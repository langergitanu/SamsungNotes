package com.opencsv.exceptions;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvMultilineLimitBrokenException extends IOException {
    private static final long serialVersionUID = 1;
    private String context;
    private int multilineLimit;
    private long row;

    public CsvMultilineLimitBrokenException() {
    }

    public String getContext() {
        return this.context;
    }

    public int getMultilineLimit() {
        return this.multilineLimit;
    }

    public long getRow() {
        return this.row;
    }

    public CsvMultilineLimitBrokenException(String str, long j, String str2, int i) {
        super(str);
        this.row = j;
        this.context = str2;
        this.multilineLimit = i;
    }
}
