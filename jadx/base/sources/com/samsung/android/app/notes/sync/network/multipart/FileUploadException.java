package com.samsung.android.app.notes.sync.network.multipart;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FileUploadException extends IOException {
    private static final long serialVersionUID = 8881893724388807504L;
    private final Throwable cause;

    public FileUploadException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.cause != null) {
            printStream.println("Caused by:");
            this.cause.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.cause != null) {
            printWriter.println("Caused by:");
            this.cause.printStackTrace(printWriter);
        }
    }
}
