package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001I\b\u0016\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u001cJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0018\u0010$\u001a\u00020\u00062\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J\u0010\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010/\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u00100\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u00101\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u00102\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0&H\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016J\u0016\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001aJ\b\u00104\u001a\u00020\u001aH\u0016J\u000e\u0010;\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u001aJ\u0010\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u001aH\u0016J\u0010\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u001aH\u0004J\u000e\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u0006J\u0010\u0010B\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\nJ \u0010D\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u00107\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u0010+\"\u0004\b9\u0010:R\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010JR\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorBaseLayout;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteSetting;", "context", "Landroid/content/Context;", "mIsSupportEyedropper", "", "<init>", "(Landroid/content/Context;Z)V", "mPaletteViewControl", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewControl;", "mIsControlOwner", "mActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "mColorChangeListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangeListener;", "mPaletteSwipeListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnPaletteSwipeListener;", "mColorButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorButtonListener;", "mColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangedListener;", "close", "", "setColor", "uiInfo", "", "color", "", "needAnimation", "opacity", "setPickerColor", "hsvColor", "setEyedropperColor", "resetColor", "addRecentColor", "setRecentColor", "recentColors", "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "getRecentColor", "getColor", "getOpacity", "()I", "setOnActionButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnColorChangeListener", "setOnPaletteSwipeListener", "setOnColorButtonListener", "setOnColorChangedListener", "setPaletteList", "palettes", "getUiInfo", "type", "paletteID", "palette", "getPalette", "setPalette", "(I)V", "containsPalette", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setRecentIndicatorSize", "size", "setEyedropperEnabled", "enabled", "setPaletteControl", "paletteControl", "initView", "paletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "maxRecentCount", "mOnColorPaletteChangeListener", "com/samsung/android/sdk/pen/setting/colorpalette/SpenColorBaseLayout$mOnColorPaletteChangeListener$1", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorBaseLayout$mOnColorPaletteChangeListener$1;", "mPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteControlInterface$OnPaletteActionListener;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenColorBaseLayout extends FrameLayout implements SpenPaletteSetting {

    @NotNull
    private static final String TAG = "SpenColorBaseLayout";

    @Nullable
    private OnActionButtonListener mActionButtonListener;

    @Nullable
    private OnColorButtonListener mColorButtonListener;

    @Nullable
    private OnColorChangeListener mColorChangeListener;

    @Nullable
    private OnColorChangedListener mColorChangedListener;
    private boolean mIsControlOwner;
    private final boolean mIsSupportEyedropper;

    @NotNull
    private final SpenColorBaseLayout$mOnColorPaletteChangeListener$1 mOnColorPaletteChangeListener;

    @NotNull
    private final SpenPaletteControlInterface.OnPaletteActionListener mPaletteActionListener;

    @Nullable
    private OnPaletteSwipeListener mPaletteSwipeListener;

    @Nullable
    private SpenPaletteViewControl mPaletteViewControl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout$mOnColorPaletteChangeListener$1] */
    public SpenColorBaseLayout(@NotNull Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsSupportEyedropper = z;
        this.mOnColorPaletteChangeListener = new SpenPaletteControlInterface.OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout$mOnColorPaletteChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor, int opacity) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                OnColorChangeListener onColorChangeListener = this.this$0.mColorChangeListener;
                if (onColorChangeListener != null) {
                    onColorChangeListener.onColorChanged(info, hsvColor);
                }
                OnColorChangedListener onColorChangedListener = this.this$0.mColorChangedListener;
                if (onColorChangedListener != null) {
                    onColorChangedListener.onColorChanged(info, hsvColor, opacity);
                }
            }
        };
        this.mPaletteActionListener = new SpenPaletteControlInterface.OnPaletteActionListener() { // from class: com.samsung.android.sdk.pen.setting.colorpalette.SpenColorBaseLayout$mPaletteActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface.OnPaletteActionListener
            public void onButtonClick(int which) {
                OnActionButtonListener onActionButtonListener = this.this$0.mActionButtonListener;
                if (onActionButtonListener != null) {
                    onActionButtonListener.onButtonClick(which);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface.OnPaletteActionListener
            public void onColorSelected(int pageIndex, int colorIndex, boolean isSelected) {
                OnColorButtonListener onColorButtonListener = this.this$0.mColorButtonListener;
                if (onColorButtonListener != null) {
                    onColorButtonListener.onColorSelected(pageIndex, colorIndex, isSelected);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteControlInterface.OnPaletteActionListener
            public void onPaletteSwipe(int position, int direction) {
                AbstractC6670b.m4744e(position, direction, "onPaletteSwipe() position=", "direction=", "SpenColorBaseLayout");
                SpenPaletteViewControl spenPaletteViewControl = this.this$0.mPaletteViewControl;
                if (spenPaletteViewControl != null) {
                    SpenColorBaseLayout spenColorBaseLayout = this.this$0;
                    int paletteIDFromViewIdx = spenPaletteViewControl.getPaletteIDFromViewIdx(position);
                    OnPaletteSwipeListener onPaletteSwipeListener = spenColorBaseLayout.mPaletteSwipeListener;
                    if (onPaletteSwipeListener != null) {
                        onPaletteSwipeListener.onPaletteSwipe(direction, paletteIDFromViewIdx);
                    }
                }
            }
        };
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public boolean addRecentColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.addRecentColor(hsvColor);
        }
        return false;
    }

    public void close() {
        SpenPaletteViewControl spenPaletteViewControl;
        if (this.mIsControlOwner && (spenPaletteViewControl = this.mPaletteViewControl) != null && spenPaletteViewControl != null) {
            spenPaletteViewControl.close();
        }
        this.mPaletteViewControl = null;
        this.mIsControlOwner = false;
        this.mActionButtonListener = null;
        this.mColorChangeListener = null;
        this.mPaletteSwipeListener = null;
        this.mColorButtonListener = null;
        this.mColorChangedListener = null;
    }

    public final boolean containsPalette(int paletteID) {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.containsPalette(paletteID);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void getColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.getColor(color);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public int getOpacity() {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.getMOpacity();
        }
        return 255;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public int getPalette() {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.getPalette();
        }
        return -1;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    @Nullable
    public List<SpenHSVColor> getRecentColor() {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.getRecentColor();
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public int getUiInfo(int type) {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl == null) {
            return 0;
        }
        if (type == 1) {
            return spenPaletteViewControl.getColorUIInfo(4);
        }
        if (type != 2) {
            return 0;
        }
        return spenPaletteViewControl.getColorUIInfo(1);
    }

    public final void initView(@NotNull Context context, @Nullable SpenPaletteViewInterface paletteView, int maxRecentCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        SpenSwipePaletteControl spenSwipePaletteControl = new SpenSwipePaletteControl(context, true, this.mIsSupportEyedropper, maxRecentCount);
        this.mPaletteViewControl = spenSwipePaletteControl;
        this.mIsControlOwner = true;
        if (paletteView == null || !spenSwipePaletteControl.setPaletteView(paletteView)) {
            return;
        }
        spenSwipePaletteControl.setColorChangeListener(this.mOnColorPaletteChangeListener);
        spenSwipePaletteControl.setPaletteActionListener(this.mPaletteActionListener);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void resetColor() {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.resetColor();
        }
    }

    public final void setColor(int uiInfo, @NotNull float[] color, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(color, "color");
        float f = color[0];
        float f4 = color[1];
        float f5 = color[2];
        StringBuilder sbM1628r = AbstractC2322a.m1628r("setColor() uiInfo=", uiInfo, " color[", f, SQLKeyword.COMMA);
        AbstractC11014a.m12337v(sbM1628r, f4, SQLKeyword.COMMA, f5, "] needAnimation=");
        AbstractC0000a.m27x(sbM1628r, needAnimation, TAG);
        setColor(uiInfo, color, 255, needAnimation);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setColorTheme(int theme) {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setColorTheme(theme);
        }
    }

    public final void setEyedropperColor(int color) {
        int i = color | (-16777216);
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setEyedropperColor(i);
        }
    }

    public final void setEyedropperEnabled(boolean enabled) {
        AbstractC4539a.m3208r("setEyedropperEnabled() enabled=", TAG, enabled);
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setEyedropperEnabled(enabled);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setOnActionButtonListener(@Nullable OnActionButtonListener listener) {
        this.mActionButtonListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setOnColorButtonListener(@Nullable OnColorButtonListener listener) {
        this.mColorButtonListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setOnColorChangeListener(@Nullable OnColorChangeListener listener) {
        this.mColorChangeListener = listener;
    }

    public void setOnColorChangedListener(@Nullable OnColorChangedListener listener) {
        this.mColorChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setOnPaletteSwipeListener(@Nullable OnPaletteSwipeListener listener) {
        this.mPaletteSwipeListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setPalette(int i) {
        AbstractC2322a.m1631u(i, "setPalette() paletteId=", TAG);
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setPalette(i);
        }
    }

    public final void setPaletteControl(@Nullable SpenPaletteViewControl paletteControl) {
        this.mPaletteViewControl = paletteControl;
        if (paletteControl != null) {
            paletteControl.setColorChangeListener(this.mOnColorPaletteChangeListener);
        }
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setPaletteActionListener(this.mPaletteActionListener);
        }
        this.mIsControlOwner = false;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public boolean setPaletteList(@NotNull List<Integer> palettes) {
        Intrinsics.checkNotNullParameter(palettes, "palettes");
        AbstractC2322a.m1631u(palettes.size(), "setPaletteList() size=", TAG);
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.setPaletteInfo(palettes);
        }
        return false;
    }

    public final void setPickerColor(@Nullable float[] hsvColor) {
        SpenPaletteViewControl spenPaletteViewControl;
        if (hsvColor == null || (spenPaletteViewControl = this.mPaletteViewControl) == null) {
            return;
        }
        spenPaletteViewControl.setPickerColor(hsvColor);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public boolean setRecentColor(@Nullable List<SpenHSVColor> recentColors) {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.setRecentColor(recentColors);
        }
        return false;
    }

    public final void setRecentIndicatorSize(int size) {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setRecentIndicatorSize(size);
        }
    }

    public final int getUiInfo(int type, int paletteID) {
        SpenPaletteViewControl spenPaletteViewControl;
        if (type == 1) {
            return SpenPaletteDefine.getColorUIInfo(paletteID, 4);
        }
        if (type == 2 && (spenPaletteViewControl = this.mPaletteViewControl) != null) {
            return spenPaletteViewControl.getColorUIInfo(1);
        }
        return 0;
    }

    public int getUiInfo() {
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            return spenPaletteViewControl.getUIInfo();
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting
    public void setColor(int uiInfo, @NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        setColor(uiInfo, color, 255, true);
    }

    public final void setColor(int uiInfo, @NotNull float[] color, int opacity, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(color, "color");
        SpenPaletteViewControl spenPaletteViewControl = this.mPaletteViewControl;
        if (spenPaletteViewControl != null) {
            spenPaletteViewControl.setColor(uiInfo, color, opacity, needAnimation);
        }
    }
}
