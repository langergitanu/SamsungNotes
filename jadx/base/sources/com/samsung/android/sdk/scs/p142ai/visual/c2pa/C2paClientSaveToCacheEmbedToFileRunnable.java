package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paParam;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paResult;
import com.samsung.android.visual.p167ai.sdkcommon.IC2paEmbedCallback;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C2paClientSaveToCacheEmbedToFileRunnable extends TaskRunnable<C2paResult> {
    private static final String TAG = "C2paClientSaveToCacheEmbedToFileRunnable";
    IC2paEmbedCallback mCallback = new IC2paEmbedCallback.Stub() { // from class: com.samsung.android.sdk.scs.ai.visual.c2pa.C2paClientSaveToCacheEmbedToFileRunnable.1
        @Override // com.samsung.android.visual.p167ai.sdkcommon.IC2paEmbedCallback
        public void onError(String str) {
            ((TaskRunnable) C2paClientSaveToCacheEmbedToFileRunnable.this).mSource.setResult(new C2paResult.Builder().setSuccess(false).setError(str).build());
        }

        @Override // com.samsung.android.visual.p167ai.sdkcommon.IC2paEmbedCallback
        public void onSuccess() {
            ((TaskRunnable) C2paClientSaveToCacheEmbedToFileRunnable.this).mSource.setResult(new C2paResult.Builder().setSuccess(true).build());
        }
    };
    List<String> mIngredientPaths;
    private String mJsonStr;
    String mParentPath;
    private final C2paServiceExecutor mServiceExecutor;
    private String mTargetPath;

    public C2paClientSaveToCacheEmbedToFileRunnable(@NonNull C2paServiceExecutor c2paServiceExecutor) {
        this.mServiceExecutor = c2paServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        Log.m6485d(TAG, "execute embedManifestToFile()");
        try {
            String fileExtension = C2paUtils.getFileExtension(this.mParentPath);
            ParcelFileDescriptor parcelFileDescriptor = C2paUtils.getParcelFileDescriptor(this.mParentPath);
            ParcelFileDescriptor parcelFileDescriptor2 = C2paUtils.getParcelFileDescriptor(this.mTargetPath);
            String fileExtension2 = C2paUtils.getFileExtension(this.mTargetPath);
            if (parcelFileDescriptor2 != null && parcelFileDescriptor != null && fileExtension != null && fileExtension2 != null && this.mJsonStr != null && this.mTargetPath != null && this.mParentPath != null) {
                String strSaveManifestsToCacheWithPfd = this.mServiceExecutor.getC2PAService().saveManifestsToCacheWithPfd(new C2paParam.SaveToCacheParamBuilder().setPfd(parcelFileDescriptor).setExtensionType(fileExtension).setFilePath(this.mParentPath).build());
                C2paParam.EmbedParamBuilder targetPath = new C2paParam.EmbedParamBuilder().setManifestJson(this.mJsonStr).setTargetPFD(parcelFileDescriptor2).setTargetExtensionType(fileExtension2).setTargetPath(this.mTargetPath);
                List<String> list = null;
                C2paParam.EmbedParamBuilder parentPath = targetPath.setParentPFD(strSaveManifestsToCacheWithPfd == null ? null : C2paUtils.getParcelFileDescriptor(strSaveManifestsToCacheWithPfd)).setParentExtensionType(strSaveManifestsToCacheWithPfd == null ? null : C2paUtils.getFileExtension(strSaveManifestsToCacheWithPfd)).setParentPath(strSaveManifestsToCacheWithPfd);
                List<String> list2 = this.mIngredientPaths;
                C2paParam.EmbedParamBuilder ingredientPFD = parentPath.setIngredientPFD(list2 == null ? null : (List) list2.stream().map(new C4662f(23)).collect(Collectors.toList()));
                List<String> list3 = this.mIngredientPaths;
                if (list3 != null) {
                    list = (List) list3.stream().map(new C4662f(24)).collect(Collectors.toList());
                }
                this.mServiceExecutor.getC2PAService().embedManifestToPfd(ingredientPFD.setIngredientExtensionTypes(list).setIngredientPaths(this.mIngredientPaths).build(), this.mCallback);
                return;
            }
            if (parcelFileDescriptor2 != null) {
                try {
                    if (parcelFileDescriptor2.getFileDescriptor().valid()) {
                        parcelFileDescriptor2.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (parcelFileDescriptor != null && parcelFileDescriptor.getFileDescriptor().valid()) {
                parcelFileDescriptor.close();
            }
            throw new NullPointerException("Target PFD/Extension/JSON is NULL");
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mSource.setException(e2);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_C2PA";
    }

    public void setIngredientPaths(@Nullable List<String> list) {
        this.mIngredientPaths = list;
    }

    public void setJson(@NonNull String str) {
        this.mJsonStr = str;
    }

    public void setParentPath(@NonNull String str) {
        this.mParentPath = str;
    }

    public void setTargetPath(@NonNull String str) {
        this.mTargetPath = str;
    }
}
