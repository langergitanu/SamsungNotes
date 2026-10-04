package androidx.test.internal.platform.util;

import androidx.annotation.RestrictTo;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import java.io.Serializable;
import java.util.Map;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TestOutputEmitter {
    private static final TestOutputHandler debugHandler = (TestOutputHandler) ServiceLoaderWrapper.loadSingleService(TestOutputHandler.class, new C0347a(12));

    private TestOutputEmitter() {
    }

    public static boolean addOutputProperties(Map<String, Serializable> map) {
        return debugHandler.addOutputProperties(map);
    }

    public static boolean captureWindowHierarchy(String str) {
        return debugHandler.captureWindowHierarchy(str);
    }

    public static void dumpThreadStates(String str) {
        debugHandler.dumpThreadStates(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TestOutputHandler lambda$static$0() {
        return new TestOutputHandler() { // from class: androidx.test.internal.platform.util.TestOutputEmitter.1
            @Override // androidx.test.internal.platform.util.TestOutputHandler
            public boolean addOutputProperties(Map<String, Serializable> map) {
                return false;
            }

            @Override // androidx.test.internal.platform.util.TestOutputHandler
            public boolean captureWindowHierarchy(String str) {
                return false;
            }

            @Override // androidx.test.internal.platform.util.TestOutputHandler
            public boolean takeScreenshot(String str) {
                return false;
            }

            @Override // androidx.test.internal.platform.util.TestOutputHandler
            public void dumpThreadStates(String str) {
            }
        };
    }

    public static boolean takeScreenshot(String str) {
        return debugHandler.takeScreenshot(str);
    }
}
