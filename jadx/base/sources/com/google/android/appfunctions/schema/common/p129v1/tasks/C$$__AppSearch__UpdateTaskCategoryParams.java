package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.tasks.$$__AppSearch__UpdateTaskCategoryParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateTaskCategoryParams implements DocumentClassFactory<UpdateTaskCategoryParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.tasks.UpdateTaskCategoryParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringField.class);
        arrayList.add(SetStringListField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("taskIds", C$$__AppSearch__SetStringListField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("title", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("taskCategoryId", 3, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateTaskCategoryParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("taskCategoryId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("title");
        SetStringField setStringField = propertyDocument != null ? (SetStringField) propertyDocument.toDocumentClass(SetStringField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("taskIds");
        return new UpdateTaskCategoryParams(namespace, id, str, setStringField, propertyDocument2 != null ? (SetStringListField) propertyDocument2.toDocumentClass(SetStringListField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateTaskCategoryParams updateTaskCategoryParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateTaskCategoryParams.getNamespace(), updateTaskCategoryParams.getId(), SCHEMA_NAME);
        String taskCategoryId = updateTaskCategoryParams.getTaskCategoryId();
        if (taskCategoryId != null) {
            builder.setPropertyString("taskCategoryId", taskCategoryId);
        }
        SetStringField title = updateTaskCategoryParams.getTitle();
        if (title != null) {
            builder.setPropertyDocument("title", GenericDocument.fromDocumentClass(title));
        }
        SetStringListField taskIds = updateTaskCategoryParams.getTaskIds();
        if (taskIds != null) {
            builder.setPropertyDocument("taskIds", GenericDocument.fromDocumentClass(taskIds));
        }
        return builder.build();
    }
}
