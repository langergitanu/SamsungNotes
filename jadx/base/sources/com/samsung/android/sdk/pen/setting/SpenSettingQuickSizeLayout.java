package com.samsung.android.sdk.pen.setting;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizePreview;
import com.samsung.android.sdk.pen.setting.handwriting.SpenQuickSizeView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 (2\u00020\u0001:\u0003()*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\rJ\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0015H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingQuickSizeLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSizeView", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "mSliderLabelListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingQuickSizeLayout$OnSliderLabelListener;", "mDisallowPreview", "", "mPreview", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenSizePreview;", "mSlider", "Landroid/view/View;", "mPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mSliderStartPos", "", "mSliderPadding", "mPreviewOffset", "close", "", "setSizeLevel", "sizeLevel", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenSettingQuickSizeLayout$OnDataChangedListener;", "setSliderLabelListener", "setPenInfo", "info", "setDisallowPreview", "disallowPreview", "construct", "initPreviewOffset", "setPreviewPosition", "value", "Companion", "OnDataChangedListener", "OnSliderLabelListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingQuickSizeLayout extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenSettingQuickSizeLayout";

    @Nullable
    private SpenConsumedListener mConsumedListener;
    private boolean mDisallowPreview;

    @Nullable
    private SpenSettingUIPenInfo mPenInfo;

    @Nullable
    private SpenPenSizePreview mPreview;
    private int mPreviewOffset;

    @Nullable
    private SpenQuickSizeView mSizeView;

    @Nullable
    private View mSlider;

    @Nullable
    private OnSliderLabelListener mSliderLabelListener;
    private int mSliderPadding;
    private int mSliderStartPos;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingQuickSizeLayout$OnDataChangedListener;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnDataChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener extends SpenQuickSizeView.OnDataChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingQuickSizeLayout$OnSliderLabelListener;", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenQuickSizeView$OnSliderListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderLabelListener extends SpenQuickSizeView.OnSliderListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQuickSizeLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        construct(context);
    }

    private final void construct(Context context) {
        this.mDisallowPreview = true;
        this.mSizeView = new SpenQuickSizeView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_quick_size_layout_top_margin);
        layoutParams.bottomMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_quick_size_layout_bottom_margin);
        layoutParams.leftMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_quick_size_layout_left_margin);
        layoutParams.rightMargin = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_quick_size_layout_right_margin);
        addView(this.mSizeView, layoutParams);
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        spenConsumedListener.setConsumedListener(this, this.mSizeView);
        setElevation(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_popup_bg_elevation));
        setBackgroundResource(C7932R.drawable.dialog_bg);
        setClipChildren(false);
        SpenSettingUtil.setShadowAlpha(this, 0.5f);
        SpenQuickSizeView spenQuickSizeView = this.mSizeView;
        if (spenQuickSizeView != null) {
            spenQuickSizeView.setSliderListener(new SpenQuickSizeView.OnSliderListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingQuickSizeLayout.construct.1
                @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenQuickSizeView.OnSliderListener
                public void onLabelChanged(String text) {
                    Intrinsics.checkNotNullParameter(text, "text");
                    if (!SpenSettingQuickSizeLayout.this.mDisallowPreview && SpenSettingQuickSizeLayout.this.mPreview != null) {
                        SpenPenSizePreview spenPenSizePreview = SpenSettingQuickSizeLayout.this.mPreview;
                        if (spenPenSizePreview != null) {
                            Integer numValueOf = Integer.valueOf(text);
                            Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(...)");
                            spenPenSizePreview.setSizeLevel(numValueOf.intValue());
                        }
                        SpenSettingQuickSizeLayout spenSettingQuickSizeLayout = SpenSettingQuickSizeLayout.this;
                        Integer numValueOf2 = Integer.valueOf(text);
                        Intrinsics.checkNotNullExpressionValue(numValueOf2, "valueOf(...)");
                        spenSettingQuickSizeLayout.setPreviewPosition(numValueOf2.intValue());
                    }
                    OnSliderLabelListener onSliderLabelListener = SpenSettingQuickSizeLayout.this.mSliderLabelListener;
                    if (onSliderLabelListener != null) {
                        onSliderLabelListener.onLabelChanged(text);
                    }
                }

                @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenQuickSizeView.OnSliderListener
                public void onLabelStateChanged(View slider, SpenQuickSizeView.OnSliderListener.LabelState state, String text) {
                    Intrinsics.checkNotNullParameter(text, "text");
                    if (!SpenSettingQuickSizeLayout.this.mDisallowPreview && SpenSettingQuickSizeLayout.this.mPreview != null) {
                        SpenQuickSizeView.OnSliderListener.LabelState labelState = SpenQuickSizeView.OnSliderListener.LabelState.SHOW;
                        if (state == labelState) {
                            SpenSettingQuickSizeLayout.this.mSlider = slider;
                            SpenSettingQuickSizeLayout.this.initPreviewOffset();
                            if (SpenSettingQuickSizeLayout.this.mPenInfo != null) {
                                SpenSettingUIPenInfo spenSettingUIPenInfo = SpenSettingQuickSizeLayout.this.mPenInfo;
                                if (spenSettingUIPenInfo != null) {
                                    spenSettingUIPenInfo.sizeLevel = Integer.valueOf(text).intValue();
                                }
                                SpenPenSizePreview spenPenSizePreview = SpenSettingQuickSizeLayout.this.mPreview;
                                if (spenPenSizePreview != null) {
                                    SpenSettingUIPenInfo spenSettingUIPenInfo2 = SpenSettingQuickSizeLayout.this.mPenInfo;
                                    Intrinsics.checkNotNull(spenSettingUIPenInfo2);
                                    spenPenSizePreview.setPenInfo(spenSettingUIPenInfo2);
                                }
                                SpenSettingQuickSizeLayout spenSettingQuickSizeLayout = SpenSettingQuickSizeLayout.this;
                                SpenSettingUIPenInfo spenSettingUIPenInfo3 = spenSettingQuickSizeLayout.mPenInfo;
                                Intrinsics.checkNotNull(spenSettingUIPenInfo3);
                                spenSettingQuickSizeLayout.setPreviewPosition(spenSettingUIPenInfo3.sizeLevel);
                            }
                        }
                        SpenPenSizePreview spenPenSizePreview2 = SpenSettingQuickSizeLayout.this.mPreview;
                        if (spenPenSizePreview2 != null) {
                            spenPenSizePreview2.setVisibility(state == labelState ? 0 : 8);
                        }
                    }
                    OnSliderLabelListener onSliderLabelListener = SpenSettingQuickSizeLayout.this.mSliderLabelListener;
                    if (onSliderLabelListener != null) {
                        onSliderLabelListener.onLabelStateChanged(slider, state, text);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPreviewOffset() {
        View view = this.mSlider;
        if (view == null || this.mPreview == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        int paddingLeft = view.getPaddingLeft();
        View view2 = this.mSlider;
        Intrinsics.checkNotNull(view2);
        this.mSliderPadding = view2.getPaddingRight() + paddingLeft;
        View view3 = this.mSlider;
        Intrinsics.checkNotNull(view3);
        int left = view3.getLeft();
        View view4 = this.mSlider;
        Intrinsics.checkNotNull(view4);
        this.mSliderStartPos = view4.getPaddingLeft() + left;
        SpenPenSizePreview spenPenSizePreview = this.mPreview;
        Intrinsics.checkNotNull(spenPenSizePreview);
        int width = (spenPenSizePreview.getWidth() / 2) * (-1);
        SpenQuickSizeView spenQuickSizeView = this.mSizeView;
        Intrinsics.checkNotNull(spenQuickSizeView);
        this.mPreviewOffset = spenQuickSizeView.getLeft() + width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreviewPosition(int value) {
        View view = this.mSlider;
        Intrinsics.checkNotNull(view);
        int width = view.getWidth() - this.mSliderPadding;
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            value = 100 - value;
        }
        int i = ((width * value) / 100) + this.mSliderStartPos;
        SpenPenSizePreview spenPenSizePreview = this.mPreview;
        if (spenPenSizePreview != null) {
            spenPenSizePreview.setX(i + this.mPreviewOffset);
        }
    }

    public final void close() {
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener == null) {
            return;
        }
        this.mSliderLabelListener = null;
        if (spenConsumedListener != null) {
            spenConsumedListener.close();
        }
        this.mConsumedListener = null;
        SpenQuickSizeView spenQuickSizeView = this.mSizeView;
        if (spenQuickSizeView != null) {
            spenQuickSizeView.close();
        }
        this.mSizeView = null;
        SpenPenSizePreview spenPenSizePreview = this.mPreview;
        if (spenPenSizePreview != null) {
            spenPenSizePreview.close();
        }
        this.mPreview = null;
        this.mSlider = null;
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        SpenQuickSizeView spenQuickSizeView = this.mSizeView;
        if (spenQuickSizeView != null) {
            spenQuickSizeView.setDataChangedListener(listener);
        }
    }

    public final void setDisallowPreview(boolean disallowPreview) {
        View view;
        this.mDisallowPreview = disallowPreview;
        if (disallowPreview || this.mPreview != null) {
            if (!disallowPreview || (view = this.mPreview) == null) {
                return;
            }
            removeView(view);
            SpenPenSizePreview spenPenSizePreview = this.mPreview;
            if (spenPenSizePreview != null) {
                spenPenSizePreview.close();
            }
            this.mPreview = null;
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.mPreview = new SpenPenSizePreview(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(C7932R.dimen.setting_quick_size_preview_top_margin);
        addView(this.mPreview, layoutParams);
        SpenPenSizePreview spenPenSizePreview2 = this.mPreview;
        if (spenPenSizePreview2 != null) {
            spenPenSizePreview2.setVisibility(4);
        }
    }

    public final void setPenInfo(@NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.mPenInfo = new SpenSettingUIPenInfo(info);
        setSizeLevel(info.sizeLevel);
    }

    public final void setSizeLevel(int sizeLevel) {
        SpenQuickSizeView spenQuickSizeView = this.mSizeView;
        if (spenQuickSizeView != null) {
            spenQuickSizeView.setSizeLevel(sizeLevel);
        }
    }

    public final void setSliderLabelListener(@Nullable OnSliderLabelListener listener) {
        this.mSliderLabelListener = listener;
    }
}
