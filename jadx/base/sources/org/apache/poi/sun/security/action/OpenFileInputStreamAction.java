package org.apache.poi.sun.security.action;

import java.io.File;
import java.io.FileInputStream;
import java.security.PrivilegedExceptionAction;

/* JADX INFO: loaded from: classes10.dex */
public class OpenFileInputStreamAction implements PrivilegedExceptionAction<FileInputStream> {
    private final File file;

    public OpenFileInputStreamAction(File file) {
        this.file = file;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.security.PrivilegedExceptionAction
    public FileInputStream run() {
        return new FileInputStream(this.file);
    }

    public OpenFileInputStreamAction(String str) {
        this.file = new File(str);
    }
}
