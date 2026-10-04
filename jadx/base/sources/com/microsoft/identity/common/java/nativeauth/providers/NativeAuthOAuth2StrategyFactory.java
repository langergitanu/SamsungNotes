package com.microsoft.identity.common.java.nativeauth.providers;

import com.microsoft.identity.common.java.nativeauth.providers.interactors.ResetPasswordInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignInInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignUpInteractor;
import com.microsoft.identity.common.java.net.UrlConnectionHttpClient;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2StrategyFactory;", "", "()V", "Companion", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthOAuth2StrategyFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2StrategyFactory$Companion;", "", "()V", "createStrategy", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "strategyParameters", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NativeAuthOAuth2Strategy createStrategy(@NotNull NativeAuthOAuth2Configuration config, @NotNull OAuth2StrategyParameters strategyParameters) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(strategyParameters, "strategyParameters");
            UrlConnectionHttpClient defaultInstance = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance()");
            SignInInteractor signInInteractor = new SignInInteractor(defaultInstance, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler());
            UrlConnectionHttpClient defaultInstance2 = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance2, "getDefaultInstance()");
            SignUpInteractor signUpInteractor = new SignUpInteractor(defaultInstance2, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler());
            UrlConnectionHttpClient defaultInstance3 = UrlConnectionHttpClient.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance3, "getDefaultInstance()");
            return new NativeAuthOAuth2Strategy(strategyParameters, config, signInInteractor, signUpInteractor, new ResetPasswordInteractor(defaultInstance3, new NativeAuthRequestProvider(config), new NativeAuthResponseHandler()));
        }

        private Companion() {
        }
    }
}
