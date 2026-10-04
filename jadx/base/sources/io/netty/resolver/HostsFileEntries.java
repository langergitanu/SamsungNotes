package io.netty.resolver;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HostsFileEntries {
    static final HostsFileEntries EMPTY;
    private final Map<String, Inet4Address> inet4Entries;
    private final Map<String, Inet6Address> inet6Entries;

    static {
        Map map = Collections.EMPTY_MAP;
        EMPTY = new HostsFileEntries(map, map);
    }

    public HostsFileEntries(Map<String, Inet4Address> map, Map<String, Inet6Address> map2) {
        this.inet4Entries = Collections.unmodifiableMap(new HashMap(map));
        this.inet6Entries = Collections.unmodifiableMap(new HashMap(map2));
    }

    public Map<String, Inet4Address> inet4Entries() {
        return this.inet4Entries;
    }

    public Map<String, Inet6Address> inet6Entries() {
        return this.inet6Entries;
    }
}
