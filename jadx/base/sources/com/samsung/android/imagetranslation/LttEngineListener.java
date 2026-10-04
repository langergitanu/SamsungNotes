package com.samsung.android.imagetranslation;

import android.graphics.Bitmap;
import com.samsung.android.imagetranslation.data.MaskResponse;
import com.samsung.android.imagetranslation.inpainting.InpainterResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface LttEngineListener {
    void onFailure(int i, int i2);

    void onInPaintingSuccess(int i, InpainterResult inpainterResult);

    default void onMaskAvailable(int i, MaskResponse maskResponse) {
    }

    default void onMessageReceived(int i, Object obj) {
    }

    default void onRenderFailure(String str) {
    }

    void onRenderSuccess(int i, Bitmap bitmap);

    default void onRenderSuccess(Bitmap bitmap) {
    }
}
