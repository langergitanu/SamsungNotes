package com.samsung.android.sdk.handwriting.text.impl;

import com.samsung.android.sdk.handwriting.text.impl.TextRecognizerImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TextRecognizerLib {
    private long engine = 0;

    private native void VIHW_AddStroke(long j, float[] fArr, float[] fArr2, int i);

    private native void VIHW_AddStroke(long j, int[] iArr, int[] iArr2, int i);

    private native void VIHW_ClearStrokes(long j);

    private native int VIHW_GenerateAndSave(long j, String str, String str2);

    private native TextRecognizerResultInfo VIHW_GetCharResultInfo(long j);

    private native long VIHW_GetDBVersion(String str);

    private native String VIHW_GetResult(long j, int i);

    private native int VIHW_GetResultCount(long j);

    private native String[] VIHW_GetResultList(long j);

    private native float[] VIHW_GetScoreList(long j);

    private native void VIHW_GetWordInfo(long j, int i, int[] iArr, int[] iArr2, int[] iArr3);

    private native long VIHW_Init();

    private native boolean VIHW_IsValidDB(String str);

    private native int VIHW_Recognize(long j);

    private native void VIHW_Release(long j);

    private native void VIHW_RemoveStroke(long j, int i);

    private native void VIHW_SetAsyncMode(long j, boolean z);

    private native void VIHW_SetBaseline(long j, int i, int i2);

    private native int VIHW_SetLanguage(long j, String str, String str2, String str3);

    private native int VIHW_SetLanguage(long j, byte[] bArr, byte[] bArr2, String str);

    private native void VIHW_SetListener(long j, TextRecognizerImpl.TextRecognizerImplListener textRecognizerImplListener);

    private native int VIHW_SetRecogMode(long j, String str);

    private native int VIHW_SetRecogType(long j, String str);

    private native void VIHW_SetStopAsync(long j);

    private native void VIHW_SetStrokeMode(long j, boolean z);

    private native int VIHW_SetUserDictMode(long j, String str);

    private native int VIHW_SetUserDictionary(long j, String[] strArr);

    public void addStroke(float[] fArr, float[] fArr2, int i) {
        VIHW_AddStroke(this.engine, fArr, fArr2, i);
    }

    public void clearStrokes() {
        VIHW_ClearStrokes(this.engine);
    }

    public TextRecognizerResultInfo getCharResultInfo() {
        return VIHW_GetCharResultInfo(this.engine);
    }

    public long getDBVersion(String str) {
        return VIHW_GetDBVersion(str);
    }

    public String getResult(int i) {
        return VIHW_GetResult(this.engine, i);
    }

    public int getResultCount() {
        return VIHW_GetResultCount(this.engine);
    }

    public String[] getResultList() {
        return VIHW_GetResultList(this.engine);
    }

    public float[] getScoreList() {
        return VIHW_GetScoreList(this.engine);
    }

    public long init() {
        long jVIHW_Init = VIHW_Init();
        this.engine = jVIHW_Init;
        return jVIHW_Init;
    }

    public boolean isValidDB(String str) {
        return VIHW_IsValidDB(str);
    }

    public int recognize() {
        return VIHW_Recognize(this.engine);
    }

    public void release() {
        long j = this.engine;
        if (j != 0) {
            VIHW_Release(j);
        }
        this.engine = 0L;
    }

    public void removeStroke(int i) {
        VIHW_RemoveStroke(this.engine, i);
    }

    public void setAsyncMode(boolean z) {
        VIHW_SetAsyncMode(this.engine, z);
    }

    public void setBaseline(int i, int i2) {
        VIHW_SetBaseline(this.engine, i, i2);
    }

    public int setLanguage(String str, String str2, String str3) {
        return VIHW_SetLanguage(this.engine, str, str2, str3);
    }

    public void setListener(TextRecognizerImpl.TextRecognizerImplListener textRecognizerImplListener) {
        VIHW_SetListener(this.engine, textRecognizerImplListener);
    }

    public int setRecogMode(String str) {
        return VIHW_SetRecogMode(this.engine, str);
    }

    public int setRecogType(String str) {
        return VIHW_SetRecogType(this.engine, str);
    }

    public void setStopAsync() {
        VIHW_SetStopAsync(this.engine);
    }

    public void setStrokeMode(boolean z) {
        VIHW_SetStrokeMode(this.engine, z);
    }

    public int setUserDictionary(String[] strArr) {
        return VIHW_SetUserDictionary(this.engine, strArr);
    }

    public void addStroke(int[] iArr, int[] iArr2, int i) {
        VIHW_AddStroke(this.engine, iArr, iArr2, i);
    }

    public int setLanguage(byte[] bArr, byte[] bArr2, String str) {
        return VIHW_SetLanguage(this.engine, bArr, bArr2, str);
    }
}
