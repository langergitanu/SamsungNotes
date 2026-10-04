package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuMorePopup;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC10395a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7174a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RecyclerView.Adapter f7175b;

    public /* synthetic */ ViewOnClickListenerC10395a(int i, RecyclerView.Adapter adapter) {
        this.f7174a = i;
        this.f7175b = adapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7174a) {
            case 0:
                ((OptionMenuMorePopup.CardMenuAdapter) this.f7175b).lambda$getOnClickListener$0(view);
                break;
            default:
                ((OptionMenuMorePopup.TextMenuAdapter) this.f7175b).lambda$onBindViewHolder$0(view);
                break;
        }
    }
}
