package net.lingala.zip4j.p210io;

import java.io.InputStream;
import net.lingala.zip4j.unzip.UnzipEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseInputStream extends InputStream {
    @Override // java.io.InputStream
    public int available() {
        return 0;
    }

    public UnzipEngine getUnzipEngine() {
        return null;
    }

    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    public void seek(long j) {
    }
}
