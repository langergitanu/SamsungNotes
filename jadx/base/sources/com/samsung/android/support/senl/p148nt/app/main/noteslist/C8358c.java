package com.samsung.android.support.senl.p148nt.app.main.noteslist;

import com.samsung.android.support.notes.bixby.BixbyManagerContract;
import com.samsung.android.support.notes.bixby.bixby2.contract.INoteFragmentBixby2;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.Bixby2;
import com.samsung.android.support.senl.p148nt.model.domain.note.UpdateNoteUseCase;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8358c implements BixbyManagerContract.INoteFragment, UpdateNoteUseCase.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6177a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6178b;

    public /* synthetic */ C8358c(Object obj, int i) {
        this.f6177a = i;
        this.f6178b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.model.domain.note.UpdateNoteUseCase.Callback
    public void handleOpenedNote(UpdateNoteUseCase.UpdateNoteParam updateNoteParam) {
        ((Bixby2.UpdateAsync) this.f6178b).lambda$backgroundOperation$0(updateNoteParam);
    }

    @Override // com.samsung.android.support.notes.bixby.BixbyManagerContract.INoteFragment
    public INoteFragmentBixby2 registerNoteFragmentBixby2() {
        switch (this.f6177a) {
            case 0:
                return ((NotesFragment) this.f6178b).lambda$onViewCreated$0();
            default:
                return ((NotesFragment) this.f6178b).lambda$onResume$3();
        }
    }
}
