package com.samsung.android.sdk.scs.p142ai.text.bnlp;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Word extends AbstractRawTextHolder {
    protected List<Token> tokenList;

    public Word() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void addToken(Token token) {
        if (this.tokenList == null) {
            this.tokenList = new ArrayList();
        }
        this.tokenList.add(token);
    }

    public List<Token> getTokenList() {
        return this.tokenList;
    }

    public int indexOf(Token token) {
        List<Token> list = this.tokenList;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Token token2 = this.tokenList.get(i);
            if (token2.getPosition() == token.getPosition() && token2.getRawText().equals(token.getRawText())) {
                return i;
            }
        }
        return -1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setTokenList(List<Token> list) {
        this.tokenList = list;
    }

    public String toString() {
        return this.rawText;
    }

    public Word(String str) {
        super(str);
    }

    public Word(String str, int i) {
        super(str, i);
    }

    public Word(String str, int i, List<Token> list) {
        super(str, i);
        this.tokenList = list;
    }
}
