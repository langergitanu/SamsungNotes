package org.apache.xmlbeans.xml.stream;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.xmlbeans.xml.stream.utils.NestedThrowable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XMLStreamException extends IOException implements NestedThrowable {

    /* JADX INFO: renamed from: th */
    protected Throwable f10183th;

    public XMLStreamException() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        Throwable th;
        String message = super.getMessage();
        return (message != null || (th = this.f10183th) == null) ? message : th.getMessage();
    }

    public Throwable getNested() {
        return this.f10183th;
    }

    public Throwable getNestedException() {
        return getNested();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        NestedThrowable.Util.printStackTrace(this, printStream);
    }

    public void superPrintStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
    }

    public String superToString() {
        return super.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return NestedThrowable.Util.toString(this);
    }

    public XMLStreamException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        NestedThrowable.Util.printStackTrace(this, printWriter);
    }

    public void superPrintStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }

    public XMLStreamException(Throwable th) {
        this.f10183th = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public XMLStreamException(String str, Throwable th) {
        super(str);
        this.f10183th = th;
    }
}
