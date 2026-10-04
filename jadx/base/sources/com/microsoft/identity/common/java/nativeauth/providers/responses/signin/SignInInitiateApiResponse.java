package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResult;
import com.microsoft.identity.common.java.nativeauth.util.ApiErrorResponseUtilKt;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "challengeType", "error", "errorDescription", "errorUri", "errorCodes", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChallengeType", "()Ljava/lang/String;", "getContinuationToken", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getStatusCode", "()I", "setStatusCode", "(I)V", "toResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInInitiateApiResponse extends IApiResponse {
    private static final String TAG = "SignInInitiateApiResponse";

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

    @SerializedName("error_codes")
    @Nullable
    private final List<Integer> errorCodes;

    @SerializedName("error_description")
    @Nullable
    private final String errorDescription;

    @SerializedName("error_uri")
    @Nullable
    private final String errorUri;

    @Expose
    private int statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInInitiateApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable List<Integer> list) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.challengeType = str2;
        this.error = str3;
        this.errorDescription = str4;
        this.errorUri = str5;
        this.errorCodes = list;
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

    @Override // com.microsoft.identity.common.java.nativeauth.providers.IApiResponse
    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @NotNull
    public final SignInInitiateApiResult toResult() {
        String str;
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, AbstractC12991c.m13991l(str2, SearchConstants.TargetContents.TAG, str2, ".toResult"));
        int statusCode = getStatusCode();
        if (statusCode == 200) {
            if (ApiErrorResponseUtilKt.isRedirect(this.challengeType)) {
                return new SignInInitiateApiResult.Redirect(getCorrelationId());
            }
            String str3 = this.continuationToken;
            if (str3 != null) {
                return new SignInInitiateApiResult.Success(getCorrelationId(), str3);
            }
            String invalid_state = ApiErrorResult.INSTANCE.getINVALID_STATE();
            List<Integer> listEmptyList = this.errorCodes;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new SignInInitiateApiResult.UnknownError(getCorrelationId(), invalid_state, "SignIn /initiate did not return a flow token", listEmptyList);
        }
        if (statusCode != 400) {
            String str4 = this.error;
            if (str4 == null) {
                str4 = "";
            }
            String str5 = this.errorDescription;
            str = str5 != null ? str5 : "";
            List<Integer> listEmptyList2 = this.errorCodes;
            if (listEmptyList2 == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            return new SignInInitiateApiResult.UnknownError(getCorrelationId(), str4, str, listEmptyList2);
        }
        if (ApiErrorResponseUtilKt.isUserNotFound(this.error)) {
            String str6 = this.error;
            if (str6 == null) {
                str6 = "";
            }
            String str7 = this.errorDescription;
            str = str7 != null ? str7 : "";
            List<Integer> listEmptyList3 = this.errorCodes;
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            return new SignInInitiateApiResult.UserNotFound(getCorrelationId(), str6, str, listEmptyList3);
        }
        String str8 = this.error;
        if (str8 == null) {
            str8 = "";
        }
        String str9 = this.errorDescription;
        str = str9 != null ? str9 : "";
        List<Integer> listEmptyList4 = this.errorCodes;
        if (listEmptyList4 == null) {
            listEmptyList4 = CollectionsKt.emptyList();
        }
        return new SignInInitiateApiResult.UnknownError(getCorrelationId(), str8, str, listEmptyList4);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "SignInInitiateApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInInitiateApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", challengeType=");
        sb.append(this.challengeType);
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
