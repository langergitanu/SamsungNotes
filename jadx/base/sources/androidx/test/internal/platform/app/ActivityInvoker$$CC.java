package androidx.test.internal.platform.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.test.platform.app.InstrumentationRegistry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ActivityInvoker$$CC {
    private ActivityInvoker$$CC() {
    }

    public static Intent getIntentForActivity$$dflt$$(ActivityInvoker activityInvoker, Class<? extends Activity> cls) {
        Intent intentMakeMainActivity = Intent.makeMainActivity(new ComponentName(InstrumentationRegistry.getInstrumentation().getTargetContext(), cls));
        return InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageManager().resolveActivity(intentMakeMainActivity, 0) != null ? intentMakeMainActivity : Intent.makeMainActivity(new ComponentName(InstrumentationRegistry.getInstrumentation().getContext(), cls));
    }
}
