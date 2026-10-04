package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.util.Locale;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVParserBuilder {
    private char separator = ',';
    private char quoteChar = '\"';
    private char escapeChar = '\\';
    private boolean strictQuotes = false;
    private boolean ignoreLeadingWhiteSpace = true;
    private boolean ignoreQuotations = false;
    private CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;
    private Locale errorLocale = Locale.getDefault();

    public CSVParser build() {
        return new CSVParser(this.separator, this.quoteChar, this.escapeChar, this.strictQuotes, this.ignoreLeadingWhiteSpace, this.ignoreQuotations, this.nullFieldIndicator, this.errorLocale);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public CSVReaderNullFieldIndicator getNullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    public char getQuoteChar() {
        return this.quoteChar;
    }

    public char getSeparator() {
        return this.separator;
    }

    public boolean isIgnoreLeadingWhiteSpace() {
        return this.ignoreLeadingWhiteSpace;
    }

    public boolean isIgnoreQuotations() {
        return this.ignoreQuotations;
    }

    public boolean isStrictQuotes() {
        return this.strictQuotes;
    }

    @Deprecated
    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    public CSVParserBuilder withErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        return this;
    }

    public CSVParserBuilder withEscapeChar(char c) {
        this.escapeChar = c;
        return this;
    }

    public CSVParserBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public CSVParserBuilder withIgnoreLeadingWhiteSpace(boolean z) {
        this.ignoreLeadingWhiteSpace = z;
        return this;
    }

    public CSVParserBuilder withIgnoreQuotations(boolean z) {
        this.ignoreQuotations = z;
        return this;
    }

    public CSVParserBuilder withQuoteChar(char c) {
        this.quoteChar = c;
        return this;
    }

    public CSVParserBuilder withSeparator(char c) {
        this.separator = c;
        return this;
    }

    public CSVParserBuilder withStrictQuotes(boolean z) {
        this.strictQuotes = z;
        return this;
    }
}
