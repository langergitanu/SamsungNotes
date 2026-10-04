package com.google.android.appfunctions.schema.common.p129v1.notes;

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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.notes.$$__AppSearch__CreateNoteParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateNoteParams implements DocumentClassFactory<CreateNoteParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.notes.CreateNoteParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Attachment.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d("attachments", C$$__AppSearch__Attachment.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("content", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("folderId", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("externalId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateNoteParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("content");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("attachments");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Attachment) genericDocument2.toDocumentClass(Attachment.class, documentClassMappingContext));
            }
        }
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("folderId");
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("externalId");
        if (propertyStringArray4 != null && propertyStringArray4.length != 0) {
            str = propertyStringArray4[0];
        }
        return new CreateNoteParams(namespace, id, str2, str3, arrayList, str4, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateNoteParams createNoteParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createNoteParams.getNamespace(), createNoteParams.getId(), SCHEMA_NAME);
        String title = createNoteParams.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        String content = createNoteParams.getContent();
        if (content != null) {
            builder.setPropertyString("content", content);
        }
        List<Attachment> attachments = createNoteParams.getAttachments();
        if (attachments != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[attachments.size()];
            Iterator<Attachment> it = attachments.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("attachments", genericDocumentArr);
        }
        String folderId = createNoteParams.getFolderId();
        if (folderId != null) {
            builder.setPropertyString("folderId", folderId);
        }
        String externalId = createNoteParams.getExternalId();
        if (externalId != null) {
            builder.setPropertyString("externalId", externalId);
        }
        return builder.build();
    }
}
