package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__CreateTimerParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateTimerParams implements DocumentClassFactory<CreateTimerParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.CreateTimerParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("originalDurationMillis", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("label", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("timerState", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("externalId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateTimerParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("label");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        long propertyLong = genericDocument.getPropertyLong("originalDurationMillis");
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("timerState");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("externalId");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new CreateTimerParams(namespace, id, str2, propertyLong, str3, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateTimerParams createTimerParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createTimerParams.getNamespace(), createTimerParams.getId(), SCHEMA_NAME);
        String label = createTimerParams.getLabel();
        if (label != null) {
            builder.setPropertyString("label", label);
        }
        builder.setPropertyLong("originalDurationMillis", createTimerParams.getOriginalDurationMillis());
        String timerState = createTimerParams.getTimerState();
        if (timerState != null) {
            builder.setPropertyString("timerState", timerState);
        }
        String externalId = createTimerParams.getExternalId();
        if (externalId != null) {
            builder.setPropertyString("externalId", externalId);
        }
        return builder.build();
    }
}
