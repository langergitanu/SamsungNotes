package com.microsoft.identity.common.java.nativeauth.providers.requests.signin;

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
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\""}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest;", "requestUrl", "Ljava/net/URL;", Contract.HEADERS, "", "", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "(Ljava/net/URL;Ljava/util/Map;Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;)V", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "getParameters", "()Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "getRequestUrl", "()Ljava/net/URL;", "setRequestUrl", "(Ljava/net/URL;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "toUnsanitizedString", "Companion", "NativeAuthRequestSignInTokenRequestParameters", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final /* data */ class SignInTokenRequest extends NativeAuthRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private Map<String, String> headers;

    @NotNull
    private final NativeAuthRequestSignInTokenRequestParameters parameters;

    @NotNull
    private URL requestUrl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JZ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eJZ\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eJZ\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$Companion;", "", "()V", "createContinuationTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest;", "continuationToken", "", SyncDBSchema.SyncInfo.CLIENT_ID, "username", "scopes", "", "challengeType", "requestUrl", Contract.HEADERS, "", "createOOBTokenRequest", "oob", "createPasswordTokenRequest", "password", "", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignInTokenRequest createContinuationTokenRequest$default(Companion companion, String str, String str2, String str3, List list, String str4, String str5, Map map, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            return companion.createContinuationTokenRequest(str, str2, str3, list, str4, str5, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignInTokenRequest createOOBTokenRequest$default(Companion companion, String str, String str2, String str3, List list, String str4, String str5, Map map, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            if ((i & 16) != 0) {
                str4 = null;
            }
            return companion.createOOBTokenRequest(str, str2, str3, list, str4, str5, map);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SignInTokenRequest createPasswordTokenRequest$default(Companion companion, char[] cArr, String str, String str2, List list, String str3, String str4, Map map, int i, Object obj) {
            if ((i & 8) != 0) {
                list = null;
            }
            if ((i & 16) != 0) {
                str3 = null;
            }
            return companion.createPasswordTokenRequest(cArr, str, str2, list, str3, str4, map);
        }

        @NotNull
        public final SignInTokenRequest createContinuationTokenRequest(@NotNull String continuationToken, @NotNull String clientId, @NotNull String username, @Nullable List<String> scopes, @Nullable String challengeType, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(username, "username");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(continuationToken, "continuationToken");
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(username, "username");
            argUtils.validateNonNullArg(challengeType, "challengeType");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new SignInTokenRequest(new URL(requestUrl), headers, new NativeAuthRequestSignInTokenRequestParameters(username, null, null, null, false, clientId, NativeAuthConstants.GrantType.CONTINUATION_TOKEN, continuationToken, scopes != null ? CollectionsKt.m13955n(scopes, " ", null, null, null, 62) : null, challengeType, 30, null), null);
        }

        @NotNull
        public final SignInTokenRequest createOOBTokenRequest(@NotNull String oob, @NotNull String continuationToken, @NotNull String clientId, @Nullable List<String> scopes, @Nullable String challengeType, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(oob, "oob");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(oob, "oob");
            argUtils.validateNonNullArg(continuationToken, "continuationToken");
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(challengeType, "challengeType");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new SignInTokenRequest(new URL(requestUrl), headers, new NativeAuthRequestSignInTokenRequestParameters(null, null, oob, null, false, clientId, "oob", continuationToken, scopes != null ? CollectionsKt.m13955n(scopes, " ", null, null, null, 62) : null, challengeType, 27, null), null);
        }

        @NotNull
        public final SignInTokenRequest createPasswordTokenRequest(@NotNull char[] password, @NotNull String continuationToken, @NotNull String clientId, @Nullable List<String> scopes, @Nullable String challengeType, @NotNull String requestUrl, @NotNull Map<String, String> headers) throws ClientException {
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            ArgUtils argUtils = ArgUtils.INSTANCE;
            argUtils.validateNonNullArg(password, "password");
            argUtils.validateNonNullArg(continuationToken, "continuationToken");
            argUtils.validateNonNullArg(clientId, SyncDBSchema.SyncInfo.CLIENT_ID);
            argUtils.validateNonNullArg(challengeType, "challengeType");
            argUtils.validateNonNullArg(requestUrl, "requestUrl");
            argUtils.validateNonNullArg(headers, Contract.HEADERS);
            return new SignInTokenRequest(new URL(requestUrl), headers, new NativeAuthRequestSignInTokenRequestParameters(null, password, null, null, false, clientId, "password", continuationToken, scopes != null ? CollectionsKt.m13955n(scopes, " ", null, null, null, 62) : null, challengeType, 29, null), null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010#\u001a\u00020\nHÂ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0080\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\b\u0010.\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u00060"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "Lcom/microsoft/identity/common/java/nativeauth/providers/requests/NativeAuthRequest$NativeAuthRequestParameters;", "username", "", "password", "", "oob", "nca", "", "clientInfo", "", SyncDBSchema.SyncInfo.CLIENT_ID, "grantType", "continuationToken", "scope", "challengeType", "(Ljava/lang/String;[CLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeType", "()Ljava/lang/String;", "getClientId", "getContinuationToken", "getGrantType", "getNca", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOob", "getPassword", "()[C", "getScope", "getUsername", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;[CLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/microsoft/identity/common/java/nativeauth/providers/requests/signin/SignInTokenRequest$NativeAuthRequestSignInTokenRequestParameters;", "equals", "other", "", "hashCode", "toString", "toUnsanitizedString", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final /* data */ class NativeAuthRequestSignInTokenRequestParameters extends NativeAuthRequest.NativeAuthRequestParameters {

        @SerializedName("challenge_type")
        @Nullable
        private final String challengeType;

        @SerializedName("client_id")
        @NotNull
        private final String clientId;

        @SerializedName("client_info")
        private final boolean clientInfo;

        @SerializedName(NativeAuthConstants.GrantType.CONTINUATION_TOKEN)
        @Nullable
        private final String continuationToken;

        @SerializedName("grant_type")
        @NotNull
        private final String grantType;

        @SerializedName("nca")
        @Nullable
        private final Integer nca;

        @Nullable
        private final String oob;

        @JsonAdapter(CharArrayJsonAdapter.class)
        @Nullable
        private final char[] password;

        @SerializedName("scope")
        @Nullable
        private final String scope;

        @Nullable
        private final String username;

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ NativeAuthRequestSignInTokenRequestParameters(String str, char[] cArr, String str2, Integer num, boolean z, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            String str9;
            String str10;
            str = (i & 1) != 0 ? null : str;
            cArr = (i & 2) != 0 ? null : cArr;
            str2 = (i & 4) != 0 ? null : str2;
            num = (i & 8) != 0 ? null : num;
            z = (i & 16) != 0 ? true : z;
            if ((i & 128) != 0) {
                str8 = str7;
                str9 = str6;
                str10 = null;
            } else {
                str8 = str7;
                str9 = str6;
                str10 = str5;
            }
            this(str, cArr, str2, num, z, str3, str4, str10, str9, str8);
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        private final boolean getClientInfo() {
            return this.clientInfo;
        }

        public static /* synthetic */ NativeAuthRequestSignInTokenRequestParameters copy$default(NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters, String str, char[] cArr, String str2, Integer num, boolean z, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeAuthRequestSignInTokenRequestParameters.username;
            }
            if ((i & 2) != 0) {
                cArr = nativeAuthRequestSignInTokenRequestParameters.password;
            }
            if ((i & 4) != 0) {
                str2 = nativeAuthRequestSignInTokenRequestParameters.oob;
            }
            if ((i & 8) != 0) {
                num = nativeAuthRequestSignInTokenRequestParameters.nca;
            }
            if ((i & 16) != 0) {
                z = nativeAuthRequestSignInTokenRequestParameters.clientInfo;
            }
            if ((i & 32) != 0) {
                str3 = nativeAuthRequestSignInTokenRequestParameters.getClientId();
            }
            if ((i & 64) != 0) {
                str4 = nativeAuthRequestSignInTokenRequestParameters.grantType;
            }
            if ((i & 128) != 0) {
                str5 = nativeAuthRequestSignInTokenRequestParameters.continuationToken;
            }
            if ((i & 256) != 0) {
                str6 = nativeAuthRequestSignInTokenRequestParameters.scope;
            }
            if ((i & 512) != 0) {
                str7 = nativeAuthRequestSignInTokenRequestParameters.challengeType;
            }
            String str8 = str6;
            String str9 = str7;
            String str10 = str4;
            String str11 = str5;
            boolean z2 = z;
            String str12 = str3;
            return nativeAuthRequestSignInTokenRequestParameters.copy(str, cArr, str2, num, z2, str12, str10, str11, str8, str9);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUsername() {
            return this.username;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getChallengeType() {
            return this.challengeType;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final char[] getPassword() {
            return this.password;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getOob() {
            return this.oob;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getNca() {
            return this.nca;
        }

        @NotNull
        public final String component6() {
            return getClientId();
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getGrantType() {
            return this.grantType;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getScope() {
            return this.scope;
        }

        @NotNull
        public final NativeAuthRequestSignInTokenRequestParameters copy(@Nullable String username, @Nullable char[] password, @Nullable String oob, @Nullable Integer nca, boolean clientInfo, @NotNull String clientId, @NotNull String grantType, @Nullable String continuationToken, @Nullable String scope, @Nullable String challengeType) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            return new NativeAuthRequestSignInTokenRequestParameters(username, password, oob, nca, clientInfo, clientId, grantType, continuationToken, scope, challengeType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeAuthRequestSignInTokenRequestParameters)) {
                return false;
            }
            NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters = (NativeAuthRequestSignInTokenRequestParameters) other;
            return Intrinsics.areEqual(this.username, nativeAuthRequestSignInTokenRequestParameters.username) && Intrinsics.areEqual(this.password, nativeAuthRequestSignInTokenRequestParameters.password) && Intrinsics.areEqual(this.oob, nativeAuthRequestSignInTokenRequestParameters.oob) && Intrinsics.areEqual(this.nca, nativeAuthRequestSignInTokenRequestParameters.nca) && this.clientInfo == nativeAuthRequestSignInTokenRequestParameters.clientInfo && Intrinsics.areEqual(getClientId(), nativeAuthRequestSignInTokenRequestParameters.getClientId()) && Intrinsics.areEqual(this.grantType, nativeAuthRequestSignInTokenRequestParameters.grantType) && Intrinsics.areEqual(this.continuationToken, nativeAuthRequestSignInTokenRequestParameters.continuationToken) && Intrinsics.areEqual(this.scope, nativeAuthRequestSignInTokenRequestParameters.scope) && Intrinsics.areEqual(this.challengeType, nativeAuthRequestSignInTokenRequestParameters.challengeType);
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

        @Nullable
        public final String getContinuationToken() {
            return this.continuationToken;
        }

        @NotNull
        public final String getGrantType() {
            return this.grantType;
        }

        @Nullable
        public final Integer getNca() {
            return this.nca;
        }

        @Nullable
        public final String getOob() {
            return this.oob;
        }

        @Nullable
        public final char[] getPassword() {
            return this.password;
        }

        @Nullable
        public final String getScope() {
            return this.scope;
        }

        @Nullable
        public final String getUsername() {
            return this.username;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v10, types: [int] */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v27 */
        public int hashCode() {
            String str = this.username;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            char[] cArr = this.password;
            int iHashCode2 = (iHashCode + (cArr == null ? 0 : Arrays.hashCode(cArr))) * 31;
            String str2 = this.oob;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.nca;
            int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            boolean z = this.clientInfo;
            ?? r32 = z;
            if (z) {
                r32 = 1;
            }
            int iM1202c = AbstractC1038a.m1202c((getClientId().hashCode() + ((iHashCode4 + r32) * 31)) * 31, 31, this.grantType);
            String str3 = this.continuationToken;
            int iHashCode5 = (iM1202c + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.scope;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.challengeType;
            return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toString() {
            return "NativeAuthRequestSignInTokenRequestParameters(nca=" + this.nca + ", clientInfo=" + this.clientInfo + ", clientId=" + getClientId() + PropertyUtils.MAPPED_DELIM2;
        }

        @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
        @NotNull
        public String toUnsanitizedString() {
            StringBuilder sb = new StringBuilder("NativeAuthRequestSignInTokenRequestParameters(nca=");
            sb.append(this.nca);
            sb.append(", clientInfo=");
            sb.append(this.clientInfo);
            sb.append(", clientId=");
            sb.append(getClientId());
            sb.append(", grantType=");
            sb.append(this.grantType);
            sb.append(", scope=");
            sb.append(this.scope);
            sb.append(", challengeType=");
            return AbstractC1038a.m1213n(PropertyUtils.MAPPED_DELIM2, this.challengeType, sb);
        }

        public NativeAuthRequestSignInTokenRequestParameters(@Nullable String str, @Nullable char[] cArr, @Nullable String str2, @Nullable Integer num, boolean z, @NotNull String clientId, @NotNull String grantType, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Intrinsics.checkNotNullParameter(grantType, "grantType");
            this.username = str;
            this.password = cArr;
            this.oob = str2;
            this.nca = num;
            this.clientInfo = z;
            this.clientId = clientId;
            this.grantType = grantType;
            this.continuationToken = str3;
            this.scope = str4;
            this.challengeType = str5;
        }
    }

    public /* synthetic */ SignInTokenRequest(URL url, Map map, NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, map, nativeAuthRequestSignInTokenRequestParameters);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignInTokenRequest copy$default(SignInTokenRequest signInTokenRequest, URL url, Map map, NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            url = signInTokenRequest.getRequestUrl();
        }
        if ((i & 2) != 0) {
            map = signInTokenRequest.getHeaders();
        }
        if ((i & 4) != 0) {
            nativeAuthRequestSignInTokenRequestParameters = signInTokenRequest.getParameters();
        }
        return signInTokenRequest.copy(url, map, nativeAuthRequestSignInTokenRequestParameters);
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
    public final NativeAuthRequestSignInTokenRequestParameters component3() {
        return getParameters();
    }

    @NotNull
    public final SignInTokenRequest copy(@NotNull URL requestUrl, @NotNull Map<String, String> headers, @NotNull NativeAuthRequestSignInTokenRequestParameters parameters) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new SignInTokenRequest(requestUrl, headers, parameters);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInTokenRequest)) {
            return false;
        }
        SignInTokenRequest signInTokenRequest = (SignInTokenRequest) other;
        return Intrinsics.areEqual(getRequestUrl(), signInTokenRequest.getRequestUrl()) && Intrinsics.areEqual(getHeaders(), signInTokenRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), signInTokenRequest.getParameters());
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
        return "SignInTokenRequest()";
    }

    @Override // com.microsoft.identity.common.java.nativeauth.util.ILoggable
    @NotNull
    public String toUnsanitizedString() {
        return "SignInTokenRequest(requestUrl=" + getRequestUrl() + ", headers=" + getHeaders() + ", parameters=" + getParameters() + PropertyUtils.MAPPED_DELIM2;
    }

    private SignInTokenRequest(URL url, Map<String, String> map, NativeAuthRequestSignInTokenRequestParameters nativeAuthRequestSignInTokenRequestParameters) {
        this.requestUrl = url;
        this.headers = map;
        this.parameters = nativeAuthRequestSignInTokenRequestParameters;
    }

    @Override // com.microsoft.identity.common.java.nativeauth.providers.requests.NativeAuthRequest
    @NotNull
    public NativeAuthRequestSignInTokenRequestParameters getParameters() {
        return this.parameters;
    }
}
