package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBoolean(boolean z);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putByte(byte b);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBytes(ByteBuffer byteBuffer);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBytes(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putBytes(byte[] bArr, int i, int i2);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putChar(char c);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putDouble(double d);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putFloat(float f);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putInt(int i);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putLong(long j);

    @CanIgnoreReturnValue
    <T> Hasher putObject(@ParametricNullness T t, Funnel<? super T> funnel);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putShort(short s);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putString(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    @CanIgnoreReturnValue
    Hasher putUnencodedChars(CharSequence charSequence);
}
