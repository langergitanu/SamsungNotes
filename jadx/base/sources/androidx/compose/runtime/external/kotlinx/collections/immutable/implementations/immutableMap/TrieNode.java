package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\b\u0000\u0018\u0000 }*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002}~B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0091\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u0014H\u0000¢\u0006\u0002\b\u001aJ\u009c\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002JO\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0002J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J+\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010/J#\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J+\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00102J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u0005H\u0002J#\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020(2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J\r\u0010:\u001a\u00020\u0005H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\b=J%\u0010>\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010?J\u0015\u0010@\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0002J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FJ[\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u00012\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00028\u00002\u0006\u0010M\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010NJI\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010PJ=\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ8\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010$\u001a\u00020\u000bH\u0002J?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010YJ2\u0010Z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J9\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\\JQ\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010^JK\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JJ\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SJT\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002JM\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JE\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010dJ:\u0010e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J.\u0010f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002JX\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002J8\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010$\u001a\u00020\u000bH\u0002J=\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010mJ!\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u0005H\u0000¢\u0006\u0002\boJ\u0015\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bpJ9\u0010q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010rJ9\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010tJ1\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010uJ&\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J&\u0010w\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002JP\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J8\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J)\u0010z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FR0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, m13886d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "dataMap", "", "nodeMap", "buffer", "", "(II[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "<set-?>", "getBuffer$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "shift", "hash", "accept$runtime_release", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "bufferMoveEntryToNode", "keyIndex", "positionMask", "newKeyHash", "newKey", "newValue", "owner", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "calculateSize", "collisionContainsKey", "", "key", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemoveEntryAtIndex", "i", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "elementsIdentityEquals", "otherNode", "entryCount", "entryCount$runtime_release", "entryKeyIndex", "entryKeyIndex$runtime_release", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "hasEntryAt", "hasEntryAt$runtime_release", "hasNodeAt", "insertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "keyAtIndex", "(I)Ljava/lang/Object;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPut", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemoveEntryAtIndex", "mutableInsertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePutAll", "mutablePutAllFromOtherNodeCell", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableRemoveEntryAtIndex", "mutableRemoveNodeAtIndex", "nodeIndex", "mutableReplaceNode", "targetNode", "newNode", "mutableUpdateNodeAtIndex", "mutableUpdateValueAtIndex", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "nodeAtIndex", "nodeAtIndex$runtime_release", "nodeIndex$runtime_release", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "remove", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "removeNodeAtIndex", "replaceNode", "updateNodeAtIndex", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "valueAtKeyIndex", "Companion", "ModificationResult", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTrieNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode\n+ 2 ForEachOneBit.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ForEachOneBitKt\n+ 3 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 4 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,899:1\n10#2,9:900\n10#2,9:916\n10#2,9:925\n61#3,7:909\n84#4:934\n1#5:935\n26#6:936\n*S KotlinDebug\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode\n*L\n630#1:900,9\n648#1:916,9\n652#1:925,9\n640#1:909,7\n700#1:934\n700#1:935\n897#1:936\n*E\n"})
public final class TrieNode<K, V> {

    @NotNull
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;

    @Nullable
    private final MutabilityOwnership ownedBy;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0]);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @StabilityInferred(parameters = 0)
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJA\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0010\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0011H\u0086\bR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m13886d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nTrieNode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrieNode.kt\nandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,899:1\n1#2:900\n*E\n"})
    public static final class ModificationResult<K, V> {
        public static final int $stable = 8;

        @NotNull
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(@NotNull TrieNode<K, V> trieNode, int i) {
            this.node = trieNode;
            this.sizeDelta = i;
        }

        @NotNull
        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        @NotNull
        public final ModificationResult<K, V> replaceNode(@NotNull Function1<? super TrieNode<K, V>, TrieNode<K, V>> operation) {
            setNode(operation.invoke(getNode()));
            return this;
        }

        public final void setNode(@NotNull TrieNode<K, V> trieNode) {
            this.node = trieNode;
        }
    }

    public TrieNode(int i, int i2, @NotNull Object[] objArr, @Nullable MutabilityOwnership mutabilityOwnership) {
        this.dataMap = i;
        this.nodeMap = i2;
        this.ownedBy = mutabilityOwnership;
        this.buffer = objArr;
    }

    private final void accept(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor, int hash, int shift) {
        visitor.invoke(this, Integer.valueOf(shift), Integer.valueOf(hash), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int i = this.nodeMap;
        while (i != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i);
            nodeAtIndex$runtime_release(nodeIndex$runtime_release(iLowestOneBit)).accept(visitor, (Integer.numberOfTrailingZeros(iLowestOneBit) << shift) + hash, shift + 5);
            i -= iLowestOneBit;
        }
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult<>(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult<>(this, 0);
    }

    private final Object[] bufferMoveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, MutabilityOwnership owner) {
        K kKeyAtIndex = keyAtIndex(keyIndex);
        return TrieNodeKt.replaceEntryWithNode(this.buffer, keyIndex, nodeIndex$runtime_release(positionMask) + 1, makeNode(kKeyAtIndex != null ? kKeyAtIndex.hashCode() : 0, kKeyAtIndex, valueAtKeyIndex(keyIndex), newKeyHash, newKey, newValue, shift + 5, owner));
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int iBitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i = iBitCount * 2; i < length; i++) {
            iBitCount += nodeAtIndex$runtime_release(i).calculateSize();
        }
        return iBitCount;
    }

    private final boolean collisionContainsKey(K key) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.areEqual(key, this.buffer[first])) {
                if (first != last) {
                    first += step;
                }
            }
            return true;
        }
        return false;
    }

    private final V collisionGet(K key) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return null;
        }
        while (!Intrinsics.areEqual(key, keyAtIndex(first))) {
            if (first == last) {
                return null;
            }
            first += step;
        }
        return valueAtKeyIndex(first);
    }

    private final ModificationResult<K, V> collisionPut(K key, V value) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.areEqual(key, keyAtIndex(first))) {
                if (first != last) {
                    first += step;
                }
            }
            if (value == valueAtKeyIndex(first)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[first + 1] = value;
            return new TrieNode(0, 0, objArrCopyOf).asUpdateResult();
        }
        return new TrieNode(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, key, value)).asInsertResult();
    }

    private final TrieNode<K, V> collisionRemove(K key) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.areEqual(key, keyAtIndex(first))) {
                if (first != last) {
                    first += step;
                }
            }
            return collisionRemoveEntryAtIndex(first);
        }
        return this;
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int i) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(objArr, i));
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> otherNode) {
        if (this == otherNode) {
            return true;
        }
        if (this.nodeMap != otherNode.nodeMap || this.dataMap != otherNode.dataMap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != otherNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasNodeAt(int positionMask) {
        return (positionMask & this.nodeMap) != 0;
    }

    private final TrieNode<K, V> insertEntryAt(int positionMask, K key, V value) {
        return new TrieNode<>(positionMask | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release(positionMask), key, value));
    }

    private final K keyAtIndex(int keyIndex) {
        return (K) this.buffer[keyIndex];
    }

    private final TrieNode<K, V> makeNode(int keyHash1, K key1, V value1, int keyHash2, K key2, V value2, int shift, MutabilityOwnership owner) {
        if (shift > 30) {
            return new TrieNode<>(0, 0, new Object[]{key1, value1, key2, value2}, owner);
        }
        int iIndexSegment = TrieNodeKt.indexSegment(keyHash1, shift);
        int iIndexSegment2 = TrieNodeKt.indexSegment(keyHash2, shift);
        if (iIndexSegment != iIndexSegment2) {
            return new TrieNode<>((1 << iIndexSegment) | (1 << iIndexSegment2), 0, iIndexSegment < iIndexSegment2 ? new Object[]{key1, value1, key2, value2} : new Object[]{key2, value2, key1, value1}, owner);
        }
        return new TrieNode<>(0, 1 << iIndexSegment, new Object[]{makeNode(keyHash1, key1, value1, keyHash2, key2, value2, shift + 5, owner)}, owner);
    }

    private final TrieNode<K, V> moveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift) {
        return new TrieNode<>(this.dataMap ^ positionMask, this.nodeMap | positionMask, bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, null));
    }

    private final TrieNode<K, V> mutableCollisionPut(K key, V value, PersistentHashMapBuilder<K, V> mutator) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.areEqual(key, keyAtIndex(first))) {
                if (first != last) {
                    first += step;
                }
            }
            mutator.setOperationResult$runtime_release(valueAtKeyIndex(first));
            if (this.ownedBy == mutator.getOwnership()) {
                this.buffer[first + 1] = value;
                return this;
            }
            mutator.setModCount$runtime_release(mutator.getModCount() + 1);
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
            objArrCopyOf[first + 1] = value;
            return new TrieNode<>(0, 0, objArrCopyOf, mutator.getOwnership());
        }
        mutator.setSize(mutator.size() + 1);
        return new TrieNode<>(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, key, value), mutator.getOwnership());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> otherNode, DeltaCounter intersectionCounter, MutabilityOwnership owner) {
        CommonFunctionsKt.m18110assert(this.nodeMap == 0);
        CommonFunctionsKt.m18110assert(this.dataMap == 0);
        CommonFunctionsKt.m18110assert(otherNode.nodeMap == 0);
        CommonFunctionsKt.m18110assert(otherNode.dataMap == 0);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + otherNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        int length = this.buffer.length;
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, otherNode.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                if (collisionContainsKey(otherNode.buffer[first])) {
                    intersectionCounter.setCount(intersectionCounter.getCount() + 1);
                } else {
                    Object[] objArr2 = otherNode.buffer;
                    objArrCopyOf[length] = objArr2[first];
                    objArrCopyOf[length + 1] = objArr2[first + 1];
                    length += 2;
                }
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        if (length == this.buffer.length) {
            return this;
        }
        if (length == otherNode.buffer.length) {
            return otherNode;
        }
        if (length == objArrCopyOf.length) {
            return new TrieNode<>(0, 0, objArrCopyOf, owner);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(this, newSize)");
        return new TrieNode<>(0, 0, objArrCopyOf2, owner);
    }

    private final TrieNode<K, V> mutableCollisionRemove(K key, PersistentHashMapBuilder<K, V> mutator) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.areEqual(key, keyAtIndex(first))) {
                if (first != last) {
                    first += step;
                }
            }
            return mutableCollisionRemoveEntryAtIndex(first, mutator);
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i, PersistentHashMapBuilder<K, V> mutator) {
        mutator.setSize(mutator.size() - 1);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(i));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != mutator.getOwnership()) {
            return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(this.buffer, i), mutator.getOwnership());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i);
        return this;
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int positionMask, K key, V value, MutabilityOwnership owner) {
        int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(positionMask);
        if (this.ownedBy != owner) {
            return new TrieNode<>(positionMask | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime_release, key, value), owner);
        }
        this.buffer = TrieNodeKt.insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime_release, key, value);
        this.dataMap = positionMask | this.dataMap;
        return this;
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, MutabilityOwnership owner) {
        if (this.ownedBy != owner) {
            return new TrieNode<>(this.dataMap ^ positionMask, positionMask | this.nodeMap, bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner), owner);
        }
        this.buffer = bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner);
        this.dataMap ^= positionMask;
        this.nodeMap |= positionMask;
        return this;
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> otherNode, int positionMask, int shift, DeltaCounter intersectionCounter, PersistentHashMapBuilder<K, V> mutator) {
        if (hasNodeAt(positionMask)) {
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(positionMask));
            if (otherNode.hasNodeAt(positionMask)) {
                return trieNodeNodeAtIndex$runtime_release.mutablePutAll(otherNode.nodeAtIndex$runtime_release(otherNode.nodeIndex$runtime_release(positionMask)), shift + 5, intersectionCounter, mutator);
            }
            if (!otherNode.hasEntryAt$runtime_release(positionMask)) {
                return trieNodeNodeAtIndex$runtime_release;
            }
            int iEntryKeyIndex$runtime_release = otherNode.entryKeyIndex$runtime_release(positionMask);
            K kKeyAtIndex = otherNode.keyAtIndex(iEntryKeyIndex$runtime_release);
            V vValueAtKeyIndex = otherNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release);
            int size = mutator.size();
            TrieNode<K, V> trieNodeMutablePut = trieNodeNodeAtIndex$runtime_release.mutablePut(kKeyAtIndex != null ? kKeyAtIndex.hashCode() : 0, kKeyAtIndex, vValueAtKeyIndex, shift + 5, mutator);
            if (mutator.size() == size) {
                intersectionCounter.setCount(intersectionCounter.getCount() + 1);
            }
            return trieNodeMutablePut;
        }
        if (!otherNode.hasNodeAt(positionMask)) {
            int iEntryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(positionMask);
            K kKeyAtIndex2 = keyAtIndex(iEntryKeyIndex$runtime_release2);
            V vValueAtKeyIndex2 = valueAtKeyIndex(iEntryKeyIndex$runtime_release2);
            int iEntryKeyIndex$runtime_release3 = otherNode.entryKeyIndex$runtime_release(positionMask);
            K kKeyAtIndex3 = otherNode.keyAtIndex(iEntryKeyIndex$runtime_release3);
            return makeNode(kKeyAtIndex2 != null ? kKeyAtIndex2.hashCode() : 0, kKeyAtIndex2, vValueAtKeyIndex2, kKeyAtIndex3 != null ? kKeyAtIndex3.hashCode() : 0, kKeyAtIndex3, otherNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release3), shift + 5, mutator.getOwnership());
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release2 = otherNode.nodeAtIndex$runtime_release(otherNode.nodeIndex$runtime_release(positionMask));
        if (!hasEntryAt$runtime_release(positionMask)) {
            return trieNodeNodeAtIndex$runtime_release2;
        }
        int iEntryKeyIndex$runtime_release4 = entryKeyIndex$runtime_release(positionMask);
        K kKeyAtIndex4 = keyAtIndex(iEntryKeyIndex$runtime_release4);
        int i = shift + 5;
        if (!trieNodeNodeAtIndex$runtime_release2.containsKey(kKeyAtIndex4 != null ? kKeyAtIndex4.hashCode() : 0, kKeyAtIndex4, i)) {
            return trieNodeNodeAtIndex$runtime_release2.mutablePut(kKeyAtIndex4 != null ? kKeyAtIndex4.hashCode() : 0, kKeyAtIndex4, valueAtKeyIndex(iEntryKeyIndex$runtime_release4), i, mutator);
        }
        intersectionCounter.setCount(intersectionCounter.getCount() + 1);
        return trieNodeNodeAtIndex$runtime_release2;
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int keyIndex, int positionMask, PersistentHashMapBuilder<K, V> mutator) {
        mutator.setSize(mutator.size() - 1);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(keyIndex));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != mutator.getOwnership()) {
            return new TrieNode<>(positionMask ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(this.buffer, keyIndex), mutator.getOwnership());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, keyIndex);
        this.dataMap ^= positionMask;
        return this;
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int nodeIndex, int positionMask, MutabilityOwnership owner) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy != owner) {
            return new TrieNode<>(this.dataMap, positionMask ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, nodeIndex), owner);
        }
        this.buffer = TrieNodeKt.removeNodeAtIndex(objArr, nodeIndex);
        this.nodeMap ^= positionMask;
        return this;
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> targetNode, TrieNode<K, V> newNode, int nodeIndex, int positionMask, MutabilityOwnership owner) {
        return newNode == null ? mutableRemoveNodeAtIndex(nodeIndex, positionMask, owner) : (this.ownedBy == owner || targetNode != newNode) ? mutableUpdateNodeAtIndex(nodeIndex, newNode, owner) : this;
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int nodeIndex, TrieNode<K, V> newNode, MutabilityOwnership owner) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && newNode.buffer.length == 2 && newNode.nodeMap == 0) {
            newNode.dataMap = this.nodeMap;
            return newNode;
        }
        if (this.ownedBy == owner) {
            objArr[nodeIndex] = newNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[nodeIndex] = newNode;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf, owner);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int keyIndex, V value, PersistentHashMapBuilder<K, V> mutator) {
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer[keyIndex + 1] = value;
            return this;
        }
        mutator.setModCount$runtime_release(mutator.getModCount() + 1);
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[keyIndex + 1] = value;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf, mutator.getOwnership());
    }

    private final TrieNode<K, V> removeEntryAtIndex(int keyIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(positionMask ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(objArr, keyIndex));
    }

    private final TrieNode<K, V> removeNodeAtIndex(int nodeIndex, int positionMask) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode<>(this.dataMap, positionMask ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, nodeIndex));
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> targetNode, TrieNode<K, V> newNode, int nodeIndex, int positionMask) {
        return newNode == null ? removeNodeAtIndex(nodeIndex, positionMask) : targetNode != newNode ? updateNodeAtIndex(nodeIndex, positionMask, newNode) : this;
    }

    private final TrieNode<K, V> updateNodeAtIndex(int nodeIndex, int positionMask, TrieNode<K, V> newNode) {
        Object[] objArr = newNode.buffer;
        if (objArr.length != 2 || newNode.nodeMap != 0) {
            Object[] objArr2 = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            objArrCopyOf[nodeIndex] = newNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf);
        }
        if (this.buffer.length == 1) {
            newNode.dataMap = this.nodeMap;
            return newNode;
        }
        return new TrieNode<>(this.dataMap ^ positionMask, positionMask ^ this.nodeMap, TrieNodeKt.replaceNodeWithEntry(this.buffer, nodeIndex, entryKeyIndex$runtime_release(positionMask), objArr[0], objArr[1]));
    }

    private final TrieNode<K, V> updateValueAtIndex(int keyIndex, V value) {
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[keyIndex + 1] = value;
        return new TrieNode<>(this.dataMap, this.nodeMap, objArrCopyOf);
    }

    private final V valueAtKeyIndex(int keyIndex) {
        return (V) this.buffer[keyIndex + 1];
    }

    public final void accept$runtime_release(@NotNull Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor) {
        accept(visitor, 0, 0);
    }

    public final boolean containsKey(int keyHash, K key, int shift) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            return Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release(iIndexSegment)));
        }
        if (!hasNodeAt(iIndexSegment)) {
            return false;
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(iIndexSegment));
        return shift == 30 ? trieNodeNodeAtIndex$runtime_release.collisionContainsKey(key) : trieNodeNodeAtIndex$runtime_release.containsKey(keyHash, key, shift + 5);
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime_release(int positionMask) {
        return Integer.bitCount((positionMask - 1) & this.dataMap) * 2;
    }

    @Nullable
    public final V get(int keyHash, K key, int shift) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return valueAtKeyIndex(iEntryKeyIndex$runtime_release);
            }
            return null;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return null;
        }
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(iIndexSegment));
        return shift == 30 ? trieNodeNodeAtIndex$runtime_release.collisionGet(key) : trieNodeNodeAtIndex$runtime_release.get(keyHash, key, shift + 5);
    }

    @NotNull
    /* JADX INFO: renamed from: getBuffer$runtime_release, reason: from getter */
    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime_release(int positionMask) {
        return (positionMask & this.dataMap) != 0;
    }

    @NotNull
    public final TrieNode<K, V> mutablePut(int keyHash, K key, V value, int shift, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder;
        TrieNode<K, V> trieNodeMutablePut;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                mutator.setOperationResult$runtime_release(valueAtKeyIndex(iEntryKeyIndex$runtime_release));
                return valueAtKeyIndex(iEntryKeyIndex$runtime_release) == value ? this : mutableUpdateValueAtIndex(iEntryKeyIndex$runtime_release, value, mutator);
            }
            mutator.setSize(mutator.size() + 1);
            return mutableMoveEntryToNode(iEntryKeyIndex$runtime_release, iIndexSegment, keyHash, key, value, shift, mutator.getOwnership());
        }
        if (!hasNodeAt(iIndexSegment)) {
            mutator.setSize(mutator.size() + 1);
            return mutableInsertEntryAt(iIndexSegment, key, value, mutator.getOwnership());
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (shift == 30) {
            trieNodeMutablePut = trieNodeNodeAtIndex$runtime_release.mutableCollisionPut(key, value, mutator);
            persistentHashMapBuilder = mutator;
        } else {
            persistentHashMapBuilder = mutator;
            trieNodeMutablePut = trieNodeNodeAtIndex$runtime_release.mutablePut(keyHash, key, value, shift + 5, persistentHashMapBuilder);
        }
        return trieNodeNodeAtIndex$runtime_release == trieNodeMutablePut ? this : mutableUpdateNodeAtIndex(iNodeIndex$runtime_release, trieNodeMutablePut, persistentHashMapBuilder.getOwnership());
    }

    @NotNull
    public final TrieNode<K, V> mutablePutAll(@NotNull TrieNode<K, V> otherNode, int shift, @NotNull DeltaCounter intersectionCounter, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        if (this == otherNode) {
            intersectionCounter.plusAssign(calculateSize());
            return this;
        }
        int i = shift;
        if (i > 30) {
            return mutableCollisionPutAll(otherNode, intersectionCounter, mutator.getOwnership());
        }
        int i2 = this.nodeMap | otherNode.nodeMap;
        int i4 = this.dataMap;
        int i5 = otherNode.dataMap;
        int i6 = (i4 ^ i5) & (~i2);
        int i7 = i4 & i5;
        while (i7 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i7);
            if (Intrinsics.areEqual(keyAtIndex(entryKeyIndex$runtime_release(iLowestOneBit)), otherNode.keyAtIndex(otherNode.entryKeyIndex$runtime_release(iLowestOneBit)))) {
                i6 |= iLowestOneBit;
            } else {
                i2 |= iLowestOneBit;
            }
            i7 ^= iLowestOneBit;
        }
        int i8 = 0;
        if (!((i2 & i6) == 0)) {
            PreconditionsKt.throwIllegalStateException("Check failed.");
        }
        TrieNode<K, V> trieNode = (Intrinsics.areEqual(this.ownedBy, mutator.getOwnership()) && this.dataMap == i6 && this.nodeMap == i2) ? this : new TrieNode<>(i6, i2, new Object[Integer.bitCount(i2) + (Integer.bitCount(i6) * 2)]);
        int i9 = i2;
        int i10 = 0;
        while (i9 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i9);
            Object[] objArr = trieNode.buffer;
            objArr[(objArr.length - 1) - i10] = mutablePutAllFromOtherNodeCell(otherNode, iLowestOneBit2, i, intersectionCounter, mutator);
            i10++;
            i9 ^= iLowestOneBit2;
            i = shift;
        }
        while (i6 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i6);
            int i11 = i8 * 2;
            if (otherNode.hasEntryAt$runtime_release(iLowestOneBit3)) {
                int iEntryKeyIndex$runtime_release = otherNode.entryKeyIndex$runtime_release(iLowestOneBit3);
                trieNode.buffer[i11] = otherNode.keyAtIndex(iEntryKeyIndex$runtime_release);
                trieNode.buffer[i11 + 1] = otherNode.valueAtKeyIndex(iEntryKeyIndex$runtime_release);
                if (hasEntryAt$runtime_release(iLowestOneBit3)) {
                    intersectionCounter.setCount(intersectionCounter.getCount() + 1);
                }
            } else {
                int iEntryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(iLowestOneBit3);
                trieNode.buffer[i11] = keyAtIndex(iEntryKeyIndex$runtime_release2);
                trieNode.buffer[i11 + 1] = valueAtKeyIndex(iEntryKeyIndex$runtime_release2);
            }
            i8++;
            i6 ^= iLowestOneBit3;
        }
        return elementsIdentityEquals(trieNode) ? this : otherNode.elementsIdentityEquals(trieNode) ? otherNode : trieNode;
    }

    @Nullable
    public final TrieNode<K, V> mutableRemove(int keyHash, K key, int shift, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment, mutator);
            }
        } else if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
            return mutableReplaceNode(trieNodeNodeAtIndex$runtime_release, shift == 30 ? trieNodeNodeAtIndex$runtime_release.mutableCollisionRemove(key, mutator) : trieNodeNodeAtIndex$runtime_release.mutableRemove(keyHash, key, shift + 5, mutator), iNodeIndex$runtime_release, iIndexSegment, mutator.getOwnership());
        }
        return this;
    }

    @NotNull
    public final TrieNode<K, V> nodeAtIndex$runtime_release(int nodeIndex) {
        Object obj = this.buffer[nodeIndex];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    public final int nodeIndex$runtime_release(int positionMask) {
        return (this.buffer.length - 1) - Integer.bitCount((positionMask - 1) & this.nodeMap);
    }

    @Nullable
    public final ModificationResult<K, V> put(int keyHash, K key, V value, int shift) {
        ModificationResult<K, V> modificationResultPut;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (!Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return moveEntryToNode(iEntryKeyIndex$runtime_release, iIndexSegment, keyHash, key, value, shift).asInsertResult();
            }
            if (valueAtKeyIndex(iEntryKeyIndex$runtime_release) == value) {
                return null;
            }
            return updateValueAtIndex(iEntryKeyIndex$runtime_release, value).asUpdateResult();
        }
        if (!hasNodeAt(iIndexSegment)) {
            return insertEntryAt(iIndexSegment, key, value).asInsertResult();
        }
        int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
        TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
        if (shift == 30) {
            modificationResultPut = trieNodeNodeAtIndex$runtime_release.collisionPut(key, value);
            if (modificationResultPut == null) {
                return null;
            }
        } else {
            modificationResultPut = trieNodeNodeAtIndex$runtime_release.put(keyHash, key, value, shift + 5);
            if (modificationResultPut == null) {
                return null;
            }
        }
        modificationResultPut.setNode(updateNodeAtIndex(iNodeIndex$runtime_release, iIndexSegment, modificationResultPut.getNode()));
        return modificationResultPut;
    }

    @Nullable
    public final TrieNode<K, V> remove(int keyHash, K key, int shift) {
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release))) {
                return removeEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment);
            }
        } else if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
            return replaceNode(trieNodeNodeAtIndex$runtime_release, shift == 30 ? trieNodeNodeAtIndex$runtime_release.collisionRemove(key) : trieNodeNodeAtIndex$runtime_release.remove(keyHash, key, shift + 5), iNodeIndex$runtime_release, iIndexSegment);
        }
        return this;
    }

    private final TrieNode<K, V> collisionRemove(K key, V value) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                if (!Intrinsics.areEqual(key, keyAtIndex(first)) || !Intrinsics.areEqual(value, valueAtKeyIndex(first))) {
                    if (first == last) {
                        break;
                    }
                    first += step;
                } else {
                    return collisionRemoveEntryAtIndex(first);
                }
            }
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K key, V value, PersistentHashMapBuilder<K, V> mutator) {
        IntProgression intProgressionStep = RangesKt___RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                if (!Intrinsics.areEqual(key, keyAtIndex(first)) || !Intrinsics.areEqual(value, valueAtKeyIndex(first))) {
                    if (first == last) {
                        break;
                    }
                    first += step;
                } else {
                    return mutableCollisionRemoveEntryAtIndex(first, mutator);
                }
            }
        }
        return this;
    }

    public TrieNode(int i, int i2, @NotNull Object[] objArr) {
        this(i, i2, objArr, null);
    }

    @Nullable
    public final TrieNode<K, V> mutableRemove(int keyHash, K key, V value, int shift, @NotNull PersistentHashMapBuilder<K, V> mutator) {
        TrieNode<K, V> trieNodeMutableRemove;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release)) && Intrinsics.areEqual(value, valueAtKeyIndex(iEntryKeyIndex$runtime_release))) {
                return mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment, mutator);
            }
        } else if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
            if (shift == 30) {
                trieNodeMutableRemove = trieNodeNodeAtIndex$runtime_release.mutableCollisionRemove(key, value, mutator);
            } else {
                trieNodeMutableRemove = trieNodeNodeAtIndex$runtime_release.mutableRemove(keyHash, key, value, shift + 5, mutator);
            }
            return mutableReplaceNode(trieNodeNodeAtIndex$runtime_release, trieNodeMutableRemove, iNodeIndex$runtime_release, iIndexSegment, mutator.getOwnership());
        }
        return this;
    }

    @Nullable
    public final TrieNode<K, V> remove(int keyHash, K key, V value, int shift) {
        TrieNode<K, V> trieNodeRemove;
        int iIndexSegment = 1 << TrieNodeKt.indexSegment(keyHash, shift);
        if (hasEntryAt$runtime_release(iIndexSegment)) {
            int iEntryKeyIndex$runtime_release = entryKeyIndex$runtime_release(iIndexSegment);
            if (Intrinsics.areEqual(key, keyAtIndex(iEntryKeyIndex$runtime_release)) && Intrinsics.areEqual(value, valueAtKeyIndex(iEntryKeyIndex$runtime_release))) {
                return removeEntryAtIndex(iEntryKeyIndex$runtime_release, iIndexSegment);
            }
        } else if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime_release = nodeIndex$runtime_release(iIndexSegment);
            TrieNode<K, V> trieNodeNodeAtIndex$runtime_release = nodeAtIndex$runtime_release(iNodeIndex$runtime_release);
            if (shift == 30) {
                trieNodeRemove = trieNodeNodeAtIndex$runtime_release.collisionRemove(key, value);
            } else {
                trieNodeRemove = trieNodeNodeAtIndex$runtime_release.remove(keyHash, key, value, shift + 5);
            }
            return replaceNode(trieNodeNodeAtIndex$runtime_release, trieNodeRemove, iNodeIndex$runtime_release, iIndexSegment);
        }
        return this;
    }
}
