package com.samsung.android.app.notes.widget.glance.setting.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.C6635R;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dB+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0006\u0010\u0018\u001a\u00020\u0007J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter$WidgetCreatorListViewHolder;", "mCreatorList", "", "", "mSelectedItems", "", "onSelectionChangeListener", "Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter$OnSelectionChangeListener;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter$OnSelectionChangeListener;)V", "checkedState", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "getSelectedCount", "getSelectedItem", "setCheckedState", "selectedItems", "OnSelectionChangeListener", "WidgetCreatorListViewHolder", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nWidgetCreatorAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetCreatorAdapter.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1788#2,4:97\n1583#2,11:101\n1878#2,2:112\n1880#2:115\n1594#2:116\n1869#2,2:118\n1#3:114\n1#3:117\n*S KotlinDebug\n*F\n+ 1 WidgetCreatorAdapter.kt\ncom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter\n*L\n73#1:97,4\n77#1:101,11\n77#1:112,2\n77#1:115\n77#1:116\n82#1:118,2\n77#1:114\n*E\n"})
public final class WidgetCreatorAdapter extends RecyclerView.Adapter<WidgetCreatorListViewHolder> {
    public static final int $stable = 8;

    @NotNull
    private final List<Boolean> checkedState;

    @NotNull
    private final List<String> mCreatorList;

    @NotNull
    private final List<Integer> mSelectedItems;

    @NotNull
    private final OnSelectionChangeListener onSelectionChangeListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter$OnSelectionChangeListener;", "", "onSelectionChangeListener", "", "selectedCount", "", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnSelectionChangeListener {
        void onSelectionChangeListener(int selectedCount);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter$WidgetCreatorListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/app/notes/widget/glance/setting/view/WidgetCreatorAdapter;Landroid/view/View;)V", "mCheckbox", "Landroid/widget/CheckBox;", "getMCheckbox", "()Landroid/widget/CheckBox;", "setMCheckbox", "(Landroid/widget/CheckBox;)V", "mDivider", "getMDivider", "()Landroid/view/View;", "setMDivider", "(Landroid/view/View;)V", "mLayout", "Landroid/widget/LinearLayout;", "getMLayout", "()Landroid/widget/LinearLayout;", "setMLayout", "(Landroid/widget/LinearLayout;)V", "notes-4.4.37.35_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class WidgetCreatorListViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private CheckBox mCheckbox;

        @NotNull
        private View mDivider;

        @NotNull
        private LinearLayout mLayout;
        final /* synthetic */ WidgetCreatorAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetCreatorListViewHolder(@NotNull WidgetCreatorAdapter widgetCreatorAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = widgetCreatorAdapter;
            View viewFindViewById = itemView.findViewById(C6635R.id.checkbox);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mCheckbox = (CheckBox) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C6635R.id.divider);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.mDivider = viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C6635R.id.widget_setting_control_list_item_container);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.mLayout = (LinearLayout) viewFindViewById3;
        }

        @NotNull
        public final CheckBox getMCheckbox() {
            return this.mCheckbox;
        }

        @NotNull
        public final View getMDivider() {
            return this.mDivider;
        }

        @NotNull
        public final LinearLayout getMLayout() {
            return this.mLayout;
        }

        public final void setMCheckbox(@NotNull CheckBox checkBox) {
            Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
            this.mCheckbox = checkBox;
        }

        public final void setMDivider(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mDivider = view;
        }

        public final void setMLayout(@NotNull LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.mLayout = linearLayout;
        }
    }

    public WidgetCreatorAdapter(@NotNull List<String> mCreatorList, @NotNull List<Integer> mSelectedItems, @NotNull OnSelectionChangeListener onSelectionChangeListener) {
        Intrinsics.checkNotNullParameter(mCreatorList, "mCreatorList");
        Intrinsics.checkNotNullParameter(mSelectedItems, "mSelectedItems");
        Intrinsics.checkNotNullParameter(onSelectionChangeListener, "onSelectionChangeListener");
        this.mCreatorList = mCreatorList;
        this.mSelectedItems = mSelectedItems;
        this.onSelectionChangeListener = onSelectionChangeListener;
        this.checkedState = setCheckedState(mSelectedItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(WidgetCreatorListViewHolder widgetCreatorListViewHolder, View view) {
        view.postDelayed(new RunnableC6974a(widgetCreatorListViewHolder, 0), 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(WidgetCreatorListViewHolder widgetCreatorListViewHolder) {
        widgetCreatorListViewHolder.getMCheckbox().setChecked(!widgetCreatorListViewHolder.getMCheckbox().isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(WidgetCreatorListViewHolder widgetCreatorListViewHolder, WidgetCreatorAdapter widgetCreatorAdapter, int i, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        widgetCreatorListViewHolder.getMCheckbox().setEnabled(false);
        widgetCreatorAdapter.checkedState.set(i, Boolean.valueOf(z));
        widgetCreatorAdapter.onSelectionChangeListener.onSelectionChangeListener(widgetCreatorAdapter.getSelectedCount());
        widgetCreatorAdapter.notifyItemRangeChanged(0, widgetCreatorAdapter.getItemCount());
        widgetCreatorListViewHolder.getMCheckbox().post(new RunnableC6974a(widgetCreatorListViewHolder, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(WidgetCreatorListViewHolder widgetCreatorListViewHolder) {
        widgetCreatorListViewHolder.getMCheckbox().setEnabled(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mCreatorList.isEmpty()) {
            return 0;
        }
        return this.mCreatorList.size();
    }

    public final int getSelectedCount() {
        List<Boolean> list = this.checkedState;
        int i = 0;
        if ((list instanceof Collection) && list.isEmpty()) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Boolean) it.next()).booleanValue() && (i = i + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    @NotNull
    public final List<Integer> getSelectedItem() {
        List<Boolean> list = this.checkedState;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Integer numValueOf = ((Boolean) obj).booleanValue() ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public final List<Boolean> setCheckedState(@NotNull List<Integer> selectedItems) {
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        ArrayList arrayList = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            arrayList.add(Boolean.FALSE);
        }
        Iterator<T> it = selectedItems.iterator();
        while (it.hasNext()) {
            arrayList.set(((Number) it.next()).intValue(), Boolean.TRUE);
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final WidgetCreatorListViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getMCheckbox().setText(this.mCreatorList.get(position));
        holder.getMCheckbox().setOnCheckedChangeListener(null);
        holder.getMCheckbox().setChecked(this.checkedState.get(position).booleanValue());
        holder.getMLayout().setOnClickListener(new ViewOnClickListenerC0157a(holder, 5));
        holder.getMCheckbox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.samsung.android.app.notes.widget.glance.setting.view.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                WidgetCreatorAdapter.onBindViewHolder$lambda$3(holder, this, position, compoundButton, z);
            }
        });
        int selectedCount = getSelectedCount();
        holder.getMCheckbox();
        holder.getMCheckbox().setEnabled(selectedCount < 4 || holder.getMCheckbox().isChecked());
        if (selectedCount < 4 || this.checkedState.get(position).booleanValue()) {
            holder.getMCheckbox().setTextColor(ResourceUtils.getColor(holder.getMCheckbox().getContext(), C6635R.color.widget_creator_setting_control_item_checkbox_text_enable_color));
        } else {
            holder.getMCheckbox().setTextColor(ResourceUtils.getColor(holder.getMCheckbox().getContext(), C6635R.color.widget_creator_setting_control_item_checkbox_text_disable_color));
            holder.getMLayout().setClickable(false);
        }
        holder.getMDivider().setVisibility(position >= getItemCount() - 1 ? 8 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public WidgetCreatorListViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Object systemService = parent.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C6635R.layout.widget_creator_setting_control_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new WidgetCreatorListViewHolder(this, viewInflate);
    }
}
