package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.types.$$__AppSearch__Date, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Date implements DocumentClassFactory<Date> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.types.Date";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("day", 3, 0, AbstractC0541b.m760b("month", 3, 0, AbstractC0541b.m760b("year", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Date fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        return new Date(genericDocument.getNamespace(), genericDocument.getId(), (int) genericDocument.getPropertyLong("year"), (int) genericDocument.getPropertyLong("month"), (int) genericDocument.getPropertyLong("day"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Date date) {
        GenericDocument.Builder builder = new GenericDocument.Builder(date.getNamespace(), date.getId(), SCHEMA_NAME);
        builder.setPropertyLong("year", date.getYear());
        builder.setPropertyLong("month", date.getMonth());
        builder.setPropertyLong("day", date.getDay());
        return builder.build();
    }
}
