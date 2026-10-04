package com.samsung.android.support.senl.p148nt.base.common.displaydata;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J)\u0010\b\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/displaydata/DisplayDataHelper;", "", "<init>", "()V", "marshall", "", "parcelable", "Landroid/os/Parcelable;", "unmarshall", "Landroid/os/Parcel;", "bytes", "T", "creator", "Landroid/os/Parcelable$Creator;", "([BLandroid/os/Parcelable$Creator;)Ljava/lang/Object;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayDataHelper {

    @NotNull
    public static final DisplayDataHelper INSTANCE = new DisplayDataHelper();

    private DisplayDataHelper() {
    }

    @JvmStatic
    @NotNull
    public static final byte[] marshall(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "parcelable");
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        Intrinsics.checkNotNull(bArrMarshall);
        return bArrMarshall;
    }

    private final Parcel unmarshall(byte[] bytes) {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        parcelObtain.unmarshall(bytes, 0, bytes.length);
        parcelObtain.setDataPosition(0);
        return parcelObtain;
    }

    @JvmStatic
    public static final <T> T unmarshall(@NotNull byte[] bytes, @NotNull Parcelable.Creator<T> creator) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Parcel parcelUnmarshall = INSTANCE.unmarshall(bytes);
        T tCreateFromParcel = creator.createFromParcel(parcelUnmarshall);
        parcelUnmarshall.recycle();
        return tCreateFromParcel;
    }
}
