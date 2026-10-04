package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiBixbyParam implements Parcelable {
    public static final Parcelable.Creator<AiBixbyParam> CREATOR = new Parcelable.Creator<AiBixbyParam>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiBixbyParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AiBixbyParam createFromParcel(Parcel parcel) {
            return new AiBixbyParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AiBixbyParam[] newArray(int i) {
            return new AiBixbyParam[i];
        }
    };
    private int mAction;
    private int mIndex;
    private boolean mIsOnDevice;
    private boolean mMaxSelectionFlag;
    private int mResultAction;
    private String mTargetLanguage;

    public AiBixbyParam() {
        this.mIsOnDevice = false;
        this.mAction = 0;
        this.mResultAction = 0;
        this.mIndex = 0;
        this.mTargetLanguage = "";
        this.mMaxSelectionFlag = false;
    }

    private void setAction(int i) {
        this.mAction = i;
        if (i != 2 || !FeatureInfo.isSummaryOnDeviceMode()) {
            AiMaxLength.setSelectedMaxLength();
        } else {
            AiMaxLength.setSelectedMaxOnDeviceSummary();
            this.mIsOnDevice = true;
        }
    }

    public void clearAction() {
        setAction(0);
    }

    public void clearResultAction() {
        this.mResultAction = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getResultAction() {
        return this.mResultAction;
    }

    public String getTargetLanguage() {
        return this.mTargetLanguage;
    }

    public boolean hasResultActionForBixby() {
        int i = this.mResultAction;
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public boolean isMaxSelection() {
        return this.mMaxSelectionFlag;
    }

    public boolean isOnDevice() {
        return this.mIsOnDevice;
    }

    public void setMaxSelectionFlag(boolean z) {
        this.mMaxSelectionFlag = z;
    }

    public void setResultAction(int i) {
        this.mResultAction = i;
    }

    public void setTargetLanguage(String str) {
        this.mTargetLanguage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AiBixbyParam{mAction=");
        sb.append(this.mAction);
        sb.append(", mResultAction=");
        sb.append(this.mResultAction);
        sb.append(", mIndex=");
        sb.append(this.mIndex);
        sb.append(", mIsOnDevice=");
        sb.append(this.mIsOnDevice);
        sb.append(", mTargetLanguage='");
        return AbstractC0622a.m1170p(this.mTargetLanguage, "'}", sb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.mAction);
        parcel.writeInt(this.mResultAction);
        parcel.writeInt(this.mIndex);
        parcel.writeString(this.mTargetLanguage);
    }

    public AiBixbyParam(int i, int i2) {
        this.mIndex = 0;
        this.mTargetLanguage = "";
        this.mMaxSelectionFlag = false;
        this.mIsOnDevice = false;
        setAction(i);
        this.mResultAction = i2;
        this.mTargetLanguage = "";
    }

    public AiBixbyParam(int i, int i2, String str) {
        this.mIndex = 0;
        this.mTargetLanguage = "";
        this.mMaxSelectionFlag = false;
        this.mIsOnDevice = false;
        setAction(i);
        this.mResultAction = i2;
        this.mTargetLanguage = str;
    }

    public AiBixbyParam(int i, int i2, int i4) {
        this.mIndex = 0;
        this.mTargetLanguage = "";
        this.mMaxSelectionFlag = false;
        this.mIsOnDevice = false;
        setAction(i);
        this.mResultAction = i2;
        this.mIndex = i4;
    }

    public AiBixbyParam(Parcel parcel) {
        this.mIndex = 0;
        this.mTargetLanguage = "";
        this.mMaxSelectionFlag = false;
        this.mIsOnDevice = false;
        setAction(parcel.readInt());
        this.mResultAction = parcel.readInt();
        this.mIndex = parcel.readInt();
        this.mTargetLanguage = parcel.readString();
    }
}
