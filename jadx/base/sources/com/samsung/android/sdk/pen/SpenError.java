package com.samsung.android.sdk.pen;

import android.os.Build;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0007J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0007J\t\u00105\u001a\u00020\u0005H\u0083 J\t\u00106\u001a\u00020#H\u0083 J\t\u00107\u001a\u00020\u0005H\u0083 J\u000b\u00108\u001a\u0004\u0018\u00010#H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020+8BX\u0083\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0003\u001a\u0004\b*\u0010-R\u001a\u0010.\u001a\u00020+8BX\u0083\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0003\u001a\u0004\b.\u0010-R\u001a\u00100\u001a\u00020+8BX\u0083\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0003\u001a\u0004\b0\u0010-¨\u00069"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenError;", "", "<init>", "()V", "E_UNKNOWN", "", "E_OUT_OF_MEMORY", "E_OUT_OF_RANGE", "E_ALREADY_INIT", "E_ALREADY_SET", "E_INVALID_DATA", "E_INVALID_ARG", "E_INVALID_STATE", "E_DATA_NOT_FOUND", "E_FILE_NOT_FOUND", "E_FILE_CAN_NOT_OPEN", "E_UNSUPPORTED_VERSION", "E_UNSUPPORTED_TYPE", "E_PERMISSION_DENY", "E_LIBRARY_NOT_FOUND", "E_LIBRARY_NOT_LOADED", "E_INVALID_PASSWORD", "E_INSTANCE_NOT_LOADED", "E_ALREADY_CLOSED", "E_EXCEED_IMAGE_LIMIT", "E_EXCEED_TEXT_LIMIT", "E_FORCE_STOP", "E_CONTENT_ALREADY_ADDED", "E_BOUND_FILE_NOT_FOUND", "E_INVALID_CACHE", "error", "getError$annotations", "getError", "()I", "message", "", "getMessage$annotations", "getMessage", "()Ljava/lang/String;", "errorModule", "getErrorModule$annotations", "getErrorModule", "isBuildTypeEngMode", "", "isBuildTypeEngMode$annotations", "()Z", "isBuildTypeUserMode", "isBuildTypeUserMode$annotations", "isBuildTypeUserDebugMode", "isBuildTypeUserDebugMode$annotations", "ThrowUncheckedException", "", "exceptionNum", "Error_GetError", "Error_GetMessage", "Error_GetErrorLine", "Error_GetErrorFileName", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenError {
    public static final int E_ALREADY_CLOSED = 19;
    public static final int E_ALREADY_INIT = 4;
    public static final int E_ALREADY_SET = 5;
    public static final int E_BOUND_FILE_NOT_FOUND = 24;
    public static final int E_CONTENT_ALREADY_ADDED = 23;
    public static final int E_DATA_NOT_FOUND = 9;
    public static final int E_EXCEED_IMAGE_LIMIT = 20;
    public static final int E_EXCEED_TEXT_LIMIT = 21;
    public static final int E_FILE_CAN_NOT_OPEN = 11;
    public static final int E_FILE_NOT_FOUND = 10;
    public static final int E_FORCE_STOP = 22;
    public static final int E_INSTANCE_NOT_LOADED = 18;
    public static final int E_INVALID_ARG = 7;
    public static final int E_INVALID_CACHE = 25;
    public static final int E_INVALID_DATA = 6;
    public static final int E_INVALID_PASSWORD = 17;
    public static final int E_INVALID_STATE = 8;
    public static final int E_LIBRARY_NOT_FOUND = 15;
    public static final int E_LIBRARY_NOT_LOADED = 16;
    public static final int E_OUT_OF_MEMORY = 2;
    public static final int E_OUT_OF_RANGE = 3;
    public static final int E_PERMISSION_DENY = 14;
    public static final int E_UNKNOWN = 1;
    public static final int E_UNSUPPORTED_TYPE = 13;
    public static final int E_UNSUPPORTED_VERSION = 12;

    @NotNull
    public static final SpenError INSTANCE = new SpenError();

    private SpenError() {
    }

    @JvmStatic
    private static final native int Error_GetError();

    @JvmStatic
    private static final native String Error_GetErrorFileName();

    @JvmStatic
    private static final native int Error_GetErrorLine();

    @JvmStatic
    private static final native String Error_GetMessage();

    @JvmStatic
    public static final void ThrowUncheckedException(int exceptionNum) {
        String errorModule = getErrorModule();
        String strM772n = errorModule.length() > 0 ? AbstractC0541b.m772n(" : ", errorModule) : "";
        if (exceptionNum == 1) {
            throw new RuntimeException(AbstractC0541b.m772n("E_UNKNOWN", strM772n));
        }
        if (exceptionNum == 2) {
            throw new OutOfMemoryError(AbstractC0541b.m772n("E_OUT_OF_MEMORY", strM772n));
        }
        if (exceptionNum == 3) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m772n("E_OUT_OF_RANGE", strM772n));
        }
        if (exceptionNum == 4) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_ALREADY_INIT", strM772n));
        }
        if (exceptionNum == 5) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_ALREADY_SET", strM772n));
        }
        if (exceptionNum == 7) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("E_INVALID_ARG", strM772n));
        }
        if (exceptionNum == 8) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_INVALID_STATE", strM772n));
        }
        if (exceptionNum == 9) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_DATA_NOT_FOUND", strM772n));
        }
        if (exceptionNum == 12) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_UNSUPPORTED_VERSION", strM772n));
        }
        if (exceptionNum == 18) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_INSTANCE_NOT_LOADED", strM772n));
        }
        if (exceptionNum == 23) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_CONTENT_ALREADY_ADDED", strM772n));
        }
        throw new RuntimeException(AbstractC0541b.m767i(exceptionNum, "Error number is ", strM772n));
    }

    public static final int getError() {
        return Error_GetError();
    }

    @JvmStatic
    public static /* synthetic */ void getError$annotations() {
    }

    @NotNull
    public static final String getErrorModule() {
        String strError_GetErrorFileName = Error_GetErrorFileName();
        return (strError_GetErrorFileName == null || strError_GetErrorFileName.length() == 0) ? "" : AbstractC1974b.m1319l("[", Error_GetErrorLine(), strError_GetErrorFileName, "](", ")");
    }

    @JvmStatic
    public static /* synthetic */ void getErrorModule$annotations() {
    }

    @NotNull
    public static final String getMessage() {
        return Error_GetMessage();
    }

    @JvmStatic
    public static /* synthetic */ void getMessage$annotations() {
    }

    private static final boolean isBuildTypeEngMode() {
        return Intrinsics.areEqual("eng", Build.TYPE);
    }

    @JvmStatic
    private static /* synthetic */ void isBuildTypeEngMode$annotations() {
    }

    private static final boolean isBuildTypeUserDebugMode() {
        return Intrinsics.areEqual("userdebug", Build.TYPE);
    }

    @JvmStatic
    private static /* synthetic */ void isBuildTypeUserDebugMode$annotations() {
    }

    private static final boolean isBuildTypeUserMode() {
        return Intrinsics.areEqual(IdentityApiContract.Token.USER, Build.TYPE);
    }

    @JvmStatic
    private static /* synthetic */ void isBuildTypeUserMode$annotations() {
    }

    @JvmStatic
    public static final void ThrowUncheckedException(int exceptionNum, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String strM774p = " : " + message;
        String errorModule = getErrorModule();
        if (errorModule.length() > 0) {
            strM774p = AbstractC0541b.m774p(" : ", errorModule, " : ", message);
        }
        if (exceptionNum == 1) {
            throw new RuntimeException(AbstractC0541b.m772n("E_UNKNOWN", strM774p));
        }
        if (exceptionNum == 2) {
            throw new OutOfMemoryError(AbstractC0541b.m772n("E_OUT_OF_MEMORY", strM774p));
        }
        if (exceptionNum == 3) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m772n("E_OUT_OF_RANGE", strM774p));
        }
        if (exceptionNum == 4) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_ALREADY_INIT", strM774p));
        }
        if (exceptionNum == 5) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_ALREADY_SET", strM774p));
        }
        if (exceptionNum == 7) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("E_INVALID_ARG", strM774p));
        }
        if (exceptionNum == 8) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_INVALID_STATE", strM774p));
        }
        if (exceptionNum == 9) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_DATA_NOT_FOUND", strM774p));
        }
        if (exceptionNum == 12) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_UNSUPPORTED_VERSION", strM774p));
        }
        if (exceptionNum == 18) {
            throw new IllegalStateException(AbstractC0541b.m772n("E_INSTANCE_NOT_LOADED", strM774p));
        }
        if (exceptionNum != 23) {
            throw new RuntimeException(AbstractC0541b.m767i(exceptionNum, "Error number is ", strM774p));
        }
        throw new IllegalStateException(AbstractC0541b.m772n("E_CONTENT_ALREADY_ADDED", strM774p));
    }
}
