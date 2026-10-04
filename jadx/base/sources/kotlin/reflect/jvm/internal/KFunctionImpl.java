package kotlin.reflect.jvm.internal;

import com.microsoft.identity.common.java.constants.FidoConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B7\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0013J\u0012\u0010(\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00100\u001a\u00020/2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020/2\u0006\u0010,\u001a\u00020-H\u0002J.\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u0010,\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0017H\u0002J\u0013\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010A\u001a\u000207H\u0016J\b\u0010B\u001a\u00020\tH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001b\u0010\u0012\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R!\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b&\u0010\"R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u00106\u001a\u0002078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0018R\u0014\u0010;\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0018R\u0014\u0010<\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0018R\u0014\u0010=\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0018R\u0014\u0010>\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0018¨\u0006C"}, m13886d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, "descriptorInitialValue", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "rawBoundReceiver", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "isBound", "", "()Z", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getName", "()Ljava/lang/String;", NotesConstants.KEY_CALLER, "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/Lazy;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getFunctionWithDefaultParametersForValueClassOverride", "getBoundReceiver", "()Ljava/lang/Object;", "useBoxedBoundReceiver", "member", "Ljava/lang/reflect/Method;", "createStaticMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "createJvmStaticInObjectCaller", "createInstanceMethodCaller", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "isDefault", "arity", "", "getArity", "()I", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nKFunctionImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KFunctionImpl.kt\nkotlin/reflect/jvm/internal/KFunctionImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,231:1\n2632#2,3:232\n1755#2,3:236\n1557#2:240\n1628#2,3:241\n1557#2:245\n1628#2,3:246\n1557#2:249\n1628#2,3:250\n1557#2:253\n1628#2,3:254\n183#3:235\n184#3:239\n1#4:244\n*S KotlinDebug\n*F\n+ 1 KFunctionImpl.kt\nkotlin/reflect/jvm/internal/KFunctionImpl\n*L\n156#1:232,3\n163#1:236,3\n72#1:240\n72#1:241,3\n87#1:245\n87#1:246,3\n123#1:249\n123#1:250,3\n128#1:253\n128#1:254,3\n163#1:235\n163#1:239\n*E\n"})
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;"))};

    /* JADX INFO: renamed from: caller$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy caller;

    @NotNull
    private final KDeclarationContainerImpl container;

    /* JADX INFO: renamed from: defaultCaller$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultCaller;

    /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReflectProperties.LazySoftVal descriptor;

    @Nullable
    private final Object rawBoundReceiver;

    @NotNull
    private final String signature;

    public /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Caller caller_delegate$lambda$4(KFunctionImpl this$0) {
        Object constructor;
        CallerImpl<Constructor<?>> callerImplCreateInstanceMethodCaller;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JvmFunctionSignature jvmFunctionSignatureMapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this$0.getDescriptor());
        if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this$0.isAnnotationConstructor()) {
                Class<?> jClass = this$0.getContainer().getJClass();
                List<KParameter> parameters = this$0.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(parameters));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    Intrinsics.checkNotNull(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            constructor = this$0.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) jvmFunctionSignatureMapSignature).getConstructorDesc());
        } else if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor descriptor = this$0.getDescriptor();
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (descriptor instanceof ConstructorDescriptor) && ((ConstructorDescriptor) descriptor).isPrimary()) {
                FunctionDescriptor descriptor2 = this$0.getDescriptor();
                KDeclarationContainerImpl container = this$0.getContainer();
                String methodDesc = ((JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature).getMethodDesc();
                List<ValueParameterDescriptor> valueParameters = this$0.getDescriptor().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                return new ValueClassAwareCaller.MultiFieldValueClassPrimaryConstructorCaller(descriptor2, container, methodDesc, valueParameters);
            }
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature;
            constructor = this$0.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
        } else if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.JavaMethod) {
            constructor = ((JvmFunctionSignature.JavaMethod) jvmFunctionSignatureMapSignature).getMethod();
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
        } else {
            if (!(jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.JavaConstructor)) {
                if (!(jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor)) {
                    throw new NoWhenBranchMatchedException();
                }
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmFunctionSignatureMapSignature).getMethods();
                Class<?> jClass2 = this$0.getContainer().getJClass();
                List<Method> list = methods;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            constructor = ((JvmFunctionSignature.JavaConstructor) jvmFunctionSignatureMapSignature).getConstructor();
            Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type java.lang.reflect.Member");
        }
        if (constructor instanceof Constructor) {
            callerImplCreateInstanceMethodCaller = this$0.createConstructorCaller((Constructor) constructor, this$0.getDescriptor(), false);
        } else {
            if (!(constructor instanceof Method)) {
                throw new KotlinReflectionInternalError("Could not compute caller for function: " + this$0.getDescriptor() + " (member = " + constructor + PropertyUtils.MAPPED_DELIM2);
            }
            Method method = (Method) constructor;
            callerImplCreateInstanceMethodCaller = !Modifier.isStatic(method.getModifiers()) ? this$0.createInstanceMethodCaller(method) : this$0.getDescriptor().getAnnotations().mo23488findAnnotation(UtilKt.getJVM_STATIC()) != null ? this$0.createJvmStaticInObjectCaller(method) : this$0.createStaticMethodCaller(method);
        }
        return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded$default(callerImplCreateInstanceMethodCaller, this$0.getDescriptor(), false, 2, null);
    }

    private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> member, FunctionDescriptor descriptor, boolean isDefault) {
        return (isDefault || !InlineClassManglingRulesKt.shouldHideConstructorDueToValueClassTypeValueParameters(descriptor)) ? isBound() ? new CallerImpl.BoundConstructor(member, getBoundReceiver()) : new CallerImpl.Constructor(member) : isBound() ? new CallerImpl.AccessorForHiddenBoundConstructor(member, getBoundReceiver()) : new CallerImpl.AccessorForHiddenConstructor(member);
    }

    private final CallerImpl.Method createInstanceMethodCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundInstance(member, getBoundReceiver()) : new CallerImpl.Method.Instance(member);
    }

    private final CallerImpl.Method createJvmStaticInObjectCaller(Method member) {
        return isBound() ? new CallerImpl.Method.BoundJvmStaticInObject(member) : new CallerImpl.Method.JvmStaticInObject(member);
    }

    private final CallerImpl.Method createStaticMethodCaller(Method member) {
        if (isBound()) {
            return new CallerImpl.Method.BoundStatic(member, useBoxedBoundReceiver(member) ? this.rawBoundReceiver : getBoundReceiver());
        }
        return new CallerImpl.Method.Static(member);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Caller defaultCaller_delegate$lambda$10(KFunctionImpl this$0) {
        GenericDeclaration genericDeclarationFindDefaultConstructor;
        CallerImpl<Constructor<?>> callerImplCreateJvmStaticInObjectCaller;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.INSTANCE;
        JvmFunctionSignature jvmFunctionSignatureMapSignature = runtimeTypeMapper.mapSignature(this$0.getDescriptor());
        if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            FunctionDescriptor descriptor = this$0.getDescriptor();
            DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration) && (descriptor instanceof ConstructorDescriptor) && ((ConstructorDescriptor) descriptor).isPrimary()) {
                throw new KotlinReflectionInternalError(this$0.getDescriptor().getContainingDeclaration() + " cannot have default arguments");
            }
            FunctionDescriptor functionWithDefaultParametersForValueClassOverride = this$0.getFunctionWithDefaultParametersForValueClassOverride(this$0.getDescriptor());
            if (functionWithDefaultParametersForValueClassOverride != null) {
                JvmFunctionSignature jvmFunctionSignatureMapSignature2 = runtimeTypeMapper.mapSignature(functionWithDefaultParametersForValueClassOverride);
                Intrinsics.checkNotNull(jvmFunctionSignatureMapSignature2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction");
                JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature2;
                genericDeclarationFindDefaultConstructor = this$0.getContainer().findDefaultMethod(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc(), true);
            } else {
                KDeclarationContainerImpl container = this$0.getContainer();
                JvmFunctionSignature.KotlinFunction kotlinFunction2 = (JvmFunctionSignature.KotlinFunction) jvmFunctionSignatureMapSignature;
                String methodName = kotlinFunction2.getMethodName();
                String methodDesc = kotlinFunction2.getMethodDesc();
                Intrinsics.checkNotNull(this$0.getCaller().mo23485getMember());
                genericDeclarationFindDefaultConstructor = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(r5.getModifiers()));
            }
        } else if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this$0.isAnnotationConstructor()) {
                Class<?> jClass = this$0.getContainer().getJClass();
                List<KParameter> parameters = this$0.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(parameters));
                Iterator<T> it = parameters.iterator();
                while (it.hasNext()) {
                    String name = ((KParameter) it.next()).getName();
                    Intrinsics.checkNotNull(name);
                    arrayList.add(name);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
            }
            genericDeclarationFindDefaultConstructor = this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) jvmFunctionSignatureMapSignature).getConstructorDesc());
        } else {
            if (jvmFunctionSignatureMapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) jvmFunctionSignatureMapSignature).getMethods();
                Class<?> jClass2 = this$0.getContainer().getJClass();
                List<Method> list = methods;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(list));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Method) it2.next()).getName());
                }
                return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
            }
            genericDeclarationFindDefaultConstructor = null;
        }
        if (genericDeclarationFindDefaultConstructor instanceof Constructor) {
            callerImplCreateJvmStaticInObjectCaller = this$0.createConstructorCaller((Constructor) genericDeclarationFindDefaultConstructor, this$0.getDescriptor(), true);
        } else if (!(genericDeclarationFindDefaultConstructor instanceof Method)) {
            callerImplCreateJvmStaticInObjectCaller = null;
        } else if (this$0.getDescriptor().getAnnotations().mo23488findAnnotation(UtilKt.getJVM_STATIC()) != null) {
            DeclarationDescriptor containingDeclaration2 = this$0.getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            callerImplCreateJvmStaticInObjectCaller = !((ClassDescriptor) containingDeclaration2).isCompanionObject() ? this$0.createJvmStaticInObjectCaller((Method) genericDeclarationFindDefaultConstructor) : this$0.createStaticMethodCaller((Method) genericDeclarationFindDefaultConstructor);
        }
        if (callerImplCreateJvmStaticInObjectCaller != null) {
            return ValueClassAwareCallerKt.createValueClassAwareCallerIfNeeded(callerImplCreateJvmStaticInObjectCaller, this$0.getDescriptor(), true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FunctionDescriptor descriptor_delegate$lambda$0(KFunctionImpl this$0, String name) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        return this$0.getContainer().findFunctionDescriptor(name, this$0.signature);
    }

    private final Object getBoundReceiver() {
        return ValueClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, getDescriptor());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final FunctionDescriptor getFunctionWithDefaultParametersForValueClassOverride(FunctionDescriptor descriptor) {
        DeclarationDescriptor containingDeclaration;
        CallableMemberDescriptor next;
        List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        List<ValueParameterDescriptor> list = valueParameters;
        if ((list instanceof Collection) && list.isEmpty()) {
            containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
            }
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((ValueParameterDescriptor) it.next()).declaresDefaultValue()) {
                    break;
                }
            }
            containingDeclaration = descriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
            if (InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
                Member memberMo23485getMember = getCaller().mo23485getMember();
                Intrinsics.checkNotNull(memberMo23485getMember);
                if (Modifier.isStatic(memberMo23485getMember.getModifiers())) {
                    Iterator<CallableMemberDescriptor> it2 = DescriptorUtilsKt.overriddenTreeAsSequence(descriptor, false).iterator();
                    loop0: while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        List<ValueParameterDescriptor> valueParameters2 = next.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                        List<ValueParameterDescriptor> list2 = valueParameters2;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it3 = list2.iterator();
                            while (it3.hasNext()) {
                                if (((ValueParameterDescriptor) it3.next()).declaresDefaultValue()) {
                                    break loop0;
                                }
                            }
                        }
                    }
                    if (next instanceof FunctionDescriptor) {
                        return (FunctionDescriptor) next;
                    }
                }
            }
        }
        return null;
    }

    private final boolean useBoxedBoundReceiver(Method member) {
        KotlinType type;
        ReceiverParameterDescriptor dispatchReceiverParameter = getDescriptor().getDispatchReceiverParameter();
        if (dispatchReceiverParameter == null || (type = dispatchReceiverParameter.getType()) == null || !InlineClassesUtilsKt.isInlineClassType(type)) {
            return false;
        }
        Class<?>[] parameterTypes = member.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
        Class cls = (Class) ArraysKt.firstOrNull(parameterTypes);
        return cls != null && cls.isInterface();
    }

    public boolean equals(@Nullable Object other) {
        KFunctionImpl kFunctionImplAsKFunctionImpl = UtilKt.asKFunctionImpl(other);
        return kFunctionImplAsKFunctionImpl != null && Intrinsics.areEqual(getContainer(), kFunctionImplAsKFunctionImpl.getContainer()) && Intrinsics.areEqual(getName(), kFunctionImplAsKFunctionImpl.getName()) && Intrinsics.areEqual(this.signature, kFunctionImplAsKFunctionImpl.signature) && Intrinsics.areEqual(this.rawBoundReceiver, kFunctionImplAsKFunctionImpl.rawBoundReceiver);
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return CallerKt.getArity(getCaller());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> getCaller() {
        return (Caller) this.caller.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.container;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> getDefaultCaller() {
        return (Caller) this.defaultCaller.getValue();
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        String strAsString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    public int hashCode() {
        return this.signature.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public Object invoke() {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return this.rawBoundReceiver != CallableReference.NO_RECEIVER;
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getDescriptor().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getDescriptor().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getDescriptor().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getDescriptor().isOperator();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getDescriptor().isSuspend();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public FunctionDescriptor getDescriptor() {
        T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FunctionDescriptor) value;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public Object invoke(@Nullable Object obj) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, final String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.container = kDeclarationContainerImpl;
        this.signature = str2;
        this.rawBoundReceiver = obj;
        this.descriptor = ReflectProperties.lazySoft(functionDescriptor, new Function0(this, str) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$0
            private final KFunctionImpl arg$0;
            private final String arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KFunctionImpl.descriptor_delegate$lambda$0(this.arg$0, this.arg$1);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.caller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$1
            private final KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KFunctionImpl.caller_delegate$lambda$4(this.arg$0);
            }
        });
        this.defaultCaller = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$$Lambda$2
            private final KFunctionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return KFunctionImpl.defaultCaller_delegate$lambda$10(this.arg$0);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4);
    }

    @Override // kotlin.jvm.functions.Function5
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5);
    }

    @Override // kotlin.jvm.functions.Function6
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        this(container, name, signature, null, obj);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
    }

    @Override // kotlin.jvm.functions.Function9
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public KFunctionImpl(@NotNull KDeclarationContainerImpl container, @NotNull FunctionDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String strAsString = descriptor.getName().asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        this(container, strAsString, RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).get_signature(), descriptor, null, 16, null);
    }

    @Override // kotlin.jvm.functions.Function10
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21, @Nullable Object obj22) {
        return FunctionWithAllInvokes.DefaultImpls.invoke(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
