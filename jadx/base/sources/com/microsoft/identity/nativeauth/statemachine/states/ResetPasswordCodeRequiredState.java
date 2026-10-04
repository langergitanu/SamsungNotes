package com.microsoft.identity.nativeauth.statemachine.states;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.CommandParametersAdapter;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.controllers.CommandDispatcher;
import com.microsoft.identity.common.java.controllers.CommandResult;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordResendCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitCodeCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordResendCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordResendCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitCodeCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResendCodeError;
import com.microsoft.identity.nativeauth.statemachine.errors.SubmitCodeError;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordResendCodeResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordSubmitCodeResult;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.Serializable;
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
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003!\"#B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0013H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", SearchConstants.TargetContents.TAG, "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "resendCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$ResendCodeCallback;", "submitCode", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "code", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$SubmitCodeCallback;", "writeToParcel", "flags", "CREATOR", "ResendCodeCallback", "SubmitCodeCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordCodeRequiredState extends BaseState implements State, Parcelable {

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

    @NotNull
    private final String username;

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<ResetPasswordCodeRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ResetPasswordCodeRequiredState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ResetPasswordCodeRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ResetPasswordCodeRequiredState[] newArray(int size) {
            return new ResetPasswordCodeRequiredState[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$ResendCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface ResendCodeCallback extends Callback<ResetPasswordResendCodeResult> {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordCodeRequiredState$SubmitCodeCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SubmitCodeCallback extends Callback<ResetPasswordSubmitCodeResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$1", m14021f = "ResetPasswordStates.kt", m14022i = {}, m14023l = {JPEG.RST0}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResendCodeCallback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64671(ResendCodeCallback resendCodeCallback, Continuation<? super C64671> continuation) {
            super(2, continuation);
            this.$callback = resendCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new C64671(this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ResetPasswordCodeRequiredState resetPasswordCodeRequiredState = ResetPasswordCodeRequiredState.this;
                    this.label = 1;
                    obj = resetPasswordCodeRequiredState.resendCode(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordResendCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(ResetPasswordCodeRequiredState.this.TAG, "Exception thrown in resendCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordResendCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$resendCode$3", m14021f = "ResetPasswordStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64683 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordResendCodeResult>, Object> {
        int label;

        public C64683(Continuation<? super C64683> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new C64683(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException {
            ResetPasswordResendCodeCommandResult unknownError;
            ResetPasswordResendCodeCommandResult unknownError2;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ResetPasswordResendCodeCommandParameters parameters = CommandParametersAdapter.createResetPasswordResendCodeCommandParameters(ResetPasswordCodeRequiredState.this.config, ResetPasswordCodeRequiredState.this.config.getOAuth2TokenCache(), ResetPasswordCodeRequiredState.this.getCorrelationId(), ResetPasswordCodeRequiredState.this.getContinuationToken());
            Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
            CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordResendCodeCommand(parameters, new NativeAuthMsalController(), "222")).get();
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
                        String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordResendCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                    }
                    if (result2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordResendCodeCommandResult");
                    }
                    unknownError = (ResetPasswordResendCodeCommandResult) result2;
                    unknownError2 = unknownError;
                }
            }
            if (unknownError2 instanceof ResetPasswordCommandResult.CodeRequired) {
                ResetPasswordCommandResult.CodeRequired codeRequired = (ResetPasswordCommandResult.CodeRequired) unknownError2;
                return new ResetPasswordResendCodeResult.Success(new ResetPasswordCodeRequiredState(codeRequired.getContinuationToken(), unknownError2.getCorrelationId(), ResetPasswordCodeRequiredState.this.username, ResetPasswordCodeRequiredState.this.config), codeRequired.getCodeLength(), codeRequired.getChallengeTargetLabel(), codeRequired.getChallengeChannel());
            }
            if (!(unknownError2 instanceof INativeAuthCommandResult.Redirect ? true : unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                throw new NoWhenBranchMatchedException();
            }
            Logger.warnWithObject(ResetPasswordCodeRequiredState.this.TAG, unknownError2.getCorrelationId(), "Resend code received unexpected result: ", unknownError2);
            Intrinsics.checkNotNull(unknownError2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error");
            INativeAuthCommandResult.Error error = (INativeAuthCommandResult.Error) unknownError2;
            return new ResendCodeError(null, error.getError(), error.getErrorDescription(), error.getCorrelationId(), error.getErrorCodes(), unknownError2 instanceof INativeAuthCommandResult.UnknownError ? ((INativeAuthCommandResult.UnknownError) unknownError2).getException() : null, 1, null);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ResetPasswordResendCodeResult> continuation) {
            return ((C64683) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$1", m14021f = "ResetPasswordStates.kt", m14022i = {}, m14023l = {101}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitCodeCallback $callback;
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64691(String str, SubmitCodeCallback submitCodeCallback, Continuation<? super C64691> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$callback = submitCodeCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new C64691(this.$code, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ResetPasswordCodeRequiredState resetPasswordCodeRequiredState = ResetPasswordCodeRequiredState.this;
                    String str = this.$code;
                    this.label = 1;
                    obj = resetPasswordCodeRequiredState.submitCode(str, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordSubmitCodeResult) obj);
            } catch (MsalException e) {
                Logger.error(ResetPasswordCodeRequiredState.this.TAG, "Exception thrown in submitCode", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitCodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordCodeRequiredState$submitCode$3", m14021f = "ResetPasswordStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64703 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordSubmitCodeResult>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64703(String str, Continuation<? super C64703> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ResetPasswordCodeRequiredState.this.new C64703(this.$code, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws ExecutionException, InterruptedException {
            ResetPasswordSubmitCodeCommandResult unknownError;
            ResetPasswordSubmitCodeCommandResult unknownError2;
            SubmitCodeError submitCodeError;
            Exception exc;
            String message;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ResetPasswordSubmitCodeCommandParameters parameters = CommandParametersAdapter.createResetPasswordSubmitCodeCommandParameters(ResetPasswordCodeRequiredState.this.config, ResetPasswordCodeRequiredState.this.config.getOAuth2TokenCache(), this.$code, ResetPasswordCodeRequiredState.this.getCorrelationId(), ResetPasswordCodeRequiredState.this.getContinuationToken());
            Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
            CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordSubmitCodeCommand(parameters, new NativeAuthMsalController(), "221")).get();
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
                        String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordSubmitCodeCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                        String correlationId3 = rawCommandResult.getCorrelationId();
                        Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                        unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                    }
                    if (result2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitCodeCommandResult");
                    }
                    unknownError = (ResetPasswordSubmitCodeCommandResult) result2;
                    unknownError2 = unknownError;
                }
            }
            if (unknownError2 instanceof ResetPasswordCommandResult.PasswordRequired) {
                return new ResetPasswordSubmitCodeResult.PasswordRequired(new ResetPasswordPasswordRequiredState(((ResetPasswordCommandResult.PasswordRequired) unknownError2).getContinuationToken(), unknownError2.getCorrelationId(), ResetPasswordCodeRequiredState.this.username, ResetPasswordCodeRequiredState.this.config));
            }
            if (unknownError2 instanceof ResetPasswordCommandResult.IncorrectCode) {
                ResetPasswordCommandResult.IncorrectCode incorrectCode = (ResetPasswordCommandResult.IncorrectCode) unknownError2;
                submitCodeError = new SubmitCodeError(ErrorTypes.INVALID_CODE, incorrectCode.getError(), incorrectCode.getErrorDescription(), unknownError2.getCorrelationId(), null, incorrectCode.getSubError(), null, 80, null);
            } else if (unknownError2 instanceof INativeAuthCommandResult.Redirect) {
                INativeAuthCommandResult.Redirect redirect = (INativeAuthCommandResult.Redirect) unknownError2;
                submitCodeError = new SubmitCodeError(ErrorTypes.BROWSER_REQUIRED, redirect.getError(), redirect.getErrorDescription(), unknownError2.getCorrelationId(), null, null, null, 112, null);
            } else {
                if (!(unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                    throw new NoWhenBranchMatchedException();
                }
                Logger.warnWithObject(ResetPasswordCodeRequiredState.this.TAG, unknownError2.getCorrelationId(), "Submit code received unexpected result: ", unknownError2);
                INativeAuthCommandResult.UnknownError unknownError3 = (INativeAuthCommandResult.UnknownError) unknownError2;
                submitCodeError = new SubmitCodeError(null, unknownError3.getError(), unknownError3.getErrorDescription(), unknownError2.getCorrelationId(), null, null, unknownError3.getException(), 49, null);
            }
            return submitCodeError;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ResetPasswordSubmitCodeResult> continuation) {
            return ((C64703) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordCodeRequiredState(@NotNull String continuationToken, @NotNull String correlationId, @NotNull String username, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("ResetPasswordCodeRequiredState", "ResetPasswordCodeRequire…te::class.java.simpleName");
        this.TAG = "ResetPasswordCodeRequiredState";
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
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".resendCode(callback: ResendCodeCallback)", new StringBuilder()));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64671(callback, null), 3, null);
    }

    public final void submitCode(@NotNull String code, @NotNull SubmitCodeCallback callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitCode", new StringBuilder()));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64691(code, callback, null), 3, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(getContinuationToken());
        parcel.writeString(getCorrelationId());
        parcel.writeString(this.username);
        parcel.writeSerializable(this.config);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ResetPasswordCodeRequiredState(@NotNull Parcel parcel) {
        Object obj;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? TelemetryEventStrings.Value.UNSET : string2;
        String string3 = parcel.readString();
        String str = string3 != null ? string3 : "";
        if (Build.VERSION.SDK_INT >= 33) {
            obj = (Serializable) parcel.readSerializable(NativeAuthPublicClientApplicationConfiguration.class.getClassLoader(), NativeAuthPublicClientApplicationConfiguration.class);
        } else {
            Serializable serializable = parcel.readSerializable();
            obj = (NativeAuthPublicClientApplicationConfiguration) (serializable instanceof NativeAuthPublicClientApplicationConfiguration ? serializable : null);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration");
        this(string, string2, str, (NativeAuthPublicClientApplicationConfiguration) obj);
    }

    @Nullable
    public final Object resendCode(@NotNull Continuation<? super ResetPasswordResendCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".resendCode", new StringBuilder()));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64683(null), continuation);
    }

    @Nullable
    public final Object submitCode(@NotNull String str, @NotNull Continuation<? super ResetPasswordSubmitCodeResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitCode(code: String)", new StringBuilder()));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64703(str, null), continuation);
    }
}
