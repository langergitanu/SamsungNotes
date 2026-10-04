package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionData;
import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.spen.libsdl.SdlMediaRecorder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ½\u00012\u00020\u0001:\n½\u0001¾\u0001¿\u0001À\u0001Á\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010`\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010c\u001a\u00020dH\u0002J\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u000e\u0010i\u001a\u00020_H\u0082@¢\u0006\u0002\u0010hJ\u0006\u0010j\u001a\u00020_J\b\u0010k\u001a\u00020_H\u0002J\u0006\u0010l\u001a\u00020_J*\u0010m\u001a\u00020_2\u0006\u0010a\u001a\u00020\u00072\u0011\u0010n\u001a\r\u0012\u0004\u0012\u00020_0o¢\u0006\u0002\bpH\u0010¢\u0006\u0004\bq\u0010rJ:\u0010s\u001a\u0002Ht\"\u0004\b\u0000\u0010t2\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010U2\f\u0010v\u001a\b\u0012\u0004\u0012\u0002Ht0oH\u0082\b¢\u0006\u0002\u0010wJ\u0015\u0010x\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\bzJ\u0010\u0010{\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0002J\b\u0010|\u001a\u00020_H\u0002J\u0015\u0010}\u001a\u00020_2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0002\b~J\u0016\u0010\u007f\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020_2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0010¢\u0006\u0003\b\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ \u0010\u0086\u0001\u001a\u00020_2\u0006\u0010y\u001a\u00020\"2\u0007\u0010\u0087\u0001\u001a\u00020#H\u0010¢\u0006\u0003\b\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010y\u001a\u00020\"H\u0010¢\u0006\u0003\b\u008a\u0001J\u0007\u0010\u008b\u0001\u001a\u00020_J\u0011\u0010\u008c\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J.\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\t2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J#\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002J0\u0010\u0090\u0001\u001a\u00020_2\r\u0010\u0091\u0001\u001a\b0\u0092\u0001j\u0003`\u0093\u00012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00072\t\b\u0002\u0010\u0095\u0001\u001a\u00020\u0017H\u0002J\u001e\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u0007H\u0002JV\u0010\u0098\u0001\u001a\u00020_2D\u0010v\u001a@\b\u0001\u0012\u0005\u0012\u00030\u009a\u0001\u0012\u0017\u0012\u00150\u009b\u0001¢\u0006\u000f\b\u009c\u0001\u0012\n\b\u009d\u0001\u0012\u0005\b\b(\u009e\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020_0\u009f\u0001\u0012\u0006\u0012\u0004\u0018\u00010'0\u0099\u0001¢\u0006\u0003\b \u0001H\u0082@¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0017H\u0002J \u0010¢\u0001\u001a\u00020_2\u0014\u0010£\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020_0\u0097\u0001H\u0082\bJ\u0011\u0010¤\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u001f\u0010¥\u0001\u001a\u00020_2\u000e\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010*H\u0010¢\u0006\u0003\b¨\u0001J\u0017\u0010©\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\bª\u0001J\u0012\u0010«\u0001\u001a\u00020_2\u0007\u0010¬\u0001\u001a\u00020QH\u0002J\u0011\u0010\u00ad\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0002J\u0017\u0010®\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b¯\u0001J\u000b\u0010°\u0001\u001a\u0004\u0018\u000109H\u0002J\u0007\u0010±\u0001\u001a\u00020_J\t\u0010²\u0001\u001a\u00020_H\u0002J$\u0010³\u0001\u001a\u00020_2\b\u0010\u009e\u0001\u001a\u00030\u009b\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0082@¢\u0006\u0003\u0010¶\u0001J\u000f\u0010·\u0001\u001a\u00020_H\u0086@¢\u0006\u0002\u0010hJ\u0018\u0010¸\u0001\u001a\u00020_2\u0006\u0010L\u001a\u00020\u0003H\u0087@¢\u0006\u0003\u0010¹\u0001J\u0017\u0010º\u0001\u001a\u00020_2\u0006\u0010a\u001a\u00020\u0007H\u0010¢\u0006\u0003\b»\u0001J.\u0010¼\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020_0\u0097\u00012\u0006\u0010a\u001a\u00020\u00072\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010UH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010'0&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\f018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0014\u0010>\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0019R\u0014\u0010@\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0019R\u0014\u0010B\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0019R\u0011\u0010D\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\bE\u0010\u0019R\u0014\u0010F\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u000e\u0010H\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bM\u00105R\u0012\u0010N\u001a\u00060OR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0019R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020'0UX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010V\u001a\b\u0012\u0004\u0012\u00020\f0W8FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u000e\u0010\\\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010]\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Â\u0001"}, m13886d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingCallByInformation", "", "getCollectingCallByInformation$runtime_release", "()Z", "collectingParameterInformation", "getCollectingParameterInformation$runtime_release", "collectingSourceInformation", "getCollectingSourceInformation$runtime_release", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compositionsRemoved", "", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "frameClockPaused", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "getKnownCompositions", "()Ljava/util/List;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "addKnownCompositionLocked", "composition", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "clearKnownCompositionsLocked", "close", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "pauseCompositionFrameClock", "performInitialMovableContentInserts", "performInsertValues", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModifications", "onEachInvalidComposition", "recordFailedCompositionLocked", "recordInspectionTable", "table", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "removeKnownCompositionLocked", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "resetErrorState", "resumeCompositionFrameClock", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 7 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n+ 8 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 9 Snapshot.kt\nandroidx/compose/runtime/snapshots/Snapshot\n+ 10 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1646:1\n1299#1,5:1712\n1305#1:1722\n1299#1,5:1735\n1305#1:1745\n1299#1,5:1766\n1305#1:1829\n1208#2:1647\n1187#2,2:1648\n89#3:1650\n89#3:1651\n89#3:1654\n89#3:1656\n89#3:1663\n89#3:1664\n89#3:1665\n89#3:1666\n89#3:1684\n89#3:1685\n89#3:1686\n89#3:1687\n89#3:1688\n89#3:1689\n89#3:1690\n89#3:1697\n89#3:1707\n89#3:1710\n89#3:1711\n89#3:1723\n89#3:1724\n89#3:1774\n89#3:1816\n89#3:1830\n89#3:1853\n89#3:1854\n89#3:1855\n89#3:1856\n89#3:1859\n89#3:1862\n89#3:1863\n89#3:1864\n89#3:1865\n89#3:1866\n89#3:1867\n89#3:1868\n1229#4,2:1652\n1#5:1655\n1#5:1812\n33#6,6:1657\n33#6,6:1667\n33#6,6:1691\n93#6,2:1725\n33#6,4:1727\n95#6,2:1731\n38#6:1733\n97#6:1734\n120#6,3:1746\n33#6,4:1749\n123#6,2:1753\n125#6,2:1762\n38#6:1764\n127#6:1765\n82#6,3:1775\n33#6,4:1778\n85#6,2:1782\n38#6:1784\n87#6:1785\n110#6,2:1786\n33#6,6:1788\n112#6:1794\n110#6,2:1795\n33#6,6:1797\n112#6:1803\n211#6,3:1804\n33#6,4:1807\n214#6:1811\n215#6:1813\n38#6:1814\n216#6:1815\n231#6,3:1817\n64#6,4:1820\n234#6,2:1824\n69#6:1826\n236#6:1827\n82#6,3:1831\n33#6,4:1834\n85#6,2:1838\n38#6:1840\n87#6:1841\n33#6,6:1842\n460#7,11:1673\n735#7,2:1857\n728#7,2:1860\n314#8,9:1698\n323#8,2:1708\n138#9,5:1717\n138#9,5:1740\n138#9,3:1771\n142#9:1828\n138#9,5:1848\n361#10,7:1755\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer\n*L\n1121#1:1712,5\n1121#1:1722\n1198#1:1735,5\n1198#1:1745\n1218#1:1766,5\n1218#1:1829\n218#1:1647\n218#1:1648,2\n297#1:1650\n347#1:1651\n441#1:1654\n446#1:1656\n460#1:1663\n469#1:1664\n474#1:1665\n485#1:1666\n497#1:1684\n505#1:1685\n751#1:1686\n781#1:1687\n812#1:1688\n824#1:1689\n841#1:1690\n989#1:1697\n1001#1:1707\n1086#1:1710\n1102#1:1711\n1134#1:1723\n1165#1:1724\n1221#1:1774\n1239#1:1816\n1262#1:1830\n1329#1:1853\n1366#1:1854\n1381#1:1855\n1413#1:1856\n1421#1:1859\n1430#1:1862\n1437#1:1863\n1444#1:1864\n1453#1:1865\n1459#1:1866\n1471#1:1867\n1171#1:1868\n348#1:1652,2\n1236#1:1812\n452#1:1657,6\n491#1:1667,6\n842#1:1691,6\n1166#1:1725,2\n1166#1:1727,4\n1166#1:1731,2\n1166#1:1733\n1166#1:1734\n1215#1:1746,3\n1215#1:1749,4\n1215#1:1753,2\n1215#1:1762,2\n1215#1:1764\n1215#1:1765\n1222#1:1775,3\n1222#1:1778,4\n1222#1:1782,2\n1222#1:1784\n1222#1:1785\n1231#1:1786,2\n1231#1:1788,6\n1231#1:1794\n1231#1:1795,2\n1231#1:1797,6\n1231#1:1803\n1236#1:1804,3\n1236#1:1807,4\n1236#1:1811\n1236#1:1813\n1236#1:1814\n1236#1:1815\n1244#1:1817,3\n1244#1:1820,4\n1244#1:1824,2\n1244#1:1826\n1244#1:1827\n1266#1:1831,3\n1266#1:1834,4\n1266#1:1838,2\n1266#1:1840\n1266#1:1841\n1273#1:1842,6\n495#1:1673,11\n1415#1:1857,2\n1423#1:1860,2\n1000#1:1698,9\n1000#1:1708,2\n1121#1:1717,5\n1198#1:1740,5\n1218#1:1771,3\n1218#1:1828\n1303#1:1848,5\n1215#1:1755,7\n*E\n"})
public final class Recomposer extends CompositionContext {

    @NotNull
    private final List<ControlledComposition> _knownCompositions;

    @Nullable
    private List<? extends ControlledComposition> _knownCompositionsCache;

    @NotNull
    private final MutableStateFlow<State> _state;

    @NotNull
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;

    @Nullable
    private Throwable closeCause;

    @NotNull
    private final MutableVector<ControlledComposition> compositionInvalidations;

    @NotNull
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;

    @NotNull
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;

    @NotNull
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;

    @NotNull
    private final List<ControlledComposition> compositionsAwaitingApply;

    @Nullable
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;

    @NotNull
    private final CoroutineContext effectCoroutineContext;

    @NotNull
    private final CompletableJob effectJob;

    @Nullable
    private RecomposerErrorState errorState;

    @Nullable
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;

    @NotNull
    private final RecomposerInfoImpl recomposerInfo;

    @Nullable
    private Job runnerJob;

    @NotNull
    private MutableScatterSet<Object> snapshotInvalidations;

    @NotNull
    private final Object stateLock;

    @Nullable
    private CancellableContinuation<? super Unit> workContinuation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @NotNull
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());

    @NotNull
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, m13886d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", ResponseType.TOKEN, "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1646:1\n1360#2:1647\n1446#2,5:1648\n1855#2,2:1653\n1855#2,2:1667\n1855#2,2:1669\n1603#2,9:1671\n1855#2:1680\n1856#2:1682\n1612#2:1683\n1603#2,9:1684\n1855#2:1693\n1856#2:1695\n1612#2:1696\n33#3,6:1655\n33#3,6:1661\n1#4:1681\n1#4:1694\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$Companion\n*L\n1522#1:1647\n1522#1:1648,5\n1530#1:1653,2\n1539#1:1667,2\n1546#1:1669,2\n1560#1:1671,9\n1560#1:1680\n1560#1:1682\n1560#1:1683\n1565#1:1684,9\n1565#1:1693\n1565#1:1695\n1565#1:1696\n1536#1:1655,6\n1537#1:1661,6\n1560#1:1681\n1565#1:1694\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetAdd = persistentSet.add(info);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                persistentSetRemove = persistentSet.remove(info);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, persistentSetRemove));
        }

        public final void clearErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorState recomposerErrorStateResetErrorState = ((RecomposerInfoImpl) it.next()).resetErrorState();
                if (recomposerErrorStateResetErrorState != null) {
                    arrayList.add(recomposerErrorStateResetErrorState);
                }
            }
        }

        @NotNull
        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                RecomposerErrorInfo currentError = ((RecomposerInfoImpl) it.next()).getCurrentError();
                if (currentError != null) {
                    arrayList.add(currentError);
                }
            }
            return arrayList;
        }

        @NotNull
        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime_release(int key) {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                if (currentError == null || currentError.getRecoverable()) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(key);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final void loadStateAndComposeForHotReload$runtime_release(@NotNull Object token) {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            Iterator it = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it.hasNext()) {
                ((RecomposerInfoImpl) it.next()).resetErrorState();
            }
            Intrinsics.checkNotNull(token, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            List list = (List) token;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((HotReloadable) list.get(i)).resetContent();
            }
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((HotReloadable) list.get(i2)).recompose();
            }
            Iterator it2 = ((Iterable) Recomposer._runningRecomposers.getValue()).iterator();
            while (it2.hasNext()) {
                ((RecomposerInfoImpl) it2.next()).retryFailedCompositions();
            }
        }

        @NotNull
        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            Iterable iterable = (Iterable) Recomposer._runningRecomposers.getValue();
            ArrayList arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((RecomposerInfoImpl) it.next()).saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void setHotReloadEnabled$runtime_release(boolean value) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(value));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class HotReloadable {

        @NotNull
        private Function2<? super Composer, ? super Integer, Unit> composable;

        @NotNull
        private final CompositionImpl composition;

        public HotReloadable(@NotNull CompositionImpl compositionImpl) {
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m17984getLambda1$runtime_release());
            }
        }

        public final void recompose() {
            if (this.composition.getIsRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class RecomposerErrorState implements RecomposerErrorInfo {

        @NotNull
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z, @NotNull Exception exc) {
            this.recoverable = z;
            this.cause = exc;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        @NotNull
        public Exception getCause() {
            return this.cause;
        }

        @Override // androidx.compose.runtime.RecomposerErrorInfo
        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$RecomposerInfoImpl\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1646:1\n89#2:1647\n89#2:1648\n89#2:1667\n211#3,3:1649\n33#3,4:1652\n214#3:1656\n215#3:1658\n38#3:1659\n216#3:1660\n33#3,6:1661\n211#3,3:1668\n33#3,4:1671\n214#3:1675\n215#3:1677\n38#3:1678\n216#3:1679\n82#3,3:1680\n33#3,4:1683\n85#3:1687\n86#3:1689\n38#3:1690\n87#3:1691\n1#4:1657\n1#4:1676\n1#4:1688\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$RecomposerInfoImpl\n*L\n373#1:1647\n378#1:1648\n386#1:1667\n382#1:1649,3\n382#1:1652,4\n382#1:1656\n382#1:1658\n382#1:1659\n382#1:1660\n383#1:1661,6\n390#1:1668,3\n390#1:1671,4\n390#1:1675\n390#1:1677\n390#1:1678\n390#1:1679\n391#1:1680,3\n391#1:1683,4\n391#1:1687\n391#1:1689\n391#1:1690\n391#1:1691\n382#1:1657\n390#1:1676\n*E\n"})
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        @Nullable
        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState recomposerErrorState;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                recomposerErrorState = recomposer.errorState;
            }
            return recomposerErrorState;
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @Override // androidx.compose.runtime.RecomposerInfo
        @NotNull
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int key) {
            List knownCompositions;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                knownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((CompositionImpl) arrayList.get(i2)).invalidateGroupsWithKey(key);
            }
        }

        @Nullable
        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }

        @NotNull
        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List knownCompositions;
            Object obj = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (obj) {
                knownCompositions = recomposer.getKnownCompositions();
            }
            ArrayList arrayList = new ArrayList(knownCompositions.size());
            int size = knownCompositions.size();
            for (int i = 0; i < size; i++) {
                ControlledComposition controlledComposition = (ControlledComposition) knownCompositions.get(i);
                CompositionImpl compositionImpl = controlledComposition instanceof CompositionImpl ? (CompositionImpl) controlledComposition : null;
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList.get(i2));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$awaitIdle$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/compose/runtime/Recomposer$State;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer$awaitIdle$2", m14021f = "Recomposer.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C19522 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C19522(Continuation<? super C19522> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C19522 c19522 = new C19522(continuation);
            c19522.L$0 = obj;
            return c19522;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull State state, @Nullable Continuation<? super Boolean> continuation) {
            return ((C19522) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0).compareTo(State.Idle) > 0);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$join$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/compose/runtime/Recomposer$State;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer$join$2", m14021f = "Recomposer.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C19532 extends SuspendLambda implements Function2<State, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C19532(Continuation<? super C19532> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C19532 c19532 = new C19532(continuation);
            c19532.L$0 = obj;
            return c19532;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull State state, @Nullable Continuation<? super Boolean> continuation) {
            return ((C19532) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((State) this.L$0) == State.ShutDown);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", m14021f = "Recomposer.kt", m14022i = {0, 0}, m14023l = {1054}, m14024m = "invokeSuspend", m14025n = {"callingJob", "unregisterApplyObserver"}, m14026s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$recompositionRunner$2\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n1#1,1646:1\n89#2:1647\n89#2:1654\n33#3,6:1648\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$recompositionRunner$2\n*L\n1050#1:1647\n1059#1:1654\n1052#1:1648,6\n*E\n"})
    public static final class C19552 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MonotonicFrameClock $parentFrameClock;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", m14021f = "Recomposer.kt", m14022i = {}, m14023l = {1055}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ MonotonicFrameClock $parentFrameClock;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass3(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$block = function3;
                this.$parentFrameClock = monotonicFrameClock;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.$block;
                    MonotonicFrameClock monotonicFrameClock = this.$parentFrameClock;
                    this.label = 1;
                    if (function3.invoke(coroutineScope, monotonicFrameClock, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C19552(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super C19552> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = monotonicFrameClock;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C19552 c19552 = Recomposer.this.new C19552(this.$block, this.$parentFrameClock, continuation);
            c19552.L$0 = obj;
            return c19552;
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Job job;
            ObserverHandle observerHandle;
            Throwable th;
            List knownCompositions;
            Object obj2;
            Object obj3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
                Recomposer.this.registerRunnerJob(job);
                Snapshot.Companion companion = Snapshot.INSTANCE;
                final Recomposer recomposer = Recomposer.this;
                ObserverHandle observerHandleRegisterApplyObserver = companion.registerApplyObserver(new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
                        invoke2(set, snapshot);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
                        CancellableContinuation cancellableContinuationDeriveStateLocked;
                        Object obj4 = recomposer.stateLock;
                        Recomposer recomposer2 = recomposer;
                        synchronized (obj4) {
                            try {
                                if (((Recomposer.State) recomposer2._state.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                                    MutableScatterSet mutableScatterSet = recomposer2.snapshotInvalidations;
                                    if (set instanceof ScatterSetWrapper) {
                                        ScatterSet set$runtime_release = ((ScatterSetWrapper) set).getSet$runtime_release();
                                        Object[] objArr = set$runtime_release.elements;
                                        long[] jArr = set$runtime_release.metadata;
                                        int length = jArr.length - 2;
                                        if (length >= 0) {
                                            int i2 = 0;
                                            while (true) {
                                                long j = jArr[i2];
                                                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                                                    for (int i5 = 0; i5 < i4; i5++) {
                                                        if ((255 & j) < 128) {
                                                            Object obj5 = objArr[(i2 << 3) + i5];
                                                            if (!(obj5 instanceof StateObjectImpl) || ((StateObjectImpl) obj5).m18128isReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(1))) {
                                                                mutableScatterSet.add(obj5);
                                                            }
                                                        }
                                                        j >>= 8;
                                                    }
                                                    if (i4 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i2 == length) {
                                                    break;
                                                } else {
                                                    i2++;
                                                }
                                            }
                                        }
                                    } else {
                                        for (Object obj6 : set) {
                                            if (!(obj6 instanceof StateObjectImpl) || ((StateObjectImpl) obj6).m18128isReadInh_f27i8$runtime_release(ReaderKind.m18116constructorimpl(1))) {
                                                mutableScatterSet.add(obj6);
                                            }
                                        }
                                    }
                                    cancellableContinuationDeriveStateLocked = recomposer2.deriveStateLocked();
                                } else {
                                    cancellableContinuationDeriveStateLocked = null;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        if (cancellableContinuationDeriveStateLocked != null) {
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuationDeriveStateLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                        }
                    }
                });
                Recomposer.INSTANCE.addRunning(Recomposer.this.recomposerInfo);
                try {
                    Object obj4 = Recomposer.this.stateLock;
                    Recomposer recomposer2 = Recomposer.this;
                    synchronized (obj4) {
                        knownCompositions = recomposer2.getKnownCompositions();
                    }
                    int size = knownCompositions.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((ControlledComposition) knownCompositions.get(i2)).invalidateAll();
                    }
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, null);
                    this.L$0 = job;
                    this.L$1 = observerHandleRegisterApplyObserver;
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(anonymousClass3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    observerHandle = observerHandleRegisterApplyObserver;
                    observerHandle.dispose();
                    obj3 = Recomposer.this.stateLock;
                    Recomposer recomposer3 = Recomposer.this;
                    synchronized (obj3) {
                    }
                } catch (Throwable th2) {
                    observerHandle = observerHandleRegisterApplyObserver;
                    th = th2;
                    observerHandle.dispose();
                    obj2 = Recomposer.this.stateLock;
                    Recomposer recomposer4 = Recomposer.this;
                    synchronized (obj2) {
                        try {
                            if (recomposer4.runnerJob == job) {
                                recomposer4.runnerJob = null;
                            }
                            recomposer4.deriveStateLocked();
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                    throw th;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                observerHandle = (ObserverHandle) this.L$1;
                job = (Job) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    observerHandle.dispose();
                    obj3 = Recomposer.this.stateLock;
                    Recomposer recomposer32 = Recomposer.this;
                    synchronized (obj3) {
                        try {
                            if (recomposer32.runnerJob == job) {
                                recomposer32.runnerJob = null;
                            }
                            recomposer32.deriveStateLocked();
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    Recomposer.INSTANCE.removeRunning(Recomposer.this.recomposerInfo);
                    return Unit.INSTANCE;
                } catch (Throwable th5) {
                    th = th5;
                    observerHandle.dispose();
                    obj2 = Recomposer.this.stateLock;
                    Recomposer recomposer42 = Recomposer.this;
                    synchronized (obj2) {
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C19552) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runFrameLoop$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer", m14021f = "Recomposer.kt", m14022i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m14023l = {921, 928}, m14024m = "runFrameLoop", m14025n = {"this", "parentFrameClock", "frameSignal", "toRecompose", "toApply", "this", "parentFrameClock", "frameSignal", "toRecompose", "toApply"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class C19561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C19561(Continuation<? super C19561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Recomposer.this.runFrameLoop(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", m14021f = "Recomposer.kt", m14022i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m14023l = {574, 585}, m14024m = "invokeSuspend", m14025n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "modifiedValues", "modifiedValuesSet", "alreadyComposed"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeAndApplyChanges$2\n+ 2 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 3 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 4 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 5 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1646:1\n89#2:1647\n89#2:1732\n33#3,6:1648\n33#3,6:1733\n228#4,4:1654\n198#4,7:1658\n209#4,3:1666\n212#4,9:1670\n232#4:1679\n228#4,4:1680\n198#4,7:1684\n209#4,3:1692\n212#4,9:1696\n232#4:1705\n228#4,4:1706\n198#4,7:1710\n209#4,3:1718\n212#4,9:1722\n232#4:1731\n1956#5:1665\n1820#5:1669\n1956#5:1691\n1820#5:1695\n1956#5:1717\n1820#5:1721\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeAndApplyChanges$2\n*L\n536#1:1647\n567#1:1732\n540#1:1648,6\n568#1:1733,6\n546#1:1654,4\n546#1:1658,7\n546#1:1666,3\n546#1:1670,9\n546#1:1679\n552#1:1680,4\n552#1:1684,7\n552#1:1692,3\n552#1:1696,9\n552#1:1705\n557#1:1706,4\n557#1:1710,7\n557#1:1718,3\n557#1:1722,9\n557#1:1731\n546#1:1665\n546#1:1669\n552#1:1691\n552#1:1695\n557#1:1717\n557#1:1721\n*E\n"})
    public static final class C19582 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        public C19582(Continuation<? super C19582> continuation) {
            super(3, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void invokeSuspend$clearRecompositionState(Recomposer recomposer, List<ControlledComposition> list, List<MovableContentStateReference> list2, List<ControlledComposition> list3, MutableScatterSet<ControlledComposition> mutableScatterSet, MutableScatterSet<ControlledComposition> mutableScatterSet2, MutableScatterSet<Object> mutableScatterSet3, MutableScatterSet<ControlledComposition> mutableScatterSet4) {
            char c;
            long j;
            long j2;
            synchronized (recomposer.stateLock) {
                try {
                    list.clear();
                    list2.clear();
                    int size = list3.size();
                    for (int i = 0; i < size; i++) {
                        ControlledComposition controlledComposition = list3.get(i);
                        controlledComposition.abandonChanges();
                        recomposer.recordFailedCompositionLocked(controlledComposition);
                    }
                    list3.clear();
                    Object[] objArr = mutableScatterSet.elements;
                    long[] jArr = mutableScatterSet.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i2 = 0;
                        j = 255;
                        while (true) {
                            long j3 = jArr[i2];
                            c = 7;
                            j2 = -9187201950435737472L;
                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i4 = 8 - ((~(i2 - length)) >>> 31);
                                for (int i5 = 0; i5 < i4; i5++) {
                                    if ((j3 & 255) < 128) {
                                        ControlledComposition controlledComposition2 = (ControlledComposition) objArr[(i2 << 3) + i5];
                                        controlledComposition2.abandonChanges();
                                        recomposer.recordFailedCompositionLocked(controlledComposition2);
                                    }
                                    j3 >>= 8;
                                }
                                if (i4 != 8) {
                                    break;
                                } else if (i2 == length) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                    } else {
                        c = 7;
                        j = 255;
                        j2 = -9187201950435737472L;
                    }
                    mutableScatterSet.clear();
                    Object[] objArr2 = mutableScatterSet2.elements;
                    long[] jArr2 = mutableScatterSet2.metadata;
                    int length2 = jArr2.length - 2;
                    if (length2 >= 0) {
                        int i6 = 0;
                        while (true) {
                            long j5 = jArr2[i6];
                            if ((((~j5) << c) & j5 & j2) != j2) {
                                int i7 = 8 - ((~(i6 - length2)) >>> 31);
                                for (int i8 = 0; i8 < i7; i8++) {
                                    if ((j5 & j) < 128) {
                                        ((ControlledComposition) objArr2[(i6 << 3) + i8]).changesApplied();
                                    }
                                    j5 >>= 8;
                                }
                                if (i7 != 8) {
                                    break;
                                } else if (i6 == length2) {
                                    break;
                                } else {
                                    i6++;
                                }
                            }
                        }
                    }
                    mutableScatterSet2.clear();
                    mutableScatterSet3.clear();
                    Object[] objArr3 = mutableScatterSet4.elements;
                    long[] jArr3 = mutableScatterSet4.metadata;
                    int length3 = jArr3.length - 2;
                    if (length3 >= 0) {
                        int i9 = 0;
                        while (true) {
                            long j6 = jArr3[i9];
                            if ((((~j6) << c) & j6 & j2) != j2) {
                                int i10 = 8 - ((~(i9 - length3)) >>> 31);
                                for (int i11 = 0; i11 < i10; i11++) {
                                    if ((j6 & j) < 128) {
                                        ControlledComposition controlledComposition3 = (ControlledComposition) objArr3[(i9 << 3) + i11];
                                        controlledComposition3.abandonChanges();
                                        recomposer.recordFailedCompositionLocked(controlledComposition3);
                                    }
                                    j6 >>= 8;
                                }
                                if (i10 != 8) {
                                    break;
                                } else if (i9 == length3) {
                                    break;
                                } else {
                                    i9++;
                                }
                            }
                        }
                    }
                    mutableScatterSet4.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer) {
            list.clear();
            synchronized (recomposer.stateLock) {
                try {
                    List list2 = recomposer.compositionValuesAwaitingInsert;
                    int size = list2.size();
                    for (int i = 0; i < size; i++) {
                        list.add((MovableContentStateReference) list2.get(i));
                    }
                    recomposer.compositionValuesAwaitingInsert.clear();
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x010f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0118  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0101 -> B:24:0x0109). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x010f -> B:12:0x00ac). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            MonotonicFrameClock monotonicFrameClock;
            MutableScatterSet mutableScatterSetMutableScatterSetOf;
            MutableScatterSet mutableScatterSetMutableScatterSetOf2;
            List list;
            Set set;
            final List list2;
            MutableScatterSet mutableScatterSet;
            List list3;
            MutableScatterSet mutableScatterSet2;
            final List list4;
            final MutableScatterSet mutableScatterSet3;
            final List list5;
            final MutableScatterSet mutableScatterSet4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                monotonicFrameClock = (MonotonicFrameClock) this.L$0;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
                MutableScatterSet mutableScatterSetMutableScatterSetOf3 = ScatterSetKt.mutableScatterSetOf();
                MutableScatterSet mutableScatterSet5 = new MutableScatterSet(0, i2, null);
                Set setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet5);
                mutableScatterSetMutableScatterSetOf2 = ScatterSetKt.mutableScatterSetOf();
                list = arrayList;
                set = setWrapIntoSet;
                list2 = arrayList2;
                mutableScatterSet = mutableScatterSet5;
                list3 = arrayList3;
                mutableScatterSet2 = mutableScatterSetMutableScatterSetOf3;
                if (!Recomposer.this.getShouldKeepRecomposing()) {
                }
            } else if (i == 1) {
                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) this.L$8;
                set = (Set) this.L$7;
                mutableScatterSet = (MutableScatterSet) this.L$6;
                mutableScatterSet2 = (MutableScatterSet) this.L$5;
                MutableScatterSet mutableScatterSet7 = (MutableScatterSet) this.L$4;
                List list6 = (List) this.L$3;
                list2 = (List) this.L$2;
                List list7 = (List) this.L$1;
                MonotonicFrameClock monotonicFrameClock2 = (MonotonicFrameClock) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableScatterSet4 = mutableScatterSet6;
                monotonicFrameClock = monotonicFrameClock2;
                list4 = list6;
                list5 = list7;
                mutableScatterSet3 = mutableScatterSet7;
                final Set set2 = set;
                final MutableScatterSet mutableScatterSet8 = mutableScatterSet2;
                final MutableScatterSet mutableScatterSet9 = mutableScatterSet;
                if (Recomposer.this.recordComposerModifications()) {
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MutableScatterSet mutableScatterSet10 = (MutableScatterSet) this.L$8;
                set = (Set) this.L$7;
                mutableScatterSet = (MutableScatterSet) this.L$6;
                mutableScatterSet2 = (MutableScatterSet) this.L$5;
                mutableScatterSetMutableScatterSetOf = (MutableScatterSet) this.L$4;
                list3 = (List) this.L$3;
                list2 = (List) this.L$2;
                list = (List) this.L$1;
                MonotonicFrameClock monotonicFrameClock3 = (MonotonicFrameClock) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableScatterSetMutableScatterSetOf2 = mutableScatterSet10;
                monotonicFrameClock = monotonicFrameClock3;
                Recomposer.this.discardUnusedValues();
                if (!Recomposer.this.getShouldKeepRecomposing()) {
                    Recomposer recomposer = Recomposer.this;
                    this.L$0 = monotonicFrameClock;
                    this.L$1 = list;
                    this.L$2 = list2;
                    this.L$3 = list3;
                    this.L$4 = mutableScatterSetMutableScatterSetOf;
                    this.L$5 = mutableScatterSet2;
                    this.L$6 = mutableScatterSet;
                    this.L$7 = set;
                    this.L$8 = mutableScatterSetMutableScatterSetOf2;
                    this.label = 1;
                    if (recomposer.awaitWorkAvailable(this) != coroutine_suspended) {
                        List list8 = list;
                        mutableScatterSet3 = mutableScatterSetMutableScatterSetOf;
                        mutableScatterSet4 = mutableScatterSetMutableScatterSetOf2;
                        list4 = list3;
                        list5 = list8;
                        final Set set22 = set;
                        final MutableScatterSet mutableScatterSet82 = mutableScatterSet2;
                        final MutableScatterSet mutableScatterSet92 = mutableScatterSet;
                        if (Recomposer.this.recordComposerModifications()) {
                            List list9 = list4;
                            mutableScatterSetMutableScatterSetOf2 = mutableScatterSet4;
                            mutableScatterSetMutableScatterSetOf = mutableScatterSet3;
                            list = list5;
                            list3 = list9;
                            mutableScatterSet = mutableScatterSet92;
                            mutableScatterSet2 = mutableScatterSet82;
                            set = set22;
                            if (!Recomposer.this.getShouldKeepRecomposing()) {
                            }
                        } else {
                            final Recomposer recomposer2 = Recomposer.this;
                            Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: androidx.compose.runtime.Recomposer.runRecomposeAndApplyChanges.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke(l.longValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:136:0x020a A[Catch: all -> 0x00e0, TryCatch #1 {all -> 0x00e0, blocks: (B:11:0x0049, B:12:0x0050, B:23:0x0082, B:24:0x0083, B:25:0x0089, B:27:0x0092, B:30:0x009d, B:32:0x00a6, B:44:0x00dc, B:58:0x00fe, B:59:0x0101, B:53:0x00f3, B:60:0x0102, B:85:0x0165, B:100:0x0190, B:124:0x01eb, B:136:0x020a, B:137:0x020e, B:139:0x0212, B:140:0x0213, B:142:0x0227, B:143:0x0228, B:134:0x0206, B:135:0x0209, B:131:0x01ff, B:94:0x0181, B:97:0x0188, B:98:0x018b, B:155:0x0253, B:157:0x025c, B:186:0x02ed, B:188:0x02f3, B:189:0x02f6, B:191:0x02ff, B:197:0x0319, B:161:0x026b, B:162:0x026f, B:185:0x02ec, B:198:0x0326, B:199:0x0327, B:206:0x033d, B:207:0x0340, B:204:0x0337, B:208:0x0341, B:209:0x0342, B:138:0x020f, B:144:0x0229, B:146:0x0230, B:148:0x023c, B:153:0x024d, B:102:0x0196, B:105:0x01a0, B:107:0x01ae, B:109:0x01ba, B:111:0x01c0, B:163:0x0270, B:165:0x027b, B:167:0x0287, B:169:0x028d, B:172:0x0297, B:173:0x029a, B:175:0x02a6, B:177:0x02b4, B:179:0x02ba, B:183:0x02d7, B:182:0x02c9, B:184:0x02dc, B:13:0x0051, B:15:0x005b, B:16:0x0060, B:22:0x0079, B:33:0x00b0, B:35:0x00b7, B:40:0x00c9, B:42:0x00d0), top: B:214:0x0049, inners: #3, #8, #9, #11, #14, #15, #16 }] */
                                /* JADX WARN: Removed duplicated region for block: B:222:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                /* JADX WARN: Removed duplicated region for block: B:226:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                /* JADX WARN: Removed duplicated region for block: B:231:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                                /* JADX WARN: Removed duplicated region for block: B:82:0x015c  */
                                /* JADX WARN: Removed duplicated region for block: B:99:0x018c  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke(long j) {
                                    Object objBeginSection;
                                    List<ControlledComposition> list10;
                                    Set<? extends Object> set3;
                                    Set<? extends Object> set4;
                                    MutableScatterSet<Object> mutableScatterSet11;
                                    long j2;
                                    char c;
                                    List<ControlledComposition> list11;
                                    if (recomposer2.getHasBroadcastFrameClockAwaiters()) {
                                        Recomposer recomposer3 = recomposer2;
                                        Trace trace = Trace.INSTANCE;
                                        objBeginSection = trace.beginSection("Recomposer:animation");
                                        try {
                                            recomposer3.broadcastFrameClock.sendFrame(j);
                                            Snapshot.INSTANCE.sendApplyNotifications();
                                            Unit unit = Unit.INSTANCE;
                                            trace.endSection(objBeginSection);
                                        } finally {
                                        }
                                    }
                                    Recomposer recomposer4 = recomposer2;
                                    MutableScatterSet<Object> mutableScatterSet12 = mutableScatterSet92;
                                    MutableScatterSet<ControlledComposition> mutableScatterSet13 = mutableScatterSet4;
                                    List<ControlledComposition> list12 = list5;
                                    List<MovableContentStateReference> list13 = list2;
                                    MutableScatterSet<ControlledComposition> mutableScatterSet14 = mutableScatterSet3;
                                    List<ControlledComposition> list14 = list4;
                                    MutableScatterSet<ControlledComposition> mutableScatterSet15 = mutableScatterSet82;
                                    Set<? extends Object> set5 = set22;
                                    objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                                    try {
                                        recomposer4.recordComposerModifications();
                                        synchronized (recomposer4.stateLock) {
                                            try {
                                                MutableVector mutableVector = recomposer4.compositionInvalidations;
                                                int size = mutableVector.getSize();
                                                if (size > 0) {
                                                    Object[] content = mutableVector.getContent();
                                                    int i4 = 0;
                                                    while (true) {
                                                        Object[] objArr = content;
                                                        list12.add((ControlledComposition) content[i4]);
                                                        i4++;
                                                        if (i4 >= size) {
                                                            break;
                                                        } else {
                                                            content = objArr;
                                                        }
                                                    }
                                                }
                                                recomposer4.compositionInvalidations.clear();
                                                Unit unit2 = Unit.INSTANCE;
                                            } finally {
                                            }
                                        }
                                        mutableScatterSet12.clear();
                                        mutableScatterSet13.clear();
                                        while (true) {
                                            if (list12.isEmpty() && list13.isEmpty()) {
                                                break;
                                            }
                                            try {
                                                try {
                                                    int size2 = list12.size();
                                                    for (int i5 = 0; i5 < size2; i5++) {
                                                        ControlledComposition controlledComposition = list12.get(i5);
                                                        ControlledComposition controlledCompositionPerformRecompose = recomposer4.performRecompose(controlledComposition, mutableScatterSet12);
                                                        if (controlledCompositionPerformRecompose != null) {
                                                            list14.add(controlledCompositionPerformRecompose);
                                                            Unit unit3 = Unit.INSTANCE;
                                                        }
                                                        mutableScatterSet13.add(controlledComposition);
                                                    }
                                                    list12.clear();
                                                    if (mutableScatterSet12.isNotEmpty() || recomposer4.compositionInvalidations.isNotEmpty()) {
                                                        synchronized (recomposer4.stateLock) {
                                                            try {
                                                                List knownCompositions = recomposer4.getKnownCompositions();
                                                                int size3 = knownCompositions.size();
                                                                for (int i6 = 0; i6 < size3; i6++) {
                                                                    ControlledComposition controlledComposition2 = (ControlledComposition) knownCompositions.get(i6);
                                                                    if (!mutableScatterSet13.contains(controlledComposition2) && controlledComposition2.observesAnyOf(set5)) {
                                                                        list12.add(controlledComposition2);
                                                                    }
                                                                }
                                                                MutableVector mutableVector2 = recomposer4.compositionInvalidations;
                                                                int size4 = mutableVector2.getSize();
                                                                int i7 = 0;
                                                                int i8 = 0;
                                                                while (i7 < size4) {
                                                                    ControlledComposition controlledComposition3 = (ControlledComposition) mutableVector2.getContent()[i7];
                                                                    if (mutableScatterSet13.contains(controlledComposition3) || list12.contains(controlledComposition3)) {
                                                                        set4 = set5;
                                                                        if (i8 > 0) {
                                                                            mutableVector2.getContent()[i7 - i8] = mutableVector2.getContent()[i7];
                                                                        }
                                                                    } else {
                                                                        set4 = set5;
                                                                        list12.add(controlledComposition3);
                                                                        i8++;
                                                                    }
                                                                    i7++;
                                                                    set5 = set4;
                                                                }
                                                                set3 = set5;
                                                                int i9 = size4 - i8;
                                                                ArraysKt___ArraysJvmKt.fill(mutableVector2.getContent(), (Object) null, i9, size4);
                                                                mutableVector2.setSize(i9);
                                                                Unit unit4 = Unit.INSTANCE;
                                                            } finally {
                                                            }
                                                        }
                                                    } else {
                                                        set3 = set5;
                                                    }
                                                    if (list12.isEmpty()) {
                                                        try {
                                                            C19582.invokeSuspend$fillToInsert(list13, recomposer4);
                                                            while (!list13.isEmpty()) {
                                                                mutableScatterSet14.plusAssign(recomposer4.performInsertValues(list13, mutableScatterSet12));
                                                                C19582.invokeSuspend$fillToInsert(list13, recomposer4);
                                                            }
                                                        } catch (Exception e) {
                                                            Recomposer.processCompositionError$default(recomposer4, e, null, true, 2, null);
                                                            C19582.invokeSuspend$clearRecompositionState(recomposer4, list12, list13, list14, mutableScatterSet14, mutableScatterSet15, mutableScatterSet12, mutableScatterSet13);
                                                        }
                                                    }
                                                    set5 = set3;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    list10 = list12;
                                                    list10.clear();
                                                    throw th;
                                                }
                                            } catch (Exception e2) {
                                                Recomposer.processCompositionError$default(recomposer4, e2, null, true, 2, null);
                                                list10 = list12;
                                                try {
                                                    C19582.invokeSuspend$clearRecompositionState(recomposer4, list10, list13, list14, mutableScatterSet14, mutableScatterSet15, mutableScatterSet12, mutableScatterSet13);
                                                    list10.clear();
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    list10.clear();
                                                    throw th;
                                                }
                                            }
                                        }
                                        if (list14.isEmpty()) {
                                            if (mutableScatterSet14.isNotEmpty()) {
                                            }
                                            if (mutableScatterSet15.isNotEmpty()) {
                                            }
                                        } else {
                                            recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                            try {
                                                try {
                                                    int size5 = list14.size();
                                                    for (int i10 = 0; i10 < size5; i10++) {
                                                        mutableScatterSet15.add(list14.get(i10));
                                                    }
                                                    int size6 = list14.size();
                                                    for (int i11 = 0; i11 < size6; i11++) {
                                                        list14.get(i11).applyChanges();
                                                    }
                                                    list14.clear();
                                                    if (mutableScatterSet14.isNotEmpty()) {
                                                        j2 = 255;
                                                        c = 7;
                                                    } else {
                                                        try {
                                                            try {
                                                                mutableScatterSet15.plusAssign(mutableScatterSet14);
                                                                Object[] objArr2 = mutableScatterSet14.elements;
                                                                long[] jArr = mutableScatterSet14.metadata;
                                                                j2 = 255;
                                                                int length = jArr.length - 2;
                                                                mutableScatterSet11 = mutableScatterSet12;
                                                                if (length >= 0) {
                                                                    int i12 = 0;
                                                                    c = 7;
                                                                    while (true) {
                                                                        try {
                                                                            long j3 = jArr[i12];
                                                                            long[] jArr2 = jArr;
                                                                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                int i13 = 8 - ((~(i12 - length)) >>> 31);
                                                                                for (int i14 = 0; i14 < i13; i14++) {
                                                                                    if ((j3 & 255) < 128) {
                                                                                        ((ControlledComposition) objArr2[(i12 << 3) + i14]).applyLateChanges();
                                                                                    }
                                                                                    j3 >>= 8;
                                                                                }
                                                                                if (i13 != 8) {
                                                                                    break;
                                                                                }
                                                                                if (i12 == length) {
                                                                                    break;
                                                                                }
                                                                                i12++;
                                                                                jArr = jArr2;
                                                                            }
                                                                        } catch (Exception e3) {
                                                                            e = e3;
                                                                            Recomposer.processCompositionError$default(recomposer4, e, null, false, 6, null);
                                                                            try {
                                                                                C19582.invokeSuspend$clearRecompositionState(recomposer4, list12, list13, list14, mutableScatterSet14, mutableScatterSet15, mutableScatterSet11, mutableScatterSet13);
                                                                                mutableScatterSet14.clear();
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                mutableScatterSet14 = mutableScatterSet14;
                                                                                mutableScatterSet14.clear();
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    c = 7;
                                                                }
                                                                mutableScatterSet14.clear();
                                                                mutableScatterSet12 = mutableScatterSet11;
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                mutableScatterSet11 = mutableScatterSet12;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            mutableScatterSet14.clear();
                                                            throw th;
                                                        }
                                                    }
                                                    if (mutableScatterSet15.isNotEmpty()) {
                                                        synchronized (recomposer4.stateLock) {
                                                        }
                                                    } else {
                                                        try {
                                                            try {
                                                                Object[] objArr3 = mutableScatterSet15.elements;
                                                                long[] jArr3 = mutableScatterSet15.metadata;
                                                                int length2 = jArr3.length - 2;
                                                                if (length2 >= 0) {
                                                                    int i15 = 0;
                                                                    while (true) {
                                                                        long j5 = jArr3[i15];
                                                                        Object[] objArr4 = objArr3;
                                                                        if ((((~j5) << c) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                            int i16 = 8 - ((~(i15 - length2)) >>> 31);
                                                                            for (int i17 = 0; i17 < i16; i17++) {
                                                                                if ((j5 & j2) < 128) {
                                                                                    ((ControlledComposition) objArr4[(i15 << 3) + i17]).changesApplied();
                                                                                }
                                                                                j5 >>= 8;
                                                                            }
                                                                            if (i16 != 8) {
                                                                                break;
                                                                            }
                                                                        }
                                                                        if (i15 == length2) {
                                                                            break;
                                                                        }
                                                                        i15++;
                                                                        objArr3 = objArr4;
                                                                    }
                                                                }
                                                                mutableScatterSet15.clear();
                                                                synchronized (recomposer4.stateLock) {
                                                                    recomposer4.deriveStateLocked();
                                                                }
                                                                Snapshot.INSTANCE.notifyObjectsInitialized();
                                                                mutableScatterSet13.clear();
                                                                mutableScatterSet12.clear();
                                                                recomposer4.compositionsRemoved = null;
                                                                Unit unit5 = Unit.INSTANCE;
                                                            } catch (Exception e6) {
                                                                Recomposer.processCompositionError$default(recomposer4, e6, null, false, 6, null);
                                                                try {
                                                                    C19582.invokeSuspend$clearRecompositionState(recomposer4, list12, list13, list14, mutableScatterSet14, mutableScatterSet15, mutableScatterSet12, mutableScatterSet13);
                                                                    mutableScatterSet15.clear();
                                                                } catch (Throwable th5) {
                                                                    th = th5;
                                                                    mutableScatterSet15 = mutableScatterSet15;
                                                                    mutableScatterSet15.clear();
                                                                    throw th;
                                                                }
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            mutableScatterSet15.clear();
                                                            throw th;
                                                        }
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    list11 = list14;
                                                    list11.clear();
                                                    throw th;
                                                }
                                            } catch (Exception e7) {
                                                Recomposer.processCompositionError$default(recomposer4, e7, null, false, 6, null);
                                                try {
                                                    C19582.invokeSuspend$clearRecompositionState(recomposer4, list12, list13, list14, mutableScatterSet14, mutableScatterSet15, mutableScatterSet12, mutableScatterSet13);
                                                    list14.clear();
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    list11 = list14;
                                                    list11.clear();
                                                    throw th;
                                                }
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            };
                            this.L$0 = monotonicFrameClock;
                            this.L$1 = list5;
                            this.L$2 = list2;
                            this.L$3 = list4;
                            this.L$4 = mutableScatterSet3;
                            this.L$5 = mutableScatterSet82;
                            this.L$6 = mutableScatterSet92;
                            this.L$7 = set22;
                            this.L$8 = mutableScatterSet4;
                            this.label = 2;
                            if (monotonicFrameClock.withFrameNanos(function1, this) != coroutine_suspended) {
                                List list10 = list4;
                                mutableScatterSetMutableScatterSetOf2 = mutableScatterSet4;
                                mutableScatterSetMutableScatterSetOf = mutableScatterSet3;
                                list = list5;
                                list3 = list10;
                                mutableScatterSet = mutableScatterSet92;
                                mutableScatterSet2 = mutableScatterSet82;
                                set = set22;
                                Recomposer.this.discardUnusedValues();
                                if (!Recomposer.this.getShouldKeepRecomposing()) {
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull MonotonicFrameClock monotonicFrameClock, @Nullable Continuation<? super Unit> continuation) {
            C19582 c19582 = Recomposer.this.new C19582(continuation);
            c19582.L$0 = monotonicFrameClock;
            return c19582.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", m14021f = "Recomposer.kt", m14022i = {0, 0, 0, 1}, m14023l = {890, SdlMediaRecorder.MEDIA_RECORDER_INFO_NO_NETWORK, SdlMediaRecorder.MEDIA_RECORDER_INFO_POOR_NETWORK}, m14024m = "invokeSuspend", m14025n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, m14026s = {"L$0", "L$1", "L$2", "L$0"})
    @SourceDebugExtension({"SMAP\nRecomposer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeConcurrentlyAndApplyChanges$2\n+ 2 Preconditions.kt\nandroidx/compose/runtime/PreconditionsKt\n+ 3 Recomposer.kt\nandroidx/compose/runtime/Recomposer\n+ 4 ActualJvm.jvm.kt\nandroidx/compose/runtime/ActualJvm_jvmKt\n+ 5 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 6 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,1646:1\n33#2,7:1647\n485#3:1654\n486#3,6:1656\n492#3,2:1666\n495#3:1669\n496#3,7:1682\n89#4:1655\n89#4:1677\n89#4:1689\n33#5,4:1662\n38#5:1668\n460#6,7:1670\n467#6,4:1678\n*S KotlinDebug\n*F\n+ 1 Recomposer.kt\nandroidx/compose/runtime/Recomposer$runRecomposeConcurrentlyAndApplyChanges$2\n*L\n880#1:1647,7\n893#1:1654\n893#1:1656,6\n893#1:1666,2\n893#1:1669\n893#1:1682,7\n893#1:1655\n894#1:1677\n906#1:1689\n893#1:1662,4\n893#1:1668\n893#1:1670,7\n893#1:1678,4\n*E\n"})
    public static final class C19592 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Recomposer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C19592(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super C19592> continuation) {
            super(3, continuation);
            this.$recomposeCoroutineContext = coroutineContext;
            this.this$0 = recomposer;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b9, code lost:
        
            if (r10.awaitWorkAvailable(r19) == r0) goto L87;
         */
        /* JADX WARN: Code restructure failed: missing block: B:86:0x01af, code lost:
        
            if (kotlinx.coroutines.JobKt.cancelAndJoin(r2, r19) != r0) goto L88;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0190  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b9 -> B:25:0x00bd). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Job jobLaunch$default;
            CoroutineScope coroutineScope;
            ProduceFrameSignal produceFrameSignal;
            MutableScatterSet mutableScatterSet;
            Continuation<Unit> continuationRequestFrameLocked;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            int i2 = 0;
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i4 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) this.L$1;
                CoroutineContext coroutineContext = this.$recomposeCoroutineContext;
                Job.Companion companion = Job.INSTANCE;
                boolean z = coroutineContext.get(companion) == null;
                CoroutineContext coroutineContext2 = this.$recomposeCoroutineContext;
                if (!z) {
                    PreconditionsKt.throwIllegalArgumentException("recomposeCoroutineContext may not contain a Job; found " + coroutineContext2.get(companion));
                }
                CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineScope2.getCoroutineContext().plus(this.$recomposeCoroutineContext).plus(JobKt.Job(JobKt.getJob(coroutineScope2.getCoroutineContext()))));
                ProduceFrameSignal produceFrameSignal2 = new ProduceFrameSignal();
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.this$0, monotonicFrameClock, produceFrameSignal2, null), 3, null);
                coroutineScope = CoroutineScope;
                produceFrameSignal = produceFrameSignal2;
                if (this.this$0.getShouldKeepRecomposing()) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                jobLaunch$default = (Job) this.L$2;
                produceFrameSignal = (ProduceFrameSignal) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Recomposer recomposer = this.this$0;
                synchronized (recomposer.stateLock) {
                    mutableScatterSet = recomposer.snapshotInvalidations;
                    if (mutableScatterSet.isNotEmpty()) {
                        recomposer.snapshotInvalidations = new MutableScatterSet(i2, i4, defaultConstructorMarker);
                    }
                }
                Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
                if (!setWrapIntoSet.isEmpty()) {
                    List knownCompositions = recomposer.getKnownCompositions();
                    int size = knownCompositions.size();
                    for (int i5 = i2; i5 < size; i5++) {
                        ((ControlledComposition) knownCompositions.get(i5)).recordModificationsOf(setWrapIntoSet);
                    }
                }
                MutableVector mutableVector = recomposer.compositionInvalidations;
                int size2 = mutableVector.getSize();
                if (size2 > 0) {
                    Object[] content = mutableVector.getContent();
                    int i6 = i2;
                    while (true) {
                        ControlledComposition controlledComposition = (ControlledComposition) content[i6];
                        synchronized (recomposer.stateLock) {
                            recomposer.concurrentCompositionsOutstanding++;
                        }
                        int i7 = size2;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, CompositionKt.getRecomposeCoroutineContext(controlledComposition), null, new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(recomposer, controlledComposition, null), 2, null);
                        int i8 = i6 + 1;
                        if (i8 >= i7) {
                            break;
                        }
                        size2 = i7;
                        i6 = i8;
                    }
                }
                recomposer.compositionInvalidations.clear();
                synchronized (recomposer.stateLock) {
                    if (recomposer.deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    Unit unit = Unit.INSTANCE;
                }
                Object obj2 = this.this$0.stateLock;
                Recomposer recomposer2 = this.this$0;
                synchronized (obj2) {
                    continuationRequestFrameLocked = recomposer2.getHasConcurrentFrameWorkLocked() ? produceFrameSignal.requestFrameLocked() : null;
                }
                if (continuationRequestFrameLocked != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    continuationRequestFrameLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                }
                i2 = 0;
                if (this.this$0.getShouldKeepRecomposing()) {
                    Job job = JobKt.getJob(coroutineScope.getCoroutineContext());
                    this.L$0 = jobLaunch$default;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    if (JobKt.cancelAndJoin(job, this) != coroutine_suspended) {
                        this.L$0 = null;
                        this.label = 3;
                    }
                } else {
                    Recomposer recomposer3 = this.this$0;
                    this.L$0 = coroutineScope;
                    this.L$1 = produceFrameSignal;
                    this.L$2 = jobLaunch$default;
                    this.label = 1;
                }
                return coroutine_suspended;
            }
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            jobLaunch$default = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 3;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull MonotonicFrameClock monotonicFrameClock, @Nullable Continuation<? super Unit> continuation) {
            C19592 c19592 = new C19592(this.$recomposeCoroutineContext, this.this$0, continuation);
            c19592.L$0 = coroutineScope;
            c19592.L$1 = monotonicFrameClock;
            return c19592.invokeSuspend(Unit.INSTANCE);
        }
    }

    public Recomposer(@NotNull CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation cancellableContinuationDeriveStateLocked;
                Object obj = this.this$0.stateLock;
                Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    cancellableContinuationDeriveStateLocked = recomposer.deriveStateLocked();
                    if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
                    }
                }
                if (cancellableContinuationDeriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuationDeriveStateLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        CompletableJob completableJobJob = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        completableJobJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable final Throwable th) {
                CancellableContinuation cancellableContinuation;
                CancellableContinuation cancellableContinuation2;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
                Object obj = this.this$0.stateLock;
                final Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    try {
                        Job job = recomposer.runnerJob;
                        cancellableContinuation = null;
                        if (job != null) {
                            recomposer._state.setValue(Recomposer.State.ShuttingDown);
                            if (recomposer.isClosed) {
                                if (recomposer.workContinuation != null) {
                                    cancellableContinuation2 = recomposer.workContinuation;
                                }
                                recomposer.workContinuation = null;
                                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                        invoke2(th2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(@Nullable Throwable th2) {
                                        Object obj2 = recomposer.stateLock;
                                        Recomposer recomposer2 = recomposer;
                                        Throwable th3 = th;
                                        synchronized (obj2) {
                                            if (th3 == null) {
                                                th3 = null;
                                            } else if (th2 != null) {
                                                try {
                                                    if (th2 instanceof CancellationException) {
                                                        th2 = null;
                                                    }
                                                    if (th2 != null) {
                                                        kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                    }
                                                } catch (Throwable th4) {
                                                    throw th4;
                                                }
                                            }
                                            recomposer2.closeCause = th3;
                                            recomposer2._state.setValue(Recomposer.State.ShutDown);
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                });
                                cancellableContinuation = cancellableContinuation2;
                            } else {
                                job.cancel(CancellationException);
                            }
                            cancellableContinuation2 = null;
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                    invoke2(th2);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@Nullable Throwable th2) {
                                    Object obj2 = recomposer.stateLock;
                                    Recomposer recomposer2 = recomposer;
                                    Throwable th3 = th;
                                    synchronized (obj2) {
                                        if (th3 == null) {
                                            th3 = null;
                                        } else if (th2 != null) {
                                            try {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        recomposer2.closeCause = th3;
                                        recomposer2._state.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            });
                            cancellableContinuation = cancellableContinuation2;
                        } else {
                            recomposer.closeCause = CancellationException;
                            recomposer._state.setValue(Recomposer.State.ShutDown);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = completableJobJob;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(completableJobJob);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            snapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl2.initCancellability();
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                this.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl = null;
            }
        }
        if (cancellableContinuationImpl != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    private final <T> T composing(ControlledComposition composition, MutableScatterSet<Object> modifiedValues, Function0<? extends T> block) {
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            try {
                return block.invoke();
            } finally {
                InlineMarker.finallyStart(1);
                mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                InlineMarker.finallyEnd(1);
            }
        } finally {
            InlineMarker.finallyStart(1);
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        int i = 0;
        int i2 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) ? State.PendingWork : State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i;
        List listEmptyList;
        synchronized (this.stateLock) {
            try {
                if (this.compositionValuesRemoved.isEmpty()) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    List listFlatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                    this.compositionValuesRemoved.clear();
                    listEmptyList = new ArrayList(listFlatten.size());
                    int size = listFlatten.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) listFlatten.get(i2);
                        listEmptyList.add(TuplesKt.m13893to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                    }
                    this.compositionValueStatesAvailable.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size2 = listEmptyList.size();
        for (i = 0; i < size2; i++) {
            Pair pair = (Pair) listEmptyList.get(i);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return !this.compositionsAwaitingApply.isEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getHasSchedulingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.isNotEmpty()) {
                z = true;
            } else if (!getHasBroadcastFrameClockAwaitersLocked()) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<ControlledComposition> getKnownCompositions() {
        List list = this._knownCompositionsCache;
        List list2 = list;
        if (list == null) {
            List<ControlledComposition> list3 = this._knownCompositions;
            List listEmptyList = list3.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list3);
            this._knownCompositionsCache = listEmptyList;
            list2 = listEmptyList;
        }
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z;
        synchronized (this.stateLock) {
            z = this.isClosed;
        }
        if (!z) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().isActive()) {
                return true;
            }
        }
        return false;
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (Intrinsics.areEqual(list.get(i).getComposition(), composition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            try {
                Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
                while (it.hasNext()) {
                    MovableContentStateReference next = it.next();
                    if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                        list.add(next);
                        it.remove();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b4, code lost:
    
        r1 = r7.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
    
        if (r6 >= r1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c5, code lost:
    
        if (((kotlin.Pair) r7.get(r6)).getSecond() == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c7, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ca, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d8, code lost:
    
        if (r8 >= r6) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00da, code lost:
    
        r9 = (kotlin.Pair) r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e4, code lost:
    
        if (r9.getSecond() != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
    
        r9 = (androidx.compose.runtime.MovableContentStateReference) r9.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ef, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f0, code lost:
    
        if (r9 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f2, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f5, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f8, code lost:
    
        r6 = r13.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
    
        monitor-enter(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fb, code lost:
    
        kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r13.compositionValuesAwaitingInsert, r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0104, code lost:
    
        monitor-exit(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0105, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0113, code lost:
    
        if (r8 >= r6) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0115, code lost:
    
        r9 = r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0120, code lost:
    
        if (((kotlin.Pair) r9).getSecond() == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0122, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0125, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> references, MutableScatterSet<Object> modifiedValues) {
        ArrayList arrayList;
        HashMap map = new HashMap(references.size());
        int size = references.size();
        for (int i = 0; i < size; i++) {
            MovableContentStateReference movableContentStateReference = references.get(i);
            ControlledComposition composition = movableContentStateReference.getComposition();
            Object arrayList2 = map.get(composition);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(composition, arrayList2);
            }
            ((ArrayList) arrayList2).add(movableContentStateReference);
        }
        for (Map.Entry entry : map.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, modifiedValues));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list.size());
                        int size2 = list.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list.get(i2);
                            arrayList.add(TuplesKt.m13893to(movableContentStateReference2, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, movableContentStateReference2.getContent$runtime_release())));
                        }
                    }
                    int size3 = arrayList.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        }
                        if (((Pair) arrayList.get(i4)).getSecond() != null) {
                            break;
                        }
                        i4++;
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    Unit unit = Unit.INSTANCE;
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } finally {
                applyAndCheck(mutableSnapshotTakeMutableSnapshot);
            }
        }
        return CollectionsKt.toList(map.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        Set<ControlledComposition> set;
        if (composition.isComposing() || composition.getDisposed() || ((set = this.compositionsRemoved) != null && set.contains(composition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotTakeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                                ControlledComposition controlledComposition = composition;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    return;
                                }
                                int i = 0;
                                while (true) {
                                    long j = jArr[i];
                                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i2 = 8 - ((~(i - length)) >>> 31);
                                        for (int i4 = 0; i4 < i2; i4++) {
                                            if ((255 & j) < 128) {
                                                controlledComposition.recordWriteOf(objArr[(i << 3) + i4]);
                                            }
                                            j >>= 8;
                                        }
                                        if (i2 != 8) {
                                            return;
                                        }
                                    }
                                    if (i == length) {
                                        return;
                                    } else {
                                        i++;
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            }
            boolean zRecompose = composition.recompose();
            mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
            if (zRecompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
        }
    }

    private final void processCompositionError(Exception e, ControlledComposition failedInitialComposition, boolean recoverable) throws Exception {
        int i = 0;
        if (!_hotReloadEnabled.get().booleanValue() || (e instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.getCause();
                }
                this.errorState = new RecomposerErrorState(false, e);
                Unit unit = Unit.INSTANCE;
            }
            throw e;
        }
        synchronized (this.stateLock) {
            try {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(i, 1, null);
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z, int i, Object obj) throws Exception {
        if ((i & 2) != 0) {
            controlledComposition = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z);
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.readObserverOf.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object obj) {
                composition.recordReadOf(obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.broadcastFrameClock, new C19552(function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List<ControlledComposition> knownCompositions;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i = 1;
            int i2 = 0;
            this.snapshotInvalidations = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
            synchronized (this.stateLock) {
                knownCompositions = getKnownCompositions();
            }
            try {
                int size = knownCompositions.size();
                for (int i4 = 0; i4 < size; i4++) {
                    knownCompositions.get(i4).recordModificationsOf(setWrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    this.snapshotInvalidations = new MutableScatterSet<>(i2, i, defaultConstructorMarker);
                    Unit unit = Unit.INSTANCE;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(setWrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        List arrayList = this.failedCompositions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.failedCompositions = arrayList;
        }
        if (!arrayList.contains(composition)) {
            arrayList.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.remove(composition);
        this._knownCompositionsCache = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retryFailedCompositions() {
        List<ControlledComposition> list;
        int i;
        synchronized (this.stateLock) {
            list = this.failedCompositions;
            this.failedCompositions = null;
        }
        if (list == null) {
            return;
        }
        while (true) {
            i = 0;
            try {
                if (list.isEmpty()) {
                    break;
                }
                ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt.removeLast(list);
                if (controlledComposition instanceof CompositionImpl) {
                    controlledComposition.invalidateAll();
                    controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                    if (this.errorState != null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (!list.isEmpty()) {
                    synchronized (this.stateLock) {
                        try {
                            int size = list.size();
                            while (i < size) {
                                recordFailedCompositionLocked(list.get(i));
                                i++;
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                throw th;
            }
        }
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.stateLock) {
            try {
                int size2 = list.size();
                while (i < size2) {
                    recordFailedCompositionLocked(list.get(i));
                    i++;
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r5.withFrameNanos(r10, r0) != r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a2 -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object runFrameLoop(MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, Continuation<? super Unit> continuation) {
        C19561 c19561;
        List arrayList;
        List arrayList2;
        Recomposer recomposer;
        final List list;
        final List list2;
        Recomposer recomposer2;
        MonotonicFrameClock monotonicFrameClock2;
        final ProduceFrameSignal produceFrameSignal2;
        Object obj;
        if (continuation instanceof C19561) {
            c19561 = (C19561) continuation;
            int i = c19561.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c19561.label = i - Integer.MIN_VALUE;
            } else {
                c19561 = new C19561(continuation);
            }
        }
        Object obj2 = c19561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c19561.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            recomposer = this;
            obj = recomposer.stateLock;
            c19561.L$0 = recomposer;
            c19561.L$1 = monotonicFrameClock;
            c19561.L$2 = produceFrameSignal;
            c19561.L$3 = arrayList;
            c19561.L$4 = arrayList2;
            c19561.label = 1;
            if (produceFrameSignal.awaitFrameRequest(obj, c19561) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list2 = (List) c19561.L$4;
            list = (List) c19561.L$3;
            produceFrameSignal2 = (ProduceFrameSignal) c19561.L$2;
            monotonicFrameClock2 = (MonotonicFrameClock) c19561.L$1;
            recomposer2 = (Recomposer) c19561.L$0;
            ResultKt.throwOnFailure(obj2);
            arrayList = list;
            produceFrameSignal = produceFrameSignal2;
            arrayList2 = list2;
            monotonicFrameClock = monotonicFrameClock2;
            recomposer = recomposer2;
            obj = recomposer.stateLock;
            c19561.L$0 = recomposer;
            c19561.L$1 = monotonicFrameClock;
            c19561.L$2 = produceFrameSignal;
            c19561.L$3 = arrayList;
            c19561.L$4 = arrayList2;
            c19561.label = 1;
            if (produceFrameSignal.awaitFrameRequest(obj, c19561) != coroutine_suspended) {
                recomposer2 = recomposer;
                monotonicFrameClock2 = monotonicFrameClock;
                list2 = arrayList2;
                produceFrameSignal2 = produceFrameSignal;
                list = arrayList;
                Function1<Long, CancellableContinuation<? super Unit>> function1 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer.runFrameLoop.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l) {
                        return invoke(l.longValue());
                    }

                    @Nullable
                    public final CancellableContinuation<Unit> invoke(long j) {
                        Object objBeginSection;
                        int i4;
                        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
                        if (Recomposer.this.getHasBroadcastFrameClockAwaiters()) {
                            Recomposer recomposer3 = Recomposer.this;
                            Trace trace = Trace.INSTANCE;
                            objBeginSection = trace.beginSection("Recomposer:animation");
                            try {
                                recomposer3.broadcastFrameClock.sendFrame(j);
                                Snapshot.INSTANCE.sendApplyNotifications();
                                Unit unit = Unit.INSTANCE;
                                trace.endSection(objBeginSection);
                            } finally {
                            }
                        }
                        Recomposer recomposer4 = Recomposer.this;
                        List<ControlledComposition> list3 = list;
                        List<ControlledComposition> list4 = list2;
                        ProduceFrameSignal produceFrameSignal3 = produceFrameSignal2;
                        objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                        try {
                            recomposer4.recordComposerModifications();
                            synchronized (recomposer4.stateLock) {
                                try {
                                    List list5 = recomposer4.compositionsAwaitingApply;
                                    int size = list5.size();
                                    i4 = 0;
                                    for (int i5 = 0; i5 < size; i5++) {
                                        list4.add((ControlledComposition) list5.get(i5));
                                    }
                                    recomposer4.compositionsAwaitingApply.clear();
                                    MutableVector mutableVector = recomposer4.compositionInvalidations;
                                    int size2 = mutableVector.getSize();
                                    if (size2 > 0) {
                                        Object[] content = mutableVector.getContent();
                                        int i6 = 0;
                                        do {
                                            list3.add((ControlledComposition) content[i6]);
                                            i6++;
                                        } while (i6 < size2);
                                    }
                                    recomposer4.compositionInvalidations.clear();
                                    produceFrameSignal3.takeFrameRequestLocked();
                                    Unit unit2 = Unit.INSTANCE;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            MutableScatterSet mutableScatterSet = new MutableScatterSet(i4, 1, null);
                            try {
                                int size3 = list3.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    ControlledComposition controlledCompositionPerformRecompose = recomposer4.performRecompose(list3.get(i7), mutableScatterSet);
                                    if (controlledCompositionPerformRecompose != null) {
                                        list4.add(controlledCompositionPerformRecompose);
                                    }
                                }
                                list3.clear();
                                if (!list4.isEmpty()) {
                                    recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                                }
                                try {
                                    int size4 = list4.size();
                                    while (i4 < size4) {
                                        list4.get(i4).applyChanges();
                                        i4++;
                                    }
                                    list4.clear();
                                    synchronized (recomposer4.stateLock) {
                                        cancellableContinuationDeriveStateLocked = recomposer4.deriveStateLocked();
                                    }
                                    return cancellableContinuationDeriveStateLocked;
                                } catch (Throwable th2) {
                                    list4.clear();
                                    throw th2;
                                }
                            } catch (Throwable th3) {
                                list3.clear();
                                throw th3;
                            }
                        } finally {
                        }
                    }
                };
                c19561.L$0 = recomposer2;
                c19561.L$1 = monotonicFrameClock2;
                c19561.L$2 = produceFrameSignal2;
                c19561.L$3 = list;
                c19561.L$4 = list2;
                c19561.label = 2;
            }
            return coroutine_suspended;
        }
        list2 = (List) c19561.L$4;
        list = (List) c19561.L$3;
        produceFrameSignal2 = (ProduceFrameSignal) c19561.L$2;
        monotonicFrameClock2 = (MonotonicFrameClock) c19561.L$1;
        recomposer2 = (Recomposer) c19561.L$0;
        ResultKt.throwOnFailure(obj2);
        Function1<Long, CancellableContinuation<? super Unit>> function12 = new Function1<Long, CancellableContinuation<? super Unit>>() { // from class: androidx.compose.runtime.Recomposer.runFrameLoop.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CancellableContinuation<? super Unit> invoke(Long l) {
                return invoke(l.longValue());
            }

            @Nullable
            public final CancellableContinuation<Unit> invoke(long j) {
                Object objBeginSection;
                int i4;
                CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
                if (Recomposer.this.getHasBroadcastFrameClockAwaiters()) {
                    Recomposer recomposer3 = Recomposer.this;
                    Trace trace = Trace.INSTANCE;
                    objBeginSection = trace.beginSection("Recomposer:animation");
                    try {
                        recomposer3.broadcastFrameClock.sendFrame(j);
                        Snapshot.INSTANCE.sendApplyNotifications();
                        Unit unit = Unit.INSTANCE;
                        trace.endSection(objBeginSection);
                    } finally {
                    }
                }
                Recomposer recomposer4 = Recomposer.this;
                List<ControlledComposition> list3 = list;
                List<ControlledComposition> list4 = list2;
                ProduceFrameSignal produceFrameSignal3 = produceFrameSignal2;
                objBeginSection = Trace.INSTANCE.beginSection("Recomposer:recompose");
                try {
                    recomposer4.recordComposerModifications();
                    synchronized (recomposer4.stateLock) {
                        try {
                            List list5 = recomposer4.compositionsAwaitingApply;
                            int size = list5.size();
                            i4 = 0;
                            for (int i5 = 0; i5 < size; i5++) {
                                list4.add((ControlledComposition) list5.get(i5));
                            }
                            recomposer4.compositionsAwaitingApply.clear();
                            MutableVector mutableVector = recomposer4.compositionInvalidations;
                            int size2 = mutableVector.getSize();
                            if (size2 > 0) {
                                Object[] content = mutableVector.getContent();
                                int i6 = 0;
                                do {
                                    list3.add((ControlledComposition) content[i6]);
                                    i6++;
                                } while (i6 < size2);
                            }
                            recomposer4.compositionInvalidations.clear();
                            produceFrameSignal3.takeFrameRequestLocked();
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    MutableScatterSet mutableScatterSet = new MutableScatterSet(i4, 1, null);
                    try {
                        int size3 = list3.size();
                        for (int i7 = 0; i7 < size3; i7++) {
                            ControlledComposition controlledCompositionPerformRecompose = recomposer4.performRecompose(list3.get(i7), mutableScatterSet);
                            if (controlledCompositionPerformRecompose != null) {
                                list4.add(controlledCompositionPerformRecompose);
                            }
                        }
                        list3.clear();
                        if (!list4.isEmpty()) {
                            recomposer4.changeCount = recomposer4.getChangeCount() + 1;
                        }
                        try {
                            int size4 = list4.size();
                            while (i4 < size4) {
                                list4.get(i4).applyChanges();
                                i4++;
                            }
                            list4.clear();
                            synchronized (recomposer4.stateLock) {
                                cancellableContinuationDeriveStateLocked = recomposer4.deriveStateLocked();
                            }
                            return cancellableContinuationDeriveStateLocked;
                        } catch (Throwable th2) {
                            list4.clear();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        list3.clear();
                        throw th3;
                    }
                } finally {
                }
            }
        };
        c19561.L$0 = recomposer2;
        c19561.L$1 = monotonicFrameClock2;
        c19561.L$2 = produceFrameSignal2;
        c19561.L$3 = list;
        c19561.L$4 = list2;
        c19561.label = 2;
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer.writeObserverOf.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object obj) {
                composition.recordWriteOf(obj);
                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(obj);
                }
            }
        };
    }

    @NotNull
    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    @Nullable
    public final Object awaitIdle(@NotNull Continuation<? super Unit> continuation) {
        Object objCollect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new C19522(null)), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            try {
                if (this._state.getValue().compareTo(State.Idle) >= 0) {
                    this._state.setValue(State.ShuttingDown);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime_release(@NotNull ControlledComposition composition, @NotNull Function2<? super Composer, ? super Integer, Unit> content) throws Exception {
        Throwable th;
        boolean zIsComposing = composition.isComposing();
        try {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            MutableSnapshot mutableSnapshotTakeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                    if (!zIsComposing) {
                        companion.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        try {
                            if (this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                                try {
                                    if (!getKnownCompositions().contains(composition)) {
                                        addKnownCompositionLocked(composition);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            try {
                                performInitialMovableContentInserts(composition);
                                try {
                                    composition.applyChanges();
                                    composition.applyLateChanges();
                                    if (zIsComposing) {
                                        return;
                                    }
                                    companion.notifyObjectsInitialized();
                                } catch (Exception e) {
                                    processCompositionError$default(this, e, null, false, 6, null);
                                }
                            } catch (Exception e2) {
                                processCompositionError(e2, composition, true);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        mutableSnapshotTakeMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                        throw th4;
                    } catch (Throwable th5) {
                        th = th5;
                        Throwable th6 = th;
                        try {
                            applyAndCheck(mutableSnapshotTakeMutableSnapshot);
                            throw th6;
                        } catch (Exception e3) {
                            e = e3;
                            processCompositionError(e, composition, true);
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, reference.getContent$runtime_release(), reference);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @NotNull
    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    @NotNull
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean getHasPendingWork() {
        boolean z;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isNotEmpty() || this.compositionInvalidations.isNotEmpty() || this.concurrentCompositionsOutstanding > 0 || !this.compositionsAwaitingApply.isEmpty()) {
                z = true;
            } else if (!getHasBroadcastFrameClockAwaitersLocked()) {
                z = false;
            }
        }
        return z;
    }

    @Override // androidx.compose.runtime.CompositionContext
    @NotNull
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @NotNull
    public final Flow<State> getState() {
        return getCurrentState();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference reference) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(@NotNull ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuationDeriveStateLocked = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl scope) {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(scope);
            cancellableContinuationDeriveStateLocked = deriveStateLocked();
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
    }

    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        Object objFirst = FlowKt.first(getCurrentState(), new C19532(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference reference, @NotNull MovableContentState data) {
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(reference, data);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    @Nullable
    public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference reference) {
        MovableContentState movableContentStateRemove;
        synchronized (this.stateLock) {
            movableContentStateRemove = this.compositionValueStatesAvailable.remove(reference);
        }
        return movableContentStateRemove;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(@NotNull ControlledComposition composition) {
        synchronized (this.stateLock) {
            try {
                Set linkedHashSet = this.compositionsRemoved;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.compositionsRemoved = linkedHashSet;
                }
                linkedHashSet.add(composition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuationDeriveStateLocked;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuationDeriveStateLocked = deriveStateLocked();
            } else {
                cancellableContinuationDeriveStateLocked = null;
            }
        }
        if (cancellableContinuationDeriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationDeriveStateLocked.resumeWith(Result.m22215constructorimpl(Unit.INSTANCE));
        }
    }

    @Nullable
    public final Object runRecomposeAndApplyChanges(@NotNull Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C19582(null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    @ExperimentalComposeApi
    @Nullable
    public final Object runRecomposeConcurrentlyAndApplyChanges(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super Unit> continuation) {
        Object objRecompositionRunner = recompositionRunner(new C19592(coroutineContext, this, null), continuation);
        return objRecompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRecompositionRunner : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(@NotNull ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void registerComposition$runtime_release(@NotNull ControlledComposition composition) {
    }

    private final void recordComposerModifications(Function1<? super ControlledComposition, Unit> onEachInvalidComposition) {
        MutableScatterSet mutableScatterSet;
        int i;
        synchronized (this.stateLock) {
            int i2 = 1;
            try {
                mutableScatterSet = this.snapshotInvalidations;
                i = 0;
                if (mutableScatterSet.isNotEmpty()) {
                    this.snapshotInvalidations = new MutableScatterSet(i, i2, null);
                }
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        Set<? extends Object> setWrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(mutableScatterSet);
        if (!setWrapIntoSet.isEmpty()) {
            List knownCompositions = getKnownCompositions();
            int size = knownCompositions.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((ControlledComposition) knownCompositions.get(i4)).recordModificationsOf(setWrapIntoSet);
            }
        }
        MutableVector mutableVector = this.compositionInvalidations;
        int size2 = mutableVector.getSize();
        if (size2 > 0) {
            Object[] content = mutableVector.getContent();
            do {
                onEachInvalidComposition.invoke(content[i]);
                i++;
            } while (i < size2);
        }
        this.compositionInvalidations.clear();
        synchronized (this.stateLock) {
            try {
                if (deriveStateLocked() == null) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } else {
                    throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                }
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
    }
}
