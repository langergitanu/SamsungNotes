package androidx.test.runner.lifecycle;

import android.app.Activity;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface ActivityLifecycleMonitor {
    void addLifecycleCallback(ActivityLifecycleCallback activityLifecycleCallback);

    Collection<Activity> getActivitiesInStage(Stage stage);

    Stage getLifecycleStageOf(Activity activity);

    void removeLifecycleCallback(ActivityLifecycleCallback activityLifecycleCallback);
}
