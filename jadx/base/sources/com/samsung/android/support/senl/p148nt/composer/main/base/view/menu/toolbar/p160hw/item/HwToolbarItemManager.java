package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.Default;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.common.Policy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.IToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarItemManager implements HwToolbarItemContract, HwSettingViewManager.ToolManager, HwSettingContract.IItemView {
    protected Activity mActivity;
    protected Map<Integer, HwToolbarItem> mBtnMap;
    private final HwToolbarOrderManager.ComponentFactory mComponentFactory;
    private final ViewGroup mContainer;
    private List<List<Integer>> mExclusiveButtonsList;
    private final AbsToolbarContainerLayout mFloatingContainer;
    private HwSettingViewManager mHwSettingViewManager;
    private HwToolbarItemVisibilityManager mHwToolbarItemVisibilityManager;
    private final IHwToolbarMenu mHwToolbarMenu;
    private HwToolbarOrderManager mHwToolbarOrderManager;
    private final HwToolbarPresenterImpl mHwToolbarPresenter;
    private View mInputBlocker;
    private HwToolbarContract.QtHwToolbarStateListener mQTListener;
    private boolean mSolveMathEnabled;
    private final WritingToolManager mWritingToolManager;
    private static final String TAG = Logger.createTag("HwToolbarItemManager");
    private static final int[][] EXCLUSIVE_BUTTONS = {new int[]{2097152, 2, 2048, 4, 8, 16, 8192, 262144}, new int[]{131072, 2048, 4, 8}, new int[]{131072, 64, 16, 8192, 1024}, new int[]{64, 4, 8, 16, 8192}, new int[]{32, 64, 128, 1024, 8192, 262144}, new int[]{64, 1024, 8192, 131072, 524288, 262144}, new int[]{64, 1024, 8192}, new int[]{1024, 8192, 16}, new int[]{1024, 32, 128, 8192}, new int[]{1024, 8192, 524288}, new int[]{16385, 16387, 16389, 16393, 16407, 32769, 32771, 32773, 4, 8, 16, 8192, 262144}};
    private final List<Integer> mModeChangeExclusionButtonList = Arrays.asList(8192, 256, 512, 4096, 65536, 1048576);
    private final List<Integer> mPrimitiveButtonList = Arrays.asList(2, 2048, 4, 8, 16);
    private final List<Integer> mDeleteOnlyButtonList = Arrays.asList(4, 256, 512, 65536, 8, 4096);
    private final DefaultItemOrder.ItemInfo[] mNotSupportedItemsOnCoedit = {DefaultItemOrder.ItemInfo.Redo, DefaultItemOrder.ItemInfo.Undo, DefaultItemOrder.ItemInfo.DirectWrite, DefaultItemOrder.ItemInfo.ConvertText, DefaultItemOrder.ItemInfo.Align, DefaultItemOrder.ItemInfo.Assistance, DefaultItemOrder.ItemInfo.CleanUpAndConvertText, DefaultItemOrder.ItemInfo.AiAssist, DefaultItemOrder.ItemInfo.LaserPen, DefaultItemOrder.ItemInfo.SmartPen};
    protected HwToolbarState mHwToolbarState = new HwToolbarState();
    private boolean mCompleteShowAnimation = false;
    private View mLastView = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IHwToolbarMenu extends IToolbarMenu {
        int getColorTheme(int i);

        View getView();

        void hideDirectWrite();

        boolean isDirectWriteUsing();

        boolean isSupportDirectWrite();

        boolean isTextMode();

        void onMovePosition(View view);

        void requestItemOnToolbarMenu(View view);

        void setDirectWrite(boolean z);

        void showDirectWrite();
    }

    public HwToolbarItemManager(Activity activity, AbsToolbarContainerLayout absToolbarContainerLayout, FloaterContainer floaterContainer, ViewGroup viewGroup, HwToolbarPresenterImpl hwToolbarPresenterImpl, IHwToolbarMenu iHwToolbarMenu, @NonNull HwToolbarOrderManager.ComponentFactory componentFactory) {
        this.mActivity = activity;
        this.mContainer = viewGroup;
        this.mFloatingContainer = absToolbarContainerLayout;
        if (absToolbarContainerLayout instanceof AllSideToolbarContainerLayout) {
            ((AllSideToolbarContainerLayout) absToolbarContainerLayout).setContract(new AllSideToolbarContainerLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout.Contract
                public void updateToolbarItemList() {
                    HwToolbarItemManager.this.updateToolbarItemList();
                }
            });
        }
        this.mHwToolbarPresenter = hwToolbarPresenterImpl;
        hwToolbarPresenterImpl.getMRemoteHwSettingPresenter().setItemView(this);
        WritingToolManager writingToolManager = hwToolbarPresenterImpl.getWritingToolManager();
        this.mWritingToolManager = writingToolManager;
        this.mHwToolbarMenu = iHwToolbarMenu;
        this.mComponentFactory = componentFactory;
        this.mHwSettingViewManager = createSettingViewManager();
        initItemLayout();
        initExclusiveBtn();
        initToolbarItemsVisibility();
        updateCollaborationViewSupportedMenuItemList();
        hwToolbarPresenterImpl.updateUndoRedoMenu();
        this.mHwSettingViewManager.init(absToolbarContainerLayout, floaterContainer, this, writingToolManager, this.mHwToolbarState, hwToolbarPresenterImpl);
        setSolveMathEnabled(hwToolbarPresenterImpl.isSolveMathEnabled());
    }

    private void dismissSmartTipPopup(int i) {
        HwToolbarItem hwToolbarItem;
        if (this.mBtnMap.containsKey(Integer.valueOf(i)) && (hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i))) != null) {
            hwToolbarItem.dismissSmartTipPopup();
        }
    }

    private HwToolbarSmartPen getHwToolbarSmartPen() {
        return getVisibilityManager().getVisibleSmartPen();
    }

    private HwToolbarItemVisibilityManager getVisibilityManager() {
        if (this.mHwToolbarItemVisibilityManager == null) {
            this.mHwToolbarItemVisibilityManager = new HwToolbarItemVisibilityManager(this.mHwToolbarPresenter, this.mHwToolbarMenu, this.mActivity, this.mBtnMap);
        }
        return this.mHwToolbarItemVisibilityManager;
    }

    private void initExclusiveBtn() {
        this.mExclusiveButtonsList = new ArrayList();
        for (int[] iArr : EXCLUSIVE_BUTTONS) {
            ArrayList arrayList = new ArrayList();
            int length = iArr.length;
            for (int iM1200a = 0; iM1200a < length; iM1200a = AbstractC1038a.m1200a(iArr[iM1200a], iM1200a, 1, arrayList)) {
            }
            this.mExclusiveButtonsList.add(arrayList);
        }
    }

    private boolean isSupportLockCanvasPadMenu() {
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        if (!companion.getInstance().isDexMode(this.mActivity) || companion.getInstance().isDexStandAloneMode(this.mActivity)) {
            return true;
        }
        return !companion.getInstance().isDexDualModeOnScreen(this.mActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$applyToolbarEnabledState$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toolbarMovePosition$0(View view) {
        this.mHwToolbarMenu.onMovePosition(view);
    }

    private void restoreToUpdateDirectWrite() {
        if (!this.mHwToolbarPresenter.isTabletLayout() || this.mHwToolbarPresenter.isPdfReader()) {
            return;
        }
        if (this.mHwToolbarMenu.isTextMode()) {
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(65536);
            if (hwToolbarItem == null || hwToolbarItem.isSelected()) {
                return;
            }
            clearAllToolbarItem(8192, 4096);
            hwToolbarItem.setSelected(true);
            return;
        }
        HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(8192);
        if (hwToolbarItem2 == null || !hwToolbarItem2.isSelected()) {
            return;
        }
        hwToolbarItem2.setSelected(false);
        HwToolbarItem hwToolbarItem3 = this.mBtnMap.get(2);
        if (hwToolbarItem3 != null) {
            hwToolbarItem3.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreViews(Bundle bundle) {
        requestItemOnToolbarMenu(this.mLastView);
        if (this.mHwSettingViewManager == null) {
            return;
        }
        HashMap map = new HashMap(this.mHwToolbarState.getShownSettingViews());
        this.mHwToolbarState.clearShownSettingViews();
        for (Map.Entry entry : map.entrySet()) {
            this.mHwSettingViewManager.show(((Integer) entry.getValue()).intValue(), ((Integer) entry.getKey()).intValue());
        }
        this.mHwSettingViewManager.restoreColorSpoid();
        this.mHwSettingViewManager.restoreAddFavoritePen(bundle);
    }

    private void restoreViewsAfterLaidOut(final Bundle bundle) {
        ViewGroup viewGroup = this.mContainer;
        if (viewGroup == null || viewGroup.isLaidOut()) {
            restoreViews(bundle);
        } else {
            this.mContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    HwToolbarItemManager.this.mContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    HwToolbarItemManager.this.restoreViews(bundle);
                }
            });
        }
    }

    private void runShowAnimation() {
        if (!this.mContainer.canScrollHorizontally(1) && !this.mContainer.canScrollHorizontally(-1)) {
            showSmartTip();
            Logger.m10999d(TAG, "show : not scrollable");
            return;
        }
        View childAt = this.mContainer.getChildAt(0);
        if (childAt == null) {
            Logger.m10999d(TAG, "show : child is null");
            return;
        }
        float width = this.mContainer.getWidth() - childAt.getWidth();
        if (LocaleUtils.isRTLMode()) {
            width = -width;
            this.mContainer.scrollTo(childAt.getWidth(), 0);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(width, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new PathInterpolator(0.66f, 0.0f, 0.34f, 1.0f));
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarItemManager.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                HwToolbarItemManager.this.showSmartTip();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        childAt.startAnimation(translateAnimation);
    }

    private void showSmartTipPopup(int i) {
        HwToolbarItem hwToolbarItem;
        if (this.mBtnMap.containsKey(Integer.valueOf(i)) && (hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i))) != null) {
            hwToolbarItem.showSmartTipPopup();
        }
    }

    private void updateCollaborationViewSupportedMenuItemList() {
        if (this.mBtnMap == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, HwToolbarItem> entry : this.mBtnMap.entrySet()) {
            if (entry.getValue().getView().getVisibility() == 0) {
                arrayList.add(entry.getKey());
            }
        }
        Logger.m10999d(TAG, "updateCollaborationViewSupportedMenuItemList# size : " + arrayList.size());
        this.mHwToolbarPresenter.setCollaborationViewSupportedMenuIdList(arrayList);
    }

    private void updateRTLLayout() {
        if (this.mBtnMap == null || this.mActivity.getResources().getConfiguration().getLayoutDirection() != 1) {
            return;
        }
        Iterator<HwToolbarItem> it = this.mBtnMap.values().iterator();
        while (it.hasNext()) {
            View view = it.next().getView();
            if (view.getVisibility() == 8 && view.getLayoutDirection() != 1) {
                view.setLayoutDirection(1);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void applyToolbarEnabledState(boolean z) {
        if (this.mInputBlocker == null) {
            View viewFindViewById = this.mFloatingContainer.findViewById(C9086R.id.hw_toolbar_input_blocker);
            this.mInputBlocker = viewFindViewById;
            if (viewFindViewById == null) {
                return;
            } else {
                viewFindViewById.setOnTouchListener(new ViewOnTouchListenerC7005f(15));
            }
        }
        this.mInputBlocker.setVisibility(z ? 8 : 0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void checkValidQuickColorItem(int i) {
        for (HwToolbarConstants.QUICK_COLOR quick_color : HwToolbarConstants.QUICK_COLOR.values()) {
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(quick_color.constant));
            if (hwToolbarItem != null && hwToolbarItem.isSelected() && !this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickColorData().isEqualsExceptAlpha(quick_color.ordinal(), i)) {
                hwToolbarItem.unselect();
                return;
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void checkValidQuickSizeItem(int i) {
        for (HwToolbarConstants.QUICK_SIZE quick_size : HwToolbarConstants.QUICK_SIZE.values()) {
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(quick_size.constant));
            if (hwToolbarItem != null && hwToolbarItem.isSelected() && !this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickSizeData().isEquals(quick_size.ordinal(), i)) {
                hwToolbarItem.unselect();
                return;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void clearAllToolbarItem(int... iArr) {
        Logger.m10999d(TAG, "clearAllToolbarItem");
        Map<Integer, HwToolbarItem> map = this.mBtnMap;
        if (map == null) {
            return;
        }
        for (Map.Entry<Integer, HwToolbarItem> entry : map.entrySet()) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    int i2 = iArr[i];
                    if (entry.getKey().intValue() == i2) {
                        AbstractC0000a.m3D(i2, "clearAllToolbarItem except menu id ", TAG);
                        break;
                    }
                    i++;
                } else {
                    if (8192 == entry.getKey().intValue() && entry.getValue().isSelected()) {
                        entry.getValue().functionEnable(false);
                        updateLastPenTypeSelectionState();
                    }
                    entry.getValue().setSelected(false);
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void clearContextMenu() {
        HwToolbarPresenterImpl hwToolbarPresenterImpl = this.mHwToolbarPresenter;
        if (hwToolbarPresenterImpl != null) {
            hwToolbarPresenterImpl.clearContextMenu();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void clearQuickTypeItem() {
        Logger.m10999d(TAG, "clearQuickTypeItem");
        for (HwToolbarConstants.QUICK_COLOR quick_color : HwToolbarConstants.QUICK_COLOR.values()) {
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(quick_color.constant));
            if (hwToolbarItem != null && hwToolbarItem.isSelected()) {
                hwToolbarItem.setSelected(false);
            }
        }
        for (HwToolbarConstants.QUICK_SIZE quick_size : HwToolbarConstants.QUICK_SIZE.values()) {
            HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(Integer.valueOf(quick_size.constant));
            if (hwToolbarItem2 != null && hwToolbarItem2.isSelected()) {
                hwToolbarItem2.setSelected(false);
            }
        }
    }

    public void clearSelectedButtonsToolbarItem() {
        Logger.m10999d(TAG, "clearSelectedButtonsToolbarItem");
        Map<Integer, HwToolbarItem> map = this.mBtnMap;
        if (map == null) {
            return;
        }
        for (Map.Entry<Integer, HwToolbarItem> entry : map.entrySet()) {
            HwToolbarItem value = entry.getValue();
            if (value.isSelected() || entry.getKey().intValue() == 4096) {
                value.setSelected(false);
            }
        }
        updatePolicy(0, false);
    }

    public void closeHandwritingSpecialButtons(int[] iArr) {
        HwToolbarItem hwToolbarItem;
        for (int i : iArr) {
            if (this.mBtnMap.containsKey(Integer.valueOf(i)) && (hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i))) != null) {
                hwToolbarItem.setSelected(false);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public boolean correctSelectionMenu(HwToolbarState hwToolbarState) {
        if (!this.mHwToolbarPresenter.isTabletLayout()) {
            return false;
        }
        List<Integer> selectedMenu = hwToolbarState.getSelectedMenu();
        if (selectedMenu.isEmpty()) {
            return false;
        }
        LinkedHashMap<Integer, HwToolbarItem> candidateItemList = this.mHwToolbarOrderManager.getCandidateItemList(this);
        if (candidateItemList.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (Integer num : selectedMenu) {
            HwToolbarItem hwToolbarItem = candidateItemList.get(num);
            if (hwToolbarItem != null) {
                Logger.m11003i(TAG, "correctSelectionMenu function disable " + num);
                hwToolbarItem.functionEnable(false);
                z = true;
            }
        }
        return z;
    }

    public HwSettingViewManager createSettingViewManager() {
        return new HwSettingViewManager();
    }

    public void dismissSmartTip() {
        dismissSmartTipPopup(32);
        dismissSmartTipPopup(128);
        dismissSmartTipPopup(524288);
        dismissSmartTipPopup(262144);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void doActionAfterDismissKeyguard(@NonNull Runnable runnable) {
        this.mHwToolbarPresenter.getKeyguardPresenter().dismissKeyguard(this.mActivity, runnable);
    }

    public void enableEasyWritingPadMenu(boolean z) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(1024);
        if (hwToolbarItem == null) {
            return;
        }
        if (!z) {
            hwToolbarItem.setSelected(false);
        }
        hwToolbarItem.setEnable(z);
    }

    public void enableLockCanvasPadMenu(boolean z) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(4096);
        if (hwToolbarItem == null) {
            return;
        }
        if (!z) {
            hwToolbarItem.setSelected(false);
        }
        hwToolbarItem.setEnable(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void enableMenus(boolean z, List<Integer> list) {
        for (Integer num : list) {
            num.intValue();
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(num);
            if (hwToolbarItem != null) {
                hwToolbarItem.setEnable(z);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void executeAiAssist() {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(1048576);
        if (hwToolbarItem != null) {
            hwToolbarItem.onClick();
        }
    }

    public void executePenSetting() {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(2);
        HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(2048);
        if (hwToolbarItem != null && hwToolbarItem.isSelected()) {
            ((HwToolbarPen) hwToolbarItem).showSettingView();
        } else {
            if (hwToolbarItem2 == null || !hwToolbarItem2.isSelected()) {
                return;
            }
            ((HwToolbarHighlighter) hwToolbarItem2).showSettingView();
        }
    }

    public void executeRemoteEraser() {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(4);
        if (hwToolbarItem == null) {
            return;
        }
        if (!hwToolbarItem.isSelected()) {
            hwToolbarItem.onClick();
            return;
        }
        HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(Integer.valueOf(this.mHwToolbarState.getLastPenType()));
        if (hwToolbarItem2 != null) {
            hwToolbarItem2.onClick();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.ToolManager
    public int getAnchorPosition(int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
        if (hwToolbarItem == null) {
            return 0;
        }
        return hwToolbarItem.getViewCenterPosition();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public int getColorTheme(int i) {
        return this.mHwToolbarMenu.getColorTheme(i);
    }

    public int getDeltaToAvoidOverlap(int i, int i2) {
        int i4;
        Iterator<HwToolbarItem> it = this.mBtnMap.values().iterator();
        while (it.hasNext()) {
            int[] horizonOnScreen = it.next().getHorizonOnScreen(i2);
            int i5 = horizonOnScreen[0];
            if (i5 < i && i < (i4 = horizonOnScreen[2])) {
                return horizonOnScreen[1] > i ? i5 - i : i4 - i;
            }
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public List<Integer> getDisabledMenus() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, HwToolbarItem> entry : this.mBtnMap.entrySet()) {
            if (!entry.getValue().mView.isEnabled()) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    /* JADX INFO: renamed from: getHwSettingViewManager */
    public HwSettingViewManager getMInAppSettingViewManager() {
        return this.mHwSettingViewManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public HwToolbarPresenterImpl getHwToolbarPresenter() {
        return this.mHwToolbarPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public HwToolbarState getHwToolbarState() {
        return this.mHwToolbarState;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public HwSettingPresenter getSettingInstance() {
        return this.mHwToolbarPresenter.getMRemoteHwSettingPresenter();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.ToolManager
    public View getView(int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
        if (hwToolbarItem != null) {
            return hwToolbarItem.getView();
        }
        throw new NoSuchElementException("Not found item view");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public WritingToolManager getWritingToolManager() {
        return this.mWritingToolManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public boolean hide() {
        if (this.mHwSettingViewManager == null || !this.mHwToolbarState.isShownSettingViews()) {
            return false;
        }
        this.mHwSettingViewManager.hide();
        return true;
    }

    public void hideAll() {
        if (this.mHwSettingViewManager == null) {
            return;
        }
        if (this.mHwToolbarState.isColorSpoidEnable()) {
            this.mHwSettingViewManager.hideColorSpoid();
        } else {
            hide();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void hideDirectWrite() {
        this.mHwToolbarMenu.hideDirectWrite();
        this.mHwToolbarPresenter.dismissDirectWriteSettingDialog();
    }

    public void initItemLayout() {
        if (this.mHwToolbarOrderManager == null) {
            this.mHwToolbarOrderManager = new HwToolbarOrderManager(this.mContainer, this.mFloatingContainer, this.mHwToolbarPresenter, this.mComponentFactory);
        }
        ViewGroup viewGroup = this.mContainer;
        if ((viewGroup instanceof ConstraintLayout) || (viewGroup instanceof LinearLayout)) {
            if (this.mHwToolbarPresenter.isCoeditNote()) {
                this.mBtnMap = this.mHwToolbarOrderManager.buildItemViewByOrder(this, this.mNotSupportedItemsOnCoedit);
            } else {
                this.mBtnMap = this.mHwToolbarOrderManager.buildItemViewByOrder(this, new DefaultItemOrder.ItemInfo[0]);
            }
        }
        this.mHwToolbarOrderManager.updateOrientation();
        updateHwSettingView(this.mActivity.getResources().getConfiguration().orientation);
    }

    public void initToolbarItemsVisibility() {
        HwToolbarItemVisibilityManager hwToolbarItemVisibilityManager = new HwToolbarItemVisibilityManager(this.mHwToolbarPresenter, this.mHwToolbarMenu, this.mActivity, this.mBtnMap);
        this.mHwToolbarItemVisibilityManager = hwToolbarItemVisibilityManager;
        hwToolbarItemVisibilityManager.initToolbarItemsVisibility();
        this.mHwToolbarOrderManager.hideDividerIfNecessary();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public boolean isAssistanceSelected() {
        HwToolbarItem hwToolbarItem;
        Map<Integer, HwToolbarItem> map = this.mBtnMap;
        return (map == null || (hwToolbarItem = map.get(131072)) == null || !hwToolbarItem.isSelected()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public boolean isDirectWriteUsing() {
        return this.mHwToolbarMenu.isDirectWriteUsing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public boolean isSelected(int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
        if (hwToolbarItem == null) {
            return false;
        }
        return hwToolbarItem.isSelected();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public boolean isSolveMathEnabled() {
        return this.mSolveMathEnabled;
    }

    public boolean isSupportEasyWritingPad(boolean z) {
        boolean zIsMultiWindowMode = WindowManagerCompat.getInstance().isMultiWindowMode(this.mActivity);
        boolean zIsTabletLayout = this.mHwToolbarPresenter.isTabletLayout();
        if (!zIsMultiWindowMode && !zIsTabletLayout && z) {
            return false;
        }
        int dimension = (int) this.mActivity.getResources().getDimension(C9086R.dimen.composer_hw_toolbar_easy_write_minimum_height);
        Integer windowHeight = DisplayUtils.getWindowHeight(this.mActivity);
        return windowHeight != null && windowHeight.intValue() > dimension;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public boolean isTextMode() {
        return this.mHwToolbarPresenter.isTextMode();
    }

    public boolean onBackPressed(boolean z) {
        return this.mHwSettingViewManager.onBackPressed(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        updateHwSettingView(configuration.orientation);
        this.mHwToolbarOrderManager.updateGapMargin();
        updateSupportedDirectWriteMenu();
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.onConfigurationChanged();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void onItemClickSALogging(int i) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onItemSelected(int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
        if (hwToolbarItem != null) {
            hwToolbarItem.onItemSelected();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onObjectChanged() {
        Logger.m10999d(TAG, "onObjectChanged");
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(256);
        if (hwToolbarItem != null) {
            ((HwToolbarUndo) hwToolbarItem).onObjectChanged();
        }
        HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(512);
        if (hwToolbarItem2 != null) {
            ((HwToolbarRedo) hwToolbarItem2).onObjectChanged();
        }
    }

    public void onOrientationChanged(int i, int i2) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public boolean onPreClick(int i) {
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.onPreClick(i);
        }
        return this.mHwToolbarPresenter.onPreClick(i);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        HwToolbarState hwToolbarState = new HwToolbarState();
        hwToolbarState.copyData(this.mHwToolbarState);
        bundle.putParcelable(TAG, hwToolbarState);
        this.mHwSettingViewManager.saveAddFavoritePen(bundle);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void onSelected(int i) {
        onSelected(i, true);
    }

    public void onShown() {
        if (getHwToolbarSmartPen() != null) {
            return;
        }
        HwToolbarCleanUpAndConvertText hwToolbarCleanUpAndConvertText = (HwToolbarCleanUpAndConvertText) this.mBtnMap.get(524288);
        if (hwToolbarCleanUpAndConvertText != null) {
            hwToolbarCleanUpAndConvertText.introAnimation();
        }
        HwToolbarAiAssist hwToolbarAiAssist = (HwToolbarAiAssist) this.mBtnMap.get(1048576);
        if (hwToolbarAiAssist != null) {
            hwToolbarAiAssist.introAnimation();
        }
    }

    public void onUpdateToolbarItem() {
        SpenSettingUIPenInfo settingPenInfoSelected = this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenInfoData().getSettingPenInfoSelected();
        onUpdatedPen(settingPenInfoSelected.name, settingPenInfoSelected.color);
        SpenSettingUIPenInfo settingHighlighterInfoSelected = this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getHighlighterData().getSettingHighlighterInfoSelected();
        onUpdatedHighlighter(settingHighlighterInfoSelected.name, settingHighlighterInfoSelected.color);
        onUpdatedStyle(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getChangeStyleData().getChangeStyleInfo().color);
        onUpdatedSelection(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getSelectionInfoData().getSettingSelectionInfo().type);
        if (this.mHwToolbarPresenter.isTabletLayout() || DeviceInfo.isVSTModel()) {
            onUpdateToolbarQuickItem();
        }
    }

    public void onUpdateToolbarQuickItem() {
        for (HwToolbarConstants.QUICK_COLOR quick_color : HwToolbarConstants.QUICK_COLOR.values()) {
            onUpdatedQuickColor(quick_color.ordinal(), this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickColorData().getQuickColor(quick_color.ordinal()));
        }
        for (HwToolbarConstants.QUICK_SIZE quick_size : HwToolbarConstants.QUICK_SIZE.values()) {
            onUpdatedQuickSize(quick_size.ordinal(), this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickSizeData().getSize(quick_size.ordinal()));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdateToolbarSelectionState(int i) {
        updateSelectionState(i, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.ToolManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedHighlighter(String str, int i) {
        HwToolbarItem hwToolbarItem;
        Logger.m10999d(TAG, "onUpdatedHighlighter penType : " + str + ", color : " + i);
        Default.Highlighter highlighterFind = Default.Highlighter.find(str);
        if (highlighterFind == null || (hwToolbarItem = this.mBtnMap.get(2048)) == null) {
            return;
        }
        ((HwToolbarHighlighter) hwToolbarItem).updateSettingMenu(highlighterFind.getDefault(), i);
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.notifyToUpdateInfo();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedLaserPen(Pair<Integer, Integer> pair) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(262144);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarLaserPen) hwToolbarItem).updateSettingMenu(pair);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.ToolManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedPen(String str, int i) {
        HwToolbarItem hwToolbarItem;
        Logger.m10999d(TAG, "onUpdatedPen penType : " + str + ", color : " + i);
        Default.Pen penFind = Default.Pen.find(str);
        if (penFind == null || (hwToolbarItem = this.mBtnMap.get(2)) == null) {
            return;
        }
        ((HwToolbarPen) hwToolbarItem).updateSettingMenu(penFind.getDefault(), i);
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.notifyToUpdateInfo();
        }
    }

    public void onUpdatedQuickColor(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "onUpdatedQuickColor index : ", ", color : ", TAG);
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(HwToolbarConstants.QUICK_COLOR.values()[i].constant));
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarQuickColor) hwToolbarItem).updateUIColor(i2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedQuickSize(int i, int i2) {
        AbstractC8014b.m7216r(i, i2, "onUpdatedQuickSize index : ", ", sizeLevel : ", TAG);
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(HwToolbarConstants.QUICK_SIZE.values()[i].constant));
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarQuickSize) hwToolbarItem).updateUISize(i2);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.ToolManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedSelection(int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(8);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarSelection) hwToolbarItem).updateSettingMenu(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedSmartPen(int i, int i2) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(4194304);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarSmartPen) hwToolbarItem).updateSelectedMenu(i, i2, false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.setting.HwSettingViewManager.ToolManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedStyle(int i) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(16);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarStyle) hwToolbarItem).updateSettingMenu(i);
    }

    public void onWindowFocusChanged() {
        updateSupportedDirectWriteMenu();
    }

    public void release() {
        HwSettingViewManager hwSettingViewManager = this.mHwSettingViewManager;
        if (hwSettingViewManager != null) {
            hwSettingViewManager.close();
            this.mHwSettingViewManager = null;
        }
        if (this.mHwToolbarPresenter.getMRemoteHwSettingPresenter() != null) {
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().release();
        }
        Map<Integer, HwToolbarItem> map = this.mBtnMap;
        if (map != null) {
            Iterator<HwToolbarItem> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
    }

    public void reloadItemOrderLayout() {
        initItemLayout();
        initToolbarItemsVisibility();
        updateSelectionState(2, false);
        updateSettingInfo();
        this.mHwToolbarPresenter.updateUndoRedoMenu();
        updateTextMode(isTextMode());
        updateRTLLayout();
        setSolveMathEnabled(this.mHwToolbarPresenter.isSolveMathEnabled());
    }

    public void requestItemOnToolbarMenu(View view) {
        this.mHwToolbarMenu.requestItemOnToolbarMenu(view);
    }

    public void restore(Bundle bundle) {
        String str = TAG;
        HwToolbarState hwToolbarState = (HwToolbarState) bundle.getParcelable(str);
        if (hwToolbarState == null) {
            Logger.m10999d(str, "restore savedHWToolbarState is null");
        } else {
            restoreHwToolbarState(hwToolbarState);
            restoreViewsAfterLaidOut(bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void restoreHwToolbarState(HwToolbarState hwToolbarState) {
        HwSettingViewManager hwSettingViewManager = this.mHwSettingViewManager;
        if (hwSettingViewManager == null) {
            return;
        }
        this.mHwToolbarState = hwToolbarState;
        hwSettingViewManager.setHwToolbarState(hwToolbarState);
        List<Integer> selectedMenu = this.mHwToolbarState.getSelectedMenu();
        ArrayList<Integer> arrayList = new ArrayList(selectedMenu);
        clearSelectedButtonsToolbarItem();
        selectedMenu.clear();
        this.mLastView = null;
        for (Integer num : arrayList) {
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(num);
            if (hwToolbarItem != null) {
                if (num.intValue() == 1024) {
                    if (isSupportEasyWritingPad(this.mActivity.getResources().getConfiguration().orientation == 2)) {
                        enableEasyWritingPadMenu(true);
                        if (this.mLastView == null) {
                            this.mLastView = hwToolbarItem.getView();
                        }
                        hwToolbarItem.setSelected(true);
                        updateSelectionState(num.intValue(), false);
                    }
                } else if (num.intValue() == 8192) {
                    if (this.mHwToolbarMenu.isSupportDirectWrite()) {
                        if (this.mLastView == null) {
                        }
                        hwToolbarItem.setSelected(true);
                        updateSelectionState(num.intValue(), false);
                    }
                } else if (num.intValue() != 4096) {
                    if (this.mLastView == null) {
                    }
                    hwToolbarItem.setSelected(true);
                    updateSelectionState(num.intValue(), false);
                }
            }
        }
        updateZoomLock();
        restoreToUpdateDirectWrite();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void setDirectWrite(boolean z) {
        this.mHwToolbarMenu.setDirectWrite(z);
    }

    public void setEnableToolTip(boolean z) {
        for (HwToolbarItem hwToolbarItem : this.mBtnMap.values()) {
            ViewCompat.getInstance().setTooltipText(hwToolbarItem.getView(), z ? hwToolbarItem.getView().getContentDescription() : "");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void setMenuDirty() {
        this.mHwToolbarPresenter.setMenuDirty();
    }

    public void setOnUpdateQuickToolListener(HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener) {
        this.mQTListener = qtHwToolbarStateListener;
        HwSettingViewManager hwSettingViewManager = this.mHwSettingViewManager;
        if (hwSettingViewManager != null) {
            hwSettingViewManager.setQtHwToolbarStateListener(qtHwToolbarStateListener);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void setSelectMenu(int i, boolean z) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(Integer.valueOf(i));
        if (hwToolbarItem != null) {
            hwToolbarItem.setSelected(z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void setSolveMathEnabled(boolean z) {
        if (DeviceInfo.isVSTModel() || this.mBtnMap == null) {
            return;
        }
        this.mSolveMathEnabled = z;
        AbstractC8014b.m7220v("setSolveMathEnabled enabled ", TAG, z);
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(131072);
        if (hwToolbarItem instanceof HwToolbarAssistance) {
            HwToolbarAssistance hwToolbarAssistance = (HwToolbarAssistance) hwToolbarItem;
            if (z) {
                hwToolbarAssistance.unselect();
                hwToolbarAssistance.functionEnable(false);
                getHwToolbarState().setLastStateHandwritingHelp(false);
            }
            hwToolbarAssistance.setDisabledByMathSolver(z);
        }
    }

    public void show() {
        if (this.mCompleteShowAnimation || this.mContainer == null) {
            return;
        }
        this.mCompleteShowAnimation = true;
        runShowAnimation();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void showAiAssistMenu(View view) {
        int dockingType = this.mFloatingContainer.getDockingType();
        this.mHwToolbarPresenter.showAiAssistMenu(view, dockingType != 0 ? dockingType != 1 ? dockingType != 2 ? dockingType != 3 ? this.mFloatingContainer.hasStoredRotate() ? AnchorPosition.FLOATING_ROTATE : AnchorPosition.FLOATING : LocaleUtils.isRTLMode() ? AnchorPosition.LEFT : AnchorPosition.RIGHT : LocaleUtils.isRTLMode() ? AnchorPosition.RIGHT : AnchorPosition.LEFT : AnchorPosition.BOTTOM : AnchorPosition.TOP);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void showCleanUpAndCTT() {
        this.mHwToolbarPresenter.showCleanUpAndCTT();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void showDirectWrite() {
        this.mHwToolbarMenu.showDirectWrite();
    }

    public void showSmartTip() {
        showSmartTipPopup(32);
        showSmartTipPopup(128);
        showSmartTipPopup(524288);
        showSmartTipPopup(262144);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void showToolTypeActionPen() {
        Logger.m10999d(TAG, "showToolTypeActionPen");
        updateLastPenTypeSelectionState();
        this.mHwToolbarPresenter.updatedLastPenInfo();
        closeHandwritingSpecialButtons(new int[]{64});
    }

    public void toggleZoomLock() {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(4096);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarLockCanvas) hwToolbarItem).toggleLockCanvas();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void toolbarMovePosition(View view) {
        if (view != null) {
            view.post(new RunnableC9844c(this, view, 23));
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateAlignment(boolean z) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(128);
        if (hwToolbarItem == null) {
            return;
        }
        hwToolbarItem.setSelected(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateAssistance(boolean z) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(131072);
        if (hwToolbarItem == null) {
            return;
        }
        if ((getHwToolbarSmartPen() != null && this.mHwToolbarState.isShownSettingViews(65536)) || this.mHwToolbarState.isShownSettingViews(16384) || !isSelected(2) || isSelected(1024) || isSelected(64)) {
            return;
        }
        hwToolbarItem.setSelected(z && (hwToolbarItem.isSelected() || this.mHwToolbarState.isLastStateHandwritingHelp()));
    }

    public void updateDeleteOnlyState(boolean z) {
        boolean z2 = !z;
        for (Map.Entry<Integer, HwToolbarItem> entry : this.mBtnMap.entrySet()) {
            if (!this.mDeleteOnlyButtonList.contains(entry.getKey())) {
                entry.getValue().setEnable(z2);
                if (z && entry.getValue().isSelected()) {
                    onSelected(4);
                }
            }
        }
    }

    public void updateDirectWrite() {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(8192);
        if (hwToolbarItem == null) {
            return;
        }
        HwToolbarSmartPen hwToolbarSmartPen = getHwToolbarSmartPen();
        if (hwToolbarSmartPen != null) {
            hwToolbarSmartPen.updateDirectWrite();
        } else {
            ((HwToolbarDirectWrite) hwToolbarItem).updateDirectWrite();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateEasyWritingPad(boolean z) {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(1024);
        if (hwToolbarItem == null) {
            return;
        }
        hwToolbarItem.setSelected(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updateHighlighterSettingInfo() {
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.notifyToUpdateInfo();
        }
        this.mHwToolbarState.setLastPenType(2048);
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().updateHighlighterSettingInfo();
    }

    public void updateHwSettingView(int i) {
        enableEasyWritingPadMenu(isSupportEasyWritingPad(2 == i));
        enableLockCanvasPadMenu(isSupportLockCanvasPadMenu());
        HwSettingViewManager hwSettingViewManager = this.mHwSettingViewManager;
        if (hwSettingViewManager != null) {
            hwSettingViewManager.updateLayout();
        }
        updateSmartTipPopup();
    }

    public void updateItemLayout(int i) {
        this.mHwToolbarOrderManager.updateItemLayout(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateLastPenTypeSelectionState() {
        updateSelectionState(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().getSelectedPenTypeItem(), false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updateLastPrimitiveTypeSelectionState() {
        if (isTextMode()) {
            return;
        }
        updateSelectionState(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().getSelectedPrimitiveTypeItem(), false);
    }

    public void updatePenColorWithLastPenInfoInNote() {
        SpenSettingUIPenInfo lastPenInfoInNote = this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getLastPenInfoInNote();
        if (lastPenInfoInNote != null) {
            if (this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().isHighlighterType(lastPenInfoInNote)) {
                this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getHighlighterData().setSettingHighlighterInfo(lastPenInfoInNote);
                onUpdatedHighlighter(lastPenInfoInNote.name, lastPenInfoInNote.color);
            } else {
                this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getPenInfoData().setSettingPenInfo(lastPenInfoInNote);
                onUpdatedPen(lastPenInfoInNote.name, lastPenInfoInNote.color);
            }
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().clearLastPenInfoInNote();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updatePenSettingInfo() {
        HwToolbarContract.QtHwToolbarStateListener qtHwToolbarStateListener = this.mQTListener;
        if (qtHwToolbarStateListener != null) {
            qtHwToolbarStateListener.notifyToUpdateInfo();
        }
        this.mHwToolbarState.setLastPenType(2);
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().updatePenSettingInfo();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updatePolicy(int i, boolean z) {
        Logger.m10999d(TAG, "updatePolicy updateViewId/enable " + i + "/" + z);
        for (Map.Entry<Integer, HwToolbarItem> entry : this.mBtnMap.entrySet()) {
            Policy policy = this.mHwToolbarPresenter.getHWToolbarPolicyManager().getPolicy(entry.getKey().intValue());
            policy.setAction(z ? Policy.Action.ENABLED : Policy.Action.DISABLED);
            entry.getValue().setPolicy(i, policy);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updateQuickColor(int i) {
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().applyQuickColor(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickColorData().getQuickHSVColor(HwToolbarConstants.QUICK_COLOR.getOrdinal(i)));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updateQuickSize(int i) {
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().applyQuickSize(this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickSizeData().getSize(HwToolbarConstants.QUICK_SIZE.getOrdinal(i)));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateRedoMenu(boolean z) {
        AbstractC8014b.m7220v("updateRedoMenu : ", TAG, z);
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(512);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarRedo) hwToolbarItem).updateUndoRedoMenu(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateSelectionMode() {
        clearAllToolbarItem(new int[0]);
        setSelectMenu(8, true);
    }

    public void updateSelectionState(int i, boolean z) {
        if (z) {
            this.mWritingToolManager.clearSelection();
        }
        boolean z2 = false;
        for (List<Integer> list : this.mExclusiveButtonsList) {
            if (list.contains(Integer.valueOf(i))) {
                for (Integer num : list) {
                    HwToolbarItem hwToolbarItem = this.mBtnMap.get(num);
                    if (hwToolbarItem != null) {
                        boolean z3 = i == num.intValue();
                        if (hwToolbarItem.setSelected(z3)) {
                            if (!z3) {
                                hwToolbarItem.functionEnable(false);
                            } else if (!z2) {
                                hwToolbarItem.functionEnable(true);
                                z2 = true;
                            }
                        }
                    }
                }
            }
        }
        HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(Integer.valueOf(i));
        if (z2 || hwToolbarItem2 == null) {
            return;
        }
        hwToolbarItem2.setSelected(true);
    }

    public void updateSettingInfo() {
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().updateSettingInfo();
    }

    public void updateSmartTipPopup() {
        for (HwToolbarItem hwToolbarItem : this.mBtnMap.values()) {
            if (hwToolbarItem != null && hwToolbarItem.isShowingSmartTipPopup()) {
                hwToolbarItem.updateSmartTipPopup();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateStateSelected(int i, boolean z) {
        if (!z) {
            this.mHwToolbarState.removeSelectedMenu(Integer.valueOf(i));
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().removeSelectedMenu(i);
            return;
        }
        this.mHwToolbarState.addSelectedMenu(Integer.valueOf(i));
        this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().addSelectedMenu(i);
        if (this.mPrimitiveButtonList.contains(Integer.valueOf(i))) {
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().setSelectedPrimitiveTypeItem(i);
        }
        if (i == 2 || i == 2048) {
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().setSelectedPenTypeItem(i);
        }
    }

    public void updateSupportedDirectWriteMenu() {
        if ((!this.mHwToolbarMenu.isSupportDirectWrite() || !this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().isEnabledSpenToText()) && isSelected(8192)) {
            onSelected(2);
        }
        getVisibilityManager().updateVisibleDirectWriteMenu();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateTextMode(boolean z) {
        AbstractC8014b.m7220v("updateTextMode :", TAG, z);
        if (z) {
            clearAllToolbarItem(65536, 8192, 4096);
            updateDirectWrite();
        }
        setSelectMenu(65536, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updateToolbarItemList() {
        HwToolbarState hwToolbarState = new HwToolbarState();
        hwToolbarState.copyData(this.mHwToolbarState);
        clearSelectedButtonsToolbarItem();
        reloadItemOrderLayout();
        if (!this.mBtnMap.containsKey(131072)) {
            hwToolbarState.setLastStateHandwritingHelp(false);
        }
        if (!this.mBtnMap.containsKey(4096)) {
            getHwToolbarPresenter().getMRemoteHwSettingPresenter().setZoomState(false);
        }
        Iterator<Integer> it = hwToolbarState.getSelectedMenu().iterator();
        while (true) {
            if (!it.hasNext()) {
                hwToolbarState.addSelectedMenu(2);
                break;
            }
            Integer next = it.next();
            next.intValue();
            if (this.mBtnMap.containsKey(next)) {
                break;
            }
        }
        restoreHwToolbarState(hwToolbarState);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateUndoMenu(boolean z) {
        AbstractC8014b.m7220v("updateUndoMenu : ", TAG, z);
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(256);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarUndo) hwToolbarItem).updateUndoRedoMenu(z);
    }

    public void updateVisible(boolean z, List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            getVisibilityManager().updateVisible(z, it.next().intValue());
        }
    }

    public void updateZoomLock() {
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(4096);
        if (hwToolbarItem == null) {
            return;
        }
        ((HwToolbarLockCanvas) hwToolbarItem).updateLockCanvas();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateZoomLockMenu(boolean z) {
        AbstractC8014b.m7220v("updateZoomLockMenu : ", TAG, z);
        HwToolbarItem hwToolbarItem = this.mBtnMap.get(4096);
        if (hwToolbarItem == null) {
            return;
        }
        hwToolbarItem.setSelected(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void onSelected(int i, boolean z) {
        if (!this.mModeChangeExclusionButtonList.contains(Integer.valueOf(i))) {
            this.mHwToolbarPresenter.getMRemoteHwSettingPresenter().changeWritingMode();
        }
        updateSelectionState(i, z);
    }

    public void closeHandwritingSpecialButtons() {
        closeHandwritingSpecialButtons(new int[]{1024, 64, 4096, 1024, 8192});
    }
}
