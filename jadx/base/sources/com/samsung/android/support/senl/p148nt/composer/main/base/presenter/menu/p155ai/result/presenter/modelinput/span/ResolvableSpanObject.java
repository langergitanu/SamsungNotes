package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.AbstractC0622a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObject;", "Landroid/os/Parcelable;", "position", "", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType;", "replacement", "", "<init>", "(ILcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType;Ljava/lang/String;)V", "getPosition", "()I", "getType", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/modelinput/span/ResolvableSpanObjectType;", "getReplacement", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class ResolvableSpanObject implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ResolvableSpanObject> CREATOR = new Creator();
    private final int position;

    @NotNull
    private final String replacement;

    @NotNull
    private final ResolvableSpanObjectType type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Creator implements Parcelable.Creator<ResolvableSpanObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ResolvableSpanObject createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ResolvableSpanObject(parcel.readInt(), ResolvableSpanObjectType.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ResolvableSpanObject[] newArray(int i) {
            return new ResolvableSpanObject[i];
        }
    }

    public ResolvableSpanObject(int i, @NotNull ResolvableSpanObjectType type, @NotNull String replacement) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        this.position = i;
        this.type = type;
        this.replacement = replacement;
    }

    public static /* synthetic */ ResolvableSpanObject copy$default(ResolvableSpanObject resolvableSpanObject, int i, ResolvableSpanObjectType resolvableSpanObjectType, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = resolvableSpanObject.position;
        }
        if ((i2 & 2) != 0) {
            resolvableSpanObjectType = resolvableSpanObject.type;
        }
        if ((i2 & 4) != 0) {
            str = resolvableSpanObject.replacement;
        }
        return resolvableSpanObject.copy(i, resolvableSpanObjectType, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ResolvableSpanObjectType getType() {
        return this.type;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReplacement() {
        return this.replacement;
    }

    @NotNull
    public final ResolvableSpanObject copy(int position, @NotNull ResolvableSpanObjectType type, @NotNull String replacement) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return new ResolvableSpanObject(position, type, replacement);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResolvableSpanObject)) {
            return false;
        }
        ResolvableSpanObject resolvableSpanObject = (ResolvableSpanObject) other;
        return this.position == resolvableSpanObject.position && this.type == resolvableSpanObject.type && Intrinsics.areEqual(this.replacement, resolvableSpanObject.replacement);
    }

    public final int getPosition() {
        return this.position;
    }

    @NotNull
    public final String getReplacement() {
        return this.replacement;
    }

    @NotNull
    public final ResolvableSpanObjectType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.replacement.hashCode() + ((this.type.hashCode() + (Integer.hashCode(this.position) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        int i = this.position;
        ResolvableSpanObjectType resolvableSpanObjectType = this.type;
        String str = this.replacement;
        StringBuilder sb = new StringBuilder("ResolvableSpanObject(position=");
        sb.append(i);
        sb.append(", type=");
        sb.append(resolvableSpanObjectType);
        sb.append(", replacement=");
        return AbstractC0622a.m1170p(str, ")", sb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.position);
        dest.writeString(this.type.name());
        dest.writeString(this.replacement);
    }
}
