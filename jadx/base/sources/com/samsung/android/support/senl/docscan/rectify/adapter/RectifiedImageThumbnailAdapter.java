package com.samsung.android.support.senl.docscan.rectify.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.docscan.rectify.adapter.AdapterContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0002J\"\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/adapter/RectifiedImageThumbnailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/RectifiedImageThumbnailAdapter$RectifiedImageThumbnailHolder;", "mContract", "Lcom/samsung/android/support/senl/docscan/rectify/adapter/AdapterContract$RecyclerView;", "mScanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "<init>", "(Lcom/samsung/android/support/senl/docscan/rectify/adapter/AdapterContract$RecyclerView;Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;)V", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "type", "", "onBindViewHolder", "", "viewHolder", "position", "payloads", "", "", "decorate", "decorateThumbnail", "isScale", "", "getItemCount", "RectifiedImageThumbnailHolder", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RectifiedImageThumbnailAdapter extends RecyclerView.Adapter<RectifiedImageThumbnailHolder> {

    @Nullable
    private final AdapterContract.RecyclerView mContract;

    @Nullable
    private final ScanDataModel mScanDataModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/adapter/RectifiedImageThumbnailAdapter$RectifiedImageThumbnailHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mImageView", "Landroid/widget/ImageView;", "getMImageView", "()Landroid/widget/ImageView;", "setMImageView", "(Landroid/widget/ImageView;)V", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class RectifiedImageThumbnailHolder extends RecyclerView.ViewHolder {

        @NotNull
        private ImageView mImageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RectifiedImageThumbnailHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C7976R.id.rectified_image_thumbnail);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mImageView = (ImageView) viewFindViewById;
        }

        @NotNull
        public final ImageView getMImageView() {
            return this.mImageView;
        }

        public final void setMImageView(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mImageView = imageView;
        }
    }

    public RectifiedImageThumbnailAdapter(@Nullable AdapterContract.RecyclerView recyclerView, @Nullable ScanDataModel scanDataModel) {
        this.mContract = recyclerView;
        this.mScanDataModel = scanDataModel;
    }

    private final void decorate(RectifiedImageThumbnailHolder viewHolder, int position) {
        if (viewHolder == null || this.mContract == null || position < 0) {
            return;
        }
        viewHolder.itemView.setTag(Integer.valueOf(position));
        viewHolder.itemView.setOnClickListener(new ViewOnClickListenerC0157a(this, 0));
        viewHolder.getMImageView().setImageBitmap(this.mContract.getThumbnailImage(position));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decorate$lambda$1$lambda$0(RectifiedImageThumbnailAdapter rectifiedImageThumbnailAdapter, View view) {
        AdapterContract.RecyclerView recyclerView = rectifiedImageThumbnailAdapter.mContract;
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        recyclerView.onItemSelected(((Integer) tag).intValue());
    }

    private final void decorateThumbnail(RectifiedImageThumbnailHolder viewHolder, int position, boolean isScale) {
        if (viewHolder == null || position < 0) {
            return;
        }
        if (!isScale) {
            View view = viewHolder.itemView;
            view.setZ(0.0f);
            view.setBackgroundColor(0);
            ImageView mImageView = viewHolder.getMImageView();
            mImageView.setScaleX(1.0f);
            mImageView.setScaleY(1.0f);
            return;
        }
        View view2 = viewHolder.itemView;
        view2.setZ(1.0f);
        view2.setBackgroundColor(-1);
        view2.bringToFront();
        ImageView mImageView2 = viewHolder.getMImageView();
        mImageView2.setScaleX(1.3f);
        mImageView2.setScaleY(1.3f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel != null) {
            return scanDataModel.getScanDataCount();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((RectifiedImageThumbnailHolder) viewHolder, i, (List<? extends Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RectifiedImageThumbnailHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int type) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(C7976R.layout.rectified_image_thumbnail_holder, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new RectifiedImageThumbnailHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RectifiedImageThumbnailHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        decorate(viewHolder, position);
        AdapterContract.RecyclerView recyclerView = this.mContract;
        decorateThumbnail(viewHolder, position, recyclerView != null && recyclerView.getCurrentPosition() == position);
    }

    public void onBindViewHolder(@NotNull RectifiedImageThumbnailHolder viewHolder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(viewHolder, position, (List<Object>) payloads);
            return;
        }
        decorate(viewHolder, position);
        AdapterContract.RecyclerView recyclerView = this.mContract;
        boolean z = false;
        if (recyclerView != null && recyclerView.getCurrentPosition() == position) {
            Object obj = payloads.get(0);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                z = true;
            }
        }
        decorateThumbnail(viewHolder, position, z);
    }
}
