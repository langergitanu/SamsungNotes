package androidx.test.platform.app;

import android.app.Instrumentation;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class InstrumentationRegistry {
    private static final AtomicReference<Instrumentation> instrumentationRef = new AtomicReference<>(null);
    private static final AtomicReference<Bundle> arguments = new AtomicReference<>(null);

    private InstrumentationRegistry() {
    }

    public static Bundle getArguments() {
        Bundle bundle = arguments.get();
        if (bundle != null) {
            return new Bundle(bundle);
        }
        throw new IllegalStateException("No instrumentation arguments registered! Are you running under an Instrumentation which registers arguments?");
    }

    public static Instrumentation getInstrumentation() {
        Instrumentation instrumentation = instrumentationRef.get();
        if (instrumentation != null) {
            return instrumentation;
        }
        throw new IllegalStateException("No instrumentation registered! Must run under a registering instrumentation.");
    }

    public static void registerInstance(Instrumentation instrumentation, Bundle bundle) {
        instrumentationRef.set(instrumentation);
        arguments.set(new Bundle(bundle));
    }
}
