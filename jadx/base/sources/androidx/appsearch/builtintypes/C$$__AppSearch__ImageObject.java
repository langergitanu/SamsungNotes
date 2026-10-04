package androidx.appsearch.builtintypes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.builtintypes.properties.C$$__AppSearch__Keyword;
import androidx.appsearch.builtintypes.properties.Keyword;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__ImageObject, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__ImageObject implements DocumentClassFactory<ImageObject> {
    public static final String SCHEMA_NAME = "builtin:ImageObject";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PotentialAction.class);
        arrayList.add(Keyword.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m762d(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, C$$__AppSearch__Keyword.SCHEMA_NAME, 1, true, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e("sha256", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("thumbnailSha256", 2, 0, 0, 0)).addProperty(new AppSearchSchema.BytesPropertyConfig.Builder("bytes").setCardinality(2).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public ImageObject fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
        int i;
        ArrayList arrayList;
        long j;
        ArrayList arrayList2;
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        int score = genericDocument.getScore();
        long creationTimestampMillis = genericDocument.getCreationTimestampMillis();
        long ttlMillis = genericDocument.getTtlMillis();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("alternateNames");
        List listAsList = propertyStringArray2 != null ? Arrays.asList(propertyStringArray2) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("image");
        String str4 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("url");
        String str5 = (propertyStringArray5 == null || propertyStringArray5.length == 0) ? null : propertyStringArray5[0];
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("potentialActions");
        if (propertyDocumentArray != null) {
            str = id;
            arrayList = new ArrayList(propertyDocumentArray.length);
            i = score;
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((PotentialAction) genericDocument2.toDocumentClass(PotentialAction.class, documentClassMappingContext));
            }
        } else {
            str = id;
            i = score;
            arrayList = null;
        }
        GenericDocument[] propertyDocumentArray2 = genericDocument.getPropertyDocumentArray(SearchIndexablesContract.RawData.COLUMN_KEYWORDS);
        if (propertyDocumentArray2 != null) {
            arrayList2 = new ArrayList(propertyDocumentArray2.length);
            j = creationTimestampMillis;
            for (GenericDocument genericDocument3 : propertyDocumentArray2) {
                arrayList2.add((Keyword) genericDocument3.toDocumentClass(Keyword.class, documentClassMappingContext));
            }
        } else {
            j = creationTimestampMillis;
            arrayList2 = null;
        }
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("sha256");
        String str6 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[0];
        String[] propertyStringArray7 = genericDocument.getPropertyStringArray("thumbnailSha256");
        String str7 = (propertyStringArray7 == null || propertyStringArray7.length == 0) ? null : propertyStringArray7[0];
        byte[][] propertyBytesArray = genericDocument.getPropertyBytesArray("bytes");
        return new ImageObject(namespace, str, i, j, ttlMillis, str2, listAsList, str3, str4, str5, arrayList, arrayList2, str6, str7, (propertyBytesArray == null || propertyBytesArray.length == 0) ? null : propertyBytesArray[0]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(ImageObject imageObject) {
        GenericDocument.Builder builder = new GenericDocument.Builder(imageObject.getNamespace(), imageObject.getId(), SCHEMA_NAME);
        builder.setScore(imageObject.getDocumentScore());
        builder.setCreationTimestampMillis(imageObject.getCreationTimestampMillis());
        builder.setTtlMillis(imageObject.getDocumentTtlMillis());
        String name = imageObject.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = imageObject.getAlternateNames();
        int i = 0;
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = imageObject.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = imageObject.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = imageObject.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = imageObject.getPotentialActions();
        if (potentialActions != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[potentialActions.size()];
            Iterator<PotentialAction> it = potentialActions.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                genericDocumentArr[i2] = GenericDocument.fromDocumentClass(it.next());
                i2++;
            }
            builder.setPropertyDocument("potentialActions", genericDocumentArr);
        }
        List<Keyword> keywords = imageObject.getKeywords();
        if (keywords != null) {
            GenericDocument[] genericDocumentArr2 = new GenericDocument[keywords.size()];
            Iterator<Keyword> it2 = keywords.iterator();
            while (it2.hasNext()) {
                genericDocumentArr2[i] = GenericDocument.fromDocumentClass(it2.next());
                i++;
            }
            builder.setPropertyDocument(SearchIndexablesContract.RawData.COLUMN_KEYWORDS, genericDocumentArr2);
        }
        String sha256 = imageObject.getSha256();
        if (sha256 != null) {
            builder.setPropertyString("sha256", sha256);
        }
        String thumbnailSha256 = imageObject.getThumbnailSha256();
        if (thumbnailSha256 != null) {
            builder.setPropertyString("thumbnailSha256", thumbnailSha256);
        }
        byte[] bytes = imageObject.getBytes();
        if (bytes != null) {
            builder.setPropertyBytes("bytes", bytes);
        }
        return builder.build();
    }
}
