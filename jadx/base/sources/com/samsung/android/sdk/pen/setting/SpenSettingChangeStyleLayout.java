package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.setting.SpenChangeStyleLayoutControl;
import com.samsung.android.sdk.pen.setting.SpenColorControl;
import com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.changestyle.SpenSettingChangeStyleManager;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.pencommon.SpenColorSettingInfo;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u0000 K2\u00020\u0001:\bKLMNOPQRBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&J(\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0016J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\bH\u0016J\u0018\u00102\u001a\u00020\u001b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u000eH\u0016J\u001a\u00106\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\"\u001a\u0004\u0018\u000107J\u000e\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u000eJ\u0012\u0010<\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010=\u001a\u00020\u001bJ\u0010\u0010>\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010?J\u0006\u0010@\u001a\u00020\u001bJ\u0010\u0010A\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0018J\u0018\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\bH\u0014J<\u0010I\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010J\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010F\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006S"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout;", "context", "Landroid/content/Context;", "canvasLayout", "Landroid/view/ViewGroup;", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "colorSettingInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;", "mIsSupportEyedropper", "", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Ljava/util/List;Ljava/util/List;Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;Z)V", "mChangeStyleImpl", "Lcom/samsung/android/sdk/pen/setting/SpenChangeStyleImpl;", "mLayoutControl", "Lcom/samsung/android/sdk/pen/setting/SpenChangeStyleLayoutControl;", "mVisibilityListener", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout$ViewListener;", "mGSIMLoggingListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$LoggingListener;", "mBaseContentTopMargin", "close", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "setInfo", "setChangeStyleInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$ChangeStyleInfoChangedListener;", "setCanvasBackground", "color", "", "setRoundedBackground", "radius", "", "bgColor", "strokeSize", "strokeColor", "setTitle", "text", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setPalette", "", "setEyedropperEnabled", "enabled", "addActionButton", "Landroid/view/View$OnClickListener;", "setViewMode", "viewMode", "setLayoutAnimation", "hasAnimation", "setVisibilityChangedListener", "showColorPickerPopup", "setColorPickerChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$ColorPickerChangedListener;", "showEyedropper", "setLoggingListener", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "actionButtonCount", "getActionButtonCount", "()I", "construct", "initView", "Companion", "ChangeStyleInfoChangedListener", "SpenPaletteChangedListener", "ColorPickerChangedListener", "SpenPenSpuitViewListener", "SpenColorPickerViewListener", "SpenColorSettingViewListener", "LoggingListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public class SpenSettingChangeStyleLayout extends SpenColorControlPopupLayout {

    @NotNull
    private static final String TAG = "SpenSettingChangeStyleLayout";
    public static final int VIEW_MODE_BASIC = 2;
    public static final int VIEW_MODE_EXTEND = 1;
    private int mBaseContentTopMargin;
    private SpenChangeStyleImpl mChangeStyleImpl;

    @Nullable
    private LoggingListener mGSIMLoggingListener;
    private boolean mIsSupportEyedropper;
    private SpenChangeStyleLayoutControl mLayoutControl;

    @Nullable
    private SpenPopupLayout.ViewListener mVisibilityListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$ChangeStyleInfoChangedListener;", "Lcom/samsung/android/sdk/pen/setting/changestyle/SpenSettingChangeStyleManager$ChangeStyleInfoChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ChangeStyleInfoChangedListener extends SpenSettingChangeStyleManager.ChangeStyleInfoChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$ColorPickerChangedListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$ColorPickerModeChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ColorPickerChangedListener extends SpenColorControlPopupLayout.ColorPickerModeChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$LoggingListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorSAListener;", "onClosed", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface LoggingListener extends SpenColorSAListener {
        void onClosed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$SpenColorPickerViewListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$SettingViewListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SpenColorPickerViewListener extends SpenColorControlPopupLayout.SettingViewListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$SpenColorSettingViewListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$SettingViewListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SpenColorSettingViewListener extends SpenColorControlPopupLayout.SettingViewListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$SpenPaletteChangedListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$PaletteChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SpenPaletteChangedListener extends SpenColorControlPopupLayout.PaletteChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingChangeStyleLayout$SpenPenSpuitViewListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$SettingViewListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SpenPenSpuitViewListener extends SpenColorControlPopupLayout.SettingViewListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingChangeStyleLayout(@NotNull Context context, @NotNull ViewGroup canvasLayout, @NotNull List<Integer> paletteList, @NotNull List<SpenHSVColor> recentList, @NotNull SpenColorSettingInfo colorSettingInfo, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(canvasLayout, "canvasLayout");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(colorSettingInfo, "colorSettingInfo");
        this.mIsSupportEyedropper = z;
        construct(context, canvasLayout, paletteList, recentList, colorSettingInfo);
        setViewMode(2);
    }

    private final void construct(Context context, ViewGroup canvasLayout, List<Integer> paletteList, List<SpenHSVColor> recentList, SpenColorSettingInfo colorSettingInfo) {
        Log.i(TAG, "construct() ");
        this.mChangeStyleImpl = new SpenChangeStyleImpl(context);
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = new SpenChangeStyleLayoutControl();
        this.mLayoutControl = spenChangeStyleLayoutControl;
        spenChangeStyleLayoutControl.setModeChangedListener(new SpenChangeStyleLayoutControl.ModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout.construct.1
            @Override // com.samsung.android.sdk.pen.setting.SpenChangeStyleLayoutControl.ModeChangedListener
            public void onModeChanged(int mode) {
                SpenChangeStyleImpl spenChangeStyleImpl = SpenSettingChangeStyleLayout.this.mChangeStyleImpl;
                SpenChangeStyleLayoutControl spenChangeStyleLayoutControl2 = null;
                if (spenChangeStyleImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
                    spenChangeStyleImpl = null;
                }
                if (spenChangeStyleImpl.changeType(mode)) {
                    SpenChangeStyleLayoutControl spenChangeStyleLayoutControl3 = SpenSettingChangeStyleLayout.this.mLayoutControl;
                    if (spenChangeStyleLayoutControl3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                    } else {
                        spenChangeStyleLayoutControl2 = spenChangeStyleLayoutControl3;
                    }
                    spenChangeStyleLayoutControl2.setMode(mode);
                }
            }
        });
        initView(context);
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        initColorControl(context, canvasLayout, spenChangeStyleImpl.getColorView(), this.mIsSupportEyedropper, paletteList, recentList, colorSettingInfo);
        setOnColorChangedListener$SDK_fullRelease(new SpenColorControl.OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout.construct.2
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor, boolean maintainAlpha) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                SpenChangeStyleImpl spenChangeStyleImpl2 = SpenSettingChangeStyleLayout.this.mChangeStyleImpl;
                if (spenChangeStyleImpl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
                    spenChangeStyleImpl2 = null;
                }
                spenChangeStyleImpl2.changeColor(info, hsvColor, maintainAlpha);
            }
        });
    }

    private final void initView(Context context) {
        Resources resources = context.getResources();
        this.mBaseContentTopMargin = resources.getDimensionPixelSize(C7932R.dimen.setting_change_style_basic_content_margin_top);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        setContentView(linearLayout);
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        SpenChangeStyleImpl spenChangeStyleImpl2 = null;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.initView(linearLayout, this.mIsSupportEyedropper);
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = this.mLayoutControl;
        if (spenChangeStyleLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenChangeStyleLayoutControl = null;
        }
        SpenChangeStyleImpl spenChangeStyleImpl3 = this.mChangeStyleImpl;
        if (spenChangeStyleImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl3 = null;
        }
        View sizeView = spenChangeStyleImpl3.getSizeView();
        SpenChangeStyleImpl spenChangeStyleImpl4 = this.mChangeStyleImpl;
        if (spenChangeStyleImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl4 = null;
        }
        View colorView = spenChangeStyleImpl4.getColorView();
        SpenChangeStyleImpl spenChangeStyleImpl5 = this.mChangeStyleImpl;
        if (spenChangeStyleImpl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
        } else {
            spenChangeStyleImpl2 = spenChangeStyleImpl5;
        }
        spenChangeStyleLayoutControl.setContentView(linearLayout, sizeView, colorView, spenChangeStyleImpl2.getNoFillView());
        String string = resources.getString(C7932R.string.pen_string_close_any, resources.getString(C7932R.string.pen_string_change_pen_style_settings));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setCloseButtonDescription(string);
        setCloseButtonInfo(new ViewOnClickListenerC0157a(this, 19));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenSettingChangeStyleLayout spenSettingChangeStyleLayout, View view) {
        spenSettingChangeStyleLayout.hideAnimation(null);
        LoggingListener loggingListener = spenSettingChangeStyleLayout.mGSIMLoggingListener;
        if (loggingListener != null) {
            loggingListener.onClosed();
        }
    }

    public final void addActionButton(@Nullable CharSequence text, @Nullable View.OnClickListener listener) {
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = this.mLayoutControl;
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl2 = null;
        if (spenChangeStyleLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenChangeStyleLayoutControl = null;
        }
        View viewAddActionButton = spenChangeStyleLayoutControl.addActionButton(text);
        if (viewAddActionButton != null) {
            viewAddActionButton.setOnClickListener(listener);
        }
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl3 = this.mLayoutControl;
        if (spenChangeStyleLayoutControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenChangeStyleLayoutControl2 = spenChangeStyleLayoutControl3;
        }
        if (spenChangeStyleLayoutControl2.getActionButtonCount() == 1) {
            setCloseButtonVisibility(8);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout, com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void close() {
        Log.i(TAG, "close()");
        super.close();
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = null;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.close();
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl2 = this.mLayoutControl;
        if (spenChangeStyleLayoutControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenChangeStyleLayoutControl = spenChangeStyleLayoutControl2;
        }
        spenChangeStyleLayoutControl.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout
    public int getActionButtonCount() {
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = this.mLayoutControl;
        if (spenChangeStyleLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenChangeStyleLayoutControl = null;
        }
        return spenChangeStyleLayoutControl.getActionButtonCount();
    }

    @Nullable
    public final SpenSettingUIChangeStyleInfo getInfo() {
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        return spenChangeStyleImpl.getInfo();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout, android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        SpenPopupLayout.ViewListener viewListener;
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        Log.i(TAG, "onVisibilityChanged() : " + visibility);
        if (changedView == this && visibility == getVisibility() && (viewListener = this.mVisibilityListener) != null) {
            viewListener.onVisibilityChanged(visibility);
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final void setCanvasBackground(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Float.valueOf(color[0]), Float.valueOf(color[1]), Float.valueOf(color[2])}, 3, "setCanvasBackground() [%f, %f, %f]", "format(format, *args)", TAG);
        setCanvasBackgroundColor(color);
    }

    public final void setChangeStyleInfoChangedListener(@Nullable ChangeStyleInfoChangedListener listener) {
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.setChangeStyleInfoChangedListener(listener);
    }

    public final void setColorPickerChangedListener(@Nullable ColorPickerChangedListener listener) {
        setColorPickerViewModeChangedListener(listener);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout
    public void setColorTheme(int theme) {
        AbstractC2322a.m1631u(theme, "setColorTheme() - ", TAG);
        super.setColorTheme(theme);
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.setColorTheme(theme);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout
    public void setEyedropperEnabled(boolean enabled) {
        AbstractC6670b.m4758s("setEyedropperEnabled() ", " -> ", TAG, this.mIsSupportEyedropper, enabled);
        if (this.mIsSupportEyedropper == enabled) {
            return;
        }
        this.mIsSupportEyedropper = enabled;
        super.setEyedropperEnabled(enabled);
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.setEyedropperEnabled(enabled);
    }

    public final void setInfo(@NotNull SpenSettingUIChangeStyleInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Log.i(TAG, "setInfo()");
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = null;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.setInfo(info);
        SpenChangeStyleImpl spenChangeStyleImpl2 = this.mChangeStyleImpl;
        if (spenChangeStyleImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl2 = null;
        }
        SpenSettingUIChangeStyleInfo info2 = spenChangeStyleImpl2.getInfo();
        if (info2 != null) {
            SpenChangeStyleLayoutControl spenChangeStyleLayoutControl2 = this.mLayoutControl;
            if (spenChangeStyleLayoutControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            } else {
                spenChangeStyleLayoutControl = spenChangeStyleLayoutControl2;
            }
            spenChangeStyleLayoutControl.setMode(info2.type);
        }
    }

    public final void setLayoutAnimation(boolean hasAnimation) {
        setAnimation(hasAnimation);
    }

    public final void setLoggingListener(@Nullable LoggingListener listener) {
        this.mGSIMLoggingListener = listener;
        setColorLogListener(listener);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout, com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPalette(@Nullable List<Integer> paletteList) {
        super.setPalette(paletteList);
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        spenChangeStyleImpl.refreshColor();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void setRoundedBackground(float radius, int bgColor, int strokeSize, int strokeColor) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Float.valueOf(radius), Integer.valueOf(bgColor), Integer.valueOf(strokeSize), Integer.valueOf(strokeColor)}, 4, "setRoundedBackground() r=%f, bgColor=#%08X, stroke=%d, strokeColor=#%08X", "format(format, *args)", TAG);
        super.setRoundedBackground(radius, bgColor, strokeSize, strokeColor);
    }

    public final void setTitle(@NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Log.i(TAG, "setTitle() [" + ((Object) text) + "]");
        setTitleText(text);
    }

    public final void setViewMode(int viewMode) {
        SpenChangeStyleLayoutControl spenChangeStyleLayoutControl = this.mLayoutControl;
        if (spenChangeStyleLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenChangeStyleLayoutControl = null;
        }
        if (spenChangeStyleLayoutControl.changeViewMode(viewMode)) {
            if (viewMode == 2) {
                setContentTopMargin(this.mBaseContentTopMargin);
                setTitleVisibility(0);
            } else {
                setContentTopMargin(0);
                setTitleVisibility(8);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void setVisibilityChangedListener(@Nullable SpenPopupLayout.ViewListener listener) {
        this.mVisibilityListener = listener;
    }

    public final void showColorPickerPopup() {
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        SpenSettingUIChangeStyleInfo info = spenChangeStyleImpl.getInfo();
        if (info == null) {
            return;
        }
        showColorPickerPopup(info.type == 0 ? info.strokeHSVColor : info.fillHSVColor);
    }

    public final void showEyedropper() {
        Log.i(TAG, "showEyedropper()");
        SpenChangeStyleImpl spenChangeStyleImpl = this.mChangeStyleImpl;
        if (spenChangeStyleImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChangeStyleImpl");
            spenChangeStyleImpl = null;
        }
        SpenSettingUIChangeStyleInfo info = spenChangeStyleImpl.getInfo();
        if (info == null) {
            return;
        }
        showEyedropper(info.type == 0 ? info.strokeHSVColor : info.fillHSVColor);
    }
}
