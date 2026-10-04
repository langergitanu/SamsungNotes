package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.util.Range;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class PageListThumbnailHelper {
    private static final int INIT_LOAD_COL_SIZE = 5;
    private static final int PRE_LOAD_COL_SIZE = 2;
    private static final String TAG = Logger.createTag("PageListThumbnailHelper");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private final PageListDataManager mPageListDataManager;
    private final ThumbnailUpdateHandler mThumbnailUpdateHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getSpanCount();
    }

    public PageListThumbnailHelper(Contract contract, PageListDataManager pageListDataManager, ComposerViewPresenter composerViewPresenter) {
        this.mContract = contract;
        this.mPageListDataManager = pageListDataManager;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mThumbnailUpdateHandler = composerViewPresenter.getThumbnailUpdateHandler();
    }

    private boolean isNeededToConvertPosToPageIndex() {
        return this.mPageListDataManager.getPageListMode().isMode(3);
    }

    private void updateConvertingTargetRange(int i, int i2, int i4, int i5) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "updateTargetRange# ", ",", " ");
        sbM1173s.append(i4);
        sbM1173s.append(",");
        sbM1173s.append(i5);
        Logger.m10999d(str, sbM1173s.toString());
        List<PageInfo> pageList = this.mComposerViewPresenter.getPageManager().getPageList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        while (i <= i2) {
            PageId pageId = this.mPageListDataManager.getPageIdList().get(i);
            while (true) {
                if (i6 >= pageList.size()) {
                    break;
                }
                if (pageId.getId().equals(pageList.get(i6).getPageId())) {
                    arrayList2.add(Integer.valueOf(i6));
                    if (i >= i4 && i <= i5) {
                        arrayList.add(Integer.valueOf(i6));
                    }
                    i6++;
                } else {
                    i6++;
                }
            }
            i++;
        }
        this.mThumbnailUpdateHandler.updateTargetRange(arrayList2, arrayList);
    }

    public void clearDisplayList() {
        Logger.m10999d(TAG, "updateDisplayThumbnailList# null");
        this.mThumbnailUpdateHandler.clearTargetRange();
    }

    public void initUpdateDisplayList() {
        updateDisplayList(0, this.mContract.getSpanCount() * 5);
    }

    public void setBlockThumbnailUpdate(boolean z) {
        this.mThumbnailUpdateHandler.setBlockToUpdate(z);
    }

    public void updateDisplayList(int i, int i2) {
        String str = TAG;
        AbstractC8014b.m7216r(i, i2, "updateDisplayThumbnailList# ", " ", str);
        int spanCount = this.mContract.getSpanCount() * 2;
        int iMax = Math.max(i - spanCount, 0);
        int size = this.mPageListDataManager.getPageIdList().size() - 1;
        int iMin = Math.min(i + i2 + spanCount, size);
        if (iMax <= iMin) {
            updateDisplayList(new Range<>(Integer.valueOf(iMax), Integer.valueOf(iMin)), i, i2);
            return;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iMax, iMin, "onVisibleItemChanged# invalid index: ", "/", "/");
        sbM1173s.append(size);
        Logger.m11000e(str, sbM1173s.toString());
    }

    public void updateThumbnail(int i) {
        if (isNeededToConvertPosToPageIndex()) {
            this.mComposerViewPresenter.getThumbnailUpdateHandler().updateThumbnail(this.mComposerViewPresenter.getPageManager().indexOf(this.mPageListDataManager.getPageIdList().get(i).getId()), true);
        } else {
            this.mComposerViewPresenter.getThumbnailUpdateHandler().updateThumbnail(i, true);
        }
    }

    public void updateDisplayList(Range<Integer> range, int i, int i2) {
        if (isNeededToConvertPosToPageIndex()) {
            updateConvertingTargetRange(((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue(), i, i2 + i);
            return;
        }
        Logger.m10999d(TAG, "updateDisplayThumbnailList# " + range.getLower() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + range.getUpper());
        this.mThumbnailUpdateHandler.updateTargetRange(((Integer) range.getLower()).intValue(), ((Integer) range.getUpper()).intValue(), i, i2 + i);
    }
}
