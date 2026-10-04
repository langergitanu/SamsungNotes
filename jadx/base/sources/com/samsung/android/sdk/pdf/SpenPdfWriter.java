package com.samsung.android.sdk.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ$\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J(\u0010\u001b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001`\u001e2\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J:\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00142\u001e\u0010 \u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001`\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J\b\u0010,\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfWriter;", "Lcom/samsung/android/sdk/pdf/SpenIPdfWriter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "nativeHandle", "", "display", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "configuration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "close", "", AbstractCircuitBreaker.PROPERTY_NAME, "", "fileName", "", "password", "documentWidth", "", "save", "outFileName", "getPageCount", "getPageSize", "Landroid/graphics/RectF;", "pageIndex", "getPageRichTextList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "setOverlayRichText", "listTextParagraph", "dstLanguageTag", "getPageImage", "Landroid/graphics/Bitmap;", "ratio", "", "setOverlayImage", "pdfPageIndex", "overlayImage", "setWatermarkString", "watermarkString", "lockFile", "unlockFile", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfWriter implements SpenIPdfWriter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenPdfWriter";

    @Nullable
    private SpenConfiguration configuration;

    @Nullable
    private SpenDisplay display;
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0083 J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J#\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u000fH\u0083 J\u0011\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0083 JC\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\u001e\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0083 J1\u0010\"\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u0001` 2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0083 J#\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0083 J#\u0010'\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010$H\u0083 J\u001b\u0010)\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010+\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 J\u0011\u0010,\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/SpenPdfWriter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "display", "configuration", "aiModelPath", "Native_finalize", "", "nativeHandle", "Native_open", "", "mNativeHandle", "fileName", "password", "documentWidth", "", "Native_save", "outFileName", "isRasterize", "Native_getPageCount", "Native_getPageSize", "Landroid/graphics/RectF;", "pageIndex", "Native_setOverlayRichText", "pdfParagraphList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pdf/SpenPdfParagraph;", "Lkotlin/collections/ArrayList;", "dstLanguageTag", "Native_getPageRichTextList", "Native_getPageImage", "Landroid/graphics/Bitmap;", "ratio", "", "Native_setOverlayImage", "overlayImage", "Native_setWatermarkString", "watermarkString", "Native_lockFile", "Native_unlockFile", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenPdfWriter.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long mNativeHandle) {
            return SpenPdfWriter.Native_getPageCount(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Bitmap Native_getPageImage(long nativeHandle, int pageIndex, float ratio) {
            return SpenPdfWriter.Native_getPageImage(nativeHandle, pageIndex, ratio);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ArrayList<SpenPdfParagraph> Native_getPageRichTextList(long nativeHandle, int pageIndex) {
            return SpenPdfWriter.Native_getPageRichTextList(nativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final RectF Native_getPageSize(long mNativeHandle, int pageIndex) {
            return SpenPdfWriter.Native_getPageSize(mNativeHandle, pageIndex);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long display, long configuration, String aiModelPath) {
            return SpenPdfWriter.Native_init(display, configuration, aiModelPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_lockFile(long mNativeHandle) {
            return SpenPdfWriter.Native_lockFile(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_open(long mNativeHandle, String fileName, String password, int documentWidth) {
            return SpenPdfWriter.Native_open(mNativeHandle, fileName, password, documentWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_save(long mNativeHandle, String outFileName, boolean isRasterize) {
            return SpenPdfWriter.Native_save(mNativeHandle, outFileName, isRasterize);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setOverlayImage(long nativeHandle, int pageIndex, Bitmap overlayImage) {
            return SpenPdfWriter.Native_setOverlayImage(nativeHandle, pageIndex, overlayImage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setOverlayRichText(long nativeHandle, int pageIndex, ArrayList<SpenPdfParagraph> pdfParagraphList, String dstLanguageTag) {
            SpenPdfWriter.Native_setOverlayRichText(nativeHandle, pageIndex, pdfParagraphList, dstLanguageTag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setWatermarkString(long nativeHandle, String watermarkString) {
            SpenPdfWriter.Native_setWatermarkString(nativeHandle, watermarkString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_unlockFile(long mNativeHandle) {
            return SpenPdfWriter.Native_unlockFile(mNativeHandle);
        }

        private Companion() {
        }
    }

    public SpenPdfWriter(@Nullable Context context) {
        if (context == null) {
            SpenError.ThrowUncheckedException(8, " : context must not be null");
            Unit unit = Unit.INSTANCE;
        }
        this.display = new SpenDisplay(context);
        this.configuration = new SpenConfiguration(context);
        Companion companion = INSTANCE;
        SpenDisplay spenDisplay = this.display;
        Intrinsics.checkNotNull(spenDisplay);
        long j = spenDisplay.handle;
        SpenConfiguration spenConfiguration = this.configuration;
        Intrinsics.checkNotNull(spenConfiguration);
        long nativeHandle = spenConfiguration.getNativeHandle();
        Intrinsics.checkNotNull(context);
        this.nativeHandle = companion.Native_init(j, nativeHandle, new SpenPdfAIModelLoader(context).getModelPath());
        SpenResources.INSTANCE.setResources(context.getResources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native Bitmap Native_getPageImage(long j, int i, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ArrayList<SpenPdfParagraph> Native_getPageRichTextList(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native RectF Native_getPageSize(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_lockFile(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_open(long j, String str, String str2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_save(long j, String str, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setOverlayImage(long j, int i, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setOverlayRichText(long j, int i, ArrayList<SpenPdfParagraph> arrayList, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setWatermarkString(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_unlockFile(long j);

    public final synchronized void close() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_finalize(j);
        this.nativeHandle = 0L;
        SpenConfiguration spenConfiguration = this.configuration;
        Intrinsics.checkNotNull(spenConfiguration);
        spenConfiguration.close();
        SpenDisplay spenDisplay = this.display;
        Intrinsics.checkNotNull(spenDisplay);
        spenDisplay.close();
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public int getPageCount() {
        long j = this.nativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageCount(j);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    @Nullable
    public Bitmap getPageImage(int pageIndex, float ratio) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageImage(j, pageIndex, ratio);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    @Nullable
    public ArrayList<SpenPdfParagraph> getPageRichTextList(int pageIndex) {
        long j = this.nativeHandle;
        if (j == 0) {
            return null;
        }
        return INSTANCE.Native_getPageRichTextList(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    @Nullable
    public RectF getPageSize(int pageIndex) {
        long j = this.nativeHandle;
        return j == 0 ? new RectF() : INSTANCE.Native_getPageSize(j, pageIndex);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public boolean lockFile() {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_lockFile(j);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public boolean open(@Nullable String fileName, @Nullable String password, int documentWidth) {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_open(j, fileName, password, documentWidth);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public boolean save(@Nullable String outFileName) {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_save(j, outFileName, true);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public boolean setOverlayImage(int pdfPageIndex, @Nullable Bitmap overlayImage) {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_setOverlayImage(j, pdfPageIndex, overlayImage);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public void setOverlayRichText(int pageIndex, @Nullable ArrayList<SpenPdfParagraph> listTextParagraph, @Nullable String dstLanguageTag) {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setOverlayRichText(j, pageIndex, listTextParagraph, dstLanguageTag);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public void setWatermarkString(@Nullable String watermarkString) {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setWatermarkString(j, watermarkString);
    }

    @Override // com.samsung.android.sdk.pdf.SpenIPdfWriter
    public boolean unlockFile() {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_unlockFile(j);
    }
}
