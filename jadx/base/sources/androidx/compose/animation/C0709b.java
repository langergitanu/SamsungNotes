package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.p109ui.geometry.Rect;

/* JADX INFO: renamed from: androidx.compose.animation.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0709b implements BoundsTransform {
    @Override // androidx.compose.animation.BoundsTransform
    public final FiniteAnimationSpec transform(Rect rect, Rect rect2) {
        return SharedTransitionScopeKt.DefaultBoundsTransform$lambda$0(rect, rect2);
    }
}
