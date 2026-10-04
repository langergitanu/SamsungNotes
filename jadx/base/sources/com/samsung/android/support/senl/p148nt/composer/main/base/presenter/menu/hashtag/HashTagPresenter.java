package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.hashtag;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.documents.data.TagData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagPresenter implements HashTagContract.Presenter {
    private static final String TAG = Logger.createTag("HashTagPresenter");
    private DialogPresenterManager mDialogPresenterManager;
    private List<String> mEmptyTagList = new ArrayList(1);
    private HashTagController mHashTagController;
    private ComposerModel mModel;
    private ComposerViewPresenter mPresenter;
    private HashTagContract.View mView;

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public List<String> getTagList() {
        HashTagController hashTagController = this.mHashTagController;
        return hashTagController != null ? hashTagController.getTagList() : this.mEmptyTagList;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public HashTagContract.View getView() {
        return this.mView;
    }

    public void init(ComposerModel composerModel, HashTagController hashTagController, DialogPresenterManager dialogPresenterManager, ComposerViewPresenter composerViewPresenter) {
        Logger.m10999d(TAG, "init#");
        this.mModel = composerModel;
        this.mPresenter = composerViewPresenter;
        this.mHashTagController = hashTagController;
        hashTagController.initPresenter(this);
        this.mDialogPresenterManager = dialogPresenterManager;
    }

    public void onDetachView() {
        Logger.m10999d(TAG, "onDetachView#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void onHashTagAdded(String str) {
        HashTagController hashTagController = this.mHashTagController;
        if (hashTagController != null) {
            hashTagController.onHashTagAdded(str);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void onHashTagClicked(Context context, String str) {
        String str2 = TAG;
        AbstractC8014b.m7196B("onHashTagClicked# ", str, str2);
        if (this.mModel.getNotesDocEntityManager().isDeleted()) {
            return;
        }
        if (this.mModel.getModeManager().isEditMode()) {
            this.mDialogPresenterManager.showHashTagRenameDialog(str);
        } else if (this.mHashTagController != null) {
            if (NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getAllWithTag(new SortParam.SortParamBuilder().build()).isEmpty()) {
                Logger.m11000e(str2, "onHashTagClicked# no tag note");
            } else {
                this.mHashTagController.executeHashNotesActivity(str);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void onHashTagRemoved(String str) {
        HashTagController hashTagController = this.mHashTagController;
        if (hashTagController != null) {
            hashTagController.onHashTagRemoved(str);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void onHashTagRenamed(String str, String str2) {
        HashTagController hashTagController = this.mHashTagController;
        if (hashTagController != null) {
            hashTagController.onHashTagRenameed(str, str2);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void saveTagList(List<TagData> list) {
        HashTagController hashTagController = this.mHashTagController;
        if (hashTagController != null) {
            hashTagController.saveHashTagList(list);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void setTagListToComposerView(List<String> list) {
        ComposerViewPresenter composerViewPresenter = this.mPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.setTagList(list);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.Presenter
    public void setView(HashTagContract.View view) {
        this.mView = view;
    }
}
