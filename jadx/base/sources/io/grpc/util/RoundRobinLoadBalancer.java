package io.grpc.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.Internal;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nonnull;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Internal
public class RoundRobinLoadBalancer extends LoadBalancer {
    private ConnectivityState currentState;
    private final LoadBalancer.Helper helper;

    @VisibleForTesting
    static final Attributes.Key<Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.create("state-info");
    private static final Status EMPTY_OK = Status.f8817OK.withDescription("no subchannels ready");
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap();
    protected RoundRobinPicker currentPicker = new EmptyPicker(EMPTY_OK);
    private final Random random = new Random();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class EmptyPicker extends RoundRobinPicker {
        private final Status status;

        public EmptyPicker(@Nonnull Status status) {
            this.status = (Status) Preconditions.checkNotNull(status, "status");
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        public boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (!(roundRobinPicker instanceof EmptyPicker)) {
                return false;
            }
            EmptyPicker emptyPicker = (EmptyPicker) roundRobinPicker;
            if (Objects.equal(this.status, emptyPicker.status)) {
                return true;
            }
            return this.status.isOk() && emptyPicker.status.isOk();
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return this.status.isOk() ? LoadBalancer.PickResult.withNoResult() : LoadBalancer.PickResult.withError(this.status);
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) EmptyPicker.class).add("status", this.status).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class ReadyPicker extends RoundRobinPicker {
        private static final AtomicIntegerFieldUpdater<ReadyPicker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(ReadyPicker.class, "index");
        private volatile int index;
        private final List<LoadBalancer.Subchannel> list;

        public ReadyPicker(List<LoadBalancer.Subchannel> list, int i) {
            Preconditions.checkArgument(!list.isEmpty(), "empty list");
            this.list = list;
            this.index = i - 1;
        }

        private LoadBalancer.Subchannel nextSubchannel() {
            int size = this.list.size();
            AtomicIntegerFieldUpdater<ReadyPicker> atomicIntegerFieldUpdater = indexUpdater;
            int iIncrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (iIncrementAndGet >= size) {
                int i = iIncrementAndGet % size;
                atomicIntegerFieldUpdater.compareAndSet(this, iIncrementAndGet, i);
                iIncrementAndGet = i;
            }
            return this.list.get(iIncrementAndGet);
        }

        @VisibleForTesting
        public List<LoadBalancer.Subchannel> getList() {
            return this.list;
        }

        @Override // io.grpc.util.RoundRobinLoadBalancer.RoundRobinPicker
        public boolean isEquivalentTo(RoundRobinPicker roundRobinPicker) {
            if (!(roundRobinPicker instanceof ReadyPicker)) {
                return false;
            }
            ReadyPicker readyPicker = (ReadyPicker) roundRobinPicker;
            if (readyPicker != this) {
                return this.list.size() == readyPicker.list.size() && new HashSet(this.list).containsAll(readyPicker.list);
            }
            return true;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withSubchannel(nextSubchannel());
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) ReadyPicker.class).add(XmlErrorCodes.LIST, this.list).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static final class Ref<T> {
        T value;

        public Ref(T t) {
            this.value = t;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class RoundRobinPicker extends LoadBalancer.SubchannelPicker {
        public abstract boolean isEquivalentTo(RoundRobinPicker roundRobinPicker);
    }

    public RoundRobinLoadBalancer(LoadBalancer.Helper helper) {
        this.helper = (LoadBalancer.Helper) Preconditions.checkNotNull(helper, "helper");
    }

    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (LoadBalancer.Subchannel subchannel : collection) {
            if (isReady(subchannel)) {
                arrayList.add(subchannel);
            }
        }
        return arrayList;
    }

    private static Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel subchannel) {
        return (Ref) Preconditions.checkNotNull((Ref) subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }

    public static boolean isReady(LoadBalancer.Subchannel subchannel) {
        return getSubchannelStateInfoRef(subchannel).value.getState() == ConnectivityState.READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void processSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        if (this.subchannels.get(stripAttrs(subchannel.getAddresses())) != subchannel) {
            return;
        }
        ConnectivityState state = connectivityStateInfo.getState();
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        if (state == connectivityState || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
            this.helper.refreshNameResolution();
        }
        ConnectivityState state2 = connectivityStateInfo.getState();
        ConnectivityState connectivityState2 = ConnectivityState.IDLE;
        if (state2 == connectivityState2) {
            subchannel.requestConnection();
        }
        Ref<ConnectivityStateInfo> subchannelStateInfoRef = getSubchannelStateInfoRef(subchannel);
        if (subchannelStateInfoRef.value.getState().equals(connectivityState) && (connectivityStateInfo.getState().equals(ConnectivityState.CONNECTING) || connectivityStateInfo.getState().equals(connectivityState2))) {
            return;
        }
        subchannelStateInfoRef.value = connectivityStateInfo;
        updateBalancingState();
    }

    private static <T> Set<T> setsDifference(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, io.grpc.ConnectivityStateInfo] */
    private void shutdownSubchannel(LoadBalancer.Subchannel subchannel) {
        subchannel.shutdown();
        getSubchannelStateInfoRef(subchannel).value = ConnectivityStateInfo.forNonError(ConnectivityState.SHUTDOWN);
    }

    private static Map<EquivalentAddressGroup, EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> list) {
        HashMap map = new HashMap(list.size() * 2);
        for (EquivalentAddressGroup equivalentAddressGroup : list) {
            map.put(stripAttrs(equivalentAddressGroup), equivalentAddressGroup);
        }
        return map;
    }

    private void updateBalancingState() {
        List<LoadBalancer.Subchannel> listFilterNonFailingSubchannels = filterNonFailingSubchannels(getSubchannels());
        if (!listFilterNonFailingSubchannels.isEmpty()) {
            updateBalancingState(ConnectivityState.READY, createReadyPicker(listFilterNonFailingSubchannels));
            return;
        }
        Status status = EMPTY_OK;
        Iterator<LoadBalancer.Subchannel> it = getSubchannels().iterator();
        boolean z = false;
        while (it.hasNext()) {
            ConnectivityStateInfo connectivityStateInfo = getSubchannelStateInfoRef(it.next()).value;
            if (connectivityStateInfo.getState() == ConnectivityState.CONNECTING || connectivityStateInfo.getState() == ConnectivityState.IDLE) {
                z = true;
            }
            if (status == EMPTY_OK || !status.isOk()) {
                status = connectivityStateInfo.getStatus();
            }
        }
        updateBalancingState(z ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(status));
    }

    @Override // io.grpc.LoadBalancer
    public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        if (resolvedAddresses.getAddresses().isEmpty()) {
            handleNameResolutionError(Status.UNAVAILABLE.withDescription("NameResolver returned no usable address. addrs=" + resolvedAddresses.getAddresses() + ", attrs=" + resolvedAddresses.getAttributes()));
            return false;
        }
        List<EquivalentAddressGroup> addresses = resolvedAddresses.getAddresses();
        Set<EquivalentAddressGroup> setKeySet = this.subchannels.keySet();
        Map<EquivalentAddressGroup, EquivalentAddressGroup> mapStripAttrs = stripAttrs(addresses);
        Set set = setsDifference(setKeySet, mapStripAttrs.keySet());
        for (Map.Entry<EquivalentAddressGroup, EquivalentAddressGroup> entry : mapStripAttrs.entrySet()) {
            EquivalentAddressGroup key = entry.getKey();
            EquivalentAddressGroup value = entry.getValue();
            LoadBalancer.Subchannel subchannel = this.subchannels.get(key);
            if (subchannel != null) {
                subchannel.updateAddresses(Collections.singletonList(value));
            } else {
                final LoadBalancer.Subchannel subchannel2 = (LoadBalancer.Subchannel) Preconditions.checkNotNull(this.helper.createSubchannel(LoadBalancer.CreateSubchannelArgs.newBuilder().setAddresses(value).setAttributes(Attributes.newBuilder().set(STATE_INFO, new Ref(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE))).build()).build()), "subchannel");
                subchannel2.start(new LoadBalancer.SubchannelStateListener() { // from class: io.grpc.util.RoundRobinLoadBalancer.1
                    @Override // io.grpc.LoadBalancer.SubchannelStateListener
                    public void onSubchannelState(ConnectivityStateInfo connectivityStateInfo) {
                        RoundRobinLoadBalancer.this.processSubchannelState(subchannel2, connectivityStateInfo);
                    }
                });
                this.subchannels.put(key, subchannel2);
                subchannel2.requestConnection();
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.subchannels.remove((EquivalentAddressGroup) it.next()));
        }
        updateBalancingState();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            shutdownSubchannel((LoadBalancer.Subchannel) it2.next());
        }
        return true;
    }

    public RoundRobinPicker createReadyPicker(List<LoadBalancer.Subchannel> list) {
        return new ReadyPicker(list, this.random.nextInt(list.size()));
    }

    @VisibleForTesting
    public Collection<LoadBalancer.Subchannel> getSubchannels() {
        return this.subchannels.values();
    }

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        if (this.currentState != ConnectivityState.READY) {
            updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new EmptyPicker(status));
        }
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        Iterator<LoadBalancer.Subchannel> it = getSubchannels().iterator();
        while (it.hasNext()) {
            shutdownSubchannel(it.next());
        }
        this.subchannels.clear();
    }

    private static EquivalentAddressGroup stripAttrs(EquivalentAddressGroup equivalentAddressGroup) {
        return new EquivalentAddressGroup(equivalentAddressGroup.getAddresses());
    }

    private void updateBalancingState(ConnectivityState connectivityState, RoundRobinPicker roundRobinPicker) {
        if (connectivityState == this.currentState && roundRobinPicker.isEquivalentTo(this.currentPicker)) {
            return;
        }
        this.helper.updateBalancingState(connectivityState, roundRobinPicker);
        this.currentState = connectivityState;
        this.currentPicker = roundRobinPicker;
    }
}
