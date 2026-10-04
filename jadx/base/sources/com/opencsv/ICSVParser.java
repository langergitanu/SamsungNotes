package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICSVParser {
    public static final String DEFAULT_BUNDLE_NAME = "opencsv";
    public static final char DEFAULT_ESCAPE_CHARACTER = '\\';
    public static final boolean DEFAULT_IGNORE_LEADING_WHITESPACE = true;
    public static final boolean DEFAULT_IGNORE_QUOTATIONS = false;
    public static final CSVReaderNullFieldIndicator DEFAULT_NULL_FIELD_INDICATOR = CSVReaderNullFieldIndicator.NEITHER;
    public static final char DEFAULT_QUOTE_CHARACTER = '\"';
    public static final char DEFAULT_SEPARATOR = ',';
    public static final boolean DEFAULT_STRICT_QUOTES = false;
    public static final int INITIAL_READ_SIZE = 1024;
    public static final int MAX_SIZE_FOR_EMPTY_FIELD = 16;
    public static final String NEWLINE = "\n";
    public static final char NULL_CHARACTER = 0;
    public static final int READ_BUFFER_SIZE = 128;

    String getPendingText();

    char getQuotechar();

    char getSeparator();

    boolean isPending();

    CSVReaderNullFieldIndicator nullFieldIndicator();

    String[] parseLine(String str);

    String[] parseLineMulti(String str);

    String parseToLine(String[] strArr, boolean z);

    void parseToLine(String[] strArr, boolean z, Appendable appendable);

    void setErrorLocale(Locale locale);
}
