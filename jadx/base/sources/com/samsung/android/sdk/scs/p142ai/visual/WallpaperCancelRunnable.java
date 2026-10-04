package com.samsung.android.sdk.scs.p142ai.visual;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class WallpaperCancelRunnable extends TaskRunnable<Boolean> {
    private static final String TAG = "WallpaperCancelRunnable";
    WallpaperServiceExecutor mServiceExecutor;
    private String mTaskId;

    public WallpaperCancelRunnable(@NonNull WallpaperServiceExecutor wallpaperServiceExecutor) {
        this.mServiceExecutor = wallpaperServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void setResult(Bundle bundle) {
        if (bundle == null) {
            Log.m6487e(TAG, "generate(). retBundle is null!!");
            AbstractC6670b.m4749j(5, "retBundle is null", this.mSource);
            return;
        }
        int i = bundle.getInt("resultCode");
        if (i == 1) {
            this.mSource.setResult((TResult) Boolean.TRUE);
            return;
        }
        AbstractC6670b.m4750k(i, "cancel(). Abnormal resultCode!!! resultCode: ", TAG);
        if (i == 500) {
            AbstractC6670b.m4748i(500, this.mSource);
        } else {
            this.mSource.setException(new ResultException(2000, Integer.toString(i)));
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6489i(TAG, "execute");
        try {
            Bundle bundle = new Bundle();
            bundle.putString("taskId", this.mTaskId);
            setResult(this.mServiceExecutor.getWallpaperService().cancel(bundle));
        } catch (RemoteException e) {
            Log.m6487e(TAG, "Exception : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_WALLPAPER";
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }
}
