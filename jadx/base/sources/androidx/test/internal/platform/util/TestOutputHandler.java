package androidx.test.internal.platform.util;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface TestOutputHandler {
    boolean addOutputProperties(Map<String, Serializable> map);

    boolean captureWindowHierarchy(String str);

    void dumpThreadStates(String str);

    boolean takeScreenshot(String str);
}
