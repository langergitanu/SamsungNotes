package com.samsung.android.support.senl.p148nt.model.repository.data.tag;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentTag extends TagData {

    @ColorInt
    private int mTagColor;
    private String mTagName;
    private static final String TAG = ModelLogger.createTag("DocumentTag");
    public static final Parcelable.Creator<DocumentTag> CREATOR = new Parcelable.Creator<DocumentTag>() { // from class: com.samsung.android.support.senl.nt.model.repository.data.tag.DocumentTag.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentTag createFromParcel(Parcel parcel) {
            return new DocumentTag(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentTag[] newArray(int i) {
            return new DocumentTag[i];
        }
    };

    public DocumentTag() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        DataLogger.m12307i(TAG, "equals, obj : " + obj);
        if (!(obj instanceof DocumentTag)) {
            return false;
        }
        DocumentTag documentTag = (DocumentTag) obj;
        return this.mTagName.compareTo(documentTag.getName()) == 0 && this.mTagColor == documentTag.getColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagData
    @ColorInt
    public int getColor() {
        return this.mTagColor;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagData
    public String getName() {
        return this.mTagName;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagData
    public TagData setColor(@ColorInt int i) {
        DataLogger.m12307i(TAG, "setColor : " + i);
        this.mTagColor = i;
        return this;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagData
    public TagData setName(String str) {
        DataLogger.m12307i(TAG, "setName : " + DataLogger.getEncode(str));
        this.mTagName = str;
        return this;
    }

    @NonNull
    public String toString() {
        return "color : " + getColor() + ", name : " + DataLogger.getEncode(getName());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mTagColor);
        parcel.writeString(this.mTagName);
    }

    public DocumentTag(Parcel parcel) {
        this.mTagColor = parcel.readInt();
        this.mTagName = parcel.readString();
        DataLogger.m12307i(TAG, "DocumentTag-in : " + this);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.documents.data.TagData
    @NonNull
    /* JADX INFO: renamed from: clone */
    public TagData mo22198clone() {
        return super.mo22198clone();
    }
}
