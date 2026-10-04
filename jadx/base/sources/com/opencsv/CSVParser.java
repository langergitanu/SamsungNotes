package com.opencsv;

import androidx.appcompat.widget.AbstractC0541b;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVParser extends AbstractCSVParser {
    private static final int BEGINNING_OF_LINE = 3;
    private Locale errorLocale;
    private final char escape;
    private final String escapeAsString;
    private final String escapeDoubleAsString;
    private final boolean ignoreLeadingWhiteSpace;
    private final boolean ignoreQuotations;
    private boolean inField;
    private final boolean strictQuotes;
    private int tokensOnLastCompleteLine;

    /* JADX INFO: renamed from: com.opencsv.CSVParser$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C66131 {
        static final /* synthetic */ int[] $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator;

        static {
            int[] iArr = new int[CSVReaderNullFieldIndicator.values().length];
            $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator = iArr;
            try {
                iArr[CSVReaderNullFieldIndicator.BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[CSVReaderNullFieldIndicator.EMPTY_SEPARATORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[CSVReaderNullFieldIndicator.EMPTY_QUOTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StringFragmentCopier {
        private final String input;

        /* JADX INFO: renamed from: sb */
        private StringBuilder f3666sb;

        /* JADX INFO: renamed from: i */
        private int f3665i = 0;
        private int pendingSubstrFrom = 0;
        private int pendingSubstrTo = 0;

        public StringFragmentCopier(String str) {
            this.input = str;
        }

        private StringBuilder materializeBuilder() {
            if (this.f3666sb == null) {
                this.f3666sb = new StringBuilder(this.input.length() + 128);
            }
            int i = this.pendingSubstrFrom;
            int i2 = this.pendingSubstrTo;
            if (i < i2) {
                this.f3666sb.append((CharSequence) this.input, i, i2);
                int i4 = this.f3665i;
                this.pendingSubstrTo = i4;
                this.pendingSubstrFrom = i4;
            }
            return this.f3666sb;
        }

        public void append(String str) {
            materializeBuilder().append(str);
        }

        public void appendPrev() {
            int i = this.pendingSubstrTo;
            if (i == this.pendingSubstrFrom) {
                int i2 = this.f3665i;
                this.pendingSubstrFrom = i2 - 1;
                this.pendingSubstrTo = i2;
            } else if (i == this.f3665i - 1) {
                this.pendingSubstrTo = i + 1;
            } else {
                materializeBuilder().append(this.input.charAt(this.f3665i - 1));
            }
        }

        public void clearOutput() {
            StringBuilder sb = this.f3666sb;
            if (sb != null) {
                sb.setLength(0);
            }
            int i = this.f3665i;
            this.pendingSubstrTo = i;
            this.pendingSubstrFrom = i;
        }

        public boolean isEmptyInput() {
            return this.f3665i >= this.input.length();
        }

        public boolean isEmptyOutput() {
            if (this.pendingSubstrFrom < this.pendingSubstrTo) {
                return false;
            }
            StringBuilder sb = this.f3666sb;
            return sb == null || sb.length() == 0;
        }

        public String peekOutput() {
            StringBuilder sb = this.f3666sb;
            return (sb == null || sb.length() == 0) ? this.input.substring(this.pendingSubstrFrom, this.pendingSubstrTo) : materializeBuilder().toString();
        }

        public char takeInput() {
            String str = this.input;
            int i = this.f3665i;
            this.f3665i = i + 1;
            return str.charAt(i);
        }

        public String takeOutput() {
            String strPeekOutput = peekOutput();
            clearOutput();
            return strPeekOutput;
        }

        public void append(char c) {
            materializeBuilder().append(c);
        }
    }

    public CSVParser() {
        this(',', '\"', '\\', false, true, false, ICSVParser.DEFAULT_NULL_FIELD_INDICATOR, Locale.getDefault());
    }

    private boolean anyCharactersAreTheSame(char c, char c2, char c4) {
        return isSameCharacter(c, c2) || isSameCharacter(c, c4) || isSameCharacter(c2, c4);
    }

    private String convertEmptyToNullIfNeeded(String str, boolean z) {
        if (str.isEmpty() && shouldConvertEmptyToNull(z)) {
            return null;
        }
        return str;
    }

    private void handleEscapeCharacter(String str, StringFragmentCopier stringFragmentCopier, boolean z) {
        if (isNextCharacterEscapable(str, inQuotes(z), stringFragmentCopier.f3665i - 1)) {
            stringFragmentCopier.takeInput();
            stringFragmentCopier.appendPrev();
        }
    }

    private void handleQuoteCharButNotStrictQuotes(String str, StringFragmentCopier stringFragmentCopier) {
        int i;
        if (this.strictQuotes || (i = stringFragmentCopier.f3665i) <= 3 || str.charAt(i - 2) == this.separator || str.length() <= i || str.charAt(i) == this.separator) {
            return;
        }
        if (this.ignoreLeadingWhiteSpace && !stringFragmentCopier.isEmptyOutput() && StringUtils.isWhitespace(stringFragmentCopier.peekOutput())) {
            stringFragmentCopier.clearOutput();
        } else {
            stringFragmentCopier.appendPrev();
        }
    }

    private boolean inQuotes(boolean z) {
        return (z && !this.ignoreQuotations) || this.inField;
    }

    private boolean isCharacterEscapable(char c) {
        return isCharacterQuoteCharacter(c) || isCharacterEscapeCharacter(c) || isCharacterSeparator(c);
    }

    private boolean isCharacterEscapeCharacter(char c) {
        return c == this.escape;
    }

    private boolean isCharacterQuoteCharacter(char c) {
        return c == this.quotechar;
    }

    private boolean isCharacterSeparator(char c) {
        return c == this.separator;
    }

    private boolean isNextCharacterEscapedQuote(String str, boolean z, int i) {
        int i2;
        return z && str.length() > (i2 = i + 1) && isCharacterQuoteCharacter(str.charAt(i2));
    }

    private boolean isSameCharacter(char c, char c2) {
        return c != 0 && c == c2;
    }

    private boolean shouldConvertEmptyToNull(boolean z) {
        int i = C66131.$SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[this.nullFieldIndicator.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return !z;
        }
        if (i != 3) {
            return false;
        }
        return z;
    }

    @Override // com.opencsv.AbstractCSVParser
    /* JADX INFO: renamed from: convertToCsvValue */
    public String lambda$parseToLine$0(String str, boolean z) {
        String strReplace = (str != null || this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.NEITHER)) ? str : "";
        StringBuilder sb = new StringBuilder(strReplace == null ? 16 : strReplace.length() * 2);
        boolean zContains = StringUtils.contains(strReplace, getQuotechar());
        boolean zContains2 = StringUtils.contains(strReplace, getEscape());
        boolean z2 = z || isSurroundWithQuotes(str, StringUtils.contains(strReplace, getSeparator()));
        if (zContains) {
            strReplace = getQuoteMatcherPattern().matcher(strReplace).replaceAll(getQuoteDoubledAsString());
        }
        if (zContains2) {
            strReplace = strReplace.replace(this.escapeAsString, this.escapeDoubleAsString);
        }
        if (z2) {
            sb.append(getQuotechar());
        }
        sb.append(strReplace);
        if (z2) {
            sb.append(getQuotechar());
        }
        return sb.toString();
    }

    public char getEscape() {
        return this.escape;
    }

    public boolean isIgnoreLeadingWhiteSpace() {
        return this.ignoreLeadingWhiteSpace;
    }

    public boolean isIgnoreQuotations() {
        return this.ignoreQuotations;
    }

    public boolean isNextCharacterEscapable(String str, boolean z, int i) {
        int i2;
        return z && str.length() > (i2 = i + 1) && isCharacterEscapable(str.charAt(i2));
    }

    public boolean isStrictQuotes() {
        return this.strictQuotes;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x003e, code lost:
    
        r1.add(convertEmptyToNullIfNeeded(r3.takeOutput(), r4));
        r8.inField = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e3  */
    @Override // com.opencsv.AbstractCSVParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] parseLine(String str, boolean z) throws IOException {
        boolean z2;
        boolean z3;
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
        ArrayList arrayList = this.tokensOnLastCompleteLine <= 0 ? new ArrayList() : new ArrayList((this.tokensOnLastCompleteLine + 1) * 2);
        StringFragmentCopier stringFragmentCopier = new StringFragmentCopier(str);
        String str3 = this.pending;
        if (str3 == null) {
            z2 = false;
            z3 = false;
            while (!stringFragmentCopier.isEmptyInput()) {
            }
            if (z2) {
                this.inField = false;
                arrayList.add(convertEmptyToNullIfNeeded(stringFragmentCopier.takeOutput(), z3));
            }
            this.tokensOnLastCompleteLine = arrayList.size();
            return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
        }
        stringFragmentCopier.append(str3);
        this.pending = null;
        z2 = !this.ignoreQuotations;
        z3 = false;
        while (!stringFragmentCopier.isEmptyInput()) {
            char cTakeInput = stringFragmentCopier.takeInput();
            if (cTakeInput == this.escape) {
                if (!this.strictQuotes) {
                    this.inField = true;
                }
                handleEscapeCharacter(str, stringFragmentCopier, z2);
            } else if (cTakeInput != this.quotechar) {
                if (cTakeInput != this.separator || (z2 && !this.ignoreQuotations)) {
                    if (!this.strictQuotes || (z2 && !this.ignoreQuotations)) {
                        stringFragmentCopier.appendPrev();
                        this.inField = true;
                        z3 = true;
                    }
                }
                z3 = false;
                while (!stringFragmentCopier.isEmptyInput()) {
                }
            } else {
                if (isNextCharacterEscapedQuote(str, inQuotes(z2), stringFragmentCopier.f3665i - 1)) {
                    stringFragmentCopier.takeInput();
                    stringFragmentCopier.appendPrev();
                } else {
                    z2 = !z2;
                    if (stringFragmentCopier.isEmptyOutput()) {
                        z3 = true;
                    }
                    handleQuoteCharButNotStrictQuotes(str, stringFragmentCopier);
                }
                this.inField = !this.inField;
            }
        }
        if (z2 || this.ignoreQuotations) {
            this.inField = false;
            arrayList.add(convertEmptyToNullIfNeeded(stringFragmentCopier.takeOutput(), z3));
        } else {
            if (!z) {
                throw new IOException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("unterminated.quote"), stringFragmentCopier.peekOutput()));
            }
            stringFragmentCopier.append('\n');
            this.pending = stringFragmentCopier.peekOutput();
        }
        this.tokensOnLastCompleteLine = arrayList.size();
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    @Override // com.opencsv.ICSVParser
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    public CSVParser(char c, char c2, char c4, boolean z, boolean z2, boolean z3, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator, Locale locale) {
        super(c, c2, cSVReaderNullFieldIndicator);
        this.tokensOnLastCompleteLine = -1;
        this.inField = false;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        if (anyCharactersAreTheSame(c, c2, c4)) {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("special.characters.must.differ"));
        }
        if (c != 0) {
            this.escape = c4;
            String string = Character.toString(c4);
            this.escapeAsString = string;
            this.escapeDoubleAsString = AbstractC0541b.m756B(string, string);
            this.strictQuotes = z;
            this.ignoreLeadingWhiteSpace = z2;
            this.ignoreQuotations = z3;
            return;
        }
        throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("define.separator"));
    }
}
