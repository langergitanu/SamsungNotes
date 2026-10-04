package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u00018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\"\u0010\u0016\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0012J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0002J0\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0016J \u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0016J \u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mGestureDetector", "Landroid/view/GestureDetector;", "mFloaters", "", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater;", "mTouchDownedFloaterIndex", "mElevation", "", "init", "", "defStyle", "addFloater", "floater", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "findFloaterAt", "x", "y", "onLayout", "changed", "l", "t", "r", "b", "addView", "child", "Landroid/view/View;", ActionHandler.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "index", "width", "height", "applyAttributes", "giveIdIfNone", "view", "applyElevationToChild", "checkOutBounds", "dragFloater", "getFloater", "()Lcom/samsung/android/support/senl/nt/base/winset/view/floater/IFloater;", "FloaterGestureListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FloaterContainer extends ConstraintLayout {
    private float mElevation;

    @NotNull
    private final List<IFloater> mFloaters;

    @Nullable
    private GestureDetector mGestureDetector;
    private int mTouchDownedFloaterIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J*\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer$FloaterGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer;)V", "onScroll", "", "start", "Landroid/view/MotionEvent;", "current", "distanceX", "", "distanceY", "onLongPress", "", "e", "onFling", "end", "velocityX", "velocityY", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class FloaterGestureListener extends GestureDetector.SimpleOnGestureListener {
        public FloaterGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent start, @NotNull MotionEvent end, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(end, "end");
            IFloater floater = FloaterContainer.this.getFloater();
            if (floater != null && floater.onFling(velocityX, velocityY, new RunnableC8979b(FloaterContainer.this, floater, 0))) {
                FloaterContainer.this.mTouchDownedFloaterIndex = -1;
            }
            return super.onFling(start, end, velocityX, velocityY);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            IFloater floater = FloaterContainer.this.getFloater();
            if (floater != null) {
                floater.onLongPress();
            }
            super.onLongPress(e);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent start, @NotNull MotionEvent current, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(current, "current");
            IFloater floater = FloaterContainer.this.getFloater();
            if (floater != null && start != null) {
                floater.onScroll(current, start.getX() - current.getX(), start.getY() - current.getY());
            }
            return super.onScroll(start, current, distanceX, distanceY);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloaterContainer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFloaters = new ArrayList();
        this.mTouchDownedFloaterIndex = -1;
        init(null, 0, 0);
    }

    public static final /* synthetic */ void access$checkOutBounds(FloaterContainer floaterContainer, IFloater iFloater) {
        floaterContainer.checkOutBounds(iFloater);
    }

    private final void applyAttributes(View child) {
        giveIdIfNone(child);
        applyElevationToChild(child);
    }

    private final void applyElevationToChild(View child) {
        float f = this.mElevation;
        if (f == 0.0f) {
            return;
        }
        child.setElevation(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkOutBounds(IFloater dragFloater) {
        if (dragFloater == null) {
            return;
        }
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        Rect rect2 = new Rect();
        dragFloater.getHitRect(rect2);
        if (rect.contains(rect2) || dragFloater.getMEnableDocking()) {
            return;
        }
        dragFloater.dropAction();
    }

    private final IFloater findFloaterAt(float x, float y2) {
        PointF pointF = new PointF(x, y2);
        for (IFloater iFloater : this.mFloaters) {
            if (iFloater.contains(pointF) && iFloater.isPressed()) {
                return iFloater;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloater getFloater() {
        int size = this.mFloaters.size();
        int i = this.mTouchDownedFloaterIndex;
        if (i < 0 || i >= size) {
            return null;
        }
        return this.mFloaters.get(i);
    }

    private final void giveIdIfNone(View view) {
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
    }

    private final void init(AttributeSet attrs, int defStyle, int defStyleRes) {
        this.mGestureDetector = new GestureDetector(getContext(), new FloaterGestureListener());
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C8875R.styleable.FloaterContainer, defStyle, defStyleRes);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mElevation = typedArrayObtainStyledAttributes.getDimension(C8875R.styleable.FloaterContainer_floaterElevation, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void addFloater(@NotNull IFloater floater) {
        Intrinsics.checkNotNullParameter(floater, "floater");
        this.mFloaters.add(0, floater);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(@NotNull View child, @NotNull ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        super.addView(child, params);
        applyAttributes(child);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        GestureDetector gestureDetector;
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.mGestureDetector != null && !this.mFloaters.isEmpty() && (gestureDetector = this.mGestureDetector) != null) {
            gestureDetector.onTouchEvent(ev);
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(ev);
        if (!this.mFloaters.isEmpty()) {
            if (ev.getAction() == 0) {
                IFloater iFloaterFindFloaterAt = findFloaterAt(ev.getX(), ev.getY());
                if (iFloaterFindFloaterAt != null) {
                    this.mTouchDownedFloaterIndex = this.mFloaters.indexOf(iFloaterFindFloaterAt);
                    return zDispatchTouchEvent;
                }
            } else if (ev.getAction() == 1) {
                checkOutBounds(getFloater());
                this.mTouchDownedFloaterIndex = -1;
            }
        }
        return zDispatchTouchEvent;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (!changed || this.mFloaters.isEmpty()) {
            return;
        }
        Iterator<IFloater> it = this.mFloaters.iterator();
        while (it.hasNext()) {
            it.next().onFieldSizeChanged();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.addView(child, index);
        applyAttributes(child);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloaterContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFloaters = new ArrayList();
        this.mTouchDownedFloaterIndex = -1;
        init(attributeSet, 0, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.addView(child);
        applyAttributes(child);
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int width, int height) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.addView(child, width, height);
        applyAttributes(child);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloaterContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFloaters = new ArrayList();
        this.mTouchDownedFloaterIndex = -1;
        init(attributeSet, i, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index, @NotNull ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        super.addView(child, index, params);
        applyAttributes(child);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloaterContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNull(context);
        this.mFloaters = new ArrayList();
        this.mTouchDownedFloaterIndex = -1;
        init(attributeSet, i, i);
    }
}
