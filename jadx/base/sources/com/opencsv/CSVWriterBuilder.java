package com.opencsv;

import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVWriterBuilder {
    private Character escapechar;
    private String lineEnd = "\n";
    private ICSVParser parser;
    private Character quotechar;
    private ResultSetHelper resultSetHelper;
    private Character separator;
    private final Writer writer;

    public CSVWriterBuilder(Writer writer) {
        this.writer = writer;
    }

    private ICSVWriter createCSVParserWriter() {
        CSVParserWriter cSVParserWriter = new CSVParserWriter(this.writer, this.parser, this.lineEnd);
        ResultSetHelper resultSetHelper = this.resultSetHelper;
        if (resultSetHelper != null) {
            cSVParserWriter.setResultService(resultSetHelper);
        }
        return cSVParserWriter;
    }

    private ICSVWriter createCSVWriter() {
        if (this.separator == null) {
            this.separator = ',';
        }
        if (this.quotechar == null) {
            this.quotechar = '\"';
        }
        if (this.escapechar == null) {
            this.escapechar = '\"';
        }
        CSVWriter cSVWriter = new CSVWriter(this.writer, this.separator.charValue(), this.quotechar.charValue(), this.escapechar.charValue(), this.lineEnd);
        ResultSetHelper resultSetHelper = this.resultSetHelper;
        if (resultSetHelper != null) {
            cSVWriter.setResultService(resultSetHelper);
        }
        return cSVWriter;
    }

    public ICSVWriter build() {
        return this.parser != null ? createCSVParserWriter() : createCSVWriter();
    }

    public CSVWriterBuilder withEscapeChar(char c) {
        if (this.parser != null) {
            throw new IllegalArgumentException("You cannot set the escape character in the builder if you have a ICSVParser set.  Set the escape character in the parser instead.");
        }
        this.escapechar = Character.valueOf(c);
        return this;
    }

    public CSVWriterBuilder withLineEnd(String str) {
        this.lineEnd = str;
        return this;
    }

    public CSVWriterBuilder withParser(ICSVParser iCSVParser) {
        if (this.separator != null || this.quotechar != null || this.escapechar != null) {
            throw new IllegalArgumentException("You cannot set the parser in the builder if you have set the separator, quote, or escape character");
        }
        this.parser = iCSVParser;
        return this;
    }

    public CSVWriterBuilder withQuoteChar(char c) {
        if (this.parser != null) {
            throw new IllegalArgumentException("You cannot set the quote character in the builder if you have a ICSVParser set.  Set the quote character in the parser instead.");
        }
        this.quotechar = Character.valueOf(c);
        return this;
    }

    public CSVWriterBuilder withResultSetHelper(ResultSetHelper resultSetHelper) {
        this.resultSetHelper = resultSetHelper;
        return this;
    }

    public CSVWriterBuilder withSeparator(char c) {
        if (this.parser != null) {
            throw new IllegalArgumentException("You cannot set the separator in the builder if you have a ICSVParser set.  Set the separator in the parser instead.");
        }
        this.separator = Character.valueOf(c);
        return this;
    }
}
