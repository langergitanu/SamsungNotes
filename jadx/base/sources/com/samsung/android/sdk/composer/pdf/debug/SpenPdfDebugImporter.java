package com.samsung.android.sdk.composer.pdf.debug;

import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eJ\u0016\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eJ\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000eJ\u0016\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/debug/SpenPdfDebugImporter;", "", "<init>", "()V", "mNativeHandle", "", "pageCount", "", "getPageCount", "()I", "close", "", "openFile", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "", "password", "getPageWidth", "index", "getPageHeight", "hasOwnerPermission", "hasAppData", "", "tag", "getAppData", "outFilename", "removeAppData", "saveFile", "removeOverlayImageTag", "isEmptyPage", "ignoreTag", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfDebugImporter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenPdfDebugImporter";
    private final long mNativeHandle = INSTANCE.Native_init();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J#\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\fH\u0083 J\u0019\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\fH\u0083 J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0083 J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 J!\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 J\u0019\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 J!\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 J!\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 J\u0019\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/pdf/debug/SpenPdfDebugImporter$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "Native_init", "", "Native_close", "", "nativeHandle", "Native_openFile", "", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "password", "Native_getPageCount", "mNativeHandle", "Native_getPageWidth", "index", "Native_getPageHeight", "Native_hasOwnerPermission", "Native_hasAppData", "", "tag", "Native_getAppData", "Native_removeAppData", "Native_isEmptyPage", "Native_removeOverlayImageTag", "Native_saveFile", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_close(long nativeHandle) {
            SpenPdfDebugImporter.Native_close(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_getAppData(long mNativeHandle, String filename, String tag) {
            return SpenPdfDebugImporter.Native_getAppData(mNativeHandle, filename, tag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long mNativeHandle) {
            return SpenPdfDebugImporter.Native_getPageCount(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageHeight(long mNativeHandle, int index) {
            return SpenPdfDebugImporter.Native_getPageHeight(mNativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageWidth(long mNativeHandle, int index) {
            return SpenPdfDebugImporter.Native_getPageWidth(mNativeHandle, index);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_hasAppData(long mNativeHandle, String tag) {
            return SpenPdfDebugImporter.Native_hasAppData(mNativeHandle, tag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_hasOwnerPermission(long mNativeHandle) {
            return SpenPdfDebugImporter.Native_hasOwnerPermission(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init() {
            return SpenPdfDebugImporter.Native_init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_isEmptyPage(long mNativeHandle, int index, String tag) {
            return SpenPdfDebugImporter.Native_isEmptyPage(mNativeHandle, index, tag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_openFile(long nativeHandle, String filename, String password) {
            return SpenPdfDebugImporter.Native_openFile(nativeHandle, filename, password);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_removeAppData(long mNativeHandle, String tag) {
            return SpenPdfDebugImporter.Native_removeAppData(mNativeHandle, tag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_removeOverlayImageTag(long mNativeHandle, int index, String tag) {
            return SpenPdfDebugImporter.Native_removeOverlayImageTag(mNativeHandle, index, tag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_saveFile(long mNativeHandle, String filename) {
            return SpenPdfDebugImporter.Native_saveFile(mNativeHandle, filename);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_close(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_getAppData(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageHeight(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageWidth(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_hasAppData(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_hasOwnerPermission(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_isEmptyPage(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_openFile(long j, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_removeAppData(long j, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_removeOverlayImageTag(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_saveFile(long j, String str);

    public final void close() {
        INSTANCE.Native_close(this.mNativeHandle);
    }

    public final boolean getAppData(@NotNull String outFilename, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(outFilename, "outFilename");
        Intrinsics.checkNotNullParameter(tag, "tag");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_getAppData(j, outFilename, tag);
    }

    public final int getPageCount() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getPageCount(j);
    }

    public final int getPageHeight(int index) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getPageHeight(j, index);
    }

    public final int getPageWidth(int index) {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_getPageWidth(j, index);
    }

    public final boolean hasAppData(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_hasAppData(j, tag);
    }

    public final int hasOwnerPermission() {
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_hasOwnerPermission(j);
    }

    public final boolean isEmptyPage(int index, @NotNull String ignoreTag) {
        Intrinsics.checkNotNullParameter(ignoreTag, "ignoreTag");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_isEmptyPage(j, index, ignoreTag);
    }

    public final int openFile(@NotNull String filename, @Nullable String password) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_openFile(j, filename, password);
    }

    public final boolean removeAppData(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_removeAppData(j, tag);
    }

    public final boolean removeOverlayImageTag(int index, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        long j = this.mNativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_removeOverlayImageTag(j, index, tag);
    }

    public final int saveFile(@NotNull String outFilename) {
        Intrinsics.checkNotNullParameter(outFilename, "outFilename");
        long j = this.mNativeHandle;
        if (j == 0) {
            return -1;
        }
        return INSTANCE.Native_saveFile(j, outFilename);
    }
}
