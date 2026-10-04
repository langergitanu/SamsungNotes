package io.netty.handler.ssl;

import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface CipherSuiteFilter {
    String[] filterCipherSuites(Iterable<String> iterable, List<String> list, Set<String> set);
}
