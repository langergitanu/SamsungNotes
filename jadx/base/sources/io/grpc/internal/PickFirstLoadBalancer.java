package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class PickFirstLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState = ConnectivityState.IDLE;
    private final LoadBalancer.Helper helper;
    private LoadBalancer.Subchannel subchannel;

    /* JADX INFO: renamed from: io.grpc.internal.PickFirstLoadBalancer$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C121942 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ConnectivityState;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            $SwitchMap$io$grpc$ConnectivityState = iArr;
            try {
                iArr[ConnectivityState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$grpc$ConnectivityState[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PickFirstLoadBalancerConfig {

        @Nullable
        final Long randomSeed;

        @Nullable
        public final Boolean shuffleAddressList;

        public PickFirstLoadBalancerConfig(@Nullable Boolean bool) {
            this(bool, null);
        }

        public PickFirstLoadBalancerConfig(@Nullable Boolean bool, @Nullable Long l) {
            this.shuffleAddressList = bool;
            this.randomSeed = l;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Picker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.PickResult result;

        public Picker(LoadBalancer.PickResult pickResult) {
            this.result = (LoadBalancer.PickResult) Preconditions.checkNotNull(pickResult, "result");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.result;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) Picker.class).add("result", this.result).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class RequestConnectionPicker extends LoadBalancer.SubchannelPicker {
        private final AtomicBoolean connectionRequested = new AtomicBoolean(false);
        private final LoadBalancer.Subchannel subchannel;

        public RequestConnectionPicker(LoadBalancer.Subchannel subchannel) {
            this.subchannel = (LoadBalancer.Subchannel) Preconditions.checkNotNull(subchannel, "subchannel");
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            if (this.connectionRequested.compareAndSet(false, true)) {
                PickFirstLoadBalancer.this.helper.getSynchronizationContext().execute(new Runnable() { // from class: io.grpc.internal.PickFirstLoadBalancer.RequestConnectionPicker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RequestConnectionPicker.this.subchannel.requestConnection();
                    }
                });
            }
            return LoadBalancer.PickResult.withNoResult();
        }
    }

    public PickFirstLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        LoadBalancer.SubchannelPicker requestConnectionPicker;
        LoadBalancer.SubchannelPicker picker;
        ConnectivityState state = connectivityStateInfo.getState();
        if (state == ConnectivityState.SHUTDOWN) {
            return;
        }
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        if (state == connectivityState || state == ConnectivityState.IDLE) {
            this.helper.refreshNameResolution();
        }
        if (this.currentState == connectivityState) {
            if (state == ConnectivityState.CONNECTING) {
                return;
            }
            if (state == ConnectivityState.IDLE) {
                requestConnection();
                return;
            }
        }
        int i = C121942.$SwitchMap$io$grpc$ConnectivityState[state.ordinal()];
        if (i != 1) {
            if (i == 2) {
                picker = new Picker(LoadBalancer.PickResult.withNoResult());
            } else if (i == 3) {
                requestConnectionPicker = new Picker(LoadBalancer.PickResult.withSubchannel(subchannel));
            } else {
                if (i != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + state);
                }
                picker = new Picker(LoadBalancer.PickResult.withError(connectivityStateInfo.getStatus()));
            }
            updateBalancingState(state, picker);
        }
        requestConnectionPicker = new RequestConnectionPicker(subchannel);
        picker = requestConnectionPicker;
        updateBalancingState(state, picker);
    }

    private void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
        this.currentState = connectivityState;
        this.helper.updateBalancingState(connectivityState, subchannelPicker);
    }

    @Override // io.grpc.LoadBalancer
    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        PickFirstLoadBalancerConfig pickFirstLoadBalancerConfig;
        Boolean bool;
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        if (addresses.isEmpty()) {
            handleNameResolutionError(Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + resolvedAddresses.getAddresses() + ", attrs=" + resolvedAddresses.getAttributes()));
            return false;
        }
        if ((resolvedAddresses.getLoadBalancingPolicyConfig() instanceof PickFirstLoadBalancerConfig) && (bool = (pickFirstLoadBalancerConfig = (PickFirstLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig()).shuffleAddressList) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(addresses);
            Collections.shuffle(arrayList, pickFirstLoadBalancerConfig.randomSeed != null ? new Random(pickFirstLoadBalancerConfig.randomSeed.longValue()) : new Random());
            addresses = arrayList;
        }
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            subchannel.updateAddresses(addresses);
            return true;
        }
        final LoadBalancer.Subchannel subchannelCreateSubchannel = this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(addresses).build());
        subchannelCreateSubchannel.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.internal.PickFirstLoadBalancer.1
            @Override // io.grpc.LoadBalancer.SubchannelStateListener
            public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                PickFirstLoadBalancer.this.processSubchannelState(subchannelCreateSubchannel, connectivityStateInfo);
            }
        });
        this.subchannel = subchannelCreateSubchannel;
        updateBalancingState(ConnectivityState.CONNECTING, new Picker(LoadBalancer.PickResult.withSubchannel(subchannelCreateSubchannel)));
        subchannelCreateSubchannel.requestConnection();
        return true;
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            subchannel.shutdown();
            this.subchannel = null;
        }
        updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new Picker(LoadBalancer.PickResult.withError(status)));
    }

    @Override // io.grpc.LoadBalancer
    public void requestConnection() {
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            subchannel.requestConnection();
        }
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        LoadBalancer.Subchannel subchannel = this.subchannel;
        if (subchannel != null) {
            subchannel.shutdown();
        }
    }
}
