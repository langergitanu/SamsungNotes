package androidx.test.internal.platform.app;

import androidx.annotation.RestrictTo;
import androidx.test.internal.platform.util.InstrumentationParameterUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ActivityLifecycleTimeout {
    private static final String ACTIVITY_LIFECYCLE_CHANGE_TIMEOUT_MILLIS_KEY = "activityLifecycleChangeTimeoutMillis";
    private static final int DEFAULT_ACTIVITY_LIFECYCLE_CHANGE_TIMEOUT_MILLIS = 45000;

    public static long getMillis() {
        return InstrumentationParameterUtil.getTimeoutMillis(ACTIVITY_LIFECYCLE_CHANGE_TIMEOUT_MILLIS_KEY, 45000L);
    }
}
