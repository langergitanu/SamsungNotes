package com.samsung.android.support.senl.p148nt.base.winset.app.picker.color;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ColorSettingState implements Parcelable {
    public static final int PALETTE_ID_NONE = -1;
    private int mColor;
    private boolean mIsColorPickerEnable;
    private boolean mIsColorSettingEnable;
    private boolean mIsColorSpoidEnable;
    private int mPaletteId;
    private static final String TAG = Logger.createTag("CP$ColorSettingState");
    public static final Parcelable.Creator<ColorSettingState> CREATOR = new Parcelable.Creator<ColorSettingState>() { // from class: com.samsung.android.support.senl.nt.base.winset.app.picker.color.ColorSettingState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorSettingState createFromParcel(Parcel parcel) {
            return new ColorSettingState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ColorSettingState[] newArray(int i) {
            return new ColorSettingState[i];
        }
    };

    public ColorSettingState() {
        this.mIsColorPickerEnable = false;
        this.mIsColorSettingEnable = false;
        this.mIsColorSpoidEnable = false;
        this.mPaletteId = -1;
        this.mColor = 0;
    }

    public boolean compareData(ColorSettingState colorSettingState) {
        boolean z;
        if (this.mIsColorPickerEnable != colorSettingState.mIsColorPickerEnable) {
            Logger.m8697d(TAG, "compareData mIsColorPickerEnable : " + this.mIsColorPickerEnable + SQLKeyword.COMMA + colorSettingState.mIsColorPickerEnable);
            z = false;
        } else {
            z = true;
        }
        if (this.mIsColorSettingEnable != colorSettingState.mIsColorSettingEnable) {
            Logger.m8697d(TAG, "compareData mIsColorSettingEnable : " + this.mIsColorSettingEnable + SQLKeyword.COMMA + colorSettingState.mIsColorSettingEnable);
            z = false;
        }
        if (this.mIsColorSpoidEnable != colorSettingState.mIsColorSpoidEnable) {
            Logger.m8697d(TAG, "compareData mIsColorSpoidEnable : " + this.mIsColorSpoidEnable + SQLKeyword.COMMA + colorSettingState.mIsColorSpoidEnable);
            z = false;
        }
        if (this.mPaletteId != colorSettingState.mPaletteId) {
            Logger.m8697d(TAG, "compareData PaletteId : " + this.mPaletteId + SQLKeyword.COMMA + colorSettingState.mPaletteId);
            z = false;
        }
        if (this.mColor == colorSettingState.mColor) {
            return z;
        }
        Logger.m8697d(TAG, "compareData PaletteId : " + this.mColor + SQLKeyword.COMMA + colorSettingState.mColor);
        return false;
    }

    public void copyData(ColorSettingState colorSettingState) {
        this.mIsColorPickerEnable = colorSettingState.mIsColorPickerEnable;
        this.mIsColorSettingEnable = colorSettingState.mIsColorSettingEnable;
        this.mIsColorSpoidEnable = colorSettingState.mIsColorSpoidEnable;
        this.mPaletteId = colorSettingState.mPaletteId;
        this.mColor = colorSettingState.mColor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getColor() {
        return this.mColor;
    }

    public int getPaletteId() {
        return this.mPaletteId;
    }

    public boolean isColorPickerEnable() {
        return this.mIsColorPickerEnable;
    }

    public boolean isColorSettingEnable() {
        return this.mIsColorSettingEnable;
    }

    public boolean isColorSpoidEnable() {
        return this.mIsColorSpoidEnable;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setColorPickerEnable(boolean z) {
        this.mIsColorPickerEnable = z;
    }

    public void setColorSettingEnable(boolean z) {
        this.mIsColorSettingEnable = z;
    }

    public void setColorSpoidEnable(boolean z) {
        this.mIsColorSpoidEnable = z;
    }

    public void setPaletteId(int i) {
        this.mPaletteId = i;
    }

    public String toString() {
        return "\n-@    mIsColorPickerEnable: " + this.mIsColorPickerEnable + "\n-@    mIsColorSettingEnable: " + this.mIsColorSettingEnable + "\n-@    mIsColorSpoidEnable: " + this.mIsColorSpoidEnable + "\n-@    mPaletteId: " + this.mPaletteId + "\n-@    mColor: " + this.mColor;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mIsColorPickerEnable ? 1 : 0);
        parcel.writeInt(this.mIsColorSettingEnable ? 1 : 0);
        parcel.writeInt(this.mIsColorSpoidEnable ? 1 : 0);
        parcel.writeInt(this.mPaletteId);
        parcel.writeInt(this.mColor);
    }

    public ColorSettingState(Parcel parcel) {
        this.mIsColorPickerEnable = false;
        this.mIsColorSettingEnable = false;
        this.mIsColorSpoidEnable = false;
        this.mPaletteId = -1;
        this.mColor = 0;
        this.mIsColorPickerEnable = parcel.readInt() != 0;
        this.mIsColorSettingEnable = parcel.readInt() != 0;
        this.mIsColorSpoidEnable = parcel.readInt() != 0;
        this.mPaletteId = parcel.readInt();
        this.mColor = parcel.readInt();
    }
}
