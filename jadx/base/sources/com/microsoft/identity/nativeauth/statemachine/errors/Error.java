package com.microsoft.identity.nativeauth.statemachine.errors;

import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\"\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/errors/Error;", "", ImageEditorConst.KEY_ERROR_TYPE, "", "error", "errorMessage", "correlationId", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCodes", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;Ljava/util/List;)V", "getCorrelationId", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorMessage", "getErrorType$msal_distRelease", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public class Error {

    @NotNull
    private final String correlationId;

    @Nullable
    private final String error;

    @Nullable
    private final List<Integer> errorCodes;

    @Nullable
    private final String errorMessage;

    @Nullable
    private final String errorType;

    @Nullable
    private Exception exception;

    public Error(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String correlationId, @Nullable Exception exc, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.errorType = str;
        this.error = str2;
        this.errorMessage = str3;
        this.correlationId = correlationId;
        this.exception = exc;
        this.errorCodes = list;
    }

    @NotNull
    public String getCorrelationId() {
        return this.correlationId;
    }

    @Nullable
    public String getError() {
        return this.error;
    }

    @Nullable
    public List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Nullable
    /* JADX INFO: renamed from: getErrorType$msal_distRelease, reason: from getter */
    public String getErrorType() {
        return this.errorType;
    }

    @Nullable
    public Exception getException() {
        return this.exception;
    }

    public void setException(@Nullable Exception exc) {
        this.exception = exc;
    }

    public /* synthetic */ Error(String str, String str2, String str3, String str4, Exception exc, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, str3, str4, (i & 16) != 0 ? null : exc, (i & 32) != 0 ? null : list);
    }
}
