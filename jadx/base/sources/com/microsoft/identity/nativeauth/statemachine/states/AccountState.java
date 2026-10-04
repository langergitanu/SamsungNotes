package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.AbstractC1974b;
import com.microsoft.identity.client.Account;
import com.microsoft.identity.client.AcquireTokenSilentParameters;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.PublicClientApplication;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.internal.commands.RemoveCurrentAccountCommand;
import com.microsoft.identity.common.internal.controllers.LocalMSALController;
import com.microsoft.identity.common.java.commands.CommandCallback;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.AcquireTokenNoFixedScopesCommandParameters;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.AcquireTokenNoFixedScopesCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.GetAccessTokenError;
import com.microsoft.identity.nativeauth.statemachine.results.GetAccessTokenResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignOutResult;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001b\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0010\u001a\u00020\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0011\u0010\u001c\u001a\u00020\u001dH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "account", "Lcom/microsoft/identity/client/IAccount;", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "correlationId", "", "(Lcom/microsoft/identity/client/IAccount;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;Ljava/lang/String;)V", "getCorrelationId", "()Ljava/lang/String;", "describeContents", "", "getAccessToken", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$GetAccessTokenCallback;", "getAccount", "getClaims", "", "getIdToken", "signOut", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$SignOutCallback;", "writeToParcel", "flags", "CREATOR", "GetAccessTokenCallback", "SignOutCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class AccountState implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NativeAuthPublicClientApplication";

    @NotNull
    private IAccount account;

    @NotNull
    private final NativeAuthPublicClientApplicationConfiguration config;

    @NotNull
    private final String correlationId;

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001d\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "createFromAccountResult", "account", "Lcom/microsoft/identity/client/IAccount;", "correlationId", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "createFromAuthenticationResult", "authenticationResult", "Lcom/microsoft/identity/client/IAuthenticationResult;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<AccountState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AccountState createFromAccountResult(@NotNull IAccount account, @NotNull String correlationId, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
            Intrinsics.checkNotNullParameter(account, "account");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(config, "config");
            return new AccountState(account, config, correlationId, null);
        }

        @NotNull
        public final AccountState createFromAuthenticationResult(@NotNull IAuthenticationResult authenticationResult, @NotNull String correlationId, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
            Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
            Intrinsics.checkNotNullParameter(correlationId, "correlationId");
            Intrinsics.checkNotNullParameter(config, "config");
            IAccount account = authenticationResult.getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "account");
            return new AccountState(account, config, correlationId, null);
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AccountState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AccountState[] newArray(int size) {
            return new AccountState[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$GetAccessTokenCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface GetAccessTokenCallback extends Callback<GetAccessTokenResult> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/AccountState$SignOutCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SignOutCallback extends Callback<SignOutResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$1", m14021f = "AccountState.kt", m14022i = {}, m14023l = {213}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetAccessTokenCallback $callback;
        final /* synthetic */ boolean $forceRefresh;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64631(boolean z, GetAccessTokenCallback getAccessTokenCallback, Continuation<? super C64631> continuation) {
            super(2, continuation);
            this.$forceRefresh = z;
            this.$callback = getAccessTokenCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AccountState.this.new C64631(this.$forceRefresh, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AccountState accountState = AccountState.this;
                    boolean z = this.$forceRefresh;
                    this.label = 1;
                    obj = accountState.getAccessToken(z, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((GetAccessTokenResult) obj);
            } catch (MsalException e) {
                Logger.error(AccountState.TAG, "Exception thrown in getAccessToken", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/GetAccessTokenResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$getAccessToken$3", m14021f = "AccountState.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64643 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetAccessTokenResult>, Object> {
        final /* synthetic */ boolean $forceRefresh;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64643(boolean z, Continuation<? super C64643> continuation) {
            super(2, continuation);
            this.$forceRefresh = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AccountState.this.new C64643(this.$forceRefresh, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            IAccount currentAccountInternal = NativeAuthPublicClientApplication.INSTANCE.getCurrentAccountInternal(AccountState.this.config);
            Account account = currentAccountInternal instanceof Account ? (Account) currentAccountInternal : null;
            if (account == null) {
                return new GetAccessTokenError("no_account_found", MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE, TelemetryEventStrings.Value.UNSET, null, null, 48, null);
            }
            AcquireTokenNoFixedScopesCommandParameters params = CommandParametersAdapter.createAcquireTokenNoFixedScopesCommandParameters(AccountState.this.config, AccountState.this.config.getOAuth2TokenCache(), PublicClientApplication.selectAccountRecordForTokenRequest(AccountState.this.config, new AcquireTokenSilentParameters.Builder().forAccount(account).fromAuthority(account.getAuthority()).build()), Boxing.boxBoolean(this.$forceRefresh), AccountState.this.getCorrelationId());
            Intrinsics.checkNotNullExpressionValue(params, "params");
            Object result = CommandDispatcher.submitSilentReturningFuture(new AcquireTokenNoFixedScopesCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_ACCOUNT_GET_ACCESS_TOKEN)).get().getResult();
            if (result instanceof ServiceException) {
                return new GetAccessTokenError(null, null, null, TelemetryEventStrings.Value.UNSET, null, ExceptionAdapter.convertToNativeAuthException((ServiceException) result), 23, null);
            }
            if (result instanceof Exception) {
                return new GetAccessTokenError(null, null, null, TelemetryEventStrings.Value.UNSET, null, (Exception) result, 23, null);
            }
            AccountState accountState = AccountState.this;
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.microsoft.identity.common.java.result.ILocalAuthenticationResult");
            ILocalAuthenticationResult iLocalAuthenticationResult = (ILocalAuthenticationResult) result;
            IAccount account2 = AuthenticationResultAdapter.adapt(iLocalAuthenticationResult).getAccount();
            Intrinsics.checkNotNullExpressionValue(account2, "adapt(commandResult as I…enticationResult).account");
            accountState.account = account2;
            IAuthenticationResult iAuthenticationResultAdapt = AuthenticationResultAdapter.adapt(iLocalAuthenticationResult);
            Intrinsics.checkNotNullExpressionValue(iAuthenticationResultAdapt, "adapt(commandResult)");
            return new GetAccessTokenResult.Complete(iAuthenticationResultAdapt);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super GetAccessTokenResult> continuation) {
            return ((C64643) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$1", m14021f = "AccountState.kt", m14022i = {}, m14023l = {92}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignOutCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64651(SignOutCallback signOutCallback, Continuation<? super C64651> continuation) {
            super(2, continuation);
            this.$callback = signOutCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AccountState.this.new C64651(this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AccountState accountState = AccountState.this;
                    this.label = 1;
                    obj = accountState.signOut(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignOutResult) obj);
            } catch (MsalException e) {
                Logger.error(AccountState.TAG, "Exception thrown in signOut", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignOutResult$Complete;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$3", m14021f = "AccountState.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64663 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignOutResult.Complete>, Object> {
        int label;

        public C64663(Continuation<? super C64663> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return AccountState.this.new C64663(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws MsalClientException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LogSession.Companion companion = LogSession.INSTANCE;
            String str = AccountState.TAG;
            StringBuilder sbM1325r = AbstractC1974b.m1325r(str, SearchConstants.TargetContents.TAG);
            sbM1325r.append(AccountState.TAG);
            sbM1325r.append(".signOut.withContext");
            companion.logMethodCall(str, null, sbM1325r.toString());
            IAccount currentAccountInternal = NativeAuthPublicClientApplication.INSTANCE.getCurrentAccountInternal(AccountState.this.config);
            if (currentAccountInternal == null) {
                throw new MsalClientException(MsalClientException.NO_CURRENT_ACCOUNT, MsalClientException.NO_CURRENT_ACCOUNT_ERROR_MESSAGE);
            }
            AccountRecord accountRecord = new AccountRecord();
            Account account = (Account) currentAccountInternal;
            accountRecord.setEnvironment(account.getEnvironment());
            accountRecord.setHomeAccountId(account.getHomeAccountId());
            Object result = CommandDispatcher.submitSilentReturningFuture(new RemoveCurrentAccountCommand(CommandParametersAdapter.createRemoveAccountCommandParameters(AccountState.this.config, AccountState.this.config.getOAuth2TokenCache(), accountRecord), new LocalMSALController().asControllerFactory(), new CommandCallback<Boolean, BaseException>() { // from class: com.microsoft.identity.nativeauth.statemachine.states.AccountState$signOut$3$removeCurrentAccountCommandParameters$1
                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
                public void onError(@Nullable BaseException error) {
                }

                @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
                public void onTaskCompleted(@Nullable Boolean result2) {
                }

                @Override // com.microsoft.identity.common.java.commands.CommandCallback
                public void onCancel() {
                }
            }, PublicApiId.NATIVE_AUTH_ACCOUNT_SIGN_OUT)).get().getResult();
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) result).booleanValue()) {
                return SignOutResult.Complete.INSTANCE;
            }
            Logger.error(AccountState.TAG, "Unexpected error during signOut.", null);
            throw new MsalClientException("unknown_error", "Unexpected error during signOut.");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignOutResult.Complete> continuation) {
            return ((C64663) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ AccountState(IAccount iAccount, NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAccount, nativeAuthPublicClientApplicationConfiguration, str);
    }

    public static /* synthetic */ void getAccessToken$default(AccountState accountState, boolean z, GetAccessTokenCallback getAccessTokenCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        accountState.getAccessToken(z, getAccessTokenCallback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void getAccessToken(boolean forceRefresh, @NotNull GetAccessTokenCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".getAccessToken"));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64631(forceRefresh, callback, null), 3, null);
    }

    @NotNull
    public final IAccount getAccount() {
        return this.account;
    }

    @Nullable
    public final Map<String, ?> getClaims() {
        return this.account.getClaims();
    }

    @NotNull
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @Nullable
    public final String getIdToken() {
        return this.account.getIdToken();
    }

    public final void signOut(@NotNull SignOutCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".signOut"));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64651(callback, null), 3, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeSerializable(this.account);
        parcel.writeSerializable(this.correlationId);
        parcel.writeSerializable(this.config);
    }

    private AccountState(IAccount iAccount, NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration, String str) {
        this.account = iAccount;
        this.config = nativeAuthPublicClientApplicationConfiguration;
        this.correlationId = str;
    }

    public static /* synthetic */ Object getAccessToken$default(AccountState accountState, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return accountState.getAccessToken(z, (Continuation<? super GetAccessTokenResult>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AccountState(@NotNull Parcel parcel) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            obj = (Serializable) parcel.readSerializable(IAccount.class.getClassLoader(), IAccount.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            obj = (IAccount) (serializable instanceof IAccount ? serializable : null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.microsoft.identity.client.IAccount");
        IAccount iAccount = (IAccount) obj;
        String string = parcel.readString();
        string = string == null ? TelemetryEventStrings.Value.UNSET : string;
        if (i >= 33) {
            obj2 = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable2 = parcel.readSerializable();
            obj2 = (NativeAuthPublicClientApplicationConfiguration) (serializable2 instanceof NativeAuthPublicClientApplicationConfiguration ? serializable2 : null);
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(iAccount, (NativeAuthPublicClientApplicationConfiguration) obj2, string);
    }

    @Nullable
    public final Object getAccessToken(boolean z, @NotNull Continuation<? super GetAccessTokenResult> continuation) {
        LogSession.Companion companion = LogSession.INSTANCE;
        String str = TAG;
        companion.logMethodCall(str, null, AbstractC12991c.m13991l(str, SearchConstants.TargetContents.TAG, str, ".getAccessToken(forceRefresh: Boolean)"));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64643(z, null), continuation);
    }

    @Nullable
    public final Object signOut(@NotNull Continuation<? super SignOutResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C64663(null), continuation);
    }
}
