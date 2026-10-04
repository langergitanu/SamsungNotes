package com.samsung.android.sdk.scs.p142ai.visual;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class WallpaperGenerator {
    private static final String TAG = "ScsApi@WallpaperGenerator";
    private final WallpaperServiceExecutor mCancelServiceExecutor;
    private final WallpaperServiceExecutor mMainServiceExecutor;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public WallpaperGenerator(@NonNull Context context) {
        Log.m6485d(TAG, "WallpaperGenerator");
        this.mMainServiceExecutor = new WallpaperServiceExecutor(context);
        this.mCancelServiceExecutor = new WallpaperServiceExecutor(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(Task task) {
        this.mMainServiceExecutor.deInit();
        this.mCancelServiceExecutor.deInit();
    }

    public Task<Boolean> cancel(@NonNull String str) {
        Log.m6485d(TAG, "cancel()");
        WallpaperCancelRunnable wallpaperCancelRunnable = new WallpaperCancelRunnable(this.mCancelServiceExecutor);
        wallpaperCancelRunnable.setTaskId(str);
        this.mCancelServiceExecutor.execute(wallpaperCancelRunnable);
        return wallpaperCancelRunnable.getTask();
    }

    public Task<WallpaperResult> generate(@NonNull Bundle bundle) {
        Log.m6485d(TAG, "generate()");
        WallpaperGenerateRunnable wallpaperGenerateRunnable = new WallpaperGenerateRunnable(this.mMainServiceExecutor);
        wallpaperGenerateRunnable.setBundle(bundle);
        this.mMainServiceExecutor.execute(wallpaperGenerateRunnable);
        return wallpaperGenerateRunnable.getTask();
    }

    public Task<Boolean> prepare() {
        Log.m6485d(TAG, "prepare()");
        WallpaperPrepareRunnable wallpaperPrepareRunnable = new WallpaperPrepareRunnable(this.mMainServiceExecutor);
        this.mMainServiceExecutor.execute(wallpaperPrepareRunnable);
        return wallpaperPrepareRunnable.getTask();
    }

    public Task<Boolean> release() {
        Log.m6485d(TAG, "release()");
        WallpaperReleaseRunnable wallpaperReleaseRunnable = new WallpaperReleaseRunnable(this.mMainServiceExecutor);
        this.mMainServiceExecutor.execute(wallpaperReleaseRunnable);
        wallpaperReleaseRunnable.getTask().addOnCompleteListener(new C7737b(this, 8));
        return wallpaperReleaseRunnable.getTask();
    }
}
