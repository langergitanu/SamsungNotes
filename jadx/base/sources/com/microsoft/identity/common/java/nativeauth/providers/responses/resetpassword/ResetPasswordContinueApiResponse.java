package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000f¨\u0006!"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", IdentityApiContract.Token.EXPIRES_IN, "error", "errorDescription", "errorUri", "subError", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordContinueApiResponse extends IApiResponse {
    private static final String TAG = "ResetPasswordContinueApiResponse";

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

    @SerializedName("expires_in")
    @Expose
    @Nullable
    private final Integer expiresIn;

    @Expose
    private int statusCode;

    @SerializedName("suberror")
    @Nullable
    private final String subError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordContinueApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeType = str2;
        this.expiresIn = num;
        this.error = str3;
        this.errorDescription = str4;
        this.errorUri = str5;
        this.subError = str6;
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

    @Nullable
    public final Integer getExpiresIn() {
        return this.expiresIn;
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
    public final ResetPasswordContinueApiResult toResult() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(this.challengeType)) {
                return new ResetPasswordContinueApiResult.Redirect(getCorrelationId());
            }
            String str2 = this.continuationToken;
            if (str2 == null) {
                return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "ResetPassword /continue successful, but did not return a continuation token");
            }
            return new ResetPasswordContinueApiResult.PasswordRequired(getCorrelationId(), str2, this.expiresIn);
        }
        if (statusCode != 400) {
            String str3 = this.error;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.errorDescription;
            return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), str3, str4 != null ? str4 : "");
        }
        if (!ApiErrorResponseUtilKt.isInvalidGrant(this.error)) {
            if (ApiErrorResponseUtilKt.isExpiredToken(this.error)) {
                String str5 = this.error;
                if (str5 == null) {
                    str5 = "";
                }
                String str6 = this.errorDescription;
                return new ResetPasswordContinueApiResult.ExpiredToken(getCorrelationId(), str5, str6 != null ? str6 : "");
            }
            String str7 = this.error;
            if (str7 == null) {
                str7 = "";
            }
            String str8 = this.errorDescription;
            return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), str7, str8 != null ? str8 : "");
        }
        if (!ApiErrorResponseUtilKt.isInvalidOOBValue(this.subError)) {
            String str9 = this.error;
            if (str9 == null) {
                str9 = "";
            }
            String str10 = this.errorDescription;
            return new ResetPasswordContinueApiResult.UnknownError(getCorrelationId(), str9, str10 != null ? str10 : "");
        }
        String str11 = this.error;
        if (str11 == null) {
            str11 = "";
        }
        String str12 = this.errorDescription;
        if (str12 == null) {
            str12 = "";
        }
        String str13 = this.subError;
        return new ResetPasswordContinueApiResult.CodeIncorrect(getCorrelationId(), str11, str12, str13 != null ? str13 : "");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("ResetPasswordContinueApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", challengeType=");
        sb.append(this.challengeType);
        sb.append(", expiresIn=");
        sb.append(this.expiresIn);
        sb.append(" error=");
        sb.append(this.error);
        sb.append(", errorUri=");
        sb.append(this.errorUri);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(", subError=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
    }
}
