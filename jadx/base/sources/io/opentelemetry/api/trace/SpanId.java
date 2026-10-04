package io.opentelemetry.api.trace;

import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.internal.TemporaryBuffers;
import io.opentelemetry.api.internal.ValidationUtil;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public final class SpanId {
    private static final int BYTES_LENGTH = 8;
    private static final int HEX_LENGTH = 16;
    private static final String INVALID = "0000000000000000";

    private SpanId() {
    }

    public static String fromBytes(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            ValidationUtil.log("spanIdBytes is null or too short");
            return INVALID;
        }
        char[] cArrChars = TemporaryBuffers.chars(16);
        OtelEncodingUtils.bytesToBase16(bArr, cArrChars, 8);
        return new String(cArrChars, 0, 16);
    }

    public static String fromLong(long j) {
        if (j == 0) {
            return getInvalid();
        }
        char[] cArrChars = TemporaryBuffers.chars(16);
        OtelEncodingUtils.longToBase16String(j, cArrChars, 0);
        return new String(cArrChars, 0, 16);
    }

    public static String getInvalid() {
        return INVALID;
    }

    public static int getLength() {
        return 16;
    }

    public static boolean isValid(CharSequence charSequence) {
        return charSequence != null && charSequence.length() == 16 && !INVALID.contentEquals(charSequence) && OtelEncodingUtils.isValidBase16String(charSequence);
    }
}
