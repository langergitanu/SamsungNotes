package com.samsung.android.sdk.scs.p142ai.text.bnlp;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Sentence extends AbstractRawTextHolder {
    protected List<Word> wordList;

    public Sentence() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void addWord(Word word) {
        if (this.wordList == null) {
            this.wordList = new ArrayList();
        }
        this.wordList.add(word);
    }

    public List<Word> getWordList() {
        return this.wordList;
    }

    public int indexOf(Word word) {
        List<Word> list = this.wordList;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Word word2 = this.wordList.get(i);
            if (word2.getPosition() == word.getPosition() && word2.getRawText().equals(word.getRawText())) {
                return i;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setWordList(List<Word> list) {
        this.wordList = list;
    }

    public String toString() {
        return this.rawText;
    }

    public Sentence(String str) {
        super(str);
    }

    public Sentence(String str, int i) {
        super(str, i);
    }

    public Sentence(String str, int i, List<Word> list) {
        super(str, i);
        this.wordList = list;
    }
}
