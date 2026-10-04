package com.samsung.android.sdk.composer.pdf;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.pen.engine.resource.SpenResources;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfExport;", "", "context", "Landroid/content/Context;", "exportType", "", "<init>", "(Landroid/content/Context;I)V", "mNativeHandle", "", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "close", "", "setDocument", "wnote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setTransparentBackgroundColor", "color", "exportFile", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$ResultType;", "defaultHeight", "outPath", "", "creationDate", "cancelExportFile", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenNotePdfExport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenNotePdfExport.kt\ncom/samsung/android/sdk/composer/pdf/SpenNotePdfExport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
public final class SpenNotePdfExport {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int PDF_EXPORT_TYPE_IMAGE = 0;
    public static final int PDF_EXPORT_TYPE_PDF = 1;
    public static final int PDF_EXPORT_TYPE_RASTER = 2;
    public static final int PDF_EXPORT_TYPE_VECTOR = 3;

    @NotNull
    private static final String TAG = "SpenPdfExport";

    @Nullable
    private SpenConfiguration mConfiguration;

    @Nullable
    private SpenDisplay mDisplay;
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0083 J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0083 J\u0019\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0083 J\u0019\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0007H\u0083 J!\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0005H\u0083 J)\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0083 J\u0011\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfExport$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PDF_EXPORT_TYPE_IMAGE", "", "PDF_EXPORT_TYPE_PDF", "PDF_EXPORT_TYPE_RASTER", "getPDF_EXPORT_TYPE_RASTER$annotations", "PDF_EXPORT_TYPE_VECTOR", "getPDF_EXPORT_TYPE_VECTOR$annotations", "Native_init", "", "display", "configuration", "exportType", "editable", "", "systemFontEnabled", "Native_finalize", "", "nativeHandle", "Native_setDocument", "nativeWNote", "Native_setTransparentBackgroundColor", "color", "Native_exportFile", "defaultHeight", "outPath", "Native_exportFileWithCreationDate", "creationDate", "Native_cancelExportFile", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_cancelExportFile(long nativeHandle) {
            SpenNotePdfExport.Native_cancelExportFile(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_exportFile(long nativeHandle, int defaultHeight, String outPath) {
            return SpenNotePdfExport.Native_exportFile(nativeHandle, defaultHeight, outPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_exportFileWithCreationDate(long nativeHandle, int defaultHeight, String outPath, String creationDate) {
            return SpenNotePdfExport.Native_exportFileWithCreationDate(nativeHandle, defaultHeight, outPath, creationDate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenNotePdfExport.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long display, long configuration, int exportType, boolean editable, boolean systemFontEnabled) {
            return SpenNotePdfExport.Native_init(display, configuration, exportType, editable, systemFontEnabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setDocument(long nativeHandle, long nativeWNote) {
            return SpenNotePdfExport.Native_setDocument(nativeHandle, nativeWNote);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setTransparentBackgroundColor(long nativeHandle, int color) {
            return SpenNotePdfExport.Native_setTransparentBackgroundColor(nativeHandle, color);
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getPDF_EXPORT_TYPE_RASTER$annotations() {
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getPDF_EXPORT_TYPE_VECTOR$annotations() {
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenNotePdfExport(@NotNull Context context) {
        this(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_cancelExportFile(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_exportFile(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_exportFileWithCreationDate(long j, int i, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2, int i, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setDocument(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setTransparentBackgroundColor(long j, int i);

    public final void cancelExportFile() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_cancelExportFile(j);
    }

    public final void close() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_finalize(j);
        this.mNativeHandle = 0L;
        SpenConfiguration spenConfiguration = this.mConfiguration;
        Intrinsics.checkNotNull(spenConfiguration);
        spenConfiguration.close();
        SpenDisplay spenDisplay = this.mDisplay;
        Intrinsics.checkNotNull(spenDisplay);
        spenDisplay.close();
        Log.d(TAG, "SpenPdfExport close: " + this);
    }

    @NotNull
    public final ISpenNotePdfManager.ResultType exportFile(int defaultHeight, @NotNull String outPath) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(outPath, "outPath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        int iNative_exportFile = INSTANCE.Native_exportFile(j, defaultHeight, outPath);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_exportFile) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    public final void setDocument(@NotNull SpenWNote wnote) {
        Intrinsics.checkNotNullParameter(wnote, "wnote");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setDocument(j, wnote.getMHandle());
    }

    public final void setTransparentBackgroundColor(int color) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setTransparentBackgroundColor(j, color);
    }

    @JvmOverloads
    public SpenNotePdfExport(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = i == 0 || i == 2;
        boolean z2 = i == 0 || i == 2;
        this.mDisplay = new SpenDisplay(context);
        this.mConfiguration = new SpenConfiguration(context);
        Companion companion = INSTANCE;
        SpenDisplay spenDisplay = this.mDisplay;
        Intrinsics.checkNotNull(spenDisplay);
        long j = spenDisplay.handle;
        SpenConfiguration spenConfiguration = this.mConfiguration;
        Intrinsics.checkNotNull(spenConfiguration);
        this.mNativeHandle = companion.Native_init(j, spenConfiguration.getNativeHandle(), 0, z, z2);
        SpenResources.INSTANCE.setResources(context.getResources());
        Log.d(TAG, "SpenPdfExport : " + this + " type=" + i);
    }

    @NotNull
    public final ISpenNotePdfManager.ResultType exportFile(int defaultHeight, @NotNull String outPath, @NotNull String creationDate) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(outPath, "outPath");
        Intrinsics.checkNotNullParameter(creationDate, "creationDate");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        int iNative_exportFileWithCreationDate = INSTANCE.Native_exportFileWithCreationDate(j, defaultHeight, outPath, creationDate);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_exportFileWithCreationDate) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    public /* synthetic */ SpenNotePdfExport(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }
}
