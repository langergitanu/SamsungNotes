package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingDimView;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenSizeLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingPenSizeLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingPenSizeLayout;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/app/Activity;Landroid/view/View;)V", "mDimView", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView;", Constants.IntentExtraValue.SHOW, "", "callerType", "", "container", "withAnimation", "", "internalHide", "onVisibilityChanged", "setFloatingContainer", "floatingContainer", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingPenSizeLayout extends HwSettingPenSizeLayout {

    @Nullable
    private final InAppSettingDimView mDimView;

    public InAppSettingPenSizeLayout(@Nullable Activity activity, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mFloatingContainer = (FloaterContainer) rootView.findViewById(C8003R.id.floating_layout_container_for_sub);
        this.mDimView = new InAppSettingDimView(activity, new InAppSettingDimView.InAppSettingViewContract() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingPenSizeLayout.1
            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingDimView.InAppSettingViewContract
            public View getCallerView() {
                ISettingViewManager iSettingViewManager = ((HwSettingLayout) InAppSettingPenSizeLayout.this).mSettingViewManager;
                Intrinsics.checkNotNull(iSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
                return ((InAppSettingViewManager) iSettingViewManager).getCallerView(InAppSettingPenSizeLayout.this.getCallerType());
            }

            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingDimView.InAppSettingViewContract
            public void onTouchOutside() {
                InAppSettingPenSizeLayout.this.onTouchOutside();
            }
        });
    }

    private final void onVisibilityChanged() {
        int i = this.mSettingViewManager.isShownSettingViews(getViewId()) ? 0 : 8;
        InAppLogger.m8598i("InAppSettingPenSizeLayout", "onVisibilityChanged " + i);
        InAppSettingDimView inAppSettingDimView = this.mDimView;
        if (inAppSettingDimView != null) {
            inAppSettingDimView.setFloatingContainerVisibility(i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenSizeLayout
    public boolean internalHide(boolean withAnimation) {
        if (!super.internalHide(withAnimation)) {
            return false;
        }
        onVisibilityChanged();
        this.mSettingViewManager.getSettingInstance().updateToolbarSelectionState(this.mSettingViewManager.getSelectedPenInfo());
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setFloatingContainer(@NotNull FloaterContainer floatingContainer) {
        Intrinsics.checkNotNullParameter(floatingContainer, "floatingContainer");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingPenSizeLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int callerType, @Nullable View container, boolean withAnimation) {
        super.show(callerType, container, withAnimation);
        onVisibilityChanged();
    }
}
