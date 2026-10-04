package com.samsung.android.vexfwk.param;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;
import com.samsung.android.vexfwk.metadata.IVexFwkMetadataConverter;
import java.util.function.Supplier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014R!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/vexfwk/param/VexFwkParamBaseParcelable;", "T", "Landroid/os/Parcelable;", "Lcom/samsung/android/vexfwk/metadata/IVexFwkMetadataConverter;", "creatorSupplier", "Ljava/util/function/Supplier;", "Landroid/os/Parcelable$Creator;", "(Ljava/util/function/Supplier;)V", "creator", "getCreator", "()Landroid/os/Parcelable$Creator;", "creator$delegate", "Lkotlin/Lazy;", Constants.MessagePayloadKeys.FROM, "data", "", "([B)Landroid/os/Parcelable;", "fromParcel", "to", "value", "(Landroid/os/Parcelable;)[B", "toParcel", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class VexFwkParamBaseParcelable<T extends Parcelable> implements IVexFwkMetadataConverter<T> {

    /* JADX INFO: renamed from: creator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy creator;

    @NotNull
    private final Supplier<Parcelable.Creator<T>> creatorSupplier;

    public VexFwkParamBaseParcelable(@NotNull Supplier<Parcelable.Creator<T>> creatorSupplier) {
        Intrinsics.checkNotNullParameter(creatorSupplier, "creatorSupplier");
        this.creatorSupplier = creatorSupplier;
        this.creator = LazyKt.lazy(new Function0<Parcelable.Creator<T>>(this) { // from class: com.samsung.android.vexfwk.param.VexFwkParamBaseParcelable$creator$2
            final /* synthetic */ VexFwkParamBaseParcelable<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Parcelable.Creator<T> invoke() {
                Object obj = ((VexFwkParamBaseParcelable) this.this$0).creatorSupplier.get();
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Parcelable.Creator) obj;
            }
        });
    }

    private final T fromParcel(byte[] data) {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        parcelObtain.unmarshall(data, 0, data.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = getCreator().createFromParcel(parcelObtain);
        parcelObtain.recycle();
        Intrinsics.checkNotNull(tCreateFromParcel);
        return tCreateFromParcel;
    }

    private final Parcelable.Creator<T> getCreator() {
        return (Parcelable.Creator) this.creator.getValue();
    }

    private final byte[] toParcel(T value) {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        value.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        Intrinsics.checkNotNull(bArrMarshall);
        return bArrMarshall;
    }

    @Override // com.samsung.android.vexfwk.metadata.IVexFwkMetadataConverter
    @NotNull
    public T from(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return (T) fromParcel(data);
    }

    @Override // com.samsung.android.vexfwk.metadata.IVexFwkMetadataConverter
    @NotNull
    /* JADX INFO: renamed from: to, reason: merged with bridge method [inline-methods] */
    public byte[] mo12821to(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return toParcel(value);
    }
}
