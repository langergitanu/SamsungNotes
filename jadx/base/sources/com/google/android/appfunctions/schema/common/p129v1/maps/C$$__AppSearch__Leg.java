package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__Leg, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Leg implements DocumentClassFactory<Leg> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.Leg";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("distanceInMeter", 3, 0, AbstractC0541b.m760b("durationInSecond", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e("durationDisplayString", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("distanceDisplayString", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("startAddress", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("endAddress", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Leg fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long propertyLong = genericDocument.getPropertyLong("durationInSecond");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("durationDisplayString");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        long propertyLong2 = genericDocument.getPropertyLong("distanceInMeter");
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("distanceDisplayString");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("startAddress");
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("endAddress");
        if (propertyStringArray4 != null && propertyStringArray4.length != 0) {
            str = propertyStringArray4[0];
        }
        return new Leg(namespace, id, propertyLong, str2, propertyLong2, str3, str4, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Leg leg) {
        GenericDocument.Builder builder = new GenericDocument.Builder(leg.getNamespace(), leg.getId(), SCHEMA_NAME);
        builder.setPropertyLong("durationInSecond", leg.getDurationInSecond());
        String durationDisplayString = leg.getDurationDisplayString();
        if (durationDisplayString != null) {
            builder.setPropertyString("durationDisplayString", durationDisplayString);
        }
        builder.setPropertyLong("distanceInMeter", leg.getDistanceInMeter());
        String distanceDisplayString = leg.getDistanceDisplayString();
        if (distanceDisplayString != null) {
            builder.setPropertyString("distanceDisplayString", distanceDisplayString);
        }
        String startAddress = leg.getStartAddress();
        if (startAddress != null) {
            builder.setPropertyString("startAddress", startAddress);
        }
        String endAddress = leg.getEndAddress();
        if (endAddress != null) {
            builder.setPropertyString("endAddress", endAddress);
        }
        return builder.build();
    }
}
