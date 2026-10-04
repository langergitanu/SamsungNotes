package com.samsung.android.support.senl.p148nt.app.main.common.handoff;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.NotesView;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.model.MainHandoffData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.handoff.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8212b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6155a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f6156b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f6157c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f6158d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f6159e;

    public /* synthetic */ RunnableC8212b(MainHandoffData mainHandoffData, int i, MainHandoffManager mainHandoffManager, int i2) {
        this.f6155a = 0;
        this.f6158d = mainHandoffData;
        this.f6156b = i;
        this.f6159e = mainHandoffManager;
        this.f6157c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        switch (this.f6155a) {
            case 0:
                MainHandoffManager.sendHandoffAction$lambda$1((MainHandoffData) this.f6158d, this.f6156b, (MainHandoffManager) this.f6159e, this.f6157c);
                break;
            case 1:
                ((Bixby2.NoteFragmentBixby2) this.f6158d).lambda$shareNotes$1(this.f6156b, this.f6157c, (Map) this.f6159e);
                break;
            case 2:
                ((NotesView) this.f6158d).lambda$getUpdateRunnable$4(this.f6156b, this.f6157c, (String) this.f6159e);
                break;
            default:
                StickyMemoManager.OnPageUpdateListenerImpl.onUpdatePage$lambda$0((StickyMemoManager.OnPageUpdateListenerImpl) this.f6158d, this.f6156b, this.f6157c, (StickyMemoManager) this.f6159e);
                break;
        }
    }

    public /* synthetic */ RunnableC8212b(Object obj, int i, int i2, Object obj2, int i4) {
        this.f6155a = i4;
        this.f6158d = obj;
        this.f6156b = i;
        this.f6157c = i2;
        this.f6159e = obj2;
    }
}
