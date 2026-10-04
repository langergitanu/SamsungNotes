package com.opencsv.exceptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvBadConverterException extends CsvRuntimeException {
    private static final long serialVersionUID = 1;
    private final Class<?> converterClass;

    public CsvBadConverterException() {
        this.converterClass = null;
    }

    public Class<?> getConverterClass() {
        return this.converterClass;
    }

    public CsvBadConverterException(Class<?> cls) {
        this.converterClass = cls;
    }

    public CsvBadConverterException(String str) {
        super(str);
        this.converterClass = null;
    }

    public CsvBadConverterException(Class<?> cls, String str) {
        super(str);
        this.converterClass = cls;
    }
}
