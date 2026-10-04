package com.opencsv;

import androidx.appcompat.widget.AbstractC0541b;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.IOException;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractCSVParser implements ICSVParser {
    protected final CSVReaderNullFieldIndicator nullFieldIndicator;
    protected String pending;
    private final String quoteDoubledAsString;
    private final Pattern quoteMatcherPattern;
    protected final char quotechar;
    private final String quotecharAsString;
    protected final char separator;
    private final String separatorAsString;

    public AbstractCSVParser(char c, char c2, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator) {
        this.separator = c;
        this.separatorAsString = Character.toString(c);
        this.quotechar = c2;
        String string = Character.toString(c2);
        this.quotecharAsString = string;
        this.quoteDoubledAsString = AbstractC0541b.m756B(string, string);
        this.quoteMatcherPattern = Pattern.compile(string);
        this.nullFieldIndicator = cSVReaderNullFieldIndicator;
    }

    /* JADX INFO: renamed from: convertToCsvValue, reason: merged with bridge method [inline-methods] */
    public abstract String lambda$parseToLine$0(String str, boolean z);

    public void convertToCsvValue(String str, boolean z, Appendable appendable) throws IOException {
        appendable.append(lambda$parseToLine$0(str, z));
    }

    @Override // com.opencsv.ICSVParser
    public String getPendingText() {
        return StringUtils.defaultString(this.pending);
    }

    public final String getQuoteDoubledAsString() {
        return this.quoteDoubledAsString;
    }

    public final Pattern getQuoteMatcherPattern() {
        return this.quoteMatcherPattern;
    }

    @Override // com.opencsv.ICSVParser
    public char getQuotechar() {
        return this.quotechar;
    }

    public String getQuotecharAsString() {
        return this.quotecharAsString;
    }

    @Override // com.opencsv.ICSVParser
    public char getSeparator() {
        return this.separator;
    }

    public String getSeparatorAsString() {
        return this.separatorAsString;
    }

    @Override // com.opencsv.ICSVParser
    public boolean isPending() {
        return this.pending != null;
    }

    public boolean isSurroundWithQuotes(String str, boolean z) {
        return str == null ? this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.EMPTY_QUOTES) : (str.isEmpty() && this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)) || z || str.contains(getSeparatorAsString()) || str.contains("\n");
    }

    @Override // com.opencsv.ICSVParser
    public CSVReaderNullFieldIndicator nullFieldIndicator() {
        return this.nullFieldIndicator;
    }

    @Override // com.opencsv.ICSVParser
    public String[] parseLine(String str) {
        return parseLine(str, false);
    }

    public abstract String[] parseLine(String str, boolean z);

    @Override // com.opencsv.ICSVParser
    public String[] parseLineMulti(String str) {
        return parseLine(str, true);
    }

    @Override // com.opencsv.ICSVParser
    public String parseToLine(String[] strArr, final boolean z) {
        return (String) Stream.of((Object[]) strArr).map(new Function() { // from class: com.opencsv.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f3668a.lambda$parseToLine$0(z, (String) obj);
            }
        }).collect(Collectors.joining(getSeparatorAsString()));
    }

    @Override // com.opencsv.ICSVParser
    public void parseToLine(String[] strArr, boolean z, Appendable appendable) throws IOException {
        boolean z2 = true;
        for (String str : strArr) {
            if (z2) {
                z2 = false;
            } else {
                appendable.append(getSeparator());
            }
            convertToCsvValue(str, z, appendable);
        }
    }
}
