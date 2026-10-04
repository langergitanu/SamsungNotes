package com.samsung.android.sdk.pen.setting.quicktool;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTCircleConsumer;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.quicktool.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnHoverListenerC7652d implements View.OnHoverListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5081a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5082b;

    public /* synthetic */ ViewOnHoverListenerC7652d(Object obj, int i) {
        this.f5081a = i;
        this.f5082b = obj;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        switch (this.f5081a) {
            case 0:
                return SpenQTCircleConsumer.mOnConsumedHoverListener$lambda$1((SpenQTCircleConsumer) this.f5082b, view, motionEvent);
            default:
                return QTCircleConsumer.mOnConsumedHoverListener$lambda$1((QTCircleConsumer) this.f5082b, view, motionEvent);
        }
    }
}
