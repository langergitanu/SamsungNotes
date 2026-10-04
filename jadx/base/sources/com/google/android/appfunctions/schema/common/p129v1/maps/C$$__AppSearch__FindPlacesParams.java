package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__FindPlacesParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindPlacesParams implements DocumentClassFactory<FindPlacesParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.FindPlacesParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Location.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m762d("locationBias", C$$__AppSearch__Location.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindPlacesParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("locationBias");
        return new FindPlacesParams(namespace, id, str, propertyDocument != null ? (Location) propertyDocument.toDocumentClass(Location.class, documentClassMappingContext) : null, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindPlacesParams findPlacesParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findPlacesParams.getNamespace(), findPlacesParams.getId(), SCHEMA_NAME);
        String query = findPlacesParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        Location locationBias = findPlacesParams.getLocationBias();
        if (locationBias != null) {
            builder.setPropertyDocument("locationBias", GenericDocument.fromDocumentClass(locationBias));
        }
        builder.setPropertyLong("maxCount", findPlacesParams.getMaxCount());
        return builder.build();
    }
}
