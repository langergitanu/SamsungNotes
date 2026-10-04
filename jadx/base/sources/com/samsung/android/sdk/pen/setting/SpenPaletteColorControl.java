package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnColorButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnPaletteSwipeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u001c\b\u0010\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0004RSTUB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J(\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000eJ\u0018\u0010\"\u001a\u00020\u001a2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010 H\u0016J\u0010\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0013J\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 J$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 2\u0006\u0010*\u001a\u00020\u000eJ(\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0 2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-0 J\u0018\u00100\u001a\u00020\u001a2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 H\u0016J\u001c\u00101\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0 2\u0006\u00102\u001a\u00020,J\u0010\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u000eH\u0016J\u0012\u00105\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u00106\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0016J\u0016\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020\u001aJ\u000e\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020:J\u0010\u0010>\u001a\u00020,2\u0006\u00109\u001a\u00020\u000eH\u0016J \u0010?\u001a\u00020\u001a2\u0006\u0010=\u001a\u00020:2\u0006\u00108\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020,H\u0002J\u000e\u0010A\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:J\u0012\u0010B\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010C\u001a\u00020\u000eH\u0004J\b\u0010D\u001a\u00020\u000eH\u0004J\u0010\u0010E\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:H\u0004J\u0010\u0010F\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\u0018J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u000eH\u0016J\u0018\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020:H\u0016J \u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020,H\u0016J\u0018\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020\u000eH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangeListener;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorButtonListener;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnPaletteSwipeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mColorLayout", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteSetting;", "mPaletteIDs", "", "", "mMaxPaletteCount", "mColorChangeListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnColorChangeListener;", "mRecentChangeListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnRecentColorChangeListener;", "mPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnPaletteActionListener;", "mPaletteActionButtonListener", "mPaletteLogListener", "Lcom/samsung/android/sdk/pen/setting/PenPaletteLoggingListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setColorInformation", "colorLayout", "paletteList", "", "maxPaletteCount", "setRecentColor", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "setOnRecentChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getPaletteList", "checkValidPaletteList", XmlErrorCodes.LIST, "maxPalette", "isEqualList", "", "T", "first", "second", "setPaletteList", "setPaletteListInner", "needValidationCheck", "setCurrentPalette", "paletteID", "setOnPaletteChangedListener", "setOnPaletteActionButtonListener", "setColor", "uiInfo", "color", "", "resetColor", "setPickerColor", "hsvColor", "setEyedropperColor", "applyColor", "maintainAlpha", "addRecentColor", "setOnColorChangeListener", "getOpacity", "getEyedropperUIInfo", "getColor", "setPaletteLogListener", "onButtonClick", "type", "onColorChanged", "info", "onColorSelected", "pageIndex", "colorIndex", "isSelected", "onPaletteSwipe", "direction", "id", "Companion", "OnRecentColorChangeListener", "OnPaletteActionListener", "OnColorChangeListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPaletteColorControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaletteColorControl.kt\ncom/samsung/android/sdk/pen/setting/SpenPaletteColorControl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,237:1\n1864#2,3:238\n*S KotlinDebug\n*F\n+ 1 SpenPaletteColorControl.kt\ncom/samsung/android/sdk/pen/setting/SpenPaletteColorControl\n*L\n109#1:238,3\n*E\n"})
public class SpenPaletteColorControl implements OnActionButtonListener, com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener, OnColorButtonListener, OnPaletteSwipeListener {

    @NotNull
    private static final String TAG = "SpenPaletteColorControl";

    @Nullable
    private OnColorChangeListener mColorChangeListener;

    @Nullable
    private SpenPaletteSetting mColorLayout;

    @Nullable
    private Context mContext;
    private int mMaxPaletteCount;

    @Nullable
    private OnActionButtonListener mPaletteActionButtonListener;

    @Nullable
    private OnPaletteActionListener mPaletteActionListener;

    @NotNull
    private List<Integer> mPaletteIDs;

    @Nullable
    private PenPaletteLoggingListener mPaletteLogListener;

    @Nullable
    private OnRecentColorChangeListener mRecentChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnColorChangeListener;", "", "onColorChanged", "", "info", "", "hsvColor", "", "maintainAlpha", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnColorChangeListener {
        void onColorChanged(int info, @NotNull float[] hsvColor, boolean maintainAlpha);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnPaletteActionListener;", "", "onPalettePageChanged", "", "direction", "", "paletteID", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPaletteActionListener {
        void onPalettePageChanged(int direction, int paletteID);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnRecentColorChangeListener;", "", "onRecentColorChanged", "", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnRecentColorChangeListener {
        void onRecentColorChanged(@Nullable List<SpenHSVColor> list);
    }

    public SpenPaletteColorControl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteIDs = new ArrayList();
        this.mMaxPaletteCount = 5;
        this.mContext = context;
    }

    private final void applyColor(float[] hsvColor, int uiInfo, boolean maintainAlpha) {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setColor(uiInfo, hsvColor);
        }
        OnColorChangeListener onColorChangeListener = this.mColorChangeListener;
        if (onColorChangeListener != null) {
            onColorChangeListener.onColorChanged(uiInfo, hsvColor, maintainAlpha);
        }
    }

    public final void addRecentColor(@NotNull float[] color) {
        OnRecentColorChangeListener onRecentColorChangeListener;
        Intrinsics.checkNotNullParameter(color, "color");
        Log.i(TAG, "addRecentColor()");
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting == null || !spenPaletteSetting.addRecentColor(color) || (onRecentColorChangeListener = this.mRecentChangeListener) == null) {
            return;
        }
        onRecentColorChangeListener.onRecentColorChanged(spenPaletteSetting.getRecentColor());
    }

    @NotNull
    public final List<Integer> checkValidPaletteList(@Nullable List<Integer> list, int maxPalette) {
        ArrayList arrayList = new ArrayList();
        List<Integer> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (arrayList.size() >= maxPalette) {
                    break;
                }
                if (!arrayList.contains(Integer.valueOf(iIntValue))) {
                    arrayList.add(Integer.valueOf(iIntValue));
                }
            }
            SpenColorPaletteUtil spenColorPaletteUtil = new SpenColorPaletteUtil(this.mContext);
            spenColorPaletteUtil.getValidTaleIDs(arrayList);
            spenColorPaletteUtil.close();
            StringBuilder sb = new StringBuilder("checkValidPaletteList : ");
            sb.append(arrayList);
            sb.append(", max=");
            AbstractC0000a.m26w(sb, TAG, maxPalette);
        }
        return arrayList;
    }

    public void close() {
        this.mPaletteIDs.clear();
        this.mColorChangeListener = null;
        this.mRecentChangeListener = null;
        this.mPaletteActionListener = null;
        this.mPaletteActionButtonListener = null;
        this.mPaletteLogListener = null;
        this.mColorLayout = null;
        this.mContext = null;
    }

    public final void getColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.getColor(color);
        }
    }

    public final int getEyedropperUIInfo() {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            return spenPaletteSetting.getUiInfo(2);
        }
        return -1;
    }

    public final int getOpacity() {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            return spenPaletteSetting.getOpacity();
        }
        return 255;
    }

    @Nullable
    public final List<Integer> getPaletteList() {
        return CollectionsKt.toList(this.mPaletteIDs);
    }

    public final <T> boolean isEqualList(@NotNull List<? extends T> first, @NotNull List<? extends T> second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (first.size() != second.size()) {
            return false;
        }
        int i = 0;
        for (T t : first) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!Intrinsics.areEqual(second.get(i), t)) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
    public void onButtonClick(int type) {
        PenPaletteLoggingListener penPaletteLoggingListener;
        OnActionButtonListener onActionButtonListener = this.mPaletteActionButtonListener;
        if (onActionButtonListener != null) {
            onActionButtonListener.onButtonClick(type);
        }
        if (type == 1) {
            PenPaletteLoggingListener penPaletteLoggingListener2 = this.mPaletteLogListener;
            if (penPaletteLoggingListener2 != null) {
                penPaletteLoggingListener2.onColorPickerSelected();
                return;
            }
            return;
        }
        if (type != 2) {
            if (type == 3 && (penPaletteLoggingListener = this.mPaletteLogListener) != null) {
                penPaletteLoggingListener.onColorSettingSelected();
                return;
            }
            return;
        }
        PenPaletteLoggingListener penPaletteLoggingListener3 = this.mPaletteLogListener;
        if (penPaletteLoggingListener3 != null) {
            penPaletteLoggingListener3.onEyedropperSelected();
        }
    }

    public void onColorChanged(int info, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        float f = hsvColor[0];
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("onColorChanged() info=", info, " color[", f, SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
        OnColorChangeListener onColorChangeListener = this.mColorChangeListener;
        if (onColorChangeListener != null) {
            onColorChangeListener.onColorChanged(info, hsvColor, true);
        }
    }

    public void onColorSelected(int pageIndex, int colorIndex, boolean isSelected) {
        SpenPaletteSetting spenPaletteSetting;
        if (this.mPaletteLogListener == null || (spenPaletteSetting = this.mColorLayout) == null) {
            return;
        }
        float[] fArr = {0.0f, 0.0f, 0.0f};
        if (spenPaletteSetting != null) {
            spenPaletteSetting.getColor(fArr);
        }
        PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteLogListener;
        if (penPaletteLoggingListener != null) {
            penPaletteLoggingListener.onColorSelected(SpenSettingUtil.HSVToColor(fArr));
        }
    }

    public void onPaletteSwipe(int direction, int id) {
        OnPaletteActionListener onPaletteActionListener = this.mPaletteActionListener;
        if (onPaletteActionListener != null) {
            onPaletteActionListener.onPalettePageChanged(direction, id);
        }
        PenPaletteLoggingListener penPaletteLoggingListener = this.mPaletteLogListener;
        if (penPaletteLoggingListener != null) {
            penPaletteLoggingListener.onPaletteSwiped(direction);
        }
    }

    public final void resetColor() {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.resetColor();
        }
    }

    public final void setColor(int uiInfo, @NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setColor(uiInfo, color);
        }
    }

    public final void setColorInformation(@Nullable SpenPaletteSetting colorLayout, @Nullable List<Integer> paletteList, int maxPaletteCount) {
        this.mColorLayout = colorLayout;
        this.mMaxPaletteCount = maxPaletteCount;
        List<Integer> list = paletteList;
        if (list != null && !list.isEmpty()) {
            setPaletteListInner(paletteList, false);
        }
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setOnActionButtonListener(this);
        }
        SpenPaletteSetting spenPaletteSetting2 = this.mColorLayout;
        if (spenPaletteSetting2 != null) {
            spenPaletteSetting2.setOnColorChangeListener(this);
        }
        SpenPaletteSetting spenPaletteSetting3 = this.mColorLayout;
        if (spenPaletteSetting3 != null) {
            spenPaletteSetting3.setOnPaletteSwipeListener(this);
        }
        SpenPaletteSetting spenPaletteSetting4 = this.mColorLayout;
        if (spenPaletteSetting4 != null) {
            spenPaletteSetting4.setOnColorButtonListener(this);
        }
    }

    public void setColorTheme(int theme) {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setColorTheme(theme);
        }
    }

    public void setCurrentPalette(int paletteID) {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setPalette(paletteID);
        }
    }

    public boolean setEyedropperColor(int color) {
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        addRecentColor(fArr);
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting == null) {
            return true;
        }
        applyColor(fArr, spenPaletteSetting.getUiInfo(2), false);
        return true;
    }

    public void setOnColorChangeListener(@Nullable OnColorChangeListener listener) {
        this.mColorChangeListener = listener;
    }

    public void setOnPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        this.mPaletteActionButtonListener = listener;
    }

    public void setOnPaletteChangedListener(@Nullable OnPaletteActionListener listener) {
        this.mPaletteActionListener = listener;
    }

    public final void setOnRecentChangeListener(@Nullable OnRecentColorChangeListener listener) {
        this.mRecentChangeListener = listener;
    }

    public void setPaletteList(@Nullable List<Integer> paletteList) {
        List<Integer> list = paletteList;
        if (list == null || list.isEmpty() || isEqualList(paletteList, this.mPaletteIDs)) {
            Log.i(TAG, "Null or Same PaletteList.");
        } else {
            setPaletteListInner(paletteList, true);
        }
    }

    public final void setPaletteListInner(@NotNull List<Integer> paletteList, boolean needValidationCheck) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        this.mPaletteIDs.clear();
        if (needValidationCheck) {
            this.mPaletteIDs.addAll(checkValidPaletteList(paletteList, this.mMaxPaletteCount));
        } else {
            this.mPaletteIDs.addAll(paletteList);
        }
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setPaletteList(paletteList);
        }
    }

    public final void setPaletteLogListener(@Nullable PenPaletteLoggingListener listener) {
        this.mPaletteLogListener = listener;
    }

    public final void setPickerColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            applyColor(hsvColor, spenPaletteSetting.getUiInfo(1), true);
        }
    }

    public void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        SpenPaletteSetting spenPaletteSetting = this.mColorLayout;
        if (spenPaletteSetting != null) {
            spenPaletteSetting.setRecentColor(recentList);
        }
    }
}
