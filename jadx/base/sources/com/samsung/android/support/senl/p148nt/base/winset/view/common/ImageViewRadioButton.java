package com.samsung.android.support.senl.p148nt.base.winset.view.common;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nJ\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\u0013J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mImageView", "Landroid/widget/ImageView;", "mTextView", "Landroid/widget/TextView;", "mRadioButton", "Landroid/widget/RadioButton;", "init", "", "defStyleRes", "setTag", "tag", "", "initRadioButton", BaseWidgetConstant.SET_IMAGE_RESOURCE, "resId", "setText", "textRes", "setChecked", "checked", "", "onInitializeAccessibilityEvent", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "removeImageViewAllMargins", "setVisibilityRadioButton", "visibility", "setVisibilityTextView", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImageViewRadioButton extends LinearLayout {

    @Nullable
    private ImageView mImageView;

    @Nullable
    private RadioButton mRadioButton;

    @Nullable
    private TextView mTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, null, 0, 0);
    }

    private final void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        int i = C8875R.layout.image_view_radio_button_layout;
        View rootView = getRootView();
        Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
        View.inflate(context, i, (ViewGroup) rootView);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C8875R.styleable.ImageRadioButtonAttribute, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            initRadioButton();
            setImageResource(typedArrayObtainStyledAttributes.getResourceId(C8875R.styleable.ImageRadioButtonAttribute_image, 0));
            setText(typedArrayObtainStyledAttributes.getResourceId(C8875R.styleable.ImageRadioButtonAttribute_text, 0));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_selected}, ResourcesCompat.getDrawable(context.getResources(), C8875R.drawable.view_rounded_rantangle_ripple_selected, context.getTheme()));
            stateListDrawable.addState(new int[]{R.attr.state_enabled}, ResourcesCompat.getDrawable(context.getResources(), C8875R.drawable.view_rounded_rantangle_ripple_pressed, context.getTheme()));
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, ResourcesCompat.getDrawable(context.getResources(), C8875R.drawable.view_rounded_rantangle_ripple_pressed, context.getTheme()));
            setBackground(stateListDrawable);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final void initRadioButton() {
        RadioButton radioButton = (RadioButton) findViewById(C8875R.id.radio_button);
        this.mRadioButton = radioButton;
        if (radioButton != null) {
            radioButton.setClickable(false);
        }
        RadioButton radioButton2 = this.mRadioButton;
        if (radioButton2 != null) {
            radioButton2.setBackground(null);
        }
    }

    private final void setText(int textRes) {
        if (textRes <= 0) {
            return;
        }
        TextView textView = (TextView) findViewById(C8875R.id.radio_text_view);
        this.mTextView = textView;
        if (textView != null) {
            textView.setText(textRes);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NotNull AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onInitializeAccessibilityEvent(event);
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            event.setChecked(radioButton.isChecked());
            event.setClassName(radioButton.getAccessibilityClassName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NotNull AccessibilityNodeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        TextView textView = this.mTextView;
        if (textView != null) {
            info.setText(textView.getText());
        }
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            info.setCheckable(true);
            info.setChecked(radioButton.isChecked());
            info.setClassName(radioButton.getAccessibilityClassName());
        }
    }

    public final void removeImageViewAllMargins() {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
        }
    }

    public final void setChecked(boolean checked) {
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            radioButton.setChecked(checked);
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setSelected(checked);
        }
    }

    public final void setImageResource(int resId) {
        if (this.mImageView == null) {
            this.mImageView = (ImageView) findViewById(C8875R.id.radio_image_view);
        }
        if (resId <= 0) {
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView2 = this.mImageView;
        if (imageView2 != null) {
            imageView2.setImageResource(resId);
        }
        ImageView imageView3 = this.mImageView;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setTag(@Nullable Object tag) {
        super.setTag(tag);
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            radioButton.setTag(tag);
        }
    }

    public final void setVisibilityRadioButton(int visibility) {
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            radioButton.setVisibility(visibility);
        }
    }

    public final void setVisibilityTextView(int visibility) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setVisibility(visibility);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet, 0, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context, attributeSet, i, 0);
    }
}
