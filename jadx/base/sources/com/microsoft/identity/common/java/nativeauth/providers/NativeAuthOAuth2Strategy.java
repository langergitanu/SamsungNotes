package com.microsoft.identity.common.java.nativeauth.providers;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.ResetPasswordInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignInInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.interactors.SignUpInteractor;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordPollCompletionApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordStartApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.resetpassword.ResetPasswordSubmitApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInInitiateApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.SignInTokenApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpChallengeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpContinueApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.signup.SignUpStartApiResult;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0013\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020#J\u0016\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020(J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020+J\u0016\u0010,\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010.\u001a\u00020/2\u0006\u0010\u0017\u001a\u000200J\u0016\u00101\u001a\u0002022\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u0002082\u0006\u00105\u001a\u000209J\u000e\u0010:\u001a\u0002082\u0006\u00105\u001a\u00020;J\u000e\u0010<\u001a\u0002082\u0006\u00105\u001a\u00020=R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Strategy;", "strategyParameters", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "signInInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignInInteractor;", "signUpInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignUpInteractor;", "resetPasswordInteractor", "Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/ResetPasswordInteractor;", "(Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2StrategyParameters;Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignInInteractor;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/SignUpInteractor;Lcom/microsoft/identity/common/java/nativeauth/providers/interactors/ResetPasswordInteractor;)V", "CACHE_IDENTIFIER_MOCK", "", SearchConstants.TargetContents.TAG, "kotlin.jvm.PlatformType", "getConfig", "()Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Configuration;", "getAuthority", "getIssuerCacheIdentifierFromTokenEndpoint", "performContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "performOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "performPasswordTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "performResetPasswordChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "continuationToken", "correlationId", "performResetPasswordContinue", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "performResetPasswordPollCompletion", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "performResetPasswordStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "performResetPasswordSubmit", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "performSignInChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "performSignInInitiate", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "performSignUpChallenge", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "performSignUpStart", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "commandParameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "performSignUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "performSignUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "performSignUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "common4j"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthOAuth2Strategy extends MicrosoftStsOAuth2Strategy {

    @NotNull
    private final String CACHE_IDENTIFIER_MOCK;
    private final String TAG;

    @NotNull
    private final NativeAuthOAuth2Configuration config;

    @NotNull
    private final ResetPasswordInteractor resetPasswordInteractor;

    @NotNull
    private final SignInInteractor signInInteractor;

    @NotNull
    private final SignUpInteractor signUpInteractor;

    @NotNull
    private final OAuth2StrategyParameters strategyParameters;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAuthOAuth2Strategy(@NotNull OAuth2StrategyParameters strategyParameters, @NotNull NativeAuthOAuth2Configuration config, @NotNull SignInInteractor signInInteractor, @NotNull SignUpInteractor signUpInteractor, @NotNull ResetPasswordInteractor resetPasswordInteractor) {
        super(config, strategyParameters);
        Intrinsics.checkNotNullParameter(strategyParameters, "strategyParameters");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(signInInteractor, "signInInteractor");
        Intrinsics.checkNotNullParameter(signUpInteractor, "signUpInteractor");
        Intrinsics.checkNotNullParameter(resetPasswordInteractor, "resetPasswordInteractor");
        this.strategyParameters = strategyParameters;
        this.config = config;
        this.signInInteractor = signInInteractor;
        this.signUpInteractor = signUpInteractor;
        this.resetPasswordInteractor = resetPasswordInteractor;
        this.TAG = "NativeAuthOAuth2Strategy";
        this.CACHE_IDENTIFIER_MOCK = "login.windows.net";
    }

    @NotNull
    public final String getAuthority() {
        String string = this.config.getAuthorityUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "config.authorityUrl.toString()");
        return string;
    }

    @NotNull
    public final NativeAuthOAuth2Configuration getConfig() {
        return this.config;
    }

    @Override // com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy
    @NotNull
    public String getIssuerCacheIdentifierFromTokenEndpoint() {
        if (this.config.getUseMockApiForNativeAuth()) {
            return this.CACHE_IDENTIFIER_MOCK;
        }
        String issuerCacheIdentifierFromTokenEndpoint = super.getIssuerCacheIdentifierFromTokenEndpoint();
        Intrinsics.checkNotNullExpressionValue(issuerCacheIdentifierFromTokenEndpoint, "super.getIssuerCacheIdentifierFromTokenEndpoint()");
        return issuerCacheIdentifierFromTokenEndpoint;
    }

    @NotNull
    public final SignInTokenApiResult performContinuationTokenTokenRequest(@NotNull SignInWithContinuationTokenCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performContinuationTokenRequest", new StringBuilder()));
        return this.signInInteractor.performContinuationTokenTokenRequest(parameters);
    }

    @NotNull
    public final SignInTokenApiResult performOOBTokenRequest(@NotNull SignInSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performOOBTokenRequest", new StringBuilder()));
        return this.signInInteractor.performOOBTokenRequest(parameters);
    }

    @NotNull
    public final SignInTokenApiResult performPasswordTokenRequest(@NotNull SignInSubmitPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performPasswordTokenRequest", new StringBuilder()));
        return this.signInInteractor.performPasswordTokenRequest(parameters);
    }

    @NotNull
    public final ResetPasswordChallengeApiResult performResetPasswordChallenge(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordChallenge", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return this.resetPasswordInteractor.performResetPasswordChallenge(continuationToken, correlationId);
    }

    @NotNull
    public final ResetPasswordContinueApiResult performResetPasswordContinue(@NotNull ResetPasswordSubmitCodeCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performResetPasswordContinue", new StringBuilder()));
        return this.resetPasswordInteractor.performResetPasswordContinue(parameters);
    }

    @NotNull
    public final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletion(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".performResetPasswordPollCompletion", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return this.resetPasswordInteractor.performResetPasswordPollCompletion(continuationToken, correlationId);
    }

    @NotNull
    public final ResetPasswordStartApiResult performResetPasswordStart(@NotNull ResetPasswordStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performResetPasswordStart", new StringBuilder()));
        return this.resetPasswordInteractor.performResetPasswordStart(parameters);
    }

    @NotNull
    public final ResetPasswordSubmitApiResult performResetPasswordSubmit(@NotNull ResetPasswordSubmitNewPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performResetPasswordSubmit", new StringBuilder()));
        return this.resetPasswordInteractor.performResetPasswordSubmit(parameters);
    }

    @NotNull
    public final SignInChallengeApiResult performSignInChallenge(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".performSignInChallenge", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return this.signInInteractor.performSignInChallenge(continuationToken, correlationId);
    }

    @NotNull
    public final SignInInitiateApiResult performSignInInitiate(@NotNull SignInStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, parameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignInInitiate", new StringBuilder()));
        return this.signInInteractor.performSignInInitiate(parameters);
    }

    @NotNull
    public final SignUpChallengeApiResult performSignUpChallenge(@NotNull String continuationToken, @NotNull String correlationId) {
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = this.TAG;
        companion.logMethodCall(str, correlationId, AbstractC0622a.m1170p(this.TAG, ".performSignUpChallenge", AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG)));
        return this.signUpInteractor.performSignUpChallenge(continuationToken, correlationId);
    }

    @NotNull
    public final SignUpStartApiResult performSignUpStart(@NotNull SignUpStartCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignUpStart", new StringBuilder()));
        return this.signUpInteractor.performSignUpStart(commandParameters);
    }

    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitCode(@NotNull SignUpSubmitCodeCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignUpSubmitCode", new StringBuilder()));
        return this.signUpInteractor.performSignUpSubmitCode(commandParameters);
    }

    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitPassword(@NotNull SignUpSubmitPasswordCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignUpSubmitPassword", new StringBuilder()));
        return this.signUpInteractor.performSignUpSubmitPassword(commandParameters);
    }

    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitUserAttributes(@NotNull SignUpSubmitUserAttributesCommandParameters commandParameters) {
        Intrinsics.checkNotNullParameter(commandParameters, "commandParameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG = this.TAG;
        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        companion.logMethodCall(TAG, commandParameters.getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".performSignUpSubmitUserAttributes", new StringBuilder()));
        return this.signUpInteractor.performSignUpSubmitUserAttributes(commandParameters);
    }
}
