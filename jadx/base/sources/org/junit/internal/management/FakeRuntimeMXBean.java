package org.junit.internal.management;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
class FakeRuntimeMXBean implements RuntimeMXBean {
    @Override // org.junit.internal.management.RuntimeMXBean
    public List<String> getInputArguments() {
        return Collections.EMPTY_LIST;
    }
}
