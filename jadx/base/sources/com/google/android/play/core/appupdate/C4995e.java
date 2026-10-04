package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.C5345i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.e */
/* JADX INFO: loaded from: classes5.dex */
final class C4995e implements AppUpdateManager {

    /* JADX INFO: renamed from: a */
    private final C5006p f2426a;

    /* JADX INFO: renamed from: b */
    private final C4991a f2427b;

    /* JADX INFO: renamed from: c */
    private final Context f2428c;

    /* JADX INFO: renamed from: d */
    private final Handler f2429d = new Handler(Looper.getMainLooper());

    public C4995e(C5006p c5006p, C4991a c4991a, Context context) {
        this.f2426a = c5006p;
        this.f2427b = c4991a;
        this.f2428c = context;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Void> completeUpdate() {
        return this.f2426a.m3607b(this.f2428c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.f2426a.m3606a(this.f2428c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f2427b.m4033a((StateUpdatedListener) installStateUpdatedListener);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        PlayCoreDialogWrapperActivity.m3854a(this.f2428c);
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return Tasks.m4184a((Exception) new InstallException(-6));
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", appUpdateInfo.m3584a(appUpdateOptions));
        C5345i c5345i = new C5345i();
        intent.putExtra("result_receiver", new ResultReceiverC4993c(this.f2429d, c5345i));
        activity.startActivity(intent);
        return c5345i.m4197a();
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) {
        return startUpdateFlowForResult(appUpdateInfo, new C4994d(activity), AppUpdateOptions.defaultOptions(i), i2);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f2427b.m4036b(installStateUpdatedListener);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return startUpdateFlowForResult(appUpdateInfo, intentSenderForResultStarter, AppUpdateOptions.defaultOptions(i), i2);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) {
        return startUpdateFlowForResult(appUpdateInfo, new C4994d(activity), appUpdateOptions, i);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) {
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions)) {
            return false;
        }
        intentSenderForResultStarter.startIntentSenderForResult(appUpdateInfo.m3584a(appUpdateOptions).getIntentSender(), i, null, 0, 0, 0, null);
        return true;
    }
}
