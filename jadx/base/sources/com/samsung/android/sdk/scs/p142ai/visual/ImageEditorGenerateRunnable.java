package com.samsung.android.sdk.scs.p142ai.visual;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.gateway.imageeditor.ImageEditorGateway;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ImageEditorGenerateRunnable extends TaskRunnable<ImageEditorResult> {
    private static final String TAG = "ImageEditorGenerateRunnable";
    private VisualAppInfo mAppInfo;
    private final int mMode;
    private final Bundle mRequestBundle = new Bundle();
    private final AiServiceExecutor<? extends IInterface> mServiceExecutor;

    public ImageEditorGenerateRunnable(@NonNull AiServiceExecutor<? extends IInterface> aiServiceExecutor, int i) {
        this.mServiceExecutor = aiServiceExecutor;
        this.mMode = i;
    }

    private void integrateSingleOutputToList(@NonNull Bundle bundle) {
        Parcelable parcelable;
        if (bundle.containsKey(ImageConst.KEY_PARAM_OUTPUT_BITMAP) && (parcelable = bundle.getParcelable(ImageConst.KEY_PARAM_OUTPUT_BITMAP)) != null) {
            ArrayList<? extends Parcelable> parcelableArrayList = bundle.containsKey(ImageEditorConst.KEY_PARAM_OUTPUT_BITMAP_LIST) ? bundle.getParcelableArrayList(ImageEditorConst.KEY_PARAM_OUTPUT_BITMAP_LIST) : null;
            if (parcelableArrayList == null) {
                parcelableArrayList = new ArrayList<>();
            }
            parcelableArrayList.add(parcelable);
            bundle.putParcelableArrayList(ImageEditorConst.KEY_PARAM_OUTPUT_BITMAP_LIST, parcelableArrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private void setResult(@Nullable Bundle bundle) {
        if (bundle == null) {
            Log.m6487e(TAG, "generate(). retBundle is null!!");
            AbstractC6670b.m4749j(5, "retBundle is null", this.mSource);
            return;
        }
        ImageEditorResult imageEditorResult = new ImageEditorResult();
        int i = bundle.getInt("resultCode");
        imageEditorResult.setResult(i);
        if (i == 1) {
            integrateSingleOutputToList(bundle);
            imageEditorResult.setBundle(bundle);
            this.mSource.setResult((TResult) imageEditorResult);
            return;
        }
        AbstractC6670b.m4750k(i, "generate(). Abnormal resultCode!!! resultCode: ", TAG);
        if (i == 500) {
            AbstractC6670b.m4748i(500, this.mSource);
            return;
        }
        this.mSource.setException(new VisualResultErrorException(bundle.getInt("errorCode", VisualErrorCode.NOT_SPECIFIED.getCode()), bundle.getString("errorMessage", "")));
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "generate()");
        if (getBundle() == null) {
            AbstractC6670b.m4748i(700, this.mSource);
            return;
        }
        try {
            ImageEditorParamUtils.toBundle(getBundle(), this.mAppInfo);
            ImageEditorParamUtils.transformBitmapsInBundle(getBundle());
            getBundle().putString("taskId", getTask().getTaskId());
            setResult(new ImageEditorGateway(this.mServiceExecutor).generate(getMode(), new Bundle(getBundle())));
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    public Bundle getBundle() {
        return this.mRequestBundle;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return ImageEditorParamUtils.getFeatureName(getMode(), this.mServiceExecutor.getServiceType(), getBundle());
    }

    public int getMode() {
        return this.mMode;
    }

    public void setAppInfo(@NonNull VisualAppInfo visualAppInfo) {
        this.mAppInfo = visualAppInfo;
    }

    public void setBundle(@NonNull Bundle bundle) {
        this.mRequestBundle.putAll(bundle);
    }
}
