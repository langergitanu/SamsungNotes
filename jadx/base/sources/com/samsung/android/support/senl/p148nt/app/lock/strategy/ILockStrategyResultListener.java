package com.samsung.android.support.senl.p148nt.app.lock.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/strategy/ILockStrategyResultListener;", "Landroid/os/Parcelable;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "getListener", "()Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;", "setListener", "(Lcom/samsung/android/support/senl/nt/base/common/access/lock/ILockManagerListener;)V", "onSuccess", "", "uuid", "", "", "([Ljava/lang/String;)V", "onFail", "failCode", "", "describeContents", "writeToParcel", "parcel", "Landroid/os/Parcel;", "i", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ILockStrategyResultListener extends Parcelable {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static int describeContents(@NotNull ILockStrategyResultListener iLockStrategyResultListener) {
            return 0;
        }

        public static void writeToParcel(@NotNull ILockStrategyResultListener iLockStrategyResultListener, @NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Override // android.os.Parcelable
    int describeContents();

    @Nullable
    ILockManagerListener getListener();

    void onFail(int failCode);

    void onSuccess(@NotNull String... uuid);

    void setListener(@Nullable ILockManagerListener iLockManagerListener);

    @Override // android.os.Parcelable
    void writeToParcel(@NotNull Parcel parcel, int i);
}
