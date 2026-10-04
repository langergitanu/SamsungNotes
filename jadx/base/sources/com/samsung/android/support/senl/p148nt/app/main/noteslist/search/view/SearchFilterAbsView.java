package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0011J\u001e\u0010\u001a\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0016\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020\u001dH&J\b\u0010$\u001a\u00020\nH&R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterAbsView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFiltersViewList", "", "Landroid/view/View;", "[Landroid/view/View;", "mListener", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterAbsView$Listener;", "mFilterFlexBox", "Lcom/google/android/flexbox/FlexboxLayout;", "mFiltersClickListener", "Landroid/view/View$OnClickListener;", "initLayout", "", "setSearchListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "loadFilterBubble", "filtersDataList", "", "", "dim", "", "setFilterSelected", "index", "isSelected", "getTAG", "getLayoutResource", "Listener", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSearchFilterAbsView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchFilterAbsView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterAbsView\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,93:1\n51#2:94\n*S KotlinDebug\n*F\n+ 1 SearchFilterAbsView.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterAbsView\n*L\n60#1:94\n*E\n"})
public abstract class SearchFilterAbsView extends FrameLayout {

    @Nullable
    private FlexboxLayout mFilterFlexBox;

    @NotNull
    private final View.OnClickListener mFiltersClickListener;

    @NotNull
    private final View[] mFiltersViewList;

    @Nullable
    private Listener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/search/view/SearchFilterAbsView$Listener;", "", "onFiltersSelected", "", "filter", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Listener {
        void onFiltersSelected(@NotNull String filter);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterAbsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFiltersViewList = new View[10];
        this.mFiltersClickListener = new ViewOnClickListenerC8556a(this, 1);
        initLayout();
    }

    private final void initLayout() {
        LayoutInflater.from(getContext()).inflate(getLayoutResource(), (ViewGroup) this, true);
        this.mFilterFlexBox = (FlexboxLayout) findViewById(C8003R.id.filter_flexbox);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mFiltersClickListener$lambda$0(SearchFilterAbsView searchFilterAbsView, View view) {
        MainLogger.m7254d(searchFilterAbsView.getTAG(), "FiltersClick# " + ((Object) view.getContentDescription()));
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.String");
        String str = (String) tag;
        Listener listener = searchFilterAbsView.mListener;
        if (listener != null) {
            listener.onFiltersSelected(str);
        }
    }

    public abstract int getLayoutResource();

    @NotNull
    public abstract String getTAG();

    public final void loadFilterBubble(@NotNull List<String> filtersDataList, boolean dim) {
        FlexboxLayout flexboxLayout;
        Intrinsics.checkNotNullParameter(filtersDataList, "filtersDataList");
        FlexboxLayout flexboxLayout2 = this.mFilterFlexBox;
        if (flexboxLayout2 != null && flexboxLayout2.getChildCount() != 0 && (flexboxLayout = this.mFilterFlexBox) != null) {
            flexboxLayout.removeAllViews();
        }
        int iMin = Math.min(filtersDataList.size(), 10);
        for (int i = 0; i < iMin; i++) {
            String str = filtersDataList.get(i);
            this.mFiltersViewList[i] = LayoutInflater.from(getContext()).inflate(C8003R.layout.flexbox_filter_item, (ViewGroup) this, false);
            View view = this.mFiltersViewList[i];
            if (view != null) {
                view.setTag(str);
            }
            View view2 = this.mFiltersViewList[i];
            if (view2 != null) {
                view2.setOnClickListener(this.mFiltersClickListener);
            }
            View view3 = this.mFiltersViewList[i];
            if (view3 != null) {
                view3.setContentDescription(str);
            }
            View view4 = this.mFiltersViewList[i];
            if (view4 != null) {
                view4.setEnabled(!dim);
            }
            View view5 = this.mFiltersViewList[i];
            if (view5 != null) {
                view5.setAlpha(dim ? 0.4f : 1.0f);
            }
            View view6 = this.mFiltersViewList[i];
            TextView textView = view6 != null ? (TextView) view6.findViewById(C8003R.id.filter_item_text) : null;
            if (textView != null) {
                textView.setText(str);
            }
            CharUtils.applyTextSizeUntilMediumSize(getContext(), textView, 13.0f);
            FlexboxLayout flexboxLayout3 = this.mFilterFlexBox;
            if (flexboxLayout3 != null) {
                flexboxLayout3.addView(this.mFiltersViewList[i]);
            }
        }
    }

    public final void setFilterSelected(int index, boolean isSelected) {
        View view = this.mFiltersViewList[index];
        if (view != null) {
            view.setSelected(isSelected);
        }
    }

    public final void setSearchListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterAbsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFiltersViewList = new View[10];
        this.mFiltersClickListener = new ViewOnClickListenerC8556a(this, 1);
        initLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFilterAbsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFiltersViewList = new View[10];
        this.mFiltersClickListener = new ViewOnClickListenerC8556a(this, 1);
        initLayout();
    }
}
