package io.netty.channel.nio;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.animation.core.AnimationKt;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.SelectStrategy;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.util.IntSupplier;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long AWAKE = -1;
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final long NONE = Long.MAX_VALUE;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final AtomicLong nextWakeupNanos;
    private final SelectorProvider provider;
    private final IntSupplier selectNowSupplier;
    private final SelectStrategy selectStrategy;
    private SelectedSelectionKeySet selectedKeys;
    private Selector selector;
    private Selector unwrappedSelector;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    static {
        if (PlatformDependent.javaVersion() < 7 && SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.2
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e);
            }
        }
        int i = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        int i2 = i >= 3 ? i : 0;
        SELECTOR_AUTO_REBUILD_THRESHOLD = i2;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
            internalLogger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(i2));
        }
    }

    public NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider, SelectStrategy selectStrategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(nioEventLoopGroup, executor, false, newTaskQueue(eventLoopTaskQueueFactory), newTaskQueue(eventLoopTaskQueueFactory2), rejectedExecutionHandler);
        this.selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
            @Override // io.netty.util.IntSupplier
            public int get() {
                return NioEventLoop.this.selectNow();
            }
        };
        this.nextWakeupNanos = new AtomicLong(-1L);
        this.ioRatio = 50;
        this.provider = (SelectorProvider) ObjectUtil.checkNotNull(selectorProvider, "selectorProvider");
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(selectStrategy, "selectStrategy");
        SelectorTuple selectorTupleOpenSelector = openSelector();
        this.selector = selectorTupleOpenSelector.selector;
        this.unwrappedSelector = selectorTupleOpenSelector.unwrappedSelector;
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> setKeys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(setKeys.size());
        for (SelectionKey selectionKey : setKeys) {
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) objAttachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) objAttachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable th) {
        logger.warn("Unexpected exception in the selector loop.", th);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e);
        }
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        return eventLoopTaskQueueFactory == null ? newTaskQueue0(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS) : eventLoopTaskQueueFactory.newTaskQueue(SingleThreadEventLoop.DEFAULT_MAX_PENDING_TASKS);
    }

    private static Queue<Runnable> newTaskQueue0(int i) {
        return i == Integer.MAX_VALUE ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(i);
    }

    private SelectorTuple openSelector() {
        try {
            final AbstractSelector abstractSelectorOpenSelector = this.provider.openSelector();
            if (DISABLE_KEY_SET_OPTIMIZATION) {
                return new SelectorTuple(abstractSelectorOpenSelector);
            }
            Object objDoPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable th) {
                        return th;
                    }
                }
            });
            if (objDoPrivileged instanceof Class) {
                final Class cls = (Class) objDoPrivileged;
                if (cls.isAssignableFrom(abstractSelectorOpenSelector.getClass())) {
                    final SelectedSelectionKeySet selectedSelectionKeySet = new SelectedSelectionKeySet();
                    Object objDoPrivileged2 = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            try {
                                Field declaredField = cls.getDeclaredField("selectedKeys");
                                Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
                                if (PlatformDependent.javaVersion() >= 9 && PlatformDependent.hasUnsafe()) {
                                    long jObjectFieldOffset = PlatformDependent.objectFieldOffset(declaredField);
                                    long jObjectFieldOffset2 = PlatformDependent.objectFieldOffset(declaredField2);
                                    if (jObjectFieldOffset != -1 && jObjectFieldOffset2 != -1) {
                                        PlatformDependent.putObject(abstractSelectorOpenSelector, jObjectFieldOffset, selectedSelectionKeySet);
                                        PlatformDependent.putObject(abstractSelectorOpenSelector, jObjectFieldOffset2, selectedSelectionKeySet);
                                        return null;
                                    }
                                }
                                Throwable thTrySetAccessible = ReflectionUtil.trySetAccessible(declaredField, true);
                                if (thTrySetAccessible != null) {
                                    return thTrySetAccessible;
                                }
                                Throwable thTrySetAccessible2 = ReflectionUtil.trySetAccessible(declaredField2, true);
                                if (thTrySetAccessible2 != null) {
                                    return thTrySetAccessible2;
                                }
                                declaredField.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
                                declaredField2.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
                                return null;
                            } catch (IllegalAccessException e) {
                                e = e;
                                return e;
                            } catch (NoSuchFieldException e2) {
                                e = e2;
                                return e;
                            }
                        }
                    });
                    if (!(objDoPrivileged2 instanceof Exception)) {
                        this.selectedKeys = selectedSelectionKeySet;
                        logger.trace("instrumented a special java.util.Set into: {}", abstractSelectorOpenSelector);
                        return new SelectorTuple(abstractSelectorOpenSelector, new SelectedSelectionKeySetSelector(abstractSelectorOpenSelector, selectedSelectionKeySet));
                    }
                    this.selectedKeys = null;
                    logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelectorOpenSelector, (Exception) objDoPrivileged2);
                    return new SelectorTuple(abstractSelectorOpenSelector);
                }
            }
            if (objDoPrivileged instanceof Throwable) {
                logger.trace("failed to instrument a special java.util.Set into: {}", abstractSelectorOpenSelector, (Throwable) objDoPrivileged);
            }
            return new SelectorTuple(abstractSelectorOpenSelector);
        } catch (IOException e) {
            throw new ChannelException("failed to open a new selector", e);
        }
    }

    private void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe nioUnsafeUnsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            try {
                if (abstractNioChannel.eventLoop() == this) {
                    nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
                    return;
                }
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            int i = selectionKey.readyOps();
            if ((i & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                nioUnsafeUnsafe.finishConnect();
            }
            if ((i & 4) != 0) {
                nioUnsafeUnsafe.forceFlush();
            }
            if ((i & 17) == 0 && i != 0) {
                return;
            }
            nioUnsafeUnsafe.read();
        } catch (CancelledKeyException unused2) {
            nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    private void processSelectedKeysOptimized() {
        int i = 0;
        while (true) {
            SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
            if (i >= selectedSelectionKeySet.size) {
                return;
            }
            SelectionKey[] selectionKeyArr = selectedSelectionKeySet.keys;
            SelectionKey selectionKey = selectionKeyArr[i];
            selectionKeyArr[i] = null;
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(selectionKey, (NioTask<SelectableChannel>) objAttachment);
            }
            if (this.needsToSelectAgain) {
                this.selectedKeys.reset(i + 1);
                selectAgain();
                i = -1;
            }
            i++;
        }
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator<SelectionKey> it = set.iterator();
        while (true) {
            SelectionKey next = it.next();
            Object objAttachment = next.attachment();
            it.remove();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(next, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(next, (NioTask<SelectableChannel>) objAttachment);
            }
            if (!it.hasNext()) {
                return;
            }
            if (this.needsToSelectAgain) {
                selectAgain();
                Set<SelectionKey> setSelectedKeys = this.selector.selectedKeys();
                if (setSelectedKeys.isEmpty()) {
                    return;
                } else {
                    it = setSelectedKeys.iterator();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector selector = this.selector;
        if (selector == null) {
            return;
        }
        try {
            SelectorTuple selectorTupleOpenSelector = openSelector();
            int i = 0;
            for (SelectionKey selectionKey : selector.keys()) {
                Object objAttachment = selectionKey.attachment();
                try {
                    if (selectionKey.isValid() && selectionKey.channel().keyFor(selectorTupleOpenSelector.unwrappedSelector) == null) {
                        int iInterestOps = selectionKey.interestOps();
                        selectionKey.cancel();
                        SelectionKey selectionKeyRegister = selectionKey.channel().register(selectorTupleOpenSelector.unwrappedSelector, iInterestOps, objAttachment);
                        if (objAttachment instanceof AbstractNioChannel) {
                            ((AbstractNioChannel) objAttachment).selectionKey = selectionKeyRegister;
                        }
                        i++;
                    }
                } catch (Exception e) {
                    logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e);
                    if (objAttachment instanceof AbstractNioChannel) {
                        AbstractNioChannel abstractNioChannel = (AbstractNioChannel) objAttachment;
                        abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
                    } else {
                        invokeChannelUnregistered((NioTask) objAttachment, selectionKey, e);
                    }
                }
            }
            this.selector = selectorTupleOpenSelector.selector;
            this.unwrappedSelector = selectorTupleOpenSelector.unwrappedSelector;
            try {
                selector.close();
            } catch (Throwable th) {
                if (logger.isWarnEnabled()) {
                    logger.warn("Failed to close the old Selector.", th);
                }
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isInfoEnabled()) {
                internalLogger.info("Migrated " + i + " channel(s) to the new Selector.");
            }
        } catch (Exception e2) {
            logger.warn("Failed to create a new Selector.", (Throwable) e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register0(SelectableChannel selectableChannel, int i, NioTask<?> nioTask) {
        try {
            selectableChannel.register(this.unwrappedSelector, i, nioTask);
        } catch (Exception e) {
            throw new EventLoopException("failed to register a channel", e);
        }
    }

    private int select(long j) {
        if (j == Long.MAX_VALUE) {
            return this.selector.select();
        }
        long jDeadlineToDelayNanos = AbstractScheduledEventExecutor.deadlineToDelayNanos(j + 995000) / AnimationKt.MillisToNanos;
        return jDeadlineToDelayNanos <= 0 ? this.selector.selectNow() : this.selector.select(jDeadlineToDelayNanos);
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }

    private boolean unexpectedSelectorWakeup(int i) {
        if (Thread.interrupted()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
            }
            return true;
        }
        int i2 = SELECTOR_AUTO_REBUILD_THRESHOLD;
        if (i2 <= 0 || i < i2) {
            return false;
        }
        logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(i), this.selector);
        rebuildSelector();
        return true;
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public boolean afterScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public boolean beforeScheduledTaskSubmitted(long j) {
        return j < this.nextWakeupNanos.get();
    }

    public void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        int i = this.cancelledKeys + 1;
        this.cancelledKeys = i;
        if (i >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void rebuildSelector() {
        if (inEventLoop()) {
            rebuildSelector0();
        } else {
            execute(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.6
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        }
    }

    public void register(final SelectableChannel selectableChannel, final int i, final NioTask<?> nioTask) {
        ObjectUtil.checkNotNull(selectableChannel, "ch");
        if (i == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        }
        if (((~selectableChannel.validOps()) & i) != 0) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "invalid interestOps: ", "(validOps: ");
            sbM778t.append(selectableChannel.validOps());
            sbM778t.append(PropertyUtils.MAPPED_DELIM2);
            throw new IllegalArgumentException(sbM778t.toString());
        }
        ObjectUtil.checkNotNull(nioTask, "task");
        if (isShutdown()) {
            throw new IllegalStateException("event loop shut down");
        }
        if (inEventLoop()) {
            register0(selectableChannel, i, nioTask);
            return;
        }
        try {
            submit(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.5
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.register0(selectableChannel, i, nioTask);
                }
            }).sync();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.selector.keys().size() - this.cancelledKeys;
    }

    @Override // io.netty.channel.SingleThreadEventLoop
    public Iterator<Channel> registeredChannelsIterator() {
        Set<SelectionKey> setKeys = this.selector.keys();
        return setKeys.isEmpty() ? SingleThreadEventLoop.ChannelsReadOnlyIterator.empty() : new Iterator<Channel>(setKeys) { // from class: io.netty.channel.nio.NioEventLoop.7
            boolean isDone;
            Channel next;
            final Iterator<SelectionKey> selectionKeyIterator;
            final /* synthetic */ Set val$keys;

            {
                this.val$keys = setKeys;
                this.selectionKeyIterator = ((Set) ObjectUtil.checkNotNull(setKeys, "selectionKeys")).iterator();
            }

            private Channel nextOrDone() {
                Iterator<SelectionKey> it = this.selectionKeyIterator;
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    if (next.isValid()) {
                        Object objAttachment = next.attachment();
                        if (objAttachment instanceof AbstractNioChannel) {
                            return (AbstractNioChannel) objAttachment;
                        }
                    }
                }
                this.isDone = true;
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.isDone) {
                    return false;
                }
                if (this.next != null) {
                    return true;
                }
                Channel channelNextOrDone = nextOrDone();
                this.next = channelNextOrDone;
                return channelNextOrDone != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Channel next() {
                if (this.isDone) {
                    throw new NoSuchElementException();
                }
                Channel channelNextOrDone = this.next;
                if (channelNextOrDone == null && (channelNextOrDone = nextOrDone()) == null) {
                    throw new NoSuchElementException();
                }
                this.next = nextOrDone();
                return channelNextOrDone;
            }
        };
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:183|9|(0)|34|163|35|36|(2:(2:147|39)|50)(1:(4:52|151|53|54)(1:58))|(2:65|(2:67|(1:69)))(8:62|(0)|156|71|(2:73|(2:171|192))|81|190|186)|64|156|71|(0)|81|190|186) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:145|4|5|(1:182)(2:7|(16:183|9|(0)|34|163|35|36|(2:(2:147|39)|50)(1:(4:52|151|53|54)(1:58))|(2:65|(2:67|(1:69)))(8:62|(0)|156|71|(2:73|(2:171|192))|81|190|186)|64|156|71|(0)|81|190|186)(5:160|12|185|(3:184|14|(2:170|191)(1:188))(1:187)|186))|23|(1:25)|26|149|27|(1:29)|33|34|163|35|36|(0)(0)|(9:61|65|(0)|64|156|71|(0)|81|190)(0)|186) */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x012d, code lost:
    
        closeAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0134, code lost:
    
        if (confirmShutdown() != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0146, code lost:
    
        r2.debug("CancelledKeyException raised by a Selector {} - JDK bug?", r9.selector, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0164, code lost:
    
        closeAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x016b, code lost:
    
        if (confirmShutdown() != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0070, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0076, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e2, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00ec, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012d A[Catch: all -> 0x0137, Error -> 0x0139, TRY_LEAVE, TryCatch #17 {Error -> 0x0139, all -> 0x0137, blocks: (B:109:0x0127, B:111:0x012d), top: B:166:0x0127 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0146 A[Catch: all -> 0x013b, TRY_LEAVE, TryCatch #21 {all -> 0x013b, blocks: (B:108:0x0124, B:121:0x013e, B:123:0x0146, B:120:0x013d, B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b2, B:67:0x00bd, B:69:0x00c5, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0098, B:57:0x00a6, B:58:0x00a7, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f7, B:90:0x00fc, B:91:0x00fd, B:92:0x0100), top: B:153:0x0124, inners: #23 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0164 A[Catch: all -> 0x016e, Error -> 0x0171, TRY_LEAVE, TryCatch #24 {Error -> 0x0171, all -> 0x016e, blocks: (B:124:0x015e, B:126:0x0164), top: B:154:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd A[Catch: all -> 0x0070, Error -> 0x0073, CancelledKeyException -> 0x0076, TryCatch #23 {Error -> 0x0073, blocks: (B:4:0x0002, B:35:0x005b, B:50:0x0079, B:62:0x00b2, B:67:0x00bd, B:69:0x00c5, B:42:0x006c, B:43:0x006f, B:52:0x0080, B:54:0x0087, B:56:0x0098, B:57:0x00a6, B:58:0x00a7, B:23:0x0032, B:26:0x0041, B:33:0x0054, B:89:0x00f7, B:90:0x00fc, B:91:0x00fd, B:92:0x0100), top: B:145:0x0002, outer: #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d7 A[Catch: all -> 0x00e2, Error -> 0x00e4, TRY_LEAVE, TryCatch #23 {Error -> 0x00e4, all -> 0x00e2, blocks: (B:71:0x00d1, B:73:0x00d7), top: B:156:0x00d1 }] */
    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        Throwable th;
        CancelledKeyException e;
        int iCalculateStrategy;
        int i2;
        boolean zRunAllTasks;
        long jNextScheduledTaskDeadlineNanos;
        while (true) {
            int i4 = 0;
            while (true) {
                try {
                    try {
                        try {
                            iCalculateStrategy = this.selectStrategy.calculateStrategy(this.selectNowSupplier, hasTasks());
                        } catch (IOException e2) {
                            rebuildSelector0();
                            try {
                                handleLoopException(e2);
                                try {
                                    if (isShuttingDown()) {
                                        closeAll();
                                        if (confirmShutdown()) {
                                            return;
                                        }
                                    } else {
                                        continue;
                                    }
                                } catch (Error e3) {
                                    throw e3;
                                } catch (Throwable th2) {
                                    handleLoopException(th2);
                                }
                            } catch (CancelledKeyException e5) {
                                e = e5;
                                i = 0;
                                InternalLogger internalLogger = logger;
                                if (internalLogger.isDebugEnabled()) {
                                }
                                try {
                                    if (isShuttingDown()) {
                                    }
                                } catch (Error e6) {
                                    throw e6;
                                } catch (Throwable th3) {
                                    th = th3;
                                    handleLoopException(th);
                                }
                                i4 = i;
                            } catch (Throwable th4) {
                                th = th4;
                                i = 0;
                                try {
                                    handleLoopException(th);
                                    try {
                                        if (isShuttingDown()) {
                                        }
                                    } catch (Error e7) {
                                        throw e7;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        handleLoopException(th);
                                    }
                                    i4 = i;
                                } catch (Throwable th6) {
                                    try {
                                        if (isShuttingDown()) {
                                            closeAll();
                                            if (confirmShutdown()) {
                                                return;
                                            }
                                        }
                                    } catch (Error e8) {
                                        throw e8;
                                    } catch (Throwable th7) {
                                        handleLoopException(th7);
                                    }
                                    throw th6;
                                }
                            }
                        }
                    } catch (Error e9) {
                        throw e9;
                    }
                } catch (CancelledKeyException e10) {
                    i = i4;
                    e = e10;
                } catch (Throwable th8) {
                    i = i4;
                    th = th8;
                }
                try {
                    if (iCalculateStrategy != -3) {
                        if (iCalculateStrategy != -2) {
                            if (iCalculateStrategy == -1) {
                            }
                            i = i4 + 1;
                            this.cancelledKeys = 0;
                            this.needsToSelectAgain = false;
                            i2 = this.ioRatio;
                            if (i2 != 100) {
                                if (iCalculateStrategy > 0) {
                                    try {
                                        processSelectedKeys();
                                    } catch (Throwable th9) {
                                        runAllTasks();
                                        throw th9;
                                    }
                                }
                                zRunAllTasks = runAllTasks();
                            } else if (iCalculateStrategy > 0) {
                                long jNanoTime = System.nanoTime();
                                try {
                                    processSelectedKeys();
                                    zRunAllTasks = runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i2))) / ((long) i2));
                                } catch (Throwable th10) {
                                    runAllTasks(((System.nanoTime() - jNanoTime) * ((long) (100 - i2))) / ((long) i2));
                                    throw th10;
                                }
                            } else {
                                zRunAllTasks = runAllTasks(0L);
                            }
                            if (zRunAllTasks && iCalculateStrategy <= 0) {
                                if (unexpectedSelectorWakeup(i)) {
                                }
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                }
                                i4 = i;
                            } else if (i > 3) {
                                InternalLogger internalLogger2 = logger;
                                if (internalLogger2.isDebugEnabled()) {
                                    internalLogger2.debug("Selector.select() returned prematurely {} times in a row for Selector {}.", Integer.valueOf(i4), this.selector);
                                }
                            }
                            i = 0;
                            if (isShuttingDown()) {
                            }
                            i4 = i;
                        } else {
                            try {
                                if (isShuttingDown()) {
                                    closeAll();
                                    if (confirmShutdown()) {
                                        return;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Error e11) {
                                throw e11;
                            } catch (Throwable th11) {
                                handleLoopException(th11);
                            }
                        }
                    }
                    if (!hasTasks()) {
                        iCalculateStrategy = select(jNextScheduledTaskDeadlineNanos);
                    }
                    this.nextWakeupNanos.lazySet(-1L);
                    i = i4 + 1;
                    this.cancelledKeys = 0;
                    this.needsToSelectAgain = false;
                    i2 = this.ioRatio;
                    if (i2 != 100) {
                    }
                    if (zRunAllTasks) {
                        if (i > 3) {
                        }
                        i = 0;
                        if (isShuttingDown()) {
                        }
                        i4 = i;
                    }
                } catch (Throwable th12) {
                    this.nextWakeupNanos.lazySet(-1L);
                    throw th12;
                }
                jNextScheduledTaskDeadlineNanos = nextScheduledTaskDeadlineNanos();
                if (jNextScheduledTaskDeadlineNanos == -1) {
                    jNextScheduledTaskDeadlineNanos = Long.MAX_VALUE;
                }
                this.nextWakeupNanos.set(jNextScheduledTaskDeadlineNanos);
            }
        }
    }

    public int selectNow() {
        return this.selector.selectNow();
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    public void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "ioRatio: ", " (expected: 0 < ioRatio <= 100)"));
        }
        this.ioRatio = i;
    }

    public Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean z) {
        if (z || this.nextWakeupNanos.getAndSet(-1L) == -1) {
            return;
        }
        this.selector.wakeup();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SelectorTuple {
        final Selector selector;
        final Selector unwrappedSelector;

        public SelectorTuple(Selector selector) {
            this.unwrappedSelector = selector;
            this.selector = selector;
        }

        public SelectorTuple(Selector selector, Selector selector2) {
            this.unwrappedSelector = selector;
            this.selector = selector2;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public Queue<Runnable> newTaskQueue(int i) {
        return newTaskQueue0(i);
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (selectionKey.isValid()) {
                    return;
                }
                invokeChannelUnregistered(nioTask, selectionKey, null);
            } catch (Exception e) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e);
            }
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th;
        }
    }
}
