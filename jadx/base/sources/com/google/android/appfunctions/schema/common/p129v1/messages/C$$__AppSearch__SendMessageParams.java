package com.google.android.appfunctions.schema.common.p129v1.messages;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Attachment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.messages.$$__AppSearch__SendMessageParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__SendMessageParams implements DocumentClassFactory<SendMessageParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.messages.SendMessageParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Attachment.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("messageAttachments", C$$__AppSearch__Attachment.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("body", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("recipientsIds", 1, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SendMessageParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("body");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("recipientsIds");
        ?? arrayList = Collections.EMPTY_LIST;
        ?? AsList = propertyStringArray2 != null ? Arrays.asList(propertyStringArray2) : arrayList;
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("messageAttachments");
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Attachment) genericDocument2.toDocumentClass(Attachment.class, documentClassMappingContext));
            }
        }
        return new SendMessageParams(namespace, id, str, AsList, arrayList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SendMessageParams sendMessageParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(sendMessageParams.getNamespace(), sendMessageParams.getId(), SCHEMA_NAME);
        String body = sendMessageParams.getBody();
        if (body != null) {
            builder.setPropertyString("body", body);
        }
        List<String> recipientsIds = sendMessageParams.getRecipientsIds();
        int i = 0;
        if (recipientsIds != null) {
            builder.setPropertyString("recipientsIds", (String[]) recipientsIds.toArray(new String[0]));
        }
        List<Attachment> messageAttachments = sendMessageParams.getMessageAttachments();
        if (messageAttachments != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[messageAttachments.size()];
            Iterator<Attachment> it = messageAttachments.iterator();
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("messageAttachments", genericDocumentArr);
        }
        return builder.build();
    }
}
