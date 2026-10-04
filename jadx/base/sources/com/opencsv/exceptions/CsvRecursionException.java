package com.opencsv.exceptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvRecursionException extends CsvRuntimeException {
    private static final long serialVersionUID = 1;
    private final Class<?> offendingType;

    public CsvRecursionException(String str, Class<?> cls) {
        super(str);
        this.offendingType = cls;
    }

    public Class<?> getOffendingType() {
        return this.offendingType;
    }
}
