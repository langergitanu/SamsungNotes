package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TypedArrayValue extends ArrayValue {

    @NotNull
    private final KotlinType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypedArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull final KotlinType type) {
        super(value, new Function1(type) { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue$$Lambda$0
            private final KotlinType arg$0;

            {
                this.arg$0 = type;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return TypedArrayValue._init_$lambda$0(this.arg$0, (ModuleDescriptor) obj);
            }
        });
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType _init_$lambda$0(KotlinType type, ModuleDescriptor it) {
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(it, "it");
        return type;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }
}
