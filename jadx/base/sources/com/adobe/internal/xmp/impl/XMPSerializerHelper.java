package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.options.SerializeOptions;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPSerializerHelper {
    public static void serialize(XMPMetaImpl xMPMetaImpl, OutputStream outputStream, SerializeOptions serializeOptions) {
        if (serializeOptions == null) {
            serializeOptions = new SerializeOptions();
        }
        if (serializeOptions.getSort()) {
            xMPMetaImpl.sort();
        }
        new XMPSerializerRDF().serialize(xMPMetaImpl, outputStream, serializeOptions);
    }

    public static byte[] serializeToBuffer(XMPMetaImpl xMPMetaImpl, SerializeOptions serializeOptions) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        serialize(xMPMetaImpl, byteArrayOutputStream, serializeOptions);
        return byteArrayOutputStream.toByteArray();
    }

    public static String serializeToString(XMPMetaImpl xMPMetaImpl, SerializeOptions serializeOptions) {
        if (serializeOptions == null) {
            serializeOptions = new SerializeOptions();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        serialize(xMPMetaImpl, byteArrayOutputStream, serializeOptions);
        try {
            return byteArrayOutputStream.toString(serializeOptions.getEncoding());
        } catch (UnsupportedEncodingException unused) {
            return byteArrayOutputStream.toString();
        }
    }
}
