package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.Fragment;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScan;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanConfig;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanConstants;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanListener;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanOption;
import com.samsung.android.support.senl.docscan.DocumentScanActivity;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.docscan.common.util.FeatureUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.PolicyManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExecuteOtherActivityController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDocumentScan;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Restriction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuAddPresenter {
    private static final String TAG = Logger.createTag("OptionMenuAddPresenter");
    private Activity mActivity;
    private final ClipboardController mClipboardController;
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final DialogPresenterManager mDialogPresenterManager;
    private VexDocumentScan mDocumentScan;
    private final ExecuteOtherActivityController mExecuteOtherActivityController;
    private Fragment mFragment;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final ObjectManager mObjectManager;
    private final OptionMenuAudioFilePresenter mOptionMenuAudioFilePresenter;
    private final OptionMenuPdfPresenter mOptionMenuPdfPresenter;
    private final OptionMenuTextFilePresenter mOptionMenuTextFilePresenter;
    private OptionMenuVoiceRecordingsPresenter mOptionMenuVoiceRecordingsPresenter;
    private final PageManager mPageManager;
    private final SoftInputManager mSoftInputManager;
    private final boolean mStickyMemoEnabled;
    private final StickyMemoManager mStickyMemoManager;
    private final StorageChecker mStorageChecker;
    private final boolean mTableEnabled;
    private final TaskController mTaskController;
    private final VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C98123 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$support$senl$nt$composer$main$base$util$ComposerRequestCode */
        static final /* synthetic */ int[] f7003x1afc3a65;

        static {
            int[] iArr = new int[ComposerRequestCode.values().length];
            f7003x1afc3a65 = iArr;
            try {
                iArr[ComposerRequestCode.ConvertSpeechToText.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.AudioAddByMyFiles.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.AudioADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.TextAddByMyFiles.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.TextADD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.PDFChooser.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.BrushDrawing.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7003x1afc3a65[ComposerRequestCode.DocumentScan.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends ConfigurationFactory {
        @NonNull
        OptionMenuPdfPresenter createPdfPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ComposerModel composerModel, @NonNull ControllerManager controllerManager);
    }

    public OptionMenuAddPresenter(MenuPresenterContract.IMenuManager iMenuManager, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, ComposerModel composerModel, VoiceRecordMenuPresenter voiceRecordMenuPresenter, VexDocumentScan vexDocumentScan, StickyMemoManager stickyMemoManager, DialogPresenterManager dialogPresenterManager, @NonNull ComponentFactory componentFactory) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mMenuManager = iMenuManager;
        ObjectManager objectManager = composerViewPresenter.getObjectManager();
        this.mObjectManager = objectManager;
        PageManager pageManager = composerViewPresenter.getPageManager();
        this.mPageManager = pageManager;
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        this.mSoftInputManager = softInputManager;
        TaskController taskController = controllerManager.getTaskController();
        this.mTaskController = taskController;
        this.mExecuteOtherActivityController = controllerManager.getExecuteOtherActivityController();
        this.mClipboardController = controllerManager.getClipboardController();
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
        this.mStorageChecker = controllerManager.getStorageChecker();
        this.mOptionMenuAudioFilePresenter = new OptionMenuAudioFilePresenter(taskController, objectManager, pageManager, composerModel, softInputManager, voiceRecordMenuPresenter, componentFactory.getConfig().isAudioFileAttachable());
        this.mOptionMenuTextFilePresenter = new OptionMenuTextFilePresenter(taskController, composerViewPresenter.getNoteManager(), objectManager, composerModel);
        this.mOptionMenuPdfPresenter = componentFactory.createPdfPresenter(iMenuManager, composerViewPresenter, composerModel, controllerManager);
        this.mDocumentScan = vexDocumentScan;
        this.mStickyMemoManager = stickyMemoManager;
        this.mStickyMemoEnabled = componentFactory.getConfig().isStickyMemoEnabled();
        this.mTableEnabled = componentFactory.getConfig().isTableEnabled();
    }

    private void applyCoeditRestriction(File file) {
        File[] fileArrListFiles;
        int length;
        int largeSizeItemsCount;
        int largeSizeItemsCount2;
        if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() && (fileArrListFiles = file.listFiles()) != null && (length = fileArrListFiles.length) > (largeSizeItemsCount2 = 100 - (largeSizeItemsCount = this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount()))) {
            AbstractC8014b.m7195A(AbstractC0622a.m1173s(length, largeSizeItemsCount, "applyCoeditRestriction# i: ", " c: ", " a: "), TAG, largeSizeItemsCount2);
            if (largeSizeItemsCount2 <= 0) {
                for (File file2 : fileArrListFiles) {
                    file2.delete();
                }
            } else {
                int i = length - largeSizeItemsCount2;
                for (int i2 = 1; i2 <= i; i2++) {
                    fileArrListFiles[length - i2].delete();
                }
            }
            Restriction.showToastCoeditErrorOverLargeMaxCount(this.mActivity);
        }
    }

    private boolean canNotAdd() {
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() || this.mComposerModel.getComposerSpenDocModel().getLargeSizeItemsCount() < 100) {
            return false;
        }
        Logger.m11003i(TAG, "canNotAdd#");
        Restriction.showToastCoeditErrorOverLargeMaxCount(this.mActivity);
        return true;
    }

    private OptionMenuVoiceRecordingsPresenter getOptionMenuVoiceRecordings() {
        if (this.mOptionMenuVoiceRecordingsPresenter == null) {
            OptionMenuVoiceRecordingsPresenter optionMenuVoiceRecordingsPresenter = new OptionMenuVoiceRecordingsPresenter();
            this.mOptionMenuVoiceRecordingsPresenter = optionMenuVoiceRecordingsPresenter;
            optionMenuVoiceRecordingsPresenter.init(this.mActivity, this.mObjectManager, this.mFragment, this.mStorageChecker);
        }
        return this.mOptionMenuVoiceRecordingsPresenter;
    }

    private void handleBrushDrawingResult(Intent intent, int i) {
        SpenObjectBase paintingObjectWithPaintingDocPath;
        this.mExecuteOtherActivityController.releaseExecutedBrush();
        if (i != -1) {
            return;
        }
        String stringExtra = intent.getStringExtra("brush_input_thumbnail_path");
        String stringExtra2 = intent.getStringExtra("brush_output_thumbnail_path");
        String stringExtra3 = intent.getStringExtra("brush_input_painting_doc_path");
        String stringExtra4 = intent.getStringExtra("brush_output_painting_doc_path");
        String str = TAG;
        Logger.m10999d(str, "handleBrushResult thumbnailPath. " + stringExtra + SQLKeyword.COMMA + stringExtra2);
        Logger.m10999d(str, "handleBrushResult paintingDocPath. " + stringExtra3 + SQLKeyword.COMMA + stringExtra4);
        if (stringExtra != null && stringExtra.equals(stringExtra2)) {
            Logger.m10999d(str, "handleBrushResult same path");
            return;
        }
        if (stringExtra3 != null && this.mObjectManager.getClickedObject() == null && (paintingObjectWithPaintingDocPath = this.mExecuteOtherActivityController.getPaintingObjectWithPaintingDocPath(this.mComposerModel.getDoc(), stringExtra3)) != null) {
            this.mObjectManager.setClickedObject(paintingObjectWithPaintingDocPath);
        }
        this.mObjectManager.addPainting(this.mPageManager.getDocPageInfo().getCurrentPageIndex(), stringExtra, stringExtra2, stringExtra3, stringExtra4, this.mComposerModel.isTabletLayout(), this.mComposerModel.getModeManager().isEditMode());
        Logger.m10999d(str, "handleBrushResult Ok");
    }

    private void handleDocumentScanImageResult(Intent intent, int i) {
        if (i != -1) {
            return;
        }
        String stringExtra = intent.getStringExtra(Constant.INTENT_PATH_TO_SAVE);
        if (TextUtils.isEmpty(stringExtra)) {
            Logger.m11000e(TAG, "handleDocumentScanImageResult# " + Logger.getEncode(stringExtra));
            return;
        }
        File file = new File(stringExtra);
        if (!file.exists() || !file.isDirectory()) {
            Logger.m11000e(TAG, "handleDocumentScanImageResult# not exist or not directory");
            return;
        }
        applyCoeditRestriction(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            Logger.m11003i(TAG, "handleDocumentScanImageResult# list is empty by coedit restriction");
            return;
        }
        this.mSoftInputManager.removeCallbackForceToShow();
        this.mTaskController.execute(new TaskDocumentScan(), new TaskDocumentScan.InputValues(this.mObjectManager, stringExtra, this.mPageManager.getDocPageInfo().getCurrentPageIndex()), new Task.Callback<TaskDocumentScan.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDocumentScan.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDocumentScan.ResultValues resultValues) {
                resultValues.clearSrcDir();
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDocumentScanResult(Intent intent, String str) {
        Uri uri = (Uri) intent.getParcelableExtra(VexDocumentScanConstants.KEY_PDF_URI);
        if (uri != null) {
            Logger.m10999d(TAG, "handleDocumentScanResult#PDF");
            this.mOptionMenuPdfPresenter.handlePdfUri(new OptionMenuPdfPresenter.ParamFactory(Collections.singletonList(uri), null).create());
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(VexDocumentScanConstants.KEY_SCANNED_DOCUMENT_BUNDLES);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            return;
        }
        Logger.m10999d(TAG, "handleDocumentScanResult#Image scanResultList size : " + parcelableArrayListExtra.size());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(this.mComposerModel.getDocInfo().getUuid());
        sb.append(str2);
        String string = sb.toString();
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            saveImageForVexScanner((Uri) ((Bundle) it.next()).getParcelable(VexDocumentScanConstants.KEY_RECTIFIED_IMAGE_URI), string);
        }
        Intent intent2 = new Intent();
        intent2.putExtra(Constant.INTENT_PATH_TO_SAVE, string);
        handleDocumentScanImageResult(intent2, -1);
    }

    private boolean isMultiplePdf() {
        return !this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCameraImage$1() {
        preAction(true);
        releaseReadMode("addCameraImage");
        releaseMoveOnlyMode();
        this.mMenuManager.onEvent(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addImage$0() {
        preAction(true);
        releaseReadMode("addImage");
        releaseMoveOnlyMode();
        this.mMenuManager.onEvent(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPdf$4() {
        preAction(false);
        releaseReadMode("addPdf");
        releaseMoveOnlyMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPdf$5() {
        this.mComposerModel.getComposerState().setLastRequestCode(ComposerRequestCode.PDFChooser.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addScan$2(String[] strArr) {
        PermissionHelper.requestPermissions(this.mFragment, 116, strArr);
    }

    private void preAction(boolean z) {
        preAction(z, true);
    }

    private void releaseMoveOnlyMode() {
        if (this.mComposerModel.getModeManager().isMoveOnlyMode()) {
            this.mComposerModel.getModeManager().setSubMode(ModeManager.SubMode.NONE, false);
        }
    }

    private void releaseReadMode(String str) {
        if (this.mComposerModel.getModeManager().isMode(Mode.ReadOnly)) {
            Mode prevMode = this.mComposerModel.getModeManager().getPrevMode();
            if (prevMode == Mode.Search) {
                this.mComposerModel.getModeManager().setMode(this.mComposerModel.getModeManager().getLastEditMode(), AbstractC2322a.m1626p(new StringBuilder(), TAG, ContentUtils.HASH_SYMBOL, str), true);
            } else {
                this.mComposerModel.getModeManager().setMode(prevMode, AbstractC2322a.m1626p(new StringBuilder(), TAG, ContentUtils.HASH_SYMBOL, str), true);
            }
        }
    }

    private void saveImageForVexScanner(Uri uri, String str) {
        if (uri == null) {
            return;
        }
        String str2 = TAG;
        AbstractC8014b.m7196B("saveImageForVexScanner# filePath : ", str, str2);
        try {
            File file = new File(str);
            if (file.exists() || file.mkdir()) {
                File file2 = new File(file, System.currentTimeMillis() + ".jpg");
                try {
                    InputStream inputStreamOpenInputStream = this.mActivity.getContentResolver().openInputStream(uri);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            if (inputStreamOpenInputStream == null) {
                                Logger.m11000e(str2, "saveImageForVexScanner# inputStream is null");
                                fileOutputStream.close();
                                if (inputStreamOpenInputStream == null) {
                                    return;
                                }
                            } else {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStreamOpenInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, i);
                                    }
                                }
                                fileOutputStream.close();
                            }
                            inputStreamOpenInputStream.close();
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException e) {
                    AbstractC8014b.m7204f(e, new StringBuilder("saveImageForVexScanner# e :"), TAG);
                }
            }
        } catch (Exception e2) {
            AbstractC8014b.m7205g(e2, new StringBuilder("saveImageForVexScanner# imageFile e :"), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startForDocumentScan, reason: merged with bridge method [inline-methods] */
    public void lambda$addScan$3(final String str) {
        boolean zIsAvailable = VexDocumentScan.isAvailable(this.mActivity);
        AbstractC8014b.m7220v("startForDocumentScan# isAvailable : ", TAG, zIsAvailable);
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mActivity)) {
            Restriction.showToastNotSupportDexScan(this.mActivity);
            return;
        }
        if (WindowManagerCompat.getInstance().getMultiWindowMode(this.mActivity) != 0) {
            Restriction.showToastNotSupportMultiWindowScan(this.mActivity);
            return;
        }
        if (this.mDocumentScan != null && zIsAvailable) {
            VexDocumentScanConfig vexDocumentScanConfig = new VexDocumentScanConfig();
            vexDocumentScanConfig.setScanMode(VexDocumentScanOption.ScanMode.SCAN_MODE_MULTI);
            vexDocumentScanConfig.setExternalStorageImport(false);
            try {
                this.mDocumentScan.start(vexDocumentScanConfig, new VexDocumentScanListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter.1
                    @Override // com.samsung.android.sdk.vexkit.scanner.VexDocumentScanListener
                    public void onCompleted(Intent intent) {
                        Logger.m10999d(OptionMenuAddPresenter.TAG, "startForDocumentScan#onCompleted#");
                        OptionMenuAddPresenter.this.handleDocumentScanResult(intent, str);
                    }

                    @Override // com.samsung.android.sdk.vexkit.scanner.VexDocumentScanListener
                    public void onError(String str2) {
                        AbstractC8014b.m7196B("startForDocumentScan#onError# ", str2, OptionMenuAddPresenter.TAG);
                    }
                });
                return;
            } catch (IllegalStateException e) {
                Logger.m10999d(TAG, "startForDocumentScan# e : " + e.getMessage());
                return;
            }
        }
        ComposerState composerState = this.mComposerModel.getComposerState();
        ComposerRequestCode composerRequestCode = ComposerRequestCode.DocumentScan;
        composerState.setLastRequestCode(composerRequestCode.getId());
        Intent intent = new Intent(this.mActivity, (Class<?>) DocumentScanActivity.class);
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        String str2 = File.separator;
        sbM1324q.append(str2);
        sbM1324q.append(this.mComposerModel.getDocInfo().getUuid());
        sbM1324q.append(str2);
        intent.putExtra(Constant.INTENT_PATH_TO_SAVE, sbM1324q.toString());
        intent.putExtra(Constant.INTENT_SDOC_UUID, this.mComposerModel.getDocInfo().getUuid());
        this.mActivity.startActivityForResult(intent, composerRequestCode.getId());
    }

    public void addAudioFile() {
        releaseReadMode("addAudio");
        preAction(true);
        if (canNotAdd()) {
            return;
        }
        this.mOptionMenuAudioFilePresenter.addAudioFile();
    }

    public void addAudioFileForConvertVoiceToText() {
        releaseReadMode("convertVoiceToText");
        preAction(true);
        if (canNotAdd()) {
            return;
        }
        this.mOptionMenuAudioFilePresenter.addAudioFileConvertSpeechToText();
    }

    public void addCameraImage() {
        if (canNotAdd()) {
            return;
        }
        ContentPickerUtils.startAttachActivityForResult(this.mFragment, 115, new RunnableC9842a(this, 0), PermissionCompat.getStoragePermissions(8));
    }

    public void addDrawing() {
        preAction(true);
        releaseReadMode("addDrawing");
        releaseMoveOnlyMode();
        this.mComposerViewPresenter.requestReadyForSave();
        if (canNotAdd()) {
            return;
        }
        this.mExecuteOtherActivityController.executeBrush("", null, null);
    }

    public void addImage() {
        if (isNotAvailableStorage() || canNotAdd()) {
            return;
        }
        ContentPickerUtils.startAttachActivityForResult(this.mFragment, 114, new RunnableC9842a(this, 3), PermissionCompat.getStoragePermissions(1));
    }

    public void addMath() {
        preAction(true);
        this.mObjectManager.addMath(this.mPageManager.getDocPageInfo().getCurrentPageIndex(), false);
        this.mComposerModel.getModeManager().setMode(Mode.Writing, AbstractC0622a.m1170p(TAG, "#addMath", new StringBuilder()), true);
    }

    public void addPdf() {
        if (ContentPickerUtils.canAddPdfFileMenu(this.mActivity)) {
            this.mStickyMemoManager.hideMemo(false, "4", false);
            ContentPickerUtils.startPdfPickerActivityForResult(this.mFragment, 122, ComposerRequestCode.PDFChooser.getId(), isMultiplePdf(), new RunnableC9842a(this, 1), new RunnableC9842a(this, 2));
        }
    }

    public void addScan() {
        if (PolicyManager.getCameraDisabled(this.mActivity) || canNotAdd()) {
            return;
        }
        if (!FeatureInfo.isVexScanSupported(this.mActivity.getApplicationContext())) {
            String[] storagePermissions = PermissionCompat.getStoragePermissions(8);
            if (!PermissionHelper.isPermissionGranted(this.mActivity, new RunnableC8515c(this, storagePermissions, 28), storagePermissions)) {
                return;
            }
        }
        preAction(true);
        releaseReadMode("addScan");
        releaseMoveOnlyMode();
        String docScanDir = ComposerCacheFileUtil.getDocScanDir(this.mActivity);
        if (docScanDir == null) {
            return;
        }
        if (!this.mSoftInputManager.isInputMethodShown()) {
            lambda$addScan$3(docScanDir);
        } else {
            this.mSoftInputManager.hide((View) null);
            this.mComposerViewPresenter.getHandler().postDelayed(new RunnableC8515c(this, docScanDir, 29), 300L);
        }
    }

    public void addStickyMemo() {
        releaseReadMode("addStickyMemo");
        preAction(false, false);
        this.mStickyMemoManager.addStickyMemo();
    }

    public void addTable() {
        this.mDialogPresenterManager.showTableDialog();
    }

    public void addTextBox() {
        releaseReadMode("addTextBox");
        releaseMoveOnlyMode();
        preAction(true);
        this.mSoftInputManager.blockToHide(true);
        this.mObjectManager.addTextBox(this.mPageManager.getDocPageInfo().getCurrentPageIndex());
        this.mSoftInputManager.blockToHide(false);
        this.mComposerModel.getModeManager().setMode(Mode.Text, "add textbox from optionmenu", true);
    }

    public void addTextFile() {
        releaseReadMode("addTextFile");
        preAction(true);
        this.mOptionMenuTextFilePresenter.addTextFile();
    }

    public void addVoice() {
        if (isNotAvailableStorage()) {
            return;
        }
        Logger.addFileLog(TAG, "addVoice", 0);
        releaseReadMode("addVoice");
        preAction(true);
        if (VoiceManager.isRecordingActivated()) {
            this.mVoiceRecordMenuPresenter.updateStatusAnimation(true);
        }
        if (getOptionMenuVoiceRecordings().addVoiceRecordings()) {
            this.mVoiceRecordMenuPresenter.hide();
            this.mVoiceRecordMenuPresenter.showRecordingView();
        }
        this.mVoiceRecordMenuPresenter.updateStatusAnimation(false);
    }

    public void createTable(int i, int i2) {
        releaseReadMode("addTable");
        preAction(false);
        ModeManager modeManager = this.mComposerModel.getModeManager();
        Mode mode = Mode.Text;
        if (!modeManager.isMode(mode)) {
            this.mComposerViewPresenter.getNoteManager().setCursorOnScreen(this.mPageManager.getDocPageInfo().getCurrentPageIndex());
            this.mComposerModel.getModeManager().setMode(mode, AbstractC0622a.m1170p(TAG, "#addTable", new StringBuilder()), true);
        }
        this.mObjectManager.createTable(this.mPageManager.getDocPageInfo().getCurrentPageIndex(), i, i2);
    }

    public OptionMenuPdfPresenter getOptionMenuPdfPresenter() {
        return this.mOptionMenuPdfPresenter;
    }

    public OptionMenuTextFilePresenter getOptionMenuTextFilePresenter() {
        return this.mOptionMenuTextFilePresenter;
    }

    public boolean isAudioFileEnabled() {
        return this.mOptionMenuAudioFilePresenter.canAddAudioFileMenu();
    }

    public boolean isCoeditNote() {
        return this.mComposerModel.getCoeditAdapter().isCoeditNote();
    }

    public boolean isNotAvailableStorage() {
        return this.mStorageChecker.checkAvailableStateToEdit(true, true, true) != 0;
    }

    public boolean isPDFEnabled() {
        return true;
    }

    public boolean isPermissionGrantedForVoiceRecordings() {
        return getOptionMenuVoiceRecordings().isPermissionGrantedForVoiceRecordings();
    }

    public boolean isStickyMemoEnabled() {
        return this.mStickyMemoEnabled && !this.mComposerModel.getMdeManager().getMdeInfo().isMde();
    }

    public boolean isSupportCamera() {
        return !this.mActivity.getPackageManager().queryIntentActivities(new Intent("android.media.action.IMAGE_CAPTURE"), 65536).isEmpty();
    }

    public boolean isSupportDocScan() {
        if (!FeatureUtils.supportSmartScanLib()) {
            return false;
        }
        if (FoldStateCompat.getInstance().getFoldType() != 2) {
            return true;
        }
        int foldState = this.mComposerModel.getComposerState().getFoldState();
        AbstractC0000a.m3D(foldState, "isSupportDocScan# foldState : ", TAG);
        return (foldState == 1 || foldState == 4) ? false : true;
    }

    public boolean isTableEnabled() {
        return this.mTableEnabled && !this.mComposerModel.getMdeManager().getMdeInfo().isMde();
    }

    public boolean isTextFileEnabled() {
        return false;
    }

    public boolean isVoiceEnabled() {
        return !this.mVoiceRecordMenuPresenter.isNotSupportedRecording();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        ComposerRequestCode composerRequestCode = ComposerRequestCode.get(i);
        if (intent == null) {
            Logger.m11000e(TAG, "intent in onActivityResult is null");
            if (composerRequestCode.equals(ComposerRequestCode.BrushDrawing) && this.mComposerModel.isRunningDrawing()) {
                this.mComposerModel.setRunningDrawing(false);
            }
            return false;
        }
        String str = TAG;
        Logger.addFileLog(str, "AddContent:" + composerRequestCode, 0);
        switch (C98123.f7003x1afc3a65[composerRequestCode.ordinal()]) {
            case 1:
            case 2:
            case 3:
                this.mOptionMenuAudioFilePresenter.handleAudioAddResult(this.mActivity, ContentPickerUtils.getUriFromSingleData(intent), ContentPickerUtils.getTitleFromSingleData(intent), i2, composerRequestCode.equals(ComposerRequestCode.ConvertSpeechToText));
                break;
            case 4:
            case 5:
                this.mOptionMenuTextFilePresenter.handleTextAddResult(this.mActivity, ContentPickerUtils.getUriListFromResult(intent), i2);
                break;
            case 6:
                this.mOptionMenuPdfPresenter.handlePdfResult(intent, i2);
                break;
            case 7:
                handleBrushDrawingResult(intent, i2);
                break;
            case 8:
                handleDocumentScanImageResult(intent, i2);
                break;
            default:
                Logger.m10999d(str, "onActivityResult default");
                break;
        }
        return false;
    }

    public void onAttachView(Activity activity, Fragment fragment) {
        this.mActivity = activity;
        this.mFragment = fragment;
        this.mOptionMenuAudioFilePresenter.onAttachView(activity, fragment);
        this.mOptionMenuTextFilePresenter.onAttachView(activity, fragment);
        this.mOptionMenuPdfPresenter.onAttachView(activity);
    }

    public void onDetachView() {
        this.mActivity = null;
        this.mFragment = null;
        this.mOptionMenuAudioFilePresenter.onDetachView();
        this.mOptionMenuTextFilePresenter.onDetachView();
        this.mOptionMenuPdfPresenter.onDetachView();
    }

    public boolean onRequestPermissionsResult(int i) {
        if (i == 121) {
            this.mOptionMenuAudioFilePresenter.addAudioFile();
            return true;
        }
        if (i == 122) {
            addPdf();
            return true;
        }
        if (i == 133) {
            this.mOptionMenuAudioFilePresenter.addAudioFileConvertSpeechToText();
            return true;
        }
        switch (i) {
            case 113:
                addVoice();
                break;
            case 114:
                addImage();
                break;
            case 115:
                addCameraImage();
                break;
            case 116:
                addScan();
                break;
        }
        return true;
    }

    public void setDocumentScan(VexDocumentScan vexDocumentScan) {
        this.mDocumentScan = vexDocumentScan;
    }

    private void preAction(boolean z, boolean z2) {
        if (z2) {
            this.mStickyMemoManager.hideMemo(false, "4", false);
        }
        this.mClipboardController.closeClipboard();
        if (z && this.mObjectManager.isFocusedTextBox()) {
            this.mObjectManager.getTextManager().clearSelection();
        } else {
            this.mObjectManager.clearSelectObject(z);
        }
    }
}
