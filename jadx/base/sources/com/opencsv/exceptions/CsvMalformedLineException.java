package com.opencsv.exceptions;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvMalformedLineException extends IOException {
    private static final long serialVersionUID = 1;
    private String context;
    private long lineNumber;

    public CsvMalformedLineException() {
    }

    public String getContext() {
        return this.context;
    }

    public long getLineNumber() {
        return this.lineNumber;
    }

    public CsvMalformedLineException(String str, long j, String str2) {
        super(str);
        this.lineNumber = j;
        this.context = str2;
    }
}
