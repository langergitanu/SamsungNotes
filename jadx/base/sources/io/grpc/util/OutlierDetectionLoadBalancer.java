package io.grpc.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.grpc.Attributes;
import io.grpc.ChannelLogger;
import io.grpc.ClientStreamTracer;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Internal;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.TimeProvider;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Internal
public final class OutlierDetectionLoadBalancer extends LoadBalancer {
    private static final Attributes.Key<AddressTracker> ADDRESS_TRACKER_ATTR_KEY = Attributes.Key.create("addressTrackerKey");
    private final LoadBalancer.Helper childHelper;
    private SynchronizationContext.ScheduledHandle detectionTimerHandle;
    private Long detectionTimerStartNanos;
    private final ChannelLogger logger;
    private final GracefulSwitchLoadBalancer switchLb;
    private final SynchronizationContext syncContext;
    private TimeProvider timeProvider;
    private final ScheduledExecutorService timeService;

    @VisibleForTesting
    final AddressTrackerMap trackerMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AddressTracker {
        private volatile CallCounter activeCallCounter;
        private OutlierDetectionLoadBalancerConfig config;
        private int ejectionTimeMultiplier;
        private Long ejectionTimeNanos;
        private CallCounter inactiveCallCounter;
        private final Set<OutlierDetectionSubchannel> subchannels = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class CallCounter {
            AtomicLong failureCount;
            AtomicLong successCount;

            private CallCounter() {
                this.successCount = new AtomicLong();
                this.failureCount = new AtomicLong();
            }

            public void reset() {
                this.successCount.set(0L);
                this.failureCount.set(0L);
            }
        }

        public AddressTracker(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            this.activeCallCounter = new CallCounter();
            this.inactiveCallCounter = new CallCounter();
            this.config = outlierDetectionLoadBalancerConfig;
        }

        @VisibleForTesting
        public long activeVolume() {
            return this.activeCallCounter.failureCount.get() + this.activeCallCounter.successCount.get();
        }

        public boolean addSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            if (subchannelsEjected() && !outlierDetectionSubchannel.isEjected()) {
                outlierDetectionSubchannel.eject();
            } else if (!subchannelsEjected() && outlierDetectionSubchannel.isEjected()) {
                outlierDetectionSubchannel.uneject();
            }
            outlierDetectionSubchannel.setAddressTracker(this);
            return this.subchannels.add(outlierDetectionSubchannel);
        }

        public boolean containsSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            return this.subchannels.contains(outlierDetectionSubchannel);
        }

        public void decrementEjectionTimeMultiplier() {
            int i = this.ejectionTimeMultiplier;
            this.ejectionTimeMultiplier = i == 0 ? 0 : i - 1;
        }

        public void ejectSubchannels(long j) {
            this.ejectionTimeNanos = Long.valueOf(j);
            this.ejectionTimeMultiplier++;
            Iterator<OutlierDetectionSubchannel> it = this.subchannels.iterator();
            while (it.hasNext()) {
                it.next().eject();
            }
        }

        public double failureRate() {
            return this.inactiveCallCounter.failureCount.get() / inactiveVolume();
        }

        @VisibleForTesting
        public Set<OutlierDetectionSubchannel> getSubchannels() {
            return ImmutableSet.copyOf((Collection) this.subchannels);
        }

        public long inactiveVolume() {
            return this.inactiveCallCounter.failureCount.get() + this.inactiveCallCounter.successCount.get();
        }

        public void incrementCallCount(boolean z) {
            OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig = this.config;
            if (outlierDetectionLoadBalancerConfig.successRateEjection == null && outlierDetectionLoadBalancerConfig.failurePercentageEjection == null) {
                return;
            }
            if (z) {
                this.activeCallCounter.successCount.getAndIncrement();
            } else {
                this.activeCallCounter.failureCount.getAndIncrement();
            }
        }

        public boolean maxEjectionTimeElapsed(long j) {
            return j > Math.min(this.config.baseEjectionTimeNanos.longValue() * ((long) this.ejectionTimeMultiplier), Math.max(this.config.baseEjectionTimeNanos.longValue(), this.config.maxEjectionTimeNanos.longValue())) + this.ejectionTimeNanos.longValue();
        }

        public boolean removeSubchannel(OutlierDetectionSubchannel outlierDetectionSubchannel) {
            outlierDetectionSubchannel.clearAddressTracker();
            return this.subchannels.remove(outlierDetectionSubchannel);
        }

        public void resetCallCounters() {
            this.activeCallCounter.reset();
            this.inactiveCallCounter.reset();
        }

        public void resetEjectionTimeMultiplier() {
            this.ejectionTimeMultiplier = 0;
        }

        public void setConfig(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            this.config = outlierDetectionLoadBalancerConfig;
        }

        public boolean subchannelsEjected() {
            return this.ejectionTimeNanos != null;
        }

        public double successRate() {
            return this.inactiveCallCounter.successCount.get() / inactiveVolume();
        }

        public void swapCounters() {
            this.inactiveCallCounter.reset();
            CallCounter callCounter = this.activeCallCounter;
            this.activeCallCounter = this.inactiveCallCounter;
            this.inactiveCallCounter = callCounter;
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.subchannels + '}';
        }

        public void unejectSubchannels() {
            Preconditions.checkState(this.ejectionTimeNanos != null, "not currently ejected");
            this.ejectionTimeNanos = null;
            Iterator<OutlierDetectionSubchannel> it = this.subchannels.iterator();
            while (it.hasNext()) {
                it.next().uneject();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AddressTrackerMap extends ForwardingMap<SocketAddress, AddressTracker> {
        private final Map<SocketAddress, AddressTracker> trackerMap = new HashMap();

        public void cancelTracking() {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                if (addressTracker.subchannelsEjected()) {
                    addressTracker.unejectSubchannels();
                }
                addressTracker.resetEjectionTimeMultiplier();
            }
        }

        public double ejectionPercentage() {
            if (this.trackerMap.isEmpty()) {
                return 0.0d;
            }
            Iterator<AddressTracker> it = this.trackerMap.values().iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                i2++;
                if (it.next().subchannelsEjected()) {
                    i++;
                }
            }
            return (((double) i) / ((double) i2)) * 100.0d;
        }

        public void maybeUnejectOutliers(Long l) {
            for (AddressTracker addressTracker : this.trackerMap.values()) {
                if (!addressTracker.subchannelsEjected()) {
                    addressTracker.decrementEjectionTimeMultiplier();
                }
                if (addressTracker.subchannelsEjected() && addressTracker.maxEjectionTimeElapsed(l.longValue())) {
                    addressTracker.unejectSubchannels();
                }
            }
        }

        public void putNewTrackers(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, Collection<SocketAddress> collection) {
            for (SocketAddress socketAddress : collection) {
                if (!this.trackerMap.containsKey(socketAddress)) {
                    this.trackerMap.put(socketAddress, new AddressTracker(outlierDetectionLoadBalancerConfig));
                }
            }
        }

        public void resetCallCounters() {
            Iterator<AddressTracker> it = this.trackerMap.values().iterator();
            while (it.hasNext()) {
                it.next().resetCallCounters();
            }
        }

        public void swapCounters() {
            Iterator<AddressTracker> it = this.trackerMap.values().iterator();
            while (it.hasNext()) {
                it.next().swapCounters();
            }
        }

        public void updateTrackerConfigs(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig) {
            Iterator<AddressTracker> it = this.trackerMap.values().iterator();
            while (it.hasNext()) {
                it.next().setConfig(outlierDetectionLoadBalancerConfig);
            }
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<SocketAddress, AddressTracker> delegate() {
            return this.trackerMap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ChildHelper extends ForwardingLoadBalancerHelper {
        private LoadBalancer.Helper delegate;

        public ChildHelper(LoadBalancer.Helper helper) {
            this.delegate = helper;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper, io.grpc.LoadBalancer.Helper
        public LoadBalancer.Subchannel createSubchannel(LoadBalancer.CreateSubchannelArgs createSubchannelArgs) {
            OutlierDetectionSubchannel outlierDetectionSubchannel = OutlierDetectionLoadBalancer.this.new OutlierDetectionSubchannel(this.delegate.createSubchannel(createSubchannelArgs));
            List<EquivalentAddressGroup> addresses = createSubchannelArgs.getAddresses();
            if (OutlierDetectionLoadBalancer.hasSingleAddress(addresses) && OutlierDetectionLoadBalancer.this.trackerMap.containsKey(addresses.get(0).getAddresses().get(0))) {
                AddressTracker addressTracker = OutlierDetectionLoadBalancer.this.trackerMap.get(addresses.get(0).getAddresses().get(0));
                addressTracker.addSubchannel(outlierDetectionSubchannel);
                if (addressTracker.ejectionTimeNanos != null) {
                    outlierDetectionSubchannel.eject();
                }
            }
            return outlierDetectionSubchannel;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper
        public LoadBalancer.Helper delegate() {
            return this.delegate;
        }

        @Override // io.grpc.util.ForwardingLoadBalancerHelper, io.grpc.LoadBalancer.Helper
        public void updateBalancingState(ConnectivityState connectivityState, LoadBalancer.SubchannelPicker subchannelPicker) {
            this.delegate.updateBalancingState(connectivityState, OutlierDetectionLoadBalancer.this.new OutlierDetectionPicker(subchannelPicker));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DetectionTimer implements Runnable {
        OutlierDetectionLoadBalancerConfig config;
        ChannelLogger logger;

        public DetectionTimer(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            OutlierDetectionLoadBalancer outlierDetectionLoadBalancer = OutlierDetectionLoadBalancer.this;
            outlierDetectionLoadBalancer.detectionTimerStartNanos = Long.valueOf(outlierDetectionLoadBalancer.timeProvider.currentTimeNanos());
            OutlierDetectionLoadBalancer.this.trackerMap.swapCounters();
            for (OutlierEjectionAlgorithm outlierEjectionAlgorithm : OutlierEjectionAlgorithm.forConfig(this.config, this.logger)) {
                OutlierDetectionLoadBalancer outlierDetectionLoadBalancer2 = OutlierDetectionLoadBalancer.this;
                outlierEjectionAlgorithm.ejectOutliers(outlierDetectionLoadBalancer2.trackerMap, outlierDetectionLoadBalancer2.detectionTimerStartNanos.longValue());
            }
            OutlierDetectionLoadBalancer outlierDetectionLoadBalancer3 = OutlierDetectionLoadBalancer.this;
            outlierDetectionLoadBalancer3.trackerMap.maybeUnejectOutliers(outlierDetectionLoadBalancer3.detectionTimerStartNanos);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FailurePercentageOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        public FailurePercentageOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @Override // io.grpc.util.OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm
        public void ejectOutliers(AddressTrackerMap addressTrackerMap, long j) {
            List<AddressTracker> listTrackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(addressTrackerMap, this.config.failurePercentageEjection.requestVolume.intValue());
            if (listTrackersWithVolume.size() < this.config.failurePercentageEjection.minimumHosts.intValue() || listTrackersWithVolume.size() == 0) {
                return;
            }
            for (AddressTracker addressTracker : listTrackersWithVolume) {
                if (addressTrackerMap.ejectionPercentage() >= this.config.maxEjectionPercent.intValue()) {
                    return;
                }
                if (addressTracker.inactiveVolume() >= this.config.failurePercentageEjection.requestVolume.intValue()) {
                    if (addressTracker.failureRate() > ((double) this.config.failurePercentageEjection.threshold.intValue()) / 100.0d) {
                        this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", addressTracker, Double.valueOf(addressTracker.failureRate()));
                        if (new Random().nextInt(100) < this.config.failurePercentageEjection.enforcementPercentage.intValue()) {
                            addressTracker.ejectSubchannels(j);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class OutlierDetectionLoadBalancerConfig {
        public final Long baseEjectionTimeNanos;
        public final ServiceConfigUtil.PolicySelection childPolicy;
        public final FailurePercentageEjection failurePercentageEjection;
        public final Long intervalNanos;
        public final Integer maxEjectionPercent;
        public final Long maxEjectionTimeNanos;
        public final SuccessRateEjection successRateEjection;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Builder {
            ServiceConfigUtil.PolicySelection childPolicy;
            FailurePercentageEjection failurePercentageEjection;
            SuccessRateEjection successRateEjection;
            Long intervalNanos = 10000000000L;
            Long baseEjectionTimeNanos = 30000000000L;
            Long maxEjectionTimeNanos = 300000000000L;
            Integer maxEjectionPercent = 10;

            public OutlierDetectionLoadBalancerConfig build() {
                Preconditions.checkState(this.childPolicy != null);
                return new OutlierDetectionLoadBalancerConfig(this.intervalNanos, this.baseEjectionTimeNanos, this.maxEjectionTimeNanos, this.maxEjectionPercent, this.successRateEjection, this.failurePercentageEjection, this.childPolicy);
            }

            public Builder setBaseEjectionTimeNanos(Long l) {
                Preconditions.checkArgument(l != null);
                this.baseEjectionTimeNanos = l;
                return this;
            }

            public Builder setChildPolicy(ServiceConfigUtil.PolicySelection policySelection) {
                Preconditions.checkState(policySelection != null);
                this.childPolicy = policySelection;
                return this;
            }

            public Builder setFailurePercentageEjection(FailurePercentageEjection failurePercentageEjection) {
                this.failurePercentageEjection = failurePercentageEjection;
                return this;
            }

            public Builder setIntervalNanos(Long l) {
                Preconditions.checkArgument(l != null);
                this.intervalNanos = l;
                return this;
            }

            public Builder setMaxEjectionPercent(Integer num) {
                Preconditions.checkArgument(num != null);
                this.maxEjectionPercent = num;
                return this;
            }

            public Builder setMaxEjectionTimeNanos(Long l) {
                Preconditions.checkArgument(l != null);
                this.maxEjectionTimeNanos = l;
                return this;
            }

            public Builder setSuccessRateEjection(SuccessRateEjection successRateEjection) {
                this.successRateEjection = successRateEjection;
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class FailurePercentageEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer threshold;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public static class Builder {
                Integer threshold = 85;
                Integer enforcementPercentage = 100;
                Integer minimumHosts = 5;
                Integer requestVolume = 50;

                public FailurePercentageEjection build() {
                    return new FailurePercentageEjection(this.threshold, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }

                public Builder setEnforcementPercentage(Integer num) {
                    boolean z = false;
                    Preconditions.checkArgument(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z = true;
                    }
                    Preconditions.checkArgument(z);
                    this.enforcementPercentage = num;
                    return this;
                }

                public Builder setMinimumHosts(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.minimumHosts = num;
                    return this;
                }

                public Builder setRequestVolume(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.requestVolume = num;
                    return this;
                }

                public Builder setThreshold(Integer num) {
                    boolean z = false;
                    Preconditions.checkArgument(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z = true;
                    }
                    Preconditions.checkArgument(z);
                    this.threshold = num;
                    return this;
                }
            }

            public FailurePercentageEjection(Integer num, Integer num2, Integer num3, Integer num4) {
                this.threshold = num;
                this.enforcementPercentage = num2;
                this.minimumHosts = num3;
                this.requestVolume = num4;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class SuccessRateEjection {
            public final Integer enforcementPercentage;
            public final Integer minimumHosts;
            public final Integer requestVolume;
            public final Integer stdevFactor;

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public static final class Builder {
                Integer stdevFactor = 1900;
                Integer enforcementPercentage = 100;
                Integer minimumHosts = 5;
                Integer requestVolume = 100;

                public SuccessRateEjection build() {
                    return new SuccessRateEjection(this.stdevFactor, this.enforcementPercentage, this.minimumHosts, this.requestVolume);
                }

                public Builder setEnforcementPercentage(Integer num) {
                    boolean z = false;
                    Preconditions.checkArgument(num != null);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z = true;
                    }
                    Preconditions.checkArgument(z);
                    this.enforcementPercentage = num;
                    return this;
                }

                public Builder setMinimumHosts(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.minimumHosts = num;
                    return this;
                }

                public Builder setRequestVolume(Integer num) {
                    Preconditions.checkArgument(num != null);
                    Preconditions.checkArgument(num.intValue() >= 0);
                    this.requestVolume = num;
                    return this;
                }

                public Builder setStdevFactor(Integer num) {
                    Preconditions.checkArgument(num != null);
                    this.stdevFactor = num;
                    return this;
                }
            }

            public SuccessRateEjection(Integer num, Integer num2, Integer num3, Integer num4) {
                this.stdevFactor = num;
                this.enforcementPercentage = num2;
                this.minimumHosts = num3;
                this.requestVolume = num4;
            }
        }

        public boolean outlierDetectionEnabled() {
            return (this.successRateEjection == null && this.failurePercentageEjection == null) ? false : true;
        }

        private OutlierDetectionLoadBalancerConfig(Long l, Long l2, Long l3, Integer num, SuccessRateEjection successRateEjection, FailurePercentageEjection failurePercentageEjection, ServiceConfigUtil.PolicySelection policySelection) {
            this.intervalNanos = l;
            this.baseEjectionTimeNanos = l2;
            this.maxEjectionTimeNanos = l3;
            this.maxEjectionPercent = num;
            this.successRateEjection = successRateEjection;
            this.failurePercentageEjection = failurePercentageEjection;
            this.childPolicy = policySelection;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OutlierDetectionPicker extends LoadBalancer.SubchannelPicker {
        private final LoadBalancer.SubchannelPicker delegate;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class ResultCountingClientStreamTracer extends ClientStreamTracer {
            AddressTracker tracker;

            public ResultCountingClientStreamTracer(AddressTracker addressTracker) {
                this.tracker = addressTracker;
            }

            @Override // io.grpc.StreamTracer
            public void streamClosed(Status status) {
                this.tracker.incrementCallCount(status.isOk());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class ResultCountingClientStreamTracerFactory extends ClientStreamTracer.Factory {
            private final AddressTracker tracker;

            public ResultCountingClientStreamTracerFactory(AddressTracker addressTracker) {
                this.tracker = addressTracker;
            }

            @Override // io.grpc.ClientStreamTracer.Factory
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo streamInfo, Metadata metadata) {
                return OutlierDetectionPicker.this.new ResultCountingClientStreamTracer(this.tracker);
            }
        }

        public OutlierDetectionPicker(LoadBalancer.SubchannelPicker subchannelPicker) {
            this.delegate = subchannelPicker;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            LoadBalancer.PickResult pickResultPickSubchannel = this.delegate.pickSubchannel(pickSubchannelArgs);
            LoadBalancer.Subchannel subchannel = pickResultPickSubchannel.getSubchannel();
            return subchannel != null ? LoadBalancer.PickResult.withSubchannel(subchannel, new ResultCountingClientStreamTracerFactory((AddressTracker) subchannel.getAttributes().get(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY))) : pickResultPickSubchannel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OutlierDetectionSubchannel extends ForwardingSubchannel {
        private AddressTracker addressTracker;
        private final LoadBalancer.Subchannel delegate;
        private boolean ejected;
        private ConnectivityStateInfo lastSubchannelState;
        private final ChannelLogger logger;
        private LoadBalancer.SubchannelStateListener subchannelStateListener;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class OutlierDetectionSubchannelStateListener implements LoadBalancer.SubchannelStateListener {
            private final LoadBalancer.SubchannelStateListener delegate;

            public OutlierDetectionSubchannelStateListener(LoadBalancer.SubchannelStateListener subchannelStateListener) {
                this.delegate = subchannelStateListener;
            }

            @Override // io.grpc.LoadBalancer.SubchannelStateListener
            public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                OutlierDetectionSubchannel.this.lastSubchannelState = connectivityStateInfo;
                if (OutlierDetectionSubchannel.this.ejected) {
                    return;
                }
                this.delegate.onSubchannelState(connectivityStateInfo);
            }
        }

        public OutlierDetectionSubchannel(LoadBalancer.Subchannel subchannel) {
            this.delegate = subchannel;
            this.logger = subchannel.getChannelLogger();
        }

        public void clearAddressTracker() {
            this.addressTracker = null;
        }

        @Override // io.grpc.util.ForwardingSubchannel
        public LoadBalancer.Subchannel delegate() {
            return this.delegate;
        }

        public void eject() {
            this.ejected = true;
            this.subchannelStateListener.onSubchannelState(ConnectivityStateInfo.forTransientFailure(Status.UNAVAILABLE));
            this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel ejected: {0}", this);
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public Attributes getAttributes() {
            return this.addressTracker != null ? this.delegate.getAttributes().toBuilder().set(OutlierDetectionLoadBalancer.ADDRESS_TRACKER_ATTR_KEY, this.addressTracker).build() : this.delegate.getAttributes();
        }

        public boolean isEjected() {
            return this.ejected;
        }

        public void setAddressTracker(AddressTracker addressTracker) {
            this.addressTracker = addressTracker;
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void start(LoadBalancer.SubchannelStateListener subchannelStateListener) {
            this.subchannelStateListener = subchannelStateListener;
            super.start(new OutlierDetectionSubchannelStateListener(subchannelStateListener));
        }

        @Override // io.grpc.util.ForwardingSubchannel
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.delegate.getAllAddresses() + '}';
        }

        public void uneject() {
            this.ejected = false;
            ConnectivityStateInfo connectivityStateInfo = this.lastSubchannelState;
            if (connectivityStateInfo != null) {
                this.subchannelStateListener.onSubchannelState(connectivityStateInfo);
                this.logger.log(ChannelLogger.ChannelLogLevel.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // io.grpc.util.ForwardingSubchannel, io.grpc.LoadBalancer.Subchannel
        public void updateAddresses(List<EquivalentAddressGroup> list) {
            if (OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsValue(this.addressTracker)) {
                    this.addressTracker.removeSubchannel(this);
                }
                SocketAddress socketAddress = list.get(0).getAddresses().get(0);
                if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(socketAddress)) {
                    OutlierDetectionLoadBalancer.this.trackerMap.get(socketAddress).addSubchannel(this);
                }
            } else if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) || OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                if (!OutlierDetectionLoadBalancer.hasSingleAddress(getAllAddresses()) && OutlierDetectionLoadBalancer.hasSingleAddress(list)) {
                    SocketAddress socketAddress2 = list.get(0).getAddresses().get(0);
                    if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(socketAddress2)) {
                        OutlierDetectionLoadBalancer.this.trackerMap.get(socketAddress2).addSubchannel(this);
                    }
                }
            } else if (OutlierDetectionLoadBalancer.this.trackerMap.containsKey(getAddresses().getAddresses().get(0))) {
                AddressTracker addressTracker = OutlierDetectionLoadBalancer.this.trackerMap.get(getAddresses().getAddresses().get(0));
                addressTracker.removeSubchannel(this);
                addressTracker.resetCallCounters();
            }
            this.delegate.updateAddresses(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OutlierEjectionAlgorithm {
        @Nullable
        static List<OutlierEjectionAlgorithm> forConfig(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            ImmutableList.Builder builder = ImmutableList.builder();
            if (outlierDetectionLoadBalancerConfig.successRateEjection != null) {
                builder.add(new SuccessRateOutlierEjectionAlgorithm(outlierDetectionLoadBalancerConfig, channelLogger));
            }
            if (outlierDetectionLoadBalancerConfig.failurePercentageEjection != null) {
                builder.add(new FailurePercentageOutlierEjectionAlgorithm(outlierDetectionLoadBalancerConfig, channelLogger));
            }
            return builder.build();
        }

        void ejectOutliers(AddressTrackerMap addressTrackerMap, long j);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SuccessRateOutlierEjectionAlgorithm implements OutlierEjectionAlgorithm {
        private final OutlierDetectionLoadBalancerConfig config;
        private final ChannelLogger logger;

        public SuccessRateOutlierEjectionAlgorithm(OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
            Preconditions.checkArgument(outlierDetectionLoadBalancerConfig.successRateEjection != null, "success rate ejection config is null");
            this.config = outlierDetectionLoadBalancerConfig;
            this.logger = channelLogger;
        }

        @VisibleForTesting
        public static double mean(Collection<Double> collection) {
            Iterator<Double> it = collection.iterator();
            double dDoubleValue = 0.0d;
            while (it.hasNext()) {
                dDoubleValue += it.next().doubleValue();
            }
            return dDoubleValue / ((double) collection.size());
        }

        @VisibleForTesting
        public static double standardDeviation(Collection<Double> collection, double d) {
            Iterator<Double> it = collection.iterator();
            double d2 = 0.0d;
            while (it.hasNext()) {
                double dDoubleValue = it.next().doubleValue() - d;
                d2 += dDoubleValue * dDoubleValue;
            }
            return Math.sqrt(d2 / ((double) collection.size()));
        }

        @Override // io.grpc.util.OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm
        public void ejectOutliers(AddressTrackerMap addressTrackerMap, long j) {
            List<AddressTracker> listTrackersWithVolume = OutlierDetectionLoadBalancer.trackersWithVolume(addressTrackerMap, this.config.successRateEjection.requestVolume.intValue());
            if (listTrackersWithVolume.size() < this.config.successRateEjection.minimumHosts.intValue() || listTrackersWithVolume.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = listTrackersWithVolume.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((AddressTracker) it.next()).successRate()));
            }
            double dMean = mean(arrayList);
            double dStandardDeviation = standardDeviation(arrayList, dMean);
            double dIntValue = dMean - (((double) (this.config.successRateEjection.stdevFactor.intValue() / 1000.0f)) * dStandardDeviation);
            for (AddressTracker addressTracker : listTrackersWithVolume) {
                if (addressTrackerMap.ejectionPercentage() >= this.config.maxEjectionPercent.intValue()) {
                    return;
                }
                if (addressTracker.successRate() < dIntValue) {
                    this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", addressTracker, Double.valueOf(addressTracker.successRate()), Double.valueOf(dMean), Double.valueOf(dStandardDeviation), Double.valueOf(dIntValue));
                    if (new Random().nextInt(100) < this.config.successRateEjection.enforcementPercentage.intValue()) {
                        addressTracker.ejectSubchannels(j);
                    }
                }
            }
        }
    }

    public OutlierDetectionLoadBalancer(LoadBalancer.Helper helper, TimeProvider timeProvider) {
        ChannelLogger channelLogger = helper.getChannelLogger();
        this.logger = channelLogger;
        ChildHelper childHelper = new ChildHelper((LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper"));
        this.childHelper = childHelper;
        this.switchLb = new GracefulSwitchLoadBalancer(childHelper);
        this.trackerMap = new AddressTrackerMap();
        this.syncContext = (SynchronizationContext) Preconditions.checkNotNull(helper.getSynchronizationContext(), "syncContext");
        this.timeService = (ScheduledExecutorService) Preconditions.checkNotNull(helper.getScheduledExecutorService(), "timeService");
        this.timeProvider = timeProvider;
        channelLogger.log(ChannelLogger.ChannelLogLevel.DEBUG, "OutlierDetection lb created.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasSingleAddress(List<EquivalentAddressGroup> list) {
        Iterator<EquivalentAddressGroup> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().getAddresses().size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AddressTracker> trackersWithVolume(AddressTrackerMap addressTrackerMap, int i) {
        ArrayList arrayList = new ArrayList();
        for (AddressTracker addressTracker : addressTrackerMap.values()) {
            if (addressTracker.inactiveVolume() >= i) {
                arrayList.add(addressTracker);
            }
        }
        return arrayList;
    }

    @Override // io.grpc.LoadBalancer
    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        this.logger.log(ChannelLogger.ChannelLogLevel.DEBUG, "Received resolution result: {0}", resolvedAddresses);
        OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig = (OutlierDetectionLoadBalancerConfig) resolvedAddresses.getLoadBalancingPolicyConfig();
        ArrayList arrayList = new ArrayList();
        Iterator<EquivalentAddressGroup> it = resolvedAddresses.getAddresses().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getAddresses());
        }
        this.trackerMap.keySet().retainAll(arrayList);
        this.trackerMap.updateTrackerConfigs(outlierDetectionLoadBalancerConfig);
        this.trackerMap.putNewTrackers(outlierDetectionLoadBalancerConfig, arrayList);
        this.switchLb.switchTo(outlierDetectionLoadBalancerConfig.childPolicy.getProvider());
        if (outlierDetectionLoadBalancerConfig.outlierDetectionEnabled()) {
            Long lValueOf = this.detectionTimerStartNanos == null ? outlierDetectionLoadBalancerConfig.intervalNanos : Long.valueOf(Math.max(0L, outlierDetectionLoadBalancerConfig.intervalNanos.longValue() - (this.timeProvider.currentTimeNanos() - this.detectionTimerStartNanos.longValue())));
            SynchronizationContext.ScheduledHandle scheduledHandle = this.detectionTimerHandle;
            if (scheduledHandle != null) {
                scheduledHandle.cancel();
                this.trackerMap.resetCallCounters();
            }
            this.detectionTimerHandle = this.syncContext.scheduleWithFixedDelay(new DetectionTimer(outlierDetectionLoadBalancerConfig, this.logger), lValueOf.longValue(), outlierDetectionLoadBalancerConfig.intervalNanos.longValue(), TimeUnit.NANOSECONDS, this.timeService);
        } else {
            SynchronizationContext.ScheduledHandle scheduledHandle2 = this.detectionTimerHandle;
            if (scheduledHandle2 != null) {
                scheduledHandle2.cancel();
                this.detectionTimerStartNanos = null;
                this.trackerMap.cancelTracking();
            }
        }
        this.switchLb.handleResolvedAddresses(resolvedAddresses.toBuilder().setLoadBalancingPolicyConfig(outlierDetectionLoadBalancerConfig.childPolicy.getConfig()).build());
        return true;
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        this.switchLb.handleNameResolutionError(status);
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        this.switchLb.shutdown();
    }
}
