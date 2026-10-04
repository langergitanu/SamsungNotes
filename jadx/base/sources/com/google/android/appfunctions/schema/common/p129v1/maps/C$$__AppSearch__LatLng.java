package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__LatLng, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__LatLng implements DocumentClassFactory<LatLng> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.LatLng";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.DoublePropertyConfig.Builder("latitude").setCardinality(3).build()).addProperty(new AppSearchSchema.DoublePropertyConfig.Builder("longitude").setCardinality(3).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public LatLng fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        return new LatLng(genericDocument.getNamespace(), genericDocument.getId(), genericDocument.getPropertyDouble("latitude"), genericDocument.getPropertyDouble("longitude"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(LatLng latLng) {
        GenericDocument.Builder builder = new GenericDocument.Builder(latLng.getNamespace(), latLng.getId(), SCHEMA_NAME);
        builder.setPropertyDouble("latitude", latLng.getLatitude());
        builder.setPropertyDouble("longitude", latLng.getLongitude());
        return builder.build();
    }
}
