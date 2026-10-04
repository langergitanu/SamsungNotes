package com.samsung.android.sdk.composer.document.sdoc.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0010H&J\b\u0010\u0017\u001a\u00020\u0010H&J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/util/ComponentUtil;", "", "<init>", "()V", "isChanged", "", "()Z", "setChanged", "(Z)V", "currentFormatVersion", "", "getCurrentFormatVersion", "()I", "setCurrentFormatVersion", "(I)V", "writeString", "", "raf", "Ljava/io/RandomAccessFile;", "data", "", "readString", "writeFile", "readFile", "fileNames", "", "getFileNames", "()[Ljava/lang/String;", "changeCacheDir", "newPath", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class ComponentUtil {
    public static final int BASE_FORMAT_VERSION = 6;

    @NotNull
    public static final String END_FILE_TAG_DATA = "EOF";
    public static final int END_FILE_TAG_DATA_SIZE = 3;

    @NotNull
    public static final String END_FILE_TAG_SDOC = "Document for SAMSUNG Note";
    public static final int END_FILE_TAG_SDOC_SIZE = 25;
    public static final int FORMAT_VERSION = 31;

    @NotNull
    private static final String TAG = "SDocComponent";
    private int currentFormatVersion;
    private boolean isChanged;

    public abstract void changeCacheDir(@Nullable String newPath);

    public final int getCurrentFormatVersion() {
        return this.currentFormatVersion;
    }

    @Nullable
    public abstract String[] getFileNames();

    /* JADX INFO: renamed from: isChanged, reason: from getter */
    public final boolean getIsChanged() {
        return this.isChanged;
    }

    public abstract void readFile();

    @Nullable
    public final String readString(@NotNull RandomAccessFile raf) throws IOException {
        StringBuilder sb;
        Intrinsics.checkNotNullParameter(raf, "raf");
        int i = raf.readInt();
        if (i > 0) {
            byte[] bArr = new byte[1026];
            sb = new StringBuilder(i);
            int i2 = i * 2;
            while (i2 > 1024) {
                int i4 = raf.read(bArr, 0, 1024);
                i2 -= 1024;
                if (((bArr[1022] & 255) >> 2) == 54 && i2 >= 2) {
                    int i5 = raf.read(bArr, 1024, 2);
                    i4 += i5;
                    i2 -= i5;
                }
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
                sb.append(new String(bArr, 0, i4, UTF_16BE));
            }
            if (i2 > 0) {
                int i6 = raf.read(bArr, 0, i2);
                Charset UTF_16BE2 = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE2, "UTF_16BE");
                sb.append(new String(bArr, 0, i6, UTF_16BE2));
            }
        } else {
            sb = null;
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    public final void setChanged(boolean z) {
        this.isChanged = z;
    }

    public final void setCurrentFormatVersion(int i) {
        this.currentFormatVersion = i;
    }

    public abstract void writeFile();

    public final void writeString(@NotNull RandomAccessFile raf, @Nullable String data) throws IOException {
        Intrinsics.checkNotNullParameter(raf, "raf");
        int length = (data == null || data.length() <= 0) ? 0 : data.length();
        raf.writeInt(length);
        if (length > 0) {
            raf.writeChars(data);
        }
    }
}
