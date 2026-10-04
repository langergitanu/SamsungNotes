package com.fasterxml.jackson.core;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface SerializableString {
    int appendQuoted(char[] cArr, int i);

    int appendQuotedUTF8(byte[] bArr, int i);

    int appendUnquoted(char[] cArr, int i);

    int appendUnquotedUTF8(byte[] bArr, int i);

    char[] asQuotedChars();

    byte[] asQuotedUTF8();

    byte[] asUnquotedUTF8();

    int charLength();

    String getValue();

    int putQuotedUTF8(ByteBuffer byteBuffer);

    int putUnquotedUTF8(ByteBuffer byteBuffer);

    int writeQuotedUTF8(OutputStream outputStream);

    int writeUnquotedUTF8(OutputStream outputStream);
}
