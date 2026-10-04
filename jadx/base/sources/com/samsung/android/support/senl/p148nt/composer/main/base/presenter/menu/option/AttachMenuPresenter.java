package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.ImagePicker;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.PendingData;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AttachMenuPresenter implements ImagePicker.OnItemClickedListener, DialogInterface.OnDismissListener {
    private static final String PENDING_DATA_FILE_PATH = "PENDING_DATA_FILE_PATH";
    private static final String PENDING_DATA_FILE_URI = "PENDING_DATA_FILE_URI";
    private static final String TAG = Logger.createTag("AttachPresenter");
    protected Activity mActivity;
    private ComposerViewPresenter mCompViewPresenter;
    private ComposerModel mComposerModel;
    protected Fragment mFragment;
    protected Handler mHandler;
    protected ImagePicker mImagePicker;
    private ObjectManager mObjectManager;
    private PageManager mPageManager;
    private PendingData mPendingData;
    protected SoftInputManager mSoftInputManager;
    private TaskController mTaskController;

    private void handleCameraResult(int i) {
        PendingData pendingData = this.mPendingData;
        if (pendingData == null) {
            Logger.m11003i(TAG, "handleCameraResult# mPendingData is null");
            return;
        }
        if (i != -1) {
            Logger.m11003i(TAG, "handleCameraResult# resultCode is not ok");
            this.mPendingData.deleteFileForTakePicture();
            this.mPendingData.clear();
            return;
        }
        Uri takenPictureUri = pendingData.getTakenPictureUri();
        if (takenPictureUri == null) {
            Logger.m11003i(TAG, "handleCameraResult# uri is null");
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(takenPictureUri);
        Logger.addFileLog(TAG, "Camera:insert", 0);
        insertImage(arrayList);
        if (this.mPendingData.getTakenPictureFilePath() != null) {
            MediaScannerConnection.scanFile(this.mActivity, new String[]{this.mPendingData.getTakenPictureFilePath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.AttachMenuPresenter.2
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    Logger.m11000e(AttachMenuPresenter.TAG, "onScanCompleted#");
                }
            });
        }
    }

    private void handleGalleryResult(Intent intent, int i) {
        List<Uri> urisFromResult = this.mImagePicker.getUrisFromResult(intent, i);
        String str = TAG;
        StringBuilder sb = new StringBuilder("Gallery:");
        sb.append(urisFromResult != null ? urisFromResult.size() : 0);
        Logger.addFileLog(str, sb.toString(), 0);
        addImage(urisFromResult);
    }

    private void insertImage(List<Uri> list) {
        this.mSoftInputManager.removeCallbackForceToShow();
        this.mTaskController.execute(new TaskAddImage(), new TaskAddImage.InputValues(this.mActivity, this.mPageManager.getDocPageInfo().getCurrentPageIndex(), list, this.mObjectManager, this.mComposerModel), new Task.Callback<TaskAddImage.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.AttachMenuPresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddImage.ResultValues resultValues) {
                Logger.m11000e(AttachMenuPresenter.TAG, "TaskDownloadImage#onError# " + resultValues.getErrorCode());
                if (AttachMenuPresenter.this.mPendingData != null) {
                    AttachMenuPresenter.this.mPendingData.deleteFileForTakePicture();
                    AttachMenuPresenter.this.mPendingData.clear();
                }
                resultValues.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddImage.ResultValues resultValues) {
                Logger.m11003i(AttachMenuPresenter.TAG, "TaskDownloadImage#onSuccess# ");
                if (AttachMenuPresenter.this.mPendingData != null) {
                    AttachMenuPresenter.this.mPendingData.clear();
                }
                resultValues.showErrorToast();
            }
        }, false);
    }

    public void addImage(List<Uri> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        insertImage(list);
    }

    public void hide() {
        ImagePicker imagePicker = this.mImagePicker;
        if (imagePicker != null && imagePicker.isShowing()) {
            this.mImagePicker.hide();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void init(ControllerManager controllerManager, PageManager pageManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel) {
        this.mCompViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mTaskController = controllerManager.getTaskController();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mPageManager = pageManager;
        ImagePicker imagePicker = new ImagePicker();
        this.mImagePicker = imagePicker;
        imagePicker.setGalleryPickMaxItemCount(100);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i == 30000) {
            this.mSoftInputManager.clearLastState();
            handleGalleryResult(intent, i2);
            return true;
        }
        if (i != 30001) {
            return false;
        }
        this.mSoftInputManager.clearLastState();
        handleCameraResult(i2);
        Logger.printMemory(TAG, "onActivityResult CAMERA");
        return true;
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
    }

    public void onDetachView() {
        this.mActivity = null;
        hide();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.mSoftInputManager.blockToShow(false, "Attach Menu onDismiss");
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.OnItemClickedListener
    public void onItemClicked(int i, @Nullable PendingData pendingData) {
        Logger.m11003i(TAG, "onItemClicked# " + i + " " + pendingData);
        this.mPendingData = pendingData;
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        return this.mImagePicker.onRequestPermissionsResult(this.mActivity, i, strArr, iArr, this.mPendingData);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        PendingData pendingData = this.mPendingData;
        if (pendingData == null) {
            Logger.m11003i(TAG, "onSaveInstanceState# mPendingData is null");
            return;
        }
        String takenPictureFilePath = pendingData.getTakenPictureFilePath();
        Uri takenPictureUri = this.mPendingData.getTakenPictureUri();
        if (TextUtils.isEmpty(takenPictureFilePath) || takenPictureUri == null) {
            return;
        }
        bundle.putString(PENDING_DATA_FILE_PATH, takenPictureFilePath);
        bundle.putString(PENDING_DATA_FILE_URI, takenPictureUri.toString());
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.OnItemClickedListener
    public void printMemory() {
        Logger.printMemory(TAG, "onItemClicked CAMERA");
    }

    public void restoreState(Bundle bundle) {
        String string = bundle.getString(PENDING_DATA_FILE_PATH, null);
        String string2 = bundle.getString(PENDING_DATA_FILE_URI, null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || this.mPendingData != null) {
            return;
        }
        PendingData pendingData = new PendingData();
        this.mPendingData = pendingData;
        pendingData.setTakenPictureFilePath(string);
        this.mPendingData.setTakenPictureFileUri(string2);
        Logger.m11003i(TAG, "restoreState : mPendingData set");
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.picker.image.ImagePicker.OnItemClickedListener
    public void setRequestCode(int i) {
        this.mCompViewPresenter.getComposerModel().getComposerState().setLastRequestCode(i);
    }

    public void show(int i, final int i2) {
        if (this.mHandler == null) {
            this.mHandler = new Handler();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.AttachMenuPresenter.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                AttachMenuPresenter attachMenuPresenter = AttachMenuPresenter.this;
                if (attachMenuPresenter.mFragment == null) {
                    return;
                }
                attachMenuPresenter.mSoftInputManager.blockToShow(true, "Attach Menu Show#addImage" + i2);
                AttachMenuPresenter attachMenuPresenter2 = AttachMenuPresenter.this;
                ImagePicker imagePicker = attachMenuPresenter2.mImagePicker;
                Fragment fragment = attachMenuPresenter2.mFragment;
                View viewFindViewById = attachMenuPresenter2.mActivity.findViewById(C9086R.id.toolbar);
                int i4 = i2;
                AttachMenuPresenter attachMenuPresenter3 = AttachMenuPresenter.this;
                if (imagePicker.show(fragment, viewFindViewById, i4, true, attachMenuPresenter3, attachMenuPresenter3)) {
                    return;
                }
                AttachMenuPresenter.this.mSoftInputManager.blockToShow(false, "Attach Menu Show#addImage" + i2);
            }
        }, i);
    }
}
