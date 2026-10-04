package androidx.credentials.provider;

import androidx.credentials.CreateCredentialRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "", "callingRequest", "Landroidx/credentials/CreateCredentialRequest;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "(Landroidx/credentials/CreateCredentialRequest;Landroidx/credentials/provider/CallingAppInfo;)V", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "getCallingRequest", "()Landroidx/credentials/CreateCredentialRequest;", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ProviderCreateCredentialRequest {

    @NotNull
    private final CallingAppInfo callingAppInfo;

    @NotNull
    private final CreateCredentialRequest callingRequest;

    public ProviderCreateCredentialRequest(@NotNull CreateCredentialRequest callingRequest, @NotNull CallingAppInfo callingAppInfo) {
        Intrinsics.checkNotNullParameter(callingRequest, "callingRequest");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
        this.callingRequest = callingRequest;
        this.callingAppInfo = callingAppInfo;
    }

    @NotNull
    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    @NotNull
    public final CreateCredentialRequest getCallingRequest() {
        return this.callingRequest;
    }
}
