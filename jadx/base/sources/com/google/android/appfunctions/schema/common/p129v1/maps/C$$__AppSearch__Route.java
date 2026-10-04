package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.maps.$$__AppSearch__Route, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__Route implements DocumentClassFactory<Route> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.maps.Route";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Leg.class);
        arrayList.add(Uri.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("directionImageUri", C$$__AppSearch__Uri.SCHEMA_NAME, 3, false, AbstractC0541b.m762d("navigationUri", C$$__AppSearch__Uri.SCHEMA_NAME, 3, false, AbstractC0541b.m762d("directionUri", C$$__AppSearch__Uri.SCHEMA_NAME, 3, false, AbstractC0541b.m762d("legs", C$$__AppSearch__Leg.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME)).addProperty(AbstractC0541b.m763e(DBSchema.DocumentCover.SUMMARY, 2, 0, 0, 0)))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList] */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Route fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("legs");
        ?? arrayList = Collections.EMPTY_LIST;
        if (propertyDocumentArray != null) {
            arrayList = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((Leg) genericDocument2.toDocumentClass(Leg.class, documentClassMappingContext));
            }
        }
        String[] propertyStringArray = genericDocument.getPropertyStringArray(DBSchema.DocumentCover.SUMMARY);
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("directionUri");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("navigationUri");
        Uri uri2 = propertyDocument2 != null ? (Uri) propertyDocument2.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("directionImageUri");
        return new Route(namespace, id, arrayList, str, uri, uri2, propertyDocument3 != null ? (Uri) propertyDocument3.toDocumentClass(Uri.class, documentClassMappingContext) : null);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Route route) {
        GenericDocument.Builder builder = new GenericDocument.Builder(route.getNamespace(), route.getId(), SCHEMA_NAME);
        List<Leg> legs = route.getLegs();
        if (legs != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[legs.size()];
            Iterator<Leg> it = legs.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("legs", genericDocumentArr);
        }
        String summary = route.getSummary();
        if (summary != null) {
            builder.setPropertyString(DBSchema.DocumentCover.SUMMARY, summary);
        }
        Uri directionUri = route.getDirectionUri();
        if (directionUri != null) {
            builder.setPropertyDocument("directionUri", GenericDocument.fromDocumentClass(directionUri));
        }
        Uri navigationUri = route.getNavigationUri();
        if (navigationUri != null) {
            builder.setPropertyDocument("navigationUri", GenericDocument.fromDocumentClass(navigationUri));
        }
        Uri directionImageUri = route.getDirectionImageUri();
        if (directionImageUri != null) {
            builder.setPropertyDocument("directionImageUri", GenericDocument.fromDocumentClass(directionImageUri));
        }
        return builder.build();
    }
}
