package com.samsung.android.support.senl.p148nt.app.trigger;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.DialogFragment;
import androidx.work.multiprocess.C4148a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.common.constants.WidgetConstant;
import com.samsung.android.support.senl.p145cm.base.common.constants.LockType;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AddonsHandler;
import com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener;
import com.samsung.android.support.senl.p148nt.app.common.dialog.AppUpdateDialogFragment;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.SettingsSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.NoteListToDrag;
import com.samsung.android.support.senl.p148nt.app.converter.ConverterDialogManager;
import com.samsung.android.support.senl.p148nt.app.lock.LockManager;
import com.samsung.android.support.senl.p148nt.app.lock.helper.ILockHelper;
import com.samsung.android.support.senl.p148nt.app.lock.view.convert.VerifyConvertPasswordDialog;
import com.samsung.android.support.senl.p148nt.app.trigger.lock.TriggerLockHelper;
import com.samsung.android.support.senl.p148nt.app.trigger.task.TriggerImportTask;
import com.samsung.android.support.senl.p148nt.app.trigger.task.TriggerListCreationTask;
import com.samsung.android.support.senl.p148nt.app.trigger.task.TriggerPdfCheckerTask;
import com.samsung.android.support.senl.p148nt.app.updater.UpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTask;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskGroup;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertTaskResult;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;
import java.util.List;
import java.util.Map;
import p012C1.RunnableC0050f;
import p084U0.AbstractC0311c;
import p084U0.C0312d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DocOpenTriggerActivity extends AppCompatActivity {
    private static final String TAG = "DocOpenTriggerActivity";
    private AddonsHandler mAddonsHandler;
    private ConverterDialogManager mDialogManager;
    private TriggerImportTask mImportTask;
    private TriggerListCreationTask mListTask;
    private TriggerLockHelper mLockHelper;
    private TriggerPdfCheckerTask mPdfDownloadTask;
    final TriggerIntentHandler mIntentHandler = new TriggerIntentHandler();
    private boolean mIsTriggered = false;
    private boolean mIsConverterCalled = false;
    private boolean mIsResultHandled = false;
    private boolean mIsStorageAvailable = true;
    private boolean mIsAppUpdateShowing = false;
    private final ConvertTaskGroup.IGroupTaskCallback mTaskCallback = new C88618();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C88596 implements TriggerImportTask.ICallback {
        final /* synthetic */ Uri val$uri;

        public C88596(Uri uri) {
            this.val$uri = uri;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailedUnsupportedDocType$0(Uri uri) {
            if (DocOpenTriggerActivity.this.isDestroyed()) {
                return;
            }
            DocOpenTriggerActivity.this.openPDF(uri);
        }

        private boolean needNotUseViewMode(Intent intent) {
            return !intent.getBooleanExtra(ComposerConstants.ARG_USE_VIEW_MODE, true);
        }

        @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerImportTask.ICallback
        public void onFailed(String str) {
            DocOpenTriggerActivity.this.finish(str);
        }

        @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerImportTask.ICallback
        public void onFailedUnsupportedDocType(String str) {
            if (str.endsWith(Constants.PDF_EXTENSION_WITH_DOT)) {
                DocOpenTriggerActivity.runOnMainThread(new RunnableC8865b(this, this.val$uri, 2));
            } else {
                DocOpenTriggerActivity docOpenTriggerActivity = DocOpenTriggerActivity.this;
                docOpenTriggerActivity.startConvert(ConvertTaskFactory.createTaskWithValidCheck(docOpenTriggerActivity, new ConvertInfo(str, hashCode()), null, DocOpenTriggerActivity.this.mTaskCallback));
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerImportTask.ICallback
        public void onFailedWithError(boolean z, String str) {
            if (z) {
                AbstractC4539a.m3206p("onFailedWithError,  msg : ", str, DocOpenTriggerActivity.TAG);
                DocOpenTriggerActivity.this.showAppUpdateDialog();
            } else if (TriggerImportTask.MSG_STORAGE_IS_FULL.equals(str)) {
                DocOpenTriggerActivity.this.finishWithErrorToast(DeviceUtils.isTabletModel() ? C8003R.string.clear_some_space_for_tablet : C8003R.string.clear_some_space_for_phone, str);
            } else {
                DocOpenTriggerActivity.this.finishWithErrorToast(str);
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerImportTask.ICallback
        public void onSdocImported(String str) {
            MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(DocOpenTriggerActivity.this).createMainListDocumentDataRepository().get(str);
            if (mainListDocumentData != null) {
                DocOpenTriggerActivity.this.openSDocWithCheckOldLock(str, mainListDocumentData.getIsLock());
                return;
            }
            DocOpenTriggerActivity.this.finishWithErrorToast("onSDocImported, fail to get entity: " + str);
        }

        @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerImportTask.ICallback
        public void onSdocxImported(String str) {
            if (!needNotUseViewMode(DocOpenTriggerActivity.this.getIntent())) {
                DocOpenTriggerActivity.this.startComposerActivity(str);
                return;
            }
            Logger.m8702i(DocOpenTriggerActivity.TAG, "needNotUseViewMode is true ");
            DocOpenTriggerActivity docOpenTriggerActivity = DocOpenTriggerActivity.this;
            Intent startComposerIntent = docOpenTriggerActivity.mIntentHandler.getStartComposerIntent(docOpenTriggerActivity, new Intent(), str, false);
            startComposerIntent.setAction(ComposerConstants.ACTION_OPEN_MEMO);
            startComposerIntent.putExtra(ComposerConstants.ARG_USE_VIEW_MODE, false);
            DocOpenTriggerActivity.this.startComposerActivity(startComposerIntent);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity$8 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C88618 implements ConvertTaskGroup.IGroupTaskCallback {
        public C88618() {
        }

        private int getLockType(int i) {
            if (i != 1) {
                return i != 2 ? 0 : 3;
            }
            return 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreFailed$0(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
            if (DocOpenTriggerActivity.this.mDialogManager != null) {
                DocOpenTriggerActivity.this.mDialogManager.showPasswordDialog(errorMsg.getPath(), getLockType(errorMsg.getSrcType()), false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPreFailed$1(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
            if (DocOpenTriggerActivity.this.mDialogManager != null) {
                DocOpenTriggerActivity.this.mDialogManager.showSaveConfirmDialog(errorMsg.getPath());
            }
        }

        private void onPostFailed() {
            DocOpenTriggerActivity.this.finishWithErrorToast(StorageUtils.isAvailableMemoryForNewMemo() ? C8003R.string.unable_to_open_note : C8003R.string.unable_to_create_note, "onPostFailed");
        }

        private void onPostSuccess(IConvertResult iConvertResult) {
            DocOpenTriggerActivity.this.showSuccessToast();
            if (iConvertResult.hasMultipleUuids()) {
                DocOpenTriggerActivity.this.startMemoListActivity();
                return;
            }
            String uuid = iConvertResult.getUuid();
            if (NotesDataRepositoryFactory.newInstance(DocOpenTriggerActivity.this).createMainListDocumentDataRepository().get(uuid).getIsLock() == 0) {
                DocOpenTriggerActivity.this.openConvertedNote(uuid);
            } else {
                DocOpenTriggerActivity.this.startMemoListAndRequestComposer(uuid);
            }
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
        public void onCreated() {
            if (DocOpenTriggerActivity.this.isFinishing()) {
                return;
            }
            DocOpenTriggerActivity.this.showConvertProgressDialog();
        }

        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskGroup.IGroupTaskCallback
        public void onEnd(boolean z, IConvertResult iConvertResult) {
            Logger.m8702i(DocOpenTriggerActivity.TAG, "ConvertTaskCallback, onEnd#, success : " + z);
            if (z) {
                onPostSuccess(iConvertResult);
            } else {
                onPostFailed();
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
            if (iConvertResult instanceof ConvertTaskResult) {
                onPostFailed();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPreFailed(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
            RunnableC8865b runnableC8865b;
            int status = errorMsg.getStatus();
            AbstractC4539a.m3203m(status, "ConvertTaskCallback, onPreFailed#, status : ", DocOpenTriggerActivity.TAG);
            if (status != 2) {
                if (status == 3) {
                    runnableC8865b = new RunnableC8865b(this, errorMsg, 0);
                } else if (status == 4) {
                    runnableC8865b = new RunnableC8865b(this, errorMsg, 1);
                } else if (status == 7) {
                    DocOpenTriggerActivity.this.finish("onPreFailed#, unsupported file type");
                }
                if (runnableC8865b != null) {
                    return;
                }
                DocOpenTriggerActivity.runOnMainThread(runnableC8865b);
                return;
            }
            DocOpenTriggerActivity.this.startMemoListActivity();
            runnableC8865b = null;
            if (runnableC8865b != null) {
            }
        }

        @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
        public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
            if ((iConvertResult instanceof ConvertTaskResult) && iConvertResult.getDstType() == 9) {
                onPostSuccess(iConvertResult);
            }
        }
    }

    private void convertFromUri(Uri uri) {
        if (uri == null) {
            finish("convertFromUri, uri is null");
            return;
        }
        if (UriFileUtils.isUnsupportedUriContent(uri)) {
            finishWithErrorToast("UnsupportedUriContent");
            return;
        }
        String type = getContentResolver().getType(uri);
        Logger.m8702i(TAG, "convertFromUri, mimeType: " + type);
        if (Constants.MIME_PDF.equals(type) || Constants.MIME_PDF.equals(getIntent().getType())) {
            openPDF(uri);
        } else {
            if ("text/plain".equals(getContentResolver().getType(uri))) {
                openText(uri);
                return;
            }
            TriggerImportTask triggerImportTask = new TriggerImportTask(this, this.mDialogManager, new C88596(uri));
            this.mImportTask = triggerImportTask;
            triggerImportTask.execute(uri);
        }
    }

    private void convertFromWidget(Intent intent) {
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        if (!TextUtils.isEmpty(stringExtra)) {
            startConvert(ConvertTaskFactory.createTaskWithValidCheck(this, new ConvertInfo(intent.getStringExtra("doc_path"), hashCode()).setUuid(stringExtra), null, new ConvertTaskFactory.IConvertTaskFactoryCallback() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.7
                @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
                public void onCreated() {
                    Logger.m8697d(DocOpenTriggerActivity.TAG, "convertFromWidget#onCreated#");
                    DocOpenTriggerActivity.this.showConvertProgressDialog();
                }

                @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
                public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                    DocOpenTriggerActivity.this.finish("convertFromWidget#onFailed#");
                }

                @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
                public void onPreFailed(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
                    DocOpenTriggerActivity.this.finish("convertFromWidget#onPreFailed# " + errorMsg.getStatus());
                }

                @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
                public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                    DocOpenTriggerActivity.this.showSuccessToast();
                    DocOpenTriggerActivity.this.finish("convertFromWidget#onSuccess#");
                }
            }));
        } else {
            finish("convertFromWidget, uuid is invalid : " + stringExtra);
        }
    }

    private void hideNavigationBar() {
        InputMethodCompat.getInstance().hideNavigationBar(this, getWindow().getDecorView());
    }

    private void initialize() {
        boolean zIsAvailableMemoryForNewMemo = StorageUtils.isAvailableMemoryForNewMemo();
        this.mIsStorageAvailable = zIsAvailableMemoryForNewMemo;
        if (!zIsAvailableMemoryForNewMemo) {
            DialogUtils.showNotEnoughStorageDialog(this, getString(C8003R.string.not_enough_space_content_for_open, getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.composer_save_to_image_dir_galaxy : C8003R.string.composer_save_to_image_dir)), new RunnableC8864a(this, 0));
            Logger.m8703w(TAG, "NotEnoughStorage, finish is will be called.");
            return;
        }
        this.mLockHelper = new TriggerLockHelper(this, new LockManager(new ILockManagerListener() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.1
            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordFail(int i, int i2, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onCreatePasswordSuccess(int i, Intent intent) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockFail(int i, int i2, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onLockSuccess(int i, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockFail(int i, int i2, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onUnlockSuccess(int i, Intent intent, String... strArr) {
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifyFail(int i, int i2, String... strArr) {
                AbstractC4539a.m3203m(i, "onVerifyFail, requestCode : ", DocOpenTriggerActivity.TAG);
                if (i == 902 || i == 901) {
                    if (i2 == 8) {
                        PermissionHelper.requestPermissions(DocOpenTriggerActivity.this, 125, "android.permission.GET_ACCOUNTS");
                    } else {
                        DocOpenTriggerActivity.this.finish("onVerifyFail");
                    }
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.access.lock.ILockManagerListener
            public void onVerifySuccess(int i, Intent intent, String... strArr) {
                AbstractC4539a.m3203m(i, "onVerifySuccess, requestCode : ", DocOpenTriggerActivity.TAG);
                if (i == 902) {
                    if (intent != null && strArr.length != 0) {
                        DocOpenTriggerActivity docOpenTriggerActivity = DocOpenTriggerActivity.this;
                        docOpenTriggerActivity.startComposerActivity(docOpenTriggerActivity.mIntentHandler.getStartComposerIntentAfterUnlock(docOpenTriggerActivity, intent));
                        return;
                    } else {
                        DocOpenTriggerActivity.this.finish("onVerifySuccess, data or uuid list is invalid#, length : " + strArr.length);
                        return;
                    }
                }
                if (i == 901) {
                    if (intent == null || strArr.length == 0) {
                        DocOpenTriggerActivity.this.finish("onVerifySuccess, data or uuid list is invalid#, length : " + strArr.length);
                        return;
                    }
                    if (TextUtils.isEmpty(strArr[0])) {
                        DocOpenTriggerActivity.this.finish("onVerifySuccess, uuid is invalid");
                    } else {
                        DocOpenTriggerActivity.this.mAddonsHandler.onActivityResult(i, -1, intent);
                    }
                }
            }
        }));
        this.mAddonsHandler = new AddonsHandler(this, new IAddonsListener() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.2
            @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
            @NonNull
            public ILockHelper getLockHelper() {
                return DocOpenTriggerActivity.this.mLockHelper;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
            public void onRequestOpenNote(boolean z, String str, String str2, String str3) {
                if (z) {
                    DocOpenTriggerActivity.this.startOldComposerActivity(str, str3);
                } else {
                    DocOpenTriggerActivity.this.showSuccessToast();
                    DocOpenTriggerActivity.this.openConvertedNote(str2);
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
            public void onStubUpdateTaskFinished() {
                DocOpenTriggerActivity.this.finish("onStubUpdateTaskFinished");
            }

            @Override // com.samsung.android.support.senl.p148nt.app.addons.IAddonsListener
            public void onTaskCanceled() {
                DocOpenTriggerActivity.this.finish("AddonsHandler#, onTaskCanceled()");
            }
        });
        ConverterDialogManager converterDialogManager = new ConverterDialogManager(this, hashCode());
        this.mDialogManager = converterDialogManager;
        converterDialogManager.setListener(new ConverterDialogManager.IDialogListener() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.3
            @Override // com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.IDialogListener
            public void onCancel() {
                DocOpenTriggerActivity.this.finish("onCancel()");
            }

            @Override // com.samsung.android.support.senl.nt.app.converter.ConverterDialogManager.IDialogListener
            public void requestConvert(String str, String str2) {
                Logger.m8697d(DocOpenTriggerActivity.TAG, "requestConvert");
                ConvertTaskManager convertTaskManager = ConvertTaskManager.getInstance();
                DocOpenTriggerActivity docOpenTriggerActivity = DocOpenTriggerActivity.this;
                convertTaskManager.put(ConvertTaskFactory.createTaskWithoutValidCheck(docOpenTriggerActivity, new ConvertInfo(str, docOpenTriggerActivity.hashCode()), str2, null, DocOpenTriggerActivity.this.mTaskCallback));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$0() {
        finish("NotEnoughStorage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$openDocument$1(final int i, List list, final List list2) {
        if (list.isEmpty()) {
            if (list2.isEmpty()) {
                startMemoListActivity();
                return;
            } else {
                startConvert(new ConvertTaskGroup(this, list2, i, -1, this.mTaskCallback));
                return;
            }
        }
        ConverterDialogManager converterDialogManager = this.mDialogManager;
        if (converterDialogManager == null) {
            return;
        }
        converterDialogManager.showImportProgressDialog();
        C0312d c0312d = new C0312d(getApplicationContext(), list, TAG);
        c0312d.f808m = new AbstractC0311c() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.4
            @Override // p084U0.InterfaceC0313e
            public void onFinish(int i2, int i4, @NonNull Map<String, Integer> map, int i5) {
                if (DocOpenTriggerActivity.this.mIsAppUpdateShowing) {
                    return;
                }
                if (DocOpenTriggerActivity.this.mDialogManager != null) {
                    DocOpenTriggerActivity.this.mDialogManager.dismiss();
                }
                if (list2.isEmpty()) {
                    DocOpenTriggerActivity.this.startMemoListActivity();
                    return;
                }
                DocOpenTriggerActivity docOpenTriggerActivity = DocOpenTriggerActivity.this;
                DocOpenTriggerActivity.this.startConvert(new ConvertTaskGroup(docOpenTriggerActivity, list2, i, -1, docOpenTriggerActivity.mTaskCallback));
            }

            @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
            public void onUnsupportedVersionError(@NonNull String str, @NonNull String str2) {
                DocOpenTriggerActivity.this.showAppUpdateDialog();
            }
        };
        c0312d.f806k = true;
        c0312d.m664c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showConvertProgressDialog$3() {
        ConverterDialogManager converterDialogManager = this.mDialogManager;
        if (converterDialogManager != null) {
            converterDialogManager.showConvertProgressDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showToast$2(int i) {
        ToastHandler.show(this, getResources().getString(i), 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openConvertedNote(String str) {
        startComposerActivity(str, true);
    }

    private void openDocumentByFinder(@NonNull String str, @Nullable String str2) {
        int iLastIndexOf = str.lastIndexOf(ExternalDataConstants.URI_PATH_FINDER_UUID);
        if (iLastIndexOf < 0) {
            finishWithErrorToast("openDocumentByFinder, invalid uri: " + Logger.getEncode(str));
            return;
        }
        int i = iLastIndexOf + 12;
        if (i > str.length()) {
            finishWithErrorToast("openDocumentByFinder, invalid uri: " + Logger.getEncode(str));
            return;
        }
        String strSubstring = str.substring(i);
        Intent startMemoListIntent = this.mIntentHandler.getStartMemoListIntent(this);
        startMemoListIntent.setAction(Constants.ACTION_VIEW_FROM_FINDER);
        startMemoListIntent.putExtra("intent_extra_data_key", strSubstring);
        startMemoListIntent.putExtra("query", str2);
        startMemoListActivity(startMemoListIntent);
        AbstractC4539a.m3188B("openDocumentByFinder, uuid: ", strSubstring, TAG);
    }

    private void openDocumentToDrag() {
        String uuidForNoteListToDrag = NoteListToDrag.getUuidForNoteListToDrag();
        NoteListToDrag.clearNoteListTodDrag(getApplicationContext());
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository().get(uuidForNoteListToDrag);
        if (mainListDocumentData == null) {
            finish("openDocumentToDrag, entry is null");
            return;
        }
        if (mainListDocumentData.getIsDeleted() != 0 || LockUtils.isLockedType(mainListDocumentData.getIsLock())) {
            finishWithErrorToast(C8003R.string.base_string_no_note, AbstractC0541b.m772n("openDocumentToDrag, entry is deleted or locked, uuid is invalid : ", uuidForNoteListToDrag));
        } else if (mainListDocumentData.isSDocX()) {
            startComposerActivity(uuidForNoteListToDrag, false);
        } else {
            startAddonsComposer(uuidForNoteListToDrag, mainListDocumentData.getFilePath(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openSDocWithCheckOldLock(String str, @LockType int i) {
        if (i == 2 || i == 3) {
            Logger.m8703w(TAG, "openSDocFromUUID, lock type is spd/snb");
            ToastHandler.show(this, C8003R.string.this_note_is_locked, 1);
            startMemoListActivity();
        } else {
            MainListDocumentDataRepository mainListDocumentDataRepositoryCreateMainListDocumentDataRepository = NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository();
            startAddonsComposer(str, mainListDocumentDataRepositoryCreateMainListDocumentDataRepository.getPath(str), getIntent().getStringExtra("highlighttext"));
        }
    }

    private void openText(Uri uri) {
        try {
            startActivity(this.mIntentHandler.getOpenTextIntent(this, uri));
            finish("openText : " + uri);
        } catch (SecurityException e) {
            finishWithErrorToast("openText, e : " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runOnMainThread(Runnable runnable) {
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() == mainLooper.getThread()) {
            runnable.run();
        } else {
            new Handler(mainLooper).post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAppUpdateDialog() {
        if (!this.mIsAppUpdateShowing) {
            this.mDialogManager.dismiss();
            this.mDialogManager.showAppUpdateDialog(new AppUpdateDialogFragment.AppUpdateDialogListener() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DocOpenTriggerActivity.this.finish();
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (-1 == i) {
                        UpdateManager.getInstance().goToGalaxyAppStore();
                    }
                    DocOpenTriggerActivity.this.finish();
                }
            });
        }
        this.mIsAppUpdateShowing = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConvertProgressDialog() {
        runOnMainThread(new RunnableC8864a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToastOnOpenReader(TriggerPdfCheckerTask.Result result) {
        if (result.getErrorCode() == 4194304) {
            ToastHandler.show(this, getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.composer_can_not_open_password_protected_pdf_for_galaxy : C8003R.string.composer_can_not_open_password_protected_pdf_opening), 0);
        } else if (result.getErrorCode() == 8388608) {
            ToastHandler.show(this, getResources().getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.composer_can_not_open_copyright_protected_pdf_for_galaxy : C8003R.string.composer_can_not_open_copyright_protected_pdf_opening), 0);
        } else {
            result.showErrorToast(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuccessToast() {
        if (FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING) {
            showToast(C8003R.string.base_string_convert_finish);
            NotesSamsungAnalytics.insertLog(SettingsSAConstants.SCREEN_OLDNOTES, NotesSAConstants.EVENT_OLDNOTES_CONVERT);
        }
    }

    private void showToast(int i) {
        runOnUiThread(new RunnableC0050f(this, i, 13));
    }

    private void startAddonsComposer(String str, String str2, String str3) {
        this.mAddonsHandler.startAddonComposer(str, str2, str3, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startComposerActivity(String str) {
        startComposerActivity(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConvert(ConvertTask convertTask) {
        this.mIsConverterCalled = true;
        ConvertTaskManager.connect(this);
        ConvertTaskManager.getInstance().put(convertTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMemoListActivity() {
        startMemoListActivity(this.mIntentHandler.getStartMemoListIntent(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMemoListAndRequestComposer(String str) {
        startActivity(this.mIntentHandler.getStartMemoListAndRequestComposerIntent(this, str));
        finish("startMemoListAndRequestComposer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOldComposerActivity(String str, String str2) {
        Intent startOldComposerIntent = this.mIntentHandler.getStartOldComposerIntent(this, new Intent(), str, str2);
        InputMethodCompat.getInstance().forceHideSoftInput(this);
        startActivityForResult(startOldComposerIntent, 4);
    }

    public void changeActivityFlags() {
        Intent intent = getIntent();
        int flags = intent.getFlags();
        AbstractC4539a.m3203m(flags, "changeActivityFlags flags: ", TAG);
        intent.setFlags(flags & (-16777217));
    }

    public boolean checkPermission() {
        return true;
    }

    public synchronized void finish(String str) {
        try {
            Logger.m8702i(TAG, "finish,  msg : " + str);
            TriggerImportTask triggerImportTask = this.mImportTask;
            if (triggerImportTask != null && !triggerImportTask.isCancelled()) {
                this.mImportTask.cancel(true);
                this.mImportTask = null;
            }
            TriggerListCreationTask triggerListCreationTask = this.mListTask;
            if (triggerListCreationTask != null && !triggerListCreationTask.isCancelled()) {
                this.mListTask.cancel(true);
                this.mListTask = null;
            }
            TriggerPdfCheckerTask triggerPdfCheckerTask = this.mPdfDownloadTask;
            if (triggerPdfCheckerTask != null && !triggerPdfCheckerTask.isCancelled()) {
                this.mPdfDownloadTask.cancel(true);
                this.mPdfDownloadTask = null;
            }
            if (!isDestroyed()) {
                ConverterDialogManager converterDialogManager = this.mDialogManager;
                if (converterDialogManager != null) {
                    converterDialogManager.dismiss();
                    this.mDialogManager = null;
                }
                finishAndRemoveTask();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void finishWithErrorToast(String str) {
        finishWithErrorToast(C8003R.string.unable_to_open_note, str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Logger.m8697d(TAG, "onActivityResult requestCode:" + i + ", resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        this.mIsResultHandled = true;
        TriggerLockHelper triggerLockHelper = this.mLockHelper;
        if (triggerLockHelper == null || !triggerLockHelper.onActivityResult(i, i2, intent)) {
            AddonsHandler addonsHandler = this.mAddonsHandler;
            if (addonsHandler != null && addonsHandler.onActivityResult(i, i2, intent)) {
                if (i2 == 0) {
                    finish("onActivityResult#, addons result is canceled");
                }
            } else {
                if (i != 4) {
                    finish("onActivityResult");
                    return;
                }
                if (i2 == -1) {
                    startComposerActivity(intent.getStringExtra("sdoc_uuid"));
                }
                finish("onActivityResult, old composer is finished");
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AddonsHandler addonsHandler = this.mAddonsHandler;
        if (addonsHandler == null || !addonsHandler.onBackPressed()) {
            super.onBackPressed();
            finish("onBackPressed");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.m8697d(TAG, "onCreate, trigger: " + hashCode());
        hideNavigationBar();
        TaskState.INSTANCE.getInstance().setIsRunning("TRIGGER", true);
        if (ModelStartManager.INSTANCE.isBlocked()) {
            finish("Trigger is blocked");
            return;
        }
        if (!this.mIntentHandler.isValid(getIntent())) {
            finish("Intent is invalid");
        } else if (!SpenSdkInitializer.initialize(this)) {
            finish("Fail to initialize spen");
        } else {
            PostLaunchManager.getInstance().executeBaseLogics();
            initialize();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Logger.m8697d(TAG, "onDestroy, trigger: " + hashCode());
        AddonsHandler addonsHandler = this.mAddonsHandler;
        if (addonsHandler != null) {
            addonsHandler.onDestroy();
        }
        TriggerLockHelper triggerLockHelper = this.mLockHelper;
        if (triggerLockHelper != null) {
            triggerLockHelper.onDestroy();
        }
        DialogFragment dialogFragment = (DialogFragment) getSupportFragmentManager().findFragmentByTag(VerifyConvertPasswordDialog.TAG);
        if (dialogFragment != null) {
            Logger.m8697d(TAG, "dismissVerifyDialog");
            dialogFragment.dismissAllowingStateLoss();
        }
        if (this.mIsConverterCalled) {
            ConvertTaskManager.disconnect();
        }
        TriggerPdfCheckerTask triggerPdfCheckerTask = this.mPdfDownloadTask;
        if (triggerPdfCheckerTask != null && !triggerPdfCheckerTask.isCancelled()) {
            this.mPdfDownloadTask.cancel(true);
            this.mPdfDownloadTask = null;
        }
        TaskState.INSTANCE.getInstance().setIsRunning("TRIGGER", false);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        AbstractC4539a.m3203m(i, "onRequestPermissionsResult, requestCode: ", TAG);
        if (i == 125) {
            if (PermissionHelper.verifyRequestResult(this, iArr, strArr)) {
                this.mLockHelper.restoreLockHelperTask();
            } else {
                finish("Permission Denied");
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        TriggerLockHelper triggerLockHelper = this.mLockHelper;
        if (triggerLockHelper != null) {
            triggerLockHelper.onRestoreInstanceState(bundle);
        }
        AddonsHandler addonsHandler = this.mAddonsHandler;
        if (addonsHandler != null) {
            addonsHandler.onRestoreInstanceState(bundle);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mIsResultHandled) {
            this.mIsResultHandled = false;
            Logger.m8697d(TAG, "onResume, activity result is handled");
        } else if (checkPermission()) {
            openDocument();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        TriggerLockHelper triggerLockHelper = this.mLockHelper;
        if (triggerLockHelper != null) {
            triggerLockHelper.onSaveInstanceState(bundle);
        }
        AddonsHandler addonsHandler = this.mAddonsHandler;
        if (addonsHandler != null) {
            addonsHandler.onSaveInstanceState(bundle);
        }
        super.onSaveInstanceState(bundle);
    }

    public synchronized void openDocument() {
        if (this.mIsTriggered) {
            Logger.m8697d(TAG, "openDocument, already triggered");
            return;
        }
        if (this.mIsStorageAvailable && this.mDialogManager != null && !CommonUtil.isNotAvailableActivity(this)) {
            this.mIsTriggered = true;
            Intent intent = getIntent();
            String action = intent.getAction();
            if ("android.intent.action.VIEW".equals(action) || ComposerConstants.ACTION_TRANSLATE.equals(action) || ComposerConstants.ACTION_SIMPLE_MODE.equals(action) || ComposerConstants.ACTION_EDIT_MODE.equals(action)) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.toString().contains(ExternalDataConstants.URI_PATH_FINDER_UUID)) {
                        openDocumentByFinder(data.toString(), intent.getStringExtra("query"));
                        return;
                    } else if (data.equals(NoteListToDrag.getFakedUriForNoteListToDrag())) {
                        openDocumentToDrag();
                        return;
                    }
                }
                convertFromUri(data);
            } else if (ComposerConstants.ACTION_OPEN_MEMO.equals(action)) {
                openDocument(intent);
            } else if (WidgetConstant.ACTION_MEMO_CONVERT.equals(action)) {
                convertFromWidget(intent);
            } else {
                ClipData clipData = intent.getClipData();
                if (clipData == null) {
                    return;
                }
                if (clipData.getItemCount() > 1) {
                    int iHashCode = hashCode();
                    TriggerListCreationTask triggerListCreationTask = new TriggerListCreationTask(this, this.mDialogManager, iHashCode, new C4148a(this, iHashCode, 2));
                    this.mListTask = triggerListCreationTask;
                    triggerListCreationTask.execute(clipData);
                } else {
                    convertFromUri(clipData.getItemAt(0).getUri());
                }
            }
            return;
        }
        Logger.m8697d(TAG, "openDocument, activity is destroyed");
    }

    public void openPDF(final Uri uri) {
        TriggerPdfCheckerTask triggerPdfCheckerTask = new TriggerPdfCheckerTask(this, this.mDialogManager, new TriggerPdfCheckerTask.Callback() { // from class: com.samsung.android.support.senl.nt.app.trigger.DocOpenTriggerActivity.9
            private void handleError(TriggerPdfCheckerTask.Result result) {
                result.showErrorToast(DocOpenTriggerActivity.this);
                DocOpenTriggerActivity.this.finish("download fail");
            }

            @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerPdfCheckerTask.Callback
            @MainThread
            public void onDone(TriggerPdfCheckerTask.Result result) {
                if (result == null) {
                    DocOpenTriggerActivity.this.finish("openPDF# result is null");
                    return;
                }
                DocOpenTriggerActivity.this.changeActivityFlags();
                if (result.isOpenReader()) {
                    if (!PermissionCompat.FEATURE_ENABLED_MANAGE_EXTERNAL_STORAGE) {
                        handleError(result);
                        return;
                    }
                    DocOpenTriggerActivity.this.showErrorToastOnOpenReader(result);
                    Intent intent = DocOpenTriggerActivity.this.getIntent();
                    intent.setFlags(intent.getFlags() & (-4097));
                    intent.addFlags(470286336);
                    intent.setClass(DocOpenTriggerActivity.this, PdfOnlyOpenTriggerActivity.class);
                    intent.putExtra(ComposerConstants.ARG_PDF_OPEN_PATH, result.getDownloadedPdfPath());
                    try {
                        DocOpenTriggerActivity.this.startActivity(intent);
                    } catch (SecurityException e) {
                        DocOpenTriggerActivity.this.finishWithErrorToast("openPDF, openReader, e : " + e.getMessage());
                        return;
                    }
                } else if (result.getErrorCode() != 0) {
                    handleError(result);
                } else {
                    try {
                        DocOpenTriggerActivity docOpenTriggerActivity = DocOpenTriggerActivity.this;
                        docOpenTriggerActivity.startActivity(docOpenTriggerActivity.mIntentHandler.getOpenPDFIntent(docOpenTriggerActivity, uri, result.getDownloadedPdfPath(), DocOpenTriggerActivity.this.getIntent()));
                    } catch (SecurityException e2) {
                        DocOpenTriggerActivity.this.finishWithErrorToast("openPDF, e : " + e2.getMessage());
                        return;
                    }
                }
                DocOpenTriggerActivity.this.finish("openPDF");
            }

            @Override // com.samsung.android.support.senl.nt.app.trigger.task.TriggerPdfCheckerTask.Callback
            public void onFailed(String str) {
                DocOpenTriggerActivity.this.finish(str);
            }
        });
        this.mPdfDownloadTask = triggerPdfCheckerTask;
        triggerPdfCheckerTask.execute(uri);
    }

    public void startComposerActivityByOption(Intent intent) {
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishWithErrorToast(int i, String str) {
        showToast(i);
        finish(str);
    }

    private void startComposerActivity(String str, boolean z) {
        startComposerActivity(this.mIntentHandler.getStartComposerIntent(this, new Intent(), str, z));
    }

    private void startMemoListActivity(Intent intent) {
        startActivity(intent);
        finish("startMemoListActivity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startComposerActivity(Intent intent) {
        InputMethodCompat.getInstance().forceHideSoftInput(this);
        startComposerActivityByOption(intent);
        finish("startComposerActivity, uuid : " + intent.getStringExtra("sdoc_uuid"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConvert(ConvertTaskGroup convertTaskGroup) {
        this.mIsConverterCalled = true;
        ConvertTaskManager.connect(this);
        ConvertTaskManager.getInstance().put(convertTaskGroup);
    }

    private void openDocument(Intent intent) {
        String uuid = this.mIntentHandler.getUuid(intent);
        if (TextUtils.isEmpty(uuid)) {
            finishWithErrorToast(C8003R.string.base_string_no_note, AbstractC0541b.m772n("openSDocFromUUID, uuid is invalid : ", uuid));
            return;
        }
        MainListDocumentData mainListDocumentData = NotesDataRepositoryFactory.newInstance(this).createMainListDocumentDataRepository().get(uuid);
        if (mainListDocumentData != null && mainListDocumentData.getIsDeleted() == 0) {
            int isLock = mainListDocumentData.getIsLock();
            if (!mainListDocumentData.isSDocX()) {
                openSDocWithCheckOldLock(uuid, isLock);
                return;
            } else if (isLock == 5) {
                this.mLockHelper.verifyLockedNote(902, this.mIntentHandler.getStartComposerIntentBeforeUnlock(this, getIntent(), uuid), uuid);
                return;
            } else {
                startComposerActivity(this.mIntentHandler.getStartComposerIntentForExistingDoc(this, getIntent(), uuid));
                return;
            }
        }
        finishWithErrorToast("openDocument");
    }
}
