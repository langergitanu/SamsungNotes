package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDownloadAudio;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.stt.picker.AudioPickerActivity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuAudioFilePresenter {
    private static final String TAG = Logger.createTag("OptionMenuAudioFilePresenter");
    private Activity mActivity;
    private final ComposerModel mComposerModel;
    private Fragment mFragment;
    private final boolean mIsAttachable;
    private final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    private final SoftInputManager mSoftInputManager;
    private final TaskController mTaskController;
    private final VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;

    public OptionMenuAudioFilePresenter(TaskController taskController, ObjectManager objectManager, PageManager pageManager, ComposerModel composerModel, SoftInputManager softInputManager, VoiceRecordMenuPresenter voiceRecordMenuPresenter, boolean z) {
        this.mTaskController = taskController;
        this.mObjectManager = objectManager;
        this.mPageManager = pageManager;
        this.mComposerModel = composerModel;
        this.mSoftInputManager = softInputManager;
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
        this.mIsAttachable = z;
    }

    public void addAudioFile() {
        int id;
        String[] storagePermissions = PermissionCompat.getStoragePermissions(2);
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
            Logger.m10999d(TAG, "to get READ_EXTERNAL_STORAGE permission");
            PermissionHelper.requestPermissions(this.mFragment, 121, storagePermissions);
            return;
        }
        Intent intent = new Intent();
        if (CommonUtils.isPackageInstalledAndEnabled(this.mActivity, ContentPickerUtils.MYFILES_PACKAGE)) {
            intent.setAction("com.sec.android.app.myfiles.PICK_DATA");
            intent.putExtra("CONTENT_TYPE", "audio/*;application/ogg");
            id = ComposerRequestCode.AudioAddByMyFiles.getId();
        } else {
            intent.setAction("android.intent.action.PICK");
            intent.setData(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
            id = ComposerRequestCode.AudioADD.getId();
        }
        this.mActivity.startActivityForResult(intent, id);
        this.mComposerModel.getComposerState().setLastRequestCode(id);
    }

    public void addAudioFileConvertSpeechToText() {
        String[] storagePermissions = PermissionCompat.getStoragePermissions(2);
        if (!PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, storagePermissions)) {
            Logger.m10999d(TAG, "to get READ_EXTERNAL_STORAGE permission");
            PermissionHelper.requestPermissions(this.mFragment, 133, storagePermissions);
            return;
        }
        Intent intent = new Intent(this.mActivity, (Class<?>) AudioPickerActivity.class);
        intent.putExtra(ContentPickerUtils.AUDIO_PICKER_MODE, 1);
        int id = ComposerRequestCode.ConvertSpeechToText.getId();
        this.mActivity.startActivityForResult(intent, id);
        this.mComposerModel.getComposerState().setLastRequestCode(id);
    }

    public boolean canAddAudioFileMenu() {
        if (!this.mIsAttachable) {
            return false;
        }
        if (CommonUtils.isPackageInstalledAndEnabled(this.mActivity, ContentPickerUtils.MYFILES_PACKAGE)) {
            return true;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setData(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        return !this.mActivity.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public void handleAudioAddResult(final Context context, Uri uri, String str, int i, final boolean z) {
        if (i != -1) {
            return;
        }
        this.mSoftInputManager.removeCallbackForceToShow();
        this.mTaskController.execute(new TaskDownloadAudio(), new TaskDownloadAudio.InputValues(context, this.mObjectManager.getCachePath(), uri, str), new Task.Callback<TaskDownloadAudio.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuAudioFilePresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDownloadAudio.ResultValues resultValues) {
                Logger.m11000e(OptionMenuAudioFilePresenter.TAG, "TaskDownloadAudio#onError# ");
                resultValues.showErrorDialog();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDownloadAudio.ResultValues resultValues) {
                Logger.m11003i(OptionMenuAudioFilePresenter.TAG, "TaskDownloadAudio#onSuccess# ");
                if (!z) {
                    if (OptionMenuAudioFilePresenter.this.mObjectManager.insertObjectVoice(OptionMenuAudioFilePresenter.this.mPageManager.getDocPageInfo().getCurrentPageIndex(), resultValues.getContentPath(), resultValues.getFileName())) {
                        return;
                    }
                    ToastHandler.show(context, C9086R.string.composer_failed_to_load_image, 0);
                    return;
                }
                Logger.m10999d(OptionMenuAudioFilePresenter.TAG, "TaskDownloadAudio#onSuccess# convertVoiceToText " + resultValues.getContentPath() + " / " + resultValues.getFileName());
                if (VoiceManager.isRecordingActivated()) {
                    VoiceManager.stopRecording();
                }
                OptionMenuAudioFilePresenter.this.mObjectManager.insertVoiceData(resultValues.getContentPath(), resultValues.getTitle());
                OptionMenuAudioFilePresenter.this.mVoiceRecordMenuPresenter.showRecordingPlayView(false);
                if (OptionMenuAudioFilePresenter.this.mVoiceRecordMenuPresenter.compareViewState(VoiceViewState.Type.LIST)) {
                    return;
                }
                OptionMenuAudioFilePresenter.this.mVoiceRecordMenuPresenter.expandRecordingListVerticalMenu();
            }
        }, false);
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
    }
}
