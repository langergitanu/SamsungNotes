package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverStickerAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStickerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\tJ\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStickerPresenter;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStickerPresenter$Contract;", "mRootView", "Landroid/view/View;", "mAdapter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/adapter/CoverStickerAdapter;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initialize", "", "presenter", "rootView", "setContract", "contract", "initAdapter", "initRecyclerView", "updateSpanCount", "setVisibility", "visibility", "", "updateSelectedSticker", "stickerUuid", "", "createStickerList", "", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverStickerData;", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStickerPresenter {

    @NotNull
    public static final String TAG = "CoverStickerPresenter";

    @Nullable
    private CoverStickerAdapter mAdapter;

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
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStickerPresenter$Contract;", "", "onSelectSticker", "", "stickerPosition", "", "stickerPrevPosition", "stickerUuid", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onSelectSticker(int stickerPosition, int stickerPrevPosition, @Nullable String stickerUuid);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<CoverStickerUtils.Sticker> entries$0 = EnumEntriesKt.enumEntries(CoverStickerUtils.Sticker.values());
    }

    public CoverStickerPresenter(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
    }

    private final List<CoverStickerData> createStickerList() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 12; i++) {
            arrayList.add(new CoverStickerData(EntriesMappings.entries$0.get(i).getUuid()));
        }
        return arrayList;
    }

    private final void initAdapter() {
        CoverStickerAdapter coverStickerAdapter = new CoverStickerAdapter();
        coverStickerAdapter.setStickerList(createStickerList());
        CoverStylePresenter coverStylePresenter = this.mPresenter;
        coverStickerAdapter.updateSelectedPosition(CoverStickerUtils.getStickerIndex(coverStylePresenter != null ? coverStylePresenter.getStickerUuid() : null));
        coverStickerAdapter.setStickerContract(new CoverStickerAdapter.StickerContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStickerPresenter$initAdapter$1$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.adapter.CoverStickerAdapter.StickerContract
            public void onSelectSticker(int stickerPosition, int stickerPrevPosition, String stickerUuid) {
                Intrinsics.checkNotNullParameter(stickerUuid, "stickerUuid");
                CoverStickerPresenter.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    contract.onSelectSticker(stickerPosition, stickerPrevPosition, stickerUuid);
                }
            }
        });
        this.mAdapter = coverStickerAdapter;
    }

    private final void initRecyclerView() {
        View view = this.mRootView;
        RecyclerView recyclerView = view != null ? (RecyclerView) view.findViewById(C9086R.id.sticker_recyclerview) : null;
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 6));
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.mAdapter);
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setItemAnimator(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSpanCount$lambda$1(CoverStickerPresenter coverStickerPresenter, RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(coverStickerPresenter.mContext, CoverStyleUtils.INSTANCE.getStickerSpanCount(coverStickerPresenter.mContext, recyclerView.getMeasuredWidth())));
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

    public final void updateSelectedSticker(@NotNull String stickerUuid) {
        Intrinsics.checkNotNullParameter(stickerUuid, "stickerUuid");
        CoverStickerAdapter coverStickerAdapter = this.mAdapter;
        if (coverStickerAdapter != null) {
            coverStickerAdapter.updateSelectedSticker(stickerUuid);
        }
    }

    public final void updateSpanCount() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.post(new RunnableC9844c(this, recyclerView, 20));
    }
}
