package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0001*B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", "bindingMethod", "challengeTargetLabel", "challengeChannel", "codeLength", MicrosoftAuthorizationResponse.INTERVAL, "error", "errorCodes", "", "errorDescription", "errorUri", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getBindingMethod", "()Ljava/lang/String;", "getChallengeChannel", "getChallengeTargetLabel", "getChallengeType", "getCodeLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getInterval", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInChallengeApiResponse extends IApiResponse {

    @NotNull
    private static final String INVALID_GRANT = "invalid_grant";

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

    @SerializedName("error_codes")
    @Nullable
    private final List<Integer> errorCodes;

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
    private static final String TAG = "SignInChallengeApiResponse";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInChallengeApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num, @Nullable Integer num2, @Nullable String str6, @Nullable List<Integer> list, @Nullable String str7, @Nullable String str8) {
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
        this.errorCodes = list;
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
    public final List<Integer> getErrorCodes() {
        return this.errorCodes;
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
    public final SignInChallengeApiResult toResult() {
        String str;
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, AbstractC12991c.m13991l(str2, SearchConstants.TargetContents.TAG, str2, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode != 200) {
            if (statusCode != 400) {
                String str3 = this.error;
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = this.errorDescription;
                str = str4 != null ? str4 : "";
                List<Integer> listEmptyList = this.errorCodes;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str3, str, listEmptyList);
            }
            if (Intrinsics.areEqual(this.error, "invalid_grant")) {
                String str5 = this.error;
                String str6 = this.errorDescription;
                str = str6 != null ? str6 : "";
                List<Integer> listEmptyList2 = this.errorCodes;
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str5, str, listEmptyList2);
            }
            String str7 = this.error;
            if (str7 == null) {
                str7 = "";
            }
            String str8 = this.errorDescription;
            str = str8 != null ? str8 : "";
            List<Integer> listEmptyList3 = this.errorCodes;
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str7, str, listEmptyList3);
        }
        if (ApiErrorResponseUtilKt.isRedirect(this.challengeType)) {
            return new SignInChallengeApiResult.Redirect(getCorrelationId());
        }
        if (!ApiErrorResponseUtilKt.isOOB(this.challengeType)) {
            if (ApiErrorResponseUtilKt.isPassword(this.challengeType)) {
                String str9 = this.continuationToken;
                if (str9 != null) {
                    return new SignInChallengeApiResult.PasswordRequired(getCorrelationId(), str9);
                }
                String invalid_state = ApiErrorResult.INSTANCE.getINVALID_STATE();
                List<Integer> listEmptyList4 = this.errorCodes;
                if (listEmptyList4 == null) {
                    listEmptyList4 = CollectionsKt.emptyList();
                }
                return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state, "SignIn /challenge did not return a continuation token with password challenge type", listEmptyList4);
            }
            String str10 = this.error;
            if (str10 == null) {
                str10 = "";
            }
            String str11 = this.errorDescription;
            str = str11 != null ? str11 : "";
            List<Integer> listEmptyList5 = this.errorCodes;
            if (listEmptyList5 == null) {
                listEmptyList5 = CollectionsKt.emptyList();
            }
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), str10, str, listEmptyList5);
        }
        String str12 = this.challengeTargetLabel;
        if (str12 == null || StringsKt.isBlank(str12)) {
            String invalid_state2 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList6 = this.errorCodes;
            if (listEmptyList6 == null) {
                listEmptyList6 = CollectionsKt.emptyList();
            }
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state2, "SignIn /challenge did not return a challenge_target_label with oob challenge type", listEmptyList6);
        }
        String str13 = this.challengeChannel;
        if (str13 == null || StringsKt.isBlank(str13)) {
            String invalid_state3 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList7 = this.errorCodes;
            if (listEmptyList7 == null) {
                listEmptyList7 = CollectionsKt.emptyList();
            }
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state3, "SignIn /challenge did not return a challenge_channel with oob challenge type", listEmptyList7);
        }
        Integer num = this.codeLength;
        if (num == null) {
            String invalid_state4 = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList8 = this.errorCodes;
            if (listEmptyList8 == null) {
                listEmptyList8 = CollectionsKt.emptyList();
            }
            return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state4, "SignIn /challenge did not return a code_length with oob challenge type", listEmptyList8);
        }
        String str14 = this.continuationToken;
        if (str14 != null) {
            return new SignInChallengeApiResult.OOBRequired(getCorrelationId(), str14, this.challengeTargetLabel, this.challengeChannel, num.intValue());
        }
        String invalid_state5 = ApiErrorResult.INSTANCE.getINVALID_STATE();
        List<Integer> listEmptyList9 = this.errorCodes;
        if (listEmptyList9 == null) {
            listEmptyList9 = CollectionsKt.emptyList();
        }
        return new SignInChallengeApiResult.UnknownError(getCorrelationId(), invalid_state5, "SignIn /challenge did not return a continuation token with oob challenge type", listEmptyList9);
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
        sb.append(this.errorDescription);
        sb.append(", errorCodes=");
        sb.append(this.errorCodes);
        sb.append(", errorUri=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.errorUri, sb);
    }
}
