package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.SpenMiniPenAttributeControl;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0006\u0010,\u001a\u00020\u001eJ\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0005J\u0016\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007J\u000e\u00102\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0007J\u0016\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\tJ\u0010\u00106\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010\u0014J\u001e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tJ\u0010\u0010;\u001a\u00020\u001e2\b\u00107\u001a\u0004\u0018\u00010\u0016J\u0018\u0010<\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u0018\u0010=\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0002J\u0010\u0010>\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0007H\u0002J\u0010\u0010?\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0007H\u0002J\u0018\u0010@\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\f2\u0006\u0010A\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\tH\u0002J \u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniViewControl;", "<init>", "()V", "mContext", "Landroid/content/Context;", "mViewMode", "", "mInitComplete", "", "mOpacityColor", "mItemString", "", "mAttrItem", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "mItemGroup", "Landroid/widget/FrameLayout;", "mAttrPopup", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnDataChangedListener;", "mSliderListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnSliderListener;", "mIsVisibleAlpha", "mIsVisibleWidth", "mPopupMode", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$Mode;", "mAttrDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnDataChangedListener;", "setViewMode", "", "viewMode", "needAnimation", "getViewMode", "getNormalView", "Landroid/view/View;", "itemClickListener", "Landroid/view/View$OnClickListener;", "getPopupView", "setNormalViewTooltip", "enable", "saveViewState", "clearView", "restoreViewState", "close", "initView", "context", "setSizeLevel", "sizeLevel", "color", "setOpacity", "setPenWidth", "penName", "fixedWidth", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAttributeVisibility", "alphaVisible", "widthVisible", "setSliderListener", "updateItemSizeLevel", "updatePopupSizeLevel", "updateItemOpacity", "updatePopupOpacity", "updatePopupWidth", "isFixedWidth", "setItemAttribute", "setPopupAttributeVisibility", "opacityVisibility", "widthVisibility", "Companion", "OnDataChangedListener", "OnSliderListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenMiniPenAttributeControl extends SpenPenMiniViewControl {

    @NotNull
    private static final String TAG = "SpenMiniPenAttributeControl";

    @Nullable
    private SpenPenAttrMiniView mAttrItem;

    @Nullable
    private SpenPenAttrMiniLayout mAttrPopup;
    private Context mContext;

    @Nullable
    private OnDataChangedListener mDataChangedListener;
    private boolean mInitComplete;
    private boolean mIsVisibleAlpha;
    private boolean mIsVisibleWidth;

    @Nullable
    private FrameLayout mItemGroup;

    @Nullable
    private String mItemString;

    @Nullable
    private SpenPenAttrMiniLayout.Mode mPopupMode;

    @Nullable
    private OnSliderListener mSliderListener;
    private int mViewMode;
    private int mOpacityColor = -16777216;

    @NotNull
    private final SpenPenAttrMiniLayout.OnDataChangedListener mAttrDataChangedListener = new SpenPenAttrMiniLayout.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenMiniPenAttributeControl$mAttrDataChangedListener$1
        @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
        public void onAlphaChanged(int alpha) {
            if (this.this$0.mAttrItem != null) {
                SpenMiniPenAttributeControl spenMiniPenAttributeControl = this.this$0;
                spenMiniPenAttributeControl.mOpacityColor = SpenSettingUtilOpacity.setCurrentAlpha(spenMiniPenAttributeControl.mOpacityColor, alpha);
                SpenPenAttrMiniView spenPenAttrMiniView = this.this$0.mAttrItem;
                if (spenPenAttrMiniView != null) {
                    spenPenAttrMiniView.setColor(this.this$0.mOpacityColor);
                }
            }
            SpenMiniPenAttributeControl.OnDataChangedListener onDataChangedListener = this.this$0.mDataChangedListener;
            if (onDataChangedListener != null) {
                onDataChangedListener.onAlphaChanged(alpha);
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
        public void onFixedWidthChanged(boolean isFixedWidth) {
            SpenMiniPenAttributeControl.OnDataChangedListener onDataChangedListener = this.this$0.mDataChangedListener;
            if (onDataChangedListener != null) {
                onDataChangedListener.onFixedWidthChanged(isFixedWidth);
            }
        }

        @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
        public void onSizeChanged(int sizeLevel) {
            SpenPenAttrMiniView spenPenAttrMiniView = this.this$0.mAttrItem;
            if (spenPenAttrMiniView != null) {
                spenPenAttrMiniView.setSizeLevel(sizeLevel);
            }
            SpenMiniPenAttributeControl.OnDataChangedListener onDataChangedListener = this.this$0.mDataChangedListener;
            if (onDataChangedListener != null) {
                onDataChangedListener.onSizeChanged(sizeLevel);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnDataChangedListener;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnDataChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener extends SpenPenAttrMiniLayout.OnDataChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnSliderListener;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniLayout$OnSliderListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderListener extends SpenPenAttrMiniLayout.OnSliderListener {
    }

    private final void setItemAttribute(boolean alphaVisible) {
        if (alphaVisible) {
            SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
            if (spenPenAttrMiniView != null) {
                SpenPenAttrMiniView.setDynamicColorBackground$default(spenPenAttrMiniView, C7932R.drawable.blank_stroke_dot_detail, C7932R.drawable.setting_mini_attr_bg, false, 0, 12, null);
                return;
            }
            return;
        }
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
        if (spenPenAttrMiniView2 != null) {
            spenPenAttrMiniView2.setColorBackground(C7932R.drawable.setting_mini_attr_bg);
        }
    }

    private final void setPopupAttributeVisibility(int opacityVisibility, int widthVisibility, boolean needAnimation) {
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout != null) {
            spenPenAttrMiniLayout.setAttributeVisibility(opacityVisibility, widthVisibility, needAnimation);
        }
    }

    private final void updateItemOpacity(int color) {
        SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
        if (spenPenAttrMiniView != null) {
            spenPenAttrMiniView.setColor(color);
        }
    }

    private final void updateItemSizeLevel(int sizeLevel, int color) {
        SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
        if (spenPenAttrMiniView != null) {
            spenPenAttrMiniView.setSizeLevel(sizeLevel);
        }
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
        if (spenPenAttrMiniView2 != null) {
            spenPenAttrMiniView2.setColor(color);
        }
    }

    private final void updatePopupOpacity(int color) {
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout != null) {
            spenPenAttrMiniLayout.setOpacity(color);
        }
    }

    private final void updatePopupSizeLevel(int sizeLevel, int color) {
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout != null) {
            spenPenAttrMiniLayout.setSizeLevel(sizeLevel, SpenSettingUtilOpacity.setCurrentAlpha(color, 255));
        }
    }

    private final void updatePopupWidth(String penName, boolean isFixedWidth) {
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout != null) {
            spenPenAttrMiniLayout.setPenWidth(penName, isFixedWidth);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void clearView() {
        this.mItemGroup = null;
        SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
        if (spenPenAttrMiniView != null) {
            spenPenAttrMiniView.close();
        }
        this.mAttrItem = null;
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout != null) {
            spenPenAttrMiniLayout.close();
        }
        this.mAttrPopup = null;
    }

    public final void close() {
        if (this.mInitComplete) {
            this.mSliderListener = null;
            this.mDataChangedListener = null;
            clearView();
            this.mItemString = null;
            this.mInitComplete = false;
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getNormalView(@Nullable View.OnClickListener itemClickListener) {
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mItemGroup == null) {
            Context context = this.mContext;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context = null;
            }
            this.mItemGroup = new FrameLayout(context);
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                context2 = null;
            }
            Object systemService = context2.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(C7932R.layout.setting_mini_home_attr, (ViewGroup) this.mItemGroup, false);
            SpenPenAttrMiniView spenPenAttrMiniView = viewInflate instanceof SpenPenAttrMiniView ? (SpenPenAttrMiniView) viewInflate : null;
            this.mAttrItem = spenPenAttrMiniView;
            if (spenPenAttrMiniView != null) {
                spenPenAttrMiniView.setOnClickListener(itemClickListener);
                setNormalViewTooltip(true);
                spenPenAttrMiniView.setContentDescription(this.mItemString);
                FrameLayout frameLayout = this.mItemGroup;
                if (frameLayout != null) {
                    frameLayout.addView(spenPenAttrMiniView);
                }
            }
        }
        return this.mItemGroup;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    @Nullable
    public View getPopupView() {
        SpenPenAttrMiniLayout spenPenAttrMiniLayout;
        Context context = null;
        if (!this.mInitComplete) {
            return null;
        }
        if (this.mAttrPopup == null) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            SpenPenAttrMiniLayout spenPenAttrMiniLayout2 = new SpenPenAttrMiniLayout(context, getMViewOrientation());
            this.mAttrPopup = spenPenAttrMiniLayout2;
            spenPenAttrMiniLayout2.setDataChangedListener(this.mAttrDataChangedListener);
            OnSliderListener onSliderListener = this.mSliderListener;
            if (onSliderListener != null && (spenPenAttrMiniLayout = this.mAttrPopup) != null) {
                spenPenAttrMiniLayout.setSliderListener(onSliderListener);
            }
        }
        return this.mAttrPopup;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    /* JADX INFO: renamed from: getViewMode, reason: from getter */
    public int getMViewMode() {
        return this.mViewMode;
    }

    public final void initView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mItemString = context.getResources().getString(C7932R.string.pen_string_pen_thickness);
        this.mInitComplete = true;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void restoreViewState() {
        if (getMHasRestoreState()) {
            SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
            if (spenPenAttrMiniLayout != null) {
                SpenPenAttrMiniLayout.Mode mode = this.mPopupMode;
                Intrinsics.checkNotNull(mode);
                spenPenAttrMiniLayout.setMode(mode);
            }
            setAttributeVisibility(this.mIsVisibleAlpha, this.mIsVisibleWidth, false);
            setRestoreState(false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewControl
    public void saveViewState() {
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout == null) {
            setRestoreState(false);
        } else {
            this.mPopupMode = spenPenAttrMiniLayout != null ? spenPenAttrMiniLayout.getMCurrentMode() : null;
            setRestoreState(true);
        }
    }

    public final void setAttributeVisibility(boolean alphaVisible, boolean widthVisible, boolean needAnimation) {
        if (this.mInitComplete) {
            int i = alphaVisible ? 0 : 8;
            int i2 = widthVisible ? 0 : 8;
            if (getMViewMode() == 1) {
                setItemAttribute(alphaVisible);
                setPopupAttributeVisibility(i, i2, false);
            } else {
                setPopupAttributeVisibility(i, i2, needAnimation);
                setItemAttribute(alphaVisible);
            }
            this.mIsVisibleAlpha = alphaVisible;
            this.mIsVisibleWidth = widthVisible;
        }
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setNormalViewTooltip(boolean enable) {
        SpenPenAttrMiniView spenPenAttrMiniView = this.mAttrItem;
        if (spenPenAttrMiniView != null) {
            SpenSettingUtilHover.setHoverText(spenPenAttrMiniView, enable ? this.mItemString : null);
        }
    }

    public final void setOpacity(int color) {
        this.mOpacityColor = color;
        if (getMViewMode() == 1) {
            updateItemOpacity(color);
            updatePopupOpacity(color);
        } else {
            updatePopupOpacity(color);
            updateItemOpacity(color);
        }
    }

    public final void setPenWidth(@NotNull String penName, boolean fixedWidth) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        updatePopupWidth(penName, fixedWidth);
    }

    public final void setSizeLevel(int sizeLevel, int color) {
        if (getMViewMode() == 1) {
            updateItemSizeLevel(sizeLevel, color);
            updatePopupSizeLevel(sizeLevel, color);
        } else {
            updatePopupSizeLevel(sizeLevel, color);
            updateItemSizeLevel(sizeLevel, color);
        }
    }

    public final void setSliderListener(@Nullable OnSliderListener listener) {
        if (this.mInitComplete) {
            this.mSliderListener = listener;
            SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
            if (spenPenAttrMiniLayout != null) {
                spenPenAttrMiniLayout.setSliderListener(listener);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniViewModeInterface
    public void setViewMode(int viewMode, boolean needAnimation) {
        AbstractC0000a.m27x(AbstractC0622a.m1173s(this.mViewMode, viewMode, "setViewMode() viewMode[", " -> ", "] InitComplete="), this.mInitComplete, TAG);
        if (!this.mInitComplete || this.mViewMode == viewMode) {
            return;
        }
        SpenPenAttrMiniLayout spenPenAttrMiniLayout = this.mAttrPopup;
        if (spenPenAttrMiniLayout != null) {
            spenPenAttrMiniLayout.setVisibility(viewMode == 2 ? 0 : 8);
        }
        this.mViewMode = viewMode;
    }
}
