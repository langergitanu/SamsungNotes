package com.google.android.material.oneui.floatingdock.controller;

import android.view.MotionEvent;
import androidx.core.util.Predicate;

/* JADX INFO: renamed from: com.google.android.material.oneui.floatingdock.controller.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4792a implements Predicate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2332a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DragHandlerController f2333b;

    public /* synthetic */ C4792a(DragHandlerController dragHandlerController, int i) {
        this.f2332a = i;
        this.f2333b = dragHandlerController;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f2332a) {
            case 0:
                return DragHandlerController.onInterceptTouchEvent$lambda$0(this.f2333b, (MotionEvent) obj);
            default:
                return DragHandlerController.onTouchEvent$lambda$2(this.f2333b, (MotionEvent) obj);
        }
    }
}
