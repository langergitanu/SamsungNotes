package com.microsoft.identity.common.java.nativeauth.providers.requests.signup;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest;
import com.microsoft.identity.common.java.util.ArgUtils;
import com.microsoft.identity.common.java.util.CharArrayJsonAdapter;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", Contract.HEADERS, "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignUpStartRequestParameters", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final /* data */ class SignUpStartRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private Map<String, String> headers;

    @NotNull
    private final NativeAuthRequestSignUpStartRequestParameters parameters;

    @NotNull
    private URL requestUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J`\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n¨\u0006\u000f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$Companion;", "", "()V", "create", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest;", "username", "", "password", "", NativeAuthConstants.GrantType.ATTRIBUTES, "", SyncDBSchema.SyncInfo.CLIENT_ID, "challengeType", "requestUrl", Contract.HEADERS, "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignUpStartRequest create$default(Companion companion, String str, char[] cArr, Map map, String str2, String str3, String str4, Map map2, int i, Object obj) {
            if ((i & 2) != 0) {
                cArr = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            return companion.create(str, cArr, map, str2, str3, str4, map2);
        }

        @NotNull
        public final SignUpStartRequest create(@NotNull String username, @Nullable char[] password, @Nullable Map<String, String> attributes, @NotNull String clientId, @NotNull String challengeType, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(challengeType, "challengeType");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new SignUpStartRequest(new URL(requestUrl), headers, new NativeAuthRequestSignUpStartRequestParameters(username, password, attributes != null ? NativeAuthRequest.INSTANCE.toJsonString(attributes, attributes) : null, clientId, challengeType), null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signup/SignUpStartRequest$NativeAuthRequestSignUpStartRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "username", "", "password", "", NativeAuthConstants.GrantType.ATTRIBUTES, SyncDBSchema.SyncInfo.CLIENT_ID, "challengeType", "(Ljava/lang/String;[CLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttributes", "()Ljava/lang/String;", "getChallengeType", "getClientId", "getPassword", "()[C", "getUsername", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class NativeAuthRequestSignUpStartRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @Nullable
        private final String attributes;

        @SerializedName("challenge_type")
        @NotNull
        private final String challengeType;

        @SerializedName("client_id")
        @NotNull
        private final String clientId;

        @JsonAdapter(CharArrayJsonAdapter.class)
        @Nullable
        private final char[] password;

        @NotNull
        private final String username;

        public /* synthetic */ NativeAuthRequestSignUpStartRequestParameters(String str, char[] cArr, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, cArr, (i & 4) != 0 ? null : str2, str3, str4);
        }

        public static /* synthetic */ NativeAuthRequestSignUpStartRequestParameters copy$default(NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters, String str, char[] cArr, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestSignUpStartRequestParameters.username;
            }
            if ((i & 2) != 0) {
                cArr = nativeAuthRequestSignUpStartRequestParameters.password;
            }
            if ((i & 4) != 0) {
                str2 = nativeAuthRequestSignUpStartRequestParameters.attributes;
            }
            if ((i & 8) != 0) {
                str3 = nativeAuthRequestSignUpStartRequestParameters.getClientId();
            }
            if ((i & 16) != 0) {
                str4 = nativeAuthRequestSignUpStartRequestParameters.challengeType;
            }
            String str5 = str4;
            String str6 = str2;
            return nativeAuthRequestSignUpStartRequestParameters.copy(str, cArr, str6, str3, str5);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final char[] getPassword() {
            return this.password;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAttributes() {
            return this.attributes;
        }

        @NotNull
        public final String component4() {
            return getClientId();
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        @NotNull
        public final NativeAuthRequestSignUpStartRequestParameters copy(@NotNull String username, @Nullable char[] password, @Nullable String attributes, @NotNull String clientId, @NotNull String challengeType) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            return new NativeAuthRequestSignUpStartRequestParameters(username, password, attributes, clientId, challengeType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignUpStartRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters = (NativeAuthRequestSignUpStartRequestParameters) other;
            return Intrinsics.areEqual(this.username, nativeAuthRequestSignUpStartRequestParameters.username) && Intrinsics.areEqual(this.password, nativeAuthRequestSignUpStartRequestParameters.password) && Intrinsics.areEqual(this.attributes, nativeAuthRequestSignUpStartRequestParameters.attributes) && Intrinsics.areEqual(getClientId(), nativeAuthRequestSignUpStartRequestParameters.getClientId()) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestSignUpStartRequestParameters.challengeType);
        }

        @Nullable
        public final String getAttributes() {
            return this.attributes;
        }

        @NotNull
        public final String getChallengeType() {
            return this.challengeType;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest.NativeAuthRequestParameters
        @NotNull
        public String getClientId() {
            return this.clientId;
        }

        @Nullable
        public final char[] getPassword() {
            return this.password;
        }

        @NotNull
        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            int iHashCode = this.username.hashCode() * 31;
            char[] cArr = this.password;
            int iHashCode2 = (iHashCode + (cArr == null ? 0 : Arrays.hashCode(cArr))) * 31;
            String str = this.attributes;
            return this.challengeType.hashCode() + ((getClientId().hashCode() + ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31)) * 31);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "NativeAuthRequestSignUpStartRequestParameters(clientId=" + getClientId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("NativeAuthRequestSignUpStartRequestParameters(clientId=");
            sb.append(getClientId());
            sb.append(", challengeType=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.challengeType, sb);
        }

        public NativeAuthRequestSignUpStartRequestParameters(@NotNull String username, @Nullable char[] cArr, @Nullable String str, @NotNull String clientId, @NotNull String challengeType) {
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(challengeType, "challengeType");
            this.username = username;
            this.password = cArr;
            this.attributes = str;
            this.clientId = clientId;
            this.challengeType = challengeType;
        }
    }

    public /* synthetic */ SignUpStartRequest(URL url, Map map, NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignUpStartRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignUpStartRequest copy$default(SignUpStartRequest signUpStartRequest, URL url, Map map, NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signUpStartRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signUpStartRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignUpStartRequestParameters = signUpStartRequest.getParameters();
        }
        return signUpStartRequest.copy(url, map, nativeAuthRequestSignUpStartRequestParameters);
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
    public final NativeAuthRequestSignUpStartRequestParameters component3() {
        return getParameters();
    }

    @NotNull
    public final SignUpStartRequest copy(@NotNull URL requestUrl, @NotNull Map<String, String> headers, @NotNull NativeAuthRequestSignUpStartRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignUpStartRequest(requestUrl, headers, parameters);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignUpStartRequest)) {
            return false;
        }
        SignUpStartRequest signUpStartRequest = (SignUpStartRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signUpStartRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signUpStartRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signUpStartRequest.getParameters());
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

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    public void setRequestUrl(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.requestUrl = url;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toString() {
        return "SignUpStartRequest()";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        return "SignUpStartRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + PropertyUtils.MAPPED_DELIM2;
    }

    private SignUpStartRequest(URL url, Map<String, String> map, NativeAuthRequestSignUpStartRequestParameters nativeAuthRequestSignUpStartRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignUpStartRequestParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public NativeAuthRequestSignUpStartRequestParameters getParameters() {
        return this.parameters;
    }
}
