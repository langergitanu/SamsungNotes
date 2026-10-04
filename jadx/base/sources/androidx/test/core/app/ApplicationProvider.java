package androidx.test.core.app;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationProvider {
    private ApplicationProvider() {
    }

    public static <T extends Context> T getApplicationContext() {
        return (T) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
}
