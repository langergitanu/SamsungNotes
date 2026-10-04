package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0017\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000e¨\u0006\""}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "pollInterval", "error", "errorDescription", "errorUri", "subError", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getError", "getErrorDescription", "getErrorUri", "getPollInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "clampPollInterval", "pollIntervalInSeconds", "(Ljava/lang/Integer;)I", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordSubmitApiResponse extends IApiResponse {
    private static final int DEFAULT_POLL_COMPLETION_INTERVAL_IN_SECONDS = 2;
    private static final int MAXIMUM_POLL_COMPLETION_INTERVAL_IN_SECONDS = 15;
    private static final int MINIMUM_POLL_COMPLETION_INTERVAL_IN_SECONDS = 1;

    @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
    @Nullable
    private final String continuationToken;

    @SerializedName("error")
    @Nullable
    private final String error;

    @SerializedName("error_description")
    @Nullable
    private final String errorDescription;

    @SerializedName("error_uri")
    @Nullable
    private final String errorUri;

    @SerializedName("poll_interval")
    @Expose
    @Nullable
    private final Integer pollInterval;

    @Expose
    private int statusCode;

    @SerializedName("suberror")
    @Nullable
    private final String subError;
    private static final String TAG = "ResetPasswordSubmitApiResponse";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordSubmitApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.pollInterval = num;
        this.error = str2;
        this.errorDescription = str3;
        this.errorUri = str4;
        this.subError = str5;
    }

    private final int clampPollInterval(Integer pollIntervalInSeconds) {
        if (pollIntervalInSeconds == null || pollIntervalInSeconds.intValue() < 1 || pollIntervalInSeconds.intValue() > 15) {
            return 2;
        }
        return pollIntervalInSeconds.intValue();
    }

    @Nullable
    public final String getContinuationToken() {
        return this.continuationToken;
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @Nullable
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    @Nullable
    public final String getErrorUri() {
        return this.errorUri;
    }

    @Nullable
    public final Integer getPollInterval() {
        return this.pollInterval;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.IApiResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    @Nullable
    public final String getSubError() {
        return this.subError;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @NotNull
    public final ResetPasswordSubmitApiResult toResult() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            String str2 = this.continuationToken;
            return str2 == null ? new ResetPasswordSubmitApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "ResetPassword /submit successful, but did not return a flow token") : new ResetPasswordSubmitApiResult.SubmitSuccess(str2, clampPollInterval(this.pollInterval), getCorrelationId());
        }
        if (statusCode != 400) {
            String str3 = this.error;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.errorDescription;
            return new ResetPasswordSubmitApiResult.UnknownError(getCorrelationId(), str3, str4 != null ? str4 : "");
        }
        if (ApiErrorResponseUtilKt.isPasswordBanned(this.subError) || ApiErrorResponseUtilKt.isPasswordTooShort(this.subError) || ApiErrorResponseUtilKt.isPasswordTooLong(this.subError) || ApiErrorResponseUtilKt.isPasswordRecentlyUsed(this.subError) || ApiErrorResponseUtilKt.isPasswordTooWeak(this.subError) || ApiErrorResponseUtilKt.isPasswordInvalid(this.subError)) {
            String str5 = this.error;
            if (str5 == null) {
                str5 = "";
            }
            String str6 = this.errorDescription;
            if (str6 == null) {
                str6 = "";
            }
            String str7 = this.subError;
            return new ResetPasswordSubmitApiResult.PasswordInvalid(getCorrelationId(), str5, str6, str7 != null ? str7 : "");
        }
        if (ApiErrorResponseUtilKt.isExpiredToken(this.error)) {
            String str8 = this.error;
            if (str8 == null) {
                str8 = "";
            }
            String str9 = this.errorDescription;
            return new ResetPasswordSubmitApiResult.ExpiredToken(getCorrelationId(), str8, str9 != null ? str9 : "");
        }
        String str10 = this.error;
        if (str10 == null) {
            str10 = "";
        }
        String str11 = this.errorDescription;
        return new ResetPasswordSubmitApiResult.UnknownError(getCorrelationId(), str10, str11 != null ? str11 : "");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordSubmitApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("ResetPasswordSubmitApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", pollInterval=");
        sb.append(this.pollInterval);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", errorUri=");
        sb.append(this.errorUri);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(", subError=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
    }
}
