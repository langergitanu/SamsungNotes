package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.LongPressRangeSelectionListener;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.listener.ViewContract;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LongPressRangeSelectionMotion {
    private static final int DIRECTION_CENTER = 2;
    private static final int DIRECTION_LEFT = 0;
    private static final int DIRECTION_RIGHT = 1;
    private static final int EMPTY_DATA = -1;
    private static final String TAG = "LongPressRangeSelectionMotion";
    private static final int UPDATE_FOLDER_EXPAND_BAR = 4;
    private static final int UPDATE_SUBHEADER = 2;
    private static final int UPDATE_TOOLBAR = 1;
    private static final int UPDATE_WAIT_DURATION = 200;
    private LongPressRangeSelectionListener mLongPressRangeSelectionListener;
    private final LongPressRangeSelectionModel mLongPressRangeSelectionModel = new LongPressRangeSelectionModel();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LongPressRangeSelectionModel {
        boolean mCheckLimitationMode;
        int mCurrentPosition;
        int mDirection;
        int mFolderCount;
        int mFolderMaximumLine;
        int mFolderMinimumLine;
        int mFolderSpan;
        int mHolderPosition;
        boolean mIsAutoScrollEnabled;
        int mLastPosition;
        float mLastX;
        int mModeIndex;
        int mRecyclerViewWidth;
        int mStartPosition;
        int mUpdateAction;

        public LongPressRangeSelectionModel() {
            clear();
        }

        public void clear() {
            this.mCheckLimitationMode = false;
            this.mDirection = 2;
            this.mStartPosition = -1;
            this.mLastPosition = -1;
            this.mRecyclerViewWidth = -1;
            this.mCurrentPosition = -1;
            this.mFolderCount = -1;
            this.mLastX = 0.0f;
            this.mFolderSpan = 0;
            this.mFolderMinimumLine = 0;
            this.mFolderMaximumLine = 0;
            this.mIsAutoScrollEnabled = false;
            this.mUpdateAction = 0;
            this.mHolderPosition = 0;
            this.mModeIndex = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnLongPressRangeSelectionsListener {
        void checkAutoScroll();

        void dragFolderSelectState(int i, boolean z, int i2);

        void dragNoteSelectState(int i, boolean z);

        void endLongPressed();

        DocumentMap getDocumentMap();

        int getModeIndex();

        NotesModel getNotesModel();

        NotesPenRecyclerView getNotesPenRecyclerView();

        ViewContract.IView getNotesView();

        StateInfo getStateInfo();

        void setLastCheckedItemViewBottom();

        void updateFolderExpandBarHolder();

        void updateSubHeaderCheckBox(long j);

        void updateTimeSubHeaderCheckBox();
    }

    public LongPressRangeSelectionMotion(final OnLongPressRangeSelectionsListener onLongPressRangeSelectionsListener) {
        Looper looperMyLooper = Looper.myLooper();
        Objects.requireNonNull(looperMyLooper);
        final Handler handler = new Handler(looperMyLooper);
        final RunnableC4199v runnableC4199v = new RunnableC4199v(this, onLongPressRangeSelectionsListener, 29);
        this.mLongPressRangeSelectionListener = new LongPressRangeSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.LongPressRangeSelectionMotion.1
            private void refreshEvent(int i) {
                LongPressRangeSelectionModel longPressRangeSelectionModel = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel;
                longPressRangeSelectionModel.mUpdateAction = i | longPressRangeSelectionModel.mUpdateAction;
                handler.removeCallbacks(runnableC4199v);
                handler.postDelayed(runnableC4199v, 200L);
            }

            private void setFolderSelectState(int i, int i2) {
                if (i < 0) {
                    MainLogger.m7255e(LongPressRangeSelectionMotion.TAG, "setFolderSelectState# holderPosition under 0");
                    return;
                }
                NotesPenRecyclerView notesPenRecyclerView = onLongPressRangeSelectionsListener.getNotesPenRecyclerView();
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth != -1 ? LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth : notesPenRecyclerView.getWidth();
                if (LocaleUtils.isRTLMode()) {
                    LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastX = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth - LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastX;
                }
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition = (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan * i) + ((int) ((LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastX / LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth) * LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan));
                if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition == i2) {
                    return;
                }
                if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition < 0) {
                    MainLogger.m7255e(LongPressRangeSelectionMotion.TAG, "setFolderSelectState# mCurrentPosition under 0");
                    return;
                }
                if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition == -1) {
                    LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition;
                }
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastPosition = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition;
                if (i2 == -1) {
                    i2 = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition;
                }
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mDirection = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition == LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition ? 2 : LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition > LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition ? 0 : 1;
                int iMin = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition < i2 ? Math.min(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition) : Math.min(i2, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition);
                int iMax = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition > i2 ? Math.max(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition) : Math.max(i2, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition);
                int i4 = iMin;
                while (i4 <= iMax) {
                    if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mDirection == 1) {
                        onLongPressRangeSelectionsListener.dragFolderSelectState(i4, notesPenRecyclerView.isNeedChecked() && i4 >= LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition && i4 <= LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan);
                    } else if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mDirection == 0) {
                        onLongPressRangeSelectionsListener.dragFolderSelectState(i4, notesPenRecyclerView.isNeedChecked() && i4 <= LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition && i4 >= LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan);
                    } else {
                        onLongPressRangeSelectionsListener.dragFolderSelectState(i4, notesPenRecyclerView.isNeedChecked() && i4 == LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan);
                    }
                    i4++;
                }
                StringBuilder sb = new StringBuilder("setFolderSelectState# folderSpan : ");
                AbstractC2821a.m2235z(sb, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan, i, ", holderPosition : ", ", lastPosition : ");
                sb.append(i2);
                sb.append(", mRecyclerViewWidth : ");
                sb.append(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth);
                sb.append(", mLastX : ");
                sb.append(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastX);
                sb.append(", mCurrentPosition : ");
                sb.append(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition);
                sb.append(", mStartPosition : ");
                sb.append(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition);
                sb.append(", mDirection : ");
                AbstractC2821a.m2235z(sb, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mDirection, iMin, ", min : ", ", max : ");
                sb.append(iMax);
                MainLogger.m7254d(LongPressRangeSelectionMotion.TAG, sb.toString());
                refreshEvent(4);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.LongPressRangeSelectionListener, com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
            public void onItemSelected(RecyclerView recyclerView, View view, int i, long j) {
                if (i < 0) {
                    return;
                }
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mHolderPosition = i;
                super.onItemSelected(recyclerView, view, i, j);
                if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderCount > 0 && LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMinimumLine <= LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mHolderPosition && LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mHolderPosition <= LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMaximumLine && this.selectedItemPositionList.contains(Integer.valueOf(i))) {
                    setFolderSelectState(i, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastPosition);
                }
                NotesPenRecyclerView notesPenRecyclerView = onLongPressRangeSelectionsListener.getNotesPenRecyclerView();
                CommonHolder commonHolder = (CommonHolder) notesPenRecyclerView.findViewHolderForLayoutPosition(i);
                if (commonHolder == null) {
                    return;
                }
                if (commonHolder.getMHolderType() != 2048) {
                    refreshEvent(1);
                    return;
                }
                if (onLongPressRangeSelectionsListener.getNotesModel().isUuidInCheckedDimmedNotes(((NotesHolder) commonHolder).getNotesHolderInfo().getUuid())) {
                    return;
                }
                if (!notesPenRecyclerView.isNeedChecked() || !this.selectedItemPositionList.contains(Integer.valueOf(i))) {
                    onLongPressRangeSelectionsListener.dragNoteSelectState(i, false);
                } else {
                    if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCheckLimitationMode && onLongPressRangeSelectionsListener.getNotesModel().getCheckedNotesUUIDForWidgetList().size() > 9) {
                        ToastHandler.show(recyclerView.getContext(), recyclerView.getResources().getQuantityString(C8003R.plurals.plurals_max_select_note_for_widget, 10, 10), 0);
                        return;
                    }
                    onLongPressRangeSelectionsListener.dragNoteSelectState(i, true);
                }
                refreshEvent(3);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.LongPressRangeSelectionListener, com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
            public void onLongPressMultiSelectionEnded(int i, int i2) {
                super.onLongPressMultiSelectionEnded(i, i2);
                MainLogger.m7254d(LongPressRangeSelectionMotion.TAG, "onLongPressMultiSelectionEnded");
                LongPressRangeSelectionModel longPressRangeSelectionModel = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel;
                LongPressRangeSelectionModel longPressRangeSelectionModel2 = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel;
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mStartPosition = -1;
                longPressRangeSelectionModel2.mLastPosition = -1;
                longPressRangeSelectionModel.mRecyclerViewWidth = -1;
                onLongPressRangeSelectionsListener.getNotesView().updateSelectedNoteCount();
                onLongPressRangeSelectionsListener.getNotesView().getMode().showBottomNavigation(true);
                onLongPressRangeSelectionsListener.endLongPressed();
                onLongPressRangeSelectionsListener.getNotesView().getMode().onDataChangedViewUpdate(onLongPressRangeSelectionsListener.getDocumentMap().getCommonDisplayListSize(FolderUtils.sStaticFolders));
                if (FeatureUtils.getViewMode(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mModeIndex) != 1) {
                    onLongPressRangeSelectionsListener.checkAutoScroll();
                    return;
                }
                onLongPressRangeSelectionsListener.setLastCheckedItemViewBottom();
                if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mIsAutoScrollEnabled) {
                    LongPressRangeSelectionMotion.this.setAutoScrollEnabled(false);
                    onLongPressRangeSelectionsListener.checkAutoScroll();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.LongPressRangeSelectionListener, com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerView.LongPressMultiSelectionListener, androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
            public void onLongPressMultiSelectionStarted(int i, int i2) {
                super.onLongPressMultiSelectionStarted(i, i2);
                MainLogger.m7254d(LongPressRangeSelectionMotion.TAG, "onLongPressMultiSelectionStarted");
                NotesFolder folderData = onLongPressRangeSelectionsListener.getDocumentMap().getFolderData(onLongPressRangeSelectionsListener.getStateInfo().getFolderUuid());
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.clear();
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mModeIndex = onLongPressRangeSelectionsListener.getModeIndex();
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mRecyclerViewWidth = -1;
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mDirection = 2;
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMinimumLine = -1;
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMaximumLine = -1;
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCheckLimitationMode = LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mModeIndex == 25 || LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mModeIndex == 28 || LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mModeIndex == 26;
                if (folderData == null || !FeatureUtils.isSubFolderExist(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mModeIndex, folderData.getUuid())) {
                    MainLogger.m7255e(LongPressRangeSelectionMotion.TAG, "onLongPressMultiSelectionStarted folder null");
                    LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderCount = 0;
                    onLongPressRangeSelectionsListener.getNotesPenRecyclerView().setLongPressed(true);
                    refreshEvent(3);
                    return;
                }
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderCount = folderData.getChildren().size();
                onLongPressRangeSelectionsListener.getNotesPenRecyclerView().setLongPressed(true);
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan = onLongPressRangeSelectionsListener.getStateInfo().getSubFoldersSpan();
                List<Common> commonDisplayList = onLongPressRangeSelectionsListener.getDocumentMap().getCommonDisplayList();
                int folderSpanHolderType = FeatureUtils.getFolderSpanHolderType(LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderSpan);
                Iterator<Common> it = commonDisplayList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    if (it.next().type != folderSpanHolderType) {
                        if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMinimumLine != -1 && LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMaximumLine != -1) {
                            break;
                        }
                    } else {
                        if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMinimumLine == -1) {
                            LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMinimumLine = i4 > 0 ? i4 - 1 : 0;
                        }
                        LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMaximumLine = i4 + 1;
                    }
                    i4++;
                }
                refreshEvent(7);
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.LongPressRangeSelectionListener, com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnLongPressMultiSelectionListener
            public boolean onTouchEvent(float f, float f4) {
                boolean z;
                if (LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderCount <= 0 || LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMinimumLine > LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mHolderPosition || LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mHolderPosition > LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mFolderMaximumLine) {
                    return false;
                }
                NotesPenRecyclerView notesPenRecyclerView = onLongPressRangeSelectionsListener.getNotesPenRecyclerView();
                View viewFindChildViewUnder = notesPenRecyclerView.findChildViewUnder(f, f4);
                if (viewFindChildViewUnder == null) {
                    viewFindChildViewUnder = notesPenRecyclerView.seslFindNearChildViewUnder(f, f4);
                    if (viewFindChildViewUnder == null) {
                        return false;
                    }
                    z = true;
                } else {
                    z = false;
                }
                LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastX = f;
                int subFoldersSpan = z ? LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mCurrentPosition / onLongPressRangeSelectionsListener.getStateInfo().getSubFoldersSpan() : notesPenRecyclerView.getChildLayoutPosition(viewFindChildViewUnder);
                CommonHolder commonHolder = (CommonHolder) notesPenRecyclerView.findViewHolderForLayoutPosition(subFoldersSpan);
                if (commonHolder == null) {
                    return false;
                }
                if (commonHolder.getMHolderType() <= 1024) {
                    setFolderSelectState(subFoldersSpan, LongPressRangeSelectionMotion.this.mLongPressRangeSelectionModel.mLastPosition);
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(OnLongPressRangeSelectionsListener onLongPressRangeSelectionsListener) {
        int i = this.mLongPressRangeSelectionModel.mUpdateAction;
        if (i == 0) {
            return;
        }
        if ((i & 1) > 0) {
            onLongPressRangeSelectionsListener.getNotesView().updateSelectedNoteCount();
        }
        LongPressRangeSelectionModel longPressRangeSelectionModel = this.mLongPressRangeSelectionModel;
        if ((longPressRangeSelectionModel.mUpdateAction & 2) > 0) {
            if (!FeatureUtils.isGcsSpaceMode(longPressRangeSelectionModel.mModeIndex)) {
                onLongPressRangeSelectionsListener.updateTimeSubHeaderCheckBox();
            } else if (onLongPressRangeSelectionsListener.getDocumentMap().hasHolderInfo(4)) {
                onLongPressRangeSelectionsListener.updateSubHeaderCheckBox(-15L);
                onLongPressRangeSelectionsListener.updateSubHeaderCheckBox(-14L);
            }
        }
        if ((this.mLongPressRangeSelectionModel.mUpdateAction & 4) > 0) {
            onLongPressRangeSelectionsListener.updateFolderExpandBarHolder();
        }
        this.mLongPressRangeSelectionModel.mUpdateAction = 0;
    }

    public LongPressRangeSelectionListener getLongPressRangeSelectionListener() {
        return this.mLongPressRangeSelectionListener;
    }

    public boolean isTouchMoved() {
        LongPressRangeSelectionListener longPressRangeSelectionListener = this.mLongPressRangeSelectionListener;
        if (longPressRangeSelectionListener == null) {
            return false;
        }
        return longPressRangeSelectionListener.isTouchMoved();
    }

    public void reset() {
        this.mLongPressRangeSelectionListener = null;
    }

    public void setAutoScrollEnabled(boolean z) {
        this.mLongPressRangeSelectionModel.mIsAutoScrollEnabled = z;
    }
}
