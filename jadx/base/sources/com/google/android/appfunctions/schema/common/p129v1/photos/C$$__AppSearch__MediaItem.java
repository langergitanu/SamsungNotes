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

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.photos.$$__AppSearch__MediaItem, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__MediaItem implements DocumentClassFactory<MediaItem> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.photos.MediaItem";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(DateTime.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m761c("starred", 2, AbstractC0541b.m762d("dateCreated", C$$__AppSearch__DateTime.SCHEMA_NAME, 3, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("type", 3, 0, 0, 0))).addProperty(AbstractC0541b.m763e("title", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e(Header.LOCATION, 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("albumId", 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public MediaItem fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("type");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dateCreated");
        DateTime dateTime = propertyDocument != null ? (DateTime) propertyDocument.toDocumentClass(DateTime.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("title");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        boolean[] propertyBooleanArray = genericDocument.getPropertyBooleanArray("starred");
        Boolean boolValueOf = (propertyBooleanArray == null || propertyBooleanArray.length == 0) ? null : Boolean.valueOf(propertyBooleanArray[0]);
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray(Header.LOCATION);
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("albumId");
        if (propertyStringArray4 != null && propertyStringArray4.length != 0) {
            str = propertyStringArray4[0];
        }
        return new MediaItem(namespace, id, str2, dateTime, str3, boolValueOf, str4, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(MediaItem mediaItem) {
        GenericDocument.Builder builder = new GenericDocument.Builder(mediaItem.getNamespace(), mediaItem.getId(), SCHEMA_NAME);
        String type = mediaItem.getType();
        if (type != null) {
            builder.setPropertyString("type", type);
        }
        DateTime dateCreated = mediaItem.getDateCreated();
        if (dateCreated != null) {
            builder.setPropertyDocument("dateCreated", GenericDocument.fromDocumentClass(dateCreated));
        }
        String title = mediaItem.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        Boolean starred = mediaItem.getStarred();
        if (starred != null) {
            builder.setPropertyBoolean("starred", starred.booleanValue());
        }
        String location = mediaItem.getLocation();
        if (location != null) {
            builder.setPropertyString(Header.LOCATION, location);
        }
        String albumId = mediaItem.getAlbumId();
        if (albumId != null) {
            builder.setPropertyString("albumId", albumId);
        }
        return builder.build();
    }
}
