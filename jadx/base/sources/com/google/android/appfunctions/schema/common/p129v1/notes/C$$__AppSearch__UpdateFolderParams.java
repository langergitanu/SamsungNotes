package com.google.android.appfunctions.schema.common.p129v1.notes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.notes.$$__AppSearch__UpdateFolderParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateFolderParams implements DocumentClassFactory<UpdateFolderParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.notes.UpdateFolderParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(SetStringField.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("name", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("folderId", 3, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateFolderParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("folderId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("name");
        return new UpdateFolderParams(namespace, id, str, propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateFolderParams updateFolderParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateFolderParams.getNamespace(), updateFolderParams.getId(), SCHEMA_NAME);
        String folderId = updateFolderParams.getFolderId();
        if (folderId != null) {
            builder.setPropertyString("folderId", folderId);
        }
        SetStringField name = updateFolderParams.getName();
        if (name != null) {
            builder.setPropertyDocument("name", GenericDocument.fromDocumentClass(name));
        }
        return builder.build();
    }
}
