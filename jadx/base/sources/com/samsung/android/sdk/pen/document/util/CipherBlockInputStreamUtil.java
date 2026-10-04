package com.samsung.android.sdk.pen.document.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/util/CipherBlockInputStreamUtil;", "Ljava/io/BufferedInputStream;", "<init>", "()V", "inputStream", "Ljava/io/InputStream;", "originalSize", "", "(Ljava/io/InputStream;I)V", "totalSize", "available", "read", "buffer", "", "byteOffset", "byteCount", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CipherBlockInputStreamUtil extends BufferedInputStream {
    private int available;
    private int totalSize;

    private CipherBlockInputStreamUtil() {
        super(null);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i = this.totalSize;
        if (i >= this.available) {
            return -1;
        }
        this.totalSize = i + 1;
        return super.read();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CipherBlockInputStreamUtil(@NotNull InputStream inputStream, int i) {
        super(inputStream);
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        this.available = (16 - (i % 16)) + i;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(@NotNull byte[] buffer, int byteOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i = this.totalSize;
        int i2 = i + byteCount;
        int i4 = this.available;
        if (i2 > i4 && (byteCount = i4 - i) <= 0) {
            return -1;
        }
        int i5 = super.read(buffer, byteOffset, byteCount);
        this.totalSize += i5;
        return i5;
    }
}
