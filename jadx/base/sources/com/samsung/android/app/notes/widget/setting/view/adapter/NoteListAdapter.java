package com.samsung.android.app.notes.widget.setting.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.widget.common.log.WidgetLogger;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7004e;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 %2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0005!\"#$%B-\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0017J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004H\u0016J \u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0012H\u0016R\u001b\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$NoteListHolder;", "noteList", "", "", "mStartDragListener", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$OnStartDragListener;", "mHeightListener", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$ItemLayoutHeightListener;", "<init>", "(Ljava/util/List;Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$OnStartDragListener;Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$ItemLayoutHeightListener;)V", "getNoteList", "()Ljava/util/List;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "", "onBindViewHolder", "", "holder", "pos", "position", "payloads", "", "decorateItemView", "mainListDocumentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "decorateTitle", "decorateDivider", "decorateReorder", "getItemCount", "NoteListHolder", "ItemRemoveClickListener", "OnStartDragListener", "ItemLayoutHeightListener", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NoteListAdapter extends RecyclerView.Adapter<NoteListHolder> {

    @NotNull
    private static final String TAG = "NoteListAdapter";

    @Nullable
    private final ItemLayoutHeightListener mHeightListener;

    @Nullable
    private final OnStartDragListener mStartDragListener;

    @Nullable
    private final List<String> noteList;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$ItemLayoutHeightListener;", "", "onItemRemoved", "", "position", "", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ItemLayoutHeightListener {
        void onItemRemoved(int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$ItemRemoveClickListener;", "", "onItemRemoveClick", "", "view", "Landroid/view/View;", "position", "", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ItemRemoveClickListener {
        void onItemRemoveClick(@Nullable View view, int position);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$NoteListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mDelete", "Landroid/widget/ImageButton;", "getMDelete", "()Landroid/widget/ImageButton;", "setMDelete", "(Landroid/widget/ImageButton;)V", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "setMTitle", "(Landroid/widget/TextView;)V", "mReorder", "getMReorder", "setMReorder", "mRemoveClickListener", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$ItemRemoveClickListener;", "onClick", "", VPathDataCmd.RCurveTo, "setItemRemoveClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class NoteListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static final int $stable = 8;

        @NotNull
        private ImageButton mDelete;

        @Nullable
        private ItemRemoveClickListener mRemoveClickListener;

        @NotNull
        private ImageButton mReorder;

        @NotNull
        private TextView mTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoteListHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C11391R.id.list_delete);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mDelete = (ImageButton) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C11391R.id.list_title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.mTitle = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C11391R.id.list_reorder);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.mReorder = (ImageButton) viewFindViewById3;
            this.mDelete.setOnClickListener(this);
        }

        @NotNull
        public final ImageButton getMDelete() {
            return this.mDelete;
        }

        @NotNull
        public final ImageButton getMReorder() {
            return this.mReorder;
        }

        @NotNull
        public final TextView getMTitle() {
            return this.mTitle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            int bindingAdapterPosition;
            ItemRemoveClickListener itemRemoveClickListener;
            Intrinsics.checkNotNullParameter(v, "v");
            if (this.mRemoveClickListener == null || (bindingAdapterPosition = getBindingAdapterPosition()) < 0 || (itemRemoveClickListener = this.mRemoveClickListener) == null) {
                return;
            }
            itemRemoveClickListener.onItemRemoveClick(v, bindingAdapterPosition);
        }

        public final void setItemRemoveClickListener(@Nullable ItemRemoveClickListener listener) {
            this.mRemoveClickListener = listener;
        }

        public final void setMDelete(@NotNull ImageButton imageButton) {
            Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
            this.mDelete = imageButton;
        }

        public final void setMReorder(@NotNull ImageButton imageButton) {
            Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
            this.mReorder = imageButton;
        }

        public final void setMTitle(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitle = textView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/NoteListAdapter$OnStartDragListener;", "", "onStartDrag", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnStartDragListener {
        void onStartDrag(@Nullable RecyclerView.ViewHolder viewHolder);
    }

    public NoteListAdapter(@Nullable List<String> list, @Nullable OnStartDragListener onStartDragListener, @Nullable ItemLayoutHeightListener itemLayoutHeightListener) {
        this.noteList = list;
        this.mStartDragListener = onStartDragListener;
        this.mHeightListener = itemLayoutHeightListener;
    }

    private final void decorateDivider(NoteListHolder holder, int position) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Resources resources = holder.itemView.getResources();
        if (LocaleUtils.isRTLMode()) {
            dimensionPixelSize = resources.getDimensionPixelSize(C11391R.dimen.widget_list_setting_item_divider_right_margin);
            dimensionPixelSize2 = resources.getDimensionPixelSize(C11391R.dimen.widget_list_setting_item_divider_left_margin);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(C11391R.dimen.widget_list_setting_item_divider_left_margin);
            dimensionPixelSize2 = resources.getDimensionPixelSize(C11391R.dimen.widget_list_setting_item_divider_right_margin);
        }
        View viewFindViewById = holder.itemView.findViewById(C11391R.id.divider);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = dimensionPixelSize;
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = dimensionPixelSize2;
        viewFindViewById.setLayoutParams(layoutParams2);
        viewFindViewById.setVisibility(position >= getItemCount() + (-1) ? 4 : 0);
    }

    private final void decorateItemView(NoteListHolder holder, MainListDocumentData mainListDocumentData, int position) {
        decorateTitle(holder, mainListDocumentData);
        decorateDivider(holder, position);
        decorateReorder(holder);
        holder.setItemRemoveClickListener(new ItemRemoveClickListener() { // from class: com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter.decorateItemView.1
            @Override // com.samsung.android.app.notes.widget.setting.view.adapter.NoteListAdapter.ItemRemoveClickListener
            public void onItemRemoveClick(View view, int position2) {
                List<String> noteList = NoteListAdapter.this.getNoteList();
                if (noteList != null) {
                    noteList.remove(position2);
                }
                NoteListAdapter.this.notifyItemRemoved(position2);
                ItemLayoutHeightListener itemLayoutHeightListener = NoteListAdapter.this.mHeightListener;
                if (itemLayoutHeightListener != null) {
                    itemLayoutHeightListener.onItemRemoved(position2);
                }
            }
        });
    }

    private final void decorateReorder(NoteListHolder holder) {
        if (getItemCount() <= 1) {
            holder.getMReorder().setVisibility(4);
        } else {
            holder.getMReorder().setVisibility(0);
            holder.getMReorder().setOnTouchListener(new ViewOnTouchListenerC7004e(this, holder, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean decorateReorder$lambda$0(NoteListAdapter noteListAdapter, NoteListHolder noteListHolder, View view, MotionEvent motionEvent) {
        OnStartDragListener onStartDragListener;
        if ((motionEvent.getAction() != 0 && motionEvent.getAction() != 211) || (onStartDragListener = noteListAdapter.mStartDragListener) == null) {
            return false;
        }
        onStartDragListener.onStartDrag(noteListHolder);
        return false;
    }

    private final void decorateTitle(NoteListHolder holder, MainListDocumentData mainListDocumentData) {
        String title = mainListDocumentData.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        if (TextUtils.isEmpty(title)) {
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            title = String.valueOf(companion.getRecommendTitleText(context, mainListDocumentData));
        }
        holder.getMTitle().setText(title);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.noteList;
        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    @Nullable
    public final List<String> getNoteList() {
        return this.noteList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((NoteListHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public NoteListHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C11391R.layout.widget_setting_control_list_item, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new NoteListHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"ClickableViewAccessibility"})
    public void onBindViewHolder(@NotNull NoteListHolder holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(holder.itemView.getContext()).createMainListDocumentDataRepository();
        List<String> list = this.noteList;
        Intrinsics.checkNotNull(list);
        String str = list.get(pos);
        Intrinsics.checkNotNull(str);
        MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(str);
        if (mainListDocumentData == null) {
            WidgetLogger.INSTANCE.m5157e(TAG, "onBindViewHolder# mainListDocumentData is null at " + pos);
            return;
        }
        decorateItemView(holder, mainListDocumentData, pos);
    }

    public void onBindViewHolder(@NotNull NoteListHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            decorateDivider(holder, position);
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }
}
