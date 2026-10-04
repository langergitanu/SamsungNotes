package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nTypeAttributeTranslators.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributeTranslators.kt\norg/jetbrains/kotlin/types/extensions/TypeAttributeTranslators\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1557#2:32\n1628#2,3:33\n1557#2:36\n1628#2,3:37\n*S KotlinDebug\n*F\n+ 1 TypeAttributeTranslators.kt\norg/jetbrains/kotlin/types/extensions/TypeAttributeTranslators\n*L\n18#1:32\n18#1:33,3\n25#1:36\n25#1:37,3\n*E\n"})
public final class TypeAttributeTranslators {

    @NotNull
    private final List<TypeAttributeTranslator> translators;

    /* JADX WARN: Multi-variable type inference failed */
    public TypeAttributeTranslators(@NotNull List<? extends TypeAttributeTranslator> translators) {
        Intrinsics.checkNotNullParameter(translators, "translators");
        this.translators = translators;
    }

    @NotNull
    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }
}
