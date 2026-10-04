package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.setting.changestyle.SpenSettingChangeStyleManager;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorPaletteLayout;
import com.samsung.android.sdk.pen.setting.common.SpenSelectView;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayoutInterface;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u0014J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*J\u001e\u0010+\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020\u0016J\u0010\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u000102J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020*J \u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u0014H\u0002J\u000e\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010 \u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR(\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006<"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenChangeStyleImpl;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mChangeStyleManager", "Lcom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager;", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mSizeLayout", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenSizeLayout;", "mColorLayout", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorPaletteLayout;", "mNoFillLayout", "Landroid/view/ViewGroup;", "mNoFillCheckBox", "Lcom/samsung/android/sdk/pen/setting/common/SpenSelectView;", "mContext", "mInitCompleted", "", "close", "", "initView", "parent", "isSupportEyedropper", "sizeView", "Landroid/view/View;", "getSizeView", "()Landroid/view/View;", "colorView", "getColorView", "noFillView", "getNoFillView", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "setInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;)V", "changeType", "type", "", "changeColor", "hsvColor", "", "maintainAlpha", "refreshColor", "setChangeStyleInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager$ChangeStyleInfoChangedListener;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "updateView", "updateInfo", "hasCheckedAnimation", "hasPaletteAnimation", "setEyedropperEnabled", "enabled", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenChangeStyleImpl {

    @NotNull
    private static final String TAG = "SpenChangeStyleImp";
    private static final int UPDATE_ALL = 7;
    private static final int UPDATE_COLOR = 4;
    private static final int UPDATE_NO_FILL = 2;
    private static final int UPDATE_SIZE = 1;

    @NotNull
    private SpenSettingChangeStyleManager mChangeStyleManager;

    @Nullable
    private SpenColorPaletteLayout mColorLayout;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;

    @NotNull
    private Context mContext;
    private boolean mInitCompleted;

    @Nullable
    private SpenSelectView mNoFillCheckBox;

    @Nullable
    private ViewGroup mNoFillLayout;

    @Nullable
    private SpenPenSizeLayout mSizeLayout;

    public SpenChangeStyleImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mChangeStyleManager = new SpenSettingChangeStyleManager();
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mInitCompleted = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenChangeStyleImpl spenChangeStyleImpl, View view) {
        if (spenChangeStyleImpl.mNoFillCheckBox != null) {
            if (spenChangeStyleImpl.mChangeStyleManager.changeBlankShape(!r3.isSelected())) {
                spenChangeStyleImpl.updateView(6, true, true);
            }
        }
    }

    private final void updateView(int updateInfo, boolean hasCheckedAnimation, boolean hasPaletteAnimation) {
        SpenSelectView spenSelectView;
        AbstractC2322a.m1631u(updateInfo, "updateView() info=", TAG);
        SpenSettingUIChangeStyleInfo changeStyleInfo = this.mChangeStyleManager.getChangeStyleInfo();
        if ((updateInfo & 1) == 1) {
            int color = this.mColorThemeUtil.getColor(changeStyleInfo.color);
            changeStyleInfo.color = color;
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeLayout;
            if (spenPenSizeLayout != null) {
                spenPenSizeLayout.setPenInfo("", changeStyleInfo.sizeLevel, color);
            }
        }
        if ((updateInfo & 2) == 2 && (spenSelectView = this.mNoFillCheckBox) != null) {
            spenSelectView.setSelected(changeStyleInfo.isBlankShape, hasCheckedAnimation);
        }
        if ((updateInfo & 4) == 4) {
            int i = changeStyleInfo.type;
            if (i == 0) {
                SpenColorPaletteLayout spenColorPaletteLayout = this.mColorLayout;
                if (spenColorPaletteLayout != null) {
                    spenColorPaletteLayout.setColor(changeStyleInfo.strokeColorUIInfo, changeStyleInfo.strokeHSVColor, hasPaletteAnimation);
                    return;
                }
                return;
            }
            if (i == 1) {
                if (changeStyleInfo.isBlankShape) {
                    SpenColorPaletteLayout spenColorPaletteLayout2 = this.mColorLayout;
                    if (spenColorPaletteLayout2 != null) {
                        spenColorPaletteLayout2.resetColor();
                        return;
                    }
                    return;
                }
                SpenColorPaletteLayout spenColorPaletteLayout3 = this.mColorLayout;
                if (spenColorPaletteLayout3 != null) {
                    spenColorPaletteLayout3.setColor(changeStyleInfo.fillColorUIInfo, changeStyleInfo.fillHSVColor, hasPaletteAnimation);
                }
            }
        }
    }

    public final boolean changeColor(int info, @NotNull float[] hsvColor, boolean maintainAlpha) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("SpenColorControl.onColorChanged() info=", info, " color[", hsvColor[0], SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
        SpenSettingUIChangeStyleInfo changeStyleInfo = this.mChangeStyleManager.getChangeStyleInfo();
        int i = changeStyleInfo.type;
        if (i == 0) {
            if (!this.mChangeStyleManager.changeColor(i, info, hsvColor, maintainAlpha, true)) {
                return false;
            }
            updateView(1, false, true);
            return true;
        }
        this.mChangeStyleManager.changeColor(i, info, hsvColor, maintainAlpha, !changeStyleInfo.isBlankShape);
        if (!changeStyleInfo.isBlankShape) {
            return true;
        }
        this.mChangeStyleManager.changeBlankShape(false);
        updateView(2, true, true);
        return true;
    }

    public final boolean changeType(int type) {
        if (!this.mChangeStyleManager.changeType(type)) {
            return false;
        }
        updateView(4, false, true);
        return true;
    }

    public final void close() {
        this.mChangeStyleManager.close();
        this.mColorThemeUtil.close();
        if (this.mInitCompleted) {
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeLayout;
            if (spenPenSizeLayout != null) {
                spenPenSizeLayout.close();
            }
            this.mSizeLayout = null;
            SpenColorPaletteLayout spenColorPaletteLayout = this.mColorLayout;
            if (spenColorPaletteLayout != null) {
                spenColorPaletteLayout.close();
            }
            this.mColorLayout = null;
            SpenSelectView spenSelectView = this.mNoFillCheckBox;
            if (spenSelectView != null) {
                spenSelectView.close();
            }
            this.mNoFillCheckBox = null;
        }
    }

    @Nullable
    public final View getColorView() {
        return this.mColorLayout;
    }

    @Nullable
    public final SpenSettingUIChangeStyleInfo getInfo() {
        return this.mChangeStyleManager.getChangeStyleInfo();
    }

    @Nullable
    public final View getNoFillView() {
        return this.mNoFillLayout;
    }

    @Nullable
    public final View getSizeView() {
        return this.mSizeLayout;
    }

    public final void initView(@Nullable ViewGroup parent, boolean isSupportEyedropper) {
        SpenPenSizeLayout spenPenSizeLayout = new SpenPenSizeLayout(this.mContext);
        this.mSizeLayout = spenPenSizeLayout;
        spenPenSizeLayout.setActionListener(new SpenPenSizeLayoutInterface.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenChangeStyleImpl.initView.1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayoutInterface.ActionListener
            public void onSizeChanged(int sizeLevel, float dpSize) {
                SpenChangeStyleImpl.this.mChangeStyleManager.changeSizeLevel(sizeLevel);
            }
        });
        int i = C7932R.layout.setting_change_style_no_fill;
        Object systemService = this.mContext.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(i, parent, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        SpenSelectView spenSelectView = (SpenSelectView) linearLayout.findViewById(C7932R.id.no_fill_check_box);
        this.mNoFillCheckBox = spenSelectView;
        if (spenSelectView != null) {
            spenSelectView.setCheckColor(SpenSettingUtil.getColor(this.mContext, C7932R.color.setting_title_string_color));
        }
        SpenSettingUtilText.applyUpToLargeLevel(this.mContext, 16.0f, (TextView) linearLayout.findViewById(C7932R.id.no_fill_text));
        linearLayout.setOnClickListener(new ViewOnClickListenerC0157a(this, 17));
        this.mNoFillLayout = linearLayout;
        this.mColorLayout = new SpenColorPaletteLayout(this.mContext, null, isSupportEyedropper);
        this.mInitCompleted = true;
    }

    public final void refreshColor() {
        updateView(4, false, false);
    }

    public final void setChangeStyleInfoChangedListener(@Nullable SpenSettingChangeStyleManager.ChangeStyleInfoChangedListener listener) {
        this.mChangeStyleManager.setChangeStyleInfoChangedListener(listener);
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
        updateView(7, false, true);
    }

    public final void setEyedropperEnabled(boolean enabled) {
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorLayout;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.setEyedropperEnabled(enabled);
        }
    }

    public final void setInfo(@Nullable SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        if (this.mChangeStyleManager.setChangeStyleInfo(spenSettingUIChangeStyleInfo)) {
            updateView(7, false, false);
        }
    }
}
