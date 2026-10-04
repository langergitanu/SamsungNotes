package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddTextFile;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuTextFilePresenter {
    private static final String TAG = Logger.createTag("OptionMenuTextFilePresenter");
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private Fragment mFragment;
    private NoteManager mNoteManager;
    private ObjectManager mObjectManager;
    private TaskController mTaskController;

    public OptionMenuTextFilePresenter(TaskController taskController, NoteManager noteManager, ObjectManager objectManager, ComposerModel composerModel) {
        this.mTaskController = taskController;
        this.mNoteManager = noteManager;
        this.mObjectManager = objectManager;
        this.mComposerModel = composerModel;
    }

    public void addTextFile() {
        int id;
        String[] storagePermissions = PermissionCompat.getStoragePermissions(3);
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
            Logger.m10999d(TAG, "to get READ_EXTERNAL_STORAGE permission");
            PermissionHelper.requestPermissions(this.mFragment, 127, storagePermissions);
            return;
        }
        Intent intent = new Intent();
        if (CommonUtils.isPackageInstalledAndEnabled(this.mActivity, ContentPickerUtils.MYFILES_PACKAGE)) {
            intent.setAction("com.sec.android.app.myfiles.PICK_DATA");
            intent.putExtra("CONTENT_TYPE", "text/plain");
            id = ComposerRequestCode.TextAddByMyFiles.getId();
        } else {
            intent.setAction("android.intent.action.PICK");
            intent.setData(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
            id = ComposerRequestCode.TextADD.getId();
        }
        this.mActivity.startActivityForResult(intent, id);
        this.mComposerModel.getComposerState().setLastRequestCode(id);
    }

    public void handleTextAddResult(Context context, List<Uri> list, int i) {
        if (i != -1) {
            return;
        }
        handleTextAddResult(context, list);
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
    }

    public void handleTextAddResult(Context context, List<Uri> list) {
        NoteManager noteManager = this.mNoteManager;
        ObjectManager objectManager = this.mObjectManager;
        this.mTaskController.execute(new TaskAddTextFile(), new TaskAddTextFile.InputValues(context, noteManager, objectManager, list, objectManager.getCachePath()), new Task.Callback<TaskAddTextFile.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuTextFilePresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddTextFile.ResultValues resultValues) {
                Logger.m10999d(OptionMenuTextFilePresenter.TAG, "handleTextAddResult#onError");
                resultValues.showErrorToast(false);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddTextFile.ResultValues resultValues) {
                Logger.m10999d(OptionMenuTextFilePresenter.TAG, "handleTextAddResult#onSuccess");
                resultValues.updateTitle();
                resultValues.showErrorToast(false);
            }
        }, false);
    }
}
