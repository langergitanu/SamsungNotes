package com.samsung.android.spen.libsdl;

import android.content.Context;
import android.os.DVFSHelper;
import com.samsung.android.spen.libinterface.DvfsManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlDvfsManager implements DvfsManagerInterface {
    public static final int TYPE_BUS_MIN = 19;
    public static final int TYPE_CPU_CORE_NUM_MAX = 15;
    public static final int TYPE_CPU_CORE_NUM_MIN = 14;
    public static final int TYPE_CPU_MAX = 13;
    public static final int TYPE_CPU_MIN = 12;
    public static final int TYPE_EMMC_BURST_MODE = 18;
    public static final int TYPE_GPU_MAX = 17;
    public static final int TYPE_GPU_MIN = 16;
    private DVFSHelper mDvfsManager;

    public SdlDvfsManager(Context context, String str, int i) {
        this.mDvfsManager = null;
        this.mDvfsManager = new DVFSHelper(context, i);
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void acquire() {
        DVFSHelper dVFSHelper = this.mDvfsManager;
        if (dVFSHelper != null) {
            dVFSHelper.acquire();
        }
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public int getApproximateFrequency(int i) {
        DVFSHelper dVFSHelper = this.mDvfsManager;
        if (dVFSHelper != null) {
            return dVFSHelper.getApproximateCPUFrequency(i);
        }
        return 0;
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public int[] getSupportedFrequency() {
        DVFSHelper dVFSHelper = this.mDvfsManager;
        if (dVFSHelper != null) {
            return dVFSHelper.getSupportedCPUFrequency();
        }
        return null;
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void release() {
        DVFSHelper dVFSHelper = this.mDvfsManager;
        if (dVFSHelper != null) {
            dVFSHelper.release();
        }
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void setDvfsValue(int i) {
        DVFSHelper dVFSHelper = this.mDvfsManager;
        if (dVFSHelper != null) {
            dVFSHelper.addExtraOption("CPU", i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void acquire(int i) {
        DVFSHelper dVFSHelper = this.mDvfsManager;
        if (dVFSHelper != null) {
            dVFSHelper.acquire(i);
        }
    }
}
