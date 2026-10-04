package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public interface HashFunction {
    int bits();

    HashCode hashBytes(ByteBuffer byteBuffer);

    HashCode hashBytes(byte[] bArr);

    HashCode hashBytes(byte[] bArr, int i, int i2);

    HashCode hashInt(int i);

    HashCode hashLong(long j);

    <T> HashCode hashObject(@ParametricNullness T t, Funnel<? super T> funnel);

    HashCode hashString(CharSequence charSequence, Charset charset);

    HashCode hashUnencodedChars(CharSequence charSequence);

    Hasher newHasher();

    Hasher newHasher(int i);
}
