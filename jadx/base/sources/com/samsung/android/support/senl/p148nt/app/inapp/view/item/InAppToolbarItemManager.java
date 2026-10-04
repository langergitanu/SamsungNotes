package com.samsung.android.support.senl.p148nt.app.inapp.view.item;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.sdk.mobileservice.social.share.BundleKey;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingViewManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.SettingInfoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarAiAssist;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarAlignmentRecognition;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarAssistance;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarCleanUpAndConvertText;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarConvertText;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarDirectWrite;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarEasyWritingPad;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarLockCanvas;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarOrderManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarRedo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarShapeRecognition;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarUndo;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 I2\u00020\u0001:\u0001IB1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0004J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u001e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0016J\u0016\u0010$\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J\u0006\u0010&\u001a\u00020\u001eJ\u0016\u0010'\u001a\u00020\u001e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0002J\u0018\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0014J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0018H\u0016J\b\u00105\u001a\u00020\"H\u0016J\b\u00106\u001a\u00020\"H\u0016J\b\u00107\u001a\u00020\u001eH\u0016J\b\u00108\u001a\u00020\u001eH\u0016J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\"H\u0016J\u0018\u0010<\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0018H\u0002J\b\u0010=\u001a\u00020\u001eH\u0016J\b\u0010>\u001a\u00020\u001eH\u0016J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0018H\u0016J\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020\"H\u0016J\u0010\u0010D\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020\u0018H\u0016J\u0006\u0010F\u001a\u00020\u001eJ\u0006\u0010G\u001a\u00020\u001eJ\n\u0010H\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarItemManager;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemManager;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "mRootView", "Landroid/view/View;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenterImpl;", "hwToolbarMenu", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemManager$IHwToolbarMenu;", "componentFactory", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarOrderManager$ComponentFactory;", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenterImpl;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarItemManager$IHwToolbarMenu;Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/item/HwToolbarOrderManager$ComponentFactory;)V", "mInAppToolbarPresenter", "Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarPresenter;", "mInAppSettingViewManager", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingViewManager;", "mAddOnsContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mAddOnsFlow", "Landroidx/constraintlayout/helper/widget/Flow;", "mSupportedItemList", "", "", "mInAppAddOnOrderList", "", "createSettingViewManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingViewManager;", "initMenu", "", "initToolbarItemsVisibility", "updateVisible", "isEnable", "", BundleKey.itemIdList, "updateSupportedItemList", "supportedItemList", "invalidateFlow", "setFlow", "hwToolbarItemList", "setRedoUndoToFlow", "viewIds", "", "redoUndoHasOneContainer", "resetAddOnToolbarItem", "initItemLayout", "restoreHwToolbarState", "savedHwToolbarState", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/common/HwToolbarState;", "onOrientationChanged", "orientation", "surfaceType", "isTextMode", "isDirectWriteUsing", "updateLastPenTypeSelectionState", "updateLastPrimitiveTypeSelectionState", "updateStateSelected", "selectedMenuKey", "isSelected", "updateHwSettingView", "onUpdateToolbarItem", "onUpdateToolbarQuickItem", "onUpdatedQuickColor", "index", "color", "applyToolbarEnabledState", "enabled", "onItemClickSALogging", "viewId", "closeColorPopups", "hideInAppPopups", "getHwSettingViewManager", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInAppToolbarItemManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppToolbarItemManager.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarItemManager\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,592:1\n37#2:593\n36#2,3:594\n37#2:597\n36#2,3:598\n37#2:601\n36#2,3:602\n37#2:605\n36#2,3:606\n37#2:609\n36#2,3:610\n37#2:613\n36#2,3:614\n37#2:617\n36#2,3:618\n37#2:621\n36#2,3:622\n*S KotlinDebug\n*F\n+ 1 InAppToolbarItemManager.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/item/InAppToolbarItemManager\n*L\n428#1:593\n428#1:594,3\n436#1:597\n436#1:598,3\n438#1:601\n438#1:602,3\n443#1:605\n443#1:606,3\n446#1:609\n446#1:610,3\n454#1:613\n454#1:614,3\n456#1:617\n456#1:618,3\n464#1:621\n464#1:622,3\n*E\n"})
public final class InAppToolbarItemManager extends HwToolbarItemManager {
    private static final int ADD_ONS_FLOW_MINIMUM_COUNT = 4;

    @NotNull
    private static final String TAG = "InAppToolbarItemManager";

    @NotNull
    private final ConstraintLayout mAddOnsContainer;

    @NotNull
    private final Flow mAddOnsFlow;

    @NotNull
    private final List<Integer> mInAppAddOnOrderList;

    @Nullable
    private InAppSettingViewManager mInAppSettingViewManager;

    @NotNull
    private final InAppToolbarPresenter mInAppToolbarPresenter;

    @NotNull
    private final View mRootView;

    @NotNull
    private final List<Integer> mSupportedItemList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<HwToolbarConstants.QUICK_COLOR> entries$0 = EnumEntriesKt.enumEntries(HwToolbarConstants.QUICK_COLOR.values());
        public static final /* synthetic */ EnumEntries<HwToolbarConstants.QUICK_SIZE> entries$1 = EnumEntriesKt.enumEntries(HwToolbarConstants.QUICK_SIZE.values());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppToolbarItemManager(@Nullable Activity activity, @NotNull View mRootView, @NotNull HwToolbarPresenterImpl presenter, @NotNull HwToolbarItemManager.IHwToolbarMenu hwToolbarMenu, @NotNull HwToolbarOrderManager.ComponentFactory componentFactory) {
        super(activity, (AbsToolbarContainerLayout) mRootView.findViewById(C8003R.id.floating_layout), (FloaterContainer) mRootView.findViewById(C8003R.id.floating_layout_container), (ViewGroup) mRootView.findViewById(C8003R.id.floating_layout), presenter, hwToolbarMenu, componentFactory);
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(hwToolbarMenu, "hwToolbarMenu");
        Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
        this.mRootView = mRootView;
        View viewFindViewById = mRootView.findViewById(C8003R.id.in_app_add_ons_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        this.mAddOnsContainer = constraintLayout;
        this.mSupportedItemList = new ArrayList();
        List<Integer> listAsList = Arrays.asList(1048576, 524288, 131072, 8192, 32, 128, 16, 1024, 64, 262144, 4096);
        Intrinsics.checkNotNullExpressionValue(listAsList, "asList(...)");
        this.mInAppAddOnOrderList = listAsList;
        constraintLayout.setVisibility(8);
        View viewFindViewById2 = mRootView.findViewById(C8003R.id.in_app_add_ons_flow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mAddOnsFlow = (Flow) viewFindViewById2;
        InAppToolbarPresenter inAppToolbarPresenter = (InAppToolbarPresenter) presenter;
        this.mInAppToolbarPresenter = inAppToolbarPresenter;
        initMenu();
        InAppSettingViewManager inAppSettingViewManager = this.mInAppSettingViewManager;
        if (inAppSettingViewManager != null) {
            inAppSettingViewManager.setPresenter(inAppToolbarPresenter);
        }
        InAppSettingViewManager inAppSettingViewManager2 = this.mInAppSettingViewManager;
        if (inAppSettingViewManager2 != null) {
            inAppSettingViewManager2.overrideLayout(activity, mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyToolbarEnabledState$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void resetAddOnToolbarItem() {
        this.mAddOnsContainer.removeAllViews();
        this.mAddOnsContainer.addView(this.mAddOnsFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void restoreHwToolbarState$lambda$0(InAppToolbarItemManager inAppToolbarItemManager) {
        InAppSettingViewManager inAppSettingViewManager = inAppToolbarItemManager.mInAppSettingViewManager;
        if (inAppSettingViewManager != null) {
            inAppSettingViewManager.show(16, 32, null, true);
        }
    }

    private final void setFlow(List<Integer> hwToolbarItemList) {
        resetAddOnToolbarItem();
        boolean z = hwToolbarItemList.size() > 4;
        int i = z ? 1 : 2;
        int size = hwToolbarItemList.size();
        int[] iArr = new int[size + i];
        setRedoUndoToFlow(iArr, z);
        for (int i2 = 0; i2 < size; i2++) {
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(hwToolbarItemList.get(i2));
            Intrinsics.checkNotNull(hwToolbarItem);
            InAppToolbarAddOnWrapperView inAppToolbarAddOnWrapperView = new InAppToolbarAddOnWrapperView(this.mRootView.getContext(), hwToolbarItem.getView());
            this.mAddOnsContainer.addView(inAppToolbarAddOnWrapperView.getView());
            iArr[i2 + i] = inAppToolbarAddOnWrapperView.getView().getId();
        }
        this.mAddOnsFlow.setReferencedIds(iArr);
    }

    private final void setRedoUndoToFlow(int[] viewIds, boolean redoUndoHasOneContainer) {
        View view;
        View view2;
        if (!redoUndoHasOneContainer) {
            Context context = this.mRootView.getContext();
            HwToolbarItem hwToolbarItem = this.mBtnMap.get(256);
            InAppToolbarAddOnWrapperView inAppToolbarAddOnWrapperView = new InAppToolbarAddOnWrapperView(context, hwToolbarItem != null ? hwToolbarItem.getView() : null);
            this.mAddOnsContainer.addView(inAppToolbarAddOnWrapperView.getView());
            viewIds[0] = inAppToolbarAddOnWrapperView.getView().getId();
            Context context2 = this.mRootView.getContext();
            HwToolbarItem hwToolbarItem2 = this.mBtnMap.get(512);
            InAppToolbarAddOnWrapperView inAppToolbarAddOnWrapperView2 = new InAppToolbarAddOnWrapperView(context2, hwToolbarItem2 != null ? hwToolbarItem2.getView() : null);
            this.mAddOnsContainer.addView(inAppToolbarAddOnWrapperView2.getView());
            viewIds[1] = inAppToolbarAddOnWrapperView2.getView().getId();
            return;
        }
        HwToolbarItem hwToolbarItem3 = this.mBtnMap.get(256);
        if (((hwToolbarItem3 == null || (view2 = hwToolbarItem3.getView()) == null) ? null : view2.getParent()) != null) {
            HwToolbarItem hwToolbarItem4 = this.mBtnMap.get(256);
            ViewParent parent = (hwToolbarItem4 == null || (view = hwToolbarItem4.getView()) == null) ? null : view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeAllViews();
        }
        View viewInflate = LayoutInflater.from(this.mRootView.getContext()).inflate(C8003R.layout.in_app_collaboration_add_on_toolbar_redo_undo_container, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        View view3 = new View(this.mRootView.getContext());
        view3.setLayoutParams(new ViewGroup.LayoutParams(this.mRootView.getResources().getDimensionPixelSize(C8003R.dimen.in_app_sub_toolbar_container_redo_undo_space_width), this.mRootView.getResources().getDimensionPixelSize(C8003R.dimen.in_app_add_ons_container_item_width_height)));
        HwToolbarItem hwToolbarItem5 = this.mBtnMap.get(256);
        viewGroup.addView(hwToolbarItem5 != null ? hwToolbarItem5.getView() : null);
        viewGroup.addView(view3);
        HwToolbarItem hwToolbarItem6 = this.mBtnMap.get(512);
        viewGroup.addView(hwToolbarItem6 != null ? hwToolbarItem6.getView() : null);
        this.mAddOnsContainer.addView(viewGroup);
        viewIds[0] = viewGroup.getId();
    }

    private final void updateHwSettingView(int orientation, int surfaceType) {
        InAppSettingViewManager inAppSettingViewManager;
        HashMap map = new HashMap(this.mHwToolbarState.getShownSettingViews());
        if (!map.isEmpty() && (inAppSettingViewManager = this.mInAppSettingViewManager) != null) {
            Intrinsics.checkNotNull(inAppSettingViewManager);
            if (inAppSettingViewManager.hide(false)) {
                View viewFindViewById = this.mRootView.findViewById(C8003R.id.floating_layout_container);
                for (Map.Entry entry : map.entrySet()) {
                    int iIntValue = ((Number) entry.getKey()).intValue();
                    int iIntValue2 = ((Number) entry.getValue()).intValue();
                    InAppSettingViewManager inAppSettingViewManager2 = this.mInAppSettingViewManager;
                    Intrinsics.checkNotNull(inAppSettingViewManager2);
                    inAppSettingViewManager2.update(iIntValue2, iIntValue, viewFindViewById, true);
                    InAppSettingViewManager inAppSettingViewManager3 = this.mInAppSettingViewManager;
                    Intrinsics.checkNotNull(inAppSettingViewManager3);
                    inAppSettingViewManager3.setRotation(surfaceType, iIntValue2, iIntValue, viewFindViewById);
                }
            }
        }
        updateSmartTipPopup();
    }

    private final void updateSupportedItemList(List<Integer> supportedItemList) {
        this.mSupportedItemList.clear();
        this.mSupportedItemList.addAll(supportedItemList);
        setFlow(this.mSupportedItemList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void applyToolbarEnabledState(boolean enabled) {
        InAppLogger.m8595d(TAG, "applyToolbarEnabledState# " + enabled);
        View viewFindViewById = this.mActivity.getWindow().getDecorView().findViewById(C8003R.id.in_app_collaboration_dim_during_ai_process);
        if (viewFindViewById == null) {
            InAppLogger.m8596e(TAG, "applyToolbarEnabledState# cannot find DimView.");
        } else {
            viewFindViewById.setOnTouchListener(new ViewOnTouchListenerC7005f(9));
            viewFindViewById.setVisibility(enabled ? 8 : 0);
        }
    }

    public final void closeColorPopups() {
        InAppLogger.m8595d(TAG, "closeColorPopups#");
        InAppSettingViewManager inAppSettingViewManager = this.mInAppSettingViewManager;
        if (inAppSettingViewManager != null) {
            inAppSettingViewManager.closeColorPopups();
        }
        InAppToolbarTextMode inAppToolbarTextMode = (InAppToolbarTextMode) this.mBtnMap.get(65536);
        if (inAppToolbarTextMode != null) {
            inAppToolbarTextMode.hidePopup();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager
    @Nullable
    public HwSettingViewManager createSettingViewManager() {
        InAppSettingViewManager inAppSettingViewManager = new InAppSettingViewManager();
        this.mInAppSettingViewManager = inAppSettingViewManager;
        return inAppSettingViewManager;
    }

    public final void hideInAppPopups() {
        InAppLogger.m8595d(TAG, "hideInAppPopups#");
        InAppSettingViewManager inAppSettingViewManager = this.mInAppSettingViewManager;
        if (inAppSettingViewManager != null) {
            inAppSettingViewManager.hideEraseAllOption();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager
    public void initItemLayout() {
        this.mBtnMap = new LinkedHashMap();
    }

    public final void initMenu() {
        Activity mActivity = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        View viewFindViewById = this.mRootView.findViewById(C8003R.id.hw_toolbar_text_mode);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        InAppToolbarTextMode inAppToolbarTextMode = new InAppToolbarTextMode(mActivity, viewFindViewById, this.mRootView, this);
        inAppToolbarTextMode.setViewId(65536);
        Map<Integer, HwToolbarItem> mBtnMap = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap, "mBtnMap");
        mBtnMap.put(Integer.valueOf(inAppToolbarTextMode.getViewId()), inAppToolbarTextMode);
        InAppToolbarPen inAppToolbarPen = new InAppToolbarPen(this.mRootView.findViewById(C8003R.id.hw_toolbar_pen), this);
        inAppToolbarPen.setViewId(2);
        Map<Integer, HwToolbarItem> mBtnMap2 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap2, "mBtnMap");
        mBtnMap2.put(Integer.valueOf(inAppToolbarPen.getViewId()), inAppToolbarPen);
        InAppToolbarHighlighter inAppToolbarHighlighter = new InAppToolbarHighlighter(this.mRootView.findViewById(C8003R.id.hw_toolbar_highlighter), this);
        inAppToolbarHighlighter.setViewId(2048);
        Map<Integer, HwToolbarItem> mBtnMap3 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap3, "mBtnMap");
        mBtnMap3.put(Integer.valueOf(inAppToolbarHighlighter.getViewId()), inAppToolbarHighlighter);
        InAppToolbarEraser inAppToolbarEraser = new InAppToolbarEraser(this.mRootView.findViewById(C8003R.id.hw_toolbar_eraser), this);
        inAppToolbarEraser.setViewId(4);
        Map<Integer, HwToolbarItem> mBtnMap4 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap4, "mBtnMap");
        mBtnMap4.put(Integer.valueOf(inAppToolbarEraser.getViewId()), inAppToolbarEraser);
        InAppToolbarSelection inAppToolbarSelection = new InAppToolbarSelection(this.mRootView.findViewById(C8003R.id.hw_toolbar_selection), this);
        inAppToolbarSelection.setViewId(8);
        Map<Integer, HwToolbarItem> mBtnMap5 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap5, "mBtnMap");
        mBtnMap5.put(Integer.valueOf(inAppToolbarSelection.getViewId()), inAppToolbarSelection);
        HwToolbarUndo hwToolbarUndo = new HwToolbarUndo(DefaultItemOrder.ItemInfo.Undo.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarUndo.setViewId(256);
        Map<Integer, HwToolbarItem> mBtnMap6 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap6, "mBtnMap");
        mBtnMap6.put(Integer.valueOf(hwToolbarUndo.getViewId()), hwToolbarUndo);
        HwToolbarRedo hwToolbarRedo = new HwToolbarRedo(DefaultItemOrder.ItemInfo.Redo.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarRedo.setViewId(512);
        Map<Integer, HwToolbarItem> mBtnMap7 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap7, "mBtnMap");
        mBtnMap7.put(Integer.valueOf(hwToolbarRedo.getViewId()), hwToolbarRedo);
        InAppToolbarQuickColor inAppToolbarQuickColor = new InAppToolbarQuickColor(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_color_1), this);
        inAppToolbarQuickColor.setViewId(16385);
        Map<Integer, HwToolbarItem> mBtnMap8 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap8, "mBtnMap");
        mBtnMap8.put(Integer.valueOf(inAppToolbarQuickColor.getViewId()), inAppToolbarQuickColor);
        InAppToolbarQuickColor inAppToolbarQuickColor2 = new InAppToolbarQuickColor(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_color_2), this);
        inAppToolbarQuickColor2.setViewId(16387);
        Map<Integer, HwToolbarItem> mBtnMap9 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap9, "mBtnMap");
        mBtnMap9.put(Integer.valueOf(inAppToolbarQuickColor2.getViewId()), inAppToolbarQuickColor2);
        InAppToolbarQuickColor inAppToolbarQuickColor3 = new InAppToolbarQuickColor(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_color_3), this);
        inAppToolbarQuickColor3.setViewId(16389);
        Map<Integer, HwToolbarItem> mBtnMap10 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap10, "mBtnMap");
        mBtnMap10.put(Integer.valueOf(inAppToolbarQuickColor3.getViewId()), inAppToolbarQuickColor3);
        InAppToolbarQuickColor inAppToolbarQuickColor4 = new InAppToolbarQuickColor(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_color_4), this);
        inAppToolbarQuickColor4.setViewId(16393);
        Map<Integer, HwToolbarItem> mBtnMap11 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap11, "mBtnMap");
        mBtnMap11.put(Integer.valueOf(inAppToolbarQuickColor4.getViewId()), inAppToolbarQuickColor4);
        InAppToolbarQuickColor inAppToolbarQuickColor5 = new InAppToolbarQuickColor(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_color_5), this);
        inAppToolbarQuickColor5.setViewId(16407);
        Map<Integer, HwToolbarItem> mBtnMap12 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap12, "mBtnMap");
        mBtnMap12.put(Integer.valueOf(inAppToolbarQuickColor5.getViewId()), inAppToolbarQuickColor5);
        InAppToolbarQuickSize inAppToolbarQuickSize = new InAppToolbarQuickSize(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_size_1), this);
        inAppToolbarQuickSize.setViewId(32769);
        Map<Integer, HwToolbarItem> mBtnMap13 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap13, "mBtnMap");
        mBtnMap13.put(Integer.valueOf(inAppToolbarQuickSize.getViewId()), inAppToolbarQuickSize);
        InAppToolbarQuickSize inAppToolbarQuickSize2 = new InAppToolbarQuickSize(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_size_2), this);
        inAppToolbarQuickSize2.setViewId(32771);
        Map<Integer, HwToolbarItem> mBtnMap14 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap14, "mBtnMap");
        mBtnMap14.put(Integer.valueOf(inAppToolbarQuickSize2.getViewId()), inAppToolbarQuickSize2);
        InAppToolbarQuickSize inAppToolbarQuickSize3 = new InAppToolbarQuickSize(this.mRootView.findViewById(C8003R.id.hw_toolbar_quick_size_3), this);
        inAppToolbarQuickSize3.setViewId(32773);
        Map<Integer, HwToolbarItem> mBtnMap15 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap15, "mBtnMap");
        mBtnMap15.put(Integer.valueOf(inAppToolbarQuickSize3.getViewId()), inAppToolbarQuickSize3);
        HwToolbarShapeRecognition hwToolbarShapeRecognition = new HwToolbarShapeRecognition(DefaultItemOrder.ItemInfo.Shape.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarShapeRecognition.setViewId(64);
        Map<Integer, HwToolbarItem> mBtnMap16 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap16, "mBtnMap");
        mBtnMap16.put(Integer.valueOf(hwToolbarShapeRecognition.getViewId()), hwToolbarShapeRecognition);
        Activity mActivity2 = this.mActivity;
        Intrinsics.checkNotNullExpressionValue(mActivity2, "mActivity");
        InAppToolbarStyle inAppToolbarStyle = new InAppToolbarStyle(mActivity2, DefaultItemOrder.ItemInfo.Style.getInfo().inflateView(this.mRootView.getContext()), this);
        inAppToolbarStyle.setViewId(16);
        Map<Integer, HwToolbarItem> mBtnMap17 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap17, "mBtnMap");
        mBtnMap17.put(Integer.valueOf(inAppToolbarStyle.getViewId()), inAppToolbarStyle);
        HwToolbarAiAssist hwToolbarAiAssist = new HwToolbarAiAssist(DefaultItemOrder.ItemInfo.AiAssist.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarAiAssist.setViewId(1048576);
        Map<Integer, HwToolbarItem> mBtnMap18 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap18, "mBtnMap");
        mBtnMap18.put(Integer.valueOf(hwToolbarAiAssist.getViewId()), hwToolbarAiAssist);
        HwToolbarCleanUpAndConvertText hwToolbarCleanUpAndConvertText = new HwToolbarCleanUpAndConvertText(DefaultItemOrder.ItemInfo.CleanUpAndConvertText.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarCleanUpAndConvertText.setViewId(524288);
        Map<Integer, HwToolbarItem> mBtnMap19 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap19, "mBtnMap");
        mBtnMap19.put(Integer.valueOf(hwToolbarCleanUpAndConvertText.getViewId()), hwToolbarCleanUpAndConvertText);
        HwToolbarConvertText hwToolbarConvertText = new HwToolbarConvertText(DefaultItemOrder.ItemInfo.ConvertText.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarConvertText.setViewId(32);
        Map<Integer, HwToolbarItem> mBtnMap20 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap20, "mBtnMap");
        mBtnMap20.put(Integer.valueOf(hwToolbarConvertText.getViewId()), hwToolbarConvertText);
        HwToolbarAlignmentRecognition hwToolbarAlignmentRecognition = new HwToolbarAlignmentRecognition(DefaultItemOrder.ItemInfo.Align.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarAlignmentRecognition.setViewId(128);
        Map<Integer, HwToolbarItem> mBtnMap21 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap21, "mBtnMap");
        mBtnMap21.put(Integer.valueOf(hwToolbarAlignmentRecognition.getViewId()), hwToolbarAlignmentRecognition);
        HwToolbarEasyWritingPad hwToolbarEasyWritingPad = new HwToolbarEasyWritingPad(DefaultItemOrder.ItemInfo.EasyWritePad.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarEasyWritingPad.setViewId(1024);
        Map<Integer, HwToolbarItem> mBtnMap22 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap22, "mBtnMap");
        mBtnMap22.put(Integer.valueOf(hwToolbarEasyWritingPad.getViewId()), hwToolbarEasyWritingPad);
        HwToolbarDirectWrite hwToolbarDirectWrite = new HwToolbarDirectWrite(DefaultItemOrder.ItemInfo.DirectWrite.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarDirectWrite.setViewId(8192);
        Map<Integer, HwToolbarItem> mBtnMap23 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap23, "mBtnMap");
        mBtnMap23.put(Integer.valueOf(hwToolbarDirectWrite.getViewId()), hwToolbarDirectWrite);
        HwToolbarLockCanvas hwToolbarLockCanvas = new HwToolbarLockCanvas(DefaultItemOrder.ItemInfo.LockCanvas.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarLockCanvas.setViewId(4096);
        Map<Integer, HwToolbarItem> mBtnMap24 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap24, "mBtnMap");
        mBtnMap24.put(Integer.valueOf(hwToolbarLockCanvas.getViewId()), hwToolbarLockCanvas);
        HwToolbarAssistance hwToolbarAssistance = new HwToolbarAssistance(DefaultItemOrder.ItemInfo.Assistance.getInfo().inflateView(this.mRootView.getContext()), this);
        hwToolbarAssistance.setViewId(131072);
        Map<Integer, HwToolbarItem> mBtnMap25 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap25, "mBtnMap");
        mBtnMap25.put(Integer.valueOf(hwToolbarAssistance.getViewId()), hwToolbarAssistance);
        InAppToolbarLaserPen inAppToolbarLaserPen = new InAppToolbarLaserPen(DefaultItemOrder.ItemInfo.LaserPen.getInfo().inflateView(this.mRootView.getContext()), this);
        inAppToolbarLaserPen.setViewId(262144);
        Map<Integer, HwToolbarItem> mBtnMap26 = this.mBtnMap;
        Intrinsics.checkNotNullExpressionValue(mBtnMap26, "mBtnMap");
        mBtnMap26.put(Integer.valueOf(inAppToolbarLaserPen.getViewId()), inAppToolbarLaserPen);
        updateSupportedItemList(this.mInAppAddOnOrderList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager
    public void initToolbarItemsVisibility() {
        InAppLogger.m8598i(TAG, "toolbarMenuVisible# toolbar add-on menu going to update by remote sync");
    }

    public final void invalidateFlow() {
        if (this.mSupportedItemList.isEmpty()) {
            return;
        }
        setFlow(this.mSupportedItemList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public boolean isDirectWriteUsing() {
        return isSelected(8192);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public boolean isTextMode() {
        return isSelected(65536);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void onItemClickSALogging(int viewId) {
        switch (viewId) {
            case 2:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_PEN_SETTING);
                break;
            case 4:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_ERASER);
                break;
            case 8:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_SELECTION_MODE);
                break;
            case 16:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_CHANGE_STYLE);
                break;
            case 32:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_CONVERT_TO_TEXT);
                break;
            case 64:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_AUTO_FIX_SHAPE);
                break;
            case 128:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_STRAIGHTEN);
                break;
            case 256:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_UNDO);
                break;
            case 512:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_REDO);
                break;
            case 1024:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_EASY_WRITING_PAD, isSelected(viewId) ? "1" : "2");
                break;
            case 2048:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_HIGHLIGHTER);
                break;
            case 4096:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_ZOOM_LOCK, isSelected(viewId) ? "1" : "2");
                break;
            case 8192:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_S_PEN_TO_TEXT_HANDWRITING, isSelected(viewId) ? "1" : "2");
                break;
            case 16385:
            case 16387:
            case 16389:
            case 16393:
            case 16407:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_QUICK_COLOR);
                break;
            case 32769:
            case 32771:
            case 32773:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_QUICK_SIZE);
                break;
            case 65536:
                CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_TOOL_TEXT);
                break;
            default:
                InAppLogger.m8595d(TAG, "onItemClickSALogging# Invalid view Id");
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager
    public void onOrientationChanged(int orientation, int surfaceType) {
        updateHwSettingView(orientation, surfaceType);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdateToolbarItem() {
        super.onUpdateToolbarItem();
        onUpdateToolbarQuickItem();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdateToolbarQuickItem() {
        int size = EntriesMappings.entries$0.size();
        int quickColorUseCount = this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getQuickColorUseCount();
        for (int i = 0; i < size; i++) {
            Map<Integer, HwToolbarItem> map = this.mBtnMap;
            EnumEntries<HwToolbarConstants.QUICK_COLOR> enumEntries = EntriesMappings.entries$0;
            InAppToolbarQuickColor inAppToolbarQuickColor = (InAppToolbarQuickColor) map.get(Integer.valueOf(((HwToolbarConstants.QUICK_COLOR[]) enumEntries.toArray(new HwToolbarConstants.QUICK_COLOR[0]))[i].constant));
            if (inAppToolbarQuickColor != null) {
                if (i >= quickColorUseCount) {
                    inAppToolbarQuickColor.getView().setVisibility(8);
                } else {
                    inAppToolbarQuickColor.getView().setVisibility(0);
                    onUpdatedQuickColor(((HwToolbarConstants.QUICK_COLOR[]) enumEntries.toArray(new HwToolbarConstants.QUICK_COLOR[0]))[i].ordinal(), this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickColorData().getQuickColor(((HwToolbarConstants.QUICK_COLOR[]) enumEntries.toArray(new HwToolbarConstants.QUICK_COLOR[0]))[i].ordinal()));
                }
            }
        }
        int length = EntriesMappings.entries$1.toArray(new HwToolbarConstants.QUICK_SIZE[0]).length;
        int quickSizeUseCount = this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getQuickSizeUseCount();
        for (int i2 = 0; i2 < length; i2++) {
            Map<Integer, HwToolbarItem> map2 = this.mBtnMap;
            EnumEntries<HwToolbarConstants.QUICK_SIZE> enumEntries2 = EntriesMappings.entries$1;
            InAppToolbarQuickSize inAppToolbarQuickSize = (InAppToolbarQuickSize) map2.get(Integer.valueOf(((HwToolbarConstants.QUICK_SIZE[]) enumEntries2.toArray(new HwToolbarConstants.QUICK_SIZE[0]))[i2].constant));
            if (inAppToolbarQuickSize != null) {
                if (i2 >= quickSizeUseCount) {
                    inAppToolbarQuickSize.getView().setVisibility(8);
                } else {
                    inAppToolbarQuickSize.getView().setVisibility(0);
                    onUpdatedQuickSize(((HwToolbarConstants.QUICK_SIZE[]) enumEntries2.toArray(new HwToolbarConstants.QUICK_SIZE[0]))[i2].ordinal(), this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getQuickSizeData().getSize(((HwToolbarConstants.QUICK_SIZE[]) enumEntries2.toArray(new HwToolbarConstants.QUICK_SIZE[0]))[i2].ordinal()));
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void onUpdatedQuickColor(int index, int color) {
        InAppLogger.m8595d(TAG, "onUpdatedQuickColor index : " + index + ", color : " + color);
        InAppToolbarQuickColor inAppToolbarQuickColor = (InAppToolbarQuickColor) this.mBtnMap.get(Integer.valueOf(((HwToolbarConstants.QUICK_COLOR[]) EntriesMappings.entries$0.toArray(new HwToolbarConstants.QUICK_COLOR[0]))[index].constant));
        if (inAppToolbarQuickColor == null) {
            return;
        }
        inAppToolbarQuickColor.updateUIColor(color);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void restoreHwToolbarState(@NotNull HwToolbarState savedHwToolbarState) {
        InAppSettingViewManager inAppSettingViewManager;
        Intrinsics.checkNotNullParameter(savedHwToolbarState, "savedHwToolbarState");
        InAppLogger.m8598i(TAG, "restoreHwToolbarState#");
        super.restoreHwToolbarState(savedHwToolbarState);
        if (!isSelected(2) && !isSelected(2048) && !isSelected(4) && !isSelected(8) && (inAppSettingViewManager = this.mInAppSettingViewManager) != null) {
            inAppSettingViewManager.show(2, 4, null, false);
        }
        InAppToolbarStyle inAppToolbarStyle = (InAppToolbarStyle) this.mBtnMap.get(16);
        if (inAppToolbarStyle != null && inAppToolbarStyle.isSelected()) {
            this.mAddOnsFlow.post(new RunnableC7599e(this, 13));
        }
        this.mAddOnsContainer.setVisibility(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateLastPenTypeSelectionState() {
        int selectedPrimitiveTypeItem = this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().getSelectedPrimitiveTypeItem();
        boolean zIsSelected = isSelected(selectedPrimitiveTypeItem);
        InAppLogger.m8595d(TAG, "updateLastPenTypeSelectionState# penType : " + selectedPrimitiveTypeItem + " / " + zIsSelected);
        if (isTextMode() || zIsSelected) {
            return;
        }
        onUpdateToolbarSelectionState(selectedPrimitiveTypeItem);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    public void updateLastPrimitiveTypeSelectionState() {
        updateSelectionState(this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager().getToolbarItemData().getSelectedPrimitiveTypeItem(), false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateStateSelected(int selectedMenuKey, boolean isSelected) {
        SettingToolbarItemData toolbarItemData;
        SettingToolbarItemData toolbarItemData2;
        SettingInfoManager settingInfoManager = this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager();
        Integer numValueOf = (settingInfoManager == null || (toolbarItemData2 = settingInfoManager.getToolbarItemData()) == null) ? null : Integer.valueOf(toolbarItemData2.getSelectedPrimitiveTypeItem());
        super.updateStateSelected(selectedMenuKey, isSelected);
        if (isSelected && selectedMenuKey == 16 && numValueOf != null) {
            InAppLogger.m8595d(TAG, "updateStateSelected# not allow to set STYLE to PrimitiveTypeItem. prevPenType : " + numValueOf);
            SettingInfoManager settingInfoManager2 = this.mInAppToolbarPresenter.getMRemoteHwSettingPresenter().getSettingInfoManager();
            if (settingInfoManager2 == null || (toolbarItemData = settingInfoManager2.getToolbarItemData()) == null) {
                return;
            }
            toolbarItemData.setSelectedPrimitiveTypeItem(numValueOf.intValue());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.IItemView
    public void updateVisible(boolean isEnable, @NotNull List<Integer> itemIdList) {
        Intrinsics.checkNotNullParameter(itemIdList, "itemIdList");
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.mInAppAddOnOrderList.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (isEnable && itemIdList.contains(Integer.valueOf(iIntValue))) {
                arrayList.add(Integer.valueOf(iIntValue));
            }
        }
        this.mSupportedItemList.clear();
        this.mSupportedItemList.addAll(arrayList);
        setFlow(arrayList);
        InAppLogger.m8598i(TAG, "updateVisible# SupportedItemList " + arrayList);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemContract
    @Nullable
    /* JADX INFO: renamed from: getHwSettingViewManager, reason: from getter */
    public InAppSettingViewManager getMInAppSettingViewManager() {
        return this.mInAppSettingViewManager;
    }
}
