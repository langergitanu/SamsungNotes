package com.samsung.android.sdk.pen.setting.favoritepen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenSettingViewAnimationWrapper;", "", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "close", "", "setPaddingLeft", "paddingLeft", "", "setPaddingTop", "paddingTop", "setPaddingRight", "paddingRight", "setPaddingBottom", "paddingBottom", "setWidth", "width", "setHeight", "height", "setMarginStart", "marginStart", "setMarginEnd", "marginEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingViewAnimationWrapper {

    @NotNull
    private View view;

    public SpenSettingViewAnimationWrapper(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final void setHeight(int height) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = height;
            this.view.setLayoutParams(layoutParams);
        }
    }

    public final void setMarginEnd(int marginEnd) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).setMarginEnd(marginEnd);
            this.view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).setMarginEnd(marginEnd);
            this.view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).setMarginEnd(marginEnd);
            this.view.setLayoutParams(layoutParams);
        }
    }

    public final void setMarginStart(int marginStart) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).setMarginStart(marginStart);
            this.view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).setMarginStart(marginStart);
            this.view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).setMarginStart(marginStart);
            this.view.setLayoutParams(layoutParams);
        }
    }

    public final void setPaddingBottom(int paddingBottom) {
        View view = this.view;
        view.setPadding(view.getPaddingLeft(), this.view.getPaddingTop(), this.view.getPaddingRight(), paddingBottom);
    }

    public final void setPaddingLeft(int paddingLeft) {
        View view = this.view;
        view.setPadding(paddingLeft, view.getPaddingTop(), this.view.getPaddingRight(), this.view.getPaddingBottom());
    }

    public final void setPaddingRight(int paddingRight) {
        View view = this.view;
        view.setPadding(view.getPaddingLeft(), this.view.getPaddingTop(), paddingRight, this.view.getPaddingBottom());
    }

    public final void setPaddingTop(int paddingTop) {
        View view = this.view;
        view.setPadding(view.getPaddingLeft(), paddingTop, this.view.getPaddingRight(), this.view.getPaddingBottom());
    }

    public final void setWidth(int width) {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
            this.view.setLayoutParams(layoutParams);
        }
    }

    public final void close() {
    }
}
