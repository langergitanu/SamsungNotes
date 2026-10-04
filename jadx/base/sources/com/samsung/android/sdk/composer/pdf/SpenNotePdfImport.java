package com.samsung.android.sdk.composer.pdf;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.view.SpenDisplay;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\rJ\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ*\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&J \u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010)\u001a\u00020\rJ \u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020 J*\u0010-\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020 2\u0006\u0010.\u001a\u00020\rH\u0002J\u0010\u0010/\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\rH\u0002J\"\u00100\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020 R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfImport;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mNativeHandle", "", "mDisplay", "Lcom/samsung/android/sdk/pen/view/SpenDisplay;", "mConfiguration", "Lcom/samsung/android/sdk/pen/view/SpenConfiguration;", "tempFile", "", "getTempFile", "()Ljava/lang/String;", "close", "", "setDocument", "wnote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "attachFile", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$ResultType;", "pageIndex", "", "filePath", "password", "hasOwnerPermission", "hasPassword", "", "verifyPassword", "getPageMode", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$PageMode;", "hasPageExtractionPermission", "getPageCount", "getPageBitmap", "Landroid/graphics/Bitmap;", "pageWidth", "", "removeAppData", "srcPath", "dstPath", "getNoteOrientation", "Lcom/samsung/android/sdk/composer/pdf/ISpenNotePdfManager$NoteOrientation;", DBSchema.Document.PAGE_MODE, "getAppData", "outPath", "removeTempFile", "copyNoteCustomData", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenNotePdfImport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenNotePdfImport.kt\ncom/samsung/android/sdk/composer/pdf/SpenNotePdfImport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
public final class SpenNotePdfImport {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenPdfImport";

    @Nullable
    private SpenConfiguration mConfiguration;

    @Nullable
    private Context mContext;

    @Nullable
    private SpenDisplay mDisplay;
    private long mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0083 J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0083 J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0083 J3\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0019\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0083 J#\u0010\u0018\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u0019\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0083 J#\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0083 J3\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0083 J3\u0010 \u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0083 J+\u0010#\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0005H\u0083 J3\u0010&\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/SpenNotePdfImport$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "display", "configuration", "Native_finalize", "", "nativeHandle", "Native_setDocument", "", "nativeWNote", "Native_attachFile", "", "cacheDirPath", "pageIndex", "filePath", "password", "Native_hasOwnerPermission", "Native_hasPassword", "Native_verifyPassword", "Native_getPageMode", "Native_hasPageExtractionPermission", "Native_getPageCount", "mNativeHandle", "Native_getPageSize", "", "pageWidth", "Native_getPageImage", "bitmap", "Landroid/graphics/Bitmap;", "Native_removeAppData", "srcPath", "dstPath", "Native_getAppData", DBSchema.Document.PAGE_MODE, "outPath", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_attachFile(long nativeHandle, String cacheDirPath, int pageIndex, String filePath, String password) {
            return SpenNotePdfImport.Native_attachFile(nativeHandle, cacheDirPath, pageIndex, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenNotePdfImport.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getAppData(long nativeHandle, String filePath, String password, int pageMode, String outPath) {
            return SpenNotePdfImport.Native_getAppData(nativeHandle, filePath, password, pageMode, outPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long mNativeHandle, String filePath, String password) {
            return SpenNotePdfImport.Native_getPageCount(mNativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_getPageImage(long nativeHandle, String filePath, String password, int pageIndex, Bitmap bitmap) {
            return SpenNotePdfImport.Native_getPageImage(nativeHandle, filePath, password, pageIndex, bitmap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageMode(long nativeHandle, String filePath, String password) {
            return SpenNotePdfImport.Native_getPageMode(nativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final float Native_getPageSize(long nativeHandle, String filePath, String password, int pageIndex, float pageWidth) {
            return SpenNotePdfImport.Native_getPageSize(nativeHandle, filePath, password, pageIndex, pageWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_hasOwnerPermission(long nativeHandle, String filePath, String password) {
            return SpenNotePdfImport.Native_hasOwnerPermission(nativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasPageExtractionPermission(long nativeHandle, String filePath, String password) {
            return SpenNotePdfImport.Native_hasPageExtractionPermission(nativeHandle, filePath, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasPassword(long nativeHandle, String filePath) {
            return SpenNotePdfImport.Native_hasPassword(nativeHandle, filePath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(long display, long configuration) {
            return SpenNotePdfImport.Native_init(display, configuration);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_removeAppData(long nativeHandle, String srcPath, String password, String dstPath) {
            return SpenNotePdfImport.Native_removeAppData(nativeHandle, srcPath, password, dstPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setDocument(long nativeHandle, long nativeWNote) {
            return SpenNotePdfImport.Native_setDocument(nativeHandle, nativeWNote);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_verifyPassword(long nativeHandle, String filePath, String password) {
            return SpenNotePdfImport.Native_verifyPassword(nativeHandle, filePath, password);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenWNote.Orientation.values().length];
            try {
                iArr[SpenWNote.Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenWNote.Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpenWNote.Orientation.LANDSCAPE_NEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpenNotePdfImport(@Nullable Context context) {
        this.mContext = context;
        this.mDisplay = new SpenDisplay(this.mContext);
        this.mConfiguration = new SpenConfiguration(this.mContext);
        Companion companion = INSTANCE;
        SpenDisplay spenDisplay = this.mDisplay;
        Intrinsics.checkNotNull(spenDisplay);
        long j = spenDisplay.handle;
        SpenConfiguration spenConfiguration = this.mConfiguration;
        Intrinsics.checkNotNull(spenConfiguration);
        this.mNativeHandle = companion.Native_init(j, spenConfiguration.getNativeHandle());
        Log.d(TAG, "SpenPdfImport : " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_attachFile(long j, String str, int i, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getAppData(long j, String str, String str2, int i, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_getPageImage(long j, String str, String str2, int i, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageMode(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native float Native_getPageSize(long j, String str, String str2, int i, float f);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_hasOwnerPermission(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasPageExtractionPermission(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasPassword(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_removeAppData(long j, String str, String str2, String str3);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setDocument(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_verifyPassword(long j, String str, String str2);

    private final ISpenNotePdfManager.ResultType getAppData(String filePath, String password, ISpenNotePdfManager.PageMode pageMode, String outPath) {
        ISpenNotePdfManager.ResultType resultType;
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        int iNative_getAppData = INSTANCE.Native_getAppData(j, filePath, password, pageMode.ordinal(), outPath);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_getAppData) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    private final String getTempFile() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        String str = context.getFilesDir().getAbsolutePath() + "/" + System.currentTimeMillis();
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }

    private final void removeTempFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.delete()) {
            return;
        }
        AbstractC4539a.m3207q("fail to delete file[", filePath, "]", TAG);
    }

    @NotNull
    public final ISpenNotePdfManager.ResultType attachFile(int pageIndex, @NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        Companion companion = INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        int iNative_attachFile = companion.Native_attachFile(j, absolutePath, pageIndex, filePath, password);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_attachFile) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
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
        this.mContext = null;
        Log.d(TAG, "SpenPdfImport close: " + this);
    }

    @Nullable
    public final String copyNoteCustomData(@NotNull String filePath, @Nullable String password, @NotNull ISpenNotePdfManager.PageMode pageMode) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(pageMode, "pageMode");
        if (this.mNativeHandle == 0) {
            return null;
        }
        String tempFile = getTempFile();
        if (getAppData(filePath, password, pageMode, tempFile) != ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS) {
            return null;
        }
        String appCustomData = SpenWNoteFile.getAppCustomData(tempFile);
        removeTempFile(tempFile);
        return appCustomData;
    }

    @NotNull
    public final ISpenNotePdfManager.NoteOrientation getNoteOrientation(@NotNull String filePath, @Nullable String password, @NotNull ISpenNotePdfManager.PageMode pageMode) {
        ISpenNotePdfManager.NoteOrientation noteOrientation;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(pageMode, "pageMode");
        if (this.mNativeHandle == 0) {
            return ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_NONE;
        }
        ISpenNotePdfManager.NoteOrientation noteOrientation2 = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_NONE;
        String tempFile = getTempFile();
        if (getAppData(filePath, password, pageMode, tempFile) != ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS) {
            return noteOrientation2;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[SpenWNoteFile.getOrientation(tempFile).ordinal()];
        if (i == 1) {
            noteOrientation = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_PORTRAIT;
        } else if (i == 2) {
            noteOrientation = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            noteOrientation = ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE_NEW;
        }
        removeTempFile(tempFile);
        return noteOrientation;
    }

    @Nullable
    public final Bitmap getPageBitmap(@NotNull String filePath, @Nullable String password, int pageIndex, float pageWidth) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j != 0 && pageWidth != 0.0f && pageIndex >= 0) {
            Companion companion = INSTANCE;
            float fNative_getPageSize = companion.Native_getPageSize(j, filePath, password, pageIndex, pageWidth);
            Log.d(TAG, "getPageBitmap : " + pageWidth + " x " + fNative_getPageSize);
            if (fNative_getPageSize == 0.0f) {
                return null;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) pageWidth, (int) fNative_getPageSize, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            if (companion.Native_getPageImage(this.mNativeHandle, filePath, password, pageIndex, bitmapCreateBitmap)) {
                return bitmapCreateBitmap;
            }
            bitmapCreateBitmap.recycle();
        }
        return null;
    }

    public final int getPageCount(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getPageCount(j, filePath, password);
    }

    @NotNull
    public final ISpenNotePdfManager.PageMode getPageMode(@NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.PageMode pageMode;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.PageMode.PAGE_MODE_NONE;
        }
        int iNative_getPageMode = INSTANCE.Native_getPageMode(j, filePath, password);
        ISpenNotePdfManager.PageMode[] pageModeArrValues = ISpenNotePdfManager.PageMode.values();
        int length = pageModeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                pageMode = null;
                break;
            }
            pageMode = pageModeArrValues[i];
            if (pageMode.ordinal() == iNative_getPageMode) {
                break;
            }
            i++;
        }
        return pageMode == null ? ISpenNotePdfManager.PageMode.PAGE_MODE_NONE : pageMode;
    }

    @NotNull
    public final ISpenNotePdfManager.ResultType hasOwnerPermission(@NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN;
        }
        int iNative_hasOwnerPermission = INSTANCE.Native_hasOwnerPermission(j, filePath, password);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_hasOwnerPermission) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }

    public final boolean hasPageExtractionPermission(@NotNull String filePath, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_hasPageExtractionPermission(j, filePath, password);
    }

    public final boolean hasPassword(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_hasPassword(j, filePath);
    }

    public final boolean removeAppData(@NotNull String srcPath, @Nullable String password, @NotNull String dstPath) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(dstPath, "dstPath");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_removeAppData(j, srcPath, password, dstPath);
    }

    public final void setDocument(@NotNull SpenWNote wnote) {
        Intrinsics.checkNotNullParameter(wnote, "wnote");
        long j = this.mNativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_setDocument(j, wnote.getMHandle());
    }

    @NotNull
    public final ISpenNotePdfManager.ResultType verifyPassword(@NotNull String filePath, @Nullable String password) {
        ISpenNotePdfManager.ResultType resultType;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        long j = this.mNativeHandle;
        if (j == 0) {
            ISpenNotePdfManager.ResultType resultType2 = ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS;
        }
        int iNative_verifyPassword = INSTANCE.Native_verifyPassword(j, filePath, password);
        ISpenNotePdfManager.ResultType[] resultTypeArrValues = ISpenNotePdfManager.ResultType.values();
        int length = resultTypeArrValues.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                resultType = null;
                break;
            }
            resultType = resultTypeArrValues[i];
            if (resultType.ordinal() == iNative_verifyPassword) {
                break;
            }
            i++;
        }
        return resultType == null ? ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_UNKNOWN : resultType;
    }
}
