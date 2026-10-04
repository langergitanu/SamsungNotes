package com.samsung.android.sdk.pen.worddocsync;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR$\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncContentFile;", "", "<init>", "()V", "mNativeHandle", "", "flag", "", "isDownloadRequired", "()Z", "setDownloadRequired", "(Z)V", "fileName", "", "getFileName", "()Ljava/lang/String;", "filePath", "getFilePath", "fileHash", "getFileHash", "url", "getUrl", "setUrl", "(Ljava/lang/String;)V", "checkInitialized", "", "throwUncheckedException", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWDocSyncContentFile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWDocSyncContentFile.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncContentFile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
public final class SpenWDocSyncContentFile {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG = "Model_WDocContentFile";
    private final int mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0083 J\u0011\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 J\u0019\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005H\u0083 J\u0011\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncContentFile$Companion;", "", "<init>", "()V", "LOG_TAG", "", "WDocSyncContentFile_setDownloadRequired", "", "nativeHandle", "", "flag", "WDocSyncContentFile_isDownloadRequired", "WDocSyncContentFile_getFileName", "WDocSyncContentFile_getFilePath", "WDocSyncContentFile_getFileHash", "WDocSyncContentFile_setUrl", "url", "WDocSyncContentFile_getUrl", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncContentFile_getFileHash(int nativeHandle) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_getFileHash(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncContentFile_getFileName(int nativeHandle) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_getFileName(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncContentFile_getFilePath(int nativeHandle) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_getFilePath(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncContentFile_getUrl(int nativeHandle) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_getUrl(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncContentFile_isDownloadRequired(int nativeHandle) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_isDownloadRequired(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncContentFile_setDownloadRequired(int nativeHandle, boolean flag) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_setDownloadRequired(nativeHandle, flag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncContentFile_setUrl(int nativeHandle, String url) {
            return SpenWDocSyncContentFile.WDocSyncContentFile_setUrl(nativeHandle, url);
        }

        private Companion() {
        }
    }

    private SpenWDocSyncContentFile() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncContentFile_getFileHash(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncContentFile_getFileName(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncContentFile_getFilePath(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncContentFile_getUrl(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncContentFile_isDownloadRequired(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncContentFile_setDownloadRequired(int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncContentFile_setUrl(int i, String str);

    private final void checkInitialized() {
        if (this.mNativeHandle == 0) {
            throw new IllegalStateException("native handle is not initialized");
        }
    }

    private final void throwUncheckedException() {
        int error = SpenError.getError();
        if (error != 19) {
            SpenError.ThrowUncheckedException(error);
            return;
        }
        throw new SpenAlreadyClosedException("SpenWDocSyncData(" + this + ") is already closed");
    }

    @NotNull
    public final String getFileHash() {
        checkInitialized();
        return INSTANCE.WDocSyncContentFile_getFileHash(this.mNativeHandle);
    }

    @NotNull
    public final String getFileName() {
        checkInitialized();
        return INSTANCE.WDocSyncContentFile_getFileName(this.mNativeHandle);
    }

    @NotNull
    public final String getFilePath() {
        checkInitialized();
        return INSTANCE.WDocSyncContentFile_getFilePath(this.mNativeHandle);
    }

    @NotNull
    public final String getUrl() {
        checkInitialized();
        return INSTANCE.WDocSyncContentFile_getUrl(this.mNativeHandle);
    }

    public final boolean isDownloadRequired() {
        checkInitialized();
        return INSTANCE.WDocSyncContentFile_isDownloadRequired(this.mNativeHandle);
    }

    public final void setDownloadRequired(boolean z) {
        checkInitialized();
        if (INSTANCE.WDocSyncContentFile_setDownloadRequired(this.mNativeHandle, z)) {
            return;
        }
        throwUncheckedException();
    }

    public final void setUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        checkInitialized();
        if (INSTANCE.WDocSyncContentFile_setUrl(this.mNativeHandle, url)) {
            return;
        }
        throwUncheckedException();
    }
}
