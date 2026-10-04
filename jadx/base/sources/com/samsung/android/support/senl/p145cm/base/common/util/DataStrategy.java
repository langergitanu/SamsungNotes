package com.samsung.android.support.senl.p145cm.base.common.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0003J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/util/DataStrategy;", "Landroid/os/Parcelable;", "strategy", "", "<init>", "(I)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mStrategy", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "", "clear", "add", "remove", Bixby2Constants.BIXBY_PARAM_CHECK, "", "get", "describeContents", "writeToParcel", "dest", "flags", "toString", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DataStrategy implements Parcelable {
    private int mStrategy;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<DataStrategy> CREATOR = new Parcelable.Creator<DataStrategy>() { // from class: com.samsung.android.support.senl.cm.base.common.util.DataStrategy$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataStrategy createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new DataStrategy(in, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataStrategy[] newArray(int size) {
            return new DataStrategy[size];
        }
    };

    public /* synthetic */ DataStrategy(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public final void add(int add) {
        this.mStrategy = add | this.mStrategy;
    }

    public final boolean check(int strategy) {
        return (strategy & this.mStrategy) != 0;
    }

    public final void clear() {
        this.mStrategy = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: renamed from: get, reason: from getter */
    public final int getMStrategy() {
        return this.mStrategy;
    }

    public final void remove(int remove) {
        this.mStrategy = (~remove) & this.mStrategy;
    }

    public final void set(int strategy) {
        this.mStrategy = strategy;
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m767i(this.mStrategy, "DataStrategy{mStrategy = ", "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.mStrategy);
    }

    public DataStrategy(int i) {
        set(i);
    }

    private DataStrategy(Parcel parcel) {
        this.mStrategy = parcel.readInt();
    }
}
