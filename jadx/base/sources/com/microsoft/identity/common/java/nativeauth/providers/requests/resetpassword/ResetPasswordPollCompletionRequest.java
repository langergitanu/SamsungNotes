package com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", Contract.HEADERS, "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "toString", "toUnsanitizedString", "Companion", "NativeAuthResetPasswordPollCompletionRequestParameters", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordPollCompletionRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private Map<String, String> headers;

    @NotNull
    private final NativeAuthRequest.NativeAuthRequestParameters parameters;

    @NotNull
    private URL requestUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n¨\u0006\u000b"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest$Companion;", "", "()V", "create", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest;", SyncDBSchema.SyncInfo.CLIENT_ID, "", "continuationToken", "requestUrl", Contract.HEADERS, "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ResetPasswordPollCompletionRequest create(@NotNull String clientId, @NotNull String continuationToken, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(continuationToken, "continuationToken");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new ResetPasswordPollCompletionRequest(new URL(requestUrl), headers, new NativeAuthResetPasswordPollCompletionRequestParameters(clientId, continuationToken), null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordPollCompletionRequest$NativeAuthResetPasswordPollCompletionRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", SyncDBSchema.SyncInfo.CLIENT_ID, "", "continuationToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getContinuationToken", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class NativeAuthResetPasswordPollCompletionRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("client_id")
        @NotNull
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        @NotNull
        private final String continuationToken;

        public NativeAuthResetPasswordPollCompletionRequestParameters(@NotNull String clientId, @NotNull String continuationToken) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            this.clientId = clientId;
            this.continuationToken = continuationToken;
        }

        public static /* synthetic */ NativeAuthResetPasswordPollCompletionRequestParameters copy$default(NativeAuthResetPasswordPollCompletionRequestParameters nativeAuthResetPasswordPollCompletionRequestParameters, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthResetPasswordPollCompletionRequestParameters.getClientId();
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthResetPasswordPollCompletionRequestParameters.continuationToken;
            }
            return nativeAuthResetPasswordPollCompletionRequestParameters.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return getClientId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @NotNull
        public final NativeAuthResetPasswordPollCompletionRequestParameters copy(@NotNull String clientId, @NotNull String continuationToken) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            return new NativeAuthResetPasswordPollCompletionRequestParameters(clientId, continuationToken);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthResetPasswordPollCompletionRequestParameters)) {
                return false;
            }
            NativeAuthResetPasswordPollCompletionRequestParameters nativeAuthResetPasswordPollCompletionRequestParameters = (NativeAuthResetPasswordPollCompletionRequestParameters) other;
            return Intrinsics.areEqual(getClientId(), nativeAuthResetPasswordPollCompletionRequestParameters.getClientId()) && Intrinsics.areEqual(this.continuationToken, nativeAuthResetPasswordPollCompletionRequestParameters.continuationToken);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        @NotNull
        public String getClientId() {
            return this.clientId;
        }

        @NotNull
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        public int hashCode() {
            return this.continuationToken.hashCode() + (getClientId().hashCode() * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return toUnsanitizedString();
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            return "NativeAuthResetPasswordPollCompletionRequestParameters(clientId=" + getClientId() + PropertyUtils.MAPPED_DELIM2;
        }
    }

    public /* synthetic */ ResetPasswordPollCompletionRequest(URL url, Map map, NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestParameters);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public NativeAuthRequest.NativeAuthRequestParameters getParameters() {
        return this.parameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public URL getRequestUrl() {
        return this.requestUrl;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setHeaders(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setRequestUrl(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.requestUrl = url;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordPollCompletionRequest()";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        return "ResetPasswordPollCompletionRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + PropertyUtils.MAPPED_DELIM2;
    }

    private ResetPasswordPollCompletionRequest(URL url, Map<String, String> map, NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestParameters;
    }
}
