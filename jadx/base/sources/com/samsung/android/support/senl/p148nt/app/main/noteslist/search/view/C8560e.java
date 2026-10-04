package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FlexboxHashTagView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FlexboxSearchView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8560e implements FlexboxSearchView.Listener, FlexboxHashTagView.Listener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RecentSearchListFragment f6253a;

    public /* synthetic */ C8560e(RecentSearchListFragment recentSearchListFragment) {
        this.f6253a = recentSearchListFragment;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FlexboxHashTagView.Listener
    public void onHashTagSelected(String str) {
        this.f6253a.lambda$onCreateView$1(str);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.FlexboxSearchView.Listener
    public void onKeywordSelected(String str) {
        this.f6253a.lambda$onCreateView$0(str);
    }
}
