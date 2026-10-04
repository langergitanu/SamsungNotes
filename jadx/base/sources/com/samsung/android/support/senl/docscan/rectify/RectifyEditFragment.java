package com.samsung.android.support.senl.docscan.rectify;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.CommonUtils;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.docscan.rectify.constant.RectifyConstant;
import com.samsung.android.support.senl.docscan.rectify.presenter.RectifyEditPresenter;
import com.samsung.android.support.senl.docscan.rectify.util.RectifyUtil;
import com.samsung.android.support.senl.docscan.rectify.view.RectifyOverlayView;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B%\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0003\u0010\u000bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u001dH\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0002J\b\u00108\u001a\u00020\u001dH\u0016J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001fH\u0016J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020#H\u0016J\u0010\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\b\u0010D\u001a\u00020\u001dH\u0002J\u0010\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u0015H\u0002J\b\u0010G\u001a\u00020\u001dH\u0002J\u0012\u0010H\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010I\u001a\u00020\u001dH\u0002J\b\u0010J\u001a\u00020\u001dH\u0016J\u0012\u0010K\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010L\u001a\u00020\u001dH\u0002J\b\u0010M\u001a\u00020\u001dH\u0002J\u0012\u0010N\u001a\u00020\u001d2\b\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0010\u0010R\u001a\u00020\u001d2\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010Q\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010!¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/RectifyEditFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "docScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "scanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", NotesConstants.KEY_CALLER, "", "(Lcom/samsung/android/support/senl/docscan/model/DocScanData;Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;Ljava/lang/String;)V", "RECTIFY_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "mUIHandler", "Landroid/os/Handler;", "mCaller", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "mRectifyRunning", "", "Ljava/lang/Boolean;", "mScanDataModel", "mRectifyOverlayView", "Lcom/samsung/android/support/senl/docscan/rectify/view/RectifyOverlayView;", "mPresenter", "Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyEditPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "isChangedOverlayView", "()Z", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initToolbar", "initRectifyOverlayView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateOptionsMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/Menu;", "Landroid/view/MenuInflater;", "onPrepareOptionsMenu", "updateBottomNavigationView", "updateMenuTextColor", "updateMenuText", "updateMenuVisibility", "onDestroy", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onClick", VPathDataCmd.RCurveTo, "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onClickMenuButton", "menuId", "", "onCancelClick", "onDoneClick", "setMenuState", "enable", "saveRectifyResult", "addDocScanData", "callBackPress", "onDestroyView", "removeDocScanData", "replaceDoneButtonToProgress", "setArgumentsToBackStackRectifyListFragment", "runOnUiThread", "runnable", "Ljava/lang/Runnable;", "isNeedBottomButton", "setScanDataModel", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRectifyEditFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RectifyEditFragment.kt\ncom/samsung/android/support/senl/docscan/rectify/RectifyEditFragment\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Menu.kt\nandroidx/core/view/MenuKt\n*L\n1#1,426:1\n11228#2:427\n11563#2,3:428\n37#3:431\n36#3,3:432\n57#4,4:435\n*S KotlinDebug\n*F\n+ 1 RectifyEditFragment.kt\ncom/samsung/android/support/senl/docscan/rectify/RectifyEditFragment\n*L\n79#1:427\n79#1:428,3\n80#1:431\n80#1:432,3\n281#1:435,4\n*E\n"})
public final class RectifyEditFragment extends Fragment implements View.OnClickListener {

    @NotNull
    public static final String TAG = "RectifyEditFragment";
    private final ExecutorService RECTIFY_EXECUTOR;

    @Nullable
    private String mCaller;
    private RectifyEditPresenter mPresenter;
    private RectifyOverlayView mRectifyOverlayView;

    @Nullable
    private Boolean mRectifyRunning;

    @Nullable
    private ScanDataModel mScanDataModel;

    @Nullable
    private Toolbar mToolbar;

    @Nullable
    private Handler mUIHandler;

    public RectifyEditFragment() {
        this.RECTIFY_EXECUTOR = AbstractC4539a.m3201k(TAG);
    }

    private final void addDocScanData(DocScanData docScanData) {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null || docScanData == null || scanDataModel == null) {
            return;
        }
        scanDataModel.addScanData(docScanData);
    }

    private final void callBackPress() {
        runOnUiThread(new RunnableC7985a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callBackPress$lambda$5(RectifyEditFragment rectifyEditFragment) {
        RectifyListFragment rectifyListFragment;
        rectifyEditFragment.setMenuState(true);
        FragmentActivity activity = rectifyEditFragment.getActivity();
        if (CommonUtils.isNotAvailableActivity(activity)) {
            return;
        }
        if (Intrinsics.areEqual(rectifyEditFragment.mCaller, "CameraFragment")) {
            CameraFragment cameraFragment = (CameraFragment) rectifyEditFragment.requireActivity().getSupportFragmentManager().findFragmentByTag("CameraFragment");
            if (cameraFragment != null && !cameraFragment.isScanDataModelInitialized()) {
                cameraFragment.setScanDataModel(rectifyEditFragment.mScanDataModel);
            }
        } else if (Intrinsics.areEqual(rectifyEditFragment.mCaller, "RectifyListFragment") && (rectifyListFragment = (RectifyListFragment) rectifyEditFragment.requireActivity().getSupportFragmentManager().findFragmentByTag("RectifyListFragment")) != null && !rectifyListFragment.isScanDataModelInitialized()) {
            rectifyListFragment.setScanDataModel(rectifyEditFragment.mScanDataModel);
        }
        Intrinsics.checkNotNull(activity);
        activity.onBackPressed();
    }

    private final void initRectifyOverlayView() {
        View view = getView();
        if (view == null) {
            return;
        }
        RectifyOverlayView rectifyOverlayView = (RectifyOverlayView) view.findViewById(C7976R.id.rectify_overlay_view);
        this.mRectifyOverlayView = rectifyOverlayView;
        RectifyOverlayView rectifyOverlayView2 = null;
        if (rectifyOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRectifyOverlayView");
            rectifyOverlayView = null;
        }
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        if (rectifyEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter = null;
        }
        rectifyOverlayView.initialize(rectifyEditPresenter);
        RectifyEditPresenter rectifyEditPresenter2 = this.mPresenter;
        if (rectifyEditPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter2 = null;
        }
        DocScanData docScanData = rectifyEditPresenter2.getDocScanData();
        Logger.m7145d(TAG, "onViewCreated# mCaller : " + this.mCaller);
        if (Intrinsics.areEqual("CameraFragment", this.mCaller)) {
            Intrinsics.checkNotNull(docScanData);
            if (docScanData.getScanBitmap() == null) {
                docScanData.setScanBitmap(DocScanUtils.getBitmapImageFromPath(docScanData.getPathToSave()));
            }
            RectifyOverlayView rectifyOverlayView3 = this.mRectifyOverlayView;
            if (rectifyOverlayView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRectifyOverlayView");
                rectifyOverlayView3 = null;
            }
            rectifyOverlayView3.setImagePath(docScanData.getScanBitmap(), docScanData.getPathToSave());
        } else {
            RectifyOverlayView rectifyOverlayView4 = this.mRectifyOverlayView;
            if (rectifyOverlayView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRectifyOverlayView");
                rectifyOverlayView4 = null;
            }
            Intrinsics.checkNotNull(docScanData);
            rectifyOverlayView4.setImagePath(docScanData.getEditingPath());
        }
        RectifyOverlayView rectifyOverlayView5 = this.mRectifyOverlayView;
        if (rectifyOverlayView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRectifyOverlayView");
        } else {
            rectifyOverlayView2 = rectifyOverlayView5;
        }
        rectifyOverlayView2.setHandlePosition(docScanData.getVertexList());
    }

    private final void initToolbar() {
        Toolbar toolbar;
        View view = getView();
        if (view == null) {
            return;
        }
        this.mToolbar = (Toolbar) view.findViewById(C7976R.id.toolbar);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity == null || (toolbar = this.mToolbar) == null) {
            return;
        }
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar);
        supportActionBar.setTitle((CharSequence) null);
        ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
        Intrinsics.checkNotNull(supportActionBar2);
        supportActionBar2.setDisplayHomeAsUpEnabled(true);
    }

    private final boolean isChangedOverlayView() {
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        RectifyEditPresenter rectifyEditPresenter2 = null;
        if (rectifyEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter = null;
        }
        PointF[] previousVertexes = rectifyEditPresenter.getPreviousVertexes();
        RectifyEditPresenter rectifyEditPresenter3 = this.mPresenter;
        if (rectifyEditPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        } else {
            rectifyEditPresenter2 = rectifyEditPresenter3;
        }
        DocScanData docScanData = rectifyEditPresenter2.getDocScanData();
        Intrinsics.checkNotNull(docScanData);
        PointF[] vertexList = docScanData.getVertexList();
        int length = vertexList.length;
        Intrinsics.checkNotNull(previousVertexes);
        if (length != previousVertexes.length) {
            return true;
        }
        int length2 = previousVertexes.length;
        for (int i = 0; i < length2; i++) {
            PointF pointF = vertexList[i];
            Intrinsics.checkNotNull(pointF);
            float f = pointF.x;
            PointF pointF2 = previousVertexes[i];
            Intrinsics.checkNotNull(pointF2);
            if (f == pointF2.x) {
                PointF pointF3 = vertexList[i];
                Intrinsics.checkNotNull(pointF3);
                float f4 = pointF3.y;
                PointF pointF4 = previousVertexes[i];
                Intrinsics.checkNotNull(pointF4);
                if (f4 == pointF4.y) {
                }
            }
            return true;
        }
        Logger.m7145d(TAG, "isChangedOverlayView# : false");
        return false;
    }

    private final boolean isNeedBottomButton() {
        return ResourceUtils.isTabletLayout(getContext()) || requireContext().getResources().getConfiguration().orientation == 1;
    }

    private final void onCancelClick() {
        Logger.m7145d(TAG, "onCancelClick# ");
        callBackPress();
    }

    private final boolean onClickMenuButton(int menuId) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.DocumentScan;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(300L, tag);
        if (menuId == 16908332 || menuId == C7976R.id.action_retake || menuId == C7976R.id.action_cancel) {
            onCancelClick();
            return true;
        }
        if (menuId != C7976R.id.action_done) {
            return false;
        }
        setMenuState(false);
        onDoneClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDestroyView$lambda$6(RectifyEditFragment rectifyEditFragment) {
        RectifyEditPresenter rectifyEditPresenter = null;
        if (!Intrinsics.areEqual("CameraFragment", rectifyEditFragment.mCaller)) {
            if (Intrinsics.areEqual("RectifyListFragment", rectifyEditFragment.mCaller)) {
                RectifyEditPresenter rectifyEditPresenter2 = rectifyEditFragment.mPresenter;
                if (rectifyEditPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
                } else {
                    rectifyEditPresenter = rectifyEditPresenter2;
                }
                rectifyEditPresenter.resetVertexes();
                return;
            }
            return;
        }
        RectifyEditPresenter rectifyEditPresenter3 = rectifyEditFragment.mPresenter;
        if (rectifyEditPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter3 = null;
        }
        rectifyEditFragment.removeDocScanData(rectifyEditPresenter3.getDocScanData());
        RectifyEditPresenter rectifyEditPresenter4 = rectifyEditFragment.mPresenter;
        if (rectifyEditPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        } else {
            rectifyEditPresenter = rectifyEditPresenter4;
        }
        rectifyEditPresenter.removeSavedCacheFile();
    }

    private final void onDoneClick() {
        Logger.m7145d(TAG, "onDoneClick# ");
        if (Intrinsics.areEqual("RectifyListFragment", this.mCaller) && !isChangedOverlayView()) {
            callBackPress();
            return;
        }
        this.mRectifyRunning = Boolean.TRUE;
        replaceDoneButtonToProgress();
        RectifyOverlayView rectifyOverlayView = this.mRectifyOverlayView;
        if (rectifyOverlayView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRectifyOverlayView");
            rectifyOverlayView = null;
        }
        rectifyOverlayView.findViewById(C7976R.id.image_view_container).setOnTouchListener(null);
        saveRectifyResult();
    }

    private final void removeDocScanData(DocScanData docScanData) {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null || docScanData == null || scanDataModel == null) {
            return;
        }
        scanDataModel.removeScanData(docScanData);
    }

    private final void replaceDoneButtonToProgress() {
        View viewFindViewById;
        if (isNeedBottomButton()) {
            View view = getView();
            if (view == null || (viewFindViewById = view.findViewById(C7976R.id.action_done)) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            DialogUtils.replaceBtnToProgress(viewFindViewById);
            View viewFindViewById2 = view.findViewById(C7976R.id.progress_circle_small_container);
            layoutParams.width = -1;
            viewFindViewById2.setLayoutParams(layoutParams);
            return;
        }
        Toolbar toolbar = this.mToolbar;
        Intrinsics.checkNotNull(toolbar);
        MenuItem menuItemFindItem = toolbar.getMenu().findItem(C7976R.id.action_done);
        Toolbar toolbar2 = this.mToolbar;
        Intrinsics.checkNotNull(toolbar2);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) toolbar2.findViewById(menuItemFindItem.getItemId());
        if (actionMenuItemView == null) {
            requireActivity().invalidateOptionsMenu();
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = actionMenuItemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams.width = marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart() + actionMenuItemView.getMeasuredWidth();
        View viewInflate = View.inflate(getContext(), C7976R.layout.notes_progress_circle_small, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        viewGroup.setLayoutParams(marginLayoutParams);
        menuItemFindItem.setActionView(viewGroup);
    }

    private final void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.mUIHandler;
        Intrinsics.checkNotNull(handler);
        handler.post(runnable);
    }

    private final void saveRectifyResult() {
        this.RECTIFY_EXECUTOR.execute(new RunnableC7985a(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveRectifyResult$lambda$4(RectifyEditFragment rectifyEditFragment) {
        Bitmap bitmapSaveRectifiedImageFromList;
        RectifyEditPresenter rectifyEditPresenter = null;
        if (Intrinsics.areEqual("CameraFragment", rectifyEditFragment.mCaller)) {
            RectifyEditPresenter rectifyEditPresenter2 = rectifyEditFragment.mPresenter;
            if (rectifyEditPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
                rectifyEditPresenter2 = null;
            }
            bitmapSaveRectifiedImageFromList = rectifyEditPresenter2.saveRectifiedImageFromCamera();
        } else if (Intrinsics.areEqual("RectifyListFragment", rectifyEditFragment.mCaller)) {
            RectifyEditPresenter rectifyEditPresenter3 = rectifyEditFragment.mPresenter;
            if (rectifyEditPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
                rectifyEditPresenter3 = null;
            }
            bitmapSaveRectifiedImageFromList = rectifyEditPresenter3.saveRectifiedImageFromList();
        } else {
            bitmapSaveRectifiedImageFromList = null;
        }
        if (bitmapSaveRectifiedImageFromList != null) {
            RectifyEditPresenter rectifyEditPresenter4 = rectifyEditFragment.mPresenter;
            if (rectifyEditPresenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
                rectifyEditPresenter4 = null;
            }
            rectifyEditPresenter4.saveRectifiedThumbnail(bitmapSaveRectifiedImageFromList);
            bitmapSaveRectifiedImageFromList.recycle();
        }
        if (Intrinsics.areEqual("CameraFragment", rectifyEditFragment.mCaller)) {
            RectifyEditPresenter rectifyEditPresenter5 = rectifyEditFragment.mPresenter;
            if (rectifyEditPresenter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            } else {
                rectifyEditPresenter = rectifyEditPresenter5;
            }
            rectifyEditFragment.addDocScanData(rectifyEditPresenter.getDocScanData());
        } else if (Intrinsics.areEqual("RectifyListFragment", rectifyEditFragment.mCaller)) {
            rectifyEditFragment.setArgumentsToBackStackRectifyListFragment();
        }
        rectifyEditFragment.mRectifyRunning = Boolean.FALSE;
        rectifyEditFragment.callBackPress();
    }

    private final void setArgumentsToBackStackRectifyListFragment() {
        Fragment fragmentFindFragmentByTag;
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || (fragmentFindFragmentByTag = ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentByTag("RectifyListFragment")) == null) {
            return;
        }
        Bundle arguments = fragmentFindFragmentByTag.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragmentFindFragmentByTag.setArguments(arguments);
        }
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        if (rectifyEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter = null;
        }
        arguments.putParcelable(RectifyConstant.KEY_DOC_SCAN_DATA, rectifyEditPresenter.getDocScanData());
    }

    private final void setMenuState(boolean enable) {
        BottomNavigationView bottomNavigationView;
        View view = getView();
        if (view == null || (bottomNavigationView = (BottomNavigationView) view.findViewById(C7976R.id.bottom_navigation_view)) == null) {
            return;
        }
        Menu menu = bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            menu.getItem(i).setEnabled(enable);
        }
    }

    private final void updateBottomNavigationView() {
        BottomNavigationView bottomNavigationView;
        View view = getView();
        if (view == null || (bottomNavigationView = (BottomNavigationView) view.findViewById(C7976R.id.bottom_navigation_view)) == null) {
            return;
        }
        if (!isNeedBottomButton()) {
            bottomNavigationView.setVisibility(8);
            return;
        }
        bottomNavigationView.setVisibility(0);
        bottomNavigationView.setOnItemSelectedListener(new C7737b(this, 11));
        Menu menu = bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        updateMenuText(menu);
        Menu menu2 = bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu2, "getMenu(...)");
        updateMenuTextColor(menu2);
        Menu menu3 = bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu3, "getMenu(...)");
        updateMenuVisibility(menu3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateBottomNavigationView$lambda$2(RectifyEditFragment rectifyEditFragment, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return rectifyEditFragment.onClickMenuButton(item.getItemId());
    }

    private final void updateMenuText(Menu menu) {
        menu.findItem(C7976R.id.action_retake).setTitle(C7976R.string.action_retake);
        menu.findItem(C7976R.id.action_cancel).setTitle(C7976R.string.action_cancel);
        menu.findItem(C7976R.id.action_done).setTitle(C7976R.string.action_done);
    }

    private final void updateMenuTextColor(Menu menu) {
        int i = ButtonBackgroundUtils.isShowButtonShapeEnabled(getContext()) ? -16777216 : -1;
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menu.getItem(i2);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
            ButtonBackgroundUtils.updateMenuItemTextColor(item, i);
        }
    }

    private final void updateMenuVisibility(Menu menu) {
        if (Intrinsics.areEqual("CameraFragment", this.mCaller)) {
            menu.findItem(C7976R.id.action_retake).setVisible(true);
            menu.findItem(C7976R.id.action_cancel).setVisible(false);
        } else if (Intrinsics.areEqual("RectifyListFragment", this.mCaller)) {
            menu.findItem(C7976R.id.action_retake).setVisible(false);
            menu.findItem(C7976R.id.action_cancel).setVisible(true);
        } else {
            menu.findItem(C7976R.id.action_retake).setVisible(false);
            menu.findItem(C7976R.id.action_cancel).setVisible(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        onClickMenuButton(v.getId());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
        updateBottomNavigationView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        PointF[] pointFArr;
        super.onCreate(savedInstanceState);
        this.mPresenter = new RectifyEditPresenter();
        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }
        RectifyEditPresenter rectifyEditPresenter = null;
        if (savedInstanceState != null) {
            RectifyEditPresenter rectifyEditPresenter2 = this.mPresenter;
            if (rectifyEditPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
                rectifyEditPresenter2 = null;
            }
            rectifyEditPresenter2.setDocScanData((DocScanData) savedInstanceState.getParcelable(RectifyConstant.KEY_DOC_SCAN_DATA));
            this.mCaller = savedInstanceState.getString(RectifyConstant.KEY_CALLER);
            RectifyEditPresenter rectifyEditPresenter3 = this.mPresenter;
            if (rectifyEditPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
                rectifyEditPresenter3 = null;
            }
            DocScanData docScanData = rectifyEditPresenter3.getDocScanData();
            if (docScanData != null) {
                Parcelable[] parcelableArray = savedInstanceState.getParcelableArray(RectifyConstant.KEY_CURRENT_VERTEX_LIST);
                if (parcelableArray != null) {
                    ArrayList arrayList = new ArrayList(parcelableArray.length);
                    for (Parcelable parcelable : parcelableArray) {
                        arrayList.add(parcelable instanceof PointF ? (PointF) parcelable : null);
                    }
                    pointFArr = (PointF[]) arrayList.toArray(new PointF[0]);
                } else {
                    pointFArr = null;
                }
                docScanData.setVertexList(pointFArr);
            }
        }
        RectifyEditPresenter rectifyEditPresenter4 = this.mPresenter;
        if (rectifyEditPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        } else {
            rectifyEditPresenter = rectifyEditPresenter4;
        }
        rectifyEditPresenter.initScanLibrary();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        if (isNeedBottomButton()) {
            menu.clear();
        } else {
            inflater.inflate(C7976R.menu.rectify_edit_menu, menu);
            updateMenuVisibility(menu);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setHasOptionsMenu(true);
        return inflater.inflate(C7976R.layout.rectify_edit_fragment, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        if (rectifyEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter = null;
        }
        rectifyEditPresenter.deInitScanLibrary();
        super.onDestroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDestroyView() {
        String str = this.mCaller;
        if (str == null) {
            str = "null";
        }
        Boolean bool = this.mRectifyRunning;
        Logger.m7145d(TAG, "onDestroyView# caller: " + str + " mRectifyRunning: " + (bool != null ? bool : "null"));
        Boolean bool2 = this.mRectifyRunning;
        if (bool2 != null) {
            Intrinsics.checkNotNull(bool2, "null cannot be cast to non-null type kotlin.Boolean");
            if (bool2.booleanValue()) {
                this.RECTIFY_EXECUTOR.execute(new RunnableC7985a(this, 2));
            }
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (onClickMenuButton(item.getItemId())) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareOptionsMenu(menu);
        if (this.mRectifyRunning != null) {
            replaceDoneButtonToProgress();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        RectifyEditPresenter rectifyEditPresenter = this.mPresenter;
        RectifyEditPresenter rectifyEditPresenter2 = null;
        if (rectifyEditPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
            rectifyEditPresenter = null;
        }
        outState.putParcelable(RectifyConstant.KEY_DOC_SCAN_DATA, rectifyEditPresenter.getDocScanData());
        outState.putString(RectifyConstant.KEY_CALLER, this.mCaller);
        RectifyEditPresenter rectifyEditPresenter3 = this.mPresenter;
        if (rectifyEditPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
        } else {
            rectifyEditPresenter2 = rectifyEditPresenter3;
        }
        DocScanData docScanData = rectifyEditPresenter2.getDocScanData();
        Intrinsics.checkNotNull(docScanData);
        outState.putParcelableArray(RectifyConstant.KEY_CURRENT_VERTEX_LIST, docScanData.getVertexList());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(view);
        initToolbar();
        initRectifyOverlayView();
        updateBottomNavigationView();
    }

    public final void setScanDataModel(@Nullable ScanDataModel scanDataModel) {
        this.mScanDataModel = scanDataModel;
    }

    public RectifyEditFragment(@NotNull DocScanData docScanData, @Nullable ScanDataModel scanDataModel, @Nullable String str) {
        Intrinsics.checkNotNullParameter(docScanData, "docScanData");
        this.RECTIFY_EXECUTOR = AbstractC4539a.m3201k(TAG);
        Bundle bundle = new Bundle();
        docScanData.setVertexList(RectifyUtil.getCalibratedVertexList(docScanData.getVertexList()));
        bundle.putParcelable(RectifyConstant.KEY_DOC_SCAN_DATA, docScanData);
        bundle.putString(RectifyConstant.KEY_CALLER, str);
        setArguments(bundle);
        this.mScanDataModel = scanDataModel;
    }
}
