package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__FindAlarmsParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindAlarmsParams implements DocumentClassFactory<FindAlarmsParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.FindAlarmsParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DateTime.class);
        arrayList.add(DayPattern.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("maxCount", 3, 0, AbstractC0541b.m762d("dayPattern", C$$__AppSearch__DayPattern.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("endTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME))).addProperty(AbstractC0541b.m763e("label", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("alarmStatus", 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("sortingOrder", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindAlarmsParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        String str = null;
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endTime");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("label");
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("alarmStatus");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("dayPattern");
        DayPattern dayPattern = propertyDocument3 != null ? (DayPattern) propertyDocument3.toDocumentClass(DayPattern.class, documentClassMappingContext) : null;
        int propertyLong = (int) genericDocument.getPropertyLong("maxCount");
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("sortingOrder");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new FindAlarmsParams(namespace, id, dateTime, dateTime2, str2, str3, dayPattern, propertyLong, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindAlarmsParams findAlarmsParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findAlarmsParams.getNamespace(), findAlarmsParams.getId(), SCHEMA_NAME);
        DateTime startTime = findAlarmsParams.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        DateTime endTime = findAlarmsParams.getEndTime();
        if (endTime != null) {
            builder.setPropertyDocument("endTime", GenericDocument.fromDocumentClass(endTime));
        }
        String label = findAlarmsParams.getLabel();
        if (label != null) {
            builder.setPropertyString("label", label);
        }
        String alarmStatus = findAlarmsParams.getAlarmStatus();
        if (alarmStatus != null) {
            builder.setPropertyString("alarmStatus", alarmStatus);
        }
        DayPattern dayPattern = findAlarmsParams.getDayPattern();
        if (dayPattern != null) {
            builder.setPropertyDocument("dayPattern", GenericDocument.fromDocumentClass(dayPattern));
        }
        builder.setPropertyLong("maxCount", findAlarmsParams.getMaxCount());
        String sortingOrder = findAlarmsParams.getSortingOrder();
        if (sortingOrder != null) {
            builder.setPropertyString("sortingOrder", sortingOrder);
        }
        return builder.build();
    }
}
