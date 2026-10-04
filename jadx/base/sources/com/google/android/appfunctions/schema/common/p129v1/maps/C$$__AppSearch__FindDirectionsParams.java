package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__FindDirectionsParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindDirectionsParams implements DocumentClassFactory<FindDirectionsParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.FindDirectionsParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Location.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d("destinations", C$$__AppSearch__Location.SCHEMA_NAME, 1, false, AbstractC0541b.m762d("origin", C$$__AppSearch__Location.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME))).addProperty(AbstractC0541b.m763e("transportationType", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("avoidTypes", 1, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindDirectionsParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("origin");
        String str = null;
        Location location = propertyDocument != null ? (Location) propertyDocument.toDocumentClass(Location.class, documentClassMappingContext) : null;
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("destinations");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Location) genericDocument2.toDocumentClass(Location.class, documentClassMappingContext));
            }
        }
        String[] propertyStringArray = genericDocument.getPropertyStringArray("transportationType");
        if (propertyStringArray != null && propertyStringArray.length != 0) {
            str = propertyStringArray[0];
        }
        String str2 = str;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("avoidTypes");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        return new FindDirectionsParams(namespace, id, location, arrayList, str2, listAsList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindDirectionsParams findDirectionsParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findDirectionsParams.getNamespace(), findDirectionsParams.getId(), SCHEMA_NAME);
        Location origin = findDirectionsParams.getOrigin();
        if (origin != null) {
            builder.setPropertyDocument("origin", GenericDocument.fromDocumentClass(origin));
        }
        List<Location> destinations = findDirectionsParams.getDestinations();
        if (destinations != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[destinations.size()];
            Iterator<Location> it = destinations.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("destinations", genericDocumentArr);
        }
        String transportationType = findDirectionsParams.getTransportationType();
        if (transportationType != null) {
            builder.setPropertyString("transportationType", transportationType);
        }
        List<String> avoidTypes = findDirectionsParams.getAvoidTypes();
        if (avoidTypes != null) {
            builder.setPropertyString("avoidTypes", (String[]) avoidTypes.toArray(new String[0]));
        }
        return builder.build();
    }
}
