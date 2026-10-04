package com.samsung.android.support.senl.p148nt.stt.picker.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mContext", "Landroid/content/Context;", "mHistorySearchInfoList", "", "", "mItemSearchClick", "Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter$ListenerItemSearchClick;", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter$ListenerItemSearchClick;)V", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "LabelHistoryViewHolder", "ListenerItemSearchClick", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LabelHistorySearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Nullable
    private final Context mContext;

    @Nullable
    private final List<String> mHistorySearchInfoList;

    @NotNull
    private ListenerItemSearchClick mItemSearchClick;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter$LabelHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter;Landroid/view/View;)V", "mTitleView", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mDeleteView", "Landroid/widget/ImageView;", "getMDeleteView", "()Landroid/widget/ImageView;", "setMDeleteView", "(Landroid/widget/ImageView;)V", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class LabelHistoryViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private ImageView mDeleteView;

        @NotNull
        private TextView mTitleView;
        final /* synthetic */ LabelHistorySearchAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LabelHistoryViewHolder(@NotNull LabelHistorySearchAdapter labelHistorySearchAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = labelHistorySearchAdapter;
            View viewFindViewById = itemView.findViewById(C11493R.id.search_history_label_text);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mTitleView = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C11493R.id.search_history_item_remove);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.mDeleteView = (ImageView) viewFindViewById2;
            itemView.setOnClickListener(new ViewOnClickListenerC11512c(labelHistorySearchAdapter, this, 0));
            if (labelHistorySearchAdapter.mContext != null) {
                TooltipCompat.setTooltipText(this.mDeleteView, labelHistorySearchAdapter.mContext.getResources().getString(C11493R.string.remove_item_recent_searches));
            }
            this.mDeleteView.setOnClickListener(new ViewOnClickListenerC11512c(labelHistorySearchAdapter, this, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(LabelHistorySearchAdapter labelHistorySearchAdapter, LabelHistoryViewHolder labelHistoryViewHolder, View view) {
            labelHistorySearchAdapter.mItemSearchClick.clickItem(labelHistoryViewHolder.getBindingAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$1(LabelHistorySearchAdapter labelHistorySearchAdapter, LabelHistoryViewHolder labelHistoryViewHolder, View view) {
            labelHistorySearchAdapter.mItemSearchClick.clickDeleteItem(labelHistoryViewHolder.getBindingAdapterPosition());
        }

        @NotNull
        public final ImageView getMDeleteView() {
            return this.mDeleteView;
        }

        @NotNull
        public final TextView getMTitleView() {
            return this.mTitleView;
        }

        public final void setMDeleteView(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mDeleteView = imageView;
        }

        public final void setMTitleView(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitleView = textView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/picker/view/LabelHistorySearchAdapter$ListenerItemSearchClick;", "", "clickItem", "", "position", "", "clickDeleteItem", "clickDeleteAll", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ListenerItemSearchClick {
        void clickDeleteAll();

        void clickDeleteItem(int position);

        void clickItem(int position);
    }

    public LabelHistorySearchAdapter(@Nullable Context context, @Nullable List<String> list, @NotNull ListenerItemSearchClick mItemSearchClick) {
        Intrinsics.checkNotNullParameter(mItemSearchClick, "mItemSearchClick");
        this.mContext = context;
        this.mHistorySearchInfoList = list;
        this.mItemSearchClick = mItemSearchClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.mHistorySearchInfoList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        LabelHistoryViewHolder labelHistoryViewHolder = (LabelHistoryViewHolder) viewHolder;
        List<String> list = this.mHistorySearchInfoList;
        Intrinsics.checkNotNull(list);
        String str = list.get(position);
        labelHistoryViewHolder.getMTitleView().setText(str);
        if (this.mContext != null) {
            labelHistoryViewHolder.getMDeleteView().setContentDescription(this.mContext.getResources().getString(C11493R.string.delete) + " , " + str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(this.mContext).inflate(C11493R.layout.adapter_label_search_history, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new LabelHistoryViewHolder(this, viewInflate);
    }
}
