package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Log;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.capture.SpenCapturePageImpl;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/SpenCapturePage;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mImpl", "Lcom/samsung/android/sdk/pen/engine/capture/SpenCapturePageImpl;", "enable", "", "isHyperTextViewEnabled", "()Z", "setHyperTextViewEnabled", "(Z)V", "_enable", "isThumbnailEnabled", "setThumbnailEnabled", "setPageDoc", "", "pageDoc", "Lcom/samsung/android/sdk/pen/document/SpenPageDoc;", "setPageDocWithoutRedraw", "compressPage", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "", "ratio", "", "captureRect", "Landroid/graphics/Bitmap;", "rect", "Landroid/graphics/RectF;", "capturePage", "fileName", "width", "", "height", "close", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenCapturePage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenCapturePage.kt\ncom/samsung/android/sdk/pen/engine/SpenCapturePage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
public final class SpenCapturePage {

    @NotNull
    private static final String TAG = "SpenCapturePage";

    @Nullable
    private SpenCapturePageImpl mImpl;

    public SpenCapturePage(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (!SpenCapturePageImpl.INSTANCE.isSupported()) {
            Log.d(TAG, "OPenGLES is not supported");
        } else {
            SpenResources.INSTANCE.setResources(context.getResources());
            this.mImpl = new SpenCapturePageImpl(context);
        }
    }

    @Nullable
    public final Bitmap capturePage(float ratio) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            return spenCapturePageImpl.capturePage(ratio);
        }
        return null;
    }

    @Nullable
    public final Bitmap captureRect(@Nullable RectF rect) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            return spenCapturePageImpl.captureRect(rect);
        }
        return null;
    }

    public final void close() {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            spenCapturePageImpl.close();
        }
    }

    public final void compressPage(@Nullable String filename, float ratio) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            spenCapturePageImpl.compressPage(filename, ratio);
        }
    }

    public final boolean isHyperTextViewEnabled() {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            return spenCapturePageImpl.getMIsHyperText();
        }
        return false;
    }

    @Deprecated(message = "")
    public final boolean isThumbnailEnabled() {
        return false;
    }

    public final void setHyperTextViewEnabled(boolean z) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            spenCapturePageImpl.setHyperTextViewEnabled(z);
        }
    }

    public final void setPageDoc(@Nullable SpenPageDoc pageDoc) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            spenCapturePageImpl.setPageDoc(pageDoc);
        }
    }

    public final void setPageDocWithoutRedraw(@Nullable SpenPageDoc pageDoc) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            spenCapturePageImpl.setPageDocWithoutRedraw(pageDoc);
        }
    }

    @Deprecated(message = "")
    public final void setThumbnailEnabled(boolean z) {
    }

    public final boolean capturePage(@Nullable String fileName) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            return spenCapturePageImpl.capturePage(fileName);
        }
        return false;
    }

    @Nullable
    public final String captureRect(@Nullable RectF rect, @Nullable String filename) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            return spenCapturePageImpl.captureRect(rect, filename);
        }
        return null;
    }

    @Nullable
    public final Bitmap capturePage(int width, int height) {
        SpenCapturePageImpl spenCapturePageImpl = this.mImpl;
        if (spenCapturePageImpl != null) {
            return spenCapturePageImpl.capturePage(width, height);
        }
        return null;
    }
}
