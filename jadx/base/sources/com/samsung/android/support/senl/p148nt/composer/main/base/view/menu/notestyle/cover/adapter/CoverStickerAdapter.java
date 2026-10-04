package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.viewholder.CoverStickerViewHolder;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverStickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverStickerViewHolder;", "<init>", "()V", "stickerList", "", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverStickerData;", "selectedPosition", "", "stickerContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverStickerAdapter$StickerContract;", "setStickerList", "", XmlErrorCodes.LIST, "", "setStickerContract", "contract", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "updateSelectedPosition", "updateSelectedSticker", "stickerUuid", "", "StickerContract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStickerAdapter extends RecyclerView.Adapter<CoverStickerViewHolder> {

    @NotNull
    public static final String TAG = "CoverStickerAdapter";
    private int selectedPosition;

    @Nullable
    private StickerContract stickerContract;

    @NotNull
    private List<CoverStickerData> stickerList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverStickerAdapter$StickerContract;", "", "onSelectSticker", "", "stickerPosition", "", "stickerPrevPosition", "stickerUuid", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface StickerContract {
        void onSelectSticker(int stickerPosition, int stickerPrevPosition, @NotNull String stickerUuid);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.stickerList.size();
    }

    public final void setStickerContract(@NotNull StickerContract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.stickerContract = contract;
    }

    public final void setStickerList(@NotNull List<? extends CoverStickerData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.stickerList = CollectionsKt.toMutableList((Collection) list);
        notifyDataSetChanged();
    }

    public final void updateSelectedPosition(int position) {
        this.selectedPosition = position;
    }

    public final void updateSelectedSticker(@NotNull String stickerUuid) {
        Intrinsics.checkNotNullParameter(stickerUuid, "stickerUuid");
        updateSelectedPosition(CoverStickerUtils.getStickerIndex(stickerUuid));
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final CoverStickerViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setContract(new CoverStickerViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverStickerAdapter.onBindViewHolder.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.viewholder.CoverStickerViewHolder.Contract
            public void onSelectSticker(int pos) {
                if (pos == CoverStickerAdapter.this.selectedPosition) {
                    return;
                }
                holder.setSelectedSticker(true);
                StickerContract stickerContract = CoverStickerAdapter.this.stickerContract;
                if (stickerContract != null) {
                    int i = CoverStickerAdapter.this.selectedPosition;
                    String uuid = ((CoverStickerData) CoverStickerAdapter.this.stickerList.get(pos)).getUuid();
                    Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
                    stickerContract.onSelectSticker(pos, i, uuid);
                }
                CoverStickerAdapter coverStickerAdapter = CoverStickerAdapter.this;
                coverStickerAdapter.notifyItemChanged(coverStickerAdapter.selectedPosition);
                CoverStickerAdapter.this.selectedPosition = pos;
            }
        });
        holder.setStickerBackground(position, this.selectedPosition, this.stickerList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public CoverStickerViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C9086R.layout.cover_style_sticker_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CoverStickerViewHolder(viewInflate);
    }
}
