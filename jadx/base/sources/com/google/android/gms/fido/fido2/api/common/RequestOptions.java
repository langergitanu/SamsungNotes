package com.google.android.gms.fido.fido2.api.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class RequestOptions extends AbstractSafeParcelable {
    @Nullable
    public abstract AuthenticationExtensions getAuthenticationExtensions();

    @NonNull
    public abstract byte[] getChallenge();

    @Nullable
    public abstract Integer getRequestId();

    @Nullable
    public abstract Double getTimeoutSeconds();

    @Nullable
    public abstract TokenBinding getTokenBinding();

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }
}
