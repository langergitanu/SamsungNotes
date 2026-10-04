package kotlinx.coroutines.selects;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001IB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001b\u001a\u00028\u0000H\u0091@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010\u001cJ0\u0010\u001e\u001a\u00020\u001f*\u00020 2\u001c\u0010!\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0096\u0002¢\u0006\u0002\u0010$JB\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0001\u0010%*\b\u0012\u0004\u0012\u0002H%0&2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0'H\u0096\u0002¢\u0006\u0002\u0010(JV\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u0010%*\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H%0*2\u0006\u0010+\u001a\u0002H)2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0'H\u0096\u0002¢\u0006\u0002\u0010,J \u0010-\u001a\u00020\u001f*\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010.\u001a\u00020\u000fH\u0001J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0016J\u001c\u00104\u001a\u00020\u001f2\n\u00105\u001a\u0006\u0012\u0002\b\u0003062\u0006\u00107\u001a\u00020\u0019H\u0016J\u0012\u00108\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u00109\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\rH\u0002J\u001a\u0010;\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010=\u001a\u00020>2\u0006\u00100\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010\rJ\u001a\u0010?\u001a\u00020\u00192\u0006\u00100\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010@\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001a\u00020\rH\u0002J\u000e\u0010A\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010\u001cJ*\u0010B\u001a\u00028\u00002\u0010\u0010C\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010DJ\u001a\u0010E\u001a\u00020\u001f2\u0010\u0010F\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001a\u0014\u0012\u000e\u0012\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "state", "Lkotlinx/atomicfu/AtomicRef;", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "isSelected", "isCancelled", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "disposableHandleOrSegment", "indexInSegment", "", "internalResult", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSelectSuspend", "invoke", "", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "checkClauseObject", "clauseObject", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "selectInRegistrationPhase", "waitUntilSelected", "reregisterClause", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "findClause", "complete", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "selectedClause", "cause", "", "ClauseData", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,904:1\n1#2:905\n2632#3,3:906\n1863#3,2:918\n1863#3,2:926\n1863#3,2:928\n351#4,9:909\n360#4,2:920\n149#5,4:922\n*S KotlinDebug\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation\n*L\n529#1:906,3\n593#1:918,2\n749#1:926,2\n774#1:928,2\n569#1:909,9\n569#1:920,2\n734#1:922,4\n*E\n"})
public class SelectImplementation<R> implements CancelHandler, SelectBuilder<R>, SelectInstanceInternal<R> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");

    @NotNull
    private final CoroutineContext context;

    @Nullable
    private Object disposableHandleOrSegment;
    private volatile /* synthetic */ Object state$volatile = SelectKt.STATE_REG;

    @Nullable
    private List<SelectImplementation<R>.ClauseData> clauses = new ArrayList(2);
    private int indexInSegment = -1;

    @Nullable
    private Object internalResult = SelectKt.NO_RESULT;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001BÆ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012U\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\u0004\u0012U\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005j\u0002`\r\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012u\u0010\u0010\u001aq\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u0005\u0018\u00010\u0005j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010 \u001a\u00028\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u000bJ8\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R_\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R_\u0010\f\u001aQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005j\u0002`\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0081\u0001\u0010\u0010\u001aq\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\u0005\u0018\u00010\u0005j\u0004\u0018\u0001`\u00118\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlinx/coroutines/selects/RegistrationFunction;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", Bixby2Constants.BIXBY_PARAM_SELECT, "param", "", "processResFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "clauseResult", "block", "onCancellationConstructor", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "disposableHandleOrSegment", "indexInSegment", "", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "processResult", "result", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "createOnCancellationAction", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nkotlinx/coroutines/selects/SelectImplementation$ClauseData\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,904:1\n1#2:905\n*E\n"})
    public final class ClauseData {

        @NotNull
        private final Object block;

        @JvmField
        @NotNull
        public final Object clauseObject;

        @JvmField
        @Nullable
        public Object disposableHandleOrSegment;

        @JvmField
        public int indexInSegment = -1;

        @JvmField
        @Nullable
        public final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> onCancellationConstructor;

        @Nullable
        private final Object param;

        @NotNull
        private final Function3<Object, Object, Object, Object> processResFunc;

        @NotNull
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

        /* JADX WARN: Multi-variable type inference failed */
        public ClauseData(@NotNull Object obj, @NotNull Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, @NotNull Function3<Object, Object, Object, ? extends Object> function32, @Nullable Object obj2, @NotNull Object obj3, @Nullable Function3<? super SelectInstance<?>, Object, Object, ? extends Function3<? super Throwable, Object, ? super CoroutineContext, Unit>> function33) {
            this.clauseObject = obj;
            this.regFunc = function3;
            this.processResFunc = function32;
            this.param = obj2;
            this.block = obj3;
            this.onCancellationConstructor = function33;
        }

        @Nullable
        public final Function3<Throwable, Object, CoroutineContext, Unit> createOnCancellationAction(@NotNull SelectInstance<?> select, @Nullable Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> function3 = this.onCancellationConstructor;
            if (function3 != null) {
                return function3.invoke(select, this.param, internalResult);
            }
            return null;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        @Nullable
        public final Object invokeBlock(@Nullable Object obj, @NotNull Continuation<? super R> continuation) {
            Object obj2 = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(continuation);
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, continuation);
        }

        @Nullable
        public final Object processResult(@Nullable Object result) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result);
        }

        public final boolean tryRegisterAsWaiter(@NotNull SelectImplementation<R> select) {
            this.regFunc.invoke(this.clauseObject, select, this.param);
            return ((SelectImplementation) select).internalResult == SelectKt.NO_RESULT;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.selects.SelectImplementation", m14021f = "Select.kt", m14022i = {0}, m14023l = {453, 456}, m14024m = "doSelectSuspend", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C134641 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SelectImplementation<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C134641(SelectImplementation<R> selectImplementation, Continuation<? super C134641> continuation) {
            super(continuation);
            this.this$0 = selectImplementation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.doSelectSuspend(this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlinx.coroutines.selects.SelectImplementation", m14021f = "Select.kt", m14022i = {}, m14023l = {729}, m14024m = "processResultAndInvokeBlockRecoveringException", m14025n = {}, m14026s = {})
    public static final class C134651 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SelectImplementation<R> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C134651(SelectImplementation<R> selectImplementation, Continuation<? super C134651> continuation) {
            super(continuation);
            this.this$0 = selectImplementation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.processResultAndInvokeBlockRecoveringException(null, null, this);
        }
    }

    public SelectImplementation(@NotNull CoroutineContext coroutineContext) {
        this.context = coroutineContext;
    }

    private final void checkClauseObject(Object clauseObject) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Intrinsics.checkNotNull(list);
        List<SelectImplementation<R>.ClauseData> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((ClauseData) it.next()).clauseObject == clauseObject) {
                throw new IllegalStateException(AbstractC0541b.m769k(clauseObject, "Cannot use select clauses on the same object: ").toString());
            }
        }
    }

    private final void cleanup(SelectImplementation<R>.ClauseData selectedClause) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.ClauseData clauseData : list) {
            if (clauseData != selectedClause) {
                clauseData.dispose();
            }
        }
        state$volatile$FU.set(this, SelectKt.STATE_COMPLETED);
        this.internalResult = SelectKt.NO_RESULT;
        this.clauses = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object complete(Continuation<? super R> continuation) {
        Object obj = state$volatile$FU.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.internalResult;
        cleanup(clauseData);
        return clauseData.invokeBlock(clauseData.processResult(obj2), continuation);
    }

    @PublishedApi
    public static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> selectImplementation, Continuation<? super R> continuation) {
        return selectImplementation.isSelected() ? selectImplementation.complete(continuation) : selectImplementation.doSelectSuspend(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doSelectSuspend(Continuation<? super R> continuation) {
        C134641 c134641;
        SelectImplementation selectImplementation;
        if (continuation instanceof C134641) {
            c134641 = (C134641) continuation;
            int i = c134641.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c134641.label = i - Integer.MIN_VALUE;
            } else {
                c134641 = new C134641(this, continuation);
            }
        }
        Object obj = c134641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c134641.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c134641.L$0 = this;
            c134641.label = 1;
            if (waitUntilSelected(c134641) != coroutine_suspended) {
                selectImplementation = this;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        SelectImplementation selectImplementation2 = (SelectImplementation) c134641.L$0;
        ResultKt.throwOnFailure(obj);
        selectImplementation = selectImplementation2;
        c134641.L$0 = null;
        c134641.label = 2;
        Object objComplete = selectImplementation.complete(c134641);
        return objComplete == coroutine_suspended ? coroutine_suspended : objComplete;
    }

    private final SelectImplementation<R>.ClauseData findClause(Object clauseObject) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).clauseObject == clauseObject) {
                obj = next;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getInRegistrationPhase() {
        Object obj = state$volatile$FU.get(this);
        return obj == SelectKt.STATE_REG || (obj instanceof List);
    }

    private final /* synthetic */ Object getState$volatile() {
        return this.state$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCancelled() {
        return state$volatile$FU.get(this) == SelectKt.STATE_CANCELLED;
    }

    private final boolean isSelected() {
        return state$volatile$FU.get(this) instanceof ClauseData;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processResultAndInvokeBlockRecoveringException(SelectImplementation<R>.ClauseData clauseData, Object obj, Continuation<? super R> continuation) {
        C134651 c134651;
        if (continuation instanceof C134651) {
            c134651 = (C134651) continuation;
            int i = c134651.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c134651.label = i - Integer.MIN_VALUE;
            } else {
                c134651 = new C134651(this, continuation);
            }
        }
        Object obj2 = c134651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c134651.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj2);
            return obj2;
        }
        ResultKt.throwOnFailure(obj2);
        Object objProcessResult = clauseData.processResult(obj);
        c134651.label = 1;
        Object objInvokeBlock = clauseData.invokeBlock(objProcessResult, c134651);
        return objInvokeBlock == coroutine_suspended ? coroutine_suspended : objInvokeBlock;
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        selectImplementation.register(clauseData, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reregisterClause(Object clauseObject) {
        SelectImplementation<R>.ClauseData clauseDataFindClause = findClause(clauseObject);
        Intrinsics.checkNotNull(clauseDataFindClause);
        clauseDataFindClause.disposableHandleOrSegment = null;
        clauseDataFindClause.indexInSegment = -1;
        register(clauseDataFindClause, true);
    }

    private final /* synthetic */ void setState$volatile(Object obj) {
        this.state$volatile = obj;
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        while (true) {
            Object obj = state$volatile$FU.get(this);
            if (!(obj instanceof CancellableContinuation)) {
                if (Intrinsics.areEqual(obj, SelectKt.STATE_COMPLETED) || (obj instanceof ClauseData)) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj, SelectKt.STATE_CANCELLED)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj, SelectKt.STATE_REG)) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
                    List listListOf = CollectionsKt.listOf(clauseObject);
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, listListOf)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    return 1;
                }
                if (!(obj instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj).toString());
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = state$volatile$FU;
                List listPlus = CollectionsKt.plus((Collection<? extends Object>) obj, clauseObject);
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, listPlus)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                return 1;
            }
            SelectImplementation<R>.ClauseData clauseDataFindClause = findClause(clauseObject);
            if (clauseDataFindClause != null) {
                Function3<Throwable, Object, CoroutineContext, Unit> function3CreateOnCancellationAction = clauseDataFindClause.createOnCancellationAction(this, internalResult);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = state$volatile$FU;
                while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, clauseDataFindClause)) {
                    if (atomicReferenceFieldUpdater3.get(this) != obj) {
                        break;
                    }
                }
                this.internalResult = internalResult;
                if (SelectKt.tryResume((CancellableContinuation) obj, function3CreateOnCancellationAction)) {
                    return 0;
                }
                this.internalResult = SelectKt.NO_RESULT;
                return 2;
            }
            continue;
        }
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(obj);
            Object objInvoke = function1.invoke(obj2);
            while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0070, code lost:
    
        r0 = r0.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0078, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007a, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object waitUntilSelected(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_REG) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = state$volatile$FU;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, cancellableContinuationImpl)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                CancellableContinuationKt.invokeOnCancellation(cancellableContinuationImpl, this);
                break loop0;
            }
            if (obj instanceof List) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = state$volatile$FU;
                Symbol symbol = SelectKt.STATE_REG;
                while (true) {
                    if (atomicReferenceFieldUpdater3.compareAndSet(this, obj, symbol)) {
                        Iterator it = ((Iterable) obj).iterator();
                        while (it.hasNext()) {
                            reregisterClause(it.next());
                        }
                    } else if (atomicReferenceFieldUpdater3.get(this) != obj) {
                        break;
                    }
                }
            } else {
                if (!(obj instanceof ClauseData)) {
                    throw new IllegalStateException(("unexpected state: " + obj).toString());
                }
                cancellableContinuationImpl.resume(Unit.INSTANCE, ((ClauseData) obj).createOnCancellationAction(this, this.internalResult));
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    @PublishedApi
    @Nullable
    public Object doSelect(@NotNull Continuation<? super R> continuation) {
        return doSelect$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.invoke(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout", imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @LowPriorityInOverloadResolution
    @ExperimentalCoroutinesApi
    public void onTimeout(long j, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        SelectBuilder.DefaultImpls.onTimeout(this, j, function1);
    }

    @JvmName(name = "register")
    public final void register(@NotNull SelectImplementation<R>.ClauseData clauseData, boolean z) {
        if (state$volatile$FU.get(this) instanceof ClauseData) {
            return;
        }
        if (!z) {
            checkClauseObject(clauseData.clauseObject);
        }
        if (!clauseData.tryRegisterAsWaiter(this)) {
            state$volatile$FU.set(this, clauseData);
            return;
        }
        if (!z) {
            List<SelectImplementation<R>.ClauseData> list = this.clauses;
            Intrinsics.checkNotNull(list);
            list.add(clauseData);
        }
        clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
        clauseData.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(@Nullable Object internalResult) {
        this.internalResult = internalResult;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(@NotNull Object clauseObject, @Nullable Object result) {
        return trySelectInternal(clauseObject, result) == 0;
    }

    @NotNull
    public final TrySelectDetailedResult trySelectDetailed(@NotNull Object clauseObject, @Nullable Object result) {
        return SelectKt.TrySelectDetailedResult(trySelectInternal(clauseObject, result));
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        register$default(this, new ClauseData(selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), function1, selectClause0.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause2.getClauseObject(), selectClause2.getRegFunc(), selectClause2.getProcessResFunc(), p, function2, selectClause2.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void invoke(@Nullable Throwable cause) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$volatile$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.STATE_COMPLETED) {
                return;
            }
            Symbol symbol = SelectKt.STATE_CANCELLED;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            List<SelectImplementation<R>.ClauseData> list = this.clauses;
            if (list == null) {
                return;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((ClauseData) it.next()).dispose();
            }
            this.internalResult = SelectKt.NO_RESULT;
            this.clauses = null;
            return;
        }
    }
}
