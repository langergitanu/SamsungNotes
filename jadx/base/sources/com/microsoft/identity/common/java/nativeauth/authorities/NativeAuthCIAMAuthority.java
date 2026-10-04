package com.microsoft.identity.common.java.nativeauth.authorities;

import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2Configuration;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2Strategy;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2StrategyFactory;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/authorities/NativeAuthCIAMAuthority;", "Lcom/microsoft/identity/common/java/authorities/CIAMAuthority;", "authorityUrl", "", SyncDBSchema.SyncInfo.CLIENT_ID, "(Ljava/lang/String;Ljava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "createNativeAuthOAuth2Configuration", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "challengeTypes", "", "createOAuth2Strategy", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", "parameters", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;", "getChallengeTypesWithDefault", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthCIAMAuthority extends CIAMAuthority {
    private static final boolean NATIVE_AUTH_USE_OPENID_CONFIGURATION = false;

    @NotNull
    private final String authorityUrl;

    @NotNull
    private final String clientId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NativeAuthCIAMAuthority";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/authorities/NativeAuthCIAMAuthority$Companion;", "", "()V", "NATIVE_AUTH_USE_OPENID_CONFIGURATION", "", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "getAuthorityFromAuthorityUrl", "Lcom/microsoft/identity/common/java/nativeauth/authorities/NativeAuthCIAMAuthority;", "authorityUrl", SyncDBSchema.SyncInfo.CLIENT_ID, "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NativeAuthCIAMAuthority getAuthorityFromAuthorityUrl(@NotNull String authorityUrl, @NotNull String clientId) throws ClientException {
            Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            Authority authorityFromAuthorityUrl = Authority.getAuthorityFromAuthorityUrl(authorityUrl);
            if (authorityFromAuthorityUrl instanceof NativeAuthCIAMAuthority) {
                return (NativeAuthCIAMAuthority) authorityFromAuthorityUrl;
            }
            if (!(authorityFromAuthorityUrl instanceof CIAMAuthority)) {
                throw new ClientException("native_auth_invalid_ciam_authority");
            }
            String string = ((CIAMAuthority) authorityFromAuthorityUrl).getAuthorityUri().toString();
            Intrinsics.checkNotNullExpressionValue(string, "authority.authorityUri.toString()");
            return new NativeAuthCIAMAuthority(string, clientId);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAuthCIAMAuthority(@NotNull String authorityUrl, @NotNull String clientId) {
        super(authorityUrl);
        Intrinsics.checkNotNullParameter(authorityUrl, "authorityUrl");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.authorityUrl = authorityUrl;
        this.clientId = clientId;
        this.mAuthorityTypeString = Authority.AAD_NA;
        this.mAuthorityUrlString = authorityUrl;
    }

    private final NativeAuthOAuth2Configuration createNativeAuthOAuth2Configuration(List<String> challengeTypes) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".createNativeAuthOAuth2Configuration"));
        URL authorityURL = getAuthorityURL();
        Intrinsics.checkNotNullExpressionValue(authorityURL, "this.authorityURL");
        return new NativeAuthOAuth2Configuration(authorityURL, this.clientId, getChallengeTypesWithDefault(challengeTypes), false, 8, null);
    }

    private final String getChallengeTypesWithDefault(List<String> challengeTypes) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".getChallengeTypesWithDefault"));
        Logger.info(str, "Challenge Types passed = " + challengeTypes);
        if (challengeTypes == null) {
            challengeTypes = CollectionsKt.emptyList();
        }
        return CollectionsKt.m13955n(CollectionsKt.distinct(CollectionsKt.plus((Collection) challengeTypes, (Iterable) CollectionsKt.listOf("redirect"))), " ", null, null, null, 62);
    }

    @NotNull
    public final String getClientId() {
        return this.clientId;
    }

    @Override // com.microsoft.identity.common.java.authorities.CIAMAuthority, com.microsoft.identity.common.java.authorities.Authority
    @NotNull
    public NativeAuthOAuth2Strategy createOAuth2Strategy(@NotNull OAuth2StrategyParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        NativeAuthOAuth2Configuration nativeAuthOAuth2ConfigurationCreateNativeAuthOAuth2Configuration = createNativeAuthOAuth2Configuration(parameters.mChallengeTypes);
        parameters.setUsingOpenIdConfiguration(false);
        return NativeAuthOAuth2StrategyFactory.INSTANCE.createStrategy(nativeAuthOAuth2ConfigurationCreateNativeAuthOAuth2Configuration, parameters);
    }
}
