package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0003#$%B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0017J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0014J\u0014\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000fJ\u001a\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\r2\u0006\u0010\"\u001a\u00020\rH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mGestureDetector", "Landroid/view/GestureDetector;", "mLayoutManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorLayoutManager;", "mLastEvent", "Landroid/view/MotionEvent;", "mInterceptTouch", "", "close", "", "dispatchTouchEvent", "event", "onInterceptTouchEvent", "onTouchEvent", "dispatchHoverEvent", "setDialItems", "items", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ColorDialItem;", "setSelectedColor", "colorIndex", "", "moveToCurrent", "getScrollDirection", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView$ScrollDirection;", "e1", "e2", "ScrollDirection", "GestureListener", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTColorRecycleView extends RecyclerView {
    private static final float SCROLLER_FRICTION = 0.2f;

    @NotNull
    private static final String TAG = "QTColorRecycleView";

    @NotNull
    private GestureDetector mGestureDetector;
    private boolean mInterceptTouch;

    @Nullable
    private MotionEvent mLastEvent;

    @NotNull
    private QTColorLayoutManager mLayoutManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J*\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "onFling", "velocityX", "velocityY", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e) {
            Intrinsics.checkNotNullParameter(e, "e");
            QTColorRecycleView.this.mLastEvent = MotionEvent.obtain(e);
            QTColorRecycleView.this.mInterceptTouch = false;
            QTColorRecycleView.this.mLayoutManager.setScrollDirection(ScrollDirection.DIR_NONE);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float velocityX, float velocityY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            ScrollDirection scrollDirection = QTColorRecycleView.this.getScrollDirection(e12, e2);
            if (scrollDirection == ScrollDirection.DIR_NONE) {
                return true;
            }
            QTColorRecycleView.this.mInterceptTouch = true;
            QTColorRecycleView.this.mLayoutManager.setScrollDirection(scrollDirection);
            OverScroller overScroller = new OverScroller(QTColorRecycleView.this.getContext());
            overScroller.setFriction(0.2f);
            overScroller.fling(0, 0, (int) velocityX, (int) velocityY, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int iHypot = (int) Math.hypot(overScroller.getFinalX(), overScroller.getFinalY());
            if (scrollDirection == ScrollDirection.DIR_LEFT_TO_RIGHT) {
                iHypot *= -1;
            }
            QTColorRecycleView.this.smoothScrollBy(iHypot, 0);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e12, @NotNull MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            int iHypot = (int) Math.hypot(distanceX, distanceY);
            if (iHypot == 0) {
                return true;
            }
            QTColorRecycleView qTColorRecycleView = QTColorRecycleView.this;
            ScrollDirection scrollDirection = qTColorRecycleView.getScrollDirection(qTColorRecycleView.mLastEvent, e2);
            QTColorRecycleView.this.mLastEvent = MotionEvent.obtain(e2);
            if (scrollDirection == ScrollDirection.DIR_NONE) {
                return true;
            }
            QTColorRecycleView.this.mInterceptTouch = true;
            QTColorRecycleView.this.mLayoutManager.setScrollDirection(scrollDirection);
            if (scrollDirection == ScrollDirection.DIR_LEFT_TO_RIGHT) {
                iHypot *= -1;
            }
            QTColorRecycleView.this.scrollBy(iHypot, 0);
            return true;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorRecycleView$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "DIR_NONE", "DIR_LEFT_TO_RIGHT", "DIR_RIGHT_TO_LEFT", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ScrollDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScrollDirection[] $VALUES;
        public static final ScrollDirection DIR_NONE = new ScrollDirection("DIR_NONE", 0);
        public static final ScrollDirection DIR_LEFT_TO_RIGHT = new ScrollDirection("DIR_LEFT_TO_RIGHT", 1);
        public static final ScrollDirection DIR_RIGHT_TO_LEFT = new ScrollDirection("DIR_RIGHT_TO_LEFT", 2);

        private static final /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{DIR_NONE, DIR_LEFT_TO_RIGHT, DIR_RIGHT_TO_LEFT};
        }

        static {
            ScrollDirection[] scrollDirectionArr$values = $values();
            $VALUES = scrollDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scrollDirectionArr$values);
        }

        private ScrollDirection(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ScrollDirection> getEntries() {
            return $ENTRIES;
        }

        public static ScrollDirection valueOf(String str) {
            return (ScrollDirection) Enum.valueOf(ScrollDirection.class, str);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public QTColorRecycleView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScrollDirection getScrollDirection(MotionEvent e12, MotionEvent e2) {
        if (e12 == null) {
            return ScrollDirection.DIR_NONE;
        }
        float f = 2;
        float width = getWidth() / f;
        float height = getHeight() / f;
        float x = e12.getX();
        float y2 = e12.getY();
        float y3 = ((e2.getY() - y2) * (x - width)) - ((e2.getX() - x) * (y2 - height));
        return y3 > 0.0f ? ScrollDirection.DIR_RIGHT_TO_LEFT : y3 < 0.0f ? ScrollDirection.DIR_LEFT_TO_RIGHT : ScrollDirection.DIR_NONE;
    }

    public final void close() {
        this.mLastEvent = null;
        this.mLayoutManager.close();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.mGestureDetector.onTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.mInterceptTouch || super.onInterceptTouchEvent(event);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return this.mInterceptTouch || super.onTouchEvent(event);
    }

    public final void setDialItems(@NotNull List<SettingQTColorDialLayout.ColorDialItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.mLayoutManager.setDialItems(items);
    }

    public final void setSelectedColor(int colorIndex, boolean moveToCurrent) {
        Logger.m11003i(TAG, "setSelectedColor colorIndex=" + colorIndex);
        RecyclerView.Adapter adapter = getAdapter();
        QTColorAdapter qTColorAdapter = adapter instanceof QTColorAdapter ? (QTColorAdapter) adapter : null;
        if (qTColorAdapter == null) {
            return;
        }
        qTColorAdapter.setSelectedPosition(colorIndex);
        if (moveToCurrent) {
            this.mLayoutManager.setFirstVisibleItemPosition(Math.max(colorIndex, 0));
        }
    }

    public /* synthetic */ QTColorRecycleView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QTColorRecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setItemAnimator(null);
        setOverScrollMode(2);
        QTColorLayoutManager qTColorLayoutManager = new QTColorLayoutManager(getResources().getDimension(C9086R.dimen.composer_qt_circular_recycle_view_radius));
        this.mLayoutManager = qTColorLayoutManager;
        setLayoutManager(qTColorLayoutManager);
        this.mGestureDetector = new GestureDetector(context, new GestureListener());
    }
}
