package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.util.Range;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingFavoriteInfo {
    private static final int NONE_FAVORITE = -1;
    private static final int START_FAVORITE_IDX = 0;
    private static final String TAG = Logger.createTag("HwSettingFavoriteInfo");
    private final HwSettingContract.IPresenter mPresenter;
    private int mPreviousFavoritePenIndex = -1;
    private SpenSettingUIPenInfo mPreviousFavoritePenInfo = null;

    public HwSettingFavoriteInfo(HwSettingContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
    }

    private int getFavoriteIndex(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        if (this.mPresenter.getSettingInfoManager().getFavoritePenData().isThereFavoriteInfo(spenSettingUIPenInfo)) {
            return this.mPresenter.getSettingInfoManager().getFavoritePenData().getFavoriteListIndex(spenSettingUIPenInfo);
        }
        return -1;
    }

    public void addFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        setFavoriteInfo(null, spenSettingUIPenInfo);
    }

    public void changeFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        if (spenSettingUIPenInfo == null || spenSettingUIPenInfo2 == null) {
            Logger.m10999d(TAG, "changeFavoritePenInfo # penInfo is null. ");
        } else {
            setFavoriteInfo(spenSettingUIPenInfo, spenSettingUIPenInfo2);
        }
    }

    public void clearFavoriteIndex() {
        this.mPreviousFavoritePenIndex = -1;
        this.mPreviousFavoritePenInfo = null;
        this.mPresenter.getSettingInfoManager().getFavoritePenData().notifyFavoriteIndexChanged(this.mPreviousFavoritePenIndex);
    }

    public boolean compareFavoritePenInfoList(List<SpenSettingUIPenInfo> list, List<SpenSettingUIPenInfo> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return list.equals(list2);
    }

    public SpenSettingUIPenInfo getFavoritePenToPenSetting(boolean z) {
        ArrayList<SpenSettingUIPenInfo> favoriteList = this.mPresenter.getSettingInfoManager().getFavoritePenData().getFavoriteList();
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("setFavoritePenToPenSetting : ", " / count = ", z);
        sbM3200j.append(favoriteList.size());
        Logger.m10999d(str, sbM3200j.toString());
        if (favoriteList.isEmpty()) {
            throw new IllegalStateException("empty favorite pen list");
        }
        SpenSettingUIPenInfo selectedPenInfo = this.mPresenter.getSelectedPenInfo();
        Range range = new Range(0, Integer.valueOf(favoriteList.size() - 1));
        int iIntValue = ((Integer) range.getLower()).intValue();
        if (selectedPenInfo != null) {
            Iterator<SpenSettingUIPenInfo> it = favoriteList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenSettingUIPenInfo next = it.next();
                if (CommonUtil.comparePenInfo(next, selectedPenInfo)) {
                    int iIndexOf = favoriteList.indexOf(next);
                    iIntValue = z ? iIndexOf + 1 : iIndexOf - 1;
                    if (!range.contains(Integer.valueOf(iIntValue))) {
                        iIntValue = ((Integer) range.getUpper()).intValue() - ((Integer) range.clamp(Integer.valueOf(iIntValue))).intValue();
                    }
                }
            }
        }
        return favoriteList.get(iIntValue);
    }

    public int getSelectedFavoritePenIndex() {
        return getFavoriteIndex(this.mPresenter.getSelectedPenInfo());
    }

    public void notifyFavoriteIndexChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        SpenSettingUIPenInfo spenSettingUIPenInfo2;
        if (spenSettingUIPenInfo == null) {
            return;
        }
        int favoriteIndex = getFavoriteIndex(spenSettingUIPenInfo);
        if (this.mPreviousFavoritePenIndex == favoriteIndex && (spenSettingUIPenInfo2 = this.mPreviousFavoritePenInfo) != null && CommonUtil.comparePenInfo(spenSettingUIPenInfo, spenSettingUIPenInfo2)) {
            return;
        }
        this.mPreviousFavoritePenIndex = favoriteIndex;
        this.mPreviousFavoritePenInfo = spenSettingUIPenInfo;
        AbstractC8014b.m7195A(new StringBuilder("notifyFavoriteIndexChanged index "), TAG, this.mPreviousFavoritePenIndex);
        this.mPresenter.getSettingInfoManager().getFavoritePenData().notifyFavoriteIndexChanged(this.mPreviousFavoritePenIndex);
    }

    public boolean removeFavoritePenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return this.mPresenter.getSettingInfoManager().getFavoritePenData().removeFavoriteInfo(spenSettingUIPenInfo);
    }

    public void setFavoriteInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        this.mPresenter.getSettingInfoManager().getFavoritePenData().setFavoriteInfo(spenSettingUIPenInfo, spenSettingUIPenInfo2);
    }

    public void setFavoriteInfoList(List<SpenSettingUIPenInfo> list) {
        this.mPresenter.getSettingInfoManager().getFavoritePenData().setFavoriteList(list);
    }
}
