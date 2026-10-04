package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenColorControl;
import com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting;
import com.samsung.android.sdk.pen.setting.pencommon.SpenColorSettingInfo;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0007}~\u007f\u0080\u0001\u0081\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0016JT\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001a2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010$2\u0006\u0010(\u001a\u00020)H\u0004J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001aH\u0016J\u0017\u0010,\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0002\b/J\u0012\u00100\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u000101H\u0004J\u0010\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020%H\u0016J\u000e\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u001aJ\u0010\u00106\u001a\u00020\u001c2\b\u00107\u001a\u0004\u0018\u000108J\u0018\u00109\u001a\u00020\u001c2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020%H\u0016J\u0012\u0010=\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u0012J\u0012\u0010@\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u000208H\u0016J\u0018\u0010C\u001a\u00020\u001c2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010:H\u0016J\u0012\u0010D\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010E\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\fJ\u0010\u0010F\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\fJ\u0010\u0010G\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\fJ\u0010\u0010H\u001a\u00020\u001a2\b\u0010B\u001a\u0004\u0018\u000108J\u0010\u0010I\u001a\u00020\u001c2\b\u0010B\u001a\u0004\u0018\u000108J\u0012\u0010J\u001a\u00020\u001c2\b\u0010B\u001a\u0004\u0018\u000108H\u0004J\u0006\u0010M\u001a\u00020\u001cJ\u000e\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020%J\u0010\u0010S\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u0018J\u000e\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020%J\u0012\u0010V\u001a\u00020\u001c2\b\u0010B\u001a\u0004\u0018\u000108H\u0004J\u0006\u0010W\u001a\u00020\u001cJ\u0016\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020%2\u0006\u0010_\u001a\u00020%J\u0010\u0010`\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u0010J\u0006\u0010a\u001a\u00020\u001cJ\u0006\u0010b\u001a\u00020\u001cJ\u0016\u0010d\u001a\u00020\u001a2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010:J\u0016\u0010f\u001a\u00020\u001a2\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010:J\u0010\u0010g\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010hJ\u0010\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020kH\u0014J\u001f\u0010p\u001a\u00020\u001c2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010s\u001a\u00020\u001aH\u0000¢\u0006\u0002\btJ'\u0010u\u001a\u00020\u001c2\b\u0010q\u001a\u0004\u0018\u00010r2\u0006\u0010v\u001a\u00020\u001a2\u0006\u0010w\u001a\u00020\u001aH\u0000¢\u0006\u0002\bxR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010K\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0011\u0010P\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0011\u0010X\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bX\u0010LR$\u0010Y\u001a\u00020%2\u0006\u00107\u001a\u00020%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010R\"\u0004\b[\u0010\\R\u0011\u0010c\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\bc\u0010LR\u0014\u0010l\u001a\u00020%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bm\u0010RR\u000e\u0010n\u001a\u00020oX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPenSettingUI;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mColorControl", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl;", "mColorLogCollector", "Lcom/samsung/android/sdk/pen/setting/SpenColorLogCollector;", "mEyedropperViewListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$SettingViewListener;", "mColorPickerViewListener", "mColorSettingViewListener", "mEyedropperActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$EyedropperActionListener;", "mPaletteChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$PaletteChangedListener;", "mPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteActionListener;", "mRecentColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenRecentColorChangedListener;", "mPickerModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$ColorPickerModeChangedListener;", "mSelfClose", "", "close", "", "initColorControl", "canvasLayout", "Landroid/view/ViewGroup;", "colorLayout", "Landroid/view/View;", "isSupportEyedropper", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "colorSettingInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;", "setEyedropperEnabled", "enabled", "setOnColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnColorChangeListener;", "setOnColorChangedListener$SDK_fullRelease", "setColorLogListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorSAListener;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setSelfClose", "enable", "setCanvasBackgroundColor", "color", "", "setPalette", "", "setCurrentPalette", "paletteID", "setPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "setPaletteChangedListener", "setPaletteActionListener", "addRecentColor", "hsvColor", "setRecentColor", "setRecentColorChangedListener", "setEyedropperVisibilityChangedListener", "setColorPickerVisibilityChangeListener", "setColorSettingVisibilityChangeListener", "getColorPickerColor", "setColorPickerColor", "showColorPickerPopup", "isColorPickerPopupVisible", "()Z", "closeColorPickerPopup", "setColorPickerViewMode", "viewMode", "colorPickerViewMode", "getColorPickerViewMode", "()I", "setColorPickerViewModeChangedListener", "setColorPickerCloseButtonType", "closeButtonType", "showEyedropper", "hideEyedropper", "isEyedropperVisible", "eyedropperColor", "getEyedropperColor", "setEyedropperColor", "(I)V", "setEyedropperPosition", "x", "y", "setEyedropperActionListener", "showColorSettingPopup", "closeColorSettingPopup", "isColorSettingPopupVisible", "getColorSettingSelectList", "selectList", "setColorSettingSelectList", "setColorSettingSelectItemEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "actionButtonCount", "getActionButtonCount", "mSubViewStateChangeListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnSubViewStateChangeListener;", "checkVisibilityChangedBefore", "which", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$SubView;", "isNextVisible", "checkVisibilityChangedBefore$SDK_fullRelease", "checkVisibilityChangedAfter", "isVisible", "isCloseByDone", "checkVisibilityChangedAfter$SDK_fullRelease", "mColorViewInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnViewInfoChangedListener;", "mPalettePageActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnPaletteActionListener;", "Companion", "SettingViewListener", "EyedropperActionListener", "PaletteChangedListener", "ColorPickerModeChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public class SpenColorControlPopupLayout extends SpenPopupLayout implements SpenPenSettingUI {
    public static final int PICKER_CLOSE_BY_ACTION_BUTTON = 0;
    public static final int PICKER_CLOSE_BY_CLOSE_BUTTON = 1;

    @NotNull
    private static final String TAG = "SpenSettingPopupLayout";

    @Nullable
    private SpenColorControl mColorControl;

    @Nullable
    private SpenColorLogCollector mColorLogCollector;

    @Nullable
    private SettingViewListener mColorPickerViewListener;

    @Nullable
    private SettingViewListener mColorSettingViewListener;

    @NotNull
    private final SpenColorControl.OnViewInfoChangedListener mColorViewInfoChangedListener;

    @Nullable
    private EyedropperActionListener mEyedropperActionListener;

    @Nullable
    private SettingViewListener mEyedropperViewListener;

    @Nullable
    private SpenPaletteActionListener mPaletteActionListener;

    @Nullable
    private PaletteChangedListener mPaletteChangedListener;

    @NotNull
    private final SpenColorControl.OnPaletteActionListener mPalettePageActionListener;

    @Nullable
    private ColorPickerModeChangedListener mPickerModeChangedListener;

    @Nullable
    private SpenRecentColorChangedListener mRecentColorChangedListener;
    private boolean mSelfClose;

    @NotNull
    private final SpenColorControl.OnSubViewStateChangeListener mSubViewStateChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$ColorPickerModeChangedListener;", "", "onViewModeChanged", "", "pickerMode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ColorPickerModeChangedListener {
        void onViewModeChanged(int pickerMode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$EyedropperActionListener;", "", "onCloseClicked", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface EyedropperActionListener {
        void onCloseClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$PaletteChangedListener;", "", "onPaletteChanged", "", XmlErrorCodes.LIST, "", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface PaletteChangedListener {
        void onPaletteChanged(@Nullable List<Integer> list);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout$SettingViewListener;", "", "onVisibilityChanged", "", "visibility", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SettingViewListener {
        void onVisibilityChanged(int visibility);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenColorControl.SubView.values().length];
            try {
                iArr[SpenColorControl.SubView.EYEDROPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenColorControl.SubView.PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpenColorControl.SubView.SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorControlPopupLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSelfClose = true;
        this.mSubViewStateChangeListener = new SpenColorControl.OnSubViewStateChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout$mSubViewStateChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnSubViewStateChangeListener
            public void onVisibilityChangeBefore(SpenColorControl.SubView which, boolean isNextVisible) {
                this.this$0.checkVisibilityChangedBefore$SDK_fullRelease(which, isNextVisible);
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnSubViewStateChangeListener
            public void onVisibilityChanged(SpenColorControl.SubView which, boolean isVisible, boolean isCloseByDone) {
                this.this$0.checkVisibilityChangedAfter$SDK_fullRelease(which, isVisible, isCloseByDone);
            }
        };
        this.mColorViewInfoChangedListener = new SpenColorControl.OnViewInfoChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout$mColorViewInfoChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnViewInfoChangedListener
            public void onPaletteChanged(List<Integer> list) {
                Log.i("SpenSettingPopupLayout", "onPaletteChanged() list size=" + (list != null ? Integer.valueOf(list.size()) : null) + " PaletteChangedListener has " + (this.this$0.mPaletteChangedListener != null ? "YES" : "NO"));
                SpenColorControlPopupLayout.PaletteChangedListener paletteChangedListener = this.this$0.mPaletteChangedListener;
                if (paletteChangedListener != null) {
                    paletteChangedListener.onPaletteChanged(list);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.OnViewInfoChangedListener
            public void onRecentColorChanged(List<SpenHSVColor> list) {
                Log.i("SpenSettingPopupLayout", "onRecentColorChanged() list size=" + (list != null ? Integer.valueOf(list.size()) : null) + " RecentChangedListener has " + (this.this$0.mRecentColorChangedListener != null ? "YES" : "NO"));
                SpenRecentColorChangedListener spenRecentColorChangedListener = this.this$0.mRecentColorChangedListener;
                if (spenRecentColorChangedListener != null) {
                    spenRecentColorChangedListener.onRecentColorChanged(list);
                }
            }
        };
        this.mPalettePageActionListener = new SpenColorControl.OnPaletteActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout$mPalettePageActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl.OnPaletteActionListener
            public void onPalettePageChanged(int direction, int paletteID) {
                SpenPaletteActionListener spenPaletteActionListener = this.this$0.mPaletteActionListener;
                if (spenPaletteActionListener != null) {
                    spenPaletteActionListener.onPageChanged(paletteID);
                }
            }
        };
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void addRecentColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        float f = hsvColor[0];
        float f4 = hsvColor[1];
        AbstractC2821a.m2234y(AbstractC0622a.m1176v("addRecentColor() color[", f, SQLKeyword.COMMA, f4, ","), hsvColor[2], "]", TAG);
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.addRecentColor(hsvColor);
        }
    }

    public final void checkVisibilityChangedAfter$SDK_fullRelease(@Nullable SpenColorControl.SubView which, boolean isVisible, boolean isCloseByDone) {
        EyedropperActionListener eyedropperActionListener;
        SettingViewListener settingViewListener;
        StringBuilder sb = new StringBuilder("checkVisibilityChangedAfter() which=");
        sb.append(which);
        sb.append(" isVisibility=");
        sb.append(isVisible);
        sb.append(" isCloseByDone=");
        AbstractC0000a.m27x(sb, isCloseByDone, TAG);
        int i = isVisible ? 0 : 8;
        int i2 = which == null ? -1 : WhenMappings.$EnumSwitchMapping$0[which.ordinal()];
        if (i2 == 1) {
            if (i == 8 && isCloseByDone && (eyedropperActionListener = this.mEyedropperActionListener) != null) {
                eyedropperActionListener.onCloseClicked();
            }
            SettingViewListener settingViewListener2 = this.mEyedropperViewListener;
            if (settingViewListener2 != null) {
                settingViewListener2.onVisibilityChanged(i);
                return;
            }
            return;
        }
        if (i2 != 2) {
            if (i2 == 3 && (settingViewListener = this.mColorSettingViewListener) != null) {
                settingViewListener.onVisibilityChanged(i);
                return;
            }
            return;
        }
        SettingViewListener settingViewListener3 = this.mColorPickerViewListener;
        if (settingViewListener3 != null) {
            settingViewListener3.onVisibilityChanged(i);
        }
    }

    public final void checkVisibilityChangedBefore$SDK_fullRelease(@Nullable SpenColorControl.SubView which, boolean isNextVisible) {
        Log.i(TAG, "checkVisibilityChangedBefore() which=" + which + " nextVisible=" + isNextVisible);
        if (this.mSelfClose) {
            int i = which == null ? -1 : WhenMappings.$EnumSwitchMapping$0[which.ordinal()];
            if (i == 1) {
                if (isNextVisible) {
                    hideAnimation(null);
                }
            } else if (i == 2 && getActionButtonCount() == 0 && !isNextVisible) {
                setVisibility(8, false);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void close() {
        super.close();
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl == null) {
            return;
        }
        if (spenColorControl != null) {
            spenColorControl.close();
        }
        this.mColorControl = null;
        this.mEyedropperViewListener = null;
        this.mColorPickerViewListener = null;
        this.mColorSettingViewListener = null;
        this.mEyedropperActionListener = null;
        this.mPaletteActionListener = null;
        this.mPaletteChangedListener = null;
        this.mRecentColorChangedListener = null;
        this.mPickerModeChangedListener = null;
        this.mColorLogCollector = null;
    }

    public final void closeColorPickerPopup() {
        SpenColorControl spenColorControl;
        if (!isColorPickerPopupVisible() || (spenColorControl = this.mColorControl) == null) {
            return;
        }
        spenColorControl.hide();
    }

    public final void closeColorSettingPopup() {
        SpenColorControl spenColorControl;
        if (!isColorSettingPopupVisible() || (spenColorControl = this.mColorControl) == null) {
            return;
        }
        spenColorControl.hide();
    }

    public int getActionButtonCount() {
        return 0;
    }

    public final boolean getColorPickerColor(@Nullable float[] hsvColor) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.getColorPickerColor(hsvColor);
        }
        return false;
    }

    public final int getColorPickerViewMode() {
        Log.i(TAG, "getColorPickerViewMode()");
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.getMColorPickerViewMode();
        }
        return -1;
    }

    public final boolean getColorSettingSelectList(@Nullable List<Integer> selectList) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.getColorSettingSelectList(selectList);
        }
        return false;
    }

    public final int getEyedropperColor() {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.getEyedropperColor();
        }
        return -16777216;
    }

    public final void hideEyedropper() {
        SpenColorControl spenColorControl;
        Log.i(TAG, "hideEyedropper()");
        if (!isEyedropperVisible() || (spenColorControl = this.mColorControl) == null) {
            return;
        }
        spenColorControl.hide();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initColorControl(@NotNull Context context, @Nullable ViewGroup canvasLayout, @Nullable View colorLayout, boolean isSupportEyedropper, @Nullable List<Integer> paletteList, @Nullable List<SpenHSVColor> recentList, @NotNull SpenColorSettingInfo colorSettingInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorSettingInfo, "colorSettingInfo");
        SpenColorControl spenColorControl = new SpenColorControl(context);
        this.mColorControl = spenColorControl;
        spenColorControl.setColorInformation(canvasLayout, (SpenPaletteSetting) colorLayout, colorSettingInfo, paletteList, isSupportEyedropper);
        spenColorControl.setRecentColor(recentList);
        spenColorControl.setOnSubViewStateChangeListener(this.mSubViewStateChangeListener);
        spenColorControl.setViewInfoChangedListener(this.mColorViewInfoChangedListener);
        spenColorControl.setOnPaletteChangedListener(this.mPalettePageActionListener);
        spenColorControl.setColorPickerModeChangedListener(new SpenColorControl.ColorPickerModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout$initColorControl$1$1
            @Override // com.samsung.android.sdk.pen.setting.SpenColorControl.ColorPickerModeChangedListener
            public void onViewModeChanged(int pickerMode) {
                SpenColorControlPopupLayout.ColorPickerModeChangedListener colorPickerModeChangedListener = this.this$0.mPickerModeChangedListener;
                if (colorPickerModeChangedListener != null) {
                    colorPickerModeChangedListener.onViewModeChanged(pickerMode);
                }
            }
        });
    }

    public final boolean isColorPickerPopupVisible() {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.isVisible(SpenColorControl.SubView.PICKER);
        }
        return false;
    }

    public final boolean isColorSettingPopupVisible() {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.isVisible(SpenColorControl.SubView.SETTING);
        }
        return false;
    }

    public final boolean isEyedropperVisible() {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.isVisible(SpenColorControl.SubView.EYEDROPPER);
        }
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        AbstractC2322a.m1631u(newConfig.orientation, "onConfigurationChanged() + newConfig.orientation=", TAG);
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.onConfigurationChanged(newConfig.orientation);
        }
    }

    public final void setCanvasBackgroundColor(@Nullable float[] color) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            Intrinsics.checkNotNull(color);
            spenColorControl.setCanvasBackgroundColor(color);
        }
    }

    public final void setColorLogListener(@Nullable SpenColorSAListener listener) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            SpenColorLogCollector spenColorLogCollector = new SpenColorLogCollector();
            this.mColorLogCollector = spenColorLogCollector;
            spenColorLogCollector.setColorLogListener(listener);
            spenColorControl.setOnActionListener(this.mColorLogCollector);
        }
    }

    public final void setColorPickerCloseButtonType(int closeButtonType) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setColorPickerCloseButtonType(closeButtonType);
        }
    }

    public final void setColorPickerColor(@Nullable float[] hsvColor) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setColorPickerColor(hsvColor);
        }
    }

    public final boolean setColorPickerViewMode(int viewMode) {
        AbstractC2322a.m1631u(viewMode, "setColorPickerViewMode() viewMode=", TAG);
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl == null) {
            return false;
        }
        if (spenColorControl == null) {
            return true;
        }
        spenColorControl.setColorPickerViewMode(viewMode);
        return true;
    }

    public final void setColorPickerViewModeChangedListener(@Nullable ColorPickerModeChangedListener listener) {
        this.mPickerModeChangedListener = listener;
    }

    public final void setColorPickerVisibilityChangeListener(@Nullable SettingViewListener listener) {
        this.mColorPickerViewListener = listener;
    }

    public final void setColorSettingSelectItemEventListener(@Nullable OnSelectItemEventListener listener) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setColorSettingSelectItemEventListener(listener);
        }
    }

    public final boolean setColorSettingSelectList(@Nullable List<Integer> selectList) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            return spenColorControl.setColorSettingSelectList(selectList);
        }
        return false;
    }

    public final void setColorSettingVisibilityChangeListener(@Nullable SettingViewListener listener) {
        this.mColorSettingViewListener = listener;
    }

    public void setColorTheme(int theme) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setColorTheme(theme);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setCurrentPalette(int paletteID) {
        AbstractC2322a.m1631u(paletteID, "setCurrentPalette() paletteID=", TAG);
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setCurrentPalette(paletteID);
        }
    }

    public final void setEyedropperActionListener(@Nullable EyedropperActionListener listener) {
        this.mEyedropperActionListener = listener;
    }

    public final void setEyedropperColor(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%X (%d)", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        Log.i(TAG, "setEyedropperColor() color=".concat(str));
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setEyedropperColor(i);
        }
    }

    public void setEyedropperEnabled(boolean enabled) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setEyedropperEnabled(enabled);
        }
    }

    public final void setEyedropperPosition(int x, int y2) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setEyedropperPosition(x, y2);
        }
    }

    public final void setEyedropperVisibilityChangedListener(@Nullable SettingViewListener listener) {
        this.mEyedropperViewListener = listener;
    }

    public final void setOnColorChangedListener$SDK_fullRelease(@Nullable SpenColorControl.OnColorChangeListener listener) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setOnColorChangeListener(listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPalette(@Nullable List<Integer> paletteList) {
        Log.i(TAG, "setPalette()");
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setPaletteList(paletteList);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setOnPaletteActionButtonListener(listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionListener(@Nullable SpenPaletteActionListener listener) {
        this.mPaletteActionListener = listener;
    }

    public final void setPaletteChangedListener(@Nullable PaletteChangedListener listener) {
        this.mPaletteChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        Log.i(TAG, "setRecentColor() recentList=" + (recentList != null ? Integer.valueOf(recentList.size()) : "NULL"));
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.setRecentColor(recentList);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColorChangedListener(@Nullable SpenRecentColorChangedListener listener) {
        this.mRecentColorChangedListener = listener;
    }

    public final void setSelfClose(boolean enable) {
        this.mSelfClose = enable;
    }

    public final void showColorPickerPopup(@Nullable float[] hsvColor) {
        SpenColorControl spenColorControl;
        if (hsvColor == null || (spenColorControl = this.mColorControl) == null) {
            return;
        }
        spenColorControl.showColorPicker(hsvColor);
    }

    public final void showColorSettingPopup() {
        SpenColorControl spenColorControl = this.mColorControl;
        if (spenColorControl != null) {
            spenColorControl.showColorSetting();
        }
    }

    public final void showEyedropper(@Nullable float[] hsvColor) {
        SpenColorControl spenColorControl;
        Log.i(TAG, "showEyedropper()");
        if (hsvColor == null || (spenColorControl = this.mColorControl) == null) {
            return;
        }
        spenColorControl.showEyedropper(hsvColor, false, false);
    }
}
