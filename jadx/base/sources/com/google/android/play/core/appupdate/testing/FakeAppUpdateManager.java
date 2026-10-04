package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.C4991a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.listener.StateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* JADX INFO: loaded from: classes5.dex */
public class FakeAppUpdateManager implements AppUpdateManager {

    /* JADX INFO: renamed from: a */
    private final C4991a f2472a;

    /* JADX INFO: renamed from: b */
    private final Context f2473b;

    /* JADX INFO: renamed from: c */
    @InstallStatus
    private int f2474c = 0;

    /* JADX INFO: renamed from: d */
    @InstallErrorCode
    private int f2475d = 0;

    /* JADX INFO: renamed from: e */
    private boolean f2476e = false;

    /* JADX INFO: renamed from: f */
    private int f2477f = 0;

    /* JADX INFO: renamed from: g */
    @Nullable
    private Integer f2478g = null;

    /* JADX INFO: renamed from: h */
    private int f2479h = 0;

    /* JADX INFO: renamed from: i */
    private long f2480i = 0;

    /* JADX INFO: renamed from: j */
    private long f2481j = 0;

    /* JADX INFO: renamed from: k */
    private boolean f2482k = false;

    /* JADX INFO: renamed from: l */
    private boolean f2483l = false;

    /* JADX INFO: renamed from: m */
    private boolean f2484m = false;

    /* JADX INFO: renamed from: n */
    @Nullable
    @AppUpdateType
    private Integer f2485n;

    public FakeAppUpdateManager(Context context) {
        this.f2472a = new C4991a(context);
        this.f2473b = context;
    }

    @UpdateAvailability
    /* JADX INFO: renamed from: a */
    private final int m3610a() {
        if (!this.f2476e) {
            return 1;
        }
        int i = this.f2474c;
        return (i == 0 || i == 4 || i == 5 || i == 6) ? 2 : 3;
    }

    /* JADX INFO: renamed from: b */
    private final void m3612b() {
        this.f2472a.m4034a(InstallState.m3862a(this.f2474c, this.f2480i, this.f2481j, this.f2475d, this.f2473b.getPackageName()));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<Void> completeUpdate() {
        int i = this.f2475d;
        if (i != 0) {
            return Tasks.m4184a((Exception) new InstallException(i));
        }
        int i2 = this.f2474c;
        if (i2 != 11) {
            return i2 == 3 ? Tasks.m4184a((Exception) new InstallException(-8)) : Tasks.m4184a((Exception) new InstallException(-7));
        }
        this.f2474c = 3;
        this.f2484m = true;
        Integer num = 0;
        if (num.equals(this.f2485n)) {
            m3612b();
        }
        return Tasks.m4185a((Object) null);
    }

    public void downloadCompletes() {
        int i = this.f2474c;
        if (i == 2 || i == 1) {
            this.f2474c = 11;
            this.f2480i = 0L;
            this.f2481j = 0L;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.f2485n)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i = this.f2474c;
        if (i == 1 || i == 2) {
            this.f2474c = 5;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
            this.f2485n = null;
            this.f2483l = false;
            this.f2474c = 0;
        }
    }

    public void downloadStarts() {
        if (this.f2474c == 1) {
            this.f2474c = 2;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent broadcast;
        PendingIntent pendingIntent;
        int i = this.f2475d;
        if (i != 0) {
            return Tasks.m4184a((Exception) new InstallException(i));
        }
        PendingIntent broadcast2 = (m3610a() == 2 && this.f2475d == 0) ? PendingIntent.getBroadcast(this.f2473b, 0, new Intent(), 0) : null;
        PendingIntent broadcast3 = (m3610a() == 2 && this.f2475d == 0) ? PendingIntent.getBroadcast(this.f2473b, 0, new Intent(), 0) : null;
        if (m3610a() == 2 && this.f2475d == 0) {
            PendingIntent broadcast4 = PendingIntent.getBroadcast(this.f2473b, 0, new Intent(), 0);
            broadcast = PendingIntent.getBroadcast(this.f2473b, 0, new Intent(), 0);
            pendingIntent = broadcast4;
        } else {
            broadcast = null;
            pendingIntent = null;
        }
        return Tasks.m4185a(AppUpdateInfo.m3581a(this.f2473b.getPackageName(), this.f2477f, m3610a(), this.f2474c, this.f2478g, this.f2479h, this.f2480i, this.f2481j, 0L, 0L, broadcast3, broadcast2, broadcast, pendingIntent));
    }

    @Nullable
    @AppUpdateType
    public Integer getTypeForUpdateInProgress() {
        return this.f2485n;
    }

    public void installCompletes() {
        if (this.f2474c == 3) {
            this.f2474c = 4;
            this.f2476e = false;
            this.f2477f = 0;
            this.f2478g = null;
            this.f2479h = 0;
            this.f2480i = 0L;
            this.f2481j = 0L;
            this.f2483l = false;
            this.f2484m = false;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
            this.f2485n = null;
            this.f2474c = 0;
        }
    }

    public void installFails() {
        if (this.f2474c == 3) {
            this.f2474c = 5;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
            this.f2485n = null;
            this.f2484m = false;
            this.f2483l = false;
            this.f2474c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.f2482k;
    }

    public boolean isImmediateFlowVisible() {
        return this.f2483l;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.f2484m;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f2472a.m4033a((StateUpdatedListener) installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j) {
        if (this.f2474c != 2 || j > this.f2481j) {
            return;
        }
        this.f2480i = j;
        Integer num = 0;
        if (num.equals(this.f2485n)) {
            m3612b();
        }
    }

    public void setClientVersionStalenessDays(@Nullable Integer num) {
        if (this.f2476e) {
            this.f2478g = num;
        }
    }

    public void setInstallErrorCode(@InstallErrorCode int i) {
        this.f2475d = i;
    }

    public void setTotalBytesToDownload(long j) {
        if (this.f2474c == 2) {
            this.f2481j = j;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
        }
    }

    public void setUpdateAvailable(int i) {
        this.f2476e = true;
        this.f2477f = i;
    }

    public void setUpdateNotAvailable() {
        this.f2476e = false;
        this.f2478g = null;
    }

    public void setUpdatePriority(int i) {
        if (this.f2476e) {
            this.f2479h = i;
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return m3611a(appUpdateInfo, appUpdateOptions) ? Tasks.m4185a(-1) : Tasks.m4184a((Exception) new InstallException(-6));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, Activity activity, int i2) {
        return m3611a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f2472a.m4036b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.f2482k || this.f2483l) {
            this.f2482k = false;
            this.f2474c = 1;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
        }
    }

    public void userCancelsDownload() {
        int i = this.f2474c;
        if (i == 1 || i == 2) {
            this.f2474c = 6;
            Integer num = 0;
            if (num.equals(this.f2485n)) {
                m3612b();
            }
            this.f2485n = null;
            this.f2483l = false;
            this.f2474c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.f2482k || this.f2483l) {
            this.f2482k = false;
            this.f2483l = false;
            this.f2485n = null;
            this.f2474c = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m3611a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.f2483l = true;
            i = 1;
        } else {
            this.f2482k = true;
            i = 0;
        }
        this.f2485n = i;
        return true;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return m3611a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) {
        return m3611a(appUpdateInfo, appUpdateOptions);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) {
        return m3611a(appUpdateInfo, appUpdateOptions);
    }
}
