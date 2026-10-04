package com.samsung.android.sdk.pen.setting.changestyle;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0010\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J.\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rJ\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0017H\u0002J \u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager;", "", "<init>", "()V", "mChangeStyleInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "mChangeStyleInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager$ChangeStyleInfoChangedListener;", "close", "", "setChangeStyleInfoChangedListener", "infoChangedListener", "setChangeStyleInfo", "", "changeStyleInfo", "getChangeStyleInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "changeType", "type", "", "changeColor", "info", "hsvColor", "", "maintainAlpha", "notifyChanged", "changeSizeLevel", "sizeLevel", "changeBlankShape", "isBlackShape", "updateHSVColor", "src", "dest", "getColorFromHSV", "srcColor", "hsv", "notifyDataChanged", "Companion", "ChangeStyleInfoChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenSettingChangeStyleManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingChangeStyleManager.kt\ncom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,183:1\n1#2:184\n*E\n"})
public final class SpenSettingChangeStyleManager {
    private static final int HSV_COLOR_SIZE = 3;

    @NotNull
    private static final String TAG = "SpenSettingChangeStyleManager";

    @NotNull
    private SpenSettingUIChangeStyleInfo mChangeStyleInfo = new SpenSettingUIChangeStyleInfo();

    @Nullable
    private ChangeStyleInfoChangedListener mChangeStyleInfoChangedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager$ChangeStyleInfoChangedListener;", "", "onChangeStyleInfoChanged", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ChangeStyleInfoChangedListener {
        void onChangeStyleInfoChanged(@Nullable SpenSettingUIChangeStyleInfo info);
    }

    private final int getColorFromHSV(int srcColor, float[] hsv, boolean maintainAlpha) {
        return maintainAlpha ? SpenSettingUtil.HSVToColor(Color.alpha(srcColor), hsv) : SpenSettingUtil.HSVToColor(hsv);
    }

    private final void notifyDataChanged() {
        ChangeStyleInfoChangedListener changeStyleInfoChangedListener = this.mChangeStyleInfoChangedListener;
        if (changeStyleInfoChangedListener != null) {
            changeStyleInfoChangedListener.onChangeStyleInfoChanged(new SpenSettingUIChangeStyleInfo(this.mChangeStyleInfo));
        }
    }

    private final boolean updateHSVColor(float[] src, float[] dest) {
        if (Arrays.equals(src, dest)) {
            return false;
        }
        System.arraycopy(src, 0, dest, 0, 3);
        return true;
    }

    public final boolean changeBlankShape(boolean isBlackShape) {
        Log.i(TAG, "changeBlankShape [" + this.mChangeStyleInfo.isBlankShape + ", -> " + isBlackShape + "]");
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = this.mChangeStyleInfo;
        if (spenSettingUIChangeStyleInfo.isBlankShape == isBlackShape) {
            return false;
        }
        spenSettingUIChangeStyleInfo.isBlankShape = isBlackShape;
        notifyDataChanged();
        return true;
    }

    public final boolean changeColor(int type, int info, @NotNull float[] hsvColor, boolean maintainAlpha, boolean notifyChanged) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = false;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(type), Integer.valueOf(info), Float.valueOf(hsvColor[0]), Float.valueOf(hsvColor[1]), Float.valueOf(hsvColor[2]), maintainAlpha ? "TRUE" : "FALSE"}, 6, "changeColor() type=%d, info=%d, hsv[%f, %f, %f] maintainAlpha=%s", "format(format, *args)", TAG);
        if (type == 0) {
            SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = this.mChangeStyleInfo;
            if (spenSettingUIChangeStyleInfo.strokeColorUIInfo != info) {
                spenSettingUIChangeStyleInfo.strokeColorUIInfo = info;
                z = true;
            }
            if (updateHSVColor(hsvColor, spenSettingUIChangeStyleInfo.strokeHSVColor)) {
                SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo2 = this.mChangeStyleInfo;
                spenSettingUIChangeStyleInfo2.color = getColorFromHSV(spenSettingUIChangeStyleInfo2.color, hsvColor, maintainAlpha);
                z = true;
            }
        } else if (type == 1) {
            SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo3 = this.mChangeStyleInfo;
            if (spenSettingUIChangeStyleInfo3.fillColorUIInfo != info) {
                spenSettingUIChangeStyleInfo3.fillColorUIInfo = info;
                z = true;
            }
            if (updateHSVColor(hsvColor, spenSettingUIChangeStyleInfo3.fillHSVColor)) {
                SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo4 = this.mChangeStyleInfo;
                spenSettingUIChangeStyleInfo4.fillColor = getColorFromHSV(spenSettingUIChangeStyleInfo4.fillColor, hsvColor, maintainAlpha);
                z = true;
            }
        }
        if (z && notifyChanged) {
            notifyDataChanged();
        }
        return z;
    }

    public final boolean changeSizeLevel(int sizeLevel) {
        Log.i(TAG, AbstractC0622a.m1164j(this.mChangeStyleInfo.sizeLevel, sizeLevel, "changeSizeLevel [", ", -> ", "]"));
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = this.mChangeStyleInfo;
        if (spenSettingUIChangeStyleInfo.sizeLevel == sizeLevel) {
            return false;
        }
        spenSettingUIChangeStyleInfo.sizeLevel = sizeLevel;
        notifyDataChanged();
        return true;
    }

    public final boolean changeType(int type) {
        Log.i(TAG, AbstractC0622a.m1164j(this.mChangeStyleInfo.type, type, "changeType [", ", -> ", "]"));
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = this.mChangeStyleInfo;
        if (spenSettingUIChangeStyleInfo.type == type) {
            return false;
        }
        spenSettingUIChangeStyleInfo.type = type;
        notifyDataChanged();
        return true;
    }

    public final void close() {
        this.mChangeStyleInfoChangedListener = null;
    }

    @NotNull
    public final SpenSettingUIChangeStyleInfo getChangeStyleInfo() {
        return new SpenSettingUIChangeStyleInfo(this.mChangeStyleInfo);
    }

    public final boolean setChangeStyleInfo(@Nullable SpenSettingUIChangeStyleInfo changeStyleInfo) {
        if (changeStyleInfo == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'changeStyleInfo' is null.");
        }
        if (Intrinsics.areEqual(this.mChangeStyleInfo, changeStyleInfo)) {
            return false;
        }
        this.mChangeStyleInfo.copy(changeStyleInfo);
        return true;
    }

    public final void setChangeStyleInfoChangedListener(@Nullable ChangeStyleInfoChangedListener infoChangedListener) {
        this.mChangeStyleInfoChangedListener = infoChangedListener;
    }
}
