package com.samsung.android.support.senl.p148nt.app.main.oldnotes.presenter;

import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.DataManager;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.adpater.OldCategoryAdapter;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.model.OldCategoryData;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.presenter.OldCategoryPresenter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0006\u0010\u0015\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001aH\u0016J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/presenter/OldCategoryPresenter;", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/OldCategoryAdapter$Contract;", "contract", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/presenter/OldCategoryPresenter$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/oldnotes/presenter/OldCategoryPresenter$Contract;)V", "mOldCategoryDisplayData", "", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/model/OldCategoryData;", "mCountEntryLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entry/NotesDocumentCountEntry;", "mAdapter", "Lcom/samsung/android/support/senl/nt/app/main/oldnotes/adpater/OldCategoryAdapter;", "mLiveDataObserver", "Landroidx/lifecycle/Observer;", "init", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "observeData", "release", "onItemSelected", "categoryUuid", "", "oldCategoryDataCount", "", "getOldCategoryDataCount", "()I", "getOldCategoryData", "i", "onNotifyBtnClicked", "type", "updateNotifyBtnMargin", "margin", "updateNotifyVisibility", "isVisible", "", "isOldConvertedDataExist", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class OldCategoryPresenter implements OldCategoryAdapter.Contract {

    @NotNull
    public static final String TAG = "OldCategoryPresenter";

    @Nullable
    private Contract contract;

    @Nullable
    private OldCategoryAdapter mAdapter;

    @Nullable
    private LiveData<List<NotesDocumentCountEntry>> mCountEntryLiveData;

    @NotNull
    private final List<OldCategoryData> mOldCategoryDisplayData = new ArrayList();

    @NotNull
    private final Observer<List<NotesDocumentCountEntry>> mLiveDataObserver = new Observer<List<NotesDocumentCountEntry>>() { // from class: com.samsung.android.support.senl.nt.app.main.oldnotes.presenter.OldCategoryPresenter$mLiveDataObserver$1
        @Override // androidx.lifecycle.Observer
        @SuppressLint({"NotifyDataSetChanged"})
        public void onChanged(List<NotesDocumentCountEntry> countEntries) {
            MainLogger.m7254d(OldCategoryPresenter.TAG, "OldCategory LiveData onChanged# countEntries count : " + (countEntries != null ? Integer.valueOf(countEntries.size()) : null));
            ArrayList arrayList = new ArrayList();
            OldCategoryData oldCategoryData = new OldCategoryData(null);
            oldCategoryData.setType(1, 1);
            arrayList.add(0, oldCategoryData);
            if (countEntries != null) {
                Iterator<NotesDocumentCountEntry> it = countEntries.iterator();
                while (it.hasNext()) {
                    NotesDocumentCountEntry next = it.next();
                    if ((next != null ? next.getDocumentCount() : 0) > 0) {
                        arrayList.add(new OldCategoryData(next));
                    }
                }
            }
            OldCategoryData oldCategoryData2 = new OldCategoryData(null);
            oldCategoryData2.setType(1, 2);
            arrayList.add(oldCategoryData2);
            if (Intrinsics.areEqual(this.this$0.mOldCategoryDisplayData, arrayList)) {
                MainLogger.m7254d(OldCategoryPresenter.TAG, "OldCategory LiveData onChanged# Same Data");
                return;
            }
            this.this$0.mOldCategoryDisplayData.clear();
            if (!arrayList.isEmpty()) {
                this.this$0.mOldCategoryDisplayData.addAll(arrayList);
            }
            OldCategoryPresenter.Contract contract = this.this$0.contract;
            if (contract != null) {
                contract.onDataChanged(this.this$0.mOldCategoryDisplayData.size());
            }
            OldCategoryAdapter oldCategoryAdapter = this.this$0.mAdapter;
            if (oldCategoryAdapter != null) {
                oldCategoryAdapter.notifyDataSetChanged();
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/oldnotes/presenter/OldCategoryPresenter$Contract;", "", "onItemSelected", "", "categoryUuid", "", "onDataChanged", "count", "", "onNotifyBtnClicked", "type", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onDataChanged(int count);

        void onItemSelected(@Nullable String categoryUuid);

        void onNotifyBtnClicked(int type);
    }

    public OldCategoryPresenter(@Nullable Contract contract) {
        this.contract = contract;
    }

    private final void observeData() {
        if (this.mCountEntryLiveData == null) {
            this.mCountEntryLiveData = DataManager.getInstance().getAllOldDocumentCountEntry_LiveData();
        }
        LiveData<List<NotesDocumentCountEntry>> liveData = this.mCountEntryLiveData;
        if (liveData != null) {
            Object obj = this.contract;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            liveData.observe(((Fragment) obj).getViewLifecycleOwner(), this.mLiveDataObserver);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.adpater.OldCategoryAdapter.Contract
    @Nullable
    public OldCategoryData getOldCategoryData(int i) {
        try {
            return this.mOldCategoryDisplayData.get(i);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.adpater.OldCategoryAdapter.Contract
    public int getOldCategoryDataCount() {
        return this.mOldCategoryDisplayData.size();
    }

    public final void init(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.mAdapter == null) {
            OldCategoryAdapter oldCategoryAdapter = new OldCategoryAdapter();
            this.mAdapter = oldCategoryAdapter;
            oldCategoryAdapter.setContract(this);
        }
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(this.mAdapter);
        observeData();
    }

    public final boolean isOldConvertedDataExist() {
        return DataManager.getInstance().getAll_ConvertedCount() > 0;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.adpater.OldCategoryAdapter.Contract
    public void onItemSelected(@Nullable String categoryUuid) {
        Contract contract = this.contract;
        if (contract != null) {
            contract.onItemSelected(categoryUuid);
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.oldnotes.adpater.OldCategoryAdapter.Contract
    public void onNotifyBtnClicked(int type) {
        Contract contract = this.contract;
        if (contract != null) {
            contract.onNotifyBtnClicked(type);
        }
    }

    public final void release() {
        LiveData<List<NotesDocumentCountEntry>> liveData = this.mCountEntryLiveData;
        if (liveData != null) {
            liveData.removeObserver(this.mLiveDataObserver);
        }
        this.mCountEntryLiveData = null;
    }

    public final void updateNotifyBtnMargin(int margin) {
        OldCategoryAdapter oldCategoryAdapter = this.mAdapter;
        if (oldCategoryAdapter != null) {
            oldCategoryAdapter.setNotifyButtonMargin(margin);
        }
        OldCategoryAdapter oldCategoryAdapter2 = this.mAdapter;
        if (oldCategoryAdapter2 != null) {
            oldCategoryAdapter2.notifyItemChanged(0);
        }
        OldCategoryAdapter oldCategoryAdapter3 = this.mAdapter;
        if (oldCategoryAdapter3 != null) {
            oldCategoryAdapter3.notifyItemChanged(this.mOldCategoryDisplayData.size() - 1);
        }
    }

    public final void updateNotifyVisibility(boolean isVisible) {
        OldCategoryAdapter oldCategoryAdapter = this.mAdapter;
        if (oldCategoryAdapter != null) {
            oldCategoryAdapter.updateNotifyVisibility(isVisible);
        }
        OldCategoryAdapter oldCategoryAdapter2 = this.mAdapter;
        if (oldCategoryAdapter2 != null) {
            oldCategoryAdapter2.notifyItemChanged(this.mOldCategoryDisplayData.size() - 1);
        }
    }
}
