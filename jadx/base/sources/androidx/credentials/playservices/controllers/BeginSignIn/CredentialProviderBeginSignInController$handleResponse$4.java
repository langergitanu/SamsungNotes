package androidx.credentials.playservices.controllers.BeginSignIn;

import androidx.credentials.exceptions.GetCredentialException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m13886d2 = {"<anonymous>", "", "invoke"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CredentialProviderBeginSignInController$handleResponse$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<GetCredentialException> $exception;
    final /* synthetic */ CredentialProviderBeginSignInController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderBeginSignInController$handleResponse$4(CredentialProviderBeginSignInController credentialProviderBeginSignInController, Ref.ObjectRef<GetCredentialException> objectRef) {
        super(0);
        this.this$0 = credentialProviderBeginSignInController;
        this.$exception = objectRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void invoke$lambda$0(CredentialProviderBeginSignInController this$0, Ref.ObjectRef exception) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(exception, "$exception");
        this$0.getCallback().onError(exception.element);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getExecutor().execute(new RunnableC2522b(this.this$0, this.$exception, 1));
    }
}
