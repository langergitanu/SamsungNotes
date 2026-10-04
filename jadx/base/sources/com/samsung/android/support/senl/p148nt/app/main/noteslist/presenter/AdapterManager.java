package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6693g;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6698l;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.support.senl.p145cm.base.framework.support.ObjectBuilder;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.labs.DocumentTest;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.IAdapter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.NotesAdapter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.NotesModel;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.SOMRecognizedInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DialogHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DragAndDropHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.LockHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.RecyclerViewHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.SearchHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.params.ViewParams;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.SOMRecognizeHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.DataTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.tipcard.TipCardHelper;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.task.DeleteTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMemberListEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentTimeUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;
import p066P2.RunnableC0201c;
import p122b2.RunnableC4199v;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AdapterManager implements AdapterContract {
    private static final String TAG = "AdapterManager";
    private LiveData<CoeditMemberListEntry> mCoeditMemberLiveData;
    private LiveData<List<CoeditMainListEntry>> mCoeditNotesLiveData;
    private DataTask mConvertNotesCheckTask;
    private List<String> mConvertTargetUuids;
    private List<String> mDeleteTargetUuids;
    private final ObjectBuilder<DialogHelper> mDialogHelper;
    private LiveData<List<MainListDocumentData>> mDisplayNotesLiveData;
    private final DocumentMap mDocumentMap;
    private final ObjectBuilder<DragAndDropHelper> mDragNDropHelper;
    private final ObjectBuilder<LockHelper> mLockHelper;
    private final IAdapter mNotesAdapter;
    private final NotesModel mNotesModel;
    private final ObjectBuilder<RecyclerViewHelper> mRecyclerViewHelper;
    private final ObjectBuilder<SOMRecognizeHelper> mSOMRecognizeHelper;
    private final ObjectBuilder<SearchHelper> mSearchHelper;
    private final StateInfo mStateInfo;
    private final ObjectBuilder<TipCardHelper> mTipCardHelper;
    private final ViewParams mViewParams;
    private final Observer<List<MainListDocumentData>> mDisplayNotesLiveDataObserver = new Observer<List<MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.AdapterManager.1
        @Override // androidx.lifecycle.Observer
        public void onChanged(List<MainListDocumentData> list) {
            if (AdapterManager.this.isScrolling()) {
                MainLogger.m7254d(AdapterManager.TAG, "Notes LiveData onChanged# isScrolling : setPostNotifyDataSetChanged");
                AdapterManager.this.mNotesModel.postNotifyDataSetChanged();
                return;
            }
            if (AdapterManager.this.mDocumentMap.isRestoreListTasking()) {
                AdapterManager.this.mDocumentMap.cancelRestoreListTask();
            }
            DataState dataStateOnDataChangedByMode = AdapterManager.this.mViewParams.getNotesView().getMode().onDataChangedByMode(list);
            int modeIndex = AdapterManager.this.mViewParams.getModeIndex();
            int size = list.size();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(size, modeIndex, "Notes LiveData onChanged# size ", ", modeIndex : ", ", dataState : ");
            sbM1173s.append(dataStateOnDataChangedByMode);
            MainLogger.m7258i(AdapterManager.TAG, sbM1173s.toString());
            if (dataStateOnDataChangedByMode != DataState.CHANGED) {
                AdapterManager.this.mViewParams.getNotesView().updateViewByDataChanged(size);
                return;
            }
            AdapterManager.this.notifyDataSetChangedWithViewPageChange("Notes LiveData onChanged");
            if (FeatureUtils.isEditMode(modeIndex)) {
                AdapterManager.this.mViewParams.getNotesView().onDataChanged(AdapterManager.this.mDocumentMap.getCommonDisplayListSize(FolderUtils.sStaticFolders), "Notes LiveData onChanged");
            } else {
                AdapterManager.this.mViewParams.getNotesView().onDataChanged(AdapterManager.this.mDocumentMap.getCommonDisplayListSize(new String[0]), "Notes LiveData onChanged");
            }
            if (AdapterManager.this.mDragNDropHelper.isValid()) {
                ((DragAndDropHelper) AdapterManager.this.mDragNDropHelper.getInstance()).releaseDragAndDrop();
            }
        }
    };
    private final Observer<List<CoeditMainListEntry>> mCoeditLiveDataObserver = new Observer<List<CoeditMainListEntry>>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.AdapterManager.2
        @Override // androidx.lifecycle.Observer
        public void onChanged(List<CoeditMainListEntry> list) {
            int modeIndex = AdapterManager.this.mViewParams.getModeIndex();
            MainLogger.m7254d(AdapterManager.TAG, "Coedit LiveData onChanged# size : " + list.size() + ", modeIndex : " + modeIndex);
            if (FeatureUtils.isSearchMode(modeIndex)) {
                AdapterManager.this.mDocumentMap.initCoeditMap(list);
                ((SearchHelper) AdapterManager.this.mSearchHelper.getInstance()).searchNotesData(AdapterManager.this.mViewParams.getNotesView().getSearchImpl().getSearchSavedText(), AdapterManager.this.mStateInfo.getSearchFolderUuid());
                return;
            }
            boolean zInitCoeditGroupMap = AdapterManager.this.mDocumentMap.initCoeditGroupMap(list);
            AbstractC6670b.m4739D("[CS9] Coedit LiveData onChanged# isDataChanged : ", AdapterManager.TAG, zInitCoeditGroupMap);
            if (zInitCoeditGroupMap) {
                AdapterManager.this.notifyDataSetChangedWithViewPageChange("Coedit LiveData onChanged");
            }
            AdapterManager.this.mViewParams.getNotesView().onDataChanged(AdapterManager.this.mDocumentMap.getCommonDisplayListSize(new String[0]), "Coedit LiveData onChanged");
        }
    };
    private final Observer<CoeditMemberListEntry> mCoeditMemberLiveDataObserver = new Observer<CoeditMemberListEntry>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.AdapterManager.3
        @Override // androidx.lifecycle.Observer
        public void onChanged(CoeditMemberListEntry coeditMemberListEntry) {
            MainLogger.m7254d(AdapterManager.TAG, "CoeditMember LiveData onChanged# size : " + coeditMemberListEntry.getMemberList().size());
            if (AdapterManager.this.mViewParams.getModeIndex() == 14) {
                AdapterManager.this.mViewParams.getNotesView().getMode().updateTitle();
            }
        }
    };
    private final Observer<List<MainListDocumentData>> mSpaceLiveDataObserver = new Observer<List<MainListDocumentData>>() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.AdapterManager.4
        @Override // androidx.lifecycle.Observer
        public void onChanged(List<MainListDocumentData> list) {
            int modeIndex = AdapterManager.this.mViewParams.getModeIndex();
            if (!FeatureUtils.isGcsSpaceMode(modeIndex)) {
                AbstractC8014b.m7201c(modeIndex, "Space LiveData onChanged# return - isNotSpaceMode, modeIndex : ", AdapterManager.TAG);
                return;
            }
            MainLogger.m7258i(AdapterManager.TAG, "Space LiveData onChanged# size : " + list.size() + ", modeIndex : " + modeIndex);
            boolean zInitNoteMapWithoutFolder = AdapterManager.this.mDocumentMap.initNoteMapWithoutFolder(list);
            if (!zInitNoteMapWithoutFolder && !FeatureUtils.isSearchMode(AdapterManager.this.mStateInfo.getPrevModeIndex())) {
                MainLogger.m7258i(AdapterManager.TAG, "Space LiveData onChanged# ");
                return;
            }
            if (zInitNoteMapWithoutFolder) {
                AdapterManager.this.notifyDataSetChangedWithViewPageChange("Space LiveData onChanged");
            } else if (FeatureUtils.isSearchMode(AdapterManager.this.mStateInfo.getPrevModeIndex())) {
                AdapterManager.this.notifyDataSetChangedWithViewPageChange("Space LiveData onChanged, prev mode is searchMode");
            }
            AdapterManager.this.mViewParams.getNotesView().onDataChanged(AdapterManager.this.mDocumentMap.getCommonDisplayListSize(FolderUtils.sStaticFolders), "Space LiveData onChanged");
        }
    };
    private ArrayList<View> mItems = null;
    private View mSubHeader = null;
    private int mInflatedViewProgress = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DataState {
        NOT_USED,
        CHANGED,
        UNCHANGED
    }

    public AdapterManager(ViewParams viewParams, DocumentMap documentMap, NotesModel notesModel, StateInfo stateInfo, ObjectBuilder<TipCardHelper> objectBuilder, ObjectBuilder<DialogHelper> objectBuilder2, ObjectBuilder<DragAndDropHelper> objectBuilder3, ObjectBuilder<RecyclerViewHelper> objectBuilder4, ObjectBuilder<SearchHelper> objectBuilder5, ObjectBuilder<SOMRecognizeHelper> objectBuilder6, ObjectBuilder<LockHelper> objectBuilder7) {
        this.mViewParams = viewParams;
        this.mDocumentMap = documentMap;
        this.mNotesModel = notesModel;
        this.mStateInfo = stateInfo;
        this.mTipCardHelper = objectBuilder;
        this.mDialogHelper = objectBuilder2;
        this.mDragNDropHelper = objectBuilder3;
        this.mRecyclerViewHelper = objectBuilder4;
        this.mSearchHelper = objectBuilder5;
        this.mSOMRecognizeHelper = objectBuilder6;
        this.mLockHelper = objectBuilder7;
        this.mNotesAdapter = new NotesAdapter(viewParams.getNotesRecyclerView(), this, documentMap, stateInfo);
        setAdapterToNotesRecyclerView();
    }

    private void changeLiveDataSet() {
        int modeIndex = getModeIndex();
        AbstractC8014b.m7201c(modeIndex, "changeLiveDataSet# modeIndex : ", TAG);
        switch (modeIndex) {
            case 5:
            case 6:
                this.mDisplayNotesLiveData = DataManager.getInstance().getAllRecycleBinData_LiveData();
                return;
            case 7:
            case 8:
                if (this.mStateInfo.getCaller() == 9 || this.mStateInfo.getCaller() == 10) {
                    this.mDisplayNotesLiveData = DataManager.getInstance().getAllForImportContentShare_LiveData();
                    return;
                }
                break;
            case 10:
            case 11:
                this.mDisplayNotesLiveData = DataManager.getInstance().getAllContentShare_LiveData(this.mStateInfo.getSpaceId());
                return;
            case 12:
            case 13:
            case 16:
            case 17:
                this.mCoeditNotesLiveData = new C6698l(this.mViewParams.getContext(), NotesUtils.getSortParam());
                return;
            case 14:
            case 15:
                this.mCoeditMemberLiveData = SesCoeditGroupReadResolver.getMemberListData(this.mViewParams.getContext(), this.mStateInfo.getGroupId());
                this.mCoeditNotesLiveData = new C6693g(this.mViewParams.getContext(), this.mStateInfo.getSpaceId(), this.mStateInfo.getGroupId(), NotesUtils.getSpaceSortParam());
                return;
            case 21:
            case 22:
                if ("old_converted_notes".equals(this.mStateInfo.getCategoryUuid())) {
                    this.mDisplayNotesLiveData = DataManager.getInstance().getAll_Converted_LiveData();
                    return;
                } else {
                    this.mDisplayNotesLiveData = DataManager.getInstance().getAll_OldNotes_LiveData();
                    return;
                }
            case 23:
            case 24:
                this.mDisplayNotesLiveData = null;
                return;
        }
        this.mDisplayNotesLiveData = DataManager.getInstance().getAll_LiveData();
    }

    private List<String> getAllConvertedNotes() {
        List<MainListDocumentData> all_Converted = DataManager.getInstance().getAll_Converted();
        if (all_Converted == null || all_Converted.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<MainListDocumentData> it = all_Converted.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUuid());
        }
        return arrayList;
    }

    private CheckBox getCheckBox(CommonHolderInfo commonHolderInfo) {
        if (FeatureUtils.isEditMode(this.mViewParams.getModeIndex()) || commonHolderInfo.isCheckboxInflated()) {
            return commonHolderInfo.getCheckBox();
        }
        return null;
    }

    private TextView getCountTextView(CommonHolderInfo commonHolderInfo) {
        if (commonHolderInfo.getHolderType() <= 1024) {
            return (TextView) commonHolderInfo.getRootCardView().findViewById(C8003R.id.count);
        }
        return null;
    }

    private int getSearchImeAwareFadingEdgeBottomPadding() {
        Object parent = this.mViewParams.getNotesRecyclerView().getParent();
        if (parent instanceof View) {
            return ((View) parent).getPaddingBottom();
        }
        return 0;
    }

    private boolean isAdapterAllocated() {
        boolean z = this.mViewParams.getNotesRecyclerView().getAdapter() != null;
        if (!z) {
            setAdapterToNotesRecyclerView();
        }
        return z;
    }

    private boolean isLockedConvertedNotesExist() {
        List<MainListDocumentData> all_Converted = DataManager.getInstance().getAll_Converted();
        if (all_Converted != null && !all_Converted.isEmpty()) {
            Iterator<MainListDocumentData> it = all_Converted.iterator();
            while (it.hasNext()) {
                if (it.next().getIsLock() == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideSearchFilter$6(Runnable runnable) {
        this.mSearchHelper.getInstance().hideSearchFilter();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeTipCard$5() {
        this.mDocumentMap.sortTopHolderDisplayList(1);
        notifyDataSetChanged("removeTipCard-withAnimation");
        this.mViewParams.getNotesView().getMode().setNoNotesLayoutVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$requestAllDeleteConvertedNotes$1(String str) {
        return !this.mDeleteTargetUuids.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAllDeleteConvertedNotes$2(List list, List list2) {
        list.addAll(getAllConvertedNotes());
        this.mDeleteTargetUuids.addAll(DataManager.getInstance().getOldNotesWithConvertedNotesInUse(list));
        this.mConvertTargetUuids.addAll((Collection) list.stream().filter(new C8506l(this, 1)).collect(Collectors.toList()));
        list2.add(Boolean.valueOf(isLockedConvertedNotesExist()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runDeleteConvertedNotesTask$3() {
        if (this.mConvertTargetUuids.isEmpty()) {
            return;
        }
        this.mDialogHelper.getInstance().showConvertConfirmDialog(this.mConvertTargetUuids, false, true, true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTipCard$4() {
        this.mViewParams.getNotesRecyclerView().scrollToTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDataChangeFromToggleFolderExpandState$0() {
        this.mDocumentMap.updateFolderDisplayList();
        notifyDataSetChangedWithViewPageChange("updateDataChangeFromToggleFolderExpandState");
        this.mViewParams.getNotesView().onDataChanged(this.mDocumentMap.getCommonDisplayListSize(new String[0]), "updateDataChangeFromToggleFolderExpandState");
    }

    private void observeCoeditLiveData() {
        LiveData<List<CoeditMainListEntry>> liveData = this.mCoeditNotesLiveData;
        if (liveData != null) {
            try {
                liveData.observe(this.mViewParams.getAbsFragment().getViewLifecycleOwner(), this.mCoeditLiveDataObserver);
            } catch (IllegalStateException e) {
                MainLogger.m7255e(TAG, "observeCoeditLiveData# " + this.mCoeditNotesLiveData.toString() + " IllegalStateException: " + e.getMessage());
            }
        }
    }

    private void observeLiveData(LiveData<List<MainListDocumentData>> liveData, Observer<List<MainListDocumentData>> observer) {
        if (liveData == null) {
            MainLogger.m7254d(TAG, "observeLiveData# live data is null.");
            this.mDocumentMap.clearCommonDisplayList();
            notifyDataSetChanged("LiveData is null. Clear list.");
            return;
        }
        try {
            liveData.observe(this.mViewParams.getAbsFragment().getViewLifecycleOwner(), observer);
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "observeLiveData# " + liveData + " IllegalStateException: " + e.getMessage());
        }
    }

    private void removeObserverFromLiveData(LiveData<List<MainListDocumentData>> liveData, Observer<List<MainListDocumentData>> observer) {
        if (liveData == null) {
            MainLogger.m7254d(TAG, "removeObserverFromLiveData# live data is null.");
        } else {
            liveData.removeObserver(observer);
        }
    }

    private void setAdapterToNotesRecyclerView() {
        MainLogger.m7254d(TAG, "setAdapterToNotesRecyclerView");
        this.mViewParams.getNotesRecyclerView().setAdapter((RecyclerView.Adapter) this.mNotesAdapter);
    }

    private void setObserver() {
        if (this.mViewParams.getAbsFragment().getView() == null) {
            MainLogger.m7255e(TAG, "setObserver# fragment getView is null");
        }
        this.mNotesModel.setIsScrolling(false);
        int modeIndex = getModeIndex();
        AbstractC6670b.m4736A(modeIndex, "setObserver# modeIndex : ", TAG);
        if (modeIndex == 23 || modeIndex == 24) {
            MainLogger.m7254d(TAG, "setObserver, ignore on OlcCategory And GcsGroup");
            return;
        }
        switch (modeIndex) {
            case 10:
            case 11:
                observeLiveData(this.mDisplayNotesLiveData, this.mSpaceLiveDataObserver);
                break;
            case 12:
            case 13:
            case 16:
            case 17:
                observeCoeditLiveData();
                break;
            case 14:
            case 15:
                LiveData<CoeditMemberListEntry> liveData = this.mCoeditMemberLiveData;
                if (liveData != null) {
                    try {
                        liveData.observe(this.mViewParams.getAbsFragment().getViewLifecycleOwner(), this.mCoeditMemberLiveDataObserver);
                    } catch (IllegalStateException e) {
                        MainLogger.m7255e(TAG, "setObserver# " + this.mCoeditMemberLiveData.toString() + " IllegalStateException: " + e.getMessage());
                    }
                }
                observeCoeditLiveData();
                break;
            default:
                observeLiveData(this.mDisplayNotesLiveData, this.mDisplayNotesLiveDataObserver);
                break;
        }
    }

    private void updateDataChangeFromToggleFolderExpandState() {
        if (FeatureUtils.isSearchMode(this.mStateInfo.getModeIndex())) {
            this.mViewParams.getNotesView().getMode().onDataChangedByMode(new ArrayList());
            return;
        }
        RunnableC8405a runnableC8405a = new RunnableC8405a(this, 0);
        if (!this.mStateInfo.isExpandedFolderBar()) {
            this.mRecyclerViewHelper.getInstance().collapseConcealSubFolderAnimation(runnableC8405a);
        } else {
            this.mStateInfo.setShowSubFolderWithAnimation(true);
            runnableC8405a.run();
        }
    }

    public synchronized void addInflatedView(View view) {
        try {
            if (this.mInflatedViewProgress < 2 && view != null) {
                if (this.mItems == null) {
                    this.mItems = new ArrayList<>();
                }
                this.mItems.add(view);
            }
        } finally {
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void addSubFolderBitmap(int i, int i2, @NotNull Drawable drawable) {
        this.mNotesAdapter.addSubFolderBitmap(i, i2, drawable);
    }

    public synchronized void addSubHeaderInflatedView(View view) {
        if (this.mInflatedViewProgress < 2 && view != null) {
            this.mSubHeader = view;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public int getCheckedFoldersCount() {
        return this.mNotesModel.getCheckedFoldersCount();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public List<Common> getCommonDisplayList() {
        return this.mDocumentMap.getCommonDisplayList();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public synchronized View getInflatedView(int i) {
        try {
            if (this.mInflatedViewProgress == 0) {
                this.mInflatedViewProgress = 1;
            }
            View view = null;
            if (i == 4096) {
                View view2 = this.mSubHeader;
                this.mSubHeader = null;
                return view2;
            }
            ArrayList<View> arrayList = this.mItems;
            if (arrayList != null && !arrayList.isEmpty()) {
                view = this.mItems.get(0);
                this.mItems.remove(0);
            }
            return view;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public int getModeIndex() {
        return this.mStateInfo.getModeIndex();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public int getNoteListHeight() {
        return this.mViewParams.getNotesRecyclerView().getMeasuredHeight();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public int getRecyclerViewHeight() {
        return this.mViewParams.getNotesRecyclerView().getMeasuredHeight() + getSearchImeAwareFadingEdgeBottomPadding();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public List<SOMRecognizedInfo> getSOMRecognizedInfo() {
        return this.mSOMRecognizeHelper.getInstance().getSOMRecognizedInfo();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public int getSearchCallerMode() {
        return this.mStateInfo.getSearchCallerMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public FilterInfo.SearchEmptyType getSearchEmptyType() {
        return this.mSearchHelper.getInstance().getSearchEmptyType();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public int getSearchViewTranslationY() {
        return this.mSearchHelper.getInstance().getSearchViewTranslationY();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public Set<String> getSelectedTags() {
        return this.mStateInfo.getSelectedTags();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public Drawable getSubFolderBitmap(int i, int i2) {
        return this.mNotesAdapter.getSubFolderBitmap(i, i2);
    }

    public void handleTipCardItemCountChange() {
        this.mDocumentMap.putHolderInfoMap(1, true);
        if (this.mDocumentMap.sortTopHolderDisplayList(1) == -1) {
            return;
        }
        notifyDataSetChanged("handleTipCardItemCountChange");
        this.mViewParams.getNotesView().getMode().setNoNotesLayoutVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean hasHolderInfo(int... iArr) {
        boolean zHasHolderInfo = false;
        for (int i : iArr) {
            zHasHolderInfo |= this.mDocumentMap.hasHolderInfo(i);
        }
        return zHasHolderInfo;
    }

    public void hideSearchFilter(Runnable runnable) {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(11);
        if (iIndexOfDefaultDisplayData == -1) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.mViewParams.getNotesRecyclerView().findViewHolderForAdapterPosition(iIndexOfDefaultDisplayData);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            HolderAnimation.hideSearchFilterView(viewHolderFindViewHolderForAdapterPosition, new RunnableC4199v(this, runnable, 26));
            return;
        }
        this.mSearchHelper.getInstance().hideSearchFilter();
        if (runnable != null) {
            runnable.run();
        }
    }

    public void initDataObserver() {
        MainLogger.m7254d(TAG, "initDataObserver");
        changeLiveDataSet();
        setObserver();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isFilterCollapsed() {
        return this.mSearchHelper.getInstance().isFilterCollapsed();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isRecentSearchRequired() {
        return this.mSearchHelper.getInstance().isRecentSearchRequired();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isRecentTagRequired() {
        return this.mSearchHelper.getInstance().isRecentTagRequired();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isRunningAnimator() {
        return this.mViewParams.getAbsFragment().isRunningAnimator();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isSOMDataChangeNotifyPendingRequired() {
        return this.mSOMRecognizeHelper.getInstance().isDataChangeNotifyPendingRequired();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isSOMRecognitionStateProgressing() {
        return this.mStateInfo.isSOMRecognitionStateProgressing();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isScrolling() {
        return this.mNotesModel.isScrolling();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean isUnlockConverting(String str) {
        return this.mNotesModel.isUnlockConverting(str);
    }

    public synchronized boolean needInflatedView() {
        return this.mInflatedViewProgress == 0;
    }

    public void notifyDataSetChanged(String str) {
        if (isAdapterAllocated()) {
            AbstractC0000a.m25v("submitList# caller : ", str, TAG);
            this.mNotesAdapter.submitList(new CopyOnWriteArrayList(this.mDocumentMap.getCommonDisplayList()));
        }
    }

    public void notifyDataSetChangedWithViewPageChange(String str) {
        if (isAdapterAllocated()) {
            AbstractC0000a.m25v("notifyDataSetChanged# caller : ", str, TAG);
            this.mNotesAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void notifyItemChanged(int i, @Nullable Object obj, String str) {
        StringBuilder sbM780v = AbstractC0541b.m780v("notifyItemChanged# caller: ", i, str, ", position: ", ", payload: ");
        sbM780v.append(obj);
        MainLogger.m7258i(TAG, sbM780v.toString());
        this.mNotesAdapter.notifyItemChanged(i, obj);
    }

    public void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "notifyItemRangeChanged# positionStart: ", " itemCount: ", ", payload: ");
        sbM1173s.append(obj);
        MainLogger.m7258i(TAG, sbM1173s.toString());
        this.mNotesAdapter.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onBindViewHolder(CommonHolderInfo commonHolderInfo) {
        if (commonHolderInfo == null) {
            return;
        }
        this.mViewParams.getNotesView().getMode().onBindViewHolder(commonHolderInfo, getCheckBox(commonHolderInfo), getCountTextView(commonHolderInfo));
        this.mDragNDropHelper.getInstance().setDragListener(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onCoeditInvitationSelected(String str, String str2, boolean z) {
        if (z) {
            this.mViewParams.getNotesView().getSpaceImpl().onInvitationAccepted(str, str2);
        } else {
            this.mViewParams.getNotesView().getSpaceImpl().onInvitationDeclined(str);
        }
        removeCoeditInvitation(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean onContextClick(CommonHolderInfo commonHolderInfo) {
        return this.mViewParams.getNotesView().onContextClick(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onCoverFilterSelected(@NonNull String str) {
        this.mSearchHelper.getInstance().onCoverFilterSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onFilterCollapsed(boolean z) {
        this.mSearchHelper.getInstance().setFilterCollapse(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onFolderFilterChanged(boolean z) {
        this.mSearchHelper.getInstance().onFolderFilterChanged(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onHashTagSelected(Set<String> set) {
        StringBuilder sb = new StringBuilder("onHashTagSelected# ");
        sb.append(set == null ? "" : MainLogger.getEncode(set.toString()));
        MainLogger.m7254d(TAG, sb.toString());
        this.mSearchHelper.getInstance().onHashTagSelected(set);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean onItemLongPressed(String str) {
        if (this.mViewParams.getNotesRecyclerView().isPenMultiSelectionOn()) {
            return false;
        }
        MainLogger.m7258i(TAG, "onItemLongPressed# uuid : " + str);
        if (FeatureUtils.getViewMode(getModeIndex()) == 1) {
            this.mRecyclerViewHelper.getInstance().setLastCheckedItemView(str);
        }
        this.mDragNDropHelper.getInstance().postStartDragAndDrop(str, this.mViewParams.getNotesView().getMode().onItemLongPressed(str) ? 1000L : 500L);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onKeywordSelected(@NonNull String str) {
        this.mSearchHelper.getInstance().onKeywordSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onNoteSelected(String str, int i, String str2) {
        MainListDocumentData noteData = this.mDocumentMap.getNoteData(str);
        if (noteData == null) {
            MainLogger.m7255e(TAG, "onNoteSelected# SDocUuid : " + str + " mainListDocumentData is null");
            return;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("onNoteSelected# SDocUuid : ", str, ", SDocFilePath : ");
        sbM15l.append(MainLogger.getEncode(noteData.getFilePath()));
        MainLogger.m7258i(TAG, sbM15l.toString());
        if (DocumentTest.UPDATE_DAYS_TO_THE_PAST <= 0) {
            MainEntryParam mainEntryParamBuild = new MainEntryParam.Builder().setDocumentData(noteData).setGuid(C13541h.m14287e().m14294h()).setModeIndex(this.mViewParams.getModeIndex()).setToolType(i).build();
            if (!TextUtils.isEmpty(str2)) {
                mainEntryParamBuild.setUiTitle(str2);
            }
            this.mViewParams.getNotesView().getMode().onNoteSelected(mainEntryParamBuild);
            return;
        }
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this.mViewParams.getContext()).createDocumentDataRepository();
        NotesDocumentEntity notesDocumentEntity = notesDocumentRepositoryCreateDocumentDataRepository.get(str);
        long pastTime = DocumentTimeUtils.getPastTime(System.currentTimeMillis(), DocumentTest.UPDATE_DAYS_TO_THE_PAST);
        notesDocumentEntity.setCreatedAt(pastTime);
        notesDocumentEntity.setLastModifiedAt(pastTime);
        notesDocumentRepositoryCreateDocumentDataRepository.update(notesDocumentEntity);
        ToastHandler.show(this.mViewParams.getContext(), "note was updated to the past: " + DocumentTest.UPDATE_DAYS_TO_THE_PAST + "days", 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onNoteSelectedBySOMRecognizedCard(String str, int i) {
        this.mViewParams.getNotesView().setIsScrollToTop(true, 0);
        this.mViewParams.getNotesView().getMode().releaseEditMode();
        onNoteSelected(str, i, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onOldCategorySelected(String str) {
        this.mViewParams.getNotesView().onOldCategorySelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onRestoreCorruptedNoteSelect(String str) {
        this.mRecyclerViewHelper.getInstance().onRestoreCorruptedNoteSelect(str);
    }

    public void onSOMRecognizeStateChanged() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(2);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        notifyItemChanged(iIndexOfDefaultDisplayData, 4, "onSOMRecognizeStateChanged");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onSOMRecognizedCardAttachedToWindow() {
        this.mSOMRecognizeHelper.getInstance().onSOMRecognizedCardAttachedToWindow();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onSOMRecognizedCardDetachedFromWindow() {
        this.mSOMRecognizeHelper.getInstance().onSOMRecognizedCardDetachedFromWindow();
    }

    public void onSOMRecognizedCardNewBadgeChanged() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(2);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        notifyItemChanged(iIndexOfDefaultDisplayData, 8, "onSOMRecognizedCardNewBadgeChanged");
    }

    public void onSOMRecognizedCardShapeChanged() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(2);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        notifyItemChanged(iIndexOfDefaultDisplayData, 7, "onSOMRecognizedCardShapeChanged");
    }

    public void onSOMRecognizedCardVisibilityChanged() {
        notifyDataSetChanged("onSOMRecognizedCardVisibilityChanged");
    }

    public void onSOMRecognizedInfoChanged() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(2);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        notifyItemChanged(iIndexOfDefaultDisplayData, 5, "onSOMRecognizedInfoChanged");
    }

    public void onSOMScrollStateChangedToIdle() {
        int iIndexOfDefaultDisplayData = this.mDocumentMap.indexOfDefaultDisplayData(2);
        if (iIndexOfDefaultDisplayData == -1) {
            return;
        }
        notifyItemChanged(iIndexOfDefaultDisplayData, 6, "onSOMScrollStateChangedToIdle");
    }

    public void onSOMSubFolderNewBadgeChanged() {
        int iIndexOfSubFolderDisplayData = this.mDocumentMap.indexOfSubFolderDisplayData(FolderConstants.ScreenOffMemo.UUID);
        if (iIndexOfSubFolderDisplayData == -1) {
            return;
        }
        notifyItemChanged(iIndexOfSubFolderDisplayData, 9, "onSOMSubFolderNewBadgeChanged");
    }

    public void onScrollStateChanged(int i) {
        if (FolderConstants.ScreenOffMemo.UUID.equals(this.mStateInfo.getFolderUuid()) && i == 0) {
            onSOMScrollStateChangedToIdle();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean onSpaceLongPressed(String str, String str2) {
        return this.mViewParams.getNotesView().getSpaceImpl().onSpaceLongPressed(str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onSpaceSelected(String str, String str2) {
        this.mViewParams.getNotesView().getSpaceImpl().onSpaceSelected(str, str2);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onSubFolderSelected(String str) {
        this.mViewParams.getNotesView().getMode().onSubFolderSelected(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean onSubHeaderSelected(long j, boolean z) {
        return this.mViewParams.getNotesView().getMode().onSubHeaderSelected(j, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onTimeFilterSelected(int i) {
        this.mSearchHelper.getInstance().onTimeFilterSelected(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onTipCardBindViewHolder(CommonHolderInfo commonHolderInfo) {
        this.mTipCardHelper.getInstance().onBindViewHolder(commonHolderInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onTypeFilterSelected(int i) {
        this.mSearchHelper.getInstance().onTypeFilterSelected(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onViewAttachedToWindow(CommonHolderInfo commonHolderInfo) {
        if (commonHolderInfo != null) {
            this.mViewParams.getNotesView().getMode().onViewAttachedToWindow(commonHolderInfo, getCheckBox(commonHolderInfo), getCountTextView(commonHolderInfo));
        }
    }

    public void reattachDataObserver() {
        MainLogger.m7254d(TAG, "reattachDataObserver");
        removeObserver();
        setObserver();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void registerNoteAnimation(Runnable runnable) {
        if (TextUtils.isEmpty(this.mNotesModel.getLastOpenedSDocXUuid())) {
            runnable.run();
        } else {
            this.mNotesModel.registerNoteAnimation(runnable);
        }
    }

    public void release() {
        removeObserver();
        this.mNotesAdapter.release();
    }

    public synchronized void releaseInflatedView() {
        try {
            this.mInflatedViewProgress = 2;
            ArrayList<View> arrayList = this.mItems;
            if (arrayList != null) {
                arrayList.clear();
                this.mItems = null;
            }
            this.mSubHeader = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void reloadDataObserver() {
        MainLogger.m7254d(TAG, "reloadDataObserver");
        removeObserver();
        changeLiveDataSet();
        setObserver();
    }

    public void removeCoeditInvitation(String str) {
        if (this.mDocumentMap.removeCoeditInvitationMap(str)) {
            this.mDocumentMap.initCommonDisplayList();
            notifyDataSetChangedWithViewPageChange("Coedit Invitation Changed");
            this.mViewParams.getNotesView().onDataChanged(this.mDocumentMap.getCommonDisplayListSize(new String[0]), "removeCoeditInvitation");
        }
    }

    public void removeObserver() {
        MainLogger.m7258i(TAG, "removeObserver");
        removeObserverFromLiveData(this.mDisplayNotesLiveData, this.mSpaceLiveDataObserver);
        removeObserverFromLiveData(this.mDisplayNotesLiveData, this.mDisplayNotesLiveDataObserver);
        LiveData<List<CoeditMainListEntry>> liveData = this.mCoeditNotesLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.mCoeditLiveDataObserver);
        }
        LiveData<CoeditMemberListEntry> liveData2 = this.mCoeditMemberLiveData;
        if (liveData2 != null) {
            liveData2.removeObserver(this.mCoeditMemberLiveDataObserver);
        }
    }

    public void removeTipCard() {
        this.mDocumentMap.putHolderInfoMap(1, false);
        int iIndexOfSortTopHolder = this.mDocumentMap.indexOfSortTopHolder(1);
        if (iIndexOfSortTopHolder == -1) {
            return;
        }
        boolean zIsVisibleHolder = this.mViewParams.getNotesRecyclerView().isVisibleHolder(this.mViewParams.getNotesRecyclerView(), iIndexOfSortTopHolder);
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = !zIsVisibleHolder ? null : this.mViewParams.getNotesRecyclerView().findViewHolderForAdapterPosition(iIndexOfSortTopHolder);
        if (zIsVisibleHolder && viewHolderFindViewHolderForAdapterPosition != null) {
            HolderAnimation.animateHolderFadeOut(viewHolderFindViewHolderForAdapterPosition, new RunnableC8405a(this, 1));
            return;
        }
        this.mDocumentMap.sortTopHolderDisplayList(1);
        notifyDataSetChanged("removeTipCard");
        this.mViewParams.getNotesView().getMode().setNoNotesLayoutVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void requestAllDeleteConvertedNotes() {
        final FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        DataTask dataTask = this.mConvertNotesCheckTask;
        if (dataTask == null) {
            this.mConvertNotesCheckTask = new DataTask(activity);
        } else {
            dataTask.cancel();
        }
        final ArrayList arrayList = new ArrayList();
        this.mDeleteTargetUuids = new ArrayList();
        this.mConvertTargetUuids = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        this.mConvertNotesCheckTask.run(new RunnableC0201c(this, 26, arrayList, arrayList2));
        this.mConvertNotesCheckTask.setCallback(new WorkerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.AdapterManager.5
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onEnd(WorkerTask.Result result) {
                if (CommonUtil.isNotAvailableActivity(activity)) {
                    return;
                }
                if (arrayList2.isEmpty() || !((Boolean) arrayList2.get(0)).booleanValue()) {
                    AdapterManager.this.runDeleteConvertedNotesTask();
                    return;
                }
                LockHelper lockHelper = (LockHelper) AdapterManager.this.mLockHelper.getInstance();
                List list = arrayList;
                lockHelper.verifyLockedNote(118, null, (String[]) list.toArray(new String[list.size()]));
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Callback
            public void onStart(@NotNull WorkerTask<?> workerTask) {
            }
        });
    }

    public void runDeleteConvertedNotesTask() {
        FragmentActivity activity = this.mViewParams.getAbsFragment().getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        MainLogger.m7258i(TAG, "DeleteConvertedNotes# count : " + this.mDeleteTargetUuids.size());
        DeleteTask deleteTask = new DeleteTask(this.mViewParams.getAbsFragment().getActivity(), getModeIndex());
        WorkerTaskManager.getInstance().addTask(deleteTask);
        deleteTask.run(Pair.create(new ArrayList(this.mDeleteTargetUuids), new ArrayList()));
        activity.runOnUiThread(new RunnableC8405a(this, 3));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void setDragListener(CommonHolderInfo commonHolderInfo) {
        this.mDragNDropHelper.getInstance().setDragListener(commonHolderInfo);
    }

    public void setHighlightText(HighlightText highlightText) {
        this.mStateInfo.setHighlightText(highlightText);
    }

    public void showSearchFilter() {
        this.mStateInfo.setShowSearchFilterWithAnimation(true);
        this.mSearchHelper.getInstance().showSearchFilter();
    }

    public void showTipCard() {
        this.mDocumentMap.putHolderInfoMap(1, true);
        int iSortTopHolderDisplayList = this.mDocumentMap.sortTopHolderDisplayList(1);
        if (iSortTopHolderDisplayList == -1) {
            return;
        }
        this.mNotesAdapter.notifyItemInserted(iSortTopHolderDisplayList);
        if (this.mViewParams.getNotesRecyclerView().isVisibleHolder(this.mViewParams.getNotesRecyclerView(), iSortTopHolderDisplayList + 1)) {
            this.mViewParams.getNotesRecyclerView().post(new RunnableC8405a(this, 2));
        }
        this.mViewParams.getNotesView().getMode().setNoNotesLayoutVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void toggleFolderExpandCollapseState() {
        this.mStateInfo.setExpandedFolderBar(!r0.isExpandedFolderBar());
        this.mRecyclerViewHelper.getInstance().updateFolderExpandBarHolder();
        updateDataChangeFromToggleFolderExpandState();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void toggleSOMRecognizedCardExpandCollapseState() {
        this.mSOMRecognizeHelper.getInstance().toggleSOMRecognizedCardExpandCollapseState();
    }

    public void updateDataObserverToCurrentMode() {
        int modeIndex = getModeIndex();
        AbstractC8014b.m7201c(modeIndex, "updateDataObserverToCurrentMode# currentMode : ", TAG);
        if (this.mViewParams.getAbsFragment() == null) {
            return;
        }
        if (FeatureUtils.isSearchMode(modeIndex)) {
            this.mViewParams.getNotesView().getMode().onDataChangedByMode(null);
        } else if (FeatureUtils.isHashTagMode(modeIndex)) {
            this.mViewParams.getNotesView().getMode().onDataChangedByMode(null);
        } else {
            reloadDataObserver();
        }
    }

    public void updateTipCardLayout() {
        if (this.mDocumentMap.sortTopHolderDisplayList(1) == -1) {
            return;
        }
        notifyDataSetChanged("updateTipCardLayout");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public boolean onSubHeaderSelected(boolean z, int i) {
        return this.mViewParams.getNotesView().getMode().onSubHeaderSelected(z, i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract
    public void onHashTagSelected(@Nullable String str) {
        this.mSearchHelper.getInstance().onHashTagSelected(str);
    }
}
