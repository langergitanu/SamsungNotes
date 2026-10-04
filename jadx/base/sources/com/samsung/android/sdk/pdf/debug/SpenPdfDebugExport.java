package com.samsung.android.sdk.pdf.debug;

import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ>\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/debug/SpenPdfDebugExport;", "", "filePath", "", "<init>", "(Ljava/lang/String;)V", "nativeHandle", "", "close", "", AbstractCircuitBreaker.PROPERTY_NAME, "", "fileName", "password", "getPageCount", "", "export", "splitFolder", "resultFolder", "historyFolder", "fileBase", "pageIndex", "onlyText", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfDebugExport {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private long nativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0083 J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J%\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0083 J\u0011\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0083 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0083 JI\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\fH\u0083 ¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/debug/SpenPdfDebugExport$Companion;", "", "<init>", "()V", "Native_init", "", "jModelPath", "", "Native_close", "", "nativeHandle", "Native_open", "", UriFileUtils.URI_COLUMN_EVERNOTE_FILENAME, "password", "Native_finalize", "Native_getPageCount", "", "mNativeHandle", "Native_export", "jSplitFolder", "jResultFolder", "jHistoryFolder", "jFilebase", "pageIndex", "onlyText", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private final void Native_close(long nativeHandle) {
            SpenPdfDebugExport.Native_close(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_export(long mNativeHandle, String jSplitFolder, String jResultFolder, String jHistoryFolder, String jFilebase, int pageIndex, boolean onlyText) {
            return SpenPdfDebugExport.Native_export(mNativeHandle, jSplitFolder, jResultFolder, jHistoryFolder, jFilebase, pageIndex, onlyText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SpenPdfDebugExport.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int Native_getPageCount(long mNativeHandle) {
            return SpenPdfDebugExport.Native_getPageCount(mNativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long Native_init(String jModelPath) {
            return SpenPdfDebugExport.Native_init(jModelPath);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_open(long nativeHandle, String filename, String password) {
            return SpenPdfDebugExport.Native_open(nativeHandle, filename, password);
        }

        private Companion() {
        }
    }

    public SpenPdfDebugExport(@Nullable String str) {
        this.nativeHandle = INSTANCE.Native_init(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_close(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_export(long j, String str, String str2, String str3, String str4, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_getPageCount(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long Native_init(String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_open(long j, String str, String str2);

    public final void close() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        INSTANCE.Native_finalize(j);
        this.nativeHandle = 0L;
    }

    public final boolean export(@Nullable String splitFolder, @Nullable String resultFolder, @Nullable String historyFolder, @Nullable String fileBase, int pageIndex, boolean onlyText) {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_export(j, splitFolder, resultFolder, historyFolder, fileBase, pageIndex, onlyText);
    }

    public final int getPageCount() {
        long j = this.nativeHandle;
        if (j == 0) {
            return 0;
        }
        return INSTANCE.Native_getPageCount(j);
    }

    public final boolean open(@Nullable String fileName, @Nullable String password) {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return INSTANCE.Native_open(j, fileName, password);
    }
}
