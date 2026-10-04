package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.presenter.item.InAppToolbarPresenter;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.RemoteHwSettingPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J*\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010#\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010#\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010&\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0002J$\u0010'\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010(\u001a\u00020\u0017H\u0016J\b\u0010)\u001a\u00020\bH\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingViewManager;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingViewManager;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/IInAppSettingViewManager;", "<init>", "()V", "mInAppToolbarPresenter", "Lcom/samsung/android/support/senl/nt/app/inapp/presenter/item/InAppToolbarPresenter;", "setPresenter", "", "presenter", "overrideLayout", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "init", "key", "", com.samsung.android.support.senl.p148nt.base.common.constants.Constants.ARG_UPDATE, "callerType", "calleeType", "container", "withAnimation", "", Constants.IntentExtraValue.SHOW, "hide", "exceptSettingView", "closeColorPopups", "hideEraseAllOption", "updateToolbarSelectionState", "getHwSettingLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingLayout;", "setRotation", "surfaceType", "parentView", "updateLayoutParam", "settingLayout", "updatePositionToCenter", "setPositionLayout", "updatePosition", "isTabletLayout", "updateLastPenTypeSelectionState", "getCallerView", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInAppSettingViewManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppSettingViewManager.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingViewManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,211:1\n1#2:212\n*E\n"})
public final class InAppSettingViewManager extends HwSettingViewManager implements IInAppSettingViewManager {

    @Nullable
    private InAppToolbarPresenter mInAppToolbarPresenter;

    private final void setPositionLayout(final int callerType, final View container, final View settingLayout) {
        ViewTreeObserver viewTreeObserver;
        if (settingLayout == null || (viewTreeObserver = settingLayout.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager.setPositionLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                settingLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                this.updatePosition(callerType, container, settingLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updatePosition(int callerType, View container, View settingLayout) {
        updatePositionToCenter(settingLayout);
        if (container == null) {
            return;
        }
        int dimension = (int) container.getResources().getDimension(C8003R.dimen.comp_hw_floating_menu_margin);
        if (callerType == 128) {
            dimension *= 2;
        } else if (callerType == 32769 || callerType == 32771 || callerType == 32773) {
            dimension *= 3;
        } else if (callerType == 131072) {
        }
        container.getLocationOnScreen(new int[2]);
        this.mToolbarContainer.getLocationOnScreen(new int[2]);
        if (settingLayout != null) {
            settingLayout.setY(((r1[1] - r3[1]) - settingLayout.getHeight()) - dimension);
        }
    }

    private final void updatePositionToCenter(View settingLayout) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.endToEnd = 0;
        layoutParams.startToStart = 0;
        if (settingLayout != null) {
            settingLayout.setLayoutParams(layoutParams);
        }
    }

    public final void closeColorPopups() {
        HashMap<Integer, HwSettingLayout> mSettingMap = this.mSettingMap;
        Intrinsics.checkNotNullExpressionValue(mSettingMap, "mSettingMap");
        Iterator<Map.Entry<Integer, HwSettingLayout>> it = mSettingMap.entrySet().iterator();
        while (it.hasNext()) {
            Object obj = (HwSettingLayout) it.next().getValue();
            if (obj instanceof InAppSettingImpl) {
                ((InAppSettingImpl) obj).closeColorPopup();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.IInAppSettingViewManager
    @Nullable
    public View getCallerView(int callerType) {
        return this.mToolbarManager.getView(callerType);
    }

    @Nullable
    public final HwSettingLayout getHwSettingLayout(int key) {
        return this.mSettingMap.get(Integer.valueOf(key));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager
    public boolean hide(boolean withAnimation, int exceptSettingView) {
        HashMap<Integer, HwSettingLayout> mSettingMap = this.mSettingMap;
        boolean z = false;
        if (mSettingMap == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(mSettingMap, "mSettingMap");
        for (Map.Entry<Integer, HwSettingLayout> entry : mSettingMap.entrySet()) {
            Integer key = entry.getKey();
            HwSettingLayout value = entry.getValue();
            if (key == null || !InAppSettingLayoutUtils.isUnableToHideSettingLayout(key)) {
                if (value != null && value.isVisible()) {
                    value.hide(withAnimation);
                    z = true;
                }
            }
        }
        return z;
    }

    public final void hideEraseAllOption() {
        HashMap<Integer, HwSettingLayout> mSettingMap = this.mSettingMap;
        Intrinsics.checkNotNullExpressionValue(mSettingMap, "mSettingMap");
        Iterator<Map.Entry<Integer, HwSettingLayout>> it = mSettingMap.entrySet().iterator();
        while (it.hasNext()) {
            HwSettingLayout value = it.next().getValue();
            if (value instanceof InAppSettingRemoverLayout) {
                ((InAppSettingRemoverLayout) value).hideEraseAllOption();
            }
        }
    }

    public final void init(int key) {
        HwSettingLayout hwSettingLayout;
        HashMap<Integer, HwSettingLayout> map = this.mSettingMap;
        if (map == null || (hwSettingLayout = map.get(Integer.valueOf(key))) == null) {
            return;
        }
        hwSettingLayout.init();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public boolean isTabletLayout() {
        return false;
    }

    public final void overrideLayout(@Nullable Activity activity, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        FloaterContainer floaterContainer = (FloaterContainer) rootView.findViewById(C8003R.id.floating_layout_container);
        HashMap map = new HashMap();
        map.put(512, new InAppColorPickerLayout());
        map.put(4, new InAppSettingPenLayout());
        map.put(256, new InAppSettingHighlighterLayout());
        map.put(8, new InAppSettingRemoverLayout(false));
        map.put(16, new InAppSettingSelectionLayout());
        map.put(1, new InAppSettingFavoritePenLayout());
        map.put(2, new InAppSettingAddFavoritePenLayout(true));
        map.put(128, new InAppSettingAddFavoritePenLayout(false));
        map.put(32, new InAppSettingChangeStyleLayout(activity, rootView));
        map.put(32768, new InAppSettingLaserPenLayout(activity, rootView));
        map.put(1024, new InAppSettingPenSizeLayout(activity, rootView));
        map.put(16384, new InAppSettingAssistanceLayout(activity, rootView));
        map.put(8192, new InAppSettingStraightenLayout(activity, rootView));
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            HwSettingLayout hwSettingLayout = (HwSettingLayout) entry.getValue();
            HashMap<Integer, HwSettingLayout> mSettingMap = this.mSettingMap;
            Intrinsics.checkNotNullExpressionValue(mSettingMap, "mSettingMap");
            mSettingMap.put(Integer.valueOf(iIntValue), hwSettingLayout);
            hwSettingLayout.setViewId(iIntValue);
            hwSettingLayout.setFloatingContainer(floaterContainer);
            hwSettingLayout.setSettingViewManager(this);
        }
    }

    public final void setPresenter(@Nullable InAppToolbarPresenter presenter) {
        this.mInAppToolbarPresenter = presenter;
    }

    public final void setRotation(int surfaceType, int callerType, int calleeType, @Nullable View parentView) {
        HashMap<Integer, HwSettingLayout> map = this.mSettingMap;
        if (map == null) {
            return;
        }
        HwSettingLayout hwSettingLayout = map.get(Integer.valueOf(calleeType));
        View view = this.mToolbarManager.getView(callerType);
        if (hwSettingLayout != null) {
            hwSettingLayout.setRotation(surfaceType, parentView, view);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void show(int callerType, int calleeType, @Nullable View container, boolean withAnimation) {
        HashMap<Integer, HwSettingLayout> mSettingMap = this.mSettingMap;
        if (mSettingMap == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(mSettingMap, "mSettingMap");
        for (Map.Entry<Integer, HwSettingLayout> entry : mSettingMap.entrySet()) {
            Integer key = entry.getKey();
            HwSettingLayout value = entry.getValue();
            if (value != null) {
                if (key != null && key.intValue() == calleeType) {
                    value.show(callerType, container, withAnimation);
                } else if (!InAppSettingLayoutUtils.isUnableToHideSettingLayout(key)) {
                    value.hide(true);
                } else if (InAppSettingLayoutUtils.isUnableToHideSettingLayout(Integer.valueOf(calleeType))) {
                    value.hide(false);
                }
            }
        }
    }

    public final void update(int callerType, int calleeType, @Nullable View container, boolean withAnimation) {
        HashMap<Integer, HwSettingLayout> mSettingMap = this.mSettingMap;
        if (mSettingMap == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(mSettingMap, "mSettingMap");
        for (Map.Entry<Integer, HwSettingLayout> entry : mSettingMap.entrySet()) {
            Integer key = entry.getKey();
            HwSettingLayout value = entry.getValue();
            if (value != null) {
                if (key != null && key.intValue() == calleeType) {
                    value.update(callerType, container, withAnimation);
                } else {
                    value.hide(true);
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.IInAppSettingViewManager
    public void updateLastPenTypeSelectionState() {
        InAppToolbarPresenter inAppToolbarPresenter = this.mInAppToolbarPresenter;
        if (inAppToolbarPresenter != null) {
            inAppToolbarPresenter.updateLastPenTypeSelectionState();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(int callerType, @Nullable View settingLayout) {
        updateLayoutParam(callerType, (View) null, settingLayout);
    }

    public final void updateToolbarSelectionState() {
        RemoteHwSettingPresenter mRemoteHwSettingPresenter;
        SpenSettingUIPenInfo selectedPenInfo = getSelectedPenInfo();
        InAppToolbarPresenter inAppToolbarPresenter = this.mInAppToolbarPresenter;
        if (inAppToolbarPresenter == null || (mRemoteHwSettingPresenter = inAppToolbarPresenter.getMRemoteHwSettingPresenter()) == null) {
            return;
        }
        mRemoteHwSettingPresenter.updateToolbarSelectionState(selectedPenInfo);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingViewManager, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager
    public void updateLayoutParam(int callerType, @Nullable View container, @Nullable View settingLayout) {
        if (InAppSettingLayoutUtils.isNotFloaterToolbarType(Integer.valueOf(callerType))) {
            updatePositionToCenter(settingLayout);
        } else {
            setPositionLayout(callerType, container, settingLayout);
        }
    }
}
