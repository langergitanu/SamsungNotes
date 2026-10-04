package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Title {
    private String mText = "";
    private int mWordCount = 0;
    public final List<MatchableSentence> mMatchedSentences = new ArrayList();

    public boolean exists() {
        return this.mText.length() > 0;
    }

    public int getLength() {
        return this.mText.length();
    }

    public String getText() {
        return this.mText;
    }

    public int getWordCount() {
        return this.mWordCount;
    }

    public void setText(String str) {
        this.mText = str;
        this.mWordCount = str.split(" ").length;
    }
}
