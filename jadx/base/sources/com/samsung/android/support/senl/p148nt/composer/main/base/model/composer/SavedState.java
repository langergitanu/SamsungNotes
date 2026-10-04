package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SavedState implements Parcelable {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.composer.SavedState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    };
    public static final String KEY = "SavedState";
    private int mCursorEnd;
    private int mCursorStart;
    private int[] mLastSelectedObjectIndexArray;
    private String[] mLastSelectedPageIdArray;
    private boolean mPrevNightMode;

    public SavedState() {
        this.mLastSelectedObjectIndexArray = null;
        this.mLastSelectedPageIdArray = null;
        this.mCursorStart = -1;
        this.mCursorEnd = -1;
        this.mPrevNightMode = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCursorEnd() {
        return this.mCursorEnd;
    }

    public int getCursorStart() {
        return this.mCursorStart;
    }

    public int[] getLastSelectedObjectIndexArray() {
        return this.mLastSelectedObjectIndexArray;
    }

    public String[] getLastSelectedPageIdArray() {
        return this.mLastSelectedPageIdArray;
    }

    public boolean getPrevNightMode() {
        return this.mPrevNightMode;
    }

    public void setCursor(int i, int i2) {
        this.mCursorStart = i;
        this.mCursorEnd = i2;
    }

    public void setLastSelectedObjectIndexArray(int[] iArr) {
        this.mLastSelectedObjectIndexArray = iArr;
    }

    public void setLastSelectedPageIdArray(String[] strArr) {
        this.mLastSelectedPageIdArray = strArr;
    }

    public void setPrevNightMode(boolean z) {
        this.mPrevNightMode = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.mLastSelectedPageIdArray);
        parcel.writeIntArray(this.mLastSelectedObjectIndexArray);
        parcel.writeInt(this.mCursorStart);
        parcel.writeInt(this.mCursorEnd);
        parcel.writeInt(this.mPrevNightMode ? 1 : 0);
    }

    public SavedState(Parcel parcel) {
        this.mLastSelectedPageIdArray = parcel.createStringArray();
        this.mLastSelectedObjectIndexArray = parcel.createIntArray();
        this.mCursorStart = parcel.readInt();
        this.mCursorEnd = parcel.readInt();
        this.mPrevNightMode = parcel.readInt() != 0;
    }
}
