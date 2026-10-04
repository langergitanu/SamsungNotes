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
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInResendCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInSubmitCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResendCodeError;
import com.microsoft.identity.nativeauth.statemachine.errors.SubmitCodeError;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInSubmitCodeResult;
import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.Serializable;
import java.util.ArrayList;
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
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\"#$B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B/\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0011\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0014H\u0016R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "scopes", "", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", SearchConstants.TargetContents.TAG, "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "resendCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$ResendCodeCallback;", "submitCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "code", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$SubmitCodeCallback;", "writeToParcel", "flags", "CREATOR", "ResendCodeCallback", "SubmitCodeCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInCodeRequiredState extends BaseState implements State, Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String TAG;

    @NotNull
    private final NativeAuthPublicClientApplicationConfiguration config;

    @NotNull
    private final String continuationToken;

    @NotNull
    private final String correlationId;

    @Nullable
    private final List<String> scopes;

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SignInCodeRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SignInCodeRequiredState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignInCodeRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SignInCodeRequiredState[] newArray(int size) {
            return new SignInCodeRequiredState[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$ResendCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface ResendCodeCallback extends Callback<SignInResendCodeResult> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInCodeRequiredState$SubmitCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SubmitCodeCallback extends Callback<SignInSubmitCodeResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$1", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {JPEG.DRI}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResendCodeCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64731(ResendCodeCallback resendCodeCallback, Continuation<? super C64731> continuation) {
            super(2, continuation);
            this.$callback = resendCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new C64731(this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SignInCodeRequiredState signInCodeRequiredState = SignInCodeRequiredState.this;
                    this.label = 1;
                    obj = signInCodeRequiredState.resendCode(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInResendCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInCodeRequiredState.this.TAG, "Exception thrown in resendCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInResendCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$resendCode$3", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64743 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInResendCodeResult>, Object> {
        int label;

        public C64743(Continuation<? super C64743> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new C64743(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException {
            SignInResendCodeCommandResult unknownError;
            SignInResendCodeCommandResult unknownError2;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SignInResendCodeCommandParameters params = CommandParametersAdapter.createSignInResendCodeCommandParameters(SignInCodeRequiredState.this.config, SignInCodeRequiredState.this.config.getOAuth2TokenCache(), SignInCodeRequiredState.this.getCorrelationId(), SignInCodeRequiredState.this.getContinuationToken());
            Intrinsics.checkNotNullExpressionValue(params, "params");
            CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInResendCodeCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_RESEND_CODE)).get();
            Intrinsics.checkNotNullExpressionValue(rawCommandResult, "rawCommandResult");
            if (rawCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED) {
                if (rawCommandResult.getResult() instanceof Exception) {
                    Object result = rawCommandResult.getResult();
                    Intrinsics.checkNotNull(result, "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
                    Exception exc2 = (Exception) result;
                    message = exc2.getMessage();
                    exc = exc2;
                } else {
                    message = "";
                    exc = null;
                }
                String str = message;
                String correlationId = rawCommandResult.getCorrelationId();
                Intrinsics.checkNotNullExpressionValue(correlationId, "correlationId");
                unknownError2 = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str, null, correlationId, null, exc, 20, null);
            } else {
                Object result2 = rawCommandResult.getResult();
                if (result2 instanceof Exception) {
                    String correlationId2 = rawCommandResult.getCorrelationId();
                    Intrinsics.checkNotNullExpressionValue(correlationId2, "this.correlationId");
                    unknownError2 = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, "Type casting error: result of " + rawCommandResult + " is of type Exception, even though the command was marked as COMPLETED", null, correlationId2, null, null, 52, null);
                } else {
                    try {
                    } catch (ClassCastException unused) {
                        String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInResendCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                    }
                    if (result2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInResendCodeCommandResult");
                    }
                    unknownError = (SignInResendCodeCommandResult) result2;
                    unknownError2 = unknownError;
                }
            }
            if (unknownError2 instanceof SignInCommandResult.CodeRequired) {
                SignInCommandResult.CodeRequired codeRequired = (SignInCommandResult.CodeRequired) unknownError2;
                return new SignInResendCodeResult.Success(new SignInCodeRequiredState(codeRequired.getContinuationToken(), unknownError2.getCorrelationId(), SignInCodeRequiredState.this.scopes, SignInCodeRequiredState.this.config), codeRequired.getCodeLength(), codeRequired.getChallengeTargetLabel(), codeRequired.getChallengeChannel());
            }
            if (!(unknownError2 instanceof INativeAuthCommandResult.Redirect ? true : unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(SignInCodeRequiredState.this.TAG, unknownError2.getCorrelationId(), "Resend code received unexpected result: ", unknownError2);
            Intrinsics.checkNotNull(unknownError2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error");
            INativeAuthCommandResult.Error error = (INativeAuthCommandResult.Error) unknownError2;
            return new ResendCodeError(null, error.getError(), error.getErrorDescription(), error.getCorrelationId(), error.getErrorCodes(), unknownError2 instanceof INativeAuthCommandResult.UnknownError ? ((INativeAuthCommandResult.UnknownError) unknownError2).getException() : null, 1, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignInResendCodeResult> continuation) {
            return ((C64743) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$1", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {109}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitCodeCallback $callback;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64751(String str, SubmitCodeCallback submitCodeCallback, Continuation<? super C64751> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$callback = submitCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new C64751(this.$code, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SignInCodeRequiredState signInCodeRequiredState = SignInCodeRequiredState.this;
                    String str = this.$code;
                    this.label = 1;
                    obj = signInCodeRequiredState.submitCode(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInSubmitCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInCodeRequiredState.this.TAG, "Exception thrown in submitCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInCodeRequiredState$submitCode$3", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64763 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInSubmitCodeResult>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64763(String str, Continuation<? super C64763> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInCodeRequiredState.this.new C64763(this.$code, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException {
            SignInSubmitCodeCommandResult unknownError;
            SignInSubmitCodeCommandResult unknownError2;
            Exception exc;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SignInSubmitCodeCommandParameters params = CommandParametersAdapter.createSignInSubmitCodeCommandParameters(SignInCodeRequiredState.this.config, SignInCodeRequiredState.this.config.getOAuth2TokenCache(), this.$code, SignInCodeRequiredState.this.getContinuationToken(), SignInCodeRequiredState.this.getCorrelationId(), SignInCodeRequiredState.this.scopes);
            Intrinsics.checkNotNullExpressionValue(params, "params");
            CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInSubmitCodeCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_SUBMIT_CODE)).get();
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
                        String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInSubmitCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                    }
                    if (result2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitCodeCommandResult");
                    }
                    unknownError = (SignInSubmitCodeCommandResult) result2;
                    unknownError2 = unknownError;
                }
            }
            if (unknownError2 instanceof SignInCommandResult.IncorrectCode) {
                SignInCommandResult.IncorrectCode incorrectCode = (SignInCommandResult.IncorrectCode) unknownError2;
                return new SubmitCodeError(ErrorTypes.INVALID_CODE, incorrectCode.getError(), incorrectCode.getErrorDescription(), unknownError2.getCorrelationId(), incorrectCode.getErrorCodes(), incorrectCode.getSubError(), null, 64, null);
            }
            if (unknownError2 instanceof SignInCommandResult.Complete) {
                IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) unknownError2).getAuthenticationResult());
                AccountState.Companion companion = AccountState.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                return new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, unknownError2.getCorrelationId(), SignInCodeRequiredState.this.config));
            }
            if (unknownError2 instanceof INativeAuthCommandResult.Redirect) {
                INativeAuthCommandResult.Redirect redirect = (INativeAuthCommandResult.Redirect) unknownError2;
                return new SubmitCodeError(ErrorTypes.BROWSER_REQUIRED, redirect.getError(), redirect.getErrorDescription(), unknownError2.getCorrelationId(), null, null, null, 112, null);
            }
            if (!(unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(SignInCodeRequiredState.this.TAG, unknownError2.getCorrelationId(), "Submit code received unexpected result: ", unknownError2);
            INativeAuthCommandResult.UnknownError unknownError3 = (INativeAuthCommandResult.UnknownError) unknownError2;
            return new SubmitCodeError(null, unknownError3.getError(), unknownError3.getErrorDescription(), unknownError2.getCorrelationId(), unknownError3.getErrorCodes(), null, unknownError3.getException(), 33, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignInSubmitCodeResult> continuation) {
            return ((C64763) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInCodeRequiredState(@NotNull String continuationToken, @NotNull String correlationId, @Nullable List<String> list, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.scopes = list;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignInCodeRequiredState", "SignInCodeRequiredState::class.java.simpleName");
        this.TAG = "SignInCodeRequiredState";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.microsoft.identity.nativeauth.statemachine.states.BaseState
    @NotNull
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

    public final void resendCode(@NotNull ResendCodeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".resendCode", new StringBuilder()));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64731(callback, null), 3, null);
    }

    public final void submitCode(@NotNull String code, @NotNull SubmitCodeCallback callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitCode", new StringBuilder()));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64751(code, callback, null), 3, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeStringList(this.scopes);
        parcel.writeSerializable(this.config);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SignInCodeRequiredState(@NotNull Parcel parcel) {
        Object obj;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        if (Build.VERSION.SDK_INT >= 33) {
            obj = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            obj = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, arrayListCreateStringArrayList, (NativeAuthPublicClientApplicationConfiguration) obj);
    }

    @Nullable
    public final Object resendCode(@NotNull Continuation<? super SignInResendCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".resendCode()", new StringBuilder()));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64743(null), continuation);
    }

    @Nullable
    public final Object submitCode(@NotNull String str, @NotNull Continuation<? super SignInSubmitCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitCode(code: String)", new StringBuilder()));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64763(str, null), continuation);
    }
}
