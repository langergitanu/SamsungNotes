package net.lingala.zip4j.exception;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipException extends Exception {
    private static final long serialVersionUID = 1;
    private int code;

    public ZipException() {
        this.code = -1;
    }

    public int getCode() {
        return this.code;
    }

    public ZipException(String str) {
        super(str);
        this.code = -1;
    }

    public ZipException(String str, Throwable th) {
        super(str, th);
        this.code = -1;
    }

    public ZipException(String str, int i) {
        super(str);
        this.code = i;
    }

    public ZipException(String str, Throwable th, int i) {
        super(str, th);
        this.code = i;
    }

    public ZipException(Throwable th) {
        super(th);
        this.code = -1;
    }

    public ZipException(Throwable th, int i) {
        super(th);
        this.code = i;
    }
}
