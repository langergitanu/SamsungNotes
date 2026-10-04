package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextOnlyModeState implements Parcelable {
    public static final String KEY_STATE = "text_only_mode_state_key";
    public static final int TEXT_ONLY_MODE_CAUSE_BY_INSERT = 2;
    public static final int TEXT_ONLY_MODE_CAUSE_BY_MENU = 1;
    public static final int TEXT_ONLY_MODE_CAUSE_BY_UNKNOWN = 0;
    private boolean mCanUseTextOnlyMode;
    private boolean mIsEnableTextOnlyMode;
    private boolean mIsLastFitScreen;
    private boolean mIsLastVertical;
    private boolean mIsStartWithTextOnly;
    private int mLastPageColumn;
    private int mLastPageRow;
    private float mLastTextScale;
    private float mLastZoomScale;
    private OnCanUseTextOnlyModeChangeListener mOnCanUseTextOnlyModeChangeListener;
    private static final String TAG = Logger.createTag("TextOnlyModeState");
    public static final Parcelable.Creator<TextOnlyModeState> CREATOR = new Parcelable.Creator<TextOnlyModeState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.model.composer.common.TextOnlyModeState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextOnlyModeState createFromParcel(Parcel parcel) {
            return new TextOnlyModeState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TextOnlyModeState[] newArray(int i) {
            return new TextOnlyModeState[i];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnCanUseTextOnlyModeChangeListener {
        void onCanUseChanged(boolean z, int i);
    }

    public TextOnlyModeState() {
    }

    public boolean canUseTextOnlyMode() {
        return this.mCanUseTextOnlyMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLastPageColumn() {
        return this.mLastPageColumn;
    }

    public int getLastPageRow() {
        return this.mLastPageRow;
    }

    public float getLastTextScale() {
        return this.mLastTextScale;
    }

    public float getLastZoomScale() {
        return this.mLastZoomScale;
    }

    public boolean isEnableTextOnlyMode() {
        return this.mIsEnableTextOnlyMode;
    }

    public boolean isLastFitScreen() {
        return this.mIsLastFitScreen;
    }

    public boolean isLastVertical() {
        return this.mIsLastVertical;
    }

    public boolean isStartWithTextOnly() {
        return this.mIsStartWithTextOnly;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(KEY_STATE, this);
    }

    public void restoreState(Bundle bundle) {
        TextOnlyModeState textOnlyModeState = (TextOnlyModeState) bundle.getParcelable(KEY_STATE);
        if (textOnlyModeState == null) {
            return;
        }
        this.mIsStartWithTextOnly = textOnlyModeState.isStartWithTextOnly();
        this.mCanUseTextOnlyMode = textOnlyModeState.canUseTextOnlyMode();
        this.mIsEnableTextOnlyMode = textOnlyModeState.isEnableTextOnlyMode();
        this.mLastTextScale = textOnlyModeState.getLastTextScale();
        this.mLastZoomScale = textOnlyModeState.getLastZoomScale();
        this.mLastPageColumn = textOnlyModeState.getLastPageColumn();
        this.mLastPageRow = textOnlyModeState.getLastPageRow();
        this.mIsLastFitScreen = textOnlyModeState.isLastFitScreen();
        this.mIsLastVertical = textOnlyModeState.isLastVertical();
    }

    public void setCanUseTextOnlyMode(boolean z) {
        this.mCanUseTextOnlyMode = z;
    }

    public void setIsEnableTextOnlyMode(boolean z) {
        this.mIsEnableTextOnlyMode = z;
    }

    public void setIsLastFitScreen(boolean z) {
        this.mIsLastFitScreen = z;
    }

    public void setIsLastVertical(boolean z) {
        this.mIsLastVertical = z;
    }

    public void setIsStartWithTextOnly(boolean z) {
        this.mIsStartWithTextOnly = z;
    }

    public void setLastPageColumn(int i) {
        this.mLastPageColumn = i;
    }

    public void setLastPageLayoutInfo(int i, int i2, boolean z, boolean z2) {
        this.mLastPageColumn = i;
        this.mLastPageRow = i2;
        this.mIsLastFitScreen = z;
        this.mIsLastVertical = z2;
    }

    public void setLastPageRow(int i) {
        this.mLastPageRow = i;
    }

    public void setLastTextScale(float f) {
        this.mLastTextScale = f;
    }

    public void setLastZoomScale(float f) {
        this.mLastZoomScale = f;
    }

    public void setOnCanUseTextOnlyModeChangeListener(OnCanUseTextOnlyModeChangeListener onCanUseTextOnlyModeChangeListener) {
        this.mOnCanUseTextOnlyModeChangeListener = onCanUseTextOnlyModeChangeListener;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte(this.mIsStartWithTextOnly ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mCanUseTextOnlyMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsEnableTextOnlyMode ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mLastTextScale);
        parcel.writeFloat(this.mLastZoomScale);
        parcel.writeInt(this.mLastPageColumn);
        parcel.writeInt(this.mLastPageRow);
        parcel.writeByte(this.mIsLastFitScreen ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsLastVertical ? (byte) 1 : (byte) 0);
    }

    public TextOnlyModeState(Parcel parcel) {
        this.mIsStartWithTextOnly = parcel.readByte() != 0;
        this.mCanUseTextOnlyMode = parcel.readByte() != 0;
        this.mIsEnableTextOnlyMode = parcel.readByte() != 0;
        this.mLastTextScale = parcel.readFloat();
        this.mLastZoomScale = parcel.readFloat();
        this.mLastPageColumn = parcel.readInt();
        this.mLastPageRow = parcel.readInt();
        this.mIsLastFitScreen = parcel.readByte() != 0;
        this.mIsLastVertical = parcel.readByte() != 0;
    }

    public void setCanUseTextOnlyMode(boolean z, int i) {
        setCanUseTextOnlyMode(z, i, true);
    }

    public void setCanUseTextOnlyMode(boolean z, int i, boolean z2) {
        OnCanUseTextOnlyModeChangeListener onCanUseTextOnlyModeChangeListener;
        if (this.mCanUseTextOnlyMode == z) {
            return;
        }
        this.mCanUseTextOnlyMode = z;
        Logger.m11003i(TAG, "setCanUseTextOnlyMode:canUse= " + z + " / cause = " + i);
        if (!this.mCanUseTextOnlyMode) {
            this.mIsStartWithTextOnly = false;
        }
        if (!z2 || (onCanUseTextOnlyModeChangeListener = this.mOnCanUseTextOnlyModeChangeListener) == null) {
            return;
        }
        onCanUseTextOnlyModeChangeListener.onCanUseChanged(z, i);
    }
}
