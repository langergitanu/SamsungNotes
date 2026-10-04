package com.fasterxml.jackson.core.p128io;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class OutputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public abstract OutputStream decorate(IOContext iOContext, OutputStream outputStream);

    public abstract Writer decorate(IOContext iOContext, Writer writer);
}
