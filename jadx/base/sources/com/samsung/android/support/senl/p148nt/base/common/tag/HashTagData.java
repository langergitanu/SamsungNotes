package com.samsung.android.support.senl.p148nt.base.common.tag;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\bJ\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020\bH\u0016R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\"\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001b¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/tag/HashTagData;", "Landroid/os/Parcelable;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mTagColor", "", "mTagName", "", "mTagUUID", "mSDocCount", "describeContents", "writeToParcel", "", "dest", "flags", "setName", "tagName", "name", "getName", "()Ljava/lang/String;", "setColor", "tagColor", "color", "getColor", "()I", "setUUID", "tagUUID", "uUID", "getUUID", "setSDocCount", "count", "sDocCount", "getSDocCount", "equals", "", "obj", "", "hashCode", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HashTagData implements Parcelable {

    @NotNull
    private static final String TAG = "HashTagData";
    private int mSDocCount;

    @ColorInt
    private int mTagColor;

    @Nullable
    private String mTagName;

    @Nullable
    private String mTagUUID;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<HashTagData> CREATOR = new Parcelable.Creator<HashTagData>() { // from class: com.samsung.android.support.senl.nt.base.common.tag.HashTagData$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HashTagData createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new HashTagData(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HashTagData[] newArray(int size) {
            return new HashTagData[size];
        }
    };

    public HashTagData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        String str;
        Logger.m8702i(TAG, "equals, obj : " + obj);
        return (obj instanceof HashTagData) && (str = this.mTagName) != null && str.compareTo(String.valueOf(((HashTagData) obj).getName())) == 0 && this.mTagColor == ((HashTagData) obj).getColor();
    }

    @ColorInt
    public final int getColor() {
        AbstractC4539a.m3203m(this.mTagColor, "getColor : ", TAG);
        return this.mTagColor;
    }

    @Nullable
    public final String getName() {
        AbstractC4539a.m3188B("getName : ", this.mTagName, TAG);
        return this.mTagName;
    }

    public final int getSDocCount() {
        AbstractC4539a.m3203m(this.mSDocCount, "getSDocCount : ", TAG);
        return this.mSDocCount;
    }

    @Nullable
    public final String getUUID() {
        AbstractC4539a.m3188B("getUUID : ", this.mTagUUID, TAG);
        return this.mTagUUID;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public final HashTagData setColor(@ColorInt int tagColor) {
        AbstractC4539a.m3203m(tagColor, "setColor : ", TAG);
        this.mTagColor = tagColor;
        return this;
    }

    @NotNull
    public final HashTagData setName(@NotNull String tagName) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Logger.m8697d(TAG, "setName : " + tagName);
        this.mTagName = tagName;
        return this;
    }

    @NotNull
    public final HashTagData setSDocCount(int count) {
        AbstractC4539a.m3203m(count, "setSDocCount : ", TAG);
        this.mSDocCount = count;
        return this;
    }

    @NotNull
    public final HashTagData setUUID(@NotNull String tagUUID) {
        Intrinsics.checkNotNullParameter(tagUUID, "tagUUID");
        Logger.m8697d(TAG, "setUUID : " + tagUUID);
        this.mTagUUID = tagUUID;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.mTagColor);
        dest.writeString(this.mTagName);
        dest.writeString(this.mTagUUID);
        dest.writeInt(this.mSDocCount);
    }

    public HashTagData(@NotNull Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        this.mTagColor = in.readInt();
        this.mTagName = in.readString();
        this.mTagUUID = in.readString();
        this.mSDocCount = in.readInt();
    }
}
