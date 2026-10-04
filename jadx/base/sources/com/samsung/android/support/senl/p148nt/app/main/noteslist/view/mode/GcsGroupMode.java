package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.FragmentContract;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupFragment;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupHolder;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupMode extends GcsBaseMode {
    private static final String TAG = "GcsGroupMode";

    public GcsGroupMode(ModeParams modeParams) {
        super(modeParams);
    }

    private void addGcsGroupFragment() {
        MainLogger.m7254d(TAG, "addGcsGroupFragment");
        FragmentManager supportFragmentManager = this.mFragment.getActivity().getSupportFragmentManager();
        GcsGroupFragment gcsGroupFragment = (GcsGroupFragment) supportFragmentManager.findFragmentByTag(GcsGroupFragment.TAG);
        if (gcsGroupFragment == null) {
            gcsGroupFragment = new GcsGroupFragment();
            supportFragmentManager.beginTransaction().add(C8003R.id.notes_fragment_container, gcsGroupFragment, GcsGroupFragment.TAG).commitAllowingStateLoss();
        } else {
            supportFragmentManager.beginTransaction().detach(gcsGroupFragment).commitAllowingStateLoss();
            supportFragmentManager.beginTransaction().attach(gcsGroupFragment).commitAllowingStateLoss();
        }
        gcsGroupFragment.setContract(new FragmentContract() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.GcsGroupMode.1
            @Override // com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.FragmentContract
            public void finish(String str) {
                AbstractC8014b.m7209k("finish# ", str, GcsGroupMode.TAG);
                GcsGroupMode.this.onBackKeyDown();
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.FragmentContract
            public void onSpaceSelected(GcsGroupHolder gcsGroupHolder) {
                GcsGroupMode.this.mNotesView.setIsScrollToTop(true, 0);
                GcsGroupMode.this.mPresenter.getStateInfo().setSpaceId(gcsGroupHolder.getSpaceId());
                GcsGroupMode.this.mPresenter.getStateInfo().setGroupId(gcsGroupHolder.getGroupID());
                GcsGroupMode.this.mNotesView.setMode(10);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.FragmentContract
            public void setNoNoteLayoutVisible(View view) {
                GcsGroupMode.this.mActionMenuController.setVerticalView(view);
            }
        });
    }

    private void removeGcsGroupFragment() {
        MainLogger.m7254d(TAG, "removeGcsGroupFragment");
        FragmentManager supportFragmentManager = this.mFragment.getActivity().getSupportFragmentManager();
        GcsGroupFragment gcsGroupFragment = (GcsGroupFragment) supportFragmentManager.findFragmentByTag(GcsGroupFragment.TAG);
        if (gcsGroupFragment != null) {
            supportFragmentManager.beginTransaction().remove(gcsGroupFragment).commitAllowingStateLoss();
        }
    }

    private void updateGroupList() {
        MainLogger.m7258i(TAG, "updateGroupList()");
        GcsGroupFragment gcsGroupFragment = (GcsGroupFragment) this.mActivity.getSupportFragmentManager().findFragmentByTag(GcsGroupFragment.TAG);
        if (gcsGroupFragment != null) {
            gcsGroupFragment.restartLoader();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 24;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 8:
                if (i2 == -1) {
                    MainLogger.m7254d(TAG, "REQUEST_INTENT_SOCIAL_SIGN_UP result OK");
                    updateGroupList();
                }
                break;
            case 9:
                if (i2 != 1) {
                    updateGroupList();
                } else {
                    MainLogger.m7255e(TAG, "REQUEST_INTENT_SPACE_NOTE_LIST Error");
                    onBackKeyDown();
                }
                break;
            case 10:
                if (i2 == 1) {
                    MainLogger.m7255e(TAG, "REQUEST_INTENT_INVITATION_LIST Error");
                    onBackKeyDown();
                }
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (!NotesUtils.isTabletLayout(this.mContext) && super.onBackKeyDown()) {
            return true;
        }
        if (NotesUtils.isCoeditFeatureEnabled(this.mAppContext)) {
            this.mNotesView.onFolderSelected(FolderConstants.Coedit.UUID);
        } else {
            this.mNotesView.onFolderSelected(FolderConstants.AllNotes.UUID);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        return AdapterManager.DataState.NOT_USED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        setNoHolderLayout();
        this.mActionMenuController.setToolbarTitle(C8003R.string.shared_notebooks);
        this.mActionMenuController.setToolbarSubTitle((String) null);
        addGcsGroupFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode, com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onModeEnd() {
        super.onModeEnd();
        removeGcsGroupFragment();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.GcsImpl
    public void onNewNote(String str, int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode
    public boolean onSesSessionConnected() {
        boolean zOnSesSessionConnected = super.onSesSessionConnected();
        AbstractC8014b.m7210l("onSesSessionConnected# ret : ", TAG, zOnSesSessionConnected);
        return zOnSesSessionConnected;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsBaseMode
    public void reconnectShareContentProvider() {
        updateGroupList();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void setNoHolderLayout() {
        if (this.mNoHolderLayout == null) {
            this.mNoHolderLayout = (ViewGroup) ViewModeUtils.getInflatedView(this.mFragment.getView(), C8003R.id.no_note_layout, C8003R.id.inflate_no_note_layout);
        }
        this.mNoHolderLayout.setVisibility(8);
    }
}
