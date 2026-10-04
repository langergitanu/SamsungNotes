package androidx.appsearch.builtintypes;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.builtintypes.WebPage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appsearch.builtintypes.$$__AppSearch__WebPage, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__WebPage implements DocumentClassFactory<WebPage> {
    public static final String SCHEMA_NAME = "builtin:WebPage";

    @Override // androidx.appsearch.app.DocumentClassFactory
    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PotentialAction.class);
        arrayList.add(ImageObject.class);
        return arrayList;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppSearchSchema getSchema() {
        return AbstractC0541b.m765g("favicon", C$$__AppSearch__ImageObject.SCHEMA_NAME, 2, false, AbstractC0541b.m762d("potentialActions", C$$__AppSearch__PotentialAction.SCHEMA_NAME, 1, false, new AppSearchSchema.Builder("builtin:WebPage").addProperty(AbstractC0541b.m763e("name", 2, 1, 2, 0)).addProperty(AbstractC0541b.m763e("alternateNames", 1, 0, 0, 0)).addProperty(AbstractC0541b.m763e("description", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("image", 2, 0, 0, 0)).addProperty(AbstractC0541b.m763e("url", 2, 0, 0, 0))));
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return "builtin:WebPage";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public WebPage fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String str;
        String str2;
        ArrayList arrayList;
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
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("favicon");
        ImageObject imageObject = propertyDocument != null ? (ImageObject) propertyDocument.toDocumentClass(ImageObject.class, documentClassMappingContext) : null;
        WebPage.Builder builder = new WebPage.Builder(namespace, id);
        builder.setDocumentScore(score);
        builder.setCreationTimestampMillis(creationTimestampMillis);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setName(str3);
        builder.setAlternateNames(listAsList);
        builder.setDescription(str4);
        builder.setImage(str2);
        builder.setUrl(str);
        builder.setPotentialActions(arrayList);
        builder.setFavicon(imageObject);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(WebPage webPage) {
        GenericDocument.Builder builder = new GenericDocument.Builder(webPage.getNamespace(), webPage.getId(), "builtin:WebPage");
        builder.setScore(webPage.getDocumentScore());
        builder.setCreationTimestampMillis(webPage.getCreationTimestampMillis());
        builder.setTtlMillis(webPage.getDocumentTtlMillis());
        String name = webPage.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        List<String> alternateNames = webPage.getAlternateNames();
        int i = 0;
        if (alternateNames != null) {
            builder.setPropertyString("alternateNames", (String[]) alternateNames.toArray(new String[0]));
        }
        String description = webPage.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        String image = webPage.getImage();
        if (image != null) {
            builder.setPropertyString("image", image);
        }
        String url = webPage.getUrl();
        if (url != null) {
            builder.setPropertyString("url", url);
        }
        List<PotentialAction> potentialActions = webPage.getPotentialActions();
        if (potentialActions != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[potentialActions.size()];
            Iterator<PotentialAction> it = potentialActions.iterator();
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument("potentialActions", genericDocumentArr);
        }
        ImageObject favicon = webPage.getFavicon();
        if (favicon != null) {
            builder.setPropertyDocument("favicon", GenericDocument.fromDocumentClass(favicon));
        }
        return builder.build();
    }
}
