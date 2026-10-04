package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import com.samsung.android.support.senl.p148nt.app.main.livesharing.LiveSharingHelper;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ExternalAccessCallback;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8413e implements ExternalAccessCallback, LiveSharingHelper.ITipCard {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ NotesPresenter f6190a;

    public /* synthetic */ C8413e(NotesPresenter notesPresenter) {
        this.f6190a = notesPresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ExternalAccessCallback
    public void filtered(List list) {
        this.f6190a.lambda$duplicateToDevice$4(list);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.livesharing.LiveSharingHelper.ITipCard
    public void setMeetTipCard(int i) {
        this.f6190a.lambda$checkLiveSharingStatus$1(i);
    }
}
