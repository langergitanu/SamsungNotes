package io.netty.channel;

import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.AbstractEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.OrderedEventExecutor;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADD_COMPLETE = 2;
    private static final int ADD_PENDING = 1;
    private static final int INIT = 0;
    private static final int REMOVE_COMPLETE = 3;
    private final int executionMask;
    final EventExecutor executor;
    private volatile int handlerState = 0;
    private Tasks invokeTasks;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean ordered;
    private final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private ChannelFuture succeededFuture;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractChannelHandlerContext.class);
    private static final AtomicIntegerFieldUpdater<AbstractChannelHandlerContext> HANDLER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractChannelHandlerContext.class, "handlerState");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Tasks {
        private final AbstractChannelHandlerContext next;
        private final Runnable invokeChannelReadCompleteTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.1
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelReadComplete();
            }
        };
        private final Runnable invokeReadTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.2
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeRead();
            }
        };
        private final Runnable invokeChannelWritableStateChangedTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.3
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeChannelWritabilityChanged();
            }
        };
        private final Runnable invokeFlushTask = new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.Tasks.4
            @Override // java.lang.Runnable
            public void run() {
                Tasks.this.next.invokeFlush();
            }
        };

        public Tasks(AbstractChannelHandlerContext abstractChannelHandlerContext) {
            this.next = abstractChannelHandlerContext;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WriteTask implements Runnable {
        private AbstractChannelHandlerContext ctx;
        private final ObjectPool.Handle<WriteTask> handle;
        private Object msg;
        private ChannelPromise promise;
        private int size;
        private static final ObjectPool<WriteTask> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<WriteTask>() { // from class: io.netty.channel.AbstractChannelHandlerContext.WriteTask.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.internal.ObjectPool.ObjectCreator
            public WriteTask newObject(ObjectPool.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        });
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 32);

        private void decrementPendingOutboundBytes() {
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                this.ctx.pipeline.decrementPendingOutboundBytes(this.size & Integer.MAX_VALUE);
            }
        }

        public static void init(WriteTask writeTask, AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z) {
            writeTask.ctx = abstractChannelHandlerContext;
            writeTask.msg = obj;
            writeTask.promise = channelPromise;
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT) {
                writeTask.size = abstractChannelHandlerContext.pipeline.estimatorHandle().size(obj) + WRITE_TASK_OVERHEAD;
                abstractChannelHandlerContext.pipeline.incrementPendingOutboundBytes(writeTask.size);
            } else {
                writeTask.size = 0;
            }
            if (z) {
                writeTask.size |= Integer.MIN_VALUE;
            }
        }

        public static WriteTask newInstance(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj, ChannelPromise channelPromise, boolean z) {
            WriteTask writeTask = RECYCLER.get();
            init(writeTask, abstractChannelHandlerContext, obj, channelPromise, z);
            return writeTask;
        }

        private void recycle() {
            this.ctx = null;
            this.msg = null;
            this.promise = null;
            this.handle.recycle(this);
        }

        public void cancel() {
            try {
                decrementPendingOutboundBytes();
            } finally {
                recycle();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                decrementPendingOutboundBytes();
                if (this.size >= 0) {
                    this.ctx.invokeWrite(this.msg, this.promise);
                } else {
                    this.ctx.invokeWriteAndFlush(this.msg, this.promise);
                }
                recycle();
            } catch (Throwable th) {
                recycle();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private WriteTask(ObjectPool.Handle<? extends WriteTask> handle) {
            this.handle = handle;
        }
    }

    public AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, Class<? extends ChannelHandler> cls) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.pipeline = defaultChannelPipeline;
        this.executor = eventExecutor;
        this.executionMask = ChannelHandlerMask.mask(cls);
        this.ordered = eventExecutor == null || (eventExecutor instanceof OrderedEventExecutor);
    }

    private AbstractChannelHandlerContext findContextInbound(int i) {
        EventExecutor eventExecutorExecutor = executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
        } while (skipContext(abstractChannelHandlerContext, eventExecutorExecutor, i, 510));
        return abstractChannelHandlerContext;
    }

    private AbstractChannelHandlerContext findContextOutbound(int i) {
        EventExecutor eventExecutorExecutor = executor();
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
        } while (skipContext(abstractChannelHandlerContext, eventExecutorExecutor, i, 130560));
        return abstractChannelHandlerContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeBind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        if (!invokeHandler()) {
            bind(socketAddress, channelPromise);
            return;
        }
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.bind(this, socketAddress, channelPromise);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).bind(this, socketAddress, channelPromise);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).bind(this, socketAddress, channelPromise);
            }
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeChannelActive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelActive();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelActive();
                }
            });
        }
    }

    public static void invokeChannelInactive(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelInactive();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelInactive();
                }
            });
        }
    }

    public static void invokeChannelRead(AbstractChannelHandlerContext abstractChannelHandlerContext, Object obj) {
        final Object obj2 = abstractChannelHandlerContext.pipeline.touch(ObjectUtil.checkNotNull(obj, "msg"), abstractChannelHandlerContext);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRead(obj2);
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.7
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRead(obj2);
                }
            });
        }
    }

    public static void invokeChannelReadComplete(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelReadComplete();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        eventExecutorExecutor.execute(tasks.invokeChannelReadCompleteTask);
    }

    public static void invokeChannelRegistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelRegistered();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelRegistered();
                }
            });
        }
    }

    public static void invokeChannelUnregistered(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelUnregistered();
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeChannelUnregistered();
                }
            });
        }
    }

    public static void invokeChannelWritabilityChanged(AbstractChannelHandlerContext abstractChannelHandlerContext) {
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeChannelWritabilityChanged();
            return;
        }
        Tasks tasks = abstractChannelHandlerContext.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContext);
            abstractChannelHandlerContext.invokeTasks = tasks;
        }
        eventExecutorExecutor.execute(tasks.invokeChannelWritableStateChangedTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeClose(ChannelPromise channelPromise) {
        if (!invokeHandler()) {
            close(channelPromise);
            return;
        }
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.close(this, channelPromise);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).close(this, channelPromise);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).close(this, channelPromise);
            }
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeConnect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        if (!invokeHandler()) {
            connect(socketAddress, socketAddress2, channelPromise);
            return;
        }
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.connect(this, socketAddress, socketAddress2, channelPromise);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).connect(this, socketAddress, socketAddress2, channelPromise);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).connect(this, socketAddress, socketAddress2, channelPromise);
            }
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDeregister(ChannelPromise channelPromise) {
        if (!invokeHandler()) {
            deregister(channelPromise);
            return;
        }
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.deregister(this, channelPromise);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).deregister(this, channelPromise);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).deregister(this, channelPromise);
            }
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDisconnect(ChannelPromise channelPromise) {
        if (!invokeHandler()) {
            disconnect(channelPromise);
            return;
        }
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.disconnect(this, channelPromise);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).disconnect(this, channelPromise);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).disconnect(this, channelPromise);
            }
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    public static void invokeExceptionCaught(AbstractChannelHandlerContext abstractChannelHandlerContext, final Throwable th) {
        ObjectUtil.checkNotNull(th, "cause");
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeExceptionCaught(th);
            return;
        }
        try {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.5
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeExceptionCaught(th);
                }
            });
        } catch (Throwable th2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isWarnEnabled()) {
                internalLogger.warn("Failed to submit an exceptionCaught() event.", th2);
                internalLogger.warn("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeFlush() {
        if (invokeHandler()) {
            invokeFlush0();
        } else {
            flush();
        }
    }

    private void invokeFlush0() {
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.flush(this);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).flush(this);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).flush(this);
            }
        } catch (Throwable th) {
            invokeExceptionCaught(th);
        }
    }

    private boolean invokeHandler() {
        int i = this.handlerState;
        return i == 2 || (!this.ordered && i == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeRead() {
        if (!invokeHandler()) {
            read();
            return;
        }
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.read(this);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).read(this);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).read(this);
            }
        } catch (Throwable th) {
            invokeExceptionCaught(th);
        }
    }

    public static void invokeUserEventTriggered(AbstractChannelHandlerContext abstractChannelHandlerContext, final Object obj) {
        ObjectUtil.checkNotNull(obj, "event");
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContext.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContext.invokeUserEventTriggered(obj);
        } else {
            eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.6
                @Override // java.lang.Runnable
                public void run() {
                    AbstractChannelHandlerContext.this.invokeUserEventTriggered(obj);
                }
            });
        }
    }

    private void invokeWrite0(Object obj, ChannelPromise channelPromise) {
        try {
            ChannelHandler channelHandlerHandler = handler();
            DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
            if (channelHandlerHandler == headContext) {
                headContext.write(this, obj, channelPromise);
            } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                ((ChannelDuplexHandler) channelHandlerHandler).write(this, obj, channelPromise);
            } else {
                ((ChannelOutboundHandler) channelHandlerHandler).write(this, obj, channelPromise);
            }
        } catch (Throwable th) {
            notifyOutboundHandlerException(th, channelPromise);
        }
    }

    private boolean isNotValidPromise(ChannelPromise channelPromise, boolean z) {
        ObjectUtil.checkNotNull(channelPromise, Contract.PROMISE);
        if (channelPromise.isDone()) {
            if (channelPromise.isCancelled()) {
                return true;
            }
            throw new IllegalArgumentException("promise already done: " + channelPromise);
        }
        if (channelPromise.channel() != channel()) {
            throw new IllegalArgumentException(String.format("promise.channel does not match: %s (expected: %s)", channelPromise.channel(), channel()));
        }
        if (channelPromise.getClass() == DefaultChannelPromise.class) {
            return false;
        }
        if (!z && (channelPromise instanceof VoidChannelPromise)) {
            throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) VoidChannelPromise.class) + " not allowed for this operation");
        }
        if (!(channelPromise instanceof AbstractChannel.CloseFuture)) {
            return false;
        }
        throw new IllegalArgumentException(StringUtil.simpleClassName((Class<?>) AbstractChannel.CloseFuture.class) + " not allowed in a pipeline");
    }

    private static void notifyOutboundHandlerException(Throwable th, ChannelPromise channelPromise) {
        PromiseNotificationUtil.tryFailure(channelPromise, th, channelPromise instanceof VoidChannelPromise ? null : logger);
    }

    private static boolean safeExecute(EventExecutor eventExecutor, Runnable runnable, ChannelPromise channelPromise, Object obj, boolean z) {
        if (z) {
            try {
                if (eventExecutor instanceof AbstractEventExecutor) {
                    ((AbstractEventExecutor) eventExecutor).lazyExecute(runnable);
                    return true;
                }
            } catch (Throwable th) {
                if (obj != null) {
                    try {
                        ReferenceCountUtil.release(obj);
                    } catch (Throwable th2) {
                        channelPromise.setFailure(th);
                        throw th2;
                    }
                }
                channelPromise.setFailure(th);
                return false;
            }
        }
        eventExecutor.execute(runnable);
        return true;
    }

    private static boolean skipContext(AbstractChannelHandlerContext abstractChannelHandlerContext, EventExecutor eventExecutor, int i, int i2) {
        if (((i2 | i) & abstractChannelHandlerContext.executionMask) != 0) {
            return abstractChannelHandlerContext.executor() == eventExecutor && (abstractChannelHandlerContext.executionMask & i) == 0;
        }
        return true;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        return channel().attr(attributeKey);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(SocketAddress socketAddress) {
        return bind(socketAddress, newPromise());
    }

    public final void callHandlerAdded() {
        if (setAddComplete()) {
            handler().handlerAdded(this);
        }
    }

    public final void callHandlerRemoved() {
        try {
            if (this.handlerState == 2) {
                handler().handlerRemoved(this);
            }
        } finally {
            setRemoved();
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress) {
        return connect(socketAddress, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister() {
        return deregister(newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        EventExecutor eventExecutor = this.executor;
        return eventExecutor == null ? channel().eventLoop() : eventExecutor;
    }

    @Override // io.netty.channel.ChannelHandlerContext, io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        return channel().hasAttr(attributeKey);
    }

    public void invokeWrite(Object obj, ChannelPromise channelPromise) {
        if (invokeHandler()) {
            invokeWrite0(obj, channelPromise);
        } else {
            write(obj, channelPromise);
        }
    }

    public void invokeWriteAndFlush(Object obj, ChannelPromise channelPromise) {
        if (!invokeHandler()) {
            writeAndFlush(obj, channelPromise);
        } else {
            invokeWrite0(obj, channelPromise);
            invokeFlush0();
        }
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.handlerState == 3;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public String name() {
        return this.name;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(channel(), executor(), th);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture newSucceededFuture() {
        ChannelFuture channelFuture = this.succeededFuture;
        if (channelFuture != null) {
            return channelFuture;
        }
        SucceededChannelFuture succeededChannelFuture = new SucceededChannelFuture(channel(), executor());
        this.succeededFuture = succeededChannelFuture;
        return succeededChannelFuture;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    public final boolean setAddComplete() {
        int i;
        do {
            i = this.handlerState;
            if (i == 3) {
                return false;
            }
        } while (!HANDLER_STATE_UPDATER.compareAndSet(this, i, 2));
        return true;
    }

    public final void setAddPending() {
        HANDLER_STATE_UPDATER.compareAndSet(this, 0, 1);
    }

    public final void setRemoved() {
        this.handlerState = 3;
    }

    @Override // io.netty.util.ResourceLeakHint
    public String toHintString() {
        return AbstractC0622a.m1170p(this.name, "' will handle the message from this point.", new StringBuilder("'"));
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + PropertyUtils.MAPPED_DELIM + this.name + SQLKeyword.COMMA + channel() + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj) {
        return write(obj, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        write(obj, true, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture bind(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "localAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(512);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeBind(socketAddress, channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.8
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeBind(socketAddress, channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture close(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(4096);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeClose(channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.11
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeClose(channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return connect(socketAddress, socketAddress2, newPromise());
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture deregister(final ChannelPromise channelPromise) {
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(8192);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeDeregister(channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.12
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeDeregister(channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture disconnect(final ChannelPromise channelPromise) {
        if (!channel().metadata().hasDisconnect()) {
            return close(channelPromise);
        }
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(2048);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeDisconnect(channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.10
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeDisconnect(channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelActive() {
        invokeChannelActive(findContextInbound(8));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelInactive() {
        invokeChannelInactive(findContextInbound(16));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRead(Object obj) {
        invokeChannelRead(findContextInbound(32), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelReadComplete() {
        invokeChannelReadComplete(findContextInbound(64));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelRegistered() {
        invokeChannelRegistered(findContextInbound(2));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelUnregistered() {
        invokeChannelUnregistered(findContextInbound(4));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        invokeChannelWritabilityChanged(findContextInbound(256));
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireExceptionCaught(Throwable th) {
        invokeExceptionCaught(findContextInbound(1), th);
        return this;
    }

    @Override // io.netty.channel.ChannelInboundInvoker
    public ChannelHandlerContext fireUserEventTriggered(Object obj) {
        invokeUserEventTriggered(findContextInbound(128), obj);
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(65536);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeFlush();
            return this;
        }
        Tasks tasks = abstractChannelHandlerContextFindContextOutbound.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContextFindContextOutbound);
            abstractChannelHandlerContextFindContextOutbound.invokeTasks = tasks;
        }
        safeExecute(eventExecutorExecutor, tasks.invokeFlushTask, channel().voidPromise(), null, false);
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(16384);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeRead();
            return this;
        }
        Tasks tasks = abstractChannelHandlerContextFindContextOutbound.invokeTasks;
        if (tasks == null) {
            tasks = new Tasks(abstractChannelHandlerContextFindContextOutbound);
            abstractChannelHandlerContextFindContextOutbound.invokeTasks = tasks;
        }
        eventExecutorExecutor.execute(tasks.invokeReadTask);
        return this;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        write(obj, false, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, newPromise());
    }

    private void write(Object obj, boolean z, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(obj, "msg");
        try {
            if (isNotValidPromise(channelPromise, true)) {
                ReferenceCountUtil.release(obj);
                return;
            }
            AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(z ? 98304 : 32768);
            Object obj2 = this.pipeline.touch(obj, abstractChannelHandlerContextFindContextOutbound);
            EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
            if (eventExecutorExecutor.inEventLoop()) {
                if (z) {
                    abstractChannelHandlerContextFindContextOutbound.invokeWriteAndFlush(obj2, channelPromise);
                    return;
                } else {
                    abstractChannelHandlerContextFindContextOutbound.invokeWrite(obj2, channelPromise);
                    return;
                }
            }
            WriteTask writeTaskNewInstance = WriteTask.newInstance(abstractChannelHandlerContextFindContextOutbound, obj2, channelPromise, z);
            if (safeExecute(eventExecutorExecutor, writeTaskNewInstance, channelPromise, obj2, !z)) {
                return;
            }
            writeTaskNewInstance.cancel();
        } catch (RuntimeException e) {
            ReferenceCountUtil.release(obj);
            throw e;
        }
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return connect(socketAddress, null, channelPromise);
    }

    @Override // io.netty.channel.ChannelOutboundInvoker
    public ChannelFuture connect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(socketAddress, "remoteAddress");
        if (isNotValidPromise(channelPromise, false)) {
            return channelPromise;
        }
        final AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound(1024);
        EventExecutor eventExecutorExecutor = abstractChannelHandlerContextFindContextOutbound.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            abstractChannelHandlerContextFindContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
            return channelPromise;
        }
        safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.channel.AbstractChannelHandlerContext.9
            @Override // java.lang.Runnable
            public void run() {
                abstractChannelHandlerContextFindContextOutbound.invokeConnect(socketAddress, socketAddress2, channelPromise);
            }
        }, channelPromise, null, false);
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelActive() {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelActive(this);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelActive(this);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelActive(this);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelActive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelInactive() {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelInactive(this);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelInactive(this);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelInactive(this);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelInactive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRegistered() {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelRegistered(this);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelRegistered(this);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelRegistered(this);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelRegistered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelUnregistered() {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelUnregistered(this);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelUnregistered(this);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelUnregistered(this);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelUnregistered();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelRead(Object obj) {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelRead(this, obj);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelRead(this, obj);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelRead(this, obj);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelRead(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeUserEventTriggered(Object obj) {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.userEventTriggered(this, obj);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).userEventTriggered(this, obj);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).userEventTriggered(this, obj);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireUserEventTriggered(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelReadComplete() {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelReadComplete(this);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelReadComplete(this);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelReadComplete(this);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelReadComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeChannelWritabilityChanged() {
        if (invokeHandler()) {
            try {
                ChannelHandler channelHandlerHandler = handler();
                DefaultChannelPipeline.HeadContext headContext = this.pipeline.head;
                if (channelHandlerHandler == headContext) {
                    headContext.channelWritabilityChanged(this);
                    return;
                } else if (channelHandlerHandler instanceof ChannelDuplexHandler) {
                    ((ChannelDuplexHandler) channelHandlerHandler).channelWritabilityChanged(this);
                    return;
                } else {
                    ((ChannelInboundHandler) channelHandlerHandler).channelWritabilityChanged(this);
                    return;
                }
            } catch (Throwable th) {
                invokeExceptionCaught(th);
                return;
            }
        }
        fireChannelWritabilityChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeExceptionCaught(Throwable th) {
        if (invokeHandler()) {
            try {
                handler().exceptionCaught(this, th);
                return;
            } catch (Throwable th2) {
                InternalLogger internalLogger = logger;
                if (internalLogger.isDebugEnabled()) {
                    internalLogger.debug("An exception {}was thrown by a user handler's exceptionCaught() method while handling the following exception:", ThrowableUtil.stackTraceToString(th2), th);
                    return;
                } else {
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("An exception '{}' [enable DEBUG level for full stacktrace] was thrown by a user handler's exceptionCaught() method while handling the following exception:", th2, th);
                        return;
                    }
                    return;
                }
            }
        }
        fireExceptionCaught(th);
    }
}
