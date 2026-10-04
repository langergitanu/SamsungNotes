package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.p217ml.model.AbstractDataIndexer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \b\u0000\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010L\u001a\u00020\u0004H\u0016J\u0010\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0004H\u0016J\u0010\u0010O\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0004H\u0016JB\u0010P\u001a\u00020\u001d2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ\b\u0010Y\u001a\u00020\rH\u0016J\u0018\u0010Z\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u001dH\u0016J2\u0010[\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\u001e2\u0006\u0010\\\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020\b0<2\u0006\u0010`\u001a\u00020\u001eJ\u0010\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\bH\u0016J\u0010\u0010c\u001a\u00020\r2\u0006\u0010b\u001a\u00020\bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011RF\u0010\u001b\u001a.\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010+\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R:\u00101\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u000102X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\b088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0<8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR7\u0010F\u001a\b\u0012\u0004\u0012\u00020E082\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E088V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bG\u0010:\"\u0004\bH\u0010I\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006e"}, m13886d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "()V", "initialIncrementId", "", "(J)V", "_selectableMap", "Landroidx/collection/MutableLongObjectMap;", "Landroidx/compose/foundation/text/selection/Selectable;", "_selectables", "", "afterSelectableUnsubscribe", "Lkotlin/Function1;", "", "getAfterSelectableUnsubscribe$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setAfterSelectableUnsubscribe$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "incrementId", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroidx/compose/foundation/AtomicLong;", "onPositionChangeCallback", "getOnPositionChangeCallback$foundation_release", "setOnPositionChangeCallback$foundation_release", "onSelectableChangeCallback", "getOnSelectableChangeCallback$foundation_release", "setOnSelectableChangeCallback$foundation_release", "onSelectionUpdateCallback", "Lkotlin/Function6;", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getOnSelectionUpdateCallback$foundation_release", "()Lkotlin/jvm/functions/Function6;", "setOnSelectionUpdateCallback$foundation_release", "(Lkotlin/jvm/functions/Function6;)V", "onSelectionUpdateEndCallback", "Lkotlin/Function0;", "getOnSelectionUpdateEndCallback$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setOnSelectionUpdateEndCallback$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "onSelectionUpdateSelectAll", "Lkotlin/Function2;", "getOnSelectionUpdateSelectAll$foundation_release", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionUpdateSelectAll$foundation_release", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionUpdateStartCallback", "Lkotlin/Function4;", "getOnSelectionUpdateStartCallback$foundation_release", "()Lkotlin/jvm/functions/Function4;", "setOnSelectionUpdateStartCallback$foundation_release", "(Lkotlin/jvm/functions/Function4;)V", "selectableMap", "Landroidx/collection/LongObjectMap;", "getSelectableMap$foundation_release", "()Landroidx/collection/LongObjectMap;", "selectables", "", "getSelectables$foundation_release", "()Ljava/util/List;", "sorted", "getSorted$foundation_release", "()Z", "setSorted$foundation_release", "(Z)V", "<set-?>", "Landroidx/compose/foundation/text/selection/Selection;", "subselections", "getSubselections", "setSubselections", "(Landroidx/collection/LongObjectMap;)V", "subselections$delegate", "Landroidx/compose/runtime/MutableState;", "nextSelectableId", "notifyPositionChange", "selectableId", "notifySelectableChange", "notifySelectionUpdate", "layoutCoordinates", "newPosition", "previousPosition", "isStartHandle", "adjustment", "isInTouchMode", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectionUpdateSelectAll", "notifySelectionUpdateStart", "startPosition", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", AbstractDataIndexer.SORT_PARAM, "containerLayoutCoordinates", "subscribe", "selectable", "unsubscribe", "Companion", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSelectionRegistrarImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectionRegistrarImpl.kt\nandroidx/compose/foundation/text/selection/SelectionRegistrarImpl\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,230:1\n81#2:231\n107#2,2:232\n*S KotlinDebug\n*F\n+ 1 SelectionRegistrarImpl.kt\nandroidx/compose/foundation/text/selection/SelectionRegistrarImpl\n*L\n115#1:231\n115#1:232,2\n*E\n"})
public final class SelectionRegistrarImpl implements SelectionRegistrar {

    @NotNull
    private final MutableLongObjectMap<Selectable> _selectableMap;

    @NotNull
    private final List<Selectable> _selectables;

    @Nullable
    private Function1<? super Long, Unit> afterSelectableUnsubscribe;

    @NotNull
    private AtomicLong incrementId;

    @Nullable
    private Function1<? super Long, Unit> onPositionChangeCallback;

    @Nullable
    private Function1<? super Long, Unit> onSelectableChangeCallback;

    @Nullable
    private Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> onSelectionUpdateCallback;

    @Nullable
    private Function0<Unit> onSelectionUpdateEndCallback;

    @Nullable
    private Function2<? super Boolean, ? super Long, Unit> onSelectionUpdateSelectAll;

    @Nullable
    private Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> onSelectionUpdateStartCallback;
    private boolean sorted;

    /* JADX INFO: renamed from: subselections$delegate, reason: from kotlin metadata */
    @NotNull
    private final MutableState subselections;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final Saver<SelectionRegistrarImpl, Long> Saver = SaverKt.Saver(new Function2<SaverScope, SelectionRegistrarImpl, Long>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Long invoke(@NotNull SaverScope saverScope, @NotNull SelectionRegistrarImpl selectionRegistrarImpl) {
            return Long.valueOf(selectionRegistrarImpl.incrementId.get());
        }
    }, new Function1<Long, SelectionRegistrarImpl>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ SelectionRegistrarImpl invoke(Long l) {
            return invoke(l.longValue());
        }

        @Nullable
        public final SelectionRegistrarImpl invoke(long j) {
            return new SelectionRegistrarImpl(j, null);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<SelectionRegistrarImpl, Long> getSaver() {
            return SelectionRegistrarImpl.Saver;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SelectionRegistrarImpl(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$2(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @Nullable
    public final Function1<Long, Unit> getAfterSelectableUnsubscribe$foundation_release() {
        return this.afterSelectableUnsubscribe;
    }

    @Nullable
    public final Function1<Long, Unit> getOnPositionChangeCallback$foundation_release() {
        return this.onPositionChangeCallback;
    }

    @Nullable
    public final Function1<Long, Unit> getOnSelectableChangeCallback$foundation_release() {
        return this.onSelectableChangeCallback;
    }

    @Nullable
    public final Function6<Boolean, LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean> getOnSelectionUpdateCallback$foundation_release() {
        return this.onSelectionUpdateCallback;
    }

    @Nullable
    public final Function0<Unit> getOnSelectionUpdateEndCallback$foundation_release() {
        return this.onSelectionUpdateEndCallback;
    }

    @Nullable
    public final Function2<Boolean, Long, Unit> getOnSelectionUpdateSelectAll$foundation_release() {
        return this.onSelectionUpdateSelectAll;
    }

    @Nullable
    public final Function4<Boolean, LayoutCoordinates, Offset, SelectionAdjustment, Unit> getOnSelectionUpdateStartCallback$foundation_release() {
        return this.onSelectionUpdateStartCallback;
    }

    @NotNull
    public final LongObjectMap<Selectable> getSelectableMap$foundation_release() {
        return this._selectableMap;
    }

    @NotNull
    public final List<Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    /* JADX INFO: renamed from: getSorted$foundation_release, reason: from getter */
    public final boolean getSorted() {
        return this.sorted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    @NotNull
    public LongObjectMap<Selection> getSubselections() {
        return (LongObjectMap) this.subselections.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long nextSelectableId() {
        long andIncrement = this.incrementId.getAndIncrement();
        while (andIncrement == 0) {
            andIncrement = this.incrementId.getAndIncrement();
        }
        return andIncrement;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifyPositionChange(long selectableId) {
        this.sorted = false;
        Function1<? super Long, Unit> function1 = this.onPositionChangeCallback;
        if (function1 != null) {
            function1.invoke(Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectableChange(long selectableId) {
        Function1<? super Long, Unit> function1 = this.onSelectableChangeCallback;
        if (function1 != null) {
            function1.invoke(Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdate-njBpvok */
    public boolean mo16557notifySelectionUpdatenjBpvok(@NotNull LayoutCoordinates layoutCoordinates, long newPosition, long previousPosition, boolean isStartHandle, @NotNull SelectionAdjustment adjustment, boolean isInTouchMode) {
        Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> function6 = this.onSelectionUpdateCallback;
        if (function6 != null) {
            return function6.invoke(Boolean.valueOf(isInTouchMode), layoutCoordinates, Offset.m18273boximpl(newPosition), Offset.m18273boximpl(previousPosition), Boolean.valueOf(isStartHandle), adjustment).booleanValue();
        }
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateEnd() {
        Function0<Unit> function0 = this.onSelectionUpdateEndCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateSelectAll(long selectableId, boolean isInTouchMode) {
        Function2<? super Boolean, ? super Long, Unit> function2 = this.onSelectionUpdateSelectAll;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(isInTouchMode), Long.valueOf(selectableId));
        }
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdateStart-ubNVwUQ */
    public void mo16558notifySelectionUpdateStartubNVwUQ(@NotNull LayoutCoordinates layoutCoordinates, long startPosition, @NotNull SelectionAdjustment adjustment, boolean isInTouchMode) {
        Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> function4 = this.onSelectionUpdateStartCallback;
        if (function4 != null) {
            function4.invoke(Boolean.valueOf(isInTouchMode), layoutCoordinates, Offset.m18273boximpl(startPosition), adjustment);
        }
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(@Nullable Function1<? super Long, Unit> function1) {
        this.afterSelectableUnsubscribe = function1;
    }

    public final void setOnPositionChangeCallback$foundation_release(@Nullable Function1<? super Long, Unit> function1) {
        this.onPositionChangeCallback = function1;
    }

    public final void setOnSelectableChangeCallback$foundation_release(@Nullable Function1<? super Long, Unit> function1) {
        this.onSelectableChangeCallback = function1;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(@Nullable Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> function6) {
        this.onSelectionUpdateCallback = function6;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(@Nullable Function0<Unit> function0) {
        this.onSelectionUpdateEndCallback = function0;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(@Nullable Function2<? super Boolean, ? super Long, Unit> function2) {
        this.onSelectionUpdateSelectAll = function2;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(@Nullable Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> function4) {
        this.onSelectionUpdateStartCallback = function4;
    }

    public final void setSorted$foundation_release(boolean z) {
        this.sorted = z;
    }

    public void setSubselections(@NotNull LongObjectMap<Selection> longObjectMap) {
        this.subselections.setValue(longObjectMap);
    }

    @NotNull
    public final List<Selectable> sort(@NotNull final LayoutCoordinates containerLayoutCoordinates) {
        if (!this.sorted) {
            CollectionsKt.sortWith(this._selectables, new C1462b(new Function2<Selectable, Selectable, Integer>() { // from class: androidx.compose.foundation.text.selection.SelectionRegistrarImpl.sort.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Integer invoke(@NotNull Selectable selectable, @NotNull Selectable selectable2) {
                    LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
                    LayoutCoordinates layoutCoordinates2 = selectable2.getLayoutCoordinates();
                    long jMo19864localPositionOfR5De75A = layoutCoordinates != null ? containerLayoutCoordinates.mo19864localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m18300getZeroF1C5BW0()) : Offset.INSTANCE.m18300getZeroF1C5BW0();
                    long jMo19864localPositionOfR5De75A2 = layoutCoordinates2 != null ? containerLayoutCoordinates.mo19864localPositionOfR5De75A(layoutCoordinates2, Offset.INSTANCE.m18300getZeroF1C5BW0()) : Offset.INSTANCE.m18300getZeroF1C5BW0();
                    return Integer.valueOf(Offset.m18285getYimpl(jMo19864localPositionOfR5De75A) == Offset.m18285getYimpl(jMo19864localPositionOfR5De75A2) ? ComparisonsKt.compareValues(Float.valueOf(Offset.m18284getXimpl(jMo19864localPositionOfR5De75A)), Float.valueOf(Offset.m18284getXimpl(jMo19864localPositionOfR5De75A2))) : ComparisonsKt.compareValues(Float.valueOf(Offset.m18285getYimpl(jMo19864localPositionOfR5De75A)), Float.valueOf(Offset.m18285getYimpl(jMo19864localPositionOfR5De75A2))));
                }
            }, 0));
            this.sorted = true;
        }
        return getSelectables$foundation_release();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    @NotNull
    public Selectable subscribe(@NotNull Selectable selectable) {
        if (selectable.getSelectableId() == 0) {
            throw new IllegalArgumentException(("The selectable contains an invalid id: " + selectable.getSelectableId()).toString());
        }
        if (this._selectableMap.containsKey(selectable.getSelectableId())) {
            throw new IllegalArgumentException(("Another selectable with the id: " + selectable + ".selectableId has already subscribed.").toString());
        }
        this._selectableMap.set(selectable.getSelectableId(), selectable);
        this._selectables.add(selectable);
        this.sorted = false;
        return selectable;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void unsubscribe(@NotNull Selectable selectable) {
        if (this._selectableMap.containsKey(selectable.getSelectableId())) {
            this._selectables.remove(selectable);
            this._selectableMap.remove(selectable.getSelectableId());
            Function1<? super Long, Unit> function1 = this.afterSelectableUnsubscribe;
            if (function1 != null) {
                function1.invoke(Long.valueOf(selectable.getSelectableId()));
            }
        }
    }

    private SelectionRegistrarImpl(long j) {
        this._selectables = new ArrayList();
        this._selectableMap = LongObjectMapKt.mutableLongObjectMapOf();
        this.incrementId = new AtomicLong(j);
        this.subselections = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LongObjectMapKt.emptyLongObjectMap(), null, 2, null);
    }

    public SelectionRegistrarImpl() {
        this(1L);
    }
}
