package androidx.compose.p109ui.node;

import androidx.compose.p109ui.layout.MeasureResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m13886d2 = {"Landroidx/compose/ui/node/PlaceableResult;", "Landroidx/compose/ui/node/OwnerScope;", "result", "Landroidx/compose/ui/layout/MeasureResult;", "placeable", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "(Landroidx/compose/ui/layout/MeasureResult;Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "isValidOwnerScope", "", "()Z", "getPlaceable", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "getResult", "()Landroidx/compose/ui/layout/MeasureResult;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final /* data */ class PlaceableResult implements OwnerScope {

    @NotNull
    private final LookaheadCapablePlaceable placeable;

    @NotNull
    private final MeasureResult result;

    public PlaceableResult(@NotNull MeasureResult measureResult, @NotNull LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.result = measureResult;
        this.placeable = lookaheadCapablePlaceable;
    }

    public static /* synthetic */ PlaceableResult copy$default(PlaceableResult placeableResult, MeasureResult measureResult, LookaheadCapablePlaceable lookaheadCapablePlaceable, int i, Object obj) {
        if ((i & 1) != 0) {
            measureResult = placeableResult.result;
        }
        if ((i & 2) != 0) {
            lookaheadCapablePlaceable = placeableResult.placeable;
        }
        return placeableResult.copy(measureResult, lookaheadCapablePlaceable);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeasureResult getResult() {
        return this.result;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LookaheadCapablePlaceable getPlaceable() {
        return this.placeable;
    }

    @NotNull
    public final PlaceableResult copy(@NotNull MeasureResult result, @NotNull LookaheadCapablePlaceable placeable) {
        return new PlaceableResult(result, placeable);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceableResult)) {
            return false;
        }
        PlaceableResult placeableResult = (PlaceableResult) other;
        return Intrinsics.areEqual(this.result, placeableResult.result) && Intrinsics.areEqual(this.placeable, placeableResult.placeable);
    }

    @NotNull
    public final LookaheadCapablePlaceable getPlaceable() {
        return this.placeable;
    }

    @NotNull
    public final MeasureResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.placeable.hashCode() + (this.result.hashCode() * 31);
    }

    @Override // androidx.compose.p109ui.node.OwnerScope
    public boolean isValidOwnerScope() {
        return this.placeable.getCoordinates().isAttached();
    }

    @NotNull
    public String toString() {
        return "PlaceableResult(result=" + this.result + ", placeable=" + this.placeable + PropertyUtils.MAPPED_DELIM2;
    }
}
