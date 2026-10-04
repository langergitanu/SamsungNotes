package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptorWithAccessors {
    @NotNull
    List<PropertyAccessorDescriptor> getAccessors();

    @Nullable
    FieldDescriptor getBackingField();

    @Nullable
    FieldDescriptor getDelegateField();

    @Nullable
    PropertyGetterDescriptor getGetter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    PropertyDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    @Nullable
    PropertySetterDescriptor getSetter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    PropertyDescriptor substitute(@NotNull TypeSubstitutor typeSubstitutor);
}
