package com.opencsv;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVWriter extends AbstractCSVWriter {
    protected final char escapechar;
    protected final char quotechar;
    protected final char separator;

    public CSVWriter(Writer writer) {
        this(writer, ',', '\"', '\"', "\n");
    }

    private void appendQuoteCharacterIfNeeded(boolean z, Appendable appendable, Boolean bool) throws IOException {
        char c;
        if ((z || bool.booleanValue()) && (c = this.quotechar) != 0) {
            appendable.append(c);
        }
    }

    public boolean checkCharactersToEscape(char c) {
        char c2 = this.quotechar;
        return c2 == 0 ? c == c2 || c == this.escapechar || c == this.separator || c == '\n' : c == c2 || c == this.escapechar;
    }

    public void processCharacter(Appendable appendable, char c) throws IOException {
        if (this.escapechar != 0 && checkCharactersToEscape(c)) {
            appendable.append(this.escapechar);
        }
        appendable.append(c);
    }

    public void processLine(String str, Appendable appendable) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            processCharacter(appendable, str.charAt(i));
        }
    }

    public boolean stringContainsSpecialCharacters(String str) {
        return (str.indexOf(this.quotechar) == -1 && str.indexOf(this.escapechar) == -1 && str.indexOf(this.separator) == -1 && !str.contains("\n") && !str.contains(StringUtils.f9761CR)) ? false : true;
    }

    @Override // com.opencsv.AbstractCSVWriter
    public void writeNext(String[] strArr, boolean z, Appendable appendable) throws IOException {
        if (strArr == null) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                appendable.append(this.separator);
            }
            String str = strArr[i];
            if (str != null) {
                boolean zStringContainsSpecialCharacters = stringContainsSpecialCharacters(str);
                Boolean boolValueOf = Boolean.valueOf(zStringContainsSpecialCharacters);
                appendQuoteCharacterIfNeeded(z, appendable, boolValueOf);
                if (zStringContainsSpecialCharacters) {
                    processLine(str, appendable);
                } else {
                    appendable.append(str);
                }
                appendQuoteCharacterIfNeeded(z, appendable, boolValueOf);
            }
        }
        appendable.append(getLineEnd());
        getWriter().write(appendable.toString());
    }

    public CSVWriter(Writer writer, char c, char c2, char c4, String str) {
        super(writer, str);
        this.escapechar = c4;
        this.quotechar = c2;
        this.separator = c;
    }
}
