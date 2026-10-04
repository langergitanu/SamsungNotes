package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnPaletteSwipeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorPaletteLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\"H\u0016J\b\u0010.\u001a\u00020\u001eH\u0016J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\n\u00103\u001a\u0004\u0018\u000100H\u0016J\u0010\u00104\u001a\u00020+2\u0006\u00105\u001a\u00020\"H\u0016J\b\u00106\u001a\u00020+H\u0016J\b\u00107\u001a\u00020+H\u0016J\b\u00108\u001a\u00020+H\u0016J\u0018\u00109\u001a\u00020+2\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020\u001eH\u0016J\u0012\u0010=\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010?\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020)H\u0016J\u0018\u0010B\u001a\u00020+2\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001dH\u0016J\u0012\u0010D\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\u0017H\u0016J\u0006\u0010E\u001a\u00020+J\u001e\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020\"2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020\"J\u0016\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020)J\u0010\u0010M\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u001eJ\u0010\u0010P\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010)J\u000e\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020\u001eJ\u0010\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020\"H\u0002J\b\u0010U\u001a\u00020\"H\u0002J\u0018\u0010V\u001a\u00020+2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010WH\u0002J\u0010\u0010X\u001a\u00020+2\u0006\u0010G\u001a\u00020\"H\u0002J\b\u0010^\u001a\u00020+H\u0002J\u0018\u0010_\u001a\u00020+2\u0006\u0010L\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020)H\u0002J\b\u0010`\u001a\u00020+H\u0002J\b\u0010a\u001a\u00020+H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010[R\u0014\u0010b\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bc\u0010[R\u0016\u0010d\u001a\u0004\u0018\u00010e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010g¨\u0006i"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniColorControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenSettingUI;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mItemString", "", "mBgDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "mNormalView", "Landroid/widget/FrameLayout;", "mColorItem", "Landroid/widget/ImageView;", "mColorPopup", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorPaletteLayout;", "mPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteActionListener;", "mRecentColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenRecentColorChangedListener;", "mPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "mColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangeListener;", "mPaletteIDs", "", "", "mRecentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "mIsSupportEyedropper", "", "mViewMode", "mInitComplete", "mIsShownFirstPopup", "mCurrentColorUIInfo", "mCurrentPaletteID", "mCurrentHSVColor", "", "setViewMode", "", "viewMode", "needAnimation", "getViewMode", "getNormalView", "Landroid/view/View;", "itemClickListener", "Landroid/view/View$OnClickListener;", "getPopupView", "setNormalViewTooltip", "enable", "saveViewState", "clearView", "restoreViewState", "setPalette", "paletteList", "setCurrentPalette", "paletteID", "setPaletteActionButtonListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPaletteActionListener", "addRecentColor", "hsvColor", "setRecentColor", "recentList", "setRecentColorChangedListener", "close", "initView", "isSupportEyedropper", "palettes", "setEyedropperEnabled", "enabled", "setColor", "uiPenInfo", "setOnColorChangeListener", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setPickerColor", "setEyedropperColor", "color", "initData", "isStarted", "isThePopupReady", "initFirstPopup", "", "initPopupView", "popupLayoutId", "getPopupLayoutId", "()I", "itemId", "getItemId", "initItemView", "setColorData", "updateColorItem", "updateColorPopup", "currentVisibleColor", "getCurrentVisibleColor", "popupDrawable", "Landroid/graphics/drawable/Drawable;", "getPopupDrawable", "()Landroid/graphics/drawable/Drawable;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMiniColorControl extends SpenPenMiniViewControl implements SpenPenSettingUI {
    private static final int DEFAULT_COLOR = -16777216;

    @NotNull
    private static final String TAG = "SpenMiniColorControl";
    private static final boolean USE_CIRCLE_PALETTE = true;

    @Nullable
    private SpenGradientDrawableHelper mBgDrawableHelper;

    @Nullable
    private OnColorChangeListener mColorChangedListener;

    @Nullable
    private ImageView mColorItem;

    @Nullable
    private SpenColorPaletteLayout mColorPopup;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;

    @Nullable
    private Context mContext;
    private int mCurrentColorUIInfo;

    @NotNull
    private final float[] mCurrentHSVColor;
    private int mCurrentPaletteID;
    private boolean mInitComplete;
    private boolean mIsShownFirstPopup;
    private boolean mIsSupportEyedropper;

    @Nullable
    private String mItemString;

    @Nullable
    private FrameLayout mNormalView;

    @Nullable
    private OnActionButtonListener mPaletteActionButtonListener;

    @Nullable
    private SpenPaletteActionListener mPaletteActionListener;

    @Nullable
    private List<Integer> mPaletteIDs;

    @Nullable
    private SpenRecentColorChangedListener mRecentColorChangedListener;

    @Nullable
    private List<SpenHSVColor> mRecentColors;
    private int mViewMode;

    public SpenMiniColorControl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mCurrentHSVColor = new float[]{0.0f, 0.0f, 0.0f};
        this.mContext = context;
        this.mCurrentColorUIInfo = 0;
        this.mItemString = context.getResources().getString(C7932R.string.pen_string_pen_color);
        initData(true);
    }

    private final int getCurrentVisibleColor() {
        return this.mColorThemeUtil.getColor(SpenSettingUtil.HSVToColor(255, this.mCurrentHSVColor));
    }

    private final int getItemId() {
        return getMViewOrientation() == 0 ? C7932R.layout.setting_pen_color_attr_mini_land_layout : C7932R.layout.setting_pen_color_attr_mini_layout;
    }

    private final Drawable getPopupDrawable() {
        float f;
        float f4;
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        Intrinsics.checkNotNull(context);
        float dimensionPixelOffset = context.getResources().getDimensionPixelOffset(C7932R.dimen.mini_pen_sub_popup_radius);
        float f5 = 0.0f;
        if (getMViewOrientation() == 1) {
            f4 = 0.0f;
            f = 0.0f;
            f5 = dimensionPixelOffset;
        } else {
            Context context2 = this.mContext;
            Intrinsics.checkNotNull(context2);
            if (context2.getResources().getConfiguration().getLayoutDirection() == 1) {
                f4 = dimensionPixelOffset;
                f = 0.0f;
                f5 = f4;
                dimensionPixelOffset = 0.0f;
            } else {
                f = dimensionPixelOffset;
                f4 = 0.0f;
            }
        }
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        spenGradientDrawableHelper.setDrawableInfo(0, SpenSettingUtil.getColor(this.mContext, C7932R.color.mini_setting_sub_popup_bg), 0, 0);
        spenGradientDrawableHelper.setRectRadius(dimensionPixelOffset, f5, f4, f);
        return spenGradientDrawableHelper.makeDrawable();
    }

    private final int getPopupLayoutId() {
        return getMViewOrientation() == 0 ? C7932R.layout.setting_mini_color_circle_land_layout : C7932R.layout.setting_mini_color_circle_layout;
    }

    private final void initData(boolean isStarted) {
        this.mCurrentPaletteID = -1;
        this.mIsSupportEyedropper = false;
        if (isStarted) {
            this.mPaletteIDs = new ArrayList();
            this.mRecentColors = new ArrayList();
        } else {
            this.mPaletteIDs = null;
            this.mRecentColors = null;
        }
    }

    private final void initFirstPopup(List<Integer> palettes) {
        if (this.mContext == null || this.mColorPopup == null || this.mIsShownFirstPopup) {
            return;
        }
        Log.i(TAG, "initFirstPopup()");
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.setColorTheme(this.mColorThemeUtil.getColorTheme());
            if (palettes != null) {
                spenColorPaletteLayout.setPaletteList(palettes);
            }
            spenColorPaletteLayout.setRecentColor(this.mRecentColors);
        }
        this.mIsShownFirstPopup = true;
        updateColorPopup();
    }

    private final void initItemView() {
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        Intrinsics.checkNotNull(context);
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(getItemId(), (ViewGroup) null);
        FrameLayout frameLayout = viewInflate instanceof FrameLayout ? (FrameLayout) viewInflate : null;
        this.mNormalView = frameLayout;
        ImageView imageView = frameLayout != null ? (ImageView) frameLayout.findViewById(C7932R.id.color_item) : null;
        this.mColorItem = imageView;
        SpenSettingUtilHover.setHoverText(imageView, this.mItemString);
        ImageView imageView2 = this.mColorItem;
        if (imageView2 != null) {
            imageView2.setContentDescription(this.mItemString);
        }
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(C7932R.dimen.setting_color_rect_chip_unselected_outline_size);
        int color = SpenSettingUtil.getColor(this.mContext, C7932R.color.setting_color_rect_chip_unselected_outline_color);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        this.mBgDrawableHelper = spenGradientDrawableHelper;
        spenGradientDrawableHelper.setDrawableInfo(1, -16777216, dimensionPixelSize, color);
        ImageView imageView3 = this.mColorItem;
        if (imageView3 != null) {
            SpenGradientDrawableHelper spenGradientDrawableHelper2 = this.mBgDrawableHelper;
            imageView3.setImageDrawable(spenGradientDrawableHelper2 != null ? spenGradientDrawableHelper2.makeDrawable() : null);
        }
    }

    private final void initPopupView(boolean isSupportEyedropper) {
        if (this.mContext == null) {
            return;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        SpenColorPaletteLayout spenColorPaletteLayout = new SpenColorPaletteLayout(context, null, isSupportEyedropper, getPopupLayoutId(), true);
        this.mColorPopup = spenColorPaletteLayout;
        spenColorPaletteLayout.setBackground(getPopupDrawable());
        spenColorPaletteLayout.setOnColorChangeListener(new OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniColorControl$initPopupView$1$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                System.arraycopy(hsvColor, 0, this.this$0.mCurrentHSVColor, 0, 3);
                this.this$0.mCurrentColorUIInfo = info;
                this.this$0.updateColorItem();
                OnColorChangeListener onColorChangeListener = this.this$0.mColorChangedListener;
                if (onColorChangeListener != null) {
                    onColorChangeListener.onColorChanged(info, hsvColor);
                }
            }
        });
        spenColorPaletteLayout.setOnPaletteSwipeListener(new OnPaletteSwipeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniColorControl$initPopupView$1$2
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnPaletteSwipeListener
            public void onPaletteSwipe(int direction, int id) {
                SpenPaletteActionListener spenPaletteActionListener = this.this$0.mPaletteActionListener;
                if (spenPaletteActionListener != null) {
                    spenPaletteActionListener.onPageChanged(id);
                }
            }
        });
        spenColorPaletteLayout.setOnActionButtonListener(new OnActionButtonListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniColorControl$initPopupView$1$3
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
            public void onButtonClick(int type) {
                OnActionButtonListener onActionButtonListener = this.this$0.mPaletteActionButtonListener;
                if (onActionButtonListener != null) {
                    onActionButtonListener.onButtonClick(type);
                }
            }
        });
    }

    /* JADX INFO: renamed from: isThePopupReady, reason: from getter */
    private final boolean getMIsShownFirstPopup() {
        return this.mIsShownFirstPopup;
    }

    private final void setColorData(int uiPenInfo, float[] hsvColor) {
        System.arraycopy(hsvColor, 0, this.mCurrentHSVColor, 0, 3);
        this.mCurrentColorUIInfo = uiPenInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateColorItem() {
        Drawable drawable;
        ImageView imageView = this.mColorItem;
        if (imageView == null || imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        int currentVisibleColor = getCurrentVisibleColor();
        SpenGradientDrawableHelper.INSTANCE.setColor(drawable, currentVisibleColor);
        SpenGradientDrawableHelper spenGradientDrawableHelper = this.mBgDrawableHelper;
        if (spenGradientDrawableHelper != null) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            spenGradientDrawableHelper.setStroke(drawable, SpenSettingUtil.isAdaptiveColor(context, currentVisibleColor));
        }
    }

    private final void updateColorPopup() {
        SpenColorPaletteLayout spenColorPaletteLayout;
        if (getMIsShownFirstPopup() && (spenColorPaletteLayout = this.mColorPopup) != null) {
            spenColorPaletteLayout.setColor(this.mCurrentColorUIInfo, this.mCurrentHSVColor);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void addRecentColor(@NotNull float[] hsvColor) {
        SpenRecentColorChangedListener spenRecentColorChangedListener;
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout == null || !spenColorPaletteLayout.addRecentColor(hsvColor) || (spenRecentColorChangedListener = this.mRecentColorChangedListener) == null) {
            return;
        }
        spenRecentColorChangedListener.onRecentColorChanged(spenColorPaletteLayout.getRecentColor());
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void clearView() {
        Log.i(TAG, "clearView()");
        this.mColorItem = null;
        this.mNormalView = null;
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.close();
        }
        this.mColorPopup = null;
        this.mIsShownFirstPopup = false;
    }

    public final void close() {
        this.mContext = null;
        this.mColorThemeUtil.close();
        this.mItemString = null;
        this.mViewMode = 0;
        if (this.mInitComplete) {
            clearView();
            initData(false);
            this.mBgDrawableHelper = null;
            this.mInitComplete = false;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getNormalView(@Nullable View.OnClickListener itemClickListener) {
        ImageView imageView;
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mNormalView == null) {
            initItemView();
        }
        if (itemClickListener != null && (imageView = this.mColorItem) != null) {
            imageView.setOnClickListener(itemClickListener);
        }
        updateColorItem();
        return this.mNormalView;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getPopupView() {
        Log.i(TAG, "getPopupView() mInitComplete=" + this.mInitComplete + " currentMode=" + this.mViewMode);
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mColorPopup == null) {
            initPopupView(this.mIsSupportEyedropper);
        }
        if (this.mViewMode == 2 && !this.mIsShownFirstPopup) {
            initFirstPopup(this.mPaletteIDs);
        }
        return this.mColorPopup;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public int getMViewMode() {
        return this.mViewMode;
    }

    public final void initView(boolean isSupportEyedropper, @Nullable List<Integer> palettes) {
        this.mIsSupportEyedropper = isSupportEyedropper;
        setPalette(palettes);
        this.mInitComplete = true;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void restoreViewState() {
        if (getMHasRestoreState()) {
            SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
            if (spenColorPaletteLayout != null) {
                spenColorPaletteLayout.setPalette(this.mCurrentPaletteID);
            }
            setRestoreState(false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void saveViewState() {
        SpenColorPaletteLayout spenColorPaletteLayout;
        Log.i(TAG, "saveViewState()");
        if (this.mInitComplete && (spenColorPaletteLayout = this.mColorPopup) != null) {
            this.mCurrentPaletteID = spenColorPaletteLayout.getPalette();
            setRestoreState(true);
        }
    }

    public final void setColor(int uiPenInfo, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        setColorData(uiPenInfo, hsvColor);
        if (getMViewMode() == 1) {
            updateColorItem();
            updateColorPopup();
        } else {
            updateColorPopup();
            updateColorItem();
        }
    }

    public final void setColorTheme(int theme) {
        if (this.mColorThemeUtil.getColorTheme() != theme) {
            this.mColorThemeUtil.setColorTheme(theme);
            SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
            if (spenColorPaletteLayout != null) {
                spenColorPaletteLayout.setColorTheme(theme);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setCurrentPalette(int paletteID) {
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.setPalette(paletteID);
        }
    }

    public final void setEyedropperColor(int color) {
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.setEyedropperColor(color);
        }
    }

    public final void setEyedropperEnabled(boolean enabled) {
        if (this.mIsSupportEyedropper == enabled) {
            return;
        }
        this.mIsSupportEyedropper = enabled;
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.setEyedropperEnabled(enabled);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setNormalViewTooltip(boolean enable) {
        ImageView imageView = this.mColorItem;
        if (imageView != null) {
            SpenSettingUtilHover.setHoverText(imageView, enable ? this.mItemString : null);
        }
    }

    public final void setOnColorChangeListener(@Nullable OnColorChangeListener listener) {
        this.mColorChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPalette(@Nullable List<Integer> paletteList) {
        List<Integer> list;
        SpenColorPaletteLayout spenColorPaletteLayout;
        if (paletteList == null || (list = this.mPaletteIDs) == null) {
            return;
        }
        list.clear();
        list.addAll(paletteList);
        if (!getMIsShownFirstPopup() || (spenColorPaletteLayout = this.mColorPopup) == null) {
            return;
        }
        spenColorPaletteLayout.setPaletteList(paletteList);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        this.mPaletteActionButtonListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionListener(@Nullable SpenPaletteActionListener listener) {
        this.mPaletteActionListener = listener;
    }

    public final void setPickerColor(@Nullable float[] hsvColor) {
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
        if (spenColorPaletteLayout != null) {
            spenColorPaletteLayout.setPickerColor(hsvColor);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        SpenColorPaletteLayout spenColorPaletteLayout;
        List<SpenHSVColor> list = this.mRecentColors;
        if (list != null) {
            list.clear();
            if (recentList != null) {
                list.addAll(recentList);
            }
            if (!getMIsShownFirstPopup() || (spenColorPaletteLayout = this.mColorPopup) == null) {
                return;
            }
            spenColorPaletteLayout.setRecentColor(recentList);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColorChangedListener(@Nullable SpenRecentColorChangedListener listener) {
        this.mRecentColorChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setViewMode(int viewMode, boolean needAnimation) {
        AbstractC6670b.m4754o("setViewMode() viewMode=", viewMode, ", mInitComplete=", this.mInitComplete, TAG);
        if (this.mInitComplete && this.mViewMode != viewMode) {
            if (viewMode == 2 && !this.mIsShownFirstPopup) {
                initFirstPopup(this.mPaletteIDs);
            }
            SpenColorPaletteLayout spenColorPaletteLayout = this.mColorPopup;
            if (spenColorPaletteLayout != null) {
                spenColorPaletteLayout.setVisibility(viewMode == 2 ? 0 : 8);
            }
            SpenColorPaletteLayout spenColorPaletteLayout2 = this.mColorPopup;
            if (spenColorPaletteLayout2 != null) {
                spenColorPaletteLayout2.setFlipperEnabled(viewMode == 2);
            }
            this.mViewMode = viewMode;
        }
    }
}
