package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__FindTimersParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindTimersParams implements DocumentClassFactory<FindTimersParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.FindTimersParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("maxCount", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("label", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("timerState", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("sortingOrder", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindTimersParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("label");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("timerState");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        int propertyLong = (int) genericDocument.getPropertyLong("maxCount");
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("sortingOrder");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new FindTimersParams(namespace, id, str2, str3, propertyLong, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindTimersParams findTimersParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findTimersParams.getNamespace(), findTimersParams.getId(), SCHEMA_NAME);
        String label = findTimersParams.getLabel();
        if (label != null) {
            builder.setPropertyString("label", label);
        }
        String timerState = findTimersParams.getTimerState();
        if (timerState != null) {
            builder.setPropertyString("timerState", timerState);
        }
        builder.setPropertyLong("maxCount", findTimersParams.getMaxCount());
        String sortingOrder = findTimersParams.getSortingOrder();
        if (sortingOrder != null) {
            builder.setPropertyString("sortingOrder", sortingOrder);
        }
        return builder.build();
    }
}
