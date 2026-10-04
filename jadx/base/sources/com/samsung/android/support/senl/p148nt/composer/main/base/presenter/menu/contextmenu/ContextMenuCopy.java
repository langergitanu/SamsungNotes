package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ClipData;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.Menu;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.support.senl.p145cm.base.framework.app.KeyguardManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.HtmlUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTypeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuSAUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuCopy extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuCopy");
    private final ComposerModel mComposerModel;
    private final ObjectManager mObjectManager;
    private final PdfManager mPdfManager;
    private final TaskController mTaskController;
    private final TextManager mTextManager;

    public ContextMenuCopy(ComposerViewPresenter composerViewPresenter, TaskController taskController) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mTaskController = taskController;
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    private void copyObject() {
        TaskCopy.InputValues inputValues;
        if (this.mPdfManager.hasSelectedImage()) {
            inputValues = new TaskCopy.InputValues(this.mActivity, this.mObjectManager, this.mPdfManager);
        } else {
            Activity activity = this.mActivity;
            ObjectManager objectManager = this.mObjectManager;
            inputValues = new TaskCopy.InputValues(activity, objectManager, objectManager.getSelectedSafeObjectList());
        }
        this.mTaskController.execute(new TaskCopy(), inputValues, new Task.Callback<TaskCopy.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCopy.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCopy.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCopy.ResultValues resultValues) {
                ContextMenuCopy.this.mObjectManager.clearSelectObject();
            }
        }, false);
    }

    private void copyObjectOfObjectSpan() {
        int[] iArrFindObjectSpanCursorPosition = new ObjectSpanHelper(this.mObjectManager.getNote()).findObjectSpanCursorPosition(this.mObjectManager.getSelectedObjectList());
        TaskCopy.InputValues inputValues = new TaskCopy.InputValues(this.mActivity, this.mObjectManager, this.mTextManager.getTextBox(), iArrFindObjectSpanCursorPosition[0], iArrFindObjectSpanCursorPosition[1]);
        this.mTaskController.execute(new TaskCopy(), inputValues, new Task.Callback<TaskCopy.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCopy.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCopy.ResultValues resultValues) {
                resultValues.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCopy.ResultValues resultValues) {
                ContextMenuCopy.this.mObjectManager.clearSelectObject();
            }
        }, false);
    }

    private void copyText() {
        TextManager textManager = this.mTextManager;
        int[] cursor = textManager.getCursor(textManager.getTextBox());
        TaskCopy.InputValues inputValues = new TaskCopy.InputValues(this.mActivity, this.mObjectManager, this.mTextManager.getTextBox(), cursor[0], cursor[1]);
        TaskCopy taskCopy = new TaskCopy();
        this.mTaskController.execute(taskCopy, inputValues, taskCopy.getDefaultCallback(), false);
        this.mTextManager.clearSelection();
    }

    private void copyTextInPdf() {
        String selectedText = this.mPdfManager.getSelectedText();
        if (selectedText == null) {
            Logger.m11003i(TAG, "executeCopyMenu# hasSelectedPdfText : 0");
            return;
        }
        Logger.m11003i(TAG, "executeCopyMenu# hasSelectedPdfText : " + selectedText.length());
        String strReplace = selectedText.replace("\\r\\n", "\n");
        try {
            Charset charset = StandardCharsets.UTF_8;
            byte[] bytes = strReplace.getBytes(charset);
            if (bytes.length > 40000) {
                strReplace = strReplace.substring(0, new String(Arrays.copyOfRange(bytes, 0, 40000), charset).length());
            }
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("executeCopyMenu# PDF Text - get the byte size : "), TAG);
        }
        ClipboardManagerCompat.INSTANCE.getInstance().setClip(this.mActivity, new ClipData.Item(strReplace, HtmlUtils.toHtml(SpannableString.valueOf(strReplace))), new String[]{Constants.MIME_HTML}, "");
        this.mPdfManager.clearSelection();
    }

    public static boolean isAvailableToCopy(ObjectManager objectManager, TextManager textManager) {
        boolean zHasMathType;
        ArrayList<SpenObjectBase> selectedSafeObjectList = objectManager.getSelectedSafeObjectList();
        if (selectedSafeObjectList == null || selectedSafeObjectList.isEmpty()) {
            return false;
        }
        if (textManager.hasFocusedTextBox()) {
            zHasMathType = isNotAvailableInTextBox(textManager, selectedSafeObjectList);
        } else {
            if (selectedSafeObjectList.size() == 1) {
                SpenObjectBase spenObjectBase = selectedSafeObjectList.get(0);
                if (spenObjectBase.getType() == 2 && TextUtils.isEmpty(((SpenObjectShape) spenObjectBase).getText())) {
                    return false;
                }
            }
            zHasMathType = ObjectTypeUtil.hasMathType(selectedSafeObjectList);
        }
        return !zHasMathType;
    }

    private static boolean isNotAvailableInTextBox(TextManager textManager, List<SpenObjectBase> list) {
        if (TextUtils.isEmpty(textManager.getSelectedText())) {
            return true;
        }
        return (list.get(0) instanceof SpenObjectTextBox) && isSelectedInvalidObjectSpans((SpenObjectTextBox) list.get(0));
    }

    private static boolean isSelectedInvalidObjectSpans(SpenObjectTextBox spenObjectTextBox) {
        int[] cursor = TextUtil.getCursor(spenObjectTextBox);
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = spenObjectTextBox.findObjectSpan(cursor[0], cursor[1]);
        if (arrayListFindObjectSpan != null && !arrayListFindObjectSpan.isEmpty()) {
            Iterator<SpenObjectSpan> it = arrayListFindObjectSpan.iterator();
            while (it.hasNext()) {
                if (!it.next().getObject().isAllContentFileAvailable()) {
                    Logger.m11003i(TAG, "isAvailableToCopy# invalid object");
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_COPY;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_copy).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (KeyguardManagerCompat.INSTANCE.getInstance().isKeyguardSecureOn(this.mActivity) || this.mComposerModel.getComposerState().isSecured()) {
            return false;
        }
        if (this.mPdfManager.hasSelectedPDF()) {
            return true;
        }
        return isAvailableToCopy(this.mObjectManager, this.mTextManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        boolean zHasSelectedText = this.mPdfManager.hasSelectedText();
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("executeCopyMenu# pdftext:", ", focus in textbox:", zHasSelectedText);
        sbM3200j.append(this.mObjectManager.isFocusedTextBox());
        Logger.m11003i(str, sbM3200j.toString());
        ComposerSA.insertLog((String) null, ComposerSAConstants.EVENT_EDIT_CONTEXTUAL_POPUP_USAGE, "1");
        ComposerSA.insertLog(this.mComposerModel.getModeManager().isEditMode() ? "401" : "301", ComposerSAConstants.EVENT_VIEW_CTX_COPY, MenuSAUtils.getSADetailValue(this.mPdfManager, this.mObjectManager));
        if (zHasSelectedText) {
            copyTextInPdf();
            return;
        }
        if (this.mTextManager.hasFocusedTextBox() || this.mObjectManager.isFocusedTextBox()) {
            copyText();
        } else if (this.mPdfManager.hasSelectedImage() || !this.mObjectManager.isSelectedObjectOfObjectSpan()) {
            copyObject();
        } else {
            copyObjectOfObjectSpan();
        }
    }
}
