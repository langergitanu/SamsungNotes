package com.samsung.android.support.senl.p148nt.app.labs;

import com.yubico.yubikit.core.fido.CtapException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.p196io.FilesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/labs/CharEncodingGuesser;", "", "<init>", "()V", "detectEncoding", "Ljava/nio/charset/Charset;", "file", "Ljava/io/File;", "isUtf8", "", "bytes", "", "isLikelyISO88591", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CharEncodingGuesser {

    @NotNull
    public static final CharEncodingGuesser INSTANCE = new CharEncodingGuesser();

    private CharEncodingGuesser() {
    }

    @JvmStatic
    @NotNull
    public static final Charset detectEncoding(@NotNull File file) {
        Charset UTF_8;
        Intrinsics.checkNotNullParameter(file, "file");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[3];
            int i = fileInputStream.read(bArr);
            if (i >= 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
                Charset UTF_82 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                CloseableKt.closeFinally(fileInputStream, null);
                return UTF_82;
            }
            if (i >= 2 && bArr[0] == -1 && bArr[1] == -2) {
                Charset UTF_16LE = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                CloseableKt.closeFinally(fileInputStream, null);
                return UTF_16LE;
            }
            if (i >= 2 && bArr[0] == -2 && bArr[1] == -1) {
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
                CloseableKt.closeFinally(fileInputStream, null);
                return UTF_16BE;
            }
            byte[] bytes = FilesKt.readBytes(file);
            CharEncodingGuesser charEncodingGuesser = INSTANCE;
            if (charEncodingGuesser.isUtf8(bytes)) {
                UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            } else if (charEncodingGuesser.isLikelyISO88591(bytes)) {
                UTF_8 = Charset.forName("EUC-KR");
                Intrinsics.checkNotNullExpressionValue(UTF_8, "forName(...)");
            } else {
                UTF_8 = Charset.forName("EUC-KR");
                Intrinsics.checkNotNullExpressionValue(UTF_8, "forName(...)");
            }
            CloseableKt.closeFinally(fileInputStream, null);
            return UTF_8;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    private final boolean isLikelyISO88591(byte[] bytes) {
        int i = 0;
        int i2 = 0;
        for (byte b : bytes) {
            if ((b & 255) < 128) {
                i2++;
            } else {
                i++;
            }
        }
        return i > 0 && ((double) i) / ((double) (i2 + i)) > 0.2d;
    }

    private final boolean isUtf8(byte[] bytes) {
        int i;
        int i2 = 0;
        while (i2 < bytes.length) {
            byte b = bytes[i2];
            if ((b & 128) == 0) {
                i2++;
            } else if ((b & CtapException.ERR_EXTENSION_FIRST) == 192) {
                int i4 = i2 + 1;
                if (i4 >= bytes.length || (bytes[i4] & 192) != 128) {
                    return false;
                }
                i2 += 2;
            } else {
                if ((b & CtapException.ERR_VENDOR_FIRST) != 224 || (i = i2 + 2) >= bytes.length || (bytes[i2 + 1] & 192) != 128 || (bytes[i] & 192) != 128) {
                    return false;
                }
                i2 += 3;
            }
        }
        return true;
    }
}
