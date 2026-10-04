package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.smp.common.constants.FeedbackDetailConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ClassMapperLite {

    @NotNull
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    @NotNull
    private static final String f10456kotlin = CollectionsKt.m13955n(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, null, 62);

    @NotNull
    private static final Map<String, String> map;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", FeedbackDetailConstants.PREFIX_CLIENT_ERROR, "Byte", "B", "Short", "S", "Int", "I", "Float", TokenizerME.NO_SPLIT, "Long", "J", "Double", DiagMonUtil.AGREE_TYPE_DIAGNOSTIC});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listListOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f10456kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listListOf.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), listListOf.get(i2));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('/');
                linkedHashMap.put(AbstractC0622a.m1170p((String) listListOf.get(i), "Array", sb2), "[" + ((String) listListOf.get(i2)));
                if (i == progressionLastElement) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(f10456kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            map$lambda$0$add(linkedHashMap, str2, AbstractC0541b.m772n("java/lang/", str2));
        }
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            map$lambda$0$add(linkedHashMap, AbstractC0541b.m772n("collections/", str3), AbstractC0541b.m772n("java/util/", str3));
            map$lambda$0$add(linkedHashMap, AbstractC0541b.m772n("collections/Mutable", str3), AbstractC0541b.m772n("java/util/", str3));
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i4 = 0; i4 < 23; i4++) {
            String strM11h = AbstractC0000a.m11h(i4, "Function");
            StringBuilder sb3 = new StringBuilder();
            String str4 = f10456kotlin;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i4);
            map$lambda$0$add(linkedHashMap, strM11h, sb3.toString());
            map$lambda$0$add(linkedHashMap, AbstractC0000a.m11h(i4, "reflect/KFunction"), AbstractC0541b.m756B(str4, "/reflect/KFunction"));
        }
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            map$lambda$0$add(linkedHashMap, AbstractC0541b.m756B(str5, ".Companion"), AbstractC0541b.m776r(new StringBuilder(), f10456kotlin, "/jvm/internal/", str5, "CompanionObject"));
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f10456kotlin + '/' + str, "L" + str2 + SQLKeyword.DELIMITER);
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        if (str != null) {
            return str;
        }
        return "L" + StringsKt__StringsJVMKt.replace$default(classId, '.', '$', false, 4, (Object) null) + SQLKeyword.DELIMITER;
    }
}
