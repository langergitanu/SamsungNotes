package androidx.glance;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u001c\u0010\n\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u0013\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J5\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016¢\u0006\u0002\u0010\u0013J5\u0010\u0014\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016¢\u0006\u0002\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/CombinedGlanceModifier;", "Landroidx/glance/GlanceModifier;", "outer", "inner", "(Landroidx/glance/GlanceModifier;Landroidx/glance/GlanceModifier;)V", "all", "", "predicate", "Lkotlin/Function1;", "Landroidx/glance/GlanceModifier$Element;", "any", "equals", "other", "", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "hashCode", "", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CombinedGlanceModifier implements GlanceModifier {
    public static final int $stable = 0;

    @NotNull
    private final GlanceModifier inner;

    @NotNull
    private final GlanceModifier outer;

    public CombinedGlanceModifier(@NotNull GlanceModifier outer, @NotNull GlanceModifier inner) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        this.outer = outer;
        this.inner = inner;
    }

    @Override // androidx.glance.GlanceModifier
    public boolean all(@NotNull Function1<? super GlanceModifier.Element, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return this.outer.all(predicate) && this.inner.all(predicate);
    }

    @Override // androidx.glance.GlanceModifier
    public boolean any(@NotNull Function1<? super GlanceModifier.Element, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return this.outer.any(predicate) || this.inner.any(predicate);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CombinedGlanceModifier)) {
            return false;
        }
        CombinedGlanceModifier combinedGlanceModifier = (CombinedGlanceModifier) other;
        return Intrinsics.areEqual(this.outer, combinedGlanceModifier.outer) && Intrinsics.areEqual(this.inner, combinedGlanceModifier.inner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.glance.GlanceModifier
    public <R> R foldIn(R initial, @NotNull Function2<? super R, ? super GlanceModifier.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return (R) this.inner.foldIn(this.outer.foldIn(initial, operation), operation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.glance.GlanceModifier
    public <R> R foldOut(R initial, @NotNull Function2<? super GlanceModifier.Element, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return (R) this.outer.foldOut(this.inner.foldOut(initial, operation), operation);
    }

    public int hashCode() {
        return (this.inner.hashCode() * 31) + this.outer.hashCode();
    }

    @NotNull
    public String toString() {
        return AbstractC0622a.m1165k(foldIn("", new Function2<String, GlanceModifier.Element, String>() { // from class: androidx.glance.CombinedGlanceModifier.toString.1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final String invoke(@NotNull String acc, @NotNull GlanceModifier.Element element) {
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + SQLKeyword.COMMA + element;
            }
        }), "[", "]");
    }
}
