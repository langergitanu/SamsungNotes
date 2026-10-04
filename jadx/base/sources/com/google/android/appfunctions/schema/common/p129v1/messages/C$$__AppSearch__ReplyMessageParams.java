package com.google.android.appfunctions.schema.common.p129v1.messages;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Attachment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.messages.$$__AppSearch__ReplyMessageParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__ReplyMessageParams implements DocumentClassFactory<ReplyMessageParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.messages.ReplyMessageParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Attachment.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("messageAttachments", C$$__AppSearch__Attachment.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("originalMessageId", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("body", 3, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public ReplyMessageParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("originalMessageId");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("body");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("messageAttachments");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Attachment) genericDocument2.toDocumentClass(Attachment.class, documentClassMappingContext));
            }
        }
        return new ReplyMessageParams(namespace, id, str2, str, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(ReplyMessageParams replyMessageParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(replyMessageParams.getNamespace(), replyMessageParams.getId(), SCHEMA_NAME);
        String originalMessageId = replyMessageParams.getOriginalMessageId();
        if (originalMessageId != null) {
            builder.setPropertyString("originalMessageId", originalMessageId);
        }
        String body = replyMessageParams.getBody();
        if (body != null) {
            builder.setPropertyString("body", body);
        }
        List<Attachment> messageAttachments = replyMessageParams.getMessageAttachments();
        if (messageAttachments != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[messageAttachments.size()];
            Iterator<Attachment> it = messageAttachments.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("messageAttachments", genericDocumentArr);
        }
        return builder.build();
    }
}
