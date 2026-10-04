package com.samsung.android.sdk.scs.p142ai.visual;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class WallpaperGenerateRunnable extends TaskRunnable<WallpaperResult> {
    private static final String TAG = "WallpaperGenerateRunnable";
    private Bitmap mAlphaBitmap;
    private Bitmap mInputBitmap;
    private Bundle mInputBundle;
    private String mInputType;
    private int mPriority;
    private final WallpaperServiceExecutor mServiceExecutor;
    private String mTime;
    private String mWeather;

    public WallpaperGenerateRunnable(@NonNull WallpaperServiceExecutor wallpaperServiceExecutor) {
        this.mServiceExecutor = wallpaperServiceExecutor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void setResult(Bundle bundle) {
        if (bundle == null) {
            Log.m6487e(TAG, "generate(). retBundle is null!!");
            AbstractC6670b.m4749j(5, "retBundle is null", this.mSource);
            return;
        }
        WallpaperResult wallpaperResult = new WallpaperResult();
        int i = bundle.getInt("resultCode");
        wallpaperResult.setResult(i);
        if (i == 1) {
            wallpaperResult.setBundle(bundle);
            this.mSource.setResult((TResult) wallpaperResult);
            return;
        }
        AbstractC6670b.m4750k(i, "generate(). Abnormal resultCode!!! resultCode: ", TAG);
        if (i == 500) {
            AbstractC6670b.m4748i(500, this.mSource);
        } else {
            this.mSource.setException(new ResultException(2000, Integer.toString(i)));
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            if (getBundle() == null && this.mInputBitmap == null) {
                this.mSource.setException(new ResultException(700));
                return;
            }
            if (getBundle() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("time", this.mTime);
                bundle.putString(ImageConst.KEY_PARAM_WEATHER, this.mWeather);
                bundle.putInt("priority", this.mPriority);
                bundle.putString("inputType", this.mInputType);
                bundle.putParcelable("inputBitmap", this.mInputBitmap);
                bundle.putParcelable("alphaBitmap", this.mAlphaBitmap);
                setBundle(bundle);
            }
            Log.m6485d(TAG, "execute(), mInputType : " + getBundle().getString("inputType"));
            getBundle().putString("taskId", getTask().getTaskId());
            ImageEditorParamUtils.transformBitmapsInBundle(getBundle());
            setResult(this.mServiceExecutor.getWallpaperService().generate(new Bundle(getBundle())));
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    public Bundle getBundle() {
        return this.mInputBundle;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_WALLPAPER";
    }

    public void setBundle(Bundle bundle) {
        this.mInputBundle = bundle;
    }

    public void setInBitmap(Bitmap bitmap, Bitmap bitmap2, String str, String str2, int i) {
        this.mInputBitmap = bitmap;
        this.mAlphaBitmap = bitmap2;
        this.mTime = str;
        this.mWeather = str2;
        this.mPriority = i;
        this.mInputType = "bitmap";
    }
}
