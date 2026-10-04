package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.oneui.floatingdock.FloatingPaneView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FiltersSearchView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialerBackgroundDrawable;

/* JADX INFO: renamed from: com.google.android.material.appbar.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4565b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2235a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2236b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f2237c;

    public /* synthetic */ C4565b(Object obj, Object obj2, int i) {
        this.f2235a = i;
        this.f2236b = obj;
        this.f2237c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2235a) {
            case 0:
                ((AppBarLayout) this.f2236b).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) this.f2237c, valueAnimator);
                break;
            case 1:
                ((ExpandCollapseAnimationHelper) this.f2236b).lambda$getExpandCollapseAnimator$0((Rect) this.f2237c, valueAnimator);
                break;
            case 2:
                FloatingPaneView.startAnimation$lambda$53$lambda$52((Rect) this.f2236b, (FloatingPaneView) this.f2237c, valueAnimator);
                break;
            case 3:
                ((BaseTransientBottomBar) this.f2236b).lambda$getAlphaAnimator$0((SnackbarContentLayout) this.f2237c, valueAnimator);
                break;
            case 4:
                SpenCurvedDialerBackgroundDrawable.startAnimation$lambda$1$lambda$0((SpenCurvedDialerBackgroundDrawable.AnimationListener) this.f2236b, (ValueAnimator) this.f2237c, valueAnimator);
                break;
            case 5:
                ((FiltersSearchView) this.f2236b).lambda$updateHeight$2((View) this.f2237c, valueAnimator);
                break;
            default:
                CurvedDialerBackgroundDrawable.startAnimation$lambda$3$lambda$1((CurvedDialerBackgroundDrawable.AnimationListener) this.f2236b, (ValueAnimator) this.f2237c, valueAnimator);
                break;
        }
    }
}
