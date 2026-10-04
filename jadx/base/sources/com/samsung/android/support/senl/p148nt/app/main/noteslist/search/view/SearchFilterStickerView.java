package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0002&'B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001cR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterStickerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFilterFlexBox", "Lcom/google/android/flexbox/FlexboxLayout;", "mStickerIcons", "", "Landroid/view/View;", "[Landroid/view/View;", "mListener", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterStickerView$Listener;", "mStickerClickListener", "Landroid/view/View$OnClickListener;", "initLayout", "", "setSearchListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setStickersContainer", "isDim", "", "loadStickersBubble", "coverStickerEntities", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/CoverStickerEntity;", "updateStickerSelected", "prevStickerUuid", "", "stickerUuid", "isSelected", "Listener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSearchFilterStickerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchFilterStickerView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterStickerView\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,139:1\n51#2:140\n*S KotlinDebug\n*F\n+ 1 SearchFilterStickerView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterStickerView\n*L\n84#1:140\n*E\n"})
public final class SearchFilterStickerView extends FrameLayout {

    @NotNull
    private static final String TAG = "SearchFilterStickerView";

    @Nullable
    private FlexboxLayout mFilterFlexBox;

    @Nullable
    private Listener mListener;

    @NotNull
    private final View.OnClickListener mStickerClickListener;

    @NotNull
    private final View[] mStickerIcons;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterStickerView$Listener;", "", "onStickerSelected", "", "filter", "", "onStickersUpdated", CoverStickerDownloadUtils.COVER_STICKER_FOLDER_ROOT, "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/CoverStickerEntity;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onStickerSelected(@NotNull String filter);

        void onStickersUpdated(@NotNull List<CoverStickerEntity> stickers);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterStickerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStickerIcons = new View[11];
        this.mStickerClickListener = new ViewOnClickListenerC8556a(this, 2);
        initLayout();
    }

    private final void initLayout() {
        LayoutInflater.from(getContext()).inflate(C8003R.layout.search_filter_sticker_view, (ViewGroup) this, true);
        this.mFilterFlexBox = (FlexboxLayout) findViewById(C8003R.id.filter_flexbox);
    }

    private final void loadStickersBubble(List<CoverStickerEntity> coverStickerEntities, boolean isDim) {
        FlexboxLayout flexboxLayout;
        AbstractC6670b.m4736A(coverStickerEntities.size(), "loadStickersBubble# sticker size : ", TAG);
        FlexboxLayout flexboxLayout2 = this.mFilterFlexBox;
        if (flexboxLayout2 != null && flexboxLayout2.getChildCount() != 0 && (flexboxLayout = this.mFilterFlexBox) != null) {
            flexboxLayout.removeAllViews();
        }
        HashMap<String, Integer> mapCreateCategoryMap = CoverData.createCategoryMap();
        Intrinsics.checkNotNullExpressionValue(mapCreateCategoryMap, "createCategoryMap(...)");
        Iterator<CoverStickerEntity> it = coverStickerEntities.iterator();
        int i = 0;
        while (it.hasNext()) {
            String uuid = it.next().getUuid();
            Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
            Integer num = mapCreateCategoryMap.get(uuid);
            if (num != null) {
                int iIntValue = num.intValue();
                this.mStickerIcons[i] = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_filter_sticker_item_expand, (ViewGroup) this, false);
                View view = this.mStickerIcons[i];
                View viewFindViewById = view != null ? view.findViewById(C8003R.id.recent_badge_view_holder) : null;
                ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
                if (imageView != null) {
                    imageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(getContext(), uuid));
                }
                View view2 = this.mStickerIcons[i];
                if (view2 != null) {
                    view2.setTag(uuid);
                }
                View view3 = this.mStickerIcons[i];
                if (view3 != null) {
                    view3.setOnClickListener(this.mStickerClickListener);
                }
                View view4 = this.mStickerIcons[i];
                if (view4 != null) {
                    view4.setEnabled(!isDim);
                }
                View view5 = this.mStickerIcons[i];
                if (view5 != null) {
                    view5.setAlpha(isDim ? 0.4f : 1.0f);
                }
                View view6 = this.mStickerIcons[i];
                if (view6 != null) {
                    view6.setContentDescription(getContext().getResources().getString(iIntValue));
                }
                FlexboxLayout flexboxLayout3 = this.mFilterFlexBox;
                if (flexboxLayout3 != null) {
                    flexboxLayout3.addView(this.mStickerIcons[i]);
                    i++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStickerClickListener$lambda$0(SearchFilterStickerView searchFilterStickerView, View view) {
        MainLogger.m7254d(TAG, "StickerClick# " + view.getTag());
        CommonSamsungAnalytics.INSTANCE.insertLog("221", NotesSAConstants.EVENT_SEARCH_COVER_STICKER);
        Listener listener = searchFilterStickerView.mListener;
        if (listener != null) {
            listener.onStickerSelected(view.getTag().toString());
        }
    }

    public final void setSearchListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    public final void setStickersContainer(boolean isDim) {
        List<CoverStickerEntity> usedEntities = NotesDataRepositoryFactory.newInstance(getContext()).createCoverStickerRepository().getUsedEntities();
        if (usedEntities.isEmpty()) {
            setVisibility(8);
        } else {
            setVisibility(0);
            Intrinsics.checkNotNull(usedEntities);
            loadStickersBubble(usedEntities, isDim);
        }
        Listener listener = this.mListener;
        if (listener != null) {
            Intrinsics.checkNotNull(usedEntities);
            listener.onStickersUpdated(usedEntities);
        }
    }

    public final boolean updateStickerSelected(@Nullable String prevStickerUuid, @NotNull String stickerUuid, boolean isSelected) {
        Intrinsics.checkNotNullParameter(stickerUuid, "stickerUuid");
        boolean z = false;
        for (View view : this.mStickerIcons) {
            if (view != null) {
                if (Intrinsics.areEqual(view.getTag(), stickerUuid)) {
                    view.setSelected(isSelected);
                    z = true;
                }
                if (Intrinsics.areEqual(view.getTag(), prevStickerUuid)) {
                    view.setSelected(false);
                }
            }
        }
        return z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterStickerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStickerIcons = new View[11];
        this.mStickerClickListener = new ViewOnClickListenerC8556a(this, 2);
        initLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterStickerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mStickerIcons = new View[11];
        this.mStickerClickListener = new ViewOnClickListenerC8556a(this, 2);
        initLayout();
    }
}
