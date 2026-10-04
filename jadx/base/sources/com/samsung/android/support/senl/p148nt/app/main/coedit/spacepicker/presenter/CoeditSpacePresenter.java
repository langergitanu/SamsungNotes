package com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.presenter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6698l;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.CoeditSpaceAdapter;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.SpacePickerSelectListener;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.CoeditSpaceMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMapContract;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SpaceEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpacePresenter implements DocumentMapContract.Coedit {
    private static final String TAG = "CoeditSpacePresenter";
    private final CoeditSpaceAdapter mAdapter;
    private LiveData<List<CoeditMainListEntry>> mCoeditGroupLiveData;
    private final Observer<List<CoeditMainListEntry>> mCoeditLiveDataObserver = new Observer<List<CoeditMainListEntry>>() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.presenter.CoeditSpacePresenter.1
        private boolean equalsSpace(SpaceEntry spaceEntry, SpaceEntry spaceEntry2) {
            return spaceEntry.getMemberCount() == spaceEntry2.getMemberCount() && spaceEntry.getUnReadCount() == spaceEntry2.getUnReadCount() && Objects.equals(spaceEntry.getGroupId(), spaceEntry2.getGroupId()) && Objects.equals(spaceEntry.getSpaceId(), spaceEntry2.getSpaceId()) && Objects.equals(spaceEntry.getTitle(), spaceEntry2.getTitle()) && Objects.equals(spaceEntry.getThumbnailIds(), spaceEntry2.getThumbnailIds());
        }

        private boolean initCoeditSpaceDisplayData() {
            if (CoeditSpacePresenter.this.mSpaceDisplayList == null) {
                CoeditSpacePresenter.this.mSpaceDisplayList = new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            CoeditSpacePresenter.this.mCoeditSpaceMap.initCoeditSpaceDisplayData(arrayList);
            if (!isEquals(arrayList)) {
                CoeditSpacePresenter.this.mSpaceDisplayList.clear();
                CoeditSpacePresenter.this.mSpaceDisplayList.addAll(arrayList);
                return true;
            }
            MainCoeditLogger.m7250d(CoeditSpacePresenter.TAG, "initCoeditSpaceDisplayData# new displayData and old displayData are same, commonDisplayList size : " + CoeditSpacePresenter.this.mSpaceDisplayList.size());
            return false;
        }

        private boolean isEquals(List<Common> list) {
            int size;
            if (CoeditSpacePresenter.this.mSpaceDisplayList == null || CoeditSpacePresenter.this.mSpaceDisplayList.isEmpty() || list.size() != (size = CoeditSpacePresenter.this.mSpaceDisplayList.size())) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!isEquals(CoeditSpacePresenter.this.mSpaceDisplayList.get(i), list.get(i))) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(List<CoeditMainListEntry> list) {
            MainCoeditLogger.m7250d(CoeditSpacePresenter.TAG, "[CS9] CoeditLiveDataObserver# onChanged, size : " + list.size());
            CoeditSpacePresenter.this.mCoeditSpaceMap.initCoeditMap(list);
            if (initCoeditSpaceDisplayData()) {
                CoeditSpacePresenter.this.notifyDataSetChanged("Space onChanged");
            }
        }

        private boolean isEquals(@Nullable Object obj, @Nullable Object obj2) {
            if (obj != null && obj2 != null) {
                Common common = (Common) obj;
                Common common2 = (Common) obj2;
                int i = common2.type;
                if (i != common.type) {
                    return false;
                }
                if (i == 8192) {
                    return equalsSpace(common2.space, common.space);
                }
                if (i == 4096 && common2.f6179id == common.f6179id) {
                    return true;
                }
            }
            return false;
        }
    };
    private final CoeditSpaceMap mCoeditSpaceMap;
    private List<Common> mSpaceDisplayList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewContract {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface IRecyclerView {
            void setAdapter(CoeditSpaceAdapter coeditSpaceAdapter);
        }
    }

    public CoeditSpacePresenter(Fragment fragment, SpacePickerSelectListener spacePickerSelectListener, ViewContract.IRecyclerView iRecyclerView) {
        CoeditSpaceMap coeditSpaceMap = new CoeditSpaceMap(this);
        this.mCoeditSpaceMap = coeditSpaceMap;
        CoeditSpaceAdapter coeditSpaceAdapter = new CoeditSpaceAdapter(spacePickerSelectListener, coeditSpaceMap);
        this.mAdapter = coeditSpaceAdapter;
        iRecyclerView.setAdapter(coeditSpaceAdapter);
        setObserver(fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged(String str) {
        MainCoeditLogger.m7253i(TAG, "notifyDataSetChanged# caller : " + str);
        this.mAdapter.notifyDataSetChanged();
    }

    private void setObserver(Fragment fragment) {
        if (this.mCoeditGroupLiveData == null) {
            this.mCoeditGroupLiveData = new C6698l(fragment.getContext(), NotesUtils.getSortParam());
        }
        try {
            this.mCoeditGroupLiveData.observe(fragment.getViewLifecycleOwner(), this.mCoeditLiveDataObserver);
        } catch (IllegalStateException e) {
            MainCoeditLogger.m7251e(TAG, "setObserver# " + this.mCoeditGroupLiveData.toString() + " IllegalStateException: " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.model.DocumentMapContract.Coedit
    public void putHolderInfoMap(int i, boolean z) {
    }

    public void removeObserver() {
        LiveData<List<CoeditMainListEntry>> liveData = this.mCoeditGroupLiveData;
        if (liveData == null) {
            return;
        }
        liveData.removeObserver(this.mCoeditLiveDataObserver);
    }
}
