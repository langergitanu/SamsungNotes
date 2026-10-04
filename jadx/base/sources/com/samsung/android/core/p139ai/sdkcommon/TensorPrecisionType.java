package com.samsung.android.core.p139ai.sdkcommon;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType;", "Landroid/os/Parcelable;", "", "<init>", "(Ljava/lang/String;I)V", "FP32", "FP16", "INT8", "INT16", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "describeContents", "CREATOR", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TensorPrecisionType implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TensorPrecisionType[] $VALUES;

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final TensorPrecisionType FP32 = new TensorPrecisionType("FP32", 0);
    public static final TensorPrecisionType FP16 = new TensorPrecisionType("FP16", 1);
    public static final TensorPrecisionType INT8 = new TensorPrecisionType("INT8", 2);
    public static final TensorPrecisionType INT16 = new TensorPrecisionType("INT16", 3);

    /* JADX INFO: renamed from: com.samsung.android.core.ai.sdkcommon.TensorPrecisionType$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType;", "<init>", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/samsung/android/core/ai/sdkcommon/TensorPrecisionType;", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements Parcelable.Creator<TensorPrecisionType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TensorPrecisionType createFromParcel(@NotNull Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            String string = source.readString();
            Intrinsics.checkNotNull(string);
            return TensorPrecisionType.valueOf(string);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public TensorPrecisionType[] newArray(int size) {
            return new TensorPrecisionType[size];
        }
    }

    private static final /* synthetic */ TensorPrecisionType[] $values() {
        return new TensorPrecisionType[]{FP32, FP16, INT8, INT16};
    }

    static {
        TensorPrecisionType[] tensorPrecisionTypeArr$values = $values();
        $VALUES = tensorPrecisionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tensorPrecisionTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private TensorPrecisionType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<TensorPrecisionType> getEntries() {
        return $ENTRIES;
    }

    public static TensorPrecisionType valueOf(String str) {
        return (TensorPrecisionType) Enum.valueOf(TensorPrecisionType.class, str);
    }

    public static TensorPrecisionType[] values() {
        return (TensorPrecisionType[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(name());
    }
}
