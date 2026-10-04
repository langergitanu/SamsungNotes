package androidx.appsearch.builtintypes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__Person, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__Person implements DocumentClassFactory<Person> {
    public static final String SCHEMA_NAME = "builtin:Person";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PotentialAction.class);
        arrayList.add(ContactPoint.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("contactPoints", C$$__AppSearch__ContactPoint.SCHEMA_NAME, 1, true, AbstractC0541b.m760b("additionalNameTypes", 1, 0, AbstractC0541b.m761c("isBot", 2, AbstractC0541b.m761c("isImportant", 2, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("givenName", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("middleName", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("familyName", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("externalUri", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e(Bixby2Constants.BIXBY_PARAM_IMAGE_URI, 2, 0, 0, 0)))).addProperty(AbstractC0541b.m763e(Privacy.KEY_NOTES, 1, 1, 2, 0))).addProperty(AbstractC0541b.m763e("additionalNames", 1, 1, 2, 0)).addProperty(AbstractC0541b.m763e("affiliations", 1, 1, 2, 0)).addProperty(AbstractC0541b.m763e("relations", 1, 0, 0, 0)));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Person fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
        int i;
        ArrayList arrayList;
        long j;
        ArrayList arrayList2;
        ArrayList arrayList3;
        List list;
        ArrayList arrayList4;
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
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("givenName");
        String str6 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[0];
        String[] propertyStringArray7 = genericDocument.getPropertyStringArray("middleName");
        String str7 = (propertyStringArray7 == null || propertyStringArray7.length == 0) ? null : propertyStringArray7[0];
        String[] propertyStringArray8 = genericDocument.getPropertyStringArray("familyName");
        String str8 = str6;
        String str9 = (propertyStringArray8 == null || propertyStringArray8.length == 0) ? null : propertyStringArray8[0];
        String[] propertyStringArray9 = genericDocument.getPropertyStringArray("externalUri");
        String str10 = str9;
        String str11 = (propertyStringArray9 == null || propertyStringArray9.length == 0) ? null : propertyStringArray9[0];
        String[] propertyStringArray10 = genericDocument.getPropertyStringArray(Bixby2Constants.BIXBY_PARAM_IMAGE_URI);
        String str12 = str11;
        String str13 = (propertyStringArray10 == null || propertyStringArray10.length == 0) ? null : propertyStringArray10[0];
        boolean propertyBoolean = genericDocument.getPropertyBoolean("isImportant");
        String str14 = str13;
        boolean propertyBoolean2 = genericDocument.getPropertyBoolean("isBot");
        String[] propertyStringArray11 = genericDocument.getPropertyStringArray(Privacy.KEY_NOTES);
        List listAsList2 = propertyStringArray11 != null ? Arrays.asList(propertyStringArray11) : null;
        long[] propertyLongArray = genericDocument.getPropertyLongArray("additionalNameTypes");
        if (propertyLongArray != null) {
            j = creationTimestampMillis;
            arrayList2 = new ArrayList(propertyLongArray.length);
            for (long j2 : propertyLongArray) {
                arrayList2.add(Long.valueOf(j2));
            }
        } else {
            j = creationTimestampMillis;
            arrayList2 = null;
        }
        String[] propertyStringArray12 = genericDocument.getPropertyStringArray("additionalNames");
        List listAsList3 = propertyStringArray12 != null ? Arrays.asList(propertyStringArray12) : null;
        String[] propertyStringArray13 = genericDocument.getPropertyStringArray("affiliations");
        List listAsList4 = propertyStringArray13 != null ? Arrays.asList(propertyStringArray13) : null;
        String[] propertyStringArray14 = genericDocument.getPropertyStringArray("relations");
        List listAsList5 = propertyStringArray14 != null ? Arrays.asList(propertyStringArray14) : null;
        List list2 = listAsList3;
        GenericDocument[] propertyDocumentArray2 = genericDocument.getPropertyDocumentArray("contactPoints");
        if (propertyDocumentArray2 != null) {
            arrayList3 = arrayList2;
            ArrayList arrayList5 = new ArrayList(propertyDocumentArray2.length);
            int i2 = 0;
            list = listAsList4;
            while (i2 < propertyDocumentArray2.length) {
                arrayList5.add((ContactPoint) propertyDocumentArray2[i2].toDocumentClass(ContactPoint.class, documentClassMappingContext));
                i2++;
                propertyDocumentArray2 = propertyDocumentArray2;
            }
            arrayList4 = arrayList5;
        } else {
            arrayList3 = arrayList2;
            list = listAsList4;
            arrayList4 = null;
        }
        return new Person(namespace, str, i, j, ttlMillis, str2, listAsList, str3, str4, str5, arrayList, str8, str7, str10, str12, str14, propertyBoolean, propertyBoolean2, listAsList2, arrayList3, list2, list, listAsList5, arrayList4);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Person person) {
        GenericDocument.Builder builder = new GenericDocument.Builder(person.getNamespace(), person.getId(), SCHEMA_NAME);
        builder.setScore(person.getDocumentScore());
        builder.setCreationTimestampMillis(person.getCreationTimestampMillis());
        builder.setTtlMillis(person.getDocumentTtlMillis());
        String name = person.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = person.getAlternateNames();
        int i = 0;
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = person.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = person.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = person.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = person.getPotentialActions();
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
        String givenName = person.getGivenName();
        if (givenName != null) {
            builder.setPropertyString("givenName", givenName);
        }
        String middleName = person.getMiddleName();
        if (middleName != null) {
            builder.setPropertyString("middleName", middleName);
        }
        String familyName = person.getFamilyName();
        if (familyName != null) {
            builder.setPropertyString("familyName", familyName);
        }
        String str = person.mExternalUri;
        if (str != null) {
            builder.setPropertyString("externalUri", str);
        }
        String str2 = person.mImageUri;
        if (str2 != null) {
            builder.setPropertyString(Bixby2Constants.BIXBY_PARAM_IMAGE_URI, str2);
        }
        builder.setPropertyBoolean("isImportant", person.mIsImportant);
        builder.setPropertyBoolean("isBot", person.mIsBot);
        List<String> notes = person.getNotes();
        if (notes != null) {
            builder.setPropertyString(Privacy.KEY_NOTES, (String[]) notes.toArray(new String[0]));
        }
        List<Long> list = person.mAdditionalNameTypes;
        if (list != null) {
            long[] jArr = new long[list.size()];
            Iterator<Long> it2 = list.iterator();
            int i4 = 0;
            while (it2.hasNext()) {
                jArr[i4] = it2.next().longValue();
                i4++;
            }
            builder.setPropertyLong("additionalNameTypes", jArr);
        }
        List<String> list2 = person.mAdditionalNames;
        if (list2 != null) {
            builder.setPropertyString("additionalNames", (String[]) list2.toArray(new String[0]));
        }
        List<String> affiliations = person.getAffiliations();
        if (affiliations != null) {
            builder.setPropertyString("affiliations", (String[]) affiliations.toArray(new String[0]));
        }
        List<String> relations = person.getRelations();
        if (relations != null) {
            builder.setPropertyString("relations", (String[]) relations.toArray(new String[0]));
        }
        List<ContactPoint> contactPoints = person.getContactPoints();
        if (contactPoints != null) {
            GenericDocument[] genericDocumentArr2 = new GenericDocument[contactPoints.size()];
            Iterator<ContactPoint> it3 = contactPoints.iterator();
            while (it3.hasNext()) {
                genericDocumentArr2[i] = GenericDocument.fromDocumentClass(it3.next());
                i++;
            }
            builder.setPropertyDocument("contactPoints", genericDocumentArr2);
        }
        return builder.build();
    }
}
