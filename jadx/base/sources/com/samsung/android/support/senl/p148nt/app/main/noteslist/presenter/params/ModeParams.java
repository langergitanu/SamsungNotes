package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params;

import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.ModeContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ModeParams {
    private ActionMenuController actionMenuController;
    private BottomMenuController bottomMenuController;
    private ModeContract.IFragment fragmentContract;
    private NotesPenRecyclerView notesRecyclerView;
    private ModeContract.IView notesView;
    private NotesPresenter presenter;

    public ActionMenuController getActionMenuController() {
        return this.actionMenuController;
    }

    public BottomMenuController getBottomMenuController() {
        return this.bottomMenuController;
    }

    public ModeContract.IFragment getFragmentContract() {
        return this.fragmentContract;
    }

    public NotesPenRecyclerView getNotesRecyclerView() {
        return this.notesRecyclerView;
    }

    public ModeContract.IView getNotesView() {
        return this.notesView;
    }

    public NotesPresenter getPresenter() {
        return this.presenter;
    }

    public ModeParams setActionMenuController(ActionMenuController actionMenuController) {
        this.actionMenuController = actionMenuController;
        return this;
    }

    public ModeParams setBottomMenuController(BottomMenuController bottomMenuController) {
        this.bottomMenuController = bottomMenuController;
        return this;
    }

    public ModeParams setFragmentContract(ModeContract.IFragment iFragment) {
        this.fragmentContract = iFragment;
        return this;
    }

    public ModeParams setNotesRecyclerView(NotesPenRecyclerView notesPenRecyclerView) {
        this.notesRecyclerView = notesPenRecyclerView;
        return this;
    }

    public ModeParams setNotesView(ModeContract.IView iView) {
        this.notesView = iView;
        return this;
    }

    public ModeParams setPresenter(NotesPresenter notesPresenter) {
        this.presenter = notesPresenter;
        return this;
    }
}
