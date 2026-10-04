package com.samsung.android.sdk.pen.setting.quicktool;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0011J\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\nJ\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u0004\u0018\u00010\bJ\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\b\u0010&\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001bH\u0002J \u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020/2\u0006\u00100\u001a\u00020\nH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenInfoManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mIsSupportAlpha", "", "mIsSupportFixedWidth", "mIndex", "", "mPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenInfoChangedListener;", "close", "", "setPenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "clearPenInfo", "updatePenInfo", "info", "index", "notify", "updateColor", "hsvColor", "", "updateFixedWidth", "isFixedWidth", "updateAlpha", "alpha", "updateSizeLevel", "sizeLevel", "getPenIndex", "getPenInfo", "isSupportAlpha", "isSupportFixedWidth", "notifyDataChanged", "updatePenAttributes", "penName", "", "copyColor", "src", "dst", "printInfo", "pre", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "penInfoOnly", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQTPenInfoManager {

    @NotNull
    private static final String TAG = "SpenQTPenInfoManager";

    @Nullable
    private Context mContext;
    private int mIndex;
    private boolean mIsSupportAlpha;
    private boolean mIsSupportFixedWidth;

    @Nullable
    private SpenSettingUIPenInfo mPenInfo;

    @Nullable
    private SpenSettingQTPenInfoChangedListener mPenInfoChangedListener;

    public SpenQTPenInfoManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mIndex = -1;
    }

    private final void copyColor(float[] src, float[] dst) {
        if (src.length == 3 && dst.length == 3) {
            System.arraycopy(src, 0, dst, 0, 3);
        }
    }

    private final void notifyDataChanged() {
        SpenSettingQTPenInfoChangedListener spenSettingQTPenInfoChangedListener;
        SpenSettingUIPenInfo penInfo = getPenInfo();
        if (penInfo == null || (spenSettingQTPenInfoChangedListener = this.mPenInfoChangedListener) == null) {
            return;
        }
        spenSettingQTPenInfoChangedListener.onPenInfoChanged(this.mIndex, penInfo);
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

    private final void updatePenAttributes(String penName) {
        SpenPenManager spenPenManager = new SpenPenManager(this.mContext);
        try {
            try {
                SpenPen spenPenCreatePen = spenPenManager.createPen(penName);
                boolean z = true;
                this.mIsSupportAlpha = spenPenCreatePen.getPenAttribute(1);
                if (penName.compareTo(SpenPenManager.SPEN_INK_PEN2) != 0) {
                    z = false;
                }
                this.mIsSupportFixedWidth = z;
                spenPenManager.destroyPen(spenPenCreatePen);
            } catch (Exception unused) {
                this.mIsSupportAlpha = false;
                this.mIsSupportFixedWidth = false;
            }
            AbstractC0000a.m27x(AbstractC2821a.m2229t("updatePenAttributes() name=", penName, ", alphaVisible=", this.mIsSupportAlpha, ", fixedWidth="), this.mIsSupportFixedWidth, TAG);
        } finally {
            spenPenManager.close();
        }
    }

    public static /* synthetic */ boolean updatePenInfo$default(SpenQTPenInfoManager spenQTPenInfoManager, SpenSettingUIPenInfo spenSettingUIPenInfo, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        return spenQTPenInfoManager.updatePenInfo(spenSettingUIPenInfo, i, z);
    }

    public final void clearPenInfo() {
        Log.i(TAG, "clearPenInfo()");
        this.mPenInfo = null;
        this.mIsSupportAlpha = false;
        this.mIsSupportFixedWidth = false;
        this.mIndex = -1;
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mContext = null;
        this.mPenInfoChangedListener = null;
        clearPenInfo();
    }

    /* JADX INFO: renamed from: getPenIndex, reason: from getter */
    public final int getMIndex() {
        return this.mIndex;
    }

    @Nullable
    public final SpenSettingUIPenInfo getPenInfo() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfo;
        if (spenSettingUIPenInfo == null) {
            return null;
        }
        Intrinsics.checkNotNull(spenSettingUIPenInfo);
        return new SpenSettingUIPenInfo(spenSettingUIPenInfo);
    }

    /* JADX INFO: renamed from: isSupportAlpha, reason: from getter */
    public final boolean getMIsSupportAlpha() {
        return this.mIsSupportAlpha;
    }

    /* JADX INFO: renamed from: isSupportFixedWidth, reason: from getter */
    public final boolean getMIsSupportFixedWidth() {
        return this.mIsSupportFixedWidth;
    }

    public final void setPenInfoChangedListener(@NotNull SpenSettingQTPenInfoChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPenInfoChangedListener = listener;
    }

    public final boolean updateAlpha(int alpha) {
        int currentAlpha;
        if (this.mPenInfo == null) {
            return false;
        }
        AbstractC2322a.m1631u(alpha, "updateAlpha() alpha=", TAG);
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfo;
        if (spenSettingUIPenInfo == null || (currentAlpha = SpenSettingUtilOpacity.setCurrentAlpha(spenSettingUIPenInfo.color, alpha)) == spenSettingUIPenInfo.color) {
            return false;
        }
        spenSettingUIPenInfo.color = currentAlpha;
        notifyDataChanged();
        return true;
    }

    public final boolean updateColor(int info, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        boolean z = false;
        if (this.mPenInfo == null) {
            return false;
        }
        boolean z2 = true;
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("updateColor() [", info, ", [", hsvColor[0], SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfo;
        if (spenSettingUIPenInfo != null && spenSettingUIPenInfo.colorUIInfo == info) {
            z = true;
        }
        boolean z3 = !z;
        int iHSVToColor = SpenSettingUtil.HSVToColor(hsvColor);
        SpenSettingUIPenInfo spenSettingUIPenInfo2 = this.mPenInfo;
        if (spenSettingUIPenInfo2 != null) {
            int currentAlpha = SpenSettingUtilOpacity.setCurrentAlpha(iHSVToColor, Color.alpha(spenSettingUIPenInfo2.color));
            if (currentAlpha != spenSettingUIPenInfo2.color) {
                spenSettingUIPenInfo2.color = currentAlpha;
            } else {
                z2 = z3;
            }
            copyColor(hsvColor, spenSettingUIPenInfo2.hsv);
            spenSettingUIPenInfo2.colorUIInfo = info;
            z3 = z2;
        }
        if (z3) {
            notifyDataChanged();
        }
        return z3;
    }

    public final boolean updateFixedWidth(boolean isFixedWidth) {
        if (this.mPenInfo == null) {
            return false;
        }
        AbstractC4539a.m3208r("updateFixedWidth() isFixedWidth=", TAG, isFixedWidth);
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfo;
        if (spenSettingUIPenInfo != null && spenSettingUIPenInfo.isFixedWidth == isFixedWidth) {
            return false;
        }
        if (spenSettingUIPenInfo != null) {
            spenSettingUIPenInfo.isFixedWidth = isFixedWidth;
        }
        notifyDataChanged();
        return true;
    }

    public final boolean updatePenInfo(@NotNull SpenSettingUIPenInfo info, int index, boolean notify) {
        Intrinsics.checkNotNullParameter(info, "info");
        StringBuilder sb = new StringBuilder("updatePenInfo() index=");
        sb.append(index);
        sb.append(", notify=");
        AbstractC0000a.m27x(sb, notify, TAG);
        boolean z = index != this.mIndex;
        this.mIndex = index;
        boolean zUpdatePenInfo = updatePenInfo(info) | z;
        if (zUpdatePenInfo && notify) {
            notifyDataChanged();
        }
        return zUpdatePenInfo;
    }

    public final boolean updateSizeLevel(int sizeLevel) {
        if (this.mPenInfo == null) {
            return false;
        }
        AbstractC2322a.m1631u(sizeLevel, "updateSizeLevel() level=", TAG);
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfo;
        if (spenSettingUIPenInfo != null && spenSettingUIPenInfo.sizeLevel == sizeLevel) {
            return false;
        }
        if (spenSettingUIPenInfo != null) {
            spenSettingUIPenInfo.sizeLevel = sizeLevel;
        }
        notifyDataChanged();
        return true;
    }

    private final boolean updatePenInfo(SpenSettingUIPenInfo info) {
        SpenSettingUIPenInfo spenSettingUIPenInfo = this.mPenInfo;
        if (spenSettingUIPenInfo == null) {
            this.mPenInfo = new SpenSettingUIPenInfo(info);
            updatePenAttributes(info.name);
            return true;
        }
        if (Intrinsics.areEqual(spenSettingUIPenInfo, info)) {
            SpenSettingUIPenInfo spenSettingUIPenInfo2 = this.mPenInfo;
            Intrinsics.checkNotNull(spenSettingUIPenInfo2);
            if (spenSettingUIPenInfo2.colorUIInfo == info.colorUIInfo) {
                Log.i(TAG, "Same Info.");
                return false;
            }
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo3 = this.mPenInfo;
        if (spenSettingUIPenInfo3 != null) {
            boolean z = spenSettingUIPenInfo3.name.compareTo(info.name) != 0;
            spenSettingUIPenInfo3.name = info.name;
            spenSettingUIPenInfo3.colorUIInfo = info.colorUIInfo;
            spenSettingUIPenInfo3.size = info.size;
            spenSettingUIPenInfo3.sizeLevel = info.sizeLevel;
            System.arraycopy(info.hsv, 0, spenSettingUIPenInfo3.hsv, 0, 3);
            spenSettingUIPenInfo3.color = info.color;
            spenSettingUIPenInfo3.isFixedWidth = info.isFixedWidth;
            spenSettingUIPenInfo3.particleSize = info.particleSize;
            spenSettingUIPenInfo3.particleDensity = info.particleDensity;
            if (z) {
                updatePenAttributes(info.name);
            }
        }
        printInfo("updatePenInfo", info, false);
        return true;
    }
}
