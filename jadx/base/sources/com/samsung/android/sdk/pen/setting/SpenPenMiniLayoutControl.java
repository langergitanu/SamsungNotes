package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.SpenMiniCloseButton;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import java.util.EnumMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b&\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0004]^_`B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010,\u001a\u00020-J(\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u00010\u0019J\b\u00103\u001a\u00020-H\u0002J\u001a\u00104\u001a\u0004\u0018\u00010\u001b2\u0006\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020\u0015H\u0002J\u0012\u00108\u001a\u0004\u0018\u00010\u00192\u0006\u00105\u001a\u00020\u0018H\u0002J\u001a\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020-H\u0002J\u0018\u0010A\u001a\u00020-2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0015H\u0002J\b\u0010D\u001a\u00020-H\u0002J\u0006\u0010E\u001a\u00020-J\u0006\u0010F\u001a\u00020-J\u0010\u0010G\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010#J\u0016\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0015J\u0010\u0010K\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010'J\u0010\u0010L\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u00010%J\u000e\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020\u0015J\b\u0010O\u001a\u00020-H\u0002J\u0018\u0010P\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0018\u0010R\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020\u0007H\u0002J(\u0010H\u001a\u00020-2\u0006\u00105\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\u0015H\u0002J\u0018\u0010W\u001a\u00020-2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0015H\u0002J\u0010\u0010X\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020-2\u0006\u0010T\u001a\u00020\u0007H\u0002J\u0010\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020\u0015H\u0002J\b\u0010\\\u001a\u00020-H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfigHelper;", "context", "Landroid/content/Context;", "popupLayout", "Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;", "orientation", "", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;I)V", "mContext", "mParent", "mHeaderButton", "Landroid/widget/ImageView;", "mFooterButton", "Lcom/samsung/android/sdk/pen/setting/SpenMiniCloseButton;", "mCurrentLayoutHelper", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenSettingLayoutInterface;", "mMiniHomeTransition", "Landroid/transition/TransitionSet;", "mIsInitialized", "", "mViewControl", "Ljava/util/EnumMap;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$ControlType;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewControl;", "mColorView", "Landroid/view/View;", "mPatternView", "mColorGroup", "Landroid/view/ViewGroup;", "mViewMode", "mHeaderString", "", "mChangeFavoriteButtonClickListener", "Landroid/view/View$OnClickListener;", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$OnButtonClickListener;", "mViewModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$OnViewModeChangedListener;", "mButtonEnableColor", "mButtonDimColor", "mFooterButtonClickListener", "mColorItemClickListener", "close", "", "setContent", "penInterface", "attributeInterface", "colorInterface", "patternInterface", "initLayout", "makeItemView", "type", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "needColorGroup", "getViewControl", "addPopupView", "viewControl", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewModeInterface;", "id", "setViewOrientation", "value", "getOrientation", "()I", "setOrientation", "(I)V", "animation", "clearView", "saveViewState", "restoreViewState", "setChangeFavoriteButton", "setViewMode", "viewMode", "needAnimation", "setOnViewModeChangedListener", "setOnButtonClickListener", "setPatternVisibility", "isVisible", "initParent", "addHeader", "parent", "addFooter", "notifyModeChanged", "mode", "expectedMode", "supportHomeTooltip", "setEnvironment", "getPopupId", "changeMode", "setHeaderTooltip", "enable", "initTransition", "Companion", "ControlType", "OnButtonClickListener", "OnViewModeChangedListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenPenMiniLayoutControl extends SpenLayoutConfigHelper {
    private static final int CHANGE_BOUNDS_DURATION = 400;
    private static final int FADE_IN_DURATION = 150;
    private static final int FADE_OUT_DURATION = 150;

    @NotNull
    private static final String TAG = "SpenPenMiniLayoutControl";
    public static final int VIEW_MODE_COLOR_LAYOUT = 8;
    public static final int VIEW_MODE_NORMAL = 1;
    public static final int VIEW_MODE_PATTERN_LAYOUT = 16;
    public static final int VIEW_MODE_PEN_LAYOUT = 2;
    public static final int VIEW_MODE_SIZE_LAYOUT = 4;

    @Nullable
    private OnButtonClickListener mButtonClickListener;
    private final int mButtonDimColor;
    private final int mButtonEnableColor;

    @Nullable
    private View.OnClickListener mChangeFavoriteButtonClickListener;

    @Nullable
    private ViewGroup mColorGroup;

    @NotNull
    private final View.OnClickListener mColorItemClickListener;

    @Nullable
    private View mColorView;

    @NotNull
    private Context mContext;
    private SpenMiniPenSettingLayoutInterface mCurrentLayoutHelper;
    private SpenMiniCloseButton mFooterButton;

    @NotNull
    private final View.OnClickListener mFooterButtonClickListener;
    private ImageView mHeaderButton;

    @Nullable
    private String mHeaderString;
    private boolean mIsInitialized;
    private TransitionSet mMiniHomeTransition;

    @NotNull
    private SpenPopupMiniLayout mParent;

    @Nullable
    private View mPatternView;

    @NotNull
    private EnumMap<ControlType, SpenPenMiniViewControl> mViewControl;
    private int mViewMode;

    @Nullable
    private OnViewModeChangedListener mViewModeChangedListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$ControlType;", "", "<init>", "(Ljava/lang/String;I)V", "PEN", "ATTRIBUTE", "COLOR", CoverConstants.TemplateType.PATTERN.UUID, "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ControlType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ControlType[] $VALUES;
        public static final ControlType PEN = new ControlType("PEN", 0);
        public static final ControlType ATTRIBUTE = new ControlType("ATTRIBUTE", 1);
        public static final ControlType COLOR = new ControlType("COLOR", 2);
        public static final ControlType PATTERN = new ControlType(CoverConstants.TemplateType.PATTERN.UUID, 3);

        private static final /* synthetic */ ControlType[] $values() {
            return new ControlType[]{PEN, ATTRIBUTE, COLOR, PATTERN};
        }

        static {
            ControlType[] controlTypeArr$values = $values();
            $VALUES = controlTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(controlTypeArr$values);
        }

        private ControlType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ControlType> getEntries() {
            return $ENTRIES;
        }

        public static ControlType valueOf(String str) {
            return (ControlType) Enum.valueOf(ControlType.class, str);
        }

        public static ControlType[] values() {
            return (ControlType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$OnButtonClickListener;", "", "onCloseButtonClicked", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnButtonClickListener {
        void onCloseButtonClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$OnViewModeChangedListener;", "", "onViewModeChanged", "", "mode", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnViewModeChangedListener {
        void onViewModeChanged(int mode);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenMiniCloseButton.Type.values().length];
            try {
                iArr[SpenMiniCloseButton.Type.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenMiniCloseButton.Type.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenPenMiniLayoutControl(@NotNull Context context, @NotNull SpenPopupMiniLayout popupLayout) {
        this(context, popupLayout, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(popupLayout, "popupLayout");
    }

    private final void addFooter(Context context, SpenPopupMiniLayout parent) {
        SpenMiniCloseButton spenMiniCloseButton = new SpenMiniCloseButton(context, getMOrientation() != 1 ? 0 : 1);
        this.mFooterButton = spenMiniCloseButton;
        spenMiniCloseButton.setBackgroundResource(C7932R.drawable.spen_ripple_effect_drawable);
        SpenMiniCloseButton spenMiniCloseButton2 = this.mFooterButton;
        SpenMiniCloseButton spenMiniCloseButton3 = null;
        if (spenMiniCloseButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterButton");
            spenMiniCloseButton2 = null;
        }
        spenMiniCloseButton2.setColorFilter(this.mButtonEnableColor);
        SpenMiniCloseButton spenMiniCloseButton4 = this.mFooterButton;
        if (spenMiniCloseButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterButton");
            spenMiniCloseButton4 = null;
        }
        parent.addDefaultFooterView(spenMiniCloseButton4);
        SpenMiniCloseButton spenMiniCloseButton5 = this.mFooterButton;
        if (spenMiniCloseButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterButton");
        } else {
            spenMiniCloseButton3 = spenMiniCloseButton5;
        }
        spenMiniCloseButton3.setOnClickListener(this.mFooterButtonClickListener);
    }

    private final void addHeader(Context context, SpenPopupMiniLayout parent) {
        ImageView imageView = new ImageView(context);
        this.mHeaderButton = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC7572e(this, 2));
        ImageView imageView2 = this.mHeaderButton;
        ImageView imageView3 = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
            imageView2 = null;
        }
        parent.addDefaultHeaderView(imageView2);
        ImageView imageView4 = this.mHeaderButton;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
        } else {
            imageView3 = imageView4;
        }
        imageView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView3.setImageResource(C7932R.drawable.favorite_off_line);
        imageView3.setBackgroundResource(C7932R.drawable.spen_ripple_effect_drawable);
        imageView3.setColorFilter(this.mButtonEnableColor);
        imageView3.setContentDescription(this.mHeaderString);
        setHeaderTooltip(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addHeader$lambda$8(SpenPenMiniLayoutControl spenPenMiniLayoutControl, View view) {
        View.OnClickListener onClickListener = spenPenMiniLayoutControl.mChangeFavoriteButtonClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private final void addPopupView(SpenPenMiniViewModeInterface viewControl, int id) {
        View popupView;
        if (viewControl == null || (popupView = viewControl.getPopupView()) == null) {
            return;
        }
        popupView.setId(id);
        this.mParent.addPopupView(popupView);
        if (viewControl.getMViewMode() == 1) {
            popupView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeMode(int mode) {
        AbstractC2322a.m1631u(mode, "changeMode() mode=", TAG);
        if (mode == 0 || !setViewMode(mode, true)) {
            return;
        }
        notifyModeChanged(mode);
    }

    private final void clearView() {
        if (this.mIsInitialized) {
            Iterator<SpenPenMiniViewControl> it = this.mViewControl.values().iterator();
            while (it.hasNext()) {
                it.next().clearView();
            }
        }
    }

    private final int getPopupId(int mode) {
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface = null;
        if (mode == 2) {
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface2 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            } else {
                spenMiniPenSettingLayoutInterface = spenMiniPenSettingLayoutInterface2;
            }
            return spenMiniPenSettingLayoutInterface.getPenPopupId();
        }
        if (mode == 4) {
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface3 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            } else {
                spenMiniPenSettingLayoutInterface = spenMiniPenSettingLayoutInterface3;
            }
            return spenMiniPenSettingLayoutInterface.getSizePopupId();
        }
        if (mode == 8) {
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface4 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            } else {
                spenMiniPenSettingLayoutInterface = spenMiniPenSettingLayoutInterface4;
            }
            return spenMiniPenSettingLayoutInterface.getColorPopupId();
        }
        if (mode != 16) {
            return C7932R.id.content_area;
        }
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface5 = this.mCurrentLayoutHelper;
        if (spenMiniPenSettingLayoutInterface5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
        } else {
            spenMiniPenSettingLayoutInterface = spenMiniPenSettingLayoutInterface5;
        }
        return spenMiniPenSettingLayoutInterface.getPatternPopupId();
    }

    private final SpenPenMiniViewControl getViewControl(ControlType type) {
        return this.mViewControl.get(type);
    }

    private final void initLayout() {
        setViewOrientation();
        this.mCurrentLayoutHelper = SpenMiniSettingLayoutFactory.createSettingLayoutHelper(getMOrientation());
        ConstraintLayout constraintLayout = new ConstraintLayout(this.mContext);
        SpenPopupMiniLayout spenPopupMiniLayout = this.mParent;
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface = this.mCurrentLayoutHelper;
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface2 = null;
        if (spenMiniPenSettingLayoutInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            spenMiniPenSettingLayoutInterface = null;
        }
        spenPopupMiniLayout.setContentView(constraintLayout, spenMiniPenSettingLayoutInterface.createContentParam());
        ControlType controlType = ControlType.PEN;
        View viewMakeItemView = makeItemView(controlType, new ViewOnClickListenerC7572e(this, 3));
        if (viewMakeItemView != null) {
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface3 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                spenMiniPenSettingLayoutInterface3 = null;
            }
            viewMakeItemView.setId(spenMiniPenSettingLayoutInterface3.getPenId());
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface4 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                spenMiniPenSettingLayoutInterface4 = null;
            }
            constraintLayout.addView(viewMakeItemView, spenMiniPenSettingLayoutInterface4.createPenParam(this.mContext));
        }
        boolean zNeedColorGroup = needColorGroup();
        if (zNeedColorGroup) {
            this.mColorGroup = new FrameLayout(this.mContext);
            View viewMakeItemView2 = makeItemView(ControlType.COLOR, this.mColorItemClickListener);
            this.mColorView = viewMakeItemView2;
            if (viewMakeItemView2 != null) {
                SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface5 = this.mCurrentLayoutHelper;
                if (spenMiniPenSettingLayoutInterface5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                    spenMiniPenSettingLayoutInterface5 = null;
                }
                viewMakeItemView2.setId(spenMiniPenSettingLayoutInterface5.getColorId());
                ViewGroup viewGroup = this.mColorGroup;
                if (viewGroup != null) {
                    viewGroup.addView(viewMakeItemView2);
                }
            }
            View viewMakeItemView3 = makeItemView(ControlType.PATTERN, new ViewOnClickListenerC7572e(this, 4));
            this.mPatternView = viewMakeItemView3;
            if (viewMakeItemView3 != null) {
                SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface6 = this.mCurrentLayoutHelper;
                if (spenMiniPenSettingLayoutInterface6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                    spenMiniPenSettingLayoutInterface6 = null;
                }
                viewMakeItemView3.setId(spenMiniPenSettingLayoutInterface6.getPatternId());
                ViewGroup viewGroup2 = this.mColorGroup;
                if (viewGroup2 != null) {
                    viewGroup2.addView(viewMakeItemView3);
                }
            }
        } else {
            this.mColorGroup = (ViewGroup) makeItemView(ControlType.COLOR, this.mColorItemClickListener);
        }
        ViewGroup viewGroup3 = this.mColorGroup;
        if (viewGroup3 != null) {
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface7 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                spenMiniPenSettingLayoutInterface7 = null;
            }
            viewGroup3.setId(spenMiniPenSettingLayoutInterface7.getColorGroupId());
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface8 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                spenMiniPenSettingLayoutInterface8 = null;
            }
            constraintLayout.addView(viewGroup3, spenMiniPenSettingLayoutInterface8.createColorParam(this.mContext));
        }
        ControlType controlType2 = ControlType.ATTRIBUTE;
        View viewMakeItemView4 = makeItemView(controlType2, new ViewOnClickListenerC7572e(this, 5));
        if (viewMakeItemView4 != null) {
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface9 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                spenMiniPenSettingLayoutInterface9 = null;
            }
            viewMakeItemView4.setId(spenMiniPenSettingLayoutInterface9.getSizeId());
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface10 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
                spenMiniPenSettingLayoutInterface10 = null;
            }
            constraintLayout.addView(viewMakeItemView4, spenMiniPenSettingLayoutInterface10.createSizeParam(this.mContext));
        }
        SpenPenMiniViewControl viewControl = getViewControl(controlType2);
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface11 = this.mCurrentLayoutHelper;
        if (spenMiniPenSettingLayoutInterface11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            spenMiniPenSettingLayoutInterface11 = null;
        }
        addPopupView(viewControl, spenMiniPenSettingLayoutInterface11.getSizePopupId());
        SpenPenMiniViewControl viewControl2 = getViewControl(controlType);
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface12 = this.mCurrentLayoutHelper;
        if (spenMiniPenSettingLayoutInterface12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            spenMiniPenSettingLayoutInterface12 = null;
        }
        addPopupView(viewControl2, spenMiniPenSettingLayoutInterface12.getPenPopupId());
        SpenPenMiniViewControl viewControl3 = getViewControl(ControlType.COLOR);
        SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface13 = this.mCurrentLayoutHelper;
        if (spenMiniPenSettingLayoutInterface13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            spenMiniPenSettingLayoutInterface13 = null;
        }
        addPopupView(viewControl3, spenMiniPenSettingLayoutInterface13.getColorPopupId());
        if (zNeedColorGroup) {
            SpenPenMiniViewControl viewControl4 = getViewControl(ControlType.PATTERN);
            SpenMiniPenSettingLayoutInterface spenMiniPenSettingLayoutInterface14 = this.mCurrentLayoutHelper;
            if (spenMiniPenSettingLayoutInterface14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentLayoutHelper");
            } else {
                spenMiniPenSettingLayoutInterface2 = spenMiniPenSettingLayoutInterface14;
            }
            addPopupView(viewControl4, spenMiniPenSettingLayoutInterface2.getPatternPopupId());
        }
    }

    private final void initParent() {
        this.mParent.setLayoutInterface(SpenMiniSettingLayoutFactory.createPopupLayoutHelper(getMOrientation()));
        addHeader(this.mContext, this.mParent);
        addFooter(this.mContext, this.mParent);
        initTransition();
    }

    private final void initTransition() {
        TransitionSet transitionSet = new TransitionSet();
        this.mMiniHomeTransition = transitionSet;
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new Fade(2).setDuration(150L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15))).addTransition(new ChangeBounds().setDuration(400L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(11))).addTransition(new Fade(1).setDuration(150L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)));
        transitionSet.addListener(new Transition.TransitionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenPenMiniLayoutControl$initTransition$1$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                Log.i("SpenPenMiniLayoutControl", "onTransitionEnd()");
                SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.this$0;
                spenPenMiniLayoutControl.setEnvironment(spenPenMiniLayoutControl.mViewMode, false);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mColorItemClickListener$lambda$1(SpenPenMiniLayoutControl spenPenMiniLayoutControl, View view) {
        if (spenPenMiniLayoutControl.mColorGroup == null) {
            return;
        }
        spenPenMiniLayoutControl.changeMode(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFooterButtonClickListener$lambda$0(SpenPenMiniLayoutControl spenPenMiniLayoutControl, View view) {
        OnButtonClickListener onButtonClickListener;
        SpenMiniCloseButton spenMiniCloseButton = spenPenMiniLayoutControl.mFooterButton;
        if (spenMiniCloseButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterButton");
            spenMiniCloseButton = null;
        }
        SpenMiniCloseButton.Type buttonType = spenMiniCloseButton.getMButtonType();
        int i = buttonType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[buttonType.ordinal()];
        if (i == 1) {
            spenPenMiniLayoutControl.changeMode(1);
        } else if (i == 2 && (onButtonClickListener = spenPenMiniLayoutControl.mButtonClickListener) != null) {
            onButtonClickListener.onCloseButtonClicked();
        }
    }

    private final View makeItemView(ControlType type, View.OnClickListener listener) {
        SpenPenMiniViewControl viewControl = getViewControl(type);
        if (viewControl == null) {
            return null;
        }
        return viewControl.getNormalView(listener);
    }

    private final boolean needColorGroup() {
        return (getViewControl(ControlType.COLOR) == null || getViewControl(ControlType.PATTERN) == null) ? false : true;
    }

    private final void notifyModeChanged(int mode) {
        OnViewModeChangedListener onViewModeChangedListener = this.mViewModeChangedListener;
        if (onViewModeChangedListener != null) {
            onViewModeChangedListener.onViewModeChanged(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEnvironment(int mode, boolean needAnimation) {
        int i;
        SpenMiniCloseButton.Type type = SpenMiniCloseButton.Type.CLOSE;
        SpenMiniCloseButton spenMiniCloseButton = null;
        if (mode != 1) {
            type = SpenMiniCloseButton.Type.BACK;
            SpenMiniCloseButton spenMiniCloseButton2 = this.mFooterButton;
            if (spenMiniCloseButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterButton");
                spenMiniCloseButton2 = null;
            }
            SpenSettingUtilAccessibility.requestAccessibilityFocus(spenMiniCloseButton2);
            i = 8;
        } else {
            i = 0;
        }
        SpenMiniCloseButton spenMiniCloseButton3 = this.mFooterButton;
        if (spenMiniCloseButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterButton");
        } else {
            spenMiniCloseButton = spenMiniCloseButton3;
        }
        spenMiniCloseButton.setButtonType(type, needAnimation);
        SpenPopupMiniLayout spenPopupMiniLayout = this.mParent;
        spenPopupMiniLayout.setHeaderDividerEnabled(false);
        spenPopupMiniLayout.setFooterTopToBottom(getPopupId(mode));
        spenPopupMiniLayout.setContentVisibility(i);
        spenPopupMiniLayout.setHeaderGroupVisibility(i);
    }

    private final void setHeaderTooltip(boolean enable) {
        ImageView imageView = this.mHeaderButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderButton");
            imageView = null;
        }
        SpenSettingUtilHover.setHoverText(imageView, enable ? this.mHeaderString : null);
    }

    private final void setViewOrientation() {
        if (this.mIsInitialized) {
            int orientation = getMOrientation();
            Iterator<SpenPenMiniViewControl> it = this.mViewControl.values().iterator();
            while (it.hasNext()) {
                it.next().setViewOrientation(orientation);
            }
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mPatternView = null;
        this.mColorView = null;
        this.mColorGroup = null;
        this.mViewControl.clear();
        this.mViewModeChangedListener = null;
        this.mChangeFavoriteButtonClickListener = null;
        this.mButtonClickListener = null;
        this.mHeaderString = null;
        this.mIsInitialized = false;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper
    /* JADX INFO: renamed from: getOrientation */
    public int getMOrientation() {
        return super.getMOrientation();
    }

    public final void restoreViewState() {
        Log.i(TAG, "restoreViewState()");
        if (this.mIsInitialized) {
            Iterator<SpenPenMiniViewControl> it = this.mViewControl.values().iterator();
            while (it.hasNext()) {
                it.next().restoreViewState();
            }
        }
    }

    public final void saveViewState() {
        Log.i(TAG, "saveViewState()");
        if (this.mIsInitialized) {
            Iterator<SpenPenMiniViewControl> it = this.mViewControl.values().iterator();
            while (it.hasNext()) {
                it.next().saveViewState();
            }
        }
    }

    public final void setChangeFavoriteButton(@Nullable View.OnClickListener listener) {
        this.mChangeFavoriteButtonClickListener = listener;
    }

    public final void setContent(@NotNull SpenPenMiniViewControl penInterface, @NotNull SpenPenMiniViewControl attributeInterface, @NotNull SpenPenMiniViewControl colorInterface, @Nullable SpenPenMiniViewControl patternInterface) {
        Intrinsics.checkNotNullParameter(penInterface, "penInterface");
        Intrinsics.checkNotNullParameter(attributeInterface, "attributeInterface");
        Intrinsics.checkNotNullParameter(colorInterface, "colorInterface");
        this.mViewControl.put(ControlType.PEN, penInterface);
        this.mViewControl.put(ControlType.ATTRIBUTE, attributeInterface);
        this.mViewControl.put(ControlType.COLOR, colorInterface);
        if (patternInterface != null) {
            this.mViewControl.put(ControlType.PATTERN, patternInterface);
        }
        this.mIsInitialized = true;
        initLayout();
    }

    public final void setOnButtonClickListener(@Nullable OnButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    public final void setOnViewModeChangedListener(@Nullable OnViewModeChangedListener listener) {
        this.mViewModeChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfigHelper
    public void setOrientation(int i) {
        AbstractC2322a.m1631u(i, "setOrientation() orientation=", TAG);
        if (this.mIsInitialized && getMOrientation() == i) {
            return;
        }
        setOrientation(i, false);
    }

    public final void setPatternVisibility(boolean isVisible) {
        AbstractC4539a.m3208r("setPatternViewVisibility() isVisible=", TAG, isVisible);
        if (getViewControl(ControlType.PATTERN) == null) {
            return;
        }
        if (isVisible) {
            View view = this.mPatternView;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.mColorView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else {
            View view3 = this.mColorView;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this.mPatternView;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        if (isVisible && this.mViewMode == 8) {
            changeMode(16);
        } else {
            if (isVisible || this.mViewMode != 16) {
                return;
            }
            changeMode(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean setViewMode(int viewMode, boolean needAnimation) {
        int i;
        int i2;
        int i4;
        int i5;
        if (viewMode != 1) {
            i = 2;
            if (viewMode != 2) {
                if (viewMode == 4) {
                    i4 = 1;
                    i5 = 1;
                    i2 = 2;
                } else {
                    if (viewMode != 8) {
                        if (viewMode != 16) {
                            return false;
                        }
                        i2 = 1;
                        i4 = 1;
                        i5 = 2;
                        i = 1;
                        this.mViewMode = viewMode;
                        if (needAnimation) {
                            SpenPopupMiniLayout spenPopupMiniLayout = this.mParent;
                            TransitionSet transitionSet = this.mMiniHomeTransition;
                            if (transitionSet == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mMiniHomeTransition");
                                transitionSet = null;
                            }
                            TransitionManager.beginDelayedTransition(spenPopupMiniLayout, transitionSet);
                        }
                        boolean z = viewMode == 1;
                        setViewMode(ControlType.PEN, i, needAnimation, z);
                        setViewMode(ControlType.ATTRIBUTE, i2, needAnimation, z);
                        setViewMode(ControlType.COLOR, i4, needAnimation, z);
                        setViewMode(ControlType.PATTERN, i5, needAnimation, z);
                        setHeaderTooltip(z);
                        setEnvironment(viewMode, needAnimation);
                        return true;
                    }
                    i2 = 1;
                    i5 = 1;
                    i4 = 2;
                }
                i = i5;
                this.mViewMode = viewMode;
                if (needAnimation) {
                }
                if (viewMode == 1) {
                }
                setViewMode(ControlType.PEN, i, needAnimation, z);
                setViewMode(ControlType.ATTRIBUTE, i2, needAnimation, z);
                setViewMode(ControlType.COLOR, i4, needAnimation, z);
                setViewMode(ControlType.PATTERN, i5, needAnimation, z);
                setHeaderTooltip(z);
                setEnvironment(viewMode, needAnimation);
                return true;
            }
            i2 = 1;
        } else {
            i = 1;
            i2 = 1;
        }
        i4 = i2;
        i5 = i4;
        this.mViewMode = viewMode;
        if (needAnimation) {
        }
        if (viewMode == 1) {
        }
        setViewMode(ControlType.PEN, i, needAnimation, z);
        setViewMode(ControlType.ATTRIBUTE, i2, needAnimation, z);
        setViewMode(ControlType.COLOR, i4, needAnimation, z);
        setViewMode(ControlType.PATTERN, i5, needAnimation, z);
        setHeaderTooltip(z);
        setEnvironment(viewMode, needAnimation);
        return true;
    }

    public /* synthetic */ SpenPenMiniLayoutControl(Context context, SpenPopupMiniLayout spenPopupMiniLayout, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, spenPopupMiniLayout, (i2 & 4) != 0 ? 1 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpenPenMiniLayoutControl(@NotNull Context context, @NotNull SpenPopupMiniLayout popupLayout, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(popupLayout, "popupLayout");
        this.mContext = context;
        this.mParent = popupLayout;
        this.mFooterButtonClickListener = new ViewOnClickListenerC7572e(this, 0);
        this.mColorItemClickListener = new ViewOnClickListenerC7572e(this, 1);
        this.mHeaderString = context.getResources().getString(C7932R.string.pen_string_favorite_pens);
        this.mIsInitialized = false;
        this.mButtonEnableColor = SpenSettingUtil.getColor(this.mContext, C7932R.color.setting_handwriting_icon_enable_color);
        this.mButtonDimColor = SpenSettingUtil.getColor(this.mContext, C7932R.color.mini_setting_background_dimmed_color);
        this.mViewControl = new EnumMap<>(ControlType.class);
        initTransition();
        setOrientation(i, false);
    }

    private final void setViewMode(ControlType type, int expectedMode, boolean animation, boolean supportHomeTooltip) {
        SpenPenMiniViewControl viewControl = getViewControl(type);
        if (viewControl == null) {
            return;
        }
        if (viewControl.getMViewMode() != expectedMode) {
            viewControl.setViewMode(expectedMode, animation);
        }
        viewControl.setNormalViewTooltip(supportHomeTooltip);
    }

    private final void setOrientation(int orientation, boolean animation) {
        AbstractC6670b.m4754o("setOrientation(", orientation, "), initialized=", this.mIsInitialized, TAG);
        super.setOrientation(orientation);
        clearView();
        this.mColorGroup = null;
        this.mColorView = null;
        this.mPatternView = null;
        if (animation) {
            TransitionManager.beginDelayedTransition(this.mParent, new ChangeBounds());
        }
        initParent();
        if (this.mIsInitialized) {
            initLayout();
            setViewMode(this.mViewMode, false);
        }
    }
}
