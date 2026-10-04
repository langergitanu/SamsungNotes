package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.FolderViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.NoteInfoViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit.TitleCoeditAddMember;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.tag.TagListView;
import p054M1.DialogInterfaceOnDismissListenerC0177d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleEditorDialog {
    public static final float DEFAULT_ALPHA = 1.0f;
    private final AlertDialog mDialog;
    private Favorite mFavorite;
    private NoteInfoViewManager mNoteInfoViewManager;
    private TagListView mTagListView;
    private final TitleEditorPresenter mTitleEditorPresenter;
    private TitleViewManager mTitleViewManager;
    private final ICustomToolbar mToolbar;

    public TitleEditorDialog(AppCompatActivity appCompatActivity, TitleEditorPresenter titleEditorPresenter, ICustomToolbar iCustomToolbar) {
        this.mTitleEditorPresenter = titleEditorPresenter;
        this.mToolbar = iCustomToolbar;
        this.mDialog = createDialog(appCompatActivity);
    }

    private AlertDialog createDialog(final AppCompatActivity appCompatActivity) {
        View viewInflate = LayoutInflater.from(appCompatActivity).inflate(C9086R.layout.comp_title_dialog_layout, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(appCompatActivity).create();
        alertDialogCreate.setView(viewInflate);
        View viewFindViewById = viewInflate.findViewById(C9086R.id.comp_title_container);
        TitleViewManager titleViewManager = new TitleViewManager(appCompatActivity, this.mToolbar, viewFindViewById, this.mTitleEditorPresenter, null);
        this.mTitleViewManager = titleViewManager;
        titleViewManager.init();
        Favorite favorite = new Favorite(viewFindViewById, this.mTitleEditorPresenter);
        this.mFavorite = favorite;
        favorite.init(1.0f);
        new TitleCoeditAddMember(viewFindViewById, this.mTitleEditorPresenter).init(1.0f);
        View viewFindViewById2 = viewInflate.findViewById(C9086R.id.comp_title_folder_container);
        new FolderViewManager(viewFindViewById2, this.mTitleEditorPresenter.getKeyguardPresenter(), new FolderViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorDialog.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.FolderViewManager.Contract
            public AppCompatActivity getActivity() {
                return appCompatActivity;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.FolderViewManager.Contract
            public TitleEditorPresenter getPresenter() {
                return TitleEditorDialog.this.mTitleEditorPresenter;
            }
        }).init(viewFindViewById2, alertDialogCreate);
        TagListView tagListView = new TagListView();
        this.mTagListView = tagListView;
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        tagListView.init(viewGroup, this.mTitleEditorPresenter.getHashTagPresenter(), 1.0f);
        NoteInfoViewManager noteInfoViewManager = new NoteInfoViewManager(viewInflate.findViewById(C9086R.id.comp_title_info_container), new NoteInfoViewManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleEditorDialog.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.NoteInfoViewManager.Contract
            public AppCompatActivity getActivity() {
                return appCompatActivity;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.NoteInfoViewManager.Contract
            public TitleEditorPresenter getPresenter() {
                return TitleEditorDialog.this.mTitleEditorPresenter;
            }
        });
        this.mNoteInfoViewManager = noteInfoViewManager;
        noteInfoViewManager.initInfoTextViews();
        new TitleCoeditMemberListView().init(viewGroup, this.mTitleEditorPresenter);
        alertDialogCreate.setOnDismissListener(new DialogInterfaceOnDismissListenerC0177d(this, 10));
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDialog$0(DialogInterface dialogInterface) {
        this.mTitleEditorPresenter.setTitle(this.mTitleViewManager.getTitleText(), true);
    }

    private void setAnchor(View view) {
        AlertDialogWrapper.setAnchorView(this.mDialog, view, AlertDialogWrapper.AnchorType.getTOOLBAR());
        AlertDialogWrapper.anchorLayoutStyle(this.mDialog);
    }

    public Favorite getFavorite() {
        return this.mFavorite;
    }

    public void hide() {
        this.mDialog.hide();
    }

    public void initFavorite() {
        this.mFavorite.updateState(this.mTitleEditorPresenter.isFavorite(), false);
    }

    public void initNoteInfo() {
        this.mNoteInfoViewManager.updateInfoContainer();
    }

    public void initTagList() {
        this.mTagListView.setEditable(this.mTitleEditorPresenter.isEditMode());
        this.mTagListView.updateTagListView();
    }

    public void initTitle() {
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    public void show(View view) {
        initTitle();
        initFavorite();
        initNoteInfo();
        initTagList();
        setAnchor(view);
        this.mDialog.show();
    }
}
