package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components;

import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DetailSentence extends Sentence {
    public static final int EXISTS = 1;
    public static final int NOT_EXIST = -1;
    public static final int UNKNOWN = 0;
    private int mExistsInSourceText;
    private final List<MatchableSentence> mMatchedSentences;

    public DetailSentence(Sentence sentence) {
        this(sentence.getIndex(), sentence.getText());
    }

    public boolean existsInMatchedSentences(String str) {
        Iterator<MatchableSentence> it = this.mMatchedSentences.iterator();
        while (it.hasNext()) {
            if (it.next().getText().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int getExistsInSourceText() {
        return this.mExistsInSourceText;
    }

    public List<MatchableSentence> getMatchedSentences() {
        return this.mMatchedSentences;
    }

    public void setExistsInSourceText(int i) {
        this.mExistsInSourceText = i;
    }

    public DetailSentence(int i, String str) {
        super(i, str);
        this.mMatchedSentences = new ArrayList();
        this.mExistsInSourceText = 0;
    }
}
