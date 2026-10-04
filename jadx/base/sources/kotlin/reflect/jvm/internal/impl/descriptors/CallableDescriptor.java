package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface CallableDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility, Substitutable<CallableDescriptor> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface UserDataKey<V> {
    }

    @NotNull
    List<ReceiverParameterDescriptor> getContextReceiverParameters();

    @Nullable
    ReceiverParameterDescriptor getDispatchReceiverParameter();

    @Nullable
    ReceiverParameterDescriptor getExtensionReceiverParameter();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    CallableDescriptor getOriginal();

    @NotNull
    Collection<? extends CallableDescriptor> getOverriddenDescriptors();

    @Nullable
    KotlinType getReturnType();

    @NotNull
    List<TypeParameterDescriptor> getTypeParameters();

    @Nullable
    <V> V getUserData(UserDataKey<V> userDataKey);

    @NotNull
    List<ValueParameterDescriptor> getValueParameters();

    boolean hasSynthesizedParameterNames();
}
