package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.graphics.Color;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000 <2\u00020\u0001:\u0001<B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J!\u0010\u0014\u001a\u00020\u00052\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0016\"\u00020\fH\u0016¢\u0006\u0002\u0010\u0017J(\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\u00052\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\bH\u0016J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0016J\u0016\u0010+\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0%H\u0016J\b\u0010-\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\bH\u0016J\u0018\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001bH\u0016J\u0010\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0005H\u0016J\u0018\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0002J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\bH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u00105\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0013¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenSwipePaletteControl;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewControl;", "context", "Landroid/content/Context;", "hasRecentPage", "", "hasEyedropper", "maxRecent", "", "<init>", "(Landroid/content/Context;ZZI)V", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "mPaletteViewActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "close", "", "defaultPageIndex", "getDefaultPageIndex", "()I", "setPaletteView", "paletteViewInterfaces", "", "([Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;)Z", "setColor", "uiInfo", "color", "", "opacity", "needAnimation", "recentPageIndex", "getRecentPageIndex", "setPickerColor", "setEyedropperColor", "resetColor", "setRecentColor", "recentList", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "getColorUIInfo", "type", "setPaletteInfo", "paletteInfo", "getPalette", "setPalette", "paletteID", "onRecentColorSelected", "childAt", "hsvColor", "setEyedropperEnabled", "enabled", "currentPageIndex", "getCurrentPageIndex", "updateLayout", "needMoveToCurrent", "updatePickerColor", "pageIndex", "isRecentPage", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSwipePaletteControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSwipePaletteControl.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenSwipePaletteControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
public final class SpenSwipePaletteControl extends SpenPaletteViewControl {
    private static final int RECENT_PAGE_INDEX = 0;

    @NotNull
    private static final String TAG = "SpenSwipePaletteControl";

    @Nullable
    private SpenPaletteViewInterface mPaletteView;

    @NotNull
    private final SpenPaletteViewActionListener mPaletteViewActionListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSwipePaletteControl(@NotNull Context context, boolean z, boolean z2, int i) {
        super(context, z, z2, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaletteViewActionListener = new SpenPaletteViewActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenSwipePaletteControl$mPaletteViewActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int pageIndex, int childAt, boolean isSelected) {
                SpenPaletteViewInterface spenPaletteViewInterface;
                if (this.this$0.mPaletteView == null || (spenPaletteViewInterface = this.this$0.mPaletteView) == null) {
                    return;
                }
                SpenSwipePaletteControl spenSwipePaletteControl = this.this$0;
                if (spenSwipePaletteControl.onEventButtonClick(pageIndex, childAt) || spenSwipePaletteControl.onRecentColorSelect(spenPaletteViewInterface, pageIndex, childAt, isSelected)) {
                    return;
                }
                spenSwipePaletteControl.onPaletteColorSelect(spenPaletteViewInterface, pageIndex, childAt, isSelected);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int pageIndex, int direction) {
                this.this$0.notifyPaletteSwipe(pageIndex, direction);
            }
        };
    }

    private final int getCurrentPageIndex() {
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            return spenPaletteViewInterface.getMCurrentPage();
        }
        return -1;
    }

    private final boolean isRecentPage(int pageIndex) {
        return getMHasRecentPage() && pageIndex == 0;
    }

    private final void updateLayout(boolean needMoveToCurrent, boolean needAnimation) {
        int pickerIndexInPalette;
        boolean z;
        int pageIndex;
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            int currentPage = spenPaletteViewInterface.getMCurrentPage();
            if (getPageIndex() != getRecentPageIndex()) {
                pickerIndexInPalette = getFrom() == 4 ? getPickerIndexInPalette() : getCurrentChildIndex();
                if (pickerIndexInPalette == -1) {
                    pickerIndexInPalette = getPickerIndexInPalette();
                }
                if (pickerIndexInPalette == getPickerIndexInPalette()) {
                    updatePickerColor(getPageIndex(), pickerIndexInPalette);
                    z = false;
                }
                pageIndex = getPageIndex();
                clearChecked(spenPaletteViewInterface, pageIndex, true);
                setSelected(spenPaletteViewInterface, pageIndex, pickerIndexInPalette, true, false);
                if (needMoveToCurrent && currentPage != pageIndex) {
                    spenPaletteViewInterface.setPage(pageIndex, needAnimation);
                }
                resetChecked(spenPaletteViewInterface, pageIndex, z);
            }
            pickerIndexInPalette = getCurrentChildIndex();
            z = true;
            pageIndex = getPageIndex();
            clearChecked(spenPaletteViewInterface, pageIndex, true);
            setSelected(spenPaletteViewInterface, pageIndex, pickerIndexInPalette, true, false);
            if (needMoveToCurrent) {
                spenPaletteViewInterface.setPage(pageIndex, needAnimation);
            }
            resetChecked(spenPaletteViewInterface, pageIndex, z);
        }
    }

    private final void updatePickerColor(int pageIndex, int childAt) {
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            applyColorInPicker(spenPaletteViewInterface.getSelectorDrawable(pageIndex, childAt));
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void close() {
        this.mPaletteView = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public int getColorUIInfo(int type) {
        if (type != 1) {
            if (type == 4) {
                int currentPageIndex = getCurrentPageIndex();
                if (isRecentPage(currentPageIndex)) {
                    currentPageIndex = getDefaultPageIndex();
                }
                if (currentPageIndex > -1) {
                    return SpenPaletteDefine.getColorUIInfo(getPaletteIDFromViewIdx(currentPageIndex), 4);
                }
            }
        } else if (getMHasRecentPage()) {
            return SpenPaletteDefine.getColorUIInfo(0, 1);
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public int getDefaultPageIndex() {
        return getMHasRecentPage() ? 1 : 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public int getPalette() {
        int currentPageIndex = getCurrentPageIndex();
        return currentPageIndex == -1 ? currentPageIndex : getPaletteIDFromViewIdx(currentPageIndex);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public int getRecentPageIndex() {
        return getMHasRecentPage() ? 0 : -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public boolean onRecentColorSelected(int childAt, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        if (!super.onRecentColorSelected(childAt, hsvColor)) {
            return false;
        }
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            resetChecked(spenPaletteViewInterface, 0, true);
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void resetColor() {
        super.resetColor();
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            resetChecked(spenPaletteViewInterface, spenPaletteViewInterface.getPageCount(), true);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColor(int uiInfo, @NotNull float[] color, int opacity, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(color, "color");
        super.setColor(uiInfo, color, opacity, needAnimation);
        if (SpenPaletteDefine.getFromType(uiInfo) != 8) {
            updateLayout(true, needAnimation);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setColorTheme(int theme) {
        super.setColorTheme(theme);
        updateLayout(false, false);
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

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl
    public void setEyedropperEnabled(boolean enabled) {
        List<SpenHSVColor> recentColor;
        int currentChildIndex;
        AbstractC6670b.m4758s("setEyedropperEnabled() hasRecentPage=", " enabled=", TAG, getMHasRecentPage(), enabled);
        if (getMHasRecentPage()) {
            super.setEyedropperEnabled(enabled);
            if (enabled || getPageIndex() != getRecentPageIndex() || (recentColor = getRecentColor()) == null || (currentChildIndex = getCurrentChildIndex()) == -1 || currentChildIndex != recentColor.size() - 1) {
                return;
            }
            AbstractC2322a.m1631u(currentChildIndex, "updateLayout() in setEyedropperEnabled() childIndex=", TAG);
            updateLayout(false, false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPalette(int paletteID) {
        int viewIndex = getViewIndex(paletteID);
        if (viewIndex == -1) {
            return false;
        }
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface == null) {
            return true;
        }
        spenPaletteViewInterface.setPage(viewIndex, false);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setPaletteInfo(@NotNull List<Integer> paletteInfo) {
        Intrinsics.checkNotNullParameter(paletteInfo, "paletteInfo");
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            return setPaletteInfo(paletteInfo, spenPaletteViewInterface, null, getRecentPageIndex());
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
        this.mPaletteView = spenPaletteViewInterface;
        if (spenPaletteViewInterface != null) {
            spenPaletteViewInterface.setPaletteActionListener(this.mPaletteViewActionListener);
            initRecentControl(spenPaletteViewInterface);
            SpenPaletteConfig spenPaletteConfigCreatePaletteConfig = SpenPaletteConfigFactory.createPaletteConfig(spenPaletteViewInterface, getContext());
            initPaletteConfig(spenPaletteConfigCreatePaletteConfig);
            if (spenPaletteConfigCreatePaletteConfig != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public void setPickerColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        int currentPageIndex = getCurrentPageIndex();
        if (currentPageIndex == -1) {
            return;
        }
        if (isRecentPage(currentPageIndex)) {
            currentPageIndex = getDefaultPageIndex();
        }
        setColor(SpenPaletteDefine.getColorUIInfo(getPaletteIDFromViewIdx(currentPageIndex), 4), color, 255, true);
        notifyColorChanged();
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewControl, com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface
    public boolean setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        if (!super.setRecentColor(recentList)) {
            return false;
        }
        if (isSameCurrentFromType(1)) {
            updateLayout(true, false);
        }
        return true;
    }
}
