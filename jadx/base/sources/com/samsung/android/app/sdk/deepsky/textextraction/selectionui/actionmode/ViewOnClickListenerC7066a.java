package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuMorePopup;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.actionmode.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnClickListenerC7066a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4751a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4752b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4753c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4754d;

    public /* synthetic */ ViewOnClickListenerC7066a(Object obj, int i, Object obj2, Object obj3) {
        this.f4751a = i;
        this.f4752b = obj;
        this.f4753c = obj2;
        this.f4754d = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4751a) {
            case 0:
                TextActionModeCallback.createIntentOnClickListener$lambda$3((PendingIntent) this.f4752b, (TextActionModeCallback) this.f4753c, (Intent) this.f4754d, view);
                break;
            default:
                ((OptionMenuMorePopup) this.f4752b).lambda$getIconMenuView$0((MenuItem) this.f4753c, (ConstraintLayout) this.f4754d, view);
                break;
        }
    }
}
