package com.sun.imageio.stream;

import java.io.Closeable;
import java.io.IOException;
import org.apache.poi.sun.java2d.DisposerRecord;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CloseableDisposerRecord implements DisposerRecord {
    private Closeable closeable;

    public CloseableDisposerRecord(Closeable closeable) {
        this.closeable = closeable;
    }

    @Override // org.apache.poi.sun.java2d.DisposerRecord
    public synchronized void dispose() {
        try {
            Closeable closeable = this.closeable;
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.closeable = null;
                    throw th;
                }
                this.closeable = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
