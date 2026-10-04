package com.samsung.android.support.senl.p148nt.app.main.noteslist.view;

import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ModeParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.BaseMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSearchMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSpaceEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.CoeditSpaceMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.EditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.GcsGroupMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagDetailMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.HashTagMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.OldCategoryMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.OldEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.OldSelectMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditSearchWidgetMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditWidgetMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RecycleBinSelectMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SearchEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SearchMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SelectMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SpaceSelectMode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ModeFactory {
    private static final String TAG = "ModeFactory";
    CoeditEditMode mCoeditEditMode;
    CoeditMode mCoeditMode;
    CoeditSpaceEditMode mCoeditSpaceEditMode;
    CoeditSpaceMode mCoeditSpaceMode;
    EditMode mEdit;
    HashTagEditMode mHashTagEditMode;
    HashTagMode mHashTagMode;
    final ModeParams mModeParams;
    OldEditMode mOldEditMode;
    OldSelectMode mOldSelectMode;
    PickEditMode mPickEditMode;
    PickEditSearchMode mPickEditSearchMode;
    PickEditSearchWidgetMode mPickEditSearchWidgetMode;
    PickEditWidgetMode mPickEditWidgetMode;
    PickMode mPickMode;
    RecycleBinEditMode mRecycleBinEdit;
    RecycleBinSelectMode mRecycleBinSelect;
    SearchEditMode mSearchEditMode;
    SearchMode mSearchMode;
    SelectMode mSelect;

    public ModeFactory(ModeParams modeParams) {
        this.mModeParams = modeParams;
    }

    public BaseMode getMode(int i) {
        switch (i) {
            case 1:
                SelectMode selectMode = this.mSelect;
                if (selectMode != null) {
                    return selectMode;
                }
                SelectMode selectMode2 = new SelectMode(this.mModeParams);
                this.mSelect = selectMode2;
                return selectMode2;
            case 2:
                EditMode editMode = this.mEdit;
                if (editMode != null) {
                    return editMode;
                }
                EditMode editMode2 = new EditMode(this.mModeParams);
                this.mEdit = editMode2;
                return editMode2;
            case 3:
                SearchMode searchMode = this.mSearchMode;
                if (searchMode != null) {
                    return searchMode;
                }
                SearchMode searchMode2 = new SearchMode(this.mModeParams);
                this.mSearchMode = searchMode2;
                return searchMode2;
            case 4:
                SearchEditMode searchEditMode = this.mSearchEditMode;
                if (searchEditMode != null) {
                    return searchEditMode;
                }
                SearchEditMode searchEditMode2 = new SearchEditMode(this.mModeParams);
                this.mSearchEditMode = searchEditMode2;
                return searchEditMode2;
            case 5:
                RecycleBinSelectMode recycleBinSelectMode = this.mRecycleBinSelect;
                if (recycleBinSelectMode != null) {
                    return recycleBinSelectMode;
                }
                RecycleBinSelectMode recycleBinSelectMode2 = new RecycleBinSelectMode(this.mModeParams);
                this.mRecycleBinSelect = recycleBinSelectMode2;
                return recycleBinSelectMode2;
            case 6:
                RecycleBinEditMode recycleBinEditMode = this.mRecycleBinEdit;
                if (recycleBinEditMode != null) {
                    return recycleBinEditMode;
                }
                RecycleBinEditMode recycleBinEditMode2 = new RecycleBinEditMode(this.mModeParams);
                this.mRecycleBinEdit = recycleBinEditMode2;
                return recycleBinEditMode2;
            case 7:
            case 27:
                PickMode pickMode = this.mPickMode;
                if (pickMode != null) {
                    return pickMode;
                }
                PickMode pickMode2 = new PickMode(this.mModeParams);
                this.mPickMode = pickMode2;
                return pickMode2;
            case 8:
                PickEditMode pickEditMode = this.mPickEditMode;
                if (pickEditMode != null) {
                    return pickEditMode;
                }
                PickEditMode pickEditMode2 = new PickEditMode(this.mModeParams);
                this.mPickEditMode = pickEditMode2;
                return pickEditMode2;
            case 9:
                PickEditSearchMode pickEditSearchMode = this.mPickEditSearchMode;
                if (pickEditSearchMode != null) {
                    return pickEditSearchMode;
                }
                PickEditSearchMode pickEditSearchMode2 = new PickEditSearchMode(this.mModeParams);
                this.mPickEditSearchMode = pickEditSearchMode2;
                return pickEditSearchMode2;
            case 10:
                return new SpaceSelectMode(this.mModeParams);
            case 11:
                return new SpaceEditMode(this.mModeParams);
            case 12:
                CoeditMode coeditMode = this.mCoeditMode;
                if (coeditMode != null) {
                    return coeditMode;
                }
                CoeditMode coeditMode2 = new CoeditMode(this.mModeParams);
                this.mCoeditMode = coeditMode2;
                return coeditMode2;
            case 13:
                CoeditEditMode coeditEditMode = this.mCoeditEditMode;
                if (coeditEditMode != null) {
                    return coeditEditMode;
                }
                CoeditEditMode coeditEditMode2 = new CoeditEditMode(this.mModeParams);
                this.mCoeditEditMode = coeditEditMode2;
                return coeditEditMode2;
            case 14:
                CoeditSpaceMode coeditSpaceMode = this.mCoeditSpaceMode;
                if (coeditSpaceMode != null) {
                    return coeditSpaceMode;
                }
                CoeditSpaceMode coeditSpaceMode2 = new CoeditSpaceMode(this.mModeParams);
                this.mCoeditSpaceMode = coeditSpaceMode2;
                return coeditSpaceMode2;
            case 15:
                CoeditSpaceEditMode coeditSpaceEditMode = this.mCoeditSpaceEditMode;
                if (coeditSpaceEditMode != null) {
                    return coeditSpaceEditMode;
                }
                CoeditSpaceEditMode coeditSpaceEditMode2 = new CoeditSpaceEditMode(this.mModeParams);
                this.mCoeditSpaceEditMode = coeditSpaceEditMode2;
                return coeditSpaceEditMode2;
            case 16:
                return new CoeditSearchMode(this.mModeParams);
            case 17:
                return new CoeditSearchEditMode(this.mModeParams);
            case 18:
                HashTagMode hashTagMode = this.mHashTagMode;
                if (hashTagMode != null) {
                    return hashTagMode;
                }
                HashTagMode hashTagMode2 = new HashTagMode(this.mModeParams);
                this.mHashTagMode = hashTagMode2;
                return hashTagMode2;
            case 19:
                HashTagEditMode hashTagEditMode = this.mHashTagEditMode;
                if (hashTagEditMode != null) {
                    return hashTagEditMode;
                }
                HashTagEditMode hashTagEditMode2 = new HashTagEditMode(this.mModeParams);
                this.mHashTagEditMode = hashTagEditMode2;
                return hashTagEditMode2;
            case 20:
                return new HashTagDetailMode(this.mModeParams);
            case 21:
                OldSelectMode oldSelectMode = this.mOldSelectMode;
                if (oldSelectMode != null) {
                    return oldSelectMode;
                }
                OldSelectMode oldSelectMode2 = new OldSelectMode(this.mModeParams);
                this.mOldSelectMode = oldSelectMode2;
                return oldSelectMode2;
            case 22:
                OldEditMode oldEditMode = this.mOldEditMode;
                if (oldEditMode != null) {
                    return oldEditMode;
                }
                OldEditMode oldEditMode2 = new OldEditMode(this.mModeParams);
                this.mOldEditMode = oldEditMode2;
                return oldEditMode2;
            case 23:
                return new OldCategoryMode(this.mModeParams);
            case 24:
                return new GcsGroupMode(this.mModeParams);
            case 25:
            case 28:
                PickEditWidgetMode pickEditWidgetMode = this.mPickEditWidgetMode;
                if (pickEditWidgetMode != null) {
                    return pickEditWidgetMode;
                }
                PickEditWidgetMode pickEditWidgetMode2 = new PickEditWidgetMode(this.mModeParams);
                this.mPickEditWidgetMode = pickEditWidgetMode2;
                return pickEditWidgetMode2;
            case 26:
                PickEditSearchWidgetMode pickEditSearchWidgetMode = this.mPickEditSearchWidgetMode;
                if (pickEditSearchWidgetMode != null) {
                    return pickEditSearchWidgetMode;
                }
                PickEditSearchWidgetMode pickEditSearchWidgetMode2 = new PickEditSearchWidgetMode(this.mModeParams);
                this.mPickEditSearchWidgetMode = pickEditSearchWidgetMode2;
                return pickEditSearchWidgetMode2;
            default:
                MainLogger.m7255e(TAG, "unexpected indexMode: " + i);
                return null;
        }
    }
}
