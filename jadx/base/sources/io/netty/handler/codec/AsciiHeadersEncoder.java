package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class AsciiHeadersEncoder {
    private final ByteBuf buf;
    private final NewlineType newlineType;
    private final SeparatorType separatorType;

    /* JADX INFO: renamed from: io.netty.handler.codec.AsciiHeadersEncoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C124791 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType */
        static final /* synthetic */ int[] f8869x354ada9;

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType */
        static final /* synthetic */ int[] f8870xcf2033ba;

        static {
            int[] iArr = new int[NewlineType.values().length];
            f8869x354ada9 = iArr;
            try {
                iArr[NewlineType.LF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8869x354ada9[NewlineType.CRLF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SeparatorType.values().length];
            f8870xcf2033ba = iArr2;
            try {
                iArr2[SeparatorType.COLON.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8870xcf2033ba[SeparatorType.COLON_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum NewlineType {
        LF,
        CRLF
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SeparatorType {
        COLON,
        COLON_SPACE
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf) {
        this(byteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
    }

    private static void writeAscii(ByteBuf byteBuf, int i, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i, charSequence.length());
        } else {
            byteBuf.setCharSequence(i, charSequence, CharsetUtil.US_ASCII);
        }
    }

    public void encode(Map.Entry<CharSequence, CharSequence> entry) {
        int i;
        int i2;
        CharSequence key = entry.getKey();
        CharSequence value = entry.getValue();
        ByteBuf byteBuf = this.buf;
        int length = key.length();
        int length2 = value.length();
        int iWriterIndex = byteBuf.writerIndex();
        byteBuf.ensureWritable(length + length2 + 4);
        writeAscii(byteBuf, iWriterIndex, key);
        int i4 = iWriterIndex + length;
        int i5 = C124791.f8870xcf2033ba[this.separatorType.ordinal()];
        if (i5 == 1) {
            byteBuf.setByte(i4, 58);
            i = i4 + 1;
        } else {
            if (i5 != 2) {
                throw new Error();
            }
            int i6 = i4 + 1;
            byteBuf.setByte(i4, 58);
            i = i4 + 2;
            byteBuf.setByte(i6, 32);
        }
        writeAscii(byteBuf, i, value);
        int i7 = i + length2;
        int i8 = C124791.f8869x354ada9[this.newlineType.ordinal()];
        if (i8 == 1) {
            byteBuf.setByte(i7, 10);
            i2 = i7 + 1;
        } else {
            if (i8 != 2) {
                throw new Error();
            }
            int i9 = i7 + 1;
            byteBuf.setByte(i7, 13);
            i2 = i7 + 2;
            byteBuf.setByte(i9, 10);
        }
        byteBuf.writerIndex(i2);
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf, SeparatorType separatorType, NewlineType newlineType) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
        this.separatorType = (SeparatorType) ObjectUtil.checkNotNull(separatorType, "separatorType");
        this.newlineType = (NewlineType) ObjectUtil.checkNotNull(newlineType, "newlineType");
    }
}
