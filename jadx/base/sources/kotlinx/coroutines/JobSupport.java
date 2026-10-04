package kotlinx.coroutines;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(m13885d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n¹\u0001º\u0001»\u0001¼\u0001½\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0004J\u001f\u0010\u001f\u001a\u00020 2\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u001b0\"H\u0082\bJ\u001c\u0010'\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001c\u001a\u00020(2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-H\u0002J\u001e\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0-H\u0002J\u001a\u00100\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u00103\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020+H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020+H\u0002J\u0016\u00109\u001a\u00020\u001b*\u0002062\b\u00107\u001a\u0004\u0018\u00010+H\u0002J/\u0010:\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00050\"H\u0082\bJ\u0006\u0010=\u001a\u00020\u0005J\u0012\u0010>\u001a\u00020?2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010@\u001a\u00020\u001bH\u0014J\u000f\u0010A\u001a\u00060Cj\u0002`B¢\u0006\u0002\u0010DJ!\u0010E\u001a\u00060Cj\u0002`B*\u00020+2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010GH\u0004¢\u0006\u0002\u0010HJ4\u0010N\u001a\u00020O2'\u0010P\u001a#\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001b0\"j\u0002`Q¢\u0006\u0002\u0010TJD\u0010N\u001a\u00020O2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00052'\u0010P\u001a#\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\bR\u0012\b\bS\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001b0\"j\u0002`Q¢\u0006\u0002\u0010WJ\u001d\u0010X\u001a\u00020O2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020<H\u0000¢\u0006\u0002\bZJ+\u0010[\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020<2\u0018\u0010\\\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00050]H\u0082\bJ\u0010\u0010^\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020<H\u0002J\u000e\u0010a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020\u0005H\u0002J\u000e\u0010d\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010bJ\u001e\u0010k\u001a\u00020\u001b2\n\u0010l\u001a\u0006\u0012\u0002\b\u00030m2\b\u0010n\u001a\u0004\u0018\u00010\u000eH\u0002J\u0015\u0010o\u001a\u00020\u001b2\u0006\u0010Y\u001a\u00020<H\u0000¢\u0006\u0002\bpJ\u001d\u0010s\u001a\u00020\u001b2\u000e\u00107\u001a\n\u0018\u00010Cj\u0004\u0018\u0001`BH\u0016¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020GH\u0014J\u0012\u0010s\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010+H\u0017J\u0010\u0010v\u001a\u00020\u001b2\u0006\u00107\u001a\u00020+H\u0016J\u000e\u0010w\u001a\u00020\u001b2\u0006\u0010x\u001a\u00020\u0003J\u0010\u0010y\u001a\u00020\u00052\u0006\u00107\u001a\u00020+H\u0016J\u0010\u0010z\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010+J\u0017\u0010{\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b|J\u0014\u0010}\u001a\u0004\u0018\u00010\u000e2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J'\u0010~\u001a\u00020\u007f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u00107\u001a\u0004\u0018\u00010+H\u0080\b¢\u0006\u0003\b\u0080\u0001J\u0012\u0010\u0081\u0001\u001a\u00060Cj\u0002`BH\u0016¢\u0006\u0002\u0010DJ\u0013\u0010\u0082\u0001\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J\u0015\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000e2\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0002J\u0013\u0010\u0084\u0001\u001a\u0004\u0018\u0001062\u0006\u0010\u001c\u001a\u000201H\u0002J\u0019\u0010\u0085\u0001\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u0002012\u0006\u0010/\u001a\u00020+H\u0002J\u0019\u0010\u0086\u0001\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\b\u0087\u0001J\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\b\u0089\u0001J\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J\u001d\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u0002012\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020(2\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0082\u0010J%\u0010\u0092\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020(2\b\u0010\u0093\u0001\u001a\u00030\u0091\u00012\b\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002J\u0011\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u0001*\u00030\u0095\u0001H\u0002J\u0010\u0010\u009a\u0001\u001a\u00020\u00102\u0007\u0010\u0090\u0001\u001a\u00020\u0002J\u0018\u0010\u009b\u0001\u001a\u00020\u001b2\u0007\u0010\u009c\u0001\u001a\u00020+H\u0010¢\u0006\u0003\b\u009d\u0001J\u0012\u0010U\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010+H\u0014J\u0012\u0010¡\u0001\u001a\u00020\u00052\u0007\u0010\u009c\u0001\u001a\u00020+H\u0014J\u0013\u0010¢\u0001\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0014J\u0013\u0010£\u0001\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0014J\t\u0010¤\u0001\u001a\u00020GH\u0016J\t\u0010¥\u0001\u001a\u00020GH\u0007J\u000f\u0010¦\u0001\u001a\u00020GH\u0010¢\u0006\u0003\b§\u0001J\u0013\u0010¨\u0001\u001a\u00020G2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0002J\t\u0010¬\u0001\u001a\u0004\u0018\u00010+J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\b®\u0001J\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010\u000eH\u0084@¢\u0006\u0002\u0010bJ\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\u000eH\u0082@¢\u0006\u0002\u0010bJ\u001f\u0010¶\u0001\u001a\u00020\u001b2\n\u0010l\u001a\u0006\u0012\u0002\b\u00030m2\b\u0010n\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010·\u0001\u001a\u0004\u0018\u00010\u000e2\b\u0010n\u001a\u0004\u0018\u00010\u000e2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u000eH\u0002R\u0015\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004R(\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0011\u0010&\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0016\u0010I\u001a\u0004\u0018\u00010+8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010L\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bM\u0010$R\u0017\u0010e\u001a\u00020f8F¢\u0006\f\u0012\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0014\u0010q\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\br\u0010$R\u001f\u0010\u008c\u0001\u001a\u0004\u0018\u00010+*\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001b\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u0097\u00018F¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0016\u0010\u009e\u0001\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010$R\u0016\u0010\u009f\u0001\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010$R\u001b\u0010©\u0001\u001a\u00020\u0005*\u0002018BX\u0082\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0013\u0010«\u0001\u001a\u00020\u00058F¢\u0006\u0007\u001a\u0005\b«\u0001\u0010$R#\u0010±\u0001\u001a\u0007\u0012\u0002\b\u00030²\u00018DX\u0084\u0004¢\u0006\u000f\u0012\u0005\b³\u0001\u0010h\u001a\u0006\b´\u0001\u0010µ\u0001¨\u0006¾\u0001"}, m13886d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "<init>", "(Z)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_parentHandle", "Lkotlinx/coroutines/ChildHandle;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "initParentJob", "", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "loopOnState", "", "block", "Lkotlin/Function1;", "isActive", "()Z", "isCompleted", "isCancelled", "finalizeFinishingState", "Lkotlinx/coroutines/JobSupport$Finishing;", "proposedUpdate", "getFinalRootCause", "", "exceptions", "", "addSuppressedExceptions", "rootCause", "tryFinalizeSimpleState", "Lkotlinx/coroutines/Incomplete;", Constants.ARG_UPDATE, "completeStateFinalization", "notifyCancelling", XmlErrorCodes.LIST, "Lkotlinx/coroutines/NodeList;", "cause", "cancelParent", "notifyCompletion", "notifyHandlers", "predicate", "Lkotlinx/coroutines/JobNode;", "start", "startInternal", "", "onStart", "getCancellationException", "Lkotlinx/coroutines/CancellationException;", "Ljava/util/concurrent/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "toCancellationException", "message", "", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "completionCause", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletionInternal", "node", "invokeOnCompletionInternal$kotlinx_coroutines_core", "tryPutNodeIntoList", "tryAdd", "Lkotlin/Function2;", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinInternal", "joinSuspend", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "()V", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "registerSelectForOnJoin", Bixby2Constants.BIXBY_PARAM_SELECT, "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "removeNode", "removeNode$kotlinx_coroutines_core", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "cancelInternal", "parentCancelled", "parentJob", "childCancelled", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelMakeCompleting", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "getChildJobCancellationCause", "createCauseException", "makeCancelling", "getOrPromoteCancellingList", "tryMakeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "tryMakeCompleting", "tryMakeCompletingSlowPath", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "tryWaitForChild", "child", "Lkotlinx/coroutines/ChildHandleNode;", "continueCompleting", "lastChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "handleOnCompletionException", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "isScopedCoroutine", "handlesException", "getHandlesException$kotlinx_coroutines_core", "handleJobException", "onCompletionInternal", "afterCompletion", "toString", "toDebugString", "nameString", "nameString$kotlinx_coroutines_core", "stateString", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "isCompletedExceptionally", "getCompletionExceptionOrNull", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "awaitInternal", "awaitSuspend", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwaitInternalRegFunc", "onAwaitInternalProcessResFunc", "result", "SelectOnJoinCompletionHandler", "Finishing", "ChildCompletion", "AwaitContinuation", "SelectOnAwaitCompletionHandler", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 9 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1583:1\n732#1,3:1587\n361#1,2:1597\n363#1,5:1602\n368#1,5:1608\n373#1,2:1616\n361#1,2:1618\n363#1,5:1623\n368#1,5:1629\n373#1,2:1637\n169#1,2:1645\n734#1:1647\n536#1:1648\n169#1,2:1649\n537#1,15:1651\n169#1,2:1666\n169#1,2:1668\n169#1,2:1681\n732#1,3:1683\n732#1,3:1686\n169#1,2:1689\n732#1,3:1691\n169#1,2:1694\n169#1,2:1698\n169#1,2:1700\n536#1:1704\n169#1,2:1705\n537#1,15:1707\n1#2:1584\n1#2:1607\n1#2:1628\n27#3:1585\n27#3:1696\n27#3:1702\n16#4:1586\n16#4:1697\n16#4:1703\n295#5,2:1590\n295#5,2:1592\n22#6:1594\n159#7:1595\n159#7:1596\n149#7,4:1722\n275#8,3:1599\n278#8,3:1613\n275#8,3:1620\n278#8,3:1634\n275#8,6:1639\n351#9,11:1670\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n241#1:1587,3\n324#1:1597,2\n324#1:1602,5\n324#1:1608,5\n324#1:1616,2\n357#1:1618,2\n357#1:1623,5\n357#1:1629,5\n357#1:1637,2\n377#1:1645,2\n422#1:1647\n468#1:1648\n468#1:1649,2\n468#1:1651,15\n536#1:1666,2\n579#1:1668,2\n621#1:1681,2\n648#1:1683,3\n657#1:1686,3\n721#1:1689,2\n750#1:1691,3\n763#1:1694,2\n836#1:1698,2\n858#1:1700,2\n1023#1:1704\n1023#1:1705,2\n1023#1:1707,15\n324#1:1607\n357#1:1628\n204#1:1585\n766#1:1696\n911#1:1702\n204#1:1586\n766#1:1697\n911#1:1703\n252#1:1590,2\n256#1:1592,2\n264#1:1594\n270#1:1595\n272#1:1596\n1327#1:1722,4\n324#1:1599,3\n324#1:1613,3\n357#1:1620,3\n357#1:1634,3\n362#1:1639,6\n585#1:1670,11\n*E\n"})
public class JobSupport implements Job, ChildJob, ParentJob {
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {

        @NotNull
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job parent) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof Finishing) || (rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause()) == null) ? state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : parent.getCancellationException() : rootCause;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public String nameString() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, m13886d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ChildCompletion extends JobNode {

        @NotNull
        private final ChildHandleNode child;

        @NotNull
        private final JobSupport parent;

        @Nullable
        private final Object proposedUpdate;

        @NotNull
        private final Finishing state;

        public ChildCompletion(@NotNull JobSupport jobSupport, @NotNull Finishing finishing, @NotNull ChildHandleNode childHandleNode, @Nullable Object obj) {
            this.parent = jobSupport;
            this.state = finishing;
            this.child = childHandleNode;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(@Nullable Throwable cause) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0002j\u0002`\u00012\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$2\b\u0010%\u001a\u0004\u0018\u00010\tJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\tJ\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0*H\u0002J\b\u0010+\u001a\u00020,H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015X\u0082\u0004R(\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0015X\u0082\u0004R(\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00028B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b \u0010\u0011R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011¨\u0006-"}, m13886d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "Lkotlinx/coroutines/Incomplete;", XmlErrorCodes.LIST, "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "getList", "()Lkotlinx/coroutines/NodeList;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "value", "()Z", "setCompleting", "(Z)V", "_rootCause", "Lkotlinx/atomicfu/AtomicRef;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "_exceptionsHolder", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isSealed", "isCancelling", "isActive", "sealLocked", "", "proposedException", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "toString", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
    public static final class Finishing implements Incomplete {
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        @NotNull
        private final NodeList list;
        private static final /* synthetic */ AtomicIntegerFieldUpdater _isCompleting$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting$volatile");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _rootCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause$volatile");
        private static final /* synthetic */ AtomicReferenceFieldUpdater _exceptionsHolder$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder$volatile");

        public Finishing(@NotNull NodeList nodeList, boolean z, @Nullable Throwable th) {
            this.list = nodeList;
            this._isCompleting$volatile = z ? 1 : 0;
            this._rootCause$volatile = th;
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        private final Object getExceptionsHolder() {
            return _exceptionsHolder$volatile$FU.get(this);
        }

        private final /* synthetic */ Object get_exceptionsHolder$volatile() {
            return this._exceptionsHolder$volatile;
        }

        private final /* synthetic */ int get_isCompleting$volatile() {
            return this._isCompleting$volatile;
        }

        private final /* synthetic */ Object get_rootCause$volatile() {
            return this._rootCause$volatile;
        }

        private final void setExceptionsHolder(Object obj) {
            _exceptionsHolder$volatile$FU.set(this, obj);
        }

        private final /* synthetic */ void set_exceptionsHolder$volatile(Object obj) {
            this._exceptionsHolder$volatile = obj;
        }

        private final /* synthetic */ void set_isCompleting$volatile(int i) {
            this._isCompleting$volatile = i;
        }

        private final /* synthetic */ void set_rootCause$volatile(Object obj) {
            this._rootCause$volatile = obj;
        }

        public final void addExceptionLocked(@NotNull Throwable exception) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(exception);
                return;
            }
            if (exception == rootCause) {
                return;
            }
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                setExceptionsHolder(exception);
                return;
            }
            if (!(exceptionsHolder instanceof Throwable)) {
                if (exceptionsHolder instanceof ArrayList) {
                    ((ArrayList) exceptionsHolder).add(exception);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + exceptionsHolder).toString());
                }
            }
            if (exception == exceptionsHolder) {
                return;
            }
            ArrayList<Throwable> arrayListAllocateList = allocateList();
            arrayListAllocateList.add(exceptionsHolder);
            arrayListAllocateList.add(exception);
            setExceptionsHolder(arrayListAllocateList);
        }

        @Override // kotlinx.coroutines.Incomplete
        @NotNull
        public NodeList getList() {
            return this.list;
        }

        @Nullable
        public final Throwable getRootCause() {
            return (Throwable) _rootCause$volatile$FU.get(this);
        }

        @Override // kotlinx.coroutines.Incomplete
        /* JADX INFO: renamed from: isActive */
        public boolean getIsActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final boolean isCompleting() {
            return _isCompleting$volatile$FU.get(this) != 0;
        }

        public final boolean isSealed() {
            return getExceptionsHolder() == JobSupportKt.SEALED;
        }

        @NotNull
        public final List<Throwable> sealLocked(@Nullable Throwable proposedException) {
            ArrayList<Throwable> arrayListAllocateList;
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                arrayListAllocateList = allocateList();
            } else if (exceptionsHolder instanceof Throwable) {
                ArrayList<Throwable> arrayListAllocateList2 = allocateList();
                arrayListAllocateList2.add(exceptionsHolder);
                arrayListAllocateList = arrayListAllocateList2;
            } else {
                if (!(exceptionsHolder instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + exceptionsHolder).toString());
                }
                arrayListAllocateList = (ArrayList) exceptionsHolder;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayListAllocateList.add(0, rootCause);
            }
            if (proposedException != null && !Intrinsics.areEqual(proposedException, rootCause)) {
                arrayListAllocateList.add(proposedException);
            }
            setExceptionsHolder(JobSupportKt.SEALED);
            return arrayListAllocateList;
        }

        public final void setCompleting(boolean z) {
            _isCompleting$volatile$FU.set(this, z ? 1 : 0);
        }

        public final void setRootCause(@Nullable Throwable th) {
            _rootCause$volatile$FU.set(this, th);
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + getExceptionsHolder() + ", list=" + getList() + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", Bixby2Constants.BIXBY_PARAM_SELECT, "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class SelectOnAwaitCompletionHandler extends JobNode {

        @NotNull
        private final SelectInstance<?> select;

        public SelectOnAwaitCompletionHandler(@NotNull SelectInstance<?> selectInstance) {
            this.select = selectInstance;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(@Nullable Throwable cause) {
            Object state$kotlinx_coroutines_core = JobSupport.this.getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                state$kotlinx_coroutines_core = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
            this.select.trySelect(JobSupport.this, state$kotlinx_coroutines_core);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, m13886d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", Bixby2Constants.BIXBY_PARAM_SELECT, "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class SelectOnJoinCompletionHandler extends JobNode {

        @NotNull
        private final SelectInstance<?> select;

        public SelectOnJoinCompletionHandler(@NotNull SelectInstance<?> selectInstance) {
            this.select = selectInstance;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean getOnCancelling() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(@Nullable Throwable cause) {
            this.select.trySelect(JobSupport.this, Unit.INSTANCE);
        }
    }

    public JobSupport(boolean z) {
        this._state$volatile = z ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        if (exceptions.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(exceptions.size()));
        for (Throwable th : exceptions) {
            if (th != rootCause && th != rootCause && !(th instanceof CancellationException) && setNewSetFromMap.add(th)) {
                kotlin.ExceptionsKt.addSuppressed(rootCause, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        awaitContinuation.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(awaitContinuation, JobKt__JobKt.invokeOnCompletion$default(this, false, new ResumeAwaitOnCompletion(awaitContinuation), 1, null));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Object cancelMakeCompleting(Object cause) {
        Object objTryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCompleting())) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(cause), false, 2, null));
        } while (objTryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    private final boolean cancelParent(Throwable cause) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = cause instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) ? z : parentHandle$kotlinx_coroutines_core.childCancelled(cause) || z;
    }

    private final void completeStateFinalization(Incomplete state, Object update) throws Throwable {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
        CompletedExceptionally completedExceptionally = update instanceof CompletedExceptionally ? (CompletedExceptionally) update : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (!(state instanceof JobNode)) {
            NodeList list = state.getList();
            if (list != null) {
                notifyCompletion(list, th);
                return;
            }
            return;
        }
        try {
            ((JobNode) state).invoke(th);
        } catch (Throwable th2) {
            handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        ChildHandleNode childHandleNodeNextChild = nextChild(lastChild);
        if (childHandleNodeNextChild == null || !tryWaitForChild(state, childHandleNodeNextChild, proposedUpdate)) {
            state.getList().close(2);
            ChildHandleNode childHandleNodeNextChild2 = nextChild(lastChild);
            if (childHandleNodeNextChild2 == null || !tryWaitForChild(state, childHandleNodeNextChild2, proposedUpdate)) {
                afterCompletion(finalizeFinishingState(state, proposedUpdate));
            }
        }
    }

    private final Throwable createCauseException(Object cause) {
        if (cause == null ? true : cause instanceof Throwable) {
            Throwable th = (Throwable) cause;
            return th == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th;
        }
        Intrinsics.checkNotNull(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) cause).getChildJobCancellationCause();
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            th = null;
        }
        if (str == null) {
            str = jobSupport.cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, jobSupport);
    }

    private final Object finalizeFinishingState(Finishing state, Object proposedUpdate) throws Throwable {
        boolean zIsCancelling;
        Throwable finalRootCause;
        CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        synchronized (state) {
            zIsCancelling = state.isCancelling();
            List<Throwable> listSealLocked = state.sealLocked(th);
            finalRootCause = getFinalRootCause(state, listSealLocked);
            if (finalRootCause != null) {
                addSuppressedExceptions(finalRootCause, listSealLocked);
            }
        }
        if (finalRootCause != null && finalRootCause != th) {
            proposedUpdate = new CompletedExceptionally(finalRootCause, false, 2, null);
        }
        if (finalRootCause != null && (cancelParent(finalRootCause) || handleJobException(finalRootCause))) {
            Intrinsics.checkNotNull(proposedUpdate, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((CompletedExceptionally) proposedUpdate).makeHandled();
        }
        if (!zIsCancelling) {
            onCancelling(finalRootCause);
        }
        onCompletionInternal(proposedUpdate);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        Object objBoxIncomplete = JobSupportKt.boxIncomplete(proposedUpdate);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, state, objBoxIncomplete) && atomicReferenceFieldUpdater.get(this) == state) {
        }
        completeStateFinalization(state, proposedUpdate);
        return proposedUpdate;
    }

    private final Throwable getExceptionOrNull(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Object next;
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list = exceptions;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = exceptions.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof Empty) {
            return new NodeList();
        }
        if (state instanceof JobNode) {
            promoteSingleToNodeList((JobNode) state);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + state).toString());
    }

    private final /* synthetic */ Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private final /* synthetic */ Object get_state$volatile() {
        return this._state$volatile;
    }

    private final boolean isCancelling(Incomplete incomplete) {
        return (incomplete instanceof Finishing) && ((Finishing) incomplete).isCancelling();
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl, JobKt__JobKt.invokeOnCompletion$default(this, false, new ResumeOnCompletion(cancellableContinuationImpl), 1, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    private final Void loopOnState(Function1<Object, Unit> block) {
        while (true) {
            block.invoke(getState$kotlinx_coroutines_core());
        }
    }

    private final Object makeCancelling(Object cause) throws Throwable {
        Throwable thCreateCauseException = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Finishing) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((Finishing) state$kotlinx_coroutines_core).isSealed()) {
                        return JobSupportKt.TOO_LATE_TO_CANCEL;
                    }
                    boolean zIsCancelling = ((Finishing) state$kotlinx_coroutines_core).isCancelling();
                    if (cause != null || !zIsCancelling) {
                        if (thCreateCauseException == null) {
                            thCreateCauseException = createCauseException(cause);
                        }
                        ((Finishing) state$kotlinx_coroutines_core).addExceptionLocked(thCreateCauseException);
                    }
                    Throwable rootCause = zIsCancelling ? null : ((Finishing) state$kotlinx_coroutines_core).getRootCause();
                    if (rootCause != null) {
                        notifyCancelling(((Finishing) state$kotlinx_coroutines_core).getList(), rootCause);
                    }
                    return JobSupportKt.COMPLETING_ALREADY;
                }
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return JobSupportKt.TOO_LATE_TO_CANCEL;
            }
            if (thCreateCauseException == null) {
                thCreateCauseException = createCauseException(cause);
            }
            Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
            if (!incomplete.getIsActive()) {
                Object objTryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(thCreateCauseException, false, 2, null));
                if (objTryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                    throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                }
                if (objTryMakeCompleting != JobSupportKt.COMPLETING_RETRY) {
                    return objTryMakeCompleting;
                }
            } else if (tryMakeCancelling(incomplete, thCreateCauseException)) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
        }
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void notifyCancelling(NodeList list, Throwable cause) throws Throwable {
        onCancelling(cause);
        list.close(4);
        Object next = list.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, list); nextNode = nextNode.getNextNode()) {
            if ((nextNode instanceof JobNode) && ((JobNode) nextNode).getOnCancelling()) {
                try {
                    ((JobNode) nextNode).invoke(cause);
                } catch (Throwable th) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + nextNode + " for " + this, th);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        cancelParent(cause);
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th) throws Throwable {
        nodeList.close(1);
        Object next = nodeList.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, nodeList); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof JobNode) {
                try {
                    ((JobNode) nextNode).invoke(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + nextNode + " for " + this, th2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    private final void notifyHandlers(NodeList list, Throwable cause, Function1<? super JobNode, Boolean> predicate) throws Throwable {
        Object next = list.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, list); nextNode = nextNode.getNextNode()) {
            if ((nextNode instanceof JobNode) && predicate.invoke(nextNode).booleanValue()) {
                try {
                    ((JobNode) nextNode).invoke(cause);
                } catch (Throwable th) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.addSuppressed(completionHandlerException, th);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + nextNode + " for " + this, th);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onAwaitInternalProcessResFunc(Object ignoredParam, Object result) throws Throwable {
        if (result instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) result).cause;
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAwaitInternalRegFunc(SelectInstance<?> select, Object ignoredParam) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                    state$kotlinx_coroutines_core = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
                }
                select.selectInRegistrationPhase(state$kotlinx_coroutines_core);
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        select.disposeOnCompletion(JobKt__JobKt.invokeOnCompletion$default(this, false, new SelectOnAwaitCompletionHandler(select), 1, null));
    }

    private final void promoteEmptyToNodeList(Empty state) {
        NodeList nodeList = new NodeList();
        Object inactiveNodeList = nodeList;
        if (!state.getIsActive()) {
            inactiveNodeList = new InactiveNodeList(nodeList);
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, state, inactiveNodeList) && atomicReferenceFieldUpdater.get(this) == state) {
        }
    }

    private final void promoteSingleToNodeList(JobNode state) {
        state.addOneIfEmpty(new NodeList());
        LockFreeLinkedListNode nextNode = state.getNextNode();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, state, nextNode) && atomicReferenceFieldUpdater.get(this) == state) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForOnJoin(SelectInstance<?> select, Object ignoredParam) {
        if (joinInternal()) {
            select.disposeOnCompletion(JobKt__JobKt.invokeOnCompletion$default(this, false, new SelectOnJoinCompletionHandler(select), 1, null));
        } else {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
    }

    private final /* synthetic */ void set_parentHandle$volatile(Object obj) {
        this._parentHandle$volatile = obj;
    }

    private final /* synthetic */ void set_state$volatile(Object obj) {
        this._state$volatile = obj;
    }

    private final int startInternal(Object state) {
        if (state instanceof Empty) {
            if (((Empty) state).getIsActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
            Empty empty = JobSupportKt.EMPTY_ACTIVE;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, state, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != state) {
                    return -1;
                }
            }
            onStart();
            return 1;
        }
        if (!(state instanceof InactiveNodeList)) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = _state$volatile$FU;
        NodeList list = ((InactiveNodeList) state).getList();
        while (!atomicReferenceFieldUpdater2.compareAndSet(this, state, list)) {
            if (atomicReferenceFieldUpdater2.get(this) != state) {
                return -1;
            }
        }
        onStart();
        return 1;
    }

    private final String stateString(Object state) {
        if (!(state instanceof Finishing)) {
            return state instanceof Incomplete ? ((Incomplete) state).getIsActive() ? "Active" : "New" : state instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) state;
        return finishing.isCancelling() ? "Cancelling" : finishing.isCompleting() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return jobSupport.toCancellationException(th, str);
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update) throws Throwable {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        Object objBoxIncomplete = JobSupportKt.boxIncomplete(update);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, state, objBoxIncomplete)) {
            if (atomicReferenceFieldUpdater.get(this) != state) {
                return false;
            }
        }
        onCancelling(null);
        onCompletionInternal(update);
        completeStateFinalization(state, update);
        return true;
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) throws Throwable {
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            return false;
        }
        Finishing finishing = new Finishing(orPromoteCancellingList, false, rootCause);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, state, finishing)) {
            if (atomicReferenceFieldUpdater.get(this) != state) {
                return false;
            }
        }
        notifyCancelling(orPromoteCancellingList, rootCause);
        return true;
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        return !(state instanceof Incomplete) ? JobSupportKt.COMPLETING_ALREADY : ((!(state instanceof Empty) && !(state instanceof JobNode)) || (state instanceof ChildHandleNode) || (proposedUpdate instanceof CompletedExceptionally)) ? tryMakeCompletingSlowPath((Incomplete) state, proposedUpdate) : tryFinalizeSimpleState((Incomplete) state, proposedUpdate) ? proposedUpdate : JobSupportKt.COMPLETING_RETRY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object tryMakeCompletingSlowPath(Incomplete state, Object proposedUpdate) throws Throwable {
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            return JobSupportKt.COMPLETING_RETRY;
        }
        Finishing finishing = state instanceof Finishing ? (Finishing) state : null;
        boolean z = false;
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (finishing) {
            if (finishing.isCompleting()) {
                return JobSupportKt.COMPLETING_ALREADY;
            }
            finishing.setCompleting(true);
            if (finishing != state) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, state, finishing)) {
                        z = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != state) {
                        break;
                    }
                }
                if (!z) {
                    return JobSupportKt.COMPLETING_RETRY;
                }
            }
            boolean zIsCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = proposedUpdate instanceof CompletedExceptionally ? (CompletedExceptionally) proposedUpdate : null;
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            ?? rootCause = zIsCancelling ? 0 : finishing.getRootCause();
            objectRef.element = rootCause;
            Unit unit = Unit.INSTANCE;
            if (rootCause != 0) {
                notifyCancelling(orPromoteCancellingList, rootCause);
            }
            ChildHandleNode childHandleNodeNextChild = nextChild(orPromoteCancellingList);
            if (childHandleNodeNextChild != null && tryWaitForChild(finishing, childHandleNodeNextChild, proposedUpdate)) {
                return JobSupportKt.COMPLETING_WAITING_CHILDREN;
            }
            orPromoteCancellingList.close(2);
            ChildHandleNode childHandleNodeNextChild2 = nextChild(orPromoteCancellingList);
            return (childHandleNodeNextChild2 == null || !tryWaitForChild(finishing, childHandleNodeNextChild2, proposedUpdate)) ? finalizeFinishingState(finishing, proposedUpdate) : JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }
    }

    private final boolean tryPutNodeIntoList(JobNode node, Function2<? super Incomplete, ? super NodeList, Boolean> tryAdd) {
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.getIsActive()) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, node)) {
                        if (atomicReferenceFieldUpdater.get(this) != state$kotlinx_coroutines_core) {
                            break;
                        }
                    }
                    return true;
                }
                promoteEmptyToNodeList(empty);
            } else {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    return false;
                }
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list == null) {
                    Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else if (tryAdd.invoke(state$kotlinx_coroutines_core, list).booleanValue()) {
                    return true;
                }
            }
        }
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        while (JobKt.invokeOnCompletion(child.childJob, false, new ChildCompletion(this, state, child, proposedUpdate)) == NonDisposableHandle.INSTANCE) {
            child = nextChild(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob child) {
        ChildHandleNode childHandleNode = new ChildHandleNode(child);
        childHandleNode.setJob(this);
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.getIsActive()) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, childHandleNode)) {
                        if (atomicReferenceFieldUpdater.get(this) != state$kotlinx_coroutines_core) {
                            break;
                        }
                    }
                    return childHandleNode;
                }
                promoteEmptyToNodeList(empty);
            } else {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
                    CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core2 instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core2 : null;
                    childHandleNode.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                    return NonDisposableHandle.INSTANCE;
                }
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    if (!list.addLast(childHandleNode, 7)) {
                        boolean zAddLast = list.addLast(childHandleNode, 3);
                        Object state$kotlinx_coroutines_core3 = getState$kotlinx_coroutines_core();
                        if (state$kotlinx_coroutines_core3 instanceof Finishing) {
                            rootCause = ((Finishing) state$kotlinx_coroutines_core3).getRootCause();
                        } else {
                            CompletedExceptionally completedExceptionally2 = state$kotlinx_coroutines_core3 instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core3 : null;
                            if (completedExceptionally2 != null) {
                                rootCause = completedExceptionally2.cause;
                            }
                        }
                        childHandleNode.invoke(rootCause);
                        if (!zAddLast) {
                            return NonDisposableHandle.INSTANCE;
                        }
                    }
                    return childHandleNode;
                }
                Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
            }
        }
    }

    @Nullable
    public final Object awaitInternal(@NotNull Continuation<Object> continuation) throws Throwable {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                }
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final boolean cancelCoroutine(@Nullable Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object cause) throws Throwable {
        Object objMakeCancelling = JobSupportKt.COMPLETING_ALREADY;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (objMakeCancelling = cancelMakeCompleting(cause)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (objMakeCancelling == JobSupportKt.COMPLETING_ALREADY) {
            objMakeCancelling = makeCancelling(cause);
        }
        if (objMakeCancelling == JobSupportKt.COMPLETING_ALREADY || objMakeCancelling == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        if (objMakeCancelling == JobSupportKt.TOO_LATE_TO_CANCEL) {
            return false;
        }
        afterCompletion(objMakeCancelling);
        return true;
    }

    public void cancelInternal(@NotNull Throwable cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @NotNull
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(@NotNull Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException();
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String message, @Nullable Throwable cause) {
        if (message == null) {
            message = cancellationExceptionMessage();
        }
        return new JobCancellationException(message, cause, this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Finishing)) {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return toCancellationException$default(this, ((CompletedExceptionally) state$kotlinx_coroutines_core).cause, null, 1, null);
            }
            return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", null, this);
        }
        Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        if (rootCause != null) {
            CancellationException cancellationException = toCancellationException(rootCause, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
            if (cancellationException != null) {
                return cancellationException;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.ParentJob
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        Throwable rootCause;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            rootCause = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        } else {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? (CancellationException) rootCause : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), rootCause, this);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() throws Throwable {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
    }

    @Nullable
    public final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable rootCause = ((Finishing) state$kotlinx_coroutines_core).getRootCause();
            if (rootCause != null) {
                return rootCause;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return null;
    }

    public final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) && ((CompletedExceptionally) state$kotlinx_coroutines_core).getHandled();
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return getExceptionOrNull(state$kotlinx_coroutines_core);
    }

    /* JADX INFO: renamed from: getHandlesException$kotlinx_coroutines_core */
    public boolean getHandlesException() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    @NotNull
    public final SelectClause1<?> getOnAwaitInternal() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final SelectClause0 getOnJoin() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause0Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(jobSupport$onJoin$1, 3), null, 4, null);
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public Job getParent() {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) _parentHandle$volatile$FU.get(this);
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return _state$volatile$FU.get(this);
    }

    public boolean handleJobException(@NotNull Throwable exception) {
        return false;
    }

    public final void initParentJob(@Nullable Job parent) {
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }
        parent.start();
        ChildHandle childHandleAttachChild = parent.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(childHandleAttachChild);
        if (isCompleted()) {
            childHandleAttachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, Unit> handler) {
        return invokeOnCompletionInternal$kotlinx_coroutines_core(true, new InvokeOnCompletion(handler));
    }

    @NotNull
    public final DisposableHandle invokeOnCompletionInternal$kotlinx_coroutines_core(boolean invokeImmediately, @NotNull JobNode node) {
        boolean z;
        boolean zAddLast;
        node.setJob(this);
        loop0: while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            z = true;
            if (!(state$kotlinx_coroutines_core instanceof Empty)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                    z = false;
                    break;
                }
                Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                NodeList list = incomplete.getList();
                if (list == null) {
                    Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                } else {
                    if (node.getOnCancelling()) {
                        Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
                        Throwable rootCause = finishing != null ? finishing.getRootCause() : null;
                        if (rootCause != null) {
                            if (invokeImmediately) {
                                node.invoke(rootCause);
                            }
                            return NonDisposableHandle.INSTANCE;
                        }
                        zAddLast = list.addLast(node, 5);
                    } else {
                        zAddLast = list.addLast(node, 1);
                    }
                    if (zAddLast) {
                        break;
                    }
                }
            } else {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.getIsActive()) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, node)) {
                        if (atomicReferenceFieldUpdater.get(this) != state$kotlinx_coroutines_core) {
                            break;
                        }
                    }
                    break loop0;
                }
                promoteEmptyToNodeList(empty);
            }
        }
        if (z) {
            return node;
        }
        if (invokeImmediately) {
            Object state$kotlinx_coroutines_core2 = getState$kotlinx_coroutines_core();
            CompletedExceptionally completedExceptionally = state$kotlinx_coroutines_core2 instanceof CompletedExceptionally ? (CompletedExceptionally) state$kotlinx_coroutines_core2 : null;
            node.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getIsActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return true;
        }
        return (state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        if (joinInternal()) {
            Object objJoinSuspend = joinSuspend(continuation);
            return objJoinSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinSuspend : Unit.INSTANCE;
        }
        JobKt.ensureActive(continuation.get$context());
        return Unit.INSTANCE;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate);
            if (objTryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                return false;
            }
            if (objTryMakeCompleting == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
        } while (objTryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        afterCompletion(objTryMakeCompleting);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object proposedUpdate) {
        Object objTryMakeCompleting;
        do {
            objTryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate);
            if (objTryMakeCompleting == JobSupportKt.COMPLETING_ALREADY) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, getExceptionOrNull(proposedUpdate));
            }
        } while (objTryMakeCompleting == JobSupportKt.COMPLETING_RETRY);
        return objTryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@NotNull ParentJob parentJob) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.DefaultImpls.plus(this, coroutineContext);
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull JobNode node) {
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof JobNode)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                node.mo23762remove();
                return;
            }
            if (state$kotlinx_coroutines_core != node) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$volatile$FU;
            Empty empty = JobSupportKt.EMPTY_ACTIVE;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != state$kotlinx_coroutines_core) {
                    break;
                }
            }
            return;
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle) {
        _parentHandle$volatile$FU.set(this, childHandle);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iStartInternal;
        do {
            iStartInternal = startInternal(getState$kotlinx_coroutines_core());
            if (iStartInternal == 0) {
                return false;
            }
        } while (iStartInternal != 1);
        return true;
    }

    @NotNull
    public final CancellationException toCancellationException(@NotNull Throwable th, @Nullable String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameString$kotlinx_coroutines_core());
        sb.append('{');
        return AbstractC1038a.m1213n('}', stateString(getState$kotlinx_coroutines_core()), sb);
    }

    @NotNull
    public String toString() {
        return toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(Throwable cause) {
        Throwable jobCancellationException;
        if (cause == null || (jobCancellationException = toCancellationException$default(this, cause, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public Job plus(@NotNull Job job) {
        return Job.DefaultImpls.plus((Job) this, job);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, @NotNull Function1<? super Throwable, Unit> handler) {
        JobNode invokeOnCompletion;
        if (onCancelling) {
            invokeOnCompletion = new InvokeOnCancelling(handler);
        } else {
            invokeOnCompletion = new InvokeOnCompletion(handler);
        }
        return invokeOnCompletionInternal$kotlinx_coroutines_core(invokeImmediately, invokeOnCompletion);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(@Nullable CancellationException cause) {
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    public static /* synthetic */ void getOnAwaitInternal$annotations() {
    }

    public static /* synthetic */ void getOnJoin$annotations() {
    }

    public void onStart() {
    }

    public void afterCompletion(@Nullable Object state) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable exception) throws Throwable {
        throw exception;
    }

    public void onCancelling(@Nullable Throwable cause) {
    }

    public void onCompletionInternal(@Nullable Object state) {
    }
}
