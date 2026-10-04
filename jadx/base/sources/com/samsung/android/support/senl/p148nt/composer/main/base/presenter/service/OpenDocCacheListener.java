package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenDocListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.entity.WordDocumentEntityContainer;
import com.samsung.android.support.senl.p148nt.model.service.IDocumentServiceWrapper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OpenDocCacheListener<T extends ISpenDocument> extends OpenDocListener<T> {
    private static final String TAG = Logger.createTag("OpenDocCacheListener");
    private final IDocumentServiceWrapper mDocService;
    private final OpenDocListener<T> mOpenDocListenerImpl;
    private final OpenParam mOpenParam;
    private final CustomSaveStrategy mSaveStrategy;

    public OpenDocCacheListener(IDocumentServiceWrapper iDocumentServiceWrapper, OpenDocListener.Contract<T> contract, OpenDocListener<T> openDocListener, OpenParam openParam, CustomSaveStrategy customSaveStrategy) {
        super(contract);
        this.mOpenDocListenerImpl = openDocListener;
        this.mDocService = iDocumentServiceWrapper;
        this.mOpenParam = openParam;
        this.mSaveStrategy = customSaveStrategy;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.service.OpenDocListener, com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
    public void failed(Throwable th, String str) {
        Logger.m10999d(TAG, "failed# ");
        DocumentRepository<SpenWordDocument, WordDocumentEntityContainer> documentRepositoryMakeDocRepository = this.mOpenParam.makeDocRepository(DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser() + "_OpenDocCacheListener", this.mDocService.getUser());
        this.mSaveStrategy.onCacheLoadFailed(documentRepositoryMakeDocRepository);
        this.mDocService.open(documentRepositoryMakeDocRepository, this.mOpenDocListenerImpl);
    }
}
