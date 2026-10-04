package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingDataManager;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u001a\u001a\u00020\u00112\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cJ\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\rJ\u0010\u0010%\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u0006J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u000fJ\u0010\u0010*\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u0006J\u0006\u0010+\u001a\u00020\u000fJ\u0010\u0010,\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u0006J\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u000fJ\u0010\u00101\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u00103\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0018H\u0002J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001dH\u0002J\u0010\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u000206H\u0002J\u001e\u0010<\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010 \u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u00108\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\"¨\u0006@"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenSettingPenManager;", "", "context", "Landroid/content/Context;", "customizedPenList", "", "", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", SearchConstants.TargetContents.TAG, "mDataManager", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingDataManager;", "mPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/pencommon/PenInfoChangedListener;", "mEnableAlphaChange", "", "close", "", "setEnableAlphaChange", "enableChange", "penNameList", "getPenNameList", "()Ljava/util/List;", "penInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "getPenInfoList", "setUIPenInfoList", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setCurrentUIPenInfo", "uiPenInfo", "currentUIPenInfo", "getCurrentUIPenInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setPenInfoChangedListener", "infoChangedListener", "setCurrentPen", "penName", "isValidPenInfo", "settingInfo", "containsParticleSizePen", "isSupportParticleSize", "containsAlphaChangeablePen", "isSupportAlphaChange", "isSupportFixedWidthChange", "isSupportDynamicSize", "isSupportFixedOpacity", "containsFixedOpacityChangeablePen", "checkPenSize", "checkPenColor", "checkColor", "isHighlighter", "changeWhat", "", "penInfo", "info", "getInfo", "notifyPenInfoChanged", "changeType", "printInfo", "pre", "penInfoOnly", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSettingPenManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingPenManager.kt\ncom/samsung/android/sdk/pen/setting/handwriting/SpenSettingPenManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,367:1\n1#2:368\n*E\n"})
public final class SpenSettingPenManager {
    private static final int CHANGE_ALL = 1;
    private static final int CHANGE_COLOR = 4;
    private static final int CHANGE_OTHERS = 8;
    private static final int CHANGE_SIZE = 2;

    @NotNull
    private static final String FOUNTAIN_MONTBLANC_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.MontblancFountainPen";

    @NotNull
    private static final String HIGHRIGHT_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.Marker2";

    @NotNull
    private static final String MAGIC_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.MagicPen";
    private static final int MARKER_ALPHA_VALUE = 115;

    @NotNull
    private static final String MARKER_PEN_NAME = "Marker";

    @NotNull
    private static final String OBLIQUE_MONBLANCE_PEN_NAME = "com.samsung.android.sdk.pen.pen.preload.MontblancCalligraphyPen";
    private static final int PENCIL2_ALPHA_VALUE = 160;

    @NotNull
    private static final String PENCIL_PEN_NAME = "Pencil2";

    @NotNull
    private final String TAG;

    @NotNull
    private SpenSettingDataManager mDataManager;
    private boolean mEnableAlphaChange;

    @Nullable
    private PenInfoChangedListener mPenInfoChangedListener;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.samsung.android.sdk.pen.setting.pencommon.SpenSettingDataManager] */
    public SpenSettingPenManager(@NotNull Context context, @Nullable List<String> list) {
        ?? penNameList;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpenSettingPenManager";
        if (list != null) {
            penNameList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                penNameList.add(list.get(i));
            }
        } else {
            penNameList = SpenPenUIPolicy.getPenNameList(context);
        }
        this.mEnableAlphaChange = false;
        ?? spenSettingDataManager = new SpenSettingDataManager(context);
        this.mDataManager = spenSettingDataManager;
        spenSettingDataManager.setPenNameList(penNameList, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int changeWhat(SpenSettingUIPenInfo penInfo) {
        int i;
        SpenSettingUIPenInfo info = getInfo();
        if (info == null || info.name.compareTo(penInfo.name) != 0) {
            i = 1;
        } else if (info.colorUIInfo == penInfo.colorUIInfo && info.color == penInfo.color) {
            float[] fArr = info.hsv;
            i = 0;
            float f = fArr[0];
            float[] fArr2 = penInfo.hsv;
            if (f != fArr2[0] || fArr[1] != fArr2[1] || fArr[2] != fArr2[2]) {
            }
            if (info.sizeLevel != penInfo.sizeLevel) {
            }
            if (info.particleSize != penInfo.particleSize) {
            }
            if (info.isFixedWidth != penInfo.isFixedWidth) {
            }
            if (info.isFixedOpacity != penInfo.isFixedOpacity) {
            }
            if (info.isAutoSizeEnabled != penInfo.isAutoSizeEnabled) {
            }
            if (info.fitRatio != penInfo.fitRatio) {
            }
        } else {
            i = 4;
            if (info.sizeLevel != penInfo.sizeLevel) {
                i |= 2;
            }
            if (info.particleSize != penInfo.particleSize) {
                i |= 8;
            }
            if (info.isFixedWidth != penInfo.isFixedWidth) {
                i |= 8;
            }
            if (info.isFixedOpacity != penInfo.isFixedOpacity) {
                i |= 8;
            }
            if (info.isAutoSizeEnabled != penInfo.isAutoSizeEnabled) {
                i |= 8;
            }
            if (info.fitRatio != penInfo.fitRatio) {
                i |= 8;
            }
        }
        if (i == 6) {
            return 1;
        }
        return i;
    }

    private final boolean checkColor(SpenSettingPenInfo settingInfo) {
        int i = settingInfo.color;
        if (((i >> 24) & 255) == 0) {
            if (this.mDataManager.hasAlphaValue(settingInfo.name)) {
                settingInfo.color = Color.argb(1, Color.red(settingInfo.color), Color.green(settingInfo.color), Color.blue(settingInfo.color));
            } else {
                settingInfo.color = Color.rgb(Color.red(settingInfo.color), Color.green(settingInfo.color), Color.blue(settingInfo.color));
            }
        }
        if (!this.mEnableAlphaChange) {
            if (isHighlighter(settingInfo.name)) {
                settingInfo.color = (settingInfo.color & 16777215) | 1929379840;
            } else if (StringsKt.m14162r(settingInfo.name, PENCIL_PEN_NAME)) {
                settingInfo.color = (settingInfo.color & 16777215) | (-1610612736);
            }
        }
        return i != settingInfo.color;
    }

    private final boolean checkPenColor(SpenSettingUIPenInfo uiPenInfo) {
        boolean z;
        int iHSVToColor = SpenSettingUtil.HSVToColor(uiPenInfo.hsv);
        int i = uiPenInfo.color;
        if (iHSVToColor != i) {
            Color.colorToHSV(i, uiPenInfo.hsv);
            z = true;
        } else {
            z = false;
        }
        if (checkColor(uiPenInfo)) {
            return true;
        }
        return z;
    }

    private final boolean checkPenSize(SpenSettingUIPenInfo uiPenInfo) {
        boolean z;
        if (uiPenInfo.size <= 0.0f) {
            Log.i(this.TAG, "checkPenSize() info size <= 0 Pen(" + uiPenInfo.name + ") sizeLevel=" + uiPenInfo.sizeLevel);
            if (uiPenInfo.sizeLevel > 0) {
                uiPenInfo.size = SpenPenUtil.convertSizeLevelToDpSize(this.mDataManager.getContext(), uiPenInfo.name, uiPenInfo.sizeLevel);
            } else {
                uiPenInfo.size = 10.0f;
            }
            z = true;
        } else {
            z = false;
        }
        float f = uiPenInfo.size;
        int i = uiPenInfo.sizeLevel;
        this.mDataManager.setPenSize(uiPenInfo);
        if (f != uiPenInfo.size || i != uiPenInfo.sizeLevel) {
            z = true;
        }
        int penIndex = this.mDataManager.getPenIndex(uiPenInfo.name);
        if (penIndex <= -1) {
            return z;
        }
        float f4 = uiPenInfo.size;
        int i2 = uiPenInfo.sizeLevel;
        this.mDataManager.loadPenPlugin(penIndex, uiPenInfo.name);
        float minSettingValue = this.mDataManager.getMinSettingValue(penIndex);
        float maxSettingValue = this.mDataManager.getMaxSettingValue(penIndex);
        AbstractC6670b.m4756q("checkPenSize() name=", uiPenInfo.name, this.TAG);
        Log.i(this.TAG, "checkPenSize() size=" + uiPenInfo.size + " sizeLevel=" + uiPenInfo.sizeLevel + " minValue=" + minSettingValue + " maxValue=" + maxSettingValue);
        if (uiPenInfo.sizeLevel == i2 && uiPenInfo.size == f4) {
            return z;
        }
        return true;
    }

    private final SpenSettingUIPenInfo getInfo() {
        if (this.mDataManager.getCurrentPenIndex() != -1) {
            return this.mDataManager.getCurrentPenInfo();
        }
        return null;
    }

    private final boolean isHighlighter(String penName) {
        return StringsKt.m14162r(penName, "Marker") || Intrinsics.areEqual(penName, SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER);
    }

    private final void notifyPenInfoChanged(int changeType) {
        SpenSettingUIPenInfo currentUIPenInfo;
        PenInfoChangedListener penInfoChangedListener = this.mPenInfoChangedListener;
        if (penInfoChangedListener == null || (currentUIPenInfo = getCurrentUIPenInfo()) == null) {
            return;
        }
        printInfo("updateViewPenSettingInfo()- by PenInfoChangeListener changeType=" + changeType, currentUIPenInfo, false);
        penInfoChangedListener.onPenInfoChanged(currentUIPenInfo);
    }

    public final void close() {
        this.mDataManager.close();
        this.mPenInfoChangedListener = null;
    }

    public final boolean containsAlphaChangeablePen() {
        Iterator<String> it = getPenNameList().iterator();
        while (it.hasNext()) {
            if (isSupportAlphaChange(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsFixedOpacityChangeablePen() {
        Iterator<String> it = getPenNameList().iterator();
        while (it.hasNext()) {
            if (isSupportFixedOpacity(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsParticleSizePen() {
        Iterator<String> it = getPenNameList().iterator();
        while (it.hasNext()) {
            if (isSupportParticleSize(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final SpenSettingUIPenInfo getCurrentUIPenInfo() {
        if (this.mDataManager.getCurrentPenIndex() != -1) {
            return new SpenSettingUIPenInfo(this.mDataManager.getCurrentPenInfo());
        }
        return null;
    }

    @NotNull
    public final List<SpenSettingPenInfo> getPenInfoList() {
        ArrayList arrayList = new ArrayList();
        List<SpenSettingUIPenInfo> penInfoList = this.mDataManager.getPenInfoList();
        if (penInfoList != null) {
            arrayList.addAll(penInfoList);
        }
        return arrayList;
    }

    @NotNull
    public final List<String> getPenNameList() {
        return this.mDataManager.getPenNameList();
    }

    public final boolean isSupportAlphaChange(@Nullable String penName) {
        if (!this.mDataManager.isInitialized() || penName == null) {
            return false;
        }
        return this.mDataManager.hasAlphaValue(penName);
    }

    public final boolean isSupportDynamicSize(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        return isHighlighter(penName);
    }

    public final boolean isSupportFixedOpacity(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        return penName.compareTo(SpenPenManager.SPEN_PENCIL2) == 0;
    }

    public final boolean isSupportFixedWidthChange(@NotNull String penName) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        if (this.mDataManager.isInitialized()) {
            return this.mDataManager.isSupportFixedWidthChange(penName);
        }
        return false;
    }

    public final boolean isSupportParticleSize(@Nullable String penName) {
        if (!this.mDataManager.isInitialized() || penName == null) {
            return false;
        }
        return this.mDataManager.isSupportParticleSize(penName);
    }

    public final boolean isValidPenInfo(@NotNull SpenSettingUIPenInfo settingInfo) {
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        if (!this.mDataManager.isInitialized()) {
            return false;
        }
        String str = settingInfo.name;
        if (Intrinsics.areEqual(str, SpenPenManager.SPEN_BRUSH) || Intrinsics.areEqual(settingInfo.name, "com.samsung.android.sdk.pen.pen.preload.MontblancFountainPen") || Intrinsics.areEqual(settingInfo.name, "com.samsung.android.sdk.pen.pen.preload.MontblancCalligraphyPen")) {
            settingInfo.name = SpenPenManager.SPEN_FOUNTAIN_PEN;
        }
        if (this.mDataManager.isUsingPen(settingInfo.name)) {
            return true;
        }
        if (!Intrinsics.areEqual(str, settingInfo.name)) {
            settingInfo.name = str;
        }
        AbstractC4539a.m3207q("Not supported Pen(", settingInfo.name, ")", this.TAG);
        return false;
    }

    public final void printInfo(@NotNull String pre, @NotNull SpenSettingPenInfo info, boolean penInfoOnly) {
        Intrinsics.checkNotNullParameter(pre, "pre");
        Intrinsics.checkNotNullParameter(info, "info");
        AbstractC4539a.m3207q("===== ", pre, " =====", this.TAG);
        AbstractC6670b.m4756q(" name = ", info.name, this.TAG);
        AbstractC4539a.m3205o(" size = ", this.TAG, info.size);
        AbstractC2322a.m1631u(info.sizeLevel, " level = ", this.TAG);
        String str = this.TAG;
        int i = info.color;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC11014a.m12328m(i, " color = ", AbstractC2322a.m1624n("#%08X", new Object[]{Integer.valueOf(i)}, 1, "format(format, *args)"), str);
        if (!penInfoOnly && (info instanceof SpenSettingUIPenInfo)) {
            SpenSettingUIPenInfo spenSettingUIPenInfo = (SpenSettingUIPenInfo) info;
            AbstractC6670b.m4765z(new Object[]{Float.valueOf(spenSettingUIPenInfo.hsv[0]), Float.valueOf(spenSettingUIPenInfo.hsv[1]), Float.valueOf(spenSettingUIPenInfo.hsv[2])}, 3, " hsv[%f, %f, %f]", "format(format, *args)", this.TAG);
            AbstractC2322a.m1631u(spenSettingUIPenInfo.colorUIInfo, " colorUI = ", this.TAG);
        }
        AbstractC4539a.m3205o(" particleSize = ", this.TAG, info.particleSize);
        Log.i(this.TAG, " isFixedWidth = ".concat(info.isFixedWidth ? "TRUE" : "FALSE"));
        Log.i(this.TAG, " isFixedOpacity = ".concat(info.isFixedOpacity ? "TRUE" : "FALSE"));
        Log.i(this.TAG, " isAutoSizeEnabled = ".concat(info.isAutoSizeEnabled ? "TRUE" : "FALSE"));
        AbstractC4539a.m3205o(" fitRatio = ", this.TAG, info.fitRatio);
        Log.i(this.TAG, "======================");
    }

    public final boolean setCurrentPen(@Nullable String penName) {
        SpenSettingUIPenInfo info = getInfo();
        if (penName == null || (info != null && info.name.compareTo(penName) == 0)) {
            AbstractC4539a.m3207q("The pen is not changed. same PenName(", penName, ")", this.TAG);
            return false;
        }
        if (!this.mDataManager.setCurrentPen(penName)) {
            return false;
        }
        notifyPenInfoChanged(1);
        return true;
    }

    public final boolean setCurrentUIPenInfo(@Nullable SpenSettingUIPenInfo uiPenInfo) {
        if (uiPenInfo == null || uiPenInfo.name == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'settingInfo' is null.");
        }
        if (!isValidPenInfo(uiPenInfo)) {
            Log.i(this.TAG, "Invalid pen.");
            return false;
        }
        boolean zCheckPenColor = checkPenColor(uiPenInfo);
        boolean zCheckPenSize = checkPenSize(uiPenInfo);
        int iChangeWhat = changeWhat(uiPenInfo);
        AbstractC0000a.m26w(AbstractC2821a.m2230u("setInfo() isChangedColor=", " isChangedSize=", " changeType=", zCheckPenColor, zCheckPenSize), this.TAG, iChangeWhat);
        if (this.mDataManager.setCurrentPenInfo(uiPenInfo)) {
            notifyPenInfoChanged(iChangeWhat);
            if (iChangeWhat != 0) {
                return true;
            }
        }
        return false;
    }

    public final void setEnableAlphaChange(boolean enableChange) {
        this.mEnableAlphaChange = enableChange;
    }

    public final void setPenInfoChangedListener(@Nullable PenInfoChangedListener infoChangedListener) {
        this.mPenInfoChangedListener = infoChangedListener;
    }

    public final void setUIPenInfoList(@Nullable List<SpenSettingUIPenInfo> list) {
        if (list != null) {
            this.mDataManager.setPenInfoList(list);
            List<SpenSettingUIPenInfo> penInfoList = this.mDataManager.getPenInfoList();
            if (penInfoList != null) {
                int size = penInfoList.size();
                SpenSettingUIPenInfo spenSettingUIPenInfo = null;
                for (int i = 0; i < size; i++) {
                    checkPenSize(penInfoList.get(i));
                    checkPenColor(penInfoList.get(i));
                    printInfo("setPenInfoList() -- Pendata", penInfoList.get(i), false);
                    SpenSettingUIPenInfo info = getInfo();
                    if (info != null && spenSettingUIPenInfo == null && penInfoList.get(i).name.compareTo(info.name) == 0) {
                        spenSettingUIPenInfo = new SpenSettingUIPenInfo(penInfoList.get(i));
                    }
                }
            }
        }
    }
}
