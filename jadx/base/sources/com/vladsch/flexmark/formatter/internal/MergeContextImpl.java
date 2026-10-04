package com.vladsch.flexmark.formatter.internal;

import com.vladsch.flexmark.formatter.MergeContext;
import com.vladsch.flexmark.formatter.MergeContextConsumer;
import com.vladsch.flexmark.formatter.TranslationContext;
import com.vladsch.flexmark.formatter.TranslationHandler;
import com.vladsch.flexmark.util.ast.Document;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MergeContextImpl implements MergeContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Document[] myDocuments;
    private final HashMap<TranslationContext, Document> myTranslationHandlerDocumentMap = new HashMap<>();
    private TranslationHandler[] myTranslationHandlers;

    public MergeContextImpl(Document[] documentArr, TranslationHandler[] translationHandlerArr) {
        this.myDocuments = documentArr;
        this.myTranslationHandlers = translationHandlerArr;
        updateDocumentMap();
        for (TranslationHandler translationHandler : this.myTranslationHandlers) {
            translationHandler.setMergeContext(this);
        }
    }

    private void updateDocumentMap() {
        int length = this.myDocuments.length;
        for (int i = 0; i < length; i++) {
            this.myTranslationHandlerDocumentMap.put(this.myTranslationHandlers[i], this.myDocuments[i]);
        }
    }

    @Override // com.vladsch.flexmark.formatter.MergeContext
    public void forEachPrecedingDocument(@Nullable Document document, @NotNull MergeContextConsumer mergeContextConsumer) {
        int length = this.myDocuments.length;
        for (int i = 0; i < length; i++) {
            Document document2 = this.myDocuments[i];
            if (document2 == document) {
                return;
            }
            mergeContextConsumer.accept(this.myTranslationHandlers[i], document2, i);
        }
    }

    @Override // com.vladsch.flexmark.formatter.MergeContext
    @NotNull
    public Document getDocument(@NotNull TranslationContext translationContext) {
        return this.myTranslationHandlerDocumentMap.get(translationContext);
    }

    public Document[] getDocuments() {
        return this.myDocuments;
    }

    public TranslationHandler[] getTranslationHandlers() {
        return this.myTranslationHandlers;
    }

    public void setDocuments(Document[] documentArr) {
        this.myDocuments = documentArr;
        updateDocumentMap();
    }
}
