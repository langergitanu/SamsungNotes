package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.ChipView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u001b\u001c\u001dB'\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001c\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001c\u0010\u0015\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0014\u0010\u0018\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0007R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ColorDialItem;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter$ViewHolder;", "mOnItemClick", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "mSelectedPosition", "mSelectedItem", "mCurrentList", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "updateDialItems", "itemList", "setSelectedPosition", "ViewHolder", "ColorDialItemDiffCallback", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTColorAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTColorAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n1878#2,3:124\n1573#2:127\n1604#2,4:128\n*S KotlinDebug\n*F\n+ 1 QTColorAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter\n*L\n54#1:124,3\n66#1:127\n66#1:128,4\n*E\n"})
public final class QTColorAdapter extends ListAdapter<SettingQTColorDialLayout.ColorDialItem, ViewHolder> {

    @NotNull
    private static final String TAG = "QTColorAdapter";

    @NotNull
    private List<SettingQTColorDialLayout.ColorDialItem> mCurrentList;

    @NotNull
    private final Function3<View, Integer, Integer, Unit> mOnItemClick;

    @Nullable
    private SettingQTColorDialLayout.ColorDialItem mSelectedItem;
    private int mSelectedPosition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter$ColorDialItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$ColorDialItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ColorDialItemDiffCallback extends DiffUtil.ItemCallback<SettingQTColorDialLayout.ColorDialItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull SettingQTColorDialLayout.ColorDialItem oldItem, @NotNull SettingQTColorDialLayout.ColorDialItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull SettingQTColorDialLayout.ColorDialItem oldItem, @NotNull SettingQTColorDialLayout.ColorDialItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "viewType", "", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorAdapter;Landroid/view/View;I)V", "colorChipView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/ChipView;", "getColorChipView", "()Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/ChipView;", "selectedElevation", "", "setSelected", "", "selected", "", "onClick", "view", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @NotNull
        private final ChipView colorChipView;
        private final float selectedElevation;
        final /* synthetic */ QTColorAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull QTColorAdapter qTColorAdapter, View itemView, int i) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = qTColorAdapter;
            View viewFindViewById = itemView.findViewById(C9086R.id.chip_color_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ChipView chipView = (ChipView) viewFindViewById;
            this.colorChipView = chipView;
            this.selectedElevation = itemView.getResources().getDimension(C9086R.dimen.composer_qt_circular_dial_item_selected_elevation);
            if (i == SettingQTColorDialLayout.DialItemType.COLOR.ordinal()) {
                chipView.setOnClickListener(this);
            } else {
                chipView.setOnClickListener(null);
            }
        }

        @NotNull
        public final ChipView getColorChipView() {
            return this.colorChipView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int bindingAdapterPosition = getBindingAdapterPosition();
            this.this$0.mOnItemClick.invoke(view, Integer.valueOf(this.this$0.mSelectedPosition), Integer.valueOf(bindingAdapterPosition));
            this.this$0.setSelectedPosition(bindingAdapterPosition);
        }

        public final void setSelected(boolean selected) {
            AbstractC8014b.m7224z("setSelected() selected=", QTColorAdapter.TAG, selected);
            if (selected) {
                this.itemView.setElevation(this.selectedElevation);
                this.itemView.setBackgroundResource(C9086R.drawable.qt_color_selected_bg);
            } else {
                this.itemView.setElevation(0.0f);
                this.itemView.setBackgroundResource(0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QTColorAdapter(@NotNull Function3<? super View, ? super Integer, ? super Integer, Unit> mOnItemClick) {
        super(new ColorDialItemDiffCallback());
        Intrinsics.checkNotNullParameter(mOnItemClick, "mOnItemClick");
        this.mOnItemClick = mOnItemClick;
        this.mSelectedPosition = -1;
        this.mCurrentList = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mCurrentList.get(position % this.mCurrentList.size()).getType().ordinal();
    }

    public final void setSelectedPosition(int position) {
        if (this.mSelectedPosition == position) {
            return;
        }
        this.mSelectedPosition = position;
        SettingQTColorDialLayout.ColorDialItem colorDialItem = (SettingQTColorDialLayout.ColorDialItem) CollectionsKt.getOrNull(this.mCurrentList, position);
        this.mSelectedItem = colorDialItem;
        if (colorDialItem != null) {
            colorDialItem.setSelected(false);
        }
        List<SettingQTColorDialLayout.ColorDialItem> list = this.mCurrentList;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(SettingQTColorDialLayout.ColorDialItem.copy$default((SettingQTColorDialLayout.ColorDialItem) obj, null, 0, null, false, i == this.mSelectedPosition, 15, null));
            i = i2;
        }
        this.mCurrentList = arrayList;
        submitList(arrayList);
    }

    public final void updateDialItems(@NotNull List<SettingQTColorDialLayout.ColorDialItem> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        AbstractC8014b.m7217s(itemList.size(), "updateDialItems() size = ", TAG);
        this.mSelectedPosition = CollectionsKt.indexOf((List<? extends SettingQTColorDialLayout.ColorDialItem>) itemList, this.mSelectedItem);
        int i = 0;
        for (Object obj : itemList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((SettingQTColorDialLayout.ColorDialItem) obj).setSelected(i == this.mSelectedPosition);
            i = i2;
        }
        this.mCurrentList = itemList;
        submitList(itemList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SettingQTColorDialLayout.ColorDialItem colorDialItem = this.mCurrentList.get(position % this.mCurrentList.size());
        int itemViewType = holder.getItemViewType();
        if (itemViewType == SettingQTColorDialLayout.DialItemType.COLOR.ordinal()) {
            holder.getColorChipView().setColor(colorDialItem.getColor(), colorDialItem.getDescription());
            holder.setSelected(colorDialItem.getSelected());
        } else if (itemViewType == SettingQTColorDialLayout.DialItemType.DIVIDER.ordinal()) {
            holder.getColorChipView().setColorRes(C9086R.drawable.qt_color_divider);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C9086R.layout.qt_color_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(this, viewInflate, viewType);
    }
}
