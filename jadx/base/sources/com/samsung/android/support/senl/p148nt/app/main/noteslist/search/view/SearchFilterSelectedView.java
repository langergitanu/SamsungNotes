package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ(\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0002J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterSelectedView;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFiltersViewList", "", "Landroid/view/View;", "[Landroid/view/View;", "mStickerIcons", "loadFilterCollapseBubble", "", "filtersDataList", "", "", "selectedStickers", "isInsideFolderChecked", "", "addSearchInsideFolder", "addTimeTypeFilter", "addStickerFilter", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSearchFilterSelectedView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchFilterSelectedView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterSelectedView\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,103:1\n51#2:104\n45#2:105\n*S KotlinDebug\n*F\n+ 1 SearchFilterSelectedView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterSelectedView\n*L\n50#1:104\n51#1:105\n*E\n"})
public final class SearchFilterSelectedView extends FlexboxLayout {

    @NotNull
    private final View[] mFiltersViewList;

    @NotNull
    private final View[] mStickerIcons;

    public SearchFilterSelectedView(@Nullable Context context) {
        super(context);
        this.mFiltersViewList = new View[10];
        this.mStickerIcons = new View[11];
    }

    private final void addSearchInsideFolder(boolean isInsideFolderChecked) {
        if (isInsideFolderChecked) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_filter_item_collapse, (ViewGroup) this, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            TextView textView = (TextView) viewInflate.findViewById(C8003R.id.filter_collapse_item_text);
            String string = getContext().getString(C8003R.string.filter_search_only_this_folder);
            if (textView != null) {
                textView.setText(string);
            }
            viewInflate.setContentDescription(string);
            addView(viewInflate);
        }
    }

    private final void addStickerFilter(String selectedStickers) {
        if (TextUtils.isEmpty(selectedStickers) || Intrinsics.areEqual(CoverStickerConstants.Category.NONE.UUID, selectedStickers)) {
            return;
        }
        HashMap<String, Integer> mapCreateCategoryMap = CoverData.createCategoryMap();
        Intrinsics.checkNotNullExpressionValue(mapCreateCategoryMap, "createCategoryMap(...)");
        Integer num = mapCreateCategoryMap.get(selectedStickers);
        if (num != null) {
            int iIntValue = num.intValue();
            this.mStickerIcons[0] = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_filter_sticker_item_collapse, (ViewGroup) this, false);
            View view = this.mStickerIcons[0];
            View viewFindViewById = view != null ? view.findViewById(C8003R.id.recent_badge_view_holder) : null;
            ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
            if (imageView != null) {
                imageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(getContext(), selectedStickers));
            }
            View view2 = this.mStickerIcons[0];
            if (view2 != null) {
                view2.setContentDescription(getContext().getResources().getString(iIntValue));
            }
            addView(this.mStickerIcons[0]);
        }
    }

    private final void addTimeTypeFilter(List<String> filtersDataList) {
        int iMin = Math.min(filtersDataList.size(), 10);
        for (int i = 0; i < iMin; i++) {
            String str = filtersDataList.get(i);
            this.mFiltersViewList[i] = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_filter_item_collapse, (ViewGroup) this, false);
            View view = this.mFiltersViewList[i];
            if (view != null) {
                view.setTag(str);
            }
            View view2 = this.mFiltersViewList[i];
            if (view2 != null) {
                view2.setContentDescription(str);
            }
            View view3 = this.mFiltersViewList[i];
            TextView textView = view3 != null ? (TextView) view3.findViewById(C8003R.id.filter_collapse_item_text) : null;
            if (textView != null) {
                textView.setText(str);
            }
            CharUtils.applyTextSizeUntilMediumSize(getContext(), textView, 13.0f);
            addView(this.mFiltersViewList[i]);
        }
    }

    public final void loadFilterCollapseBubble(@NotNull List<String> filtersDataList, @Nullable String selectedStickers, boolean isInsideFolderChecked) {
        Intrinsics.checkNotNullParameter(filtersDataList, "filtersDataList");
        if (getVisibility() != 0) {
            return;
        }
        if (getChildCount() != 0) {
            removeViews(0, getChildCount());
        }
        addSearchInsideFolder(isInsideFolderChecked);
        addTimeTypeFilter(filtersDataList);
        addStickerFilter(selectedStickers);
    }

    public SearchFilterSelectedView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFiltersViewList = new View[10];
        this.mStickerIcons = new View[11];
    }

    public SearchFilterSelectedView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFiltersViewList = new View[10];
        this.mStickerIcons = new View[11];
    }
}
