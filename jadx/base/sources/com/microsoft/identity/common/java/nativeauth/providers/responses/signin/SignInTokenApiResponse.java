package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.providers.IApiResponse;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
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
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResponse;", "Lcom/microsoft/identity/common/java/nativeauth/providers/IApiResponse;", "statusCode", "", "correlationId", "", "continuationToken", "error", "errorDescription", "errorUri", "errorCodes", "", "subError", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getContinuationToken", "()Ljava/lang/String;", "getError", "getErrorCodes", "()Ljava/util/List;", "getErrorDescription", "getErrorUri", "getStatusCode", "()I", "setStatusCode", "(I)V", "getSubError", "toErrorResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "toString", "toUnsanitizedString", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInTokenApiResponse extends IApiResponse {
    private static final String TAG = "SignInTokenApiResponse";

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

    @SerializedName("suberror")
    @Nullable
    private final String subError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInTokenApiResponse(int i, @NotNull String correlationId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable List<Integer> list, @Nullable String str5) {
        super(i, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        this.statusCode = i;
        this.continuationToken = str;
        this.error = str2;
        this.errorDescription = str3;
        this.errorUri = str4;
        this.errorCodes = list;
        this.subError = str5;
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

    @Nullable
    public final String getSubError() {
        return this.subError;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @NotNull
    public final SignInTokenApiResult toErrorResult() {
        String str;
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, AbstractC12991c.m13991l(str2, SearchConstants.TargetContents.TAG, str2, ".toResult"));
        if (ApiErrorResponseUtilKt.isInvalidRequest(this.error)) {
            List<Integer> list = this.errorCodes;
            if (list != null && !list.isEmpty()) {
                String str3 = this.error;
                if (str3 == null) {
                    str3 = "";
                }
                String str4 = this.errorDescription;
                return new SignInTokenApiResult.UnknownError(getCorrelationId(), str3, str4 != null ? str4 : "", this.errorCodes);
            }
            String str5 = this.error;
            if (str5 == null) {
                str5 = "";
            }
            String str6 = this.errorDescription;
            str = str6 != null ? str6 : "";
            List<Integer> listEmptyList = this.errorCodes;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return new SignInTokenApiResult.UnknownError(getCorrelationId(), str5, str, listEmptyList);
        }
        if (!ApiErrorResponseUtilKt.isInvalidGrant(this.error)) {
            if (ApiErrorResponseUtilKt.isUserNotFound(this.error)) {
                String str7 = this.error;
                if (str7 == null) {
                    str7 = "";
                }
                String str8 = this.errorDescription;
                str = str8 != null ? str8 : "";
                List<Integer> listEmptyList2 = this.errorCodes;
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                return new SignInTokenApiResult.UserNotFound(getCorrelationId(), str7, str, listEmptyList2);
            }
            String str9 = this.error;
            if (str9 == null) {
                str9 = "";
            }
            String str10 = this.errorDescription;
            str = str10 != null ? str10 : "";
            List<Integer> listEmptyList3 = this.errorCodes;
            if (listEmptyList3 == null) {
                listEmptyList3 = CollectionsKt.emptyList();
            }
            return new SignInTokenApiResult.UnknownError(getCorrelationId(), str9, str, listEmptyList3);
        }
        List<Integer> list2 = this.errorCodes;
        if (list2 == null || list2.isEmpty()) {
            String str11 = this.error;
            if (str11 == null) {
                str11 = "";
            }
            String str12 = this.errorDescription;
            str = str12 != null ? str12 : "";
            List<Integer> listEmptyList4 = this.errorCodes;
            if (listEmptyList4 == null) {
                listEmptyList4 = CollectionsKt.emptyList();
            }
            return new SignInTokenApiResult.UnknownError(getCorrelationId(), str11, str, listEmptyList4);
        }
        if (ApiErrorResponseUtilKt.isInvalidCredentials(this.errorCodes.get(0))) {
            String str13 = this.error;
            if (str13 == null) {
                str13 = "";
            }
            String str14 = this.errorDescription;
            return new SignInTokenApiResult.InvalidCredentials(getCorrelationId(), str13, str14 != null ? str14 : "", this.errorCodes);
        }
        if (ApiErrorResponseUtilKt.isMFARequired(this.errorCodes.get(0))) {
            String str15 = this.error;
            if (str15 == null) {
                str15 = "";
            }
            String str16 = this.errorDescription;
            return new SignInTokenApiResult.MFARequired(getCorrelationId(), str15, str16 != null ? str16 : "", this.errorCodes);
        }
        if (ApiErrorResponseUtilKt.isInvalidOOBValue(this.subError)) {
            String str17 = this.error;
            String str18 = str17 == null ? "" : str17;
            String str19 = this.errorDescription;
            String str20 = str19 == null ? "" : str19;
            List<Integer> list3 = this.errorCodes;
            String str21 = this.subError;
            return new SignInTokenApiResult.CodeIncorrect(getCorrelationId(), str18, str20, list3, str21 == null ? "" : str21);
        }
        if (ApiErrorResponseUtilKt.isInvalidAuthenticationType(this.errorCodes.get(0))) {
            String str22 = this.error;
            if (str22 == null) {
                str22 = "";
            }
            String str23 = this.errorDescription;
            return new SignInTokenApiResult.InvalidAuthenticationType(getCorrelationId(), str22, str23 != null ? str23 : "", this.errorCodes);
        }
        String str24 = this.error;
        if (str24 == null) {
            str24 = "";
        }
        String str25 = this.errorDescription;
        return new SignInTokenApiResult.UnknownError(getCorrelationId(), str24, str25 != null ? str25 : "", this.errorCodes);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "SignInTokenApiResponse(statusCode=" + getStatusCode() + ", correlationId=" + getCorrelationId();
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        StringBuilder sb = new StringBuilder("SignInTokenApiResponse(statusCode=");
        sb.append(getStatusCode());
        sb.append(", correlationId=");
        sb.append(getCorrelationId());
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", errorDescription=");
        sb.append(this.errorDescription);
        sb.append(", errorCodes=");
        sb.append(this.errorCodes);
        sb.append(", errorUri=");
        sb.append(this.errorUri);
        sb.append(", subError=");
        return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.subError, sb);
    }
}
