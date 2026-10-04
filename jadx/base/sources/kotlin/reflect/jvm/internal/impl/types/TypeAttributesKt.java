package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
public final class TypeAttributesKt {
    @NotNull
    public static final TypeAttributes replaceAnnotations(@NotNull TypeAttributes typeAttributes, @NotNull Annotations newAnnotations) {
        TypeAttributes typeAttributesRemove;
        Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        if (AnnotationsTypeAttributeKt.getAnnotations(typeAttributes) == newAnnotations) {
            return typeAttributes;
        }
        AnnotationsTypeAttribute annotationsAttribute = AnnotationsTypeAttributeKt.getAnnotationsAttribute(typeAttributes);
        if (annotationsAttribute != null && (typeAttributesRemove = typeAttributes.remove(annotationsAttribute)) != null) {
            typeAttributes = typeAttributesRemove;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? typeAttributes.plus(new AnnotationsTypeAttribute(newAnnotations)) : typeAttributes;
    }

    @NotNull
    public static final TypeAttributes toDefaultAttributes(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "<this>");
        return TypeAttributeTranslator.DefaultImpls.toAttributes$default(DefaultTypeAttributeTranslator.INSTANCE, annotations, null, null, 6, null);
    }
}
