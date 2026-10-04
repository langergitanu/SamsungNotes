package com.samsung.android.sdk.pen.setting.laserpen;

import android.annotation.SuppressLint;
import android.graphics.Color;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\t\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010J \u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenSettingLaserPenManager;", "", "<init>", "()V", "mLaserPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenSettingLaserPenManager$LaserPenInfoChangedListener;", "mLaserPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "close", "", "setLaserPenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "info", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "setInfo", "", "laserPenInfo", "changeType", "type", "", "changeTypeAndFillInside", "fillInside", "changeColorOption", "changeColor", "colorUIInfo", "hsvColor", "", "maintainAlpha", "notifyChanged", "getColorFromHSV", "srcColor", "hsv", "notifyDataChanged", "Companion", "LaserPenInfoChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenSettingLaserPenManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingLaserPenManager.kt\ncom/samsung/android/sdk/pen/setting/laserpen/SpenSettingLaserPenManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
public final class SpenSettingLaserPenManager {

    @NotNull
    private static final String TAG = "SpenSettingLaserPenManager";

    @NotNull
    private SpenSettingUILaserPenInfo mLaserPenInfo = new SpenSettingUILaserPenInfo();

    @Nullable
    private LaserPenInfoChangedListener mLaserPenInfoChangedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/laserpen/SpenSettingLaserPenManager$LaserPenInfoChangedListener;", "", "onLaserPenInfoChanged", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface LaserPenInfoChangedListener {
        void onLaserPenInfoChanged(@Nullable SpenSettingUILaserPenInfo info);
    }

    private final int getColorFromHSV(int srcColor, float[] hsv, boolean maintainAlpha) {
        return maintainAlpha ? SpenSettingUtil.HSVToColor(Color.alpha(srcColor), hsv) : SpenSettingUtil.HSVToColor(hsv);
    }

    private final void notifyDataChanged() {
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = this.mLaserPenInfo;
        int i = spenSettingUILaserPenInfo.type;
        int i2 = spenSettingUILaserPenInfo.colorOption;
        boolean z = spenSettingUILaserPenInfo.fillInside;
        int i4 = spenSettingUILaserPenInfo.colorUIInfo;
        int i5 = spenSettingUILaserPenInfo.color;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "notifyDataChanged() type=", " colorOption=", ", fillInside=");
        sbM1173s.append(z);
        sbM1173s.append(", colorUIInfo=");
        sbM1173s.append(i4);
        sbM1173s.append(", color=");
        AbstractC11014a.m12329n(i5, "))", TAG, sbM1173s);
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo2 = this.mLaserPenInfo;
        float f = spenSettingUILaserPenInfo2.blurSize;
        float f4 = spenSettingUILaserPenInfo2.strokeSize;
        float f5 = spenSettingUILaserPenInfo2.insideRatio;
        int i6 = spenSettingUILaserPenInfo2.waitingTime;
        int i7 = spenSettingUILaserPenInfo2.fadeOutTime;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("notifyDataChanged() blurSize=", f, ", strokeSize=", f4, ", insideRatio=");
        sbM1176v.append(f5);
        sbM1176v.append(", waitingTime=");
        sbM1176v.append(i6);
        sbM1176v.append(", fadeoutTime=");
        AbstractC0000a.m26w(sbM1176v, TAG, i7);
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo3 = this.mLaserPenInfo;
        int i8 = spenSettingUILaserPenInfo3.rainbowDistance;
        int i9 = spenSettingUILaserPenInfo3.rainbowTime;
        AbstractC0000a.m26w(AbstractC0622a.m1173s(i8, i9, "notifyDataChanged() rainbowDistance=", ", rainbowTime=", ", rainbowEffectType="), TAG, spenSettingUILaserPenInfo3.rainbowEffectType);
        LaserPenInfoChangedListener laserPenInfoChangedListener = this.mLaserPenInfoChangedListener;
        if (laserPenInfoChangedListener != null) {
            laserPenInfoChangedListener.onLaserPenInfoChanged(new SpenSettingUILaserPenInfo(this.mLaserPenInfo));
        }
    }

    public final boolean changeColor(int colorUIInfo, @NotNull float[] hsvColor, boolean maintainAlpha, boolean notifyChanged) {
        boolean z;
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z2 = true;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(colorUIInfo), Float.valueOf(hsvColor[0]), Float.valueOf(hsvColor[1]), Float.valueOf(hsvColor[2]), maintainAlpha ? "TRUE" : "FALSE"}, 5, "changeColor() info=%d, hsv[%f, %f, %f] maintainAlpha=%s", "format(format, *args)", TAG);
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = this.mLaserPenInfo;
        if (spenSettingUILaserPenInfo.colorUIInfo != colorUIInfo) {
            spenSettingUILaserPenInfo.colorUIInfo = colorUIInfo;
            z = true;
        } else {
            z = false;
        }
        if (Arrays.equals(spenSettingUILaserPenInfo.hsvColor, hsvColor)) {
            z2 = z;
        } else {
            System.arraycopy(hsvColor, 0, this.mLaserPenInfo.hsvColor, 0, 3);
            SpenSettingUILaserPenInfo spenSettingUILaserPenInfo2 = this.mLaserPenInfo;
            spenSettingUILaserPenInfo2.color = getColorFromHSV(spenSettingUILaserPenInfo2.color, spenSettingUILaserPenInfo2.hsvColor, maintainAlpha);
        }
        if (z2 && notifyChanged) {
            notifyDataChanged();
        }
        return z2;
    }

    public final boolean changeColorOption(int type) {
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = this.mLaserPenInfo;
        if (spenSettingUILaserPenInfo.colorOption == type) {
            return false;
        }
        spenSettingUILaserPenInfo.colorOption = type;
        notifyDataChanged();
        return true;
    }

    public final boolean changeType(int type) {
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = this.mLaserPenInfo;
        if (spenSettingUILaserPenInfo.type == type) {
            return false;
        }
        spenSettingUILaserPenInfo.type = type;
        notifyDataChanged();
        return true;
    }

    public final boolean changeTypeAndFillInside(int type, boolean fillInside) {
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = this.mLaserPenInfo;
        int i = spenSettingUILaserPenInfo.type;
        boolean z = false;
        if (i == type && spenSettingUILaserPenInfo.fillInside == fillInside) {
            return false;
        }
        boolean z2 = true;
        if (i != type) {
            spenSettingUILaserPenInfo.type = type;
            z = true;
        }
        if (spenSettingUILaserPenInfo.fillInside != fillInside) {
            spenSettingUILaserPenInfo.fillInside = fillInside;
        } else {
            z2 = z;
        }
        if (z2) {
            notifyDataChanged();
        }
        return z2;
    }

    public final void close() {
        this.mLaserPenInfoChangedListener = null;
    }

    @NotNull
    public final SpenSettingUILaserPenInfo getInfo() {
        return new SpenSettingUILaserPenInfo(this.mLaserPenInfo);
    }

    public final boolean setInfo(@Nullable SpenSettingUILaserPenInfo laserPenInfo) {
        if (laserPenInfo == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'LaserPenInfo' is null.");
        }
        if (Intrinsics.areEqual(this.mLaserPenInfo, laserPenInfo)) {
            return false;
        }
        this.mLaserPenInfo.copy(laserPenInfo);
        return true;
    }

    public final void setLaserPenInfoChangedListener(@Nullable LaserPenInfoChangedListener listener) {
        this.mLaserPenInfoChangedListener = listener;
    }
}
