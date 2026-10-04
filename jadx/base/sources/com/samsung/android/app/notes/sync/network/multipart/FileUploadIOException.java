package com.samsung.android.app.notes.sync.network.multipart;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FileUploadIOException extends IOException {
    private static final long serialVersionUID = -7047616958165584154L;
    private final FileUploadException cause;

    public FileUploadIOException(FileUploadException fileUploadException) {
        this.cause = fileUploadException;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
