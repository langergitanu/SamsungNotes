package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverColorAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverColorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.view.CoverItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverColorPresenter;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverColorPresenter$Contract;", "mRootView", "Landroid/view/View;", "mAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverColorAdapter;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initialize", "", "presenter", "rootView", "setContract", "contract", "initAdapter", "initRecyclerView", "updateSelectedColor", "colorUuid", "", "setVisibility", "visibility", "", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverColorPresenter {

    @NotNull
    public static final String TAG = "CoverColorPresenter";
    private CoverColorAdapter mAdapter;

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
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverColorPresenter$Contract;", "", "onSelectColor", "", "colorUuid", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onSelectColor(@NotNull String colorUuid);
    }

    public CoverColorPresenter(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    private final void initAdapter() {
        List<Pair<String, Integer>> listCreateColorList = CoverEditorUtils.createColorList();
        Intrinsics.checkNotNullExpressionValue(listCreateColorList, "createColorList(...)");
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        Intrinsics.checkNotNull(coverStylePresenter);
        CoverColorAdapter coverColorAdapter = new CoverColorAdapter(listCreateColorList, coverStylePresenter.getColorUuid());
        coverColorAdapter.setColorContract(new CoverColorAdapter.ColorContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverColorPresenter$initAdapter$1$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverColorAdapter.ColorContract
            public void onSelectColor(int position, String colorUuid) {
                Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
                StringBuilder sb = new StringBuilder("onSelectColor# position : ");
                sb.append(position);
                sb.append(", colorUuid : ");
                AbstractC8014b.m7213o(sb, colorUuid, CoverColorPresenter.TAG);
                CoverStylePresenter coverStylePresenter2 = this.this$0.mPresenter;
                Intrinsics.checkNotNull(coverStylePresenter2);
                coverStylePresenter2.setColorId(colorUuid);
                CoverColorPresenter.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    contract.onSelectColor(colorUuid);
                }
            }
        });
        this.mAdapter = coverColorAdapter;
    }

    private final void initRecyclerView() {
        View view = this.mRootView;
        CoverColorAdapter coverColorAdapter = null;
        RecyclerView recyclerView = view != null ? (RecyclerView) view.findViewById(C9086R.id.color_recyclerview) : null;
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            CoverColorAdapter coverColorAdapter2 = this.mAdapter;
            if (coverColorAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                coverColorAdapter2 = null;
            }
            recyclerView2.setAdapter(coverColorAdapter2);
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(null);
        }
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 != null) {
            CoverColorAdapter coverColorAdapter3 = this.mAdapter;
            if (coverColorAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                coverColorAdapter = coverColorAdapter3;
            }
            recyclerView4.scrollToPosition(coverColorAdapter.getSelectedPosition());
        }
        RecyclerView recyclerView5 = this.mRecyclerView;
        if (recyclerView5 != null) {
            recyclerView5.addItemDecoration(new CoverItemDecoration(this.mContext.getResources().getDimensionPixelSize(C9086R.dimen.cover_editor_new_color_item_margin_horizontal)));
        }
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
        CoverColorAdapter coverColorAdapter = this.mAdapter;
        CoverColorAdapter coverColorAdapter2 = null;
        if (coverColorAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            coverColorAdapter = null;
        }
        coverColorAdapter.updateSelectedColor(colorUuid);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            CoverColorAdapter coverColorAdapter3 = this.mAdapter;
            if (coverColorAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                coverColorAdapter2 = coverColorAdapter3;
            }
            recyclerView.scrollToPosition(coverColorAdapter2.getSelectedPosition());
        }
    }
}
