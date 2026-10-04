package com.samsung.android.app.notes.widget.setting.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.widget.util.WidgetListUtils;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.homewidget.C11391R;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001#B!\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J(\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ \u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010 \u001a\u00020\u000eH\u0016J\u000e\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0007R\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/PreviewListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/app/notes/widget/setting/view/adapter/PreviewListAdapter$PreviewListHolder;", "mNoteList", "", "", "mIsDarkTheme", "", "<init>", "(Ljava/util/List;Z)V", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onBindViewHolderThumbnail", "mainListDocumentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "uuid", "decorateCoverCapturedImage", "coverEntity", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesDocumentCoverEntity;", "decorateDefaultThumbnail", "onBindViewHolderTitle", "onBindViewHolderDivider", "getItemCount", "updatePreviewItemColor", "darkTheme", "PreviewListHolder", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PreviewListAdapter extends RecyclerView.Adapter<PreviewListHolder> {
    public static final int $stable = 8;
    private boolean mIsDarkTheme;

    @Nullable
    private final List<String> mNoteList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0005¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/setting/view/adapter/PreviewListAdapter$PreviewListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mThumbnail", "Landroid/widget/ImageView;", "getMThumbnail", "()Landroid/widget/ImageView;", "setMThumbnail", "(Landroid/widget/ImageView;)V", "mTitle", "Landroid/widget/TextView;", "getMTitle", "()Landroid/widget/TextView;", "setMTitle", "(Landroid/widget/TextView;)V", "mContent", "getMContent", "setMContent", "mTime", "getMTime", "setMTime", "mFavorite", "getMFavorite", "setMFavorite", "mVoice", "getMVoice", "setMVoice", "mDivider", "getMDivider", "()Landroid/view/View;", "setMDivider", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class PreviewListHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;

        @NotNull
        private TextView mContent;

        @Nullable
        private View mDivider;

        @NotNull
        private ImageView mFavorite;

        @NotNull
        private ImageView mThumbnail;

        @NotNull
        private TextView mTime;

        @NotNull
        private TextView mTitle;

        @NotNull
        private ImageView mVoice;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewListHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C11391R.id.thumbnail);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mThumbnail = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C11391R.id.title);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.mTitle = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(C11391R.id.content);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.mContent = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(C11391R.id.time);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.mTime = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(C11391R.id.favorite);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.mFavorite = (ImageView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(C11391R.id.voice);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.mVoice = (ImageView) viewFindViewById6;
            this.mDivider = itemView.findViewById(C11391R.id.divider);
        }

        @NotNull
        public final TextView getMContent() {
            return this.mContent;
        }

        @Nullable
        public final View getMDivider() {
            return this.mDivider;
        }

        @NotNull
        public final ImageView getMFavorite() {
            return this.mFavorite;
        }

        @NotNull
        public final ImageView getMThumbnail() {
            return this.mThumbnail;
        }

        @NotNull
        public final TextView getMTime() {
            return this.mTime;
        }

        @NotNull
        public final TextView getMTitle() {
            return this.mTitle;
        }

        @NotNull
        public final ImageView getMVoice() {
            return this.mVoice;
        }

        public final void setMContent(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mContent = textView;
        }

        public final void setMDivider(@Nullable View view) {
            this.mDivider = view;
        }

        public final void setMFavorite(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mFavorite = imageView;
        }

        public final void setMThumbnail(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mThumbnail = imageView;
        }

        public final void setMTime(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTime = textView;
        }

        public final void setMTitle(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitle = textView;
        }

        public final void setMVoice(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mVoice = imageView;
        }
    }

    public PreviewListAdapter(@Nullable List<String> list, boolean z) {
        this.mNoteList = list;
        this.mIsDarkTheme = z;
    }

    private final void decorateDefaultThumbnail(PreviewListHolder holder, String uuid, MainListDocumentData mainListDocumentData) {
        Context context = holder.itemView.getContext();
        holder.getMThumbnail().setBackgroundResource(this.mIsDarkTheme ? C11391R.drawable.widget_list_item_thumbnail_rounded_corner_shape_dark : C11391R.drawable.widget_list_item_thumbnail_rounded_corner_shape);
        ImageView mThumbnail = holder.getMThumbnail();
        Intrinsics.checkNotNull(context);
        mThumbnail.setImageBitmap(WidgetListUtils.getThumbnailBitmap(context, uuid, mainListDocumentData, this.mIsDarkTheme));
        holder.getMThumbnail().setClipToOutline(true);
    }

    private final void onBindViewHolderThumbnail(PreviewListHolder holder, MainListDocumentData mainListDocumentData, String uuid) {
        Context context = holder.itemView.getContext();
        NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
        Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
        DocumentCoverStateTuple coverStateTuple = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getCoverStateTuple(mainListDocumentData.getUuid());
        boolean z = coverStateTuple != null && coverStateTuple.isEnabled();
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            holder.getMThumbnail().setForeground(this.mIsDarkTheme ? ContextCompat.getDrawable(context, C11391R.drawable.widget_list_glance_item_thumbnail_rounded_corner_stroke_dark) : ContextCompat.getDrawable(context, C11391R.drawable.widget_list_glance_item_thumbnail_rounded_corner_stroke_light));
        }
        if (!z) {
            decorateDefaultThumbnail(holder, uuid, mainListDocumentData);
            return;
        }
        Integer numValueOf = coverStateTuple != null ? Integer.valueOf(coverStateTuple.state) : null;
        if ((numValueOf != null && numValueOf.intValue() == 4) || ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == -2)))) {
            decorateCoverCapturedImage(holder, uuid, mainListDocumentData, coverStateTuple);
        }
    }

    private final void onBindViewHolderTitle(PreviewListHolder holder, MainListDocumentData mainListDocumentData) {
        int color;
        int color2;
        float f;
        Context context = holder.itemView.getContext();
        String title = mainListDocumentData.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "getTitle(...)");
        if (TextUtils.isEmpty(title)) {
            WidgetUtils.Companion companion = WidgetUtils.INSTANCE;
            Intrinsics.checkNotNull(context);
            holder.getMContent().setText(String.valueOf(companion.getRecommendTitleText(context, mainListDocumentData)));
            holder.getMContent().setVisibility(0);
            holder.getMTitle().setVisibility(8);
        } else {
            holder.getMTitle().setText(title);
            holder.getMTitle().setVisibility(0);
            holder.getMContent().setVisibility(8);
        }
        if (this.mIsDarkTheme) {
            color = ResourceUtils.getColor(context, C11391R.color.widget_black_theme_text_color);
            color2 = ResourceUtils.getColor(context, C11391R.color.widget_black_theme_color);
            f = 0.6f;
        } else {
            color = ResourceUtils.getColor(context, C11391R.color.widget_white_theme_text_color);
            color2 = ResourceUtils.getColor(context, C11391R.color.widget_white_theme_color);
            f = 0.95f;
        }
        holder.getMTitle().setTextColor(color);
        holder.getMContent().setTextColor(color);
        holder.getMTime().setTextColor(color2);
        holder.getMVoice().setColorFilter(color2);
        holder.getMVoice().setAlpha(f);
    }

    public final void decorateCoverCapturedImage(@NotNull PreviewListHolder holder, @NotNull String uuid, @NotNull MainListDocumentData mainListDocumentData, @Nullable NotesDocumentCoverEntity coverEntity) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(mainListDocumentData, "mainListDocumentData");
        Context context = holder.itemView.getContext();
        CoverThumbnailCreator.ThumbnailType thumbnailType = CoverThumbnailCreator.ThumbnailType.SQUARE;
        if (!CoverThumbnailCreator.isExistCoverFile(context, mainListDocumentData.getUuid(), thumbnailType)) {
            decorateDefaultThumbnail(holder, uuid, mainListDocumentData);
            return;
        }
        if (coverEntity == null) {
            NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
            Intrinsics.checkNotNullExpressionValue(notesDocumentCoverRepositoryCreateDocumentCoverRepository, "createDocumentCoverRepository(...)");
            if (notesDocumentCoverRepositoryCreateDocumentCoverRepository.getEntity(uuid) == null) {
                decorateDefaultThumbnail(holder, uuid, mainListDocumentData);
                return;
            }
        }
        Drawable coverThumbnail = CoverThumbnailCreator.getCoverThumbnail(context, mainListDocumentData.getUuid(), thumbnailType);
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(coverThumbnail, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap bitmap = ((BitmapDrawable) coverThumbnail).getBitmap();
        Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
        holder.getMThumbnail().setImageBitmap(WidgetListUtils.getRoundedRectBitmap(context, bitmap, mainListDocumentData.getBackgroundColor()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.mNoteList;
        Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public final void onBindViewHolderDivider(@NotNull PreviewListHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Context context = holder.itemView.getContext();
        int color = this.mIsDarkTheme ? ResourceUtils.getColor(context, C11391R.color.widget_list_glance_setting_preview_item_divider_color_dark) : ResourceUtils.getColor(context, C11391R.color.widget_list_glance_setting_preview_item_divider_color_light);
        View mDivider = holder.getMDivider();
        if (mDivider != null) {
            mDivider.setBackgroundColor(color);
        }
        View mDivider2 = holder.getMDivider();
        if (mDivider2 != null) {
            mDivider2.setVisibility(position >= getItemCount() + (-1) ? 4 : 0);
        }
    }

    public final void updatePreviewItemColor(boolean darkTheme) {
        if (this.mIsDarkTheme != darkTheme) {
            this.mIsDarkTheme = darkTheme;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((PreviewListHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public PreviewListHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(BaseWidgetUtils.INSTANCE.isSupportedNewWidget() ? C11391R.layout.widget_list_glance_setting_preview_item : C11391R.layout.widget_list_item, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PreviewListHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull PreviewListHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Context context = holder.itemView.getContext();
        MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository();
        List<String> list = this.mNoteList;
        Intrinsics.checkNotNull(list);
        String str = list.get(i);
        Intrinsics.checkNotNull(str);
        MainListDocumentData mainListDocumentData = mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.get(str);
        Intrinsics.checkNotNull(mainListDocumentData);
        String uuid = mainListDocumentData.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        onBindViewHolderThumbnail(holder, mainListDocumentData, uuid);
        onBindViewHolderTitle(holder, mainListDocumentData);
        holder.getMTime().setText(WidgetListUtils.getDate(context, mainListDocumentData.getLastModifiedAt()));
        int i2 = 8;
        holder.getMFavorite().setVisibility(mainListDocumentData.getIsFavorite() == 1 ? 0 : 8);
        boolean z = mainListDocumentData.getIsLock() != 5;
        ImageView mVoice = holder.getMVoice();
        if (z && !TextUtils.isEmpty(mainListDocumentData.getVrUuid())) {
            i2 = 0;
        }
        mVoice.setVisibility(i2);
        if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
            onBindViewHolderDivider(holder, i);
        }
    }

    public void onBindViewHolder(@NotNull PreviewListHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                onBindViewHolderDivider(holder, position);
                return;
            }
            return;
        }
        super.onBindViewHolder(holder, position, payloads);
    }
}
