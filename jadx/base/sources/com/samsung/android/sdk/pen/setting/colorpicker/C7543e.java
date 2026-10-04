package com.samsung.android.sdk.pen.setting.colorpicker;

import android.view.View;
import android.widget.AdapterView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemHolder;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpicker.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7543e implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5023a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5024b;

    public /* synthetic */ C7543e(Object obj, int i) {
        this.f5023a = i;
        this.f5024b = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.f5023a) {
            case 0:
                SpenColorSwatchView.mSwatchItemClickListener$lambda$0((SpenColorSwatchView) this.f5024b, adapterView, view, i, j);
                break;
            default:
                CustomToolbarItemHolder.initListPopupWindow$lambda$3((CustomToolbarItemHolder) this.f5024b, adapterView, view, i, j);
                break;
        }
    }
}
