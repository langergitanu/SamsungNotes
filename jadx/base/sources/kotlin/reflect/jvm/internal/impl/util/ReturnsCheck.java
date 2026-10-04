package kotlin.reflect.jvm.internal.impl.util;

import androidx.appcompat.widget.AbstractC0541b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ReturnsCheck implements Check {

    @NotNull
    private final String description;

    @NotNull
    private final String name;

    @NotNull
    private final Function1<KotlinBuiltIns, KotlinType> type;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReturnsBoolean extends ReturnsCheck {

        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        private ReturnsBoolean() {
            super("Boolean", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsBoolean$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ReturnsCheck.ReturnsBoolean._init_$lambda$0((KotlinBuiltIns) obj);
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType booleanType = kotlinBuiltIns.getBooleanType();
            Intrinsics.checkNotNullExpressionValue(booleanType, "getBooleanType(...)");
            return booleanType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReturnsInt extends ReturnsCheck {

        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        private ReturnsInt() {
            super("Int", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsInt$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ReturnsCheck.ReturnsInt._init_$lambda$0((KotlinBuiltIns) obj);
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType intType = kotlinBuiltIns.getIntType();
            Intrinsics.checkNotNullExpressionValue(intType, "getIntType(...)");
            return intType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReturnsUnit extends ReturnsCheck {

        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        private ReturnsUnit() {
            super("Unit", new Function1() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck$ReturnsUnit$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ReturnsCheck.ReturnsUnit._init_$lambda$0((KotlinBuiltIns) obj);
                }
            }, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final KotlinType _init_$lambda$0(KotlinBuiltIns kotlinBuiltIns) {
            Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
            SimpleType unitType = kotlinBuiltIns.getUnitType();
            Intrinsics.checkNotNullExpressionValue(unitType, "getUnitType(...)");
            return unitType;
        }
    }

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = str;
        this.type = function1;
        this.description = AbstractC0541b.m772n("must return ", str);
    }
}
