package junit.framework;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ComparisonCompactor {
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";
    private static final String ELLIPSIS = "...";
    private String fActual;
    private int fContextLength;
    private String fExpected;
    private int fPrefix;
    private int fSuffix;

    public ComparisonCompactor(int i, String str, String str2) {
        this.fContextLength = i;
        this.fExpected = str;
        this.fActual = str2;
    }

    private boolean areStringsEqual() {
        return this.fExpected.equals(this.fActual);
    }

    private String compactString(String str) {
        String strM1170p = AbstractC0622a.m1170p(str.substring(this.fPrefix, (str.length() - this.fSuffix) + 1), "]", new StringBuilder("["));
        if (this.fPrefix > 0) {
            strM1170p = AbstractC0622a.m1170p(computeCommonPrefix(), strM1170p, new StringBuilder());
        }
        if (this.fSuffix <= 0) {
            return strM1170p;
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(strM1170p);
        sbM1324q.append(computeCommonSuffix());
        return sbM1324q.toString();
    }

    private String computeCommonPrefix() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.fPrefix > this.fContextLength ? ELLIPSIS : "");
        sb.append(this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix));
        return sb.toString();
    }

    private String computeCommonSuffix() {
        int iMin = Math.min((this.fExpected.length() - this.fSuffix) + 1 + this.fContextLength, this.fExpected.length());
        StringBuilder sb = new StringBuilder();
        String str = this.fExpected;
        sb.append(str.substring((str.length() - this.fSuffix) + 1, iMin));
        sb.append((this.fExpected.length() - this.fSuffix) + 1 < this.fExpected.length() - this.fContextLength ? ELLIPSIS : "");
        return sb.toString();
    }

    private void findCommonPrefix() {
        this.fPrefix = 0;
        int iMin = Math.min(this.fExpected.length(), this.fActual.length());
        while (true) {
            int i = this.fPrefix;
            if (i >= iMin || this.fExpected.charAt(i) != this.fActual.charAt(this.fPrefix)) {
                return;
            } else {
                this.fPrefix++;
            }
        }
    }

    private void findCommonSuffix() {
        int length = this.fExpected.length() - 1;
        int length2 = this.fActual.length() - 1;
        while (true) {
            int i = this.fPrefix;
            if (length2 < i || length < i || this.fExpected.charAt(length) != this.fActual.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.fSuffix = this.fExpected.length() - length;
    }

    public String compact(String str) {
        if (this.fExpected == null || this.fActual == null || areStringsEqual()) {
            return Assert.format(str, this.fExpected, this.fActual);
        }
        findCommonPrefix();
        findCommonSuffix();
        return Assert.format(str, compactString(this.fExpected), compactString(this.fActual));
    }
}
