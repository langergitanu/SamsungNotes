package com.samsung.android.support.senl.ntnl.coedit;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CoeditDeviceInfo {
    private long mHandle;

    public CoeditDeviceInfo() {
        this.mHandle = CoeditDeviceInfo_construct();
    }

    private native long CoeditDeviceInfo_construct();

    private native void CoeditDeviceInfo_finalize(long j);

    private native String CoeditDeviceInfo_getDeviceId(long j);

    private native String CoeditDeviceInfo_getUserId(long j);

    private native boolean CoeditDeviceInfo_isConnected(long j);

    private native boolean CoeditDeviceInfo_isPermissionGranted(long j);

    private native void CoeditDeviceInfo_setConnected(long j, boolean z);

    private native void CoeditDeviceInfo_setDeviceId(long j, String str);

    private native void CoeditDeviceInfo_setPermissionGranted(long j, boolean z);

    private native void CoeditDeviceInfo_setUserId(long j, String str);

    public void finalize() {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        CoeditDeviceInfo_finalize(j);
        this.mHandle = 0L;
    }

    public String getDeviceId() {
        return CoeditDeviceInfo_getDeviceId(this.mHandle);
    }

    public String getUserId() {
        return CoeditDeviceInfo_getUserId(this.mHandle);
    }

    public boolean isConnected() {
        return CoeditDeviceInfo_isConnected(this.mHandle);
    }

    public boolean isPermissionGranted() {
        return CoeditDeviceInfo_isPermissionGranted(this.mHandle);
    }

    public void setConnected(boolean z) {
        CoeditDeviceInfo_setConnected(this.mHandle, z);
    }

    public void setDeviceId(String str) {
        CoeditDeviceInfo_setDeviceId(this.mHandle, str);
    }

    public void setPermissionGranted(boolean z) {
        CoeditDeviceInfo_setPermissionGranted(this.mHandle, z);
    }

    public void setUserId(String str) {
        CoeditDeviceInfo_setUserId(this.mHandle, str);
    }

    @NonNull
    public String toString() {
        return "deviceId: " + getDeviceId() + ", userId: " + getUserId() + ", isConnected: " + isConnected() + ", isPermissionGranted: " + isPermissionGranted();
    }

    public CoeditDeviceInfo(long j) {
        this.mHandle = j;
    }
}
