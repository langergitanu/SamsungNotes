package com.microsoft.identity.common.java.nativeauth.providers.requests.resetpassword;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
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
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0002\"#B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006$"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", Contract.HEADERS, "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;", "setParameters", "(Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;)V", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestResetPasswordStartParameters", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final /* data */ class ResetPasswordStartRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private Map<String, String> headers;

    @NotNull
    private NativeAuthRequestResetPasswordStartParameters parameters;

    @NotNull
    private URL requestUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$Companion;", "", "()V", "create", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest;", SyncDBSchema.SyncInfo.CLIENT_ID, "", "username", "challengeType", "requestUrl", Contract.HEADERS, "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ResetPasswordStartRequest create(@NotNull String clientId, @NotNull String username, @NotNull String challengeType, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(challengeType, "challengeType");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new ResetPasswordStartRequest(new URL(requestUrl), headers, new NativeAuthRequestResetPasswordStartParameters(username, clientId, challengeType), null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/resetpassword/ResetPasswordStartRequest$NativeAuthRequestResetPasswordStartParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "username", "", SyncDBSchema.SyncInfo.CLIENT_ID, "challengeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getClientId", "getUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class NativeAuthRequestResetPasswordStartParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("challenge_type")
        @Nullable
        private final String challengeType;

        @SerializedName("client_id")
        @NotNull
        private final String clientId;

        @NotNull
        private final String username;

        public NativeAuthRequestResetPasswordStartParameters(@NotNull String username, @NotNull String clientId, @Nullable String str) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            this.username = username;
            this.clientId = clientId;
            this.challengeType = str;
        }

        public static /* synthetic */ NativeAuthRequestResetPasswordStartParameters copy$default(NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestResetPasswordStartParameters.username;
            }
            if ((i & 2) != 0) {
                str2 = nativeAuthRequestResetPasswordStartParameters.getClientId();
            }
            if ((i & 4) != 0) {
                str3 = nativeAuthRequestResetPasswordStartParameters.challengeType;
            }
            return nativeAuthRequestResetPasswordStartParameters.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        @NotNull
        public final String component2() {
            return getClientId();
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        @NotNull
        public final NativeAuthRequestResetPasswordStartParameters copy(@NotNull String username, @NotNull String clientId, @Nullable String challengeType) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            return new NativeAuthRequestResetPasswordStartParameters(username, clientId, challengeType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestResetPasswordStartParameters)) {
                return false;
            }
            NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters = (NativeAuthRequestResetPasswordStartParameters) other;
            return Intrinsics.areEqual(this.username, nativeAuthRequestResetPasswordStartParameters.username) && Intrinsics.areEqual(getClientId(), nativeAuthRequestResetPasswordStartParameters.getClientId()) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestResetPasswordStartParameters.challengeType);
        }

        @Nullable
        public final String getChallengeType() {
            return this.challengeType;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        @NotNull
        public String getClientId() {
            return this.clientId;
        }

        @NotNull
        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            int iHashCode = (getClientId().hashCode() + (this.username.hashCode() * 31)) * 31;
            String str = this.challengeType;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "ResetPasswordStartRequest(clientId=" + getClientId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("ResetPasswordStartRequest(clientId=");
            sb.append(getClientId());
            sb.append(", challengeType=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.challengeType, sb);
        }
    }

    public /* synthetic */ ResetPasswordStartRequest(URL url, Map map, NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestResetPasswordStartParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResetPasswordStartRequest copy$default(ResetPasswordStartRequest resetPasswordStartRequest, URL url, Map map, NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = resetPasswordStartRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = resetPasswordStartRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestResetPasswordStartParameters = resetPasswordStartRequest.getParameters();
        }
        return resetPasswordStartRequest.copy(url, map, nativeAuthRequestResetPasswordStartParameters);
    }

    @NotNull
    public final URL component1() {
        return getRequestUrl();
    }

    @NotNull
    public final Map<String, String> component2() {
        return getHeaders();
    }

    @NotNull
    public final NativeAuthRequestResetPasswordStartParameters component3() {
        return getParameters();
    }

    @NotNull
    public final ResetPasswordStartRequest copy(@NotNull URL requestUrl, @NotNull Map<String, String> headers, @NotNull NativeAuthRequestResetPasswordStartParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new ResetPasswordStartRequest(requestUrl, headers, parameters);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResetPasswordStartRequest)) {
            return false;
        }
        ResetPasswordStartRequest resetPasswordStartRequest = (ResetPasswordStartRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), resetPasswordStartRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), resetPasswordStartRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), resetPasswordStartRequest.getParameters());
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public URL getRequestUrl() {
        return this.requestUrl;
    }

    public int hashCode() {
        return getParameters().hashCode() + ((getHeaders().hashCode() + (getRequestUrl().hashCode() * 31)) * 31);
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setHeaders(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.headers = map;
    }

    public void setParameters(@NotNull NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters) {
        Intrinsics.checkNotNullParameter(nativeAuthRequestResetPasswordStartParameters, "<set-?>");
        this.parameters = nativeAuthRequestResetPasswordStartParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setRequestUrl(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.requestUrl = url;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "ResetPasswordStartRequest()";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        return "ResetPasswordStartRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + PropertyUtils.MAPPED_DELIM2;
    }

    private ResetPasswordStartRequest(URL url, Map<String, String> map, NativeAuthRequestResetPasswordStartParameters nativeAuthRequestResetPasswordStartParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestResetPasswordStartParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public NativeAuthRequestResetPasswordStartParameters getParameters() {
        return this.parameters;
    }
}
