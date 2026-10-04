package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.CustomSwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ViewParams {
    private static final String TAG = "ViewParams";
    private final AbsFragment absFragment;
    private final Context context;
    private final DialogViewContract.IDialogCreator dialogCreator;
    private final NotesPenRecyclerView notesRecyclerView;
    private final ViewContract.IView notesView;
    private final CustomSwipeRefreshLayout swipeRefreshLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ViewParamsBuilder {
        private AbsFragment absFragment;
        private DialogViewContract.IDialogCreator dialogCreator;
        private NotesPenRecyclerView notesRecyclerView;
        private ViewContract.IView notesView;
        private CustomSwipeRefreshLayout swipeRefreshLayout;

        public ViewParams build() {
            return new ViewParams(this);
        }

        public ViewParamsBuilder setAbsFragment(AbsFragment absFragment) {
            this.absFragment = absFragment;
            return this;
        }

        public ViewParamsBuilder setDialogCreator(DialogViewContract.IDialogCreator iDialogCreator) {
            this.dialogCreator = iDialogCreator;
            return this;
        }

        public ViewParamsBuilder setNotesListContainer(CustomSwipeRefreshLayout customSwipeRefreshLayout) {
            this.swipeRefreshLayout = customSwipeRefreshLayout;
            return this;
        }

        public ViewParamsBuilder setNotesRecyclerView(NotesPenRecyclerView notesPenRecyclerView) {
            this.notesRecyclerView = notesPenRecyclerView;
            return this;
        }

        public ViewParamsBuilder setNotesView(ViewContract.IView iView) {
            this.notesView = iView;
            return this;
        }
    }

    public ViewParams(ViewParamsBuilder viewParamsBuilder) {
        AbsFragment absFragment = viewParamsBuilder.absFragment;
        this.absFragment = absFragment;
        this.notesView = viewParamsBuilder.notesView;
        this.notesRecyclerView = viewParamsBuilder.notesRecyclerView;
        this.swipeRefreshLayout = viewParamsBuilder.swipeRefreshLayout;
        this.dialogCreator = viewParamsBuilder.dialogCreator;
        this.context = absFragment.getContext();
    }

    public AbsFragment getAbsFragment() {
        return this.absFragment;
    }

    public Context getContext() {
        return this.context;
    }

    public DialogViewContract.IDialogCreator getDialogCreator() {
        return this.dialogCreator;
    }

    public int getModeIndex() {
        ViewContract.IView iView = this.notesView;
        if (iView != null) {
            return iView.getModeIndex();
        }
        MainLogger.m7255e(TAG, "getModeIndex# notesView is null");
        return 1;
    }

    public CustomSwipeRefreshLayout getNotesListContainer() {
        return this.swipeRefreshLayout;
    }

    public NotesPenRecyclerView getNotesRecyclerView() {
        return this.notesRecyclerView;
    }

    public ViewContract.IView getNotesView() {
        return this.notesView;
    }
}
