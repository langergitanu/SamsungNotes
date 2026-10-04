package androidx.test.runner.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class ActivityLifecycleMonitorRegistry {
    private static final AtomicReference<ActivityLifecycleMonitor> lifecycleMonitor = new AtomicReference<>(null);

    private ActivityLifecycleMonitorRegistry() {
    }

    public static ActivityLifecycleMonitor getInstance() {
        ActivityLifecycleMonitor activityLifecycleMonitor = lifecycleMonitor.get();
        if (activityLifecycleMonitor != null) {
            return activityLifecycleMonitor;
        }
        throw new IllegalStateException("No lifecycle monitor registered! Are you running under an Instrumentation which registers lifecycle monitors?");
    }

    public static void registerInstance(ActivityLifecycleMonitor activityLifecycleMonitor) {
        lifecycleMonitor.set(activityLifecycleMonitor);
    }
}
