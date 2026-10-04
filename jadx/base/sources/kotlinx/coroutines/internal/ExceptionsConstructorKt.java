package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.C7881i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00042\u0006\u0010\t\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000eH\u0002¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\u0013\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0001H\u0082\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0002\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¨\u0006\u0017"}, m13886d2 = {"throwableFields", "", "Ctor", "Lkotlin/Function1;", "", "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "tryCopyException", ExifInterface.LONGITUDE_EAST, "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "createConstructor", "Lkotlinx/coroutines/internal/Ctor;", "clz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "safeCtor", "block", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "fieldsCountOrDefault", "defaultValue", "fieldsCount", "accumulator", "kotlinx-coroutines-core"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1#2:113\n11102#3:114\n11437#3,3:115\n12671#3,3:132\n1971#4,14:118\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n41#1:114\n41#1:115,3\n78#1:132,3\n59#1:118,14\n*E\n"})
public final class ExceptionsConstructorKt {

    @NotNull
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        CtorCache ctorCache2;
        try {
            ctorCache2 = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable unused) {
            ctorCache2 = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = ctorCache2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        Object next;
        Function1<Throwable, Throwable> function1;
        Pair pairM13893to;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (throwableFields == fieldsCountOrDefault(cls, 0)) {
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.length);
            int length = constructors.length;
            int i = 0;
            while (true) {
                next = null;
                if (i >= length) {
                    break;
                }
                final Constructor<?> constructor = constructors[i];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                int length2 = parameterTypes.length;
                if (length2 == 0) {
                    final int i2 = 3;
                    pairM13893to = TuplesKt.m13893to(safeCtor(new Function1() { // from class: kotlinx.coroutines.internal.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            switch (i2) {
                                case 0:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$1(constructor, (Throwable) obj);
                                case 1:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$3(constructor, (Throwable) obj);
                                case 2:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$4(constructor, (Throwable) obj);
                                default:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$6(constructor, (Throwable) obj);
                            }
                        }
                    }), 0);
                } else if (length2 == 1) {
                    Class<?> cls2 = parameterTypes[0];
                    if (Intrinsics.areEqual(cls2, String.class)) {
                        final int i4 = 1;
                        pairM13893to = TuplesKt.m13893to(safeCtor(new Function1() { // from class: kotlinx.coroutines.internal.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                switch (i4) {
                                    case 0:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$1(constructor, (Throwable) obj);
                                    case 1:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$3(constructor, (Throwable) obj);
                                    case 2:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$4(constructor, (Throwable) obj);
                                    default:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$6(constructor, (Throwable) obj);
                                }
                            }
                        }), 2);
                    } else if (Intrinsics.areEqual(cls2, Throwable.class)) {
                        final int i5 = 2;
                        pairM13893to = TuplesKt.m13893to(safeCtor(new Function1() { // from class: kotlinx.coroutines.internal.a
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                switch (i5) {
                                    case 0:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$1(constructor, (Throwable) obj);
                                    case 1:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$3(constructor, (Throwable) obj);
                                    case 2:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$4(constructor, (Throwable) obj);
                                    default:
                                        return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$6(constructor, (Throwable) obj);
                                }
                            }
                        }), 1);
                    } else {
                        pairM13893to = TuplesKt.m13893to(null, -1);
                    }
                } else if (length2 != 2) {
                    pairM13893to = TuplesKt.m13893to(null, -1);
                } else if (Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    final int i6 = 0;
                    pairM13893to = TuplesKt.m13893to(safeCtor(new Function1() { // from class: kotlinx.coroutines.internal.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            switch (i6) {
                                case 0:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$1(constructor, (Throwable) obj);
                                case 1:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$3(constructor, (Throwable) obj);
                                case 2:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$4(constructor, (Throwable) obj);
                                default:
                                    return ExceptionsConstructorKt.createConstructor$lambda$7$lambda$6(constructor, (Throwable) obj);
                            }
                        }
                    }), 3);
                } else {
                    pairM13893to = TuplesKt.m13893to(null, -1);
                }
                arrayList.add(pairM13893to);
                i++;
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iIntValue = ((Number) ((Pair) next).getSecond()).intValue();
                    do {
                        Object next2 = it.next();
                        int iIntValue2 = ((Number) ((Pair) next2).getSecond()).intValue();
                        if (iIntValue < iIntValue2) {
                            next = next2;
                            iIntValue = iIntValue2;
                        }
                    } while (it.hasNext());
                }
            }
            Pair pair = (Pair) next;
            if (pair != null && (function1 = (Function1) pair.getFirst()) != null) {
                return function1;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$7$lambda$1(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th.getMessage(), th);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$7$lambda$3(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th.getMessage());
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) objNewInstance;
        th2.initCause(th);
        return th2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$7$lambda$4(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$7$lambda$6(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(null);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) objNewInstance;
        th2.initCause(th);
        return th2;
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object objM22215constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        Integer numValueOf = Integer.valueOf(i);
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = numValueOf;
        }
        return ((Number) objM22215constructorimpl).intValue();
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return new C7881i(function1, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable safeCtor$lambda$9(Function1 function1, Throwable th) {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Throwable th2 = (Throwable) function1.invoke(th);
            if (!Intrinsics.areEqual(th.getMessage(), th2.getMessage()) && !Intrinsics.areEqual(th2.getMessage(), th.toString())) {
                th2 = null;
            }
            objM22215constructorimpl = Result.m22215constructorimpl(th2);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th3));
        }
        return (Throwable) (Result.m22221isFailureimpl(objM22215constructorimpl) ? null : objM22215constructorimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E extends Throwable> E tryCopyException(@NotNull E e) {
        Object objM22215constructorimpl;
        if (!(e instanceof CopyableThrowable)) {
            return (E) ctorCache.get(e.getClass()).invoke(e);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(((CopyableThrowable) e).createCopy());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
            objM22215constructorimpl = null;
        }
        return (E) objM22215constructorimpl;
    }
}
