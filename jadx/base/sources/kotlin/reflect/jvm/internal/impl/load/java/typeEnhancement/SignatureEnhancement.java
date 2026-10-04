package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.DeprecationCausedByFunctionNInfo;
import kotlin.reflect.jvm.internal.impl.load.java.UtilsKt;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.deprecation.DescriptorBasedDeprecationInfoKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nsignatureEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1557#2:291\n1628#2,3:292\n1557#2:295\n1628#2,3:296\n1557#2:300\n1628#2,3:301\n1755#2,3:304\n1755#2,3:307\n1567#2:310\n1598#2,4:311\n1557#2:315\n1628#2,3:316\n1557#2:319\n1628#2,3:320\n1#3:299\n*S KotlinDebug\n*F\n+ 1 signatureEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancement\n*L\n55#1:291\n55#1:292,3\n66#1:295\n66#1:296,3\n117#1:300\n117#1:301,3\n138#1:304,3\n144#1:307,3\n150#1:310\n150#1:311,4\n164#1:315\n164#1:316,3\n214#1:319\n214#1:320,3\n*E\n"})
public final class SignatureEnhancement {

    @NotNull
    private final JavaTypeEnhancement typeEnhancement;

    public SignatureEnhancement(@NotNull JavaTypeEnhancement typeEnhancement) {
        Intrinsics.checkNotNullParameter(typeEnhancement, "typeEnhancement");
        this.typeEnhancement = typeEnhancement;
    }

    private final boolean containsFunctionN(KotlinType kotlinType) {
        return TypeUtils.contains(kotlinType, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return SignatureEnhancement.containsFunctionN$lambda$15((UnwrappedType) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean containsFunctionN$lambda$15(UnwrappedType unwrappedType) {
        ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = unwrappedType.getConstructor().mo23493getDeclarationDescriptor();
        if (classifierDescriptorMo23493getDeclarationDescriptor == null) {
            return Boolean.FALSE;
        }
        Name name = classifierDescriptorMo23493getDeclarationDescriptor.getName();
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        return Boolean.valueOf(Intrinsics.areEqual(name, javaToKotlinClassMap.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual(DescriptorUtilsKt.fqNameOrNull(classifierDescriptorMo23493getDeclarationDescriptor), javaToKotlinClassMap.getFUNCTION_N_FQ_NAME()));
    }

    private final KotlinType enhance(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z2, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        SignatureParts signatureParts = new SignatureParts(annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, false, 16, null);
        KotlinType kotlinTypeInvoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(collection));
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            Intrinsics.checkNotNull(callableMemberDescriptor2);
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return enhance(signatureParts, kotlinTypeInvoke, arrayList, typeEnhancementInfo, z2);
    }

    public static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, LazyJavaResolverContext lazyJavaResolverContext, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, TypeEnhancementInfo typeEnhancementInfo, boolean z2, Function1 function1, int i, Object obj) {
        return signatureEnhancement.enhance(callableMemberDescriptor, annotated, z, lazyJavaResolverContext, annotationQualifierApplicabilityType, typeEnhancementInfo, (i & 32) != 0 ? false : z2, function1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01ee, code lost:
    
        if (r3 == null) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends CallableMemberDescriptor> D enhanceSignature(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        D d2;
        KotlinType kotlinTypeEnhanceValueParameter;
        boolean z;
        boolean z2;
        KotlinType type;
        List<TypeEnhancementInfo> parametersInfo;
        PropertyDescriptorImpl propertyDescriptorImpl;
        PropertyGetterDescriptorImpl getter;
        if (!(d instanceof JavaCallableMemberDescriptor)) {
            return d;
        }
        boolean z3 = true;
        if (d.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE || d.getOriginal().getOverriddenDescriptors().size() != 1) {
            LazyJavaResolverContext lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, getDefaultAnnotations(d, lazyJavaResolverContext));
            if (!(d instanceof JavaPropertyDescriptor) || (getter = (propertyDescriptorImpl = (PropertyDescriptorImpl) d).getGetter()) == null || getter.isDefault()) {
                d2 = d;
            } else {
                PropertyGetterDescriptorImpl getter2 = propertyDescriptorImpl.getGetter();
                Intrinsics.checkNotNull(getter2);
                d2 = getter2;
            }
            KotlinType type2 = null;
            if (d.getExtensionReceiverParameter() != null) {
                FunctionDescriptor functionDescriptor = d2 instanceof FunctionDescriptor ? (FunctionDescriptor) d2 : null;
                kotlinTypeEnhanceValueParameter = enhanceValueParameter(d, functionDescriptor != null ? (ValueParameterDescriptor) functionDescriptor.getUserData(JavaMethodDescriptor.ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER) : null, lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$0
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        return SignatureEnhancement.enhanceSignature$lambda$2((CallableMemberDescriptor) obj);
                    }
                });
            } else {
                kotlinTypeEnhanceValueParameter = null;
            }
            JavaMethodDescriptor javaMethodDescriptor = d instanceof JavaMethodDescriptor ? (JavaMethodDescriptor) d : null;
            int i = 0;
            if (javaMethodDescriptor != null) {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                DeclarationDescriptor containingDeclaration = javaMethodDescriptor.getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                String strSignature = MethodSignatureBuildingUtilsKt.signature(signatureBuildingComponents, (ClassDescriptor) containingDeclaration, MethodSignatureMappingKt.computeJvmDescriptor$default(javaMethodDescriptor, false, false, 3, null));
                PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo = strSignature != null ? PredefinedEnhancementInfoKt.getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE().get(strSignature) : null;
                if (predefinedFunctionEnhancementInfo != null) {
                    predefinedFunctionEnhancementInfo.getParametersInfo().size();
                    ((JavaMethodDescriptor) d).getValueParameters().size();
                }
                boolean z4 = (UtilsKt.isJspecifyEnabledInStrictMode(lazyJavaResolverContext.getComponents().getJavaTypeEnhancementState()) || lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers.getComponents().getSettings().getIgnoreNullabilityForErasedValueParameters()) && UtilsKt.hasErasedValueParameters(d);
                List<ValueParameterDescriptor> valueParameters = d2.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                List<ValueParameterDescriptor> list = valueParameters;
                ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
                for (final ValueParameterDescriptor valueParameterDescriptor : list) {
                    arrayList.add(enhanceValueParameter(d, valueParameterDescriptor, lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, (predefinedFunctionEnhancementInfo == null || (parametersInfo = predefinedFunctionEnhancementInfo.getParametersInfo()) == null) ? null : (TypeEnhancementInfo) CollectionsKt.getOrNull(parametersInfo, valueParameterDescriptor.getIndex()), z4, new Function1(valueParameterDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$1
                        private final ValueParameterDescriptor arg$0;

                        {
                            this.arg$0 = valueParameterDescriptor;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public Object invoke(Object obj) {
                            return SignatureEnhancement.enhanceSignature$lambda$8$lambda$7(this.arg$0, (CallableMemberDescriptor) obj);
                        }
                    }));
                }
                PropertyDescriptor propertyDescriptor = d instanceof PropertyDescriptor ? (PropertyDescriptor) d : null;
                KotlinType kotlinTypeEnhance$default = enhance$default(this, d, d2, true, lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, (propertyDescriptor == null || !JavaDescriptorUtilKt.isJavaField(propertyDescriptor)) ? AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE : AnnotationQualifierApplicabilityType.FIELD, predefinedFunctionEnhancementInfo != null ? predefinedFunctionEnhancementInfo.getReturnTypeInfo() : null, false, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$2
                    @Override // kotlin.jvm.functions.Function1
                    public Object invoke(Object obj) {
                        return SignatureEnhancement.enhanceSignature$lambda$9((CallableMemberDescriptor) obj);
                    }
                }, 32, null);
                KotlinType returnType = d.getReturnType();
                Intrinsics.checkNotNull(returnType);
                if (containsFunctionN(returnType)) {
                    z = true;
                    Pair<CallableDescriptor.UserDataKey<?>, ?> pairM13893to = z ? TuplesKt.m13893to(DescriptorBasedDeprecationInfoKt.getDEPRECATED_FUNCTION_KEY(), new DeprecationCausedByFunctionNInfo(d)) : null;
                    if (kotlinTypeEnhanceValueParameter == null && kotlinTypeEnhance$default == null) {
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((KotlinType) it.next()) != null) {
                                    break;
                                }
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor) d;
                    if (kotlinTypeEnhanceValueParameter == null) {
                        ReceiverParameterDescriptor extensionReceiverParameter = d.getExtensionReceiverParameter();
                        if (extensionReceiverParameter != null) {
                            type2 = extensionReceiverParameter.getType();
                        }
                    } else {
                        type2 = kotlinTypeEnhanceValueParameter;
                    }
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(arrayList));
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        KotlinType type3 = (KotlinType) obj;
                        if (type3 == null) {
                            type3 = d.getValueParameters().get(i).getType();
                            Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
                        }
                        arrayList2.add(type3);
                        i = i2;
                    }
                    if (kotlinTypeEnhance$default == null) {
                        kotlinTypeEnhance$default = d.getReturnType();
                        Intrinsics.checkNotNull(kotlinTypeEnhance$default);
                    }
                    JavaCallableMemberDescriptor javaCallableMemberDescriptorEnhance = javaCallableMemberDescriptor.enhance(type2, arrayList2, kotlinTypeEnhance$default, pairM13893to);
                    Intrinsics.checkNotNull(javaCallableMemberDescriptorEnhance, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                    return javaCallableMemberDescriptorEnhance;
                }
                ReceiverParameterDescriptor extensionReceiverParameter2 = d.getExtensionReceiverParameter();
                if (!((extensionReceiverParameter2 == null || (type = extensionReceiverParameter2.getType()) == null) ? false : containsFunctionN(type))) {
                    List<ValueParameterDescriptor> valueParameters2 = d.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                    List<ValueParameterDescriptor> list2 = valueParameters2;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        z2 = false;
                        if (z2) {
                        }
                        if (z) {
                        }
                        if (kotlinTypeEnhanceValueParameter == null) {
                        }
                        JavaCallableMemberDescriptor javaCallableMemberDescriptor2 = (JavaCallableMemberDescriptor) d;
                        if (kotlinTypeEnhanceValueParameter == null) {
                        }
                        ArrayList arrayList22 = new ArrayList(CollectionsKt.m13952k(arrayList));
                        while (r7.hasNext()) {
                        }
                        if (kotlinTypeEnhance$default == null) {
                        }
                        JavaCallableMemberDescriptor javaCallableMemberDescriptorEnhance2 = javaCallableMemberDescriptor2.enhance(type2, arrayList22, kotlinTypeEnhance$default, pairM13893to);
                        Intrinsics.checkNotNull(javaCallableMemberDescriptorEnhance2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                        return javaCallableMemberDescriptorEnhance2;
                    }
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        KotlinType type4 = ((ValueParameterDescriptor) it2.next()).getType();
                        Intrinsics.checkNotNullExpressionValue(type4, "getType(...)");
                        if (containsFunctionN(type4)) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = false;
                    }
                    if (z) {
                    }
                    if (kotlinTypeEnhanceValueParameter == null) {
                        if (!arrayList.isEmpty()) {
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    JavaCallableMemberDescriptor javaCallableMemberDescriptor22 = (JavaCallableMemberDescriptor) d;
                    if (kotlinTypeEnhanceValueParameter == null) {
                    }
                    ArrayList arrayList222 = new ArrayList(CollectionsKt.m13952k(arrayList));
                    while (r7.hasNext()) {
                    }
                    if (kotlinTypeEnhance$default == null) {
                    }
                    JavaCallableMemberDescriptor javaCallableMemberDescriptorEnhance22 = javaCallableMemberDescriptor22.enhance(type2, arrayList222, kotlinTypeEnhance$default, pairM13893to);
                    Intrinsics.checkNotNull(javaCallableMemberDescriptorEnhance22, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                    return javaCallableMemberDescriptorEnhance22;
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$2(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ReceiverParameterDescriptor extensionReceiverParameter = it.getExtensionReceiverParameter();
        Intrinsics.checkNotNull(extensionReceiverParameter);
        KotlinType type = extensionReceiverParameter.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$8$lambda$7(ValueParameterDescriptor valueParameterDescriptor, CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType type = it.getValueParameters().get(valueParameterDescriptor.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType enhanceSignature$lambda$9(CallableMemberDescriptor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KotlinType returnType = it.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enhanceTypeParameterBounds$lambda$14$lambda$13(UnwrappedType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof RawType;
    }

    private final KotlinType enhanceValueParameter(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, LazyJavaResolverContext lazyJavaResolverContext, TypeEnhancementInfo typeEnhancementInfo, boolean z, Function1<? super CallableMemberDescriptor, ? extends KotlinType> function1) {
        LazyJavaResolverContext lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers;
        return enhance(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers = ContextKt.copyWithNewDefaultTypeQualifiers(lazyJavaResolverContext, valueParameterDescriptor.getAnnotations())) == null) ? lazyJavaResolverContext : lazyJavaResolverContextCopyWithNewDefaultTypeQualifiers, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, typeEnhancementInfo, z, function1);
    }

    private final <D extends CallableMemberDescriptor> Annotations getDefaultAnnotations(D d, LazyJavaResolverContext lazyJavaResolverContext) {
        ClassifierDescriptor topLevelContainingClassifier = DescriptorUtilKt.getTopLevelContainingClassifier(d);
        if (topLevelContainingClassifier == null) {
            return d.getAnnotations();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = topLevelContainingClassifier instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) topLevelContainingClassifier : null;
        List<JavaAnnotation> moduleAnnotations = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.getModuleAnnotations() : null;
        List<JavaAnnotation> list = moduleAnnotations;
        if (list == null || list.isEmpty()) {
            return d.getAnnotations();
        }
        List<JavaAnnotation> list2 = moduleAnnotations;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, (JavaAnnotation) it.next(), true));
        }
        return Annotations.Companion.create(CollectionsKt.plus((Iterable) d.getAnnotations(), (Iterable) arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> enhanceSignatures(@NotNull LazyJavaResolverContext c, @NotNull Collection<? extends D> platformSignatures) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(platformSignatures, "platformSignatures");
        Collection<? extends D> collection = platformSignatures;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(collection));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(enhanceSignature((CallableMemberDescriptor) it.next(), c));
        }
        return arrayList;
    }

    @NotNull
    public final KotlinType enhanceSuperType(@NotNull KotlinType type, @NotNull LazyJavaResolverContext context) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(context, "context");
        KotlinType kotlinTypeEnhance$default = enhance$default(this, new SignatureParts(null, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, true), type, CollectionsKt.emptyList(), null, false, 12, null);
        return kotlinTypeEnhance$default == null ? type : kotlinTypeEnhance$default;
    }

    @NotNull
    public final List<KotlinType> enhanceTypeParameterBounds(@NotNull TypeParameterDescriptor typeParameter, @NotNull List<? extends KotlinType> bounds, @NotNull LazyJavaResolverContext context) {
        KotlinType kotlinType;
        KotlinType kotlinTypeEnhance$default;
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(context, "context");
        List<? extends KotlinType> list = bounds;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        for (KotlinType kotlinType2 : list) {
            if (TypeUtilsKt.contains(kotlinType2, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return Boolean.valueOf(SignatureEnhancement.enhanceTypeParameterBounds$lambda$14$lambda$13((UnwrappedType) obj));
                }
            })) {
                kotlinType = kotlinType2;
            } else {
                kotlinType = kotlinType2;
                kotlinTypeEnhance$default = enhance$default(this, new SignatureParts(typeParameter, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, false, 16, null), kotlinType, CollectionsKt.emptyList(), null, false, 12, null);
                if (kotlinTypeEnhance$default == null) {
                }
                arrayList.add(kotlinTypeEnhance$default);
            }
            kotlinTypeEnhance$default = kotlinType;
            arrayList.add(kotlinTypeEnhance$default);
        }
        return arrayList;
    }

    public static /* synthetic */ KotlinType enhance$default(SignatureEnhancement signatureEnhancement, SignatureParts signatureParts, KotlinType kotlinType, List list, TypeEnhancementInfo typeEnhancementInfo, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            typeEnhancementInfo = null;
        }
        TypeEnhancementInfo typeEnhancementInfo2 = typeEnhancementInfo;
        if ((i & 8) != 0) {
            z = false;
        }
        return signatureEnhancement.enhance(signatureParts, kotlinType, list, typeEnhancementInfo2, z);
    }

    private final KotlinType enhance(SignatureParts signatureParts, KotlinType kotlinType, List<? extends KotlinType> list, TypeEnhancementInfo typeEnhancementInfo, boolean z) {
        return this.typeEnhancement.enhance(kotlinType, signatureParts.computeIndexedQualifiers(kotlinType, list, typeEnhancementInfo, z), signatureParts.getSkipRawTypeArguments());
    }
}
