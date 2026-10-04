package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import java.util.ArrayList;
import java.util.Iterator;
import p079T.AbstractC0291i;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditEditModeView extends AbsEditModeView {
    private static final String TAG = "NormalEditModeView";
    boolean mIsStandaloneNote;

    public CoeditEditModeView(ModeParams modeParams, AbsEditModeView.Contract contract, boolean z) {
        super(modeParams, contract);
        this.mIsStandaloneNote = z;
    }

    private boolean checkCanDelete() {
        C0283a.m562d().getClass();
        String strM561c = C0283a.m561c();
        if (strM561c == null) {
            return false;
        }
        for (String str : this.mPresenter.getCheckedNotesUUID()) {
            MainListDocumentData noteData = this.mPresenter.getDocumentMap().getNoteData(str);
            if (noteData != null) {
                if (TextUtils.isEmpty(noteData.getMdeItemId())) {
                    return true;
                }
                if (AbstractC0291i.m569f(str)) {
                    return false;
                }
                String coeditNoteCreatorId = SesCoeditShareReadResolver.getInstance().getCoeditNoteCreatorId(this.mFragment.getContext(), noteData.getMdeSpaceId(), noteData.getMdeItemId());
                boolean standAlone = SesCoeditShareReadResolver.getInstance().getStandAlone(noteData.getMdeSpaceId());
                if (!strM561c.equals(coeditNoteCreatorId) || standAlone) {
                    if (!SesCoeditGroupReadResolver.getInstance().isGroupLeaderByMemberId(noteData.getMdeGroupId(), strM561c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isFakeNoteChecked() {
        ArrayList<String> checkedNotesUUID = this.mPresenter.getCheckedNotesUUID();
        if (checkedNotesUUID == null) {
            return false;
        }
        Iterator<String> it = checkedNotesUUID.iterator();
        while (it.hasNext()) {
            CoeditMainListEntry coeditNoteData = this.mPresenter.getDocumentMap().getCoeditNoteData(it.next());
            if (coeditNoteData != null && coeditNoteData.getType() == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onPrepareOptionsMenu$0(MenuItem menuItem) {
        return this.mModeParams.getNotesView().getMode().onOptionsItemSelected(menuItem);
    }

    private void onOptionsItemSelectedSALogging(int i) {
        int modeIndex = this.mContract.getModeIndex();
        if (modeIndex == 13) {
            if (i == C8003R.id.action_delete) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_MAIN_EDIT_DELETE, this.mPresenter.getCheckedNotesCount());
                return;
            }
            if (i == C8003R.id.action_save_to_device) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_MAIN_EDIT_SAVE_TO_DEVICE);
                return;
            } else if (i == C8003R.id.action_save_as_file) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_MAIN_EDIT_SAVE_AS_FILE);
                return;
            } else {
                if (i == C8003R.id.action_share) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_MAIN_EDIT_SHARE);
                    return;
                }
                return;
            }
        }
        if (modeIndex == 15) {
            if (i == C8003R.id.action_delete) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_EDIT_DELETE, this.mPresenter.getCheckedNotesCount());
                return;
            }
            if (i == C8003R.id.action_save_to_device) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_EDIT_SAVE_TO_DEVICE);
            } else if (i == C8003R.id.action_save_as_file) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_EDIT_SAVE_AS_FILE);
            } else if (i == C8003R.id.action_share) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE, NotesSAConstants.EVENT_COEDIT_SPACE_EDIT_SHARE);
            }
        }
    }

    private void updateDeleteMenu(Menu menu, int i, boolean z, boolean z2) {
        if (!z && !z2) {
            menu.removeItem(C8003R.id.action_delete);
            return;
        }
        MenuItem menuItemFindItem = menu.findItem(C8003R.id.action_delete);
        if (menuItemFindItem != null) {
            menuItemFindItem.setTitle(this.mPresenter.getDocumentMap().getCommonDisplayListSize(new String[0]) == i ? C8003R.string.action_delete_all : C8003R.string.action_delete);
            if (z) {
                return;
            }
            menuItemFindItem.setEnabled(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public long getCurrentOptionsMenuStatus() {
        return 0L;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public int getOptionMenuRes() {
        return isFakeNoteChecked() ? C8003R.menu.notelist_coedit_edit_menu_fake_note : C8003R.menu.notelist_coedit_edit_menu;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onFilteredOptionsMenu(Menu menu) {
        if (menu == null) {
            return;
        }
        int checkedDataCount = this.mPresenter.getCheckedDataCount();
        boolean zIsFakeNoteChecked = isFakeNoteChecked();
        boolean zCheckCanDelete = checkCanDelete();
        if (this.mIsStandaloneNote && checkedDataCount == 1 && !zCheckCanDelete) {
            MenuItem menuItemFindItem = menu.findItem(C8003R.id.action_leave_shared_note);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(true);
            }
            menu.removeItem(C8003R.id.action_delete);
        } else {
            updateDeleteMenu(menu, checkedDataCount, zCheckCanDelete, zIsFakeNoteChecked);
        }
        if (zIsFakeNoteChecked) {
            return;
        }
        MenuItem menuItemFindItem2 = menu.findItem(C8003R.id.action_switch_to_notebook);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setVisible(false);
        }
        if (checkedDataCount > 100) {
            menu.removeItem(C8003R.id.action_save_to_device);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        MainCoeditLogger.m7250d(TAG, "onOptionsItemSelectedCoeditEdit# " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        onOptionsItemSelectedSALogging(itemId);
        if (itemId == C8003R.id.action_delete) {
            this.mPresenter.showDeleteCoeditNotesDialog();
        } else if (itemId == C8003R.id.action_save_to_device) {
            this.mPresenter.duplicateToDevice();
        } else if (itemId == C8003R.id.action_save_as_file) {
            this.mPresenter.showExportOptionPopup(true);
        } else if (itemId == C8003R.id.action_share) {
            this.mPresenter.showExportOptionPopup(false);
        } else {
            if (itemId != C8003R.id.action_done) {
                return false;
            }
            this.mModeParams.getNotesView().getMode().releaseEditMode();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onPrepareContextMenu(Menu menu) {
        onFilteredOptionsMenu(menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.impl.AbsEditModeView
    public void onPrepareOptionsMenu() {
        if (this.mPresenter.getCheckedDataCount() == 0) {
            this.mBottomMenuController.showBottomNavigation(false);
            updateBasicEffect(false);
            return;
        }
        this.mBottomMenuController.inflateBottomNavigationMenu(getOptionMenuRes(), new C7737b(this, 15));
        if (!this.mModeParams.getNotesRecyclerView().isLongPressed()) {
            this.mBottomMenuController.showBottomNavigation(true);
            updateBasicEffect(true);
            this.mBottomMenuController.checkProgressCircle();
        }
        onFilteredOptionsMenu(this.mBottomMenuController.getBottomNavigationMenu());
    }
}
