package com.samsung.android.support.senl.p145cm.base.common.util;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/BaseImageUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_TEXTURE_SIZE", "", "maxTextureSize", "getMaxTextureSize$annotations", "getMaxTextureSize", "()I", "getImageRatio", "", "filePath", "getImageSize", "Landroid/graphics/Rect;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseImageUtils {

    @NotNull
    public static final BaseImageUtils INSTANCE = new BaseImageUtils();
    private static int MAX_TEXTURE_SIZE = -1;

    @NotNull
    private static final String TAG = "ImageUtils";

    private BaseImageUtils() {
    }

    @JvmStatic
    public static final float getImageRatio(@Nullable String filePath) {
        if (INSTANCE.getImageSize(filePath).isEmpty()) {
            return 1.0f;
        }
        return r1.height() / r1.width();
    }

    public static final int getMaxTextureSize() {
        int i = MAX_TEXTURE_SIZE;
        if (i > 0) {
            return i;
        }
        EGL egl = EGLContext.getEGL();
        Intrinsics.checkNotNull(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        EGL10 egl10 = (EGL10) egl;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (eGLDisplayEglGetDisplay == null) {
            return 2048;
        }
        egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        egl10.eglGetConfigs(eGLDisplayEglGetDisplay, null, 0, iArr);
        int i2 = iArr[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i2];
        egl10.eglGetConfigs(eGLDisplayEglGetDisplay, eGLConfigArr, i2, iArr);
        int[] iArr2 = new int[1];
        int i4 = iArr[0];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i6], 12332, iArr2);
            int i7 = iArr2[0];
            if (i5 < i7) {
                i5 = i7;
            }
        }
        egl10.eglTerminate(eGLDisplayEglGetDisplay);
        int iMax = (int) Math.max(i5, 2048);
        MAX_TEXTURE_SIZE = iMax;
        if (iMax > 8192) {
            MAX_TEXTURE_SIZE = 8192;
        }
        return MAX_TEXTURE_SIZE;
    }

    @NotNull
    public final Rect getImageSize(@Nullable String filePath) {
        Rect rect = new Rect(0, 0, 0, 0);
        if (!TextUtils.isEmpty(filePath) && BaseFileUtils.exists(filePath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, options);
            rect.set(0, 0, options.outWidth, options.outHeight);
            LoggerBase.INSTANCE.m7132d(TAG, "getImageSize, size : " + rect);
        }
        return rect;
    }

    @JvmStatic
    public static /* synthetic */ void getMaxTextureSize$annotations() {
    }
}
