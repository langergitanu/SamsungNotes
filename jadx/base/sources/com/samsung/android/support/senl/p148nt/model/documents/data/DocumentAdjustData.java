package com.samsung.android.support.senl.p148nt.model.documents.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentAdjustData implements Parcelable {
    public static final Parcelable.Creator<DocumentAdjustData> CREATOR = new Parcelable.Creator<DocumentAdjustData>() { // from class: com.samsung.android.support.senl.nt.model.documents.data.DocumentAdjustData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentAdjustData createFromParcel(Parcel parcel) {
            return new DocumentAdjustData(parcel, 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DocumentAdjustData[] newArray(int i) {
            return new DocumentAdjustData[i];
        }
    };
    private final Map<Integer, Integer> mColorSet;

    @ColorInt
    private final int mDefaultBackgroundColor;
    private final int mDefaultPageHeight;
    private final int mDefaultPageWidth;
    private final int mPageDefaultNumber;
    private final int mPageIndex;
    private final int mPenColorType;

    public /* synthetic */ DocumentAdjustData(Parcel parcel, int i) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<Integer, Integer> getColorSet() {
        return this.mColorSet;
    }

    public int getDefaultBackgroundColor() {
        return this.mDefaultBackgroundColor;
    }

    public int getDefaultPageHeight() {
        return this.mDefaultPageHeight;
    }

    public int getDefaultPageWidth() {
        return this.mDefaultPageWidth;
    }

    public int getPageDefaultNumber() {
        return this.mPageDefaultNumber;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public int getPenColorType() {
        return this.mPenColorType;
    }

    @NonNull
    public String toString() {
        return "DocumentAdjustData{mDefaultPageWidth=" + this.mDefaultPageWidth + ", mDefaultPageHeight=" + this.mDefaultPageHeight + ", mDefaultBackgroundColor=" + this.mDefaultBackgroundColor + ", mPageIndex=" + this.mPageIndex + ", mPageDefaultNumber=" + this.mPageDefaultNumber + ", mPenColorType=" + this.mPenColorType + ", mColorSet=" + this.mColorSet + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDefaultPageWidth);
        parcel.writeInt(this.mDefaultPageHeight);
        parcel.writeInt(this.mDefaultBackgroundColor);
        parcel.writeInt(this.mPageIndex);
        parcel.writeInt(this.mPageDefaultNumber);
        parcel.writeInt(this.mPenColorType);
        parcel.writeMap(this.mColorSet);
    }

    public DocumentAdjustData(int i, int i2, int i4, int i5, int i6, int i7, Map<Integer, Integer> map) {
        HashMap map2 = new HashMap();
        this.mColorSet = map2;
        this.mDefaultPageWidth = i;
        this.mDefaultPageHeight = i2;
        this.mDefaultBackgroundColor = i4;
        this.mPageIndex = i5;
        this.mPageDefaultNumber = i6;
        this.mPenColorType = i7;
        map2.putAll(map);
    }

    private DocumentAdjustData(Parcel parcel) {
        HashMap map = new HashMap();
        this.mColorSet = map;
        this.mDefaultPageWidth = parcel.readInt();
        this.mDefaultPageHeight = parcel.readInt();
        this.mDefaultBackgroundColor = parcel.readInt();
        this.mPageIndex = parcel.readInt();
        this.mPageDefaultNumber = parcel.readInt();
        this.mPenColorType = parcel.readInt();
        parcel.readMap(map, Map.class.getClassLoader());
    }
}
