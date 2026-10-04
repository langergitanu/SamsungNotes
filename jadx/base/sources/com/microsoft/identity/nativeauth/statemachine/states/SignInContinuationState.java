package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.AuthenticationResultAdapter;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInWithContinuationTokenCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInWithContinuationTokenCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInContinuationError;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001f B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J#\u0010\u0015\u001a\u00020\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J \u0010\u0015\u001a\u00020\u001a2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0014H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\n\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", SearchConstants.TargetContents.TAG, "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "getUsername$msal_distRelease", "describeContents", "", "signIn", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "scopes", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState$SignInContinuationCallback;", "writeToParcel", "flags", "CREATOR", "SignInContinuationCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInContinuationState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String TAG;

    @NotNull
    private final NativeAuthPublicClientApplicationConfiguration config;

    @Nullable
    private final String continuationToken;

    @NotNull
    private final String correlationId;

    @NotNull
    private final String username;

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SignInContinuationState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SignInContinuationState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignInContinuationState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SignInContinuationState[] newArray(int size) {
            return new SignInContinuationState[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInContinuationState$SignInContinuationCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SignInContinuationCallback extends Callback<SignInResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$1", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {508}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SignInContinuationCallback $callback;
        final /* synthetic */ List<String> $scopes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64771(List<String> list, SignInContinuationCallback signInContinuationCallback, Continuation<? super C64771> continuation) {
            super(2, continuation);
            this.$scopes = list;
            this.$callback = signInContinuationCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInContinuationState.this.new C64771(this.$scopes, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SignInContinuationState signInContinuationState = SignInContinuationState.this;
                    List<String> list = this.$scopes;
                    this.label = 1;
                    obj = signInContinuationState.signIn(list, this);
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
                Logger.error(SignInContinuationState.this.TAG, "Exception thrown in signIn", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInContinuationState$signIn$3", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64783 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInResult>, Object> {
        final /* synthetic */ List<String> $scopes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64783(List<String> list, Continuation<? super C64783> continuation) {
            super(2, continuation);
            this.$scopes = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInContinuationState.this.new C64783(this.$scopes, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException {
            SignInWithContinuationTokenCommandResult unknownError;
            SignInWithContinuationTokenCommandResult unknownError2;
            Exception exc;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LogSession.INSTANCE.logMethodCall(SignInContinuationState.this.TAG, SignInContinuationState.this.getCorrelationId(), SignInContinuationState.this.TAG + ".signIn(scopes: List<String>)");
            String continuationToken = SignInContinuationState.this.getContinuationToken();
            if (continuationToken == null || continuationToken.length() == 0) {
                Logger.warn(SignInContinuationState.this.TAG, "Sign in after sign up received unexpected result: continuationToken was null");
                return new SignInContinuationError(ErrorTypes.INVALID_STATE, "Sign In is not available through this state, please use the standalone sign in method.", TelemetryEventStrings.Value.UNSET, null, null, 24, null);
            }
            SignInWithContinuationTokenCommandParameters commandParameters = CommandParametersAdapter.createSignInWithContinuationTokenCommandParameters(SignInContinuationState.this.config, SignInContinuationState.this.config.getOAuth2TokenCache(), SignInContinuationState.this.getContinuationToken(), SignInContinuationState.this.getUsername(), SignInContinuationState.this.getCorrelationId(), this.$scopes);
            Intrinsics.checkNotNullExpressionValue(commandParameters, "commandParameters");
            CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInWithContinuationTokenCommand(commandParameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_WITH_SLT)).get();
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
                        String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInWithContinuationTokenCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                    }
                    if (result2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInWithContinuationTokenCommandResult");
                    }
                    unknownError = (SignInWithContinuationTokenCommandResult) result2;
                    unknownError2 = unknownError;
                }
            }
            if (unknownError2 instanceof SignInCommandResult.Complete) {
                IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) unknownError2).getAuthenticationResult());
                AccountState.Companion creator = AccountState.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                return new SignInResult.Complete(creator.createFromAuthenticationResult(authenticationResult, unknownError2.getCorrelationId(), SignInContinuationState.this.config));
            }
            if (!(unknownError2 instanceof INativeAuthCommandResult.Redirect ? true : unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(SignInContinuationState.this.TAG, unknownError2.getCorrelationId(), "Sign in after sign up received unexpected result: ", unknownError2);
            Intrinsics.checkNotNull(unknownError2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error");
            INativeAuthCommandResult.Error error = (INativeAuthCommandResult.Error) unknownError2;
            return new SignInContinuationError(error.getError(), error.getErrorDescription(), error.getCorrelationId(), error.getErrorCodes(), ((INativeAuthCommandResult.UnknownError) unknownError2).getException());
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignInResult> continuation) {
            return ((C64783) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInContinuationState(@Nullable String str, @NotNull String correlationId, @NotNull String username, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
        super(str, correlationId);
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = str;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignInContinuationState", "SignInContinuationState::class.java.simpleName");
        this.TAG = "SignInContinuationState";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void signIn$default(SignInContinuationState signInContinuationState, List list, SignInContinuationCallback signInContinuationCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        signInContinuationState.signIn((List<String>) list, signInContinuationCallback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseState
    @Nullable
    /* JADX INFO: renamed from: getContinuationToken$msal_distRelease, reason: from getter */
    public String getContinuationToken() {
        return this.continuationToken;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseState
    @NotNull
    /* JADX INFO: renamed from: getCorrelationId$msal_distRelease, reason: from getter */
    public String getCorrelationId() {
        return this.correlationId;
    }

    @NotNull
    /* JADX INFO: renamed from: getUsername$msal_distRelease, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final void signIn(@Nullable List<String> scopes, @NotNull SignInContinuationCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".signIn", new StringBuilder()));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64771(scopes, callback, null), 3, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeString(this.username);
        parcel.writeSerializable(this.config);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object signIn$default(SignInContinuationState signInContinuationState, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return signInContinuationState.signIn((List<String>) list, (Continuation<? super SignInResult>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignInContinuationState(@NotNull Parcel parcel) {
        Object obj;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        String string3 = parcel.readString();
        string3 = string3 == null ? "" : string3;
        if (Build.VERSION.SDK_INT >= 33) {
            obj = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            obj = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, string3, (NativeAuthPublicClientApplicationConfiguration) obj);
    }

    @Nullable
    public final Object signIn(@Nullable List<String> list, @NotNull Continuation<? super SignInResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C64783(list, null), continuation);
    }
}
