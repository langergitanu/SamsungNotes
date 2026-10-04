package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.email.$$__AppSearch__FindAccountsParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindAccountsParams implements DocumentClassFactory<FindAccountsParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.email.FindAccountsParams";

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
    public FindAccountsParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        return new FindAccountsParams(namespace, id, (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0], (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindAccountsParams findAccountsParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findAccountsParams.getNamespace(), findAccountsParams.getId(), SCHEMA_NAME);
        String query = findAccountsParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        builder.setPropertyLong("maxCount", findAccountsParams.getMaxCount());
        return builder.build();
    }
}
