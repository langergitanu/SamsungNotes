package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HashTagMode extends BaseMode {
    private static final String TAG = "HashTagMode";

    public HashTagMode(ModeParams modeParams) {
        super(modeParams);
    }

    private boolean isSupportedEditMode() {
        int caller = this.mPresenter.getStateInfo().getCaller();
        return caller == 0 || caller == 1 || caller == 13 || caller == 2;
    }

    private void onNavigateUp() {
        clearSelectedTag();
        finishActivity();
    }

    public boolean clearSelectedTag() {
        if (this.mPresenter.getStateInfo().getSelectedTags().isEmpty()) {
            return false;
        }
        this.mPresenter.onHashTagSelected(new HashSet());
        return true;
    }

    public void finishActivity() {
        AbsFragment absFragment = this.mFragment;
        if (absFragment == null) {
            return;
        }
        FragmentActivity activity = absFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.finish();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.impl.AbsEditModeView.Contract
    public int getModeIndex() {
        return 18;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onBackKeyDown() {
        if (clearSelectedTag()) {
            return true;
        }
        if (NotesUtils.isTabletLayout(this.mContext) || !super.onBackKeyDown()) {
            return this.mNotesView.setMode(3);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C8003R.menu.noteslist_select, menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onCustomKeyEvent(int i, KeyEvent keyEvent) {
        if (i != 34) {
            if (i == 84) {
                return this.mNotesView.setMode(3);
            }
        } else if ((keyEvent.getMetaState() & 4096) == 4096) {
            return this.mNotesView.setMode(3);
        }
        return super.onCustomKeyEvent(i, keyEvent);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode
    public void onDataChangedBase(int i) {
        super.onDataChangedBase(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public AdapterManager.DataState onDataChangedByMode(List<MainListDocumentData> list) {
        this.mPresenter.getSearchHelper().searchTagNotesData(this.mPresenter.getStateInfo().getSelectedTags());
        return AdapterManager.DataState.NOT_USED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onDataChangedViewUpdate(int i) {
        super.onDataChangedViewUpdate(i);
        setToolbarSubTitle();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onItemLongPressed(String str) {
        if (!isSupportedEditMode()) {
            return false;
        }
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_HASHTAG_NOTES, NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_NOTESLIST_SELECTION_MODE : NotesSAConstants.EVENT_NOTESLIST_SELECTION_MODE);
        CommonSamsungAnalytics.insertLog("122");
        setEditMode(true);
        super.onItemLongPressed(str);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onLayout() {
        super.onLayout();
        setTipCard(1);
        this.mActionMenuController.setDisplayHomeAsUpEnabled(true);
        setToolbarTitle();
        setToolbarSubTitle();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.MemoList;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onNavigateUp();
        } else if (itemId == C8003R.id.action_edit) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_HASHTAG_NOTES, NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_NOTESLIST_EDIT : NotesSAConstants.EVENT_NOTESLIST_EDIT);
            CommonSamsungAnalytics.insertLog("122");
            setEditMode(true);
        } else if (itemId == C8003R.id.action_viewby) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_HASHTAG_NOTES, NotesUtils.isTabletLayout(this.mContext) ? NotesSAConstants.EVENT_TABLET_NOTESLIST_VIEW_BY : NotesSAConstants.EVENT_NOTESLIST_VIEW_BY);
            this.mPresenter.showViewByPopupMenu();
        } else {
            if (itemId != C8003R.id.action_sortby) {
                AbstractC8014b.m7201c(itemId, "unexpected itemId: ", getTag());
                return false;
            }
            this.mPresenter.showSortByDialog();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public void onPrepareOptionsMenu(Menu menu) {
        menu.removeItem(C8003R.id.action_search);
        menu.removeItem(C8003R.id.action_pin_to_favorites);
        menu.removeItem(C8003R.id.action_add_folder);
        if (isSupportedEditMode()) {
            return;
        }
        menu.removeItem(C8003R.id.action_edit);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.listener.ViewContract.IMode
    public boolean setEditMode(boolean z) {
        super.setEditMode(z);
        return this.mNotesView.setMode(19);
    }

    public void setTipCard(int i) {
        if (hasCreatePostLogic()) {
            return;
        }
        AbstractC8014b.m7201c(i, "setTipCard# caller : ", getTag());
        this.mPresenter.getTipCardHelper().clearTipCard(true);
    }

    public void setToolbarSubTitle() {
        int commonDisplayListSize = this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]);
        this.mActionMenuController.setToolbarSubTitle(commonDisplayListSize <= 0 ? "" : this.mAppContext.getResources().getQuantityString(C8003R.plurals.plurals_count_notes, commonDisplayListSize, Integer.valueOf(commonDisplayListSize)));
    }

    public void setToolbarTitle() {
        this.mActionMenuController.setToolbarTitle(C8003R.string.tags_title);
    }
}
