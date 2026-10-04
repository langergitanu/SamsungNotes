package com.samsung.android.support.senl.p148nt.model.repository.pdfwriter;

import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.repository.pdfwriter.PDFWriterGsonRepository;
import com.samsung.android.support.senl.p148nt.data.repository.pdfwriter.PDFWriterRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class PDFWriterRepositoryFactory {
    public static PDFWriterRepository createPDFWriterRepository() {
        return new PDFWriterRepository(new PDFWriterGsonRepository(DocumentCacheUtils.getPDFWriterCacheFolder(BaseUtils.getApplicationContext())));
    }
}
