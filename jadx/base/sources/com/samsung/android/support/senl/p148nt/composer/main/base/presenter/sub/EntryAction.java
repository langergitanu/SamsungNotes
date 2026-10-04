package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.DynamicTemplateConstant;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ExecuteOtherActivityController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskActionSend;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskLoadDynamicTemplate;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.TemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EntryAction {
    public static final int IS_SEND_ACTION_RESULT_FALSE = 0;
    public static final int IS_SEND_ACTION_RESULT_TRUE = 1;
    public static final int IS_SEND_ACTION_RESULT_TRUE_BUT_NOT_SUPPORTED = 2;
    private static final String TAG = Logger.createTag("EntryAction");

    public static void executeBixbyAction(Activity activity, BixbyContract bixbyContract) {
        BixbyActionManager.executeBixbyAction(activity, bixbyContract);
    }

    private boolean executeNewAddActionWithPdf(Intent intent, OptionMenuAddPresenter optionMenuAddPresenter) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Uri uri = (Uri) intent.getParcelableExtra(ComposerConstants.ARG_PDF_OPEN_URI);
        if (uri != null) {
            arrayList.add(uri);
            String stringExtra = intent.getStringExtra(ComposerConstants.ARG_PDF_OPEN_PATH);
            if (!TextUtils.isEmpty(stringExtra)) {
                arrayList2.add(stringExtra);
            }
        } else {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ComposerConstants.ARG_PDF_OPEN_URI);
            if (parcelableArrayListExtra != null) {
                arrayList.addAll(parcelableArrayListExtra);
            }
        }
        if (!arrayList.isEmpty()) {
            optionMenuAddPresenter.getOptionMenuPdfPresenter().handlePdfUri(new OptionMenuPdfPresenter.ParamFactory(arrayList, arrayList2).setByExternal("android.intent.action.VIEW".equals(intent.getAction()) || ComposerConstants.ACTION_TRANSLATE.equals(intent.getAction()) || ComposerConstants.ACTION_SIMPLE_MODE.equals(intent.getAction()) || ComposerConstants.ACTION_EDIT_MODE.equals(intent.getAction())).create());
            intent.removeExtra(ComposerConstants.ARG_PDF_OPEN_URI);
            return true;
        }
        if (((PdfFileInfo) intent.getParcelableExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO)) == null) {
            return false;
        }
        Logger.m11003i(TAG, "executeNewAddActionWithPdf# pdfFileInfo is not null");
        return true;
    }

    private boolean executeNewAddActionWithText(Context context, Intent intent, OptionMenuAddPresenter optionMenuAddPresenter) {
        Uri uri = (Uri) intent.getParcelableExtra(ComposerConstants.ARG_TEXT_OPEN_URI);
        if (uri == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        optionMenuAddPresenter.getOptionMenuTextFilePresenter().handleTextAddResult(context, arrayList);
        intent.removeExtra(ComposerConstants.ARG_TEXT_OPEN_URI);
        return true;
    }

    public static boolean isEditModeAction(Intent intent) {
        if (!ComposerConstants.ACTION_EDIT_MODE.equals(intent.getAction())) {
            return false;
        }
        Logger.m10999d(TAG, "isEditModeAction# true");
        return true;
    }

    private static boolean isNotSupportedActionSendMultiType(String str) {
        return (str.startsWith(Constants.MIME_IMAGE_START) || str.startsWith(Constants.MIME_AUDIO_START) || str.startsWith(Constants.MIME_MULTI_START) || str.startsWith(Constants.MIME_APPLICATION_START)) ? false : true;
    }

    private static boolean isNotSupportedActionSendType(String str) {
        return (str.startsWith(Constants.MIME_IMAGE_START) || str.startsWith(Constants.MIME_AUDIO_START) || str.startsWith("text/plain") || str.startsWith(Constants.MIME_APPLICATION_START) || str.startsWith(Constants.MIME_MULTI_START)) ? false : true;
    }

    public static boolean isPdfViewAction(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        Logger.m10999d(TAG, "isPdfViewAction, action: " + action + ", type: " + type);
        if (!TextUtils.isEmpty(action) && !TextUtils.isEmpty(type)) {
            if ("android.intent.action.VIEW".equals(action)) {
                return type.startsWith(Constants.MIME_PDF);
            }
            return false;
        }
        if (((Uri) intent.getParcelableExtra(ComposerConstants.ARG_PDF_OPEN_URI)) != null) {
            return true;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ComposerConstants.ARG_PDF_OPEN_URI);
        return (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) ? false : true;
    }

    public static int isSendAction(Intent intent) {
        String action = intent.getAction();
        String type = intent.getType();
        String str = TAG;
        Logger.m10999d(str, "isSendAction, action: " + action + ", type: " + type);
        if (!TextUtils.isEmpty(action) && !TextUtils.isEmpty(type)) {
            if (intent.hasExtra(Constants.EXTRA_DOC)) {
                Logger.m10999d(str, "isSendAction, has doc extra in intent.");
                return 0;
            }
            if ("android.intent.action.SEND".equals(action)) {
                return isNotSupportedActionSendType(type) ? 2 : 1;
            }
            if ("android.intent.action.SEND_MULTIPLE".equals(action) && type != null) {
                return isNotSupportedActionSendMultiType(type) ? 2 : 1;
            }
        }
        return 0;
    }

    public static boolean isSimpleModeAction(Intent intent) {
        if (!ComposerConstants.ACTION_SIMPLE_MODE.equals(intent.getAction())) {
            return false;
        }
        Logger.m10999d(TAG, "isSimpleModeAction# true");
        return true;
    }

    public void executeNewAction(Context context, Intent intent, OptionMenuAddPresenter optionMenuAddPresenter) {
        if (executeNewAddActionWithText(context, intent, optionMenuAddPresenter) || executeNewAddActionWithPdf(intent, optionMenuAddPresenter)) {
            return;
        }
        executeNewAddActionWithPdfTemplate(intent, optionMenuAddPresenter);
    }

    public void executeNewAddActionWithPdfTemplate(Intent intent, OptionMenuAddPresenter optionMenuAddPresenter) {
        Pair<Integer, String> pageTypeAndPathFromIntent = TemplateUtil.getPageTypeAndPathFromIntent(intent);
        if (pageTypeAndPathFromIntent.first.intValue() != 16) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(pageTypeAndPathFromIntent.second);
        optionMenuAddPresenter.getOptionMenuPdfPresenter().handlePdfUri(new OptionMenuPdfPresenter.ParamFactory(null, arrayList).setByNewTemplate().create());
    }

    public void executeNewDynamicTemplateAction(final Activity activity, Intent intent, TaskController taskController, DynamicTemplateLoader dynamicTemplateLoader) {
        taskController.execute(new TaskLoadDynamicTemplate(), new TaskLoadDynamicTemplate.InputValues(0, intent.getIntExtra(Constant.ARG_DYNAMIC_TEMPLATE_TYPE, DynamicTemplateConstant.TemplateType.NONE.ordinal()), intent.getIntExtra(Constant.ARG_DYNAMIC_TEMPLATE_INDEX, 0), dynamicTemplateLoader), new Task.Callback<TaskLoadDynamicTemplate.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.EntryAction.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskLoadDynamicTemplate.ResultValues resultValues) {
                Logger.m11000e(EntryAction.TAG, "executeNewDynamicTemplateAction#onError");
                activity.finish();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskLoadDynamicTemplate.ResultValues resultValues) {
                Logger.m10999d(EntryAction.TAG, "executeNewDynamicTemplateAction#onSuccess");
            }
        }, false);
    }

    public void executeSearchTextAction(Intent intent, ModeManager modeManager, PageManager pageManager) {
        String stringExtra = intent.getStringExtra("highlighttext");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        modeManager.setMode(Mode.Search, "executeSearchTextAction", true, stringExtra);
        pageManager.getDocPageInfo().setRestoreFlag(false);
    }

    public void executeTaskActionSend(Intent intent, Activity activity, Fragment fragment, final ComposerViewPresenter composerViewPresenter, final ControllerManager controllerManager, DialogPresenterManager dialogPresenterManager, boolean z) {
        composerViewPresenter.getComposerModel().getComposerState().disableIsNeedGuideView();
        final TaskActionSend.InputValues inputValues = new TaskActionSend.InputValues(activity, intent, composerViewPresenter.getObjectManager(), composerViewPresenter.getTextManager(), composerViewPresenter.getNoteManager(), composerViewPresenter.getPdfManager(), composerViewPresenter.getPageManager(), new TaskContract.IPageScroller() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.EntryAction.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.common.TaskContract.IPageScroller
            public void goToPage(int i) {
                composerViewPresenter.getComposerControllerManager().getScrollController().goToPage(i);
            }
        }, z, composerViewPresenter.getComposerModel());
        inputValues.setFragment(fragment);
        if (!IntentParser.hasWebCard(intent) || WebCardUtil.isFirstCheckToShowWebPreviewsPopup() || WebCardUtil.isShowWebPreviewsSettingEnabled()) {
            executeTaskActionSend(controllerManager.getTaskController(), inputValues);
        } else {
            WebCardUtil.showOnlyFirstWebCardPreviewDialog(dialogPresenterManager, new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.EntryAction.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    EntryAction.this.executeTaskActionSend(controllerManager.getTaskController(), inputValues);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean executeWidgetSendAction(Intent intent, OptionMenuAddPresenter optionMenuAddPresenter, SoftInputManager softInputManager, ModeManager modeManager, boolean z, boolean z2) {
        Mode mode;
        String stringExtra = intent.getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION);
        Mode mode2 = Mode.Text;
        if (stringExtra == null) {
            return false;
        }
        if (stringExtra.equals(ComposerConstants.NEW_MEMO_WRITING_OPEN) || stringExtra.equals(ComposerConstants.NEW_MEMO_DRAWING_OPEN)) {
            mode = Mode.Writing;
            z2 = false;
            if (z2) {
            }
            intent.removeExtra(ComposerConstants.MEMO_WIDGET_ACTION);
            return true;
        }
        if (!stringExtra.equals(ComposerConstants.NEW_MEMO_VOICE_OPEN)) {
            if (stringExtra.equals(ComposerConstants.NEW_MEMO_INSERT_OPEN)) {
                if (z) {
                    optionMenuAddPresenter.addImage();
                }
                mode = mode2;
                z2 = true;
            }
            if (z2) {
                softInputManager.blockToShow(true, "executeWidgetSendAction");
                modeManager.setMode(mode, "widgetAction", true);
                softInputManager.blockToShow(false, "executeWidgetSendAction");
            } else {
                modeManager.setMode(mode, "widgetAction", true, mode != mode2 ? ModeManager.SIPShowType.NONE : ModeManager.SIPShowType.FORCE);
            }
            intent.removeExtra(ComposerConstants.MEMO_WIDGET_ACTION);
            return true;
        }
        z2 = !optionMenuAddPresenter.isPermissionGrantedForVoiceRecordings();
        if (z) {
            optionMenuAddPresenter.addVoice();
        }
        mode = mode2;
        if (z2) {
        }
        intent.removeExtra(ComposerConstants.MEMO_WIDGET_ACTION);
        return true;
    }

    public void executeWidgetSendActionDrawing(Activity activity, ComposerModel composerModel) {
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra(ComposerConstants.MEMO_WIDGET_ACTION);
        if (stringExtra != null && stringExtra.equals(ComposerConstants.NEW_MEMO_DRAWING_OPEN)) {
            composerModel.setRunningDrawing(ExecuteOtherActivityController.executeBrushStatic(activity, intent.getStringExtra("sdoc_uuid"), "", null, null, 0));
        }
    }

    public void initSpenOnlyMode(Activity activity) {
        if (!SharedPreferencesCompat.getInstance("Settings").contains("settings_spen_only_mode")) {
            SharedPreferencesCompat.getInstance("Settings").putBoolean("settings_spen_only_mode", DeviceUtils.isShopDemoDevice(activity) ? false : ComposerSpenUtils.canUseSpen(activity));
        } else {
            if (DeviceUtils.isSpenModel() || !SharedPreferencesCompat.getInstance("Settings").getBoolean("settings_spen_only_mode", false)) {
                return;
            }
            SharedPreferencesCompat.getInstance("Settings").putBoolean("settings_spen_only_mode", false);
        }
    }

    public boolean isDefaultTemplatePdf(Intent intent) {
        return TemplateUtil.getPageTypeAndPathFromIntent(intent).first.intValue() == 16;
    }

    public boolean isDynamicTemplate(Intent intent) {
        return intent.hasExtra(Constant.ARG_DYNAMIC_TEMPLATE_TYPE) && intent.hasExtra(Constant.ARG_DYNAMIC_TEMPLATE_INDEX);
    }

    public boolean isSendActionWithPdf(Context context, Intent intent) {
        ArrayList parcelableArrayListExtra;
        String type = intent.getType();
        if (TextUtils.isEmpty(type)) {
            return false;
        }
        if (type.startsWith(Constants.MIME_PDF)) {
            return true;
        }
        if (type.startsWith(Constants.MIME_MULTI_START)) {
            if ("android.intent.action.SEND".equals(intent.getAction())) {
                parcelableArrayListExtra = new ArrayList(1);
                parcelableArrayListExtra.add((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"));
            } else {
                parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            if (parcelableArrayListExtra != null) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    String mimeType = UriFileUtils.getMimeType(context, (Uri) it.next());
                    if (mimeType != null && mimeType.startsWith(Constants.MIME_PDF)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void executeBixbyAction(Activity activity, Intent intent, BixbyContract bixbyContract) {
        BixbyActionManager.executeBixbyAction(activity, intent, bixbyContract);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTaskActionSend(TaskController taskController, TaskActionSend.InputValues inputValues) {
        TaskActionSend taskActionSend = new TaskActionSend();
        taskController.execute(taskActionSend, inputValues, taskActionSend.getDefaultCallback(), false);
    }
}
