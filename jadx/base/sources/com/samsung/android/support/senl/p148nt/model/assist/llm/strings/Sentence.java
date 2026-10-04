package com.samsung.android.support.senl.p148nt.model.assist.llm.strings;

import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Sentence {
    private int mIndex;
    private String mText = "";
    private String[] mWords;

    public Sentence(int i, String str) {
        setIndex(i);
        setText(str);
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getLength() {
        return this.mText.length();
    }

    public String getText() {
        return this.mText;
    }

    public int getWordCount() {
        String[] strArr = this.mWords;
        if (strArr == null) {
            return 0;
        }
        return strArr.length;
    }

    public String[] getWords() {
        return this.mWords;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public void setText(String str) {
        this.mText = str;
        this.mWords = new UnicodeUtils.Builder(str).replace(UnicodeUtils.NBSP, " ").replace("\u200b", " ").getText().split(" ");
    }
}
