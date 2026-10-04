package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteConfig;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteRecentControl;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010(\u001a\u00020)H\u0016J!\u0010*\u001a\u00020\u00052\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0,\"\u00020-H\u0016¢\u0006\u0002\u0010.J\u0012\u0010/\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010#H\u0016J\u0012\u00101\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010%H\u0016J\u0018\u00102\u001a\u00020\u00052\u000e\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0016J\u0010\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0016J\u0016\u00109\u001a\u00020\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b04H\u0016J\b\u0010;\u001a\u00020\bH\u0016J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\bH\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0011H\u0016J\b\u0010A\u001a\u00020\bH\u0016J\b\u0010B\u001a\u00020)H\u0016J\u0010\u0010C\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\bH\u0016J\u0010\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020\bH\u0016J\u0010\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0016J(\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u0005H\u0016J\u0010\u0010N\u001a\u00020)2\u0006\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010O\u001a\u00020)2\u0006\u0010@\u001a\u00020\bH\u0016J\u0010\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020\u0005H\u0016J\u001e\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\bJ\u000e\u0010R\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bJ\u001e\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010U\u001a\u00020\u0005J.\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005J\u001e\u0010Z\u001a\u00020)2\u0006\u0010W\u001a\u00020-2\u0006\u0010[\u001a\u00020\b2\u0006\u0010U\u001a\u00020\u0005J\u0018\u0010`\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\b2\u0006\u0010a\u001a\u00020\u0011H\u0016J\u0006\u0010b\u001a\u00020)J\u0016\u0010c\u001a\u00020)2\u0006\u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u00020\bJ\u0016\u0010f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\bJ&\u0010g\u001a\u00020\u00052\u0006\u0010W\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010h\u001a\u00020\u0005J&\u0010i\u001a\u00020)2\u0006\u0010W\u001a\u00020-2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010h\u001a\u00020\u0005J&\u0010J\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\bJ\u0006\u0010j\u001a\u00020\u0005J\u000e\u0010q\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bJ\u0010\u0010r\u001a\u00020)2\b\u0010W\u001a\u0004\u0018\u00010-J\u0010\u0010s\u001a\u00020)2\b\u0010t\u001a\u0004\u0018\u00010\u001fJ0\u00109\u001a\u00020\u00052\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b042\u0006\u0010u\u001a\u00020-2\b\u0010v\u001a\u0004\u0018\u00010-2\u0006\u0010[\u001a\u00020\bH\u0004J\u0012\u0010w\u001a\u00020)2\b\u0010x\u001a\u0004\u0018\u00010yH\u0004J\u0010\u0010z\u001a\u00020)2\u0006\u0010{\u001a\u00020\u0005H\u0002J\u0010\u0010|\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\bH\u0002J(\u0010}\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0002J \u0010?\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010~\u001a\u00020\b2\u0006\u0010X\u001a\u00020\bH\u0002J\u0018\u0010g\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\b2\u0006\u0010a\u001a\u00020\u0011H\u0002J!\u0010\u007f\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010h\u001a\u00020\u0005H\u0002J\u0018\u0010A\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010X\u001a\u00020\bH\u0002J\u0019\u0010\u0083\u0001\u001a\u00020)2\u0006\u0010I\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020)2\u0006\u0010W\u001a\u00020-H\u0002J&\u00109\u001a\u00020)2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b042\u0006\u0010W\u001a\u00020-2\u0006\u0010o\u001a\u00020\bH\u0002J\"\u0010\u0085\u0001\u001a\u00020)2\u0007\u0010\u0086\u0001\u001a\u00020\b2\u0006\u0010W\u001a\u00020-2\u0006\u0010o\u001a\u00020\bH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\\\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b]\u0010\u0016R\u0011\u0010^\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b_\u0010\u0016R\u0011\u0010k\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bl\u0010\u0016R\u0014\u0010m\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0016R\u0014\u0010o\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0016R\u0016\u0010\u0081\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0016¨\u0006\u0088\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewControl;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface;", "context", "Landroid/content/Context;", "mHasRecentPage", "", "haveEyedropper", "maxRecent", "", "<init>", "(Landroid/content/Context;ZZI)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mColorUIInfo", "mColor", "", "mOpacity", "value", "pageIndex", "getPageIndex", "()I", Constants.MessagePayloadKeys.FROM, "getFrom", "mIsColorInit", "mColorDataHelper", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteDataHelper;", "mRecentControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl;", "mPaletteConfig", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteConfig;", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mColorChangeListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnColorChangeListener;", "mPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnPaletteActionListener;", "onRecentColorSelectListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl$OnColorChangeListener;", "close", "", "setPaletteView", "paletteViewInterfaces", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "([Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;)Z", "setColorChangeListener", "actionListener", "setPaletteActionListener", "setRecentColor", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "getRecentColor", "getColorUIInfo", "type", "setPaletteInfo", "paletteInfo", "getPalette", "setPalette", "paletteID", "containsPalette", "getColor", "color", "getOpacity", "resetColor", "addRecentColor", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setRecentIndicatorSize", "size", "getPaletteIDFromViewIdx", "viewIndex", "setColor", "uiInfo", "opacity", "needAnimation", "setPickerColor", "setEyedropperColor", "setEyedropperEnabled", "enabled", "getViewIndex", "clearChecked", "paletteView", "includingPicker", "setSelected", "palette", "childAt", "selected", "resetChecked", "exceptPageIndex", "currentChildIndex", "getCurrentChildIndex", "pickerIndexInPalette", "getPickerIndexInPalette", "onRecentColorSelected", "hsvColor", "notifyColorChanged", "notifyPaletteSwipe", "position", "direction", "onEventButtonClick", "onRecentColorSelect", "isSelected", "onPaletteColorSelect", "hasRecentPage", "uIInfo", "getUIInfo", "defaultPageIndex", "getDefaultPageIndex", "recentPageIndex", "getRecentPageIndex", "isSameCurrentFromType", "initRecentControl", "initPaletteConfig", "paletteConfig", "colorPalette", "recentPalette", "applyColorInPicker", "drawable", "Landroid/graphics/drawable/Drawable;", "setPaletteVisibleColor", "reverse", "clearRecentChecked", "setRecentSelected", "getColorIndex", "notifyColorSelected", "colorIndex", "totalPageCount", "getTotalPageCount", "setUIInfo", "initColor", "initConfigTable", "totalPage", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPaletteViewControl implements SpenPaletteControlInterface {

    @NotNull
    private static final String TAG = "SpenPaletteViewControl";

    @NotNull
    private Context context;
    private int from;

    @NotNull
    private float[] mColor;

    @Nullable
    private SpenPaletteControlInterface.OnColorChangeListener mColorChangeListener;

    @NotNull
    private SpenPaletteDataHelper mColorDataHelper;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;
    private int mColorUIInfo;
    private final boolean mHasRecentPage;
    private boolean mIsColorInit;
    private int mOpacity;

    @Nullable
    private SpenPaletteControlInterface.OnPaletteActionListener mPaletteActionListener;

    @Nullable
    private SpenPaletteConfig mPaletteConfig;

    @Nullable
    private SpenPaletteRecentControl mRecentControl;

    @NotNull
    private final SpenPaletteRecentControl.OnColorChangeListener onRecentColorSelectListener;
    private int pageIndex;

    public SpenPaletteViewControl(@NotNull Context context, boolean z, boolean z2, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mHasRecentPage = z;
        this.mColor = new float[3];
        SpenPaletteRecentControl.OnColorChangeListener onColorChangeListener = new SpenPaletteRecentControl.OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl$onRecentColorSelectListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteRecentControl.OnColorChangeListener
            public void OnColorSelected(int childAt, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                this.this$0.onRecentColorSelected(childAt, hsvColor);
            }
        };
        this.onRecentColorSelectListener = onColorChangeListener;
        this.mOpacity = 255;
        if (z) {
            SpenPaletteRecentControl spenPaletteRecentControl = new SpenPaletteRecentControl(this.context, 0, z2, i);
            this.mRecentControl = spenPaletteRecentControl;
            spenPaletteRecentControl.setOnColorChangeListener(onColorChangeListener);
        }
        this.pageIndex = getDefaultPageIndex();
        this.mColorDataHelper = new SpenPaletteDataHelper();
        this.mColorThemeUtil = new SpenColorThemeUtil(this.context);
    }

    private final boolean clearRecentChecked(int pageIndex) {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl == null || getRecentPageIndex() != pageIndex) {
            return false;
        }
        spenPaletteRecentControl.clearChecked();
        return true;
    }

    private final int getColorIndex(int childAt) {
        List<Integer> colorIdxList;
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig == null || (colorIdxList = spenPaletteConfig.getColorIdxList()) == null) {
            return -1;
        }
        return colorIdxList.indexOf(Integer.valueOf(childAt));
    }

    private final int getTotalPageCount() {
        return (getMHasRecentPage() ? 1 : 0) + this.mColorDataHelper.getPaletteSize();
    }

    private final void initColor(SpenPaletteViewInterface palette) {
        if (this.mIsColorInit) {
            setColor(this.mColorUIInfo, this.mColor, this.mOpacity, false);
        } else {
            palette.setPage(getDefaultPageIndex(), false);
        }
    }

    private final void initConfigTable(int totalPage, SpenPaletteViewInterface palette, int recentPageIndex) {
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.initTable(palette, this.mRecentControl);
            for (int i = 0; i < totalPage; i++) {
                if (i == recentPageIndex) {
                    spenPaletteConfig.initRecentPalette(i);
                } else {
                    spenPaletteConfig.initDefinedPalette(i, this.mColorDataHelper.getPaletteData(i));
                }
            }
        }
    }

    private final void notifyColorSelected(int pageIndex, int colorIndex, boolean isSelected) {
        SpenPaletteControlInterface.OnPaletteActionListener onPaletteActionListener;
        if (colorIndex >= 0 && (onPaletteActionListener = this.mPaletteActionListener) != null) {
            onPaletteActionListener.onColorSelected(pageIndex, colorIndex, isSelected);
        }
    }

    private final void setPaletteVisibleColor(boolean reverse) {
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.setReverseMode(reverse);
            int totalPageCount = getTotalPageCount();
            for (int i = 0; i < totalPageCount; i++) {
                if (i == getRecentPageIndex()) {
                    SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
                    if (spenPaletteRecentControl != null) {
                        spenPaletteRecentControl.updateColor();
                    }
                } else {
                    spenPaletteConfig.setPaletteVisibleColor(i, this.mColorDataHelper.getPaletteData(i));
                }
            }
        }
    }

    private final boolean setRecentSelected(int pageIndex, int childAt, boolean selected, boolean needAnimation) {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl == null || getRecentPageIndex() != pageIndex) {
            return false;
        }
        spenPaletteRecentControl.setSelected(childAt, selected, needAnimation);
        return true;
    }

    private final void setUIInfo(int viewIndex, int from) {
        this.mColorUIInfo = SpenPaletteDefine.getColorUIInfo(getPaletteIDFromViewIdx(viewIndex), from);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean addRecentColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        Log.i(TAG, "addRecentColor() - From SpenSettingPenLayout");
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl != null) {
            return spenPaletteRecentControl.addColor(color);
        }
        Log.i(TAG, "recent control is not existed. so return false");
        return false;
    }

    public final void applyColorInPicker(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float[] fArr = new float[3];
        getColor(fArr);
        int color = this.mColorThemeUtil.getColor(Color.HSVToColor(fArr));
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.applyPickerColor(drawable, color);
        }
    }

    public final void clearChecked(@NotNull SpenPaletteViewInterface paletteView, int pageIndex, boolean includingPicker) {
        SpenPaletteConfig spenPaletteConfig;
        List<Integer> colorIdxList;
        SpenPaletteConfig spenPaletteConfig2;
        Intrinsics.checkNotNullParameter(paletteView, "paletteView");
        if (clearRecentChecked(pageIndex) || (spenPaletteConfig = this.mPaletteConfig) == null || (colorIdxList = spenPaletteConfig.getColorIdxList()) == null) {
            return;
        }
        int size = colorIdxList.size();
        for (int i = 0; i < size; i++) {
            paletteView.setSelected(pageIndex, colorIdxList.get(i).intValue(), false, false);
        }
        if (includingPicker) {
            SpenPaletteConfig spenPaletteConfig3 = this.mPaletteConfig;
            if ((spenPaletteConfig3 == null || spenPaletteConfig3.getMPickerButtonIdx() != -1) && (spenPaletteConfig2 = this.mPaletteConfig) != null) {
                paletteView.setSelected(pageIndex, spenPaletteConfig2.getMPickerButtonIdx(), false, false);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void close() {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl != null) {
            spenPaletteRecentControl.close();
        }
        this.mRecentControl = null;
        this.mColorDataHelper.close();
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.close();
        }
        this.mPaletteConfig = null;
        this.mColorThemeUtil.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean containsPalette(int paletteID) {
        return this.mColorDataHelper.getViewIndex(paletteID) != -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void getColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        System.arraycopy(this.mColor, 0, color, 0, 3);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public int getColorUIInfo(int type) {
        return 0;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final int getCurrentChildIndex() {
        SpenPaletteRecentControl spenPaletteRecentControl;
        int recentPageIndex = getRecentPageIndex();
        int i = this.pageIndex;
        if (recentPageIndex == i) {
            if (this.from == 0 || (spenPaletteRecentControl = this.mRecentControl) == null) {
                return -1;
            }
            return spenPaletteRecentControl.getChildIndex(this.mColor);
        }
        int childIndex = this.mColorDataHelper.getChildIndex(i, this.mColor, this.mOpacity);
        if (childIndex == -1) {
            SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
            if (spenPaletteConfig != null) {
                return spenPaletteConfig.getMPickerButtonIdx();
            }
            return -1;
        }
        SpenPaletteConfig spenPaletteConfig2 = this.mPaletteConfig;
        List<Integer> colorIdxList = spenPaletteConfig2 != null ? spenPaletteConfig2.getColorIdxList() : null;
        if (colorIdxList == null || childIndex >= colorIdxList.size()) {
            return -1;
        }
        return colorIdxList.get(childIndex).intValue();
    }

    public int getDefaultPageIndex() {
        return 0;
    }

    public final int getFrom() {
        return this.from;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    /* JADX INFO: renamed from: getOpacity, reason: from getter */
    public int getMOpacity() {
        return this.mOpacity;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public int getPalette() {
        return getPaletteIDFromViewIdx(this.pageIndex);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public int getPaletteIDFromViewIdx(int viewIndex) {
        if (viewIndex == getRecentPageIndex()) {
            return 0;
        }
        return this.mColorDataHelper.getPaletteID(viewIndex);
    }

    public final int getPickerIndexInPalette() {
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            return spenPaletteConfig.getMPickerButtonIdx();
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    @Nullable
    public List<SpenHSVColor> getRecentColor() {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        spenPaletteRecentControl.getRecentColors(arrayList);
        return arrayList;
    }

    public int getRecentPageIndex() {
        return 0;
    }

    public final int getUIInfo() {
        if (this.mIsColorInit) {
            return this.mColorUIInfo;
        }
        return -1;
    }

    public final int getViewIndex(int paletteID) {
        return (getMHasRecentPage() && paletteID == 0) ? getRecentPageIndex() : this.mColorDataHelper.getViewIndex(paletteID);
    }

    /* JADX INFO: renamed from: hasRecentPage, reason: from getter */
    public final boolean getMHasRecentPage() {
        return this.mHasRecentPage;
    }

    public final void initPaletteConfig(@Nullable SpenPaletteConfig paletteConfig) {
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.close();
        }
        this.mPaletteConfig = paletteConfig;
    }

    public final void initRecentControl(@Nullable SpenPaletteViewInterface palette) {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl != null) {
            spenPaletteRecentControl.setPaletteView(palette);
        }
    }

    public final boolean isSameCurrentFromType(int from) {
        return SpenPaletteDefine.getFromType(this.mColorUIInfo) == from;
    }

    public final void notifyColorChanged() {
        SpenPaletteDefine.showUIInfo(TAG, "notifyColorChanged", this.mColorUIInfo);
        SpenPaletteControlInterface.OnColorChangeListener onColorChangeListener = this.mColorChangeListener;
        if (onColorChangeListener != null) {
            onColorChangeListener.onColorChanged(this.mColorUIInfo, this.mColor, this.mOpacity);
        }
    }

    public final void notifyPaletteSwipe(int position, int direction) {
        SpenPaletteControlInterface.OnPaletteActionListener onPaletteActionListener = this.mPaletteActionListener;
        if (onPaletteActionListener != null) {
            onPaletteActionListener.onPaletteSwipe(position, direction);
        }
    }

    public final boolean onEventButtonClick(int pageIndex, int childAt) {
        SpenPaletteControlInterface.OnPaletteActionListener onPaletteActionListener;
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        SpenPaletteConfig.ButtonType buttonType = spenPaletteConfig != null ? spenPaletteConfig.getButtonType(pageIndex, childAt) : null;
        if (buttonType == SpenPaletteConfig.ButtonType.NONE) {
            return false;
        }
        if (buttonType == null || (onPaletteActionListener = this.mPaletteActionListener) == null) {
            return true;
        }
        onPaletteActionListener.onButtonClick(buttonType.value);
        return true;
    }

    public final void onPaletteColorSelect(@NotNull SpenPaletteViewInterface palette, int pageIndex, int childAt, boolean isSelected) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        if (isSelected) {
            setSelected(palette, pageIndex, childAt, true, true);
            notifyColorSelected(pageIndex, childAt, true);
            return;
        }
        clearChecked(palette, pageIndex, true);
        setSelected(palette, pageIndex, childAt, true, true);
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        resetChecked(palette, pageIndex, !(spenPaletteConfig != null && childAt == spenPaletteConfig.getMPickerButtonIdx()));
        float[] fArr = new float[3];
        int colorIndex = getColorIndex(childAt);
        if (colorIndex > -1 && getColor(pageIndex, childAt, fArr)) {
            setColor(pageIndex, 2, fArr, getOpacity(pageIndex, childAt));
            setUIInfo(pageIndex, 2);
            notifyColorChanged();
            Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("colorIndex=", colorIndex, " color[", fArr[0], SQLKeyword.COMMA), fArr[1], SQLKeyword.COMMA, fArr[2], "]"));
        }
        notifyColorSelected(pageIndex, colorIndex, false);
    }

    public final boolean onRecentColorSelect(@NotNull SpenPaletteViewInterface palette, int pageIndex, int childAt, boolean isSelected) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        if (pageIndex != getRecentPageIndex()) {
            return false;
        }
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl != null) {
            spenPaletteRecentControl.onButtonClick(childAt, isSelected);
        }
        resetChecked(palette, pageIndex, true);
        notifyColorSelected(pageIndex, childAt, isSelected);
        return true;
    }

    public boolean onRecentColorSelected(int childAt, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        int recentPageIndex = getRecentPageIndex();
        if (recentPageIndex == -1) {
            return false;
        }
        setColor(recentPageIndex, 1, hsvColor, 255);
        setUIInfo(recentPageIndex, 1);
        notifyColorChanged();
        return true;
    }

    public final void resetChecked(@NotNull SpenPaletteViewInterface palette, int exceptPageIndex, boolean includingPicker) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        int pageCount = palette.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            if (i != exceptPageIndex) {
                clearChecked(palette, i, includingPicker);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void resetColor() {
        this.mIsColorInit = false;
        this.mColorUIInfo = 0;
        this.mOpacity = 0;
        int length = this.mColor.length;
        for (int i = 0; i < length; i++) {
            this.mColor[i] = 0.0f;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColor(int uiInfo, @NotNull float[] color, int opacity, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.mColorUIInfo = uiInfo;
        SpenPaletteDefine.showUIInfo(TAG, "setColor()", uiInfo);
        int paletteID = SpenPaletteDefine.getPaletteID(uiInfo);
        setColor(getViewIndex(paletteID), SpenPaletteDefine.getFromType(uiInfo), color, opacity);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColorChangeListener(@Nullable SpenPaletteControlInterface.OnColorChangeListener actionListener) {
        this.mColorChangeListener = actionListener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColorTheme(int theme) {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl != null) {
            spenPaletteRecentControl.setColorTheme(theme);
        }
        setPaletteVisibleColor(theme != 0);
        this.mColorThemeUtil.setColorTheme(theme);
    }

    public final void setContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public void setEyedropperEnabled(boolean enabled) {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl != null) {
            spenPaletteRecentControl.setEyedropperEnabled(enabled);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPalette(int paletteID) {
        int viewIndex = getViewIndex(paletteID);
        if (viewIndex == -1) {
            return false;
        }
        this.pageIndex = viewIndex;
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setPaletteActionListener(@Nullable SpenPaletteControlInterface.OnPaletteActionListener actionListener) {
        this.mPaletteActionListener = actionListener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPaletteInfo(@NotNull List<Integer> paletteInfo) {
        Intrinsics.checkNotNullParameter(paletteInfo, "paletteInfo");
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPaletteView(@NotNull SpenPaletteViewInterface... paletteViewInterfaces) {
        Intrinsics.checkNotNullParameter(paletteViewInterfaces, "paletteViewInterfaces");
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setPickerColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        SpenPaletteRecentControl spenPaletteRecentControl = this.mRecentControl;
        if (spenPaletteRecentControl == null) {
            return false;
        }
        spenPaletteRecentControl.setRecentColors(recentList);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setRecentIndicatorSize(int size) {
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.setRecentIndicatorSize(size);
        }
    }

    public final void setSelected(@NotNull SpenPaletteViewInterface palette, int pageIndex, int childAt, boolean selected, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        if (childAt == -1) {
            AbstractC6670b.m4744e(pageIndex, childAt, "setSelected() invalid pageIndex=", " childAt=", TAG);
            return;
        }
        if (setRecentSelected(pageIndex, childAt, selected, needAnimation)) {
            return;
        }
        palette.setSelected(pageIndex, childAt, selected, needAnimation);
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig == null || childAt != spenPaletteConfig.getMPickerButtonIdx()) {
            return;
        }
        int totalPageCount = getTotalPageCount();
        for (int i = 1; i < totalPageCount; i++) {
            if (i != pageIndex) {
                palette.setSelected(i, childAt, selected, false);
            }
        }
    }

    private final boolean getColor(int pageIndex, int childAt, float[] color) {
        if (this.mRecentControl != null && pageIndex == getRecentPageIndex()) {
            Log.i(TAG, "currently, not necessary!!!!");
            return false;
        }
        int colorIndex = getColorIndex(childAt);
        if (colorIndex > -1) {
            return this.mColorDataHelper.getColor(pageIndex, colorIndex, color);
        }
        return false;
    }

    private final int getOpacity(int pageIndex, int childAt) {
        int colorIndex;
        if (pageIndex != getRecentPageIndex() && (colorIndex = getColorIndex(childAt)) > -1) {
            return this.mColorDataHelper.getOpacity(pageIndex, colorIndex);
        }
        return 255;
    }

    public final boolean setPaletteInfo(@NotNull List<Integer> paletteInfo, @NotNull SpenPaletteViewInterface colorPalette, @Nullable SpenPaletteViewInterface recentPalette, int exceptPageIndex) {
        Intrinsics.checkNotNullParameter(paletteInfo, "paletteInfo");
        Intrinsics.checkNotNullParameter(colorPalette, "colorPalette");
        AbstractC2322a.m1631u(paletteInfo.size(), "setPaletteInfo() size=", TAG);
        if (recentPalette == null) {
            setPaletteInfo(paletteInfo, colorPalette, exceptPageIndex);
            initColor(colorPalette);
            return true;
        }
        setPaletteInfo(paletteInfo, colorPalette, -1);
        recentPalette.setPaletteInfo(1);
        SpenPaletteConfig spenPaletteConfig = this.mPaletteConfig;
        if (spenPaletteConfig != null) {
            spenPaletteConfig.initRecentPalette(0);
        }
        initColor(colorPalette);
        return true;
    }

    private final boolean onRecentColorSelect(int childAt, float[] hsvColor) {
        int recentPageIndex = getRecentPageIndex();
        if (recentPageIndex == -1) {
            return false;
        }
        setColor(recentPageIndex, 1, hsvColor, 255);
        setUIInfo(recentPageIndex, 1);
        notifyColorChanged();
        return true;
    }

    public final void setColor(int uiInfo, @NotNull float[] color, int opacity) {
        Intrinsics.checkNotNullParameter(color, "color");
        setColor(uiInfo, color, opacity, true);
    }

    public final boolean setColor(int pageIndex, int from, @NotNull float[] color, int opacity) {
        Intrinsics.checkNotNullParameter(color, "color");
        boolean z = true;
        this.mIsColorInit = true;
        float f = color[0];
        float f4 = color[1];
        float f5 = color[2];
        StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIndex, from, "setColor() pageIndex=", " from = ", "h=");
        AbstractC11014a.m12337v(sbM1173s, f, ", s=", f4, " v=");
        sbM1173s.append(f5);
        sbM1173s.append(" opacity=");
        sbM1173s.append(opacity);
        Log.i(TAG, sbM1173s.toString());
        if (from == 0) {
            this.pageIndex = getDefaultPageIndex();
            this.from = from;
        } else if (pageIndex < getTotalPageCount() && pageIndex >= 0) {
            this.pageIndex = pageIndex;
            this.from = from;
        } else {
            this.from = 2;
            this.pageIndex = getMHasRecentPage() ? getRecentPageIndex() : getDefaultPageIndex();
            AbstractC6670b.m4744e(this.pageIndex, this.from, "setColor() decide pageIndex=", " from=", TAG);
            System.arraycopy(color, 0, this.mColor, 0, 3);
            this.mOpacity = opacity;
            return z;
        }
        z = false;
        AbstractC6670b.m4744e(this.pageIndex, this.from, "setColor() decide pageIndex=", " from=", TAG);
        System.arraycopy(color, 0, this.mColor, 0, 3);
        this.mOpacity = opacity;
        return z;
    }

    private final void setPaletteInfo(List<Integer> paletteInfo, SpenPaletteViewInterface palette, int recentPageIndex) {
        AbstractC6670b.m4744e(paletteInfo.size(), recentPageIndex, "setPaletteInfo() size=", " recentIdx=", TAG);
        this.mColorDataHelper.setPaletteInfo(this.context, paletteInfo, recentPageIndex);
        int paletteSize = this.mColorDataHelper.getPaletteSize() + (recentPageIndex != -1 ? 1 : 0);
        palette.setPaletteInfo(paletteSize);
        initConfigTable(paletteSize, palette, recentPageIndex);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setEyedropperColor(int color) {
    }
}
