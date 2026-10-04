package com.google.android.material.appbar.model.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.model.AppBarModel;
import com.google.android.material.appbar.model.SuggestAppBarModel;
import com.google.android.material.appbar.model.adapter.BasicAppBarViewPagerAdapter.BasicViewHolder;
import com.google.android.material.appbar.model.view.AppBarView;
import com.google.android.material.appbar.model.view.SuggestAppBarItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0005:\u0001&B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H&¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00192\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013J\u001a\u0010$\u001a\u00020\u00192\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, m13886d2 = {"Lcom/google/android/material/appbar/model/adapter/BasicAppBarViewPagerAdapter;", "T", "Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;", "U", "Lcom/google/android/material/appbar/model/adapter/BasicAppBarViewPagerAdapter$BasicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "data", "", "Lcom/google/android/material/appbar/model/SuggestAppBarModel;", "getData", "()Ljava/util/List;", "find", "", "dataModel", "Lcom/google/android/material/appbar/model/AppBarModel;", "Lcom/google/android/material/appbar/model/view/AppBarView;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "(Lcom/google/android/material/appbar/model/adapter/BasicAppBarViewPagerAdapter$BasicViewHolder;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "(Landroid/view/ViewGroup;I)Lcom/google/android/material/appbar/model/adapter/BasicAppBarViewPagerAdapter$BasicViewHolder;", "onViewRecycled", "(Lcom/google/android/material/appbar/model/adapter/BasicAppBarViewPagerAdapter$BasicViewHolder;)V", "removeDataModel", "setDataModel", "", "BasicViewHolder", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class BasicAppBarViewPagerAdapter<T extends SuggestAppBarItemView, U extends BasicViewHolder<T>> extends RecyclerView.Adapter<U> {

    @NotNull
    private final Context context;

    @NotNull
    private final List<SuggestAppBarModel<T>> data;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/appbar/model/adapter/BasicAppBarViewPagerAdapter$BasicViewHolder;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "appBarModuleView", "(Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;)V", "getAppBarModuleView", "()Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;", "Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class BasicViewHolder<V extends SuggestAppBarItemView> extends RecyclerView.ViewHolder {

        @NotNull
        private final V appBarModuleView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BasicViewHolder(@NotNull V appBarModuleView) {
            super(appBarModuleView);
            Intrinsics.checkNotNullParameter(appBarModuleView, "appBarModuleView");
            this.appBarModuleView = appBarModuleView;
        }

        @NotNull
        public final V getAppBarModuleView() {
            return this.appBarModuleView;
        }
    }

    public BasicAppBarViewPagerAdapter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.data = new ArrayList();
    }

    public final int find(@NotNull AppBarModel<? extends AppBarView> dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        return CollectionsKt.indexOf((List<? extends AppBarModel<? extends AppBarView>>) getData(), dataModel);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public List<SuggestAppBarModel<T>> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getData().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public abstract U onCreateViewHolder(@NotNull ViewGroup parent, int viewType);

    public final void removeDataModel(@NotNull AppBarModel<? extends AppBarView> dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        int iIndexOf = CollectionsKt.indexOf((List<? extends AppBarModel<? extends AppBarView>>) getData(), dataModel);
        TypeIntrinsics.asMutableCollection(getData()).remove(dataModel);
        notifyItemRemoved(iIndexOf);
    }

    public final void setDataModel(@NotNull List<? extends SuggestAppBarModel<T>> dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        getData().clear();
        getData().addAll(dataModel);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull U holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        getData().get(position).init(holder.getAppBarModuleView());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull U holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        SuggestAppBarItemView appBarModuleView = holder.getAppBarModuleView();
        appBarModuleView.setAlpha(1.0f);
        appBarModuleView.setScaleX(1.0f);
        appBarModuleView.setScaleY(1.0f);
    }
}
