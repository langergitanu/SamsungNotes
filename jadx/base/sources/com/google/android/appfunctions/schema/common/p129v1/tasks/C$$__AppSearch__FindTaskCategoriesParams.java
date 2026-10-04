package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__FindTaskCategoriesParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindTaskCategoriesParams implements DocumentClassFactory<FindTaskCategoriesParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.FindTaskCategoriesParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindTaskCategoriesParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        return new FindTaskCategoriesParams(namespace, id, (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0], (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindTaskCategoriesParams findTaskCategoriesParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findTaskCategoriesParams.getNamespace(), findTaskCategoriesParams.getId(), SCHEMA_NAME);
        String query = findTaskCategoriesParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        builder.setPropertyLong("maxCount", findTaskCategoriesParams.getMaxCount());
        return builder.build();
    }
}
