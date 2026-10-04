package com.sun.imageio.stream;

import java.io.IOException;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class StreamFinalizer {
    private ImageInputStream stream;

    public StreamFinalizer(ImageInputStream imageInputStream) {
        this.stream = imageInputStream;
    }

    public void finalize() throws Throwable {
        try {
            this.stream.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.stream = null;
            super.finalize();
            throw th;
        }
        this.stream = null;
        super.finalize();
    }
}
