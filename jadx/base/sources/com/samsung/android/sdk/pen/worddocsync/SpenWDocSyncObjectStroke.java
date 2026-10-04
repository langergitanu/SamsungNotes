package com.samsung.android.sdk.pen.worddocsync;

import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncObjectStroke;", "", "<init>", "()V", "mNativeHandle", "", "uuid", "", "getUuid", "()Ljava/lang/String;", "modifiedTime", "", "getModifiedTime", "()J", CoeditServiceConstants.Attribute.KEY_STROKE_BINARY, "", "getStrokeBinary", "()[B", "applyStrokeBinary", "", "checkInitialized", "throwUncheckedException", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenWDocSyncObjectStroke.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenWDocSyncObjectStroke.kt\ncom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncObjectStroke\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n1#2:65\n*E\n"})
public final class SpenWDocSyncObjectStroke {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String LOG_TAG = "Model_WDocObjectStroke";
    private final int mNativeHandle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0083 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0083 J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0083 J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddocsync/SpenWDocSyncObjectStroke$Companion;", "", "<init>", "()V", "LOG_TAG", "", "WDocSyncObjectStroke_getUuid", "nativeHandle", "", "WDocSyncObjectStroke_getModifiedTime", "", "WDocSyncObjectStroke_getStrokeBinary", "", "WDocSyncObjectStroke_applyStrokeBinary", "", CoeditServiceConstants.Attribute.KEY_STROKE_BINARY, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean WDocSyncObjectStroke_applyStrokeBinary(int nativeHandle, byte[] strokeBinary) {
            return SpenWDocSyncObjectStroke.WDocSyncObjectStroke_applyStrokeBinary(nativeHandle, strokeBinary);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long WDocSyncObjectStroke_getModifiedTime(int nativeHandle) {
            return SpenWDocSyncObjectStroke.WDocSyncObjectStroke_getModifiedTime(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final byte[] WDocSyncObjectStroke_getStrokeBinary(int nativeHandle) {
            return SpenWDocSyncObjectStroke.WDocSyncObjectStroke_getStrokeBinary(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String WDocSyncObjectStroke_getUuid(int nativeHandle) {
            return SpenWDocSyncObjectStroke.WDocSyncObjectStroke_getUuid(nativeHandle);
        }

        private Companion() {
        }
    }

    private SpenWDocSyncObjectStroke() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean WDocSyncObjectStroke_applyStrokeBinary(int i, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native long WDocSyncObjectStroke_getModifiedTime(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native byte[] WDocSyncObjectStroke_getStrokeBinary(int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native String WDocSyncObjectStroke_getUuid(int i);

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

    public final void applyStrokeBinary(@NotNull byte[] strokeBinary) {
        Intrinsics.checkNotNullParameter(strokeBinary, "strokeBinary");
        checkInitialized();
        if (INSTANCE.WDocSyncObjectStroke_applyStrokeBinary(this.mNativeHandle, strokeBinary)) {
            return;
        }
        throwUncheckedException();
    }

    public final long getModifiedTime() {
        checkInitialized();
        return INSTANCE.WDocSyncObjectStroke_getModifiedTime(this.mNativeHandle);
    }

    @NotNull
    public final byte[] getStrokeBinary() {
        checkInitialized();
        return INSTANCE.WDocSyncObjectStroke_getStrokeBinary(this.mNativeHandle);
    }

    @NotNull
    public final String getUuid() {
        checkInitialized();
        return INSTANCE.WDocSyncObjectStroke_getUuid(this.mNativeHandle);
    }
}
