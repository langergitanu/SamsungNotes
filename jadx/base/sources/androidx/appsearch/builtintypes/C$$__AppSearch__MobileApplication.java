package androidx.appsearch.builtintypes;

import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.builtintypes.MobileApplication;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__MobileApplication, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__MobileApplication implements DocumentClassFactory<MobileApplication> {
    public static final String SCHEMA_NAME = "builtin:MobileApplication";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(PotentialAction.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m760b("updatedTimestamp", 2, 1, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 1, 2, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("packageName", 2, 2, 2, 0)).addProperty(AbstractC0541b.m763e("displayName", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("iconUri", 2, 0, 0, 0)).addProperty(new AppSearchSchema.BytesPropertyConfig.Builder("sha256Certificate").setCardinality(2).build())).addProperty(AbstractC0541b.m763e(SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, 2, 0, 0, 0)).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public MobileApplication fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
        char c;
        ArrayList arrayList;
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
            c = 0;
            arrayList = new ArrayList(propertyDocumentArray.length);
            str = namespace;
            int i = 0;
            while (i < propertyDocumentArray.length) {
                arrayList.add((PotentialAction) propertyDocumentArray[i].toDocumentClass(PotentialAction.class, documentClassMappingContext));
                i++;
                id = id;
                score = score;
            }
        } else {
            str = namespace;
            c = 0;
            arrayList = null;
        }
        String str6 = id;
        int i2 = score;
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("packageName");
        String str7 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[c];
        String[] propertyStringArray7 = genericDocument.getPropertyStringArray("displayName");
        String str8 = (propertyStringArray7 == null || propertyStringArray7.length == 0) ? null : propertyStringArray7[c];
        String propertyString = genericDocument.getPropertyString("iconUri");
        Uri uriDeserialize = propertyString != null ? new MobileApplication.IconUriAsUri().deserialize(propertyString) : null;
        byte[][] propertyBytesArray = genericDocument.getPropertyBytesArray("sha256Certificate");
        byte[] bArr = (propertyBytesArray == null || propertyBytesArray.length == 0) ? null : propertyBytesArray[c];
        long propertyLong = genericDocument.getPropertyLong("updatedTimestamp");
        String[] propertyStringArray8 = genericDocument.getPropertyStringArray(SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME);
        return new MobileApplication(str, str6, i2, creationTimestampMillis, ttlMillis, str2, listAsList, str3, str4, str5, arrayList, str7, str8, uriDeserialize, bArr, propertyLong, (propertyStringArray8 == null || propertyStringArray8.length == 0) ? null : propertyStringArray8[c]);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(MobileApplication mobileApplication) {
        GenericDocument.Builder builder = new GenericDocument.Builder(mobileApplication.getNamespace(), mobileApplication.getId(), SCHEMA_NAME);
        builder.setScore(mobileApplication.getDocumentScore());
        builder.setCreationTimestampMillis(mobileApplication.getCreationTimestampMillis());
        builder.setTtlMillis(mobileApplication.getDocumentTtlMillis());
        String name = mobileApplication.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = mobileApplication.getAlternateNames();
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = mobileApplication.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = mobileApplication.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = mobileApplication.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = mobileApplication.getPotentialActions();
        if (potentialActions != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[potentialActions.size()];
            Iterator<PotentialAction> it = potentialActions.iterator();
            int i = 0;
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("potentialActions", genericDocumentArr);
        }
        String packageName = mobileApplication.getPackageName();
        if (packageName != null) {
            builder.setPropertyString("packageName", packageName);
        }
        String displayName = mobileApplication.getDisplayName();
        if (displayName != null) {
            builder.setPropertyString("displayName", displayName);
        }
        Uri iconUri = mobileApplication.getIconUri();
        if (iconUri != null) {
            builder.setPropertyString("iconUri", new MobileApplication.IconUriAsUri().serialize(iconUri));
        }
        byte[] sha256Certificate = mobileApplication.getSha256Certificate();
        if (sha256Certificate != null) {
            builder.setPropertyBytes("sha256Certificate", sha256Certificate);
        }
        builder.setPropertyLong("updatedTimestamp", mobileApplication.getUpdatedTimestamp());
        String className = mobileApplication.getClassName();
        if (className != null) {
            builder.setPropertyString(SearchIndexablesContract.BaseColumns.COLUMN_CLASS_NAME, className);
        }
        return builder.build();
    }
}
