package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b,\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001KB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0014H\u0016J(\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0014J\b\u0010(\u001a\u00020 H\u0016J\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0010\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\tJ\u000e\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u000fJ\u000e\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u000fJ*\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\b\b\u0002\u00108\u001a\u00020\u00142\b\b\u0002\u00109\u001a\u00020\u000fJ\u0018\u0010?\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u000fH\u0002J\b\u0010C\u001a\u00020 H\u0002J\u0010\u0010D\u001a\u00020 2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0018\u0010E\u001a\u00020 2\u0006\u0010F\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010G\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\u000fH\u0002J\u001a\u0010J\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010:\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000f8D@DX\u0084\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010<¨\u0006L"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mLabelFormat", "", "mLabelText", "Landroid/widget/TextView;", "mColorView", "Landroid/widget/ImageView;", "mValue", "", "mSelectedView", "Landroid/view/View;", "mColorBackground", "mApplyDynamicColorSize", "", "mDiffColorRadius", "mSizeLevel", "mDefaultMargin", "mColor", "mNormalResId", "mFullResId", "mCurrentResId", "mUseNormalBackgroundTint", "mNormalBackgroundTintColor", "mUserDefineChildLayoutId", "onFinishInflate", "", "setSelected", "selected", "onSizeChanged", "w", "h", "oldw", "oldh", "close", "setValue", "value", "setColor", "color", "setLabelFormat", "format", "setLabelVisibility", "visibility", "setSizeLevel", "sizeLevel", "setColorBackground", "resId", "setDynamicColorBackground", "normalId", "fullResId", "useNormalTintColor", "normalTintColor", "userDefineChildLayout", "getUserDefineChildLayout", "()I", "setUserDefineChildLayout", "(I)V", "initView", "layoutResource", "inflateChildId", "getInflateChildId", "adjustBackground", "setInnerColorBackground", "setInnerColorBackgroundTint", "enable", "updateLabelText", "updateColorSize", "level", "setAttributes", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenPenAttrMiniView extends FrameLayout {
    private static final int SHOW_TEXT_DURATION = 200;

    @NotNull
    private static final String TAG = "SpenPenAttrMiniView";
    private boolean mApplyDynamicColorSize;
    private int mColor;

    @Nullable
    private View mColorBackground;

    @Nullable
    private ImageView mColorView;
    private int mCurrentResId;
    private int mDefaultMargin;
    private int mDiffColorRadius;
    private int mFullResId;

    @Nullable
    private String mLabelFormat;

    @Nullable
    private TextView mLabelText;
    private int mNormalBackgroundTintColor;
    private int mNormalResId;

    @Nullable
    private View mSelectedView;
    private int mSizeLevel;
    private boolean mUseNormalBackgroundTint;
    private int mUserDefineChildLayoutId;
    private int mValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenPenAttrMiniView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setAttributes(context, attributeSet);
    }

    private final void adjustBackground() {
        if (!this.mApplyDynamicColorSize || this.mNormalResId == -1) {
            return;
        }
        int i = (this.mSizeLevel == 100 && Color.alpha(this.mColor) == 255) ? this.mFullResId : this.mNormalResId;
        setInnerColorBackground(i);
        setInnerColorBackgroundTint(i == this.mNormalResId && this.mUseNormalBackgroundTint, this.mNormalBackgroundTintColor);
    }

    private final int getInflateChildId() {
        if (getChildCount() > 0) {
            return 0;
        }
        int i = this.mUserDefineChildLayoutId;
        return i != 0 ? i : C7932R.layout.setting_pen_attr_mini_view;
    }

    private final void initView(Context context, int layoutResource) {
        if (layoutResource != 0) {
            Object systemService = context.getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            ((LayoutInflater) systemService).inflate(layoutResource, (ViewGroup) this, true);
        }
        this.mLabelText = (TextView) findViewById(C7932R.id.text_label);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        ImageView imageView = (ImageView) findViewById(C7932R.id.color);
        this.mColorView = imageView;
        if (imageView != null) {
            spenGradientDrawableHelper.setDrawableInfo(1, -16777216, 0, 0);
            ImageView imageView2 = this.mColorView;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageDrawable(spenGradientDrawableHelper.makeDrawable());
            ImageView imageView3 = this.mColorView;
            Intrinsics.checkNotNull(imageView3);
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            this.mDefaultMargin = ((FrameLayout.LayoutParams) layoutParams).topMargin;
        }
        this.mLabelFormat = TimeModel.NUMBER_FORMAT;
        this.mSelectedView = findViewById(C7932R.id.color_selected);
        this.mColorBackground = findViewById(C7932R.id.color_background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSizeChanged$lambda$0(SpenPenAttrMiniView spenPenAttrMiniView) {
        spenPenAttrMiniView.updateColorSize(spenPenAttrMiniView.mSizeLevel);
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.mini_pen_attr_default_color_diff_radius);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenPenAttrMiniView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                this.mApplyDynamicColorSize = typedArrayObtainStyledAttributes.getBoolean(C7932R.styleable.SpenPenAttrMiniView_applyDynamicColorSize, false);
                this.mDiffColorRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenPenAttrMiniView_diffColorRadius, dimensionPixelSize);
                this.mUserDefineChildLayoutId = typedArrayObtainStyledAttributes.getResourceId(C7932R.styleable.SpenPenAttrMiniView_childLayout, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            this.mApplyDynamicColorSize = false;
            this.mDiffColorRadius = dimensionPixelSize;
            this.mUserDefineChildLayoutId = 0;
        }
        this.mSizeLevel = 0;
        this.mColor = 0;
        this.mNormalResId = -1;
        this.mFullResId = -1;
        this.mCurrentResId = 0;
    }

    public static /* synthetic */ void setDynamicColorBackground$default(SpenPenAttrMiniView spenPenAttrMiniView, int i, int i2, boolean z, int i4, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDynamicColorBackground");
        }
        if ((i5 & 4) != 0) {
            z = false;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        spenPenAttrMiniView.setDynamicColorBackground(i, i2, z, i4);
    }

    private final void setInnerColorBackground(int resId) {
        View view = this.mColorBackground;
        if (view == null || this.mCurrentResId == resId) {
            return;
        }
        this.mCurrentResId = resId;
        Intrinsics.checkNotNull(view);
        view.setBackgroundResource(resId);
    }

    private final void setInnerColorBackgroundTint(boolean enable, int color) {
        View view = this.mColorBackground;
        if (view != null) {
            view.setBackgroundTintList(enable ? ColorStateList.valueOf(color) : null);
        }
    }

    private final void updateColorSize(int level) {
        ImageView imageView = this.mColorView;
        if (imageView == null || !this.mApplyDynamicColorSize) {
            return;
        }
        int i = ((int) (((double) ((100 - level) * this.mDiffColorRadius)) * 0.01d)) + this.mDefaultMargin;
        Intrinsics.checkNotNull(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(i, i, i, i);
        ImageView imageView2 = this.mColorView;
        Intrinsics.checkNotNull(imageView2);
        imageView2.setLayoutParams(layoutParams2);
    }

    private final void updateLabelText(int value) {
        AbstractC2322a.m1631u(value, "updateLabelText() value=", TAG);
        if (this.mLabelText == null) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = this.mLabelFormat;
        Intrinsics.checkNotNull(str);
        String strM1624n = AbstractC2322a.m1624n(str, new Object[]{Integer.valueOf(value)}, 1, "format(format, *args)");
        TextView textView = this.mLabelText;
        Intrinsics.checkNotNull(textView);
        textView.setText(strM1624n);
    }

    public void close() {
        this.mSelectedView = null;
        this.mColorView = null;
    }

    /* JADX INFO: renamed from: getUserDefineChildLayout, reason: from getter */
    public final int getMUserDefineChildLayoutId() {
        return this.mUserDefineChildLayoutId;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context, getInflateChildId());
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (!this.mApplyDynamicColorSize || h <= 0 || this.mSizeLevel <= 0) {
            return;
        }
        new Handler().post(new RunnableC7596b(this, 0));
    }

    public void setColor(int color) {
        ImageView imageView = this.mColorView;
        if (imageView == null || this.mColor == color) {
            return;
        }
        this.mColor = color;
        Intrinsics.checkNotNull(imageView);
        imageView.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        adjustBackground();
    }

    public final void setColorBackground(int resId) {
        setInnerColorBackground(resId);
        setInnerColorBackgroundTint(false, 0);
        this.mNormalResId = -1;
        this.mFullResId = -1;
        this.mUseNormalBackgroundTint = false;
        this.mNormalBackgroundTintColor = 0;
    }

    public final void setDynamicColorBackground(int normalId, int fullResId, boolean useNormalTintColor, int normalTintColor) {
        if (this.mApplyDynamicColorSize) {
            this.mUseNormalBackgroundTint = useNormalTintColor;
            this.mNormalBackgroundTintColor = normalTintColor;
            this.mNormalResId = normalId;
            this.mFullResId = fullResId;
            adjustBackground();
        }
    }

    public final void setLabelFormat(@Nullable String format) {
        this.mLabelFormat = format;
        updateLabelText(this.mValue);
    }

    public final void setLabelVisibility(int visibility) {
        TextView textView = this.mLabelText;
        if (textView == null) {
            return;
        }
        Intrinsics.checkNotNull(textView);
        if (textView.getVisibility() != visibility) {
            TextView textView2 = this.mLabelText;
            Intrinsics.checkNotNull(textView2);
            textView2.setVisibility(visibility);
            if (visibility == 0) {
                SpenSettingUtilAnimation.alphaVisibleAnimation$default(this.mLabelText, 15, 200L, null, 8, null);
            }
        }
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        View view = this.mSelectedView;
        if (view != null) {
            view.setBackgroundResource(selected ? C7932R.drawable.setting_mini_attr_selected_bg : 0);
        }
    }

    public final void setSizeLevel(int sizeLevel) {
        if (!this.mApplyDynamicColorSize || this.mSizeLevel == sizeLevel) {
            return;
        }
        this.mSizeLevel = sizeLevel;
        updateColorSize(sizeLevel);
        adjustBackground();
    }

    public final void setUserDefineChildLayout(int i) {
        this.mUserDefineChildLayoutId = i;
    }

    public final void setValue(int value) {
        this.mValue = value;
        updateLabelText(value);
    }
}
