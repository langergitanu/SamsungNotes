package com.opencsv;

import com.opencsv.processor.RowProcessor;
import com.opencsv.validators.LineValidatorAggregator;
import com.opencsv.validators.RowValidatorAggregator;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CSVReaderHeaderAware extends CSVReader {
    private final Map<String, Integer> headerIndex;

    public CSVReaderHeaderAware(Reader reader) {
        super(reader);
        this.headerIndex = new HashMap();
        initializeHeader();
    }

    private void initializeHeader() {
        String[] nextSilently = super.readNextSilently();
        for (int i = 0; i < nextSilently.length; i++) {
            this.headerIndex.put(nextSilently[i], Integer.valueOf(i));
        }
    }

    public Map<String, String> readMap() throws IOException {
        String[] next = readNext();
        if (next == null) {
            return null;
        }
        if (next.length != this.headerIndex.size()) {
            throw new IOException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.data.mismatch.with.line.number"), Long.valueOf(getRecordsRead()), Integer.valueOf(this.headerIndex.size()), Integer.valueOf(next.length)));
        }
        HashMap map = new HashMap(this.headerIndex.size() * 2);
        for (Map.Entry<String, Integer> entry : this.headerIndex.entrySet()) {
            if (entry.getValue().intValue() < next.length) {
                map.put(entry.getKey(), next[entry.getValue().intValue()]);
            }
        }
        return map;
    }

    public String[] readNext(String... strArr) throws IOException {
        if (strArr == null) {
            return super.readNextSilently();
        }
        String[] next = readNext();
        if (next == null) {
            return null;
        }
        if (next.length != this.headerIndex.size()) {
            throw new IOException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.data.mismatch.with.line.number"), Long.valueOf(getRecordsRead()), Integer.valueOf(this.headerIndex.size()), Integer.valueOf(next.length)));
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            Integer num = this.headerIndex.get(str);
            if (num == null) {
                throw new IllegalArgumentException(String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("header.nonexistant"), str));
            }
            strArr2[i] = next[num.intValue()];
        }
        return strArr2;
    }

    public CSVReaderHeaderAware(Reader reader, int i, ICSVParser iCSVParser, boolean z, boolean z2, int i2, Locale locale, LineValidatorAggregator lineValidatorAggregator, RowValidatorAggregator rowValidatorAggregator, RowProcessor rowProcessor) {
        super(reader, i, iCSVParser, z, z2, i2, locale, lineValidatorAggregator, rowValidatorAggregator, rowProcessor);
        this.headerIndex = new HashMap();
        initializeHeader();
    }
}
