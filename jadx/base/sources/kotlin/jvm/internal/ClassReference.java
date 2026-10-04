package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010I\u001a\u00020JH\u0002J\u0013\u0010K\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010(\u001a\u0004\b-\u0010\u001eR(\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010(\u001a\u0004\b0\u0010\u001eR\u001c\u00101\u001a\u0004\u0018\u0001028VX\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b7\u0010(\u001a\u0004\b6\u00108R\u001a\u00109\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b9\u00108R\u001a\u0010;\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b<\u0010(\u001a\u0004\b;\u00108R\u001a\u0010=\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b>\u0010(\u001a\u0004\b=\u00108R\u001a\u0010?\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010(\u001a\u0004\b?\u00108R\u001a\u0010A\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bB\u0010(\u001a\u0004\bA\u00108R\u001a\u0010C\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bD\u0010(\u001a\u0004\bC\u00108R\u001a\u0010E\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bF\u0010(\u001a\u0004\bE\u00108R\u001a\u0010G\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bH\u0010(\u001a\u0004\bG\u00108¨\u0006Q"}, m13886d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "error", "", "equals", "other", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,205:1\n1573#2:206\n1604#2,4:207\n1267#2,4:211\n1252#2,4:217\n465#3:215\n415#3:216\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:206\n107#1:207,4\n155#1:211,4\n163#1:217,4\n163#1:215\n163#1:216\n*E\n"})
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;

    @NotNull
    private static final HashMap<String, String> classFqNames;

    @NotNull
    private static final HashMap<String, String> primitiveFqNames;

    @NotNull
    private static final HashMap<String, String> primitiveWrapperFqNames;

    @NotNull
    private static final Map<String, String> simpleNames;

    @NotNull
    private final Class<?> jClass;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006R&\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000b0\u000b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "primitiveFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveWrapperFqNames", "classFqNames", "simpleNames", "kotlin.jvm.PlatformType", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", "", "value", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String getClassQualifiedName(@NotNull Class<?> jClass) {
            String str;
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String strConcat = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str2 = (String) ClassReference.classFqNames.get(jClass.getName());
                return str2 == null ? jClass.getCanonicalName() : str2;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) ClassReference.classFqNames.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "kotlin.Array" : strConcat;
        }

        @Nullable
        public final String getClassSimpleName(@NotNull Class<?> jClass) {
            String str;
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String strConcat = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (!jClass.isLocalClass()) {
                if (!jClass.isArray()) {
                    String str2 = (String) ClassReference.simpleNames.get(jClass.getName());
                    return str2 == null ? jClass.getSimpleName() : str2;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) ClassReference.simpleNames.get(componentType.getName())) != null) {
                    strConcat = str.concat("Array");
                }
                return strConcat == null ? "Array" : strConcat;
            }
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNull(simpleName);
                String strM14147U = StringsKt.m14147U(simpleName, enclosingMethod.getName() + '$');
                if (strM14147U != null) {
                    return strM14147U;
                }
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                Intrinsics.checkNotNull(simpleName);
                return StringsKt__StringsKt.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNull(simpleName);
            return StringsKt.m14147U(simpleName, enclosingConstructor.getName() + '$');
        }

        public final boolean isInstance(@Nullable Object value, @NotNull Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Map map = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return TypeIntrinsics.isFunctionOfArity(value, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass));
            }
            return jClass.isInstance(value);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List listListOf = CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listListOf));
        int i = 0;
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.m13893to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        FUNCTION_CLASSES = MapsKt.toMap(arrayList);
        HashMap<String, String> mapM13996q = AbstractC12991c.m13996q("boolean", "kotlin.Boolean", "char", "kotlin.Char");
        mapM13996q.put("byte", "kotlin.Byte");
        mapM13996q.put("short", "kotlin.Short");
        mapM13996q.put(XmlErrorCodes.INT, "kotlin.Int");
        mapM13996q.put("float", "kotlin.Float");
        mapM13996q.put(XmlErrorCodes.LONG, "kotlin.Long");
        mapM13996q.put(XmlErrorCodes.DOUBLE, "kotlin.Double");
        primitiveFqNames = mapM13996q;
        HashMap<String, String> mapM13996q2 = AbstractC12991c.m13996q("java.lang.Boolean", "kotlin.Boolean", "java.lang.Character", "kotlin.Char");
        mapM13996q2.put("java.lang.Byte", "kotlin.Byte");
        mapM13996q2.put("java.lang.Short", "kotlin.Short");
        mapM13996q2.put("java.lang.Integer", "kotlin.Int");
        mapM13996q2.put("java.lang.Float", "kotlin.Float");
        mapM13996q2.put("java.lang.Long", "kotlin.Long");
        mapM13996q2.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = mapM13996q2;
        HashMap<String, String> mapM13996q3 = AbstractC12991c.m13996q("java.lang.Object", "kotlin.Any", "java.lang.String", "kotlin.String");
        mapM13996q3.put("java.lang.CharSequence", "kotlin.CharSequence");
        mapM13996q3.put("java.lang.Throwable", "kotlin.Throwable");
        mapM13996q3.put("java.lang.Cloneable", "kotlin.Cloneable");
        mapM13996q3.put("java.lang.Number", "kotlin.Number");
        mapM13996q3.put("java.lang.Comparable", "kotlin.Comparable");
        mapM13996q3.put("java.lang.Enum", "kotlin.Enum");
        mapM13996q3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        mapM13996q3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        mapM13996q3.put("java.util.Iterator", "kotlin.collections.Iterator");
        mapM13996q3.put("java.util.Collection", "kotlin.collections.Collection");
        mapM13996q3.put("java.util.List", "kotlin.collections.List");
        mapM13996q3.put("java.util.Set", "kotlin.collections.Set");
        mapM13996q3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        mapM13996q3.put("java.util.Map", "kotlin.collections.Map");
        mapM13996q3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        mapM13996q3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        mapM13996q3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        mapM13996q3.putAll(mapM13996q);
        mapM13996q3.putAll(mapM13996q2);
        Collection<String> collectionValues = mapM13996q.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            Intrinsics.checkNotNull(str);
            sb.append(StringsKt__StringsKt.substringAfterLast$default(str, '.', (String) null, 2, (Object) null));
            sb.append("CompanionObject");
            Pair pairM13893to = TuplesKt.m13893to(sb.toString(), str + ".Companion");
            mapM13996q3.put(pairM13893to.getFirst(), pairM13893to.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            mapM13996q3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        classFqNames = mapM13996q3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapM13996q3.size()));
        for (Map.Entry entry2 : mapM13996q3.entrySet()) {
            Object key = entry2.getKey();
            String str2 = (String) entry2.getValue();
            Intrinsics.checkNotNull(str2);
            linkedHashMap.put(key, StringsKt__StringsKt.substringAfterLast$default(str2, '.', (String) null, 2, (Object) null));
        }
        simpleNames = linkedHashMap;
    }

    public ClassReference(@NotNull Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return INSTANCE.getClassQualifiedName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return INSTANCE.getClassSimpleName(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    public boolean isInstance(@Nullable Object value) {
        return INSTANCE.isInstance(value, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String toString() {
        return getJClass() + " (Kotlin reflection is not available)";
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getSupertypes$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getVisibility$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isAbstract$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isCompanion$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isData$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isFinal$annotations() {
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_14)
    public static /* synthetic */ void isFun$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isInner$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isOpen$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isSealed$annotations() {
    }

    @SinceKotlin(version = XmlOptions.GENERATE_JAVA_15)
    public static /* synthetic */ void isValue$annotations() {
    }
}
