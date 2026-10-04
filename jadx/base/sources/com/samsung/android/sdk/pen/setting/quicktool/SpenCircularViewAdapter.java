package com.samsung.android.sdk.pen.setting.quicktool;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenChipView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTColorDialLayout;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u0000  2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u001c\u0010\u0014\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J,\u0010\u0014\u001a\u00020\r2\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0016\u0010\u001a\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter$ColorViewHolder;", "<init>", "()V", "mSelectedPosition", "", "mItemList", "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTColorDialLayout$ColorDialItem;", "mOnItemClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter$OnItemClickListener;", "close", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getItemCount", "updateDialItems", "itemList", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedPosition", "getSelectedPosition", "Companion", "OnItemClickListener", "ColorViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCircularViewAdapter extends RecyclerView.Adapter<ColorViewHolder> {
    private static final int CHANGE_SELECT = 0;

    @NotNull
    private static final String TAG = "SpenCircularViewAdapter";

    @Nullable
    private OnItemClickListener mOnItemClickListener;
    private int mSelectedPosition = -1;

    @NotNull
    private List<SpenSettingQTColorDialLayout.ColorDialItem> mItemList = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter$ColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "viewType", "", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter;Landroid/view/View;I)V", "colorChipView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;", "getColorChipView", "()Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;", "setColorChipView", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenChipView;)V", "selectedBgResourceId", "selectedElevation", "", "setSelected", "", "selected", "", "onClick", "view", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @NotNull
        private SpenChipView colorChipView;
        private final int selectedBgResourceId;
        private final float selectedElevation;
        final /* synthetic */ SpenCircularViewAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ColorViewHolder(@NotNull SpenCircularViewAdapter spenCircularViewAdapter, View itemView, int i) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenCircularViewAdapter;
            this.selectedBgResourceId = C7932R.drawable.qt_color_selected_bg;
            this.selectedElevation = itemView.getContext().getResources().getDimensionPixelSize(C7932R.dimen.qt_circular_dial_item_selected_elevation);
            SpenChipView spenChipView = (SpenChipView) itemView.findViewById(C7932R.id.chip_color_view);
            this.colorChipView = spenChipView;
            spenChipView.setOnClickListener(this);
            if (i == SpenSettingQTColorDialLayout.DialItemType.COLOR.ordinal()) {
                this.colorChipView.setOnClickListener(this);
            } else {
                this.colorChipView.setOnClickListener(null);
            }
        }

        @NotNull
        public final SpenChipView getColorChipView() {
            return this.colorChipView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            int adapterPosition = getAdapterPosition();
            this.this$0.setSelectedPosition(adapterPosition);
            OnItemClickListener onItemClickListener = this.this$0.mOnItemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, adapterPosition);
            }
        }

        public final void setColorChipView(@NotNull SpenChipView spenChipView) {
            Intrinsics.checkNotNullParameter(spenChipView, "<set-?>");
            this.colorChipView = spenChipView;
        }

        public final void setSelected(boolean selected) {
            Log.i(SpenCircularViewAdapter.TAG, "setSelected() selected=" + selected + ", position=" + getAdapterPosition());
            View view = this.itemView;
            view.setElevation(selected ? this.selectedElevation : 0.0f);
            view.setBackgroundResource(selected ? this.selectedBgResourceId : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCircularViewAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "position", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onItemClick(@NotNull View view, int position);
    }

    public final void close() {
        this.mItemList = CollectionsKt.emptyList();
        this.mOnItemClickListener = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.mItemList.get(position % this.mItemList.size()).getType().ordinal();
    }

    /* JADX INFO: renamed from: getSelectedPosition, reason: from getter */
    public final int getMSelectedPosition() {
        return this.mSelectedPosition;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public final void setSelectedPosition(int position) {
        int i = this.mSelectedPosition;
        if (i == position) {
            return;
        }
        this.mSelectedPosition = position;
        notifyItemChanged(position, 0);
        notifyItemChanged(i, 0);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void updateDialItems(@NotNull List<SpenSettingQTColorDialLayout.ColorDialItem> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        AbstractC2322a.m1631u(itemList.size(), "updateDialItems itemListSize= ", TAG);
        this.mItemList = itemList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ColorViewHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ColorViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_qt_color_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new ColorViewHolder(this, viewInflate, viewType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ColorViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SpenSettingQTColorDialLayout.ColorDialItem colorDialItem = this.mItemList.get(position % this.mItemList.size());
        int itemViewType = holder.getItemViewType();
        if (itemViewType == SpenSettingQTColorDialLayout.DialItemType.COLOR.ordinal()) {
            holder.getColorChipView().setColor(colorDialItem.getColor(), String.valueOf(colorDialItem.getDescription()));
            holder.setSelected(this.mSelectedPosition == position);
        } else if (itemViewType == SpenSettingQTColorDialLayout.DialItemType.DIVIDER.ordinal()) {
            holder.getColorChipView().setColorRes(C7932R.drawable.setting_qt_color_divider);
        }
    }

    public void onBindViewHolder(@NotNull ColorViewHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            if (payloads.get(0) instanceof Integer) {
                Integer num = (Integer) payloads.get(0);
                if (num != null && num.intValue() == 0) {
                    holder.setSelected(this.mSelectedPosition == position);
                    return;
                }
                return;
            }
        }
        super.onBindViewHolder(holder, position, payloads);
    }
}
