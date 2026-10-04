package com.microsoft.identity.nativeauth.utils;

import android.os.Build;
import android.os.Parcel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"serializable", "T", "Ljava/io/Serializable;", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/io/Serializable;", "msal_distRelease"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ParcelExtensionsKt {
    public static final /* synthetic */ <T extends Serializable> T serializable(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "<this>");
        if (Build.VERSION.SDK_INT < 33) {
            T t = (T) parcel.readSerializable();
            Intrinsics.reifiedOperationMarker(2, "T");
            return t;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        ClassLoader classLoader = Serializable.class.getClassLoader();
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) parcel.readSerializable(classLoader, Serializable.class);
    }
}
