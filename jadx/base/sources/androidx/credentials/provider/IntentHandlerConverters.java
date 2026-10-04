package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialResponse;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import androidx.annotation.RequiresApi;
import androidx.credentials.AbstractC2512a;
import androidx.credentials.AbstractC2513b;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0007\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0007\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0007\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u0002H\u0007¨\u0006\u000b"}, m13886d2 = {"getBeginGetResponse", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "Landroid/content/Intent;", "getCreateCredentialCredentialResponse", "Landroid/credentials/CreateCredentialResponse;", "getCreateCredentialException", "Landroid/credentials/CreateCredentialException;", "getGetCredentialException", "Landroid/credentials/GetCredentialException;", "getGetCredentialResponse", "Landroid/credentials/GetCredentialResponse;", "credentials_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SuppressLint({"ClassVerificationFailure"})
@JvmName(name = "IntentHandlerConverters")
public final class IntentHandlerConverters {
    @RequiresApi(34)
    @Nullable
    public static final BeginGetCredentialResponse getBeginGetResponse(@NotNull Intent intent) {
        android.service.credentials.BeginGetCredentialResponse beginGetCredentialResponseM1981k;
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (intent.hasExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE") && (beginGetCredentialResponseM1981k = AbstractC2513b.m1981k(intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", AbstractC2513b.m1993w()))) != null) {
            return BeginGetCredentialUtil.INSTANCE.convertToJetpackResponse(beginGetCredentialResponseM1981k);
        }
        return null;
    }

    @RequiresApi(34)
    @Nullable
    public static final CreateCredentialResponse getCreateCredentialCredentialResponse(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (intent.hasExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE")) {
            return AbstractC2512a.m1948h(intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", AbstractC2513b.m1990t()));
        }
        return null;
    }

    @RequiresApi(34)
    @Nullable
    public static final CreateCredentialException getCreateCredentialException(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (intent.hasExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION")) {
            return AbstractC2513b.m1972b(intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", AbstractC2513b.m1995y()));
        }
        return null;
    }

    @RequiresApi(34)
    @Nullable
    public static final GetCredentialException getGetCredentialException(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (intent.hasExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION")) {
            return AbstractC2513b.m1976f(intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", AbstractC2513b.m1967A()));
        }
        return null;
    }

    @RequiresApi(34)
    @Nullable
    public static final GetCredentialResponse getGetCredentialResponse(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        if (intent.hasExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE")) {
            return AbstractC2512a.m1953m(intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", AbstractC2513b.m1984n()));
        }
        return null;
    }
}
