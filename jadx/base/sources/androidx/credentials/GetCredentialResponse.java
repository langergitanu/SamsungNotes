package androidx.credentials;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Landroidx/credentials/GetCredentialResponse;", "", "credential", "Landroidx/credentials/Credential;", "(Landroidx/credentials/Credential;)V", "getCredential", "()Landroidx/credentials/Credential;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class GetCredentialResponse {

    @NotNull
    private final Credential credential;

    public GetCredentialResponse(@NotNull Credential credential) {
        Intrinsics.checkNotNullParameter(credential, "credential");
        this.credential = credential;
    }

    @NotNull
    public final Credential getCredential() {
        return this.credential;
    }
}
