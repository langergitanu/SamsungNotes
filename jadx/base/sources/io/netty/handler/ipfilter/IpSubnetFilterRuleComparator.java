package io.netty.handler.ipfilter;

import java.net.InetSocketAddress;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class IpSubnetFilterRuleComparator implements Comparator<Object> {
    static final IpSubnetFilterRuleComparator INSTANCE = new IpSubnetFilterRuleComparator();

    private IpSubnetFilterRuleComparator() {
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((IpSubnetFilterRule) obj).compareTo((InetSocketAddress) obj2);
    }
}
