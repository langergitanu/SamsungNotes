package androidx.test.runner.intent;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class IntentMonitorRegistry {
    private static final AtomicReference<IntentMonitor> monitorRef = new AtomicReference<>(null);

    private IntentMonitorRegistry() {
    }

    public static IntentMonitor getInstance() {
        IntentMonitor intentMonitor = monitorRef.get();
        if (intentMonitor != null) {
            return intentMonitor;
        }
        throw new IllegalStateException("No intent monitor registered! Are you running under an Instrumentation which registers intent monitors?");
    }

    public static void registerInstance(IntentMonitor intentMonitor) {
        monitorRef.set(intentMonitor);
    }
}
