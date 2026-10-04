package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.sub;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.BaseSubManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ComposerCloser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.IPwInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.lifecycle.PdfWriterManager;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PdfFileInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwServiceContractImpl extends ServiceContractImpl {
    private static final String TAG = Logger.createTag("PwServiceContractImpl");
    private final RestoreManagerContract mRestoreManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface RestoreManagerContract {
        PwDocInfo createPwDocInfo();

        boolean hasRestoreInfo();
    }

    public PwServiceContractImpl(BaseSubManager baseSubManager, ComposerCloser composerCloser, ServiceContractImpl.Contract contract, RestoreManagerContract restoreManagerContract) {
        super(baseSubManager, composerCloser, contract);
        this.mRestoreManager = restoreManagerContract;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl
    public DocInfo createByIntent(Activity activity) {
        if (this.mRestoreManager.hasRestoreInfo()) {
            Logger.m10999d(TAG, "getDocInfo# get from RestoreInfo");
            return this.mRestoreManager.createPwDocInfo();
        }
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        if (!"android.intent.action.VIEW".equals(intent.getAction()) && !ComposerConstants.ACTION_TRANSLATE.equals(intent.getAction()) && !ComposerConstants.ACTION_SIMPLE_MODE.equals(intent.getAction()) && !ComposerConstants.ACTION_EDIT_MODE.equals(intent.getAction())) {
            Logger.m10999d(TAG, "createByIntent# fail: " + intent.getAction() + " " + intent.getType());
            return null;
        }
        PdfFileInfo pdfFileInfo = (PdfFileInfo) intent.getParcelableExtra(ComposerConstants.ARG_PDF_READER_FILE_INFO);
        if (pdfFileInfo == null) {
            Logger.m11000e(TAG, "createByIntent# pdfFileInfo is null");
            return null;
        }
        PwDocInfo pwDocInfo = new PwDocInfo(DocInfo.OpenType.OpenByView, new PwFileManager().getSavePath(activity, stringExtra + ".sdocx"), stringExtra);
        pwDocInfo.setPdfFileInfo(pdfFileInfo);
        Logger.m10999d(TAG, "createByIntent# " + pwDocInfo);
        return pwDocInfo;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public OpenParam getOpenParam(boolean z) {
        OpenParam openParam = super.getOpenParam(z);
        openParam.setWritingMode(100);
        return openParam;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl
    public int getPageType(Intent intent) {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.ServiceContract
    public void onLoadDocCompleted(NotesDocument<SpenWordDocument> notesDocument) {
        super.onLoadDocCompleted(notesDocument);
        PdfFileInfo pdfFileInfo = ((PwDocInfo) getDocInfo()).getPdfFileInfo();
        ComponentCallbacks2 activity = this.mSubManager.getComposerLifeState().getActivity();
        if (activity instanceof IPwInfo) {
            PdfWriterManager.getInstance().register((IPwInfo) activity, pdfFileInfo);
        }
    }
}
