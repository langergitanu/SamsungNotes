package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.PasswordCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, m13886d2 = {"Landroidx/credentials/provider/BeginCreatePasswordCredentialRequest;", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "candidateQueryData", "Landroid/os/Bundle;", "(Landroidx/credentials/provider/CallingAppInfo;Landroid/os/Bundle;)V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BeginCreatePasswordCredentialRequest extends BeginCreateCredentialRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\t¨\u0006\n"}, m13886d2 = {"Landroidx/credentials/provider/BeginCreatePasswordCredentialRequest$Companion;", "", "()V", "createFrom", "Landroidx/credentials/provider/BeginCreatePasswordCredentialRequest;", "data", "Landroid/os/Bundle;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "createFrom$credentials_release", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final BeginCreatePasswordCredentialRequest createFrom$credentials_release(@NotNull Bundle data, @Nullable CallingAppInfo callingAppInfo) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                return new BeginCreatePasswordCredentialRequest(callingAppInfo, data);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeginCreatePasswordCredentialRequest(@Nullable CallingAppInfo callingAppInfo, @NotNull Bundle candidateQueryData) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, candidateQueryData, callingAppInfo);
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
    }
}
