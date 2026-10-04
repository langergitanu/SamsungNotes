package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__DateTime;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.scsp.common.Header;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__FindMediaItemsParams, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__FindMediaItemsParams implements DocumentClassFactory<FindMediaItemsParams> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.FindMediaItemsParams";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("maxCount", 3, 0, AbstractC0541b.m761c("starred", 2, AbstractC0541b.m762d("endTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("startTime", C$$__AppSearch__DateTime.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME))).addProperty(AbstractC0541b.m763e("query", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e(Header.LOCATION, 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("albumId", 2, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public FindMediaItemsParams fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("startTime");
        String str = null;
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("endTime");
        DateTime dateTime2 = propertyDocument2 != null ? (DateTime) propertyDocument2.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray(Header.LOCATION);
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("starred");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("albumId");
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new FindMediaItemsParams(namespace, id, dateTime, dateTime2, str2, str3, boolValueOf, str, (int) genericDocument.getPropertyLong("maxCount"));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(FindMediaItemsParams findMediaItemsParams) {
        GenericDocument.Builder builder = new GenericDocument.Builder(findMediaItemsParams.getNamespace(), findMediaItemsParams.getId(), SCHEMA_NAME);
        DateTime startTime = findMediaItemsParams.getStartTime();
        if (startTime != null) {
            builder.setPropertyDocument("startTime", GenericDocument.fromDocumentClass(startTime));
        }
        DateTime endTime = findMediaItemsParams.getEndTime();
        if (endTime != null) {
            builder.setPropertyDocument("endTime", GenericDocument.fromDocumentClass(endTime));
        }
        String query = findMediaItemsParams.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        String location = findMediaItemsParams.getLocation();
        if (location != null) {
            builder.setPropertyString(Header.LOCATION, location);
        }
        Boolean starred = findMediaItemsParams.getStarred();
        if (starred != null) {
            builder.setPropertyBoolean("starred", starred.booleanValue());
        }
        String albumId = findMediaItemsParams.getAlbumId();
        if (albumId != null) {
            builder.setPropertyString("albumId", albumId);
        }
        builder.setPropertyLong("maxCount", findMediaItemsParams.getMaxCount());
        return builder.build();
    }
}
