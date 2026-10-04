package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.BaseItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;
import p047K3.ViewOnLayoutChangeListenerC0162a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\"B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/tab/TemplateTabView;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContainer", "Landroid/view/View;", "mRootView", "mItemRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/tab/TemplateTabView$Contract;", "mLastWidth", "", "getLayoutResourceId", "initLayout", "", "baseItemAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/adapter/BaseItemAdapter;", "contract", "getViewLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "scrollToPosition", "type", "position", "setEnableNestedScroll", "enable", "", "getView", "getLayoutHeight", "getTopBottomMarginFromView", "", "view", "Contract", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TemplateTabView {

    @Nullable
    private final Context context;

    @NotNull
    private final View mContainer;

    @Nullable
    private Contract mContract;

    @NotNull
    private final RecyclerView mItemRecyclerView;
    private int mLastWidth;

    @NotNull
    private final View mRootView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/tab/TemplateTabView$Contract;", "", "updateSpanCount", "", "width", "", "updatePagerHeight", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void updatePagerHeight();

        void updateSpanCount(int width);
    }

    public TemplateTabView(@Nullable Context context) {
        this.context = context;
        View viewInflate = LayoutInflater.from(context).inflate(getLayoutResourceId(), (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.mContainer = viewInflate;
        View viewFindViewById = viewInflate.findViewById(C9086R.id.comp_template_root);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mRootView = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(C9086R.id.comp_default_template_recycler_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mItemRecyclerView = (RecyclerView) viewFindViewById2;
        this.mLastWidth = -1;
    }

    private final float getTopBottomMarginFromView(View view) {
        if (view == null) {
            return 0.0f;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLayout$lambda$0(TemplateTabView templateTabView, View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || (i10 = i4 - i) == templateTabView.mLastWidth) {
            return;
        }
        templateTabView.mLastWidth = i10;
        Contract contract = templateTabView.mContract;
        if (contract != null) {
            contract.updateSpanCount(i10);
        }
        Contract contract2 = templateTabView.mContract;
        if (contract2 != null) {
            contract2.updatePagerHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToPosition$lambda$1(TemplateTabView templateTabView, int i) {
        Object parent = templateTabView.mItemRecyclerView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        float y2 = templateTabView.mItemRecyclerView.getChildAt(i).getY() + templateTabView.mItemRecyclerView.getY() + ((View) parent).getY();
        View view = templateTabView.mContainer;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
        ((NestedScrollView) view).smoothScrollTo(0, (int) y2);
    }

    public final int getLayoutHeight() {
        return (int) (this.mItemRecyclerView.getMeasuredHeight() + getTopBottomMarginFromView(this.mRootView));
    }

    public final int getLayoutResourceId() {
        return C9086R.layout.comp_dialog_template_change;
    }

    @NotNull
    /* JADX INFO: renamed from: getView, reason: from getter */
    public final View getMContainer() {
        return this.mContainer;
    }

    @NotNull
    public final GridLayoutManager getViewLayoutManager() {
        GridLayoutManager gridLayoutManager = (GridLayoutManager) this.mItemRecyclerView.getLayoutManager();
        return gridLayoutManager == null ? new GridLayoutManager(this.context, 3) : gridLayoutManager;
    }

    public final void initLayout(@Nullable BaseItemAdapter baseItemAdapter, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mItemRecyclerView.setAdapter(baseItemAdapter);
        this.mItemRecyclerView.setLayoutManager(getViewLayoutManager());
        this.mContract = contract;
        this.mContainer.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0162a(this, 11));
    }

    public final void scrollToPosition(int type, int position) {
        this.mContainer.post(new RunnableC0050f(this, position, 27));
    }

    public final void setEnableNestedScroll(boolean enable) {
        this.mContainer.setNestedScrollingEnabled(enable);
    }
}
