package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverTemplateAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverTemplatePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0202d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010!J\u0016\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020!2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverTemplatePresenter;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverTemplatePresenter$Contract;", "mRootView", "Landroid/view/View;", "mAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverTemplateAdapter;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initialize", "", "presenter", "rootView", "setContract", "contract", "initAdapter", "initRecyclerView", "updateSpan", "isTextType", "", "updateSpanCount", "setVisibility", "visibility", "", "updateSelectedColor", "colorUuid", "", "updateSelectedType", "selectedTypeIndex", "selectedTemplate", "updateSelectedTemplate", "templateUuid", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverTemplatePresenter {

    @NotNull
    public static final String TAG = "CoverTemplatePresenter";

    @Nullable
    private CoverTemplateAdapter mAdapter;

    @NotNull
    private final Context mContext;

    @Nullable
    private Contract mContract;

    @Nullable
    private CoverStylePresenter mPresenter;

    @Nullable
    private RecyclerView mRecyclerView;

    @Nullable
    private View mRootView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverTemplatePresenter$Contract;", "", "onSelectTemplate", "", "templateUuid", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onSelectTemplate(@NotNull String templateUuid);
    }

    public CoverTemplatePresenter(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    private final void initAdapter() {
        String templateUuid;
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter);
        Map<Integer, List<String>> mapCreateTemplateMap = coverStylePresenter.createTemplateMap();
        CoverStylePresenter coverStylePresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter2);
        String templateUuid2 = coverStylePresenter2.getTemplateUuid();
        CoverStylePresenter coverStylePresenter3 = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter3);
        CoverStylePresenter coverStylePresenter4 = this.mPresenter;
        if (coverStylePresenter4 == null || (templateUuid = coverStylePresenter4.getTemplateUuid()) == null) {
            templateUuid = "";
        }
        int typeIndex = coverStylePresenter3.getTypeIndex(templateUuid);
        CoverStylePresenter coverStylePresenter5 = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter5);
        CoverTemplateAdapter coverTemplateAdapter = new CoverTemplateAdapter(mapCreateTemplateMap, templateUuid2, typeIndex, coverStylePresenter5.getColorUuid());
        coverTemplateAdapter.setTemplateContract(new CoverTemplateAdapter.TemplateContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverTemplatePresenter$initAdapter$1$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverTemplateAdapter.TemplateContract
            public void onSelectTemplate(int position, String templateUuid3) {
                Intrinsics.checkNotNullParameter(templateUuid3, "templateUuid");
                StringBuilder sb = new StringBuilder("onSelectTemplate# position : ");
                sb.append(position);
                sb.append(", templateUuid : ");
                AbstractC8014b.m7213o(sb, templateUuid3, CoverTemplatePresenter.TAG);
                CoverStylePresenter coverStylePresenter6 = this.this$0.mPresenter;
                if (coverStylePresenter6 != null) {
                    CoverStylePresenter coverStylePresenter7 = this.this$0.mPresenter;
                    Intrinsics.checkNotNull(coverStylePresenter7);
                    coverStylePresenter6.setSelectedTemplateUuid(coverStylePresenter7.getTypeIndex(templateUuid3), templateUuid3);
                }
                CoverStylePresenter coverStylePresenter8 = this.this$0.mPresenter;
                if (coverStylePresenter8 != null) {
                    coverStylePresenter8.setTemplateUuid(templateUuid3);
                }
                CoverTemplatePresenter.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    contract.onSelectTemplate(templateUuid3);
                }
            }
        });
        this.mAdapter = coverTemplateAdapter;
    }

    private final void initRecyclerView() {
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter);
        CoverStylePresenter coverStylePresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter2);
        boolean z = coverStylePresenter.getTypeIndex(coverStylePresenter2.getTemplateUuid()) == CoverStyleConstants.CoverType.TEXT.ordinal();
        View view = this.mRootView;
        RecyclerView recyclerView = view != null ? (RecyclerView) view.findViewById(C9086R.id.template_recyclerview) : null;
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, z ? 4 : 3));
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mAdapter);
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(null);
        }
        updateSpan(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSpanCount$lambda$2(CoverTemplatePresenter coverTemplatePresenter, RecyclerView recyclerView, boolean z) {
        recyclerView.setLayoutManager(new GridLayoutManager(coverTemplatePresenter.mContext, CoverStyleUtils.INSTANCE.getTemplateSpanCount(coverTemplatePresenter.mContext, recyclerView.getMeasuredWidth(), z)));
    }

    public final void initialize(@Nullable CoverStylePresenter presenter, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mPresenter = presenter;
        this.mRootView = rootView;
        initAdapter();
        initRecyclerView();
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void setVisibility(int visibility) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setVisibility(visibility);
        }
    }

    public final void updateSelectedColor(@NotNull String colorUuid) {
        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
        CoverTemplateAdapter coverTemplateAdapter = this.mAdapter;
        if (coverTemplateAdapter != null) {
            coverTemplateAdapter.updateSelectedColor(colorUuid);
        }
    }

    public final void updateSelectedTemplate(@NotNull String templateUuid, @NotNull String colorUuid) {
        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
        CoverTemplateAdapter coverTemplateAdapter = this.mAdapter;
        if (coverTemplateAdapter != null) {
            coverTemplateAdapter.updateSelectedTemplate(templateUuid, colorUuid);
        }
    }

    public final void updateSelectedType(int selectedTypeIndex, @Nullable String selectedTemplate) {
        CoverTemplateAdapter coverTemplateAdapter = this.mAdapter;
        if (coverTemplateAdapter != null) {
            coverTemplateAdapter.updateSelectedType(selectedTypeIndex, selectedTemplate);
        }
        updateSpan(selectedTypeIndex == CoverStyleConstants.CoverType.TEXT.ordinal());
    }

    public final void updateSpan(boolean isTextType) {
        Resources resources;
        int i;
        updateSpanCount(isTextType);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(isTextType ? C9086R.dimen.cover_style_template_recycler_margin_horizontal_4_span : C9086R.dimen.cover_style_template_recycler_margin_horizontal_3_span);
        if (isTextType) {
            resources = this.mContext.getResources();
            i = C9086R.dimen.cover_style_template_recycler_margin_bottom_4_span;
        } else {
            resources = this.mContext.getResources();
            i = C9086R.dimen.cover_style_template_recycler_margin_bottom_3_span;
        }
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i);
        RecyclerView recyclerView = this.mRecyclerView;
        ViewGroup.LayoutParams layoutParams = recyclerView != null ? recyclerView.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.setMargins(dimensionPixelSize, marginLayoutParams.topMargin, dimensionPixelSize, dimensionPixelSize2);
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final void updateSpanCount(boolean isTextType) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.post(new RunnableC0202d(this, recyclerView, isTextType, 10));
    }
}
