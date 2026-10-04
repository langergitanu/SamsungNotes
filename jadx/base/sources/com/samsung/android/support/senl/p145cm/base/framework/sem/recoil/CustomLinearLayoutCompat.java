package com.samsung.android.support.senl.p145cm.base.framework.sem.recoil;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.C7968R;
import com.samsung.android.support.senl.p145cm.base.framework.sem.recoil.CustomRecoilAnimator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0002$%B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomLinearLayoutCompat;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mItemBackgroundHolder", "Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomLinearLayoutCompat$ItemBackgroundHolder;", "mRecoilAnimatorHolder", "Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomRecoilAnimator$Holder;", "mRoundedCorner", "Landroidx/appcompat/util/SeslRoundedCorner;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "isViewUnder", "child", "Landroid/view/View;", "x", "y", "findChildViewUnder", "view", "findClickableChildUnder", "e", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "ItemBackgroundHolder", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CustomLinearLayoutCompat extends LinearLayoutCompat {
    private static final int MOTION_EVENT_ACTION_PEN_DOWN = 211;
    private static final int MOTION_EVENT_ACTION_PEN_UP = 212;

    @NotNull
    private final ItemBackgroundHolder mItemBackgroundHolder;

    @NotNull
    private final CustomRecoilAnimator.Holder mRecoilAnimatorHolder;

    @NotNull
    private final SeslRoundedCorner mRoundedCorner;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomLinearLayoutCompat$ItemBackgroundHolder;", "", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/recoil/CustomLinearLayoutCompat;)V", "activeBg", "Landroid/graphics/drawable/Drawable;", "getActiveBg", "()Landroid/graphics/drawable/Drawable;", "setActiveBg", "(Landroid/graphics/drawable/Drawable;)V", "setPress", "", "view", "Landroid/view/View;", "setRelease", "setCancel", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ItemBackgroundHolder {

        @Nullable
        private Drawable activeBg;

        public ItemBackgroundHolder() {
        }

        @Nullable
        public final Drawable getActiveBg() {
            return this.activeBg;
        }

        public final void setActiveBg(@Nullable Drawable drawable) {
            this.activeBg = drawable;
        }

        public final void setCancel() {
            Drawable drawable = this.activeBg;
            if (drawable != null) {
                if (drawable instanceof CustomRecoilDrawable) {
                    Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.sem.recoil.CustomRecoilDrawable");
                    ((CustomRecoilDrawable) drawable).setCancel();
                } else {
                    Intrinsics.checkNotNull(drawable);
                    drawable.setState(new int[0]);
                }
                this.activeBg = null;
            }
        }

        public final void setPress(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            setRelease();
            Drawable background = view.getBackground();
            this.activeBg = background;
            if (background != null) {
                Intrinsics.checkNotNull(background);
                background.setState(new int[]{R.attr.state_hovered});
            }
        }

        public final void setRelease() {
            Drawable drawable = this.activeBg;
            if (drawable != null) {
                Intrinsics.checkNotNull(drawable);
                drawable.setState(new int[0]);
                this.activeBg = null;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomLinearLayoutCompat(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View findChildViewUnder(View view, int x, int y2) {
        View viewFindChildViewUnder = null;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNull(childAt);
                if (isViewUnder(childAt, x, y2) && (viewFindChildViewUnder = findChildViewUnder(childAt, x, y2)) != null) {
                    break;
                }
            }
        }
        return (viewFindChildViewUnder == null && view.isClickable() && view.getVisibility() == 0 && view.isEnabled()) ? view : viewFindChildViewUnder;
    }

    private final View findClickableChildUnder(MotionEvent e) {
        View childAt;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                childAt = null;
                break;
            }
            childAt = getChildAt(i);
            Intrinsics.checkNotNull(childAt);
            if (isViewUnder(childAt, (int) e.getX(), (int) e.getY())) {
                break;
            }
            i++;
        }
        if (childAt == null) {
            return null;
        }
        View viewFindChildViewUnder = findChildViewUnder(childAt, (int) e.getX(), (int) e.getY());
        if (viewFindChildViewUnder != null && viewFindChildViewUnder != childAt) {
            if (viewFindChildViewUnder.getHeight() * viewFindChildViewUnder.getWidth() < ((double) (childAt.getHeight() * childAt.getWidth())) * 0.5d) {
                return null;
            }
        }
        return viewFindChildViewUnder;
    }

    private final boolean isViewUnder(View child, int x, int y2) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        child.getGlobalVisibleRect(rect2);
        getGlobalVisibleRect(rect);
        return rect2.contains(rect.width() + ((x + rect.left) - getWidth()), rect.height() + ((y2 + rect.top) - getHeight()));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        this.mRoundedCorner.drawRoundedCorner(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() == 66) {
            if (event.getAction() == 0) {
                View focusedChild = getFocusedChild();
                if (focusedChild != null) {
                    this.mRecoilAnimatorHolder.setPress(focusedChild);
                }
            } else {
                this.mRecoilAnimatorHolder.setRelease();
            }
        }
        return super.dispatchKeyEvent(event);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            View viewFindClickableChildUnder = findClickableChildUnder(ev);
            if (viewFindClickableChildUnder != null) {
                this.mItemBackgroundHolder.setPress(viewFindClickableChildUnder);
                this.mRecoilAnimatorHolder.setPress(viewFindClickableChildUnder);
            }
        } else if (action == 1) {
            this.mItemBackgroundHolder.setRelease();
            this.mRecoilAnimatorHolder.setRelease();
        } else if (action == 3) {
            this.mItemBackgroundHolder.setCancel();
            this.mRecoilAnimatorHolder.setRelease();
        } else if (action != 211) {
            if (action == 212) {
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomLinearLayoutCompat(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomLinearLayoutCompat(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomLinearLayoutCompat(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, C7968R.styleable.CustomLayout, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, C7968R.styleable.CustomLayout, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = tintTypedArrayObtainStyledAttributes.getInt(C7968R.styleable.CustomLayout_CustomLayoutRoundedCorner, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
        SeslRoundedCorner seslRoundedCorner = new SeslRoundedCorner(context);
        this.mRoundedCorner = seslRoundedCorner;
        seslRoundedCorner.setRoundedCorners(i2);
        this.mItemBackgroundHolder = new ItemBackgroundHolder();
        this.mRecoilAnimatorHolder = new CustomRecoilAnimator.Holder(context);
    }
}
