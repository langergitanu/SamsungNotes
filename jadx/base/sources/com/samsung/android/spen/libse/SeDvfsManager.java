package com.samsung.android.spen.libse;

import android.content.Context;
import com.samsung.android.os.SemDvfsManager;
import com.samsung.android.spen.libinterface.DvfsManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeDvfsManager implements DvfsManagerInterface {
    public static final int TYPE_BUS_MIN = 19;
    public static final int TYPE_CPU_CORE_NUM_MAX = 15;
    public static final int TYPE_CPU_CORE_NUM_MIN = 14;
    public static final int TYPE_CPU_MAX = 13;
    public static final int TYPE_CPU_MIN = 12;
    public static final int TYPE_EMMC_BURST_MODE = 18;
    public static final int TYPE_GPU_MAX = 17;
    public static final int TYPE_GPU_MIN = 16;
    public static final int TYPE_RESOURCE_BUS_MIN = 805310465;
    public static final int TYPE_RESOURCE_CPU_CORE_NUM_MAX = 268443652;
    public static final int TYPE_RESOURCE_CPU_CORE_NUM_MIN = 268443651;
    public static final int TYPE_RESOURCE_CPU_MAX = 301993986;
    public static final int TYPE_RESOURCE_CPU_MIN = 301993985;
    public static final int TYPE_RESOURCE_GPU_MAX = 536875010;
    public static final int TYPE_RESOURCE_GPU_MIN = 536875009;
    private SemDvfsManager mDvfsManager;

    public SeDvfsManager(Context context, String str, int i) {
        this.mDvfsManager = null;
        this.mDvfsManager = SemDvfsManager.createInstance(context, str);
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void acquire() {
        SemDvfsManager semDvfsManager = this.mDvfsManager;
        if (semDvfsManager != null) {
            semDvfsManager.acquire();
        }
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public int getApproximateFrequency(int i) {
        SemDvfsManager semDvfsManager = this.mDvfsManager;
        if (semDvfsManager != null) {
            return semDvfsManager.getApproximateFrequency(i, TYPE_RESOURCE_CPU_MIN, 1);
        }
        return 0;
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public int[] getSupportedFrequency() {
        SemDvfsManager semDvfsManager = this.mDvfsManager;
        if (semDvfsManager != null) {
            return semDvfsManager.getSupportedFrequency(TYPE_RESOURCE_CPU_MIN, 1);
        }
        return null;
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void release() {
        SemDvfsManager semDvfsManager = this.mDvfsManager;
        if (semDvfsManager != null) {
            semDvfsManager.release();
        }
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void setDvfsValue(int i) {
        SemDvfsManager semDvfsManager = this.mDvfsManager;
        if (semDvfsManager != null) {
            semDvfsManager.addResourceValue(TYPE_RESOURCE_CPU_MIN, i);
        }
    }

    @Override // com.samsung.android.spen.libinterface.DvfsManagerInterface
    public void acquire(int i) {
        SemDvfsManager semDvfsManager = this.mDvfsManager;
        if (semDvfsManager != null) {
            semDvfsManager.acquire(i);
        }
    }
}
