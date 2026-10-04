package com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
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
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", Contract.HEADERS, "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "setParameters", "(Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;)V", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "toString", "toUnsanitizedString", "Companion", "NativeAuthResetPasswordContinueRequestParameters", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordContinueRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private Map<String, String> headers;

    @NotNull
    private NativeAuthRequest.NativeAuthRequestParameters parameters;

    @NotNull
    private URL requestUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest$Companion;", "", "()V", "create", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest;", SyncDBSchema.SyncInfo.CLIENT_ID, "", "continuationToken", "oob", "requestUrl", Contract.HEADERS, "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ResetPasswordContinueRequest create(@NotNull String clientId, @NotNull String continuationToken, @NotNull String oob, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(oob, "oob");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(continuationToken, "continuationToken");
            argUtils.validateNonNullArg(oob, "oob");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new ResetPasswordContinueRequest(new URL(requestUrl), headers, new NativeAuthResetPasswordContinueRequestParameters(clientId, "oob", continuationToken, oob), null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordContinueRequest$NativeAuthResetPasswordContinueRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", SyncDBSchema.SyncInfo.CLIENT_ID, "", "grantType", "continuationToken", "oob", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getContinuationToken", "getGrantType", "getOob", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class NativeAuthResetPasswordContinueRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("client_id")
        @NotNull
        private final String clientId;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        @NotNull
        private final String continuationToken;

        @SerializedName("grant_type")
        @NotNull
        private final String grantType;

        @SerializedName("oob")
        @NotNull
        private final String oob;

        public NativeAuthResetPasswordContinueRequestParameters(@NotNull String clientId, @NotNull String grantType, @NotNull String continuationToken, @NotNull String oob) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(oob, "oob");
            this.clientId = clientId;
            this.grantType = grantType;
            this.continuationToken = continuationToken;
            this.oob = oob;
        }

        public static /* synthetic */ NativeAuthResetPasswordContinueRequestParameters copy$default(NativeAuthResetPasswordContinueRequestParameters nativeAuthResetPasswordContinueRequestParameters, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthResetPasswordContinueRequestParameters.getClientId();
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthResetPasswordContinueRequestParameters.grantType;
            }
            if ((i & 4) != 0) {
                str3 = nativeAuthResetPasswordContinueRequestParameters.continuationToken;
            }
            if ((i & 8) != 0) {
                str4 = nativeAuthResetPasswordContinueRequestParameters.oob;
            }
            return nativeAuthResetPasswordContinueRequestParameters.copy(str, str2, str3, str4);
        }

        @NotNull
        public final String component1() {
            return getClientId();
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGrantType() {
            return this.grantType;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getOob() {
            return this.oob;
        }

        @NotNull
        public final NativeAuthResetPasswordContinueRequestParameters copy(@NotNull String clientId, @NotNull String grantType, @NotNull String continuationToken, @NotNull String oob) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(oob, "oob");
            return new NativeAuthResetPasswordContinueRequestParameters(clientId, grantType, continuationToken, oob);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthResetPasswordContinueRequestParameters)) {
                return false;
            }
            NativeAuthResetPasswordContinueRequestParameters nativeAuthResetPasswordContinueRequestParameters = (NativeAuthResetPasswordContinueRequestParameters) other;
            return Intrinsics.areEqual(getClientId(), nativeAuthResetPasswordContinueRequestParameters.getClientId()) && Intrinsics.areEqual(this.grantType, nativeAuthResetPasswordContinueRequestParameters.grantType) && Intrinsics.areEqual(this.continuationToken, nativeAuthResetPasswordContinueRequestParameters.continuationToken) && Intrinsics.areEqual(this.oob, nativeAuthResetPasswordContinueRequestParameters.oob);
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

        @NotNull
        public final String getGrantType() {
            return this.grantType;
        }

        @NotNull
        public final String getOob() {
            return this.oob;
        }

        public int hashCode() {
            return this.oob.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c(getClientId().hashCode() * 31, 31, this.grantType), 31, this.continuationToken);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "NativeAuthResetPasswordContinueRequestParameters(clientId=" + getClientId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("NativeAuthResetPasswordContinueRequestParameters(clientId=");
            sb.append(getClientId());
            sb.append(", grant_type=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.grantType, sb);
        }
    }

    public /* synthetic */ ResetPasswordContinueRequest(URL url, Map map, NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
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

    public void setParameters(@NotNull NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters) {
        Intrinsics.checkNotNullParameter(nativeAuthRequestParameters, "<set-?>");
        this.parameters = nativeAuthRequestParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setRequestUrl(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.requestUrl = url;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordContinueRequest()";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        return "ResetPasswordContinueRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + PropertyUtils.MAPPED_DELIM2;
    }

    private ResetPasswordContinueRequest(URL url, Map<String, String> map, NativeAuthRequest.NativeAuthRequestParameters nativeAuthRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestParameters;
    }
}
