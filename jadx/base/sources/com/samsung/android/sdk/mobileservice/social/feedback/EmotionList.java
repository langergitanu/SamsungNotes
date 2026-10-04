package com.samsung.android.sdk.mobileservice.social.feedback;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class EmotionList {
    private List<Emotion> mEmotions;
    private int mMyEmotionType;

    public EmotionList(int i, List<Emotion> list) {
        this.mMyEmotionType = i;
        this.mEmotions = list;
    }

    public List<Emotion> getEmotions() {
        return this.mEmotions;
    }

    public int getMyEmotionType() {
        return this.mMyEmotionType;
    }
}
