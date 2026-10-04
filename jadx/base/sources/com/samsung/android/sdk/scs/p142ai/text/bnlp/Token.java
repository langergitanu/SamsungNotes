package com.samsung.android.sdk.scs.p142ai.text.bnlp;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Token extends AbstractRawTextHolder {
    protected String lemma;
    protected String mpTags;
    protected String posTag;
    protected String stem;

    public Token() {
    }

    public String getLemma() {
        return this.lemma;
    }

    public String getMpTags() {
        return this.mpTags;
    }

    public String getPosTag() {
        return this.posTag;
    }

    public String getStem() {
        return this.stem;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setLemma(String str) {
        this.lemma = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMpTags(String str) {
        this.mpTags = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPosTag(String str) {
        this.posTag = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStem(String str) {
        this.stem = str;
    }

    public String toString() {
        return this.rawText + "/" + this.posTag;
    }

    public Token(String str) {
        super(str);
    }

    public Token(String str, int i) {
        super(str, i);
    }

    public Token(String str, int i, String str2) {
        super(str, i);
        this.posTag = str2;
    }

    public Token(String str, int i, String str2, String str3, String str4) {
        super(str, i);
        this.posTag = str2;
        this.stem = str3;
        this.lemma = str4;
    }

    public Token(String str, int i, String str2, String str3, String str4, String str5) {
        super(str, i);
        this.posTag = str2;
        this.stem = str3;
        this.lemma = str4;
        this.mpTags = str5;
    }
}
