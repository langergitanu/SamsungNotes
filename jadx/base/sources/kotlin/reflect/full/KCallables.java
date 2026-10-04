package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001a\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a6\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0087@¢\u0006\u0002\u0010\u0017\u001a4\u0010\u0018\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0019H\u0087@¢\u0006\u0002\u0010\u001a\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m13886d2 = {"instanceParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getInstanceParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getInstanceParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "extensionReceiverParameter", "getExtensionReceiverParameter$annotations", "getExtensionReceiverParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "findParameterByName", "name", "", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-reflection"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@JvmName(name = "KCallables")
@SourceDebugExtension({"SMAP\nKCallables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KCallables.kt\nkotlin/reflect/full/KCallables\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,82:1\n669#2,11:83\n669#2,11:94\n774#2:105\n865#2,2:106\n669#2,11:108\n1#3:119\n*S KotlinDebug\n*F\n+ 1 KCallables.kt\nkotlin/reflect/full/KCallables\n*L\n23#1:83,11\n31#1:94,11\n38#1:105\n38#1:106,2\n45#1:108,11\n*E\n"})
public final class KCallables {

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspend$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class C130341<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C130341(Continuation<? super C130341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspendBy$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class C130351<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C130351(Continuation<? super C130351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KCallables.callSuspendBy(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @SinceKotlin(version = "1.3")
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspend(@NotNull KCallable<? extends R> kCallable, @NotNull Object[] objArr, @NotNull Continuation<? super R> continuation) {
        C130341 c130341;
        if (continuation instanceof C130341) {
            c130341 = (C130341) continuation;
            int i = c130341.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c130341.label = i - Integer.MIN_VALUE;
            } else {
                c130341 = new C130341(continuation);
            }
        }
        Object objCall = c130341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c130341.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCall);
            if (!kCallable.isSuspend()) {
                return kCallable.call(Arrays.copyOf(objArr, objArr.length));
            }
            if (!(kCallable instanceof KFunction)) {
                throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
            }
            c130341.L$0 = kCallable;
            c130341.L$1 = objArr;
            c130341.label = 1;
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(objArr);
            spreadBuilder.add(c130341);
            objCall = kCallable.call(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            if (objCall == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c130341);
            }
            if (objCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kCallable = (KCallable) c130341.L$0;
            ResultKt.throwOnFailure(objCall);
        }
        KFunction kFunction = (KFunction) kCallable;
        return (!Intrinsics.areEqual(kFunction.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || kFunction.getReturnType().isMarkedNullable()) ? objCall : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @SinceKotlin(version = "1.3")
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspendBy(@NotNull KCallable<? extends R> kCallable, @NotNull Map<KParameter, ? extends Object> map, @NotNull Continuation<? super R> continuation) throws IllegalCallableAccessException {
        C130351 c130351;
        if (continuation instanceof C130351) {
            c130351 = (C130351) continuation;
            int i = c130351.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c130351.label = i - Integer.MIN_VALUE;
            } else {
                c130351 = new C130351(continuation);
            }
        }
        Object objCallDefaultMethod$kotlin_reflection = c130351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c130351.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCallDefaultMethod$kotlin_reflection);
            if (!kCallable.isSuspend()) {
                return kCallable.callBy(map);
            }
            if (!(kCallable instanceof KFunction)) {
                throw new IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
            }
            KCallableImpl<?> kCallableImplAsKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            if (kCallableImplAsKCallableImpl == null) {
                throw new KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
            }
            c130351.L$0 = kCallable;
            c130351.L$1 = map;
            c130351.L$2 = kCallableImplAsKCallableImpl;
            c130351.label = 1;
            objCallDefaultMethod$kotlin_reflection = kCallableImplAsKCallableImpl.callDefaultMethod$kotlin_reflection(map, c130351);
            if (objCallDefaultMethod$kotlin_reflection == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(c130351);
            }
            if (objCallDefaultMethod$kotlin_reflection == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kCallable = (KCallable) c130351.L$0;
            ResultKt.throwOnFailure(objCallDefaultMethod$kotlin_reflection);
        }
        KFunction kFunction = (KFunction) kCallable;
        return (!Intrinsics.areEqual(kFunction.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) || kFunction.getReturnType().isMarkedNullable()) ? objCallDefaultMethod$kotlin_reflection : Unit.INSTANCE;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final KParameter findParameterByName(@NotNull KCallable<?> kCallable, @NotNull String name) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (Intrinsics.areEqual(((KParameter) next).getName(), name)) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter getExtensionReceiverParameter(@NotNull KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter getInstanceParameter(@NotNull KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.INSTANCE) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @NotNull
    public static final List<KParameter> getValueParameters(@NotNull KCallable<?> kCallable) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable kCallable) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getInstanceParameter$annotations(KCallable kCallable) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getValueParameters$annotations(KCallable kCallable) {
    }
}
