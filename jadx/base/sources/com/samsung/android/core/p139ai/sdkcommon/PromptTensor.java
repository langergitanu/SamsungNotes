package com.samsung.android.core.p139ai.sdkcommon;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AbstractC0541b;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/core/ai/sdkcommon/PromptTensor;", "Landroid/os/Parcelable;", "mPromptName", "", "mPromptString", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "inParcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMPromptName", "()Ljava/lang/String;", "getMPromptString", "writeToParcel", "", "dest", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final /* data */ class PromptTensor implements Parcelable {

    @NotNull
    private final String mPromptName;

    @NotNull
    private final String mPromptString;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PromptTensor> CREATOR = new Parcelable.Creator<PromptTensor>() { // from class: com.samsung.android.core.ai.sdkcommon.PromptTensor$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PromptTensor createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new PromptTensor(source, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PromptTensor[] newArray(int size) {
            return new PromptTensor[size];
        }
    };

    public /* synthetic */ PromptTensor(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static /* synthetic */ PromptTensor copy$default(PromptTensor promptTensor, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promptTensor.mPromptName;
        }
        if ((i & 2) != 0) {
            str2 = promptTensor.mPromptString;
        }
        return promptTensor.copy(str, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMPromptName() {
        return this.mPromptName;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMPromptString() {
        return this.mPromptString;
    }

    @NotNull
    public final PromptTensor copy(@NotNull String mPromptName, @NotNull String mPromptString) {
        Intrinsics.checkNotNullParameter(mPromptName, "mPromptName");
        Intrinsics.checkNotNullParameter(mPromptString, "mPromptString");
        return new PromptTensor(mPromptName, mPromptString);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromptTensor)) {
            return false;
        }
        PromptTensor promptTensor = (PromptTensor) other;
        return Intrinsics.areEqual(this.mPromptName, promptTensor.mPromptName) && Intrinsics.areEqual(this.mPromptString, promptTensor.mPromptString);
    }

    @NotNull
    public final String getMPromptName() {
        return this.mPromptName;
    }

    @NotNull
    public final String getMPromptString() {
        return this.mPromptString;
    }

    public int hashCode() {
        return this.mPromptString.hashCode() + (this.mPromptName.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return AbstractC0541b.m775q("PromptTensor(mPromptName=", this.mPromptName, ", mPromptString=", this.mPromptString, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.mPromptName);
        dest.writeString(this.mPromptString);
    }

    public PromptTensor(@NotNull String mPromptName, @NotNull String mPromptString) {
        Intrinsics.checkNotNullParameter(mPromptName, "mPromptName");
        Intrinsics.checkNotNullParameter(mPromptString, "mPromptString");
        this.mPromptName = mPromptName;
        this.mPromptString = mPromptString;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private PromptTensor(Parcel parcel) {
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        this(string, string2 != null ? string2 : "");
    }
}
