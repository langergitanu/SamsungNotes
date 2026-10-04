package com.google.android.material.oneui.floatingdock;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTLayoutAnimation;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenItemVisibilityController;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4796g implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2341a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2342b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f2343c;

    public /* synthetic */ C4796g(Object obj, View view, int i) {
        this.f2341a = i;
        this.f2342b = obj;
        this.f2343c = view;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        switch (this.f2341a) {
            case 0:
                FloatingPaneView.show$lambda$18$lambda$16((Ref.BooleanRef) this.f2342b, (FloatingPaneView) this.f2343c, dynamicAnimation, f, f4);
                break;
            case 1:
                SpenQTLayoutAnimation.rotateAnimation$lambda$4((SpenQTLayoutAnimation) this.f2342b, this.f2343c, dynamicAnimation, f, f4);
                break;
            default:
                SpenQTPenItemVisibilityController.startEdgeItemAnimation$lambda$11$lambda$10((SpenQTPenItemVisibilityController) this.f2342b, this.f2343c, dynamicAnimation, f, f4);
                break;
        }
    }
}
