package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.p109ui.layout.BeyondBoundsLayout;
import androidx.compose.p109ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p109ui.modifier.ModifierLocalProvider;
import androidx.compose.p109ui.modifier.ProvidableModifierLocal;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 ,2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002:\u0001,B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0019\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u001f¢\u0006\u0002\b!H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\u00020\b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0016\u0010'\u001a\u00020\b*\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0016\u0010*\u001a\u00020\b*\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", DBSchema.DocumentThumbnail.LAYOUT, "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "isForward", "isForward-4vf7U8o", "(I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    public static final int $stable = 0;

    @NotNull
    private static final C1113x8f1df05a emptyBeyondBoundsScope = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1
        private final boolean hasMoreContent;

        @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean getHasMoreContent() {
            return this.hasMoreContent;
        }
    };

    @NotNull
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    @NotNull
    private final LayoutDirection layoutDirection;

    @NotNull
    private final Orientation orientation;
    private final boolean reverseLayout;

    @NotNull
    private final LazyLayoutBeyondBoundsState state;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierLocal(@NotNull LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, @NotNull LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z, @NotNull LayoutDirection layoutDirection, @NotNull Orientation orientation) {
        this.state = lazyLayoutBeyondBoundsState;
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    /* JADX INFO: renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m16003addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start = currentInterval.getStart();
        int end = currentInterval.getEnd();
        if (m16005isForward4vf7U8o(direction)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m16004hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        if (m16006isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        return m16005isForward4vf7U8o(i) ? interval.getEnd() < this.state.getItemCount() - 1 : interval.getStart() > 0;
    }

    /* JADX INFO: renamed from: isForward-4vf7U8o, reason: not valid java name */
    private final boolean m16005isForward4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.INSTANCE;
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19841getBeforehoxUOeE())) {
            return false;
        }
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19840getAfterhoxUOeE())) {
            return true;
        }
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19839getAbovehoxUOeE())) {
            return this.reverseLayout;
        }
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19842getBelowhoxUOeE())) {
            return !this.reverseLayout;
        }
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19843getLefthoxUOeE())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i2 == 1) {
                return this.reverseLayout;
            }
            if (i2 == 2) {
                return !this.reverseLayout;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19844getRighthoxUOeE())) {
            LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
        if (i4 == 1) {
            return !this.reverseLayout;
        }
        if (i4 == 2) {
            return this.reverseLayout;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m16006isOppositeToOrientation4vf7U8o(int i) {
        BeyondBoundsLayout.LayoutDirection.Companion companion = BeyondBoundsLayout.LayoutDirection.INSTANCE;
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19839getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19842getBelowhoxUOeE())) {
            return this.orientation == Orientation.Horizontal;
        }
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19843getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19844getRighthoxUOeE())) {
            return this.orientation == Orientation.Vertical;
        }
        if (BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19841getBeforehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m19835equalsimpl0(i, companion.m19840getAfterhoxUOeE())) {
            return false;
        }
        LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.p109ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p109ui.modifier.ModifierLocalProvider
    @NotNull
    public BeyondBoundsLayout getValue() {
        return this;
    }

    @Override // androidx.compose.p109ui.layout.BeyondBoundsLayout
    @Nullable
    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo16007layouto7g1Pn8(final int direction, @NotNull Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return block.invoke(emptyBeyondBoundsScope);
        }
        int lastPlacedIndex = m16005isForward4vf7U8o(direction) ? this.state.getLastPlacedIndex() : this.state.getFirstPlacedIndex();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) this.beyondBoundsInfo.addInterval(lastPlacedIndex, lastPlacedIndex);
        T tInvoke = null;
        while (tInvoke == null && m16004hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element, direction)) {
            T t = (T) m16003addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element, direction);
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = t;
            this.state.remeasure();
            tInvoke = block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    return this.this$0.m16004hasMoreContentFR3nfPY(objectRef.element, direction);
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element);
        this.state.remeasure();
        return tInvoke;
    }
}
