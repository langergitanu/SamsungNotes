package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface PrimitiveSink {
    @CanIgnoreReturnValue
    PrimitiveSink putBoolean(boolean z);

    @CanIgnoreReturnValue
    PrimitiveSink putByte(byte b);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr);

    @CanIgnoreReturnValue
    PrimitiveSink putBytes(byte[] bArr, int i, int i2);

    @CanIgnoreReturnValue
    PrimitiveSink putChar(char c);

    @CanIgnoreReturnValue
    PrimitiveSink putDouble(double d);

    @CanIgnoreReturnValue
    PrimitiveSink putFloat(float f);

    @CanIgnoreReturnValue
    PrimitiveSink putInt(int i);

    @CanIgnoreReturnValue
    PrimitiveSink putLong(long j);

    @CanIgnoreReturnValue
    PrimitiveSink putShort(short s);

    @CanIgnoreReturnValue
    PrimitiveSink putString(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
