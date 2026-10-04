package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class RFC4180ParserBuilder {
    private char separator = ',';
    private char quoteChar = '\"';
    private CSVReaderNullFieldIndicator nullFieldIndicator = CSVReaderNullFieldIndicator.NEITHER;

    public RFC4180Parser build() {
        return new RFC4180Parser(this.quoteChar, this.separator, this.nullFieldIndicator);
    }

    public char getQuoteChar() {
        return this.quoteChar;
    }

    public char getSeparator() {
        return this.separator;
    }

    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    public RFC4180ParserBuilder withFieldAsNull(CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
        return this;
    }

    public RFC4180ParserBuilder withQuoteChar(char c) {
        this.quoteChar = c;
        return this;
    }

    public RFC4180ParserBuilder withSeparator(char c) {
        this.separator = c;
        return this;
    }
}
