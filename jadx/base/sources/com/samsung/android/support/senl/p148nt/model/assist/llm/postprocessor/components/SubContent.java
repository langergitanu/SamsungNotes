package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SubContent {
    private String mHeader = "";
    private int mWordCount = 0;
    public final List<MatchableSentence> mMatchedSentences = new ArrayList();
    public List<DetailSentence> mDetails = new ArrayList();

    public String getHeader() {
        return this.mHeader;
    }

    public int getHeaderLength() {
        return this.mHeader.length();
    }

    public int getHeaderWordCount() {
        return this.mWordCount;
    }

    public void setHeader(String str) {
        this.mHeader = str;
        this.mWordCount = str.split(" ").length;
    }
}
