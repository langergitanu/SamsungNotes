package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J \u0010\f\u001a\u00020\b2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u000fH&¢\u0006\u0002\u0010\u0010J3\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000eH&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH'J$\u0010\u001b\u001a\u00020\b2\u001a\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e0\u001dH'J\b\u0010 \u001a\u00020\bH&J\u0016\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H&J\u0016\u0010%\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH&J\b\u0010&\u001a\u00020\u0003H&J\u0016\u0010'\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H&J\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020$H&J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020$H&J\b\u0010+\u001a\u00020\bH'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\u0082\u0001\u0001,ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0001"}, m13886d2 = {"Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/Composition;", "hasPendingChanges", "", "getHasPendingChanges", "()Z", "isComposing", "abandonChanges", "", "applyChanges", "applyLateChanges", "changesApplied", "composeContent", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;)V", "delegateInvalidations", "R", "to", "groupIndex", "", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "insertMovableContent", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidateAll", "observesAnyOf", "values", "", "", "prepareCompose", "recompose", "recordModificationsOf", "recordReadOf", "value", "recordWriteOf", "verifyConsistent", "Landroidx/compose/runtime/CompositionImpl;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ControlledComposition extends Composition {
    void abandonChanges();

    void applyChanges();

    void applyLateChanges();

    void changesApplied();

    void composeContent(@NotNull Function2<? super Composer, ? super Integer, Unit> content);

    <R> R delegateInvalidations(@Nullable ControlledComposition to, int groupIndex, @NotNull Function0<? extends R> block);

    @InternalComposeApi
    void disposeUnusedMovableContent(@NotNull MovableContentState state);

    boolean getHasPendingChanges();

    @InternalComposeApi
    void insertMovableContent(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> references);

    void invalidateAll();

    boolean isComposing();

    boolean observesAnyOf(@NotNull Set<? extends Object> values);

    void prepareCompose(@NotNull Function0<Unit> block);

    boolean recompose();

    void recordModificationsOf(@NotNull Set<? extends Object> values);

    void recordReadOf(@NotNull Object value);

    void recordWriteOf(@NotNull Object value);

    @InternalComposeApi
    void verifyConsistent();
}
