package com.google.android.appfunctions.schema.common.p129v1.video;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.google.android.appfunctions.schema.common.p129v1.types.C$$__AppSearch__Uri;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.appfunctions.schema.common.v1.video.$$__AppSearch__VideoItem, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class C$$__AppSearch__VideoItem implements DocumentClassFactory<VideoItem> {
    public static final String SCHEMA_NAME = "com.google.android.appfunctions.schema.common.v1.video.VideoItem";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(Uri.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("thumbnailHeight", 3, 0, AbstractC0541b.m760b("thumbnailWidth", 3, 0, AbstractC0541b.m762d(ExternalDataConstants.Column.THUMBNAIL_URI, C$$__AppSearch__Uri.SCHEMA_NAME, 3, false, AbstractC0541b.m760b("durationInSecond", 3, 0, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("title", 3, 0, 0, 0)))))).addProperty(AbstractC0541b.m763e("categories", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("attributionText", 3, 0, 0, 0)).addProperty(AbstractC0541b.m763e("transcriptId", 3, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public VideoItem fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("title");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        long propertyLong = genericDocument.getPropertyLong("durationInSecond");
        GenericDocument propertyDocument = genericDocument.getPropertyDocument(ExternalDataConstants.Column.THUMBNAIL_URI);
        Uri uri = propertyDocument != null ? (Uri) propertyDocument.toDocumentClass(Uri.class, documentClassMappingContext) : null;
        int propertyLong2 = (int) genericDocument.getPropertyLong("thumbnailWidth");
        int propertyLong3 = (int) genericDocument.getPropertyLong("thumbnailHeight");
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("categories");
        List listAsList = Collections.EMPTY_LIST;
        if (propertyStringArray2 != null) {
            listAsList = Arrays.asList(propertyStringArray2);
        }
        List list = listAsList;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("attributionText");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("transcriptId");
        if (propertyStringArray4 != null && propertyStringArray4.length != 0) {
            str = propertyStringArray4[0];
        }
        return new VideoItem(namespace, id, str2, propertyLong, uri, propertyLong2, propertyLong3, list, str3, str);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(VideoItem videoItem) {
        GenericDocument.Builder builder = new GenericDocument.Builder(videoItem.getNamespace(), videoItem.getId(), SCHEMA_NAME);
        String title = videoItem.getTitle();
        if (title != null) {
            builder.setPropertyString("title", title);
        }
        builder.setPropertyLong("durationInSecond", videoItem.getDurationInSecond());
        Uri thumbnailUri = videoItem.getThumbnailUri();
        if (thumbnailUri != null) {
            builder.setPropertyDocument(ExternalDataConstants.Column.THUMBNAIL_URI, GenericDocument.fromDocumentClass(thumbnailUri));
        }
        builder.setPropertyLong("thumbnailWidth", videoItem.getThumbnailWidth());
        builder.setPropertyLong("thumbnailHeight", videoItem.getThumbnailHeight());
        List<String> categories = videoItem.getCategories();
        if (categories != null) {
            builder.setPropertyString("categories", (String[]) categories.toArray(new String[0]));
        }
        String attributionText = videoItem.getAttributionText();
        if (attributionText != null) {
            builder.setPropertyString("attributionText", attributionText);
        }
        String transcriptId = videoItem.getTranscriptId();
        if (transcriptId != null) {
            builder.setPropertyString("transcriptId", transcriptId);
        }
        return builder.build();
    }
}
