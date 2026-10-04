package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class PlatformDependentDeclarationFilterKt {

    @NotNull
    private static final FqName PLATFORM_DEPENDENT_ANNOTATION_FQ_NAME = StandardNames.FqNames.platformDependent;

    @NotNull
    public static final FqName getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME() {
        return PLATFORM_DEPENDENT_ANNOTATION_FQ_NAME;
    }
}
