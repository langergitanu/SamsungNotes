package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SplitInstallSessionState {
    /* JADX INFO: renamed from: a */
    public static SplitInstallSessionState m4103a(Bundle bundle) {
        return new C5273a(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }

    public static SplitInstallSessionState create(int i, @SplitInstallSessionStatus int i2, @SplitInstallErrorCode int i4, long j, long j2, List<String> list, List<String> list2) {
        if (i2 != 8) {
            return new C5273a(i, i2, i4, j, j2, list, list2, null, null);
        }
        throw new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract List<String> mo4104a();

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract List<String> mo4105b();

    public abstract long bytesDownloaded();

    @Nullable
    /* JADX INFO: renamed from: c */
    public abstract List<Intent> mo4106c();

    @SplitInstallErrorCode
    public abstract int errorCode();

    public boolean hasTerminalStatus() {
        int iStatus = status();
        return iStatus == 0 || iStatus == 5 || iStatus == 6 || iStatus == 7;
    }

    @NonNull
    public List<String> languages() {
        return mo4105b() != null ? new ArrayList(mo4105b()) : new ArrayList();
    }

    @NonNull
    public List<String> moduleNames() {
        return mo4104a() != null ? new ArrayList(mo4104a()) : new ArrayList();
    }

    @Nullable
    @Deprecated
    public abstract PendingIntent resolutionIntent();

    public abstract int sessionId();

    @SplitInstallSessionStatus
    public abstract int status();

    public abstract long totalBytesToDownload();
}
