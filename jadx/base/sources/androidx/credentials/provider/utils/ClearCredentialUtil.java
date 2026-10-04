package androidx.credentials.provider.utils;

import android.content.pm.SigningInfo;
import android.service.credentials.ClearCredentialStateRequest;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.ProviderClearCredentialStateRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(34)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/credentials/provider/utils/ClearCredentialUtil;", "", "()V", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ClearCredentialUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/credentials/provider/utils/ClearCredentialUtil$Companion;", "", "()V", "convertToJetpackRequest", "Landroidx/credentials/provider/ProviderClearCredentialStateRequest;", "request", "Landroid/service/credentials/ClearCredentialStateRequest;", "convertToJetpackRequest$credentials_release", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ProviderClearCredentialStateRequest convertToJetpackRequest$credentials_release(@NotNull ClearCredentialStateRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            String packageName = request.getCallingAppInfo().getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "request.callingAppInfo.packageName");
            SigningInfo signingInfo = request.getCallingAppInfo().getSigningInfo();
            Intrinsics.checkNotNullExpressionValue(signingInfo, "request.callingAppInfo.signingInfo");
            return new ProviderClearCredentialStateRequest(new CallingAppInfo(packageName, signingInfo, request.getCallingAppInfo().getOrigin()));
        }

        private Companion() {
        }
    }
}
