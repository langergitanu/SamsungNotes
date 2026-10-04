package androidx.appsearch.app;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AppSearchEnvironmentFactory {
    private static volatile AppSearchEnvironment sAppSearchEnvironment;

    private AppSearchEnvironmentFactory() {
    }

    public static AppSearchEnvironment getEnvironmentInstance() {
        AppSearchEnvironment jetpackAppSearchEnvironment;
        AppSearchEnvironment appSearchEnvironment = sAppSearchEnvironment;
        if (appSearchEnvironment != null) {
            return appSearchEnvironment;
        }
        synchronized (AppSearchEnvironmentFactory.class) {
            try {
                jetpackAppSearchEnvironment = sAppSearchEnvironment;
                if (jetpackAppSearchEnvironment == null) {
                    jetpackAppSearchEnvironment = new JetpackAppSearchEnvironment();
                    sAppSearchEnvironment = jetpackAppSearchEnvironment;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jetpackAppSearchEnvironment;
    }

    @VisibleForTesting
    public static void setEnvironmentInstanceForTest(AppSearchEnvironment appSearchEnvironment) {
        synchronized (AppSearchEnvironmentFactory.class) {
            sAppSearchEnvironment = appSearchEnvironment;
        }
    }
}
