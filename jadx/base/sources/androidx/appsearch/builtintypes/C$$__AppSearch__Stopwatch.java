package androidx.appsearch.builtintypes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__Stopwatch, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__Stopwatch implements DocumentClassFactory<Stopwatch> {
    public static final String SCHEMA_NAME = "builtin:Stopwatch";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PotentialAction.class);
        arrayList.add(StopwatchLap.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("laps", C$$__AppSearch__StopwatchLap.SCHEMA_NAME, 1, false, AbstractC0541b.m760b("accumulatedDurationMillis", 2, 0, AbstractC0541b.m760b("status", 2, 0, AbstractC0541b.m760b("bootCount", 2, 0, AbstractC0541b.m760b("baseTimeMillisInElapsedRealtime", 2, 0, AbstractC0541b.m760b("baseTimeMillis", 2, 0, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0)))))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Stopwatch fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
        int i;
        ArrayList arrayList;
        int i2;
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
        long propertyLong = genericDocument.getPropertyLong("baseTimeMillis");
        long propertyLong2 = genericDocument.getPropertyLong("baseTimeMillisInElapsedRealtime");
        int propertyLong3 = (int) genericDocument.getPropertyLong("bootCount");
        int propertyLong4 = (int) genericDocument.getPropertyLong("status");
        long propertyLong5 = genericDocument.getPropertyLong("accumulatedDurationMillis");
        GenericDocument[] propertyDocumentArray2 = genericDocument.getPropertyDocumentArray("laps");
        if (propertyDocumentArray2 != null) {
            i2 = propertyLong4;
            ArrayList arrayList3 = new ArrayList(propertyDocumentArray2.length);
            j = creationTimestampMillis;
            for (GenericDocument genericDocument3 : propertyDocumentArray2) {
                arrayList3.add((StopwatchLap) genericDocument3.toDocumentClass(StopwatchLap.class, documentClassMappingContext));
            }
            arrayList2 = arrayList3;
        } else {
            i2 = propertyLong4;
            j = creationTimestampMillis;
            arrayList2 = null;
        }
        return new Stopwatch(namespace, str, i, j, ttlMillis, str2, listAsList, str3, str4, str5, arrayList, propertyLong, propertyLong2, propertyLong3, i2, propertyLong5, arrayList2);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Stopwatch stopwatch) {
        GenericDocument.Builder builder = new GenericDocument.Builder(stopwatch.getNamespace(), stopwatch.getId(), SCHEMA_NAME);
        builder.setScore(stopwatch.getDocumentScore());
        builder.setCreationTimestampMillis(stopwatch.getCreationTimestampMillis());
        builder.setTtlMillis(stopwatch.getDocumentTtlMillis());
        String name = stopwatch.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = stopwatch.getAlternateNames();
        int i = 0;
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = stopwatch.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = stopwatch.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = stopwatch.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = stopwatch.getPotentialActions();
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
        builder.setPropertyLong("baseTimeMillis", stopwatch.getBaseTimeMillis());
        builder.setPropertyLong("baseTimeMillisInElapsedRealtime", stopwatch.getBaseTimeMillisInElapsedRealtime());
        builder.setPropertyLong("bootCount", stopwatch.getBootCount());
        builder.setPropertyLong("status", stopwatch.getStatus());
        builder.setPropertyLong("accumulatedDurationMillis", stopwatch.getAccumulatedDurationMillis());
        List<StopwatchLap> laps = stopwatch.getLaps();
        if (laps != null) {
            GenericDocument[] genericDocumentArr2 = new GenericDocument[laps.size()];
            Iterator<StopwatchLap> it2 = laps.iterator();
            while (it2.hasNext()) {
                genericDocumentArr2[i] = GenericDocument.fromDocumentClass(it2.next());
                i++;
            }
            builder.setPropertyDocument("laps", genericDocumentArr2);
        }
        return builder.build();
    }
}
