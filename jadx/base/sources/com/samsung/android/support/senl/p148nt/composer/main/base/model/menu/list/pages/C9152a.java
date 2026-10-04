package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages;

import androidx.lifecycle.Observer;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.CursorProvider;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9152a implements Observer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6772a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6773b;

    public /* synthetic */ C9152a(Object obj, int i) {
        this.f6772a = i;
        this.f6773b = obj;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        switch (this.f6772a) {
            case 0:
                ((BookmarkEntityManager) this.f6773b).lambda$updatePageRepositoryObserver$0((List) obj);
                break;
            default:
                CursorProvider.mListObserver$lambda$0((CursorProvider) this.f6773b, (List) obj);
                break;
        }
    }
}
