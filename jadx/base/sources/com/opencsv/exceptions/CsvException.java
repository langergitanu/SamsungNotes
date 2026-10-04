package com.opencsv.exceptions;

import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvException extends Exception {
    private static final long serialVersionUID = 1;
    private String[] line;
    private long lineNumber;

    public CsvException() {
        this.lineNumber = -1L;
    }

    public String[] getLine() {
        return (String[]) ArrayUtils.clone(this.line);
    }

    public long getLineNumber() {
        return this.lineNumber;
    }

    public void setLine(String[] strArr) {
        this.line = (String[]) ArrayUtils.clone(strArr);
    }

    public void setLineNumber(long j) {
        this.lineNumber = j;
    }

    public CsvException(String str) {
        super(str);
        this.lineNumber = -1L;
    }
}
