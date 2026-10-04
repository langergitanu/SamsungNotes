package com.nimbusds.jose;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class KeyLengthException extends KeyException {
    private final Algorithm alg;
    private final int expectedLength;

    public KeyLengthException(String str) {
        super(str);
        this.expectedLength = 0;
        this.alg = null;
    }

    public Algorithm getAlgorithm() {
        return this.alg;
    }

    public int getExpectedKeyLength() {
        return this.expectedLength;
    }

    public KeyLengthException(Algorithm algorithm) {
        this(0, algorithm);
    }

    public KeyLengthException(int i, Algorithm algorithm) {
        String strM767i;
        String str;
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            strM767i = AbstractC0541b.m767i(i, "The expected key length is ", " bits");
        } else {
            strM767i = "Unexpected key length";
        }
        sb.append(strM767i);
        if (algorithm != null) {
            str = " (for " + algorithm + " algorithm)";
        } else {
            str = "";
        }
        sb.append(str);
        super(sb.toString());
        this.expectedLength = i;
        this.alg = algorithm;
    }
}
