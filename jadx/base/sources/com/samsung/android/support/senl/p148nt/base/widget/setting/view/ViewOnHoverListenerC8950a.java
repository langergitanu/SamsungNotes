package com.samsung.android.support.senl.p148nt.base.widget.setting.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolAiMenu;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.widget.setting.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnHoverListenerC8950a implements View.OnHoverListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6491a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6492b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6493c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f6494d;

    public /* synthetic */ ViewOnHoverListenerC8950a(Object obj, int i, Object obj2, Object obj3) {
        this.f6491a = i;
        this.f6492b = obj;
        this.f6493c = obj2;
        this.f6494d = obj3;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        switch (this.f6491a) {
            case 0:
                return BaseWidgetSettingView.initOpacityViewOneUi7x$lambda$0((BaseWidgetSettingView) this.f6492b, (Resources) this.f6493c, (Drawable) this.f6494d, view, motionEvent);
            default:
                return QuickToolAiMenu.makeImageBtn$lambda$10((QuickToolAiMenu) this.f6492b, (String) this.f6493c, (ImageButton) this.f6494d, view, motionEvent);
        }
    }
}
