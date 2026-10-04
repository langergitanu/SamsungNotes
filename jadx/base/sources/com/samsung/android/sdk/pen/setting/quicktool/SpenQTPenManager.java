package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 E2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0014\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u001c\u0010\u0019\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\nJ\u0016\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0002J\f\u0010(\u001a\u00020)*\u00020)H\u0002J\u0018\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)H\u0002J\u000e\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nJ\u000e\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020)J\u0006\u00105\u001a\u00020\u001dJ\b\u00106\u001a\u0004\u0018\u00010\u0018J\u0010\u00106\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u00107\u001a\u00020\nJ\u0006\u00108\u001a\u00020\nJ\u0006\u00109\u001a\u00020\nJ\b\u0010:\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$H\u0002J \u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020=2\u0006\u0010 \u001a\u00020C2\u0006\u0010D\u001a\u00020\nH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mPenListManager", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListManager;", "mIsSupportAlpha", "", "mIsSupportFixedWidth", "mIsSupportParticleSize", "mPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenInfoChangedListener;", "close", "", "clearData", "setPenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "clearPenInfo", "getPenInfoList", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setPenInfoList", "penInfoList", "", "currentIndex", "", "updatePenInfo", "index", "info", "notify", "updateColor", "hsvColor", "", "isSameColor", "hsv1", "hsv2", "roundToTwoDecimalPlaces", "", "compareFloats", "a", "b", "updateFixedWidth", "isFixedWidth", "updateAlpha", "alpha", "updateSizeLevel", "sizeLevel", "updateParticleSize", "particleSize", "getPenIndex", "getPenInfo", "isSupportAlpha", "isSupportFixedWidth", "isSupportParticleSize", "notifyDataChanged", "updatePenAttributes", "penName", "", "copyColor", "src", "dst", "printInfo", "pre", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "penInfoOnly", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQTPenManager {

    @NotNull
    private static final String TAG = "SpenQTPenManager";

    @Nullable
    private Context mContext;
    private boolean mIsSupportAlpha;
    private boolean mIsSupportFixedWidth;
    private boolean mIsSupportParticleSize;

    @Nullable
    private SpenSettingQTPenInfoChangedListener mPenInfoChangedListener;

    @NotNull
    private final SpenQTPenListManager mPenListManager;

    public SpenQTPenManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mPenListManager = new SpenQTPenListManager();
    }

    private final void clearPenInfo() {
        Log.i(TAG, "clearPenInfo()");
        this.mIsSupportAlpha = false;
        this.mIsSupportFixedWidth = false;
    }

    private final boolean compareFloats(float a, float b) {
        return roundToTwoDecimalPlaces(a) == roundToTwoDecimalPlaces(b);
    }

    private final void copyColor(float[] src, float[] dst) {
        if (src.length == 3 && dst.length == 3) {
            System.arraycopy(src, 0, dst, 0, 3);
        }
    }

    private final boolean isSameColor(float[] hsv1, float[] hsv2) {
        return ((int) hsv1[0]) == ((int) hsv2[0]) && compareFloats(hsv1[1], hsv2[1]) && compareFloats(hsv1[2], hsv2[2]);
    }

    private final void notifyDataChanged() {
        SpenSettingQTPenInfoChangedListener spenSettingQTPenInfoChangedListener;
        SpenSettingUIPenInfo currentPenInfo = this.mPenListManager.getCurrentPenInfo();
        if (currentPenInfo == null || (spenSettingQTPenInfoChangedListener = this.mPenInfoChangedListener) == null) {
            return;
        }
        spenSettingQTPenInfoChangedListener.onPenInfoChanged(this.mPenListManager.getMCurrentIndex(), currentPenInfo);
    }

    private final void printInfo(String pre, SpenSettingPenInfo info, boolean penInfoOnly) {
        AbstractC4539a.m3207q("===== ", pre, " =====", TAG);
        AbstractC6670b.m4756q(" name = ", info.name, TAG);
        AbstractC4539a.m3205o(" size = ", TAG, info.size);
        AbstractC2322a.m1631u(info.sizeLevel, " level = ", TAG);
        int i = info.color;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC11014a.m12328m(i, " color = ", AbstractC2322a.m1624n("#%08X", new Object[]{Integer.valueOf(i)}, 1, "format(format, *args)"), TAG);
        if (!penInfoOnly && (info instanceof SpenSettingUIPenInfo)) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = (SpenSettingUIPenInfo) info;
            float[] fArr = spenSettingUIPenInfo.hsv;
            AbstractC2821a.m2234y(AbstractC0622a.m1176v(" hsv[", fArr[0], SQLKeyword.COMMA, fArr[1], SQLKeyword.COMMA), fArr[2], "]", TAG);
            AbstractC2322a.m1631u(spenSettingUIPenInfo.colorUIInfo, " colorUI = ", TAG);
        }
        AbstractC4539a.m3205o(" particleSize = ", TAG, info.particleSize);
        Log.i(TAG, " isFixedWidth = ".concat(info.isFixedWidth ? "TRUE" : "FALSE"));
        Log.i(TAG, "======================");
    }

    private final float roundToTwoDecimalPlaces(float f) {
        return ((float) Math.rint(f * r0)) / 100;
    }

    private final void updatePenAttributes(String penName) {
        SpenPenManager spenPenManager = new SpenPenManager(this.mContext);
        boolean z = true;
        try {
            try {
                SpenPen spenPenCreatePen = spenPenManager.createPen(penName);
                this.mIsSupportAlpha = spenPenCreatePen.getPenAttribute(1);
                this.mIsSupportFixedWidth = false;
                this.mIsSupportParticleSize = spenPenCreatePen.getPenAttribute(6);
                spenPenManager.destroyPen(spenPenCreatePen);
            } catch (Exception unused) {
                this.mIsSupportAlpha = false;
                this.mIsSupportFixedWidth = false;
                this.mIsSupportParticleSize = false;
                if (penName.compareTo(SpenPenManager.SPEN_MOSAIC_PEN) != 0) {
                    z = false;
                }
                this.mIsSupportParticleSize = z;
            }
            AbstractC0000a.m27x(AbstractC2821a.m2229t("updatePenAttributes() name=", penName, ", alphaVisible=", this.mIsSupportAlpha, ", fixedWidth="), this.mIsSupportFixedWidth, TAG);
        } finally {
            spenPenManager.close();
        }
    }

    public static /* synthetic */ boolean updatePenInfo$default(SpenQTPenManager spenQTPenManager, int i, SpenSettingUIPenInfo spenSettingUIPenInfo, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        return spenQTPenManager.updatePenInfo(i, spenSettingUIPenInfo, z);
    }

    public final void clearData() {
        this.mPenListManager.setPenInfoList(new ArrayList(), -1);
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mContext = null;
        this.mPenInfoChangedListener = null;
        this.mPenListManager.close();
        clearPenInfo();
    }

    public final int getPenIndex() {
        return this.mPenListManager.getMCurrentIndex();
    }

    @Nullable
    public final SpenSettingUIPenInfo getPenInfo() {
        return this.mPenListManager.getCurrentPenInfo();
    }

    public final boolean getPenInfoList(@NotNull List<SpenSettingUIPenInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return this.mPenListManager.getPenInfoList(list);
    }

    /* JADX INFO: renamed from: isSupportAlpha, reason: from getter */
    public final boolean getMIsSupportAlpha() {
        return this.mIsSupportAlpha;
    }

    /* JADX INFO: renamed from: isSupportFixedWidth, reason: from getter */
    public final boolean getMIsSupportFixedWidth() {
        return this.mIsSupportFixedWidth;
    }

    /* JADX INFO: renamed from: isSupportParticleSize, reason: from getter */
    public final boolean getMIsSupportParticleSize() {
        return this.mIsSupportParticleSize;
    }

    public final void setPenInfoChangedListener(@NotNull SpenSettingQTPenInfoChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPenInfoChangedListener = listener;
        this.mPenListManager.setPenInfoChangedListener(listener);
    }

    public final void setPenInfoList(@NotNull List<? extends SpenSettingUIPenInfo> penInfoList, int currentIndex) {
        SpenSettingUIPenInfo penInfo;
        Intrinsics.checkNotNullParameter(penInfoList, "penInfoList");
        int penInfoList2 = this.mPenListManager.setPenInfoList(penInfoList, currentIndex);
        AbstractC2322a.m1631u(penInfoList2, "setPenInfoList() result=", TAG);
        if ((penInfoList2 & 2) != 2 || (penInfo = getPenInfo()) == null) {
            return;
        }
        updatePenAttributes(penInfo.name);
    }

    public final boolean updateAlpha(int alpha) {
        int currentAlpha;
        if (this.mPenListManager.getMCurrentIndex() == -1) {
            Log.i(TAG, "invalid current pen index.");
            return false;
        }
        AbstractC2322a.m1631u(alpha, "updateAlpha() alpha=", TAG);
        SpenSettingUIPenInfo currentPen$SDK_fullRelease = this.mPenListManager.getCurrentPen$SDK_fullRelease();
        if (currentPen$SDK_fullRelease == null || (currentAlpha = SpenSettingUtilOpacity.setCurrentAlpha(currentPen$SDK_fullRelease.color, alpha)) == currentPen$SDK_fullRelease.color) {
            return false;
        }
        currentPen$SDK_fullRelease.color = currentAlpha;
        notifyDataChanged();
        return true;
    }

    public final boolean updateColor(int info, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        if (this.mPenListManager.getMCurrentIndex() == -1) {
            Log.i(TAG, "invalid current pen index.");
            return false;
        }
        SpenSettingUIPenInfo currentPen$SDK_fullRelease = this.mPenListManager.getCurrentPen$SDK_fullRelease();
        if (currentPen$SDK_fullRelease == null) {
            return false;
        }
        boolean z = true;
        boolean z2 = (currentPen$SDK_fullRelease.colorUIInfo == info && Intrinsics.areEqual(hsvColor, currentPen$SDK_fullRelease.hsv)) ? false : true;
        int currentAlpha = SpenSettingUtilOpacity.setCurrentAlpha(SpenSettingUtil.HSVToColor(hsvColor), Color.alpha(currentPen$SDK_fullRelease.color));
        if (currentAlpha != currentPen$SDK_fullRelease.color) {
            currentPen$SDK_fullRelease.color = currentAlpha;
        } else if (isSameColor(currentPen$SDK_fullRelease.hsv, hsvColor)) {
            z = z2;
        }
        copyColor(hsvColor, currentPen$SDK_fullRelease.hsv);
        currentPen$SDK_fullRelease.colorUIInfo = info;
        if (z) {
            notifyDataChanged();
        }
        return z;
    }

    public final boolean updateFixedWidth(boolean isFixedWidth) {
        if (this.mPenListManager.getMCurrentIndex() == -1) {
            Log.i(TAG, "invalid current pen index.");
            return false;
        }
        AbstractC4539a.m3208r("updateFixedWidth() isFixedWidth=", TAG, isFixedWidth);
        SpenSettingUIPenInfo currentPen$SDK_fullRelease = this.mPenListManager.getCurrentPen$SDK_fullRelease();
        if (currentPen$SDK_fullRelease == null || currentPen$SDK_fullRelease.isFixedWidth == isFixedWidth) {
            return false;
        }
        currentPen$SDK_fullRelease.isFixedWidth = isFixedWidth;
        notifyDataChanged();
        return true;
    }

    public final boolean updateParticleSize(float particleSize) {
        if (this.mPenListManager.getMCurrentIndex() == -1) {
            Log.i(TAG, "invalid current pen index.");
            return false;
        }
        AbstractC4539a.m3205o("updateParticleSize() particleSize=", TAG, particleSize);
        SpenSettingUIPenInfo currentPen$SDK_fullRelease = this.mPenListManager.getCurrentPen$SDK_fullRelease();
        if (currentPen$SDK_fullRelease == null || currentPen$SDK_fullRelease.particleSize == particleSize) {
            return false;
        }
        currentPen$SDK_fullRelease.particleSize = particleSize;
        notifyDataChanged();
        return true;
    }

    public final boolean updatePenInfo(int index, @NotNull SpenSettingUIPenInfo info, boolean notify) {
        String str;
        Intrinsics.checkNotNullParameter(info, "info");
        Log.i(TAG, "updatePenInfo() index=" + index + ", notify=" + notify);
        SpenSettingUIPenInfo penInfo = getPenInfo();
        boolean z = (penInfo == null || (str = penInfo.name) == null || str.compareTo(info.name) != 0) ? false : true;
        boolean zUpdateCurrentPenInfo = this.mPenListManager.getMCurrentIndex() == index ? this.mPenListManager.updateCurrentPenInfo(info, false) : this.mPenListManager.setCurrentPenInfo(index, info, false);
        if (zUpdateCurrentPenInfo) {
            if (!z) {
                updatePenAttributes(info.name);
            }
            if (notify) {
                notifyDataChanged();
            }
        }
        return zUpdateCurrentPenInfo;
    }

    public final boolean updateSizeLevel(int sizeLevel) {
        if (this.mPenListManager.getMCurrentIndex() == -1) {
            Log.i(TAG, "invalid current pen index.");
            return false;
        }
        AbstractC2322a.m1631u(sizeLevel, "updateSizeLevel() level=", TAG);
        SpenSettingUIPenInfo currentPen$SDK_fullRelease = this.mPenListManager.getCurrentPen$SDK_fullRelease();
        if (currentPen$SDK_fullRelease == null || currentPen$SDK_fullRelease.sizeLevel == sizeLevel) {
            return false;
        }
        currentPen$SDK_fullRelease.sizeLevel = sizeLevel;
        notifyDataChanged();
        return true;
    }

    @Nullable
    public final SpenSettingUIPenInfo getPenInfo(int index) {
        return this.mPenListManager.getPenInfo(index);
    }
}
