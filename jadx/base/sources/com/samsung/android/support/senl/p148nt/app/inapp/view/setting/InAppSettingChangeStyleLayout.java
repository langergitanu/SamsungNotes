package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.sdk.pen.setting.SpenPopupLayout;
import com.samsung.android.sdk.pen.setting.SpenSettingChangeStyleLayout;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.InAppSettingDimView;
import com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.ISettingViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingChangeStyleLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/hw/setting/HwSettingChangeStyleLayout;", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/impl/InAppSettingImpl;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/app/Activity;Landroid/view/View;)V", "mDimView", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView;", "mBorderView", "getMBorderView", "()Landroid/view/View;", "init", "", "setCloseButtonTouchEvent", "closeColorPopup", "setFloatingContainer", "floatingContainer", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer;", "updatePosition", "callerType", "", "container", "withAnimation", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingChangeStyleLayout extends HwSettingChangeStyleLayout implements InAppSettingImpl {

    @Nullable
    private final View mBorderView;

    @Nullable
    private final InAppSettingDimView mDimView;

    public InAppSettingChangeStyleLayout(@Nullable Activity activity, @NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mFloatingContainer = (FloaterContainer) rootView.findViewById(C8003R.id.floating_layout_container_for_sub);
        this.mBorderView = rootView.findViewById(C8003R.id.in_app_add_ons_container);
        this.mDimView = new InAppSettingDimView(activity, new InAppSettingDimView.InAppSettingViewContract() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingChangeStyleLayout.1
            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingDimView.InAppSettingViewContract
            public View getCallerView() {
                ISettingViewManager iSettingViewManager = ((HwSettingLayout) InAppSettingChangeStyleLayout.this).mSettingViewManager;
                Intrinsics.checkNotNull(iSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
                return ((InAppSettingViewManager) iSettingViewManager).getCallerView(InAppSettingChangeStyleLayout.this.getCallerType());
            }

            @Override // com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingDimView.InAppSettingViewContract
            public void onTouchOutside() {
                if (((HwSettingLayout) InAppSettingChangeStyleLayout.this).mSettingViewManager != null) {
                    ISettingViewManager iSettingViewManager = ((HwSettingLayout) InAppSettingChangeStyleLayout.this).mSettingViewManager;
                    Intrinsics.checkNotNull(iSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
                    ((InAppSettingViewManager) iSettingViewManager).updateLastPenTypeSelectionState();
                }
                InAppSettingChangeStyleLayout.this.onTouchOutside();
            }
        });
    }

    private final void setCloseButtonTouchEvent() {
        View childAt;
        ViewGroup viewGroup = (ViewGroup) this.mSpenSettingChangeStyleLayout.findViewById(C8003R.id.popup_title);
        int childCount = viewGroup.getChildCount();
        ViewGroup viewGroup2 = null;
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                View childAt2 = viewGroup.getChildAt(i);
                Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
                viewGroup2 = (ViewGroup) childAt2;
            }
        }
        if (viewGroup2 == null || (childAt = viewGroup2.getChildAt(0)) == null) {
            return;
        }
        childAt.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setCloseButtonTouchEvent$lambda$0(InAppSettingChangeStyleLayout inAppSettingChangeStyleLayout, View view, MotionEvent motionEvent) {
        ISettingViewManager iSettingViewManager;
        if (motionEvent.getAction() != 1 || (iSettingViewManager = inAppSettingChangeStyleLayout.mSettingViewManager) == null) {
            return false;
        }
        Intrinsics.checkNotNull(iSettingViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingViewManager");
        ((InAppSettingViewManager) iSettingViewManager).updateLastPenTypeSelectionState();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.inapp.view.setting.impl.InAppSettingImpl
    public void closeColorPopup() {
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout != null) {
            spenSettingChangeStyleLayout.closeColorPickerPopup();
        }
        SpenSettingChangeStyleLayout spenSettingChangeStyleLayout2 = this.mSpenSettingChangeStyleLayout;
        if (spenSettingChangeStyleLayout2 != null) {
            spenSettingChangeStyleLayout2.closeColorSettingPopup();
        }
    }

    @Nullable
    public final View getMBorderView() {
        return this.mBorderView;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void init() {
        this.mIsSupportEyedropper = false;
        super.init();
        this.mSpenSettingChangeStyleLayout.setVisibilityChangedListener(new SpenPopupLayout.ViewListener() { // from class: com.samsung.android.support.senl.nt.app.inapp.view.setting.InAppSettingChangeStyleLayout.init.1
            @Override // com.samsung.android.sdk.pen.setting.SpenPopupLayout.ViewListener
            public void onVisibilityChanged(int visibility) {
                InAppSettingDimView inAppSettingDimView = InAppSettingChangeStyleLayout.this.mDimView;
                if (inAppSettingDimView != null) {
                    inAppSettingDimView.setFloatingContainerVisibility(visibility);
                }
                InAppSettingDimView inAppSettingDimView2 = InAppSettingChangeStyleLayout.this.mDimView;
                if (inAppSettingDimView2 != null) {
                    inAppSettingDimView2.setItemViewVisibility(InAppSettingChangeStyleLayout.this.getCallerType(), visibility);
                }
            }
        });
        setCloseButtonTouchEvent();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void setFloatingContainer(@NotNull FloaterContainer floatingContainer) {
        Intrinsics.checkNotNullParameter(floatingContainer, "floatingContainer");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingChangeStyleLayout, com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLayout
    public void updatePosition(int callerType, @Nullable View container, boolean withAnimation) {
        this.mSettingViewManager.updateLayoutParam(callerType, this.mBorderView, this.mSpenSettingChangeStyleLayout);
    }
}
