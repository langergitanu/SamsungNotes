package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.Context;
import io.grpc.EquivalentAddressGroup;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientCallImpl;
import io.grpc.internal.ManagedClientTransport;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
final class OobChannel extends ManagedChannel implements InternalInstrumented<InternalChannelz.ChannelStats> {
    private static final Logger log = Logger.getLogger(OobChannel.class.getName());
    private final String authority;
    private final CallTracer channelCallsTracer;
    private final ChannelTracer channelTracer;
    private final InternalChannelz channelz;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final DelayedClientTransport delayedTransport;
    private final Executor executor;
    private final ObjectPool<? extends Executor> executorPool;
    private final InternalLogId logId;
    private volatile boolean shutdown;
    private InternalSubchannel subchannel;
    private AbstractSubchannel subchannelImpl;
    private LoadBalancer.SubchannelPicker subchannelPicker;
    private final TimeProvider timeProvider;
    private final CountDownLatch terminatedLatch = new CountDownLatch(1);
    private final ClientCallImpl.ClientStreamProvider transportProvider = new ClientCallImpl.ClientStreamProvider() { // from class: io.grpc.internal.OobChannel.1
        @Override // io.grpc.internal.ClientCallImpl.ClientStreamProvider
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context) {
            ClientStreamTracer[] clientStreamTracers = GrpcUtil.getClientStreamTracers(callOptions, metadata, 0, false);
            Context contextAttach = context.attach();
            try {
                return OobChannel.this.delayedTransport.newStream(methodDescriptor, metadata, callOptions, clientStreamTracers);
            } finally {
                context.detach(contextAttach);
            }
        }
    };

    /* JADX INFO: renamed from: io.grpc.internal.OobChannel$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C121924 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ConnectivityState;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            $SwitchMap$io$grpc$ConnectivityState = iArr;
            try {
                iArr[ConnectivityState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public OobChannel(String str, ObjectPool<? extends Executor> objectPool, ScheduledExecutorService scheduledExecutorService, SynchronizationContext synchronizationContext, CallTracer callTracer, ChannelTracer channelTracer, InternalChannelz internalChannelz, TimeProvider timeProvider) {
        this.authority = (String) Preconditions.checkNotNull(str, "authority");
        this.logId = InternalLogId.allocate((Class<?>) OobChannel.class, str);
        this.executorPool = (ObjectPool) Preconditions.checkNotNull(objectPool, "executorPool");
        Executor executor = (Executor) Preconditions.checkNotNull(objectPool.getObject(), "executor");
        this.executor = executor;
        this.deadlineCancellationExecutor = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "deadlineCancellationExecutor");
        DelayedClientTransport delayedClientTransport = new DelayedClientTransport(executor, synchronizationContext);
        this.delayedTransport = delayedClientTransport;
        this.channelz = (InternalChannelz) Preconditions.checkNotNull(internalChannelz);
        delayedClientTransport.start(new ManagedClientTransport.Listener() { // from class: io.grpc.internal.OobChannel.2
            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportInUse(boolean z) {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportReady() {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportShutdown(Status status) {
            }

            @Override // io.grpc.internal.ManagedClientTransport.Listener
            public void transportTerminated() {
                OobChannel.this.subchannelImpl.shutdown();
            }
        });
        this.channelCallsTracer = callTracer;
        this.channelTracer = (ChannelTracer) Preconditions.checkNotNull(channelTracer, "channelTracer");
        this.timeProvider = (TimeProvider) Preconditions.checkNotNull(timeProvider, "timeProvider");
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.authority;
    }

    @Override // io.grpc.ManagedChannel
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.terminatedLatch.await(j, timeUnit);
    }

    public InternalSubchannel getInternalSubchannel() {
        return this.subchannel;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    @Override // io.grpc.ManagedChannel
    public ConnectivityState getState(boolean z) {
        InternalSubchannel internalSubchannel = this.subchannel;
        return internalSubchannel == null ? ConnectivityState.IDLE : internalSubchannel.getState();
    }

    @Override // io.grpc.InternalInstrumented
    public ListenableFuture<InternalChannelz.ChannelStats> getStats() {
        SettableFuture settableFutureCreate = SettableFuture.create();
        InternalChannelz.ChannelStats.Builder builder = new InternalChannelz.ChannelStats.Builder();
        this.channelCallsTracer.updateBuilder(builder);
        this.channelTracer.updateBuilder(builder);
        builder.setTarget(this.authority).setState(this.subchannel.getState()).setSubchannels(Collections.singletonList(this.subchannel));
        settableFutureCreate.set(builder.build());
        return settableFutureCreate;
    }

    @VisibleForTesting
    public LoadBalancer.Subchannel getSubchannel() {
        return this.subchannelImpl;
    }

    public void handleSubchannelStateChange(ConnectivityStateInfo connectivityStateInfo) {
        this.channelTracer.reportEvent(new InternalChannelz.ChannelTrace.Event.Builder().setDescription("Entering " + connectivityStateInfo.getState() + " state").setSeverity(InternalChannelz.ChannelTrace.Event.Severity.CT_INFO).setTimestampNanos(this.timeProvider.currentTimeNanos()).build());
        int i = C121924.$SwitchMap$io$grpc$ConnectivityState[connectivityStateInfo.getState().ordinal()];
        if (i == 1 || i == 2) {
            this.delayedTransport.reprocess(this.subchannelPicker);
        } else {
            if (i != 3) {
                return;
            }
            this.delayedTransport.reprocess(new LoadBalancer.SubchannelPicker(connectivityStateInfo) { // from class: io.grpc.internal.OobChannel.1OobErrorPicker
                final LoadBalancer.PickResult errorResult;
                final /* synthetic */ ConnectivityStateInfo val$newState;

                {
                    this.val$newState = connectivityStateInfo;
                    this.errorResult = LoadBalancer.PickResult.withError(connectivityStateInfo.getStatus());
                }

                @Override // io.grpc.LoadBalancer.SubchannelPicker
                public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                    return this.errorResult;
                }

                public String toString() {
                    return MoreObjects.toStringHelper((Class<?>) C1OobErrorPicker.class).add("errorResult", this.errorResult).toString();
                }
            });
        }
    }

    public void handleSubchannelTerminated() {
        this.channelz.removeSubchannel(this);
        this.executorPool.returnObject(this.executor);
        this.terminatedLatch.countDown();
    }

    @Override // io.grpc.ManagedChannel
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override // io.grpc.ManagedChannel
    public boolean isTerminated() {
        return this.terminatedLatch.getCount() == 0;
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return new ClientCallImpl(methodDescriptor, callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor(), callOptions, this.transportProvider, this.deadlineCancellationExecutor, this.channelCallsTracer, null);
    }

    @Override // io.grpc.ManagedChannel
    public void resetConnectBackoff() {
        this.subchannel.resetConnectBackoff();
    }

    public void setSubchannel(final InternalSubchannel internalSubchannel) {
        log.log(Level.FINE, "[{0}] Created with [{1}]", new Object[]{this, internalSubchannel});
        this.subchannel = internalSubchannel;
        this.subchannelImpl = new AbstractSubchannel() { // from class: io.grpc.internal.OobChannel.3
            @Override // io.grpc.LoadBalancer.Subchannel
            public List<EquivalentAddressGroup> getAllAddresses() {
                return internalSubchannel.getAddressGroups();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public Attributes getAttributes() {
                return Attributes.EMPTY;
            }

            @Override // io.grpc.internal.AbstractSubchannel
            public InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel() {
                return internalSubchannel;
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public Object getInternalSubchannel() {
                return internalSubchannel;
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public void requestConnection() {
                internalSubchannel.obtainActiveTransport();
            }

            @Override // io.grpc.LoadBalancer.Subchannel
            public void shutdown() {
                internalSubchannel.shutdown(Status.UNAVAILABLE.withDescription("OobChannel is shutdown"));
            }
        };
        LoadBalancer.SubchannelPicker subchannelPicker = new LoadBalancer.SubchannelPicker() { // from class: io.grpc.internal.OobChannel.1OobSubchannelPicker
            final LoadBalancer.PickResult result;

            {
                this.result = LoadBalancer.PickResult.withSubchannel(OobChannel.this.subchannelImpl);
            }

            @Override // io.grpc.LoadBalancer.SubchannelPicker
            public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
                return this.result;
            }

            public String toString() {
                return MoreObjects.toStringHelper((Class<?>) C1OobSubchannelPicker.class).add("result", this.result).toString();
            }
        };
        this.subchannelPicker = subchannelPicker;
        this.delayedTransport.reprocess(subchannelPicker);
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdown() {
        this.shutdown = true;
        this.delayedTransport.shutdown(Status.UNAVAILABLE.withDescription("OobChannel.shutdown() called"));
        return this;
    }

    @Override // io.grpc.ManagedChannel
    public ManagedChannel shutdownNow() {
        this.shutdown = true;
        this.delayedTransport.shutdownNow(Status.UNAVAILABLE.withDescription("OobChannel.shutdownNow() called"));
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("authority", this.authority).toString();
    }

    public void updateAddresses(List<EquivalentAddressGroup> list) {
        this.subchannel.updateAddresses(list);
    }
}
