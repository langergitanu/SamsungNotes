package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerLayoutV2;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AnchorInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.menu.ViewAnchorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingViewManager implements ISettingViewManager, HwSettingContract.ISettingView {
    private static final String TAG = Logger.createTag("HwSettingViewManager");
    private FloaterContainer mFloatingContainer;
    private Handler mHandler;
    private HwToolbarState mHwToolbarState;
    private boolean mIsBlockingHide;
    private boolean mIsTabletLayout;
    private HwToolbarPresenterImpl mPresenter;
    private HwToolbarContract.QtHwToolbarStateListener mQTListener;
    private int mSelectedToolbarItem;
    protected HashMap<Integer, HwSettingLayout> mSettingMap;
    protected View mToolbarContainer;
    protected ToolManager mToolbarManager;
    private WritingToolManager mWritingToolManager;
    protected boolean mIsSupportFixedOpacity = true;
    protected boolean mIsSupportDynamicPenWeightByTextSize = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ToolManager {
        int getAnchorPosition(int i);

        View getView(int i);

        void onUpdatedHighlighter(String str, int i);

        void onUpdatedPen(String str, int i);

        void onUpdatedSelection(int i);

        void onUpdatedStyle(int i);
    }

    private boolean cancel() {
        if (this.mSettingMap == null || !this.mHwToolbarState.isShownSettingViews()) {
            return false;
        }
        Iterator it = new HashMap(this.mHwToolbarState.getShownSettingViews()).entrySet().iterator();
        boolean zCancel = true;
        while (it.hasNext()) {
            HwSettingLayout hwSettingLayout = this.mSettingMap.get(((Map.Entry) it.next()).getKey());
            if (hwSettingLayout != null) {
                zCancel = hwSettingLayout.cancel();
            }
        }
        return zCancel;
    }

    private Rect getCorrectDockingSize(Rect rect) {
        Rect rect2 = new Rect(rect);
        boolean zIsRTLMode = LocaleUtils.isRTLMode();
        int dockingType = ((FloatLayout) this.mToolbarContainer).getDockingType();
        int dockingSize = ((FloatLayout) this.mToolbarContainer).getDockingSize();
        if (dockingType == 0) {
            rect2.offset(0, dockingSize);
            return rect2;
        }
        if ((!zIsRTLMode && dockingType == 2) || (zIsRTLMode && dockingType == 3)) {
            rect2.offset(dockingSize, 0);
        }
        return rect2;
    }

    private void requestFocusToCallerView(int i, View view) {
        try {
            view = this.mToolbarManager.getView(i);
        } catch (NoSuchElementException unused) {
        }
        view.requestFocus();
    }

    private void setPositionLayout(final int i, final View view, final View view2) {
        if (view2 == null || view == null) {
            return;
        }
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                HwSettingViewManager.this.updatePosition(i, view, view2, (int) HwSettingViewManager.this.mToolbarContainer.getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_margin));
            }
        });
        view2.requestLayout();
    }

    private boolean shouldDisplayOnCenter(View view) {
        return !this.mIsTabletLayout && view.getResources().getDisplayMetrics().widthPixels < view.getWidth() * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePosition(View view, AnchorInfo anchorInfo) {
        Rect correctDockingSize = getCorrectDockingSize(anchorInfo.mAnchorRect);
        ViewAnchorUtil.Area area = anchorInfo.mPriorityArea;
        if (area == null) {
            if (this.mIsTabletLayout) {
                ViewAnchorUtil.updatePosition(correctDockingSize, anchorInfo.mAnchorBorderView, view, anchorInfo.mAnchorMargin);
                return;
            } else {
                ViewAnchorUtil.updatePositionToCenter(correctDockingSize, anchorInfo.mAnchorBorderView, view, anchorInfo.mAnchorMargin);
                return;
            }
        }
        Rect rect = anchorInfo.mBorderRect;
        if (rect != null) {
            ViewAnchorUtil.updatePositionToVertical(correctDockingSize, rect, view, anchorInfo.mAnchorMargin, area);
        } else {
            ViewAnchorUtil.updatePositionToVertical(correctDockingSize, anchorInfo.mAnchorBorderView, view, anchorInfo.mAnchorMargin, area);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void clearContextMenu() {
        Logger.m11003i(TAG, "clearContextMenu");
        this.mPresenter.clearContextMenu();
    }

    public void close() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        Iterator<Map.Entry<Integer, HwSettingLayout>> it = this.mSettingMap.entrySet().iterator();
        while (it.hasNext()) {
            HwSettingLayout value = it.next().getValue();
            if (value != null) {
                value.close();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void executeEraseAllOnAllPages() {
        this.mPresenter.getSettingInstance().executeEraseAllOnAllPages();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void executeEraseAllOnCurrentPage(int i) {
        this.mPresenter.getSettingInstance().executeEraseAllOnCurrentPage(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void executeSelectedChangeStyle(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        this.mPresenter.getSettingInstance().executeSelectedChangeStyle(spenSettingUIChangeStyleInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public int getBackgroundThemeColor() {
        return this.mPresenter.getBackgroundThemeColor();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public int getColorTheme() {
        return this.mPresenter.getColorTheme();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public String getCurrentPageInfo() {
        return this.mPresenter.getCurrentPageInfo();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public HwToolbarState getHWToolbarState() {
        return this.mHwToolbarState;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public SpenSettingUIPenInfo getSelectedPenInfo() {
        return this.mPresenter.getSettingInstance().getSelectedPenInfo();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public int getSelectedToolbarItem() {
        return this.mSelectedToolbarItem;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public SettingInfoManager getSettingInfoManager() {
        return this.mPresenter.getSettingInstance().getSettingInfoManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public HwSettingPresenter getSettingInstance() {
        return this.mPresenter.getSettingInstance();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public WritingToolManager getWritingToolManager() {
        return this.mWritingToolManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public boolean hide() {
        return hide(true, 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public boolean hideColorSpoid() {
        HwSettingLayout hwSettingLayout;
        if (!this.mHwToolbarState.isColorSpoidEnable() || (hwSettingLayout = this.mSettingMap.get(Integer.valueOf(this.mHwToolbarState.getColorSpoidKey()))) == null) {
            return false;
        }
        if (hwSettingLayout instanceof HwSettingPenLayoutCommon) {
            ((HwSettingPenLayoutCommon) hwSettingLayout).hideColorSpoid();
            return true;
        }
        if (hwSettingLayout instanceof HwSettingEyedropperLayout) {
            hwSettingLayout.hide(false);
            return true;
        }
        if (hwSettingLayout instanceof HwSettingChangeStyleLayout) {
            ((HwSettingChangeStyleLayout) hwSettingLayout).hideEyedropper();
            return true;
        }
        if (!(hwSettingLayout instanceof HwSettingLaserPenLayout)) {
            return false;
        }
        ((HwSettingLaserPenLayout) hwSettingLayout).hideEyedropper();
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void hideSettingView(int i) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(Integer.valueOf(i));
        if (hwSettingLayout != null) {
            hwSettingLayout.hide(true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void hideSettingViews(boolean z) {
        HashMap<Integer, HwSettingLayout> map = this.mSettingMap;
        if (map == null) {
            return;
        }
        for (HwSettingLayout hwSettingLayout : map.values()) {
            if (hwSettingLayout != null) {
                hwSettingLayout.hide(hwSettingLayout.isVisible() && z);
            }
        }
    }

    public void init(View view, FloaterContainer floaterContainer, ToolManager toolManager, WritingToolManager writingToolManager, HwToolbarState hwToolbarState, HwToolbarPresenterImpl hwToolbarPresenterImpl) {
        this.mToolbarContainer = view;
        this.mToolbarManager = toolManager;
        this.mSettingMap = new HashMap<>(5);
        this.mFloatingContainer = floaterContainer;
        this.mHwToolbarState = hwToolbarState;
        this.mWritingToolManager = writingToolManager;
        this.mSelectedToolbarItem = 4;
        this.mPresenter = hwToolbarPresenterImpl;
        hwToolbarPresenterImpl.getSettingInstance().setSettingView(this);
        this.mHandler = new Handler();
        this.mIsTabletLayout = ResourceUtils.isTabletLayout(this.mToolbarContainer.getContext());
        this.mSettingMap.put(1, new HwSettingFavoritePenLayout());
        this.mSettingMap.put(2, new HwSettingAddFavoritePenLayout());
        this.mSettingMap.put(128, new HwSettingAddFavoritePenLayout(false));
        this.mSettingMap.put(4, new HwSettingPenLayout());
        this.mSettingMap.put(256, new HwSettingHighlighterLayout());
        this.mSettingMap.put(8, new HwSettingRemoverLayout(hwToolbarPresenterImpl.isCoeditNote()));
        this.mSettingMap.put(16, new HwSettingSelectionLayout());
        this.mSettingMap.put(32, new HwSettingChangeStyleLayout());
        this.mSettingMap.put(64, new HwSettingChangeStyleSelectedLayout());
        this.mSettingMap.put(8192, new HwSettingStraightenLayout());
        this.mSettingMap.put(512, new HwSettingColorPickerLayout());
        this.mSettingMap.put(1024, new HwSettingPenSizeLayout());
        this.mSettingMap.put(2048, new HwSettingColorSetLayout());
        this.mSettingMap.put(4096, new HwSettingEyedropperLayout());
        this.mSettingMap.put(16384, new HwSettingAssistanceLayout());
        this.mSettingMap.put(32768, new HwSettingLaserPenLayout());
        this.mSettingMap.put(65536, new HwSettingSmartPenLayout());
        for (Map.Entry<Integer, HwSettingLayout> entry : this.mSettingMap.entrySet()) {
            HwSettingLayout value = entry.getValue();
            value.setViewId(entry.getKey().intValue());
            value.setFloatingContainer(this.mFloatingContainer);
            value.setWritingToolManager(this.mWritingToolManager);
            value.setSettingViewManager(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isCoeditNote() {
        return this.mPresenter.isCoeditNote();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isEraseCurrentTwoPage() {
        return this.mPresenter.isEraseCurrentTwoPage();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public boolean isShownSettingViews(int i) {
        return this.mHwToolbarState.isShownSettingViews(Integer.valueOf(i));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isSupportDynamicPenWeightByTextSize() {
        return this.mIsSupportDynamicPenWeightByTextSize;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isSupportEraseCurrentPage() {
        return this.mPresenter.isSupportEraseCurrentPage();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isSupportFixedOpacity() {
        return this.mIsSupportFixedOpacity;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isTabletLayout() {
        return this.mIsTabletLayout;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void notifyChangedRecentColor(List<SpenHSVColor> list) {
        for (HwSettingLayout hwSettingLayout : this.mSettingMap.values()) {
            if (hwSettingLayout != null && (hwSettingLayout instanceof HwSettingPenLayoutCommon)) {
                ((HwSettingPenLayoutCommon) hwSettingLayout).setRecentColor(list);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void notifyPaletteSetChanged(List<Integer> list) {
        for (HwSettingLayout hwSettingLayout : this.mSettingMap.values()) {
            if (hwSettingLayout != null && (hwSettingLayout instanceof HwSettingPenLayoutCommon)) {
                ((HwSettingPenLayoutCommon) hwSettingLayout).setPalette(list);
            } else if (hwSettingLayout != null && (hwSettingLayout instanceof HwSettingChangeStyleLayout)) {
                ((HwSettingChangeStyleLayout) hwSettingLayout).setPalette(list);
            } else if (hwSettingLayout != null && (hwSettingLayout instanceof HwSettingLaserPenLayout)) {
                ((HwSettingLaserPenLayout) hwSettingLayout).setPalette(list);
            }
        }
    }

    public boolean onBackPressed(boolean z) {
        if (hideColorSpoid() || cancel()) {
            return true;
        }
        return hide(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void onShowSettingPenMini() {
        this.mPresenter.showSettingPenMini();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public boolean onTouchOutside() {
        boolean zOnTouchOutside = false;
        if (this.mSettingMap == null || !this.mHwToolbarState.isShownSettingViews()) {
            return false;
        }
        Iterator it = new HashMap(this.mHwToolbarState.getShownSettingViews()).entrySet().iterator();
        while (it.hasNext()) {
            HwSettingLayout hwSettingLayout = this.mSettingMap.get(((Map.Entry) it.next()).getKey());
            if (hwSettingLayout != null) {
                zOnTouchOutside = hwSettingLayout.onTouchOutside();
                Logger.m11003i(TAG, "onTouchOutside# hwSettingLayout " + hwSettingLayout.toString());
            }
        }
        return zOnTouchOutside;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void onUpdateEyedropperColor() {
        HwSettingLayout hwSettingLayout;
        if (this.mHwToolbarState.isColorSpoidEnable() && (hwSettingLayout = this.mSettingMap.get(Integer.valueOf(getHWToolbarState().getColorSpoidKey()))) != null) {
            if (hwSettingLayout instanceof HwSettingPenLayoutCommon) {
                if (hwSettingLayout instanceof HwSettingPenLayout) {
                    ((HwSettingPenLayout) hwSettingLayout).setPenSettingInfo();
                } else if (hwSettingLayout instanceof HwSettingHighlighterLayout) {
                    ((HwSettingHighlighterLayout) hwSettingLayout).setHighlighterSettingInfo();
                }
                ((HwSettingPenLayoutCommon) hwSettingLayout).setEyedropperColor(getHWToolbarState().getEyedropperColor());
                return;
            }
            if (hwSettingLayout instanceof HwSettingEyedropperLayout) {
                ((HwSettingEyedropperLayout) hwSettingLayout).setColorSpoidColor(getHWToolbarState().getEyedropperColor());
                return;
            }
            if (hwSettingLayout instanceof HwSettingChangeStyleLayout) {
                HwSettingChangeStyleLayout hwSettingChangeStyleLayout = (HwSettingChangeStyleLayout) hwSettingLayout;
                hwSettingChangeStyleLayout.setEyedropperColor(getHWToolbarState().getEyedropperColor());
                hwSettingChangeStyleLayout.updateChangeStyleInfo();
            } else if (hwSettingLayout instanceof HwSettingLaserPenLayout) {
                ((HwSettingLaserPenLayout) hwSettingLayout).setEyedropperColor(getHWToolbarState().getEyedropperColor());
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void onUpdateFavoriteButton(boolean z) {
        ((HwSettingPenLayout) this.mSettingMap.get(4)).updateFavoriteButton(z);
        ((HwSettingHighlighterLayout) this.mSettingMap.get(256)).updateFavoriteButton(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void onUpdatedSelection(int i) {
        this.mToolbarManager.onUpdatedSelection(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void onUpdatedStyle(int i) {
        this.mToolbarManager.onUpdatedStyle(i);
    }

    public void reboundSettingPenMiniVI() {
        if (this.mIsTabletLayout && this.mPresenter.getSettingInstance().getSettingInfoManager().getPenMiniMenuData().isEnable()) {
            this.mPresenter.reboundSettingPenMiniVI();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void requestFocusToComposerView() {
        this.mPresenter.requestFocusToComposerView();
    }

    public void restoreAddFavoritePen(Bundle bundle) {
        if (isShownSettingViews(2)) {
            ((HwSettingAddFavoritePenLayout) this.mSettingMap.get(2)).restoreState(bundle);
        }
    }

    public void restoreColorSpoid() {
        if (this.mHwToolbarState.isColorSpoidEnable()) {
            final HwSettingLayout hwSettingLayout = this.mSettingMap.get(Integer.valueOf(this.mHwToolbarState.getColorSpoidKey()));
            this.mHwToolbarState.clearColorSpoidEnable();
            if (hwSettingLayout == null || !(hwSettingLayout instanceof HwSettingPenLayoutCommon)) {
                return;
            }
            hwSettingLayout.init();
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ((HwSettingPenLayoutCommon) hwSettingLayout).showColorSpoid();
                    Logger.m10999d(HwSettingViewManager.TAG, "restoreColorSpoid showColorSpoid");
                }
            });
        }
    }

    public void saveAddFavoritePen(Bundle bundle) {
        if (isShownSettingViews(2)) {
            ((HwSettingAddFavoritePenLayout) this.mSettingMap.get(2)).saveInstanceState(bundle);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setAlignmentOptions(boolean z, boolean z2, boolean z3, boolean z4) {
        ((HwSettingStraightenLayout) this.mSettingMap.get(8192)).setAlignmentOptions(z, z2, z3, z4);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setAssistanceOptions(boolean z, boolean z2, boolean z3) {
        ((HwSettingAssistanceLayout) this.mSettingMap.get(16384)).setAssistanceOptions(z, z2, z3);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void setBlockContextMenu(boolean z) {
        this.mPresenter.setBlockContextMenu(z);
    }

    public void setBlockHideSettingView(boolean z, String str) {
        Logger.m10999d(TAG, "setBlockHideSettingView# " + z + " by " + str);
        this.mIsBlockingHide = z;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setColorTheme(int i) {
        Iterator<HwSettingLayout> it = this.mSettingMap.values().iterator();
        while (it.hasNext()) {
            it.next().setColorTheme(i);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setEnabledSettingView(int i, boolean z) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(Integer.valueOf(i));
        if (hwSettingLayout != null) {
            hwSettingLayout.setEnabledSettingView(z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setEyedropperPosition(int i, int i2) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(Integer.valueOf(this.mHwToolbarState.getColorSpoidKey()));
        if (hwSettingLayout instanceof HwSettingEyedropperLayout) {
            ((HwSettingEyedropperLayout) hwSettingLayout).movePosition(i, i2);
        } else if (hwSettingLayout instanceof HwSettingAddFavoritePenLayout) {
            ((HwSettingAddFavoritePenLayout) hwSettingLayout).setEyedropperPosition(i, i2);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setHighlighterOnlyEnabled(boolean z) {
        HwSettingRemoverLayout hwSettingRemoverLayout = (HwSettingRemoverLayout) this.mSettingMap.get(8);
        if (hwSettingRemoverLayout != null) {
            hwSettingRemoverLayout.setEraserHighlighterOnlyEnabled(z);
        }
    }

    public void setHwToolbarState(HwToolbarState hwToolbarState) {
        this.mHwToolbarState = hwToolbarState;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setIsSupportDynamicPenWeightByTextSize(boolean z) {
        this.mIsSupportDynamicPenWeightByTextSize = z;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setIsSupportFixedOpacity(boolean z) {
        this.mIsSupportFixedOpacity = z;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setItemChangeStyleInfo(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        ((HwSettingChangeStyleLayout) this.mSettingMap.get(32)).setItemChangeStyleInfo(spenSettingUIChangeStyleInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setItemHighlighterSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        ((HwSettingHighlighterLayout) this.mSettingMap.get(256)).setItemHighlighterSettingInfo(spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setItemPenSettingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        ((HwSettingPenLayout) this.mSettingMap.get(4)).setItemPenSettingInfo(spenSettingUIPenInfo);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setLaserPenSettingInfo(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        ((HwSettingLaserPenLayout) this.mSettingMap.get(32768)).setSettingInfo(spenSettingUILaserPenInfo);
    }

    public void setQtHwToolbarStateListener(HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener) {
        this.mQTListener = qtHwToolbarStateListener;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setQuickColorSettingInfo(float[] fArr) {
        ((HwSettingColorPickerLayout) this.mSettingMap.get(512)).setCurrentColor(fArr);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setQuickSizeInfo(int i) {
        ((HwSettingPenSizeLayout) this.mSettingMap.get(1024)).setSettingInfo(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        ((HwSettingRemoverLayout) this.mSettingMap.get(8)).setSettingInfo(spenSettingRemoverInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setSelectedToolbarItem(int i) {
        this.mSelectedToolbarItem = i;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void setSelectionSettingInfo(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        ((HwSettingSelectionLayout) this.mSettingMap.get(16)).setSettingInfo(spenSettingSelectionInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void setSkipHideFavoriteList(boolean z) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(1);
        if (hwSettingLayout instanceof HwSettingFavoritePenLayout) {
            ((HwSettingFavoritePenLayout) hwSettingLayout).setSkipHide(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void show(int i, int i2) {
        show(i, i2, null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void showAddFavoritePen(int i, ViewGroup viewGroup, boolean z) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(2);
        if (hwSettingLayout instanceof HwSettingAddFavoritePenLayout) {
            ((HwSettingAddFavoritePenLayout) hwSettingLayout).showCenterInHalfParent(i, viewGroup, z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void showByAnchor(int i, int i2, AnchorInfo anchorInfo) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(Integer.valueOf(i2));
        if (hwSettingLayout instanceof AbsHwSettingAnchorLayout) {
            ((AbsHwSettingAnchorLayout) hwSettingLayout).setAnchorInfo(anchorInfo);
        }
        show(i, i2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void showColorPicker(int i, View view, float[] fArr) {
        show(i, 512, view);
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(512);
        if (hwSettingLayout instanceof HwSettingColorPickerLayout) {
            ((HwSettingColorPickerLayout) hwSettingLayout).setCurrentColor(fArr);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void showEyedropper(int i, View view, float[] fArr, SpenColorPickerLayoutV2.PickerColorChangedListener pickerColorChangedListener) {
        show(i, 4096, view);
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(4096);
        if (hwSettingLayout instanceof HwSettingEyedropperLayout) {
            HwSettingEyedropperLayout hwSettingEyedropperLayout = (HwSettingEyedropperLayout) hwSettingLayout;
            hwSettingEyedropperLayout.setPickerColorChangedListener(pickerColorChangedListener);
            hwSettingEyedropperLayout.setColorSpoidColor(ColorCompat.HSVToColor(fArr));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void showSelectionChangeStyle(int i, SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo, boolean z, AnchorInfo anchorInfo) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(64);
        if (hwSettingLayout instanceof HwSettingChangeStyleLayout) {
            HwSettingChangeStyleSelectedLayout hwSettingChangeStyleSelectedLayout = (HwSettingChangeStyleSelectedLayout) hwSettingLayout;
            hwSettingChangeStyleSelectedLayout.setChangeStyleInfo(spenSettingUIChangeStyleInfo, z);
            hwSettingChangeStyleSelectedLayout.setAnchoredInfo(anchorInfo);
        }
        show(i, 64);
    }

    public boolean showSettingPopupOfLaserPen(boolean z, View.OnClickListener onClickListener) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(32768);
        if (hwSettingLayout == null || !(hwSettingLayout instanceof HwSettingLaserPenLayout)) {
            return false;
        }
        ((HwSettingLaserPenLayout) hwSettingLayout).setActionButton(z, onClickListener);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void updateBeautifierLanguage(String str, boolean z) {
        ((HwSettingAssistanceLayout) this.mSettingMap.get(16384)).updateLanguage(str, z);
        ((HwSettingStraightenLayout) this.mSettingMap.get(8192)).updateLanguage(str, z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void updateByAnchor(int i, int i2, AnchorInfo anchorInfo) {
        HwSettingLayout hwSettingLayout = this.mSettingMap.get(Integer.valueOf(i2));
        if (hwSettingLayout instanceof AbsHwSettingAnchorLayout) {
            ((AbsHwSettingAnchorLayout) hwSettingLayout).setAnchorInfo(anchorInfo);
            hwSettingLayout.updatePosition(i, anchorInfo.mAnchorBorderView, true);
        }
    }

    public void updateLayout() {
        if (this.mHwToolbarState == null) {
            return;
        }
        HashMap map = new HashMap(this.mHwToolbarState.getShownSettingViews());
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            HwSettingLayout hwSettingLayout = this.mSettingMap.get(entry.getKey());
            if (hwSettingLayout != null) {
                hwSettingLayout.updatePosition(((Integer) entry.getValue()).intValue(), null, true);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(AnchorInfo anchorInfo, View view) {
        updateLayoutParam(anchorInfo, view, (ISettingViewManager.OnUpdatePositionListener) null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void updateRemoverSettingLayout() {
        HwSettingRemoverLayout hwSettingRemoverLayout = (HwSettingRemoverLayout) this.mSettingMap.get(8);
        if (hwSettingRemoverLayout == null || !hwSettingRemoverLayout.isVisible()) {
            return;
        }
        hwSettingRemoverLayout.updateEraseAllLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateShowState(int i, int i2, boolean z) {
        updateShowState(i, i2, z, false);
    }

    public boolean hide(boolean z) {
        return hide(z, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isShownSettingViews(int i, int i2) {
        return this.mHwToolbarState.isShownSettingViews(Integer.valueOf(i), Integer.valueOf(i2));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingView
    public void show(int i, int i2, View view) {
        show(i, i2, view, true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(final AnchorInfo anchorInfo, final View view, final ISettingViewManager.OnUpdatePositionListener onUpdatePositionListener) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (onUpdatePositionListener == null) {
                    HwSettingViewManager.this.updatePosition(view, anchorInfo);
                    return;
                }
                PointF pointF = new PointF(view.getX(), view.getY());
                HwSettingViewManager.this.updatePosition(view, anchorInfo);
                onUpdatePositionListener.onPositionUpdated(view, pointF, new PointF(view.getX(), view.getY()));
            }
        });
        view.requestLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateShowState(int i, int i2, boolean z, boolean z2) {
        updateShowState(i, i2, z, false, false);
    }

    public boolean hide(boolean z, int i) {
        HashMap<Integer, HwSettingLayout> map = this.mSettingMap;
        boolean z2 = false;
        if (map == null) {
            return false;
        }
        if (this.mIsBlockingHide) {
            Logger.m10999d(TAG, "hide# blocking");
            return true;
        }
        for (Map.Entry<Integer, HwSettingLayout> entry : map.entrySet()) {
            HwSettingLayout value = entry.getValue();
            if (value != null && value.isVisible() && entry.getKey().intValue() != i) {
                value.hide(z);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void show(int i, int i2, View view, boolean z) {
        View view2;
        HashMap<Integer, HwSettingLayout> map = this.mSettingMap;
        if (map == null) {
            return;
        }
        for (Map.Entry<Integer, HwSettingLayout> entry : map.entrySet()) {
            HwSettingLayout value = entry.getValue();
            if (value != null) {
                if (entry.getKey().intValue() == i2) {
                    if (view == null && (value instanceof HwSettingColorPickerLayout) && (view2 = this.mPresenter.getSettingInstance().getSettingMiniView().getView()) != null && view2.getVisibility() == 0) {
                        view = (View) view2.getParent();
                    }
                    value.show(i, view, z);
                } else {
                    value.hide(true);
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateShowState(int i, int i2, boolean z, boolean z2, boolean z3) {
        if (z) {
            this.mHwToolbarState.addShownSettingViews(Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            this.mHwToolbarState.removeShownSettingViews(Integer.valueOf(i2));
            if (!z2) {
                requestFocusToCallerView(i, this.mToolbarContainer);
            }
        }
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.onShownSettingViewsChange(this.mHwToolbarState.getShownSettingViews());
        }
        if (z3) {
            return;
        }
        View view = this.mToolbarContainer;
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).setFreezeState(this.mHwToolbarState.isShownSettingViews());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(final int i, final View view, final ISettingViewManager.OnUpdatePositionListener onUpdatePositionListener) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                HwSettingViewManager.this.mToolbarContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int dimension = (int) view.getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_margin);
                if (onUpdatePositionListener == null) {
                    HwSettingViewManager hwSettingViewManager = HwSettingViewManager.this;
                    hwSettingViewManager.updatePosition(i, hwSettingViewManager.mToolbarContainer, view, dimension);
                    return;
                }
                PointF pointF = new PointF(view.getX(), view.getY());
                HwSettingViewManager hwSettingViewManager2 = HwSettingViewManager.this;
                hwSettingViewManager2.updatePosition(i, hwSettingViewManager2.mToolbarContainer, view, dimension);
                onUpdatePositionListener.onPositionUpdated(view, pointF, new PointF(view.getX(), view.getY()));
            }
        });
        view.requestLayout();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(int i, View view) {
        setPositionLayout(i, this.mToolbarContainer, view);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(int i, View view, View view2) {
        if (view == null) {
            updateLayoutParam(i, view2);
        } else {
            setPositionLayout(i, view, view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePosition(int i, View view, View view2, int i2) {
        View view3;
        try {
            view3 = this.mToolbarManager.getView(i);
        } catch (NoSuchElementException unused) {
            view3 = view;
        }
        if (shouldDisplayOnCenter(view2)) {
            ViewAnchorUtil.updatePositionToCenter(view3, view, view2, i2);
        } else {
            ViewAnchorUtil.updatePosition(view3, view, view2, i2);
        }
    }
}
