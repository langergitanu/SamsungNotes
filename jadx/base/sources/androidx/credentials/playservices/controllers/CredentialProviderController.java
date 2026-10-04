package androidx.credentials.playservices.controllers;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u0000  *\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u0002*\b\b\u0003\u0010\u0005*\u00020\u0002*\b\b\u0004\u0010\u0006*\u00020\u00022\u00020\u0007:\u0001 B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0000H$¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00028\u00032\u0006\u0010\u000f\u001a\u00028\u0002H$¢\u0006\u0002\u0010\rJ;\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0018JT\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00028\u00040\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0004R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Landroidx/credentials/playservices/controllers/CredentialProviderController;", "T1", "", "T2", "R2", "R1", "E1", "Landroidx/credentials/playservices/controllers/CredentialProviderBaseController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "convertRequestToPlayServices", "request", "(Ljava/lang/Object;)Ljava/lang/Object;", "convertResponseToCredentialManager", "response", "invokePlayServices", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroidx/credentials/CredentialManagerCallback;", "executor", "Ljava/util/concurrent/Executor;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/Object;Landroidx/credentials/CredentialManagerCallback;Ljava/util/concurrent/Executor;Landroid/os/CancellationSignal;)V", "maybeReportErrorFromResultReceiver", "", "resultData", "Landroid/os/Bundle;", "conversionFn", "Lkotlin/Function2;", "", "Companion", "credentials-play-services-auth_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class CredentialProviderController<T1, T2, R2, R1, E1> extends CredentialProviderBaseController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String ERROR_MESSAGE_START_ACTIVITY_FAILED = "Failed to launch the selector UI. Hint: ensure the `context` parameter is an Activity-based context.";

    @NotNull
    private final Context context;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0005J\r\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010JP\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2 \u0010\u0013\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0005JP\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2 \u0010\u0013\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00060\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Landroidx/credentials/playservices/controllers/CredentialProviderController$Companion;", "", "()V", "ERROR_MESSAGE_START_ACTIVITY_FAILED", "", "cancelOrCallbackExceptionOrResult", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "onResultOrException", "Lkotlin/Function0;", "generateErrorStringCanceled", "generateErrorStringCanceled$credentials_play_services_auth_release", "generateErrorStringUnknown", "resultCode", "", "generateErrorStringUnknown$credentials_play_services_auth_release", "maybeReportErrorResultCodeCreate", "", "cancelOnError", "Lkotlin/Function2;", "onError", "Lkotlin/Function1;", "Landroidx/credentials/exceptions/CreateCredentialException;", "maybeReportErrorResultCodeGet", "Landroidx/credentials/exceptions/GetCredentialException;", "credentials-play-services-auth_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void cancelOrCallbackExceptionOrResult(@Nullable CancellationSignal cancellationSignal, @NotNull Function0<Unit> onResultOrException) {
            Intrinsics.checkNotNullParameter(onResultOrException, "onResultOrException");
            if (CredentialProviderPlayServicesImpl.INSTANCE.cancellationReviewer$credentials_play_services_auth_release(cancellationSignal)) {
                return;
            }
            onResultOrException.invoke();
        }

        @NotNull
        /* JADX INFO: renamed from: generateErrorStringCanceled$credentials_play_services_auth_release */
        public final String m2018x576fb150() {
            return "activity is cancelled by the user.";
        }

        @NotNull
        /* JADX INFO: renamed from: generateErrorStringUnknown$credentials_play_services_auth_release */
        public final String m2019x14b42947(int resultCode) {
            return AbstractC0541b.m767i(resultCode, "activity with result code: ", " indicating not RESULT_OK");
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.credentials.exceptions.CreateCredentialUnknownException] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, androidx.credentials.exceptions.CreateCredentialCancellationException] */
        @JvmStatic
        public final boolean maybeReportErrorResultCodeCreate(int resultCode, @NotNull Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> cancelOnError, @NotNull final Function1<? super CreateCredentialException, Unit> onError, @Nullable CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(cancelOnError, "cancelOnError");
            Intrinsics.checkNotNullParameter(onError, "onError");
            if (resultCode == -1) {
                return false;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new CreateCredentialUnknownException(m2019x14b42947(resultCode));
            if (resultCode == 0) {
                objectRef.element = new CreateCredentialCancellationException(m2018x576fb150());
            }
            cancelOnError.invoke(cancellationSignal, new Function0<Unit>() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$Companion$maybeReportErrorResultCodeCreate$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onError.invoke(objectRef.element);
                }
            });
            return true;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.credentials.exceptions.GetCredentialUnknownException] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, androidx.credentials.exceptions.GetCredentialCancellationException] */
        @JvmStatic
        public final boolean maybeReportErrorResultCodeGet(int resultCode, @NotNull Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> cancelOnError, @NotNull final Function1<? super GetCredentialException, Unit> onError, @Nullable CancellationSignal cancellationSignal) {
            Intrinsics.checkNotNullParameter(cancelOnError, "cancelOnError");
            Intrinsics.checkNotNullParameter(onError, "onError");
            if (resultCode == -1) {
                return false;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new GetCredentialUnknownException(m2019x14b42947(resultCode));
            if (resultCode == 0) {
                objectRef.element = new GetCredentialCancellationException(m2018x576fb150());
            }
            cancelOnError.invoke(cancellationSignal, new Function0<Unit>() { // from class: androidx.credentials.playservices.controllers.CredentialProviderController$Companion$maybeReportErrorResultCodeGet$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    onError.invoke(objectRef.element);
                }
            });
            return true;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CredentialProviderController$maybeReportErrorFromResultReceiver$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u0007*\u00020\u0003H\n¢\u0006\u0002\b\b"}, m13886d2 = {"<anonymous>", "", "T1", "", "T2", "R2", "R1", "E1", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class C25451 extends Lambda implements Function0<Unit> {
        final /* synthetic */ CredentialManagerCallback<R1, E1> $callback;
        final /* synthetic */ E1 $exception;
        final /* synthetic */ Executor $executor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C25451(Executor executor, CredentialManagerCallback<R1, E1> credentialManagerCallback, E1 e12) {
            super(0);
            this.$executor = executor;
            this.$callback = credentialManagerCallback;
            this.$exception = e12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(CredentialManagerCallback callback, Object exception) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(exception, "$exception");
            callback.onError(exception);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Executor executor = this.$executor;
            final CredentialManagerCallback<R1, E1> credentialManagerCallback = this.$callback;
            final E1 e12 = this.$exception;
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.controllers.a
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderController.C25451.invoke$lambda$0(credentialManagerCallback, e12);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderController(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @JvmStatic
    public static final void cancelOrCallbackExceptionOrResult(@Nullable CancellationSignal cancellationSignal, @NotNull Function0<Unit> function0) {
        INSTANCE.cancelOrCallbackExceptionOrResult(cancellationSignal, function0);
    }

    @JvmStatic
    public static final boolean maybeReportErrorResultCodeCreate(int i, @NotNull Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, @NotNull Function1<? super CreateCredentialException, Unit> function1, @Nullable CancellationSignal cancellationSignal) {
        return INSTANCE.maybeReportErrorResultCodeCreate(i, function2, function1, cancellationSignal);
    }

    @JvmStatic
    public static final boolean maybeReportErrorResultCodeGet(int i, @NotNull Function2<? super CancellationSignal, ? super Function0<Unit>, Unit> function2, @NotNull Function1<? super GetCredentialException, Unit> function1, @Nullable CancellationSignal cancellationSignal) {
        return INSTANCE.maybeReportErrorResultCodeGet(i, function2, function1, cancellationSignal);
    }

    @NotNull
    public abstract T2 convertRequestToPlayServices(@NotNull T1 request);

    @NotNull
    public abstract R1 convertResponseToCredentialManager(@NotNull R2 response);

    public abstract void invokePlayServices(@NotNull T1 request, @NotNull CredentialManagerCallback<R1, E1> callback, @NotNull Executor executor, @Nullable CancellationSignal cancellationSignal);

    public final boolean maybeReportErrorFromResultReceiver(@NotNull Bundle resultData, @NotNull Function2<? super String, ? super String, ? extends E1> conversionFn, @NotNull Executor executor, @NotNull CredentialManagerCallback<R1, E1> callback, @Nullable CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        Intrinsics.checkNotNullParameter(conversionFn, "conversionFn");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!resultData.getBoolean(CredentialProviderBaseController.FAILURE_RESPONSE_TAG)) {
            return false;
        }
        cancelOrCallbackExceptionOrResult(cancellationSignal, new C25451(executor, callback, conversionFn.invoke(resultData.getString(CredentialProviderBaseController.EXCEPTION_TYPE_TAG), resultData.getString(CredentialProviderBaseController.EXCEPTION_MESSAGE_TAG))));
        return true;
    }
}
