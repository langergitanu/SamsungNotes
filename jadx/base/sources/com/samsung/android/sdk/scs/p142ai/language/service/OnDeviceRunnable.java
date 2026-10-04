package com.samsung.android.sdk.scs.p142ai.language.service;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.TaskRunnable;
import com.samsung.android.sdk.scs.p142ai.language.AppInfo;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
@Deprecated
public class OnDeviceRunnable extends TaskRunnable<Result> {
    private static final String TAG = "OnDeviceRunnable";
    Map<String, String> authHeader;
    OnDeviceServiceExecutor mServiceExecutor;

    public OnDeviceRunnable(@NonNull OnDeviceServiceExecutor onDeviceServiceExecutor) {
        this.mServiceExecutor = onDeviceServiceExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public void execute() {
        try {
            this.mServiceExecutor.getService().unLoadModel();
            this.mSource.setResult((TResult) new Result(new Bundle()));
        } catch (RemoteException e) {
            e.printStackTrace();
            this.mSource.setException(e);
        }
    }

    public Map<String, String> getAuthHeader() {
        return this.authHeader;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.TaskRunnable
    public String getFeatureName() {
        return "FEATURE_SIVS_CONFIGURATION";
    }

    public void setAppInfo(AppInfo appInfo) {
        this.authHeader = new AuthHeader(appInfo).generateHeaderMap(this.mServiceExecutor.context);
    }
}
