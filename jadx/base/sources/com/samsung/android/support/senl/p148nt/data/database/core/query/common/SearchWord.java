package com.samsung.android.support.senl.p148nt.data.database.core.query.common;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchWord {
    private String mStemmedWord = "";
    private final Set<String> mSynonyms = new HashSet();
    private final String mWord;

    public SearchWord(@NonNull String str) {
        this.mWord = str;
    }

    @NonNull
    private String removeSpace(@NonNull String str) {
        return str.replace(" ", "");
    }

    public void addSynonyms(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            this.mSynonyms.add(removeSpace(it.next()));
        }
    }

    @NonNull
    public String getStemmedWord() {
        return this.mStemmedWord;
    }

    @NonNull
    public Set<String> getSynonyms() {
        return this.mSynonyms;
    }

    @NonNull
    public String getWord() {
        return this.mWord;
    }

    public boolean isValidStemmedWord() {
        return !this.mStemmedWord.isEmpty();
    }

    public void setStemmedWord(@NonNull String str) {
        this.mStemmedWord = removeSpace(str);
    }
}
