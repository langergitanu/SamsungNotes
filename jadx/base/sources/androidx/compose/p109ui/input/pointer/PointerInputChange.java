package androidx.compose.p109ui.input.pointer;

import androidx.compose.p109ui.ExperimentalComposeUiApi;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B[\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011BQ\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0014Bu\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u0006\u0010<\u001a\u00020=Jt\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u0086\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010FJl\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010HJt\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJj\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010LJz\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR&\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00138\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010#R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b*\u0010,R\"\u0010\u001a\u001a\u00020\u0007X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b-\u0010(\"\u0004\b.\u0010/R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b0\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b4\u0010(R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b7\u0010(R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, m13886d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "pressure", "", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "get_historical$annotations", "()V", "<set-?>", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "isConsumed", "isConsumed$annotations", "()Z", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "getPosition-F1C5BW0", "getPressed", "getPressure", "()F", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class PointerInputChange {
    public static final int $stable = 0;

    @Nullable
    private List<HistoricalChange> _historical;

    @NotNull
    private ConsumedData consumed;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, boolean z3, int i, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j5, j6, z2, z3, i, j7);
    }

    /* JADX INFO: renamed from: copy-0GkPj7c$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m19712copy0GkPj7c$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, ConsumedData consumedData, int i, long j7, int i2, Object obj) {
        long j8;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j12 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j5;
        long j13 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j6;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i4 = (i2 & 256) != 0 ? pointerInputChange.type : i;
        if ((i2 & 512) != 0) {
            j8 = pointerInputChange.scrollDelta;
            j9 = j9;
        } else {
            j8 = j7;
        }
        return pointerInputChange.m19718copy0GkPj7c(j9, j10, j11, z3, j12, j13, z4, consumedData, i4, j8);
    }

    /* JADX INFO: renamed from: copy-JKmWfYY$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m19714copyJKmWfYY$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, int i, long j7, int i2, Object obj) {
        long j8;
        long j9;
        long j10 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j11 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j12 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j13 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j5;
        long j14 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j6;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i4 = (i2 & 128) != 0 ? pointerInputChange.type : i;
        if ((i2 & 256) != 0) {
            j8 = pointerInputChange.scrollDelta;
            j9 = j10;
        } else {
            j8 = j7;
            j9 = j10;
        }
        return pointerInputChange.m19720copyJKmWfYY(j9, j11, j12, z3, j13, j14, z4, i4, j8);
    }

    /* JADX INFO: renamed from: copy-OHpmEuE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m19715copyOHpmEuE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, int i, List list, long j7, int i2, Object obj) {
        long j8;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j12 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j5;
        long j13 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j6;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i4 = (i2 & 128) != 0 ? pointerInputChange.type : i;
        if ((i2 & 512) != 0) {
            j8 = pointerInputChange.scrollDelta;
            j9 = j9;
        } else {
            j8 = j7;
        }
        return pointerInputChange.m19721copyOHpmEuE(j9, j10, j11, z3, j12, j13, z4, i4, list, j8);
    }

    /* JADX INFO: renamed from: copy-Tn9QgHE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m19716copyTn9QgHE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, int i, long j7, int i2, Object obj) {
        long j8;
        long j9;
        long j10 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j11 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j12 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        float f4 = (i2 & 16) != 0 ? pointerInputChange.pressure : f;
        long j13 = (i2 & 32) != 0 ? pointerInputChange.previousUptimeMillis : j5;
        long j14 = (i2 & 64) != 0 ? pointerInputChange.previousPosition : j6;
        boolean z4 = (i2 & 128) != 0 ? pointerInputChange.previousPressed : z2;
        int i4 = (i2 & 256) != 0 ? pointerInputChange.type : i;
        if ((i2 & 512) != 0) {
            j8 = pointerInputChange.scrollDelta;
            j9 = j10;
        } else {
            j8 = j7;
            j9 = j10;
        }
        return pointerInputChange.m19722copyTn9QgHE(j9, j11, j12, z3, f4, j13, j14, z4, i4, j8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-wbzehF4$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m19717copywbzehF4$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, int i, List list, long j7, int i2, Object obj) {
        long j8;
        List list2;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        float f4 = (i2 & 16) != 0 ? pointerInputChange.pressure : f;
        long j12 = (i2 & 32) != 0 ? pointerInputChange.previousUptimeMillis : j5;
        long j13 = (i2 & 64) != 0 ? pointerInputChange.previousPosition : j6;
        boolean z4 = (i2 & 128) != 0 ? pointerInputChange.previousPressed : z2;
        int i4 = (i2 & 256) != 0 ? pointerInputChange.type : i;
        long j14 = j9;
        List historical = (i2 & 512) != 0 ? pointerInputChange.getHistorical() : list;
        if ((i2 & 1024) != 0) {
            list2 = historical;
            j8 = pointerInputChange.scrollDelta;
        } else {
            j8 = j7;
            list2 = historical;
        }
        return pointerInputChange.m19723copywbzehF4(j14, j10, j11, z3, f4, j12, j13, z4, i4, list2, j8);
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    @NotNull
    /* JADX INFO: renamed from: copy-0GkPj7c, reason: not valid java name */
    public final PointerInputChange m19718copy0GkPj7c(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, @NotNull ConsumedData consumed, int type, long scrollDelta) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, getHistorical(), scrollDelta, this.originalEventPosition, null);
        this.consumed = consumed;
        return pointerInputChange;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* JADX INFO: renamed from: copy-Ezr-O64, reason: not valid java name */
    public final /* synthetic */ PointerInputChange m19719copyEzrO64(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, ConsumedData consumed, int type) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, getHistorical(), this.scrollDelta, this.originalEventPosition, null);
        this.consumed = consumed;
        return pointerInputChange;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-JKmWfYY, reason: not valid java name */
    public final PointerInputChange m19720copyJKmWfYY(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        return m19723copywbzehF4(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, type, getHistorical(), scrollDelta);
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* JADX INFO: renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m19721copyOHpmEuE(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, @NotNull List<HistoricalChange> historical, long scrollDelta) {
        return m19723copywbzehF4(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, type, historical, scrollDelta);
    }

    @NotNull
    /* JADX INFO: renamed from: copy-Tn9QgHE, reason: not valid java name */
    public final PointerInputChange m19722copyTn9QgHE(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, getHistorical(), scrollDelta, this.originalEventPosition, null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* JADX INFO: renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m19723copywbzehF4(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, @NotNull List<HistoricalChange> historical, long scrollDelta) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, historical, scrollDelta, this.originalEventPosition, null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @NotNull
    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX INFO: renamed from: getId-J3iCeTQ, reason: not valid java name and from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: getOriginalEventPosition-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getOriginalEventPosition() {
        return this.originalEventPosition;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* JADX INFO: renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPreviousPosition() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* JADX INFO: renamed from: getScrollDelta-F1C5BW0, reason: not valid java name and from getter */
    public final long getScrollDelta() {
        return this.scrollDelta;
    }

    /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    /* JADX INFO: renamed from: setOriginalEventPosition-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m19730setOriginalEventPositionk4lQ0M$ui_release(long j) {
        this.originalEventPosition = j;
    }

    @NotNull
    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.m19710toStringimpl(this.id)) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m18292toStringimpl(this.position)) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + ((Object) Offset.m18292toStringimpl(this.previousPosition)) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + ((Object) PointerType.m19800toStringimpl(this.type)) + ", historical=" + getHistorical() + ",scrollDelta=" + ((Object) Offset.m18292toStringimpl(this.scrollDelta)) + PropertyUtils.MAPPED_DELIM2;
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, boolean z3, int i, List list, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j5, j6, z2, z3, i, (List<HistoricalChange>) list, j7, j8);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, ConsumedData consumedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j5, j6, z2, consumedData, i);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, boolean z3, int i, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j5, j6, z2, z3, i, j7);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, boolean z3, int i, long j7) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.pressure = f;
        this.previousUptimeMillis = j5;
        this.previousPosition = j6;
        this.previousPressed = z2;
        this.type = i;
        this.scrollDelta = j7;
        this.originalEventPosition = Offset.INSTANCE.m18300getZeroF1C5BW0();
        this.consumed = new ConsumedData(z3, z3);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getHistorical$annotations() {
    }

    private static /* synthetic */ void get_historical$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, boolean z3, int i, long j7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j5, j6, z2, z3, (i2 & 512) != 0 ? PointerType.INSTANCE.m19805getTouchT8wyACA() : i, (i2 & 1024) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j7, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, boolean z3, int i, long j7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j5, j6, z2, z3, (i2 & 256) != 0 ? PointerType.INSTANCE.m19805getTouchT8wyACA() : i, (i2 & 512) != 0 ? Offset.INSTANCE.m18300getZeroF1C5BW0() : j7, (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, boolean z3, int i, long j7) {
        this(j, j2, j3, z, 1.0f, j5, j6, z2, z3, i, j7, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, ConsumedData consumedData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j5, j6, z2, consumedData, (i2 & 256) != 0 ? PointerType.INSTANCE.m19805getTouchT8wyACA() : i, (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j5, long j6, boolean z2, ConsumedData consumedData, int i) {
        this(j, j2, j3, z, 1.0f, j5, j6, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, Offset.INSTANCE.m18300getZeroF1C5BW0(), (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j5, long j6, boolean z2, boolean z3, int i, List<HistoricalChange> list, long j7, long j8) {
        this(j, j2, j3, z, f, j5, j6, z2, z3, i, j7, (DefaultConstructorMarker) null);
        this._historical = list;
        this.originalEventPosition = j8;
    }
}
