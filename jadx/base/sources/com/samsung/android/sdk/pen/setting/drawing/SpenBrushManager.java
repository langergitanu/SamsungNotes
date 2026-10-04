package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingDataManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDataManager", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingDataManager;", "close", "", "hasAlphaValue", "", "penName", "", "isSupportParticleDensity", "isSupportSize", "getMaxPenSizeDp", "", "loadedPen", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushManager {

    @NotNull
    private static final String TAG = "SpenBrushManager";

    @NotNull
    private SpenSettingDataManager mDataManager;

    public SpenBrushManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDataManager = new SpenSettingDataManager(context);
        List<String> penNameList = SpenBrushUIPolicy.INSTANCE.getPenNameList(context);
        penNameList.add(SpenPenManager.SPEN_ERASER);
        this.mDataManager.setPenNameList(penNameList, false);
    }

    private final int loadedPen(String penName) {
        int penIndex = this.mDataManager.getPenIndex(penName);
        Log.i(TAG, "loadPen name=" + penName + " index=" + penIndex);
        if (penIndex <= -1 || !this.mDataManager.loadPenPlugin(penIndex, penName)) {
            return -1;
        }
        return penIndex;
    }

    public final void close() {
        this.mDataManager.close();
    }

    public final float getMaxPenSizeDp(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        int iLoadedPen = loadedPen(penName);
        if (iLoadedPen > -1) {
            return this.mDataManager.getMaxSettingValue(iLoadedPen);
        }
        AbstractC4539a.m3207q("getMaxPenSizeDp() Invalid Pen (", penName, ")", TAG);
        return -1.0f;
    }

    public final boolean hasAlphaValue(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        int iLoadedPen = loadedPen(penName);
        if (iLoadedPen > -1) {
            return this.mDataManager.hasAlphaValue(iLoadedPen);
        }
        AbstractC4539a.m3207q("hasAlphaValue() Invalid Pen (", penName, ")", TAG);
        return false;
    }

    public final boolean isSupportParticleDensity(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        int iLoadedPen = loadedPen(penName);
        if (iLoadedPen > -1) {
            return this.mDataManager.isSupportParticleDensity(iLoadedPen);
        }
        AbstractC4539a.m3207q("isSupportParticleDensity() Invalid Pen (", penName, ")", TAG);
        return false;
    }

    public final boolean isSupportSize(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        int iLoadedPen = loadedPen(penName);
        if (iLoadedPen > -1) {
            return this.mDataManager.isSupportSize(iLoadedPen);
        }
        AbstractC4539a.m3207q("isSupportSize() Invalid Pen (", penName, ")", TAG);
        return false;
    }
}
