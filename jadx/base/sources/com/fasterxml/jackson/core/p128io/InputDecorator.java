package com.fasterxml.jackson.core.p128io;

import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract InputStream decorate(IOContext iOContext, InputStream inputStream);

    public abstract InputStream decorate(IOContext iOContext, byte[] bArr, int i, int i2);

    public abstract Reader decorate(IOContext iOContext, Reader reader);
}
