package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nJvmNameResolverBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1216#2,2:107\n1246#2,4:109\n*S KotlinDebug\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n*L\n101#1:107,2\n101#1:109,4\n*E\n"})
public class JvmNameResolverBase implements NameResolver {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final List<String> PREDEFINED_STRINGS;

    @NotNull
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    @NotNull
    private static final String f10457kotlin;

    @NotNull
    private final Set<Integer> localNameIndices;

    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> records;

    @NotNull
    private final String[] strings;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String strM13955n = CollectionsKt.m13955n(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, null, 62);
        f10457kotlin = strM13955n;
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{AbstractC0541b.m756B(strM13955n, "/Any"), AbstractC0541b.m756B(strM13955n, "/Nothing"), AbstractC0541b.m756B(strM13955n, "/Unit"), AbstractC0541b.m756B(strM13955n, "/Throwable"), AbstractC0541b.m756B(strM13955n, "/Number"), AbstractC0541b.m756B(strM13955n, "/Byte"), AbstractC0541b.m756B(strM13955n, "/Double"), AbstractC0541b.m756B(strM13955n, "/Float"), AbstractC0541b.m756B(strM13955n, "/Int"), AbstractC0541b.m756B(strM13955n, "/Long"), AbstractC0541b.m756B(strM13955n, "/Short"), AbstractC0541b.m756B(strM13955n, "/Boolean"), AbstractC0541b.m756B(strM13955n, "/Char"), AbstractC0541b.m756B(strM13955n, "/CharSequence"), AbstractC0541b.m756B(strM13955n, "/String"), AbstractC0541b.m756B(strM13955n, "/Comparable"), AbstractC0541b.m756B(strM13955n, "/Enum"), AbstractC0541b.m756B(strM13955n, "/Array"), AbstractC0541b.m756B(strM13955n, "/ByteArray"), AbstractC0541b.m756B(strM13955n, "/DoubleArray"), AbstractC0541b.m756B(strM13955n, "/FloatArray"), AbstractC0541b.m756B(strM13955n, "/IntArray"), AbstractC0541b.m756B(strM13955n, "/LongArray"), AbstractC0541b.m756B(strM13955n, "/ShortArray"), AbstractC0541b.m756B(strM13955n, "/BooleanArray"), AbstractC0541b.m756B(strM13955n, "/CharArray"), AbstractC0541b.m756B(strM13955n, "/Cloneable"), AbstractC0541b.m756B(strM13955n, "/Annotation"), AbstractC0541b.m756B(strM13955n, "/collections/Iterable"), AbstractC0541b.m756B(strM13955n, "/collections/MutableIterable"), AbstractC0541b.m756B(strM13955n, "/collections/Collection"), AbstractC0541b.m756B(strM13955n, "/collections/MutableCollection"), AbstractC0541b.m756B(strM13955n, "/collections/List"), AbstractC0541b.m756B(strM13955n, "/collections/MutableList"), AbstractC0541b.m756B(strM13955n, "/collections/Set"), AbstractC0541b.m756B(strM13955n, "/collections/MutableSet"), AbstractC0541b.m756B(strM13955n, "/collections/Map"), AbstractC0541b.m756B(strM13955n, "/collections/MutableMap"), AbstractC0541b.m756B(strM13955n, "/collections/Map.Entry"), AbstractC0541b.m756B(strM13955n, "/collections/MutableMap.MutableEntry"), AbstractC0541b.m756B(strM13955n, "/collections/Iterator"), AbstractC0541b.m756B(strM13955n, "/collections/MutableIterator"), AbstractC0541b.m756B(strM13955n, "/collections/ListIterator"), AbstractC0541b.m756B(strM13955n, "/collections/MutableListIterator")});
        PREDEFINED_STRINGS = listListOf;
        Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(listListOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(iterableWithIndex)), 16));
        for (IndexedValue indexedValue : iterableWithIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }

    public JvmNameResolverBase(@NotNull String[] strings, @NotNull Set<Integer> localNameIndices, @NotNull List<JvmProtoBuf.StringTableTypes.Record> records) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getString(int i) {
        String strReplace$default;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            strReplace$default = record.getString();
        } else if (record.hasPredefinedIndex()) {
            List<String> list = PREDEFINED_STRINGS;
            int size = list.size();
            int predefinedIndex = record.getPredefinedIndex();
            strReplace$default = (predefinedIndex < 0 || predefinedIndex >= size) ? this.strings[i] : list.get(record.getPredefinedIndex());
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNull(substringIndexList);
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= strReplace$default.length()) {
                Intrinsics.checkNotNull(strReplace$default);
                Intrinsics.checkNotNull(num);
                int iIntValue = num.intValue();
                Intrinsics.checkNotNull(num2);
                strReplace$default = strReplace$default.substring(iIntValue, num2.intValue());
                Intrinsics.checkNotNullExpressionValue(strReplace$default, "substring(...)");
            }
        }
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNull(replaceCharList);
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            Intrinsics.checkNotNull(strReplace$default);
            strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                Intrinsics.checkNotNull(strReplace$default);
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, '$', '.', false, 4, (Object) null);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (strReplace$default.length() >= 2) {
                    Intrinsics.checkNotNull(strReplace$default);
                    strReplace$default = strReplace$default.substring(1, strReplace$default.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strReplace$default, "substring(...)");
                }
                Intrinsics.checkNotNull(strReplace$default);
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, '$', '.', false, 4, (Object) null);
            }
        }
        Intrinsics.checkNotNull(strReplace$default);
        return strReplace$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }
}
