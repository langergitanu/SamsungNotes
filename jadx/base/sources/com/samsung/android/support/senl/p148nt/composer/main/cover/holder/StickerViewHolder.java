package com.samsung.android.support.senl.p148nt.composer.main.cover.holder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StickerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "StickerViewHolder";
    private Contract mContract;
    private final View mStickerBackgroundView;
    private final ImageView mStickerImageView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onSelectSticker(int i);
    }

    public StickerViewHolder(@NonNull View view) {
        super(view);
        this.mStickerImageView = (ImageView) view.findViewById(C9086R.id.cover_editor_sticker_item_image_view);
        View viewFindViewById = view.findViewById(C9086R.id.cover_editor_sticker_item_bg);
        this.mStickerBackgroundView = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mContract.onSelectSticker(getLayoutPosition());
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void setSelectedSticker(boolean z) {
        this.mStickerBackgroundView.getBackground().setAlpha(z ? 255 : 0);
        this.mStickerBackgroundView.setSelected(z);
    }

    public void setStickerBackground(int i, int i2, CoverStickerData coverStickerData) {
        this.mStickerImageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(this.itemView.getContext(), coverStickerData.getUuid()));
        setSelectedSticker(i == i2);
        this.mStickerBackgroundView.setContentDescription(this.itemView.getResources().getString(CoverStickerUtils.Sticker.values()[i].getResId()));
    }
}
