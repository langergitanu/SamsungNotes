package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
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
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006%"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", "challengeTargetLabel", "codeLength", "bindingMethod", MicrosoftAuthorizationResponse.INTERVAL, "challengeChannel", "error", "errorDescription", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTargetLabel", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorDescription", "getInterval", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignUpChallengeApiResponse extends IApiResponse {
    private static final String TAG = "SignUpChallengeApiResponse";

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

    @SerializedName(MicrosoftAuthorizationResponse.INTERVAL)
    @Expose
    @Nullable
    private final Integer interval;

    @Expose
    private int statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignUpChallengeApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable Integer num2, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeType = str2;
        this.challengeTargetLabel = str3;
        this.codeLength = num;
        this.bindingMethod = str4;
        this.interval = num2;
        this.challengeChannel = str5;
        this.error = str6;
        this.errorDescription = str7;
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
    public final SignUpChallengeApiResult toResult() {
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
                return new SignUpChallengeApiResult.UnknownError(str2, str3 != null ? str3 : "", getCorrelationId());
            }
            if (ApiErrorResponseUtilKt.isUnsupportedChallengeType(this.error)) {
                String str4 = this.error;
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = this.errorDescription;
                return new SignUpChallengeApiResult.UnsupportedChallengeType(getCorrelationId(), str4, str5 != null ? str5 : "");
            }
            if (ApiErrorResponseUtilKt.isExpiredToken(this.error)) {
                String str6 = this.error;
                if (str6 == null) {
                    str6 = "";
                }
                String str7 = this.errorDescription;
                return new SignUpChallengeApiResult.ExpiredToken(getCorrelationId(), str6, str7 != null ? str7 : "");
            }
            String str8 = this.error;
            if (str8 == null) {
                str8 = "";
            }
            String str9 = this.errorDescription;
            return new SignUpChallengeApiResult.UnknownError(str8, str9 != null ? str9 : "", getCorrelationId());
        }
        if (ApiErrorResponseUtilKt.isRedirect(this.challengeType)) {
            return new SignUpChallengeApiResult.Redirect(getCorrelationId());
        }
        if (!ApiErrorResponseUtilKt.isOOB(this.challengeType)) {
            if (ApiErrorResponseUtilKt.isPassword(this.challengeType)) {
                String str10 = this.continuationToken;
                return str10 == null ? new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a continuation token with password challenge type", getCorrelationId()) : new SignUpChallengeApiResult.PasswordRequired(getCorrelationId(), str10);
            }
            String str11 = this.error;
            if (str11 == null) {
                str11 = "";
            }
            String str12 = this.errorDescription;
            return new SignUpChallengeApiResult.UnknownError(str11, str12 != null ? str12 : "", getCorrelationId());
        }
        String str13 = this.challengeTargetLabel;
        if (str13 == null || StringsKt.isBlank(str13)) {
            return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a challenge_target_label with oob challenge type", getCorrelationId());
        }
        String str14 = this.challengeChannel;
        if (str14 == null || StringsKt.isBlank(str14)) {
            return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a challenge_channel with oob challenge type", getCorrelationId());
        }
        Integer num = this.codeLength;
        if (num == null) {
            return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a code_length with oob challenge type", getCorrelationId());
        }
        String str15 = this.continuationToken;
        if (str15 == null) {
            return new SignUpChallengeApiResult.UnknownError(ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /challenge did not return a continuation token with oob challenge type", getCorrelationId());
        }
        return new SignUpChallengeApiResult.OOBRequired(getCorrelationId(), str15, this.challengeTargetLabel, this.challengeChannel, num.intValue());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "SignInChallengeApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInChallengeApiResponse(statusCode=");
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
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorDescription, sb);
    }
}
