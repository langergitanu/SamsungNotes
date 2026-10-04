package com.samsung.android.sdk.mobileservice.social.feedback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Emotion {
    public static final int EMOTION_TYPE_LIKE = 0;
    public static final int EMOTION_TYPE_NONE = -1;
    private int mCount;
    private int mEmotionType;

    public Emotion(int i, int i2) {
        this.mEmotionType = i;
        this.mCount = i2;
    }

    public int getCount() {
        return this.mCount;
    }

    public int getEmotionType() {
        return this.mEmotionType;
    }
}
