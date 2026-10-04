package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DescriptorSubstitutor {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(str2);
        }
    }

    @NotNull
    public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> list, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(0);
        }
        if (typeSubstitution == null) {
            $$$reportNull$$$0(1);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        if (list2 == null) {
            $$$reportNull$$$0(3);
        }
        TypeSubstitutor typeSubstitutorSubstituteTypeParameters = substituteTypeParameters(list, typeSubstitution, declarationDescriptor, list2, null);
        if (typeSubstitutorSubstituteTypeParameters != null) {
            return typeSubstitutorSubstituteTypeParameters;
        }
        throw new AssertionError("Substitution failed");
    }

    @Nullable
    public static TypeSubstitutor substituteTypeParameters(@NotNull List<TypeParameterDescriptor> list, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2, @Nullable boolean[] zArr) {
        if (list == null) {
            $$$reportNull$$$0(5);
        }
        if (typeSubstitution == null) {
            $$$reportNull$$$0(6);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(7);
        }
        if (list2 == null) {
            $$$reportNull$$$0(8);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i = 0;
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            TypeParameterDescriptorImpl typeParameterDescriptorImplCreateForFurtherModification = TypeParameterDescriptorImpl.createForFurtherModification(declarationDescriptor, typeParameterDescriptor.getAnnotations(), typeParameterDescriptor.isReified(), typeParameterDescriptor.getVariance(), typeParameterDescriptor.getName(), i, SourceElement.NO_SOURCE, typeParameterDescriptor.getStorageManager());
            map.put(typeParameterDescriptor.getTypeConstructor(), new TypeProjectionImpl(typeParameterDescriptorImplCreateForFurtherModification.getDefaultType()));
            map2.put(typeParameterDescriptor, typeParameterDescriptorImplCreateForFurtherModification);
            list2.add(typeParameterDescriptorImplCreateForFurtherModification);
            i++;
        }
        TypeConstructorSubstitution typeConstructorSubstitutionCreateByConstructorsMap = TypeConstructorSubstitution.createByConstructorsMap(map);
        TypeSubstitutor typeSubstitutorCreateChainedSubstitutor = TypeSubstitutor.createChainedSubstitutor(typeSubstitution, typeConstructorSubstitutionCreateByConstructorsMap);
        TypeSubstitutor typeSubstitutorCreateChainedSubstitutor2 = TypeSubstitutor.createChainedSubstitutor(typeSubstitution.replaceWithNonApproximating(), typeConstructorSubstitutionCreateByConstructorsMap);
        for (TypeParameterDescriptor typeParameterDescriptor2 : list) {
            TypeParameterDescriptorImpl typeParameterDescriptorImpl = (TypeParameterDescriptorImpl) map2.get(typeParameterDescriptor2);
            for (KotlinType kotlinType : typeParameterDescriptor2.getUpperBounds()) {
                ClassifierDescriptor classifierDescriptorMo23493getDeclarationDescriptor = kotlinType.getConstructor().mo23493getDeclarationDescriptor();
                KotlinType kotlinTypeSubstitute = (((classifierDescriptorMo23493getDeclarationDescriptor instanceof TypeParameterDescriptor) && TypeUtilsKt.hasTypeParameterRecursiveBounds((TypeParameterDescriptor) classifierDescriptorMo23493getDeclarationDescriptor)) ? typeSubstitutorCreateChainedSubstitutor : typeSubstitutorCreateChainedSubstitutor2).substitute(kotlinType, Variance.OUT_VARIANCE);
                if (kotlinTypeSubstitute == null) {
                    return null;
                }
                if (kotlinTypeSubstitute != kotlinType && zArr != null) {
                    zArr[0] = true;
                }
                typeParameterDescriptorImpl.addUpperBound(kotlinTypeSubstitute);
            }
            typeParameterDescriptorImpl.setInitialized();
        }
        return typeSubstitutorCreateChainedSubstitutor;
    }
}
