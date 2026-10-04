package com.samsung.android.support.senl.p145cm.base.framework.support;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.KeyCharacterMap;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u001a\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/BaseUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mApplicationContext", "Landroid/content/Context;", "mProviderContext", "getApplicationContext", "setApplicationContext", "", "context", "setProviderContext", "getContext", "mHasSoftKey", "", "hasSoftKey", "", "copyFile", "src", "dst", "copyFileFromContentUri", "srcUri", "Landroid/net/Uri;", "copyFileFromStream", "inputStream", "Ljava/io/InputStream;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"StaticFieldLeak"})
@SourceDebugExtension({"SMAP\nBaseUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseUtils.kt\ncom/samsung/android/support/senl/cm/base/framework/support/BaseUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final class BaseUtils {

    @NotNull
    private static final String TAG = "BaseUtils";

    @Nullable
    private static Context mApplicationContext;

    @Nullable
    private static Context mProviderContext;

    @NotNull
    public static final BaseUtils INSTANCE = new BaseUtils();
    private static int mHasSoftKey = -1;

    private BaseUtils() {
    }

    @JvmStatic
    public static final void copyFile(@Nullable String src, @NotNull String dst) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        FileInputStream fileInputStream = new FileInputStream(src);
        try {
            INSTANCE.copyFileFromStream(fileInputStream, dst);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileInputStream, null);
        } finally {
        }
    }

    @JvmStatic
    public static final void copyFileFromContentUri(@Nullable Uri srcUri, @NotNull String dst) {
        ContentResolver contentResolver;
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (srcUri == null) {
            return;
        }
        Context applicationContext = getApplicationContext();
        InputStream inputStreamOpenInputStream = (applicationContext == null || (contentResolver = applicationContext.getContentResolver()) == null) ? null : contentResolver.openInputStream(srcUri);
        try {
            INSTANCE.copyFileFromStream(inputStreamOpenInputStream, dst);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(inputStreamOpenInputStream, null);
        } finally {
        }
    }

    private final void copyFileFromStream(InputStream inputStream, String dst) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(dst));
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        bArr = new byte[1024];
                    } finally {
                    }
                } finally {
                }
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i <= 0) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedOutputStream, null);
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        return;
                    }
                    bufferedOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (IOException e) {
            AbstractC0000a.m23t("copyFile : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            throw e;
        }
    }

    @JvmStatic
    @Nullable
    public static final Context getApplicationContext() {
        Context context = mApplicationContext;
        return context == null ? mProviderContext : context;
    }

    @JvmStatic
    @NotNull
    public static final Context getContext() {
        Context context = mApplicationContext;
        if (context != null) {
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.content.Context");
            return context;
        }
        Context context2 = mProviderContext;
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.Context");
        return context2;
    }

    @JvmStatic
    public static final void setApplicationContext(@Nullable Context context) {
        mApplicationContext = context;
    }

    @JvmStatic
    public static final void setProviderContext(@Nullable Context context) {
        mProviderContext = context;
    }

    public final boolean hasSoftKey() {
        if (mHasSoftKey == -1) {
            try {
                mHasSoftKey = !KeyCharacterMap.deviceHasKey(4) ? 1 : 0;
            } catch (Exception unused) {
                return false;
            }
        }
        LoggerBase.INSTANCE.m7132d(TAG, "hasSoftKey " + mHasSoftKey);
        return mHasSoftKey == 1;
    }
}
