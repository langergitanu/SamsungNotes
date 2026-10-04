package androidx.test.runner.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationLifecycleMonitorRegistry {
    private static final AtomicReference<ApplicationLifecycleMonitor> lifecycleMonitor = new AtomicReference<>(null);

    private ApplicationLifecycleMonitorRegistry() {
    }

    public static ApplicationLifecycleMonitor getInstance() {
        ApplicationLifecycleMonitor applicationLifecycleMonitor = lifecycleMonitor.get();
        if (applicationLifecycleMonitor != null) {
            return applicationLifecycleMonitor;
        }
        throw new IllegalStateException("No lifecycle monitor registered! Are you running under an Instrumentation which registers lifecycle monitors?");
    }

    public static void registerInstance(ApplicationLifecycleMonitor applicationLifecycleMonitor) {
        lifecycleMonitor.set(applicationLifecycleMonitor);
    }
}
