package kotlinx.coroutines.channels;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.primitives.Longs;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.C7884a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004ï\u0001ð\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010#J4\u0010%\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010)J\"\u0010*\u001a\u00020\b*\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J#\u0010,\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0.H\u0002¢\u0006\u0002\u0010/J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\b012\u0006\u0010\"\u001a\u00028\u0000H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b5\u0010#Jê\u0001\u00106\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u0010\"\u001a\u00028\u00002\b\u00108\u001a\u0004\u0018\u0001092\f\u0010:\u001a\b\u0012\u0004\u0012\u0002H70;2<\u0010<\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H70=2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H70;2h\b\u0002\u0010C\u001ab\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H70DH\u0082\b¢\u0006\u0002\u0010EJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\b012\u0006\u0010\"\u001a\u00028\u0000H\u0004¢\u0006\u0004\bG\u00103JX\u0010H\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\u0006\u00108\u001a\u00020+2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0;2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0;H\u0082\b¢\u0006\u0002\u0010IJE\u0010J\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010LJE\u0010M\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010(\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010K\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010LJ\u0010\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u0011H\u0003J\u0010\u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u0011H\u0002J\r\u0010N\u001a\u00020\u001aH\u0010¢\u0006\u0002\bRJ\u0019\u0010S\u001a\u00020\u001a*\u0002092\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\bH\u0014J\b\u0010V\u001a\u00020\bH\u0014J\u000e\u0010W\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010XJ;\u0010Y\u001a\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010[J\"\u0010\\\u001a\u00020\b*\u00020+2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0016\u0010]\u001a\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.H\u0002J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0096@¢\u0006\u0004\b_\u0010XJ4\u0010`\u001a\b\u0012\u0004\u0012\u00028\u0000012\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u0011H\u0082@¢\u0006\u0004\ba\u0010[J\u001c\u0010b\u001a\u00020\b2\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010.H\u0002J\u0015\u0010c\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0016¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\u0011H\u0004J÷\u0001\u0010h\u001a\u0002H7\"\u0004\b\u0001\u001072\b\u00108\u001a\u0004\u0018\u0001092!\u0010i\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H70\u00072Q\u0010<\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002H70j2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H70;2S\b\u0002\u0010C\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001e¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(Z\u0012\u0004\u0012\u0002H70jH\u0082\b¢\u0006\u0002\u0010kJ`\u0010l\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\u0006\u00108\u001a\u00020+2!\u0010i\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b0\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0;H\u0082\bJ2\u0010m\u001a\u0004\u0018\u0001092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H\u0002J2\u0010n\u001a\u0004\u0018\u0001092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H\u0002J\"\u0010o\u001a\u00020\u001a*\u0002092\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\b\u0010p\u001a\u00020\bH\u0002J&\u0010q\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0011H\u0002J&\u0010s\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0011H\u0002J\u0012\u0010t\u001a\u00020\b2\b\b\u0002\u0010u\u001a\u00020\u0011H\u0002J\u0015\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u0011H\u0000¢\u0006\u0002\bxJ \u0010\u007f\u001a\u00020\b2\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u00012\b\u0010\"\u001a\u0004\u0018\u000109H\u0014J%\u0010\u0082\u0001\u001a\u00020\b2\u0006\u0010\"\u001a\u00028\u00002\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u0001H\u0002¢\u0006\u0003\u0010\u0083\u0001J!\u0010\u0084\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J\"\u0010\u0092\u0001\u001a\u00020\b2\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u00012\t\u0010\u0085\u0001\u001a\u0004\u0018\u000109H\u0002J\u0017\u0010\u0093\u0001\u001a\u00020\b2\f\u0010\u0080\u0001\u001a\u0007\u0012\u0002\b\u00030\u0081\u0001H\u0002J!\u0010\u0094\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J!\u0010\u0095\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J!\u0010\u0096\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0085\u0001\u001a\u0004\u0018\u0001092\t\u0010\u0086\u0001\u001a\u0004\u0018\u000109H\u0002J\u0011\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000 \u0001H\u0096\u0002J\t\u0010ª\u0001\u001a\u00020\bH\u0014J\u0015\u0010«\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\u0013\u0010\u00ad\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u0001J\u0007\u0010\u00ad\u0001\u001a\u00020\bJ \u0010\u00ad\u0001\u001a\u00020\b2\u0011\u0010¬\u0001\u001a\f\u0018\u00010¯\u0001j\u0005\u0018\u0001`®\u0001¢\u0006\u0003\u0010°\u0001J\u001b\u0010±\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0010¢\u0006\u0003\b²\u0001J\u001e\u0010³\u0001\u001a\u00020\u001a2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u009b\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u001aH\u0014J\t\u0010´\u0001\u001a\u00020\bH\u0002J1\u0010µ\u0001\u001a\u00020\b2&\u0010¶\u0001\u001a!\u0012\u0017\u0012\u0015\u0018\u00010\u009b\u0001¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(¬\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\t\u0010·\u0001\u001a\u00020\bH\u0002J\t\u0010¸\u0001\u001a\u00020\bH\u0002J\t\u0010¹\u0001\u001a\u00020\bH\u0002J\t\u0010º\u0001\u001a\u00020\bH\u0002J\u0018\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0007\u0010½\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010¾\u0001\u001a\u00020\b2\u0007\u0010½\u0001\u001a\u00020\u0011H\u0002J\u000f\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0018\u0010À\u0001\u001a\u00020\u00112\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0018\u0010Â\u0001\u001a\u00020\b2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J \u0010Ã\u0001\u001a\u00020\b2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010Ä\u0001\u001a\u00020\b*\u00020+H\u0002J\r\u0010Å\u0001\u001a\u00020\b*\u00020+H\u0002J\u0016\u0010Æ\u0001\u001a\u00020\b*\u00020+2\u0007\u0010Ç\u0001\u001a\u00020\u001aH\u0002J\u001b\u0010Ï\u0001\u001a\u00020\u001a2\u0007\u0010Ð\u0001\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u00020\u001aH\u0002J\u000f\u0010Ó\u0001\u001a\u00020\u001aH\u0000¢\u0006\u0003\bÔ\u0001J'\u0010Õ\u0001\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u0011H\u0002J)\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J)\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J2\u0010Ú\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001e2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\u0007\u0010Û\u0001\u001a\u00020\u0011H\u0002J!\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010×\u0001\u001a\u00020\u00112\r\u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0002J\u0012\u0010Ý\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010ß\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\u0011H\u0002J\n\u0010à\u0001\u001a\u00030á\u0001H\u0016J\u0010\u0010â\u0001\u001a\u00030á\u0001H\u0000¢\u0006\u0003\bã\u0001J\u0007\u0010ä\u0001\u001a\u00020\bJJ\u0010å\u0001\u001a#\u0012\u0005\u0012\u00030\u009b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000001\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0æ\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0002¢\u0006\u0003\u0010ç\u0001J4\u0010è\u0001\u001a\u00020\b2\b\u0010¬\u0001\u001a\u00030\u009b\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u0000012\b\u0010é\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\bê\u0001\u0010ë\u0001JM\u0010ì\u0001\u001a\u001e\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0j*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u00062\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010í\u0001JD\u0010ì\u0001\u001a\u001d\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0æ\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0002¢\u0006\u0003\u0010ç\u0001J+\u0010î\u0001\u001a\u00020\b2\b\u0010¬\u0001\u001a\u00030\u009b\u00012\u0006\u0010\"\u001a\u00028\u00002\b\u0010é\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0003\u0010ë\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00068\u0000X\u0081\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\t\u0010\f\u001a\u00020\rX\u0082\u0004R\t\u0010\u000e\u001a\u00020\rX\u0082\u0004R\t\u0010\u000f\u001a\u00020\rX\u0082\u0004R\u0014\u0010\u0010\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\t\u0010\u0018\u001a\u00020\rX\u0082\u0004R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0015\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0082\u0004R\u0015\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0082\u0004R\u0015\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e0\u001dX\u0082\u0004R,\u0010y\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000z8VX\u0096\u0004¢\u0006\f\u0012\u0004\b{\u0010|\u001a\u0004\b}\u0010~R%\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0088\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u0089\u0001\u0010|\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u008c\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000010\u0088\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u008d\u0001\u0010|\u001a\u0006\b\u008e\u0001\u0010\u008b\u0001R'\u0010\u008f\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0088\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u0090\u0001\u0010|\u001a\u0006\b\u0091\u0001\u0010\u008b\u0001R\u008f\u0001\u0010\u0097\u0001\u001ax\u0012\u0019\u0012\u0017\u0012\u0002\b\u00030\u0081\u0001¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0080\u0001\u0012\u0016\u0012\u0014\u0018\u000109¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u0099\u0001\u0012\u0016\u0012\u0014\u0018\u000109¢\u0006\r\b>\u0012\t\b?\u0012\u0005\b\b(\u009a\u0001\u0012 \u0012\u001e\u0012\u0005\u0012\u00030\u009b\u0001\u0012\u0006\u0012\u0004\u0018\u000109\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0004\u0012\u00020\b0j\u0018\u00010jj\u0005\u0018\u0001`\u0098\u0001X\u0082\u0004¢\u0006\f\n\u0003\u0010\u009e\u0001\u0012\u0005\b\u009d\u0001\u0010|R\u0012\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001dX\u0082\u0004R\u001a\u0010¢\u0001\u001a\u0005\u0018\u00010\u009b\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010¥\u0001\u001a\u00030\u009b\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010¤\u0001R\u0018\u0010§\u0001\u001a\u00030\u009b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010¤\u0001R\u0012\u0010©\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u001dX\u0082\u0004R\u0016\u0010»\u0001\u001a\u00020\u001a8TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b»\u0001\u0010\u001bR\u001d\u0010È\u0001\u001a\u00020\u001a8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÉ\u0001\u0010|\u001a\u0005\bÈ\u0001\u0010\u001bR\u001b\u0010Ê\u0001\u001a\u00020\u001a*\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u001d\u0010Ì\u0001\u001a\u00020\u001a8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÍ\u0001\u0010|\u001a\u0005\bÌ\u0001\u0010\u001bR\u001b\u0010Î\u0001\u001a\u00020\u001a*\u00020\u00118BX\u0082\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ë\u0001R\u001d\u0010Ñ\u0001\u001a\u00020\u001a8VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÒ\u0001\u0010|\u001a\u0005\bÑ\u0001\u0010\u001b¨\u0006ñ\u0001"}, m13886d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Channel;", ImageConst.ImageUpscaleConst.SHARED_MEM_CAPACITY, "", "onUndeliveredElement", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "Lkotlin/Function1;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "sendersAndCloseStatus", "Lkotlinx/atomicfu/AtomicLong;", "receivers", "bufferEnd", "sendersCounter", "", "getSendersCounter$kotlinx_coroutines_core", "()J", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "bufferEndCounter", "getBufferEndCounter", "completedExpandBuffersAndPauseFlag", "isRendezvousOrUnlimited", "", "()Z", "sendSegment", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/channels/ChannelSegment;", "receiveSegment", "bufferEndSegment", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSend", "sendOnNoWaiterSuspend", "segment", "index", "s", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSenderForSuspension", "Lkotlinx/coroutines/Waiter;", "onClosedSendOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "R", "waiter", "", "onRendezvousOrBuffered", "Lkotlin/Function0;", "onSuspend", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "segm", "i", "onClosed", "onNoWaiterSuspend", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "shouldSendSuspend", "curSendersAndCloseStatus", "bufferOrRendezvousSend", "curSenders", "shouldSendSuspend$kotlinx_coroutines_core", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "onReceiveEnqueued", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOnNoWaiterSuspend", "r", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "onClosedReceiveCatchingOnNoWaiterSuspend", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "receiveImpl", "onElementRetrieved", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "updateCellReceive", "updateCellReceiveSlow", "tryResumeSender", "expandBuffer", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "incCompletedExpandBufferAttempts", "nAttempts", "waitExpandBufferCompletion", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", Bixby2Constants.BIXBY_PARAM_SELECT, "Lkotlinx/coroutines/selects/SelectInstance;", "onClosedSelectOnSend", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "processResultSelectSend", "ignoredParam", "selectResult", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "registerSelectForReceive", "onClosedSelectOnReceive", "processResultSelectReceive", "processResultSelectReceiveOrNull", "processResultSelectReceiveCatching", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "param", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "Lkotlin/jvm/functions/Function3;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "_closeCause", "closeCause", "getCloseCause", "()Ljava/lang/Throwable;", "sendException", "getSendException", "receiveException", "getReceiveException", "closeHandler", "onClosedIdempotent", "close", "cause", "cancel", "Lkotlinx/coroutines/CancellationException;", "Ljava/util/concurrent/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "closeOrCancelImpl", "invokeCloseHandler", "invokeOnClose", "handler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "isConflatedDropOldest", "completeClose", "sendersCur", "completeCancel", "closeLinkedList", "markAllEmptyCellsAsClosed", "lastSegment", "removeUnprocessedElements", "cancelSuspendedReceiveRequests", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "isClosedForSend", "isClosedForSend$annotations", "isClosedForSend0", "(J)Z", "isClosedForReceive", "isClosedForReceive$annotations", "isClosedForReceive0", "isClosed", "sendersAndCloseStatusCur", "isEmpty", "isEmpty$annotations", "hasElements", "hasElements$kotlinx_coroutines_core", "isCellNonEmpty", "findSegmentSend", "id", "startFrom", "findSegmentReceive", "findSegmentBufferEnd", "currentBufferEndCounter", "moveSegmentBufferEndToSpecifiedOrLast", "updateSendersCounterIfLower", "value", "updateReceiversCounterIfLower", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "checkSegmentStructureInvariants", "bindCancellationFunResult", "Lkotlin/reflect/KFunction3;", "(Lkotlin/jvm/functions/Function1;)Lkotlin/reflect/KFunction;", "onCancellationChannelResultImplDoNotCall", "context", "onCancellationChannelResultImplDoNotCall-5_sEAP8", "(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "bindCancellationFun", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;", "onCancellationImplDoNotCall", "SendBroadcast", "BufferedChannelIterator", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3116:1\n270#1,6:3119\n277#1,68:3126\n394#1,18:3217\n241#1:3235\n266#1,10:3236\n277#1,48:3247\n415#1:3295\n331#1,14:3296\n419#1,3:3311\n241#1:3324\n266#1,10:3325\n277#1,68:3336\n241#1:3414\n266#1,10:3415\n277#1,68:3426\n241#1:3498\n266#1,10:3499\n277#1,68:3510\n241#1:3579\n266#1,10:3580\n277#1,68:3591\n906#1,52:3661\n984#1,8:3717\n878#1:3725\n902#1,33:3726\n994#1:3759\n936#1,14:3760\n955#1,3:3775\n999#1,6:3778\n906#1,52:3792\n984#1,8:3848\n878#1:3856\n902#1,33:3857\n994#1:3890\n936#1,14:3891\n955#1,3:3906\n999#1,6:3909\n878#1:3924\n902#1,48:3925\n955#1,3:3974\n878#1:3977\n902#1,48:3978\n955#1,3:4027\n241#1:4039\n266#1,10:4040\n277#1,68:4051\n878#1:4120\n902#1,48:4121\n955#1,3:4170\n1#2:3117\n3099#3:3118\n3099#3:3125\n3099#3:3246\n3099#3:3335\n3099#3:3425\n3099#3:3497\n3099#3:3509\n3099#3:3590\n3099#3:3660\n3099#3:3923\n3099#3:4030\n3099#3:4031\n3113#3:4032\n3113#3:4033\n3112#3:4034\n3112#3:4035\n3112#3:4036\n3113#3:4037\n3112#3:4038\n3099#3:4050\n3100#3:4173\n3099#3:4174\n3099#3:4175\n3099#3:4176\n3100#3:4177\n3099#3:4178\n3100#3:4201\n3099#3:4202\n3099#3:4203\n3100#3:4204\n3099#3:4254\n3100#3:4255\n3100#3:4256\n3100#3:4274\n3100#3:4275\n351#4,9:3194\n360#4,2:3211\n369#4,4:3213\n373#4,8:3314\n351#4,9:3405\n360#4,2:3495\n369#4,4:3713\n373#4,8:3784\n369#4,4:3844\n373#4,8:3915\n206#5:3203\n207#5:3206\n206#5:3207\n207#5:3210\n57#6,2:3204\n57#6,2:3208\n57#6,2:3322\n266#7:3310\n266#7:3404\n266#7:3494\n266#7:3578\n266#7:3659\n266#7:4119\n902#8:3774\n902#8:3905\n902#8:3973\n902#8:4026\n902#8:4169\n33#9,11:4179\n33#9,11:4190\n68#10,3:4205\n42#10,8:4208\n68#10,3:4216\n42#10,8:4219\n42#10,8:4227\n68#10,3:4235\n42#10,8:4238\n42#10,8:4246\n774#11:4257\n865#11,2:4258\n2318#11,14:4260\n774#11:4276\n865#11,2:4277\n2318#11,14:4279\n774#11:4293\n865#11,2:4294\n2318#11,14:4296\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n110#1:3119,6\n110#1:3126,68\n151#1:3217,18\n151#1:3235\n151#1:3236,10\n151#1:3247,48\n151#1:3295\n151#1:3296,14\n151#1:3311,3\n191#1:3324\n191#1:3325,10\n191#1:3336,68\n222#1:3414\n222#1:3415,10\n222#1:3426,68\n353#1:3498\n353#1:3499,10\n353#1:3510,68\n411#1:3579\n411#1:3580,10\n411#1:3591,68\n687#1:3661,52\n716#1:3717,8\n716#1:3725\n716#1:3726,33\n716#1:3759\n716#1:3760,14\n716#1:3775,3\n716#1:3778,6\n752#1:3792,52\n768#1:3848,8\n768#1:3856\n768#1:3857,33\n768#1:3890\n768#1:3891,14\n768#1:3906,3\n768#1:3909,6\n801#1:3924\n801#1:3925,48\n801#1:3974,3\n991#1:3977\n991#1:3978,48\n991#1:4027,3\n1484#1:4039\n1484#1:4040,10\n1484#1:4051,68\n1532#1:4120\n1532#1:4121,48\n1532#1:4170,3\n67#1:3118\n110#1:3125\n151#1:3246\n191#1:3335\n222#1:3425\n275#1:3497\n353#1:3509\n411#1:3590\n626#1:3660\n791#1:3923\n1027#1:4030\n1076#1:4031\n1394#1:4032\n1396#1:4033\n1426#1:4034\n1436#1:4035\n1445#1:4036\n1446#1:4037\n1453#1:4038\n1484#1:4050\n1898#1:4173\n1900#1:4174\n1902#1:4175\n1915#1:4176\n1926#1:4177\n1927#1:4178\n2229#1:4201\n2242#1:4202\n2252#1:4203\n2255#1:4204\n2572#1:4254\n2574#1:4255\n2599#1:4256\n2661#1:4274\n2662#1:4275\n131#1:3194,9\n131#1:3211,2\n150#1:3213,4\n150#1:3314,8\n218#1:3405,9\n218#1:3495,2\n715#1:3713,4\n715#1:3784,8\n766#1:3844,4\n766#1:3915,8\n135#1:3203\n135#1:3206\n138#1:3207\n138#1:3210\n135#1:3204,2\n138#1:3208,2\n180#1:3322,2\n151#1:3310\n191#1:3404\n222#1:3494\n353#1:3578\n411#1:3659\n1484#1:4119\n716#1:3774\n768#1:3905\n801#1:3973\n991#1:4026\n1532#1:4169\n2131#1:4179,11\n2186#1:4190,11\n2394#1:4205,3\n2394#1:4208,8\n2449#1:4216,3\n2449#1:4219,8\n2468#1:4227,8\n2498#1:4235,3\n2498#1:4238,8\n2559#1:4246,8\n2608#1:4257\n2608#1:4258,2\n2609#1:4260,14\n2673#1:4276\n2673#1:4277,2\n2674#1:4279,14\n2714#1:4293\n2714#1:4294,2\n2715#1:4296,14\n*E\n"})
public class BufferedChannel<E> implements Channel<E> {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    @JvmField
    @Nullable
    public final Function1<E, Unit> onUndeliveredElement;

    @Nullable
    private final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\tH\u0096B¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J,\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u000e\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "receiveResult", "", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedHasNext", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "onClosedHasNextNoWaiterSuspend", "next", "()Ljava/lang/Object;", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3116:1\n906#2,52:3117\n984#2,8:3173\n878#2:3181\n902#2,33:3182\n994#2:3215\n936#2,14:3216\n955#2,3:3231\n999#2,6:3234\n369#3,4:3169\n373#3,8:3240\n902#4:3230\n57#5,2:3248\n57#5,2:3251\n1#6:3250\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1619#1:3117,52\n1657#1:3173,8\n1657#1:3181\n1657#1:3182,33\n1657#1:3215\n1657#1:3216,14\n1657#1:3231,3\n1657#1:3234,6\n1655#1:3169,4\n1655#1:3240,8\n1657#1:3230\n1693#1:3248,2\n1741#1:3251,2\n*E\n"})
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {

        @Nullable
        private CancellableContinuationImpl<? super Boolean> continuation;

        @Nullable
        private Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super Boolean> continuation) throws Throwable {
            Boolean boolBoxBoolean;
            Function1<E, Unit> function1;
            ChannelSegment channelSegmentFindSegmentReceive;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            try {
                this.continuation = orCreateCancellableContinuation;
                try {
                    Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, j, this);
                    if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                        bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i);
                    } else {
                        Function3 function3BindCancellationFun = null;
                        if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                            if (j < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                            while (true) {
                                if (bufferedChannel.isClosedForReceive()) {
                                    onClosedHasNextNoWaiterSuspend();
                                    break;
                                }
                                long andIncrement = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                                int i2 = BufferedChannelKt.SEGMENT_SIZE;
                                long j2 = andIncrement / ((long) i2);
                                int i4 = (int) (andIncrement % ((long) i2));
                                if (channelSegment2.id != j2) {
                                    channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment2);
                                    if (channelSegmentFindSegmentReceive == null) {
                                    }
                                } else {
                                    channelSegmentFindSegmentReceive = channelSegment2;
                                }
                                objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i4, andIncrement, this);
                                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                                    bufferedChannel.prepareReceiverForSuspension(this, channelSegmentFindSegmentReceive, i4);
                                    break;
                                }
                                if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                        channelSegmentFindSegmentReceive.cleanPrev();
                                    }
                                    channelSegment2 = channelSegmentFindSegmentReceive;
                                } else {
                                    if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    channelSegmentFindSegmentReceive.cleanPrev();
                                    this.receiveResult = objUpdateCellReceive;
                                    this.continuation = null;
                                    boolBoxBoolean = Boxing.boxBoolean(true);
                                    function1 = bufferedChannel.onUndeliveredElement;
                                    if (function1 != null) {
                                    }
                                }
                            }
                            orCreateCancellableContinuation.resume(boolBoxBoolean, (Function3<? super Throwable, ? super Boolean, ? super CoroutineContext, Unit>) function3BindCancellationFun);
                        } else {
                            channelSegment.cleanPrev();
                            this.receiveResult = objUpdateCellReceive;
                            this.continuation = null;
                            boolBoxBoolean = Boxing.boxBoolean(true);
                            function1 = bufferedChannel.onUndeliveredElement;
                            if (function1 != null) {
                                function3BindCancellationFun = bufferedChannel.bindCancellationFun(function1, objUpdateCellReceive);
                            }
                            orCreateCancellableContinuation.resume(boolBoxBoolean, (Function3<? super Throwable, ? super Boolean, ? super CoroutineContext, Unit>) function3BindCancellationFun);
                        }
                    }
                    Object result = orCreateCancellableContinuation.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private final boolean onClosedHasNext() throws Throwable {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) throws Throwable {
            ChannelSegment<E> channelSegmentFindSegmentReceive;
            boolean zOnClosedHasNext = true;
            if (this.receiveResult == BufferedChannelKt.NO_RECEIVE_RESULT || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel<E> bufferedChannel = BufferedChannel.this;
                ChannelSegment<E> channelSegment = (ChannelSegment) BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                while (!bufferedChannel.isClosedForReceive()) {
                    long andIncrement = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                    int i = BufferedChannelKt.SEGMENT_SIZE;
                    long j = andIncrement / ((long) i);
                    int i2 = (int) (andIncrement % ((long) i));
                    if (channelSegment.id != j) {
                        channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                        if (channelSegmentFindSegmentReceive == null) {
                            continue;
                        }
                    } else {
                        channelSegmentFindSegmentReceive = channelSegment;
                    }
                    Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i2, andIncrement, null);
                    if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                        throw new IllegalStateException("unreachable");
                    }
                    if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegmentFindSegmentReceive.cleanPrev();
                        }
                        channelSegment = channelSegmentFindSegmentReceive;
                    } else {
                        if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                            return hasNextOnNoWaiterSuspend(channelSegmentFindSegmentReceive, i2, andIncrement, continuation);
                        }
                        channelSegmentFindSegmentReceive.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                    }
                }
                zOnClosedHasNext = onClosedHasNext();
            }
            return Boxing.boxBoolean(zOnClosedHasNext);
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object next(Continuation continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final boolean tryResumeHasNext(E element) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = element;
            Boolean bool = Boolean.TRUE;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            Function1<E, Unit> function1 = bufferedChannel.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, bool, function1 != null ? bufferedChannel.bindCancellationFun(function1, element) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() throws Throwable {
            E e = (E) this.receiveResult;
            if (e == BufferedChannelKt.NO_RECEIVE_RESULT) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e != BufferedChannelKt.getCHANNEL_CLOSED()) {
                return e;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m13886d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;

        @NotNull
        private final CancellableContinuation<Boolean> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(@NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
            this.cont = cancellableContinuation;
        }

        @NotNull
        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment<?> segment, int index) {
            this.$$delegate_0.invokeOnCancellation(segment, index);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BufferedChannel$bindCancellationFun$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class C132772 extends FunctionReferenceImpl implements Function3<Throwable, E, CoroutineContext, Unit> {
        public C132772(Object obj) {
            super(3, obj, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Object obj, CoroutineContext coroutineContext) {
            invoke2(th, obj, coroutineContext);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th, E e, CoroutineContext coroutineContext) {
            ((BufferedChannel) this.receiver).onCancellationImplDoNotCall(th, e, coroutineContext);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BufferedChannel$bindCancellationFunResult$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class C132781 extends FunctionReferenceImpl implements Function3<Throwable, ChannelResult<? extends E>, CoroutineContext, Unit> {
        public C132781(Object obj) {
            super(3, obj, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th, Object obj, CoroutineContext coroutineContext) {
            m23714invoke5_sEAP8(th, ((ChannelResult) obj).getHolder(), coroutineContext);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke-5_sEAP8, reason: not valid java name */
        public final void m23714invoke5_sEAP8(Throwable th, Object obj, CoroutineContext coroutineContext) {
            ((BufferedChannel) this.receiver).m23708onCancellationChannelResultImplDoNotCall5_sEAP8(th, obj, coroutineContext);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i, @Nullable Function1<? super E, Unit> function1) {
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.initialBufferEnd(i);
        this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
        ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment;
        this.receiveSegment$volatile = channelSegment;
        if (isRendezvousOrUnlimited()) {
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = channelSegment;
        this.onUndeliveredElementReceiveCancellationConstructor = function1 != 0 ? new Function3() { // from class: kotlinx.coroutines.channels.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BufferedChannel.m14208xa189d599(this.f9420a, (SelectInstance) obj, obj2, obj3);
            }
        } : null;
        this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3<Throwable, Object, CoroutineContext, Unit> bindCancellationFun(Function1<? super E, Unit> function1, E e) {
        return new C7884a(function1, e, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindCancellationFun$lambda$89(Function1 function1, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        OnUndeliveredElementKt.callUndeliveredElement(function1, obj, coroutineContext);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction<Unit> bindCancellationFunResult(Function1<? super E, Unit> function1) {
        return new C132781(this);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < getBufferEndCounter() || curSenders < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> lastSegment, long sendersCounter) {
        Object objM23754constructorimpl$default = InlineList.m23754constructorimpl$default(null, 1, null);
        loop0: while (lastSegment != null) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((lastSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i) < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                                break;
                            }
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                objM23754constructorimpl$default = InlineList.m23759plusFjFbRPM(objM23754constructorimpl$default, state$kotlinx_coroutines_core);
                                lastSegment.onCancelledRequest(i, true);
                                break;
                            }
                        } else {
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                objM23754constructorimpl$default = InlineList.m23759plusFjFbRPM(objM23754constructorimpl$default, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                lastSegment.onCancelledRequest(i, true);
                                break;
                            }
                        }
                    } else {
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
            lastSegment = (ChannelSegment) lastSegment.getPrev();
        }
        if (objM23754constructorimpl$default != null) {
            if (!(objM23754constructorimpl$default instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((Waiter) objM23754constructorimpl$default);
                return;
            }
            Intrinsics.checkNotNull(objM23754constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) objM23754constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object obj = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) obj);
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        ChannelSegment<E> channelSegmentCloseLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long jMarkAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(channelSegmentCloseLinkedList);
            if (jMarkAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(jMarkAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(channelSegmentCloseLinkedList, sendersCur);
        return channelSegmentCloseLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i);
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != j) {
                ChannelSegment<E> channelSegmentFindSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                if (channelSegmentFindSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % ((long) i)), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM23769getSegmentimpl = SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM23769getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM23769getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM23769getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentM23769getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM23769getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
        if (channelSegment.id <= id) {
            return channelSegment;
        }
        long j = channelSegment.id;
        int i = BufferedChannelKt.SEGMENT_SIZE;
        if (bufferEnd$volatile$FU.compareAndSet(this, currentBufferEndCounter + 1, j * ((long) i))) {
            incCompletedExpandBufferAttempts((channelSegment.id * ((long) i)) - currentBufferEndCounter);
        } else {
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> startFrom) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM23769getSegmentimpl = SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM23769getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM23769getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM23769getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentM23769getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM23769getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / ((long) BufferedChannelKt.SEGMENT_SIZE)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$volatile$FU;
            while (true) {
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.id >= channelSegment.id || !channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, segment2, channelSegment)) {
                    if (atomicReferenceFieldUpdater2.get(this) != segment2) {
                        if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                            channelSegment.remove();
                        }
                    }
                }
                if (segment2.decPointers$kotlinx_coroutines_core()) {
                    segment2.remove();
                }
            }
        }
        long j = channelSegment.id;
        if (j <= id) {
            return channelSegment;
        }
        int i = BufferedChannelKt.SEGMENT_SIZE;
        updateReceiversCounterIfLower(j * ((long) i));
        if (channelSegment.id * ((long) i) < getSendersCounter$kotlinx_coroutines_core()) {
            channelSegment.cleanPrev();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> startFrom) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
                Segment segmentM23769getSegmentimpl = SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM23769getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM23769getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentM23769getSegmentimpl)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentM23769getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                                segmentM23769getSegmentimpl.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m23771isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * ((long) BufferedChannelKt.SEGMENT_SIZE) < getReceiversCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m23769getSegmentimpl(objFindSegmentInternal);
        long j = channelSegment.id;
        if (j <= id) {
            return channelSegment;
        }
        int i = BufferedChannelKt.SEGMENT_SIZE;
        updateSendersCounterIfLower(j * ((long) i));
        if (channelSegment.id * ((long) i) < getReceiversCounter$kotlinx_coroutines_core()) {
            channelSegment.cleanPrev();
        }
        return null;
    }

    private final /* synthetic */ Object getAndUpdate$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1) {
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(obj);
            Object objInvoke = function1.invoke(obj2);
            while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, objInvoke)) {
                if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                    break;
                }
            }
            return obj2;
        }
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, nAttempts) & Longs.MAX_POWER_OF_TWO) != 0) {
            while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & Longs.MAX_POWER_OF_TWO) != 0) {
            }
        }
    }

    public static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j);
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        loop0: while (true) {
            obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        }
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> segment, int index, long globalIndex) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                return state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV && globalIndex == getReceiversCounter$kotlinx_coroutines_core();
            }
        } while (!segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i = (int) (sendersAndCloseStatusCur >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i == 2) {
            completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
            return (isClosedForReceive && hasElements$kotlinx_coroutines_core()) ? false : true;
        }
        if (i != 3) {
            throw new IllegalStateException(AbstractC0000a.m11h(i, "unexpected close status: ").toString());
        }
        completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
        return true;
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (kotlinx.coroutines.channels.ChannelSegment) r8.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> lastSegment) {
        do {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 >= i) {
                    break;
                }
                long j = (lastSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                        return j;
                    }
                }
            }
        } while (lastSegment != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (((int) (j >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 1)));
    }

    private final void markCancelled() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3)));
    }

    private final void markClosed() {
        long j;
        long jConstructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                jConstructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 2);
            } else if (i != 1) {
                return;
            } else {
                jConstructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, jConstructSendersAndCloseStatus));
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> startFrom) {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2;
        while (startFrom.id < id && (channelSegment2 = (ChannelSegment) startFrom.getNext()) != null) {
            startFrom = channelSegment2;
        }
        while (true) {
            if (!startFrom.isRemoved() || (channelSegment = (ChannelSegment) startFrom.getNext()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= startFrom.id) {
                        return;
                    }
                    if (!startFrom.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, startFrom)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (startFrom.decPointers$kotlinx_coroutines_core()) {
                                startFrom.remove();
                            }
                        }
                    }
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                        return;
                    }
                    return;
                }
            }
            startFrom = channelSegment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onCancellationChannelResultImplDoNotCall-5_sEAP8, reason: not valid java name */
    public final void m23708onCancellationChannelResultImplDoNotCall5_sEAP8(Throwable cause, Object element, CoroutineContext context) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        Object objM23724getOrNullimpl = ChannelResult.m23724getOrNullimpl(element);
        Intrinsics.checkNotNull(objM23724getOrNullimpl);
        OnUndeliveredElementKt.callUndeliveredElement(function1, objM23724getOrNullimpl, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCancellationImplDoNotCall(Throwable cause, E element, CoroutineContext context) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        OnUndeliveredElementKt.callUndeliveredElement(function1, element, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m22215constructorimpl(ChannelResult.m23719boximpl(ChannelResult.INSTANCE.m23732closedJP2dKIU(getCloseCause()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(E element, SelectInstance<?> select) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, select.getContext());
        }
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) == null) {
            Throwable sendException = getSendException();
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(sendException)));
        } else {
            ExceptionsKt.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, getSendException());
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(undeliveredElementExceptionCallUndeliveredElementCatchingException$default)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super Unit> cont) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        Throwable sendException = getSendException();
        Result.Companion companion = Result.INSTANCE;
        cont.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56 */
    public static final Function3 m14208xa189d599(final BufferedChannel bufferedChannel, final SelectInstance selectInstance, Object obj, final Object obj2) {
        return new Function3(bufferedChannel) { // from class: kotlinx.coroutines.channels.a

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ BufferedChannel f9418b;

            {
                this.f9418b = bufferedChannel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return BufferedChannel.m14209xc6272352(obj2, this.f9418b, selectInstance, (Throwable) obj3, obj4, (CoroutineContext) obj5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55 */
    public static final Unit m14209xc6272352(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        if (obj != BufferedChannelKt.getCHANNEL_CLOSED()) {
            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj, selectInstance.getContext());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceive(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        return ChannelResult.m23719boximpl(selectResult == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.INSTANCE.m23732closedJP2dKIU(getCloseCause()) : ChannelResult.INSTANCE.m23734successJP2dKIU(selectResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectSend(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    public static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) throws Throwable {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i);
            int i2 = (int) (andIncrement % ((long) i));
            if (channelSegment2.id != j) {
                ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i2, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return bufferedChannel2.receiveOnNoWaiterSuspend(channelSegment, i2, andIncrement, continuation);
                }
                channelSegment.cleanPrev();
                return objUpdateCellReceive;
            }
            if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            bufferedChannel = bufferedChannel2;
            channelSegment2 = channelSegment;
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object m23709receiveCatchingJP2dKIU$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super ChannelResult<? extends E>> continuation) throws Throwable {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        ChannelSegment<E> channelSegment;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuation;
            int i = bufferedChannel$receiveCatching$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label = i - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
            }
        }
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$12 = bufferedChannel$receiveCatching$1;
        Object obj = bufferedChannel$receiveCatching$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bufferedChannel$receiveCatching$12.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((ChannelResult) obj).getHolder();
        }
        ResultKt.throwOnFailure(obj);
        ChannelSegment<E> channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i4 = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i4);
            int i5 = (int) (andIncrement % ((long) i4));
            if (channelSegment2.id != j) {
                ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i5, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment.cleanPrev();
                    return ChannelResult.INSTANCE.m23734successJP2dKIU(objUpdateCellReceive);
                }
                bufferedChannel$receiveCatching$12.label = 1;
                Object objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel2.m23710receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i5, andIncrement, bufferedChannel$receiveCatching$12);
                return objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutine_suspended ? coroutine_suspended : objM23710receiveCatchingOnNoWaiterSuspendGKJJFZk;
            }
            if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            bufferedChannel = bufferedChannel2;
            channelSegment2 = channelSegment;
        }
        return ChannelResult.INSTANCE.m23732closedJP2dKIU(bufferedChannel.getCloseCause());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m23710receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super ChannelResult<? extends E>> continuation) throws Throwable {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        ReceiveCatching receiveCatching;
        ChannelResult channelResultM23719boximpl;
        ChannelSegment channelSegment2;
        if (continuation instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            int i2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = i2 - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
            }
        }
        Object result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(result);
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0 = this;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1 = channelSegment;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0 = i;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0 = j;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
            try {
                Intrinsics.checkNotNull(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");
                receiveCatching = new ReceiveCatching(orCreateCancellableContinuation);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, receiveCatching);
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                    prepareReceiverForSuspension(receiveCatching, channelSegment, i);
                } else {
                    KFunction kFunctionBindCancellationFunResult = null;
                    if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                        if (j < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment3 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                        while (true) {
                            if (isClosedForReceive()) {
                                onClosedReceiveCatchingOnNoWaiterSuspend(orCreateCancellableContinuation);
                                break;
                            }
                            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                            int i5 = BufferedChannelKt.SEGMENT_SIZE;
                            long j2 = andIncrement / ((long) i5);
                            int i6 = (int) (andIncrement % ((long) i5));
                            if (channelSegment3.id != j2) {
                                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment3);
                                if (channelSegmentFindSegmentReceive != null) {
                                    channelSegment2 = channelSegmentFindSegmentReceive;
                                }
                            } else {
                                channelSegment2 = channelSegment3;
                            }
                            Object objUpdateCellReceive2 = updateCellReceive(channelSegment2, i6, andIncrement, receiveCatching);
                            ChannelSegment channelSegment4 = channelSegment2;
                            if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND) {
                                prepareReceiverForSuspension(receiveCatching, channelSegment4, i6);
                                break;
                            }
                            if (objUpdateCellReceive2 == BufferedChannelKt.FAILED) {
                                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment4.cleanPrev();
                                }
                                channelSegment3 = channelSegment4;
                            } else {
                                if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                    throw new IllegalStateException("unexpected");
                                }
                                channelSegment4.cleanPrev();
                                channelResultM23719boximpl = ChannelResult.m23719boximpl(ChannelResult.INSTANCE.m23734successJP2dKIU(objUpdateCellReceive2));
                                Function1<E, Unit> function1 = this.onUndeliveredElement;
                                if (function1 != null) {
                                    kFunctionBindCancellationFunResult = bindCancellationFunResult(function1);
                                }
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        channelResultM23719boximpl = ChannelResult.m23719boximpl(ChannelResult.INSTANCE.m23734successJP2dKIU(objUpdateCellReceive));
                        Function1<E, Unit> function12 = this.onUndeliveredElement;
                        if (function12 != null) {
                            kFunctionBindCancellationFunResult = bindCancellationFunResult(function12);
                        }
                    }
                    orCreateCancellableContinuation.resume(channelResultM23719boximpl, (Function3<? super Throwable, ? super ChannelResult, ? super CoroutineContext, Unit>) kFunctionBindCancellationFunResult);
                }
                result = orCreateCancellableContinuation.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th3;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((ChannelResult) result).getHolder();
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> onElementRetrieved, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onSuspend, Function0<? extends R> onClosed, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onNoWaiterSuspend) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i);
            int i2 = (int) (andIncrement % ((long) i));
            if (channelSegment2.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object obj = waiter;
            Symbol symbol = (Object) updateCellReceive(channelSegment, i2, andIncrement, obj);
            channelSegment2 = channelSegment;
            if (symbol == BufferedChannelKt.SUSPEND) {
                Waiter waiter2 = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter2 != null) {
                    prepareReceiverForSuspension(waiter2, channelSegment2, i2);
                }
                return onSuspend.invoke(channelSegment2, Integer.valueOf(i2), Long.valueOf(andIncrement));
            }
            if (symbol != BufferedChannelKt.FAILED) {
                if (symbol == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return onNoWaiterSuspend.invoke(channelSegment2, Integer.valueOf(i2), Long.valueOf(andIncrement));
                }
                channelSegment2.cleanPrev();
                return onElementRetrieved.invoke(symbol);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            waiter = obj;
        }
        return onClosed.invoke();
    }

    public static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i, Object obj2) {
        ChannelSegment channelSegment;
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        if ((i & 16) != 0) {
            function32 = new Function3() { // from class: kotlinx.coroutines.channels.BufferedChannel.receiveImpl.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4, Object obj5) {
                    return invoke((ChannelSegment) obj3, ((Number) obj4).intValue(), ((Number) obj5).longValue());
                }

                public final Void invoke(ChannelSegment<E> channelSegment2, int i2, long j) {
                    throw new IllegalStateException("unexpected");
                }
            };
        }
        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i2);
            int i4 = (int) (andIncrement % ((long) i2));
            if (channelSegment2.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel2 = bufferedChannel;
            Object obj3 = obj;
            Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i4, andIncrement, obj3);
            channelSegment2 = channelSegment;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj3 instanceof Waiter ? (Waiter) obj3 : null;
                if (waiter != null) {
                    bufferedChannel2.prepareReceiverForSuspension(waiter, channelSegment2, i4);
                }
                return function3.invoke(channelSegment2, Integer.valueOf(i4), Long.valueOf(andIncrement));
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return function32.invoke(channelSegment2, Integer.valueOf(i4), Long.valueOf(andIncrement));
                }
                channelSegment2.cleanPrev();
                return function1.invoke(objUpdateCellReceive);
            }
            if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            bufferedChannel = bufferedChannel2;
            obj = obj3;
        }
        return function0.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> segment, int index, long r, Waiter waiter, Function1<? super E, Unit> onElementRetrieved, Function0<Unit> onClosed) {
        ChannelSegment channelSegment;
        Symbol symbol = (Object) updateCellReceive(segment, index, r, waiter);
        BufferedChannel<E> bufferedChannel = this;
        if (symbol == BufferedChannelKt.SUSPEND) {
            prepareReceiverForSuspension(waiter, segment, index);
            return;
        }
        if (symbol != BufferedChannelKt.FAILED) {
            segment.cleanPrev();
            onElementRetrieved.invoke(symbol);
            return;
        }
        if (r < getSendersCounter$kotlinx_coroutines_core()) {
            segment.cleanPrev();
        }
        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i);
            int i2 = (int) (andIncrement % ((long) i));
            if (channelSegment2.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            Symbol symbol2 = (Object) bufferedChannel2.updateCellReceive(channelSegment, i2, andIncrement, waiter);
            channelSegment2 = channelSegment;
            if (symbol2 == BufferedChannelKt.SUSPEND) {
                Waiter waiter2 = waiter != null ? waiter : null;
                if (waiter2 != null) {
                    prepareReceiverForSuspension(waiter2, channelSegment2, i2);
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            if (symbol2 != BufferedChannelKt.FAILED) {
                if (symbol2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment2.cleanPrev();
                onElementRetrieved.invoke(symbol2);
                return;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            bufferedChannel = bufferedChannel2;
        }
        onClosed.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super E> continuation) {
        ChannelSegment channelSegment2;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, orCreateCancellableContinuation);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                prepareReceiverForSuspension(orCreateCancellableContinuation, channelSegment, i);
            } else {
                KFunction kFunctionBindCancellationFun = null;
                kFunctionBindCancellationFun = null;
                if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                    if (j < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    ChannelSegment channelSegment3 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            onClosedReceiveOnNoWaiterSuspend(orCreateCancellableContinuation);
                            break;
                        }
                        long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                        int i2 = BufferedChannelKt.SEGMENT_SIZE;
                        long j2 = andIncrement / ((long) i2);
                        int i4 = (int) (andIncrement % ((long) i2));
                        if (channelSegment3.id != j2) {
                            ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment3);
                            if (channelSegmentFindSegmentReceive != null) {
                                channelSegment2 = channelSegmentFindSegmentReceive;
                            }
                        } else {
                            channelSegment2 = channelSegment3;
                        }
                        objUpdateCellReceive = updateCellReceive(channelSegment2, i4, andIncrement, orCreateCancellableContinuation);
                        ChannelSegment channelSegment4 = channelSegment2;
                        if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                            CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                            if (cancellableContinuationImpl != null) {
                                prepareReceiverForSuspension(cancellableContinuationImpl, channelSegment4, i4);
                            }
                        } else if (objUpdateCellReceive == BufferedChannelKt.FAILED) {
                            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment4.cleanPrev();
                            }
                            channelSegment3 = channelSegment4;
                        } else {
                            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment4.cleanPrev();
                            Function1<E, Unit> function1 = this.onUndeliveredElement;
                            if (function1 != null) {
                                kFunctionBindCancellationFun = bindCancellationFun(function1);
                            }
                        }
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, Unit> function12 = this.onUndeliveredElement;
                    if (function12 != null) {
                        kFunctionBindCancellationFun = bindCancellationFun(function12);
                    }
                }
                orCreateCancellableContinuation.resume(objUpdateCellReceive, (Function3<? super Throwable, ? super Object, ? super CoroutineContext, Unit>) kFunctionBindCancellationFun);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / ((long) i);
            int i2 = (int) (andIncrement % ((long) i));
            if (channelSegment2.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance<?> selectInstance = select;
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i2, andIncrement, selectInstance);
            channelSegment2 = channelSegment;
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment2, i2);
                    return;
                }
                return;
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment2.cleanPrev();
                selectInstance.selectInRegistrationPhase(objUpdateCellReceive);
                return;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment2.cleanPrev();
            }
            select = selectInstance;
        }
        onClosedSelectOnReceive(select);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeUnprocessedElements(ChannelSegment<E> lastSegment) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = null;
        Object objM23754constructorimpl$default = InlineList.m23754constructorimpl$default(null, 1, null);
        loop0: do {
            int i = BufferedChannelKt.SEGMENT_SIZE - 1;
            while (true) {
                if (-1 >= i) {
                    break;
                }
                long j = (lastSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV) {
                        break loop0;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER && state$kotlinx_coroutines_core != null) {
                            if (!(state$kotlinx_coroutines_core instanceof Waiter) && !(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB) {
                                        break;
                                    }
                                } else {
                                    break loop0;
                                }
                            } else {
                                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                    break loop0;
                                }
                                Waiter waiter = state$kotlinx_coroutines_core instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core).waiter : (Waiter) state$kotlinx_coroutines_core;
                                if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    if (function1 != null) {
                                        undeliveredElementExceptionCallUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i), undeliveredElementExceptionCallUndeliveredElementCatchingException);
                                    }
                                    objM23754constructorimpl$default = InlineList.m23759plusFjFbRPM(objM23754constructorimpl$default, waiter);
                                    lastSegment.cleanElement$kotlinx_coroutines_core(i);
                                    lastSegment.onSlotCleaned();
                                }
                            }
                        } else {
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                lastSegment.onSlotCleaned();
                                break;
                            }
                        }
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (function1 != null) {
                                undeliveredElementExceptionCallUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i), undeliveredElementExceptionCallUndeliveredElementCatchingException);
                            }
                            lastSegment.cleanElement$kotlinx_coroutines_core(i);
                            lastSegment.onSlotCleaned();
                        }
                    }
                }
                i--;
            }
        } while (lastSegment != null);
        if (objM23754constructorimpl$default != null) {
            if (objM23754constructorimpl$default instanceof ArrayList) {
                Intrinsics.checkNotNull(objM23754constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                ArrayList arrayList = (ArrayList) objM23754constructorimpl$default;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    resumeSenderOnCancelledChannel((Waiter) arrayList.get(size));
                }
            } else {
                resumeSenderOnCancelledChannel((Waiter) objM23754constructorimpl$default);
            }
        }
        if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
            throw undeliveredElementExceptionCallUndeliveredElementCatchingException;
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation<Boolean> cont = ((SendBroadcast) waiter).getCont();
            Result.Companion companion = Result.INSTANCE;
            cont.resumeWith(Result.m22215constructorimpl(Boolean.FALSE));
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) waiter).cont;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(ChannelResult.m23719boximpl(ChannelResult.INSTANCE.m23732closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Unit> continuation) {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            if (channelSegment2.id != j2) {
                ChannelSegment<E> channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    Object objOnClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (objOnClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objOnClosedSend;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            E e2 = e;
            int iUpdateCellSend = bufferedChannel2.updateCellSend(channelSegment, i2, e2, j, null, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    Object objSendOnNoWaiterSuspend = bufferedChannel2.sendOnNoWaiterSuspend(channelSegment, i2, e2, j, continuation);
                    if (objSendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objSendOnNoWaiterSuspend;
                    }
                } else if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    bufferedChannel = bufferedChannel2;
                    channelSegment2 = channelSegment;
                    e = e2;
                } else {
                    if (j < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object objOnClosedSend2 = bufferedChannel2.onClosedSend(e2, continuation);
                    if (objOnClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objOnClosedSend2;
                    }
                }
            } else if (zIsClosedForSend0) {
                channelSegment.onSlotCleaned();
                Object objOnClosedSend3 = bufferedChannel2.onClosedSend(e2, continuation);
                if (objOnClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return objOnClosedSend3;
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        r13 = kotlin.Result.INSTANCE;
        r0.resumeWith(kotlin.Result.m22215constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Boolean> continuation) {
        ChannelSegment channelSegmentFindSegmentSend;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (bufferedChannel.onUndeliveredElement != null) {
            throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`");
        }
        SendBroadcast sendBroadcast = new SendBroadcast(cancellableContinuationImpl);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            if (channelSegment.id != j2) {
                channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend == null) {
                    if (zIsClosedForSend0) {
                        break;
                    }
                }
            } else {
                channelSegmentFindSegmentSend = channelSegment;
            }
            E e2 = e;
            BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            int iUpdateCellSend = bufferedChannel2.updateCellSend(channelSegmentFindSegmentSend, i2, e2, j, sendBroadcast, zIsClosedForSend0);
            channelSegment = channelSegmentFindSegmentSend;
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    bufferedChannel = bufferedChannel2;
                    e = e2;
                } else if (j < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else if (zIsClosedForSend0) {
                channelSegment.onSlotCleaned();
            } else {
                bufferedChannel2.prepareSenderForSuspension(sendBroadcast, channelSegment, i2);
            }
        }
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(Result.m22215constructorimpl(Boxing.boxBoolean(false)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final <R> R sendImpl(E element, Object waiter, Function0<? extends R> onRendezvousOrBuffered, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, Function0<? extends R> onClosed, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        BufferedChannel<E> bufferedChannel;
        E e;
        Object obj;
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            if (channelSegment.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                    bufferedChannel = this;
                    obj = waiter;
                    e = element;
                } else if (zIsClosedForSend0) {
                    return onClosed.invoke();
                }
            } else {
                bufferedChannel = this;
                e = element;
                obj = waiter;
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, e, j, obj, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return onRendezvousOrBuffered.invoke();
            }
            if (iUpdateCellSend == 1) {
                return onRendezvousOrBuffered.invoke();
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return onClosed.invoke();
                }
                Waiter waiter2 = waiter instanceof Waiter ? (Waiter) waiter : null;
                if (waiter2 != null) {
                    prepareSenderForSuspension(waiter2, channelSegment, i2);
                }
                return onSuspend.invoke(channelSegment, Integer.valueOf(i2));
            }
            if (iUpdateCellSend == 3) {
                return onNoWaiterSuspend.invoke(channelSegment, Integer.valueOf(i2), element, Long.valueOf(j));
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return onClosed.invoke();
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
        }
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        BufferedChannel bufferedChannel2;
        Object obj4;
        Object obj5;
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        Function4 function42 = (i & 32) != 0 ? new Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel.sendImpl.1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) {
                return invoke((ChannelSegment<Object>) obj6, ((Number) obj7).intValue(), obj8, ((Number) obj9).longValue());
            }

            public final Void invoke(ChannelSegment<E> channelSegment, int i2, E e, long j) {
                throw new IllegalStateException("unexpected");
            }
        } : function4;
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i2);
            int i4 = (int) (j % ((long) i2));
            if (channelSegment.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                    bufferedChannel2 = bufferedChannel;
                    obj5 = obj2;
                    obj4 = obj;
                } else if (zIsClosedForSend0) {
                    return function02.invoke();
                }
            } else {
                bufferedChannel2 = bufferedChannel;
                obj4 = obj;
                obj5 = obj2;
            }
            int iUpdateCellSend = bufferedChannel2.updateCellSend(channelSegment, i4, obj4, j, obj5, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return function0.invoke();
            }
            if (iUpdateCellSend == 1) {
                return function0.invoke();
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return function02.invoke();
                }
                Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                if (waiter != null) {
                    bufferedChannel.prepareSenderForSuspension(waiter, channelSegment, i4);
                }
                return function2.invoke(channelSegment, Integer.valueOf(i4));
            }
            if (iUpdateCellSend == 3) {
                return function42.invoke(channelSegment, Integer.valueOf(i4), obj, Long.valueOf(j));
            }
            if (iUpdateCellSend == 4) {
                if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return function02.invoke();
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
        }
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> segment, int index, E element, long s, Waiter waiter, Function0<Unit> onRendezvousOrBuffered, Function0<Unit> onClosed) {
        BufferedChannel<E> bufferedChannel;
        E e;
        Waiter waiter2;
        Unit unitInvoke;
        int iUpdateCellSend = updateCellSend(segment, index, element, s, waiter, false);
        if (iUpdateCellSend == 0) {
            segment.cleanPrev();
            onRendezvousOrBuffered.invoke();
            return;
        }
        if (iUpdateCellSend == 1) {
            onRendezvousOrBuffered.invoke();
            return;
        }
        if (iUpdateCellSend == 2) {
            prepareSenderForSuspension(waiter, segment, index);
            return;
        }
        if (iUpdateCellSend == 4) {
            if (s < getReceiversCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
            }
            onClosed.invoke();
            return;
        }
        String str = "unexpected";
        if (iUpdateCellSend != 5) {
            throw new IllegalStateException("unexpected");
        }
        segment.cleanPrev();
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            String str2 = str;
            if (channelSegment.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                    bufferedChannel = this;
                    waiter2 = waiter;
                    e = element;
                } else {
                    if (zIsClosedForSend0) {
                        unitInvoke = onClosed.invoke();
                        break;
                    }
                    str = str2;
                }
            } else {
                bufferedChannel = this;
                e = element;
                waiter2 = waiter;
            }
            int iUpdateCellSend2 = bufferedChannel.updateCellSend(channelSegment, i2, e, j, waiter2, zIsClosedForSend0);
            if (iUpdateCellSend2 == 0) {
                channelSegment.cleanPrev();
                unitInvoke = onRendezvousOrBuffered.invoke();
                break;
            }
            if (iUpdateCellSend2 == 1) {
                unitInvoke = onRendezvousOrBuffered.invoke();
                break;
            }
            if (iUpdateCellSend2 != 2) {
                if (iUpdateCellSend2 == 3) {
                    throw new IllegalStateException(str2);
                }
                if (iUpdateCellSend2 != 4) {
                    if (iUpdateCellSend2 == 5) {
                        channelSegment.cleanPrev();
                    }
                    str = str2;
                } else {
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    unitInvoke = onClosed.invoke();
                }
            } else if (zIsClosedForSend0) {
                channelSegment.onSlotCleaned();
                unitInvoke = onClosed.invoke();
            } else {
                Waiter waiter3 = waiter2 != null ? waiter2 : null;
                if (waiter3 != null) {
                    prepareSenderForSuspension(waiter3, channelSegment, i2);
                }
                unitInvoke = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, E e, long j, Continuation<? super Unit> continuation) {
        Unit unit;
        Object result;
        ChannelSegment channelSegmentFindSegmentSend;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            int iUpdateCellSend = updateCellSend(channelSegment, i, e, j, orCreateCancellableContinuation, false);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                Result.Companion companion = Result.INSTANCE;
                unit = Unit.INSTANCE;
            } else {
                if (iUpdateCellSend != 1) {
                    if (iUpdateCellSend != 2) {
                        if (iUpdateCellSend != 4) {
                            String str = "unexpected";
                            if (iUpdateCellSend != 5) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment.cleanPrev();
                            ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
                            while (true) {
                                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                                long j2 = 1152921504606846975L & andIncrement;
                                boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
                                int i2 = BufferedChannelKt.SEGMENT_SIZE;
                                long j3 = j2 / ((long) i2);
                                int i4 = (int) (j2 % ((long) i2));
                                String str2 = str;
                                if (channelSegment2.id != j3) {
                                    channelSegmentFindSegmentSend = findSegmentSend(j3, channelSegment2);
                                    if (channelSegmentFindSegmentSend == null) {
                                        if (zIsClosedForSend0) {
                                            break;
                                        }
                                        str = str2;
                                    }
                                } else {
                                    channelSegmentFindSegmentSend = channelSegment2;
                                }
                                int iUpdateCellSend2 = updateCellSend(channelSegmentFindSegmentSend, i4, e, j2, orCreateCancellableContinuation, zIsClosedForSend0);
                                if (iUpdateCellSend2 == 0) {
                                    channelSegmentFindSegmentSend.cleanPrev();
                                    Result.Companion companion2 = Result.INSTANCE;
                                    unit = Unit.INSTANCE;
                                    break;
                                }
                                if (iUpdateCellSend2 == 1) {
                                    Result.Companion companion3 = Result.INSTANCE;
                                    unit = Unit.INSTANCE;
                                    break;
                                }
                                if (iUpdateCellSend2 != 2) {
                                    if (iUpdateCellSend2 == 3) {
                                        throw new IllegalStateException(str2);
                                    }
                                    if (iUpdateCellSend2 != 4) {
                                        if (iUpdateCellSend2 == 5) {
                                            channelSegmentFindSegmentSend.cleanPrev();
                                        }
                                        str = str2;
                                        channelSegment2 = channelSegmentFindSegmentSend;
                                    } else if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                        channelSegmentFindSegmentSend.cleanPrev();
                                    }
                                } else if (zIsClosedForSend0) {
                                    channelSegmentFindSegmentSend.onSlotCleaned();
                                } else {
                                    CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                                    if (cancellableContinuationImpl != null) {
                                        prepareSenderForSuspension(cancellableContinuationImpl, channelSegmentFindSegmentSend, i4);
                                    }
                                }
                            }
                        } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        onClosedSendOnNoWaiterSuspend(e, orCreateCancellableContinuation);
                    } else {
                        prepareSenderForSuspension(orCreateCancellableContinuation, channelSegment, i);
                    }
                    result = orCreateCancellableContinuation.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result != IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
                }
                Result.Companion companion4 = Result.INSTANCE;
                unit = Unit.INSTANCE;
            }
            orCreateCancellableContinuation.resumeWith(Result.m22215constructorimpl(unit));
            result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        return !bufferOrRendezvousSend(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) obj).cont;
            ChannelResult channelResultM23719boximpl = ChannelResult.m23719boximpl(ChannelResult.INSTANCE.m23734successJP2dKIU(e));
            Function1<E, Unit> function1 = this.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, channelResultM23719boximpl, (Function3) (function1 != null ? bindCancellationFunResult(function1) : null));
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e);
        }
        if (!(obj instanceof CancellableContinuation)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
        Function1<E, Unit> function12 = this.onUndeliveredElement;
        return BufferedChannelKt.tryResume0(cancellableContinuation, e, (Function3) (function12 != null ? bindCancellationFun(function12) : null));
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, null, 2, null);
        }
        if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultTrySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            return trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final /* synthetic */ void update$atomicfu(Object obj, AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1) {
        while (true) {
            long j = atomicLongFieldUpdater.get(obj);
            Object obj2 = obj;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            if (atomicLongFieldUpdater2.compareAndSet(obj2, j, function1.invoke(Long.valueOf(j)).longValue())) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            obj = obj2;
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> segment, int index, long b) {
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (!(state$kotlinx_coroutines_core instanceof Waiter) || b < receivers$volatile$FU.get(this) || !segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
            return updateCellExpandBufferSlow(segment, index, b);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
            return true;
        }
        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_SEND);
        segment.onCancelledRequest(index, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> segment, int index, long b) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                if (b < receivers$volatile$FU.get(this)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_SEND);
                    segment.onCancelledRequest(index, false);
                    return false;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return true;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> segment, int index, long r, Object waiter) {
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (r >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return segment.retrieveElement$kotlinx_coroutines_core(index);
        }
        return updateCellReceiveSlow(segment, index, r, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> segment, int index, long r, Object waiter) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (r < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else {
                    if (waiter == null) {
                        return BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.INTERRUPTED_SEND && state$kotlinx_coroutines_core != BufferedChannelKt.POISONED) {
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            expandBuffer();
                            return BufferedChannelKt.FAILED;
                        }
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV)) {
                            boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                            if (z) {
                                state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                            }
                            if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.DONE_RCV);
                                expandBuffer();
                                return segment.retrieveElement$kotlinx_coroutines_core(index);
                            }
                            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_SEND);
                            segment.onCancelledRequest(index, false);
                            if (z) {
                                expandBuffer();
                            }
                            return BufferedChannelKt.FAILED;
                        }
                    }
                    return BufferedChannelKt.FAILED;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return segment.retrieveElement$kotlinx_coroutines_core(index);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return updateCellSendSlow(segment, index, element, s, waiter, closed);
        }
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(s)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            }
            if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_RCV) == BufferedChannelKt.INTERRUPTED_RCV) {
                return 5;
            }
            segment.onCancelledRequest(index, true);
            return 5;
        }
        return updateCellSendSlow(segment, index, element, s, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(s) || closed) {
                    if (closed) {
                        if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            segment.onCancelledRequest(index, false);
                            return 4;
                        }
                    } else {
                        if (waiter == null) {
                            return 3;
                        }
                        if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                            return 2;
                        }
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        completeCloseOrCancel();
                        return 4;
                    }
                    segment.cleanElement$kotlinx_coroutines_core(index);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.DONE_RCV);
                        onReceiveDequeued();
                        return 0;
                    }
                    if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                        segment.onCancelledRequest(index, true);
                    }
                    return 5;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            }
        }
    }

    private final void updateReceiversCounterIfLower(long value) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if (j >= value) {
                return;
            }
            long j2 = value;
            if (receivers$volatile$FU.compareAndSet(this, j, j2)) {
                return;
            } else {
                value = j2;
            }
        }
    }

    private final void updateSendersCounterIfLower(long value) {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            j2 = 1152921504606846975L & j;
            if (j2 >= value) {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(j2, (int) (j >> 60))));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(@Nullable Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(cause, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSegmentStructureInvariants() {
        if (isRendezvousOrUnlimited()) {
            if (bufferEndSegment$volatile$FU.get(this) != BufferedChannelKt.NULL_SEGMENT) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id > ((ChannelSegment) bufferEndSegment$volatile$FU.get(this)).id) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        List listListOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        if (channelSegment.getPrev() != 0) {
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        while (channelSegment.getNext() != 0) {
            S next3 = channelSegment.getNext();
            Intrinsics.checkNotNull(next3);
            if (((ChannelSegment) next3).getPrev() != 0) {
                S next4 = channelSegment.getNext();
                Intrinsics.checkNotNull(next4);
                if (((ChannelSegment) next4).getPrev() != channelSegment) {
                    throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                }
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            int i2 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i4);
                if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED) && !(state$kotlinx_coroutines_core instanceof Waiter)) {
                    if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_SEND) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        if (channelSegment.getElement$kotlinx_coroutines_core(i4) != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        i2++;
                    } else {
                        if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.POISONED) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                            throw new IllegalStateException(("Unexpected segment cell state: " + state$kotlinx_coroutines_core + ".\nChannel state: " + this).toString());
                        }
                        if (channelSegment.getElement$kotlinx_coroutines_core(i4) != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                    }
                }
            }
            if (i2 == BufferedChannelKt.SEGMENT_SIZE && channelSegment != receiveSegment$volatile$FU.get(this) && channelSegment != sendSegment$volatile$FU.get(this) && channelSegment != bufferEndSegment$volatile$FU.get(this)) {
                throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
            }
            S next5 = channelSegment.getNext();
            Intrinsics.checkNotNull(next5);
            channelSegment = (ChannelSegment) next5;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    public boolean closeOrCancelImpl(@Nullable Throwable cause, boolean cancel) {
        boolean z;
        if (cancel) {
            markCancellationStarted();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _closeCause$volatile$FU;
        Symbol symbol = BufferedChannelKt.NO_CLOSE_CAUSE;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, cause)) {
                z = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != symbol) {
                z = false;
                break;
            }
        }
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (z) {
            invokeCloseHandler();
        }
        return z;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        ChannelSegment<E> channelSegmentFindSegmentReceive;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            long j = receivers$volatile$FU.get(this);
            if (globalCellIndex < Math.max(((long) this.capacity) + j, getBufferEndCounter())) {
                return;
            }
            if (receivers$volatile$FU.compareAndSet(this, j, 1 + j)) {
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = j / ((long) i);
                int i2 = (int) (j % ((long) i));
                if (channelSegment.id != j2) {
                    channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    }
                } else {
                    channelSegmentFindSegmentReceive = channelSegment;
                }
                Object objUpdateCellReceive = updateCellReceive(channelSegmentFindSegmentReceive, i2, j, null);
                if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                    channelSegmentFindSegmentReceive.cleanPrev();
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, objUpdateCellReceive, null, 2, null)) != null) {
                        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
                    }
                } else if (j < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegmentFindSegmentReceive.cleanPrev();
                }
                channelSegment = channelSegmentFindSegmentReceive;
            }
        }
    }

    @Nullable
    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    @NotNull
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> channelSegmentFindSegmentReceive = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = receiversCounter$kotlinx_coroutines_core / ((long) i);
            if (channelSegmentFindSegmentReceive.id == j || (channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegmentFindSegmentReceive)) != null) {
                channelSegmentFindSegmentReceive.cleanPrev();
                if (isCellNonEmpty(channelSegmentFindSegmentReceive, (int) (receiversCounter$kotlinx_coroutines_core % ((long) i)), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id < j) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, null, handler)) {
            if (atomicReferenceFieldUpdater.get(this) != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = closeHandler$volatile$FU;
                while (true) {
                    Object obj = atomicReferenceFieldUpdater2.get(this);
                    if (obj != BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                        if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = closeHandler$volatile$FU;
                    Symbol symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
                    Symbol symbol2 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
                    while (!atomicReferenceFieldUpdater3.compareAndSet(this, symbol, symbol2)) {
                        if (atomicReferenceFieldUpdater3.get(this) != symbol) {
                            break;
                        }
                    }
                    handler.invoke(getCloseCause());
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return (E) Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo23711receiveCatchingJP2dKIU(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        return m23709receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    @Nullable
    public Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i);
            int i2 = (int) (j % ((long) i));
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    onClosedSelectOnSend(element, select);
                    return;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance<?> selectInstance = select;
            Object obj = element;
            int iUpdateCellSend = updateCellSend(channelSegment, i2, obj, j, selectInstance, zIsClosedForSend0);
            channelSegment2 = channelSegment;
            if (iUpdateCellSend == 0) {
                channelSegment2.cleanPrev();
                selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
                return;
            }
            if (iUpdateCellSend == 1) {
                selectInstance.selectInRegistrationPhase(Unit.INSTANCE);
                return;
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment2.onSlotCleaned();
                    onClosedSelectOnSend(obj, selectInstance);
                    return;
                } else {
                    Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment2, i2);
                        return;
                    }
                    return;
                }
            }
            if (iUpdateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                onClosedSelectOnSend(obj, selectInstance);
                return;
            } else {
                if (iUpdateCellSend == 5) {
                    channelSegment2.cleanPrev();
                }
                element = obj;
                select = selectInstance;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    @Nullable
    public Object sendBroadcast$kotlinx_coroutines_core(E e, @NotNull Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ca, code lost:
    
        r16 = r7;
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d3, code lost:
    
        if (r3 != null) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        boolean z;
        String string;
        StringBuilder sb = new StringBuilder();
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 2) {
            sb.append("closed,");
        } else if (i == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        int i2 = 0;
        boolean z2 = true;
        List listListOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: while (true) {
            int i4 = BufferedChannelKt.SEGMENT_SIZE;
            int i5 = i2;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                long j3 = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i5);
                if (j3 >= sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i5);
                Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i5);
                boolean z3 = z2;
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    string = (j3 >= receiversCounter$kotlinx_coroutines_core || j3 < sendersCounter$kotlinx_coroutines_core) ? (j3 >= sendersCounter$kotlinx_coroutines_core || j3 < receiversCounter$kotlinx_coroutines_core) ? "cont" : "send" : "receive";
                } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                    string = (j3 >= receiversCounter$kotlinx_coroutines_core || j3 < sendersCounter$kotlinx_coroutines_core) ? (j3 >= sendersCounter$kotlinx_coroutines_core || j3 < receiversCounter$kotlinx_coroutines_core) ? Bixby2Constants.BIXBY_PARAM_SELECT : "onSend" : "onReceive";
                } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    string = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof SendBroadcast) {
                    string = "sendBroadcast";
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    string = AbstractC1038a.m1215p(state$kotlinx_coroutines_core, "EB(", PropertyUtils.MAPPED_DELIM2);
                } else if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    string = "resuming_sender";
                } else if (state$kotlinx_coroutines_core == null || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.POISONED) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_SEND) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                    i5++;
                    z2 = z3;
                } else {
                    string = state$kotlinx_coroutines_core.toString();
                }
                if (element$kotlinx_coroutines_core != null) {
                    sb.append("(" + string + ',' + element$kotlinx_coroutines_core + "),");
                } else {
                    sb.append(string + ',');
                }
                i5++;
                z2 = z3;
            }
            z2 = z;
            i2 = 0;
        }
        if (StringsKt.last(sb) == ',') {
            Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String toStringDebug$kotlinx_coroutines_core() {
        StringBuilder sb = new StringBuilder();
        sb.append("S=" + getSendersCounter$kotlinx_coroutines_core() + ",R=" + getReceiversCounter$kotlinx_coroutines_core() + ",B=" + getBufferEndCounter() + ",B'=" + completedExpandBuffersAndPauseFlag$volatile$FU.get(this) + ",C=" + ((int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60)) + ',');
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 1) {
            sb.append("CANCELLATION_STARTED,");
        } else if (i == 2) {
            sb.append("CLOSED,");
        } else if (i == 3) {
            sb.append("CANCELLED,");
        }
        sb.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(sendSegment$volatile$FU.get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(receiveSegment$volatile$FU.get(this)));
        if (!isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$volatile$FU.get(this)));
        }
        sb.append(Constant.WHITE_SPACE_FOR_LINK_ICON);
        List listListOf = CollectionsKt.listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        do {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DebugStringsKt.getHexAddress(channelSegment));
            sb2.append("=[");
            sb2.append(channelSegment.isRemoved() ? "*" : "");
            sb2.append(channelSegment.id);
            sb2.append(",prev=");
            ChannelSegment channelSegment2 = (ChannelSegment) channelSegment.getPrev();
            sb2.append(channelSegment2 != null ? DebugStringsKt.getHexAddress(channelSegment2) : null);
            sb2.append(',');
            sb.append(sb2.toString());
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            for (int i4 = 0; i4 < i2; i4++) {
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i4);
                Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i4);
                sb.append("[" + i4 + "]=(" + (state$kotlinx_coroutines_core instanceof CancellableContinuation ? "cont" : state$kotlinx_coroutines_core instanceof SelectInstance ? Bixby2Constants.BIXBY_PARAM_SELECT : state$kotlinx_coroutines_core instanceof ReceiveCatching ? "receiveCatching" : state$kotlinx_coroutines_core instanceof SendBroadcast ? "send(broadcast)" : state$kotlinx_coroutines_core instanceof WaiterEB ? AbstractC1038a.m1215p(state$kotlinx_coroutines_core, "EB(", PropertyUtils.MAPPED_DELIM2) : String.valueOf(state$kotlinx_coroutines_core)) + ',' + element$kotlinx_coroutines_core + "),");
            }
            StringBuilder sb3 = new StringBuilder("next=");
            ChannelSegment channelSegment3 = (ChannelSegment) channelSegment.getNext();
            sb3.append(channelSegment3 != null ? DebugStringsKt.getHexAddress(channelSegment3) : null);
            sb3.append("]  ");
            sb.append(sb3.toString());
            channelSegment = (ChannelSegment) channelSegment.getNext();
        } while (channelSegment != null);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo23712tryReceivePtdJZtk() {
        ChannelSegment channelSegmentFindSegmentReceive;
        long j = receivers$volatile$FU.get(this);
        long j2 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j2)) {
            return ChannelResult.INSTANCE.m23732closedJP2dKIU(getCloseCause());
        }
        if (j >= (j2 & 1152921504606846975L)) {
            return ChannelResult.INSTANCE.m23733failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = andIncrement / ((long) i);
            int i2 = (int) (andIncrement % ((long) i));
            if (channelSegment.id != j3) {
                channelSegmentFindSegmentReceive = findSegmentReceive(j3, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                }
            } else {
                channelSegmentFindSegmentReceive = channelSegment;
            }
            Object objUpdateCellReceive = updateCellReceive(channelSegmentFindSegmentReceive, i2, andIncrement, obj);
            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegmentFindSegmentReceive, i2);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegmentFindSegmentReceive.onSlotCleaned();
                return ChannelResult.INSTANCE.m23733failurePtdJZtk();
            }
            if (objUpdateCellReceive != BufferedChannelKt.FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegmentFindSegmentReceive.cleanPrev();
                return ChannelResult.INSTANCE.m23734successJP2dKIU(objUpdateCellReceive);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegmentFindSegmentReceive.cleanPrev();
            }
            channelSegment = channelSegmentFindSegmentReceive;
        }
        return ChannelResult.INSTANCE.m23732closedJP2dKIU(getCloseCause());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo23705trySendJP2dKIU(E element) {
        E e;
        int i;
        ChannelSegment channelSegment;
        BufferedChannel<E> bufferedChannel;
        if (shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            return ChannelResult.INSTANCE.m23733failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i2);
            int i4 = (int) (j % ((long) i2));
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    i = i4;
                    channelSegment = channelSegmentFindSegmentSend;
                    bufferedChannel = this;
                    e = element;
                } else if (zIsClosedForSend0) {
                    return ChannelResult.INSTANCE.m23732closedJP2dKIU(getSendException());
                }
            } else {
                e = element;
                i = i4;
                channelSegment = channelSegment2;
                bufferedChannel = this;
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e, j, obj, zIsClosedForSend0);
            channelSegment2 = channelSegment;
            if (iUpdateCellSend == 0) {
                channelSegment2.cleanPrev();
                return ChannelResult.INSTANCE.m23734successJP2dKIU(Unit.INSTANCE);
            }
            if (iUpdateCellSend == 1) {
                return ChannelResult.INSTANCE.m23734successJP2dKIU(Unit.INSTANCE);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment2.onSlotCleaned();
                    return ChannelResult.INSTANCE.m23732closedJP2dKIU(getSendException());
                }
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    prepareSenderForSuspension(waiter, channelSegment2, i);
                }
                channelSegment2.onSlotCleaned();
                return ChannelResult.INSTANCE.m23733failurePtdJZtk();
            }
            if (iUpdateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                return ChannelResult.INSTANCE.m23732closedJP2dKIU(getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment2.cleanPrev();
            }
            element = e;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    public final Object m23713trySendDropOldestJP2dKIU(E element) {
        ChannelSegment channelSegmentFindSegmentSend;
        int i;
        BufferedChannel<E> bufferedChannel;
        Object obj = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / ((long) i2);
            int i4 = (int) (j % ((long) i2));
            if (channelSegment.id != j2) {
                channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    bufferedChannel = this;
                    i = i4;
                } else if (zIsClosedForSend0) {
                    return ChannelResult.INSTANCE.m23732closedJP2dKIU(getSendException());
                }
            } else {
                channelSegmentFindSegmentSend = channelSegment;
                i = i4;
                bufferedChannel = this;
            }
            E e = element;
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegmentFindSegmentSend, i, e, j, obj, zIsClosedForSend0);
            channelSegment = channelSegmentFindSegmentSend;
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return ChannelResult.INSTANCE.m23734successJP2dKIU(Unit.INSTANCE);
            }
            if (iUpdateCellSend == 1) {
                return ChannelResult.INSTANCE.m23734successJP2dKIU(Unit.INSTANCE);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return ChannelResult.INSTANCE.m23732closedJP2dKIU(getSendException());
                }
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    prepareSenderForSuspension(waiter, channelSegment, i);
                }
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * ((long) i2)) + ((long) i));
                return ChannelResult.INSTANCE.m23734successJP2dKIU(Unit.INSTANCE);
            }
            if (iUpdateCellSend == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return ChannelResult.INSTANCE.m23732closedJP2dKIU(getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            element = e;
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (bufferedChannel.getBufferEndCounter() <= globalIndex) {
            bufferedChannel = this;
        }
        int i = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i2 = 0; i2 < i; i2++) {
            long bufferEndCounter = bufferedChannel.getBufferEndCounter();
            if (bufferEndCounter == (DurationKt.MAX_MILLIS & completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel)) && bufferEndCounter == bufferedChannel.getBufferEndCounter()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(bufferedChannel);
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j, BufferedChannelKt.constructEBCompletedAndPauseFlag(j & DurationKt.MAX_MILLIS, true))) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        while (true) {
            long bufferEndCounter2 = bufferedChannel.getBufferEndCounter();
            long j2 = completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel);
            long j3 = j2 & DurationKt.MAX_MILLIS;
            boolean z = (Longs.MAX_POWER_OF_TWO & j2) != 0;
            if (bufferEndCounter2 == j3 && bufferEndCounter2 == bufferedChannel.getBufferEndCounter()) {
                break;
            }
            if (z) {
                bufferedChannel = this;
            } else {
                bufferedChannel = this;
                completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(bufferedChannel, j2, BufferedChannelKt.constructEBCompletedAndPauseFlag(j3, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$volatile$FU;
        while (true) {
            long j5 = atomicLongFieldUpdater2.get(bufferedChannel);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j5, BufferedChannelKt.constructEBCompletedAndPauseFlag(j5 & DurationKt.MAX_MILLIS, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            bufferedChannel = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction<Unit> bindCancellationFun(Function1<? super E, Unit> function1) {
        return new C132772(this);
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    /* JADX INFO: renamed from: getOnUndeliveredElementReceiveCancellationConstructor$annotations */
    private static /* synthetic */ void m14207x1df74ada() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isEmpty$annotations() {
    }

    public void onClosedIdempotent() {
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }
}
