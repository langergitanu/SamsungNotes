package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.common.data.HighlightText;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.CoeditSpaceHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.NotesHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SOMRecognizedCardHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SearchFilterHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter.ViewHolderFactory;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesAdapter extends ListAdapter<Common, CommonHolder> implements IAdapter {
    private static final int PREFIXED_ID = 234234;
    private static final String TAG = "NotesAdapter";
    private final AdapterContract mAdapterContract;
    private final DocumentMap mDocumentMap;
    private NotesPenRecyclerView mRecyclerView;
    private final StateInfo mStateInfo;
    private final Map<String, Drawable> mSubFolderIconCache;

    public NotesAdapter(NotesPenRecyclerView notesPenRecyclerView, AdapterContract adapterContract, DocumentMap documentMap, StateInfo stateInfo) {
        super(new NotesDiffCallback());
        this.mSubFolderIconCache = new ConcurrentHashMap();
        setHasStableIds(true);
        this.mRecyclerView = notesPenRecyclerView;
        this.mAdapterContract = adapterContract;
        this.mDocumentMap = documentMap;
        this.mStateInfo = stateInfo;
    }

    private void onBindNoteHolderWithPayload(@NonNull NotesHolder notesHolder, Common common, int i, @NonNull Object obj) {
        if (common == null) {
            return;
        }
        if ("com.samsung.android.app.notes.memolist.ACTION_FORCE_UPDATE".equals(obj) || obj.equals(2)) {
            notesHolder.getNotesHolderInfo().setForceUpdate(true);
            notesHolder.decorate(common.notes, this.mStateInfo.getHighlightText());
            notesHolder.onBindViewHolder(i);
            notesHolder.getNotesHolderInfo().setForceUpdate(false);
            this.mStateInfo.setForceUpdateThumbnail(null);
            return;
        }
        if (obj.equals(3)) {
            notesHolder.decorate(common.notes, new HighlightText());
            notesHolder.onBindViewHolder(i);
        } else if (!NotesConstants.PAYLOAD_CHANGE_TIME.equals(obj)) {
            notesHolder.decorateExtra(common.notes);
        } else {
            notesHolder.getNotesHolderInfo().setDateText(ContentUtils.getDate(notesHolder.itemView.getContext(), NotesConstants.Sort.isModifiedType(NotesUtils.getSortType()) ? common.notes.getLastModifiedAt() : common.notes.getCreatedAt()));
            notesHolder.decorateExtra(common.notes);
        }
    }

    private void onBindSOMRecognizedCardHolderWithPayload(@NonNull SOMRecognizedCardHolder sOMRecognizedCardHolder, Common common, @NonNull List<Object> list) {
        if (common == null) {
            return;
        }
        Object obj = null;
        for (Object obj2 : list) {
            if (!obj2.equals(obj)) {
                MainLogger.m7254d(TAG, "onBindSOMRecognizedCardHolderWithPayload, handled payload : " + obj2);
                if (obj2.equals(4)) {
                    sOMRecognizedCardHolder.decorateRunningState();
                } else if (obj2.equals(5)) {
                    sOMRecognizedCardHolder.decorate(this.mStateInfo.getSOMRecognizedCardShape());
                } else if (obj2.equals(6)) {
                    sOMRecognizedCardHolder.onListScrollStateChangeToIdle();
                } else if (obj2.equals(7)) {
                    sOMRecognizedCardHolder.onCardShapeChanged(this.mStateInfo.getPrevSOMRecognizedCardShape(), this.mStateInfo.getSOMRecognizedCardShape());
                } else if (obj2.equals(8)) {
                    sOMRecognizedCardHolder.decorateNewBadge();
                }
                obj = obj2;
            }
        }
    }

    private void onBindSearchFilterHolderWithPayload(SearchFilterHolder searchFilterHolder, Common common, @NonNull List<Object> list) {
        if (common instanceof Common.SearchFilter) {
            Object obj = null;
            for (Object obj2 : list) {
                if (!obj2.equals(obj)) {
                    MainLogger.m7254d(TAG, "onBindSearchFilterHolderWithPayload, handled payload : " + obj2);
                    if (obj2.equals(10)) {
                        searchFilterHolder.notifyRecentSearchDataChanged();
                    } else if (obj2.equals(11)) {
                        searchFilterHolder.updateSearchContainer();
                    } else if (obj2.equals(12)) {
                        searchFilterHolder.updateTagContainer();
                    } else if (obj2.equals(13)) {
                        searchFilterHolder.updateSearchVisibility(this.mAdapterContract.isRecentSearchRequired() ? 0 : 8);
                    } else if (obj2.equals(14)) {
                        searchFilterHolder.updateTagVisibility(this.mAdapterContract.isRecentTagRequired() ? 0 : 8);
                    } else if (obj2.equals(15)) {
                        searchFilterHolder.updateData(this.mStateInfo.getFilterInfo());
                    } else if (obj2.equals(16)) {
                        searchFilterHolder.collapseFilter();
                    } else if (obj2.equals(17)) {
                        searchFilterHolder.onViewModeChanged();
                    } else if (obj2.equals(18)) {
                        searchFilterHolder.updateSearchEmptyView();
                    }
                    obj = obj2;
                }
            }
        }
    }

    private void onBindSubFolderHolderWithPayload(SubFolderHolder subFolderHolder, Common common, List<Object> list) {
        if (common == null) {
            return;
        }
        Object obj = null;
        for (Object obj2 : list) {
            if (!obj2.equals(obj)) {
                MainLogger.m7254d(TAG, "onBindSubFolderHolderWithPayload, handled payload : " + obj2);
                if (obj2.equals(9)) {
                    subFolderHolder.decorateSOMSubFolderNewBadge();
                }
                obj = obj2;
            }
        }
    }

    private void onBindViewHolderByType(int i, View view) {
        if (NotesUtils.isStaggeredGridLayout(this.mRecyclerView.getLayoutMode())) {
            try {
                StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
                if (i == 2048) {
                    if (layoutParams.isFullSpan()) {
                        layoutParams.setFullSpan(false);
                        view.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                if (layoutParams.isFullSpan()) {
                    return;
                }
                layoutParams.setFullSpan(true);
                view.setLayoutParams(layoutParams);
            } catch (ClassCastException e) {
                MainLogger.m7255e(TAG, "onBindViewHolderByType : " + e.getMessage());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.IAdapter
    public void addSubFolderBitmap(int i, int i2, @NotNull Drawable drawable) {
        int iMin = Math.min(2, i);
        this.mSubFolderIconCache.put(iMin + "/" + i2, drawable);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Common> commonDisplayList = this.mDocumentMap.getCommonDisplayList();
        if (commonDisplayList == null) {
            return 0;
        }
        return commonDisplayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Common commonDisplayData = this.mDocumentMap.getCommonDisplayData(i);
        if (commonDisplayData == null) {
            return 0L;
        }
        int i2 = commonDisplayData.type;
        if (i2 == 2048) {
            return commonDisplayData.notes.getId().longValue();
        }
        if (i2 <= 1024) {
            return commonDisplayData.folders.get(0).getId();
        }
        if (i2 == 16384) {
            return 234234L;
        }
        if (i2 == 8192) {
            return commonDisplayData.space.getSpaceId().hashCode();
        }
        if (i2 == 131072) {
            return commonDisplayData.invitation.getRequestedTime();
        }
        if (i2 != 4096) {
            return commonDisplayData.f6179id;
        }
        long j = commonDisplayData.time;
        return j > 0 ? j + 234234 : commonDisplayData.f6179id + 234234;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<Common> commonDisplayList = this.mDocumentMap.getCommonDisplayList();
        if (commonDisplayList.isEmpty() || commonDisplayList.size() <= i || commonDisplayList.get(i) == null) {
            return 0;
        }
        return commonDisplayList.get(i).type;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.IAdapter
    public Drawable getSubFolderBitmap(int i, int i2) {
        int iMin = Math.min(2, i);
        return this.mSubFolderIconCache.get(iMin + "/" + i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = (NotesPenRecyclerView) recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.IAdapter
    public void release() {
        this.mSubFolderIconCache.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) {
        onBindViewHolder((CommonHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public CommonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CommonHolder commonHolderCreateHolder = ViewHolderFactory.createHolder(viewGroup, this.mAdapterContract.getInflatedView(i), i, this.mStateInfo.getSubFoldersSpan(), FeatureUtils.getViewMode(this.mAdapterContract.getModeIndex()));
        commonHolderCreateHolder.setAdapterContract(this.mAdapterContract);
        return commonHolderCreateHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull CommonHolder commonHolder) {
        super.onViewAttachedToWindow(commonHolder);
        commonHolder.onViewAttachedToWindow(commonHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull CommonHolder commonHolder) {
        commonHolder.onViewDetachedFromWindow(commonHolder);
        super.onViewDetachedFromWindow(commonHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull CommonHolder commonHolder) {
        super.onViewRecycled(commonHolder);
        if (commonHolder.getMHolderType() == 2048) {
            ((NotesHolder) commonHolder).clearThumbnailHolder();
        } else if (commonHolder.getMHolderType() == 8192) {
            CoeditSpaceHolder coeditSpaceHolder = (CoeditSpaceHolder) commonHolder;
            coeditSpaceHolder.clearThumbnailHolder();
            CoeditHandlerManager.getInstance().unregisterExternalSnap(coeditSpaceHolder.getCoeditSpaceHolderInfo().getUuid());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull CommonHolder commonHolder, int i) {
        int mHolderType = commonHolder.getMHolderType();
        MainLogger.m7254d(TAG, "onBindViewHolder# modeIndex : " + this.mAdapterContract.getModeIndex() + ", holderType : " + mHolderType + ", position : " + i);
        Common commonDisplayData = this.mDocumentMap.getCommonDisplayData(i);
        if (commonDisplayData == null) {
            return;
        }
        if (mHolderType == 2048) {
            ((NotesHolder) commonHolder).setFolderData(this.mDocumentMap.getFolderData(commonDisplayData.notes.getCategoryUuid()));
        }
        onBindViewHolderByType(mHolderType, commonHolder.itemView);
        Common commonDisplayData2 = this.mDocumentMap.getCommonDisplayData(i + 1);
        commonHolder.setBottomOfSameViewType(commonDisplayData2 == null || commonDisplayData2.type != commonDisplayData.type);
        if (mHolderType == 2048 && this.mStateInfo.isForceUpdateThumbnail(commonDisplayData.uuid)) {
            NotesHolder notesHolder = (NotesHolder) commonHolder;
            notesHolder.getNotesHolderInfo().setForceUpdate(true);
            commonHolder.decorate(commonDisplayData, this.mStateInfo);
            commonHolder.onBindViewHolder(i);
            notesHolder.getNotesHolderInfo().setForceUpdate(false);
            this.mStateInfo.setForceUpdateThumbnail(null);
            return;
        }
        commonHolder.decorate(commonDisplayData, this.mStateInfo);
        commonHolder.onBindViewHolder(i);
    }

    public void onBindViewHolder(@NonNull CommonHolder commonHolder, int i, @NonNull List<Object> list) {
        if (list.isEmpty()) {
            super.onBindViewHolder(commonHolder, i, list);
            return;
        }
        int mHolderType = commonHolder.getMHolderType();
        MainLogger.m7254d(TAG, "onBindViewHolder# modeIndex : " + this.mAdapterContract.getModeIndex() + ", holderType : " + mHolderType + ", position : " + i + ", payloads : " + list);
        Common commonDisplayData = this.mDocumentMap.getCommonDisplayData(i);
        if (commonDisplayData == null) {
            return;
        }
        if (mHolderType <= 1024) {
            onBindSubFolderHolderWithPayload((SubFolderHolder) commonHolder, commonDisplayData, list);
            return;
        }
        if (mHolderType == 2048) {
            onBindNoteHolderWithPayload((NotesHolder) commonHolder, commonDisplayData, i, AbstractC0000a.m10g(list, 1));
            return;
        }
        if (mHolderType == 262144) {
            onBindSOMRecognizedCardHolderWithPayload((SOMRecognizedCardHolder) commonHolder, commonDisplayData, list);
            return;
        }
        if (mHolderType == 16384) {
            commonHolder.decorate(commonDisplayData, this.mStateInfo);
            commonHolder.onBindViewHolder(i);
        } else if (mHolderType == 2097152) {
            onBindSearchFilterHolderWithPayload((SearchFilterHolder) commonHolder, commonDisplayData, list);
        }
    }
}
