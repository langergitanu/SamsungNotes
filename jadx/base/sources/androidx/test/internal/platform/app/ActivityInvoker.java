package androidx.test.internal.platform.app;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.test.platform.app.InstrumentationRegistry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ActivityInvoker {
    void finishActivity(Activity activity);

    Instrumentation.ActivityResult getActivityResult();

    default Intent getIntentForActivity(Class<? extends Activity> cls) {
        Intent intentMakeMainActivity = Intent.makeMainActivity(new ComponentName(InstrumentationRegistry.getInstrumentation().getTargetContext(), cls));
        return InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageManager().resolveActivity(intentMakeMainActivity, 0) != null ? intentMakeMainActivity : Intent.makeMainActivity(new ComponentName(InstrumentationRegistry.getInstrumentation().getContext(), cls));
    }

    void pauseActivity(Activity activity);

    void recreateActivity(Activity activity);

    void resumeActivity(Activity activity);

    void startActivity(Intent intent);

    void startActivity(Intent intent, @Nullable Bundle bundle);

    void startActivityForResult(Intent intent);

    void startActivityForResult(Intent intent, @Nullable Bundle bundle);

    void stopActivity(Activity activity);
}
