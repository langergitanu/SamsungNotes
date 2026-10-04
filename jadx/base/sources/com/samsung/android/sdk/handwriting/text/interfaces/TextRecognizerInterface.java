package com.samsung.android.sdk.handwriting.text.interfaces;

import com.samsung.android.sdk.handwriting.text.TextRecognizer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface TextRecognizerInterface {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EventListener {
        void onResult(int i, ResultInterface resultInterface);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultInterface {
        String[] getCandidates();

        int getEndPointOffset(int i);

        int getEndStrokeIndex(int i);

        int getStartPointOffset(int i);

        int getStartStrokeIndex(int i);
    }

    void addStroke(float[] fArr, float[] fArr2);

    void addStroke(float[] fArr, float[] fArr2, int i);

    void addStroke(int[] iArr, int[] iArr2);

    void addStroke(int[] iArr, int[] iArr2, int i);

    void cancel();

    void clearStrokes();

    void dispose();

    List<String> getSupportedLanguages();

    ResultInterface recognize();

    void removeStroke(int i);

    void request();

    void setAsyncMode(boolean z);

    void setBaseline(int i, int i2);

    void setLanguage(String str);

    void setLanguageData(String str, byte[] bArr, byte[] bArr2);

    void setListener(EventListener eventListener);

    void setPositiveScaleIndicator(float f, float f4, float f5);

    void setRecognitionMode(TextRecognizer.RecognitionMode recognitionMode);

    void setRecognitionType(TextRecognizer.RecognitionType recognitionType);

    void setStrokeMode(boolean z);

    void setUserDictionary(List<String> list);
}
