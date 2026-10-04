package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class JvmBuiltInsCustomizerKt {

    @NotNull
    private static final Name GET_FIRST_LIST_NAME;

    @NotNull
    private static final Name GET_LAST_LIST_NAME;

    static {
        Name nameIdentifier = Name.identifier("getFirst");
        Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        GET_FIRST_LIST_NAME = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("getLast");
        Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        GET_LAST_LIST_NAME = nameIdentifier2;
    }
}
