package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class RequestParams extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public abstract Set<Uri> getAllAppIds();

    @NonNull
    public abstract Uri getAppId();

    @NonNull
    public abstract ChannelIdValue getChannelIdValue();

    @NonNull
    public abstract String getDisplayHint();

    @NonNull
    public abstract List<RegisteredKey> getRegisteredKeys();

    @NonNull
    public abstract Integer getRequestId();

    @NonNull
    public abstract Double getTimeoutSeconds();
}
