package androidx.appsearch.builtintypes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.builtintypes.Alarm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__Alarm, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__Alarm implements DocumentClassFactory<Alarm> {
    public static final String SCHEMA_NAME = "builtin:Alarm";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PotentialAction.class);
        arrayList.add(AlarmInstance.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m764f("computingDevice", 2, 0, AbstractC0541b.m762d("nextInstance", C$$__AppSearch__AlarmInstance.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("previousInstance", C$$__AppSearch__AlarmInstance.SCHEMA_NAME, 2, false, AbstractC0541b.m761c("shouldVibrate", 2, AbstractC0541b.m760b("minute", 2, 0, AbstractC0541b.m760b("hour", 2, 0, AbstractC0541b.m760b("daysOfWeek", 1, 0, AbstractC0541b.m761c("enabled", 2, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0))))))).addProperty(AbstractC0541b.m763e("blackoutPeriodStartDate", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("blackoutPeriodEndDate", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("ringtone", 2, 0, 0, 0))))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public Alarm fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
        String str2;
        ArrayList arrayList;
        boolean z;
        int[] iArr;
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        int score = genericDocument.getScore();
        long creationTimestampMillis = genericDocument.getCreationTimestampMillis();
        long ttlMillis = genericDocument.getTtlMillis();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str3 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("alternateNames");
        List listAsList = propertyStringArray2 != null ? Arrays.asList(propertyStringArray2) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("description");
        String str4 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        String[] propertyStringArray4 = genericDocument.getPropertyStringArray("image");
        String str5 = (propertyStringArray4 == null || propertyStringArray4.length == 0) ? null : propertyStringArray4[0];
        String[] propertyStringArray5 = genericDocument.getPropertyStringArray("url");
        String str6 = (propertyStringArray5 == null || propertyStringArray5.length == 0) ? null : propertyStringArray5[0];
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray("potentialActions");
        if (propertyDocumentArray != null) {
            str = str6;
            arrayList = new ArrayList(propertyDocumentArray.length);
            str2 = str5;
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList.add((PotentialAction) genericDocument2.toDocumentClass(PotentialAction.class, documentClassMappingContext));
            }
        } else {
            str = str6;
            str2 = str5;
            arrayList = null;
        }
        boolean propertyBoolean = genericDocument.getPropertyBoolean("enabled");
        long[] propertyLongArray = genericDocument.getPropertyLongArray("daysOfWeek");
        if (propertyLongArray != null) {
            int[] iArr2 = new int[propertyLongArray.length];
            z = propertyBoolean;
            int i = 0;
            while (i < propertyLongArray.length) {
                iArr2[i] = (int) propertyLongArray[i];
                i++;
                arrayList = arrayList;
            }
            iArr = iArr2;
        } else {
            z = propertyBoolean;
            iArr = null;
        }
        ArrayList arrayList2 = arrayList;
        int propertyLong = (int) genericDocument.getPropertyLong("hour");
        int propertyLong2 = (int) genericDocument.getPropertyLong("minute");
        String[] propertyStringArray6 = genericDocument.getPropertyStringArray("blackoutPeriodStartDate");
        String str7 = (propertyStringArray6 == null || propertyStringArray6.length == 0) ? null : propertyStringArray6[0];
        String[] propertyStringArray7 = genericDocument.getPropertyStringArray("blackoutPeriodEndDate");
        String str8 = str7;
        String str9 = (propertyStringArray7 == null || propertyStringArray7.length == 0) ? null : propertyStringArray7[0];
        String[] propertyStringArray8 = genericDocument.getPropertyStringArray("ringtone");
        String str10 = str9;
        String str11 = (propertyStringArray8 == null || propertyStringArray8.length == 0) ? null : propertyStringArray8[0];
        boolean propertyBoolean2 = genericDocument.getPropertyBoolean("shouldVibrate");
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("previousInstance");
        String str12 = str11;
        AlarmInstance alarmInstance = propertyDocument != null ? (AlarmInstance) propertyDocument.toDocumentClass(AlarmInstance.class, documentClassMappingContext) : null;
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("nextInstance");
        AlarmInstance alarmInstance2 = propertyDocument2 != null ? (AlarmInstance) propertyDocument2.toDocumentClass(AlarmInstance.class, documentClassMappingContext) : null;
        int propertyLong3 = (int) genericDocument.getPropertyLong("computingDevice");
        Alarm.Builder builder = new Alarm.Builder(namespace, id);
        builder.setDocumentScore(score);
        builder.setCreationTimestampMillis(creationTimestampMillis);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setName(str3);
        builder.setAlternateNames(listAsList);
        builder.setDescription(str4);
        builder.setImage(str2);
        builder.setUrl(str);
        builder.setPotentialActions(arrayList2);
        builder.setEnabled(z);
        builder.setDaysOfWeek(iArr);
        builder.setHour(propertyLong);
        builder.setMinute(propertyLong2);
        builder.setBlackoutPeriodStartDate(str8);
        builder.setBlackoutPeriodEndDate(str10);
        builder.setRingtone(str12);
        builder.setShouldVibrate(propertyBoolean2);
        builder.setPreviousInstance(alarmInstance);
        builder.setNextInstance(alarmInstance2);
        builder.setOriginatingDevice(propertyLong3);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(Alarm alarm) {
        GenericDocument.Builder builder = new GenericDocument.Builder(alarm.getNamespace(), alarm.getId(), SCHEMA_NAME);
        builder.setScore(alarm.getDocumentScore());
        builder.setCreationTimestampMillis(alarm.getCreationTimestampMillis());
        builder.setTtlMillis(alarm.getDocumentTtlMillis());
        String name = alarm.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = alarm.getAlternateNames();
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = alarm.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = alarm.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = alarm.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = alarm.getPotentialActions();
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
        builder.setPropertyBoolean("enabled", alarm.isEnabled());
        int[] daysOfWeek = alarm.getDaysOfWeek();
        if (daysOfWeek != null) {
            long[] jArr = new long[daysOfWeek.length];
            for (int i2 = 0; i2 < daysOfWeek.length; i2++) {
                jArr[i2] = daysOfWeek[i2];
            }
            builder.setPropertyLong("daysOfWeek", jArr);
        }
        builder.setPropertyLong("hour", alarm.getHour());
        builder.setPropertyLong("minute", alarm.getMinute());
        String blackoutPeriodStartDate = alarm.getBlackoutPeriodStartDate();
        if (blackoutPeriodStartDate != null) {
            builder.setPropertyString("blackoutPeriodStartDate", blackoutPeriodStartDate);
        }
        String blackoutPeriodEndDate = alarm.getBlackoutPeriodEndDate();
        if (blackoutPeriodEndDate != null) {
            builder.setPropertyString("blackoutPeriodEndDate", blackoutPeriodEndDate);
        }
        String ringtone = alarm.getRingtone();
        if (ringtone != null) {
            builder.setPropertyString("ringtone", ringtone);
        }
        builder.setPropertyBoolean("shouldVibrate", alarm.shouldVibrate());
        AlarmInstance previousInstance = alarm.getPreviousInstance();
        if (previousInstance != null) {
            builder.setPropertyDocument("previousInstance", GenericDocument.fromDocumentClass(previousInstance));
        }
        AlarmInstance nextInstance = alarm.getNextInstance();
        if (nextInstance != null) {
            builder.setPropertyDocument("nextInstance", GenericDocument.fromDocumentClass(nextInstance));
        }
        builder.setPropertyLong("computingDevice", alarm.getOriginatingDevice());
        return builder.build();
    }
}
