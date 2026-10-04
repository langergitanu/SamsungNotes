package com.google.android.appfunctions.schema.common.p129v1.notes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetAttachmentListField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetAttachmentListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.notes.$$__AppSearch__UpdateNoteParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateNoteParams implements DocumentClassFactory<UpdateNoteParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.notes.UpdateNoteParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetAttachmentListField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("folderId", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("attachments", C$$__AppSearch__SetAttachmentListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("content", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("noteId", 3, 0, 0, 0))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateNoteParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("noteId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("content");
        SetStringNullableField setStringNullableField = propertyDocument2 != null ? (SetStringNullableField) propertyDocument2.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("attachments");
        SetAttachmentListField setAttachmentListField = propertyDocument3 != null ? (SetAttachmentListField) propertyDocument3.toDocumentClass(SetAttachmentListField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("folderId");
        return new UpdateNoteParams(namespace, id, str, setStringField, setStringNullableField, setAttachmentListField, propertyDocument4 != null ? (SetStringNullableField) propertyDocument4.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateNoteParams updateNoteParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateNoteParams.getNamespace(), updateNoteParams.getId(), SCHEMA_NAME);
        String noteId = updateNoteParams.getNoteId();
        if (noteId != null) {
            builder.setPropertyString("noteId", noteId);
        }
        SetStringField title = updateNoteParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        SetStringNullableField content = updateNoteParams.getContent();
        if (content != null) {
            builder.setPropertyDocument("content", GenericDocument.fromDocumentClass(content));
        }
        SetAttachmentListField attachments = updateNoteParams.getAttachments();
        if (attachments != null) {
            builder.setPropertyDocument("attachments", GenericDocument.fromDocumentClass(attachments));
        }
        SetStringNullableField folderId = updateNoteParams.getFolderId();
        if (folderId != null) {
            builder.setPropertyDocument("folderId", GenericDocument.fromDocumentClass(folderId));
        }
        return builder.build();
    }
}
