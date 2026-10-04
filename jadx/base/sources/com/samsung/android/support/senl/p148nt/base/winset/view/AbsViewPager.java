package com.samsung.android.support.senl.p148nt.base.winset.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/AbsViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPagingEnabled", "", "onRtlPropertiesChanged", "", "layoutDirection", "", "onViewAdded", "child", "Landroid/view/View;", "setPagingEnabled", "pagingEnabled", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "setCurrentItem", "item", "smoothScroll", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsViewPager extends ViewPager {
    private boolean mPagingEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsViewPager(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPagingEnabled = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mPagingEnabled) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        setRotationY(layoutDirection == 1 ? 180.0f : 0.0f);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mPagingEnabled) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        if (getLayoutDirection() == 1) {
            child.setRotationY(180.0f);
        } else {
            child.setRotationY(0.0f);
        }
        super.onViewAdded(child);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item) {
        SettingsCompat companion = SettingsCompat.INSTANCE.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (companion.isAccessibilityAnimationDisabled(context)) {
            super.setCurrentItem(item, false);
        } else {
            super.setCurrentItem(item);
        }
    }

    public final void setPagingEnabled(boolean pagingEnabled) {
        this.mPagingEnabled = pagingEnabled;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsViewPager(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPagingEnabled = true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item, boolean smoothScroll) {
        SettingsCompat companion = SettingsCompat.INSTANCE.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (companion.isAccessibilityAnimationDisabled(context)) {
            super.setCurrentItem(item, false);
        } else {
            super.setCurrentItem(item, smoothScroll);
        }
    }
}
