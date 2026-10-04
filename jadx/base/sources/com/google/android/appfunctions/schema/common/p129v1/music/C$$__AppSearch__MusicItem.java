package com.google.android.appfunctions.schema.common.p129v1.music;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Date;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Date;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.music.$$__AppSearch__MusicItem, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__MusicItem implements DocumentClassFactory<MusicItem> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.music.MusicItem";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uri.class);
        arrayList.add(Date.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d("thumbnail", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, AbstractC0541b.m760b("lengthInSeconds", 2, 0, AbstractC0541b.m762d("publishDate", C$$__AppSearch__Date.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("deeplink", C$$__AppSearch__Uri.SCHEMA_NAME, 2, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("type", 3, 0, 0, 0))).addProperty(AbstractC0541b.m763e("title", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("artistNames", 1, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("childMusicItemIds", 1, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public MusicItem fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("type");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("deeplink");
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("title");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("artistNames");
        List listAsList = Collections.EMPTY_LIST;
        List listAsList2 = propertyStringArray3 != null ? Arrays.asList(propertyStringArray3) : listAsList;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("publishDate");
        Date date = propertyDocument2 != null ? (Date) propertyDocument2.toDocumentClass(Date.class, documentClassMappingContext) : null;
        long[] propertyLongArray = genericDocument.getPropertyLongArray("lengthInSeconds");
        Long lValueOf = (propertyLongArray == null || propertyLongArray.length == 0) ? null : Long.valueOf(propertyLongArray[0]);
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        GenericDocument propertyDocument3 = genericDocument.getPropertyDocument("thumbnail");
        Uri uri2 = propertyDocument3 != null ? (Uri) propertyDocument3.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("childMusicItemIds");
        if (propertyStringArray5 != null) {
            listAsList = Arrays.asList(propertyStringArray5);
        }
        return new MusicItem(namespace, id, str, uri, str2, listAsList2, date, lValueOf, str3, uri2, listAsList);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(MusicItem musicItem) {
        GenericDocument.Builder builder = new GenericDocument.Builder(musicItem.getNamespace(), musicItem.getId(), SCHEMA_NAME);
        String type = musicItem.getType();
        if (type != null) {
            builder.setPropertyString("type", type);
        }
        Uri deeplink = musicItem.getDeeplink();
        if (deeplink != null) {
            builder.setPropertyDocument("deeplink", GenericDocument.fromDocumentClass(deeplink));
        }
        String title = musicItem.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        List<String> artistNames = musicItem.getArtistNames();
        if (artistNames != null) {
            builder.setPropertyString("artistNames", (String[]) artistNames.toArray(new String[0]));
        }
        Date publishDate = musicItem.getPublishDate();
        if (publishDate != null) {
            builder.setPropertyDocument("publishDate", GenericDocument.fromDocumentClass(publishDate));
        }
        Long lengthInSeconds = musicItem.getLengthInSeconds();
        if (lengthInSeconds != null) {
            builder.setPropertyLong("lengthInSeconds", lengthInSeconds.longValue());
        }
        String description = musicItem.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        Uri thumbnail = musicItem.getThumbnail();
        if (thumbnail != null) {
            builder.setPropertyDocument("thumbnail", GenericDocument.fromDocumentClass(thumbnail));
        }
        List<String> childMusicItemIds = musicItem.getChildMusicItemIds();
        if (childMusicItemIds != null) {
            builder.setPropertyString("childMusicItemIds", (String[]) childMusicItemIds.toArray(new String[0]));
        }
        return builder.build();
    }
}
