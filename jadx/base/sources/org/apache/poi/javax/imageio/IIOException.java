package org.apache.poi.javax.imageio;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IIOException extends IOException {
    public IIOException(String str) {
        super(str);
    }

    public IIOException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
