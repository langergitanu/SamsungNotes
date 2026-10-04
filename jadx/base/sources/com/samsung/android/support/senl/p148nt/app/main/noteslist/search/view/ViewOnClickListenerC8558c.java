package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC8558c implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6249a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesSearchView f6250b;

    public /* synthetic */ ViewOnClickListenerC8558c(NotesSearchView notesSearchView, int i) {
        this.f6249a = i;
        this.f6250b = notesSearchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6249a) {
            case 0:
                this.f6250b.lambda$setSearchMoreVisibility$6(view);
                break;
            case 1:
                this.f6250b.lambda$init$0(view);
                break;
            default:
                this.f6250b.lambda$init$1(view);
                break;
        }
    }
}
