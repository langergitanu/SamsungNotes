package com.samsung.android.app.sdk.deepsky.suggestion.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.app.sdk.deepsky.C7012R;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SuggestionViewSpec;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "", "getEnableLocalOnly", "", "getExcludedDataId", "", "", "getExtras", "Landroid/os/Bundle;", "getIncludedDataId", "getItem", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "getListMinHeight", "getMaxSuggestionCount", "getViewSpec", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SuggestionViewSpec;", "Builder", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface SuggestionViewConfig {
    boolean getEnableLocalOnly();

    @NotNull
    List<Integer> getExcludedDataId();

    @Nullable
    Bundle getExtras();

    @NotNull
    List<Integer> getIncludedDataId();

    @NotNull
    SuggestionItem getItem();

    int getListMinHeight();

    int getMaxSuggestionCount();

    @NotNull
    SuggestionViewSpec getViewSpec();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0014\u0010\u001e\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000fJ\u0014\u0010$\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bJ\b\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u0014\u0010)\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u0014\u0010,\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\bJ\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\bJ\u000e\u00104\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\bR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u0018\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0019\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u00066"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig$Builder;", "", "suggestionItem", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "listItemView", "Landroid/widget/RemoteViews;", "(Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;Landroid/widget/RemoteViews;)V", "listMinHeight", "", "(Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;Landroid/widget/RemoteViews;I)V", "clickableIdList", "", "descriptionId", "Ljava/lang/Integer;", "enableLocalOnly", "", "enableSwipeDismiss", "Ljava/lang/Boolean;", "excludedDataIdList", "", "iconId", "includedDataIdList", "listView", "listViewId", "listViewItemId", "maxIdSize", "maxListItemVisibleCount", "maxSuggestionCount", "suggestionFromId", "titleId", "addClickableId", "clickableIds", "build", "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "enableDrawLocalOnly", "enable", "setClickableId", "setDefaultViewId", "", "setDescriptionId", "resId", "setExcludedDataId", DialogConstant.BUNDLE_IDS, "setIconId", "setIncludedDataId", "setListView", "view", "setListViewId", "setListViewItemId", "setMaxListItemVisibleCount", "count", "setMaxSuggestionCount", "setSuggestionFromId", "setTitleId", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSuggestionViewConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestionViewConfig.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n1#2:201\n1549#3:202\n1620#3,3:203\n1549#3:206\n1620#3,3:207\n*S KotlinDebug\n*F\n+ 1 SuggestionViewConfig.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig$Builder\n*L\n174#1:202\n174#1:203,3\n175#1:206\n175#1:207,3\n*E\n"})
    public static final class Builder {

        @Nullable
        private List<Integer> clickableIdList;

        @Nullable
        private Integer descriptionId;
        private boolean enableLocalOnly;

        @Nullable
        private Boolean enableSwipeDismiss;

        @Nullable
        private List<String> excludedDataIdList;

        @Nullable
        private Integer iconId;

        @Nullable
        private List<String> includedDataIdList;

        @NotNull
        private final RemoteViews listItemView;
        private final int listMinHeight;

        @Nullable
        private RemoteViews listView;

        @Nullable
        private Integer listViewId;

        @Nullable
        private Integer listViewItemId;
        private final int maxIdSize;

        @Nullable
        private Integer maxListItemVisibleCount;
        private int maxSuggestionCount;

        @Nullable
        private Integer suggestionFromId;

        @NotNull
        private final SuggestionItem suggestionItem;

        @Nullable
        private Integer titleId;

        public Builder(@NotNull SuggestionItem suggestionItem, @NotNull RemoteViews listItemView, int i) {
            Intrinsics.checkNotNullParameter(suggestionItem, "suggestionItem");
            Intrinsics.checkNotNullParameter(listItemView, "listItemView");
            this.suggestionItem = suggestionItem;
            this.listItemView = listItemView;
            this.listMinHeight = i;
            setDefaultViewId();
            this.maxIdSize = 10000;
            this.maxSuggestionCount = Integer.MAX_VALUE;
        }

        private final void setDefaultViewId() {
            setTitleId(C7012R.id.sss_list_view_item_title);
            setDescriptionId(C7012R.id.sss_list_view_item_description);
            setIconId(C7012R.id.sss_list_view_item_icon);
            setSuggestionFromId(C7012R.id.sss_list_view_item_suggestion_from);
            setListViewId(C7012R.id.sss_list_view);
            setListViewItemId(C7012R.id.sss_list_view_item);
            addClickableId(CollectionsKt.listOf(Integer.valueOf(C7012R.id.sss_list_view_item)));
        }

        @NotNull
        public final Builder addClickableId(@NotNull List<Integer> clickableIds) {
            Intrinsics.checkNotNullParameter(clickableIds, "clickableIds");
            List<Integer> list = clickableIds;
            List<Integer> listEmptyList = this.clickableIdList;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            this.clickableIdList = CollectionsKt.plus((Collection) list, (Iterable) listEmptyList);
            return this;
        }

        @NotNull
        public final SuggestionViewConfig build() {
            List list;
            Log.i("SSS:SuggestionViewConfig@Builder", "item: " + this.suggestionItem.getId() + ", valid: " + this.suggestionItem.getValid());
            Integer num = this.titleId;
            Integer num2 = this.descriptionId;
            Integer num3 = this.iconId;
            Integer num4 = this.suggestionFromId;
            Integer num5 = this.listViewId;
            Integer num6 = this.listViewItemId;
            if (num6 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            SuggestionViewSpec suggestionViewSpec = new SuggestionViewSpec(0, num, num2, num3, num4, num5, num6.intValue(), this.clickableIdList, this.listView, this.listItemView, this.maxListItemVisibleCount, this.enableSwipeDismiss, null, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, null);
            SuggestionItem suggestionItem = this.suggestionItem;
            int i = this.maxSuggestionCount;
            boolean z = this.enableLocalOnly;
            List<String> list2 = this.includedDataIdList;
            List list3 = null;
            if (list2 != null) {
                List<String> list4 = list2;
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list4));
                Iterator<T> it = list4.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((String) it.next()).hashCode()));
                }
                list = CollectionsKt.toList(arrayList);
            } else {
                list = null;
            }
            List<String> list5 = this.excludedDataIdList;
            if (list5 != null) {
                List<String> list6 = list5;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list6));
                Iterator<T> it2 = list6.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(((String) it2.next()).hashCode()));
                }
                list3 = CollectionsKt.toList(arrayList2);
            }
            return new SuggestionViewConfigImpl(suggestionItem, suggestionViewSpec, i, z, null, list, list3, this.listMinHeight, 16, null);
        }

        @NotNull
        public final Builder enableDrawLocalOnly(boolean enable) {
            this.enableLocalOnly = enable;
            return this;
        }

        @NotNull
        public final Builder enableSwipeDismiss(boolean enable) {
            this.enableSwipeDismiss = Boolean.valueOf(enable);
            return this;
        }

        @NotNull
        public final Builder setClickableId(@NotNull List<Integer> clickableIds) {
            Intrinsics.checkNotNullParameter(clickableIds, "clickableIds");
            this.clickableIdList = CollectionsKt.distinct(clickableIds);
            return this;
        }

        @NotNull
        public final Builder setDescriptionId(int resId) {
            this.descriptionId = Integer.valueOf(resId);
            return this;
        }

        @NotNull
        public final Builder setExcludedDataId(@NotNull List<String> ids) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            List<String> listDistinct = CollectionsKt.distinct(ids);
            int size = listDistinct.size();
            int i = this.maxIdSize;
            if (size > i) {
                listDistinct = CollectionsKt.take(listDistinct, i);
            }
            this.excludedDataIdList = listDistinct;
            return this;
        }

        @NotNull
        public final Builder setIconId(int resId) {
            this.iconId = Integer.valueOf(resId);
            return this;
        }

        @NotNull
        public final Builder setIncludedDataId(@NotNull List<String> ids) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            List<String> listDistinct = CollectionsKt.distinct(ids);
            int size = listDistinct.size();
            int i = this.maxIdSize;
            if (size > i) {
                listDistinct = CollectionsKt.take(listDistinct, i);
            }
            this.includedDataIdList = listDistinct;
            return this;
        }

        @NotNull
        public final Builder setListView(@NotNull RemoteViews view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.listView = view;
            return this;
        }

        @NotNull
        public final Builder setListViewId(int resId) {
            this.listViewId = Integer.valueOf(resId);
            return this;
        }

        @NotNull
        public final Builder setListViewItemId(int resId) {
            this.listViewItemId = Integer.valueOf(resId);
            return this;
        }

        @NotNull
        public final Builder setMaxListItemVisibleCount(int count) {
            this.maxListItemVisibleCount = Integer.valueOf(count);
            return this;
        }

        @NotNull
        public final Builder setMaxSuggestionCount(int count) {
            this.maxSuggestionCount = count;
            return this;
        }

        @NotNull
        public final Builder setSuggestionFromId(int resId) {
            this.suggestionFromId = Integer.valueOf(resId);
            return this;
        }

        @NotNull
        public final Builder setTitleId(int resId) {
            this.titleId = Integer.valueOf(resId);
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.WARNING, message = "Use Builder(suggestionItem: SuggestionItem, listItemView: RemoteViews, listItemMinHeight: Int)")
        public Builder(@NotNull SuggestionItem suggestionItem, @NotNull RemoteViews listItemView) {
            this(suggestionItem, listItemView, 0);
            Intrinsics.checkNotNullParameter(suggestionItem, "suggestionItem");
            Intrinsics.checkNotNullParameter(listItemView, "listItemView");
        }
    }
}
