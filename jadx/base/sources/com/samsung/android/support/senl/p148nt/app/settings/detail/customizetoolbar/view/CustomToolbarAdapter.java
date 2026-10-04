package com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "view", "Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;)V", "getContext", "()Landroid/content/Context;", "getView", "()Lcom/samsung/android/support/senl/nt/app/settings/detail/customizetoolbar/view/CustomToolbarView;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "getItemViewType", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CustomToolbarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NotNull
    private static final String TAG = "CustomToolbarAdapter";
    private static final int VIEW_TYPE_DELETION_MARKER = 2;
    private static final int VIEW_TYPE_ITEM = 1;

    @NotNull
    private final Context context;

    @NotNull
    private final CustomToolbarView view;

    public CustomToolbarAdapter(@NotNull Context context, @NotNull CustomToolbarView view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        this.context = context;
        this.view = view;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.view.getToolbarDisplayList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position == this.view.getDeletionMarkerIndex() ? 2 : 1;
    }

    @NotNull
    public final CustomToolbarView getView() {
        return this.view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        String str = this.view.getToolbarDisplayList().get(position);
        AbstractC0000a.m25v("onBindViewHolder# ", str, TAG);
        CustomToolbarItemHolder customToolbarItemHolder = holder instanceof CustomToolbarItemHolder ? (CustomToolbarItemHolder) holder : null;
        if (customToolbarItemHolder != null) {
            customToolbarItemHolder.decorate(str, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View viewInflate = LayoutInflater.from(this.context).inflate(C8003R.layout.settings_customize_toolbar_item_deletion_marker, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new CustomToolbarDeletionMarkerHolder(viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(this.context).inflate(C8003R.layout.settings_customize_toolbar_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new CustomToolbarItemHolder(viewInflate2, this.view);
    }
}
