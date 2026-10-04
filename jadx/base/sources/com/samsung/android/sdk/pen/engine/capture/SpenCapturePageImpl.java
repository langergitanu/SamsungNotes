package com.samsung.android.sdk.pen.engine.capture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0018\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/capture/SpenCapturePageImpl;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeCapture", "", "mPageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "mIsHyperText", "", "enable", "isHyperTextViewEnabled", "()Z", "setHyperTextViewEnabled", "(Z)V", "setPageDoc", "", "pageDoc", "setPageDocWithoutRedraw", "compressPage", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "", "ratio", "", "captureRect", "Landroid/graphics/Bitmap;", "rect", "Landroid/graphics/RectF;", "fileName", "capturePage", "width", "", "height", "close", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCapturePageImpl {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenCapturePageImpl";

    @Nullable
    private SpenConfiguration mConfiguration;

    @Nullable
    private SpenDisplay mDisplay;
    private boolean mIsHyperText;
    private long mNativeCapture;

    @Nullable
    private SpenPageDoc mPageDoc;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\t\u001a\u00020\nH\u0083 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0083 J)\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0083 J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0083 J\u001b\u0010\u0016\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0083 J\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0083 J\u0019\u0010\u001b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0083 J!\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0083 J#\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0083 J\t\u0010!\u001a\u00020\u0007H\u0083 J\u0019\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/capture/SpenCapturePageImpl$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isSupported", "", "()Z", "Native_init", "", "Native_finalize", "", "nativeCapture", "Native_construct", "context", "Landroid/content/Context;", "display", "configuration", "Native_setPageDoc", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "Native_setPageDocWithoutRedraw", "Native_capturePage", "bitmap", "Landroid/graphics/Bitmap;", "Native_capturePageAsVectorDrawing", "Native_capturePageFile", "fileName", "Native_captureRect", "rect", "Landroid/graphics/RectF;", "Native_captureRectFile", "Native_isSupported", "Native_setHyperTextViewEnabled", "enabled", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_capturePage(long nativeCapture, Bitmap bitmap) {
            return SpenCapturePageImpl.Native_capturePage(nativeCapture, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_capturePageAsVectorDrawing(long nativeCapture, Bitmap bitmap) {
            return SpenCapturePageImpl.Native_capturePageAsVectorDrawing(nativeCapture, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_capturePageFile(long nativeCapture, String fileName) {
            return SpenCapturePageImpl.Native_capturePageFile(nativeCapture, fileName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_captureRect(long nativeCapture, Bitmap bitmap, RectF rect) {
            return SpenCapturePageImpl.Native_captureRect(nativeCapture, bitmap, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String Native_captureRectFile(long nativeCapture, RectF rect, String fileName) {
            return SpenCapturePageImpl.Native_captureRectFile(nativeCapture, rect, fileName);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_construct(long nativeCapture, Context context, long display, long configuration) {
            return SpenCapturePageImpl.Native_construct(nativeCapture, context, display, configuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeCapture) {
            SpenCapturePageImpl.Native_finalize(nativeCapture);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenCapturePageImpl.Native_init();
        }

        @JvmStatic
        private final boolean Native_isSupported() {
            return SpenCapturePageImpl.Native_isSupported();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setHyperTextViewEnabled(long nativeCapture, boolean enabled) {
            SpenCapturePageImpl.Native_setHyperTextViewEnabled(nativeCapture, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setPageDoc(long nativeCapture, SpenPageDoc pageDoc) {
            return SpenCapturePageImpl.Native_setPageDoc(nativeCapture, pageDoc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setPageDocWithoutRedraw(long nativeCapture, SpenPageDoc pageDoc) {
            return SpenCapturePageImpl.Native_setPageDocWithoutRedraw(nativeCapture, pageDoc);
        }

        public final boolean isSupported() {
            return Native_isSupported();
        }

        private Companion() {
        }
    }

    public SpenCapturePageImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        this.mNativeCapture = companion.Native_init();
        this.mDisplay = new SpenDisplay(context);
        this.mConfiguration = new SpenConfiguration(context);
        long j = this.mNativeCapture;
        SpenDisplay spenDisplay = this.mDisplay;
        Intrinsics.checkNotNull(spenDisplay);
        long j2 = spenDisplay.handle;
        SpenConfiguration spenConfiguration = this.mConfiguration;
        Intrinsics.checkNotNull(spenConfiguration);
        if (companion.Native_construct(j, context, j2, spenConfiguration.getNativeHandle())) {
            return;
        }
        SpenError.ThrowUncheckedException(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_capturePage(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_capturePageAsVectorDrawing(long j, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_capturePageFile(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_captureRect(long j, Bitmap bitmap, RectF rectF);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String Native_captureRectFile(long j, RectF rectF, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_construct(long j, Context context, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isSupported();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setHyperTextViewEnabled(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setPageDoc(long j, SpenPageDoc spenPageDoc);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setPageDocWithoutRedraw(long j, SpenPageDoc spenPageDoc);

    @Nullable
    public final Bitmap capturePage(float ratio) {
        SpenPageDoc spenPageDoc;
        if (this.mNativeCapture == 0 || ratio > 5.0f || (spenPageDoc = this.mPageDoc) == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (spenPageDoc.getWidth() * ratio), (int) (spenPageDoc.getHeight() * ratio), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (INSTANCE.Native_capturePage(this.mNativeCapture, bitmapCreateBitmap)) {
            return bitmapCreateBitmap;
        }
        bitmapCreateBitmap.recycle();
        return null;
    }

    @Nullable
    public final Bitmap captureRect(@Nullable RectF rect) {
        if (this.mNativeCapture != 0 && rect != null && !rect.isEmpty()) {
            try {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) rect.width(), (int) rect.height(), Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                if (INSTANCE.Native_captureRect(this.mNativeCapture, bitmapCreateBitmap, rect)) {
                    return bitmapCreateBitmap;
                }
            } catch (Throwable unused) {
                Log.e(TAG, "Failed to create bitmap w = " + rect.width() + " h = " + rect.height());
                SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
            }
        }
        return null;
    }

    public final void close() {
        SpenConfiguration spenConfiguration = this.mConfiguration;
        if (spenConfiguration != null) {
            spenConfiguration.close();
            this.mConfiguration = null;
        }
        SpenDisplay spenDisplay = this.mDisplay;
        if (spenDisplay != null) {
            spenDisplay.close();
            this.mDisplay = null;
        }
        long j = this.mNativeCapture;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
            this.mNativeCapture = 0L;
        }
        this.mPageDoc = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void compressPage(@Nullable String filename, float ratio) {
        FileOutputStream fileOutputStream;
        if (this.mNativeCapture == 0 || ratio == 0.0f) {
            Log.e(TAG, "ratio = " + ratio);
            return;
        }
        if (filename == null) {
            SpenError.ThrowUncheckedException(9);
            return;
        }
        try {
            Bitmap bitmapCapturePage = capturePage(ratio);
            if (bitmapCapturePage == null) {
                SpenError.ThrowUncheckedException(2);
                return;
            }
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    File file = new File(filename);
                    if (file.createNewFile()) {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            try {
                                bitmapCapturePage.compress(Bitmap.CompressFormat.PNG, 0, fileOutputStream);
                                fileOutputStream3 = fileOutputStream;
                            } catch (Exception e) {
                                e = e;
                                SpenPageDoc spenPageDoc = this.mPageDoc;
                                Integer numValueOf = spenPageDoc != null ? Integer.valueOf(spenPageDoc.getWidth()) : null;
                                SpenPageDoc spenPageDoc2 = this.mPageDoc;
                                Log.d(TAG, "filename = " + filename + " width = " + numValueOf + " height = " + (spenPageDoc2 != null ? Integer.valueOf(spenPageDoc2.getHeight()) : null) + " ratio = " + ratio);
                                e.printStackTrace();
                                bitmapCapturePage.recycle();
                                if (fileOutputStream == null) {
                                    return;
                                } else {
                                    fileOutputStream.close();
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            bitmapCapturePage.recycle();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bitmapCapturePage.recycle();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bitmapCapturePage.recycle();
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            if (fileOutputStream3 != null) {
                fileOutputStream3.close();
            }
        } catch (IllegalArgumentException unused) {
            SpenError.ThrowUncheckedException(7);
        }
    }

    /* JADX INFO: renamed from: isHyperTextViewEnabled, reason: from getter */
    public final boolean getMIsHyperText() {
        return this.mIsHyperText;
    }

    public final void setHyperTextViewEnabled(boolean z) {
        long j = this.mNativeCapture;
        if (j == 0) {
            return;
        }
        this.mIsHyperText = z;
        INSTANCE.Native_setHyperTextViewEnabled(j, z);
    }

    public final void setPageDoc(@Nullable SpenPageDoc pageDoc) {
        if (this.mNativeCapture == 0) {
            return;
        }
        if (pageDoc != null && !pageDoc.isValid()) {
            Log.d(TAG, "setPageDoc is closed");
        } else {
            this.mPageDoc = pageDoc;
            INSTANCE.Native_setPageDoc(this.mNativeCapture, pageDoc);
        }
    }

    public final void setPageDocWithoutRedraw(@Nullable SpenPageDoc pageDoc) {
        if (this.mNativeCapture == 0) {
            return;
        }
        if (pageDoc != null && !pageDoc.isValid()) {
            Log.d(TAG, "setPageDoc is closed");
        } else {
            this.mPageDoc = pageDoc;
            INSTANCE.Native_setPageDocWithoutRedraw(this.mNativeCapture, pageDoc);
        }
    }

    public final boolean capturePage(@Nullable String filename) {
        long j = this.mNativeCapture;
        if (j == 0 || filename == null) {
            return false;
        }
        return INSTANCE.Native_capturePageFile(j, filename);
    }

    @Nullable
    public final String captureRect(@Nullable RectF rect, @Nullable String fileName) {
        if (this.mNativeCapture != 0 && rect != null && !rect.isEmpty() && fileName != null) {
            try {
                return INSTANCE.Native_captureRectFile(this.mNativeCapture, rect, fileName);
            } catch (Throwable unused) {
                Log.e(TAG, "Failed to create bitmap w = " + rect.width() + " h = " + rect.height());
                SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
            }
        }
        return null;
    }

    @Nullable
    public final Bitmap capturePage(int width, int height) {
        if (this.mNativeCapture != 0 && width > 0 && height > 0 && this.mPageDoc != null) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            if (INSTANCE.Native_capturePageAsVectorDrawing(this.mNativeCapture, bitmapCreateBitmap)) {
                return bitmapCreateBitmap;
            }
        }
        return null;
    }
}
