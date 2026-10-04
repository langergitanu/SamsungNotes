package com.samsung.android.support.senl.p148nt.app.main.common.data;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SearchWord;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HighlightText implements Serializable {
    private final Set<String> mKeywords = new HashSet();
    private final Set<String> mSourceWords = new HashSet();
    private final Set<String> mAdditionalWords = new HashSet();

    public void clear() {
        this.mKeywords.clear();
        this.mSourceWords.clear();
        this.mAdditionalWords.clear();
    }

    public List<String> getHighlightText() {
        return new ArrayList(this.mKeywords);
    }

    public boolean hasOnlySourceKeywords() {
        return this.mAdditionalWords.isEmpty();
    }

    public boolean isEmpty() {
        return this.mKeywords.isEmpty();
    }

    public void set(List<SearchWord> list) {
        for (SearchWord searchWord : list) {
            if (!TextUtils.isEmpty(searchWord.getWord())) {
                this.mSourceWords.add(searchWord.getWord());
            }
            if (!TextUtils.isEmpty(searchWord.getStemmedWord())) {
                this.mAdditionalWords.add(searchWord.getStemmedWord());
            }
            if (!searchWord.getSynonyms().isEmpty()) {
                this.mAdditionalWords.addAll(searchWord.getSynonyms());
            }
        }
        if (this.mAdditionalWords.isEmpty()) {
            this.mKeywords.addAll(this.mSourceWords);
        } else {
            this.mKeywords.addAll(this.mAdditionalWords);
        }
    }
}
