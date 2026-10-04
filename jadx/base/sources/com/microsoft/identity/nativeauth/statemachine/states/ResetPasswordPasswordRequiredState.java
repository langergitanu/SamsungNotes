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
import com.microsoft.identity.common.java.eststelemetry.PublicApiId;
import com.microsoft.identity.common.java.logging.LogSession;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.commands.parameters.ResetPasswordSubmitNewPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitNewPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.ErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResetPasswordErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.ResetPasswordSubmitPasswordError;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordResult;
import com.microsoft.identity.nativeauth.statemachine.results.ResetPasswordSubmitPasswordResult;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.Serializable;
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
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0013H\u0016R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "username", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", SearchConstants.TargetContents.TAG, "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "submitPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitPasswordResult;", "password", "", "([CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState$SubmitPasswordCallback;", "writeToParcel", "flags", "CREATOR", "SubmitPasswordCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ResetPasswordPasswordRequiredState extends BaseState implements State, Parcelable {

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

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordPasswordRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<ResetPasswordPasswordRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ResetPasswordPasswordRequiredState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ResetPasswordPasswordRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ResetPasswordPasswordRequiredState[] newArray(int size) {
            return new ResetPasswordPasswordRequiredState[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/ResetPasswordPasswordRequiredState$SubmitPasswordCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitPasswordResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SubmitPasswordCallback extends Callback<ResetPasswordSubmitPasswordResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordPasswordRequiredState$submitPassword$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordPasswordRequiredState$submitPassword$1", m14021f = "ResetPasswordStates.kt", m14022i = {}, m14023l = {342}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitPasswordCallback $callback;
        final /* synthetic */ char[] $password;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64711(char[] cArr, SubmitPasswordCallback submitPasswordCallback, Continuation<? super C64711> continuation) {
            super(2, continuation);
            this.$password = cArr;
            this.$callback = submitPasswordCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ResetPasswordPasswordRequiredState.this.new C64711(this.$password, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ResetPasswordPasswordRequiredState resetPasswordPasswordRequiredState = ResetPasswordPasswordRequiredState.this;
                    char[] cArr = this.$password;
                    this.label = 1;
                    obj = resetPasswordPasswordRequiredState.submitPassword(cArr, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((ResetPasswordSubmitPasswordResult) obj);
            } catch (MsalException e) {
                Logger.error(ResetPasswordPasswordRequiredState.this.TAG, "Exception thrown in submitPassword", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordPasswordRequiredState$submitPassword$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/ResetPasswordSubmitPasswordResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.ResetPasswordPasswordRequiredState$submitPassword$3", m14021f = "ResetPasswordStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64723 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ResetPasswordSubmitPasswordResult>, Object> {
        final /* synthetic */ char[] $password;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64723(char[] cArr, Continuation<? super C64723> continuation) {
            super(2, continuation);
            this.$password = cArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return ResetPasswordPasswordRequiredState.this.new C64723(this.$password, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            INativeAuthCommandResult unknownError;
            INativeAuthCommandResult unknownError2;
            ResetPasswordSubmitPasswordError resetPasswordSubmitPasswordError;
            Object complete;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ResetPasswordSubmitNewPasswordCommandParameters parameters = CommandParametersAdapter.createResetPasswordSubmitNewPasswordCommandParameters(ResetPasswordPasswordRequiredState.this.config, ResetPasswordPasswordRequiredState.this.config.getOAuth2TokenCache(), ResetPasswordPasswordRequiredState.this.getContinuationToken(), ResetPasswordPasswordRequiredState.this.getCorrelationId(), this.$password);
            Intrinsics.checkNotNullExpressionValue(parameters, "parameters");
            try {
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new ResetPasswordSubmitNewPasswordCommand(parameters, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_RESET_PASSWORD_SUBMIT_NEW_PASSWORD)).get();
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
                            String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(ResetPasswordSubmitNewPasswordCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                        }
                        if (result2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.ResetPasswordSubmitNewPasswordCommandResult");
                        }
                        unknownError = (ResetPasswordSubmitNewPasswordCommandResult) result2;
                        unknownError2 = unknownError;
                    }
                }
                if (unknownError2 instanceof ResetPasswordCommandResult.Complete) {
                    complete = new ResetPasswordResult.Complete(new SignInContinuationState(((ResetPasswordCommandResult.Complete) unknownError2).getContinuationToken(), unknownError2.getCorrelationId(), ResetPasswordPasswordRequiredState.this.username, ResetPasswordPasswordRequiredState.this.config));
                } else {
                    if (unknownError2 instanceof ResetPasswordCommandResult.PasswordNotAccepted) {
                        resetPasswordSubmitPasswordError = new ResetPasswordSubmitPasswordError(ErrorTypes.INVALID_PASSWORD, ((ResetPasswordCommandResult.PasswordNotAccepted) unknownError2).getError(), ((ResetPasswordCommandResult.PasswordNotAccepted) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), null, ((ResetPasswordCommandResult.PasswordNotAccepted) unknownError2).getSubError(), null, 80, null);
                    } else if (unknownError2 instanceof ResetPasswordCommandResult.PasswordResetFailed) {
                        resetPasswordSubmitPasswordError = new ResetPasswordSubmitPasswordError(ResetPasswordErrorTypes.PASSWORD_RESET_FAILED, ((ResetPasswordCommandResult.PasswordResetFailed) unknownError2).getError(), ((ResetPasswordCommandResult.PasswordResetFailed) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), null, null, null, 112, null);
                    } else if (unknownError2 instanceof ResetPasswordCommandResult.UserNotFound) {
                        Logger.warnWithObject(ResetPasswordPasswordRequiredState.this.TAG, unknownError2.getCorrelationId(), "Submit password received unexpected result: ", unknownError2);
                        resetPasswordSubmitPasswordError = new ResetPasswordSubmitPasswordError(null, ((ResetPasswordCommandResult.UserNotFound) unknownError2).getError(), ((ResetPasswordCommandResult.UserNotFound) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), null, null, null, 113, null);
                    } else {
                        if (!(unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Logger.warnWithObject(ResetPasswordPasswordRequiredState.this.TAG, unknownError2.getCorrelationId(), "Submit password received unexpected result: ", unknownError2);
                        resetPasswordSubmitPasswordError = new ResetPasswordSubmitPasswordError(null, ((INativeAuthCommandResult.UnknownError) unknownError2).getError(), ((INativeAuthCommandResult.UnknownError) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), null, null, ((INativeAuthCommandResult.UnknownError) unknownError2).getException(), 49, null);
                    }
                    complete = resetPasswordSubmitPasswordError;
                }
                return complete;
            } finally {
                StringUtil.overwriteWithNull(parameters.newPassword);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ResetPasswordSubmitPasswordResult> continuation) {
            return ((C64723) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPasswordPasswordRequiredState(@NotNull String continuationToken, @NotNull String correlationId, @NotNull String username, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.username = username;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("ResetPasswordPasswordRequiredState", "ResetPasswordPasswordReq…te::class.java.simpleName");
        this.TAG = "ResetPasswordPasswordRequiredState";
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

    public final void submitPassword(@NotNull char[] password, @NotNull SubmitPasswordCallback callback) {
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitPassword", new StringBuilder()));
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64711(password, callback, null), 3, null);
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
    public ResetPasswordPasswordRequiredState(@NotNull Parcel parcel) {
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
    public final Object submitPassword(@NotNull char[] cArr, @NotNull Continuation<? super ResetPasswordSubmitPasswordResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitPassword(password: CharArray)", new StringBuilder()));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64723(cArr, null), continuation);
    }
}
