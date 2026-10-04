package com.sun.imageio.plugins.common;

import java.io.InputStream;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InputStreamAdapter extends InputStream {
    ImageInputStream stream;

    public InputStreamAdapter(ImageInputStream imageInputStream) {
        this.stream = imageInputStream;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.stream.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.stream.read(bArr, i, i2);
    }
}
