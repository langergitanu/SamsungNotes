package com.samsung.android.imagetranslation;

import android.graphics.Bitmap;
import com.samsung.android.imagetranslation.data.MaskResponse;
import com.samsung.android.imagetranslation.inpainting.InpainterResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface TaskListener {
    void onFailure(int i, int i2);

    void onInpaintingSuccess(int i, InpainterResult inpainterResult);

    void onMaskAvailable(int i, MaskResponse maskResponse);

    void onRenderSuccess(int i, Bitmap bitmap);
}
