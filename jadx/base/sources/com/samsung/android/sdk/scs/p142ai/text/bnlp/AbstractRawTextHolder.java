package com.samsung.android.sdk.scs.p142ai.text.bnlp;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRawTextHolder {
    protected int position;
    protected String rawText;

    public AbstractRawTextHolder() {
    }

    public int endPosition() {
        return length() + this.position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getRawText() {
        return this.rawText;
    }

    public int length() {
        String str = this.rawText;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPosition(int i) {
        this.position = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setRawText(String str) {
        this.rawText = str;
    }

    public String subRawText(int i) {
        String str = this.rawText;
        if (str == null) {
            return null;
        }
        return str.substring(i);
    }

    public AbstractRawTextHolder(String str) {
        this.rawText = str;
    }

    public String subRawText(int i, int i2) {
        String str = this.rawText;
        if (str == null) {
            return null;
        }
        return str.substring(i, i2);
    }

    public AbstractRawTextHolder(String str, int i) {
        this.rawText = str;
        this.position = i;
    }
}
