package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__Location, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Location implements DocumentClassFactory<Location> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.Location";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.class);
        arrayList.add(LatLng.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("latLng", C$$__AppSearch__LatLng.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("placeUri", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Location fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("placeUri");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("latLng");
        return new Location(namespace, id, uri, propertyDocument2 != null ? (LatLng) propertyDocument2.toDocumentClass(LatLng.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Location location) {
        GenericDocument.Builder builder = new GenericDocument.Builder(location.getNamespace(), location.getId(), SCHEMA_NAME);
        Uri placeUri = location.getPlaceUri();
        if (placeUri != null) {
            builder.setPropertyDocument("placeUri", GenericDocument.fromDocumentClass(placeUri));
        }
        LatLng latLng = location.getLatLng();
        if (latLng != null) {
            builder.setPropertyDocument("latLng", GenericDocument.fromDocumentClass(latLng));
        }
        return builder.build();
    }
}
