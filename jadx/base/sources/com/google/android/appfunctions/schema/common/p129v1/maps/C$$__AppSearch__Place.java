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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__Place, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Place implements DocumentClassFactory<Place> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.Place";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.class);
        arrayList.add(OpeningHours.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("openingHours", C$$__AppSearch__OpeningHours.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("uri", C$$__AppSearch__Uri.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e("name", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("address", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Place fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("uri");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("address");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("openingHours");
        return new Place(namespace, id, uri, str, str2, str3, propertyDocument2 != null ? (OpeningHours) propertyDocument2.toDocumentClass(OpeningHours.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Place place) {
        GenericDocument.Builder builder = new GenericDocument.Builder(place.getNamespace(), place.getId(), SCHEMA_NAME);
        Uri uri = place.getUri();
        if (uri != null) {
            builder.setPropertyDocument("uri", GenericDocument.fromDocumentClass(uri));
        }
        String name = place.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        String address = place.getAddress();
        if (address != null) {
            builder.setPropertyString("address", address);
        }
        String description = place.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        OpeningHours openingHours = place.getOpeningHours();
        if (openingHours != null) {
            builder.setPropertyDocument("openingHours", GenericDocument.fromDocumentClass(openingHours));
        }
        return builder.build();
    }
}
