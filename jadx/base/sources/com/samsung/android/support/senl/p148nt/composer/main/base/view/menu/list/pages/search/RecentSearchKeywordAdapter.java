package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.search.RecentSearchKeywordInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecentSearchKeywordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private View.OnClickListener mClearAllClickListenerImpl;
    private final IDataManager mDataManager;
    private View.OnClickListener mDeleteBtnClickListenerImpl;
    private final List<RecentSearchKeywordInfo> mItemList;
    private View.OnClickListener mKeywordClickListenerImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IDataManager {
        void delete(String str);

        void deleteAll();

        void search(String str);
    }

    public RecentSearchKeywordAdapter(List<RecentSearchKeywordInfo> list, IDataManager iDataManager) {
        setHasStableIds(true);
        this.mItemList = list;
        this.mDataManager = iDataManager;
        initListener();
    }

    private int getItemPosition(int i) {
        return i - 1;
    }

    private void initListener() {
        this.mKeywordClickListenerImpl = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecentSearchKeywordAdapter.this.mDataManager.search(((RecentSearchKeywordInfo) RecentSearchKeywordAdapter.this.mItemList.get(((Integer) view.getTag()).intValue())).getKeyword());
            }
        };
        this.mDeleteBtnClickListenerImpl = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecentSearchKeywordAdapter.this.mDataManager.delete(((RecentSearchKeywordInfo) RecentSearchKeywordAdapter.this.mItemList.get(((Integer) view.getTag()).intValue())).getKeyword());
            }
        };
        this.mClearAllClickListenerImpl = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.search.RecentSearchKeywordAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecentSearchKeywordAdapter.this.mDataManager.deleteAll();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mItemList.isEmpty()) {
            return 0;
        }
        return this.mItemList.size() + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return (i == 0 || this.mItemList.size() + 1 == i) ? super.getItemId(i) : this.mItemList.get(getItemPosition(i)).hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        return this.mItemList.size() + 1 == i ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (!(viewHolder instanceof ItemViewHolder)) {
            if (viewHolder instanceof FooterViewHolder) {
                viewHolder.itemView.setOnClickListener(this.mClearAllClickListenerImpl);
                return;
            }
            return;
        }
        int itemPosition = getItemPosition(i);
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        itemViewHolder.getKeywordView().setText(this.mItemList.get(itemPosition).getKeyword());
        itemViewHolder.getItemContainer().setTag(Integer.valueOf(itemPosition));
        itemViewHolder.getItemContainer().setOnClickListener(this.mKeywordClickListenerImpl);
        itemViewHolder.getDeleteButton().setTag(Integer.valueOf(itemPosition));
        itemViewHolder.getDeleteButton().setOnClickListener(this.mDeleteBtnClickListenerImpl);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 0 ? new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_search_recent_keyword_list_header, viewGroup, false)) : i == 2 ? new FooterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_search_recent_keyword_list_footer, viewGroup, false)) : new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_page_list_search_recent_keyword_list_item, viewGroup, false));
    }
}
