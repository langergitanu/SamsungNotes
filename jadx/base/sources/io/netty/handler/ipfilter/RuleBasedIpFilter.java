package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ChannelHandler.Sharable
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final boolean acceptIfNotFound;
    private final List<IpFilterRule> rules;

    public RuleBasedIpFilter(IpFilterRule... ipFilterRuleArr) {
        this(true, ipFilterRuleArr);
    }

    public RuleBasedIpFilter(boolean z, IpFilterRule... ipFilterRuleArr) {
        ObjectUtil.checkNotNull(ipFilterRuleArr, "rules");
        this.acceptIfNotFound = z;
        this.rules = new ArrayList(ipFilterRuleArr.length);
        for (IpFilterRule ipFilterRule : ipFilterRuleArr) {
            if (ipFilterRule != null) {
                this.rules.add(ipFilterRule);
            }
        }
    }

    @Override // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext, InetSocketAddress inetSocketAddress) {
        for (IpFilterRule ipFilterRule : this.rules) {
            if (ipFilterRule.matches(inetSocketAddress)) {
                return ipFilterRule.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return this.acceptIfNotFound;
    }
}
