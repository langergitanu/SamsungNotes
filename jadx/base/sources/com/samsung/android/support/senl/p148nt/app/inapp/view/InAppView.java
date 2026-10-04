package com.samsung.android.support.senl.p148nt.app.inapp.view;

import android.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.InAppSAConstants;
import com.samsung.android.support.senl.p148nt.app.inapp.view.dialog.DisconnectDialogFragment;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityClientManager;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u0006\u0010&\u001a\u00020\u001bJ\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010.R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppView;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "mActivityContract", "Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppView$ActivityContract;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppView$ActivityContract;)V", "mToolbarManager", "Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppToolbarManager;", "mFloatingView", "Landroid/view/View;", "mToolbarView", "mSubToolbarView", "mAddOnsToolbarFlowView", "mRootView", "Landroid/view/ViewGroup;", "mCloseButton", "mCloseButtonVisibility", "", "mUiMode", "mMultiWindowMode", "mIsLargeHandsetLayout", "", "mIsFoldStateClosed", "mIsFoldableModel", "createView", "", "invalidateToolbarLayout", "setOnTouchListenerToHideInAppPopups", "detachedView", "setDimView", "needViewChange", "newConfig", "Landroid/content/res/Configuration;", "initCloseButton", "content", "onClickClose", "showCloseButton", "showDisconnectDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "contract", "Lcom/samsung/android/support/senl/nt/app/inapp/view/dialog/DisconnectDialogFragment$Contract;", "receiveData", "data", "", "ActivityContract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nInAppView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppView.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/InAppView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,192:1\n1#2:193\n*E\n"})
public final class InAppView {

    @NotNull
    private static final String TAG = "InAppView";

    @NotNull
    private final ActivityContract mActivityContract;

    @NotNull
    private final View mAddOnsToolbarFlowView;

    @Nullable
    private View mCloseButton;
    private int mCloseButtonVisibility;

    @NotNull
    private final View mFloatingView;
    private boolean mIsFoldStateClosed;
    private final boolean mIsFoldableModel;
    private boolean mIsLargeHandsetLayout;
    private int mMultiWindowMode;

    @Nullable
    private ViewGroup mRootView;

    @NotNull
    private final View mSubToolbarView;

    @Nullable
    private final InAppToolbarManager mToolbarManager;

    @NotNull
    private final View mToolbarView;
    private final int mUiMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/InAppView$ActivityContract;", "", "setContentView", "", "layoutResID", "", "finishActivity", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ActivityContract {
        void finishActivity();

        void setContentView(@LayoutRes int layoutResID);
    }

    public InAppView(@NotNull Activity activity, @NotNull ActivityContract mActivityContract) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mActivityContract, "mActivityContract");
        this.mActivityContract = mActivityContract;
        this.mCloseButtonVisibility = 8;
        Configuration configuration = activity.getResources().getConfiguration();
        this.mMultiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(configuration);
        this.mIsLargeHandsetLayout = ResourceUtils.isLargeHandsetLayout(activity);
        this.mUiMode = configuration.uiMode;
        boolean zIsFoldableModel = DeviceUtils.isFoldableModel();
        this.mIsFoldableModel = zIsFoldableModel;
        this.mIsFoldStateClosed = zIsFoldableModel && !this.mIsLargeHandsetLayout;
        View viewInflate = LayoutInflater.from(activity).inflate(C8003R.layout.in_app_collaboration_floating_layout, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        this.mFloatingView = viewInflate;
        View viewInflate2 = LayoutInflater.from(activity).inflate(C8003R.layout.in_app_collaboration_toolbar_container, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
        this.mToolbarView = viewInflate2;
        View viewInflate3 = LayoutInflater.from(activity).inflate(C8003R.layout.in_app_collaboration_sub_toolbar_container, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "inflate(...)");
        this.mSubToolbarView = viewInflate3;
        View viewInflate4 = LayoutInflater.from(activity).inflate(C8003R.layout.in_app_collaboration_add_ons_toolbar_flow, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate4, "inflate(...)");
        this.mAddOnsToolbarFlowView = viewInflate4;
        createView(activity);
        ViewGroup viewGroup = this.mRootView;
        Intrinsics.checkNotNull(viewGroup);
        this.mToolbarManager = new InAppToolbarManager(activity, viewGroup);
    }

    private final void initCloseButton(View content) {
        View viewFindViewById = content.findViewById(C8003R.id.action_close_button);
        this.mCloseButton = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(this.mCloseButtonVisibility);
        }
        View view = this.mCloseButton;
        if (view != null) {
            view.setOnClickListener(new ViewOnClickListenerC7538b(this, 22));
        }
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.mCloseButton);
    }

    private final void invalidateToolbarLayout(Activity activity) {
        View viewFindViewById;
        Resources resources = activity.getResources();
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null || (viewFindViewById = viewGroup.findViewById(C8003R.id.in_app_toolbar_container)) == null) {
            return;
        }
        viewFindViewById.setPadding(resources.getDimensionPixelSize(C8003R.dimen.in_app_toolbar_container_padding_start_end), 0, resources.getDimensionPixelSize(C8003R.dimen.in_app_toolbar_container_padding_start_end), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickClose() {
        InAppLogger.m8595d(TAG, "onClickClose()");
        ContinuityClientManager companion = ContinuityClientManager.INSTANCE.getInstance();
        if (companion != null && !companion.closeInAppCollaboration()) {
            this.mActivityContract.finishActivity();
        }
        CommonSamsungAnalytics.INSTANCE.insertLog(InAppSAConstants.SCREEN_IN_APP_CLIENT, InAppSAConstants.EVENT_CLOSE_MOVE_PEN_FROM_CLIENT);
    }

    private final void setOnTouchListenerToHideInAppPopups() {
        ViewGroup viewGroup = this.mRootView;
        View viewFindViewById = viewGroup != null ? viewGroup.findViewById(C8003R.id.inapp_toolbar_root_view) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById).setOnTouchListener(new ViewOnTouchListenerC4799j(this, 11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnTouchListenerToHideInAppPopups$lambda$1(InAppView inAppView, View view, MotionEvent motionEvent) {
        InAppToolbarManager inAppToolbarManager;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (motionEvent.getAction() == 1 && (inAppToolbarManager = inAppView.mToolbarManager) != null) {
            inAppToolbarManager.hideInAppPopups();
        }
        return true;
    }

    public final void createView(@NotNull Activity activity) {
        Resources resources;
        int i;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mActivityContract.setContentView(C8003R.layout.in_app_collaboration_activity);
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            View viewFindViewById = viewGroup != null ? viewGroup.findViewById(C8003R.id.layout_toolbar_container) : null;
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) viewFindViewById).removeView(this.mToolbarView);
            ViewGroup viewGroup2 = this.mRootView;
            View viewFindViewById2 = viewGroup2 != null ? viewGroup2.findViewById(C8003R.id.layout_sub_toolbar_container) : null;
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) viewFindViewById2).removeView(this.mSubToolbarView);
            ViewGroup viewGroup3 = this.mRootView;
            View viewFindViewById3 = viewGroup3 != null ? viewGroup3.findViewById(C8003R.id.layout_add_ons_toolbar_container) : null;
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) viewFindViewById3).removeView(this.mAddOnsToolbarFlowView);
            ViewGroup viewGroup4 = this.mRootView;
            View viewFindViewById4 = viewGroup4 != null ? viewGroup4.findViewById(C8003R.id.inapp_toolbar_root_view) : null;
            Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) viewFindViewById4).removeView(this.mFloatingView);
            ViewGroup.LayoutParams layoutParams = this.mAddOnsToolbarFlowView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.mAddOnsToolbarFlowView.setLayoutParams(layoutParams);
        }
        View viewInflate = LayoutInflater.from(activity).inflate(C8003R.layout.in_app_collaboration_view, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup5 = (ViewGroup) viewInflate;
        this.mRootView = viewGroup5;
        View viewFindViewById5 = viewGroup5 != null ? viewGroup5.findViewById(C8003R.id.layout_toolbar_container) : null;
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById5).addView(this.mToolbarView);
        ViewGroup viewGroup6 = this.mRootView;
        View viewFindViewById6 = viewGroup6 != null ? viewGroup6.findViewById(C8003R.id.layout_sub_toolbar_container) : null;
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById6).addView(this.mSubToolbarView);
        ViewGroup viewGroup7 = this.mRootView;
        View viewFindViewById7 = viewGroup7 != null ? viewGroup7.findViewById(C8003R.id.layout_add_ons_toolbar_container) : null;
        Intrinsics.checkNotNull(viewFindViewById7, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById7).addView(this.mAddOnsToolbarFlowView);
        ViewGroup viewGroup8 = this.mRootView;
        View viewFindViewById8 = viewGroup8 != null ? viewGroup8.findViewById(C8003R.id.inapp_toolbar_root_view) : null;
        Intrinsics.checkNotNull(viewFindViewById8, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById8).addView(this.mFloatingView);
        View viewFindViewById9 = activity.findViewById(C8003R.id.fragment_container);
        Intrinsics.checkNotNull(viewFindViewById9, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById9).addView(this.mRootView);
        View viewFindViewById10 = activity.findViewById(R.id.content);
        viewFindViewById10.findViewById(C8003R.id.in_app_collaboration_dim_background_for_action_bar).setVisibility(this.mFloatingView.findViewById(C8003R.id.floating_layout_container_for_sub).getVisibility());
        if (this.mIsFoldStateClosed) {
            resources = activity.getResources();
            i = C8003R.dimen.in_app_toolbar_container_margin_start_end_for_sub_display;
        } else {
            resources = activity.getResources();
            i = C8003R.dimen.in_app_toolbar_container_margin_start_end;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i);
        ViewGroup viewGroup9 = this.mRootView;
        if (viewGroup9 != null) {
            viewGroup9.findViewById(C8003R.id.in_app_layout_container).setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        invalidateToolbarLayout(activity);
        Intrinsics.checkNotNull(viewFindViewById10);
        initCloseButton(viewFindViewById10);
        setOnTouchListenerToHideInAppPopups();
        InAppToolbarManager inAppToolbarManager = this.mToolbarManager;
        if (inAppToolbarManager != null) {
            inAppToolbarManager.invalidateFlow();
        }
    }

    public final void detachedView() {
        InAppToolbarManager inAppToolbarManager = this.mToolbarManager;
        if (inAppToolbarManager != null) {
            inAppToolbarManager.release();
        }
        InAppToolbarManager inAppToolbarManager2 = this.mToolbarManager;
        if (inAppToolbarManager2 != null) {
            inAppToolbarManager2.close();
        }
    }

    public final boolean needViewChange(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        boolean z = this.mIsLargeHandsetLayout;
        ViewGroup viewGroup = this.mRootView;
        Intrinsics.checkNotNull(viewGroup);
        boolean z2 = false;
        if (z == ResourceUtils.isLargeHandsetLayout(viewGroup.getContext())) {
            int multiWindowMode = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(newConfig);
            if (this.mMultiWindowMode == multiWindowMode) {
                return this.mUiMode != newConfig.uiMode;
            }
            this.mMultiWindowMode = multiWindowMode;
            InAppLogger.m8595d(TAG, "needViewChange() change to windowMode " + multiWindowMode);
            return true;
        }
        boolean z3 = !this.mIsLargeHandsetLayout;
        this.mIsLargeHandsetLayout = z3;
        InAppLogger.m8595d(TAG, "needViewChange() change to LargeHandsetLayout " + z3);
        if (this.mIsFoldableModel && !this.mIsLargeHandsetLayout) {
            z2 = true;
        }
        this.mIsFoldStateClosed = z2;
        return true;
    }

    public final void receiveData(@Nullable byte[] data) {
        InAppToolbarManager inAppToolbarManager = this.mToolbarManager;
        if (inAppToolbarManager != null) {
            inAppToolbarManager.receiveData(data);
        }
    }

    public final void setDimView() {
        InAppToolbarManager inAppToolbarManager = this.mToolbarManager;
        if (inAppToolbarManager != null) {
            inAppToolbarManager.closeColorPopups();
        }
    }

    public final void showCloseButton() {
        this.mCloseButtonVisibility = 0;
        View view = this.mCloseButton;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void showDisconnectDialog(@NotNull FragmentManager fragmentManager, @Nullable DisconnectDialogFragment.Contract contract) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        new DisconnectDialogFragment(contract).show(fragmentManager, DisconnectDialogFragment.TAG);
        CommonSamsungAnalytics.INSTANCE.insertLog("750", "7067");
    }
}
