package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.DynamicTemplateConstant;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerSpenDocModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPdfPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.loader.DynamicTemplateLoader;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskLoadDynamicTemplate;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.TemplateUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.DynamicTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.ImageTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.PdfTemplatePresenterUtil;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuChangeNoteStyle {
    private static final String TAG = Logger.createTag("OptionMenuChangeNoteStyle");
    private boolean mApplyToAll;
    private final ComposerViewPresenter mCompViewPresenter;
    private final ComposerModel mComposerModel;
    private int mCurrentPageIndex;
    private int mDynamicTemplateIndex;
    private final DynamicTemplateLoader mDynamicTemplateLoader;
    private int mDynamicTemplateType;
    private boolean mIsPickerMode;
    private boolean mIsTwoPage;
    private final NoteManager mNoteManager;
    private final ObjectManager mObjectManager;
    private final OptionMenuAddPresenter mOptionMenuAddPresenter;
    private final PageManager mPageManager;
    private int mPageToChange;
    private final ScrollController mScrollController;
    private int mSpenPageType;
    private final TaskController mTaskController;
    private String mTemplatePath;
    private int mTemplateType;

    public OptionMenuChangeNoteStyle(ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, OptionMenuAddPresenter optionMenuAddPresenter, TaskController taskController, DynamicTemplateLoader dynamicTemplateLoader) {
        this.mCompViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mPageManager = composerViewPresenter.getPageManager();
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mScrollController = composerViewPresenter.getComposerControllerManager().getScrollController();
        this.mOptionMenuAddPresenter = optionMenuAddPresenter;
        this.mTaskController = taskController;
        this.mDynamicTemplateLoader = dynamicTemplateLoader;
    }

    private void loadTemplateResult(Intent intent) {
        this.mTemplateType = intent.getIntExtra("template_type", 10);
        Pair<Integer, String> pageTypeAndPathFromIntentForComposer = TemplateUtil.getPageTypeAndPathFromIntentForComposer(intent);
        this.mSpenPageType = pageTypeAndPathFromIntentForComposer.first.intValue();
        this.mTemplatePath = pageTypeAndPathFromIntentForComposer.second;
        if (TemplateViewType.isDynamicType(this.mTemplateType)) {
            this.mDynamicTemplateType = intent.getIntExtra(Constant.ARG_DYNAMIC_TEMPLATE_TYPE, DynamicTemplateConstant.TemplateType.NONE.ordinal());
            this.mDynamicTemplateIndex = intent.getIntExtra(Constant.ARG_DYNAMIC_TEMPLATE_INDEX, 0);
        } else {
            this.mDynamicTemplateType = -1;
            this.mDynamicTemplateIndex = -1;
        }
        this.mApplyToAll = intent.getBooleanExtra(ChangeTemplateConstants.ARG_TEMPLATE_APPLY_TO_ALL, false);
        this.mPageToChange = intent.getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_TO_CHANGE, 0);
        this.mIsPickerMode = TemplateConstants.isPickerMode(intent.getIntExtra(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 1));
        int currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
        int intExtra = intent.getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, currentPageIndex);
        this.mCurrentPageIndex = intExtra;
        if (intExtra < 0) {
            this.mCurrentPageIndex = currentPageIndex;
        }
        String str = TAG;
        Logger.m11003i(str, "loadTemplateResult# templateType:" + this.mTemplateType + ", templateIndex:" + this.mSpenPageType + ", templatePath:" + this.mTemplatePath + ", dynamicTemplateType:" + this.mDynamicTemplateType + ", dynamicTemplateIndex:" + this.mDynamicTemplateIndex + ", applyToAll:" + this.mApplyToAll + ", pageToChange:" + this.mPageToChange + ", mIsPickerMode:" + this.mIsPickerMode);
        StringBuilder sb = new StringBuilder("template:T-");
        sb.append(this.mTemplateType);
        sb.append("/I-");
        sb.append(this.mSpenPageType);
        sb.append("/A-");
        sb.append(this.mApplyToAll);
        sb.append("/P-");
        sb.append(this.mPageToChange);
        sb.append("/PI-");
        sb.append(this.mIsPickerMode);
        Logger.addFileLog(str, sb.toString(), 0);
    }

    private boolean setCustomTemplateAll(SpenWNote spenWNote) {
        int iRegisterFile = spenWNote.registerFile(this.mTemplatePath);
        if (iRegisterFile < 0) {
            return false;
        }
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        int size = pageList.size();
        for (int i = 0; i < size; i++) {
            SpenWPage spenWPage = pageList.get(i);
            if (!spenWPage.hasPDF()) {
                this.mNoteManager.setCustomTemplate(spenWPage, iRegisterFile, this.mTemplatePath);
                this.mCompViewPresenter.getThumbnailUpdateHandler().updateThumbnail(i);
            }
        }
        Logger.m11003i(TAG, "setCustomTemplateAll# done");
        return true;
    }

    private void setDefaultTemplateAll(SpenWNote spenWNote) {
        int pageCount = spenWNote.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            setTemplatePageIndex(spenWNote, i);
        }
        Logger.m11003i(TAG, "setDefaultTemplateAll# done");
    }

    private void setTemplatePageIndex(SpenWNote spenWNote, int i) {
        setTemplatePageIndex(spenWNote, i, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Intent setupIntentTemplateInfo() {
        int pageHeight;
        boolean z;
        int height;
        DocumentPageRatio.PageRatioType pageRatioType;
        int templateType;
        String strValueOf;
        boolean zIsSingleMode = this.mComposerModel.isSingleMode();
        boolean zHasPdf = this.mComposerModel.getComposerSpenDocModel().hasPdf(this.mCurrentPageIndex);
        int pageWidth = this.mComposerModel.getComposerSpenDocModel().getPageWidth(this.mCurrentPageIndex);
        int pageHeight2 = this.mComposerModel.getComposerSpenDocModel().getPageHeight(this.mCurrentPageIndex);
        int i = 0;
        this.mIsTwoPage = false;
        if (!zIsSingleMode) {
            if (isTwoPage() && getTwoPageRightIndex() < this.mPageManager.getPageCount() - 1) {
                this.mIsTwoPage = true;
                ComposerSpenDocModel composerSpenDocModel = this.mComposerModel.getComposerSpenDocModel();
                boolean zHasPdf2 = composerSpenDocModel.hasPdf(getTwoPageLeftIndex());
                boolean zHasPdf3 = composerSpenDocModel.hasPdf(getTwoPageRightIndex());
                int pageWidth2 = composerSpenDocModel.getPageWidth(getTwoPageLeftIndex());
                int pageHeight3 = composerSpenDocModel.getPageHeight(getTwoPageLeftIndex());
                int pageWidth3 = composerSpenDocModel.getPageWidth(getTwoPageRightIndex());
                pageHeight = composerSpenDocModel.getPageHeight(getTwoPageRightIndex());
                zHasPdf = zHasPdf2;
                pageWidth = pageWidth2;
                pageHeight2 = pageHeight3;
                z = zHasPdf3;
                i = pageWidth3;
            }
            if (this.mComposerModel.getDoc().getOrientation() != SpenWNote.Orientation.LANDSCAPE_NEW) {
                pageRatioType = DocumentPageRatio.PageRatioType.A4_LANDSCAPE;
                height = pageRatioType.getHeight(pageWidth);
                if (i != 0) {
                    pageHeight = pageRatioType.getHeight(i);
                }
            } else {
                DocumentPageRatio.PageRatioType pageRatioType2 = DocumentPageRatio.PageRatioType.A4_PORTRAIT;
                if (pageWidth != 0 && pageHeight2 < pageWidth) {
                    pageHeight2 = pageRatioType2.getHeight(pageWidth);
                }
                if (i != 0 && pageHeight < i) {
                    pageHeight = pageRatioType2.getHeight(i);
                }
                height = pageHeight2;
                pageRatioType = pageRatioType2;
            }
            Intent intent = new Intent();
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_SINGLE_MODE, zIsSingleMode);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE, zHasPdf);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_IS_TWO_PAGE, this.mIsTwoPage);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE_NEXT, z);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, this.mCurrentPageIndex);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_WIDTH, pageWidth);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_HEIGHT, height);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_WIDTH, i);
            intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_HEIGHT, pageHeight);
            SpenWPage page = this.mComposerModel.getDoc().getPage(this.mCurrentPageIndex);
            templateType = page.getTemplateType();
            if (templateType != 12) {
                strValueOf = page.getTemplateURI();
                intent.putExtra("template_type", 3);
                intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, strValueOf);
            } else if (templateType == 16) {
                String pdfTemplateNameFromPage = PdfTemplatePresenterUtil.getPdfTemplateNameFromPage(page);
                intent.putExtra("template_type", PdfTemplatePresenterUtil.getTemplateTypeFromTemplateName(pdfTemplateNameFromPage, pageRatioType.getPageRatio()));
                intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, pdfTemplateNameFromPage);
                strValueOf = pdfTemplateNameFromPage;
            } else if (templateType == 17) {
                strValueOf = "";
                intent.putExtra("template_type", DynamicTemplatePresenterUtil.getTemplateTypeFromTemplateXml(""));
                intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, "");
            } else {
                strValueOf = String.valueOf(templateType);
                intent.putExtra("template_type", ImageTemplatePresenterUtil.getTemplateTypeFromTemplateName(strValueOf));
                intent.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NAME, strValueOf);
            }
            String str = TAG;
            StringBuilder sbM2230u = AbstractC2821a.m2230u("setupIntentTemplateInfo#  singleMode:", ", hasPDFPage:", ", isTwoPage:", zIsSingleMode, zHasPdf);
            AbstractC2821a.m2208C(sbM2230u, this.mIsTwoPage, ", hasPDFPageNext:", z, ", page = ");
            AbstractC2821a.m2235z(sbM2230u, pageWidth, height, "/", "/");
            AbstractC2821a.m2235z(sbM2230u, i, pageHeight, "/", ", templateType:");
            sbM2230u.append(templateType);
            sbM2230u.append(", templateName:");
            sbM2230u.append(strValueOf);
            Logger.m10999d(str, sbM2230u.toString());
            return intent;
        }
        pageHeight2 = DocumentPageRatio.PAGE_RATIO.getHeight(pageWidth);
        pageHeight = 0;
        z = false;
        if (this.mComposerModel.getDoc().getOrientation() != SpenWNote.Orientation.LANDSCAPE_NEW) {
        }
        Intent intent2 = new Intent();
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_SINGLE_MODE, zIsSingleMode);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE, zHasPdf);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_IS_TWO_PAGE, this.mIsTwoPage);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_HAS_PDF_PAGE_NEXT, z);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_INDEX, this.mCurrentPageIndex);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_WIDTH, pageWidth);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_PAGE_HEIGHT, height);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_WIDTH, i);
        intent2.putExtra(ChangeTemplateConstants.ARG_TEMPLATE_NEXT_PAGE_HEIGHT, pageHeight);
        SpenWPage page2 = this.mComposerModel.getDoc().getPage(this.mCurrentPageIndex);
        templateType = page2.getTemplateType();
        if (templateType != 12) {
        }
        String str2 = TAG;
        StringBuilder sbM2230u2 = AbstractC2821a.m2230u("setupIntentTemplateInfo#  singleMode:", ", hasPDFPage:", ", isTwoPage:", zIsSingleMode, zHasPdf);
        AbstractC2821a.m2208C(sbM2230u2, this.mIsTwoPage, ", hasPDFPageNext:", z, ", page = ");
        AbstractC2821a.m2235z(sbM2230u2, pageWidth, height, "/", "/");
        AbstractC2821a.m2235z(sbM2230u2, i, pageHeight, "/", ", templateType:");
        sbM2230u2.append(templateType);
        sbM2230u2.append(", templateName:");
        sbM2230u2.append(strValueOf);
        Logger.m10999d(str2, sbM2230u2.toString());
        return intent2;
    }

    private void updateTemplateResultApplyToAll(SpenWNote spenWNote) {
        if (this.mSpenPageType != 12 || !setCustomTemplateAll(spenWNote)) {
            setDefaultTemplateAll(spenWNote);
        }
        this.mNoteManager.updateInvertBackgroundColor();
    }

    private void updateTemplateResultOnePage(SpenWNote spenWNote, boolean z) {
        if (spenWNote.getPage(this.mCurrentPageIndex).hasPDF()) {
            updateTemplateResultOnePageHasPdf(spenWNote, this.mCurrentPageIndex);
        } else {
            updateTemplateResultOnePageNormal(spenWNote, this.mCurrentPageIndex);
        }
        Logger.m11003i(TAG, "updateTemplateResultOnePage# mCurrentPageIndex:" + this.mCurrentPageIndex + " / needUpdateInvert : " + z);
        if (z) {
            this.mNoteManager.updateInvertBackgroundColor();
        }
    }

    private void updateTemplateResultOnePageHasPdf(SpenWNote spenWNote, int i) {
        boolean z;
        int i2;
        if (this.mNoteManager.getNote().isGroupingHistory()) {
            z = false;
        } else {
            this.mNoteManager.getNote().beginHistoryGroup();
            z = true;
        }
        int pageCount = spenWNote.getPageCount();
        DocumentPageRatio.PageRatioType pageRatioType = DocumentPageRatio.PageRatioType.A4_PORTRAIT;
        if (this.mNoteManager.getNote().getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
            pageRatioType = DocumentPageRatio.PageRatioType.A4_LANDSCAPE;
        } else if (!this.mComposerModel.isSingleMode()) {
            SpenWPage page = this.mComposerModel.getDoc().getPage(i);
            float height = page.getHeight() / page.getWidth();
            DocumentPageRatio.PageRatioType pageRatioType2 = DocumentPageRatio.PageRatioType.LONG;
            if (height >= pageRatioType2.getPageRatio()) {
                pageRatioType = pageRatioType2;
            }
        }
        int pageDefaultWidth = this.mIsPickerMode ? this.mNoteManager.getNote().getPageDefaultWidth() : this.mNoteManager.getNote().getPage(i).getWidth();
        int height2 = pageRatioType.getHeight(pageDefaultWidth);
        if (!this.mNoteManager.isDummyPage(i, pageCount)) {
            int i4 = this.mSpenPageType;
            String str = this.mTemplatePath;
            this.mNoteManager.insertDefaultPage(i + 1, pageDefaultWidth, height2, i4, str, str);
        }
        if (this.mNoteManager.isDummyPage(i, pageCount)) {
            NoteManager noteManager = this.mNoteManager;
            int i5 = this.mSpenPageType;
            String str2 = this.mTemplatePath;
            noteManager.replacePage(i, pageDefaultWidth, height2, i5, str2, str2);
            i2 = i;
        } else {
            if (this.mNoteManager.isLastPage(i, pageCount)) {
                int i6 = this.mSpenPageType;
                String str3 = this.mTemplatePath;
                this.mNoteManager.replacePage(i + 2, pageDefaultWidth, height2, i6, str3, str3);
            }
            i2 = i + 1;
        }
        if (!this.mComposerModel.isSingleMode()) {
            this.mScrollController.goToPage(i2);
        }
        if (z) {
            this.mNoteManager.getNote().endHistoryGroup();
        }
        AbstractC8014b.m7217s(i, "updateTemplateResultOnePageHasPdf# pageIndex:", TAG);
    }

    private void updateTemplateResultOnePageNormal(SpenWNote spenWNote, int i) {
        setTemplatePageIndex(spenWNote, i);
        if (!this.mComposerModel.isSingleMode()) {
            this.mScrollController.goToPage(i);
        }
        if (this.mNoteManager.isLastPage(i, spenWNote.getPageCount())) {
            setTemplatePageIndex(spenWNote, i + 1, true);
        }
        AbstractC8014b.m7217s(i, "updateTemplateResultOnePageNormal# pageIndex:", TAG);
    }

    private void updateTemplateResultPageToChange(SpenWNote spenWNote) {
        int twoPageLeftIndex = getTwoPageLeftIndex();
        int i = this.mPageToChange;
        if (i == 1 || i == 3) {
            setTemplatePageIndex(spenWNote, twoPageLeftIndex);
        }
        int i2 = this.mPageToChange;
        if (i2 == 2 || i2 == 3) {
            int twoPageRightIndex = getTwoPageRightIndex();
            setTemplatePageIndex(spenWNote, twoPageRightIndex);
            if (this.mNoteManager.isLastPage(twoPageRightIndex, spenWNote.getPageCount())) {
                setTemplatePageIndex(spenWNote, twoPageRightIndex + 1);
            }
        }
        Logger.m11003i(TAG, "updateTemplateResultPageToChange# PageToChange:" + this.mPageToChange + ", pageIndex:" + twoPageLeftIndex);
        this.mNoteManager.updateInvertBackgroundColor();
    }

    private void updateTemplateResultTwoPage(SpenWNote spenWNote, boolean z) {
        boolean z2;
        int twoPageLeftIndex = getTwoPageLeftIndex();
        if (spenWNote.getPage(twoPageLeftIndex).hasPDF()) {
            z2 = true;
        } else {
            updateTemplateResultOnePageNormal(spenWNote, twoPageLeftIndex);
            z2 = false;
        }
        int pageCount = spenWNote.getPageCount();
        int twoPageRightIndex = getTwoPageRightIndex();
        if (twoPageRightIndex < pageCount - 1) {
            if (!spenWNote.getPage(twoPageRightIndex).hasPDF()) {
                updateTemplateResultOnePageNormal(spenWNote, twoPageRightIndex);
            } else if (z2) {
                updateTemplateResultOnePageHasPdf(spenWNote, twoPageRightIndex);
            }
        }
        Logger.m11003i(TAG, "updateTemplateResultTwoPage# done");
        if (z) {
            this.mNoteManager.updateInvertBackgroundColor();
        }
    }

    public int getTwoPageLeftIndex() {
        return this.mCompViewPresenter.getTwoPageLeftIndex(this.mCurrentPageIndex);
    }

    public int getTwoPageRightIndex() {
        return this.mCompViewPresenter.getTwoPageRightIndex(this.mCurrentPageIndex);
    }

    public boolean isTwoPage() {
        return this.mCompViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPage();
    }

    public void onActivityResult(int i, Intent intent) {
        if (i != -1) {
            return;
        }
        if (intent.hasExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT)) {
            updateTemplateResult(intent);
        }
        this.mNoteManager.commitHistory();
    }

    public void startChangeTemplateActivity(Activity activity) {
        int currentPageIndex = this.mPageManager.getDocPageInfo().getCurrentPageIndex();
        this.mCurrentPageIndex = currentPageIndex;
        if (currentPageIndex < 0 || currentPageIndex >= this.mPageManager.getPageCount()) {
            Logger.m11000e(TAG, "startChangeTemplateActivity# error mCurrentPageIndex =" + this.mCurrentPageIndex + ", page count : " + this.mPageManager.getPageCount());
            return;
        }
        if (this.mComposerModel.isSingleMode() && this.mComposerModel.getComposerSpenDocModel().hasPdf(this.mCurrentPageIndex)) {
            ToastHandler.show(activity, C9086R.string.change_template_unable_to_apply_to_pages_imported_from_pdfs, 0);
            return;
        }
        this.mObjectManager.clearSelection();
        Intent intent = setupIntentTemplateInfo();
        CoverStyleUtils.INSTANCE.extractTextWithReceiver(this.mCompViewPresenter.getView().getContext(), this.mComposerModel.getDoc(), this.mComposerModel.getDocInfo().getDocPath(), this.mComposerModel.getDocInfo().getUuid(), false);
        intent.setClassName(activity.getPackageName(), NoteStyleActivity.class.getName());
        intent.putExtra("key_type", Constant.Type.STYLE_CHANGE.ordinal());
        intent.putExtra(com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant.KEY_GRAVITY, 8388661);
        intent.putExtra("sdoc_uuid", this.mComposerModel.getDocInfo().getUuid());
        intent.putExtra(com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant.KEY_IS_COEDIT_NOTE, this.mOptionMenuAddPresenter.isCoeditNote() || this.mComposerModel.getMdeInfo().isMde());
        intent.putExtra(CoverData.KEY_COVER_DATA, this.mCompViewPresenter.getAiMenuManager().getAiCoverMenuViewPresenter().createCoverData());
        ComposerRequestCode composerRequestCode = ComposerRequestCode.ChangeNoteStyle;
        activity.startActivityForResult(intent, composerRequestCode.getId());
        this.mComposerModel.getComposerState().setLastRequestCode(composerRequestCode.getId());
    }

    public void updateTemplateResult(Intent intent) {
        SpenWNote doc = this.mComposerModel.getDoc();
        if (doc == null) {
            return;
        }
        loadTemplateResult(intent);
        boolean z = true;
        if (this.mSpenPageType == 16 && !TextUtils.isEmpty(this.mTemplatePath)) {
            if (this.mComposerModel.getModeManager().isMode(Mode.ReadOnly)) {
                this.mComposerModel.getModeManager().setMode(this.mComposerModel.getModeManager().getPrevMode(), TAG, true);
            }
            this.mOptionMenuAddPresenter.getOptionMenuPdfPresenter().handlePdfUri(new OptionMenuPdfPresenter.ParamFactory(null, Arrays.asList(this.mTemplatePath)).setByTemplate(this.mIsPickerMode).create());
            return;
        }
        int i = this.mSpenPageType;
        if (i == 17) {
            final int currentPageIndex = this.mCompViewPresenter.getCurrentPageIndex();
            this.mTaskController.execute(new TaskLoadDynamicTemplate(), new TaskLoadDynamicTemplate.InputValues(currentPageIndex, this.mDynamicTemplateType, this.mDynamicTemplateIndex, this.mDynamicTemplateLoader), new Task.Callback<TaskLoadDynamicTemplate.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.OptionMenuChangeNoteStyle.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onError(TaskLoadDynamicTemplate.ResultValues resultValues) {
                    Logger.m11000e(OptionMenuChangeNoteStyle.TAG, "updateTemplateResult, LoadDynamicTemplate Failed");
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
                public void onSuccess(TaskLoadDynamicTemplate.ResultValues resultValues) {
                    Logger.m10999d(OptionMenuChangeNoteStyle.TAG, "updateTemplateResult, LoadDynamicTemplate Success");
                    OptionMenuChangeNoteStyle.this.mCompViewPresenter.getComposerControllerManager().getScrollController().goToPage(currentPageIndex);
                }
            }, false);
            return;
        }
        if (i != 16 && i != 17 && i != 12) {
            z = false;
        }
        if (this.mIsPickerMode) {
            updateTemplateResultOnePage(doc, z);
            return;
        }
        if (this.mApplyToAll) {
            updateTemplateResultApplyToAll(doc);
            return;
        }
        if (this.mPageToChange != 0) {
            updateTemplateResultPageToChange(doc);
        } else if (this.mIsTwoPage) {
            updateTemplateResultTwoPage(doc, z);
        } else {
            updateTemplateResultOnePage(doc, z);
        }
    }

    private void setTemplatePageIndex(SpenWNote spenWNote, int i, boolean z) {
        SpenWPage page = spenWNote.getPage(i);
        if (page.hasPDF()) {
            return;
        }
        if (z) {
            this.mNoteManager.updateDummyPage();
            return;
        }
        NoteManager noteManager = this.mNoteManager;
        int i2 = this.mSpenPageType;
        String str = this.mTemplatePath;
        noteManager.setTemplate(page, i2, str, str);
        this.mCompViewPresenter.getThumbnailUpdateHandler().updateThumbnail(i);
    }
}
