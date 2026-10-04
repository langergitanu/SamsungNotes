package androidx.appsearch.builtintypes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.builtintypes.AlarmInstance;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__AlarmInstance, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__AlarmInstance implements DocumentClassFactory<AlarmInstance> {
    public static final String SCHEMA_NAME = "builtin:AlarmInstance";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        return AbstractC0541b.m782x(PotentialAction.class);
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("snoozeDurationMillis", 2, 0, AbstractC0541b.m760b("status", 2, 0, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0))).addProperty(AbstractC0541b.m763e("scheduledTime", 2, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AlarmInstance fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
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
            arrayList = new ArrayList(propertyDocumentArray.length);
            str = str5;
            int i = 0;
            while (i < propertyDocumentArray.length) {
                arrayList.add((PotentialAction) propertyDocumentArray[i].toDocumentClass(PotentialAction.class, documentClassMappingContext));
                i++;
                propertyDocumentArray = propertyDocumentArray;
            }
        } else {
            str = str5;
            arrayList = null;
        }
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("scheduledTime");
        String str6 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[0];
        int propertyLong = (int) genericDocument.getPropertyLong("status");
        long propertyLong2 = genericDocument.getPropertyLong("snoozeDurationMillis");
        AlarmInstance.Builder builder = new AlarmInstance.Builder(namespace, id, str6);
        builder.setDocumentScore(score);
        builder.setCreationTimestampMillis(creationTimestampMillis);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setName(str2);
        builder.setAlternateNames(listAsList);
        builder.setDescription(str3);
        builder.setImage(str4);
        builder.setUrl(str);
        builder.setPotentialActions(arrayList);
        builder.setStatus(propertyLong);
        builder.setSnoozeDurationMillis(propertyLong2);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AlarmInstance alarmInstance) {
        GenericDocument.Builder builder = new GenericDocument.Builder(alarmInstance.getNamespace(), alarmInstance.getId(), SCHEMA_NAME);
        builder.setScore(alarmInstance.getDocumentScore());
        builder.setCreationTimestampMillis(alarmInstance.getCreationTimestampMillis());
        builder.setTtlMillis(alarmInstance.getDocumentTtlMillis());
        String name = alarmInstance.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = alarmInstance.getAlternateNames();
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = alarmInstance.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = alarmInstance.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = alarmInstance.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = alarmInstance.getPotentialActions();
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
        String scheduledTime = alarmInstance.getScheduledTime();
        if (scheduledTime != null) {
            builder.setPropertyString("scheduledTime", scheduledTime);
        }
        builder.setPropertyLong("status", alarmInstance.getStatus());
        builder.setPropertyLong("snoozeDurationMillis", alarmInstance.getSnoozeDurationMillis());
        return builder.build();
    }
}
