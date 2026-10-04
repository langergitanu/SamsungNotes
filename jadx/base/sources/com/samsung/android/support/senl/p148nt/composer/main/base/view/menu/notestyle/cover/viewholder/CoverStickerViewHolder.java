package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0002\u0019\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverStickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "stickerImageView", "Landroid/widget/ImageView;", "stickerBackgroundView", "contract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverStickerViewHolder$Contract;", "setContract", "", "setStickerBackground", "position", "", "selectedPosition", "coverStickerData", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverStickerData;", "setSelectedSticker", "isSelected", "", "onClick", "view", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStickerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @NotNull
    public static final String TAG = "CoverStickerViewHolder";

    @Nullable
    private Contract contract;

    @NotNull
    private final View stickerBackgroundView;

    @NotNull
    private final ImageView stickerImageView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverStickerViewHolder$Contract;", "", "onSelectSticker", "", "position", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onSelectSticker(int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<CoverStickerUtils.Sticker> entries$0 = EnumEntriesKt.enumEntries(CoverStickerUtils.Sticker.values());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverStickerViewHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(C9086R.id.cover_editor_sticker_item_image_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.stickerImageView = (ImageView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(C9086R.id.cover_editor_sticker_item_bg);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.stickerBackgroundView = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Contract contract = this.contract;
        if (contract != null) {
            contract.onSelectSticker(getAdapterPosition());
        }
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
    }

    public final void setSelectedSticker(boolean isSelected) {
        Drawable background = this.stickerBackgroundView.getBackground();
        if (background != null) {
            background.setAlpha(isSelected ? 255 : 0);
        }
        this.stickerBackgroundView.setSelected(isSelected);
    }

    public final void setStickerBackground(int position, int selectedPosition, @NotNull CoverStickerData coverStickerData) {
        Intrinsics.checkNotNullParameter(coverStickerData, "coverStickerData");
        this.stickerImageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(this.itemView.getContext(), coverStickerData.getUuid()));
        setSelectedSticker(position == selectedPosition);
        this.stickerBackgroundView.setContentDescription(this.itemView.getResources().getString(EntriesMappings.entries$0.get(position).getResId()));
    }
}
