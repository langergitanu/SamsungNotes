package io.netty.handler.ipfilter;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class IpSubnetFilterRule implements IpFilterRule, Comparable<IpSubnetFilterRule> {
    private final IpFilterRule filterRule;
    private final String ipAddress;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Ip4SubnetFilterRule implements IpFilterRule {
        private final int networkAddress;
        private final IpFilterRuleType ruleType;
        private final int subnetMask;

        private static int prefixToSubnetMask(int i) {
            return (int) ((-1) << (32 - i));
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            return (address instanceof Inet4Address) && (NetUtil.ipv4AddressToInt((Inet4Address) address) & this.subnetMask) == this.networkAddress;
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip4SubnetFilterRule(Inet4Address inet4Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i < 0 || i > 32) {
                throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", Integer.valueOf(i)));
            }
            int iPrefixToSubnetMask = prefixToSubnetMask(i);
            this.subnetMask = iPrefixToSubnetMask;
            this.networkAddress = NetUtil.ipv4AddressToInt(inet4Address) & iPrefixToSubnetMask;
            this.ruleType = ipFilterRuleType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Ip6SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
        private final BigInteger networkAddress;
        private final IpFilterRuleType ruleType;
        private final BigInteger subnetMask;

        /* JADX INFO: Access modifiers changed from: private */
        public static BigInteger ipToInt(Inet6Address inet6Address) {
            return new BigInteger(inet6Address.getAddress());
        }

        private static BigInteger prefixToSubnetMask(int i) {
            return MINUS_ONE.shiftLeft(128 - i);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            if (!(address instanceof Inet6Address)) {
                return false;
            }
            BigInteger bigIntegerIpToInt = ipToInt((Inet6Address) address);
            return bigIntegerIpToInt.and(this.subnetMask).equals(this.subnetMask) || bigIntegerIpToInt.and(this.subnetMask).equals(this.networkAddress);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip6SubnetFilterRule(Inet6Address inet6Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i < 0 || i > 128) {
                throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", Integer.valueOf(i)));
            }
            BigInteger bigIntegerPrefixToSubnetMask = prefixToSubnetMask(i);
            this.subnetMask = bigIntegerPrefixToSubnetMask;
            this.networkAddress = ipToInt(inet6Address).and(bigIntegerPrefixToSubnetMask);
            this.ruleType = ipFilterRuleType;
        }
    }

    public IpSubnetFilterRule(String str, int i, IpFilterRuleType ipFilterRuleType) {
        try {
            this.ipAddress = str;
            this.filterRule = selectFilterRule(SocketUtils.addressByName(str), i, ipFilterRuleType);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException("ipAddress", e);
        }
    }

    private static int compareInt(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static IpFilterRule selectFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        ObjectUtil.checkNotNull(inetAddress, "ipAddress");
        ObjectUtil.checkNotNull(ipFilterRuleType, "ruleType");
        if (inetAddress instanceof Inet4Address) {
            return new Ip4SubnetFilterRule((Inet4Address) inetAddress, i, ipFilterRuleType);
        }
        if (inetAddress instanceof Inet6Address) {
            return new Ip6SubnetFilterRule((Inet6Address) inetAddress, i, ipFilterRuleType);
        }
        throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
    }

    public IpFilterRule getFilterRule() {
        return this.filterRule;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public boolean matches(InetSocketAddress inetSocketAddress) {
        return this.filterRule.matches(inetSocketAddress);
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    @Override // java.lang.Comparable
    public int compareTo(IpSubnetFilterRule ipSubnetFilterRule) {
        IpFilterRule ipFilterRule = this.filterRule;
        return ipFilterRule instanceof Ip4SubnetFilterRule ? compareInt(((Ip4SubnetFilterRule) ipFilterRule).networkAddress, ((Ip4SubnetFilterRule) ipSubnetFilterRule.filterRule).networkAddress) : ((Ip6SubnetFilterRule) ipFilterRule).networkAddress.compareTo(((Ip6SubnetFilterRule) ipSubnetFilterRule.filterRule).networkAddress);
    }

    public IpSubnetFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        this.ipAddress = inetAddress.getHostAddress();
        this.filterRule = selectFilterRule(inetAddress, i, ipFilterRuleType);
    }

    public int compareTo(InetSocketAddress inetSocketAddress) {
        IpFilterRule ipFilterRule = this.filterRule;
        if (ipFilterRule instanceof Ip4SubnetFilterRule) {
            Ip4SubnetFilterRule ip4SubnetFilterRule = (Ip4SubnetFilterRule) ipFilterRule;
            return compareInt(ip4SubnetFilterRule.networkAddress, NetUtil.ipv4AddressToInt((Inet4Address) inetSocketAddress.getAddress()) & ip4SubnetFilterRule.subnetMask);
        }
        Ip6SubnetFilterRule ip6SubnetFilterRule = (Ip6SubnetFilterRule) ipFilterRule;
        return ip6SubnetFilterRule.networkAddress.compareTo(Ip6SubnetFilterRule.ipToInt((Inet6Address) inetSocketAddress.getAddress()).and(ip6SubnetFilterRule.networkAddress));
    }
}
