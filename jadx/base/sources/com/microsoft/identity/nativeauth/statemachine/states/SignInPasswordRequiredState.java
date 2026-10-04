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
import com.microsoft.identity.common.java.nativeauth.commands.parameters.SignInSubmitPasswordCommandParameters;
import com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInCommandResult;
import com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult;
import com.microsoft.identity.common.java.nativeauth.util.CommandResultUtilKt;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.nativeauth.internal.commands.SignInSubmitPasswordCommand;
import com.microsoft.identity.common.nativeauth.internal.controllers.NativeAuthMsalController;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplication;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInErrorTypes;
import com.microsoft.identity.nativeauth.statemachine.errors.SignInSubmitPasswordError;
import com.microsoft.identity.nativeauth.statemachine.results.SignInResult;
import com.microsoft.identity.nativeauth.statemachine.results.SignInSubmitPasswordResult;
import com.microsoft.identity.nativeauth.statemachine.states.AccountState;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001f B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B-\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0016\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0014H\u0016R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\t\u001a\u00020\bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/BaseState;", "Lcom/microsoft/identity/nativeauth/statemachine/states/State;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "continuationToken", "", "correlationId", "scopes", "", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;)V", SearchConstants.TargetContents.TAG, "getContinuationToken$msal_distRelease", "()Ljava/lang/String;", "getCorrelationId$msal_distRelease", "describeContents", "", "submitPassword", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "password", "", "([CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState$SubmitPasswordCallback;", "writeToParcel", "flags", "CREATOR", "SubmitPasswordCallback", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SignInPasswordRequiredState extends BaseState implements State, Parcelable {

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

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<SignInPasswordRequiredState> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SignInPasswordRequiredState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignInPasswordRequiredState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SignInPasswordRequiredState[] newArray(int size) {
            return new SignInPasswordRequiredState[size];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/statemachine/states/SignInPasswordRequiredState$SubmitPasswordCallback;", "Lcom/microsoft/identity/nativeauth/statemachine/states/Callback;", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public interface SubmitPasswordCallback extends Callback<SignInSubmitPasswordResult> {
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$1", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {356}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubmitPasswordCallback $callback;
        final /* synthetic */ char[] $password;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64791(char[] cArr, SubmitPasswordCallback submitPasswordCallback, Continuation<? super C64791> continuation) {
            super(2, continuation);
            this.$password = cArr;
            this.$callback = submitPasswordCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInPasswordRequiredState.this.new C64791(this.$password, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SignInPasswordRequiredState signInPasswordRequiredState = SignInPasswordRequiredState.this;
                    char[] cArr = this.$password;
                    this.label = 1;
                    obj = signInPasswordRequiredState.submitPassword(cArr, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$callback.onResult((SignInSubmitPasswordResult) obj);
            } catch (MsalException e) {
                Logger.error(SignInPasswordRequiredState.this.TAG, "Exception thrown in submitPassword", e);
                this.$callback.onError(e);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C64791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Lcom/microsoft/identity/nativeauth/statemachine/results/SignInSubmitPasswordResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.microsoft.identity.nativeauth.statemachine.states.SignInPasswordRequiredState$submitPassword$3", m14021f = "SignInStates.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C64803 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SignInSubmitPasswordResult>, Object> {
        final /* synthetic */ char[] $password;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C64803(char[] cArr, Continuation<? super C64803> continuation) {
            super(2, continuation);
            this.$password = cArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return SignInPasswordRequiredState.this.new C64803(this.$password, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            INativeAuthCommandResult unknownError;
            INativeAuthCommandResult unknownError2;
            Object signInSubmitPasswordError;
            String message;
            Exception exc;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SignInSubmitPasswordCommandParameters params = CommandParametersAdapter.createSignInSubmitPasswordCommandParameters(SignInPasswordRequiredState.this.config, SignInPasswordRequiredState.this.config.getOAuth2TokenCache(), SignInPasswordRequiredState.this.getContinuationToken(), this.$password, SignInPasswordRequiredState.this.getCorrelationId(), SignInPasswordRequiredState.this.scopes);
            try {
                Intrinsics.checkNotNullExpressionValue(params, "params");
                CommandResult rawCommandResult = CommandDispatcher.submitSilentReturningFuture(new SignInSubmitPasswordCommand(params, new NativeAuthMsalController(), PublicApiId.NATIVE_AUTH_SIGN_IN_SUBMIT_PASSWORD)).get();
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
                            String str2 = "Type casting error: result of " + rawCommandResult + " is not of type " + Reflection.getOrCreateKotlinClass(SignInSubmitPasswordCommandResult.class) + ", but of type " + Reflection.getOrCreateKotlinClass(result2.getClass()) + ", even though the command was marked as COMPLETED";
                            String correlationId3 = rawCommandResult.getCorrelationId();
                            Intrinsics.checkNotNullExpressionValue(correlationId3, "this.correlationId");
                            unknownError = new INativeAuthCommandResult.UnknownError(CommandResultUtilKt.UNSUCCESSFUL_COMMAND_ERROR, str2, null, correlationId3, null, null, 52, null);
                        }
                        if (result2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.SignInSubmitPasswordCommandResult");
                        }
                        unknownError = (SignInSubmitPasswordCommandResult) result2;
                        unknownError2 = unknownError;
                    }
                }
                if (unknownError2 instanceof SignInCommandResult.InvalidCredentials) {
                    signInSubmitPasswordError = new SignInSubmitPasswordError(SignInErrorTypes.INVALID_CREDENTIALS, ((SignInCommandResult.InvalidCredentials) unknownError2).getError(), ((SignInCommandResult.InvalidCredentials) unknownError2).getErrorDescription(), unknownError2.getCorrelationId(), null, null, 48, null);
                } else if (unknownError2 instanceof SignInCommandResult.Complete) {
                    IAuthenticationResult authenticationResult = AuthenticationResultAdapter.adapt(((SignInCommandResult.Complete) unknownError2).getAuthenticationResult());
                    AccountState.Companion companion = AccountState.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(authenticationResult, "authenticationResult");
                    signInSubmitPasswordError = new SignInResult.Complete(companion.createFromAuthenticationResult(authenticationResult, unknownError2.getCorrelationId(), SignInPasswordRequiredState.this.config));
                } else {
                    if (!(unknownError2 instanceof INativeAuthCommandResult.Redirect ? true : unknownError2 instanceof INativeAuthCommandResult.UnknownError)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Logger.warnWithObject(SignInPasswordRequiredState.this.TAG, unknownError2.getCorrelationId(), "Submit password received unexpected result: ", unknownError2);
                    Intrinsics.checkNotNull(unknownError2, "null cannot be cast to non-null type com.microsoft.identity.common.java.nativeauth.controllers.results.INativeAuthCommandResult.Error");
                    signInSubmitPasswordError = new SignInSubmitPasswordError(null, ((INativeAuthCommandResult.Error) unknownError2).getError(), ((INativeAuthCommandResult.Error) unknownError2).getErrorDescription(), ((INativeAuthCommandResult.Error) unknownError2).getCorrelationId(), ((INativeAuthCommandResult.Error) unknownError2).getErrorCodes(), ((INativeAuthCommandResult.UnknownError) unknownError2).getException(), 1, null);
                }
                StringUtil.overwriteWithNull(params.password);
                return signInSubmitPasswordError;
            } catch (Throwable th) {
                StringUtil.overwriteWithNull(params.password);
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SignInSubmitPasswordResult> continuation) {
            return ((C64803) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignInPasswordRequiredState(@NotNull String continuationToken, @NotNull String correlationId, @Nullable List<String> list, @NotNull NativeAuthPublicClientApplicationConfiguration config) {
        super(continuationToken, correlationId);
        Intrinsics.checkNotNullParameter(continuationToken, "continuationToken");
        Intrinsics.checkNotNullParameter(correlationId, "correlationId");
        Intrinsics.checkNotNullParameter(config, "config");
        this.continuationToken = continuationToken;
        this.correlationId = correlationId;
        this.scopes = list;
        this.config = config;
        Intrinsics.checkNotNullExpressionValue("SignInPasswordRequiredState", "SignInPasswordRequiredState::class.java.simpleName");
        this.TAG = "SignInPasswordRequiredState";
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
        BuildersKt__Builders_commonKt.launch$default(NativeAuthPublicClientApplication.INSTANCE.getPcaScope(), null, null, new C64791(password, callback, null), 3, null);
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
    public SignInPasswordRequiredState(@NotNull Parcel parcel) {
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
    public final Object submitPassword(@NotNull char[] cArr, @NotNull Continuation<? super SignInSubmitPasswordResult> continuation) {
        LogSession.INSTANCE.logMethodCall(this.TAG, getCorrelationId(), AbstractC0622a.m1170p(this.TAG, ".submitPassword(password: CharArray)", new StringBuilder()));
        return BuildersKt.withContext(Dispatchers.getIO(), new C64803(cArr, null), continuation);
    }
}
