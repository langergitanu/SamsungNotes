package com.samsung.android.support.senl.p148nt.composer.main.cover;

import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.BadgeListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.ColorListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.StyleListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.TemplateListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.TypeListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.view.CoverTabView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10921a implements BadgeListAdapter.PreviewContract, TypeListAdapter.TypeContract, StyleListAdapter.PreviewContract, TemplateListAdapter.TemplateContract, ColorListAdapter.ColorContract, CoverTabView.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CoverCreator f7332a;

    public /* synthetic */ C10921a(CoverCreator coverCreator) {
        this.f7332a = coverCreator;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.StyleListAdapter.PreviewContract
    public void onSelectBackground(String str) {
        this.f7332a.lambda$initColorAdapter$8(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.ColorListAdapter.ColorContract
    public void onSelectColor(int i, String str) {
        this.f7332a.lambda$initColorListAdapter$4(i, str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.BadgeListAdapter.PreviewContract
    public void onSelectPosition(String str) {
        this.f7332a.lambda$initCategoryAdapter$7(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.TemplateListAdapter.TemplateContract
    public void onSelectTemplate(int i, String str) {
        this.f7332a.lambda$initTemplateListAdapter$3(i, str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.TypeListAdapter.TypeContract
    public void onSelectType(int i) {
        this.f7332a.lambda$initTypeListAdapter$1(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.cover.view.CoverTabView.Contract
    public void onTabSelected(int i) {
        this.f7332a.lambda$initTabLayout$5(i);
    }
}
