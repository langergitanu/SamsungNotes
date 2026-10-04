package com.samsung.android.sdk.pen.setting.colorpalette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000 32\u00020\u0001:\u00013B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0016\u001a\u00020\u00052\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0018\"\u00020\fH\u0016¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\u0018\u0010%\u001a\u00020\u00052\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0016J\u0016\u0010-\u001a\u00020\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0'H\u0016J\u0018\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u001dH\u0016J\b\u00102\u001a\u00020\u0012H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015¨\u00064"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedPaletteControl;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewControl;", "context", "Landroid/content/Context;", "hasRecentPage", "", "hasEyedropper", "maxRecent", "", "<init>", "(Landroid/content/Context;ZZI)V", "mColorPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "mRecentPaletteView", "mPaletteViewActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "mRecentViewActionListener", "close", "", "defaultPageIndex", "getDefaultPageIndex", "()I", "setPaletteView", "paletteViewInterfaces", "", "([Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;)Z", "setColor", "uiInfo", "color", "", "opacity", "needAnimation", "recentPageIndex", "getRecentPageIndex", "setPickerColor", "setEyedropperColor", "resetColor", "setRecentColor", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "getColorUIInfo", "type", "setPaletteInfo", "paletteInfo", "onRecentColorSelected", "childAt", "hsvColor", "updateLayout", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenExtendedPaletteControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenExtendedPaletteControl.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedPaletteControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
public final class SpenExtendedPaletteControl extends SpenPaletteViewControl {

    @NotNull
    private static final String TAG = "SpenExtendedPaletteControl";

    @Nullable
    private SpenPaletteViewInterface mColorPaletteView;

    @NotNull
    private final SpenPaletteViewActionListener mPaletteViewActionListener;

    @Nullable
    private SpenPaletteViewInterface mRecentPaletteView;

    @NotNull
    private final SpenPaletteViewActionListener mRecentViewActionListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenExtendedPaletteControl(@NotNull Context context, boolean z, boolean z2, int i) {
        super(context, z, z2, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteViewActionListener = new SpenPaletteViewActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenExtendedPaletteControl$mPaletteViewActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int pageIndex, int childAt, boolean isSelected) {
                SpenPaletteViewInterface spenPaletteViewInterface = this.this$0.mColorPaletteView;
                if (spenPaletteViewInterface != null) {
                    SpenExtendedPaletteControl spenExtendedPaletteControl = this.this$0;
                    if (spenExtendedPaletteControl.onEventButtonClick(pageIndex, childAt)) {
                        return;
                    }
                    spenExtendedPaletteControl.onPaletteColorSelect(spenPaletteViewInterface, pageIndex, childAt, isSelected);
                    if (isSelected) {
                        return;
                    }
                    spenExtendedPaletteControl.clearChecked(spenPaletteViewInterface, spenExtendedPaletteControl.getRecentPageIndex(), true);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int pageIndex, int direction) {
            }
        };
        this.mRecentViewActionListener = new SpenPaletteViewActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenExtendedPaletteControl$mRecentViewActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int pageIndex, int childAt, boolean isSelected) {
                SpenExtendedPaletteControl spenExtendedPaletteControl;
                int recentPageIndex;
                Log.i("SpenExtendedPaletteControl", "onRecentButton Click!");
                SpenPaletteViewInterface spenPaletteViewInterface = this.this$0.mColorPaletteView;
                if (spenPaletteViewInterface == null || (recentPageIndex = (spenExtendedPaletteControl = this.this$0).getRecentPageIndex()) == -1 || spenExtendedPaletteControl.onEventButtonClick(recentPageIndex, childAt)) {
                    return;
                }
                spenExtendedPaletteControl.onRecentColorSelect(spenPaletteViewInterface, recentPageIndex, childAt, isSelected);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int pageIndex, int direction) {
            }
        };
    }

    private final void updateLayout() {
        SpenExtendedPaletteControl spenExtendedPaletteControl;
        SpenPaletteViewInterface spenPaletteViewInterface;
        SpenPaletteViewInterface spenPaletteViewInterface2 = this.mColorPaletteView;
        if (spenPaletteViewInterface2 != null) {
            int pageIndex = getPageIndex();
            if (pageIndex != -1) {
                clearChecked(spenPaletteViewInterface2, pageIndex, true);
                spenExtendedPaletteControl = this;
                spenExtendedPaletteControl.setSelected(spenPaletteViewInterface2, pageIndex, getCurrentChildIndex(), true, false);
            } else {
                spenExtendedPaletteControl = this;
            }
            resetChecked(spenPaletteViewInterface2, pageIndex, true);
            if (pageIndex == getRecentPageIndex() || (spenPaletteViewInterface = spenExtendedPaletteControl.mRecentPaletteView) == null) {
                return;
            }
            resetChecked(spenPaletteViewInterface, -1, true);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void close() {
        this.mColorPaletteView = null;
        this.mRecentPaletteView = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public int getColorUIInfo(int type) {
        if (type == 4) {
            return SpenPaletteDefine.getColorUIInfo(getDefaultPageIndex(), 4);
        }
        if (type == 1 && getMHasRecentPage()) {
            return SpenPaletteDefine.getColorUIInfo(0, 1);
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public int getDefaultPageIndex() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public int getRecentPageIndex() {
        SpenPaletteViewInterface spenPaletteViewInterface;
        if (!getMHasRecentPage() || (spenPaletteViewInterface = this.mColorPaletteView) == null) {
            return -1;
        }
        return spenPaletteViewInterface.getPageCount();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public boolean onRecentColorSelected(int childAt, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Integer.valueOf(childAt), Float.valueOf(hsvColor[0]), Float.valueOf(hsvColor[1]), Float.valueOf(hsvColor[2])}, 4, "onRecentColorSelected() childAt=%d Color[%f, %f, %f]", "format(format, *args)", TAG);
        if (!super.onRecentColorSelected(childAt, hsvColor)) {
            return false;
        }
        SpenPaletteViewInterface spenPaletteViewInterface = this.mColorPaletteView;
        if (spenPaletteViewInterface != null) {
            resetChecked(spenPaletteViewInterface, getRecentPageIndex(), true);
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void resetColor() {
        super.resetColor();
        SpenPaletteViewInterface spenPaletteViewInterface = this.mColorPaletteView;
        if (spenPaletteViewInterface != null) {
            resetChecked(spenPaletteViewInterface, -1, true);
        }
        SpenPaletteViewInterface spenPaletteViewInterface2 = this.mRecentPaletteView;
        if (spenPaletteViewInterface2 != null) {
            clearChecked(spenPaletteViewInterface2, getRecentPageIndex(), true);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColor(int uiInfo, @NotNull float[] color, int opacity, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(color, "color");
        super.setColor(uiInfo, color, opacity, needAnimation);
        if (SpenPaletteDefine.getFromType(uiInfo) != 8) {
            updateLayout();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColorTheme(int theme) {
        super.setColorTheme(theme);
        updateLayout();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setEyedropperColor(int color) {
        if (getMHasRecentPage()) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            setColor(SpenPaletteDefine.getColorUIInfo(0, 8), fArr, 255, true);
            notifyColorChanged();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPaletteInfo(@NotNull List<Integer> paletteInfo) {
        Intrinsics.checkNotNullParameter(paletteInfo, "paletteInfo");
        SpenPaletteViewInterface spenPaletteViewInterface = this.mColorPaletteView;
        if (spenPaletteViewInterface != null) {
            return setPaletteInfo(paletteInfo, spenPaletteViewInterface, this.mRecentPaletteView, -1);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPaletteView(@NotNull SpenPaletteViewInterface... paletteViewInterfaces) {
        Intrinsics.checkNotNullParameter(paletteViewInterfaces, "paletteViewInterfaces");
        if (paletteViewInterfaces.length == 0) {
            return false;
        }
        SpenPaletteViewInterface spenPaletteViewInterface = paletteViewInterfaces[0];
        this.mColorPaletteView = spenPaletteViewInterface;
        if (spenPaletteViewInterface != null) {
            spenPaletteViewInterface.setPaletteActionListener(this.mPaletteViewActionListener);
        }
        if (getMHasRecentPage()) {
            SpenPaletteViewInterface spenPaletteViewInterface2 = paletteViewInterfaces[1];
            this.mRecentPaletteView = spenPaletteViewInterface2;
            if (spenPaletteViewInterface2 == null) {
                Log.i(TAG, "wrong input.");
                return false;
            }
            if (spenPaletteViewInterface2 != null) {
                spenPaletteViewInterface2.setPaletteActionListener(this.mRecentViewActionListener);
            }
            initRecentControl(this.mRecentPaletteView);
        }
        initPaletteConfig(new SpenExtendedPaletteConfig(getContext()));
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setPickerColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        setColor(SpenPaletteDefine.getColorUIInfo(getDefaultPageIndex(), 4), color, 255, true);
        notifyColorChanged();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        if (!super.setRecentColor(recentList)) {
            return false;
        }
        if (isSameCurrentFromType(1)) {
            updateLayout();
        }
        return true;
    }
}
