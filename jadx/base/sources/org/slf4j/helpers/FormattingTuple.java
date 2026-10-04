package org.slf4j.helpers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class FormattingTuple {
    public static FormattingTuple NULL = new FormattingTuple(null);
    private final Object[] argArray;
    private final String message;
    private final Throwable throwable;

    public FormattingTuple(String str) {
        this(str, null, null);
    }

    public Object[] getArgArray() {
        return this.argArray;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public FormattingTuple(String str, Object[] objArr, Throwable th) {
        this.message = str;
        this.throwable = th;
        this.argArray = objArr;
    }
}
