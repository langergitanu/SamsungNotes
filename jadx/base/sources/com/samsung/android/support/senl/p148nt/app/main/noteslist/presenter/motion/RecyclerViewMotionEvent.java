package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.MouseDragEvent;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.MouseMultiSelectionEvent;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.PenMultiSelectionEvent;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecyclerViewMotionEvent implements PenMultiSelectionEvent.PenMultiSelectionEventListener, MouseMultiSelectionEvent.MouseMultiSelectionEventListener, ShiftMultiSelectionMotion.ShiftMultiSelectionEventListener, MouseDragEvent.MouseDragEventListener, LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener {
    private static final String TAG = "RecyclerViewMotionEvent";
    private RecyclerViewMotionEventListener mContract;
    private DocumentMap mDocumentMap;
    private LongPressRangeSelectionMotion mLongPressRangeSelectionMotion;
    private MouseDragEvent mMouseDragEvent;
    private MouseMultiSelectionEvent mMouseMultiSelectionEvent;
    private NotesModel mNotesModel;
    private PenMultiSelectionEvent mPenMultiSelectionEvent;
    private NotesPenRecyclerView mRecyclerView;
    private ShiftMultiSelectionMotion mShiftMultiSelectionMotion;
    private StateInfo mStateInfo;
    private ViewParams mViewParams;

    public RecyclerViewMotionEvent(ViewParams viewParams, NotesModel notesModel, DocumentMap documentMap, StateInfo stateInfo, NotesPenRecyclerView notesPenRecyclerView, RecyclerViewMotionEventListener recyclerViewMotionEventListener) {
        this.mViewParams = viewParams;
        this.mNotesModel = notesModel;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
        this.mRecyclerView = notesPenRecyclerView;
        this.mContract = recyclerViewMotionEventListener;
    }

    private boolean isSOMRecognizedCard(int i) {
        return this.mContract.isSOMRecognizedCardHolder(i);
    }

    private boolean isTipCard(int i) {
        int tipCardHolderCount = this.mContract.getTipCardHolderCount();
        return tipCardHolderCount > 0 && tipCardHolderCount > i;
    }

    private void toggleSelectedState(CommonHolderInfo commonHolderInfo) {
        if (commonHolderInfo == null || commonHolderInfo.getCheckBox().getTag() == null || FolderUtils.isStaticFolder(commonHolderInfo.getUuid())) {
            return;
        }
        if (commonHolderInfo.getHolderType() > 1024 || !FeatureUtils.isPickEditMode(this.mViewParams.getModeIndex())) {
            if (commonHolderInfo.getHolderType() == 2048) {
                MainListDocumentData noteData = this.mDocumentMap.getNoteData(commonHolderInfo.getUuid());
                if (noteData != null) {
                    this.mNotesModel.toggleCheckedNote(noteData);
                }
            } else {
                this.mNotesModel.toggleCheckedFolder(commonHolderInfo.getUuid());
            }
            commonHolderInfo.getCheckBox().setChecked(this.mNotesModel.isUuidInCheckedData(commonHolderInfo.getUuid()));
            this.mContract.updateContentDescription(commonHolderInfo, true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void checkAutoScroll() {
        this.mContract.checkAutoScroll();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void dragFolderSelectState(int i, boolean z, int i2) {
        this.mContract.dragFolderSelectState(i, z, i2);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void dragNoteSelectState(int i, boolean z) {
        this.mContract.dragNoteSelectState(i, z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void endLongPressed() {
        MainLogger.m7254d(TAG, "endLongPressed");
        this.mRecyclerView.setLongPressed(false);
        this.mNotesModel.setPostDragAndDropUuid(null);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion.ShiftMultiSelectionEventListener, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public DocumentMap getDocumentMap() {
        return this.mDocumentMap;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public int getModeIndex() {
        return this.mViewParams.getModeIndex();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public NotesModel getNotesModel() {
        return this.mNotesModel;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion.ShiftMultiSelectionEventListener, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public NotesPenRecyclerView getNotesPenRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public ViewContract.IView getNotesView() {
        return this.mViewParams.getNotesView();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion.ShiftMultiSelectionEventListener, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public StateInfo getStateInfo() {
        return this.mStateInfo;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.MouseDragEvent.MouseDragEventListener
    public int getSubFoldersSpan() {
        return this.mStateInfo.getSubFoldersSpan();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.MouseDragEvent.MouseDragEventListener
    public boolean isDragAndDropEnabledPosition(int i, boolean z) {
        return this.mContract.isDragAndDropEnabledPosition(i, z);
    }

    public boolean isLongPressMoved() {
        LongPressRangeSelectionMotion longPressRangeSelectionMotion = this.mLongPressRangeSelectionMotion;
        if (longPressRangeSelectionMotion == null) {
            return false;
        }
        return longPressRangeSelectionMotion.isTouchMoved();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0224  */
    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.PenMultiSelectionEvent.PenMultiSelectionEventListener, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.MouseMultiSelectionEvent.MouseMultiSelectionEventListener, com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion.ShiftMultiSelectionEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4, boolean z) {
        char c;
        int i5;
        int i6;
        int i7;
        char c2;
        ArrayList<Integer> arrayList2 = arrayList;
        char c4 = '\n';
        if (arrayList2 == null || arrayList2.isEmpty() || this.mDocumentMap.getCommonDisplayListSize(FolderUtils.sStaticFolders) <= 0 || FeatureUtils.isSinglePickSelectMode(this.mViewParams.getModeIndex(), this.mStateInfo.getCaller(), this.mStateInfo.getSearchCallerMode())) {
            return;
        }
        int i8 = 1;
        int i9 = 0;
        if (arrayList2.size() == 1) {
            if (isTipCard(arrayList2.get(0).intValue()) || isSOMRecognizedCard(arrayList2.get(0).intValue())) {
                return;
            }
            Common commonDisplayData = this.mDocumentMap.getCommonDisplayData(arrayList2.get(0).intValue());
            if (i2 == 0 && i4 == 0 && commonDisplayData != null && commonDisplayData.type <= 1024) {
                return;
            }
        }
        MainLogger.m7254d(TAG, "onSelectedItemPosition# list size : " + arrayList2.size() + " isDragging " + z);
        this.mViewParams.getNotesView().getMode().setEditMode(false);
        int subFoldersSpan = this.mStateInfo.getSubFoldersSpan();
        float f = (float) i;
        float f4 = (float) subFoldersSpan;
        int i10 = (int) ((i2 / f) * f4);
        int i11 = (int) ((i4 / f) * f4);
        int modeIndex = this.mViewParams.getModeIndex();
        boolean zIsPickEditMode = FeatureUtils.isPickEditMode(modeIndex);
        Iterator<Integer> it = arrayList2.iterator();
        int i12 = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (isTipCard(iIntValue)) {
                c = c4;
                i5 = i8;
                i6 = i9;
            } else {
                CommonHolder commonHolder = (CommonHolder) this.mRecyclerView.findViewHolderForLayoutPosition(iIntValue);
                int i13 = (z || iIntValue == arrayList2.get(i9).intValue()) ? i10 : 0;
                if (z) {
                    i5 = i8;
                } else {
                    i5 = i8;
                    if (iIntValue != ((Integer) AbstractC1974b.m1313f(i8, arrayList2)).intValue()) {
                        i7 = subFoldersSpan - 1;
                    }
                    if (commonHolder != null) {
                        Common commonDisplayData2 = this.mDocumentMap.getCommonDisplayData(iIntValue);
                        if (commonDisplayData2 != null) {
                            int i14 = commonDisplayData2.type;
                            if (i14 == 2048) {
                                MainListDocumentData mainListDocumentData = commonDisplayData2.notes;
                                if (mainListDocumentData != null) {
                                    if (FeatureUtils.isPickEditWidgetMode(modeIndex)) {
                                        if (!this.mNotesModel.isUuidInCheckedDimmedNotes(mainListDocumentData.getUuid())) {
                                            if (this.mNotesModel.getCheckedNotesUUIDForWidgetList().size() > 9) {
                                                i6 = 0;
                                                ToastHandler.show(this.mViewParams.getContext(), this.mViewParams.getAbsFragment().getResources().getQuantityString(C8003R.plurals.plurals_max_select_note_for_widget, 10, 10), 0);
                                                c = '\n';
                                            } else {
                                                i12 = i5;
                                            }
                                        }
                                    }
                                    this.mNotesModel.toggleCheckedNote(mainListDocumentData);
                                    i8 = i5;
                                    c4 = '\n';
                                    i9 = 0;
                                }
                            } else if (i14 <= 1024 && !zIsPickEditMode) {
                                List<NotesFolder> list = commonDisplayData2.folders;
                                while (i13 <= i7) {
                                    if (list.get(i13) != null && !FolderUtils.isStaticFolder(list.get(i13).getUuid())) {
                                        this.mNotesModel.toggleCheckedFolder(list.get(i13).getUuid());
                                    }
                                    i13++;
                                }
                            }
                        }
                        i6 = 0;
                        c = '\n';
                    } else {
                        if (FeatureUtils.isPickEditWidgetMode(modeIndex)) {
                            if (this.mNotesModel.getCheckedNotesUUIDForWidgetList().size() > 9) {
                                c = '\n';
                                i6 = 0;
                                ToastHandler.show(this.mViewParams.getContext(), this.mViewParams.getAbsFragment().getResources().getQuantityString(C8003R.plurals.plurals_max_select_note_for_widget, 10, 10), 0);
                            } else {
                                i12 = i5;
                            }
                        }
                        if (commonHolder.getMHolderType() == 2048) {
                            NotesHolder notesHolder = (NotesHolder) commonHolder;
                            if (this.mNotesModel.isUuidInCheckedDimmedNotes(notesHolder.getNotesHolderInfo().getUuid())) {
                                c2 = 1024;
                                if (commonHolder.getMHolderType() <= 1024) {
                                    while (i13 <= i7) {
                                        SubFolderHolder subFolderHolder = (SubFolderHolder) commonHolder;
                                        if (i13 >= subFolderHolder.getSubFolderCount()) {
                                            break;
                                        }
                                        toggleSelectedState(subFolderHolder.getSubFolderHolderInfo(i13));
                                        i13++;
                                    }
                                }
                            } else {
                                toggleSelectedState(notesHolder.getNotesHolderInfo());
                                c2 = 1024;
                            }
                            arrayList2 = arrayList;
                            i9 = 0;
                            i8 = i5;
                            c4 = '\n';
                        }
                    }
                }
                i7 = i11;
                if (commonHolder != null) {
                }
            }
            i9 = i6;
            c4 = c;
            i8 = i5;
        }
        boolean z2 = i8;
        if (i12 != 0 && FeatureUtils.isPickEditWidgetMode(modeIndex)) {
            this.mViewParams.getAbsFragment().filteredInvalidateOptionsMenu();
            this.mViewParams.getNotesView().getMode().showBottomNavigation(z2);
        }
        this.mContract.updateFolderExpandBarHolder();
        this.mViewParams.getNotesView().updateSelectedNoteCount();
        if (!FeatureUtils.isGcsSpaceMode(modeIndex)) {
            this.mContract.updateTimeSubHeaderCheckBox();
        } else if (this.mDocumentMap.hasHolderInfo(4)) {
            this.mContract.updateSubHeaderCheckBox(-15L);
            this.mContract.updateSubHeaderCheckBox(-14L);
        }
    }

    public void registerListener() {
        this.mPenMultiSelectionEvent = new PenMultiSelectionEvent(this);
        this.mMouseMultiSelectionEvent = new MouseMultiSelectionEvent(this);
        this.mShiftMultiSelectionMotion = new ShiftMultiSelectionMotion(this);
        this.mMouseDragEvent = new MouseDragEvent(this);
        this.mLongPressRangeSelectionMotion = new LongPressRangeSelectionMotion(this);
        this.mRecyclerView.setOnPenMultiSelectionListener(this.mPenMultiSelectionEvent.getOnPenMultiSelectionListener());
        this.mRecyclerView.setOnMouseMultiSelectionListener(this.mMouseMultiSelectionEvent.getOnPenMultiSelectionListener());
        this.mRecyclerView.setOnShiftMultiSelectionListener(this.mShiftMultiSelectionMotion.getOnShiftMultiSelectionListener());
        this.mRecyclerView.setOnMouseDragListener(this.mMouseDragEvent.getOnMouseDragListenerListener());
        this.mRecyclerView.setOnLongPressMultiSelectionListener(this.mLongPressRangeSelectionMotion.getLongPressRangeSelectionListener());
    }

    public void resumeLongPressMultiSelection() {
        this.mRecyclerView.setOnLongPressMultiSelectionListener(this.mLongPressRangeSelectionMotion.getLongPressRangeSelectionListener());
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion.ShiftMultiSelectionEventListener
    public void selectAllNotes(boolean z) {
        this.mContract.selectAllNotes(z);
    }

    public void setAutoScrollEnabled(boolean z) {
        LongPressRangeSelectionMotion longPressRangeSelectionMotion = this.mLongPressRangeSelectionMotion;
        if (longPressRangeSelectionMotion == null) {
            return;
        }
        longPressRangeSelectionMotion.setAutoScrollEnabled(z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void setLastCheckedItemViewBottom() {
        this.mContract.setLastCheckedItemViewBottom();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.MouseDragEvent.MouseDragEventListener
    public void startDragAndDrop(int i, boolean z) {
        this.mContract.startDragAndDrop(i, z);
    }

    public void stopLongPressMultiSelection() {
        this.mRecyclerView.removeOnLongPressMultiSelectionListener();
    }

    public void unregisterListener() {
        this.mRecyclerView.setOnMouseDragListener(null);
        this.mRecyclerView.setOnMouseMultiSelectionListener(null);
        this.mRecyclerView.setOnShiftMultiSelectionListener(null);
        this.mRecyclerView.setOnPenMultiSelectionListener(null);
        this.mRecyclerView.setOnLongPressMultiSelectionListener(null);
        PenMultiSelectionEvent penMultiSelectionEvent = this.mPenMultiSelectionEvent;
        if (penMultiSelectionEvent != null) {
            penMultiSelectionEvent.reset();
        }
        MouseMultiSelectionEvent mouseMultiSelectionEvent = this.mMouseMultiSelectionEvent;
        if (mouseMultiSelectionEvent != null) {
            mouseMultiSelectionEvent.reset();
        }
        ShiftMultiSelectionMotion shiftMultiSelectionMotion = this.mShiftMultiSelectionMotion;
        if (shiftMultiSelectionMotion != null) {
            shiftMultiSelectionMotion.reset();
        }
        MouseDragEvent mouseDragEvent = this.mMouseDragEvent;
        if (mouseDragEvent != null) {
            mouseDragEvent.reset();
        }
        LongPressRangeSelectionMotion longPressRangeSelectionMotion = this.mLongPressRangeSelectionMotion;
        if (longPressRangeSelectionMotion != null) {
            longPressRangeSelectionMotion.reset();
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void updateFolderExpandBarHolder() {
        this.mContract.updateFolderExpandBarHolder();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void updateSubHeaderCheckBox(long j) {
        this.mContract.updateSubHeaderCheckBox(j);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.OnLongPressRangeSelectionsListener
    public void updateTimeSubHeaderCheckBox() {
        this.mContract.updateTimeSubHeaderCheckBox();
    }
}
