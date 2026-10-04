package com.samsung.android.sdk.pen.setting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenColorControl;
import com.samsung.android.sdk.pen.setting.SpenPaletteColorControl;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteSetting;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup;
import com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout;
import com.samsung.android.sdk.pen.setting.pencommon.SpenColorSettingInfo;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u008a\u0001\b\u0000\u0018\u0000 \u0091\u00012\u00020\u0001:\u0010\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u001bH\u0016J:\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010\u00072\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020+2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001072\u0006\u00108\u001a\u00020\u001eJ\u000e\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020$J\u000e\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020\u001eJ\u0010\u0010=\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010\u0011J\u0010\u0010?\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010\u0013J\u0010\u0010@\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010\u0015J\u0010\u0010A\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010\u0019J\u000e\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020\tJ\u0016\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u001eJ\u001e\u0010G\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020$2\u0006\u0010H\u001a\u00020\u001e2\u0006\u0010F\u001a\u00020\u001eJ\u000e\u0010I\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020$J\u0006\u0010J\u001a\u00020\u001eJ\u0016\u0010K\u001a\u00020\u001e2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"J\u0016\u0010M\u001a\u00020\u001e2\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"J\u0016\u0010N\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u001eJ\u0016\u0010O\u001a\u00020.2\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001bJ\u0010\u0010R\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001bH\u0016J\u000e\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020\u001bJ\u0006\u0010N\u001a\u00020.J\u0010\u0010X\u001a\u00020\u001e2\b\u0010Y\u001a\u0004\u0018\u00010$J\u0010\u0010Z\u001a\u00020.2\b\u0010Y\u001a\u0004\u0018\u00010$J\u0010\u0010`\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010'J\u0012\u0010a\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010bH\u0016J\b\u0010c\u001a\u00020\u001eH\u0002J\u0010\u0010d\u001a\u00020.2\u0006\u0010e\u001a\u00020\u001bH\u0016J\u0018\u0010f\u001a\u00020.2\u0006\u0010g\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020$H\u0016J \u0010h\u001a\u00020.2\u0006\u0010i\u001a\u00020\u001b2\u0006\u0010j\u001a\u00020\u001b2\u0006\u0010k\u001a\u00020\u001eH\u0016J\u0016\u0010l\u001a\u00020\u001e2\f\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001b07H\u0002J\u0018\u0010n\u001a\u00020.2\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u000107H\u0016J\u0018\u0010o\u001a\u00020.2\u0006\u0010p\u001a\u00020\u001b2\u0006\u0010q\u001a\u00020\u001bH\u0016J\u0012\u0010r\u001a\u00020.2\b\u0010s\u001a\u0004\u0018\u00010tH\u0002J\u001e\u0010n\u001a\u00020.2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b072\u0006\u0010u\u001a\u00020\u001eH\u0002J\u0010\u0010v\u001a\u00020.2\u0006\u0010:\u001a\u00020$H\u0002J\u0018\u0010v\u001a\u00020.2\u0006\u0010w\u001a\u00020$2\u0006\u0010x\u001a\u00020$H\u0002J\u0010\u0010~\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u001eH\u0002J\b\u0010\u007f\u001a\u00020.H\u0002J\u0018\u0010~\u001a\u00020.2\u0006\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020\u001bH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020.2\u0006\u0010F\u001a\u00020\u001eH\u0002J\u000f\u0010\u0083\u0001\u001a\u00020.2\u0006\u0010e\u001a\u00020\u001bJ\t\u0010\u0086\u0001\u001a\u00020.H\u0002J\t\u0010\u008c\u0001\u001a\u00020.H\u0002J\u0011\u0010\u0090\u0001\u001a\u00020.2\b\u0010>\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010S\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\bT\u0010UR$\u0010\\\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u0010U\"\u0004\b^\u0010_R\u000e\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0099\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mCanvasLayout", "Landroid/view/ViewGroup;", "mCurrent", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$SubView;", "mColorSpoid", "Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout;", "mColorPickerPopup", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup;", "mColorSettingPopup", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup;", "mViewStateChangeListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnSubViewStateChangeListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnActionListener;", "mColorChangeListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnColorChangeListener;", "mViewInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnViewInfoChangedListener;", "mColorSettingSelectItemEventListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener;", "mOrientation", "", "mColorTheme", "mIsAllowedSubView", "", "mIsShowColorSpoid", "mIsPopupCloseByDone", "mPaletteIDs", "", "mColor", "", "mColorPickerViewMode", "mPickerModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$ColorPickerModeChangedListener;", "mIsPickerSupportEyedropper", "mColorPickerCloseButtonType", "mColorSettingInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;", "mCanvasBackgroundColor", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setColorInformation", "canvasLayout", "colorLayout", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteSetting;", "colorSettingInfo", "paletteList", "", "isPickerSupportEyedropper", "setCanvasBackgroundColor", "color", "setEyedropperEnabled", "enabled", "setOnSubViewStateChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnActionListener", "setOnColorChangeListener", "setColorSettingSelectItemEventListener", "isVisible", "which", "setMode", "mode", "needAnimation", "showEyedropper", "isRebuild", "showColorPicker", "showColorSetting", "getColorSettingSelectList", "selectList", "setColorSettingSelectList", "hide", "setEyedropperPosition", "x", "y", "setEyedropperColor", "eyedropperColor", "getEyedropperColor", "()I", "onConfigurationChanged", "orientation", "getColorPickerColor", "hsvColor", "setColorPickerColor", "viewMode", "colorPickerViewMode", "getColorPickerViewMode", "setColorPickerViewMode", "(I)V", "setColorPickerModeChangedListener", "setOnPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "isNotSupportSubView", "onButtonClick", "type", "onColorChanged", "info", "onColorSelected", "pageIndex", "colorIndex", "isSelected", "initPaletteList", XmlErrorCodes.LIST, "setPaletteList", "onPaletteSwipe", "direction", "id", "closeDialog", "dialog", "Landroid/app/Dialog;", "needUpdate", "copyColor", "src", "dest", "mPopupDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mSpoidInitComplete", "mShowSpoidAfterInit", "mCloseSpoidByUser", "initColorSpoid", "initDefaultColorSpoid", "mColorSpoidActionListener", "Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout$ActionListener;", "hideColorSpoid", "setColorPickerCloseButtonType", "mColorPickerChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerChangedListener;", "closeColorPicker", "mColorPickerEyedropperButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$PickerEyedropperButtonListener;", "mColorSettingPopupEventListener", "com/samsung/android/sdk/pen/setting/SpenColorControl$mColorSettingPopupEventListener$1", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$mColorSettingPopupEventListener$1;", "closeColorSetting", "mSettingPopupActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorSettingPopup$OnActionListener;", "mSettingPopupSelectItemEventListener", "setViewInfoChangedListener", "Companion", "SubView", "OnColorChangeListener", "OnPaletteActionListener", "OnSubViewStateChangeListener", "OnActionListener", "ColorPickerModeChangedListener", "OnViewInfoChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorControl extends SpenPaletteColorControl {
    private static final int COLOR_SIZE = 3;
    public static final int PICKER_WITH_ACTION_BUTTON = 0;
    public static final int PICKER_WITH_CLOSE_BUTTON = 1;

    @NotNull
    private static final String TAG = "SpenColorControl";

    @Nullable
    private OnActionListener mActionListener;

    @NotNull
    private final float[] mCanvasBackgroundColor;

    @Nullable
    private ViewGroup mCanvasLayout;
    private boolean mCloseSpoidByUser;

    @NotNull
    private final float[] mColor;

    @Nullable
    private OnColorChangeListener mColorChangeListener;

    @NotNull
    private final SpenColorPickerPopup.ColorPickerChangedListener mColorPickerChangedListener;
    private int mColorPickerCloseButtonType;

    @NotNull
    private final SpenColorPickerPopup.PickerEyedropperButtonListener mColorPickerEyedropperButtonListener;

    @Nullable
    private SpenColorPickerPopup mColorPickerPopup;
    private int mColorPickerViewMode;

    @Nullable
    private SpenColorSettingInfo mColorSettingInfo;

    @Nullable
    private SpenColorSettingPopup mColorSettingPopup;

    @NotNull
    private final SpenColorControl$mColorSettingPopupEventListener$1 mColorSettingPopupEventListener;

    @Nullable
    private OnSelectItemEventListener mColorSettingSelectItemEventListener;

    @Nullable
    private SpenColorSpoidLayout mColorSpoid;

    @NotNull
    private final SpenColorSpoidLayout.ActionListener mColorSpoidActionListener;
    private int mColorTheme;

    @NotNull
    private Context mContext;

    @NotNull
    private SubView mCurrent;
    private boolean mIsAllowedSubView;
    private boolean mIsPickerSupportEyedropper;
    private boolean mIsPopupCloseByDone;
    private boolean mIsShowColorSpoid;
    private int mOrientation;

    @NotNull
    private List<Integer> mPaletteIDs;

    @Nullable
    private ColorPickerModeChangedListener mPickerModeChangedListener;

    @NotNull
    private final DialogInterface.OnDismissListener mPopupDismissListener;

    @NotNull
    private final SpenColorSettingPopup.OnActionListener mSettingPopupActionListener;

    @NotNull
    private final OnSelectItemEventListener mSettingPopupSelectItemEventListener;
    private boolean mShowSpoidAfterInit;
    private boolean mSpoidInitComplete;

    @Nullable
    private OnViewInfoChangedListener mViewInfoChangedListener;

    @Nullable
    private OnSubViewStateChangeListener mViewStateChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$ColorPickerModeChangedListener;", "", "onViewModeChanged", "", "pickerMode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ColorPickerModeChangedListener {
        void onViewModeChanged(int pickerMode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnActionListener;", "Lcom/samsung/android/sdk/pen/setting/colorspoid/SpenColorSpoidLayout$ActionListener;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenColorPickerPopup$ColorPickerListener;", "onColorSettingDone", "", "selection", "", "onColorSettingCancel", "onPaletteSwipe", "direction", "onColorPickerSelected", "onColorSettingSelected", "onEyedropperSelected", "onColorSelected", "pageIndex", "childAt", "color", "onColorPickerClose", "byDone", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener extends SpenColorSpoidLayout.ActionListener, SpenColorPickerPopup.ColorPickerListener {
        void onColorPickerClose(boolean byDone);

        void onColorPickerSelected();

        void onColorSelected(int pageIndex, int childAt, int color);

        void onColorSettingCancel();

        void onColorSettingDone(int selection);

        void onColorSettingSelected();

        void onEyedropperSelected();

        void onPaletteSwipe(int direction);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnColorChangeListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnColorChangeListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnColorChangeListener extends SpenPaletteColorControl.OnColorChangeListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnPaletteActionListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteColorControl$OnPaletteActionListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPaletteActionListener extends SpenPaletteColorControl.OnPaletteActionListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnSubViewStateChangeListener;", "", "onVisibilityChangeBefore", "", "which", "Lcom/samsung/android/sdk/pen/setting/SpenColorControl$SubView;", "isNextVisible", "", "onVisibilityChanged", "isVisible", "isCloseByDone", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSubViewStateChangeListener {
        void onVisibilityChangeBefore(@Nullable SubView which, boolean isNextVisible);

        void onVisibilityChanged(@Nullable SubView which, boolean isVisible, boolean isCloseByDone);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$OnViewInfoChangedListener;", "", "onPaletteChanged", "", XmlErrorCodes.LIST, "", "", "onRecentColorChanged", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnViewInfoChangedListener {
        void onPaletteChanged(@Nullable List<Integer> list);

        void onRecentColorChanged(@Nullable List<SpenHSVColor> list);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenColorControl$SubView;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "PICKER", "EYEDROPPER", "SETTING", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SubView {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SubView[] $VALUES;
        public static final SubView NONE = new SubView(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final SubView PICKER = new SubView("PICKER", 1);
        public static final SubView EYEDROPPER = new SubView("EYEDROPPER", 2);
        public static final SubView SETTING = new SubView("SETTING", 3);

        private static final /* synthetic */ SubView[] $values() {
            return new SubView[]{NONE, PICKER, EYEDROPPER, SETTING};
        }

        static {
            SubView[] subViewArr$values = $values();
            $VALUES = subViewArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(subViewArr$values);
        }

        private SubView(String str, int i) {
        }

        @NotNull
        public static EnumEntries<SubView> getEntries() {
            return $ENTRIES;
        }

        public static SubView valueOf(String str) {
            return (SubView) Enum.valueOf(SubView.class, str);
        }

        public static SubView[] values() {
            return (SubView[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubView.values().length];
            try {
                iArr[SubView.EYEDROPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubView.PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SubView.SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.samsung.android.sdk.pen.setting.SpenColorControl$mColorSettingPopupEventListener$1] */
    public SpenColorControl(@NotNull Context mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mCurrent = SubView.NONE;
        this.mIsAllowedSubView = true;
        this.mPaletteIDs = new ArrayList();
        this.mColor = new float[]{0.0f, 0.0f, 0.0f};
        this.mColorPickerCloseButtonType = -1;
        this.mCanvasBackgroundColor = new float[]{0.0f, 0.0f, 0.99f};
        this.mPopupDismissListener = new DialogInterfaceOnDismissListenerC0177d(this, 1);
        this.mColorSpoidActionListener = new SpenColorSpoidLayout.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$mColorSpoidActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
            public void onHandlerTapped() {
                SpenColorControl.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onHandlerTapped();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorspoid.SpenColorSpoidLayout.ActionListener
            public void onSpoidClosed() {
                this.this$0.mCloseSpoidByUser = true;
                this.this$0.setMode(SpenColorControl.SubView.NONE, true);
                SpenColorControl.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onSpoidClosed();
                }
            }
        };
        this.mColorPickerChangedListener = new SpenColorPickerPopup.ColorPickerChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$mColorPickerChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerChangedListener, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
            public void onColorChanged(int color, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                float f = hsvColor[0];
                float f4 = hsvColor[1];
                AbstractC2821a.m2206A(AbstractC0622a.m1176v("ColorPicker onColorChanged() color=", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA), "SpenColorControl", hsvColor[2]);
                this.this$0.setPickerColor(hsvColor);
                if (this.this$0.mColorPickerCloseButtonType == 1) {
                    return;
                }
                this.this$0.mIsPopupCloseByDone = true;
                SpenColorControl.OnSubViewStateChangeListener onSubViewStateChangeListener = this.this$0.mViewStateChangeListener;
                if (onSubViewStateChangeListener != null) {
                    onSubViewStateChangeListener.onVisibilityChangeBefore(SpenColorControl.SubView.PICKER, false);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.ColorPickerChangedListener, com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerViewModeChangedListener
            public void onViewModeChanged(int viewMode) {
                AbstractC2322a.m1631u(viewMode, "ColorPicker onModeChanged() mode=", "SpenColorControl");
                this.this$0.mColorPickerViewMode = viewMode;
                SpenColorControl.ColorPickerModeChangedListener colorPickerModeChangedListener = this.this$0.mPickerModeChangedListener;
                if (colorPickerModeChangedListener != null) {
                    colorPickerModeChangedListener.onViewModeChanged(viewMode);
                }
            }
        };
        this.mColorPickerEyedropperButtonListener = new SpenColorPickerPopup.PickerEyedropperButtonListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$mColorPickerEyedropperButtonListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerEyedropperListener
            public void onEyedropperButtonClicked() {
                Log.i("SpenColorControl", "ColorPicker EyedropperButton Clicked.");
                this.this$0.mIsPopupCloseByDone = false;
                SpenColorControl.OnSubViewStateChangeListener onSubViewStateChangeListener = this.this$0.mViewStateChangeListener;
                if (onSubViewStateChangeListener != null) {
                    onSubViewStateChangeListener.onVisibilityChangeBefore(SpenColorControl.SubView.PICKER, false);
                }
                this.this$0.hide(SpenColorControl.SubView.PICKER, false);
                this.this$0.onButtonClick(2);
            }
        };
        this.mColorSettingPopupEventListener = new SpenColorSettingPopup.IEventListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$mColorSettingPopupEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup.IEventListener
            public void onChangeSelected(List<Integer> list) {
                if (list != null) {
                    if (list.size() == this.this$0.mPaletteIDs.size() && this.this$0.mPaletteIDs.containsAll(list)) {
                        return;
                    }
                    this.this$0.mPaletteIDs.clear();
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        this.this$0.mPaletteIDs.add(Integer.valueOf(it.next().intValue()));
                    }
                    SpenColorControl spenColorControl = this.this$0;
                    spenColorControl.setPaletteList(spenColorControl.mPaletteIDs, true);
                }
            }
        };
        this.mSettingPopupActionListener = new SpenColorSettingPopup.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$mSettingPopupActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup.OnActionListener
            public void OnDone(int count) {
                this.this$0.mIsPopupCloseByDone = true;
                SpenColorControl.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onColorSettingDone(count);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup.OnActionListener
            public void onCancel() {
                SpenColorControl.OnActionListener onActionListener = this.this$0.mActionListener;
                if (onActionListener != null) {
                    onActionListener.onColorSettingCancel();
                }
            }
        };
        this.mSettingPopupSelectItemEventListener = new OnSelectItemEventListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$mSettingPopupSelectItemEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemChanged(int position, boolean selected) {
                OnSelectItemEventListener onSelectItemEventListener = this.this$0.mColorSettingSelectItemEventListener;
                if (onSelectItemEventListener != null) {
                    onSelectItemEventListener.onSelectItemChanged(position, selected);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnSelectItemEventListener
            public void onSelectItemUnchanged(int position, OnSelectItemEventListener.UnchangedReason reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                OnSelectItemEventListener onSelectItemEventListener = this.this$0.mColorSettingSelectItemEventListener;
                if (onSelectItemEventListener != null) {
                    onSelectItemEventListener.onSelectItemUnchanged(position, reason);
                    return;
                }
                if (reason != OnSelectItemEventListener.UnchangedReason.MAX_VALUE_LIMIT) {
                    if (reason == OnSelectItemEventListener.UnchangedReason.MIN_VALUE_LIMIT) {
                        Toast.makeText(this.this$0.mContext, this.this$0.mContext.getResources().getString(C7932R.string.pen_string_setting_select_at_least_one), 0).show();
                    }
                } else {
                    SpenColorSettingInfo spenColorSettingInfo = this.this$0.mColorSettingInfo;
                    if (spenColorSettingInfo != null) {
                        SpenColorControl spenColorControl = this.this$0;
                        int mMaxSelectCount = spenColorSettingInfo.getMMaxSelectCount();
                        Toast.makeText(spenColorControl.mContext, spenColorControl.mContext.getResources().getQuantityString(C7932R.plurals.plurals_count_show_colors, mMaxSelectCount, Integer.valueOf(mMaxSelectCount)), 0).show();
                    }
                }
            }
        };
        this.mColorPickerCloseButtonType = 0;
        this.mPaletteIDs = new ArrayList();
        this.mOrientation = -1;
        this.mColorPickerViewMode = 2;
    }

    private final void closeColorPicker() {
        SpenColorPickerPopup spenColorPickerPopup = this.mColorPickerPopup;
        if (spenColorPickerPopup != null && spenColorPickerPopup.isShowing()) {
            spenColorPickerPopup.dismiss();
            OnSubViewStateChangeListener onSubViewStateChangeListener = this.mViewStateChangeListener;
            if (onSubViewStateChangeListener != null) {
                onSubViewStateChangeListener.onVisibilityChanged(SubView.PICKER, false, this.mIsPopupCloseByDone);
            }
        }
        this.mColorPickerPopup = null;
    }

    private final void closeColorSetting() {
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup != null && spenColorSettingPopup.isShowing()) {
            spenColorSettingPopup.dismiss();
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener != null) {
            onSubViewStateChangeListener.onVisibilityChanged(SubView.SETTING, false, this.mIsPopupCloseByDone);
        }
        this.mColorSettingPopup = null;
    }

    private final void closeDialog(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        try {
            dialog.dismiss();
        } catch (Exception unused) {
            Log.e(TAG, "dialog dismiss error.");
        }
    }

    private final void copyColor(float[] color) {
        copyColor(color, this.mColor);
    }

    private final void hideColorSpoid(boolean needAnimation) {
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout == null || spenColorSpoidLayout.getColorSpoidSettingVisible() != 0) {
            return;
        }
        spenColorSpoidLayout.hide(needAnimation);
        this.mIsShowColorSpoid = false;
        float[] fArr = new float[3];
        getColor(fArr);
        float[] fArr2 = this.mColor;
        if (fArr2[0] == fArr[0] && fArr2[1] == fArr[1] && fArr2[2] == fArr[2]) {
            Log.i(TAG, "same color. (Not update)");
        } else {
            setEyedropperColor(SpenSettingUtil.HSVToColor(fArr2));
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener != null) {
            onSubViewStateChangeListener.onVisibilityChanged(SubView.EYEDROPPER, false, this.mCloseSpoidByUser);
            this.mCloseSpoidByUser = false;
        }
    }

    private final boolean initColorSpoid(boolean isRebuild) {
        SpenColorSpoidLayout spenColorSpoidLayout;
        final ViewGroup viewGroup = this.mCanvasLayout;
        if (viewGroup == null) {
            Log.i(TAG, "Token mCanvasLayout is null");
            return false;
        }
        if (!isRebuild || (spenColorSpoidLayout = this.mColorSpoid) == null || !this.mIsShowColorSpoid) {
            if (this.mColorSpoid != null || viewGroup == null) {
                return true;
            }
            if (viewGroup.getWidth() > 0) {
                initDefaultColorSpoid();
                return true;
            }
            this.mSpoidInitComplete = false;
            viewGroup.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl$initColorSpoid$1$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    viewGroup.removeOnLayoutChangeListener(this);
                    this.initDefaultColorSpoid();
                    if (this.mShowSpoidAfterInit) {
                        this.mShowSpoidAfterInit = false;
                        SpenColorControl spenColorControl = this;
                        spenColorControl.showEyedropper(spenColorControl.mColor, false, true);
                    }
                }
            });
            return false;
        }
        Integer numValueOf = spenColorSpoidLayout != null ? Integer.valueOf(spenColorSpoidLayout.getPositionX()) : null;
        SpenColorSpoidLayout spenColorSpoidLayout2 = this.mColorSpoid;
        Integer numValueOf2 = spenColorSpoidLayout2 != null ? Integer.valueOf(spenColorSpoidLayout2.getPositionY()) : null;
        SpenColorSpoidLayout spenColorSpoidLayout3 = this.mColorSpoid;
        if (spenColorSpoidLayout3 != null) {
            spenColorSpoidLayout3.close();
        }
        this.mColorSpoid = null;
        if (numValueOf != null && numValueOf2 != null) {
            initColorSpoid(numValueOf.intValue(), numValueOf2.intValue());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initDefaultColorSpoid() {
        initColorSpoid(this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.color_spoid_default_margin), this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.color_spoid_default_y));
        this.mCloseSpoidByUser = false;
    }

    private final boolean initPaletteList(List<Integer> list) {
        SpenColorSettingInfo spenColorSettingInfo = this.mColorSettingInfo;
        if (spenColorSettingInfo == null) {
            Log.i(TAG, "invalid state.");
            return false;
        }
        Intrinsics.checkNotNull(spenColorSettingInfo);
        int maxSelectCount = spenColorSettingInfo.getMMaxSelectCount();
        this.mPaletteIDs.clear();
        this.mPaletteIDs.addAll(checkValidPaletteList(list, maxSelectCount));
        return !isEqualList(this.mPaletteIDs, list);
    }

    private final boolean isNotSupportSubView() {
        return !this.mIsAllowedSubView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPopupDismissListener$lambda$9(SpenColorControl spenColorControl, DialogInterface dialogInterface) {
        SubView subView;
        OnActionListener onActionListener;
        Log.i(TAG, "++++++++++++++++++++= checked !!! onDismiss");
        if (Intrinsics.areEqual(dialogInterface, spenColorControl.mColorPickerPopup)) {
            spenColorControl.mColorPickerPopup = null;
            subView = SubView.PICKER;
            Log.i(TAG, "CURRENT is picker.");
        } else if (!Intrinsics.areEqual(dialogInterface, spenColorControl.mColorSettingPopup)) {
            Log.i(TAG, "CURRENT is unknown.");
            return;
        } else {
            spenColorControl.mColorSettingPopup = null;
            subView = SubView.SETTING;
            Log.i(TAG, "CURRENT is setting.");
        }
        spenColorControl.mCurrent = SubView.NONE;
        OnSubViewStateChangeListener onSubViewStateChangeListener = spenColorControl.mViewStateChangeListener;
        if (onSubViewStateChangeListener != null) {
            onSubViewStateChangeListener.onVisibilityChanged(subView, false, spenColorControl.mIsPopupCloseByDone);
        }
        if (subView != SubView.PICKER || (onActionListener = spenColorControl.mActionListener) == null) {
            return;
        }
        onActionListener.onColorPickerClose(spenColorControl.mIsPopupCloseByDone);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl
    public void close() {
        Log.i(TAG, "close()");
        this.mPaletteIDs.clear();
        this.mActionListener = null;
        this.mViewStateChangeListener = null;
        this.mPickerModeChangedListener = null;
        this.mColorSettingSelectItemEventListener = null;
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout != null) {
            spenColorSpoidLayout.close();
        }
        this.mColorSpoid = null;
        closeDialog(this.mColorSettingPopup);
        this.mColorSettingPopup = null;
        closeDialog(this.mColorPickerPopup);
        SpenColorPickerPopup spenColorPickerPopup = this.mColorPickerPopup;
        if (spenColorPickerPopup != null) {
            spenColorPickerPopup.close();
        }
        this.mColorPickerPopup = null;
        this.mCurrent = SubView.NONE;
        this.mCanvasLayout = null;
        super.close();
    }

    public final boolean getColorPickerColor(@Nullable float[] hsvColor) {
        SubView subView = this.mCurrent;
        if (subView != SubView.PICKER) {
            Log.i(TAG, "not picker mode. mode=" + subView);
            return false;
        }
        SpenColorPickerPopup spenColorPickerPopup = this.mColorPickerPopup;
        if (spenColorPickerPopup == null) {
            return true;
        }
        spenColorPickerPopup.getCurrentColor(hsvColor);
        return true;
    }

    /* JADX INFO: renamed from: getColorPickerViewMode, reason: from getter */
    public final int getMColorPickerViewMode() {
        return this.mColorPickerViewMode;
    }

    public final boolean getColorSettingSelectList(@Nullable List<Integer> selectList) {
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup != null) {
            return spenColorSettingPopup.getSelectPaletteList(selectList);
        }
        return false;
    }

    public final int getEyedropperColor() {
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout != null) {
            return spenColorSpoidLayout.getColorSpoidCurrentColor();
        }
        Log.i(TAG, "getEyedropperColor() it's not possible case.");
        return -16777216;
    }

    public final boolean hide(@NotNull SubView which, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(which, "which");
        if (this.mCurrent != which) {
            return false;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[which.ordinal()];
        if (i == 1) {
            hideColorSpoid(needAnimation);
            return false;
        }
        if (i == 2) {
            closeColorPicker();
            return false;
        }
        if (i != 3) {
            return false;
        }
        closeColorSetting();
        return false;
    }

    public final boolean isVisible(@NotNull SubView which) {
        Intrinsics.checkNotNullParameter(which, "which");
        return this.mCurrent == which;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl, com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
    public void onButtonClick(int type) {
        super.onButtonClick(type);
        if (isNotSupportSubView()) {
            return;
        }
        float[] fArr = new float[3];
        getColor(fArr);
        if (getOpacity() == 0) {
            AbstractC11014a.m12328m(type, "onButtonClick() which=", " currentColor is Transparent.", TAG);
            copyColor(this.mCanvasBackgroundColor, fArr);
        }
        if (type == 1) {
            Log.i(TAG, " Click BUTTON_TYPE_PICKER");
            showColorPicker(fArr);
            OnActionListener onActionListener = this.mActionListener;
            if (onActionListener != null) {
                onActionListener.onColorPickerSelected();
                return;
            }
            return;
        }
        if (type == 2) {
            Log.i(TAG, " Click BUTTON_TYPE_EYEDROPPER");
            showEyedropper(fArr, false, true);
            OnActionListener onActionListener2 = this.mActionListener;
            if (onActionListener2 != null) {
                onActionListener2.onEyedropperSelected();
                return;
            }
            return;
        }
        if (type != 3) {
            return;
        }
        Log.i(TAG, " Click BUTTON_TYPE_SETTING");
        showColorSetting();
        OnActionListener onActionListener3 = this.mActionListener;
        if (onActionListener3 != null) {
            onActionListener3.onColorSettingSelected();
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl, com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener
    public void onColorChanged(int info, @NotNull float[] hsvColor) {
        SpenColorSpoidLayout spenColorSpoidLayout;
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        super.onColorChanged(info, hsvColor);
        if (isNotSupportSubView() || !isVisible(SubView.EYEDROPPER) || (spenColorSpoidLayout = this.mColorSpoid) == null) {
            return;
        }
        spenColorSpoidLayout.setColorSpoidColor(SpenSettingUtil.HSVToColor(hsvColor));
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl, com.samsung.android.sdk.pen.setting.colorpalette.OnColorButtonListener
    public void onColorSelected(int pageIndex, int colorIndex, boolean isSelected) {
        OnActionListener onActionListener = this.mActionListener;
        if (onActionListener != null) {
            float[] fArr = {0.0f, 0.0f, 0.0f};
            getColor(fArr);
            onActionListener.onColorSelected(pageIndex, colorIndex, SpenSettingUtil.HSVToColor(fArr));
        }
    }

    public final void onConfigurationChanged(int orientation) {
        this.mOrientation = orientation;
        SpenColorPickerPopup spenColorPickerPopup = this.mColorPickerPopup;
        if (spenColorPickerPopup != null && spenColorPickerPopup.isShowing()) {
            spenColorPickerPopup.setOrientationMode(this.mOrientation);
        }
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout != null) {
            spenColorSpoidLayout.setRotation();
        }
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup == null || !spenColorSettingPopup.isShowing()) {
            return;
        }
        spenColorSettingPopup.setOrientation(this.mOrientation);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl, com.samsung.android.sdk.pen.setting.colorpalette.OnPaletteSwipeListener
    public void onPaletteSwipe(int direction, int id) {
        super.onPaletteSwipe(direction, id);
        OnActionListener onActionListener = this.mActionListener;
        if (onActionListener != null) {
            onActionListener.onPaletteSwipe(direction);
        }
    }

    public final void setCanvasBackgroundColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        AbstractC6670b.m4765z(new Object[]{Float.valueOf(color[0]), Float.valueOf(color[1]), Float.valueOf(color[2])}, 3, "setCanvasBackgroundColor() [%f, %f, %f]", "format(format, *args)", TAG);
        copyColor(color, this.mCanvasBackgroundColor);
    }

    public final void setColorInformation(@Nullable ViewGroup canvasLayout, @Nullable SpenPaletteSetting colorLayout, @NotNull SpenColorSettingInfo colorSettingInfo, @Nullable List<Integer> paletteList, boolean isPickerSupportEyedropper) {
        Intrinsics.checkNotNullParameter(colorSettingInfo, "colorSettingInfo");
        SubView subView = this.mCurrent;
        if (subView != SubView.NONE) {
            hide(subView, false);
        }
        this.mColorSettingInfo = new SpenColorSettingInfo(colorSettingInfo.getSwatchList(), colorSettingInfo.getMMaxSelectCount());
        this.mCanvasLayout = canvasLayout;
        this.mIsPickerSupportEyedropper = isPickerSupportEyedropper;
        if (paletteList != null) {
            initPaletteList(paletteList);
        }
        setOnRecentChangeListener(new SpenPaletteColorControl.OnRecentColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl.setColorInformation.1
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl.OnRecentColorChangeListener
            public void onRecentColorChanged(List<SpenHSVColor> list) {
                OnViewInfoChangedListener onViewInfoChangedListener = SpenColorControl.this.mViewInfoChangedListener;
                if (onViewInfoChangedListener != null) {
                    onViewInfoChangedListener.onRecentColorChanged(list);
                }
            }
        });
        setColorInformation(colorLayout, this.mPaletteIDs, colorSettingInfo.getMMaxSelectCount());
    }

    public final void setColorPickerCloseButtonType(int type) {
        this.mColorPickerCloseButtonType = type;
    }

    public final void setColorPickerColor(@Nullable float[] hsvColor) {
        SpenColorPickerPopup spenColorPickerPopup;
        if (hsvColor == null || hsvColor.length != 3) {
            return;
        }
        if (isNotSupportSubView()) {
            Log.i(TAG, "setColorPickerColor() : not support subView. so it will be used by palette color");
            setPickerColor(hsvColor);
        } else {
            if (this.mCurrent != SubView.PICKER || (spenColorPickerPopup = this.mColorPickerPopup) == null) {
                return;
            }
            spenColorPickerPopup.setCurrentColor(hsvColor);
        }
    }

    public final void setColorPickerModeChangedListener(@Nullable ColorPickerModeChangedListener listener) {
        if (isNotSupportSubView()) {
            Log.i(TAG, "Not support subView. so ignore this listener. [ColorPickerModeChangedListener]");
        } else {
            this.mPickerModeChangedListener = listener;
        }
    }

    public final void setColorPickerViewMode(int i) {
        SpenColorPickerPopup spenColorPickerPopup;
        if (this.mColorPickerViewMode != i) {
            this.mColorPickerViewMode = i;
            if (!isVisible(SubView.PICKER) || (spenColorPickerPopup = this.mColorPickerPopup) == null) {
                return;
            }
            spenColorPickerPopup.setViewMode(this.mColorPickerViewMode);
        }
    }

    public final void setColorSettingSelectItemEventListener(@Nullable OnSelectItemEventListener listener) {
        if (isNotSupportSubView()) {
            Log.i(TAG, "Not support subView. so ignore this listener. [OnSelectItemEventListener]");
        } else {
            this.mColorSettingSelectItemEventListener = listener;
        }
    }

    public final boolean setColorSettingSelectList(@Nullable List<Integer> selectList) {
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup != null) {
            return spenColorSettingPopup.setSelectPaletteList(selectList);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl
    public void setColorTheme(int theme) {
        super.setColorTheme(theme);
        this.mColorTheme = theme;
        SpenColorSettingPopup spenColorSettingPopup = this.mColorSettingPopup;
        if (spenColorSettingPopup != null) {
            spenColorSettingPopup.setColorTheme(theme);
        }
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout != null) {
            spenColorSpoidLayout.setColorTheme(theme);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl
    public boolean setEyedropperColor(int color) {
        int eyedropperUIInfo;
        if (isNotSupportSubView()) {
            Log.i(TAG, "setEyedropperColor(). not support subView. it will be used by palette color");
            return super.setEyedropperColor(color);
        }
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout == null) {
            return false;
        }
        float[] fArr = new float[3];
        Color.colorToHSV(color, fArr);
        copyColor(fArr);
        spenColorSpoidLayout.setColorSpoidColor(SpenSettingUtil.HSVToColor(fArr));
        OnColorChangeListener onColorChangeListener = this.mColorChangeListener;
        if (onColorChangeListener == null || (eyedropperUIInfo = getEyedropperUIInfo()) == -1) {
            return true;
        }
        onColorChangeListener.onColorChanged(eyedropperUIInfo, this.mColor, false);
        return true;
    }

    public final void setEyedropperEnabled(boolean enabled) {
        AbstractC4539a.m3208r("setEyedropperEnabled() enabled=", TAG, enabled);
        this.mIsPickerSupportEyedropper = enabled;
    }

    public final void setEyedropperPosition(int x, int y2) {
        SpenColorSpoidLayout spenColorSpoidLayout = this.mColorSpoid;
        if (spenColorSpoidLayout != null) {
            spenColorSpoidLayout.movePosition(x, y2);
        }
    }

    public final boolean setMode(@NotNull SubView mode, boolean needAnimation) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        SubView subView = this.mCurrent;
        if (subView == mode) {
            return false;
        }
        hide(subView, needAnimation);
        this.mCurrent = mode;
        return true;
    }

    public final void setOnActionListener(@Nullable OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setOnColorChangeListener(@Nullable OnColorChangeListener listener) {
        super.setOnColorChangeListener((SpenPaletteColorControl.OnColorChangeListener) listener);
        this.mColorChangeListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl
    public void setOnPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        super.setOnPaletteActionButtonListener(listener);
        boolean z = listener == null;
        this.mIsAllowedSubView = z;
        AbstractC4539a.m3208r("setOnPaletteActionButtonListener() mIsAllowedSubView=", TAG, z);
    }

    public final void setOnSubViewStateChangeListener(@Nullable OnSubViewStateChangeListener listener) {
        if (isNotSupportSubView()) {
            Log.i(TAG, "Not support subView. so ignore this listener. [OnSubViewStateChangeListener]");
        } else {
            this.mViewStateChangeListener = listener;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl
    public void setPaletteList(@Nullable List<Integer> paletteList) {
        List<Integer> list = paletteList;
        if (list == null || list.isEmpty() || isEqualList(paletteList, this.mPaletteIDs)) {
            Log.i(TAG, "Null or Same PaletteList.");
        } else {
            initPaletteList(paletteList);
            setPaletteList(this.mPaletteIDs, false);
        }
    }

    public final void setViewInfoChangedListener(@Nullable OnViewInfoChangedListener listener) {
        this.mViewInfoChangedListener = listener;
    }

    public final boolean showColorPicker(@NotNull float[] color) {
        SpenColorPickerPopup spenColorPickerPopup;
        SpenColorPickerPopup spenColorPickerPopup2;
        SpenColorPickerPopup spenColorPickerPopup3;
        Intrinsics.checkNotNullParameter(color, "color");
        if (isNotSupportSubView()) {
            return false;
        }
        SubView subView = SubView.PICKER;
        if (!setMode(subView, false)) {
            Log.i(TAG, "Not Changed mode.");
            return true;
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener != null) {
            onSubViewStateChangeListener.onVisibilityChangeBefore(subView, true);
        }
        copyColor(color);
        this.mIsPopupCloseByDone = false;
        SpenColorPickerPopup spenColorPickerPopup4 = new SpenColorPickerPopup(this.mContext, this.mColorPickerViewMode, this.mColor, this.mIsPickerSupportEyedropper);
        this.mColorPickerPopup = spenColorPickerPopup4;
        spenColorPickerPopup4.setColorTheme(this.mColorTheme);
        spenColorPickerPopup4.setColorPickerChangeListener(this.mColorPickerChangedListener);
        spenColorPickerPopup4.setColorPickerListener(this.mActionListener);
        spenColorPickerPopup4.setOnDismissListener(this.mPopupDismissListener);
        if (this.mColorPickerCloseButtonType == 1 && (spenColorPickerPopup3 = this.mColorPickerPopup) != null) {
            spenColorPickerPopup3.setCloseButton(new SpenColorPickerPopup.OnCloseClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenColorControl.showColorPicker.2
                @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerPopup.OnCloseClickListener
                public void onCloseButtonClick() {
                    OnSubViewStateChangeListener onSubViewStateChangeListener2 = SpenColorControl.this.mViewStateChangeListener;
                    if (onSubViewStateChangeListener2 != null) {
                        onSubViewStateChangeListener2.onVisibilityChangeBefore(SubView.PICKER, false);
                    }
                    SpenColorControl.this.hide();
                }
            });
        }
        int i = this.mOrientation;
        if (i != -1 && (spenColorPickerPopup2 = this.mColorPickerPopup) != null) {
            spenColorPickerPopup2.setOrientationMode(i);
        }
        if (this.mIsPickerSupportEyedropper && (spenColorPickerPopup = this.mColorPickerPopup) != null) {
            spenColorPickerPopup.setColorPickerEyedropperButtonListener(this.mColorPickerEyedropperButtonListener);
        }
        SpenColorPickerPopup spenColorPickerPopup5 = this.mColorPickerPopup;
        if (spenColorPickerPopup5 != null) {
            spenColorPickerPopup5.show();
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener2 = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener2 != null) {
            onSubViewStateChangeListener2.onVisibilityChanged(subView, true, false);
        }
        return false;
    }

    public final boolean showColorSetting() {
        SpenColorSettingPopup spenColorSettingPopup;
        if (isNotSupportSubView()) {
            return false;
        }
        SubView subView = SubView.SETTING;
        if (!setMode(subView, false)) {
            Log.i(TAG, "[Setting] Not Change mode. ");
            return true;
        }
        SpenColorSettingInfo spenColorSettingInfo = this.mColorSettingInfo;
        if (spenColorSettingInfo == null) {
            Log.i(TAG, "[Setting] No Palette information.");
            return false;
        }
        Integer numValueOf = spenColorSettingInfo != null ? Integer.valueOf(spenColorSettingInfo.getMMaxSelectCount()) : null;
        SpenColorSettingInfo spenColorSettingInfo2 = this.mColorSettingInfo;
        List<Integer> swatchList = spenColorSettingInfo2 != null ? spenColorSettingInfo2.getSwatchList() : null;
        if (numValueOf == null || swatchList == null) {
            return false;
        }
        if (numValueOf.intValue() < 1) {
            Log.i(TAG, "[Setting] Wrong Palette information.");
            return false;
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener != null) {
            onSubViewStateChangeListener.onVisibilityChangeBefore(subView, true);
        }
        this.mIsPopupCloseByDone = false;
        SpenColorSettingPopup spenColorSettingPopup2 = new SpenColorSettingPopup(this.mContext, swatchList, numValueOf.intValue());
        this.mColorSettingPopup = spenColorSettingPopup2;
        spenColorSettingPopup2.setSelectPaletteList(this.mPaletteIDs);
        spenColorSettingPopup2.setEventListener(this.mColorSettingPopupEventListener);
        spenColorSettingPopup2.setOnDismissListener(this.mPopupDismissListener);
        spenColorSettingPopup2.setOnActionListener(this.mSettingPopupActionListener);
        spenColorSettingPopup2.setOnSelectItemEventListener(this.mSettingPopupSelectItemEventListener);
        int i = this.mOrientation;
        if (i != -1 && (spenColorSettingPopup = this.mColorSettingPopup) != null) {
            spenColorSettingPopup.setOrientation(i);
        }
        SpenColorSettingPopup spenColorSettingPopup3 = this.mColorSettingPopup;
        if (spenColorSettingPopup3 != null) {
            spenColorSettingPopup3.setColorTheme(this.mColorTheme);
        }
        SpenColorSettingPopup spenColorSettingPopup4 = this.mColorSettingPopup;
        if (spenColorSettingPopup4 != null) {
            spenColorSettingPopup4.show();
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener2 = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener2 != null) {
            onSubViewStateChangeListener2.onVisibilityChanged(subView, true, false);
        }
        return true;
    }

    public final boolean showEyedropper(@NotNull float[] color, boolean isRebuild, boolean needAnimation) {
        SpenColorSpoidLayout spenColorSpoidLayout;
        Intrinsics.checkNotNullParameter(color, "color");
        if (isNotSupportSubView()) {
            return false;
        }
        SubView subView = SubView.EYEDROPPER;
        if (!setMode(subView, false)) {
            Log.i(TAG, "Not Changed mode.");
            return true;
        }
        OnSubViewStateChangeListener onSubViewStateChangeListener = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener != null) {
            onSubViewStateChangeListener.onVisibilityChangeBefore(subView, true);
        }
        copyColor(color);
        if (initColorSpoid(isRebuild) && (spenColorSpoidLayout = this.mColorSpoid) != null) {
            spenColorSpoidLayout.setColorSpoidColor(SpenSettingUtil.HSVToColor(color));
        }
        if (!this.mSpoidInitComplete) {
            this.mShowSpoidAfterInit = true;
            Log.i(TAG, "showColorSpoid() can be shown after init");
            return true;
        }
        SpenColorSpoidLayout spenColorSpoidLayout2 = this.mColorSpoid;
        if (spenColorSpoidLayout2 == null) {
            return false;
        }
        spenColorSpoidLayout2.show(needAnimation);
        this.mIsShowColorSpoid = true;
        OnSubViewStateChangeListener onSubViewStateChangeListener2 = this.mViewStateChangeListener;
        if (onSubViewStateChangeListener2 != null) {
            onSubViewStateChangeListener2.onVisibilityChanged(subView, true, false);
        }
        return true;
    }

    private final void copyColor(float[] src, float[] dest) {
        System.arraycopy(src, 0, dest, 0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPaletteList(List<Integer> paletteList, boolean needUpdate) {
        setPaletteListInner(paletteList, false);
        if (this.mViewInfoChangedListener == null || !needUpdate) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(paletteList);
        OnViewInfoChangedListener onViewInfoChangedListener = this.mViewInfoChangedListener;
        if (onViewInfoChangedListener != null) {
            onViewInfoChangedListener.onPaletteChanged(arrayList);
        }
    }

    public final void hide() {
        Log.i(TAG, "hide()");
        setMode(SubView.NONE, false);
    }

    private final void initColorSpoid(int x, int y2) {
        SpenColorSpoidLayout spenColorSpoidLayout = new SpenColorSpoidLayout(this.mContext, this.mCanvasLayout, x, y2);
        this.mColorSpoid = spenColorSpoidLayout;
        spenColorSpoidLayout.setColorTheme(this.mColorTheme);
        SpenColorSpoidLayout spenColorSpoidLayout2 = this.mColorSpoid;
        if (spenColorSpoidLayout2 != null) {
            spenColorSpoidLayout2.setSpoidListener(this.mColorSpoidActionListener);
        }
        this.mSpoidInitComplete = true;
    }
}
