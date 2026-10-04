package com.samsung.android.sdk.ocr;

import android.util.Log;
import com.samsung.android.sdk.pen.ocr.SpenOcrLanguage;
import com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerProvider_OneUI411 extends RecognizerProvider {
    private static final String TAG = "RecognizerProvider_OneUI411";

    public RecognizerProvider_OneUI411(RecognizerParams recognizerParams, RecognizerSupporter recognizerSupporter) {
        super(recognizerParams, recognizerSupporter);
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerProvider
    public void createSOCRRecognizer(RecognizerParams recognizerParams) {
        if (this.mEngine.isSupportedLanguage(SpenOcrLanguage.from(recognizerParams.language))) {
            this.mSOCRecognizer = new SOCRecognizer_OneUI411(this.mEngine, recognizerParams);
            return;
        }
        Log.w(TAG, "SOCRecognizer does not support language(" + recognizerParams.language.toString() + ")");
        this.mSOCRecognizer = null;
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerProvider
    public SpenOcrModelLoaderFactory.MODEL_LOADER whichModelLoader(boolean z) {
        return z ? SpenOcrModelLoaderFactory.MODEL_LOADER.ASSETS : SpenOcrModelLoaderFactory.MODEL_LOADER.PROVIDER_ONEUI411;
    }
}
