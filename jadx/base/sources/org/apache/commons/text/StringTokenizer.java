package org.apache.commons.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.text.matcher.StringMatcher;
import org.apache.commons.text.matcher.StringMatcherFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringTokenizer implements ListIterator<String>, Cloneable {
    private static final StringTokenizer CSV_TOKENIZER_PROTOTYPE;
    private static final StringTokenizer TSV_TOKENIZER_PROTOTYPE;
    private char[] chars;
    private StringMatcher delimMatcher;
    private boolean emptyAsNull;
    private boolean ignoreEmptyTokens;
    private StringMatcher ignoredMatcher;
    private StringMatcher quoteMatcher;
    private int tokenPos;
    private String[] tokens;
    private StringMatcher trimmerMatcher;

    static {
        StringTokenizer stringTokenizer = new StringTokenizer();
        CSV_TOKENIZER_PROTOTYPE = stringTokenizer;
        StringMatcherFactory stringMatcherFactory = StringMatcherFactory.INSTANCE;
        stringTokenizer.setDelimiterMatcher(stringMatcherFactory.commaMatcher());
        stringTokenizer.setQuoteMatcher(stringMatcherFactory.doubleQuoteMatcher());
        stringTokenizer.setIgnoredMatcher(stringMatcherFactory.noneMatcher());
        stringTokenizer.setTrimmerMatcher(stringMatcherFactory.trimMatcher());
        stringTokenizer.setEmptyTokenAsNull(false);
        stringTokenizer.setIgnoreEmptyTokens(false);
        StringTokenizer stringTokenizer2 = new StringTokenizer();
        TSV_TOKENIZER_PROTOTYPE = stringTokenizer2;
        stringTokenizer2.setDelimiterMatcher(stringMatcherFactory.tabMatcher());
        stringTokenizer2.setQuoteMatcher(stringMatcherFactory.doubleQuoteMatcher());
        stringTokenizer2.setIgnoredMatcher(stringMatcherFactory.noneMatcher());
        stringTokenizer2.setTrimmerMatcher(stringMatcherFactory.trimMatcher());
        stringTokenizer2.setEmptyTokenAsNull(false);
        stringTokenizer2.setIgnoreEmptyTokens(false);
    }

    public StringTokenizer() {
        StringMatcherFactory stringMatcherFactory = StringMatcherFactory.INSTANCE;
        this.delimMatcher = stringMatcherFactory.splitMatcher();
        this.quoteMatcher = stringMatcherFactory.noneMatcher();
        this.ignoredMatcher = stringMatcherFactory.noneMatcher();
        this.trimmerMatcher = stringMatcherFactory.noneMatcher();
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    private void addToken(List<String> list, String str) {
        if (str == null || str.isEmpty()) {
            if (isIgnoreEmptyTokens()) {
                return;
            }
            if (isEmptyTokenAsNull()) {
                str = null;
            }
        }
        list.add(str);
    }

    private void checkTokenized() {
        if (this.tokens == null) {
            char[] cArr = this.chars;
            this.tokens = (String[]) (cArr == null ? tokenize(null, 0, 0) : tokenize(cArr, 0, cArr.length)).toArray(ArrayUtils.EMPTY_STRING_ARRAY);
        }
    }

    private static StringTokenizer getCSVClone() {
        return (StringTokenizer) CSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StringTokenizer getCSVInstance() {
        return getCSVClone();
    }

    private static StringTokenizer getTSVClone() {
        return (StringTokenizer) TSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StringTokenizer getTSVInstance() {
        return getTSVClone();
    }

    private boolean isQuote(char[] cArr, int i, int i2, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i + i6;
            if (i7 >= i2 || cArr[i7] != cArr[i4 + i6]) {
                return false;
            }
        }
        return true;
    }

    private int readNextToken(char[] cArr, int i, int i2, TextStringBuilder textStringBuilder, List<String> list) {
        int i4 = i;
        while (i4 < i2) {
            int iMax = Math.max(getIgnoredMatcher().isMatch(cArr, i4, i4, i2), getTrimmerMatcher().isMatch(cArr, i4, i4, i2));
            if (iMax == 0 || getDelimiterMatcher().isMatch(cArr, i4, i4, i2) > 0 || getQuoteMatcher().isMatch(cArr, i4, i4, i2) > 0) {
                break;
            }
            i4 += iMax;
        }
        if (i4 >= i2) {
            addToken(list, "");
            return -1;
        }
        int iIsMatch = getDelimiterMatcher().isMatch(cArr, i4, i4, i2);
        if (iIsMatch > 0) {
            addToken(list, "");
            return i4 + iIsMatch;
        }
        int iIsMatch2 = getQuoteMatcher().isMatch(cArr, i4, i4, i2);
        if (iIsMatch2 <= 0) {
            return readWithQuotes(cArr, i4, i2, textStringBuilder, list, 0, 0);
        }
        int i5 = i4;
        return readWithQuotes(cArr, i5 + iIsMatch2, i2, textStringBuilder, list, i5, iIsMatch2);
    }

    private int readWithQuotes(char[] cArr, int i, int i2, TextStringBuilder textStringBuilder, List<String> list, int i4, int i5) {
        char[] cArr2;
        int i6;
        int i7 = i2;
        textStringBuilder.clear();
        boolean z = i5 > 0;
        int i8 = i;
        int size = 0;
        while (i8 < i7) {
            if (z) {
                int i9 = i8;
                if (isQuote(cArr, i8, i7, i4, i5)) {
                    i8 = i9 + i5;
                    i7 = i2;
                    if (isQuote(cArr, i8, i7, i4, i5)) {
                        textStringBuilder.append(cArr, i9, i5);
                        i8 = (i5 * 2) + i9;
                        size = textStringBuilder.size();
                    } else {
                        z = false;
                    }
                } else {
                    cArr2 = cArr;
                    i7 = i2;
                    i6 = i9;
                    textStringBuilder.append(cArr2[i6]);
                    size = textStringBuilder.size();
                    i8 = i6 + 1;
                }
            } else {
                cArr2 = cArr;
                int i10 = i8;
                int iIsMatch = getDelimiterMatcher().isMatch(cArr2, i10, i, i7);
                if (iIsMatch > 0) {
                    addToken(list, textStringBuilder.substring(0, size));
                    return iIsMatch + i10;
                }
                if (i5 > 0) {
                    i6 = i10;
                    if (isQuote(cArr2, i6, i7, i4, i5)) {
                        i8 = i6 + i5;
                        z = true;
                    }
                } else {
                    i6 = i10;
                }
                int iIsMatch2 = getIgnoredMatcher().isMatch(cArr2, i6, i, i7);
                if (iIsMatch2 <= 0) {
                    iIsMatch2 = getTrimmerMatcher().isMatch(cArr2, i6, i, i7);
                    if (iIsMatch2 > 0) {
                        textStringBuilder.append(cArr2, i6, iIsMatch2);
                    } else {
                        textStringBuilder.append(cArr2[i6]);
                        size = textStringBuilder.size();
                        i8 = i6 + 1;
                    }
                }
                i8 = i6 + iIsMatch2;
            }
        }
        addToken(list, textStringBuilder.substring(0, size));
        return -1;
    }

    public Object clone() {
        try {
            return cloneReset();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Object cloneReset() {
        StringTokenizer stringTokenizer = (StringTokenizer) super.clone();
        char[] cArr = stringTokenizer.chars;
        if (cArr != null) {
            stringTokenizer.chars = (char[]) cArr.clone();
        }
        stringTokenizer.reset();
        return stringTokenizer;
    }

    public String getContent() {
        char[] cArr = this.chars;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public StringMatcher getDelimiterMatcher() {
        return this.delimMatcher;
    }

    public StringMatcher getIgnoredMatcher() {
        return this.ignoredMatcher;
    }

    public StringMatcher getQuoteMatcher() {
        return this.quoteMatcher;
    }

    public String[] getTokenArray() {
        checkTokenized();
        return (String[]) this.tokens.clone();
    }

    public List<String> getTokenList() {
        checkTokenized();
        return new ArrayList(Arrays.asList(this.tokens));
    }

    public StringMatcher getTrimmerMatcher() {
        return this.trimmerMatcher;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        checkTokenized();
        return this.tokenPos < this.tokens.length;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        checkTokenized();
        return this.tokenPos > 0;
    }

    public boolean isEmptyTokenAsNull() {
        return this.emptyAsNull;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.ignoreEmptyTokens;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.tokenPos;
    }

    public String nextToken() {
        if (!hasNext()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i = this.tokenPos;
        this.tokenPos = i + 1;
        return strArr[i];
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.tokenPos - 1;
    }

    public String previousToken() {
        if (!hasPrevious()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i = this.tokenPos - 1;
        this.tokenPos = i;
        return strArr[i];
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public StringTokenizer reset() {
        this.tokenPos = 0;
        this.tokens = null;
        return this;
    }

    public StringTokenizer setDelimiterChar(char c) {
        return setDelimiterMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringTokenizer setDelimiterMatcher(StringMatcher stringMatcher) {
        if (stringMatcher == null) {
            stringMatcher = StringMatcherFactory.INSTANCE.noneMatcher();
        }
        this.delimMatcher = stringMatcher;
        return this;
    }

    public StringTokenizer setDelimiterString(String str) {
        return setDelimiterMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
    }

    public StringTokenizer setEmptyTokenAsNull(boolean z) {
        this.emptyAsNull = z;
        return this;
    }

    public StringTokenizer setIgnoreEmptyTokens(boolean z) {
        this.ignoreEmptyTokens = z;
        return this;
    }

    public StringTokenizer setIgnoredChar(char c) {
        return setIgnoredMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringTokenizer setIgnoredMatcher(StringMatcher stringMatcher) {
        if (stringMatcher != null) {
            this.ignoredMatcher = stringMatcher;
        }
        return this;
    }

    public StringTokenizer setQuoteChar(char c) {
        return setQuoteMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringTokenizer setQuoteMatcher(StringMatcher stringMatcher) {
        if (stringMatcher != null) {
            this.quoteMatcher = stringMatcher;
        }
        return this;
    }

    public StringTokenizer setTrimmerMatcher(StringMatcher stringMatcher) {
        if (stringMatcher != null) {
            this.trimmerMatcher = stringMatcher;
        }
        return this;
    }

    public int size() {
        checkTokenized();
        return this.tokens.length;
    }

    public String toString() {
        if (this.tokens == null) {
            return "StringTokenizer[not tokenized yet]";
        }
        return "StringTokenizer" + getTokenList();
    }

    public List<String> tokenize(char[] cArr, int i, int i2) {
        if (cArr == null || i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder();
        ArrayList arrayList = new ArrayList();
        int nextToken = i;
        while (nextToken >= 0 && nextToken < i2) {
            char[] cArr2 = cArr;
            int i4 = i2;
            nextToken = readNextToken(cArr2, nextToken, i4, textStringBuilder, arrayList);
            if (nextToken >= i4) {
                addToken(arrayList, "");
            }
            cArr = cArr2;
            i2 = i4;
        }
        return arrayList;
    }

    public static StringTokenizer getCSVInstance(char[] cArr) {
        return getCSVClone().reset(cArr);
    }

    public static StringTokenizer getTSVInstance(char[] cArr) {
        return getTSVClone().reset(cArr);
    }

    @Override // java.util.ListIterator
    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String[] strArr = this.tokens;
        int i = this.tokenPos;
        this.tokenPos = i + 1;
        return strArr[i];
    }

    @Override // java.util.ListIterator
    public String previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        String[] strArr = this.tokens;
        int i = this.tokenPos - 1;
        this.tokenPos = i;
        return strArr[i];
    }

    @Override // java.util.ListIterator
    public void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public static StringTokenizer getCSVInstance(String str) {
        return getCSVClone().reset(str);
    }

    public static StringTokenizer getTSVInstance(String str) {
        return getTSVClone().reset(str);
    }

    public StringTokenizer reset(char[] cArr) {
        reset();
        this.chars = cArr != null ? (char[]) cArr.clone() : null;
        return this;
    }

    public StringTokenizer reset(String str) {
        reset();
        this.chars = str != null ? str.toCharArray() : null;
        return this;
    }

    public StringTokenizer(char[] cArr) {
        StringMatcherFactory stringMatcherFactory = StringMatcherFactory.INSTANCE;
        this.delimMatcher = stringMatcherFactory.splitMatcher();
        this.quoteMatcher = stringMatcherFactory.noneMatcher();
        this.ignoredMatcher = stringMatcherFactory.noneMatcher();
        this.trimmerMatcher = stringMatcherFactory.noneMatcher();
        this.ignoreEmptyTokens = true;
        this.chars = cArr != null ? (char[]) cArr.clone() : null;
    }

    public StringTokenizer(char[] cArr, char c) {
        this(cArr);
        setDelimiterChar(c);
    }

    public StringTokenizer(char[] cArr, char c, char c2) {
        this(cArr, c);
        setQuoteChar(c2);
    }

    public StringTokenizer(char[] cArr, String str) {
        this(cArr);
        setDelimiterString(str);
    }

    public StringTokenizer(char[] cArr, StringMatcher stringMatcher) {
        this(cArr);
        setDelimiterMatcher(stringMatcher);
    }

    public StringTokenizer(char[] cArr, StringMatcher stringMatcher, StringMatcher stringMatcher2) {
        this(cArr, stringMatcher);
        setQuoteMatcher(stringMatcher2);
    }

    public StringTokenizer(String str) {
        StringMatcherFactory stringMatcherFactory = StringMatcherFactory.INSTANCE;
        this.delimMatcher = stringMatcherFactory.splitMatcher();
        this.quoteMatcher = stringMatcherFactory.noneMatcher();
        this.ignoredMatcher = stringMatcherFactory.noneMatcher();
        this.trimmerMatcher = stringMatcherFactory.noneMatcher();
        this.ignoreEmptyTokens = true;
        this.chars = str != null ? str.toCharArray() : null;
    }

    public StringTokenizer(String str, char c) {
        this(str);
        setDelimiterChar(c);
    }

    public StringTokenizer(String str, char c, char c2) {
        this(str, c);
        setQuoteChar(c2);
    }

    public StringTokenizer(String str, String str2) {
        this(str);
        setDelimiterString(str2);
    }

    public StringTokenizer(String str, StringMatcher stringMatcher) {
        this(str);
        setDelimiterMatcher(stringMatcher);
    }

    public StringTokenizer(String str, StringMatcher stringMatcher, StringMatcher stringMatcher2) {
        this(str, stringMatcher);
        setQuoteMatcher(stringMatcher2);
    }
}
