package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ArrayValue extends ConstantValue<List<? extends ConstantValue<?>>> {

    @NotNull
    private final Function1<ModuleDescriptor, KotlinType> computeType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull Function1<? super ModuleDescriptor, ? extends KotlinType> computeType) {
        super(value);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(computeType, "computeType");
        this.computeType = computeType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    @NotNull
    public KotlinType getType(@NotNull ModuleDescriptor module) {
        Intrinsics.checkNotNullParameter(module, "module");
        KotlinType kotlinTypeInvoke = this.computeType.invoke(module);
        if (!KotlinBuiltIns.isArray(kotlinTypeInvoke) && !KotlinBuiltIns.isPrimitiveArray(kotlinTypeInvoke)) {
            KotlinBuiltIns.isUnsignedArrayType(kotlinTypeInvoke);
        }
        return kotlinTypeInvoke;
    }
}
