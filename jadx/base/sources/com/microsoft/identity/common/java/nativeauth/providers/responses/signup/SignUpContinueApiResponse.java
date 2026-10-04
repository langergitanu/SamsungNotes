package com.microsoft.identity.common.java.nativeauth.providers.responses.signup;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0001(B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R*\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017¨\u0006)"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", IdentityApiContract.Token.EXPIRES_IN, "unverifiedAttributes", "", "", "invalidAttributes", "requiredAttributes", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "error", "errorCodes", "errorDescription", "subError", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getExpiresIn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInvalidAttributes", "getRequiredAttributes", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "getUnverifiedAttributes", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignUpContinueApiResponse extends IApiResponse {
    private static final String TAG = "SignUpContinueApiResponse";

    @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
    @Nullable
    private final String continuationToken;

    @SerializedName("error")
    @Nullable
    private final String error;

    @SerializedName("error_codes")
    @Nullable
    private final List<Integer> errorCodes;

    @SerializedName("error_description")
    @Nullable
    private final String errorDescription;

    @SerializedName("expires_in")
    @Expose
    @Nullable
    private final Integer expiresIn;

    @SerializedName(SignUpErrorTypes.INVALID_ATTRIBUTES)
    @Expose
    @Nullable
    private final List<Map<String, String>> invalidAttributes;

    @SerializedName("required_attributes")
    @Expose
    @Nullable
    private final List<UserAttributeApiResult> requiredAttributes;

    @Expose
    private int statusCode;

    @SerializedName("suberror")
    @Nullable
    private final String subError;

    @SerializedName("unverified_attributes")
    @Expose
    @Nullable
    private final List<Map<String, String>> unverifiedAttributes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SignUpContinueApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable Integer num, @Nullable List<? extends Map<String, String>> list, @Nullable List<? extends Map<String, String>> list2, @Nullable List<UserAttributeApiResult> list3, @Nullable String str2, @Nullable List<Integer> list4, @Nullable String str3, @Nullable String str4) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.expiresIn = num;
        this.unverifiedAttributes = list;
        this.invalidAttributes = list2;
        this.requiredAttributes = list3;
        this.error = str2;
        this.errorCodes = list4;
        this.errorDescription = str3;
        this.subError = str4;
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
    public final List<Integer> getErrorCodes() {
        return this.errorCodes;
    }

    @Nullable
    public final String getErrorDescription() {
        return this.errorDescription;
    }

    @Nullable
    public final Integer getExpiresIn() {
        return this.expiresIn;
    }

    @Nullable
    public final List<Map<String, String>> getInvalidAttributes() {
        return this.invalidAttributes;
    }

    @Nullable
    public final List<UserAttributeApiResult> getRequiredAttributes() {
        return this.requiredAttributes;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.IApiResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    @Nullable
    public final String getSubError() {
        return this.subError;
    }

    @Nullable
    public final List<Map<String, String>> getUnverifiedAttributes() {
        return this.unverifiedAttributes;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @NotNull
    public final SignUpContinueApiResult toResult() {
        List<String> attributeList;
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            return new SignUpContinueApiResult.Success(getCorrelationId(), this.continuationToken, this.expiresIn);
        }
        if (statusCode != 400) {
            String str2 = this.error;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = this.errorDescription;
            return new SignUpContinueApiResult.UnknownError(getCorrelationId(), str2, str3 != null ? str3 : "");
        }
        if (ApiErrorResponseUtilKt.isInvalidGrant(this.error)) {
            if (ApiErrorResponseUtilKt.isPasswordTooWeak(this.subError) || ApiErrorResponseUtilKt.isPasswordTooLong(this.subError) || ApiErrorResponseUtilKt.isPasswordTooShort(this.subError) || ApiErrorResponseUtilKt.isPasswordBanned(this.subError) || ApiErrorResponseUtilKt.isPasswordRecentlyUsed(this.subError) || ApiErrorResponseUtilKt.isPasswordInvalid(this.subError)) {
                String str4 = this.error;
                if (str4 == null) {
                    str4 = "";
                }
                String str5 = this.errorDescription;
                if (str5 == null) {
                    str5 = "";
                }
                String str6 = this.subError;
                return new SignUpContinueApiResult.InvalidPassword(getCorrelationId(), str4, str5, str6 != null ? str6 : "");
            }
            if (ApiErrorResponseUtilKt.isAttributeValidationFailed(this.subError)) {
                String str7 = this.error;
                String str8 = str7 == null ? "" : str7;
                String str9 = this.errorDescription;
                String str10 = str9 == null ? "" : str9;
                List<Map<String, String>> list = this.invalidAttributes;
                if (list == null || (attributeList = ApiErrorResponseUtilKt.toAttributeList(list)) == null) {
                    return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ErrorTypes.INVALID_STATE, "SignUp /continue did not return a invalid_attributes with validation_failed error");
                }
                String str11 = this.subError;
                return new SignUpContinueApiResult.InvalidAttributes(getCorrelationId(), attributeList, str8, str10, str11 == null ? "" : str11);
            }
            if (!ApiErrorResponseUtilKt.isInvalidOOBValue(this.subError)) {
                String str12 = this.error;
                if (str12 == null) {
                    str12 = "";
                }
                String str13 = this.errorDescription;
                return new SignUpContinueApiResult.UnknownError(getCorrelationId(), str12, str13 != null ? str13 : "");
            }
            String str14 = this.error;
            if (str14 == null) {
                str14 = "";
            }
            String str15 = this.errorDescription;
            if (str15 == null) {
                str15 = "";
            }
            String str16 = this.subError;
            return new SignUpContinueApiResult.InvalidOOBValue(getCorrelationId(), str14, str15, str16 != null ? str16 : "");
        }
        if (ApiErrorResponseUtilKt.isUserAlreadyExists(this.error)) {
            String str17 = this.error;
            if (str17 == null) {
                str17 = "";
            }
            String str18 = this.errorDescription;
            return new SignUpContinueApiResult.UsernameAlreadyExists(getCorrelationId(), str17, str18 != null ? str18 : "");
        }
        if (ApiErrorResponseUtilKt.isExpiredToken(this.error)) {
            String str19 = this.error;
            if (str19 == null) {
                str19 = "";
            }
            String str20 = this.errorDescription;
            return new SignUpContinueApiResult.ExpiredToken(getCorrelationId(), str19, str20 != null ? str20 : "");
        }
        if (ApiErrorResponseUtilKt.isAttributesRequired(this.error)) {
            String str21 = this.continuationToken;
            if (str21 == null) {
                return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /continue did not return a continuation token with attributes_required error");
            }
            String str22 = this.error;
            String str23 = str22 == null ? "" : str22;
            String str24 = this.errorDescription;
            String str25 = str24 == null ? "" : str24;
            List<UserAttributeApiResult> list2 = this.requiredAttributes;
            return list2 == null ? new SignUpContinueApiResult.UnknownError(getCorrelationId(), ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /continue did not return required_attributes with attributes_required error") : new SignUpContinueApiResult.AttributesRequired(getCorrelationId(), str21, str23, str25, list2);
        }
        if (ApiErrorResponseUtilKt.isCredentialRequired(this.error)) {
            String str26 = this.continuationToken;
            if (str26 == null) {
                return new SignUpContinueApiResult.UnknownError(getCorrelationId(), ApiErrorResult.INSTANCE.getINVALID_STATE(), "SignUp /continue did not return a continuation token with credential_required");
            }
            String str27 = this.error;
            if (str27 == null) {
                str27 = "";
            }
            String str28 = this.errorDescription;
            return new SignUpContinueApiResult.CredentialRequired(getCorrelationId(), str26, str27, str28 != null ? str28 : "");
        }
        if (ApiErrorResponseUtilKt.isVerificationRequired(this.error)) {
            String str29 = this.error;
            if (str29 == null) {
                str29 = "";
            }
            String str30 = this.errorDescription;
            return new SignUpContinueApiResult.UnknownError(getCorrelationId(), str29, str30 != null ? str30 : "");
        }
        String str31 = this.error;
        if (str31 == null) {
            str31 = "";
        }
        String str32 = this.errorDescription;
        return new SignUpContinueApiResult.UnknownError(getCorrelationId(), str31, str32 != null ? str32 : "");
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "SignUpContinueApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignUpContinueApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", expiresIn=");
        sb.append(this.expiresIn);
        sb.append(", requiredAttributes=");
        sb.append(this.requiredAttributes);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", errorCodes=");
        sb.append(this.errorCodes);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(", subError=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
    }
}
