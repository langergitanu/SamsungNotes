package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\rH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/BitmapInspector;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "OFFSET_BITMAP_BIT", "", "OFFSET_BITMAP_WIDTH", "OFFSET_BITMAP_HEIGHT", "OFFSET_BITMAP_SIZE", "MAX_READ_OFFSET", "staticBuffer", "", "isValid", "", "path", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "is", "Ljava/io/InputStream;", "checkValidation", "byteToChar", "", TypedValues.Cycle.S_WAVE_OFFSET, "arr", "byteToInt", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBitmapInspector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitmapInspector.kt\ncom/samsung/android/support/senl/nt/base/common/util/BitmapInspector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
public final class BitmapInspector {
    private static final int MAX_READ_OFFSET = 38;
    private static final int OFFSET_BITMAP_BIT = 28;
    private static final int OFFSET_BITMAP_HEIGHT = 22;
    private static final int OFFSET_BITMAP_SIZE = 34;
    private static final int OFFSET_BITMAP_WIDTH = 18;

    @NotNull
    private static final String TAG = "BitmapInspector";

    @NotNull
    public static final BitmapInspector INSTANCE = new BitmapInspector();

    @NotNull
    private static final byte[] staticBuffer = new byte[38];

    private BitmapInspector() {
    }

    private final char byteToChar(int offset, byte[] arr) {
        return (char) (arr[offset] & 255);
    }

    private final int byteToInt(int offset, byte[] arr) {
        return (arr[offset] & 255) | ((arr[offset + 3] & 255) << 24) | ((arr[offset + 2] & 255) << 16) | ((arr[offset + 1] & 255) << 8);
    }

    private final boolean checkValidation(InputStream is) {
        Logger.m8702i(TAG, "checkValidation# InputStream : " + is);
        try {
            byte[] bArr = staticBuffer;
            if (is.read(bArr, 0, 38) < 0) {
                return true;
            }
            char cByteToChar = byteToChar(0, bArr);
            char cByteToChar2 = byteToChar(1, bArr);
            if (cByteToChar == 'B' && cByteToChar2 == 'M') {
                int iByteToInt = byteToInt(18, bArr);
                int iByteToInt2 = byteToInt(22, bArr);
                if (iByteToInt <= 0 || iByteToInt2 <= 0) {
                    return false;
                }
            }
        } catch (IOException e) {
            AbstractC4539a.m3214x("isValid, e : ", e.getMessage(), TAG);
        }
        return true;
    }

    public final boolean isValid(@Nullable String path) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(path);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        }
        try {
            boolean zIsValid = isValid(fileInputStream);
            try {
                fileInputStream.close();
                return zIsValid;
            } catch (IOException e2) {
                AbstractC4539a.m3214x("isValid, e : ", e2.getMessage(), TAG);
                return zIsValid;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            Logger.m8699e(TAG, "isValid", e);
            if (fileInputStream2 == null) {
                return false;
            }
            try {
                fileInputStream2.close();
                return false;
            } catch (IOException e5) {
                AbstractC4539a.m3214x("isValid, e : ", e5.getMessage(), TAG);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    AbstractC4539a.m3214x("isValid, e : ", e6.getMessage(), TAG);
                }
            }
            throw th;
        }
    }

    @JvmStatic
    public static final boolean isValid(@NotNull Context context, @NotNull Uri uri) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream != null) {
                    boolean zCheckValidation = INSTANCE.checkValidation(inputStreamOpenInputStream);
                    inputStreamOpenInputStream.close();
                    return zCheckValidation;
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                        return true;
                    } catch (IOException e) {
                        AbstractC4539a.m3214x("isValid, e : ", e.getMessage(), TAG);
                    }
                }
                return true;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e2) {
                        AbstractC4539a.m3214x("isValid, e : ", e2.getMessage(), TAG);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            Logger.m8698e(TAG, "isValid, e : " + e3.getMessage());
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e5) {
                    AbstractC4539a.m3214x("isValid, e : ", e5.getMessage(), TAG);
                }
            }
            return true;
        }
    }

    public final boolean isValid(@Nullable InputStream is) throws IOException {
        if (is == null) {
            return true;
        }
        try {
            boolean zCheckValidation = INSTANCE.checkValidation(is);
            is.close();
            return zCheckValidation;
        } catch (Throwable th) {
            try {
                is.close();
            } catch (IOException e) {
                AbstractC4539a.m3214x("isValid, e : ", e.getMessage(), TAG);
            }
            throw th;
        }
    }
}
