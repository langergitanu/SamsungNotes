package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.EssentialItemViewHolder;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.TemplateCommonViewHolder;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseItemAdapter extends RecyclerView.Adapter<TemplateCommonViewHolder> {
    private static final String TAG = "BaseItemAdapter";
    protected OnItemActionListener mDefaultItemListener;
    protected List<TemplateItem> mItemList;
    private final List<TemplateItem> mSelectedTemplates = new ArrayList();

    public BaseItemAdapter() {
        Logger.m10999d(TAG, "initBaseItemAdapter");
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMode(int i) {
        Iterator<TemplateItem> it = this.mItemList.iterator();
        while (it.hasNext()) {
            it.next().setMode(i);
        }
        notifyDataSetChanged();
    }

    public void clearSelectedTemplates() {
        this.mSelectedTemplates.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<TemplateItem> list = this.mItemList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.mItemList.get(i).getName().hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mItemList.get(i).getType();
    }

    public TemplateItem getRenameItem() {
        List<TemplateItem> list = this.mSelectedTemplates;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.mSelectedTemplates.get(0);
    }

    public List<TemplateItem> getSelectedTemplates() {
        return this.mSelectedTemplates;
    }

    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    public void notifyItemChanged(TemplateItem templateItem) {
        notifyItemChanged(this.mItemList.indexOf(templateItem));
    }

    public int requestSelectAllItems(boolean z) {
        if (z) {
            this.mSelectedTemplates.clear();
            this.mSelectedTemplates.addAll(this.mItemList);
            if (this.mSelectedTemplates.get(0).getType() == 25) {
                this.mSelectedTemplates.remove(0);
            }
        } else {
            this.mSelectedTemplates.removeAll(this.mItemList);
        }
        notifyDataSetChanged();
        return this.mSelectedTemplates.size();
    }

    public void setItemList(List<TemplateItem> list) {
        this.mItemList = list;
    }

    public void setOnClickListener(OnItemActionListener onItemActionListener) {
        this.mDefaultItemListener = onItemActionListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull TemplateCommonViewHolder templateCommonViewHolder, int i) {
        templateCommonViewHolder.onBind(this.mItemList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public TemplateCommonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return (i == 25 || i == 3 || i == 5) ? new AddedItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_template_item_layout, viewGroup, false), i, this.mDefaultItemListener, new AddedItemViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.BaseItemAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.Contract
            public int addSelectedItem(TemplateItem templateItem) {
                BaseItemAdapter.this.mSelectedTemplates.add(templateItem);
                return BaseItemAdapter.this.mSelectedTemplates.size();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.Contract
            public boolean isSelectedItem(TemplateItem templateItem) {
                return BaseItemAdapter.this.mSelectedTemplates.contains(templateItem);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.Contract
            public int removeSelectedItem(TemplateItem templateItem) {
                BaseItemAdapter.this.mSelectedTemplates.remove(templateItem);
                return BaseItemAdapter.this.mSelectedTemplates.size();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.Contract
            public void updateMode(int i2) {
                BaseItemAdapter.this.clearSelectedTemplates();
                BaseItemAdapter.this.updateMode(i2);
            }
        }) : new EssentialItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_template_item_layout, viewGroup, false), i, this.mDefaultItemListener);
    }
}
