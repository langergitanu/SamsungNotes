package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.BlockingOperationException;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ImmediateEventExecutor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class DefaultChannelGroupFuture extends DefaultPromise<Void> implements ChannelGroupFuture {
    private final ChannelFutureListener childListener;
    private int failureCount;
    private final Map<Channel, ChannelFuture> futures;
    private final ChannelGroup group;
    private int successCount;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class DefaultEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private final V value;

        public DefaultEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("read-only");
        }
    }

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Collection<ChannelFuture> collection, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.childListener = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroupFuture.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                boolean z;
                boolean zIsSuccess = channelFuture.isSuccess();
                synchronized (DefaultChannelGroupFuture.this) {
                    try {
                        if (zIsSuccess) {
                            DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                        } else {
                            DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                        }
                        z = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    if (DefaultChannelGroupFuture.this.failureCount <= 0) {
                        DefaultChannelGroupFuture.this.setSuccess0();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                    for (ChannelFuture channelFuture2 : DefaultChannelGroupFuture.this.futures.values()) {
                        if (!channelFuture2.isSuccess()) {
                            arrayList.add(new DefaultEntry(channelFuture2.channel(), channelFuture2.cause()));
                        }
                    }
                    DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(arrayList));
                }
            }
        };
        this.group = (ChannelGroup) ObjectUtil.checkNotNull(channelGroup, "group");
        ObjectUtil.checkNotNull(collection, "futures");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (ChannelFuture channelFuture : collection) {
            linkedHashMap.put(channelFuture.channel(), channelFuture);
        }
        Map<Channel, ChannelFuture> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.futures = mapUnmodifiableMap;
        Iterator<ChannelFuture> it = mapUnmodifiableMap.values().iterator();
        while (it.hasNext()) {
            it.next().addListener((GenericFutureListener<? extends Future<? super Void>>) this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }

    public static /* synthetic */ int access$008(DefaultChannelGroupFuture defaultChannelGroupFuture) {
        int i = defaultChannelGroupFuture.successCount;
        defaultChannelGroupFuture.successCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$108(DefaultChannelGroupFuture defaultChannelGroupFuture) {
        int i = defaultChannelGroupFuture.failureCount;
        defaultChannelGroupFuture.failureCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFailure0(ChannelGroupException channelGroupException) {
        super.setFailure((Throwable) channelGroupException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuccess0() {
        super.setSuccess((Object) null);
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    public void checkDeadLock() {
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor != null && eventExecutorExecutor != ImmediateEventExecutor.INSTANCE && eventExecutorExecutor.inEventLoop()) {
            throw new BlockingOperationException();
        }
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public ChannelFuture find(Channel channel) {
        return this.futures.get(channel);
    }

    @Override // io.netty.channel.group.ChannelGroupFuture
    public ChannelGroup group() {
        return this.group;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    @Override // io.netty.channel.group.ChannelGroupFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isPartialFailure() {
        boolean z;
        int i = this.failureCount;
        if (i != 0) {
            z = i != this.futures.size();
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    @Override // io.netty.channel.group.ChannelGroupFuture
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isPartialSuccess() {
        boolean z;
        int i = this.successCount;
        if (i != 0) {
            z = i != this.futures.size();
        }
        return z;
    }

    @Override // io.netty.channel.group.ChannelGroupFuture, java.lang.Iterable
    public Iterator<ChannelFuture> iterator() {
        return this.futures.values().iterator();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public boolean tryFailure(Throwable th) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public ChannelGroupException cause() {
        return (ChannelGroupException) super.cause();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public DefaultChannelGroupFuture setFailure(Throwable th) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public DefaultChannelGroupFuture setSuccess(Void r12) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public boolean trySuccess(Void r12) {
        throw new IllegalStateException();
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> addListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.addListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> addListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.addListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> await() throws InterruptedException {
        super.await();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> awaitUninterruptibly() {
        super.awaitUninterruptibly();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> removeListener(GenericFutureListener<? extends Future<? super Void>> genericFutureListener) {
        super.removeListener((GenericFutureListener) genericFutureListener);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> removeListeners(GenericFutureListener<? extends Future<? super Void>>... genericFutureListenerArr) {
        super.removeListeners((GenericFutureListener[]) genericFutureListenerArr);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> sync() throws Throwable {
        super.sync();
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future
    public Future<Void> syncUninterruptibly() throws Throwable {
        super.syncUninterruptibly();
        return this;
    }

    public DefaultChannelGroupFuture(ChannelGroup channelGroup, Map<Channel, ChannelFuture> map, EventExecutor eventExecutor) {
        super(eventExecutor);
        this.childListener = new ChannelFutureListener() { // from class: io.netty.channel.group.DefaultChannelGroupFuture.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                boolean z;
                boolean zIsSuccess = channelFuture.isSuccess();
                synchronized (DefaultChannelGroupFuture.this) {
                    try {
                        if (zIsSuccess) {
                            DefaultChannelGroupFuture.access$008(DefaultChannelGroupFuture.this);
                        } else {
                            DefaultChannelGroupFuture.access$108(DefaultChannelGroupFuture.this);
                        }
                        z = DefaultChannelGroupFuture.this.successCount + DefaultChannelGroupFuture.this.failureCount == DefaultChannelGroupFuture.this.futures.size();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    if (DefaultChannelGroupFuture.this.failureCount <= 0) {
                        DefaultChannelGroupFuture.this.setSuccess0();
                        return;
                    }
                    ArrayList arrayList = new ArrayList(DefaultChannelGroupFuture.this.failureCount);
                    for (ChannelFuture channelFuture2 : DefaultChannelGroupFuture.this.futures.values()) {
                        if (!channelFuture2.isSuccess()) {
                            arrayList.add(new DefaultEntry(channelFuture2.channel(), channelFuture2.cause()));
                        }
                    }
                    DefaultChannelGroupFuture.this.setFailure0(new ChannelGroupException(arrayList));
                }
            }
        };
        this.group = channelGroup;
        Map<Channel, ChannelFuture> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        this.futures = mapUnmodifiableMap;
        Iterator<ChannelFuture> it = mapUnmodifiableMap.values().iterator();
        while (it.hasNext()) {
            it.next().addListener((GenericFutureListener<? extends Future<? super Void>>) this.childListener);
        }
        if (this.futures.isEmpty()) {
            setSuccess0();
        }
    }
}
