package androidx.credentials;

import androidx.credentials.PrepareGetCredentialResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
public /* synthetic */ class PrepareGetCredentialResponse$Builder$setFrameworkResponse$3 extends FunctionReferenceImpl implements Function0<Boolean> {
    public PrepareGetCredentialResponse$Builder$setFrameworkResponse$3(Object obj) {
        super(0, obj, PrepareGetCredentialResponse.Builder.class, "hasRemoteResults", "hasRemoteResults()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(((PrepareGetCredentialResponse.Builder) this.receiver).hasRemoteResults());
    }
}
