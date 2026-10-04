package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__TimeOfDay;
import com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__CreateAlarmParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__CreateAlarmParams implements DocumentClassFactory<CreateAlarmParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.CreateAlarmParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TimeOfDay.class);
        arrayList.add(DayPattern.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d("dayPattern", C$$__AppSearch__DayPattern.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("time", C$$__AppSearch__TimeOfDay.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("label", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("alarmStatus", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("externalId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public CreateAlarmParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("label");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("time");
        TimeOfDay timeOfDay = propertyDocument != null ? (TimeOfDay) propertyDocument.toDocumentClass(TimeOfDay.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("alarmStatus");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("dayPattern");
        DayPattern dayPattern = propertyDocument2 != null ? (DayPattern) propertyDocument2.toDocumentClass(DayPattern.class, documentClassMappingContext) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("externalId");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new CreateAlarmParams(namespace, id, str2, timeOfDay, str3, dayPattern, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(CreateAlarmParams createAlarmParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(createAlarmParams.getNamespace(), createAlarmParams.getId(), SCHEMA_NAME);
        String label = createAlarmParams.getLabel();
        if (label != null) {
            builder.setPropertyString("label", label);
        }
        TimeOfDay time = createAlarmParams.getTime();
        if (time != null) {
            builder.setPropertyDocument("time", GenericDocument.fromDocumentClass(time));
        }
        String alarmStatus = createAlarmParams.getAlarmStatus();
        if (alarmStatus != null) {
            builder.setPropertyString("alarmStatus", alarmStatus);
        }
        DayPattern dayPattern = createAlarmParams.getDayPattern();
        if (dayPattern != null) {
            builder.setPropertyDocument("dayPattern", GenericDocument.fromDocumentClass(dayPattern));
        }
        String externalId = createAlarmParams.getExternalId();
        if (externalId != null) {
            builder.setPropertyString("externalId", externalId);
        }
        return builder.build();
    }
}
