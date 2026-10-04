package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__TimeOfDayRange;
import com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDayRange;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__OpeningHours, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__OpeningHours implements DocumentClassFactory<OpeningHours> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.OpeningHours";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(TimeOfDayRange.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("sunday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("saturday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("friday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("thursday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("wednesday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("tuesday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("monday", C$$__AppSearch__TimeOfDayRange.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME))))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public OpeningHours fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("monday");
        TimeOfDayRange timeOfDayRange = propertyDocument != null ? (TimeOfDayRange) propertyDocument.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("tuesday");
        TimeOfDayRange timeOfDayRange2 = propertyDocument2 != null ? (TimeOfDayRange) propertyDocument2.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("wednesday");
        TimeOfDayRange timeOfDayRange3 = propertyDocument3 != null ? (TimeOfDayRange) propertyDocument3.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument4 = genericDocument.getPropertyDocument("thursday");
        TimeOfDayRange timeOfDayRange4 = propertyDocument4 != null ? (TimeOfDayRange) propertyDocument4.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument5 = genericDocument.getPropertyDocument("friday");
        TimeOfDayRange timeOfDayRange5 = propertyDocument5 != null ? (TimeOfDayRange) propertyDocument5.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument6 = genericDocument.getPropertyDocument("saturday");
        TimeOfDayRange timeOfDayRange6 = propertyDocument6 != null ? (TimeOfDayRange) propertyDocument6.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument7 = genericDocument.getPropertyDocument("sunday");
        return new OpeningHours(namespace, id, timeOfDayRange, timeOfDayRange2, timeOfDayRange3, timeOfDayRange4, timeOfDayRange5, timeOfDayRange6, propertyDocument7 != null ? (TimeOfDayRange) propertyDocument7.toDocumentClass(TimeOfDayRange.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(OpeningHours openingHours) {
        GenericDocument.Builder builder = new GenericDocument.Builder(openingHours.getNamespace(), openingHours.getId(), SCHEMA_NAME);
        TimeOfDayRange monday = openingHours.getMonday();
        if (monday != null) {
            builder.setPropertyDocument("monday", GenericDocument.fromDocumentClass(monday));
        }
        TimeOfDayRange tuesday = openingHours.getTuesday();
        if (tuesday != null) {
            builder.setPropertyDocument("tuesday", GenericDocument.fromDocumentClass(tuesday));
        }
        TimeOfDayRange wednesday = openingHours.getWednesday();
        if (wednesday != null) {
            builder.setPropertyDocument("wednesday", GenericDocument.fromDocumentClass(wednesday));
        }
        TimeOfDayRange thursday = openingHours.getThursday();
        if (thursday != null) {
            builder.setPropertyDocument("thursday", GenericDocument.fromDocumentClass(thursday));
        }
        TimeOfDayRange friday = openingHours.getFriday();
        if (friday != null) {
            builder.setPropertyDocument("friday", GenericDocument.fromDocumentClass(friday));
        }
        TimeOfDayRange saturday = openingHours.getSaturday();
        if (saturday != null) {
            builder.setPropertyDocument("saturday", GenericDocument.fromDocumentClass(saturday));
        }
        TimeOfDayRange sunday = openingHours.getSunday();
        if (sunday != null) {
            builder.setPropertyDocument("sunday", GenericDocument.fromDocumentClass(sunday));
        }
        return builder.build();
    }
}
