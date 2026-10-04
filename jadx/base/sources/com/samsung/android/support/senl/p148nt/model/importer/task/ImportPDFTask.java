package com.samsung.android.support.senl.p148nt.model.importer.task;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.contract.DataToModelManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.C11397R;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.importer.common.PDFException;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportPdfParam;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentPageUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportPDFTask extends ImportSdocXBaseTask<ImportPdfParam> {
    private static final String TAG = ModelLogger.createTag("ImportPDFTask");
    private final SpenNotePdfImport mSPenNotePdfImport;

    public ImportPDFTask(ImportPdfParam importPdfParam) {
        super(importPdfParam);
        this.mSPenNotePdfImport = ToolConstructor.makeSpenNotePdfImport(importPdfParam.getContext());
    }

    private void addPageToSPenWNote(@NonNull SpenWNote spenWNote, SpenWNote.PageMode pageMode) {
        int defaultBackgroundColor = DocumentBackgroundUtils.getDefaultBackgroundColor(getContext().getResources().getColor(C11397R.color.background_color_white, null));
        SpenWPage spenWPageAppendPage = spenWNote.appendPage();
        spenWPageAppendPage.setBackgroundColor(defaultBackgroundColor);
        setTemplate(spenWPageAppendPage, pageMode);
    }

    private void checkPDFFile(String str) {
        if (this.mSPenNotePdfImport.hasPassword(str)) {
            throw new PDFException("checkPDFFile, PDF was protected by password", ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED.ordinal());
        }
        ISpenNotePdfManager.ResultType resultTypeHasOwnerPermission = this.mSPenNotePdfImport.hasOwnerPermission(str, "");
        ISpenNotePdfManager.ResultType resultType = ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED;
        if (resultType == resultTypeHasOwnerPermission) {
            throw new PDFException("checkPDFFile, PDF has owner permission", resultType.ordinal());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setTemplate(SpenWPage spenWPage, SpenWNote.PageMode pageMode) {
        int templateViewType = DocumentBackgroundUtils.getTemplateViewType();
        String templatePath = DocumentBackgroundUtils.getTemplatePath();
        if (!TemplateViewType.isDefaultImageType(templateViewType) || templatePath == null) {
            if (TemplateViewType.isCustomImageType(templateViewType)) {
                templateViewType = 12;
            } else if (TemplateViewType.isPdfType(templateViewType)) {
                templateViewType = 0;
            }
            spenWPage.setTemplateType(templateViewType);
            spenWPage.setBackgroundImageMode(pageMode != SpenWNote.PageMode.SINGLE ? 3 : 2);
            spenWPage.setBackgroundImage(templatePath, true);
            spenWPage.setTemplateURI(templatePath);
        }
        templateViewType = Integer.parseInt(templatePath);
        templatePath = null;
        spenWPage.setTemplateType(templateViewType);
        spenWPage.setBackgroundImageMode(pageMode != SpenWNote.PageMode.SINGLE ? 3 : 2);
        spenWPage.setBackgroundImage(templatePath, true);
        spenWPage.setTemplateURI(templatePath);
    }

    private void updateIndividualPageNoteHeight(@NonNull SpenWNote spenWNote) {
        int height = spenWNote.getHeight();
        int pageDefaultHeight = spenWNote.getPageDefaultHeight();
        spenWNote.getPage(0).setSize(spenWNote.getWidth(), (pageDefaultHeight / 2) + (((height / pageDefaultHeight) + (height % pageDefaultHeight == 0 ? 1 : 2)) * pageDefaultHeight));
    }

    private void updateInvertBackgroundColor(SpenWNote spenWNote) {
        if (DocumentBackgroundUtils.getInvertBackgroundColorType(spenWNote.getPageList()) == DocumentBackgroundUtils.InvertBackgroundColorType.None) {
            spenWNote.invertBackgroundColor(DocumentBackgroundUtils.getDefaultInvertBackground());
        } else {
            spenWNote.invertBackgroundColor(false);
        }
        DataLogger.m12307i(TAG, "updateInvertBackgroundColor# isBackgroundColorInverted:" + spenWNote.isBackgroundColorInverted());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public String getPrefix() {
        return FileUtils.extractFileName(((ImportPdfParam) getParam()).getExternalPath()) + '_';
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXBaseTask
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void onPostExecute() {
        DataToModelManager.resumePdfCollect(getClass(), TAG);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void onPreExecute() {
        checkPDFFile(getExternalPath());
        DataToModelManager.pausePdfCollect(getClass(), TAG);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void saveExtraData() {
        String uuidToCopyExtraData = ((ImportPdfParam) getParam()).getUuidToCopyExtraData();
        if (TextUtils.isEmpty(uuidToCopyExtraData)) {
            return;
        }
        copyCoverData(uuidToCopyExtraData, getUuid());
        copyTagData(uuidToCopyExtraData, getUuid());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXBaseTask, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean close(@Nullable SpenWNote spenWNote, String str) {
        SpenNotePdfImport spenNotePdfImport = this.mSPenNotePdfImport;
        if (spenNotePdfImport != null) {
            spenNotePdfImport.close();
        }
        return super.close(spenWNote, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public NotesDocumentEntity createDocumentEntity(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull SpenWNote spenWNote) {
        NotesDocumentEntity notesDocumentEntity = new NotesDocumentEntity();
        notesDocumentEntity.setId(null);
        notesDocumentEntity.setUuid(str);
        notesDocumentEntity.setTitle(((ImportPdfParam) getParam()).getTitle());
        notesDocumentEntity.setFilePath(str2);
        notesDocumentEntity.setCategoryUuid(str4);
        notesDocumentEntity.setPageMode(spenWNote.getPageMode() == SpenWNote.PageMode.LIST ? 2 : 1);
        return notesDocumentEntity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    @NonNull
    public SpenWNote open(@NonNull String str, @NonNull String str2) {
        SpenWNote.PageMode pageModeConvertToWNotePageMode;
        SpenWNote.Orientation orientation;
        SpenWNote.Orientation orientation2 = SpenWNote.Orientation.PORTRAIT;
        ISpenNotePdfManager.PageMode pageMode = this.mSPenNotePdfImport.getPageMode(str2, "");
        ISpenNotePdfManager.PageMode pageMode2 = ISpenNotePdfManager.PageMode.PAGE_MODE_LIST;
        if (pageMode == pageMode2) {
            pageModeConvertToWNotePageMode = SpenWNote.PageMode.LIST;
            orientation = this.mSPenNotePdfImport.getNoteOrientation(str2, null, pageMode2) == ISpenNotePdfManager.NoteOrientation.NOTE_ORIENTATION_LANDSCAPE_NEW ? SpenWNote.Orientation.LANDSCAPE_NEW : orientation2;
        } else {
            if (pageMode == ISpenNotePdfManager.PageMode.PAGE_MODE_SINGLE) {
                pageModeConvertToWNotePageMode = SpenWNote.PageMode.SINGLE;
            } else {
                int preferredPageMode = ((ImportPdfParam) getParam()).getPreferredPageMode();
                if (preferredPageMode != 0) {
                    pageModeConvertToWNotePageMode = DocumentPageUtils.convertToWNotePageMode(preferredPageMode);
                    if (pageModeConvertToWNotePageMode == SpenWNote.PageMode.LIST && !((ImportPdfParam) getParam()).getPreferredIsPortraitOrientation()) {
                        orientation = SpenWNote.Orientation.LANDSCAPE_NEW;
                    }
                } else {
                    pageModeConvertToWNotePageMode = 1 == new DocumentStyleRepository().getPageStyle() ? SpenWNote.PageMode.LIST : SpenWNote.PageMode.SINGLE;
                }
            }
        }
        int iMax = Math.max(Resources.getSystem().getDisplayMetrics().widthPixels, 1080);
        int i = (int) (orientation == orientation2 ? iMax * 1.4142857f : iMax / 1.4142857f);
        SpenWNote spenWNoteMakeSpenWNote = DocumentConstructor.makeSpenWNote(((ImportPdfParam) getParam()).getContext(), pageModeConvertToWNotePageMode, orientation, iMax, false);
        spenWNoteMakeSpenWNote.setPageDefaultWidth(iMax);
        spenWNoteMakeSpenWNote.setPageDefaultHeight(i);
        spenWNoteMakeSpenWNote.getTitle().setText(UnicodeUtils.normalizeNFC(((ImportPdfParam) getParam()).getTitle()));
        addPageToSPenWNote(spenWNoteMakeSpenWNote, pageModeConvertToWNotePageMode);
        return spenWNoteMakeSpenWNote;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public boolean saveToDatabase(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull String str4) {
        String str5 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("save, uuid : ", str, ", savePath : ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", externalPath : ");
        sbM15l.append(DataLogger.getEncode(str3));
        sbM15l.append(", document : ");
        sbM15l.append(spenWNote);
        DataLogger.m12302d(str5, sbM15l.toString());
        return super.saveToDatabase(str, str2, str3, spenWNote, notesDocumentEntity, str4) && DocumentWriteResolver.save(getContext(), true, str2, notesDocumentEntity, spenWNote, (String) null, true, str4);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask
    public void updateSPenDocument(@NonNull SpenWNote spenWNote) {
        this.mSPenNotePdfImport.setDocument(spenWNote);
        ISpenNotePdfManager.ResultType resultTypeAttachFile = this.mSPenNotePdfImport.attachFile(0, getExternalPath(), "");
        if (ISpenNotePdfManager.ResultType.RESULT_TYPE_SUCCESS != resultTypeAttachFile) {
            throw new PDFException("updateSPenDocument, eType: " + resultTypeAttachFile, resultTypeAttachFile.ordinal());
        }
        if (spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
            updateIndividualPageNoteHeight(spenWNote);
        }
        updateInvertBackgroundColor(spenWNote);
    }
}
