package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.InternalChannelz;
import io.grpc.InternalInstrumented;
import io.grpc.LoadBalancer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
    @VisibleForTesting
    public abstract InternalInstrumented<InternalChannelz.ChannelStats> getInstrumentedInternalSubchannel();
}
