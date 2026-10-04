package com.samsung.android.support.senl.p148nt.base.winset.app.pointericon;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ$\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/pointericon/PointerIconResolver;", "", "<init>", "()V", "mBaseLocation", "", "mTargetLocation", "mPrevTargetViewId", "", "needToResolvePointerIcon", "", "onResolvePointerIcon", "Landroid/view/PointerIcon;", "root", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "pointerIndex", "pointerIcon", "resolveTargetView", "view", "x", "y", "contains", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPointerIconResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointerIconResolver.kt\ncom/samsung/android/support/senl/nt/base/winset/app/pointericon/PointerIconResolver\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,94:1\n255#2:95\n255#2:96\n255#2:97\n*S KotlinDebug\n*F\n+ 1 PointerIconResolver.kt\ncom/samsung/android/support/senl/nt/base/winset/app/pointericon/PointerIconResolver\n*L\n60#1:95\n64#1:96\n74#1:97\n*E\n"})
public final class PointerIconResolver {

    @NotNull
    private static final String TAG = "PointerIconResolver";
    private int mPrevTargetViewId;

    @NotNull
    private final int[] mBaseLocation = new int[2];

    @NotNull
    private final int[] mTargetLocation = new int[2];

    private final boolean contains(View view, int x, int y2) {
        int i;
        view.getLocationOnScreen(this.mTargetLocation);
        int i2 = this.mTargetLocation[0];
        return i2 <= x && x <= view.getWidth() + i2 && (i = this.mTargetLocation[1]) <= y2 && y2 <= view.getHeight() + i;
    }

    private final boolean needToResolvePointerIcon() {
        return Build.VERSION.SDK_INT < 28;
    }

    private final View resolveTargetView(View view, int x, int y2) {
        if (!(view instanceof ViewGroup)) {
            if (view != null && view.getVisibility() == 0 && contains(view, x, y2)) {
                return view;
            }
            return null;
        }
        if (!contains(view, x, y2) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                Drawable background = viewGroup.getBackground();
                if (viewGroup.getAlpha() == 0.0f || background == null || background.getAlpha() == 0) {
                    return null;
                }
                return view;
            }
            View viewResolveTargetView = resolveTargetView(viewGroup.getChildAt(childCount), x, y2);
            if (viewResolveTargetView != null && viewResolveTargetView.getVisibility() == 0) {
                return viewResolveTargetView;
            }
        }
    }

    @Nullable
    public final PointerIcon onResolvePointerIcon(@NotNull View root, @NotNull MotionEvent event, int pointerIndex, @Nullable PointerIcon pointerIcon) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(event, "event");
        if (needToResolvePointerIcon() && pointerIcon == null) {
            root.getLocationOnScreen(this.mBaseLocation);
            View viewResolveTargetView = resolveTargetView(root, ((int) event.getX(pointerIndex)) + this.mBaseLocation[0], ((int) event.getY(pointerIndex)) + this.mBaseLocation[1]);
            if (viewResolveTargetView != null) {
                int id = viewResolveTargetView.getId();
                if (this.mPrevTargetViewId != id) {
                    Logger.m8697d(TAG, "targetView :" + viewResolveTargetView);
                    this.mPrevTargetViewId = id;
                }
                viewResolveTargetView.getLocationOnScreen(this.mTargetLocation);
                int i = this.mBaseLocation[0];
                int[] iArr = this.mTargetLocation;
                event.offsetLocation(i - iArr[0], r9[1] - iArr[1]);
                return viewResolveTargetView.onResolvePointerIcon(event, pointerIndex);
            }
        }
        return pointerIcon;
    }
}
