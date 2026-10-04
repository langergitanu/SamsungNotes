package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.app.ActivityManager;
import android.content.Context;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/util/RunningChecker;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SCREEN_OFF_MEMO_SERVICE_NAME", "isScreenOffActivityRunning", "", "isScreenOffServiceRunning", "context", "Landroid/content/Context;", "isScreenOffActivityFinishing", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RunningChecker {

    @NotNull
    private static final String SCREEN_OFF_MEMO_SERVICE_NAME = "com.samsung.android.app.notes.screenoffmemo.ScreenOffMemoService";

    @NotNull
    public static final RunningChecker INSTANCE = new RunningChecker();

    @NotNull
    private static final String TAG = SOLogger.createTag("RunningChecker");

    private RunningChecker() {
    }

    public final boolean isScreenOffActivityFinishing(@NotNull String activityName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        return ApplicationManager.INSTANCE.getInstance().getActivityTracker().isActivityFinishing(activityName);
    }

    public final boolean isScreenOffActivityRunning() {
        ApplicationManager.Companion companion = ApplicationManager.INSTANCE;
        ActivityLifecycleTracker activityTracker = companion.getInstance().getActivityTracker();
        Intrinsics.checkNotNullExpressionValue("ScreenOffActivity", "getSimpleName(...)");
        if (activityTracker.isActivityRunning("ScreenOffActivity")) {
            return true;
        }
        ActivityLifecycleTracker activityTracker2 = companion.getInstance().getActivityTracker();
        Intrinsics.checkNotNullExpressionValue("ScreenOffAnimatorActivity", "getSimpleName(...)");
        return activityTracker2.isActivityRunning("ScreenOffAnimatorActivity");
    }

    public final boolean isScreenOffServiceRunning(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService(Constants.StringExtra.EXECUTE_TYPE_ACTIVITY);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE).iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(SCREEN_OFF_MEMO_SERVICE_NAME, it.next().service.getClassName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            AbstractC8014b.m7208j("isScreenOffServiceRunning# ", e.getMessage(), SOLogger.INSTANCE, TAG);
            return false;
        }
    }
}
