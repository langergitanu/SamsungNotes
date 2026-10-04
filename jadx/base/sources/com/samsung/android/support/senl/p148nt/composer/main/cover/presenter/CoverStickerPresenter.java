package com.samsung.android.support.senl.p148nt.composer.main.cover.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.color.utilities.C4662f;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.adapter.StickerListAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverStickerData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverStickerDownloadPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerUtils;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverStickerPresenter {
    private static final String TAG = Logger.createCoverTag(com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStickerPresenter.TAG);
    private StickerListAdapter mAdapter;
    private final Context mContext;
    private Contract mContract;
    private CoverStickerDownloadPresenter mDownloadPresenter;
    private View mDownloadView;
    private View mProgresView;
    private RecyclerView mRecyclerView;
    private final TaskDownloadCoverSticker mDownloadStickerTask = new TaskDownloadCoverSticker();
    private boolean mNeedToDownloadSticker = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ViewOnClickListenerC109441 implements View.OnClickListener {
        public ViewOnClickListenerC109441() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Logger.m10999d(CoverStickerPresenter.TAG, "onClick# mDownloadView");
            CoverStickerPresenter.this.downloadCoverSticker();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onDownloadedCoverSticker();

        void onSelectSticker(int i, int i2, String str);
    }

    public CoverStickerPresenter(View view, String str) {
        this.mContext = view.getContext();
        initDownloadView(view);
        initAdapter(view, str);
    }

    private List<CoverStickerData> createStickerList() {
        Logger.m10999d(TAG, "createStickerList");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 12; i++) {
            arrayList.add(new CoverStickerData(CoverStickerUtils.Sticker.values()[i].getUuid()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadCoverSticker() {
        this.mDownloadPresenter.setDownloadContract(new CoverStickerDownloadPresenter.DownloadContract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerDownloadPresenter.DownloadContract
            public void hideProgress() {
                CoverStickerPresenter.this.hideProgressView();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerDownloadPresenter.DownloadContract
            public void onDownloadedCoverSticker() {
                Logger.m10999d(CoverStickerPresenter.TAG, "onDownloadedCoverSticker# ");
                List<CoverStickerData> listUpdateDownloadStickerList = CoverStickerPresenter.this.updateDownloadStickerList();
                if (listUpdateDownloadStickerList != null) {
                    CoverStickerPresenter.this.mAdapter.updateCoverStickerList(listUpdateDownloadStickerList);
                    CoverStickerPresenter.this.updateDownloadedCategories(listUpdateDownloadStickerList);
                }
                CoverStickerPresenter.this.mNeedToDownloadSticker = false;
                CoverStickerPresenter.this.hideProgressView();
                CoverStickerPresenter.this.mDownloadView.setVisibility(8);
                CoverStickerPresenter.this.mAdapter.notifyItemInserted(CoverStickerDownloadUtils.getDownloadedStickerFirstIndex() + CoverStickerDownloadUtils.getDownloadedStickerSize());
                CoverStickerPresenter.this.mContract.onDownloadedCoverSticker();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerDownloadPresenter.DownloadContract
            public void showProgress() {
                CoverStickerPresenter.this.showProgressView();
            }
        });
        this.mDownloadPresenter.onDownloadCoverSticker(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressView() {
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter.5
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(CoverStickerPresenter.TAG, "hideProgressView");
                CoverStickerPresenter.this.mProgresView.setVisibility(8);
                CoverStickerPresenter.this.clear();
            }
        });
    }

    private void initAdapter(View view, String str) {
        StickerListAdapter stickerListAdapter = new StickerListAdapter();
        this.mAdapter = stickerListAdapter;
        stickerListAdapter.setStickerList(createStickerList());
        this.mAdapter.updateSelectedPosition(CoverStickerUtils.getStickerIndex(str));
        this.mAdapter.setStickerContract(new StickerListAdapter.StickerContract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.StickerListAdapter.StickerContract
            public void onSelectSticker(int i, int i2, String str2) {
                CoverStickerPresenter.this.mContract.onSelectSticker(i, i2, str2);
            }
        });
        initRecyclerView(view);
    }

    private void initDownloadView(View view) {
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C9086R.id.sticker_recyclerview);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this.mContext, 6));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setItemAnimator(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Pair lambda$updateDownloadedCategories$0(CoverStickerData coverStickerData) {
        return new Pair(coverStickerData.getUuid(), CoverStickerUtils.Sticker.values()[coverStickerData.getIndex()].getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressView() {
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.CoverStickerPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(CoverStickerPresenter.TAG, "showProgressView");
                CoverStickerPresenter.this.mProgresView.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CoverStickerData> updateDownloadStickerList() {
        Logger.m10999d(TAG, "updateDownloadStickerList# mNeedToDownloadSticker : " + this.mNeedToDownloadSticker);
        int downloadedStickerSize = CoverStickerDownloadUtils.getDownloadedStickerSize();
        int downloadedStickerFirstIndex = CoverStickerDownloadUtils.getDownloadedStickerFirstIndex();
        List<Pair<Drawable, String>> downloadedStickerDrawableList = CoverStickerDownloadUtils.getDownloadedStickerDrawableList(this.mContext, downloadedStickerSize);
        if (downloadedStickerDrawableList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = downloadedStickerFirstIndex; i < downloadedStickerSize; i++) {
            CoverStickerData coverStickerData = new CoverStickerData(CoverStickerUtils.Sticker.values()[i].getUuid());
            int i2 = i - downloadedStickerFirstIndex;
            if (downloadedStickerDrawableList.get(i2).first != null) {
                coverStickerData.setDrawable((Drawable) downloadedStickerDrawableList.get(i2).first);
                coverStickerData.setPath((String) downloadedStickerDrawableList.get(i2).second);
            }
            arrayList.add(coverStickerData);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDownloadedCategories(List<CoverStickerData> list) {
        FolderManager.getInstance().initializeCoverDownloadedCategories((List) list.stream().map(new C4662f(26)).collect(Collectors.toList()));
    }

    public void clear() {
        this.mDownloadStickerTask.clear();
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void setVisibility(int i) {
        this.mRecyclerView.setVisibility(i);
    }

    public void updateSelectedSticker(int i) {
        this.mAdapter.updateSelectedSticker(i);
    }

    public void updateStickerSpan(int i) {
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(this.mContext, CoverEditorUtils.getSpanCount(this.mContext, i, 1)));
    }
}
