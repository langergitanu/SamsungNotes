package com.samsung.android.support.senl.p148nt.base.winset.app.picker.image;

import android.view.View;
import android.widget.AdapterView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuMorePopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page.PageRatioSettingView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.winset.app.picker.image.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8971a implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6500a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6501b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6502c;

    public /* synthetic */ C8971a(Object obj, Object obj2, int i) {
        this.f6500a = i;
        this.f6501b = obj;
        this.f6502c = obj2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.f6500a) {
            case 0:
                ImagePicker.showDialog$lambda$3((ImagePicker) this.f6501b, (Integer) this.f6502c, adapterView, view, i, j);
                break;
            case 1:
                ((OptionMenuMorePopup) this.f6501b).lambda$getSubMenuItemClickListener$1((List) this.f6502c, adapterView, view, i, j);
                break;
            default:
                ((PageRatioSettingView) this.f6501b).lambda$initPageRatio$0((ArrayList) this.f6502c, adapterView, view, i, j);
                break;
        }
    }
}
