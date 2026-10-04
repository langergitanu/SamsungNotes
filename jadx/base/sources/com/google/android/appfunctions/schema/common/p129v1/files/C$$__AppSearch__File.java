package com.google.android.appfunctions.schema.common.p129v1.files;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.files.$$__AppSearch__File, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__File implements DocumentClassFactory<File> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.files.File";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("dateCreated", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 3, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public File fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dateCreated");
        return new File(namespace, id, str, propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(File file) {
        GenericDocument.Builder builder = new GenericDocument.Builder(file.getNamespace(), file.getId(), SCHEMA_NAME);
        String name = file.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        DateTime dateCreated = file.getDateCreated();
        if (dateCreated != null) {
            builder.setPropertyDocument("dateCreated", GenericDocument.fromDocumentClass(dateCreated));
        }
        return builder.build();
    }
}
