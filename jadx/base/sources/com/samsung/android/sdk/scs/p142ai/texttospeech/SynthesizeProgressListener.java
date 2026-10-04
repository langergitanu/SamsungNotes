package com.samsung.android.sdk.scs.p142ai.texttospeech;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SynthesizeProgressListener {
    public abstract void onDone(String str);

    public abstract void onError(String str, int i);

    public abstract void onProgress(String str, byte[] bArr, int i, int i2);

    public abstract void onRangeStart(String str, int i, int i2, int i4);

    public abstract void onStart(String str, int i, int i2, int i4);
}
