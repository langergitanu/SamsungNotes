package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.meeting;

import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MeetingList extends Sentence {
    private final String mTextWithoutSpace;

    public MeetingList(Sentence sentence) {
        this(sentence.getIndex(), sentence.getText());
    }

    public boolean sameWith(String str) {
        return str.replace(" ", "").equals(this.mTextWithoutSpace);
    }

    public MeetingList(int i, String str) {
        super(i, str);
        this.mTextWithoutSpace = str.replace(" ", "");
    }
}
