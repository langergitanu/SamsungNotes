package io.netty.resolver;

import java.io.File;
import java.io.Reader;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HostsFileParser {
    private HostsFileParser() {
    }

    private static HostsFileEntries hostsFileEntries(HostsFileEntriesProvider hostsFileEntriesProvider) {
        return hostsFileEntriesProvider == HostsFileEntriesProvider.EMPTY ? HostsFileEntries.EMPTY : new HostsFileEntries(toMapWithSingleValue(hostsFileEntriesProvider.ipv4Entries()), toMapWithSingleValue(hostsFileEntriesProvider.ipv6Entries()));
    }

    public static HostsFileEntries parse() {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse());
    }

    public static HostsFileEntries parseSilently() {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parseSilently());
    }

    private static Map<String, ?> toMapWithSingleValue(Map<String, List<InetAddress>> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<String, List<InetAddress>> entry : map.entrySet()) {
            List<InetAddress> value = entry.getValue();
            if (!value.isEmpty()) {
                map2.put(entry.getKey(), value.get(0));
            }
        }
        return map2;
    }

    public static HostsFileEntries parse(File file) {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse(file, new Charset[0]));
    }

    public static HostsFileEntries parseSilently(Charset... charsetArr) {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parseSilently(charsetArr));
    }

    public static HostsFileEntries parse(File file, Charset... charsetArr) {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse(file, charsetArr));
    }

    public static HostsFileEntries parse(Reader reader) {
        return hostsFileEntries(HostsFileEntriesProvider.parser().parse(reader));
    }
}
