package com.samsung.android.sdk.scs.p142ai.visual;

import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import com.samsung.android.sdk.scs.p142ai.gateway.LvmServiceExecutorContainer;
import com.samsung.android.sdk.scs.p142ai.gateway.LvmServiceExecutorFactory;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ImageEditorGenerator extends LvmServiceExecutorContainer {
    private static final String TAG = "ScsApi@ImageEditorGenerator";
    private final int mMode;
    private final AiServiceExecutorFactory.ServiceType mServiceType;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ImageEditorGenerator(@NonNull Context context, int i) {
        this(context, i, RequestType.CLOUD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(Task task) {
        super.release();
    }

    public Task<Boolean> cancel(@NonNull String str) {
        Log.m6485d(TAG, "cancel()");
        ImageEditorCancelRunnable imageEditorCancelRunnable = new ImageEditorCancelRunnable(getCancelServiceExecutor(this.mServiceType), this.mMode);
        imageEditorCancelRunnable.setTaskId(str);
        getCancelServiceExecutor(this.mServiceType).execute(imageEditorCancelRunnable);
        return imageEditorCancelRunnable.getTask();
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.LvmServiceExecutorContainer
    @NonNull
    public AiServiceExecutor<? extends IInterface> createCancelServiceExecutor(@NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        return new LvmServiceExecutorFactory(getContext()).createImageEditor(serviceType, ImageEditorParamUtils.getFeatureName(this.mMode, serviceType));
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorContainer
    @NonNull
    public AiServiceExecutor<? extends IInterface> createServiceExecutor(@NonNull AiServiceExecutorFactory.ServiceType serviceType) {
        return new LvmServiceExecutorFactory(getContext()).createImageEditor(serviceType, ImageEditorParamUtils.getFeatureName(this.mMode, serviceType));
    }

    public Task<ImageEditorResult> generate(@NonNull VisualAppInfo visualAppInfo, @NonNull Bundle bundle) {
        Log.m6485d(TAG, "generate())");
        ImageEditorGenerateRunnable imageEditorGenerateRunnable = new ImageEditorGenerateRunnable(getServiceExecutor(this.mServiceType), this.mMode);
        imageEditorGenerateRunnable.setAppInfo(visualAppInfo);
        imageEditorGenerateRunnable.setBundle(bundle);
        getServiceExecutor(this.mServiceType).execute(imageEditorGenerateRunnable);
        return imageEditorGenerateRunnable.getTask();
    }

    public Task<Boolean> prepare() {
        Log.m6485d(TAG, "prepare()");
        ImageEditorPrepareRunnable imageEditorPrepareRunnable = new ImageEditorPrepareRunnable(getServiceExecutor(this.mServiceType), this.mMode);
        getServiceExecutor(this.mServiceType).execute(imageEditorPrepareRunnable);
        return imageEditorPrepareRunnable.getTask();
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.LvmServiceExecutorContainer, com.samsung.android.sdk.scs.p142ai.gateway.executor.TemplateContainer
    public Task<Boolean> release() {
        Log.m6485d(TAG, "release()");
        ImageEditorReleaseRunnable imageEditorReleaseRunnable = new ImageEditorReleaseRunnable(getServiceExecutor(this.mServiceType), this.mMode);
        getServiceExecutor(this.mServiceType).execute(imageEditorReleaseRunnable);
        imageEditorReleaseRunnable.getTask().addOnCompleteListener(new C7737b(this, 7));
        return imageEditorReleaseRunnable.getTask();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ImageEditorGenerator(@NonNull Context context, int i, @NonNull RequestType requestType) {
        super(context);
        Log.m6485d(TAG, "ImageEditorGenerator");
        this.mMode = i;
        this.mServiceType = getServiceType(requestType);
    }
}
