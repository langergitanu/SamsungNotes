package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__TaskCategory, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__TaskCategory implements DocumentClassFactory<TaskCategory> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.TaskCategory";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("taskIds", 1, 0, 0, 0)).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isReadOnly").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public TaskCategory fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        Boolean boolValueOf = null;
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("taskIds");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        List list = listAsList;
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("isReadOnly");
        if (propertyBooleanArray != null && propertyBooleanArray.length != 0) {
            boolValueOf = Boolean.valueOf(propertyBooleanArray[0]);
        }
        return new TaskCategory(namespace, id, str, list, boolValueOf);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(TaskCategory taskCategory) {
        GenericDocument.Builder builder = new GenericDocument.Builder(taskCategory.getNamespace(), taskCategory.getId(), SCHEMA_NAME);
        String title = taskCategory.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        List<String> taskIds = taskCategory.getTaskIds();
        if (taskIds != null) {
            builder.setPropertyString("taskIds", (String[]) taskIds.toArray(new String[0]));
        }
        Boolean isReadOnly = taskCategory.getIsReadOnly();
        if (isReadOnly != null) {
            builder.setPropertyBoolean("isReadOnly", isReadOnly.booleanValue());
        }
        return builder.build();
    }
}
