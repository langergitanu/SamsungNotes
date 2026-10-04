package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.composer.voice.AudioFocus;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.support.senl.p145cm.base.framework.media.AudioManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuVoiceRecordingsPresenter {
    private static final String TAG = Logger.createTag("OptionMenuVoiceRecordingsPresenter");
    private Activity mActivity;
    private Fragment mFragment;
    private ObjectManager mObjectManager;
    private StorageChecker mStorageChecker;

    private boolean checkVoiceState() {
        if (!VoiceUtil.isAllowAudioRecord(this.mActivity)) {
            return false;
        }
        if (VoiceManager.isRecorderWorking() || AudioManagerCompat.getInstance().isRecordActive(this.mActivity)) {
            VoiceManager.toastVoiceMessage(SpenVoiceListenerManager.ERROR_ALREADY_RECORDER_WORKING);
            return false;
        }
        if (!AudioFocus.isCalling()) {
            return true;
        }
        VoiceManager.toastVoiceMessage(SpenVoiceListenerManager.ERROR_IS_CALLING_RECORD);
        return false;
    }

    public boolean addVoiceRecordings() {
        if (VoiceManager.isRecordingActivated()) {
            VoiceManager.stopRecording();
        }
        final String[] permissionsForRecordAudio = PermissionHelper.getPermissionsForRecordAudio();
        if (!PermissionHelper.isPermissionGranted(this.mActivity, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuVoiceRecordingsPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(OptionMenuVoiceRecordingsPresenter.TAG, "to get RECORD_AUDIO permission");
                PermissionHelper.requestPermissions(OptionMenuVoiceRecordingsPresenter.this.mFragment, 113, permissionsForRecordAudio);
            }
        }, permissionsForRecordAudio)) {
            return false;
        }
        if (!checkVoiceState()) {
            Logger.m10999d(TAG, "insert voice# voice state is not available");
            return false;
        }
        if (this.mStorageChecker.checkAvailableStateToEdit(true, true, true) != 0) {
            return false;
        }
        this.mObjectManager.insertVoiceData();
        return true;
    }

    public void init(Activity activity, ObjectManager objectManager, Fragment fragment, StorageChecker storageChecker) {
        this.mActivity = activity;
        this.mObjectManager = objectManager;
        this.mFragment = fragment;
        this.mStorageChecker = storageChecker;
    }

    public boolean isPermissionGrantedForVoiceRecordings() {
        return PermissionHelper.isPermissionGrantedWithoutNotice(this.mActivity, PermissionHelper.getPermissionsForRecordAudio());
    }
}
