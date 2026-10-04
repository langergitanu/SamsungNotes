package com.samsung.android.mcf.continuity.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityNearbyMyDeviceWrapper implements ContinuityNearbyMyDevice {

    @Nullable
    private final String mBtMac;

    @Nullable
    private final ContinuityDeviceState mCurContinuityDeviceState;
    private final int mDeviceType;

    @Nullable
    private final String mDisplayName;

    @Nullable
    private final String mIp;

    @Nullable
    private final String mModelName;
    private final int mPort;

    @Nullable
    private final ContinuityDeviceState mPrevContinuityDeviceState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {

        @Nullable
        private String mBtMac;

        @Nullable
        private ContinuityDeviceState mCurContinuityDeviceState;

        @Nullable
        private String mDisplayName;

        @Nullable
        private String mIp;

        @Nullable
        private String mModelName;

        @Nullable
        private ContinuityDeviceState mPrevContinuityDeviceState;
        private int mDeviceType = 0;
        private int mPort = -1;

        @NonNull
        public ContinuityNearbyMyDeviceWrapper build() {
            return new ContinuityNearbyMyDeviceWrapper(this.mBtMac, this.mDisplayName, this.mDeviceType, this.mModelName, this.mIp, this.mPort, this.mPrevContinuityDeviceState, this.mCurContinuityDeviceState);
        }

        @NonNull
        public Builder setBtMac(@Nullable String str) {
            this.mBtMac = str;
            return this;
        }

        @NonNull
        public Builder setCurContinuityDeviceState(@Nullable ContinuityDeviceState continuityDeviceState) {
            this.mCurContinuityDeviceState = continuityDeviceState;
            return this;
        }

        @NonNull
        public Builder setDeviceType(int i) {
            this.mDeviceType = i;
            return this;
        }

        @NonNull
        public Builder setDisplayName(@Nullable String str) {
            this.mDisplayName = str;
            return this;
        }

        @NonNull
        public Builder setIp(@Nullable String str) {
            this.mIp = str;
            return this;
        }

        @NonNull
        public Builder setModelName(@Nullable String str) {
            this.mModelName = str;
            return this;
        }

        @NonNull
        public Builder setPort(int i) {
            this.mPort = i;
            return this;
        }

        @NonNull
        public Builder setPrevContinuityDeviceState(@Nullable ContinuityDeviceState continuityDeviceState) {
            this.mPrevContinuityDeviceState = continuityDeviceState;
            return this;
        }
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    @Nullable
    public String getBtMac() {
        return this.mBtMac;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    public int getBtState() {
        ContinuityDeviceState continuityDeviceState = this.mCurContinuityDeviceState;
        if (continuityDeviceState != null) {
            return continuityDeviceState.getBtState();
        }
        return 600;
    }

    public int getCallState() {
        ContinuityDeviceState continuityDeviceState = this.mCurContinuityDeviceState;
        if (continuityDeviceState != null) {
            return continuityDeviceState.getCallState();
        }
        return 500;
    }

    public int getCmcState() {
        ContinuityDeviceState continuityDeviceState = this.mCurContinuityDeviceState;
        if (continuityDeviceState != null) {
            return continuityDeviceState.getCmcState();
        }
        return 800;
    }

    @Nullable
    public ContinuityDeviceState getCurContinuityDeviceState() {
        return this.mCurContinuityDeviceState;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    public int getDeviceType() {
        return this.mDeviceType;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    @Nullable
    public String getDisplayName() {
        return this.mDisplayName;
    }

    @Nullable
    public String getIp() {
        return this.mIp;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    @Nullable
    public String getModelName() {
        return this.mModelName;
    }

    public int getPort() {
        return this.mPort;
    }

    @Nullable
    public ContinuityDeviceState getPrevContinuityDeviceState() {
        return this.mPrevContinuityDeviceState;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    public int getScreenState() {
        ContinuityDeviceState continuityDeviceState = this.mCurContinuityDeviceState;
        if (continuityDeviceState != null) {
            return continuityDeviceState.getScreenState();
        }
        return 400;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice
    public int getWifiState() {
        ContinuityDeviceState continuityDeviceState = this.mCurContinuityDeviceState;
        if (continuityDeviceState != null) {
            return continuityDeviceState.getWifiState();
        }
        return 700;
    }

    public boolean isDeviceStateChanged() {
        ContinuityDeviceState continuityDeviceState = this.mCurContinuityDeviceState;
        if (continuityDeviceState == null) {
            return false;
        }
        return (this.mPrevContinuityDeviceState != null && continuityDeviceState.getScreenState() == this.mPrevContinuityDeviceState.getScreenState() && this.mCurContinuityDeviceState.getBtState() == this.mPrevContinuityDeviceState.getBtState() && this.mCurContinuityDeviceState.getWifiState() == this.mPrevContinuityDeviceState.getWifiState()) ? false : true;
    }

    private ContinuityNearbyMyDeviceWrapper(@Nullable String str, @Nullable String str2, int i, @Nullable String str3, @Nullable String str4, int i2, @Nullable ContinuityDeviceState continuityDeviceState, @Nullable ContinuityDeviceState continuityDeviceState2) {
        this.mBtMac = str;
        this.mDisplayName = str2;
        this.mDeviceType = i;
        this.mModelName = str3;
        this.mIp = str4;
        this.mPort = i2;
        this.mPrevContinuityDeviceState = continuityDeviceState;
        this.mCurContinuityDeviceState = continuityDeviceState2;
    }
}
