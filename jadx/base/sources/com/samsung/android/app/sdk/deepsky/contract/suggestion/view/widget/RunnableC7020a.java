package com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget;

import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.SwipeDismissFrameLayout;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.contract.suggestion.view.widget.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7020a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4730a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SwipeDismissFrameLayout f4731b;

    public /* synthetic */ RunnableC7020a(SwipeDismissFrameLayout swipeDismissFrameLayout, int i) {
        this.f4730a = i;
        this.f4731b = swipeDismissFrameLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4730a) {
            case 0:
                SwipeDismissFrameLayout.MyOnDismissedListener.onDismissed$lambda$0(this.f4731b);
                break;
            default:
                SwipeDismissFrameLayout.MyOnSwipeProgressChangedListener.onSwipeCanceled$lambda$0(this.f4731b);
                break;
        }
    }
}
