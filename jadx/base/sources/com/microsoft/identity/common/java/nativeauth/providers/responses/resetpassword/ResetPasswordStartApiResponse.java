package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResult;
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
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", "error", "errorDescription", "errorUri", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordStartApiResponse extends IApiResponse {
    private static final String TAG = "ResetPasswordStartApiResponse";

    @SerializedName("challenge_type")
    @Expose
    @Nullable
    private final String challengeType;

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

    @Expose
    private int statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordStartApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeType = str2;
        this.error = str3;
        this.errorDescription = str4;
        this.errorUri = str5;
    }

    @Nullable
    public final String getChallengeType() {
        return this.challengeType;
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

    @Override // com.microsoft.identity.common.java.nativeauth.providers.IApiResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @NotNull
    public final ResetPasswordStartApiResult toResult() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(this.challengeType)) {
                return new ResetPasswordStartApiResult.Redirect(getCorrelationId());
            }
            String str2 = this.continuationToken;
            return str2 == null ? new ResetPasswordStartApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "ResetPassword /start returned redirect challenge, but did not return a flow token") : new ResetPasswordStartApiResult.Success(str2, getCorrelationId());
        }
        if (statusCode != 400) {
            String str3 = this.error;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.errorDescription;
            return new ResetPasswordStartApiResult.UnknownError(getCorrelationId(), str3, str4 != null ? str4 : "");
        }
        if (ApiErrorResponseUtilKt.isUserNotFound(this.error)) {
            String str5 = this.error;
            if (str5 == null) {
                str5 = "";
            }
            String str6 = this.errorDescription;
            return new ResetPasswordStartApiResult.UserNotFound(getCorrelationId(), str5, str6 != null ? str6 : "");
        }
        if (ApiErrorResponseUtilKt.isUnsupportedChallengeType(this.error)) {
            String str7 = this.error;
            if (str7 == null) {
                str7 = "";
            }
            String str8 = this.errorDescription;
            return new ResetPasswordStartApiResult.UnsupportedChallengeType(getCorrelationId(), str7, str8 != null ? str8 : "");
        }
        String str9 = this.error;
        if (str9 == null) {
            str9 = "";
        }
        String str10 = this.errorDescription;
        return new ResetPasswordStartApiResult.UnknownError(getCorrelationId(), str9, str10 != null ? str10 : "");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordStartApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("ResetPasswordStartApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", challengeType=");
        sb.append(this.challengeType);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", errorUri=");
        sb.append(this.errorUri);
        sb.append(", errorDescription=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
    }
}
