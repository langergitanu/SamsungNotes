package com.sun.imageio.plugins.png;

import com.sun.imageio.plugins.common.InputStreamAdapter;
import com.sun.imageio.plugins.common.SubImageInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import org.apache.poi.javax.imageio.stream.ImageInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class PNGImageDataEnumeration implements Enumeration<InputStream> {
    boolean firstTime = true;
    int length;
    ImageInputStream stream;

    public PNGImageDataEnumeration(ImageInputStream imageInputStream) {
        this.stream = imageInputStream;
        this.length = imageInputStream.readInt();
        imageInputStream.readInt();
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        if (this.firstTime) {
            return true;
        }
        try {
            this.stream.readInt();
            this.length = this.stream.readInt();
        } catch (IOException unused) {
        }
        return this.stream.readInt() == 1229209940;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Enumeration
    public InputStream nextElement() {
        try {
            this.firstTime = false;
            return new InputStreamAdapter(new SubImageInputStream(this.stream, this.length));
        } catch (IOException unused) {
            return null;
        }
    }
}
