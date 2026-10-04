package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetLongField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetLongField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.clock.$$__AppSearch__UpdateTimerParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__UpdateTimerParams implements DocumentClassFactory<UpdateTimerParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.clock.UpdateTimerParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SetStringNullableField.class);
        arrayList.add(SetLongField.class);
        arrayList.add(SetStringField.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("timerState", C$$__AppSearch__SetStringField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("durationMs", C$$__AppSearch__SetLongField.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("label", C$$__AppSearch__SetStringNullableField.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("timerId", 3, 0, 0, 0)))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public UpdateTimerParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("timerId");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("label");
        SetStringNullableField setStringNullableField = propertyDocument != null ? (SetStringNullableField) propertyDocument.toDocumentClass(SetStringNullableField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("durationMs");
        SetLongField setLongField = propertyDocument2 != null ? (SetLongField) propertyDocument2.toDocumentClass(SetLongField.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("timerState");
        return new UpdateTimerParams(namespace, id, str, setStringNullableField, setLongField, propertyDocument3 != null ? (SetStringField) propertyDocument3.toDocumentClass(SetStringField.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(UpdateTimerParams updateTimerParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(updateTimerParams.getNamespace(), updateTimerParams.getId(), SCHEMA_NAME);
        String timerId = updateTimerParams.getTimerId();
        if (timerId != null) {
            builder.setPropertyString("timerId", timerId);
        }
        SetStringNullableField label = updateTimerParams.getLabel();
        if (label != null) {
            builder.setPropertyDocument("label", GenericDocument.fromDocumentClass(label));
        }
        SetLongField durationMs = updateTimerParams.getDurationMs();
        if (durationMs != null) {
            builder.setPropertyDocument("durationMs", GenericDocument.fromDocumentClass(durationMs));
        }
        SetStringField timerState = updateTimerParams.getTimerState();
        if (timerState != null) {
            builder.setPropertyDocument("timerState", GenericDocument.fromDocumentClass(timerState));
        }
        return builder.build();
    }
}
