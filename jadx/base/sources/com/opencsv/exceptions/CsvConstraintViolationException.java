package com.opencsv.exceptions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CsvConstraintViolationException extends CsvFieldAssignmentException {
    private static final long serialVersionUID = 1;
    private final transient Object sourceObject;

    public CsvConstraintViolationException() {
        this.sourceObject = null;
    }

    public Object getSourceObject() {
        return this.sourceObject;
    }

    public CsvConstraintViolationException(Object obj) {
        this.sourceObject = obj;
    }

    public CsvConstraintViolationException(String str) {
        super(str);
        this.sourceObject = null;
    }

    public CsvConstraintViolationException(Object obj, String str) {
        super(str);
        this.sourceObject = obj;
    }
}
