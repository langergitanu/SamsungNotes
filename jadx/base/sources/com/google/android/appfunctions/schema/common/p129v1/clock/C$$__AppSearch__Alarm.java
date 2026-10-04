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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__Alarm, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Alarm implements DocumentClassFactory<Alarm> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.Alarm";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TimeOfDay.class);
        arrayList.add(DayPattern.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("dayPattern", C$$__AppSearch__DayPattern.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("time", C$$__AppSearch__TimeOfDay.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("label", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("alarmStatus", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Alarm fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("label");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("time");
        TimeOfDay timeOfDay = propertyDocument != null ? (TimeOfDay) propertyDocument.toDocumentClass(TimeOfDay.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("alarmStatus");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("dayPattern");
        return new Alarm(namespace, id, str, timeOfDay, str2, propertyDocument2 != null ? (DayPattern) propertyDocument2.toDocumentClass(DayPattern.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Alarm alarm) {
        GenericDocument.Builder builder = new GenericDocument.Builder(alarm.getNamespace(), alarm.getId(), SCHEMA_NAME);
        String label = alarm.getLabel();
        if (label != null) {
            builder.setPropertyString("label", label);
        }
        TimeOfDay time = alarm.getTime();
        if (time != null) {
            builder.setPropertyDocument("time", GenericDocument.fromDocumentClass(time));
        }
        String alarmStatus = alarm.getAlarmStatus();
        if (alarmStatus != null) {
            builder.setPropertyString("alarmStatus", alarmStatus);
        }
        DayPattern dayPattern = alarm.getDayPattern();
        if (dayPattern != null) {
            builder.setPropertyDocument("dayPattern", GenericDocument.fromDocumentClass(dayPattern));
        }
        return builder.build();
    }
}
