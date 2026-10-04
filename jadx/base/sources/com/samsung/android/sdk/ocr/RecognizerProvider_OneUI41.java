package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.android.sdk.pen.ocr.SpenOcrLanguage;
import com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerProvider_OneUI41 extends RecognizerProvider {
    private static final String TAG = "RecognizerProvider_OneUI41";

    public RecognizerProvider_OneUI41(RecognizerParams recognizerParams, RecognizerSupporter recognizerSupporter) {
        super(recognizerParams, recognizerSupporter);
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerProvider
    public void createSOCRRecognizer(RecognizerParams recognizerParams) {
        if (this.mEngine.isSupportedLanguage(SpenOcrLanguage.from(recognizerParams.language))) {
            this.mSOCRecognizer = new SOCRecognizer_OneUI41(this.mEngine, recognizerParams);
            return;
        }
        Log.w(TAG, "SOCRecognizer does not support language(" + recognizerParams.language.toString() + ")");
        this.mSOCRecognizer = null;
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerProvider
    public boolean isHandwritten(Bitmap bitmap) {
        return isHandwritten(this.mDataConverter.resizeBitmap(bitmap), true);
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerProvider
    public boolean isPrinted(Bitmap bitmap) {
        Log.e(TAG, "This API should not be called(It supports above One UI 4.1)");
        return false;
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerProvider
    public SpenOcrModelLoaderFactory.MODEL_LOADER whichModelLoader(boolean z) {
        return z ? SpenOcrModelLoaderFactory.MODEL_LOADER.ASSETS : SpenOcrModelLoaderFactory.MODEL_LOADER.ONEUI41;
    }

    private boolean isHandwritten(Bitmap bitmap, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zIsHandwrittenImage = z ? this.mClassifier.isHandwrittenImage(this.mDataConverter.resizeBitmap(bitmap)) : this.mClassifier.isHandwrittenImage(bitmap);
        Log.i(TAG, String.format("Type Classification(handwritten=%s), Time: %d ms", Boolean.toString(zIsHandwrittenImage), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return zIsHandwrittenImage;
    }
}
