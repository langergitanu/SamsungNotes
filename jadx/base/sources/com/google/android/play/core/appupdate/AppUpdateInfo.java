package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AppUpdateInfo {
    /* JADX INFO: renamed from: b */
    private final boolean m3582b(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && mo3583a() <= mo3585b();
    }

    /* JADX INFO: renamed from: a */
    public abstract long mo3583a();

    @Nullable
    /* JADX INFO: renamed from: a */
    public final PendingIntent m3584a(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() == 0) {
            if (mo3587d() != null) {
                return mo3587d();
            }
            if (m3582b(appUpdateOptions)) {
                return mo3589f();
            }
            return null;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            if (mo3586c() != null) {
                return mo3586c();
            }
            if (m3582b(appUpdateOptions)) {
                return mo3588e();
            }
        }
        return null;
    }

    public abstract int availableVersionCode();

    /* JADX INFO: renamed from: b */
    public abstract long mo3585b();

    public abstract long bytesDownloaded();

    @Nullable
    /* JADX INFO: renamed from: c */
    public abstract PendingIntent mo3586c();

    @Nullable
    public abstract Integer clientVersionStalenessDays();

    @Nullable
    /* JADX INFO: renamed from: d */
    public abstract PendingIntent mo3587d();

    @Nullable
    /* JADX INFO: renamed from: e */
    public abstract PendingIntent mo3588e();

    @Nullable
    /* JADX INFO: renamed from: f */
    public abstract PendingIntent mo3589f();

    @InstallStatus
    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(@AppUpdateType int i) {
        return m3584a(AppUpdateOptions.defaultOptions(i)) != null;
    }

    @NonNull
    public abstract String packageName();

    public abstract long totalBytesToDownload();

    @UpdateAvailability
    public abstract int updateAvailability();

    public abstract int updatePriority();

    /* JADX INFO: renamed from: a */
    public static AppUpdateInfo m3581a(@NonNull String str, int i, @UpdateAvailability int i2, @InstallStatus int i4, @Nullable Integer num, int i5, long j, long j2, long j3, long j5, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4) {
        return new C5010t(str, i, i2, i4, num, i5, j, j2, j3, j5, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    public boolean isUpdateTypeAllowed(@NonNull AppUpdateOptions appUpdateOptions) {
        return m3584a(appUpdateOptions) != null;
    }
}
