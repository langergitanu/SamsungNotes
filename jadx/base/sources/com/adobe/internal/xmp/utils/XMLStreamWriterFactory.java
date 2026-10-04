package com.adobe.internal.xmp.utils;

import com.adobe.internal.xmp.options.SerializeOptions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMLStreamWriterFactory {
    public static XMLStreamWriterImpl create(Writer writer, SerializeOptions serializeOptions) {
        return new XMLStreamWriterImpl(writer, serializeOptions);
    }

    public static XMLStreamWriterImpl create(OutputStream outputStream, SerializeOptions serializeOptions) throws IOException {
        try {
            return create(new BufferedWriter(new OutputStreamWriter(outputStream, serializeOptions.getEncoding()), 4096), serializeOptions);
        } catch (UnsupportedEncodingException unused) {
            throw new IOException("Unsupported encoding " + serializeOptions.getEncoding());
        }
    }
}
