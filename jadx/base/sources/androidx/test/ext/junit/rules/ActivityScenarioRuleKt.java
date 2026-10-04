package androidx.test.ext.junit.rules;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\b¨\u0006\b"}, m13886d2 = {"activityScenarioRule", "Landroidx/test/ext/junit/rules/ActivityScenarioRule;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/app/Activity;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "activityOptions", "Landroid/os/Bundle;", "ktx_ext_junit_java_androidx_test_ext_junit-junit_kt"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ActivityScenarioRuleKt {
    public static final /* synthetic */ <A extends Activity> ActivityScenarioRule<A> activityScenarioRule(Intent intent, Bundle bundle) {
        if (intent != null) {
            return new ActivityScenarioRule<>(intent, bundle);
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        return new ActivityScenarioRule<>(Activity.class, bundle);
    }

    public static /* synthetic */ ActivityScenarioRule activityScenarioRule$default(Intent intent, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            intent = null;
        }
        if ((i & 2) != 0) {
            bundle = null;
        }
        if (intent != null) {
            return new ActivityScenarioRule(intent, bundle);
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        return new ActivityScenarioRule(Activity.class, bundle);
    }
}
