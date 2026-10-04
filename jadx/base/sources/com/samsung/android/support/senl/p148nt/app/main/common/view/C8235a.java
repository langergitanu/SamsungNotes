package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.animation.ValueAnimator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorShowHideAnimator;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8235a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6160a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f6161b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6162c;

    public /* synthetic */ C8235a(int i, Object obj, boolean z) {
        this.f6160a = i;
        this.f6162c = obj;
        this.f6161b = z;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6160a) {
            case 0:
                ((ActionMenuController) this.f6162c).lambda$setFolderPathLayoutVisibleAnimation$5(this.f6161b, valueAnimator);
                break;
            default:
                ((TitleEditorShowHideAnimator) this.f6162c).lambda$animate$0(this.f6161b, valueAnimator);
                break;
        }
    }
}
