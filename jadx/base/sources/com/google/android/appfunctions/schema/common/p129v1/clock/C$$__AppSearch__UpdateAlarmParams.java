package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetTimeOfDayField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetTimeOfDayField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__UpdateAlarmParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateAlarmParams implements DocumentClassFactory<UpdateAlarmParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.UpdateAlarmParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetTimeOfDayField.class);
        arrayList.add(SetDayPatternNullableField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("dayPattern", C$$__AppSearch__SetDayPatternNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("alarmStatus", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("time", C$$__AppSearch__SetTimeOfDayField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("label", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("alarmId", 3, 0, 0, 0))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateAlarmParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("alarmId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("label");
        SetStringNullableField setStringNullableField = propertyDocument != null ? (SetStringNullableField) propertyDocument.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("time");
        SetTimeOfDayField setTimeOfDayField = propertyDocument2 != null ? (SetTimeOfDayField) propertyDocument2.toDocumentClass(SetTimeOfDayField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("alarmStatus");
        SetStringNullableField setStringNullableField2 = propertyDocument3 != null ? (SetStringNullableField) propertyDocument3.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("dayPattern");
        return new UpdateAlarmParams(namespace, id, str, setStringNullableField, setTimeOfDayField, setStringNullableField2, propertyDocument4 != null ? (SetDayPatternNullableField) propertyDocument4.toDocumentClass(SetDayPatternNullableField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateAlarmParams updateAlarmParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateAlarmParams.getNamespace(), updateAlarmParams.getId(), SCHEMA_NAME);
        String alarmId = updateAlarmParams.getAlarmId();
        if (alarmId != null) {
            builder.setPropertyString("alarmId", alarmId);
        }
        SetStringNullableField label = updateAlarmParams.getLabel();
        if (label != null) {
            builder.setPropertyDocument("label", GenericDocument.fromDocumentClass(label));
        }
        SetTimeOfDayField time = updateAlarmParams.getTime();
        if (time != null) {
            builder.setPropertyDocument("time", GenericDocument.fromDocumentClass(time));
        }
        SetStringNullableField alarmStatus = updateAlarmParams.getAlarmStatus();
        if (alarmStatus != null) {
            builder.setPropertyDocument("alarmStatus", GenericDocument.fromDocumentClass(alarmStatus));
        }
        SetDayPatternNullableField dayPattern = updateAlarmParams.getDayPattern();
        if (dayPattern != null) {
            builder.setPropertyDocument("dayPattern", GenericDocument.fromDocumentClass(dayPattern));
        }
        return builder.build();
    }
}
