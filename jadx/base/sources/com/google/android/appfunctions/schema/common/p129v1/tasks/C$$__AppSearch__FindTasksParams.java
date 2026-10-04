package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__FindTasksParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindTasksParams implements DocumentClassFactory<FindTasksParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.FindTasksParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m762d("endTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m761c("completed", 2, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0))))).addProperty(AbstractC0541b.m763e("taskCategoryId", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindTasksParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("completed");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endTime");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("taskCategoryId");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        return new FindTasksParams(namespace, id, str2, boolValueOf, dateTime, dateTime2, str, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindTasksParams findTasksParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findTasksParams.getNamespace(), findTasksParams.getId(), SCHEMA_NAME);
        String query = findTasksParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        Boolean completed = findTasksParams.getCompleted();
        if (completed != null) {
            builder.setPropertyBoolean("completed", completed.booleanValue());
        }
        DateTime startTime = findTasksParams.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        DateTime endTime = findTasksParams.getEndTime();
        if (endTime != null) {
            builder.setPropertyDocument("endTime", GenericDocument.fromDocumentClass(endTime));
        }
        String taskCategoryId = findTasksParams.getTaskCategoryId();
        if (taskCategoryId != null) {
            builder.setPropertyString("taskCategoryId", taskCategoryId);
        }
        builder.setPropertyLong("maxCount", findTasksParams.getMaxCount());
        return builder.build();
    }
}
