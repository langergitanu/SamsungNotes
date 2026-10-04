package com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import java.util.HashSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J*\u0010\u000b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u0001`\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/IFingerprintApi;", "", "authenticate", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "cancelAuthenticate", "hasChangedFingerprint", "", "getFingerprintId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IFingerprintApi {
    void authenticate(@NotNull Context context, @NotNull FingerprintApi.OnAuthenticationListener listener);

    void cancelAuthenticate();

    @Nullable
    HashSet<String> getFingerprintId(@Nullable Context context);

    boolean hasChangedFingerprint(@Nullable Context context);
}
