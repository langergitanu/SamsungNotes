package com.microsoft.identity.common.nativeauth.internal.controllers;

import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.internal.commands.RefreshOnCommand;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseNativeAuthCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.BaseSignInTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpSubmitUserAttributesCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitNewPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitUserAttributesCommandResult;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthOAuth2Strategy;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.ApiResult;
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
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThreadUtils;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.microsoft.identity.common.nativeauth.internal.util.CommandUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Ö\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 |2\u00020\u0001:\u0001|B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u001aH\u0007J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020!H\u0002J \u0010\"\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020)H\u0002J \u0010*\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020.H\u0002J \u0010/\u001a\u0002002\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0018\u00101\u001a\u0002022\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u000203H\u0007J\u0018\u00104\u001a\u0002052\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u000206H\u0002J\u0018\u00107\u001a\u0002052\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u000208H\u0002J\u0018\u00109\u001a\u0002052\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020:H\u0007J*\u0010;\u001a\u00020<2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010.2\u0006\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0002J.\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020-2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010.2\u0006\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010?\u001a\u00020@H\u0007Jp\u0010C\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00042\u0012\u0010G\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030H2:\u0010\r\u001a6\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030I2\u0006\u0010J\u001a\u00020KH\u0002J(\u0010L\u001a\u00020M2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010N\u001a\u00020OH\u0002J\u000e\u0010P\u001a\u00020Q2\u0006\u0010\u0005\u001a\u00020RJ\u000e\u0010S\u001a\u00020T2\u0006\u0010\u0005\u001a\u00020&J\u000e\u0010U\u001a\u00020V2\u0006\u0010\u0005\u001a\u00020!J\u000e\u0010W\u001a\u00020M2\u0006\u0010\u0005\u001a\u00020)J \u0010X\u001a\u00020Y2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0002J&\u0010]\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010=\u001a\u00020E2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020K0\bH\u0002J\u000e\u0010_\u001a\u00020`2\u0006\u0010\u0005\u001a\u00020aJ\u000e\u0010b\u001a\u00020<2\u0006\u0010\u0005\u001a\u00020.J\u000e\u0010c\u001a\u00020d2\u0006\u0010\u0005\u001a\u00020\u0018J\u000e\u0010e\u001a\u00020f2\u0006\u0010\u0005\u001a\u00020\u001aJ\u000e\u0010g\u001a\u00020h2\u0006\u0010\u0005\u001a\u00020\u0016J\u000e\u0010i\u001a\u00020j2\u0006\u0010\u0005\u001a\u00020kJ\u000e\u0010l\u001a\u00020m2\u0006\u0010\u0005\u001a\u000203J\u000e\u0010n\u001a\u00020o2\u0006\u0010\u0005\u001a\u000206J\u000e\u0010p\u001a\u00020q2\u0006\u0010\u0005\u001a\u000208J\u000e\u0010r\u001a\u00020s2\u0006\u0010\u0005\u001a\u00020:J\f\u0010t\u001a\u00020T*\u00020\u001cH\u0002J\u001c\u0010u\u001a\u00020<*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020.H\u0002J\u001c\u0010v\u001a\u00020f*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001aH\u0002J\f\u0010w\u001a\u00020m*\u000200H\u0002J\u0014\u0010x\u001a\u00020o*\u0002052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0014\u0010y\u001a\u00020q*\u0002052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0014\u0010z\u001a\u00020s*\u0002052\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\f\u0010{\u001a\u00020s*\u000200H\u0002¨\u0006}"}, m13886d2 = {"Lcom/microsoft/identity/common/nativeauth/internal/controllers/NativeAuthMsalController;", "Lcom/microsoft/identity/common/nativeauth/internal/controllers/BaseNativeAuthController;", "()V", "acquireTokenSilent", "Lcom/microsoft/identity/common/java/result/AcquireTokenResult;", "parameters", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/AcquireTokenNoFixedScopesCommandParameters;", "addDefaultScopes", "", "", "scopes", "createAuthorizationRequest", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsAuthorizationRequest;", "strategy", "Lcom/microsoft/identity/common/java/nativeauth/providers/NativeAuthOAuth2Strategy;", SyncDBSchema.SyncInfo.CLIENT_ID, "applicationIdentifier", "createOAuth2Strategy", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/BaseNativeAuthCommandParameters;", "performContinuationTokenTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult;", "oAuth2Strategy", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInWithContinuationTokenCommandParameters;", "performOOBTokenRequest", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitCodeCommandParameters;", "performPasswordTokenCall", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInSubmitPasswordCommandParameters;", "performResetPasswordChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordChallengeApiResult;", "continuationToken", "correlationId", "performResetPasswordContinueCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitCodeCommandParameters;", "performResetPasswordPollCompletionCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordPollCompletionApiResult;", "performResetPasswordStartCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordStartCommandParameters;", "performResetPasswordSubmitCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/resetpassword/ResetPasswordSubmitApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordSubmitNewPasswordCommandParameters;", "performSignInChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInChallengeApiResult;", "performSignInInitiateCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInInitiateApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInStartCommandParameters;", "performSignUpChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpChallengeApiResult;", "performSignUpStartUsingPasswordRequest", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpStartApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpStartCommandParameters;", "performSignUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signup/SignUpContinueApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitCodeCommandParameters;", "performSignUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitPasswordCommandParameters;", "performSignUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpSubmitUserAttributesCommandParameters;", "processSignInChallengeCall", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInStartCommandResult;", "parametersWithScopes", "result", "usePassword", "", "processSignInInitiateApiResult", "initiateApiResult", "renewAT", "", "Lcom/microsoft/identity/common/java/commands/parameters/SilentTokenCommandParameters;", "acquireTokenSilentResult", "tokenCache", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2TokenCache;", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2Strategy;", "cacheRecord", "Lcom/microsoft/identity/common/java/cache/ICacheRecord;", "resetPasswordPollCompletion", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitNewPasswordCommandResult;", "pollIntervalInSeconds", "", "resetPasswordResendCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/ResetPasswordResendCodeCommandParameters;", "resetPasswordStart", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordStartCommandResult;", "resetPasswordSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/ResetPasswordSubmitCodeCommandResult;", "resetPasswordSubmitNewPassword", "saveAndReturnTokens", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInCommandResult$Complete;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/BaseSignInTokenCommandParameters;", "tokenApiResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/SignInTokenApiResult$Success;", "setAcquireTokenResult", "cacheRecords", "signInResendCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignInResendCodeCommandParameters;", "signInStart", "signInSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitCodeCommandResult;", "signInSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInSubmitPasswordCommandResult;", "signInWithContinuationToken", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignInWithContinuationTokenCommandResult;", "signUpResendCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpResendCodeCommandResult;", "Lcom/microsoft/identity/common/java/nativeauth/commands/parameters/SignUpResendCodeCommandParameters;", "signUpStart", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpStartCommandResult;", "signUpSubmitCode", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitCodeCommandResult;", "signUpSubmitPassword", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitPasswordCommandResult;", "signUpSubmitUserAttributes", "Lcom/microsoft/identity/common/java/nativeauth/controllers/results/SignUpSubmitUserAttributesCommandResult;", "toResetPasswordStartCommandResult", "toSignInStartCommandResult", "toSignInSubmitPasswordCommandResult", "toSignUpStartCommandResult", "toSignUpSubmitCodeCommandResult", "toSignUpSubmitPasswordCommandResult", "toSignUpSubmitUserAttributesCommandResult", "toSignUpSubmitUserAttrsCommandResult", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthMsalController extends BaseNativeAuthController {
    private static final String TAG = "NativeAuthMsalController";

    private final List<String> addDefaultScopes(List<String> scopes) {
        List arrayList;
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".createAuthorizationRequest"));
        if (scopes == null || (arrayList = CollectionsKt.toMutableList((Collection) scopes)) == null) {
            arrayList = new ArrayList();
        }
        Set<String> DEFAULT_SCOPES = AuthenticationConstants.DEFAULT_SCOPES;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_SCOPES, "DEFAULT_SCOPES");
        arrayList.addAll(DEFAULT_SCOPES);
        TypeIntrinsics.asMutableCollection(arrayList).removeAll(CollectionsKt.listOf((Object[]) new String[]{"", null}));
        return CollectionsKt.toList(arrayList);
    }

    private final MicrosoftStsAuthorizationRequest createAuthorizationRequest(NativeAuthOAuth2Strategy strategy, List<String> scopes, String clientId, String applicationIdentifier) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".createAuthorizationRequest"));
        MicrosoftStsAuthorizationRequest.Builder builder = new MicrosoftStsAuthorizationRequest.Builder();
        builder.setAuthority(new URL(strategy.getAuthority()));
        builder.setClientId(clientId);
        builder.setScope(StringUtil.join(" ", scopes));
        builder.setApplicationIdentifier(applicationIdentifier);
        MicrosoftStsAuthorizationRequest microsoftStsAuthorizationRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(microsoftStsAuthorizationRequestBuild, "builder.build()");
        return microsoftStsAuthorizationRequestBuild;
    }

    private final NativeAuthOAuth2Strategy createOAuth2Strategy(BaseNativeAuthCommandParameters parameters) {
        OAuth2StrategyParameters strategyParameters = OAuth2StrategyParameters.builder().platformComponents(parameters.getPlatformComponents()).challengeTypes(parameters.challengeType).build();
        NativeAuthCIAMAuthority nativeAuthCIAMAuthority = parameters.authority;
        Intrinsics.checkNotNullExpressionValue(strategyParameters, "strategyParameters");
        return nativeAuthCIAMAuthority.createOAuth2Strategy(strategyParameters);
    }

    private final SignInTokenApiResult performOOBTokenRequest(NativeAuthOAuth2Strategy oAuth2Strategy, SignInSubmitCodeCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performOOBTokenRequest", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performOOBTokenRequest(parameters);
    }

    private final ResetPasswordChallengeApiResult performResetPasswordChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, correlationId, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".performResetPasswordChallengeCall"));
        return oAuth2Strategy.performResetPasswordChallenge(continuationToken, correlationId);
    }

    private final ResetPasswordContinueApiResult performResetPasswordContinueCall(NativeAuthOAuth2Strategy oAuth2Strategy, ResetPasswordSubmitCodeCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performResetPasswordContinueCall", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performResetPasswordContinue(parameters);
    }

    private final ResetPasswordPollCompletionApiResult performResetPasswordPollCompletionCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, correlationId, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".performResetPasswordPollCompletionCall"));
        return oAuth2Strategy.performResetPasswordPollCompletion(continuationToken, correlationId);
    }

    private final ResetPasswordStartApiResult performResetPasswordStartCall(NativeAuthOAuth2Strategy oAuth2Strategy, ResetPasswordStartCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performResetPasswordStartCall", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performResetPasswordStart(parameters);
    }

    private final ResetPasswordSubmitApiResult performResetPasswordSubmitCall(NativeAuthOAuth2Strategy oAuth2Strategy, ResetPasswordSubmitNewPasswordCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performResetPasswordSubmitCall", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performResetPasswordSubmit(parameters);
    }

    private final SignInChallengeApiResult performSignInChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, correlationId, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".performSignInChallengeCall"));
        return oAuth2Strategy.performSignInChallenge(continuationToken, correlationId);
    }

    private final SignInInitiateApiResult performSignInInitiateCall(NativeAuthOAuth2Strategy oAuth2Strategy, SignInStartCommandParameters parameters) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performSignInInitiateCall", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performSignInInitiate(parameters);
    }

    private final SignUpChallengeApiResult performSignUpChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId) {
        return oAuth2Strategy.performSignUpChallenge(continuationToken, correlationId);
    }

    private final SignUpContinueApiResult performSignUpSubmitCode(NativeAuthOAuth2Strategy oAuth2Strategy, SignUpSubmitCodeCommandParameters parameters) {
        return oAuth2Strategy.performSignUpSubmitCode(parameters);
    }

    private final SignUpContinueApiResult performSignUpSubmitPassword(NativeAuthOAuth2Strategy oAuth2Strategy, SignUpSubmitPasswordCommandParameters parameters) {
        return oAuth2Strategy.performSignUpSubmitPassword(parameters);
    }

    private final SignInStartCommandResult processSignInChallengeCall(NativeAuthOAuth2Strategy oAuth2Strategy, SignInStartCommandParameters parametersWithScopes, SignInChallengeApiResult result, boolean usePassword) {
        if (result instanceof SignInChallengeApiResult.OOBRequired) {
            SignInChallengeApiResult.OOBRequired oOBRequired = (SignInChallengeApiResult.OOBRequired) result;
            String continuationToken = oOBRequired.getContinuationToken();
            int codeLength = oOBRequired.getCodeLength();
            return new SignInCommandResult.CodeRequired(result.getCorrelationId(), continuationToken, oOBRequired.getChallengeTargetLabel(), oOBRequired.getChallengeChannel(), codeLength);
        }
        if (result instanceof SignInChallengeApiResult.PasswordRequired) {
            if (!usePassword) {
                return new SignInCommandResult.PasswordRequired(result.getCorrelationId(), ((SignInChallengeApiResult.PasswordRequired) result).getContinuationToken());
            }
            if (parametersWithScopes == null) {
                throw new IllegalArgumentException("Parameters must be provided in password flow");
            }
            SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters = CommandUtil.createSignInSubmitPasswordCommandParameters(parametersWithScopes, result.getCorrelationId(), ((SignInChallengeApiResult.PasswordRequired) result).getContinuationToken());
            try {
                Intrinsics.checkNotNullExpressionValue(signInSubmitPasswordCommandParameters, "signInSubmitPasswordCommandParameters");
                return toSignInStartCommandResult(performPasswordTokenCall(oAuth2Strategy, signInSubmitPasswordCommandParameters), oAuth2Strategy, parametersWithScopes);
            } finally {
                StringUtil.overwriteWithNull(signInSubmitPasswordCommandParameters.password);
            }
        }
        if (result instanceof SignInChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(result.getCorrelationId());
        }
        if (!(result instanceof SignInChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, result.getCorrelationId(), "Unexpected result: ", result);
        SignInChallengeApiResult.UnknownError unknownError = (SignInChallengeApiResult.UnknownError) result;
        return new INativeAuthCommandResult.UnknownError(unknownError.getError(), unknownError.getErrorDescription(), null, result.getCorrelationId(), unknownError.getErrorCodes(), null, 36, null);
    }

    public static /* synthetic */ SignInStartCommandResult processSignInInitiateApiResult$default(NativeAuthMsalController nativeAuthMsalController, SignInInitiateApiResult signInInitiateApiResult, SignInStartCommandParameters signInStartCommandParameters, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            signInStartCommandParameters = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return nativeAuthMsalController.processSignInInitiateApiResult(signInInitiateApiResult, signInStartCommandParameters, nativeAuthOAuth2Strategy, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void renewAT(SilentTokenCommandParameters parameters, AcquireTokenResult acquireTokenSilentResult, OAuth2TokenCache<?, ?, ?> tokenCache, OAuth2Strategy<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> strategy, ICacheRecord cacheRecord) throws ServiceException, ClientException {
        Set<String> set;
        List listM13999t;
        List listEmptyList;
        Logger.verbose(TAG, parameters.getCorrelationId(), "Renewing access token...");
        String target = cacheRecord.getAccessToken().getTarget();
        if (target == null || (listM13999t = AbstractC12991c.m13999t(0, " ", target)) == null) {
            set = null;
        } else if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
            }
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
            if (listEmptyList == null) {
                set = CollectionsKt.toSet(listEmptyList);
            }
        }
        renewAccessToken(((SilentTokenCommandParameters.SilentTokenCommandParametersBuilder) parameters.toBuilder().scopes(set)).build(), acquireTokenSilentResult, tokenCache, strategy, cacheRecord);
    }

    private final ResetPasswordSubmitNewPasswordCommandResult resetPasswordPollCompletion(NativeAuthOAuth2Strategy oAuth2Strategy, String continuationToken, String correlationId, int pollIntervalInSeconds) throws Exception {
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        String strM1170p = AbstractC0622a.m1170p(str, ":resetPasswordPollCompletion", sb);
        LogSession.INSTANCE.logMethodCall(str, correlationId, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".resetPasswordPollCompletion"));
        int i = pollIntervalInSeconds * 1000;
        try {
            ResetPasswordPollCompletionApiResult resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall = performResetPasswordPollCompletionCall(oAuth2Strategy, continuationToken, correlationId);
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.InProgress) {
                ThreadUtils.sleepSafely(i, strM1170p, "Waiting between reset password polls");
                if (resetPasswordPollCompletion$pollCompletionTimedOut(jCurrentTimeMillis)) {
                    Logger.warn(TAG, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "Reset password completion timed out.");
                    return new ResetPasswordCommandResult.PasswordResetFailed(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "timeout", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_DESCRIPTION);
                }
                resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall = performResetPasswordPollCompletionCall(oAuth2Strategy, continuationToken, correlationId);
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.PollingFailed) {
                return new ResetPasswordCommandResult.PasswordResetFailed(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), ((ResetPasswordPollCompletionApiResult.PollingFailed) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getError(), ((ResetPasswordPollCompletionApiResult.PollingFailed) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getErrorDescription());
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.PollingSucceeded) {
                return new ResetPasswordCommandResult.Complete(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), ((ResetPasswordPollCompletionApiResult.PollingSucceeded) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getContinuationToken(), ((ResetPasswordPollCompletionApiResult.PollingSucceeded) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getExpiresIn());
            }
            if (resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.InProgress) {
                Logger.warn(TAG, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "in_progress received after polling, illegal state");
                return new INativeAuthCommandResult.UnknownError("illegal_state", "in_progress received after polling concluded, illegal state", null, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), null, null, 52, null);
            }
            boolean z = true;
            if (!(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.ExpiredToken ? true : resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.UserNotFound ? true : resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.PasswordInvalid)) {
                z = resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall instanceof ResetPasswordPollCompletionApiResult.UnknownError;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), "Unexpected result: ", resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall);
            Intrinsics.checkNotNull(resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getError(), ((ApiErrorResult) resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall).getErrorDescription(), null, resetPasswordPollCompletionApiResultPerformResetPasswordPollCompletionCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, correlationId, "Exception thrown in resetPasswordPollCompletion", e);
            throw e;
        }
    }

    private static final boolean resetPasswordPollCompletion$pollCompletionTimedOut(long j) {
        return System.currentTimeMillis() - j > 300000;
    }

    private final SignInCommandResult.Complete saveAndReturnTokens(NativeAuthOAuth2Strategy oAuth2Strategy, BaseSignInTokenCommandParameters parametersWithScopes, SignInTokenApiResult.Success tokenApiResult) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".saveAndReturnTokens", companion, TAG2, parametersWithScopes.getCorrelationId());
        Intrinsics.checkNotNull(oAuth2Strategy, "null cannot be cast to non-null type com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy");
        List<String> list = parametersWithScopes.scopes;
        Intrinsics.checkNotNullExpressionValue(list, "parametersWithScopes.scopes");
        String clientId = parametersWithScopes.getClientId();
        Intrinsics.checkNotNullExpressionValue(clientId, "parametersWithScopes.clientId");
        String applicationIdentifier = parametersWithScopes.getApplicationIdentifier();
        Intrinsics.checkNotNullExpressionValue(applicationIdentifier, "parametersWithScopes.applicationIdentifier");
        List<ICacheRecord> listSaveTokens = saveTokens(oAuth2Strategy, createAuthorizationRequest(oAuth2Strategy, list, clientId, applicationIdentifier), tokenApiResult.getTokenResponse(), parametersWithScopes.getOAuth2TokenCache());
        Intrinsics.checkNotNullExpressionValue(listSaveTokens, "saveTokens(\n            …Auth2TokenCache\n        )");
        return new SignInCommandResult.Complete(tokenApiResult.getCorrelationId(), new LocalAuthenticationResult(finalizeCacheRecordForResult(listSaveTokens.get(0), parametersWithScopes.getAuthenticationScheme()), listSaveTokens, SdkType.MSAL, false));
    }

    private final void setAcquireTokenResult(AcquireTokenResult acquireTokenSilentResult, SilentTokenCommandParameters parametersWithScopes, List<? extends ICacheRecord> cacheRecords) {
        acquireTokenSilentResult.setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult(cacheRecords.get(0), parametersWithScopes.getAuthenticationScheme()), cacheRecords, SdkType.MSAL, true));
    }

    private final ResetPasswordStartCommandResult toResetPasswordStartCommandResult(ResetPasswordChallengeApiResult resetPasswordChallengeApiResult) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".createAuthorizationRequest", companion, TAG2, resetPasswordChallengeApiResult.getCorrelationId());
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.CodeRequired) {
            ResetPasswordChallengeApiResult.CodeRequired codeRequired = (ResetPasswordChallengeApiResult.CodeRequired) resetPasswordChallengeApiResult;
            return new ResetPasswordCommandResult.CodeRequired(resetPasswordChallengeApiResult.getCorrelationId(), codeRequired.getContinuationToken(), codeRequired.getCodeLength(), codeRequired.getChallengeTargetLabel(), codeRequired.getChallengeChannel());
        }
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(resetPasswordChallengeApiResult.getCorrelationId());
        }
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.ExpiredToken) {
            Logger.warnWithObject(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), "Expire token result: ", resetPasswordChallengeApiResult);
            ResetPasswordChallengeApiResult.ExpiredToken expiredToken = (ResetPasswordChallengeApiResult.ExpiredToken) resetPasswordChallengeApiResult;
            return new INativeAuthCommandResult.UnknownError(expiredToken.getError(), expiredToken.getErrorDescription(), null, resetPasswordChallengeApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.UnsupportedChallengeType) {
            Logger.warnWithObject(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), "Unsupported challenge type: ", resetPasswordChallengeApiResult);
            ResetPasswordChallengeApiResult.UnsupportedChallengeType unsupportedChallengeType = (ResetPasswordChallengeApiResult.UnsupportedChallengeType) resetPasswordChallengeApiResult;
            return new INativeAuthCommandResult.UnknownError(unsupportedChallengeType.getError(), unsupportedChallengeType.getErrorDescription(), null, resetPasswordChallengeApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (!(resetPasswordChallengeApiResult instanceof ResetPasswordChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG2, resetPasswordChallengeApiResult.getCorrelationId(), "Unexpected result: ", resetPasswordChallengeApiResult);
        ResetPasswordChallengeApiResult.UnknownError unknownError = (ResetPasswordChallengeApiResult.UnknownError) resetPasswordChallengeApiResult;
        return new INativeAuthCommandResult.UnknownError(unknownError.getError(), unknownError.getErrorDescription(), null, resetPasswordChallengeApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignInStartCommandResult toSignInStartCommandResult(SignInTokenApiResult signInTokenApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy, SignInStartCommandParameters signInStartCommandParameters) {
        if (signInTokenApiResult instanceof SignInTokenApiResult.InvalidCredentials) {
            SignInTokenApiResult.InvalidCredentials invalidCredentials = (SignInTokenApiResult.InvalidCredentials) signInTokenApiResult;
            return new SignInCommandResult.InvalidCredentials(signInTokenApiResult.getCorrelationId(), invalidCredentials.getError(), invalidCredentials.getErrorDescription(), invalidCredentials.getErrorCodes());
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.Success) {
            return saveAndReturnTokens(nativeAuthOAuth2Strategy, signInStartCommandParameters, (SignInTokenApiResult.Success) signInTokenApiResult);
        }
        if (!(signInTokenApiResult instanceof SignInTokenApiResult.CodeIncorrect ? true : signInTokenApiResult instanceof SignInTokenApiResult.MFARequired ? true : signInTokenApiResult instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : signInTokenApiResult instanceof SignInTokenApiResult.UserNotFound ? true : signInTokenApiResult instanceof SignInTokenApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signInTokenApiResult.getCorrelationId(), "Unexpected result: ", signInTokenApiResult);
        Intrinsics.checkNotNull(signInTokenApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        return new INativeAuthCommandResult.UnknownError("unexpected_api_result", "API returned unexpected result: " + signInTokenApiResult, null, signInTokenApiResult.getCorrelationId(), ((ApiErrorResult) signInTokenApiResult).getErrorCodes(), null, 36, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignInSubmitPasswordCommandResult toSignInSubmitPasswordCommandResult(SignInTokenApiResult signInTokenApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy, SignInSubmitPasswordCommandParameters signInSubmitPasswordCommandParameters) {
        if (signInTokenApiResult instanceof SignInTokenApiResult.InvalidCredentials) {
            SignInTokenApiResult.InvalidCredentials invalidCredentials = (SignInTokenApiResult.InvalidCredentials) signInTokenApiResult;
            return new SignInCommandResult.InvalidCredentials(signInTokenApiResult.getCorrelationId(), invalidCredentials.getError(), invalidCredentials.getErrorDescription(), invalidCredentials.getErrorCodes());
        }
        if (signInTokenApiResult instanceof SignInTokenApiResult.Success) {
            return saveAndReturnTokens(nativeAuthOAuth2Strategy, signInSubmitPasswordCommandParameters, (SignInTokenApiResult.Success) signInTokenApiResult);
        }
        if (!(signInTokenApiResult instanceof SignInTokenApiResult.UserNotFound ? true : signInTokenApiResult instanceof SignInTokenApiResult.CodeIncorrect ? true : signInTokenApiResult instanceof SignInTokenApiResult.MFARequired ? true : signInTokenApiResult instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : signInTokenApiResult instanceof SignInTokenApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signInTokenApiResult.getCorrelationId(), "Unexpected result: ", signInTokenApiResult);
        Intrinsics.checkNotNull(signInTokenApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        return new INativeAuthCommandResult.UnknownError("unexpected_api_result", "API returned unexpected result: " + signInTokenApiResult, null, signInTokenApiResult.getCorrelationId(), ((ApiErrorResult) signInTokenApiResult).getErrorCodes(), null, 36, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpStartCommandResult toSignUpStartCommandResult(SignUpChallengeApiResult signUpChallengeApiResult) {
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.OOBRequired) {
            SignUpChallengeApiResult.OOBRequired oOBRequired = (SignUpChallengeApiResult.OOBRequired) signUpChallengeApiResult;
            return new SignUpCommandResult.CodeRequired(signUpChallengeApiResult.getCorrelationId(), oOBRequired.getContinuationToken(), oOBRequired.getChallengeTargetLabel(), oOBRequired.getChallengeChannel(), oOBRequired.getCodeLength());
        }
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.PasswordRequired) {
            return new SignUpCommandResult.PasswordRequired(signUpChallengeApiResult.getCorrelationId(), ((SignUpChallengeApiResult.PasswordRequired) signUpChallengeApiResult).getContinuationToken());
        }
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpChallengeApiResult.getCorrelationId());
        }
        if (!(signUpChallengeApiResult instanceof SignUpChallengeApiResult.ExpiredToken ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnsupportedChallengeType ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpChallengeApiResult.getCorrelationId(), "Unexpected result: ", signUpChallengeApiResult);
        Intrinsics.checkNotNull(signUpChallengeApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpChallengeApiResult;
        return new INativeAuthCommandResult.UnknownError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpChallengeApiResult.getCorrelationId(), null, null, 52, null);
    }

    private final SignUpSubmitCodeCommandResult toSignUpSubmitCodeCommandResult(SignUpContinueApiResult signUpContinueApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy) {
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Success) {
            SignUpContinueApiResult.Success success = (SignUpContinueApiResult.Success) signUpContinueApiResult;
            return new SignUpCommandResult.Complete(signUpContinueApiResult.getCorrelationId(), success.getContinuationToken(), success.getExpiresIn());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.ExpiredToken) {
            Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Expire token result: ", signUpContinueApiResult);
            SignUpContinueApiResult.ExpiredToken expiredToken = (SignUpContinueApiResult.ExpiredToken) signUpContinueApiResult;
            return new INativeAuthCommandResult.UnknownError(expiredToken.getError(), expiredToken.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UsernameAlreadyExists) {
            SignUpContinueApiResult.UsernameAlreadyExists usernameAlreadyExists = (SignUpContinueApiResult.UsernameAlreadyExists) signUpContinueApiResult;
            return new SignUpCommandResult.UsernameAlreadyExists(signUpContinueApiResult.getCorrelationId(), usernameAlreadyExists.getError(), usernameAlreadyExists.getErrorDescription());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.AttributesRequired) {
            SignUpContinueApiResult.AttributesRequired attributesRequired = (SignUpContinueApiResult.AttributesRequired) signUpContinueApiResult;
            return new SignUpCommandResult.AttributesRequired(signUpContinueApiResult.getCorrelationId(), attributesRequired.getContinuationToken(), attributesRequired.getError(), attributesRequired.getErrorDescription(), attributesRequired.getRequiredAttributes());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.CredentialRequired) {
            SignUpStartCommandResult signUpStartCommandResult = toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2Strategy, ((SignUpContinueApiResult.CredentialRequired) signUpContinueApiResult).getContinuationToken(), signUpContinueApiResult.getCorrelationId()));
            Intrinsics.checkNotNull(signUpStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitCodeCommandResult");
            return (SignUpSubmitCodeCommandResult) signUpStartCommandResult;
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidOOBValue) {
            SignUpContinueApiResult.InvalidOOBValue invalidOOBValue = (SignUpContinueApiResult.InvalidOOBValue) signUpContinueApiResult;
            return new SignUpCommandResult.InvalidCode(signUpContinueApiResult.getCorrelationId(), invalidOOBValue.getError(), invalidOOBValue.getErrorDescription(), invalidOOBValue.getSubError());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpContinueApiResult.getCorrelationId());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UnknownError) {
            Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Unexpected result: ", signUpContinueApiResult);
            SignUpContinueApiResult.UnknownError unknownError = (SignUpContinueApiResult.UnknownError) signUpContinueApiResult;
            return new INativeAuthCommandResult.UnknownError(unknownError.getError(), unknownError.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
        }
        if (!(signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidAttributes ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidPassword)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Unexpected result: ", signUpContinueApiResult);
        return new INativeAuthCommandResult.UnknownError("unexpected_api_result", "API returned unexpected result: " + signUpContinueApiResult, null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitPasswordCommandResult toSignUpSubmitPasswordCommandResult(SignUpContinueApiResult signUpContinueApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy) {
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Success) {
            SignUpContinueApiResult.Success success = (SignUpContinueApiResult.Success) signUpContinueApiResult;
            return new SignUpCommandResult.Complete(signUpContinueApiResult.getCorrelationId(), success.getContinuationToken(), success.getExpiresIn());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UsernameAlreadyExists) {
            SignUpContinueApiResult.UsernameAlreadyExists usernameAlreadyExists = (SignUpContinueApiResult.UsernameAlreadyExists) signUpContinueApiResult;
            return new SignUpCommandResult.UsernameAlreadyExists(signUpContinueApiResult.getCorrelationId(), usernameAlreadyExists.getError(), usernameAlreadyExists.getErrorDescription());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.AttributesRequired) {
            SignUpContinueApiResult.AttributesRequired attributesRequired = (SignUpContinueApiResult.AttributesRequired) signUpContinueApiResult;
            return new SignUpCommandResult.AttributesRequired(signUpContinueApiResult.getCorrelationId(), attributesRequired.getContinuationToken(), attributesRequired.getError(), attributesRequired.getErrorDescription(), attributesRequired.getRequiredAttributes());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.CredentialRequired) {
            SignUpStartCommandResult signUpStartCommandResult = toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2Strategy, ((SignUpContinueApiResult.CredentialRequired) signUpContinueApiResult).getContinuationToken(), signUpContinueApiResult.getCorrelationId()));
            Intrinsics.checkNotNull(signUpStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpSubmitPasswordCommandResult");
            return (SignUpSubmitPasswordCommandResult) signUpStartCommandResult;
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidPassword) {
            SignUpContinueApiResult.InvalidPassword invalidPassword = (SignUpContinueApiResult.InvalidPassword) signUpContinueApiResult;
            return new SignUpCommandResult.InvalidPassword(signUpContinueApiResult.getCorrelationId(), invalidPassword.getError(), invalidPassword.getErrorDescription(), invalidPassword.getSubError());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpContinueApiResult.getCorrelationId());
        }
        if (!(signUpContinueApiResult instanceof SignUpContinueApiResult.ExpiredToken ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidOOBValue ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidAttributes ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Error in signup continue result: ", signUpContinueApiResult);
        Intrinsics.checkNotNull(signUpContinueApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpContinueApiResult;
        return new INativeAuthCommandResult.UnknownError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitUserAttributesCommandResult toSignUpSubmitUserAttributesCommandResult(SignUpContinueApiResult signUpContinueApiResult, NativeAuthOAuth2Strategy nativeAuthOAuth2Strategy) {
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Success) {
            SignUpContinueApiResult.Success success = (SignUpContinueApiResult.Success) signUpContinueApiResult;
            return new SignUpCommandResult.Complete(signUpContinueApiResult.getCorrelationId(), success.getContinuationToken(), success.getExpiresIn());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.UsernameAlreadyExists) {
            SignUpContinueApiResult.UsernameAlreadyExists usernameAlreadyExists = (SignUpContinueApiResult.UsernameAlreadyExists) signUpContinueApiResult;
            return new SignUpCommandResult.UsernameAlreadyExists(signUpContinueApiResult.getCorrelationId(), usernameAlreadyExists.getError(), usernameAlreadyExists.getErrorDescription());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.AttributesRequired) {
            SignUpContinueApiResult.AttributesRequired attributesRequired = (SignUpContinueApiResult.AttributesRequired) signUpContinueApiResult;
            return new SignUpCommandResult.AttributesRequired(signUpContinueApiResult.getCorrelationId(), attributesRequired.getContinuationToken(), attributesRequired.getError(), attributesRequired.getErrorDescription(), attributesRequired.getRequiredAttributes());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.CredentialRequired) {
            return toSignUpSubmitUserAttrsCommandResult(performSignUpChallengeCall(nativeAuthOAuth2Strategy, ((SignUpContinueApiResult.CredentialRequired) signUpContinueApiResult).getContinuationToken(), signUpContinueApiResult.getCorrelationId()));
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpContinueApiResult.getCorrelationId());
        }
        if (signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidAttributes) {
            SignUpContinueApiResult.InvalidAttributes invalidAttributes = (SignUpContinueApiResult.InvalidAttributes) signUpContinueApiResult;
            return new SignUpCommandResult.InvalidAttributes(signUpContinueApiResult.getCorrelationId(), invalidAttributes.getError(), invalidAttributes.getErrorDescription(), invalidAttributes.getInvalidAttributes());
        }
        if (!(signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidOOBValue ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.InvalidPassword ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.ExpiredToken ? true : signUpContinueApiResult instanceof SignUpContinueApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpContinueApiResult.getCorrelationId(), "Expire token result: ", signUpContinueApiResult);
        Intrinsics.checkNotNull(signUpContinueApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpContinueApiResult;
        return new INativeAuthCommandResult.UnknownError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpContinueApiResult.getCorrelationId(), null, null, 52, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SignUpSubmitUserAttributesCommandResult toSignUpSubmitUserAttrsCommandResult(SignUpChallengeApiResult signUpChallengeApiResult) {
        if (signUpChallengeApiResult instanceof SignUpChallengeApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(signUpChallengeApiResult.getCorrelationId());
        }
        if (!(signUpChallengeApiResult instanceof SignUpChallengeApiResult.ExpiredToken ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnsupportedChallengeType ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.OOBRequired ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.PasswordRequired ? true : signUpChallengeApiResult instanceof SignUpChallengeApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, signUpChallengeApiResult.getCorrelationId(), "Unexpected result: ", signUpChallengeApiResult);
        Intrinsics.checkNotNull(signUpChallengeApiResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
        ApiErrorResult apiErrorResult = (ApiErrorResult) signUpChallengeApiResult;
        return new INativeAuthCommandResult.UnknownError(apiErrorResult.getError(), apiErrorResult.getErrorDescription(), null, signUpChallengeApiResult.getCorrelationId(), null, null, 52, null);
    }

    @NotNull
    public final AcquireTokenResult acquireTokenSilent(@NotNull AcquireTokenNoFixedScopesCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        companion.logMethodCall(TAG2, parameters.getCorrelationId(), TAG2 + ".acquireTokenSilent");
        AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
        parameters.validate();
        SilentTokenCommandParameters silentTokenCommandParameters = CommandUtil.convertAcquireTokenNoFixedScopesCommandParameters(parameters, parameters.getCorrelationId());
        AccountRecord cachedAccountRecord = getCachedAccountRecord(silentTokenCommandParameters);
        Intrinsics.checkNotNullExpressionValue(cachedAccountRecord, "getCachedAccountRecord(s…ntTokenCommandParameters)");
        AbstractAuthenticationScheme authenticationScheme = silentTokenCommandParameters.getAuthenticationScheme();
        OAuth2Strategy strategy = silentTokenCommandParameters.getAuthority().createOAuth2Strategy(OAuth2StrategyParameters.builder().platformComponents(parameters.getPlatformComponents()).authenticationScheme(authenticationScheme).build());
        OAuth2TokenCache tokenCache = silentTokenCommandParameters.getOAuth2TokenCache();
        List<ICacheRecord> listLoadWithAggregatedAccountData = tokenCache.loadWithAggregatedAccountData(silentTokenCommandParameters.getClientId(), parameters.getApplicationIdentifier(), null, null, cachedAccountRecord, authenticationScheme);
        Intrinsics.checkNotNull(listLoadWithAggregatedAccountData, "null cannot be cast to non-null type kotlin.collections.List<com.microsoft.identity.common.java.cache.ICacheRecord>");
        ICacheRecord iCacheRecord = listLoadWithAggregatedAccountData.get(0);
        if (accessTokenIsNull(iCacheRecord)) {
            throw new ServiceException(ErrorStrings.NATIVE_AUTH_NO_ACCESS_TOKEN_FOUND, "No access token found during refresh - user must be signed out.", null);
        }
        if (LibraryConfiguration.getInstance().isRefreshInEnabled() && iCacheRecord.getAccessToken() != null && iCacheRecord.getAccessToken().refreshOnIsActive()) {
            Logger.info(TAG2, parameters.getCorrelationId(), "RefreshOn is active. This will extend your token usage in the rare case servers are not available.");
        }
        if (LibraryConfiguration.getInstance().isRefreshInEnabled() && iCacheRecord.getAccessToken() != null && iCacheRecord.getAccessToken().shouldRefresh()) {
            if (iCacheRecord.getAccessToken().isExpired()) {
                Logger.warn(TAG2, parameters.getCorrelationId(), "Access token is expired. Removing from cache...");
                Intrinsics.checkNotNullExpressionValue(silentTokenCommandParameters, "silentTokenCommandParameters");
                Intrinsics.checkNotNullExpressionValue(tokenCache, "tokenCache");
                Intrinsics.checkNotNullExpressionValue(strategy, "strategy");
                renewAT(silentTokenCommandParameters, acquireTokenResult, tokenCache, strategy, iCacheRecord);
            } else {
                Intrinsics.checkNotNullExpressionValue(silentTokenCommandParameters, "silentTokenCommandParameters");
                setAcquireTokenResult(acquireTokenResult, silentTokenCommandParameters, listLoadWithAggregatedAccountData);
                CommandDispatcher.submitAndForget(new RefreshOnCommand(parameters, asControllerFactory(), PublicApiId.MSAL_REFRESH_ON));
            }
        } else if (accessTokenIsNull(iCacheRecord) || refreshTokenIsNull(iCacheRecord) || silentTokenCommandParameters.isForceRefresh() || !isRequestAuthorityRealmSameAsATRealm(silentTokenCommandParameters.getAuthority(), iCacheRecord.getAccessToken()) || !strategy.validateCachedResult(authenticationScheme, iCacheRecord)) {
            if (refreshTokenIsNull(iCacheRecord)) {
                ServiceException serviceException = new ServiceException("no_tokens_found", "No refresh token was found.", null);
                Telemetry.emit(new ApiEndEvent().putException(serviceException).putApiId("103"));
                throw serviceException;
            }
            Intrinsics.checkNotNullExpressionValue(silentTokenCommandParameters, "silentTokenCommandParameters");
            Intrinsics.checkNotNullExpressionValue(tokenCache, "tokenCache");
            Intrinsics.checkNotNullExpressionValue(strategy, "strategy");
            renewAT(silentTokenCommandParameters, acquireTokenResult, tokenCache, strategy, iCacheRecord);
        } else if (iCacheRecord.getAccessToken().isExpired()) {
            Logger.warn(TAG2, parameters.getCorrelationId(), "Access token is expired. Removing from cache...");
            Intrinsics.checkNotNullExpressionValue(silentTokenCommandParameters, "silentTokenCommandParameters");
            Intrinsics.checkNotNullExpressionValue(tokenCache, "tokenCache");
            Intrinsics.checkNotNullExpressionValue(strategy, "strategy");
            renewAT(silentTokenCommandParameters, acquireTokenResult, tokenCache, strategy, iCacheRecord);
        } else {
            Logger.verbose(TAG2, parameters.getCorrelationId(), "Returning silent result");
            Intrinsics.checkNotNullExpressionValue(silentTokenCommandParameters, "silentTokenCommandParameters");
            setAcquireTokenResult(acquireTokenResult, silentTokenCommandParameters, listLoadWithAggregatedAccountData);
        }
        Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResult).putApiId("103"));
        return acquireTokenResult;
    }

    @VisibleForTesting
    @NotNull
    public final SignInTokenApiResult performContinuationTokenTokenRequest(@NotNull NativeAuthOAuth2Strategy oAuth2Strategy, @NotNull SignInWithContinuationTokenCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performContinuationTokenTokenRequest", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performContinuationTokenTokenRequest(parameters);
    }

    @VisibleForTesting
    @NotNull
    public final SignInTokenApiResult performPasswordTokenCall(@NotNull NativeAuthOAuth2Strategy oAuth2Strategy, @NotNull SignInSubmitPasswordCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".performPasswordTokenCall", companion, TAG2, parameters.getCorrelationId());
        return oAuth2Strategy.performPasswordTokenRequest(parameters);
    }

    @VisibleForTesting
    @NotNull
    public final SignUpStartApiResult performSignUpStartUsingPasswordRequest(@NotNull NativeAuthOAuth2Strategy oAuth2Strategy, @NotNull SignUpStartCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return oAuth2Strategy.performSignUpStart(parameters);
    }

    @VisibleForTesting
    @NotNull
    public final SignUpContinueApiResult performSignUpSubmitUserAttributes(@NotNull NativeAuthOAuth2Strategy oAuth2Strategy, @NotNull SignUpSubmitUserAttributesCommandParameters parameters) {
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return oAuth2Strategy.performSignUpSubmitUserAttributes(parameters);
    }

    @VisibleForTesting
    @NotNull
    public final SignInStartCommandResult processSignInInitiateApiResult(@NotNull SignInInitiateApiResult initiateApiResult, @Nullable SignInStartCommandParameters parametersWithScopes, @NotNull NativeAuthOAuth2Strategy oAuth2Strategy, boolean usePassword) {
        Intrinsics.checkNotNullParameter(initiateApiResult, "initiateApiResult");
        Intrinsics.checkNotNullParameter(oAuth2Strategy, "oAuth2Strategy");
        if (initiateApiResult instanceof SignInInitiateApiResult.Redirect) {
            return new INativeAuthCommandResult.Redirect(initiateApiResult.getCorrelationId());
        }
        if (initiateApiResult instanceof SignInInitiateApiResult.Success) {
            return processSignInChallengeCall(oAuth2Strategy, parametersWithScopes, performSignInChallengeCall(oAuth2Strategy, ((SignInInitiateApiResult.Success) initiateApiResult).getContinuationToken(), initiateApiResult.getCorrelationId()), usePassword);
        }
        if (initiateApiResult instanceof SignInInitiateApiResult.UserNotFound) {
            SignInInitiateApiResult.UserNotFound userNotFound = (SignInInitiateApiResult.UserNotFound) initiateApiResult;
            return new SignInCommandResult.UserNotFound(initiateApiResult.getCorrelationId(), userNotFound.getError(), userNotFound.getErrorDescription(), userNotFound.getErrorCodes());
        }
        if (!(initiateApiResult instanceof SignInInitiateApiResult.UnknownError)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.warnWithObject(TAG, initiateApiResult.getCorrelationId(), "Unexpected result: ", initiateApiResult);
        SignInInitiateApiResult.UnknownError unknownError = (SignInInitiateApiResult.UnknownError) initiateApiResult;
        return new INativeAuthCommandResult.UnknownError(unknownError.getError(), unknownError.getErrorDescription(), null, initiateApiResult.getCorrelationId(), unknownError.getErrorCodes(), null, 36, null);
    }

    @NotNull
    public final ResetPasswordResendCodeCommandResult resetPasswordResendCode(@NotNull ResetPasswordResendCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".resetPasswordResendCode", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            ApiResult apiResultPerformResetPasswordChallengeCall = performResetPasswordChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId);
            if (apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.CodeRequired) {
                return new ResetPasswordCommandResult.CodeRequired(apiResultPerformResetPasswordChallengeCall.getCorrelationId(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getContinuationToken(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getCodeLength(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getChallengeTargetLabel(), ((ResetPasswordChallengeApiResult.CodeRequired) apiResultPerformResetPasswordChallengeCall).getChallengeChannel());
            }
            if (apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordChallengeCall.getCorrelationId());
            }
            boolean z = true;
            if (!(apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.ExpiredToken ? true : apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.UnsupportedChallengeType)) {
                z = apiResultPerformResetPasswordChallengeCall instanceof ResetPasswordChallengeApiResult.UnknownError;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformResetPasswordChallengeCall.getCorrelationId(), "Unexpected result: ", apiResultPerformResetPasswordChallengeCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordChallengeCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformResetPasswordChallengeCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordChallengeCall).getErrorDescription(), null, apiResultPerformResetPasswordChallengeCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordResendCode", e);
            throw e;
        }
    }

    @NotNull
    public final ResetPasswordStartCommandResult resetPasswordStart(@NotNull ResetPasswordStartCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".resetPasswordStart", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            ApiResult apiResultPerformResetPasswordStartCall = performResetPasswordStartCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.Success) {
                return toResetPasswordStartCommandResult(performResetPasswordChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((ResetPasswordStartApiResult.Success) apiResultPerformResetPasswordStartCall).getContinuationToken(), apiResultPerformResetPasswordStartCall.getCorrelationId()));
            }
            if (apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordStartCall.getCorrelationId());
            }
            if (apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.UserNotFound) {
                return new ResetPasswordCommandResult.UserNotFound(apiResultPerformResetPasswordStartCall.getCorrelationId(), ((ResetPasswordStartApiResult.UserNotFound) apiResultPerformResetPasswordStartCall).getError(), ((ResetPasswordStartApiResult.UserNotFound) apiResultPerformResetPasswordStartCall).getErrorDescription());
            }
            if (!(apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.UnsupportedChallengeType ? true : apiResultPerformResetPasswordStartCall instanceof ResetPasswordStartApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, parameters.getCorrelationId(), "Unexpected result: ", apiResultPerformResetPasswordStartCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordStartCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformResetPasswordStartCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordStartCall).getErrorDescription(), null, apiResultPerformResetPasswordStartCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordStart", e);
            throw e;
        }
    }

    @NotNull
    public final ResetPasswordSubmitCodeCommandResult resetPasswordSubmitCode(@NotNull ResetPasswordSubmitCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".resetPasswordSubmitCode", companion, TAG2, parameters.getCorrelationId());
        try {
            ApiResult apiResultPerformResetPasswordContinueCall = performResetPasswordContinueCall(createOAuth2Strategy(parameters), parameters);
            if (apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.PasswordRequired) {
                return new ResetPasswordCommandResult.PasswordRequired(apiResultPerformResetPasswordContinueCall.getCorrelationId(), ((ResetPasswordContinueApiResult.PasswordRequired) apiResultPerformResetPasswordContinueCall).getContinuationToken());
            }
            if (apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.CodeIncorrect) {
                return new ResetPasswordCommandResult.IncorrectCode(apiResultPerformResetPasswordContinueCall.getCorrelationId(), ((ResetPasswordContinueApiResult.CodeIncorrect) apiResultPerformResetPasswordContinueCall).getError(), ((ResetPasswordContinueApiResult.CodeIncorrect) apiResultPerformResetPasswordContinueCall).getErrorDescription(), ((ResetPasswordContinueApiResult.CodeIncorrect) apiResultPerformResetPasswordContinueCall).getSubError());
            }
            if (apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformResetPasswordContinueCall.getCorrelationId());
            }
            if (!(apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.ExpiredToken ? true : apiResultPerformResetPasswordContinueCall instanceof ResetPasswordContinueApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, "Unexpected result: ", apiResultPerformResetPasswordContinueCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordContinueCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformResetPasswordContinueCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordContinueCall).getErrorDescription(), null, apiResultPerformResetPasswordContinueCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordSubmitCode", e);
            throw e;
        }
    }

    @NotNull
    public final ResetPasswordSubmitNewPasswordCommandResult resetPasswordSubmitNewPassword(@NotNull ResetPasswordSubmitNewPasswordCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".resetPasswordSubmitNewPassword", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            ApiResult apiResultPerformResetPasswordSubmitCall = performResetPasswordSubmitCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.SubmitSuccess) {
                return resetPasswordPollCompletion(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((ResetPasswordSubmitApiResult.SubmitSuccess) apiResultPerformResetPasswordSubmitCall).getContinuationToken(), apiResultPerformResetPasswordSubmitCall.getCorrelationId(), ((ResetPasswordSubmitApiResult.SubmitSuccess) apiResultPerformResetPasswordSubmitCall).getPollInterval());
            }
            if (apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.PasswordInvalid) {
                return new ResetPasswordCommandResult.PasswordNotAccepted(apiResultPerformResetPasswordSubmitCall.getCorrelationId(), ((ResetPasswordSubmitApiResult.PasswordInvalid) apiResultPerformResetPasswordSubmitCall).getError(), ((ResetPasswordSubmitApiResult.PasswordInvalid) apiResultPerformResetPasswordSubmitCall).getErrorDescription(), ((ResetPasswordSubmitApiResult.PasswordInvalid) apiResultPerformResetPasswordSubmitCall).getSubError());
            }
            if (!(apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.ExpiredToken ? true : apiResultPerformResetPasswordSubmitCall instanceof ResetPasswordSubmitApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformResetPasswordSubmitCall.getCorrelationId(), "Unexpected result: ", apiResultPerformResetPasswordSubmitCall);
            Intrinsics.checkNotNull(apiResultPerformResetPasswordSubmitCall, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformResetPasswordSubmitCall).getError(), ((ApiErrorResult) apiResultPerformResetPasswordSubmitCall).getErrorDescription(), null, apiResultPerformResetPasswordSubmitCall.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in resetPasswordSubmitNewPassword", e);
            throw e;
        }
    }

    @NotNull
    public final SignInResendCodeCommandResult signInResendCode(@NotNull SignInResendCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signInResendCode", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            SignInChallengeApiResult signInChallengeApiResultPerformSignInChallengeCall = performSignInChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId);
            if (signInChallengeApiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.OOBRequired) {
                return new SignInCommandResult.CodeRequired(signInChallengeApiResultPerformSignInChallengeCall.getCorrelationId(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInChallengeCall).getContinuationToken(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInChallengeCall).getChallengeTargetLabel(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInChallengeCall).getChallengeChannel(), ((SignInChallengeApiResult.OOBRequired) signInChallengeApiResultPerformSignInChallengeCall).getCodeLength());
            }
            if (signInChallengeApiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.PasswordRequired) {
                Logger.warnWithObject(TAG2, signInChallengeApiResultPerformSignInChallengeCall.getCorrelationId(), "Unexpected result: ", signInChallengeApiResultPerformSignInChallengeCall);
                return new INativeAuthCommandResult.UnknownError("unexpected_api_result", "API returned unexpected result: " + signInChallengeApiResultPerformSignInChallengeCall, null, signInChallengeApiResultPerformSignInChallengeCall.getCorrelationId(), null, null, 52, null);
            }
            if (signInChallengeApiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(signInChallengeApiResultPerformSignInChallengeCall.getCorrelationId());
            }
            if (!(signInChallengeApiResultPerformSignInChallengeCall instanceof SignInChallengeApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, "Unexpected result: ", signInChallengeApiResultPerformSignInChallengeCall);
            return new INativeAuthCommandResult.UnknownError(((SignInChallengeApiResult.UnknownError) signInChallengeApiResultPerformSignInChallengeCall).getError(), ((SignInChallengeApiResult.UnknownError) signInChallengeApiResultPerformSignInChallengeCall).getErrorDescription(), null, signInChallengeApiResultPerformSignInChallengeCall.getCorrelationId(), ((SignInChallengeApiResult.UnknownError) signInChallengeApiResultPerformSignInChallengeCall).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInResendCode", e);
            throw e;
        }
    }

    @NotNull
    public final SignInStartCommandResult signInStart(@NotNull SignInStartCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signInStart", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            SignInInitiateApiResult signInInitiateApiResultPerformSignInInitiateCall = performSignInInitiateCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            char[] cArr = parameters.password;
            if (cArr != null) {
                if (!(cArr.length == 0)) {
                    Logger.verbose(TAG2, parameters.getCorrelationId(), "Parameters has password");
                    SignInStartCommandParameters signInStartCommandParametersCreateSignInStartCommandParametersWithScopes = CommandUtil.createSignInStartCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
                    try {
                        return processSignInInitiateApiResult(signInInitiateApiResultPerformSignInInitiateCall, signInStartCommandParametersCreateSignInStartCommandParametersWithScopes, nativeAuthOAuth2StrategyCreateOAuth2Strategy, true);
                    } finally {
                        StringUtil.overwriteWithNull(signInStartCommandParametersCreateSignInStartCommandParametersWithScopes.password);
                    }
                }
            }
            Logger.verbose(TAG2, parameters.getCorrelationId(), "Parameters doesn't have password");
            return processSignInInitiateApiResult$default(this, signInInitiateApiResultPerformSignInInitiateCall, null, nativeAuthOAuth2StrategyCreateOAuth2Strategy, false, 10, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInStart", e);
            throw e;
        }
    }

    @NotNull
    public final SignInSubmitCodeCommandResult signInSubmitCode(@NotNull SignInSubmitCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signInSubmitCode", companion, TAG2, parameters.getCorrelationId());
        try {
            SignInSubmitCodeCommandParameters parametersWithScopes = CommandUtil.createSignInSubmitCodeCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
            ApiResult apiResultPerformOOBTokenRequest = performOOBTokenRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.Success) {
                return saveAndReturnTokens(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, (SignInTokenApiResult.Success) apiResultPerformOOBTokenRequest);
            }
            if (apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.CodeIncorrect) {
                return new SignInCommandResult.IncorrectCode(apiResultPerformOOBTokenRequest.getCorrelationId(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getError(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getErrorDescription(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getErrorCodes(), ((SignInTokenApiResult.CodeIncorrect) apiResultPerformOOBTokenRequest).getSubError());
            }
            boolean z = true;
            if (!(apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.UnknownError ? true : apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.MFARequired ? true : apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.InvalidCredentials)) {
                z = apiResultPerformOOBTokenRequest instanceof SignInTokenApiResult.UserNotFound;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformOOBTokenRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformOOBTokenRequest);
            Intrinsics.checkNotNull(apiResultPerformOOBTokenRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformOOBTokenRequest).getError(), ((ApiErrorResult) apiResultPerformOOBTokenRequest).getErrorDescription(), null, apiResultPerformOOBTokenRequest.getCorrelationId(), ((ApiErrorResult) apiResultPerformOOBTokenRequest).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitCode", e);
            throw e;
        }
    }

    @NotNull
    public final SignInSubmitPasswordCommandResult signInSubmitPassword(@NotNull SignInSubmitPasswordCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signInSubmitPassword", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            SignInSubmitPasswordCommandParameters parametersWithScopes = CommandUtil.createSignInSubmitPasswordCommandParametersWithScopes(parameters, parameters.getCorrelationId(), addDefaultScopes(parameters.scopes));
            try {
                Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
                return toSignInSubmitPasswordCommandResult(performPasswordTokenCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes), nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            } finally {
                StringUtil.overwriteWithNull(parametersWithScopes.password);
            }
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInSubmitPassword", e);
            throw e;
        }
    }

    @NotNull
    public final SignInWithContinuationTokenCommandResult signInWithContinuationToken(@NotNull SignInWithContinuationTokenCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signInWithContinuationToken", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            SignInWithContinuationTokenCommandParameters parametersWithScopes = CommandUtil.createSignInWithContinuationTokenCommandParametersWithScopes(parameters, addDefaultScopes(parameters.scopes));
            Intrinsics.checkNotNullExpressionValue(parametersWithScopes, "parametersWithScopes");
            ApiResult apiResultPerformContinuationTokenTokenRequest = performContinuationTokenTokenRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes);
            if (apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.Success) {
                return saveAndReturnTokens(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parametersWithScopes, (SignInTokenApiResult.Success) apiResultPerformContinuationTokenTokenRequest);
            }
            boolean z = true;
            if (!(apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.InvalidAuthenticationType ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.MFARequired ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.CodeIncorrect ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.UserNotFound ? true : apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.InvalidCredentials)) {
                z = apiResultPerformContinuationTokenTokenRequest instanceof SignInTokenApiResult.UnknownError;
            }
            if (!z) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(TAG2, apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformContinuationTokenTokenRequest);
            Intrinsics.checkNotNull(apiResultPerformContinuationTokenTokenRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getError(), "API returned unexpected result: " + apiResultPerformContinuationTokenTokenRequest, null, apiResultPerformContinuationTokenTokenRequest.getCorrelationId(), ((ApiErrorResult) apiResultPerformContinuationTokenTokenRequest).getErrorCodes(), null, 36, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signInWithContinuationToken", e);
            throw e;
        }
    }

    @NotNull
    public final SignUpResendCodeCommandResult signUpResendCode(@NotNull SignUpResendCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signUpResendCode", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            String str = parameters.continuationToken;
            Intrinsics.checkNotNullExpressionValue(str, "parameters.continuationToken");
            String correlationId = parameters.getCorrelationId();
            Intrinsics.checkNotNullExpressionValue(correlationId, "parameters.correlationId");
            SignUpStartCommandResult signUpStartCommandResult = toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, str, correlationId));
            Intrinsics.checkNotNull(signUpStartCommandResult, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpResendCodeCommandResult");
            return (SignUpResendCodeCommandResult) signUpStartCommandResult;
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpResendCode", e);
            throw e;
        }
    }

    @NotNull
    public final SignUpStartCommandResult signUpStart(@NotNull SignUpStartCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signUpStart", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            ApiResult apiResultPerformSignUpStartUsingPasswordRequest = performSignUpStartUsingPasswordRequest(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters);
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.Success) {
                return toSignUpStartCommandResult(performSignUpChallengeCall(nativeAuthOAuth2StrategyCreateOAuth2Strategy, ((SignUpStartApiResult.Success) apiResultPerformSignUpStartUsingPasswordRequest).getContinuationToken(), apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId()));
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.InvalidPassword) {
                return new SignUpCommandResult.InvalidPassword(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.InvalidPassword) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.InvalidPassword) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), ((SignUpStartApiResult.InvalidPassword) apiResultPerformSignUpStartUsingPasswordRequest).getSubError());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.InvalidAttributes) {
                return new SignUpCommandResult.InvalidAttributes(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.InvalidAttributes) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.InvalidAttributes) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), ((SignUpStartApiResult.InvalidAttributes) apiResultPerformSignUpStartUsingPasswordRequest).getInvalidAttributes());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.UsernameAlreadyExists) {
                return new SignUpCommandResult.UsernameAlreadyExists(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.UsernameAlreadyExists) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.UsernameAlreadyExists) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.InvalidUsername) {
                return new INativeAuthCommandResult.InvalidUsername(((SignUpStartApiResult.InvalidUsername) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.InvalidUsername) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), null, apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), null, null, 52, null);
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.AuthNotSupported) {
                return new SignUpCommandResult.AuthNotSupported(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), ((SignUpStartApiResult.AuthNotSupported) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((SignUpStartApiResult.AuthNotSupported) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription());
            }
            if (apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.Redirect) {
                return new INativeAuthCommandResult.Redirect(apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId());
            }
            if (!(apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.UnsupportedChallengeType ? true : apiResultPerformSignUpStartUsingPasswordRequest instanceof SignUpStartApiResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNull(apiResultPerformSignUpStartUsingPasswordRequest, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.providers.responses.ApiErrorResult");
            Logger.warnWithObject(TAG2, apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), "Unexpected result: ", apiResultPerformSignUpStartUsingPasswordRequest);
            return new INativeAuthCommandResult.UnknownError(((ApiErrorResult) apiResultPerformSignUpStartUsingPasswordRequest).getError(), ((ApiErrorResult) apiResultPerformSignUpStartUsingPasswordRequest).getErrorDescription(), null, apiResultPerformSignUpStartUsingPasswordRequest.getCorrelationId(), null, null, 52, null);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpStart", e);
            throw e;
        }
    }

    @NotNull
    public final SignUpSubmitCodeCommandResult signUpSubmitCode(@NotNull SignUpSubmitCodeCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signUpSubmitCode", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            return toSignUpSubmitCodeCommandResult(performSignUpSubmitCode(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters), nativeAuthOAuth2StrategyCreateOAuth2Strategy);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpSubmitCode", e);
            throw e;
        }
    }

    @NotNull
    public final SignUpSubmitPasswordCommandResult signUpSubmitPassword(@NotNull SignUpSubmitPasswordCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signUpSubmitPassword", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            return toSignUpSubmitPasswordCommandResult(performSignUpSubmitPassword(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters), nativeAuthOAuth2StrategyCreateOAuth2Strategy);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpSubmitPassword", e);
            throw e;
        }
    }

    @NotNull
    public final SignUpSubmitUserAttributesCommandResult signUpSubmitUserAttributes(@NotNull SignUpSubmitUserAttributesCommandParameters parameters) throws Exception {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        LogSession.Companion companion = LogSession.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        AbstractC12991c.m14004y(TAG2, ".signUpSubmitUserAttributes", companion, TAG2, parameters.getCorrelationId());
        try {
            NativeAuthOAuth2Strategy nativeAuthOAuth2StrategyCreateOAuth2Strategy = createOAuth2Strategy(parameters);
            return toSignUpSubmitUserAttributesCommandResult(performSignUpSubmitUserAttributes(nativeAuthOAuth2StrategyCreateOAuth2Strategy, parameters), nativeAuthOAuth2StrategyCreateOAuth2Strategy);
        } catch (Exception e) {
            Logger.error(TAG, parameters.getCorrelationId(), "Exception thrown in signUpSubmitUserAttributes", e);
            throw e;
        }
    }
}
