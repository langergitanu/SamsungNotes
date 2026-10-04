package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components;

import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MatchableSentence extends Sentence {
    public static final int ADDED = 1000;
    public static final int EXIST_IN_DETAIL = 100;
    public static final int EXIST_IN_SUBHEADING = 10;
    public static final int EXIST_IN_TITLE = 1;
    public static final int MISSED = 0;
    public static final int REPLACED_DETAIL = 101;
    public static final int REPLACED_SUB_HEADING = 11;
    public static final int REPLACED_TITLE = 2;
    private int mMask;

    public MatchableSentence(Sentence sentence) {
        super(sentence.getIndex(), sentence.getText());
        this.mMask = 0;
    }

    public int getMask() {
        return this.mMask;
    }

    public void reset() {
        this.mMask = 0;
    }

    public void setMask(int i) {
        this.mMask = i;
    }
}
