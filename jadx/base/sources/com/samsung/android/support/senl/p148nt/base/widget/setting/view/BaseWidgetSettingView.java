package com.samsung.android.support.senl.p148nt.base.widget.setting.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout;
import com.samsung.android.sdk.pen.setting.common.C7558c;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.NestedScrollViewCustom;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.widget.setting.common.BaseWidgetSettingConstant;
import com.samsung.android.support.senl.p148nt.base.widget.setting.presenter.BaseWidgetSettingPresenter;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 ±\u00012\u00020\u0001:\u0002±\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010u\u001a\u00020vH\u0016J\b\u0010{\u001a\u00020vH\u0002J\b\u0010|\u001a\u00020vH\u0002J\b\u0010}\u001a\u00020vH\u0002J\b\u0010~\u001a\u00020vH\u0002J\b\u0010\u007f\u001a\u00020vH\u0002J\u0007\u0010\u0080\u0001\u001a\u00020vJ\t\u0010\u0081\u0001\u001a\u00020vH\u0014J\u0012\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001J\u0012\u0010\u0085\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001J\t\u0010\u0086\u0001\u001a\u00020vH\u0002J\u0007\u0010\u0087\u0001\u001a\u00020vJ\u0010\u0010\u0088\u0001\u001a\u00020v2\u0007\u0010\u0089\u0001\u001a\u00020\u0003J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010\u008c\u0001\u001a\u00020v2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00032\b\u0010\u008e\u0001\u001a\u00030\u0083\u0001H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020v2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003J\u0007\u0010\u0091\u0001\u001a\u00020vJ\t\u0010\u0092\u0001\u001a\u00020vH\u0002J\t\u0010\u0093\u0001\u001a\u00020vH\u0002J\u0007\u0010\u0094\u0001\u001a\u00020vJ\u0013\u0010\u0095\u0001\u001a\u00020v2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0014J\u001c\u0010¡\u0001\u001a\u00020v2\u0007\u0010¢\u0001\u001a\u00020\u00032\b\u0010£\u0001\u001a\u00030\u0083\u0001H\u0004J*\u0010¡\u0001\u001a\u00020v2\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010¥\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010¢\u0001\u001a\u0004\u0018\u00010^H\u0004J\u0013\u0010¦\u0001\u001a\u00020v2\b\u0010§\u0001\u001a\u00030\u0097\u0001H\u0016J'\u0010¨\u0001\u001a\u00020v2\b\u0010\u008d\u0001\u001a\u00030©\u00012\b\u0010ª\u0001\u001a\u00030\u0083\u00012\b\u0010«\u0001\u001a\u00030\u0083\u0001H\u0004J\u001b\u0010¬\u0001\u001a\u00020v2\b\u0010\u00ad\u0001\u001a\u00030\u008b\u00012\b\u0010®\u0001\u001a\u00030\u0083\u0001J\u001c\u0010¯\u0001\u001a\u00030\u008b\u00012\b\u0010°\u0001\u001a\u00030\u008b\u00012\b\u0010®\u0001\u001a\u00030\u0083\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\u0005R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0005R\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\u0005R\u001c\u00100\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\u0005R\u001c\u00103\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\u0005R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\u0005R\u001c\u00109\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\u0005R\u001c\u0010<\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R\u001c\u0010?\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\u0005R\u001c\u0010B\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\u0005R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001c\u0010N\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0007\"\u0004\bP\u0010\u0005R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\u0005R\u001c\u0010T\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\u0005R\u001c\u0010W\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0007\"\u0004\bY\u0010\u0005R\u001c\u0010Z\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0007\"\u0004\b\\\u0010\u0005R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0007\"\u0004\bk\u0010\u0005R\u001c\u0010l\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0007\"\u0004\bn\u0010\u0005R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0012\u0010w\u001a\u00020xX¦\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u0018\u0010\u0098\u0001\u001a\u00030\u0083\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u0097\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u0097\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009c\u0001R\u0015\u0010\u009e\u0001\u001a\u00030\u0097\u00018F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009c\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u0083\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u009a\u0001¨\u0006²\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingView;", "Lcom/samsung/android/support/senl/nt/base/widget/setting/view/BaseWidgetSettingContract;", "mParent", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getMParent", "()Landroid/view/View;", "setMParent", "mSeekBar", "Landroidx/appcompat/widget/SeslSeekBar;", "getMSeekBar", "()Landroidx/appcompat/widget/SeslSeekBar;", "setMSeekBar", "(Landroidx/appcompat/widget/SeslSeekBar;)V", "mOpacityText", "Landroid/widget/TextView;", "getMOpacityText", "()Landroid/widget/TextView;", "setMOpacityText", "(Landroid/widget/TextView;)V", "mBgColorRadioGroup", "Landroid/widget/RadioGroup;", "getMBgColorRadioGroup", "()Landroid/widget/RadioGroup;", "setMBgColorRadioGroup", "(Landroid/widget/RadioGroup;)V", "mWhiteRadio", "Landroid/widget/RadioButton;", "getMWhiteRadio", "()Landroid/widget/RadioButton;", "setMWhiteRadio", "(Landroid/widget/RadioButton;)V", "mBlackRadio", "getMBlackRadio", "setMBlackRadio", "mMatchWithSettingRadio", "getMMatchWithSettingRadio", "setMMatchWithSettingRadio", "mWhiteColorContainer", "getMWhiteColorContainer", "setMWhiteColorContainer", "mBlackColorContainer", "getMBlackColorContainer", "setMBlackColorContainer", "mMatchWithSettingColorContainer", "getMMatchWithSettingColorContainer", "setMMatchWithSettingColorContainer", "mWhiteCheckmark", "getMWhiteCheckmark", "setMWhiteCheckmark", "mBlackCheckmark", "getMBlackCheckmark", "setMBlackCheckmark", "mMatchWithSettingCheckmark", "getMMatchWithSettingCheckmark", "setMMatchWithSettingCheckmark", "mSelectedCheckmarkBackgroundColor", "getMSelectedCheckmarkBackgroundColor", "setMSelectedCheckmarkBackgroundColor", "mBackgroundColorsSubtitle", "getMBackgroundColorsSubtitle", "setMBackgroundColorsSubtitle", "mSliderBar", "getMSliderBar", "setMSliderBar", "mTransperanceView", "getMTransperanceView", "setMTransperanceView", "mDarkModeSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "getMDarkModeSwitch", "()Landroidx/appcompat/widget/SwitchCompat;", "setMDarkModeSwitch", "(Landroidx/appcompat/widget/SwitchCompat;)V", "mBackgroundColorText", "getMBackgroundColorText", "setMBackgroundColorText", "mBackgroundOnOffItemView", "getMBackgroundOnOffItemView", "setMBackgroundOnOffItemView", "mBackgroundColorsView", "getMBackgroundColorsView", "setMBackgroundColorsView", "mBackgroundShapeView", "getMBackgroundShapeView", "setMBackgroundShapeView", "mBackgroundOnOffFrameView", "getMBackgroundOnOffFrameView", "setMBackgroundOnOffFrameView", "mBackgroundOnOffContainerView", "getMBackgroundOnOffContainerView", "setMBackgroundOnOffContainerView", "mBackgroundOnOffCornerView", "Lcom/samsung/android/support/senl/nt/base/winset/view/RoundCornerOverlayView;", "getMBackgroundOnOffCornerView", "()Lcom/samsung/android/support/senl/nt/base/winset/view/RoundCornerOverlayView;", "setMBackgroundOnOffCornerView", "(Lcom/samsung/android/support/senl/nt/base/winset/view/RoundCornerOverlayView;)V", "mDividerButtonLayout", "Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;", "getMDividerButtonLayout", "()Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;", "setMDividerButtonLayout", "(Lcom/google/android/material/oneui/dividerbuttonlayout/DividerButtonLayout;)V", "mCancelSaveButtonLayout", "getMCancelSaveButtonLayout", "setMCancelSaveButtonLayout", "mOpacityIconBackgroundView", "getMOpacityIconBackgroundView", "setMOpacityIconBackgroundView", "mScrollView", "Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/NestedScrollViewCustom;", "getMScrollView", "()Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/NestedScrollViewCustom;", "setMScrollView", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/widget/NestedScrollViewCustom;)V", "init", "", "presenter", "Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "getPresenter", "()Lcom/samsung/android/support/senl/nt/base/widget/setting/presenter/BaseWidgetSettingPresenter;", "initScrollbar", "initCancelSaveButton", "inflateDividerButtonLayout", "initSaveCancel", "initOpacityView", "initOpacityViewOneUi7x", "updateOpacityIconOverlay", "getProgress", "", "transparency", "getTransparency", "initRadioButtons", "initBackgroundColorOneUI7x", "showPopupBackgroundColors", "anchorView", "getMatchSettingString", "", "setHoverView", "view", "indexItem", "selectCheckmarkBackgroundColor", "viewCheckmark", "initRadioButtonsOneUiOld", "initDarkModeSwitch", "setMaxFontSize", "menuEnableUpdate", "setEnableBackgroundColorView", "enable", "", "currentTheme", "getCurrentTheme", "()I", "isDarkTheme", "()Z", "isBlackBackground", "isBlackBackgroundOneUi7x", "previewAlpha", "getPreviewAlpha", "updateRoundCornerViewHeight", "roundCornerView", "height", "containerView", "parentRoundCornerView", "onBackgroundToggled", "isChecked", "updateBackgroundColor", "Landroid/widget/ImageView;", "backgroundId", "bgColor", "addSALog", "eventName", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "getDetail", "evenName", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class BaseWidgetSettingView implements BaseWidgetSettingContract {
    public static final float DISABLE_BUTTON_ALPHA = 0.4f;
    public static final float ENABLE_BUTTON_ALPHA = 1.0f;
    public static final int WIDGET_TEXT_BUTTON_TEXT_SIZE = 18;

    @Nullable
    private TextView mBackgroundColorText;

    @Nullable
    private TextView mBackgroundColorsSubtitle;

    @Nullable
    private View mBackgroundColorsView;

    @Nullable
    private View mBackgroundOnOffContainerView;

    @Nullable
    private RoundCornerOverlayView mBackgroundOnOffCornerView;

    @Nullable
    private View mBackgroundOnOffFrameView;

    @Nullable
    private View mBackgroundOnOffItemView;

    @Nullable
    private View mBackgroundShapeView;

    @Nullable
    private RadioGroup mBgColorRadioGroup;

    @Nullable
    private View mBlackCheckmark;

    @Nullable
    private View mBlackColorContainer;

    @Nullable
    private RadioButton mBlackRadio;

    @Nullable
    private View mCancelSaveButtonLayout;

    @Nullable
    private SwitchCompat mDarkModeSwitch;

    @Nullable
    private DividerButtonLayout mDividerButtonLayout;

    @Nullable
    private View mMatchWithSettingCheckmark;

    @Nullable
    private View mMatchWithSettingColorContainer;

    @Nullable
    private RadioButton mMatchWithSettingRadio;

    @Nullable
    private View mOpacityIconBackgroundView;

    @Nullable
    private TextView mOpacityText;

    @NotNull
    private View mParent;

    @Nullable
    private NestedScrollViewCustom mScrollView;

    @Nullable
    private SeslSeekBar mSeekBar;

    @Nullable
    private View mSelectedCheckmarkBackgroundColor;

    @Nullable
    private View mSliderBar;

    @Nullable
    private View mTransperanceView;

    @Nullable
    private View mWhiteCheckmark;

    @Nullable
    private View mWhiteColorContainer;

    @Nullable
    private RadioButton mWhiteRadio;

    public BaseWidgetSettingView(@NotNull View mParent) {
        Intrinsics.checkNotNullParameter(mParent, "mParent");
        this.mParent = mParent;
    }

    private final String getMatchSettingString() {
        if (DeviceUtils.isTabletModel()) {
            String string = this.mParent.getResources().getString(C8875R.string.base_widget_setting_match_with_tablet_setting);
            Intrinsics.checkNotNull(string);
            return string;
        }
        String string2 = this.mParent.getResources().getString(C8875R.string.base_widget_setting_match_with_phone_setting);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    private final void inflateDividerButtonLayout() {
        DividerButtonLayout dividerButtonLayout = this.mDividerButtonLayout;
        if (dividerButtonLayout != null) {
            dividerButtonLayout.inflateMenu(C8875R.menu.widget_setting_menu);
        }
        DividerButtonLayout dividerButtonLayout2 = this.mDividerButtonLayout;
        if (dividerButtonLayout2 != null) {
            dividerButtonLayout2.setOnMenuItemClickListener(new DividerButtonLayout.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.BaseWidgetSettingView.inflateDividerButtonLayout.1
                @Override // com.google.android.material.oneui.dividerbuttonlayout.DividerButtonLayout.OnMenuItemClickListener
                public boolean onMenuItemClick(MenuItem item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    if (item.getItemId() == C8875R.id.save) {
                        BaseWidgetSettingView.this.getPresenter().saveAndFinish();
                        return true;
                    }
                    BaseWidgetSettingView.this.getPresenter().cancelAndFinish();
                    return true;
                }
            });
        }
        NestedScrollViewCustom nestedScrollViewCustom = this.mScrollView;
        if (nestedScrollViewCustom != null) {
            nestedScrollViewCustom.seslSetFadingEdgeEnabled(true, 0, this.mParent.getContext().getResources().getDimensionPixelSize(C8875R.dimen.sesl_fading_edge_extra_bottom_height));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBackgroundColorOneUI7x$lambda$1(BaseWidgetSettingView baseWidgetSettingView, View view) {
        Intrinsics.checkNotNull(view);
        baseWidgetSettingView.showPopupBackgroundColors(view);
    }

    private final void initCancelSaveButton() {
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget() && this.mParent.getResources().getConfiguration().orientation == 1) {
            this.mDividerButtonLayout = (DividerButtonLayout) this.mParent.findViewById(C8875R.id.divider_button_layout);
            inflateDividerButtonLayout();
            return;
        }
        View viewFindViewById = this.mParent.findViewById(C8875R.id.widget_setting_cancel_save_button_layout);
        this.mCancelSaveButtonLayout = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        initSaveCancel();
        setMaxFontSize();
    }

    private final void initDarkModeSwitch() {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            return;
        }
        View viewFindViewById = this.mParent.findViewById(C8875R.id.widget_setting_dark_mode_on_off_container);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.View");
        viewFindViewById.setVisibility(0);
        View viewFindViewById2 = this.mParent.findViewById(C8875R.id.view_divider_radio);
        if (companion.isNotSupportMatchWithDarkMode()) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
            return;
        }
        View viewFindViewById3 = this.mParent.findViewById(C8875R.id.widget_setting_dark_mode_on_off_switch);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        SwitchCompat switchCompat = (SwitchCompat) viewFindViewById3;
        this.mDarkModeSwitch = switchCompat;
        if (switchCompat != null) {
            switchCompat.setChecked(getPresenter().getDarkMode() == 1);
        }
        SwitchCompat switchCompat2 = this.mDarkModeSwitch;
        if (switchCompat2 != null) {
            switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.BaseWidgetSettingView.initDarkModeSwitch.1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Intrinsics.checkNotNullParameter(compoundButton, "compoundButton");
                    BaseWidgetSettingView.this.getPresenter().onDarkModeSwitchChanged(b);
                }
            });
        }
        TextView textView = (TextView) viewFindViewById.findViewById(C8875R.id.widget_setting_dark_mode_on_off_text);
        textView.post(new RunnableC8515c(textView, viewFindViewById.findViewById(C8875R.id.widget_setting_dark_mode_on_off_round_corner), 20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDarkModeSwitch$lambda$7(TextView textView, View view) {
        int height = textView.getHeight();
        if (height < textView.getResources().getDimensionPixelSize(C8875R.dimen.widget_setting_item_height) || view.getHeight() == height) {
            return;
        }
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, height));
        view.invalidate();
    }

    private final void initOpacityView() {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            View viewFindViewById = this.mParent.findViewById(C8875R.id.slider_bar);
            this.mSliderBar = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
                return;
            }
            return;
        }
        Object systemService = this.mParent.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewFindViewById2 = this.mParent.findViewById(C8875R.id.widget_setting_control_menu_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((LinearLayout) viewFindViewById2).addView(((LayoutInflater) systemService).inflate(C8875R.layout.widget_setting_control_background_color, (ViewGroup) null), 0);
        Drawable drawable = this.mParent.getContext().getResources().getDrawable(C8875R.drawable.widget_setting_thumb_background);
        View viewFindViewById3 = this.mParent.findViewById(C8875R.id.widget_setting_seek_bar_percent_text);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.mOpacityText = (TextView) viewFindViewById3;
        SeslSeekBar seslSeekBar = (SeslSeekBar) this.mParent.findViewById(C8875R.id.widget_setting_seek_bar);
        this.mSeekBar = seslSeekBar;
        if (seslSeekBar != null) {
            seslSeekBar.setMax(10);
        }
        SeslSeekBar seslSeekBar2 = this.mSeekBar;
        if (seslSeekBar2 != null) {
            seslSeekBar2.setMode(8);
        }
        SeslSeekBar seslSeekBar3 = this.mSeekBar;
        if (seslSeekBar3 != null) {
            seslSeekBar3.setThumb(drawable);
        }
        int transparency = getPresenter().getTransparency();
        TextView textView = this.mOpacityText;
        if (textView != null) {
            textView.setText(companion.getProgressToString(transparency));
        }
        SeslSeekBar seslSeekBar4 = this.mSeekBar;
        if (seslSeekBar4 != null) {
            seslSeekBar4.setProgress(transparency / 10);
        }
        SeslSeekBar seslSeekBar5 = this.mSeekBar;
        if (seslSeekBar5 != null) {
            seslSeekBar5.setOnSeekBarChangeListener(new SeslSeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.BaseWidgetSettingView.initOpacityView.1
                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeslSeekBar seekBar, int i, boolean fromUser) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                    int i2 = i * 10;
                    TextView mOpacityText = BaseWidgetSettingView.this.getMOpacityText();
                    if (mOpacityText != null) {
                        mOpacityText.setText(BaseWidgetUtils.INSTANCE.getProgressToString(i2));
                    }
                    SeslSeekBar mSeekBar = BaseWidgetSettingView.this.getMSeekBar();
                    if (mSeekBar != null) {
                        mSeekBar.setProgress(i);
                    }
                    BaseWidgetSettingView.this.getPresenter().onTransparencyChanged(i2);
                }

                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeslSeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }

                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeslSeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initOpacityViewOneUi7x$lambda$0(BaseWidgetSettingView baseWidgetSettingView, Resources resources, Drawable drawable, View view, MotionEvent motionEvent) {
        SeslSeekBar seslSeekBar;
        int action = motionEvent.getAction();
        if (action != 9) {
            if (action != 10 || (seslSeekBar = baseWidgetSettingView.mSeekBar) == null) {
                return false;
            }
            seslSeekBar.setThumb(drawable);
            return false;
        }
        SeslSeekBar seslSeekBar2 = baseWidgetSettingView.mSeekBar;
        if (seslSeekBar2 == null) {
            return false;
        }
        seslSeekBar2.setThumb(resources.getDrawable(C8875R.drawable.widget_setting_thumb_background_hover));
        return false;
    }

    private final void initRadioButtons() {
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            return;
        }
        initRadioButtonsOneUiOld();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRadioButtonsOneUiOld$lambda$6(BaseWidgetSettingView baseWidgetSettingView, RadioGroup group, int i) {
        Intrinsics.checkNotNullParameter(group, "group");
        baseWidgetSettingView.addSALog("background_color", i);
        int backgroundColor = baseWidgetSettingView.getPresenter().getBackgroundColor();
        if (i == C8875R.id.radio_white && backgroundColor != 1) {
            baseWidgetSettingView.getPresenter().onBackgroundColorCheckChanged(1);
            baseWidgetSettingView.getPresenter().setMatchSetting(false);
        } else if (i == C8875R.id.radio_black && backgroundColor != 0) {
            baseWidgetSettingView.getPresenter().onBackgroundColorCheckChanged(0);
            baseWidgetSettingView.getPresenter().setMatchSetting(false);
        }
        baseWidgetSettingView.updateWidgetPreviewTheme();
        baseWidgetSettingView.updateWidgetBackgroundColor();
    }

    private final void initSaveCancel() {
        View viewFindViewById = this.mParent.findViewById(C8875R.id.save);
        if (viewFindViewById != null) {
            ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.BaseWidgetSettingView.initSaveCancel.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    BaseWidgetSettingView.this.getPresenter().saveAndFinish();
                }
            });
        }
        View viewFindViewById2 = this.mParent.findViewById(C8875R.id.cancel);
        if (viewFindViewById2 != null) {
            ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById2);
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.BaseWidgetSettingView.initSaveCancel.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    BaseWidgetSettingView.this.getPresenter().cancelAndFinish();
                }
            });
        }
    }

    private final void initScrollbar() {
        NestedScrollViewCustom nestedScrollViewCustom = (NestedScrollViewCustom) this.mParent.findViewById(C8875R.id.widget_setting_scroll_view);
        this.mScrollView = nestedScrollViewCustom;
        if (nestedScrollViewCustom != null) {
            nestedScrollViewCustom.seslSetFillHorizontalPaddingEnabled(true, ContextCompat.getColor(this.mParent.getContext(), C8875R.color.widget_setting_background));
        }
    }

    private final void setHoverView(View view, final int indexItem) {
        if (view != null) {
            view.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.b
                @Override // android.view.View.OnHoverListener
                public final boolean onHover(View view2, MotionEvent motionEvent) {
                    return BaseWidgetSettingView.setHoverView$lambda$5(indexItem, this, view2, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setHoverView$lambda$5(int i, BaseWidgetSettingView baseWidgetSettingView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 9) {
            view.setBackground(i != 0 ? i != 2 ? ContextCompat.getDrawable(baseWidgetSettingView.mParent.getContext(), C8875R.drawable.f6378xdc7180c1) : ContextCompat.getDrawable(baseWidgetSettingView.mParent.getContext(), C8875R.drawable.f6375x3cc81a57) : ContextCompat.getDrawable(baseWidgetSettingView.mParent.getContext(), C8875R.drawable.f6381xe7f292cd));
            return false;
        }
        if (action != 10) {
            return false;
        }
        view.setBackground(i != 0 ? i != 2 ? ContextCompat.getDrawable(baseWidgetSettingView.mParent.getContext(), C8875R.drawable.f6377x7298762) : ContextCompat.getDrawable(baseWidgetSettingView.mParent.getContext(), C8875R.drawable.f6374xac401378) : ContextCompat.getDrawable(baseWidgetSettingView.mParent.getContext(), C8875R.drawable.f6380x36ae466e));
        return false;
    }

    private final void setMaxFontSize() {
        Context context = this.mParent.getContext();
        CharUtils.applyTextSizeUntilLargeSize(context, (TextView) this.mParent.findViewById(C8875R.id.save), 18.0f);
        CharUtils.applyTextSizeUntilLargeSize(context, (TextView) this.mParent.findViewById(C8875R.id.cancel), 18.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupBackgroundColors$lambda$2(BaseWidgetSettingView baseWidgetSettingView, PopupWindow popupWindow, View view) {
        baseWidgetSettingView.getPresenter().setMatchSetting(true);
        if (ContextUtils.isNightMode(baseWidgetSettingView.mParent.getContext())) {
            baseWidgetSettingView.getPresenter().setBackgroundColor(0);
        } else {
            baseWidgetSettingView.getPresenter().setBackgroundColor(1);
        }
        baseWidgetSettingView.selectCheckmarkBackgroundColor(baseWidgetSettingView.mMatchWithSettingCheckmark);
        TextView textView = baseWidgetSettingView.mBackgroundColorsSubtitle;
        if (textView != null) {
            textView.setText(baseWidgetSettingView.getMatchSettingString());
        }
        baseWidgetSettingView.updateOpacityIconOverlay();
        baseWidgetSettingView.updateWidgetBackgroundColor();
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupBackgroundColors$lambda$3(BaseWidgetSettingView baseWidgetSettingView, PopupWindow popupWindow, View view) {
        baseWidgetSettingView.getPresenter().setMatchSetting(false);
        baseWidgetSettingView.getPresenter().setBackgroundColor(1);
        TextView textView = baseWidgetSettingView.mBackgroundColorsSubtitle;
        if (textView != null) {
            textView.setText(baseWidgetSettingView.mParent.getResources().getString(C8875R.string.base_widget_setting_light));
        }
        baseWidgetSettingView.selectCheckmarkBackgroundColor(baseWidgetSettingView.mWhiteCheckmark);
        baseWidgetSettingView.updateOpacityIconOverlay();
        baseWidgetSettingView.updateWidgetBackgroundColor();
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopupBackgroundColors$lambda$4(BaseWidgetSettingView baseWidgetSettingView, PopupWindow popupWindow, View view) {
        baseWidgetSettingView.getPresenter().setMatchSetting(false);
        baseWidgetSettingView.getPresenter().setBackgroundColor(0);
        TextView textView = baseWidgetSettingView.mBackgroundColorsSubtitle;
        if (textView != null) {
            textView.setText(baseWidgetSettingView.mParent.getResources().getString(C8875R.string.base_widget_setting_dark));
        }
        baseWidgetSettingView.selectCheckmarkBackgroundColor(baseWidgetSettingView.mBlackCheckmark);
        baseWidgetSettingView.updateOpacityIconOverlay();
        baseWidgetSettingView.updateWidgetBackgroundColor();
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRoundCornerViewHeight$lambda$8(View view, int i) {
        if (i < view.getResources().getDimensionPixelSize(C8875R.dimen.widget_setting_item_height) || view.getHeight() == i) {
            return;
        }
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
        view.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateRoundCornerViewHeight$lambda$9(View view, View view2, RoundCornerOverlayView roundCornerOverlayView) {
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view2 instanceof FrameLayout ? new FrameLayout.LayoutParams(-1, height) : view2 instanceof LinearLayout ? new LinearLayout.LayoutParams(-1, height) : new RelativeLayout.LayoutParams(-1, height);
        if (roundCornerOverlayView != null) {
            roundCornerOverlayView.setLayoutParams(layoutParams);
        }
        if (roundCornerOverlayView != null) {
            roundCornerOverlayView.invalidate();
        }
    }

    public final void addSALog(@NotNull String eventName, int detail) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (Intrinsics.areEqual(eventName, "background_color")) {
            if (simpleName != null) {
                int iHashCode = simpleName.hashCode();
                if (iHashCode == -1242642859) {
                    if (simpleName.equals(BaseWidgetSettingConstant.WIDGET_SINGLE_VIEW)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("613", "6129", getDetail(eventName, detail));
                        return;
                    }
                    return;
                } else if (iHashCode == -155181121) {
                    if (simpleName.equals(BaseWidgetSettingConstant.WIDGET_LIST_VIEW)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("615", "6130", getDetail(eventName, detail));
                        return;
                    }
                    return;
                } else {
                    if (iHashCode == 969169613 && simpleName.equals(BaseWidgetSettingConstant.WIDGET_CREATOR_VIEW)) {
                        NotesSamsungAnalytics.INSTANCE.insertLog("616", "6136", getDetail(eventName, detail));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (!Intrinsics.areEqual(eventName, "transparency") || simpleName == null) {
            return;
        }
        int iHashCode2 = simpleName.hashCode();
        if (iHashCode2 == -1242642859) {
            if (simpleName.equals(BaseWidgetSettingConstant.WIDGET_SINGLE_VIEW)) {
                NotesSamsungAnalytics.INSTANCE.insertLog("613", "6124", getDetail(eventName, detail));
            }
        } else if (iHashCode2 == -155181121) {
            if (simpleName.equals(BaseWidgetSettingConstant.WIDGET_LIST_VIEW)) {
                NotesSamsungAnalytics.INSTANCE.insertLog("615", "6127", getDetail(eventName, detail));
            }
        } else if (iHashCode2 == 969169613 && simpleName.equals(BaseWidgetSettingConstant.WIDGET_CREATOR_VIEW)) {
            NotesSamsungAnalytics.INSTANCE.insertLog("616", "6137", getDetail(eventName, detail));
        }
    }

    public final int getCurrentTheme() {
        return getPresenter().getTheme();
    }

    @NotNull
    public final String getDetail(@NotNull String evenName, int detail) {
        Intrinsics.checkNotNullParameter(evenName, "evenName");
        return Intrinsics.areEqual(evenName, "background_color") ? detail == C8875R.id.radio_match_with_setting ? "1. Match phone setting  " : detail == C8875R.id.radio_white ? "2. Light" : "3. Dark" : Intrinsics.areEqual(evenName, "transparency") ? detail != 0 ? detail != 1 ? "3. Level 3" : "2. Level 2" : "1. Level 1" : "None";
    }

    @Nullable
    public final TextView getMBackgroundColorText() {
        return this.mBackgroundColorText;
    }

    @Nullable
    public final TextView getMBackgroundColorsSubtitle() {
        return this.mBackgroundColorsSubtitle;
    }

    @Nullable
    public final View getMBackgroundColorsView() {
        return this.mBackgroundColorsView;
    }

    @Nullable
    public final View getMBackgroundOnOffContainerView() {
        return this.mBackgroundOnOffContainerView;
    }

    @Nullable
    public final RoundCornerOverlayView getMBackgroundOnOffCornerView() {
        return this.mBackgroundOnOffCornerView;
    }

    @Nullable
    public final View getMBackgroundOnOffFrameView() {
        return this.mBackgroundOnOffFrameView;
    }

    @Nullable
    public final View getMBackgroundOnOffItemView() {
        return this.mBackgroundOnOffItemView;
    }

    @Nullable
    public final View getMBackgroundShapeView() {
        return this.mBackgroundShapeView;
    }

    @Nullable
    public final RadioGroup getMBgColorRadioGroup() {
        return this.mBgColorRadioGroup;
    }

    @Nullable
    public final View getMBlackCheckmark() {
        return this.mBlackCheckmark;
    }

    @Nullable
    public final View getMBlackColorContainer() {
        return this.mBlackColorContainer;
    }

    @Nullable
    public final RadioButton getMBlackRadio() {
        return this.mBlackRadio;
    }

    @Nullable
    public final View getMCancelSaveButtonLayout() {
        return this.mCancelSaveButtonLayout;
    }

    @Nullable
    public final SwitchCompat getMDarkModeSwitch() {
        return this.mDarkModeSwitch;
    }

    @Nullable
    public final DividerButtonLayout getMDividerButtonLayout() {
        return this.mDividerButtonLayout;
    }

    @Nullable
    public final View getMMatchWithSettingCheckmark() {
        return this.mMatchWithSettingCheckmark;
    }

    @Nullable
    public final View getMMatchWithSettingColorContainer() {
        return this.mMatchWithSettingColorContainer;
    }

    @Nullable
    public final RadioButton getMMatchWithSettingRadio() {
        return this.mMatchWithSettingRadio;
    }

    @Nullable
    public final View getMOpacityIconBackgroundView() {
        return this.mOpacityIconBackgroundView;
    }

    @Nullable
    public final TextView getMOpacityText() {
        return this.mOpacityText;
    }

    @NotNull
    public final View getMParent() {
        return this.mParent;
    }

    @Nullable
    public final NestedScrollViewCustom getMScrollView() {
        return this.mScrollView;
    }

    @Nullable
    public final SeslSeekBar getMSeekBar() {
        return this.mSeekBar;
    }

    @Nullable
    public final View getMSelectedCheckmarkBackgroundColor() {
        return this.mSelectedCheckmarkBackgroundColor;
    }

    @Nullable
    public final View getMSliderBar() {
        return this.mSliderBar;
    }

    @Nullable
    public final View getMTransperanceView() {
        return this.mTransperanceView;
    }

    @Nullable
    public final View getMWhiteCheckmark() {
        return this.mWhiteCheckmark;
    }

    @Nullable
    public final View getMWhiteColorContainer() {
        return this.mWhiteColorContainer;
    }

    @Nullable
    public final RadioButton getMWhiteRadio() {
        return this.mWhiteRadio;
    }

    @NotNull
    public abstract BaseWidgetSettingPresenter getPresenter();

    public final int getPreviewAlpha() {
        return BaseWidgetUtils.INSTANCE.convertAlpha(getPresenter().getReverseTransparency());
    }

    public final int getProgress(int transparency) {
        if (transparency < 0 || transparency >= 51) {
            return ((51 > transparency || transparency >= 91) && 91 <= transparency && transparency < 101) ? 2 : 1;
        }
        return 0;
    }

    public final int getTransparency(int transparency) {
        if (transparency != 0) {
            return (transparency == 1 || transparency != 2) ? 75 : 100;
        }
        return 50;
    }

    public void init() {
        initScrollbar();
        initOpacityView();
        initRadioButtons();
        initDarkModeSwitch();
        initCancelSaveButton();
    }

    public final void initBackgroundColorOneUI7x() {
        View viewFindViewById = this.mParent.findViewById(C8875R.id.widget_glance_setting_colors);
        this.mBackgroundColorsView = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC8556a(this, 7));
        }
        this.mBackgroundColorsSubtitle = (TextView) this.mParent.findViewById(C8875R.id.widget_glance_setting_colors_sub_title);
        if (getPresenter().getMatchSetting()) {
            TextView textView = this.mBackgroundColorsSubtitle;
            if (textView != null) {
                textView.setText(getMatchSettingString());
                return;
            }
            return;
        }
        if (getPresenter().getBackgroundColor() == 1) {
            TextView textView2 = this.mBackgroundColorsSubtitle;
            if (textView2 != null) {
                textView2.setText(this.mParent.getResources().getString(C8875R.string.base_widget_setting_light));
                return;
            }
            return;
        }
        TextView textView3 = this.mBackgroundColorsSubtitle;
        if (textView3 != null) {
            textView3.setText(this.mParent.getResources().getString(C8875R.string.base_widget_setting_dark));
        }
    }

    public final void initOpacityViewOneUi7x() {
        Resources resources = this.mParent.getContext().getResources();
        this.mOpacityIconBackgroundView = this.mParent.findViewById(C8875R.id.widget_glance_setting_opacity_icon_overlay);
        this.mTransperanceView = this.mParent.findViewById(C8875R.id.widget_glance_setting_opacity);
        Drawable drawable = resources.getDrawable(C8875R.drawable.widget_setting_thumb_background);
        SeslSeekBar seslSeekBar = (SeslSeekBar) this.mParent.findViewById(C8875R.id.widget_glance_setting_opacity_seekbar);
        this.mSeekBar = seslSeekBar;
        if (seslSeekBar != null) {
            seslSeekBar.setMax(2);
        }
        SeslSeekBar seslSeekBar2 = this.mSeekBar;
        if (seslSeekBar2 != null) {
            seslSeekBar2.setMode(8);
        }
        SeslSeekBar seslSeekBar3 = this.mSeekBar;
        if (seslSeekBar3 != null) {
            seslSeekBar3.setThumb(drawable);
        }
        int transparency = getPresenter().getTransparency();
        SeslSeekBar seslSeekBar4 = this.mSeekBar;
        if (seslSeekBar4 != null) {
            seslSeekBar4.setProgress(getProgress(transparency));
        }
        SeslSeekBar seslSeekBar5 = this.mSeekBar;
        if (seslSeekBar5 != null) {
            seslSeekBar5.setOnHoverListener(new ViewOnHoverListenerC8950a(this, 0, resources, drawable));
        }
        SeslSeekBar seslSeekBar6 = this.mSeekBar;
        if (seslSeekBar6 != null) {
            seslSeekBar6.setOnSeekBarChangeListener(new SeslSeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.BaseWidgetSettingView.initOpacityViewOneUi7x.2
                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeslSeekBar seekBar, int i, boolean fromUser) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                    int transparency2 = BaseWidgetSettingView.this.getTransparency(i);
                    BaseWidgetSettingView.this.addSALog("transparency", i);
                    SeslSeekBar mSeekBar = BaseWidgetSettingView.this.getMSeekBar();
                    if (mSeekBar != null) {
                        mSeekBar.setProgress(i);
                    }
                    BaseWidgetSettingView.this.getPresenter().onTransparencyChangedOneUi7x(transparency2);
                }

                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeslSeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }

                @Override // androidx.appcompat.widget.SeslSeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeslSeekBar seekBar) {
                    Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                }
            });
        }
        updateOpacityIconOverlay();
    }

    public final void initRadioButtonsOneUiOld() {
        View viewFindViewById = this.mParent.findViewById(C8875R.id.radio_group);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.RadioGroup");
        this.mBgColorRadioGroup = (RadioGroup) viewFindViewById;
        View viewFindViewById2 = this.mParent.findViewById(C8875R.id.radio_white);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.RadioButton");
        this.mWhiteRadio = (RadioButton) viewFindViewById2;
        View viewFindViewById3 = this.mParent.findViewById(C8875R.id.radio_black);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.RadioButton");
        this.mBlackRadio = (RadioButton) viewFindViewById3;
        this.mBackgroundColorText = (TextView) this.mParent.findViewById(C8875R.id.widget_setting_seekbar_title);
        if (getPresenter().getBackgroundColor() == 1) {
            RadioButton radioButton = this.mWhiteRadio;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
        } else {
            RadioButton radioButton2 = this.mBlackRadio;
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
        }
        RadioGroup radioGroup = this.mBgColorRadioGroup;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new C7558c(this, 4));
        }
    }

    public final boolean isBlackBackground() {
        BaseWidgetUtils.Companion companion = BaseWidgetUtils.INSTANCE;
        if (companion.isSupportedNewWidget()) {
            return getPresenter().getBackgroundColor() == 0 || companion.isMatchWithDarkModeAndNightMode(this.mParent.getContext(), getPresenter().getMatchSetting() ? 1 : 0);
        }
        return getPresenter().getBackgroundColor() == 0 || companion.isMatchWithDarkModeAndNightMode(this.mParent.getContext(), getPresenter().getDarkMode());
    }

    public final boolean isBlackBackgroundOneUi7x() {
        return getPresenter().getMatchSetting() ? getPresenter().getMModel().getDarkMode() == 1 && ContextUtils.isNightMode(this.mParent.getContext()) : getPresenter().getBackgroundColor() == 0;
    }

    public final boolean isDarkTheme() {
        return getCurrentTheme() == 0;
    }

    public final void menuEnableUpdate() {
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            return;
        }
        setEnableBackgroundColorView(!r0.isMatchWithDarkModeAndNightMode(this.mParent.getContext(), getPresenter().getDarkMode()));
    }

    public void onBackgroundToggled(boolean isChecked) {
        int i = isChecked ? 0 : 8;
        View view = this.mBackgroundColorsView;
        if (view != null) {
            view.setVisibility(i);
        }
        View view2 = this.mBackgroundShapeView;
        if (view2 != null) {
            view2.setVisibility(i);
        }
        View view3 = this.mBackgroundOnOffItemView;
        if (view3 != null) {
            view3.setVisibility(i);
        }
        updateWidgetBackgroundColor();
    }

    public final void selectCheckmarkBackgroundColor(@Nullable View viewCheckmark) {
        View view = this.mSelectedCheckmarkBackgroundColor;
        if (view != null) {
            view.setVisibility(4);
        }
        if (viewCheckmark != null) {
            viewCheckmark.setVisibility(0);
        }
        this.mSelectedCheckmarkBackgroundColor = viewCheckmark;
    }

    public void setEnableBackgroundColorView(boolean enable) {
        int color;
        if (enable) {
            color = ContextCompat.getColor(this.mParent.getContext(), C8875R.color.widget_setting_background_enabled_text_color);
            RadioButton radioButton = this.mWhiteRadio;
            if (radioButton != null) {
                radioButton.setAlpha(1.0f);
            }
            RadioButton radioButton2 = this.mBlackRadio;
            if (radioButton2 != null) {
                radioButton2.setAlpha(1.0f);
            }
            SeslSeekBar seslSeekBar = this.mSeekBar;
            if (seslSeekBar != null) {
                seslSeekBar.setAlpha(1.0f);
            }
        } else {
            color = ContextCompat.getColor(this.mParent.getContext(), C8875R.color.widget_setting_background_disabled_text_color);
            RadioButton radioButton3 = this.mWhiteRadio;
            if (radioButton3 != null) {
                radioButton3.setAlpha(0.4f);
            }
            RadioButton radioButton4 = this.mBlackRadio;
            if (radioButton4 != null) {
                radioButton4.setAlpha(0.4f);
            }
            SeslSeekBar seslSeekBar2 = this.mSeekBar;
            if (seslSeekBar2 != null) {
                seslSeekBar2.setAlpha(0.4f);
            }
        }
        RadioButton radioButton5 = this.mWhiteRadio;
        if (radioButton5 != null) {
            radioButton5.setEnabled(enable);
        }
        RadioButton radioButton6 = this.mBlackRadio;
        if (radioButton6 != null) {
            radioButton6.setEnabled(enable);
        }
        TextView textView = this.mOpacityText;
        if (textView != null) {
            textView.setEnabled(enable);
        }
        SeslSeekBar seslSeekBar3 = this.mSeekBar;
        if (seslSeekBar3 != null) {
            seslSeekBar3.setEnabled(enable);
        }
        RadioButton radioButton7 = this.mWhiteRadio;
        if (radioButton7 != null) {
            radioButton7.setTextColor(color);
        }
        RadioButton radioButton8 = this.mBlackRadio;
        if (radioButton8 != null) {
            radioButton8.setTextColor(color);
        }
        TextView textView2 = this.mOpacityText;
        if (textView2 != null) {
            textView2.setTextColor(color);
        }
    }

    public final void setMBackgroundColorText(@Nullable TextView textView) {
        this.mBackgroundColorText = textView;
    }

    public final void setMBackgroundColorsSubtitle(@Nullable TextView textView) {
        this.mBackgroundColorsSubtitle = textView;
    }

    public final void setMBackgroundColorsView(@Nullable View view) {
        this.mBackgroundColorsView = view;
    }

    public final void setMBackgroundOnOffContainerView(@Nullable View view) {
        this.mBackgroundOnOffContainerView = view;
    }

    public final void setMBackgroundOnOffCornerView(@Nullable RoundCornerOverlayView roundCornerOverlayView) {
        this.mBackgroundOnOffCornerView = roundCornerOverlayView;
    }

    public final void setMBackgroundOnOffFrameView(@Nullable View view) {
        this.mBackgroundOnOffFrameView = view;
    }

    public final void setMBackgroundOnOffItemView(@Nullable View view) {
        this.mBackgroundOnOffItemView = view;
    }

    public final void setMBackgroundShapeView(@Nullable View view) {
        this.mBackgroundShapeView = view;
    }

    public final void setMBgColorRadioGroup(@Nullable RadioGroup radioGroup) {
        this.mBgColorRadioGroup = radioGroup;
    }

    public final void setMBlackCheckmark(@Nullable View view) {
        this.mBlackCheckmark = view;
    }

    public final void setMBlackColorContainer(@Nullable View view) {
        this.mBlackColorContainer = view;
    }

    public final void setMBlackRadio(@Nullable RadioButton radioButton) {
        this.mBlackRadio = radioButton;
    }

    public final void setMCancelSaveButtonLayout(@Nullable View view) {
        this.mCancelSaveButtonLayout = view;
    }

    public final void setMDarkModeSwitch(@Nullable SwitchCompat switchCompat) {
        this.mDarkModeSwitch = switchCompat;
    }

    public final void setMDividerButtonLayout(@Nullable DividerButtonLayout dividerButtonLayout) {
        this.mDividerButtonLayout = dividerButtonLayout;
    }

    public final void setMMatchWithSettingCheckmark(@Nullable View view) {
        this.mMatchWithSettingCheckmark = view;
    }

    public final void setMMatchWithSettingColorContainer(@Nullable View view) {
        this.mMatchWithSettingColorContainer = view;
    }

    public final void setMMatchWithSettingRadio(@Nullable RadioButton radioButton) {
        this.mMatchWithSettingRadio = radioButton;
    }

    public final void setMOpacityIconBackgroundView(@Nullable View view) {
        this.mOpacityIconBackgroundView = view;
    }

    public final void setMOpacityText(@Nullable TextView textView) {
        this.mOpacityText = textView;
    }

    public final void setMParent(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mParent = view;
    }

    public final void setMScrollView(@Nullable NestedScrollViewCustom nestedScrollViewCustom) {
        this.mScrollView = nestedScrollViewCustom;
    }

    public final void setMSeekBar(@Nullable SeslSeekBar seslSeekBar) {
        this.mSeekBar = seslSeekBar;
    }

    public final void setMSelectedCheckmarkBackgroundColor(@Nullable View view) {
        this.mSelectedCheckmarkBackgroundColor = view;
    }

    public final void setMSliderBar(@Nullable View view) {
        this.mSliderBar = view;
    }

    public final void setMTransperanceView(@Nullable View view) {
        this.mTransperanceView = view;
    }

    public final void setMWhiteCheckmark(@Nullable View view) {
        this.mWhiteCheckmark = view;
    }

    public final void setMWhiteColorContainer(@Nullable View view) {
        this.mWhiteColorContainer = view;
    }

    public final void setMWhiteRadio(@Nullable RadioButton radioButton) {
        this.mWhiteRadio = radioButton;
    }

    public final void showPopupBackgroundColors(@NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Object systemService = this.mParent.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C8875R.layout.widget_glance_setting_control_background_colors_popup, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2, true);
        this.mMatchWithSettingColorContainer = viewInflate.findViewById(C8875R.id.match_with_setting_color_container);
        this.mWhiteColorContainer = viewInflate.findViewById(C8875R.id.white_color_container);
        this.mBlackColorContainer = viewInflate.findViewById(C8875R.id.black_color_container);
        this.mMatchWithSettingCheckmark = viewInflate.findViewById(C8875R.id.match_with_setting_color_selected_checkmark);
        this.mWhiteCheckmark = viewInflate.findViewById(C8875R.id.white_color_selected_checkmark);
        this.mBlackCheckmark = viewInflate.findViewById(C8875R.id.black_color_selected_checkmark);
        TextView textView = (TextView) viewInflate.findViewById(C8875R.id.match_with_setting_color_title);
        textView.setText(getMatchSettingString());
        textView.setContentDescription(getMatchSettingString());
        if (getPresenter().getMatchSetting()) {
            selectCheckmarkBackgroundColor(this.mMatchWithSettingCheckmark);
        } else if (getPresenter().getBackgroundColor() == 1) {
            selectCheckmarkBackgroundColor(this.mWhiteCheckmark);
        } else {
            selectCheckmarkBackgroundColor(this.mBlackCheckmark);
        }
        View view = this.mMatchWithSettingColorContainer;
        if (view != null) {
            final int i = 0;
            view.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ BaseWidgetSettingView f6498b;

                {
                    this.f6498b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i) {
                        case 0:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$2(this.f6498b, popupWindow, view2);
                            break;
                        case 1:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$3(this.f6498b, popupWindow, view2);
                            break;
                        default:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$4(this.f6498b, popupWindow, view2);
                            break;
                    }
                }
            });
        }
        View view2 = this.mWhiteColorContainer;
        if (view2 != null) {
            final int i2 = 1;
            view2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ BaseWidgetSettingView f6498b;

                {
                    this.f6498b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view22) {
                    switch (i2) {
                        case 0:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$2(this.f6498b, popupWindow, view22);
                            break;
                        case 1:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$3(this.f6498b, popupWindow, view22);
                            break;
                        default:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$4(this.f6498b, popupWindow, view22);
                            break;
                    }
                }
            });
        }
        View view3 = this.mBlackColorContainer;
        if (view3 != null) {
            final int i4 = 2;
            view3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.base.widget.setting.view.c

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ BaseWidgetSettingView f6498b;

                {
                    this.f6498b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view22) {
                    switch (i4) {
                        case 0:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$2(this.f6498b, popupWindow, view22);
                            break;
                        case 1:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$3(this.f6498b, popupWindow, view22);
                            break;
                        default:
                            BaseWidgetSettingView.showPopupBackgroundColors$lambda$4(this.f6498b, popupWindow, view22);
                            break;
                    }
                }
            });
        }
        setHoverView(this.mMatchWithSettingColorContainer, 0);
        setHoverView(this.mWhiteColorContainer, 1);
        setHoverView(this.mBlackColorContainer, 2);
        popupWindow.setElevation(16.0f);
        popupWindow.setOutsideTouchable(true);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        popupWindow.showAsDropDown(anchorView, 0, -viewInflate.getMeasuredHeight());
    }

    public final void updateBackgroundColor(@NotNull ImageView view, int backgroundId, int bgColor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setImageResource(backgroundId);
        view.setColorFilter(bgColor);
    }

    public void updateOpacityIconOverlay() {
        Context context;
        int i;
        if (isBlackBackgroundOneUi7x()) {
            context = this.mParent.getContext();
            i = C8875R.color.widget_glance_common_background_color_dark_theme;
        } else {
            context = this.mParent.getContext();
            i = C8875R.color.widget_glance_common_background_color_white_theme;
        }
        int alphaComponent = ColorUtils.setAlphaComponent(ContextCompat.getColor(context, i), new int[]{128, STBorder.INT_ZIG_ZAG_STITCH, 255}[1]);
        View view = this.mOpacityIconBackgroundView;
        if (view != null) {
            view.setBackgroundColor(alphaComponent);
        }
    }

    public final void updateRoundCornerViewHeight(@NotNull View roundCornerView, int height) {
        Intrinsics.checkNotNullParameter(roundCornerView, "roundCornerView");
        if (roundCornerView instanceof RoundCornerOverlayView) {
            roundCornerView.post(new RunnableC0050f((RoundCornerOverlayView) roundCornerView, height, 16));
        }
    }

    public final void updateRoundCornerViewHeight(@Nullable View containerView, @Nullable View parentRoundCornerView, @Nullable RoundCornerOverlayView roundCornerView) {
        if (containerView != null) {
            containerView.post(new RunnableC8928b(containerView, 3, parentRoundCornerView, roundCornerView));
        }
    }
}
