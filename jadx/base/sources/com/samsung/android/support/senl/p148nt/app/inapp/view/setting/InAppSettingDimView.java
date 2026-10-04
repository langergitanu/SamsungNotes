package com.samsung.android.support.senl.p148nt.app.inapp.view.setting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloaterContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.AbsItemOrderInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.constants.DefaultItemOrder;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0003J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView;", "", "mActivity", "Landroid/app/Activity;", "mInAppSettingView", "Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView$InAppSettingViewContract;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView$InAppSettingViewContract;)V", "mFloatingContainer", "Lcom/samsung/android/support/senl/nt/base/winset/view/floater/FloaterContainer;", "setFloatingContainerVisibility", "", "visibility", "", "setTouchListenerToDim", "dimView", "Landroid/view/View;", "setItemViewVisibility", "toolbarId", "recreateItemViewWithCurrentQualifiers", "Landroid/view/ViewGroup;", "getToolbarView", "setToolbarLocation", "itemView", "InAppSettingViewContract", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class InAppSettingDimView {

    @Nullable
    private final Activity mActivity;

    @Nullable
    private final FloaterContainer mFloatingContainer;

    @Nullable
    private final InAppSettingViewContract mInAppSettingView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/setting/InAppSettingDimView$InAppSettingViewContract;", "", "onTouchOutside", "", "getCallerView", "Landroid/view/View;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface InAppSettingViewContract {
        @Nullable
        View getCallerView();

        void onTouchOutside();
    }

    public InAppSettingDimView(@Nullable Activity activity, @Nullable InAppSettingViewContract inAppSettingViewContract) {
        Window window;
        View decorView;
        this.mActivity = activity;
        this.mInAppSettingView = inAppSettingViewContract;
        this.mFloatingContainer = (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : (FloaterContainer) decorView.findViewById(C8003R.id.floating_layout_container_for_sub);
    }

    private final View getToolbarView(int toolbarId) {
        if (toolbarId == 16) {
            AbsItemOrderInfo info = DefaultItemOrder.ItemInfo.Style.getInfo();
            FloaterContainer floaterContainer = this.mFloatingContainer;
            return info.inflateView(floaterContainer != null ? floaterContainer.getContext() : null);
        }
        if (toolbarId == 128) {
            AbsItemOrderInfo info2 = DefaultItemOrder.ItemInfo.Align.getInfo();
            FloaterContainer floaterContainer2 = this.mFloatingContainer;
            return info2.inflateView(floaterContainer2 != null ? floaterContainer2.getContext() : null);
        }
        if (toolbarId == 131072) {
            AbsItemOrderInfo info3 = DefaultItemOrder.ItemInfo.Assistance.getInfo();
            FloaterContainer floaterContainer3 = this.mFloatingContainer;
            return info3.inflateView(floaterContainer3 != null ? floaterContainer3.getContext() : null);
        }
        if (toolbarId != 262144) {
            return null;
        }
        AbsItemOrderInfo info4 = DefaultItemOrder.ItemInfo.LaserPen.getInfo();
        FloaterContainer floaterContainer4 = this.mFloatingContainer;
        return info4.inflateView(floaterContainer4 != null ? floaterContainer4.getContext() : null);
    }

    private final ViewGroup recreateItemViewWithCurrentQualifiers() {
        ViewGroup viewGroup;
        int iIndexOfChild;
        FloaterContainer floaterContainer = this.mFloatingContainer;
        if (floaterContainer == null || (viewGroup = (ViewGroup) floaterContainer.findViewById(C8003R.id.floating_layout_container_for_sub)) == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.mFloatingContainer.findViewById(C8003R.id.in_app_floating_item_layout);
        if (viewGroup2 != null) {
            iIndexOfChild = viewGroup.indexOfChild(viewGroup2);
            viewGroup.removeViewAt(iIndexOfChild);
        } else {
            iIndexOfChild = -1;
        }
        FrameLayout frameLayout = new FrameLayout(new ContextThemeWrapper(this.mActivity, C8003R.style.InAppCollaborationAddOnsButtonStyle), null, 0);
        frameLayout.setId(C8003R.id.in_app_floating_item_layout);
        viewGroup.addView(frameLayout, iIndexOfChild);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setToolbarLocation(int toolbarId, ViewGroup itemView) {
        View callerView;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        InAppSettingViewContract inAppSettingViewContract = this.mInAppSettingView;
        if (inAppSettingViewContract == null || (callerView = inAppSettingViewContract.getCallerView()) == null) {
            return;
        }
        if (toolbarId == 16) {
            View viewFindViewById = callerView.findViewById(C8003R.id.hw_toolbar_style_color_view);
            ImageView imageView = viewFindViewById instanceof ImageView ? (ImageView) viewFindViewById : null;
            ColorStateList imageTintList = imageView != null ? imageView.getImageTintList() : null;
            View viewFindViewById2 = itemView != null ? itemView.findViewById(C8003R.id.hw_toolbar_style_color_view) : null;
            ImageView imageView2 = viewFindViewById2 instanceof ImageView ? (ImageView) viewFindViewById2 : null;
            if (imageView2 != null) {
                imageView2.setImageTintList(imageTintList);
            }
        }
        callerView.getLocationOnScreen(iArr);
        FloaterContainer floaterContainer = this.mFloatingContainer;
        if (floaterContainer != null) {
            floaterContainer.getLocationOnScreen(iArr2);
        }
        if (itemView != null) {
            itemView.setX(iArr[0] - iArr2[0]);
            itemView.setY(iArr[1] - iArr2[1]);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void setTouchListenerToDim(View dimView) {
        ViewOnTouchListenerC4799j viewOnTouchListenerC4799j = new ViewOnTouchListenerC4799j(this, 13);
        if (dimView != null) {
            dimView.setOnTouchListener(viewOnTouchListenerC4799j);
        }
        FloaterContainer floaterContainer = this.mFloatingContainer;
        if (floaterContainer != null) {
            floaterContainer.setOnTouchListener(viewOnTouchListenerC4799j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchListenerToDim$lambda$0(InAppSettingDimView inAppSettingDimView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        InAppLogger.m8598i("InAppSettingDimView", "onTouchOutside()");
        InAppSettingViewContract inAppSettingViewContract = inAppSettingDimView.mInAppSettingView;
        if (inAppSettingViewContract == null) {
            return true;
        }
        inAppSettingViewContract.onTouchOutside();
        return true;
    }

    public final void setFloatingContainerVisibility(int visibility) {
        Window window;
        View decorView;
        Activity activity = this.mActivity;
        View viewFindViewById = (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.findViewById(C8003R.id.in_app_collaboration_dim_background_for_action_bar);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(visibility);
        }
        FloaterContainer floaterContainer = this.mFloatingContainer;
        if (floaterContainer != null) {
            floaterContainer.setVisibility(visibility);
        }
        if (visibility == 0) {
            setTouchListenerToDim(viewFindViewById);
        }
    }

    public final void setItemViewVisibility(int toolbarId, int visibility) {
        ViewGroup viewGroupRecreateItemViewWithCurrentQualifiers = recreateItemViewWithCurrentQualifiers();
        if (visibility == 0 && viewGroupRecreateItemViewWithCurrentQualifiers != null && viewGroupRecreateItemViewWithCurrentQualifiers.getVisibility() == visibility) {
            FloaterContainer floaterContainer = this.mFloatingContainer;
            if (floaterContainer != null) {
                floaterContainer.post(new RunnableC0101a(this, toolbarId, viewGroupRecreateItemViewWithCurrentQualifiers, 8));
                return;
            }
            return;
        }
        if (viewGroupRecreateItemViewWithCurrentQualifiers != null) {
            viewGroupRecreateItemViewWithCurrentQualifiers.removeAllViews();
        }
        if (visibility == 0 && viewGroupRecreateItemViewWithCurrentQualifiers != null) {
            viewGroupRecreateItemViewWithCurrentQualifiers.addView(getToolbarView(toolbarId));
            setToolbarLocation(toolbarId, viewGroupRecreateItemViewWithCurrentQualifiers);
        }
        if (viewGroupRecreateItemViewWithCurrentQualifiers != null) {
            viewGroupRecreateItemViewWithCurrentQualifiers.setVisibility(visibility);
        }
    }
}
