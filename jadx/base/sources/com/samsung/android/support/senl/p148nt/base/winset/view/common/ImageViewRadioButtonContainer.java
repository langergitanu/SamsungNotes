package com.samsung.android.support.senl.p148nt.base.winset.view.common;

import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0004¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButtonContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "setRecoilStateListAnimator", "", "view", "Landroid/view/View;", "updateButtonWidth", "container", "Landroid/widget/LinearLayout;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nImageViewRadioButtonContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageViewRadioButtonContainer.kt\ncom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButtonContainer\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,76:1\n297#2:77\n*S KotlinDebug\n*F\n+ 1 ImageViewRadioButtonContainer.kt\ncom/samsung/android/support/senl/nt/base/winset/view/common/ImageViewRadioButtonContainer\n*L\n44#1:77\n*E\n"})
public class ImageViewRadioButtonContainer extends FrameLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButtonContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setRecoilStateListAnimator(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewCompat companion = ViewCompat.INSTANCE.getInstance();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        StateListAnimator recoilStateListAnimator = companion.getRecoilStateListAnimator(context, 0);
        if (recoilStateListAnimator != null) {
            view.setStateListAnimator(recoilStateListAnimator);
        }
    }

    public final void updateButtonWidth(@NotNull LinearLayout container) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(container, "container");
        Object parent = container.getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View view = (View) parent;
        int childCount = container.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = container.getChildAt(i4);
            if (childAt != null && childAt.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int marginEnd = marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart() + childAt.getMeasuredWidth();
                TypedValue typedValue = new TypedValue();
                container.getContext().getResources().getValue(C8875R.dimen.image_view_radio_button_width_percent, typedValue, true);
                int measuredWidth = (int) (view.getMeasuredWidth() * typedValue.getFloat());
                if (marginEnd > measuredWidth) {
                    int i5 = marginEnd - measuredWidth;
                    i2 = i5 / 2;
                    i = i5 - i2;
                    marginEnd = measuredWidth;
                } else {
                    i = 0;
                    i2 = 0;
                }
                marginLayoutParams.width = marginEnd;
                marginLayoutParams.setMarginStart(i2);
                marginLayoutParams.setMarginEnd(i);
                childAt.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButtonContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButtonContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewRadioButtonContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
