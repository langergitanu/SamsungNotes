package com.opencsv.exceptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvDataTypeMismatchException extends CsvFieldAssignmentException {
    private static final long serialVersionUID = 1;
    private final Class<?> destinationClass;
    private final transient Object sourceObject;

    public CsvDataTypeMismatchException() {
        this.sourceObject = null;
        this.destinationClass = null;
    }

    public Class<?> getDestinationClass() {
        return this.destinationClass;
    }

    public Object getSourceObject() {
        return this.sourceObject;
    }

    public CsvDataTypeMismatchException(Object obj, Class<?> cls) {
        this.sourceObject = obj;
        this.destinationClass = cls;
    }

    public CsvDataTypeMismatchException(String str) {
        super(str);
        this.sourceObject = null;
        this.destinationClass = null;
    }

    public CsvDataTypeMismatchException(Object obj, Class<?> cls, String str) {
        super(str);
        this.sourceObject = obj;
        this.destinationClass = cls;
    }
}
