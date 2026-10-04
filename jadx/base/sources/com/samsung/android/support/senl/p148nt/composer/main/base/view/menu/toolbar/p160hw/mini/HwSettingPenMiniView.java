package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.mini;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.LazyUpdateHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class HwSettingPenMiniView extends SpenSettingPenMiniLayout {
    private static final String TAG = Logger.createTag("HwSettingPenMiniView");
    View mContainer;
    IPenMiniContract mIContract;
    private final LazyUpdateHelper mLazyUpdateHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IPenMiniContract {
        void applyPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo);

        void beginDelayedRestrictOutOfBounds();

        HwSettingPresenter getSettingInstance();

        View.OnClickListener getToggleModeClickListener();

        boolean isTouchDownConsumed();

        void runHidingVI();

        void runReboundVI();

        void updatePenMode();
    }

    public HwSettingPenMiniView(@NonNull Context context, @NonNull List<Integer> list, @NonNull List<SpenHSVColor> list2, @NonNull boolean z, List<String> list3, int i) {
        super(context, list, list2, z, list3, i);
        this.mLazyUpdateHelper = new LazyUpdateHelper(new LazyUpdateHelper.Callback<SpenSettingUIPenInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.util.LazyUpdateHelper.Callback
            public void onLazyUpdate(SpenSettingUIPenInfo spenSettingUIPenInfo) {
                Logger.m11003i(HwSettingPenMiniView.TAG, "onLazyUpdate pen size: " + spenSettingUIPenInfo.size);
                HwSettingPenMiniView.this.mIContract.applyPenInfo(spenSettingUIPenInfo);
            }
        });
    }

    public void initialize(final View view, IPenMiniContract iPenMiniContract) {
        this.mContainer = view;
        this.mIContract = iPenMiniContract;
        setAllPenInfo();
        setDisallowSliderLabel(false);
        setChangeViewModeButtonListener(this.mIContract.getToggleModeClickListener());
        setPaletteActionButtonListener(new OnActionButtonListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.2
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener
            public void onButtonClick(int i) {
                String str = HwSettingPenMiniView.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "onButtonClick ", " isTouchDownConsumed : ");
                sbM778t.append(HwSettingPenMiniView.this.mIContract.isTouchDownConsumed());
                Logger.m11003i(str, sbM778t.toString());
                if (HwSettingPenMiniView.this.mIContract.isTouchDownConsumed()) {
                    return;
                }
                if (1 == i) {
                    SpenSettingUIPenInfo info = HwSettingPenMiniView.this.getInfo();
                    if (info != null) {
                        HwSettingPenMiniView.this.mIContract.getSettingInstance().showColorPicker(0, HwSettingPenMiniView.this.mContainer, info.hsv);
                        return;
                    }
                    return;
                }
                if (2 == i) {
                    HwSettingPenMiniView.this.mIContract.updatePenMode();
                    HwSettingPenMiniView.this.setViewMode(1);
                    HwSettingPenMiniView.this.mIContract.getSettingInstance().showSettingView(0, 4096, (View) view.getParent());
                } else if (3 == i) {
                    HwSettingPenMiniView.this.mIContract.getSettingInstance().showSettingView(0, 2048, HwSettingPenMiniView.this.mContainer);
                }
            }
        });
        setViewModeChangedListener(new SpenSettingPenMiniLayout.OnViewModeChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.3
            @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniLayoutControl.OnViewModeChangedListener
            public void onViewModeChanged(int i) {
                AbstractC8014b.m7217s(i, "onViewModeChanged ", HwSettingPenMiniView.TAG);
                HwSettingPenMiniView.this.mIContract.beginDelayedRestrictOutOfBounds();
                if (2 == i) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_MINI_PEN_TYPE);
                    ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_MINI_PEN_DEPTH, "c");
                } else if (8 == i) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_MINI_PEN_COLOR);
                    ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_MINI_PEN_DEPTH, "d");
                } else if (4 == i) {
                    ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_MINI_PEN_SIZE);
                    ComposerSA.insertStatusLog(HWToolbarSAConstants.EVENT_STATUS_MINI_PEN_DEPTH, "e");
                }
            }
        });
        setPenInfoChangedListener(new PenInfoChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.4
            @Override // com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener
            public void onPenInfoChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
                String str;
                if (spenSettingUIPenInfo == null) {
                    str = "null";
                } else {
                    str = spenSettingUIPenInfo.name + "/" + spenSettingUIPenInfo.color + "/" + spenSettingUIPenInfo.size;
                }
                AbstractC8014b.m7197C("onPenInfoChanged ", str, HwSettingPenMiniView.TAG);
                HwSettingPenMiniView.this.mLazyUpdateHelper.updateValue(spenSettingUIPenInfo);
            }
        });
        setOnButtonClickListener(new SpenSettingPenMiniLayout.OnButtonClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.mini.HwSettingPenMiniView.5
            @Override // com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout.OnButtonClickListener
            public void onCloseButtonClick() {
                Logger.m11003i(HwSettingPenMiniView.TAG, "onCloseButtonClick");
                HwSettingPenMiniView.this.mIContract.getSettingInstance().getSettingInfoManager().getPenMiniMenuData().setEnable(false);
                HwSettingPenMiniView.this.mIContract.runHidingVI();
                ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_MINI_CLOSE_MINI);
            }
        });
    }

    public void setAllPenInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mIContract.getSettingInstance().getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoList());
        arrayList.addAll(this.mIContract.getSettingInstance().getSettingInfoManager().getPenInfoData().getSettingPenInfoList());
        setPenInfoList(arrayList);
        setRecentColor(this.mIContract.getSettingInstance().getSettingInfoManager().getColorRecentData().getRecentColors());
        setPalette(this.mIContract.getSettingInstance().getSettingInfoManager().getColorPaletteData().getSelectList());
    }
}
