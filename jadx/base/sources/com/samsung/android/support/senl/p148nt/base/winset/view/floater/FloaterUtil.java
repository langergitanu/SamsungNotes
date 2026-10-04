package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tJ\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J3\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEBUG_LOG", "", "HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_LEFT", "", "HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_RIGHT", "HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_UP", "HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_DOWN", "SCROLLABLE_DIRECTION_LEFT", "SCROLLABLE_DIRECTION_RIGHT", "SCROLLABLE_DIRECTION_UP", "SCROLLABLE_DIRECTION_DOWN", "isVerticalScrollable", "direction", "isHorizontalScrollable", "isLeftDirection", "isRightDirection", "isUpDirection", "isDownDirection", "getScrollDirection", "view", "Landroid/view/View;", "point", "Landroid/graphics/PointF;", "getScrollDirectionView", "getValidView", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroid/view/View;Landroid/graphics/PointF;)Ljava/lang/Object;", "contains", "LOGD", "", "content", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FloaterUtil {
    private static final boolean DEBUG_LOG = false;
    private static final int HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_DOWN = 1;
    private static final int HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_LEFT = -1;
    private static final int HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_RIGHT = 1;
    private static final int HORIZONTAL_SCROLLABLE_EXIST_ITEM_ON_UP = -1;

    @NotNull
    public static final FloaterUtil INSTANCE = new FloaterUtil();
    private static final int SCROLLABLE_DIRECTION_DOWN = 8;
    private static final int SCROLLABLE_DIRECTION_LEFT = 1;
    private static final int SCROLLABLE_DIRECTION_RIGHT = 2;
    private static final int SCROLLABLE_DIRECTION_UP = 4;

    @NotNull
    private static final String TAG = "FloaterUtil";

    private FloaterUtil() {
    }

    private final void LOGD(String content) {
    }

    private final int getScrollDirectionView(View view) {
        int i = view.canScrollHorizontally(-1) ? 2 : 0;
        if (view.canScrollHorizontally(1)) {
            i |= 1;
        }
        if (view.canScrollVertically(-1)) {
            i |= 8;
        }
        return view.canScrollVertically(1) ? i | 4 : i;
    }

    private final boolean isDownDirection(int direction) {
        return (direction & 8) == 8;
    }

    private final boolean isLeftDirection(int direction) {
        return (direction & 1) == 1;
    }

    private final boolean isRightDirection(int direction) {
        return (direction & 2) == 2;
    }

    private final boolean isUpDirection(int direction) {
        return (direction & 4) == 4;
    }

    public final boolean contains(@Nullable View view, @NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getHitRect(rect);
        boolean zContains = rect.contains((int) point.x, (int) point.y);
        LOGD("contains : " + zContains + " : " + rect + " & " + point + " : " + view);
        return zContains;
    }

    public final int getScrollDirection(@Nullable View view, @NotNull PointF point) {
        Intrinsics.checkNotNullParameter(point, "point");
        if (view != null && view.getVisibility() == 0) {
            if (!contains(view, point)) {
                LOGD("check horizontal scrollable direction : not contained : " + view + " / " + point);
                return 0;
            }
            int scrollDirectionView = getScrollDirectionView(view);
            if (scrollDirectionView != 0) {
                return scrollDirectionView;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                PointF pointF = new PointF(point.x - viewGroup.getX(), point.y - viewGroup.getY());
                for (int i = 0; i < childCount; i++) {
                    int scrollDirection = getScrollDirection(viewGroup.getChildAt(i), pointF);
                    if (scrollDirection != 0) {
                        return scrollDirection;
                    }
                }
            }
            LOGD("check horizontal scrollable direction : not scrollable : " + view + " / " + point);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final <T> T getValidView(@NotNull Class<T> clazz, @Nullable View view, @NotNull PointF point) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(point, "point");
        if (clazz.isInstance(view)) {
            if (view != 0 && view.isShown() && contains(view, point)) {
                return view;
            }
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF = new PointF(point.x - viewGroup.getX(), point.y - viewGroup.getY());
            for (int i = 0; i < childCount; i++) {
                T t = (T) getValidView(clazz, viewGroup.getChildAt(i), pointF);
                if (t != null) {
                    return t;
                }
            }
        }
        return null;
    }

    public final boolean isHorizontalScrollable(int direction) {
        return isLeftDirection(direction) || isRightDirection(direction);
    }

    public final boolean isVerticalScrollable(int direction) {
        return isUpDirection(direction) || isDownDirection(direction);
    }
}
