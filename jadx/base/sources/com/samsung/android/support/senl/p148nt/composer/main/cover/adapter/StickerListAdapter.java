package com.samsung.android.support.senl.p148nt.composer.main.cover.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.cover.holder.StickerViewHolder;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StickerListAdapter extends RecyclerView.Adapter<StickerViewHolder> {
    private static final String TAG = "StickerListAdapter";
    private int mSelectedPosition = 0;
    private StickerContract mStickerContract;
    private List<CoverStickerData> mStickerList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StickerContract {
        void onSelectSticker(int i, int i2, String str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mStickerList.size();
    }

    public void setStickerContract(StickerContract stickerContract) {
        this.mStickerContract = stickerContract;
    }

    public void setStickerList(List<CoverStickerData> list) {
        this.mStickerList = list;
    }

    public void updateCoverStickerList(List<CoverStickerData> list) {
        this.mStickerList.addAll(list);
    }

    public void updateSelectedPosition(int i) {
        this.mSelectedPosition = i;
    }

    public void updateSelectedSticker(int i) {
        updateSelectedPosition(i);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull final StickerViewHolder stickerViewHolder, int i) {
        stickerViewHolder.setContract(new StickerViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.StickerListAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.holder.StickerViewHolder.Contract
            public void onSelectSticker(int i2) {
                if (i2 == StickerListAdapter.this.mSelectedPosition) {
                    return;
                }
                stickerViewHolder.setSelectedSticker(true);
                StickerListAdapter.this.mStickerContract.onSelectSticker(i2, StickerListAdapter.this.mSelectedPosition, ((CoverStickerData) StickerListAdapter.this.mStickerList.get(i2)).getUuid());
                StickerListAdapter stickerListAdapter = StickerListAdapter.this;
                stickerListAdapter.notifyItemChanged(stickerListAdapter.mSelectedPosition);
                StickerListAdapter.this.mSelectedPosition = i2;
            }
        });
        stickerViewHolder.setStickerBackground(i, this.mSelectedPosition, this.mStickerList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public StickerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new StickerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.cover_editor_new_sticker_list_item, viewGroup, false));
    }
}
