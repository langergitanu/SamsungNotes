package com.samsung.android.mcf.continuity.interfaces;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class ContinuityDeviceState {
    private final int mBtState;
    private final int mCallState;
    private final int mCmcState;
    private final int mScreenState;
    private final int mWifiState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {
        private int mScreenState = 400;
        private int mCallState = 500;
        private int mBtState = 600;
        private int mWifiState = 700;
        private int mCmcState = 800;

        @NonNull
        public ContinuityDeviceState build() {
            return new ContinuityDeviceState(this.mScreenState, this.mCallState, this.mBtState, this.mWifiState, this.mCmcState);
        }

        @NonNull
        public Builder setBtState(int i) {
            this.mBtState = i;
            return this;
        }

        @NonNull
        public Builder setCallState(int i) {
            this.mCallState = i;
            return this;
        }

        @NonNull
        public Builder setCmcState(int i) {
            this.mCmcState = i;
            return this;
        }

        @NonNull
        public Builder setScreenState(int i) {
            this.mScreenState = i;
            return this;
        }

        @NonNull
        public Builder setWifiState(int i) {
            this.mWifiState = i;
            return this;
        }
    }

    public int getBtState() {
        return this.mBtState;
    }

    public int getCallState() {
        return this.mCallState;
    }

    public int getCmcState() {
        return this.mCmcState;
    }

    public int getScreenState() {
        return this.mScreenState;
    }

    public int getWifiState() {
        return this.mWifiState;
    }

    private ContinuityDeviceState(int i, int i2, int i4, int i5, int i6) {
        this.mScreenState = i;
        this.mCallState = i2;
        this.mBtState = i4;
        this.mWifiState = i5;
        this.mCmcState = i6;
    }
}
