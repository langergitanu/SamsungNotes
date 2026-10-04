package com.samsung.android.support.senl.docscan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BuildCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.docscan.common.FileDeleteTask;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.docscan.rectify.RectifyEditFragment;
import com.samsung.android.support.senl.docscan.rectify.RectifyListFragment;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p031G2.C0109b;
import p031G2.RunnableC0108a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0016J+\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\rH\u0014J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000fH\u0014J\b\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\rH\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0016J\u001c\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u00102\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\tH\u0016J\b\u00107\u001a\u00020\rH\u0002J\b\u00108\u001a\u00020\rH\u0002J\b\u00109\u001a\u00020\rH\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u0013H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/DocumentScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/docscan/detect/CameraFragment$Contract;", "Lcom/samsung/android/support/senl/docscan/rectify/RectifyListFragment$Contract;", "<init>", "()V", "mScanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "mHasSavedInstance", "", "mPostActionWhenDenied", "Ljava/lang/Runnable;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "checkNotSupportedWindow", "onMultiWindowModeChanged", "isInMultiWindowMode", "restoreFragment", "onKeyShortcut", "keyCode", "event", "Landroid/view/KeyEvent;", "isNeedToShowCheckAddToNoteDialog", "()Z", "showCheckAddToNoteDialog", "dismissCheckAddToNoteDialog", "setContractToBackStackFragment", "startCameraFragment", "showRectifyListView", "showRectifyEditView", "docScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", NotesConstants.KEY_CALLER, "finishWithFailed", "cause", "finishWithSuccess", "onTopResumedActivityChanged", "isTopResumedActivity", "onWindowFocusChanged", "hasFocus", "deleteCacheFiles", "deleteSavedCacheDir", "onUserInteraction", "onTrimMemory", "level", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDocumentScanActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DocumentScanActivity.kt\ncom/samsung/android/support/senl/docscan/DocumentScanActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,334:1\n37#2:335\n36#2,3:336\n37#2:339\n36#2,3:340\n*S KotlinDebug\n*F\n+ 1 DocumentScanActivity.kt\ncom/samsung/android/support/senl/docscan/DocumentScanActivity\n*L\n96#1:335\n96#1:336,3\n32#1:339\n32#1:340,3\n*E\n"})
public final class DocumentScanActivity extends AppCompatActivity implements CameraFragment.Contract, RectifyListFragment.Contract {
    private static final int REQUEST_CAMERA_PERMISSION = 1;

    @NotNull
    private static final String TAG = "DocumentScanActivity";
    private boolean mHasSavedInstance;

    @NotNull
    private ScanDataModel mScanDataModel = new ScanDataModel();

    @NotNull
    private final Runnable mPostActionWhenDenied = new RunnableC0108a(this, 1);

    private final void checkNotSupportedWindow() {
        if (WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(this) != 0) {
            dismissCheckAddToNoteDialog();
            ToastHandler.show(this, C7976R.string.cannot_use_feature_in_multi_window, 0);
            finishWithSuccess("MultiWindow not supported");
        }
    }

    private final void deleteCacheFiles() {
        new FileDeleteTask().execute(DocScanUtils.getScanCachePath(getIntent().getStringExtra(Constant.INTENT_SDOC_UUID)));
    }

    private final void deleteSavedCacheDir() {
        new FileDeleteTask().execute(getIntent().getStringExtra(Constant.INTENT_PATH_TO_SAVE));
    }

    private final void dismissCheckAddToNoteDialog() {
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        if (cameraFragment != null) {
            cameraFragment.dismissCheckAddToNoteDialog();
        }
    }

    private final boolean isNeedToShowCheckAddToNoteDialog() {
        return !this.mScanDataModel.isScanDataEmpty() && getSupportFragmentManager().getBackStackEntryCount() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPostActionWhenDenied$lambda$1(DocumentScanActivity documentScanActivity) {
        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(8)).toArray(new String[0]);
        PermissionHelper.requestPermissions(documentScanActivity, 1, new RunnableC0108a(documentScanActivity, 0), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    private final void restoreFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                if (fragment instanceof CameraFragment) {
                    CameraFragment cameraFragment = (CameraFragment) fragment;
                    cameraFragment.setContract(this);
                    cameraFragment.setScanDataModel(this.mScanDataModel);
                } else if (fragment instanceof RectifyListFragment) {
                    RectifyListFragment rectifyListFragment = (RectifyListFragment) fragment;
                    rectifyListFragment.setContract(this);
                    rectifyListFragment.setScanDataModel(this.mScanDataModel);
                } else if (fragment instanceof RectifyEditFragment) {
                    ((RectifyEditFragment) fragment).setScanDataModel(this.mScanDataModel);
                }
                Logger.m7145d(TAG, "restoreFragment");
                return;
            }
        }
    }

    private final void setContractToBackStackFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        if (backStackEntryCount <= 0) {
            Logger.m7145d(TAG, "setContractToBackStackFragment# no backStack");
            return;
        }
        FragmentManager.BackStackEntry backStackEntryAt = supportFragmentManager.getBackStackEntryAt(backStackEntryCount - 1);
        Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "getBackStackEntryAt(...)");
        String name = backStackEntryAt.getName();
        Logger.m7145d(TAG, "setContractToBackStackFragment# fragmentTag : " + name);
        if (!Intrinsics.areEqual("CameraFragment", name)) {
            if (Intrinsics.areEqual("RectifyListFragment", name)) {
                Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(name);
                Objects.requireNonNull(fragmentFindFragmentByTag);
                Intrinsics.checkNotNull(fragmentFindFragmentByTag, "null cannot be cast to non-null type com.samsung.android.support.senl.docscan.rectify.RectifyListFragment");
                ((RectifyListFragment) fragmentFindFragmentByTag).setContract(this);
                return;
            }
            return;
        }
        CameraFragment cameraFragment = (CameraFragment) supportFragmentManager.findFragmentByTag(name);
        if (cameraFragment != null) {
            cameraFragment.setContract(this);
            if (cameraFragment.isScanDataModelInitialized()) {
                return;
            }
            cameraFragment.setScanDataModel(this.mScanDataModel);
        }
    }

    private final void showCheckAddToNoteDialog() {
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        if (cameraFragment != null) {
            cameraFragment.showCheckAddToNoteDialog();
        }
    }

    private final void startCameraFragment() {
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        if (cameraFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.INTENT_PATH_TO_SAVE, getIntent().getStringExtra(Constant.INTENT_PATH_TO_SAVE));
            bundle.putString(Constant.INTENT_SDOC_UUID, getIntent().getStringExtra(Constant.INTENT_SDOC_UUID));
            CameraFragment cameraFragment2 = new CameraFragment(this.mScanDataModel);
            cameraFragment2.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(C7976R.id.preview_container, cameraFragment2, "CameraFragment").commit();
            cameraFragment = cameraFragment2;
        }
        cameraFragment.setContract(this);
        Logger.m7145d(TAG, "startCameraFragment");
    }

    @Override // com.samsung.android.support.senl.docscan.detect.CameraFragment.Contract
    public void finishWithFailed(@Nullable String cause) {
        Logger.m7145d(TAG, "finishWithFailed# cause : " + cause);
        deleteCacheFiles();
        deleteSavedCacheDir();
        setResult(0);
        finish();
    }

    @Override // com.samsung.android.support.senl.docscan.detect.CameraFragment.Contract
    public void finishWithSuccess(@Nullable String cause) {
        Logger.m7145d(TAG, "finishWithSuccess# cause : " + cause);
        deleteCacheFiles();
        Intent intent = new Intent();
        intent.putExtra(Constant.INTENT_PATH_TO_SAVE, getIntent().getStringExtra(Constant.INTENT_PATH_TO_SAVE));
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Logger.m7145d(TAG, "handleOnBack");
        if (isNeedToShowCheckAddToNoteDialog()) {
            showCheckAddToNoteDialog();
        } else {
            setContractToBackStackFragment();
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C7976R.layout.document_scan_activity);
        checkNotSupportedWindow();
        if (getIntent() == null || getIntent().getStringExtra(Constant.INTENT_PATH_TO_SAVE) == null) {
            finishWithFailed("onCreate failed");
        }
        if (getIntent().getStringExtra(Constant.INTENT_SDOC_UUID) == null) {
            finishWithFailed("onCreate failed, docUuid is null");
        }
        this.mHasSavedInstance = savedInstanceState != null;
        this.mScanDataModel.load(savedInstanceState);
        if (this.mHasSavedInstance) {
            restoreFragment();
        } else {
            deleteCacheFiles();
        }
        if (BuildCompat.isAtLeastV()) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(1000000, new C0109b(this, 0));
        }
    }

    @Override // android.app.Activity
    public boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        return cameraFragment != null ? cameraFragment.onKeyShortcut(keyCode, event) : super.onKeyShortcut(keyCode, event);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Logger.m7145d(TAG, "onMultiWindowModeChanged# isInMultiWindowMode : " + isInMultiWindowMode);
        checkNotSupportedWindow();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (!PermissionHelper.verifyRequestResult(this, grantResults, (String[]) Arrays.copyOf(permissions, permissions.length))) {
                finishWithFailed("Permission requestCode error");
            } else if (this.mHasSavedInstance) {
                restoreFragment();
            } else {
                startCameraFragment();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(8)).toArray(new String[0]);
        if (PermissionHelper.isPermissionGranted(this, this.mPostActionWhenDenied, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            if (this.mHasSavedInstance) {
                restoreFragment();
            } else {
                startCameraFragment();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        this.mScanDataModel.save(outState);
        super.onSaveInstanceState(outState);
    }

    @Override // android.app.Activity
    public void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        super.onTopResumedActivityChanged(isTopResumedActivity);
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        if (cameraFragment != null) {
            cameraFragment.onTopResumedActivityChanged(isTopResumedActivity);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    @SuppressLint({"SwitchIntDef"})
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == 20) {
            Logger.m7148i(TAG, "onTrimMemory : TRIM_MEMORY_UI_HIDDEN");
        } else {
            if (level != 40) {
                return;
            }
            Logger.m7148i(TAG, "onTrimMemory : TRIM_MEMORY_BACKGROUND");
        }
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        Logger.m7145d(TAG, "onUserInteraction");
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        if (cameraFragment == null) {
            return;
        }
        if (cameraFragment.isVisible()) {
            cameraFragment.restartCameraTimer();
        }
        super.onUserInteraction();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("CameraFragment");
        if (cameraFragment == null || !cameraFragment.isResumed()) {
            return;
        }
        cameraFragment.onWindowFocusChanged(hasFocus);
    }

    @Override // com.samsung.android.support.senl.docscan.detect.CameraFragment.Contract, com.samsung.android.support.senl.docscan.rectify.RectifyListFragment.Contract
    public void showRectifyEditView(@Nullable DocScanData docScanData, @Nullable String caller) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        if (((RectifyEditFragment) supportFragmentManager.findFragmentByTag(RectifyEditFragment.TAG)) == null && docScanData != null) {
            supportFragmentManager.beginTransaction().replace(C7976R.id.preview_container, new RectifyEditFragment(docScanData, this.mScanDataModel, caller), RectifyEditFragment.TAG).addToBackStack(caller).commitAllowingStateLoss();
        }
        Logger.m7145d(TAG, "showRectifyEditView");
    }

    @Override // com.samsung.android.support.senl.docscan.detect.CameraFragment.Contract
    public void showRectifyListView() {
        if (this.mScanDataModel.isScanDataEmpty()) {
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        RectifyListFragment rectifyListFragment = (RectifyListFragment) supportFragmentManager.findFragmentByTag("RectifyListFragment");
        if (rectifyListFragment == null) {
            rectifyListFragment = new RectifyListFragment(this.mScanDataModel);
            supportFragmentManager.beginTransaction().replace(C7976R.id.preview_container, rectifyListFragment, "RectifyListFragment").addToBackStack("CameraFragment").commitAllowingStateLoss();
        }
        rectifyListFragment.setContract(this);
        Logger.m7145d(TAG, "showRectifyListView");
    }
}
