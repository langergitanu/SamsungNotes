package androidx.credentials.provider;

import android.os.CancellationSignal;
import android.p108os.OutcomeReceiver;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.AbstractC2513b;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import androidx.credentials.provider.utils.ClearCredentialUtil;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"J,\u0010%\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0\"H&J*\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0\"J,\u0010,\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\"H&J*\u0010/\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u0002002\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\"J.\u00103\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0004\u0012\u0002040\"H&R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\t8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f8G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00158G@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00065"}, m13886d2 = {"Landroidx/credentials/provider/CredentialProviderService;", "Landroid/service/credentials/CredentialProviderService;", "()V", "<set-?>", "", "isTestMode", "()Z", "setTestMode", "(Z)V", "Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "lastClearRequest", "getLastClearRequest", "()Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "setLastClearRequest", "(Landroidx/credentials/provider/ProviderClearCredentialStateRequest;)V", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "lastCreateRequest", "getLastCreateRequest", "()Landroidx/credentials/provider/BeginCreateCredentialRequest;", "setLastCreateRequest", "(Landroidx/credentials/provider/BeginCreateCredentialRequest;)V", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "lastGetRequest", "getLastGetRequest", "()Landroidx/credentials/provider/BeginGetCredentialRequest;", "setLastGetRequest", "(Landroidx/credentials/provider/BeginGetCredentialRequest;)V", "onBeginCreateCredential", "", "request", "Landroid/service/credentials/BeginCreateCredentialRequest;", "cancellationSignal", "Landroid/os/CancellationSignal;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/os/OutcomeReceiver;", "Landroid/service/credentials/BeginCreateCredentialResponse;", "Landroid/credentials/CreateCredentialException;", "onBeginCreateCredentialRequest", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "Landroidx/credentials/exceptions/CreateCredentialException;", "onBeginGetCredential", "Landroid/service/credentials/BeginGetCredentialRequest;", "Landroid/service/credentials/BeginGetCredentialResponse;", "Landroid/credentials/GetCredentialException;", "onBeginGetCredentialRequest", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "Landroidx/credentials/exceptions/GetCredentialException;", "onClearCredentialState", "Landroid/service/credentials/ClearCredentialStateRequest;", "Ljava/lang/Void;", "Landroid/credentials/ClearCredentialStateException;", "onClearCredentialStateRequest", "Landroidx/credentials/exceptions/ClearCredentialException;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class CredentialProviderService extends android.service.credentials.CredentialProviderService {
    private boolean isTestMode;

    @Nullable
    private ProviderClearCredentialStateRequest lastClearRequest;

    @Nullable
    private BeginCreateCredentialRequest lastCreateRequest;

    @Nullable
    private BeginGetCredentialRequest lastGetRequest;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    @Nullable
    public final ProviderClearCredentialStateRequest getLastClearRequest() {
        return this.lastClearRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    @Nullable
    public final BeginCreateCredentialRequest getLastCreateRequest() {
        return this.lastCreateRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    @Nullable
    public final BeginGetCredentialRequest getLastGetRequest() {
        return this.lastGetRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    /* JADX INFO: renamed from: isTestMode, reason: from getter */
    public final boolean getIsTestMode() {
        return this.isTestMode;
    }

    public final void onBeginCreateCredential(@NotNull android.service.credentials.BeginCreateCredentialRequest request, @NotNull CancellationSignal cancellationSignal, @NotNull final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.provider.CredentialProviderService$onBeginCreateCredential$outcome$1
            public void onError(@NotNull CreateCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OutcomeReceiver outcomeReceiver2 = callback;
                AbstractC2513b.m1987q();
                outcomeReceiver2.onError(AbstractC2513b.m1973c(error.getType(), error.getMessage()));
            }

            public void onResult(@NotNull BeginCreateCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onResult(BeginCreateCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
            }
        };
        BeginCreateCredentialRequest beginCreateCredentialRequestConvertToJetpackRequest$credentials_release = BeginCreateCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(request);
        if (this.isTestMode) {
            this.lastCreateRequest = beginCreateCredentialRequestConvertToJetpackRequest$credentials_release;
        }
        onBeginCreateCredentialRequest(beginCreateCredentialRequestConvertToJetpackRequest$credentials_release, cancellationSignal, outcomeReceiver);
    }

    public abstract void onBeginCreateCredentialRequest(@NotNull BeginCreateCredentialRequest request, @NotNull CancellationSignal cancellationSignal, @NotNull OutcomeReceiver callback);

    public final void onBeginGetCredential(@NotNull android.service.credentials.BeginGetCredentialRequest request, @NotNull CancellationSignal cancellationSignal, @NotNull final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BeginGetCredentialRequest beginGetCredentialRequestConvertToJetpackRequest$credentials_release = BeginGetCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(request);
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.provider.CredentialProviderService$onBeginGetCredential$outcome$1
            public void onError(@NotNull GetCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OutcomeReceiver outcomeReceiver2 = callback;
                AbstractC2513b.m1991u();
                outcomeReceiver2.onError(AbstractC2513b.m1977g(error.getType(), error.getMessage()));
            }

            public void onResult(@NotNull BeginGetCredentialResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                callback.onResult(BeginGetCredentialUtil.INSTANCE.convertToFrameworkResponse(response));
            }
        };
        if (this.isTestMode) {
            this.lastGetRequest = beginGetCredentialRequestConvertToJetpackRequest$credentials_release;
        }
        onBeginGetCredentialRequest(beginGetCredentialRequestConvertToJetpackRequest$credentials_release, cancellationSignal, outcomeReceiver);
    }

    public abstract void onBeginGetCredentialRequest(@NotNull BeginGetCredentialRequest request, @NotNull CancellationSignal cancellationSignal, @NotNull OutcomeReceiver callback);

    public final void onClearCredentialState(@NotNull ClearCredentialStateRequest request, @NotNull CancellationSignal cancellationSignal, @NotNull final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        OutcomeReceiver outcomeReceiver = new OutcomeReceiver() { // from class: androidx.credentials.provider.CredentialProviderService$onClearCredentialState$outcome$1
            public void onError(@NotNull ClearCredentialException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                OutcomeReceiver outcomeReceiver2 = callback;
                AbstractC2513b.m1994x();
                outcomeReceiver2.onError(AbstractC2513b.m1971a(error.getType(), error.getMessage()));
            }

            public void onResult(@Nullable Void response) {
                callback.onResult(response);
            }
        };
        ProviderClearCredentialStateRequest providerClearCredentialStateRequestConvertToJetpackRequest$credentials_release = ClearCredentialUtil.INSTANCE.convertToJetpackRequest$credentials_release(request);
        if (this.isTestMode) {
            this.lastClearRequest = providerClearCredentialStateRequestConvertToJetpackRequest$credentials_release;
        }
        onClearCredentialStateRequest(providerClearCredentialStateRequestConvertToJetpackRequest$credentials_release, cancellationSignal, outcomeReceiver);
    }

    public abstract void onClearCredentialStateRequest(@NotNull ProviderClearCredentialStateRequest request, @NotNull CancellationSignal cancellationSignal, @NotNull OutcomeReceiver callback);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final void setLastClearRequest(@Nullable ProviderClearCredentialStateRequest providerClearCredentialStateRequest) {
        this.lastClearRequest = providerClearCredentialStateRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final void setLastCreateRequest(@Nullable BeginCreateCredentialRequest beginCreateCredentialRequest) {
        this.lastCreateRequest = beginCreateCredentialRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final void setLastGetRequest(@Nullable BeginGetCredentialRequest beginGetCredentialRequest) {
        this.lastGetRequest = beginGetCredentialRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public final void setTestMode(boolean z) {
        this.isTestMode = z;
    }
}
