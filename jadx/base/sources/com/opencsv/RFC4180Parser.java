package com.opencsv;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RFC4180Parser extends AbstractCSVParser {
    public RFC4180Parser() {
        this('\"', ',', CSVReaderNullFieldIndicator.NEITHER);
    }

    private int findEndOfFieldFromPosition(String str, int i) {
        int iIndexOf = str.indexOf(this.quotechar, i + 1);
        boolean z = false;
        while (haveNotFoundLastQuote(str, iIndexOf)) {
            if (!z) {
                int i2 = iIndexOf + 1;
                if (str.charAt(i2) == this.separator) {
                    return i2;
                }
            }
            do {
                iIndexOf = str.indexOf(this.quotechar, iIndexOf + 1);
                z = !z;
                if (haveNotFoundLastQuote(str, iIndexOf)) {
                }
            } while (str.charAt(iIndexOf + 1) == this.quotechar);
        }
        return str.length();
    }

    private String[] handleEmptySeparators(String[] strArr) {
        CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator = this.nullFieldIndicator;
        if (cSVReaderNullFieldIndicator == CSVReaderNullFieldIndicator.EMPTY_SEPARATORS || cSVReaderNullFieldIndicator == CSVReaderNullFieldIndicator.BOTH) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].isEmpty()) {
                    strArr[i] = null;
                }
            }
        }
        return strArr;
    }

    private String handleQuotes(String str) {
        if (!hasOnlyOneQuote(str) && str.startsWith(getQuotecharAsString())) {
            str = StringUtils.removeEnd(StringUtils.removeStart(str, getQuotecharAsString()), getQuotecharAsString());
        }
        String strReplace = StringUtils.replace(str, getQuoteDoubledAsString(), getQuotecharAsString());
        if (!strReplace.isEmpty()) {
            return strReplace;
        }
        CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator = this.nullFieldIndicator;
        if (cSVReaderNullFieldIndicator == CSVReaderNullFieldIndicator.BOTH || cSVReaderNullFieldIndicator == CSVReaderNullFieldIndicator.EMPTY_QUOTES) {
            return null;
        }
        return strReplace;
    }

    private boolean hasOddQuotes(String str) {
        return StringUtils.countMatches(str, this.quotechar) % 2 != 0;
    }

    private boolean hasOnlyOneQuote(String str) {
        return StringUtils.countMatches(str, this.quotechar) == 1;
    }

    private boolean haveNotFoundLastQuote(String str, int i) {
        return i != -1 && i < str.length() - 1;
    }

    private boolean lastElementStartedWithQuoteButDidNotEndInOne(List<String> list) {
        String str = (String) AbstractC0000a.m10g(list, 1);
        return startsButDoesNotEndWithQuote(str) || hasOnlyOneQuote(str) || hasOddQuotes(str);
    }

    private String[] splitWhileNotInQuotes(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (length < str.length()) {
            int iIndexOf = str.indexOf(this.separator, length);
            int iIndexOf2 = str.indexOf(this.quotechar, length);
            if (iIndexOf == -1) {
                arrayList.add(str.substring(length));
                length = str.length();
            } else {
                if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf || iIndexOf2 != length) {
                    arrayList.add(str.substring(length, iIndexOf));
                } else {
                    iIndexOf = findEndOfFieldFromPosition(str, length);
                    arrayList.add(iIndexOf >= str.length() ? str.substring(length) : str.substring(length, iIndexOf));
                }
                length = iIndexOf + 1;
            }
        }
        if (z && lastElementStartedWithQuoteButDidNotEndInOne(arrayList)) {
            this.pending = AbstractC0622a.m1170p((String) AbstractC1974b.m1313f(1, arrayList), "\n", new StringBuilder());
            arrayList.remove(arrayList.size() - 1);
        } else if (str.lastIndexOf(this.separator) == str.length() - 1) {
            arrayList.add("");
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    private boolean startsButDoesNotEndWithQuote(String str) {
        return str.startsWith(getQuotecharAsString()) && !str.endsWith(getQuotecharAsString());
    }

    private String[] tokenizeStringIntoArray(String str) {
        String[] strArrSplitPreserveAllTokens = StringUtils.splitPreserveAllTokens(str, this.separator);
        return (strArrSplitPreserveAllTokens == null || strArrSplitPreserveAllTokens.length != 0) ? strArrSplitPreserveAllTokens : new String[]{""};
    }

    @Override // com.opencsv.AbstractCSVParser
    /* JADX INFO: renamed from: convertToCsvValue */
    public String lambda$parseToLine$0(String str, boolean z) {
        String strReplaceAll = (str != null || this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.NEITHER)) ? str : "";
        StringBuilder sb = new StringBuilder(strReplaceAll == null ? 16 : strReplaceAll.length() * 2);
        boolean z2 = strReplaceAll != null && strReplaceAll.contains(getQuotecharAsString());
        boolean z3 = z || isSurroundWithQuotes(str, z2);
        if (z2) {
            strReplaceAll = getQuoteMatcherPattern().matcher(strReplaceAll).replaceAll(getQuoteDoubledAsString());
        }
        if (z3) {
            sb.append(getQuotechar());
        }
        sb.append(strReplaceAll);
        if (z3) {
            sb.append(getQuotechar());
        }
        return sb.toString();
    }

    @Override // com.opencsv.AbstractCSVParser
    public String[] parseLine(String str, boolean z) {
        if (!z && this.pending != null) {
            this.pending = null;
        }
        if (str == null) {
            String str2 = this.pending;
            if (str2 == null) {
                return null;
            }
            this.pending = null;
            return new String[]{str2};
        }
        if (z && this.pending != null) {
            str = AbstractC0622a.m1170p(this.pending, str, new StringBuilder());
        }
        this.pending = null;
        if (!StringUtils.contains(str, this.quotechar)) {
            return handleEmptySeparators(tokenizeStringIntoArray(str));
        }
        String[] strArrHandleEmptySeparators = handleEmptySeparators(splitWhileNotInQuotes(str, z));
        for (int i = 0; i < strArrHandleEmptySeparators.length; i++) {
            if (StringUtils.contains(strArrHandleEmptySeparators[i], this.quotechar)) {
                strArrHandleEmptySeparators[i] = handleQuotes(strArrHandleEmptySeparators[i]);
            }
        }
        return strArrHandleEmptySeparators;
    }

    public RFC4180Parser(char c, char c2, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        super(c2, c, cSVReaderNullFieldIndicator);
    }

    @Override // com.opencsv.ICSVParser
    public void setErrorLocale(Locale locale) {
    }
}
