package androidx.glance;

import androidx.annotation.RestrictTo;
import androidx.glance.GlanceModifier;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0087\b\u001a\u001c\u0010\u0004\u001a\u0004\u0018\u0001H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"extractModifier", "Lkotlin/Pair;", "T", "Landroidx/glance/GlanceModifier;", "findModifier", "(Landroidx/glance/GlanceModifier;)Ljava/lang/Object;", "glance_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class UtilsKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* synthetic */ <T> Pair<T, GlanceModifier> extractModifier(GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.needClassReification();
        if (!glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.UtilsKt.extractModifier.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GlanceModifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Intrinsics.reifiedOperationMarker(3, "T");
                return Boolean.valueOf(Objects.nonNull(it));
            }
        })) {
            return TuplesKt.m13893to(null, glanceModifier);
        }
        Pair pairM13893to = TuplesKt.m13893to(null, GlanceModifier.INSTANCE);
        Intrinsics.needClassReification();
        return (Pair) glanceModifier.foldIn(pairM13893to, C28192.INSTANCE);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* synthetic */ <T> T findModifier(GlanceModifier glanceModifier) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.needClassReification();
        return (T) glanceModifier.foldIn(null, C28201.INSTANCE);
    }
}
