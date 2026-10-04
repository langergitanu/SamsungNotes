package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingDimView;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingStraightenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingStraightenLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingStraightenLayout;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/app/Activity;Landroid/view/View;)V", "mDimView", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView;", "mLanguageSettingBtn", Constants.IntentExtraValue.SHOW, "", "callerType", "", "container", "withAnimation", "", "hide", "onVisibilityChanged", "visibility", "setFloatingContainer", "floatingContainer", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingStraightenLayout extends HwSettingStraightenLayout {

    @Nullable
    private final InAppSettingDimView mDimView;

    @Nullable
    private final View mLanguageSettingBtn;

    public InAppSettingStraightenLayout(@Nullable Activity activity, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mFloatingContainer = (FloaterContainer) rootView.findViewById(C8003R.id.floating_layout_container_for_sub);
        this.mLanguageSettingBtn = rootView.findViewById(C8003R.id.hw_language_icon);
        this.mDimView = new InAppSettingDimView(activity, new InAppSettingDimView.InAppSettingViewContract() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingStraightenLayout.1
            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingDimView.InAppSettingViewContract
            public View getCallerView() {
                ISettingViewManager iSettingViewManager = ((HwSettingLayout) InAppSettingStraightenLayout.this).mSettingViewManager;
                Intrinsics.checkNotNull(iSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
                return ((InAppSettingViewManager) iSettingViewManager).getCallerView(InAppSettingStraightenLayout.this.getCallerType());
            }

            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingDimView.InAppSettingViewContract
            public void onTouchOutside() {
                InAppSettingStraightenLayout.this.onTouchOutside();
            }
        });
    }

    private final void onVisibilityChanged(int visibility) {
        InAppSettingDimView inAppSettingDimView = this.mDimView;
        if (inAppSettingDimView != null) {
            inAppSettingDimView.setFloatingContainerVisibility(visibility);
        }
        InAppSettingDimView inAppSettingDimView2 = this.mDimView;
        if (inAppSettingDimView2 != null) {
            inAppSettingDimView2.setItemViewVisibility(getCallerType(), visibility);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingStraightenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void hide(boolean withAnimation) {
        if (isVisible()) {
            onVisibilityChanged(8);
        }
        super.hide(withAnimation);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setFloatingContainer(@Nullable FloaterContainer floatingContainer) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingStraightenLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorExpansionLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.AbsHwSettingAnchorLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void show(int callerType, @Nullable View container, boolean withAnimation) {
        super.show(callerType, container, withAnimation);
        if (this.mStraightenLayout.getVisibility() == 0) {
            onVisibilityChanged(0);
        }
        setEnabled(this.mLanguageSettingBtn, false);
    }
}
