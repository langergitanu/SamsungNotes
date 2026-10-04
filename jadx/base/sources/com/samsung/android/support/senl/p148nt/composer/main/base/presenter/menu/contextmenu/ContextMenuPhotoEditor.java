package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectFindUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPhotoEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuPhotoEditor extends ContextMenuItem {
    public static final String AGIF_EDITOR_ACTION = "com.sec.android.mimage.photoretouching.motionphoto";
    private static final int MIN_SUPPORTED_AGIF_VERSION_CODE = 310712001;
    private static final int MIN_SUPPORTED_PHOTO_VERSION_CODE = 302235001;
    public static final String PHOTO_EDITOR_ACTIVITY = "com.sec.android.mimage.photoretouching.SPEActivity";
    public static final String PHOTO_EDITOR_PACKAGE_NAME = "com.sec.android.mimage.photoretouching";
    private static final String TAG = Logger.createTag("ContextMenuPhotoEditor");
    private final ComposerModel mComposerModel;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    protected final ComposerViewPresenter mPresenter;
    private final TaskController mTaskController;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPhotoEditor$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C97601 implements Task.Callback<TaskPhotoEditor.ResultValues> {
        final /* synthetic */ SpenObjectImage val$image;

        public C97601(SpenObjectImage spenObjectImage) {
            this.val$image = spenObjectImage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0(TaskPhotoEditor.ResultValues resultValues, SpenObjectImage spenObjectImage, String str, Uri uri) {
            if (uri == null) {
                uri = UriFileUtils.getUriFromExtFilePath(ContextMenuPhotoEditor.this.mActivity, str);
            }
            if (uri == null) {
                Logger.m11000e(ContextMenuPhotoEditor.TAG, "onScanCompleted# uri is null");
                resultValues.clearImageStorageDir();
                return;
            }
            Logger.m11003i(ContextMenuPhotoEditor.TAG, "onScanCompleted# path: " + Logger.getEncode(str) + ", uri: " + Logger.getEncode(uri.toString()));
            ContextMenuPhotoEditor.this.startImageEditor(spenObjectImage.getId(), uri, str);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(TaskPhotoEditor.ResultValues resultValues) {
            ToastHandler.show(ContextMenuPhotoEditor.this.mActivity, C9086R.string.composer_failed_to_copy, 1);
            resultValues.clearImageStorageDir();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(final TaskPhotoEditor.ResultValues resultValues) {
            Activity activity = ContextMenuPhotoEditor.this.mActivity;
            String[] strArr = {resultValues.getImagePath()};
            final SpenObjectImage spenObjectImage = this.val$image;
            MediaScannerConnection.scanFile(activity, strArr, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.c
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri) {
                    this.f6999a.lambda$onSuccess$0(resultValues, spenObjectImage, str, uri);
                }
            });
            ContextMenuPhotoEditor.this.mObjectManager.clearSelectObject();
        }
    }

    public ContextMenuPhotoEditor(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mTaskController = controllerManager.getTaskController();
    }

    private void clearImageStorageDir() {
        TaskPhotoEditor taskPhotoEditor = new TaskPhotoEditor();
        this.mTaskController.execute(taskPhotoEditor, new TaskPhotoEditor.InputValues(this.mActivity), taskPhotoEditor.getDefaultCallback(), false);
    }

    private Intent createAgifEditorIntent() {
        Logger.m11003i(TAG, "createAgifEditorIntent#");
        Intent intent = new Intent(AGIF_EDITOR_ACTION);
        intent.setPackage(PHOTO_EDITOR_PACKAGE_NAME);
        return intent;
    }

    private Intent createPhotoEditorIntent() {
        Logger.m11003i(TAG, "createPhotoEditorIntent#");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(PHOTO_EDITOR_PACKAGE_NAME, PHOTO_EDITOR_ACTIVITY));
        intent.putExtra("service", "spe_draw");
        intent.putExtra("otherapps_service", true);
        return intent;
    }

    @NonNull
    private Intent getEditorIntent(String str, Uri uri, String str2) {
        Intent intentCreateAgifEditorIntent = isAgif(str2) ? createAgifEditorIntent() : createPhotoEditorIntent();
        intentCreateAgifEditorIntent.putExtra("filepath", uri);
        intentCreateAgifEditorIntent.putExtra("notes_service", true);
        intentCreateAgifEditorIntent.putExtra("notes_objectId", str);
        intentCreateAgifEditorIntent.addFlags(3);
        if (Build.VERSION.SDK_INT > 30) {
            this.mActivity.grantUriPermission(PHOTO_EDITOR_PACKAGE_NAME, uri, 3);
        }
        return intentCreateAgifEditorIntent;
    }

    private SpenObjectBase getFindSourceImageObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ObjectFindUtil.getObject(this.mComposerModel.getDoc(), 4, 3, str, new C8416h(7));
    }

    private PackageInfo getPhotoEditorPackageInfo(boolean z) {
        try {
            PackageInfo packageInfo = this.mActivity.getPackageManager().getPackageInfo(PHOTO_EDITOR_PACKAGE_NAME, 1);
            if (packageInfo == null || !packageInfo.applicationInfo.enabled) {
                Logger.m11003i(TAG, "getPhotoEditorPackageInfo# info is null or applicationInfo is not enabled");
                return null;
            }
            int i = z ? MIN_SUPPORTED_AGIF_VERSION_CODE : MIN_SUPPORTED_PHOTO_VERSION_CODE;
            if (i <= packageInfo.versionCode) {
                return packageInfo;
            }
            AbstractC8014b.m7195A(AbstractC0541b.m778t(i, "getPhotoEditorPackageInfo# minSupportedVersionCode - minSupport:", ", editor version:"), TAG, packageInfo.versionCode);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.m11001e(TAG, "getPhotoEditorPackageInfo# packageName:com.sec.android.mimage.photoretouching", e);
            return null;
        }
    }

    private boolean isAgif() {
        ArrayList<SpenObjectBase> selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList == null || selectedSafeObjectList.size() != 1) {
            return false;
        }
        SpenObjectBase spenObjectBase = selectedSafeObjectList.get(0);
        if (spenObjectBase.getType() != 3) {
            return false;
        }
        String imagePath = ((SpenObjectImage) spenObjectBase).getImagePath();
        if (!TextUtils.isEmpty(imagePath)) {
            return isAgif(imagePath);
        }
        Logger.m11003i(TAG, "isAgif# path is empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFindSourceImageObject$0(String str, SpenObjectBase spenObjectBase) {
        return str.equals(spenObjectBase.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startImageEditor(String str, Uri uri, String str2) {
        String str3 = TAG;
        Logger.m11003i(str3, "startImageEditor");
        if (this.mActivity == null) {
            Logger.m11000e(str3, "startImageEditor# mActivity is null");
            return;
        }
        Intent editorIntent = getEditorIntent(str, uri, str2);
        try {
            if (editorIntent.resolveActivity(this.mActivity.getPackageManager()) != null) {
                Activity activity = this.mActivity;
                ComposerRequestCode composerRequestCode = ComposerRequestCode.ImageEditor;
                activity.startActivityForResult(editorIntent, composerRequestCode.getId());
                this.mComposerModel.getComposerState().setLastRequestCode(composerRequestCode.getId());
            }
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "startImageEditor not founded " + editorIntent.getPackage() + ", e=" + e.getMessage());
        } catch (Exception e2) {
            AbstractC8014b.m7205g(e2, new StringBuilder("startImageEditor failed e="), TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        int i = isAgif() ? C9086R.string.composer_ctx_menu_agif_editor : C9086R.string.composer_ctx_menu_photo_editor;
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PHOTO_EDITOR;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), i).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        ArrayList<SpenObjectBase> selectedSafeObjectList;
        if (!this.mModeManager.isEditMode() || (selectedSafeObjectList = this.mObjectManager.getSelectedSafeObjectList()) == null || selectedSafeObjectList.size() != 1) {
            return false;
        }
        SpenObjectBase spenObjectBase = selectedSafeObjectList.get(0);
        if (spenObjectBase.getType() != 3) {
            return false;
        }
        String imagePath = ((SpenObjectImage) spenObjectBase).getImagePath();
        if (!TextUtils.isEmpty(imagePath)) {
            return isPhotoEditorEnabled(imagePath);
        }
        Logger.m11003i(TAG, "canShow# path is empty");
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m10999d(str, "executePhotoEditor#" + this.mObjectManager.getSelectedSafeObjectList().get(0).getType());
        SpenObjectImage spenObjectImage = (SpenObjectImage) this.mObjectManager.getSelectedSafeObjectList().get(0);
        this.mObjectManager.setClickedObject(spenObjectImage);
        this.mPresenter.requestReadyForSave();
        TaskPhotoEditor.InputValues inputValues = new TaskPhotoEditor.InputValues(this.mActivity, spenObjectImage);
        C97601 c97601 = new C97601(spenObjectImage);
        String[] storagePermissions = PermissionCompat.getStoragePermissions(6);
        if (PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
            this.mTaskController.execute(new TaskPhotoEditor(), inputValues, c97601, false);
            return;
        }
        Logger.m10999d(str, "executePhotoEditor# to get WRITE_EXTERNAL_STORAGE permission");
        Fragment fragmentFindFragmentByTag = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().findFragmentByTag("Composer");
        if (fragmentFindFragmentByTag != null) {
            PermissionHelper.requestPermissions(fragmentFindFragmentByTag, 126, storagePermissions);
            this.mTaskController.setPendingTask(new TaskPhotoEditor(), inputValues, c97601, false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isLockRelated() {
        return true;
    }

    public boolean isPhotoEditorEnabled(String str) {
        return getPhotoEditorPackageInfo(isAgif(str)) != null;
    }

    public void onActivityResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            clearImageStorageDir();
            Logger.m11000e(TAG, "onActivityResult# resultCode failed : " + i + " or data is null");
            return;
        }
        String stringExtra = intent.getStringExtra("output");
        if (stringExtra == null) {
            clearImageStorageDir();
            Logger.m11000e(TAG, "onActivityResult# outputImageFile is null");
            return;
        }
        if (!AbstractC2322a.m1607A(stringExtra)) {
            clearImageStorageDir();
            Logger.m11000e(TAG, "onActivityResult# outputImageFile not exist");
            return;
        }
        String stringExtra2 = intent.getStringExtra("notes_objectId");
        SpenObjectBase findSourceImageObject = getFindSourceImageObject(stringExtra2);
        if (findSourceImageObject == null || findSourceImageObject.getType() != 3 || !(findSourceImageObject instanceof SpenObjectImage)) {
            clearImageStorageDir();
            Logger.m11000e(TAG, "onActivityResult# imageObject is null");
            return;
        }
        SpenObjectImage spenObjectImage = (SpenObjectImage) findSourceImageObject;
        String str = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("onActivityResult# ", stringExtra2, " = ");
        sbM15l.append(Logger.getEncode(stringExtra));
        Logger.m11003i(str, sbM15l.toString());
        boolean z = (TextUtils.isEmpty(spenObjectImage.getOriginalImagePath()) || spenObjectImage.getOriginalRect() == null) ? false : true;
        spenObjectImage.setCropRect(null);
        spenObjectImage.setOriginalRect(null);
        spenObjectImage.setImage(stringExtra);
        if (z) {
            Logger.m11003i(str, "onActivityResult# hasLassoCrop is true.");
            spenObjectImage.setOriginalImage(null);
        }
        this.mObjectManager.commitHistory();
        clearImageStorageDir();
    }

    private boolean isAgif(String str) {
        return str.toLowerCase().endsWith(Constants.THUMBNAIL_GIF_EXTENSION);
    }
}
