package com.samsung.android.support.senl.p148nt.app.labs;

import android.R;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.constructor.JavaInstanceConstructor;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.labs.actionbar.FragmentToolBarActivity;
import com.samsung.android.support.senl.p148nt.app.labs.collect.CollectStatus;
import com.samsung.android.support.senl.p148nt.app.labs.createnote.CreateNoteTester;
import com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo.ScreenOffMemoTester;
import com.samsung.android.support.senl.p148nt.app.sync.providers.SDocProviderDump;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.executor.ModelThreadPoolExecutor;
import com.samsung.android.support.senl.p148nt.model.restore.folder.FolderArrangeManager;
import com.samsung.android.support.senl.p148nt.model.utils.FeatureUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class LabsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String CLASS_NAME_COLLECT_SERVICE = "com.samsung.android.support.senl.nt.model.collector.CollectService";
    private static final String TAG = "LabsActivity";
    private DocumentTest mDocumentTest = new DocumentTest();
    private final Map<Integer, IActivityResultListener> mResultMap = new HashMap();
    private static final String COMMAND_TOGGLE_CMS_TEST = "Enable/Disable CMS Test";
    private static final String COMMAND_TOGGLE_FOR_DELETE_OLD_DOC_AFTER_CONVERTING = "Enable/Disable delete old doc after converting";
    private static final String COMMAND_IMPORT_PDF_TXT_FILES = "import pdf/txt files";
    private static final String COMMAND_EXTRACT_BODY_PDF_HW_TEXT = "extract BodyText/PDF/Hw Text";
    private static final String COMMAND_TOGGLE_AI_FOR_SETTING_PAGE = "Enable/Disable AI for settings page";
    private static final String COMMAND_GEN_AI_AUTO_TEST = "Gen AI Auto Test";
    private static final String COMMAND_CHECK_RECOGNITION_STATUS = "Check recognition status";
    private static final String COMMAND_TOGGLE_EDP_UI_TEST_1 = "Enable/Disable EDP Error UI Test";
    private static final String COMMAND_TOGGLE_EDP_UI_TEST_2 = "Enable/Disable EDP AppUpdate Test";
    private static final String COMMAND_TOGGLE_EDP_TEST = "Enable/Disable EDP Test";
    private static final String COMMAND_UPDATE_TIME_TO_THE_PAST = "Update Time to the past";
    private static final String COMMAND_CHECK_STORAGE_INFO = "Check Storage Info";
    private static final String COMMAND_TOGGLE_RECOGNITION_SLEEP = "Enable/Disable recognition sleep";
    private static final String COMMAND_IMPORT_DOCS = "Import docs (sdocx, sdoc)";
    private static final String COMMAND_STG_PROD_TOGGLE_COEDIT = "Toggle Stg coedit";
    private static final String COMMAND_VALIDATION_TOGGLE_COEDIT = "Toggle Validation coedit";
    private static final String COMMAND_COPY_DOCS = "Copy docs";
    private static final String COMMAND_COPY_LAST_DOC = "Copy last doc";
    private static final String COMMAND_CREATE_TEST_FOLDERS = "Create Test Folders";
    private static final String COMMAND_EXPORT_ALL_DOCS = "Copy docs to external sdcard";
    private static final String COMMAND_CREATE_DUMMY_DB = "Create dummy database";
    private static final String COMMAND_CUSTOM_ACTIONBAR = "Custom Toolbar";
    private static final String COMMAND_REARRANGE_DB = "Re-arrange database";
    private static final String COMMAND_REARRANGE_FOLDER_DB = "Re-arrange folder database";
    private static final String COMMAND_CLEAR_DATABASE = "Clear database";
    private static final String COMMAND_RESTORE_DATABASE = "Restore database";
    private static final String COMMAND_CLEAR_SYNC_DATA = "Clear sync data";
    private static final String COMMAND_CLEAR_MAPPED_TABLE = "Clear mapped table";
    private static final String COMMAND_ENABLE_SYNC_DEBUG = "Enable Sync Debug";
    private static final String COMMAND_DISABLE_SYNC_DEBUG = "Disable Sync Debug";
    private static final String COMMAND_ENABLE_COEDIT_DEBUG = "Enable Coedit Debug";
    private static final String COMMAND_DISABLE_COEDIT_DEBUG = "Disable Coedit Debug";
    private static final String COMMAND_ENABLE_STG_SERVER = "Enable STG Server";
    private static final String COMMAND_DISABLE_STG_SERVER = "Disable STG Server";
    private static final String COMMAND_CORRUPT_LAST_MEMO_FOR_RECOVERY = "Corrupt Last Memo For Recovery";
    private static final String COMMAND_CORRUPT_LAST_MEMO_FOR_FAIL = "Corrupt Last Memo For Fail";
    private static final String COMMAND_ENABLE_APP_UPDATE = "Enable App Update";
    private static final String COMMAND_DISABLE_APP_UPDATE = "Disable App Update";
    private static final String COMMAND_ENABLE_COLLECT = "Enable Collect";
    private static final String COMMAND_DISABLE_COLLECT = "Disable Collect";
    private static final String COMMAND_ENABLE_COLLECT_LOGGING = "Enable Collect Logging";
    private static final String COMMAND_DISABLE_COLLECT_LOGGING = "Disable Collect Logging";
    private static final String COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DETACH = "Start ScreenOffMemo by pen detach";
    private static final String COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DOUBLE_TAP = "Start ScreenOffMemo by pen double tap";
    private static final String COMMAND_START_CREATE_NOTE_BY_AIR_COMMAND = "Start Create note by AirCommand";
    private static final String COMMAND_START_CREATE_NOTE_BY_DOUBLE_TAP = "Start Create note by double tap";
    private static final String COMMAND_ENABLE_CLEAR_INVALID_COEDIT_NOTE = "Enable clear invalid coedit notes";
    private static final String COMMAND_DISABLE_CLEAR_INVALID_COEDIT_NOTE = "Disable clear invalid coedit notes";
    private static final String COMMAND_COMPOSER_TEST = "Composer Test";
    private static final String COMMAND_TOGGLE_HIGH_FORMAT_VER_TEST = "Toggle High Format Version Test";
    private static final String[] ITEMS = {COMMAND_TOGGLE_CMS_TEST, COMMAND_TOGGLE_FOR_DELETE_OLD_DOC_AFTER_CONVERTING, COMMAND_IMPORT_PDF_TXT_FILES, COMMAND_EXTRACT_BODY_PDF_HW_TEXT, COMMAND_TOGGLE_AI_FOR_SETTING_PAGE, COMMAND_GEN_AI_AUTO_TEST, COMMAND_CHECK_RECOGNITION_STATUS, COMMAND_TOGGLE_EDP_UI_TEST_1, COMMAND_TOGGLE_EDP_UI_TEST_2, COMMAND_TOGGLE_EDP_TEST, COMMAND_UPDATE_TIME_TO_THE_PAST, COMMAND_CHECK_STORAGE_INFO, COMMAND_TOGGLE_RECOGNITION_SLEEP, COMMAND_IMPORT_DOCS, COMMAND_STG_PROD_TOGGLE_COEDIT, COMMAND_VALIDATION_TOGGLE_COEDIT, COMMAND_COPY_DOCS, COMMAND_COPY_LAST_DOC, COMMAND_CREATE_TEST_FOLDERS, COMMAND_EXPORT_ALL_DOCS, COMMAND_CREATE_DUMMY_DB, COMMAND_CUSTOM_ACTIONBAR, COMMAND_REARRANGE_DB, COMMAND_REARRANGE_FOLDER_DB, COMMAND_CLEAR_DATABASE, COMMAND_RESTORE_DATABASE, COMMAND_CLEAR_SYNC_DATA, COMMAND_CLEAR_MAPPED_TABLE, COMMAND_ENABLE_SYNC_DEBUG, COMMAND_DISABLE_SYNC_DEBUG, COMMAND_ENABLE_COEDIT_DEBUG, COMMAND_DISABLE_COEDIT_DEBUG, COMMAND_ENABLE_STG_SERVER, COMMAND_DISABLE_STG_SERVER, COMMAND_CORRUPT_LAST_MEMO_FOR_RECOVERY, COMMAND_CORRUPT_LAST_MEMO_FOR_FAIL, COMMAND_ENABLE_APP_UPDATE, COMMAND_DISABLE_APP_UPDATE, COMMAND_ENABLE_COLLECT, COMMAND_DISABLE_COLLECT, COMMAND_ENABLE_COLLECT_LOGGING, COMMAND_DISABLE_COLLECT_LOGGING, COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DETACH, COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DOUBLE_TAP, COMMAND_START_CREATE_NOTE_BY_AIR_COMMAND, COMMAND_START_CREATE_NOTE_BY_DOUBLE_TAP, COMMAND_ENABLE_CLEAR_INVALID_COEDIT_NOTE, COMMAND_DISABLE_CLEAR_INVALID_COEDIT_NOTE, COMMAND_COMPOSER_TEST, COMMAND_TOGGLE_HIGH_FORMAT_VER_TEST};

    private ViewGroup createItem(String str, ViewGroup.LayoutParams layoutParams) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        Button button = new Button(this);
        button.setText(str);
        button.setOnClickListener(this);
        button.setTag(str);
        linearLayout.addView(button, layoutParams);
        return linearLayout;
    }

    private void disableCoeditFileLogging() {
        File file = new File(getApplicationContext().getFilesDir() + "/deviceName");
        if (file.exists()) {
            AbstractC6670b.m4764y("disableCoeditFileLogging, isDeleted: ", TAG, file.delete());
        }
    }

    private void enableCoeditFileLogging() {
        File file = new File(getApplicationContext().getFilesDir() + "/deviceName");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile() && Build.VERSION.SDK_INT >= 33) {
                try {
                    FileWriter fileWriterCreateFileWriter = JavaInstanceConstructor.createFileWriter(file);
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriterCreateFileWriter);
                        try {
                            bufferedWriter.write(Build.MODEL);
                            bufferedWriter.close();
                            if (fileWriterCreateFileWriter != null) {
                                fileWriterCreateFileWriter.close();
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (IOException e) {
                    Logger.m7101e(TAG, "Fail to write, e: " + e.getMessage());
                }
            }
        } catch (IOException unused) {
            Logger.m7101e(TAG, "Fail to write device name file");
        }
    }

    private void initialize() {
        LinearLayout linearLayout = (LinearLayout) findViewById(C8003R.id.item_container);
        for (String str : ITEMS) {
            if (COMMAND_COPY_DOCS.equals(str) || COMMAND_COPY_LAST_DOC.equals(str) || COMMAND_CREATE_TEST_FOLDERS.equals(str) || COMMAND_CREATE_DUMMY_DB.equals(str) || COMMAND_UPDATE_TIME_TO_THE_PAST.equals(str)) {
                ViewGroup viewGroupCreateItem = createItem(str, new LinearLayout.LayoutParams(-2, -2));
                EditText editText = new EditText(this);
                editText.setId(R.id.edit);
                editText.setGravity(80);
                editText.setInputType(2);
                viewGroupCreateItem.addView(editText, new LinearLayout.LayoutParams(-1, -1));
                linearLayout.addView(viewGroupCreateItem);
            } else {
                linearLayout.addView(createItem(str, new LinearLayout.LayoutParams(-1, -1)));
            }
        }
        ConvertTaskManager.connect(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$0() {
        SDocProviderDump.dumpStorageInfo(this);
    }

    private void setCollectEnabledSetting(int i) {
        getApplicationContext().getPackageManager().setComponentEnabledSetting(new ComponentName(getApplicationContext().getPackageName(), CLASS_NAME_COLLECT_SERVICE), i, 1);
        ToastHandler.show(this, "collect: ".concat(i == 1 ? "enabled" : "disabled"), 0);
    }

    private void startPickerActivity(int i) {
        this.mDocumentTest.setType(i);
        this.mDocumentTest.pick(this);
        this.mResultMap.put(1, this.mDocumentTest);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        IActivityResultListener iActivityResultListener = this.mResultMap.get(Integer.valueOf(i));
        if (iActivityResultListener != null) {
            iActivityResultListener.onActivityResult(this, i2, intent);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int i;
        str = (String) view.getTag();
        str.getClass();
        i = 2;
        switch (str) {
            case "Copy last doc":
            case "Create Test Folders":
            case "Copy docs":
            case "Create dummy database":
            case "Update Time to the past":
                try {
                    int i2 = Integer.parseInt(((EditText) ((ViewGroup) view.getParent()).findViewById(R.id.edit)).getText().toString());
                    switch (str.hashCode()) {
                        case -1903207207:
                            if (str.equals(COMMAND_COPY_LAST_DOC)) {
                                new DocumentTest().importLastData(this, i2);
                            }
                            break;
                        case -1286669125:
                            if (str.equals(COMMAND_CREATE_TEST_FOLDERS)) {
                                new FolderTest().createData(this, i2);
                            }
                            break;
                        case -843979802:
                            if (str.equals(COMMAND_COPY_DOCS)) {
                                new DocumentTest().importData(this, i2);
                            }
                            break;
                        case 1159888906:
                            if (str.equals(COMMAND_UPDATE_TIME_TO_THE_PAST)) {
                                DocumentTest.updateTimeToThePast(this, i2);
                            }
                            break;
                    }
                    new DocumentTest().createDummy(this, i2);
                    break;
                } catch (NumberFormatException e) {
                    Logger.m7101e(TAG, "COMMAND_COPY_DOCS, e : " + e.getMessage());
                    return;
                }
                break;
            case "import pdf/txt files":
                new SpenDocumentTester(this).importPdfTxtFiles();
                break;
            case "Disable clear invalid coedit notes":
                new SyncTester(getApplicationContext()).disableInvalidCoEditNotes();
                break;
            case "Toggle Validation coedit":
                CoeditConstants.toogleValidation();
                ToastHandler.show(this, "IS_VALIDATION " + CoeditConstants.IS_VALIDATION, 0);
                break;
            case "Re-arrange database":
                new DatabaseTester().arrange(getApplicationContext());
                break;
            case "Corrupt Last Memo For Recovery":
                new DatabaseTester().corruptLastMemo(getApplicationContext(), DatabaseTester.CORRUPT_MEDIA_FILES);
                break;
            case "Disable Coedit Debug":
                disableCoeditFileLogging();
                break;
            case "Composer Test":
                new ComposerTester(this).showDialog();
                break;
            case "Check recognition status":
                CollectStatus.checkCollectStatus(getApplicationContext());
                break;
            case "extract BodyText/PDF/Hw Text":
                new SpenDocumentTester(this).extractBodyPdfHwText();
                break;
            case "Start Create note by AirCommand":
            case "Start Create note by double tap":
                CreateNoteTester.getInstance().execute(str);
                break;
            case "Corrupt Last Memo For Fail":
                new DatabaseTester().corruptLastMemo(getApplicationContext(), DatabaseTester.CORRUPT_END_TAG);
                break;
            case "Gen AI Auto Test":
                if (Build.VERSION.SDK_INT >= 33) {
                    new DocumentTest().executeGenAIAutoTest(this);
                    break;
                }
                break;
            case "Disable Collect":
                setCollectEnabledSetting(2);
                break;
            case "Re-arrange folder database":
                new FolderArrangeManager(getApplicationContext()).arrangeFolders();
                break;
            case "Clear sync data":
                new SyncTester(getApplicationContext()).clearAllData();
                break;
            case "Enable/Disable recognition sleep":
                ToastHandler.show(this, "recognition sleep disabled: " + RecognitionUtil.togglesRecognitionSleep(), 0);
                break;
            case "Import docs (sdocx, sdoc)":
                startPickerActivity(10);
                break;
            case "Clear database":
                new DatabaseTester().clear(getApplicationContext());
                break;
            case "Enable/Disable EDP AppUpdate Test":
                new SyncTester(getApplicationContext()).toggleEdpUiTest2State();
                break;
            case "Disable App Update":
                new SyncTester(getApplicationContext()).disableAppUpdate();
                break;
            case "Copy docs to external sdcard":
                SpenDocumentTester spenDocumentTester = new SpenDocumentTester(this);
                StringBuilder sb = new StringBuilder();
                sb.append(Environment.getExternalStorageDirectory());
                spenDocumentTester.setDestFolder(AbstractC0622a.m1170p(File.separator, "NotesTestFolder", sb)).copyToSdcard();
                break;
            case "Enable clear invalid coedit notes":
                new SyncTester(getApplicationContext()).enableInvalidCoEditNotes();
                break;
            case "Enable App Update":
                new SyncTester(getApplicationContext()).enableAppUpdate();
                break;
            case "Disable Sync Debug":
                new SyncTester(getApplicationContext()).disableSyncDebug();
                break;
            case "Toggle Stg coedit":
                CoeditConstants.toogleStgServer();
                ToastHandler.show(this, "IS_STG_SERVER " + CoeditConstants.IS_STG_SERVER, 0);
                break;
            case "Enable Sync Debug":
                new SyncTester(getApplicationContext()).enableSyncDebug();
                break;
            case "Disable Collect Logging":
                CollectStatus.setCollectLogging(getApplicationContext(), false);
                ToastHandler.show(this, "Collect logging disabled", 0);
                break;
            case "Custom Toolbar":
                Intent intent = new Intent(this, (Class<?>) FragmentToolBarActivity.class);
                intent.setFlags(402653184);
                startActivity(intent);
                finish();
                break;
            case "Restore database":
                new DummyDocumentDetector(getApplicationContext()).execute();
                break;
            case "Clear mapped table":
                new SyncTester(getApplicationContext()).clearMappedTable();
                break;
            case "Toggle High Format Version Test":
                new SyncTester(getApplicationContext()).toggleHighFormatVerTestState();
                break;
            case "Enable/Disable EDP Test":
                new SyncTester(getApplicationContext()).toggleEdpTestState();
                break;
            case "Disable STG Server":
                new SyncTester(getApplicationContext()).useProdServer();
                break;
            case "Enable Collect Logging":
                CollectStatus.setCollectLogging(getApplicationContext(), true);
                ToastHandler.show(this, "Collect logging enabled", 0);
                break;
            case "Enable STG Server":
                new SyncTester(getApplicationContext()).useStagingServer();
                break;
            case "Enable/Disable CMS Test":
                new SyncTester(getApplicationContext()).toggleCmsTestState();
                break;
            case "Enable/Disable EDP Error UI Test":
                new SyncTester(getApplicationContext()).toggleEdpUiTest1State();
                break;
            case "Enable Coedit Debug":
                enableCoeditFileLogging();
                break;
            case "Enable/Disable AI for settings page":
                ToastHandler.show(this, "Enabled: " + Features.toggleSupportGlobalSettingPermission(), 0);
                break;
            case "Start ScreenOffMemo by pen detach":
            case "Start ScreenOffMemo by pen double tap":
                ScreenOffMemoTester.getInstance().execute(str);
                break;
            case "Check Storage Info":
                ModelThreadPoolExecutor.getSingleThreadExecutor().execute(new RunnableC8092a(this, i));
                break;
            case "Enable Collect":
                setCollectEnabledSetting(1);
                break;
            case "Enable/Disable delete old doc after converting":
                FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING = !FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING;
                ToastHandler.show(this, "delete old doc after conv Enabled: " + FeatureUtils.ENABLE_DELETE_OLD_DOC_AFTER_CONVERTING, 0);
                break;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C8003R.layout.labs_activity);
        initialize();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ConvertTaskManager.disconnect();
        this.mDocumentTest = null;
        this.mResultMap.clear();
        super.onDestroy();
    }
}
