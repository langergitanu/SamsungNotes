package androidx.credentials.playservices;

import android.util.Log;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m13886d2 = {"<anonymous>", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CredentialProviderPlayServicesImpl$onClearCredential$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CredentialManagerCallback<Void, ClearCredentialException> $callback;

    /* JADX INFO: renamed from: $e */
    final /* synthetic */ Exception f1382$e;
    final /* synthetic */ Executor $executor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderPlayServicesImpl$onClearCredential$2$1$1(Exception exc, Executor executor, CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback) {
        super(0);
        this.f1382$e = exc;
        this.$executor = executor;
        this.$callback = credentialManagerCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(CredentialManagerCallback callback, Exception e) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(e, "$e");
        callback.onError(new ClearCredentialUnknownException(e.getMessage()));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Log.w("PlayServicesImpl", "During clear credential sign out failed with " + this.f1382$e);
        Executor executor = this.$executor;
        final CredentialManagerCallback<Void, ClearCredentialException> credentialManagerCallback = this.$callback;
        final Exception exc = this.f1382$e;
        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.d
            @Override // java.lang.Runnable
            public final void run() {
                CredentialProviderPlayServicesImpl$onClearCredential$2$1$1.invoke$lambda$0(credentialManagerCallback, exc);
            }
        });
    }
}
