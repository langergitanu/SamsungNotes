package com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006'"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", "bindingMethod", "challengeTargetLabel", "challengeChannel", "codeLength", MicrosoftAuthorizationResponse.INTERVAL, "error", "errorDescription", "errorUri", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTargetLabel", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorDescription", "getErrorUri", "getInterval", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordChallengeApiResponse extends IApiResponse {
    private static final String TAG = "ResetPasswordChallengeApiResponse";

    @SerializedName("binding_method")
    @Expose
    @Nullable
    private final String bindingMethod;

    @SerializedName("challenge_channel")
    @Expose
    @Nullable
    private final String challengeChannel;

    @SerializedName("challenge_target_label")
    @Nullable
    private final String challengeTargetLabel;

    @SerializedName("challenge_type")
    @Expose
    @Nullable
    private final String challengeType;

    @SerializedName("code_length")
    @Expose
    @Nullable
    private final Integer codeLength;

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

    @SerializedName(MicrosoftAuthorizationResponse.INTERVAL)
    @Expose
    @Nullable
    private final Integer interval;

    @Expose
    private int statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordChallengeApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable Integer num2, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeType = str2;
        this.bindingMethod = str3;
        this.challengeTargetLabel = str4;
        this.challengeChannel = str5;
        this.codeLength = num;
        this.interval = num2;
        this.error = str6;
        this.errorDescription = str7;
        this.errorUri = str8;
    }

    @Nullable
    public final String getBindingMethod() {
        return this.bindingMethod;
    }

    @Nullable
    public final String getChallengeChannel() {
        return this.challengeChannel;
    }

    @Nullable
    public final String getChallengeTargetLabel() {
        return this.challengeTargetLabel;
    }

    @Nullable
    public final String getChallengeType() {
        return this.challengeType;
    }

    @Nullable
    public final Integer getCodeLength() {
        return this.codeLength;
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
    public final Integer getInterval() {
        return this.interval;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.IApiResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @NotNull
    public final ResetPasswordChallengeApiResult toResult() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode != 200) {
            if (statusCode != 400) {
                String str2 = this.error;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = this.errorDescription;
                return new ResetPasswordChallengeApiResult.UnknownError(str2, str3 != null ? str3 : "", getCorrelationId());
            }
            if (ApiErrorResponseUtilKt.isExpiredToken(this.error)) {
                String str4 = this.error;
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = this.errorDescription;
                return new ResetPasswordChallengeApiResult.ExpiredToken(str4, str5 != null ? str5 : "", getCorrelationId());
            }
            if (ApiErrorResponseUtilKt.isUnsupportedChallengeType(this.error)) {
                String str6 = this.error;
                if (str6 == null) {
                    str6 = "";
                }
                String str7 = this.errorDescription;
                return new ResetPasswordChallengeApiResult.UnsupportedChallengeType(getCorrelationId(), str6, str7 != null ? str7 : "");
            }
            String str8 = this.error;
            if (str8 == null) {
                str8 = "";
            }
            String str9 = this.errorDescription;
            return new ResetPasswordChallengeApiResult.UnknownError(str8, str9 != null ? str9 : "", getCorrelationId());
        }
        if (ApiErrorResponseUtilKt.isRedirect(this.challengeType)) {
            return new ResetPasswordChallengeApiResult.Redirect(getCorrelationId());
        }
        if (!ApiErrorResponseUtilKt.isOOB(this.challengeType)) {
            String str10 = this.error;
            if (str10 == null) {
                str10 = "";
            }
            String str11 = this.errorDescription;
            return new ResetPasswordChallengeApiResult.UnknownError(str10, str11 != null ? str11 : "", getCorrelationId());
        }
        String str12 = this.challengeTargetLabel;
        if (str12 == null || StringsKt.isBlank(str12)) {
            return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge did not return a challenge_target_label with oob challenge type", getCorrelationId());
        }
        String str13 = this.challengeChannel;
        if (str13 == null || StringsKt.isBlank(str13)) {
            return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge did not return a challenge_channel with oob challenge type", getCorrelationId());
        }
        Integer num = this.codeLength;
        if (num == null) {
            return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge did not return a code_length with oob challenge type", getCorrelationId());
        }
        String str14 = this.continuationToken;
        if (str14 == null) {
            return new ResetPasswordChallengeApiResult.UnknownError(ErrorTypes.INVALID_STATE, "ResetPassword /challenge successful, but did not return a continuation token", getCorrelationId());
        }
        return new ResetPasswordChallengeApiResult.CodeRequired(getCorrelationId(), str14, this.challengeTargetLabel, this.challengeChannel, num.intValue());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordChallengeApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("ResetPasswordChallengeApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", challengeType=");
        sb.append(this.challengeType);
        sb.append(", bindingMethod=");
        sb.append(this.bindingMethod);
        sb.append(", challengeTargetLabel=");
        sb.append(this.challengeTargetLabel);
        sb.append(", challengeChannel=");
        sb.append(this.challengeChannel);
        sb.append(", codeLength=");
        sb.append(this.codeLength);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(", errorUri=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorUri, sb);
    }
}
