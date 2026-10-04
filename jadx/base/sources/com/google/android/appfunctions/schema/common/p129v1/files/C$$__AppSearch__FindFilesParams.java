package com.google.android.appfunctions.schema.common.p129v1.files;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.files.$$__AppSearch__FindFilesParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindFilesParams implements DocumentClassFactory<FindFilesParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.files.FindFilesParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("fileType", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindFilesParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("fileType");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        return new FindFilesParams(namespace, id, str2, str, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindFilesParams findFilesParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findFilesParams.getNamespace(), findFilesParams.getId(), SCHEMA_NAME);
        String query = findFilesParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        String fileType = findFilesParams.getFileType();
        if (fileType != null) {
            builder.setPropertyString("fileType", fileType);
        }
        builder.setPropertyLong("maxCount", findFilesParams.getMaxCount());
        return builder.build();
    }
}
