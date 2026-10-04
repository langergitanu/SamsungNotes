package com.opencsv.bean.concurrent;

import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SingleLineReader {
    protected final CSVReader csvReader;
    protected final boolean ignoreEmptyLines;
    protected String[] line;

    public SingleLineReader(CSVReader cSVReader, boolean z) {
        this.csvReader = cSVReader;
        this.ignoreEmptyLines = z;
    }

    private boolean isCurrentLineEmpty() {
        String[] strArr = this.line;
        return strArr.length == 0 || (strArr.length == 1 && StringUtils.isEmpty(strArr[0]));
    }

    public String[] getLine() {
        String[] strArr = this.line;
        if (strArr == null) {
            return strArr;
        }
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public long getLinesRead() {
        return this.csvReader.getLinesRead();
    }

    public String[] readNextLine() {
        do {
            String[] next = this.csvReader.readNext();
            this.line = next;
            if (next == null || !isCurrentLineEmpty()) {
                break;
            }
        } while (this.ignoreEmptyLines);
        return getLine();
    }
}
