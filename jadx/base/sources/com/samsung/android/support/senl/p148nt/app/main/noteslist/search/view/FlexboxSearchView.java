package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014J\u001c\u0010\u001b\u001a\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00110\u001dH\u0002J\u0006\u0010\u001f\u001a\u00020\u0019R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView;", "Lcom/google/android/flexbox/FlexboxLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSearchViews", "", "Landroid/view/View;", "[Landroid/view/View;", "mIdColumns", "", "[Ljava/lang/Long;", "mListener", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView$Listener;", "mDeleteClickListener", "Landroid/view/View$OnClickListener;", "mSearchItemClickListener", "initialize", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "loadSearchBubble", "searchDataList", "", "", "updateSearchContainer", "Listener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFlexboxSearchView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlexboxSearchView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,115:1\n51#2:116\n45#2:117\n*S KotlinDebug\n*F\n+ 1 FlexboxSearchView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView\n*L\n71#1:116\n72#1:117\n*E\n"})
public final class FlexboxSearchView extends FlexboxLayout {
    private static final int MAX_SEARCH_LIMIT = 10;

    @NotNull
    private static final String TAG = "FlexboxSearchView";

    @NotNull
    private final View.OnClickListener mDeleteClickListener;

    @NotNull
    private final Long[] mIdColumns;

    @Nullable
    private Listener mListener;

    @NotNull
    private final View.OnClickListener mSearchItemClickListener;

    @NotNull
    private final View[] mSearchViews;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/FlexboxSearchView$Listener;", "", "onKeywordSelected", "", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onKeywordSelected(@NotNull String keyword);
    }

    public FlexboxSearchView(@Nullable Context context) {
        super(context);
        this.mSearchViews = new View[10];
        this.mIdColumns = new Long[10];
        final int i = 0;
        this.mDeleteClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FlexboxSearchView f6248b;

            {
                this.f6248b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        FlexboxSearchView.mDeleteClickListener$lambda$0(this.f6248b, view);
                        break;
                    default:
                        FlexboxSearchView.mSearchItemClickListener$lambda$1(this.f6248b, view);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mSearchItemClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FlexboxSearchView f6248b;

            {
                this.f6248b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        FlexboxSearchView.mDeleteClickListener$lambda$0(this.f6248b, view);
                        break;
                    default:
                        FlexboxSearchView.mSearchItemClickListener$lambda$1(this.f6248b, view);
                        break;
                }
            }
        };
    }

    private final void loadSearchBubble(Map<String, Long> searchDataList) {
        if (getChildCount() != 0) {
            removeViews(0, getChildCount());
        }
        int i = 0;
        for (Map.Entry<String, Long> entry : searchDataList.entrySet()) {
            this.mIdColumns[i] = entry.getValue();
            String key = entry.getKey();
            this.mSearchViews[i] = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_search_item, (ViewGroup) this, false);
            View view = this.mSearchViews[i];
            if (view != null) {
                view.setTag(Integer.valueOf(i));
            }
            View view2 = this.mSearchViews[i];
            if (view2 != null) {
                view2.setOnClickListener(this.mSearchItemClickListener);
            }
            View view3 = this.mSearchViews[i];
            if (view3 != null) {
                view3.setAccessibilityDelegate(new VoiceAssistAsButton());
            }
            View view4 = this.mSearchViews[i];
            TextView textView = view4 != null ? (TextView) view4.findViewById(C8003R.id.search_item_text) : null;
            if (textView != null) {
                textView.setText(key);
            }
            CharUtils.applyTextSizeUntilMediumSize(getContext(), textView, 13.0f);
            View view5 = this.mSearchViews[i];
            ImageView imageView = view5 != null ? (ImageView) view5.findViewById(C8003R.id.search_item_delete) : null;
            if (imageView != null) {
                imageView.setTag(Integer.valueOf(i));
            }
            if (imageView != null) {
                imageView.setOnClickListener(this.mDeleteClickListener);
            }
            if (imageView != null) {
                imageView.setColorFilter(getResources().getColor(C8003R.color.recent_search_bubble_list_item_delete_icon_color, null), PorterDuff.Mode.SRC_ATOP);
            }
            addView(this.mSearchViews[i]);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDeleteClickListener$lambda$0(FlexboxSearchView flexboxSearchView, View view) {
        MainLogger.m7254d(TAG, "onClick# delete");
        CommonSamsungAnalytics.INSTANCE.insertLog("221", NotesSAConstants.EVENT_SEARCH_DELETE_RECENT_SEARCHES);
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        Long l = flexboxSearchView.mIdColumns[((Integer) tag).intValue()];
        Intrinsics.checkNotNull(l);
        RecentSearchDatabaseHelper.AsyncExecutor.deleteSearchKeyword(l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSearchItemClickListener$lambda$1(FlexboxSearchView flexboxSearchView, View view) {
        CommonSamsungAnalytics.INSTANCE.insertLog("221", NotesSAConstants.EVENT_SEARCH_SELECT_RECENT_SEARCHES);
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        View view2 = flexboxSearchView.mSearchViews[((Integer) tag).intValue()];
        View viewFindViewById = view2 != null ? view2.findViewById(C8003R.id.search_item_text) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        String string = ((TextView) viewFindViewById).getText().toString();
        Listener listener = flexboxSearchView.mListener;
        if (listener != null) {
            listener.onKeywordSelected(string);
        }
        RecentSearchDatabaseHelper.AsyncExecutor.insertSearchKeyword(string);
    }

    public final void initialize(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    public final void updateSearchContainer() {
        if (getContext() == null) {
            return;
        }
        Map<String, Long> mapQuerySearchKeywordList = RecentSearchDatabaseHelper.AsyncExecutor.querySearchKeywordList(10);
        if (mapQuerySearchKeywordList.isEmpty()) {
            return;
        }
        loadSearchBubble(mapQuerySearchKeywordList);
    }

    public FlexboxSearchView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSearchViews = new View[10];
        this.mIdColumns = new Long[10];
        final int i = 0;
        this.mDeleteClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FlexboxSearchView f6248b;

            {
                this.f6248b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        FlexboxSearchView.mDeleteClickListener$lambda$0(this.f6248b, view);
                        break;
                    default:
                        FlexboxSearchView.mSearchItemClickListener$lambda$1(this.f6248b, view);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mSearchItemClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FlexboxSearchView f6248b;

            {
                this.f6248b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        FlexboxSearchView.mDeleteClickListener$lambda$0(this.f6248b, view);
                        break;
                    default:
                        FlexboxSearchView.mSearchItemClickListener$lambda$1(this.f6248b, view);
                        break;
                }
            }
        };
    }

    public FlexboxSearchView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSearchViews = new View[10];
        this.mIdColumns = new Long[10];
        final int i2 = 0;
        this.mDeleteClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FlexboxSearchView f6248b;

            {
                this.f6248b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        FlexboxSearchView.mDeleteClickListener$lambda$0(this.f6248b, view);
                        break;
                    default:
                        FlexboxSearchView.mSearchItemClickListener$lambda$1(this.f6248b, view);
                        break;
                }
            }
        };
        final int i4 = 1;
        this.mSearchItemClickListener = new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ FlexboxSearchView f6248b;

            {
                this.f6248b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i4) {
                    case 0:
                        FlexboxSearchView.mDeleteClickListener$lambda$0(this.f6248b, view);
                        break;
                    default:
                        FlexboxSearchView.mSearchItemClickListener$lambda$1(this.f6248b, view);
                        break;
                }
            }
        };
    }
}
