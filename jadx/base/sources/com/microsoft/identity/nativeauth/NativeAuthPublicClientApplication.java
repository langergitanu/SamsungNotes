package com.microsoft.identity.nativeauth;

import android.content.Context;
import com.microsoft.identity.client.AccountAdapter;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.crypto.AndroidAuthSdkStorageEncryptionManager;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.commands.GetCurrentAccountCommand;
import com.microsoft.identity.common.internal.controllers.LocalMSALController;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignUpStartCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordStartCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInStartCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignUpStartCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResetPasswordError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpError;
import com.microsoft.identity.nativeauth.statemachine.errors.SignUpErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.results.GetAccountResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordStartResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignUpResult;
import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import com.microsoft.identity.nativeauth.statemachine.states.Callback;
import com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState;
import com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpAttributesRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpCodeRequiredState;
import com.microsoft.identity.nativeauth.statemachine.states.SignUpPasswordRequiredState;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0005*+,-.B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0011\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u001aH\u0016J3\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J2\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\"H\u0016J-\u0010#\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'J,\u0010#\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u000f\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication;", "Lcom/microsoft/identity/nativeauth/INativeAuthPublicClientApplication;", "Lcom/microsoft/identity/client/PublicClientApplication;", "nativeAuthConfig", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", "sharedPreferencesFileManager", "Lcom/microsoft/identity/common/internal/cache/SharedPreferencesFileManager;", "checkForPersistedAccount", "Lcom/microsoft/identity/common/java/util/ResultFuture;", "", "getCurrentAccount", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$GetCurrentAccountCallback;", "initializeApplication", "initializeSharedPreferenceFileManager", "context", "Landroid/content/Context;", "resetPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$ResetPasswordCallback;", "signIn", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "password", "", "scopes", "", "(Ljava/lang/String;[CLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignInCallback;", "signUp", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", NativeAuthConstants.GrantType.ATTRIBUTES, "Lcom/microsoft/identity/nativeauth/UserAttributes;", "(Ljava/lang/String;[CLcom/microsoft/identity/nativeauth/UserAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignUpCallback;", "verifyNoUserIsSignedIn", "Companion", "GetCurrentAccountCallback", "ResetPasswordCallback", "SignInCallback", "SignUpCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthPublicClientApplication extends PublicClientApplication implements INativeAuthPublicClientApplication {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String NATIVE_AUTH_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.native_auth_credential_cache";

    @NotNull
    private static final String TAG;

    @NotNull
    private static final CoroutineScope pcaScope;

    @NotNull
    private final NativeAuthPublicClientApplicationConfiguration nativeAuthConfig;
    private SharedPreferencesFileManager sharedPreferencesFileManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$Companion;", "", "()V", "NATIVE_AUTH_CREDENTIAL_SHARED_PREFERENCES", "", SearchConstants.TargetContents.TAG, "getTAG$msal_distRelease", "()Ljava/lang/String;", "pcaScope", "Lkotlinx/coroutines/CoroutineScope;", "getPcaScope", "()Lkotlinx/coroutines/CoroutineScope;", "getAccountFromICacheRecordsList", "Lcom/microsoft/identity/client/IAccount;", "cacheRecords", "", "Lcom/microsoft/identity/common/java/cache/ICacheRecord;", "getCurrentAccountInternal", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final IAccount getAccountFromICacheRecordsList(List<? extends ICacheRecord> cacheRecords) {
            LogSession.INSTANCE.logMethodCall(getTAG$msal_distRelease(), null, getTAG$msal_distRelease() + ".getAccountFromICacheRecordsList");
            List<? extends ICacheRecord> list = cacheRecords;
            if (list == null || list.isEmpty()) {
                return null;
            }
            List<IAccount> listAdapt = AccountAdapter.adapt(cacheRecords);
            Intrinsics.checkNotNullExpressionValue(listAdapt, "adapt(cacheRecords)");
            if (listAdapt.isEmpty()) {
                Logger.error(getTAG$msal_distRelease(), "Returned cacheRecords were adapted into empty or null IAccount list. This is unexpected in native auth mode.Returning null.", null);
                return null;
            }
            if (listAdapt.size() != 1) {
                Logger.warn(getTAG$msal_distRelease(), "Returned cacheRecords were adapted into multiple IAccount. This is unexpected in native auth mode.Returning the first adapted account.");
            }
            return listAdapt.get(0);
        }

        @Nullable
        public final IAccount getCurrentAccountInternal(@NotNull NativeAuthPublicClientApplicationConfiguration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            LogSession.INSTANCE.logMethodCall(getTAG$msal_distRelease(), null, getTAG$msal_distRelease() + ".getCurrentAccountInternal");
            return getAccountFromICacheRecordsList((List) CommandDispatcher.submitSilentReturningFuture(new GetCurrentAccountCommand(CommandParametersAdapter.createCommandParameters(config, config.getOAuth2TokenCache()), new LocalMSALController().asControllerFactory(), new CommandCallback<List<? extends ICacheRecord>, BaseException>() { // from class: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$Companion$getCurrentAccountInternal$command$1
                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                public void onError(@Nullable BaseException error) {
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                public void onTaskCompleted(@Nullable List<? extends ICacheRecord> result) {
                }

                @Override // com.microsoft.identity.common.java.commands.CommandCallback
                public void onCancel() {
                }
            }, PublicApiId.NATIVE_AUTH_GET_ACCOUNT)).get().getResult());
        }

        @NotNull
        public final CoroutineScope getPcaScope() {
            return NativeAuthPublicClientApplication.pcaScope;
        }

        @NotNull
        public final String getTAG$msal_distRelease() {
            return NativeAuthPublicClientApplication.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$GetCurrentAccountCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccountResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface GetCurrentAccountCallback extends Callback<GetAccountResult> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$ResetPasswordCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface ResetPasswordCallback extends Callback<ResetPasswordStartResult> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignInCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SignInCallback extends Callback<SignInResult> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplication$SignUpCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SignUpCallback extends Callback<SignUpResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$1", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {JPEG.APP9}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetCurrentAccountCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64551(GetCurrentAccountCallback getCurrentAccountCallback, Continuation<? super C64551> continuation) {
            super(2, continuation);
            this.$callback = getCurrentAccountCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64551(this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeAuthPublicClientApplication nativeAuthPublicClientApplication = NativeAuthPublicClientApplication.this;
                    this.label = 1;
                    obj = nativeAuthPublicClientApplication.getCurrentAccount(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((GetAccountResult) obj);
            } catch (MsalException e) {
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/Result;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$getCurrentAccount$3", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64563 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetAccountResult>, Object> {
        int label;

        public C64563(Continuation<? super C64563> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64563(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            IAccount currentAccountInternal = NativeAuthPublicClientApplication.INSTANCE.getCurrentAccountInternal(NativeAuthPublicClientApplication.this.nativeAuthConfig);
            if (currentAccountInternal == null) {
                return GetAccountResult.NoAccountFound.INSTANCE;
            }
            AccountState.Companion companion = AccountState.INSTANCE;
            String threadCorrelationId = DiagnosticContext.INSTANCE.getThreadCorrelationId();
            Intrinsics.checkNotNullExpressionValue(threadCorrelationId, "INSTANCE.threadCorrelationId");
            return new GetAccountResult.AccountFound(companion.createFromAccountResult(currentAccountInternal, threadCorrelationId, NativeAuthPublicClientApplication.this.nativeAuthConfig));
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super GetAccountResult> continuation) {
            return ((C64563) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$1", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {734}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResetPasswordCallback $callback;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64571(String str, ResetPasswordCallback resetPasswordCallback, Continuation<? super C64571> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$callback = resetPasswordCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64571(this.$username, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeAuthPublicClientApplication nativeAuthPublicClientApplication = NativeAuthPublicClientApplication.this;
                    String str = this.$username;
                    this.label = 1;
                    obj = nativeAuthPublicClientApplication.resetPassword(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordStartResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in resetPassword", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordStartResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$resetPassword$3", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64583 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordStartResult>, Object> {
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64583(String str, Continuation<? super C64583> continuation) {
            super(2, continuation);
            this.$username = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64583(this.$username, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException, MsalClientException {
            ResetPasswordStartCommandResult unknownError;
            ResetPasswordStartCommandResult unknownError2;
            ResetPasswordError resetPasswordError;
            Exception exc;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Boolean doesAccountExist = (Boolean) NativeAuthPublicClientApplication.this.checkForPersistedAccount().get();
            Intrinsics.checkNotNullExpressionValue(doesAccountExist, "doesAccountExist");
            if (doesAccountExist.booleanValue()) {
                throw new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in.");
            }
            if (StringsKt.isBlank(this.$username)) {
                return new ResetPasswordError(ErrorTypes.INVALID_USERNAME, null, "Empty or blank username", TelemetryEventStrings.Value.UNSET, null, null, 50, null);
            }
            ResetPasswordStartCommandParameters parameters = CommandParametersAdapter.createResetPasswordStartCommandParameters(NativeAuthPublicClientApplication.this.nativeAuthConfig, NativeAuthPublicClientApplication.this.nativeAuthConfig.getOAuth2TokenCache(), this.$username);
            Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
            CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordStartCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_RESET_PASSWORD_START)).get();
            Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
            if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                if (rawCommandResult.getResult() instanceof Exception) {
                    Object result = rawCommandResult.getResult();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                    exc = (Exception) result;
                    message = exc.getMessage();
                } else {
                    exc = null;
                    message = "";
                }
                Exception exc2 = exc;
                String str = message;
                String correlationId = rawCommandResult.getCorrelationId();
                Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                unknownError2 = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId, null, exc2, 20, null);
            } else {
                Object result2 = rawCommandResult.getResult();
                if (result2 instanceof Exception) {
                    String correlationId2 = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                    unknownError2 = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED", null, correlationId2, null, null, 52, null);
                } else {
                    try {
                    } catch (ClassCastException unused) {
                        String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordStartCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                    }
                    if (result2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordStartCommandResult");
                    }
                    unknownError = (ResetPasswordStartCommandResult) result2;
                    unknownError2 = unknownError;
                }
            }
            if (unknownError2 instanceof ResetPasswordCommandResult.CodeRequired) {
                ResetPasswordCommandResult.CodeRequired codeRequired = (ResetPasswordCommandResult.CodeRequired) unknownError2;
                return new ResetPasswordStartResult.CodeRequired(new ResetPasswordCodeRequiredState(codeRequired.getContinuationToken(), unknownError2.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig), codeRequired.getCodeLength(), codeRequired.getChallengeTargetLabel(), codeRequired.getChallengeChannel());
            }
            if (unknownError2 instanceof ResetPasswordCommandResult.UserNotFound) {
                ResetPasswordCommandResult.UserNotFound userNotFound = (ResetPasswordCommandResult.UserNotFound) unknownError2;
                resetPasswordError = new ResetPasswordError(ErrorTypes.USER_NOT_FOUND, userNotFound.getError(), userNotFound.getErrorDescription(), unknownError2.getCorrelationId(), null, null, 48, null);
            } else if (unknownError2 instanceof INativeAuthCommandResult.InvalidUsername) {
                INativeAuthCommandResult.InvalidUsername invalidUsername = (INativeAuthCommandResult.InvalidUsername) unknownError2;
                resetPasswordError = new ResetPasswordError(ErrorTypes.INVALID_USERNAME, invalidUsername.getError(), invalidUsername.getErrorDescription(), unknownError2.getCorrelationId(), invalidUsername.getErrorCodes(), null, 32, null);
            } else if (unknownError2 instanceof INativeAuthCommandResult.UnknownError) {
                INativeAuthCommandResult.UnknownError unknownError3 = (INativeAuthCommandResult.UnknownError) unknownError2;
                resetPasswordError = new ResetPasswordError(null, unknownError3.getError(), unknownError3.getErrorDescription(), unknownError2.getCorrelationId(), null, unknownError3.getException(), 17, null);
            } else if (unknownError2 instanceof INativeAuthCommandResult.Redirect) {
                INativeAuthCommandResult.Redirect redirect = (INativeAuthCommandResult.Redirect) unknownError2;
                resetPasswordError = new ResetPasswordError(ErrorTypes.BROWSER_REQUIRED, redirect.getError(), redirect.getErrorDescription(), unknownError2.getCorrelationId(), null, null, 48, null);
            } else {
                if (!(unknownError2 instanceof ResetPasswordCommandResult.PasswordNotSet) && !(unknownError2 instanceof ResetPasswordCommandResult.EmailNotVerified)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), unknownError2.getCorrelationId(), "Reset password received unexpected result: ", unknownError2);
                resetPasswordError = new ResetPasswordError(null, ErrorTypes.INVALID_STATE, "Unexpected state", unknownError2.getCorrelationId(), null, null, 49, null);
            }
            return resetPasswordError;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ResetPasswordStartResult> continuation) {
            return ((C64583) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$1", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {288}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignInCallback $callback;
        final /* synthetic */ char[] $password;
        final /* synthetic */ List<String> $scopes;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64591(String str, char[] cArr, List<String> list, SignInCallback signInCallback, Continuation<? super C64591> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$scopes = list;
            this.$callback = signInCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64591(this.$username, this.$password, this.$scopes, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeAuthPublicClientApplication nativeAuthPublicClientApplication = NativeAuthPublicClientApplication.this;
                    String str = this.$username;
                    char[] cArr = this.$password;
                    List<String> list = this.$scopes;
                    this.label = 1;
                    obj = nativeAuthPublicClientApplication.signIn(str, cArr, list, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in signIn", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signIn$3", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64603 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInResult>, Object> {
        final /* synthetic */ char[] $password;
        final /* synthetic */ List<String> $scopes;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64603(String str, char[] cArr, List<String> list, Continuation<? super C64603> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$scopes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64603(this.$username, this.$password, this.$scopes, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException, MsalClientException {
            INativeAuthCommandResult unknownError;
            INativeAuthCommandResult unknownError2;
            SignInError signInError;
            Object passwordRequired;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NativeAuthPublicClientApplication.this.verifyNoUserIsSignedIn();
            if (StringsKt.isBlank(this.$username)) {
                return new SignInError(ErrorTypes.INVALID_USERNAME, null, "Empty or blank username", TelemetryEventStrings.Value.UNSET, null, null, 50, null);
            }
            char[] cArr = this.$password;
            boolean z = false;
            if (cArr != null) {
                if (!(cArr.length == 0)) {
                    z = true;
                }
            }
            SignInStartCommandParameters params = CommandParametersAdapter.createSignInStartCommandParameters(NativeAuthPublicClientApplication.this.nativeAuthConfig, NativeAuthPublicClientApplication.this.nativeAuthConfig.getOAuth2TokenCache(), this.$username, this.$password, this.$scopes);
            try {
                Intrinsics.checkNotNullExpressionValue(params, "params");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInStartCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_WITH_EMAIL)).get();
                Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
                if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                    if (rawCommandResult.getResult() instanceof Exception) {
                        Object result = rawCommandResult.getResult();
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                        Exception exc2 = (Exception) result;
                        exc = exc2;
                        message = exc2.getMessage();
                    } else {
                        message = "";
                        exc = null;
                    }
                    String correlationId = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                    unknownError2 = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, message, null, correlationId, null, exc, 20, null);
                } else {
                    Object result2 = rawCommandResult.getResult();
                    if (result2 instanceof Exception) {
                        String str = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                        String correlationId2 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                        unknownError2 = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId2, null, null, 52, null);
                    } else {
                        try {
                        } catch (ClassCastException unused) {
                            String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInStartCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                        }
                        if (result2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInStartCommandResult");
                        }
                        unknownError = (SignInStartCommandResult) result2;
                        unknownError2 = unknownError;
                    }
                }
                if (unknownError2 instanceof SignInCommandResult.Complete) {
                    if (z) {
                        IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) unknownError2).getAuthenticationResult());
                        AccountState.Companion companion = AccountState.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                        passwordRequired = new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, unknownError2.getCorrelationId(), NativeAuthPublicClientApplication.this.nativeAuthConfig));
                    } else {
                        Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign in received unexpected result: ", unknownError2);
                        signInError = new SignInError(null, ErrorTypes.INVALID_STATE, "unexpected state", unknownError2.getCorrelationId(), null, null, 49, null);
                        passwordRequired = signInError;
                    }
                } else if (unknownError2 instanceof SignInCommandResult.CodeRequired) {
                    Logger.warn(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), unknownError2.getCorrelationId(), "Server requires a code");
                    passwordRequired = new SignInResult.CodeRequired(new SignInCodeRequiredState(((SignInCommandResult.CodeRequired) unknownError2).getContinuationToken(), unknownError2.getCorrelationId(), this.$scopes, NativeAuthPublicClientApplication.this.nativeAuthConfig), ((SignInCommandResult.CodeRequired) unknownError2).getCodeLength(), ((SignInCommandResult.CodeRequired) unknownError2).getChallengeTargetLabel(), ((SignInCommandResult.CodeRequired) unknownError2).getChallengeChannel());
                } else {
                    if (unknownError2 instanceof INativeAuthCommandResult.InvalidUsername) {
                        signInError = new SignInError(ErrorTypes.INVALID_USERNAME, ((INativeAuthCommandResult.InvalidUsername) unknownError2).getError(), ((INativeAuthCommandResult.InvalidUsername) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), ((INativeAuthCommandResult.InvalidUsername) unknownError2).getErrorCodes(), null, 32, null);
                    } else if (unknownError2 instanceof SignInCommandResult.PasswordRequired) {
                        if (z) {
                            Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign in using password received unexpected result: ", unknownError2);
                            signInError = new SignInError(null, ErrorTypes.INVALID_STATE, "unexpected state", unknownError2.getCorrelationId(), null, null, 49, null);
                        } else {
                            passwordRequired = new SignInResult.PasswordRequired(new SignInPasswordRequiredState(((SignInCommandResult.PasswordRequired) unknownError2).getContinuationToken(), unknownError2.getCorrelationId(), this.$scopes, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                        }
                    } else if (unknownError2 instanceof SignInCommandResult.UserNotFound) {
                        signInError = new SignInError(ErrorTypes.USER_NOT_FOUND, ((SignInCommandResult.UserNotFound) unknownError2).getError(), ((SignInCommandResult.UserNotFound) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), ((SignInCommandResult.UserNotFound) unknownError2).getErrorCodes(), null, 32, null);
                    } else if (unknownError2 instanceof SignInCommandResult.InvalidCredentials) {
                        if (z) {
                            signInError = new SignInError(SignInErrorTypes.INVALID_CREDENTIALS, ((SignInCommandResult.InvalidCredentials) unknownError2).getError(), ((SignInCommandResult.InvalidCredentials) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), ((SignInCommandResult.InvalidCredentials) unknownError2).getErrorCodes(), null, 32, null);
                        } else {
                            Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign in received Unexpected result: ", unknownError2);
                            signInError = new SignInError(null, ErrorTypes.INVALID_STATE, "unexpected state", unknownError2.getCorrelationId(), ((SignInCommandResult.InvalidCredentials) unknownError2).getErrorCodes(), null, 33, null);
                        }
                    } else if (unknownError2 instanceof INativeAuthCommandResult.Redirect) {
                        signInError = new SignInError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) unknownError2).getError(), ((INativeAuthCommandResult.Redirect) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), null, null, 48, null);
                    } else {
                        if (!(unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        signInError = new SignInError(null, ((INativeAuthCommandResult.UnknownError) unknownError2).getError(), ((INativeAuthCommandResult.UnknownError) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), ((INativeAuthCommandResult.UnknownError) unknownError2).getErrorCodes(), ((INativeAuthCommandResult.UnknownError) unknownError2).getException(), 1, null);
                    }
                    passwordRequired = signInError;
                }
                return passwordRequired;
            } finally {
                StringUtil.overwriteWithNull(params.password);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignInResult> continuation) {
            return ((C64603) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$1", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {507}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserAttributes $attributes;
        final /* synthetic */ SignUpCallback $callback;
        final /* synthetic */ char[] $password;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64611(String str, char[] cArr, UserAttributes userAttributes, SignUpCallback signUpCallback, Continuation<? super C64611> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$attributes = userAttributes;
            this.$callback = signUpCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64611(this.$username, this.$password, this.$attributes, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeAuthPublicClientApplication nativeAuthPublicClientApplication = NativeAuthPublicClientApplication.this;
                    String str = this.$username;
                    char[] cArr = this.$password;
                    UserAttributes userAttributes = this.$attributes;
                    this.label = 1;
                    obj = nativeAuthPublicClientApplication.signUp(str, cArr, userAttributes, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignUpResult) obj);
            } catch (MsalException e) {
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in signUp", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignUpResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication$signUp$3", m14021f = "NativeAuthPublicClientApplication.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64623 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignUpResult>, Object> {
        final /* synthetic */ UserAttributes $attributes;
        final /* synthetic */ Ref.BooleanRef $hasPassword;
        final /* synthetic */ char[] $password;
        final /* synthetic */ String $username;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64623(String str, char[] cArr, UserAttributes userAttributes, Ref.BooleanRef booleanRef, Continuation<? super C64623> continuation) {
            super(2, continuation);
            this.$username = str;
            this.$password = cArr;
            this.$attributes = userAttributes;
            this.$hasPassword = booleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return NativeAuthPublicClientApplication.this.new C64623(this.$username, this.$password, this.$attributes, this.$hasPassword, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws MsalClientException {
            INativeAuthCommandResult unknownError;
            SignUpError signUpError;
            SignUpError signUpError2;
            Object passwordRequired;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Boolean doesAccountExist = (Boolean) NativeAuthPublicClientApplication.this.checkForPersistedAccount().get();
            Intrinsics.checkNotNullExpressionValue(doesAccountExist, "doesAccountExist");
            if (doesAccountExist.booleanValue()) {
                throw new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in.");
            }
            if (StringsKt.isBlank(this.$username)) {
                return new SignUpError(ErrorTypes.INVALID_USERNAME, null, "Empty or blank username", TelemetryEventStrings.Value.UNSET, null, null, 50, null);
            }
            NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration = NativeAuthPublicClientApplication.this.nativeAuthConfig;
            OAuth2TokenCache oAuth2TokenCache = NativeAuthPublicClientApplication.this.nativeAuthConfig.getOAuth2TokenCache();
            String str = this.$username;
            char[] cArr = this.$password;
            UserAttributes userAttributes = this.$attributes;
            Exception exc = null;
            SignUpStartCommandParameters parameters = CommandParametersAdapter.createSignUpStartCommandParameters(nativeAuthPublicClientApplicationConfiguration, oAuth2TokenCache, str, cArr, userAttributes != null ? UserAttributesKt.toMap(userAttributes) : null);
            Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
            try {
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignUpStartCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_UP_START)).get();
                Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
                if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                    String message = "";
                    if (rawCommandResult.getResult() instanceof Exception) {
                        Object result = rawCommandResult.getResult();
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                        exc = (Exception) result;
                        message = exc.getMessage();
                    }
                    String str2 = message;
                    Exception exc2 = exc;
                    String correlationId = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                    unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId, null, exc2, 20, null);
                } else {
                    Object result2 = rawCommandResult.getResult();
                    if (result2 instanceof Exception) {
                        String str3 = "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED";
                        String correlationId2 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str3, null, correlationId2, null, null, 52, null);
                    } else {
                        try {
                            if (result2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignUpStartCommandResult");
                            }
                            unknownError = (SignUpStartCommandResult) result2;
                        } catch (ClassCastException unused) {
                            String str4 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignUpStartCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str4, null, correlationId3, null, null, 52, null);
                        }
                    }
                }
                if (unknownError instanceof SignUpCommandResult.Complete) {
                    passwordRequired = new SignUpResult.Complete(new SignInContinuationState(((SignUpCommandResult.Complete) unknownError).getContinuationToken(), unknownError.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                } else if (unknownError instanceof SignUpCommandResult.AttributesRequired) {
                    passwordRequired = new SignUpResult.AttributesRequired(new SignUpAttributesRequiredState(((SignUpCommandResult.AttributesRequired) unknownError).getContinuationToken(), unknownError.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig), RequiredUserAttributeKt.toListOfRequiredUserAttribute(((SignUpCommandResult.AttributesRequired) unknownError).getRequiredAttributes()));
                } else if (unknownError instanceof SignUpCommandResult.CodeRequired) {
                    passwordRequired = new SignUpResult.CodeRequired(new SignUpCodeRequiredState(((SignUpCommandResult.CodeRequired) unknownError).getContinuationToken(), unknownError.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig), ((SignUpCommandResult.CodeRequired) unknownError).getCodeLength(), ((SignUpCommandResult.CodeRequired) unknownError).getChallengeTargetLabel(), ((SignUpCommandResult.CodeRequired) unknownError).getChallengeChannel());
                } else if (!(unknownError instanceof SignUpCommandResult.PasswordRequired)) {
                    if (unknownError instanceof SignUpCommandResult.AuthNotSupported) {
                        signUpError = new SignUpError(SignUpErrorTypes.AUTH_NOT_SUPPORTED, ((SignUpCommandResult.AuthNotSupported) unknownError).getError(), ((SignUpCommandResult.AuthNotSupported) unknownError).getErrorDescription(), unknownError.getCorrelationId(), null, null, 48, null);
                    } else if (unknownError instanceof SignUpCommandResult.InvalidPassword) {
                        if (this.$hasPassword.element) {
                            signUpError = new SignUpError(ErrorTypes.INVALID_PASSWORD, ((SignUpCommandResult.InvalidPassword) unknownError).getError(), ((SignUpCommandResult.InvalidPassword) unknownError).getErrorDescription(), unknownError.getCorrelationId(), null, null, 48, null);
                        } else {
                            Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign up received unexpected result: ", unknownError);
                            signUpError2 = new SignUpError(null, ErrorTypes.INVALID_STATE, "Unexpected state", unknownError.getCorrelationId(), null, null, 49, null);
                            passwordRequired = signUpError2;
                        }
                    } else if (unknownError instanceof SignUpCommandResult.UsernameAlreadyExists) {
                        signUpError = new SignUpError(SignUpErrorTypes.USER_ALREADY_EXISTS, ((SignUpCommandResult.UsernameAlreadyExists) unknownError).getError(), ((SignUpCommandResult.UsernameAlreadyExists) unknownError).getErrorDescription(), unknownError.getCorrelationId(), null, null, 48, null);
                    } else if (unknownError instanceof INativeAuthCommandResult.InvalidUsername) {
                        signUpError = new SignUpError(ErrorTypes.INVALID_USERNAME, ((INativeAuthCommandResult.InvalidUsername) unknownError).getError(), ((INativeAuthCommandResult.InvalidUsername) unknownError).getErrorDescription(), unknownError.getCorrelationId(), null, null, 48, null);
                    } else if (unknownError instanceof SignUpCommandResult.InvalidAttributes) {
                        signUpError = new SignUpError(SignUpErrorTypes.INVALID_ATTRIBUTES, ((SignUpCommandResult.InvalidAttributes) unknownError).getError(), ((SignUpCommandResult.InvalidAttributes) unknownError).getErrorDescription(), unknownError.getCorrelationId(), null, null, 48, null);
                    } else if (unknownError instanceof INativeAuthCommandResult.Redirect) {
                        signUpError = new SignUpError(ErrorTypes.BROWSER_REQUIRED, ((INativeAuthCommandResult.Redirect) unknownError).getError(), ((INativeAuthCommandResult.Redirect) unknownError).getErrorDescription(), unknownError.getCorrelationId(), null, null, 48, null);
                    } else {
                        if (!(unknownError instanceof INativeAuthCommandResult.UnknownError)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        signUpError = new SignUpError(null, ErrorTypes.INVALID_STATE, "Unexpected state", unknownError.getCorrelationId(), null, null, 49, null);
                    }
                    passwordRequired = signUpError;
                } else if (this.$hasPassword.element) {
                    Logger.warnWithObject(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Sign up using password received unexpected result: ", unknownError);
                    signUpError2 = new SignUpError(null, ErrorTypes.INVALID_STATE, "Unexpected state", unknownError.getCorrelationId(), null, null, 49, null);
                    passwordRequired = signUpError2;
                } else {
                    passwordRequired = new SignUpResult.PasswordRequired(new SignUpPasswordRequiredState(((SignUpCommandResult.PasswordRequired) unknownError).getContinuationToken(), unknownError.getCorrelationId(), this.$username, NativeAuthPublicClientApplication.this.nativeAuthConfig));
                }
                return passwordRequired;
            } finally {
                StringUtil.overwriteWithNull(parameters.password);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignUpResult> continuation) {
            return ((C64623) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        String string = NativeAuthPublicClientApplication.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "NativeAuthPublicClientAp…on::class.java.toString()");
        TAG = string;
        pcaScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAuthPublicClientApplication(@NotNull NativeAuthPublicClientApplicationConfiguration nativeAuthConfig) {
        super(nativeAuthConfig);
        Intrinsics.checkNotNullParameter(nativeAuthConfig, "nativeAuthConfig");
        this.nativeAuthConfig = nativeAuthConfig;
        initializeApplication();
        Context appContext = nativeAuthConfig.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "nativeAuthConfig.appContext");
        initializeSharedPreferenceFileManager(appContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultFuture<Boolean> checkForPersistedAccount() {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, str + ".checkForPersistedAccount");
        final ResultFuture<Boolean> resultFuture = new ResultFuture<>();
        getCurrentAccount(new GetCurrentAccountCallback() { // from class: com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication.checkForPersistedAccount.1
            @Override // com.microsoft.identity.nativeauth.statemachine.states.Callback
            public void onError(@NotNull BaseException exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                Logger.error(NativeAuthPublicClientApplication.INSTANCE.getTAG$msal_distRelease(), "Exception thrown in checkForPersistedAccount", exception);
                resultFuture.setException(exception);
            }

            @Override // com.microsoft.identity.nativeauth.statemachine.states.Callback
            public void onResult(@NotNull GetAccountResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                resultFuture.setResult(Boolean.valueOf(result instanceof GetAccountResult.AccountFound));
            }
        });
        return resultFuture;
    }

    private final void initializeApplication() {
        Context appContext = this.nativeAuthConfig.getAppContext();
        AzureActiveDirectory.setEnvironment(this.nativeAuthConfig.getEnvironment());
        Authority.addKnownAuthorities(this.nativeAuthConfig.getAuthorities());
        PublicClientApplication.initializeLoggerSettings(this.nativeAuthConfig.getLoggerConfiguration());
        PublicClientApplication.checkInternetPermission(this.nativeAuthConfig);
        HttpCache.initialize(appContext.getCacheDir());
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        AbstractC12991c.m14004y(str, ".initializeApplication", companion, str, null);
    }

    private final void initializeSharedPreferenceFileManager(Context context) {
        this.sharedPreferencesFileManager = new SharedPreferencesFileManager(context, NATIVE_AUTH_CREDENTIAL_SHARED_PREFERENCES, new AndroidAuthSdkStorageEncryptionManager(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyNoUserIsSignedIn() throws ExecutionException, InterruptedException, MsalClientException {
        Boolean doesAccountExist = checkForPersistedAccount().get();
        Intrinsics.checkNotNullExpressionValue(doesAccountExist, "doesAccountExist");
        if (doesAccountExist.booleanValue()) {
            Logger.error(TAG, "An account is already signed in.", null);
            throw new MsalClientException(MsalClientException.INVALID_PARAMETER, "An account is already signed in.");
        }
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void getCurrentAccount(@NotNull GetCurrentAccountCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C64551(callback, null), 3, null);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void resetPassword(@NotNull String username, @NotNull ResetPasswordCallback callback) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        AbstractC12991c.m14004y(str, ".resetPassword", companion, str, null);
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C64571(username, callback, null), 3, null);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void signIn(@NotNull String username, @Nullable char[] password, @Nullable List<String> scopes, @NotNull SignInCallback callback) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        AbstractC12991c.m14004y(str, ".signIn", companion, str, null);
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C64591(username, password, scopes, callback, null), 3, null);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    public void signUp(@NotNull String username, @Nullable char[] password, @Nullable UserAttributes attributes, @NotNull SignUpCallback callback) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        AbstractC12991c.m14004y(str, ".signUp", companion, str, null);
        BuildersKt__Builders_commonKt.launch$default(pcaScope, null, null, new C64611(username, password, attributes, callback, null), 3, null);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Nullable
    public Object getCurrentAccount(@NotNull Continuation<? super GetAccountResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C64563(null), continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Nullable
    public Object resetPassword(@NotNull String str, @NotNull Continuation<? super ResetPasswordStartResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, str2 + ".resetPassword(username: String)");
        return BuildersKt.withContext(Dispatchers.getIO(), new C64583(str, null), continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Nullable
    public Object signIn(@NotNull String str, @Nullable char[] cArr, @Nullable List<String> list, @NotNull Continuation<? super SignInResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, str2 + ".signIn");
        return BuildersKt.withContext(Dispatchers.getIO(), new C64603(str, cArr, list, null), continuation);
    }

    @Override // com.microsoft.identity.nativeauth.INativeAuthPublicClientApplication
    @Nullable
    public Object signUp(@NotNull String str, @Nullable char[] cArr, @Nullable UserAttributes userAttributes, @NotNull Continuation<? super SignUpResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str2 = TAG;
        companion.logMethodCall(str2, null, str2 + ".signUp");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        boolean z = false;
        if (cArr != null) {
            if (!(cArr.length == 0)) {
                z = true;
            }
        }
        booleanRef.element = z;
        return BuildersKt.withContext(Dispatchers.getIO(), new C64623(str, cArr, userAttributes, booleanRef, null), continuation);
    }
}
