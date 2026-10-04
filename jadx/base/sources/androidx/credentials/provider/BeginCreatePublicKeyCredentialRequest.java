package androidx.credentials.provider;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.utils.RequestValidationUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m13886d2 = {"Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest;", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "requestJson", "", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "candidateQueryData", "Landroid/os/Bundle;", "clientDataHash", "", "(Ljava/lang/String;Landroidx/credentials/provider/CallingAppInfo;Landroid/os/Bundle;[B)V", "getClientDataHash", "()[B", "getRequestJson", "()Ljava/lang/String;", "initiateBundle", "", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBeginCreatePublicKeyCredentialRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BeginCreatePublicKeyCredentialRequest.kt\nandroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n1#2:102\n*E\n"})
public final class BeginCreatePublicKeyCredentialRequest extends BeginCreateCredentialRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final byte[] clientDataHash;

    @NotNull
    private final String requestJson;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest$Companion;", "", "()V", "createForTest", "Landroidx/credentials/provider/BeginCreatePublicKeyCredentialRequest;", "data", "Landroid/os/Bundle;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "createFrom", "createFrom$credentials_release", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @VisibleForTesting
        @NotNull
        public final BeginCreatePublicKeyCredentialRequest createForTest(@NotNull Bundle data, @Nullable CallingAppInfo callingAppInfo) {
            Intrinsics.checkNotNullParameter(data, "data");
            return createFrom$credentials_release(data, callingAppInfo);
        }

        @NotNull
        public final BeginCreatePublicKeyCredentialRequest createFrom$credentials_release(@NotNull Bundle data, @Nullable CallingAppInfo callingAppInfo) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                String string = data.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
                byte[] byteArray = data.getByteArray("androidx.credentials.BUNDLE_KEY_CLIENT_DATA_HASH");
                Intrinsics.checkNotNull(string);
                return new BeginCreatePublicKeyCredentialRequest(string, callingAppInfo, data, byteArray);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BeginCreatePublicKeyCredentialRequest(@NotNull String requestJson, @Nullable CallingAppInfo callingAppInfo, @NotNull Bundle candidateQueryData) {
        this(requestJson, callingAppInfo, candidateQueryData, null, 8, null);
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
    }

    @JvmStatic
    @VisibleForTesting
    @NotNull
    public static final BeginCreatePublicKeyCredentialRequest createForTest(@NotNull Bundle bundle, @Nullable CallingAppInfo callingAppInfo) {
        return INSTANCE.createForTest(bundle, callingAppInfo);
    }

    private final void initiateBundle(Bundle candidateQueryData, String requestJson) {
        candidateQueryData.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", requestJson);
    }

    @Nullable
    public final byte[] getClientDataHash() {
        return this.clientDataHash;
    }

    @NotNull
    public final String getRequestJson() {
        return this.requestJson;
    }

    public /* synthetic */ BeginCreatePublicKeyCredentialRequest(String str, CallingAppInfo callingAppInfo, Bundle bundle, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, callingAppInfo, bundle, (i & 8) != 0 ? null : bArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BeginCreatePublicKeyCredentialRequest(@NotNull String requestJson, @Nullable CallingAppInfo callingAppInfo, @NotNull Bundle candidateQueryData, @Nullable byte[] bArr) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, candidateQueryData, callingAppInfo);
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
        this.requestJson = requestJson;
        this.clientDataHash = bArr;
        if (RequestValidationUtil.INSTANCE.isValidJSON(requestJson)) {
            initiateBundle(candidateQueryData, requestJson);
            return;
        }
        throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON");
    }
}
