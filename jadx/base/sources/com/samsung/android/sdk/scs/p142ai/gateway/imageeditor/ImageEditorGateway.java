package com.samsung.android.sdk.scs.p142ai.gateway.imageeditor;

import android.os.Bundle;
import android.os.IInterface;
import com.samsung.android.aicore.sdkcommon.IOnDeviceService;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutor;
import com.samsung.android.sdk.scs.p142ai.gateway.aidl.IImageEditorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ImageEditorGateway implements IImageEditorService {
    private final AiServiceExecutor<? extends IInterface> mServiceExecutor;

    public ImageEditorGateway(AiServiceExecutor<? extends IInterface> aiServiceExecutor) {
        this.mServiceExecutor = aiServiceExecutor;
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.aidl.IImageEditorService
    public Bundle cancel(int i, Bundle bundle) {
        return this.mServiceExecutor.getService() instanceof IOnDeviceService ? ((IOnDeviceService) this.mServiceExecutor.getService()).cancel(i, bundle) : ((com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService) this.mServiceExecutor.getService()).cancel(i, bundle);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.aidl.IImageEditorService
    public Bundle generate(int i, Bundle bundle) {
        return this.mServiceExecutor.getService() instanceof IOnDeviceService ? ((IOnDeviceService) this.mServiceExecutor.getService()).generate(i, bundle) : ((com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService) this.mServiceExecutor.getService()).generate(i, bundle);
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.aidl.IImageEditorService
    public void prepare(int i) {
        if (this.mServiceExecutor.getService() instanceof IOnDeviceService) {
            ((IOnDeviceService) this.mServiceExecutor.getService()).prepare(i);
        } else {
            ((com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService) this.mServiceExecutor.getService()).prepare(i);
        }
    }

    @Override // com.samsung.android.sdk.scs.p142ai.gateway.aidl.IImageEditorService
    public void release(int i) {
        if (this.mServiceExecutor.getService() instanceof IOnDeviceService) {
            ((IOnDeviceService) this.mServiceExecutor.getService()).release(i);
        } else {
            ((com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService) this.mServiceExecutor.getService()).release(i);
        }
    }
}
