package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\fJ\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\nH\u0002J(\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0014J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorView;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mWidth", "", "mColorMarginRatio", "", "mIsSelectVisible", "", "getAttributes", "", "initView", "getDefaultColor", "getStrokeSize", "getStrokeColor", "setSelectVisibility", "isVisible", "setColorMarginRatio", "ratio", "setChildMargin", "margin", "setMargin", "view", "Landroid/view/View;", "onSizeChanged", "w", "h", "oldw", "oldh", "setSelected", "selected", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorView extends SpenChipView {

    @NotNull
    private static final String TAG = "SpenColorView";
    private float mColorMarginRatio;
    private boolean mIsSelectVisible;
    private int mWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsSelectVisible = true;
    }

    private final void getAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenColorView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            float f = typedArrayObtainStyledAttributes.getFloat(C7932R.styleable.SpenColorView_marginRatio, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            this.mColorMarginRatio = f;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final boolean setChildMargin(int margin) {
        boolean margin2 = setMargin(getColorView(), margin);
        if (setMargin(getSelectView(), margin)) {
            return true;
        }
        return margin2;
    }

    private final boolean setMargin(View view, int margin) {
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2.getMarginStart() == margin) {
            return false;
        }
        layoutParams2.setMargins(margin, margin, margin, margin);
        view.setLayoutParams(layoutParams2);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView
    public int getDefaultColor() {
        return -855309;
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView
    public int getStrokeColor() {
        return SpenSettingUtil.getColor(getContext(), C7932R.color.setting_color_circle_chip_unselected_outline_color);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView
    public int getStrokeSize() {
        return getContext().getResources().getDimensionPixelSize(C7932R.dimen.setting_color_circle_chip_unselected_outline_size);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView, com.samsung.android.sdk.pen.setting.colorpalette.SpenBaseColorView
    public void initView(@NotNull Context context, @Nullable AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.initView(context, attrs);
        getAttributes(context, attrs);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(oldw, oldh, "onSizeChanged() old[", SQLKeyword.COMMA, "] -> new["), w, h, SQLKeyword.COMMA, "]"));
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        if (w > 0) {
            float f = this.mColorMarginRatio;
            if (f <= 0.0f || !setChildMargin(Math.round(w * f))) {
                return;
            }
            new Handler().post(new RunnableC4617a(this, 21));
        }
    }

    public final void setColorMarginRatio(float ratio) {
        this.mColorMarginRatio = ratio;
        int i = this.mWidth;
        if (i == 0) {
            return;
        }
        setChildMargin(Math.round(i * ratio));
    }

    public final void setSelectVisibility(boolean isVisible) {
        AbstractC4539a.m3208r("setSelectVisibility = ", TAG, isVisible);
        this.mIsSelectVisible = isVisible;
        getSelectView().setVisibility(this.mIsSelectVisible ? 0 : 8);
    }

    @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView, android.view.View
    public void setSelected(boolean selected) {
        setSelected(selected, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenColorView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mIsSelectVisible = true;
    }
}
