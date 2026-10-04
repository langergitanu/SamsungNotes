package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import cz.msebera.android.httpclient.HttpStatus;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p196io.CloseableKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 F*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003FGHB\u007f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012?\b\u0002\u0010\b\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n0\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010+\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00103\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00105\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00106\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00107\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00108\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u00104JL\u00109\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\u0006\u0010<\u001a\u00020=H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010>JD\u0010?\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00028\u0000H\u0080@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\f\u0010E\u001a\u00020\u0010*\u00020\u0005H\u0002R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'RJ\u0010*\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n\u0018\u00010\tX\u0082\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, m13886d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/DataStore;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "SCRATCH_SUFFIX", "", "actor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "downstreamFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "getDownstreamFlow$annotations", "()V", "file", "getFile", "()Ljava/io/File;", "file$delegate", "Lkotlin/Lazy;", "initTasks", "handleRead", "read", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", Constants.ARG_UPDATE, "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "readAndInitOrPropagateFailure", "readData", "readDataOrHandleCorruption", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "writeData$datastore_core", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
public final class SingleProcessDataStore<T> implements DataStore<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @GuardedBy("activeFilesLock")
    @NotNull
    private static final Set<String> activeFiles = new LinkedHashSet();

    @NotNull
    private static final Object activeFilesLock = new Object();

    @NotNull
    private final String SCRATCH_SUFFIX;

    @NotNull
    private final SimpleActor<Message<T>> actor;

    @NotNull
    private final CorruptionHandler<T> corruptionHandler;

    @NotNull
    private final Flow<T> data;

    @NotNull
    private final MutableStateFlow<State<T>> downstreamFlow;

    /* JADX INFO: renamed from: file$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy file;

    @Nullable
    private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;

    @NotNull
    private final Function0<File> produceFile;

    @NotNull
    private final CoroutineScope scope;

    @NotNull
    private final Serializer<T> serializer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Companion;", "", "()V", "activeFiles", "", "", "getActiveFiles$datastore_core", "()Ljava/util/Set;", "activeFilesLock", "getActiveFilesLock$datastore_core", "()Ljava/lang/Object;", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Set<String> getActiveFiles$datastore_core() {
            return SingleProcessDataStore.activeFiles;
        }

        @NotNull
        public final Object getActiveFilesLock$datastore_core() {
            return SingleProcessDataStore.activeFilesLock;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, m13886d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", "T", "", "()V", "lastState", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
    public static abstract class Message<T> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "lastState", "Landroidx/datastore/core/State;", "(Landroidx/datastore/core/State;)V", "getLastState", "()Landroidx/datastore/core/State;", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
        public static final class Read<T> extends Message<T> {

            @Nullable
            private final State<T> lastState;

            public Read(@Nullable State<T> state) {
                super(null);
                this.lastState = state;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            @Nullable
            public State<T> getLastState() {
                return this.lastState;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Ba\u00121\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RA\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m13886d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "ack", "Lkotlinx/coroutines/CompletableDeferred;", "lastState", "Landroidx/datastore/core/State;", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "getAck", "()Lkotlinx/coroutines/CompletableDeferred;", "getCallerContext", "()Lkotlin/coroutines/CoroutineContext;", "getLastState", "()Landroidx/datastore/core/State;", "getTransform", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
        public static final class Update<T> extends Message<T> {

            @NotNull
            private final CompletableDeferred<T> ack;

            @NotNull
            private final CoroutineContext callerContext;

            @Nullable
            private final State<T> lastState;

            @NotNull
            private final Function2<T, Continuation<? super T>, Object> transform;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Update(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> transform, @NotNull CompletableDeferred<T> ack, @Nullable State<T> state, @NotNull CoroutineContext callerContext) {
                super(null);
                Intrinsics.checkNotNullParameter(transform, "transform");
                Intrinsics.checkNotNullParameter(ack, "ack");
                Intrinsics.checkNotNullParameter(callerContext, "callerContext");
                this.transform = transform;
                this.ack = ack;
                this.lastState = state;
                this.callerContext = callerContext;
            }

            @NotNull
            public final CompletableDeferred<T> getAck() {
                return this.ack;
            }

            @NotNull
            public final CoroutineContext getCallerContext() {
                return this.callerContext;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            @Nullable
            public State<T> getLastState() {
                return this.lastState;
            }

            @NotNull
            public final Function2<T, Continuation<? super T>, Object> getTransform() {
                return this.transform;
            }
        }

        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public abstract State<T> getLastState();

        private Message() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "fileOutputStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;)V", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "close", "", "flush", "write", "b", "", "bytes", "off", "", "len", "datastore-core"}, m13887k = 1, m13888mv = {1, 5, 1}, m13890xi = 48)
    public static final class UncloseableOutputStream extends OutputStream {

        @NotNull
        private final FileOutputStream fileOutputStream;

        public UncloseableOutputStream(@NotNull FileOutputStream fileOutputStream) {
            Intrinsics.checkNotNullParameter(fileOutputStream, "fileOutputStream");
            this.fileOutputStream = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        @NotNull
        public final FileOutputStream getFileOutputStream() {
            return this.fileOutputStream;
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] b) throws IOException {
            Intrinsics.checkNotNullParameter(b, "b");
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(@NotNull byte[] bytes, int off, int len) throws IOException {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.fileOutputStream.write(bytes, off, len);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {1, 1}, m14023l = {276, 281, 284}, m14024m = "handleUpdate", m14025n = {Constants.ARG_UPDATE, "$this$handleUpdate_u24lambda_u2d0"}, m14026s = {"L$0", "L$1"})
    public static final class C26171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26171(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26171> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInit$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {0, 0, 1, 1, 1, 2}, m14023l = {322, 348, 505}, m14024m = "readAndInit", m14025n = {"updateLock", "initData", "updateLock", "initData", "initializationComplete", "$this$withLock_u24default$iv"}, m14026s = {"L$1", "L$2", "L$1", "L$2", "L$3", "L$3"})
    public static final class C26181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26181(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26181> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInit(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {0}, m14023l = {302}, m14024m = "readAndInitOrPropagateAndThrowFailure", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C26191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26191(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26191> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {0}, m14023l = {311}, m14024m = "readAndInitOrPropagateFailure", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C26201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26201(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26201> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateFailure(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readData$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {0}, m14023l = {381}, m14024m = "readData", m14025n = {"this"}, m14026s = {"L$0"})
    public static final class C26211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26211(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26211> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readData(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {0, 1, 2, 2}, m14023l = {359, 362, 365}, m14024m = "readDataOrHandleCorruption", m14025n = {"this", "ex", "ex", "newData"}, m14026s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class C26221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26221(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26221> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(this);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 5, 1}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.datastore.core.SingleProcessDataStore", m14021f = "SingleProcessDataStore.kt", m14022i = {0, 0, 0}, m14023l = {402, HttpStatus.SC_GONE}, m14024m = "transformAndWrite", m14025n = {"this", "curDataAndHash", "curData"}, m14026s = {"L$0", "L$1", "L$2"})
    public static final class C26231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26231(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super C26231> continuation) {
            super(continuation);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.transformAndWrite(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore(@NotNull Function0<? extends File> produceFile, @NotNull Serializer<T> serializer, @NotNull List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasksList, @NotNull CorruptionHandler<T> corruptionHandler, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(initTasksList, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler, "corruptionHandler");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.produceFile = produceFile;
        this.serializer = serializer;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = FlowKt.flow(new SingleProcessDataStore$data$1(this, null));
        this.SCRATCH_SUFFIX = DiskFileUpload.postfix;
        this.file = LazyKt.lazy(new Function0<File>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final File invoke() {
                File file = (File) ((SingleProcessDataStore) this.this$0).produceFile.invoke();
                String it = file.getAbsolutePath();
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                synchronized (companion.getActiveFilesLock$datastore_core()) {
                    if (companion.getActiveFiles$datastore_core().contains(it)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Set<String> activeFiles$datastore_core = companion.getActiveFiles$datastore_core();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    activeFiles$datastore_core.add(it);
                }
                return file;
            }
        });
        this.downstreamFlow = StateFlowKt.MutableStateFlow(UnInitialized.INSTANCE);
        this.initTasks = CollectionsKt.toList(initTasksList);
        this.actor = new SimpleActor<>(scope, new Function1<Throwable, Unit>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                if (th != null) {
                    ((SingleProcessDataStore) this.this$0).downstreamFlow.setValue(new Final(th));
                }
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                Object activeFilesLock$datastore_core = companion.getActiveFilesLock$datastore_core();
                SingleProcessDataStore<T> singleProcessDataStore = this.this$0;
                synchronized (activeFilesLock$datastore_core) {
                    companion.getActiveFiles$datastore_core().remove(singleProcessDataStore.getFile().getAbsolutePath());
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, new Function2<Message<T>, Throwable, Unit>() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Throwable th) {
                invoke((SingleProcessDataStore.Message) obj, th);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SingleProcessDataStore.Message<T> msg, @Nullable Throwable th) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg instanceof SingleProcessDataStore.Message.Update) {
                    CompletableDeferred<T> ack = ((SingleProcessDataStore.Message.Update) msg).getAck();
                    if (th == null) {
                        th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    ack.completeExceptionally(th);
                }
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(Intrinsics.stringPlus("Unable to create parent directories of ", file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFile() {
        return (File) this.file.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleRead(Message.Read<T> read, Continuation<? super Unit> continuation) {
        State<T> value = this.downstreamFlow.getValue();
        if (!(value instanceof Data)) {
            if (value instanceof ReadException) {
                if (value == read.getLastState()) {
                    Object andInitOrPropagateFailure = readAndInitOrPropagateFailure(continuation);
                    return andInitOrPropagateFailure == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? andInitOrPropagateFailure : Unit.INSTANCE;
                }
            } else {
                if (Intrinsics.areEqual(value, UnInitialized.INSTANCE)) {
                    Object andInitOrPropagateFailure2 = readAndInitOrPropagateFailure(continuation);
                    return andInitOrPropagateFailure2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? andInitOrPropagateFailure2 : Unit.INSTANCE;
                }
                if (value instanceof Final) {
                    throw new IllegalStateException("Can't read in final state.");
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b6, code lost:
    
        if (r9 == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.CompletableDeferred] */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleUpdate(Message.Update<T> update, Continuation<? super Unit> continuation) {
        C26171 c26171;
        Object objM22215constructorimpl;
        ?? r9;
        CompletableDeferred<T> ack;
        State<T> value;
        ?? r2;
        Object objTransformAndWrite;
        Message.Update<T> update2;
        if (continuation instanceof C26171) {
            c26171 = (C26171) continuation;
            int i = c26171.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c26171.label = i - Integer.MIN_VALUE;
            } else {
                c26171 = new C26171(this, continuation);
            }
        }
        Object obj = c26171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26171.label;
        boolean z = true;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    CompletableDeferred<T> completableDeferred = (CompletableDeferred) c26171.L$2;
                    SingleProcessDataStore singleProcessDataStore = (SingleProcessDataStore) c26171.L$1;
                    Message.Update<T> update3 = (Message.Update) c26171.L$0;
                    ResultKt.throwOnFailure(obj);
                    ack = completableDeferred;
                    r2 = singleProcessDataStore;
                    update2 = update3;
                } else if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            Message.Update<T> update4 = (Message.Update<T>) ((CompletableDeferred) c26171.L$0);
            ResultKt.throwOnFailure(obj);
            update = update4;
            objM22215constructorimpl = Result.m22215constructorimpl(obj);
            r9 = update;
            CompletableDeferredKt.completeWith(r9, objM22215constructorimpl);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        ack = update.getAck();
        try {
            Result.Companion companion = Result.INSTANCE;
            value = this.downstreamFlow.getValue();
        } catch (Throwable th2) {
            th = th2;
            update = ack;
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            r9 = update;
        }
        if (value instanceof Data) {
            Function2<T, Continuation<? super T>, Object> transform = update.getTransform();
            CoroutineContext callerContext = update.getCallerContext();
            c26171.L$0 = ack;
            c26171.label = 1;
            objTransformAndWrite = transformAndWrite(transform, callerContext, c26171);
            if (objTransformAndWrite == coroutine_suspended) {
            }
            CompletableDeferred<T> completableDeferred2 = ack;
            obj = objTransformAndWrite;
            update = (Message.Update<T>) completableDeferred2;
            objM22215constructorimpl = Result.m22215constructorimpl(obj);
            r9 = update;
            CompletableDeferredKt.completeWith(r9, objM22215constructorimpl);
            return Unit.INSTANCE;
        }
        if (!(value instanceof ReadException)) {
            z = value instanceof UnInitialized;
        }
        if (!z) {
            if (value instanceof Final) {
                throw ((Final) value).getFinalException();
            }
            throw new NoWhenBranchMatchedException();
        }
        if (value != update.getLastState()) {
            throw ((ReadException) value).getReadException();
        }
        c26171.L$0 = update;
        c26171.L$1 = this;
        c26171.L$2 = ack;
        c26171.label = 2;
        if (readAndInitOrPropagateAndThrowFailure(c26171) != coroutine_suspended) {
            r2 = this;
            update2 = update;
        }
        return coroutine_suspended;
        Function2<T, Continuation<? super T>, Object> transform2 = update2.getTransform();
        CoroutineContext callerContext2 = update2.getCallerContext();
        c26171.L$0 = ack;
        c26171.L$1 = null;
        c26171.L$2 = null;
        c26171.label = 3;
        objTransformAndWrite = r2.transformAndWrite(transform2, callerContext2, c26171);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.datastore.core.SingleProcessDataStore, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAndInit(Continuation<? super Unit> continuation) {
        C26181 c26181;
        Mutex mutexMutex$default;
        Ref.ObjectRef objectRef;
        ?? r10;
        Ref.ObjectRef objectRef2;
        ?? r12;
        Ref.ObjectRef objectRef3;
        SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1;
        Iterator<T> it;
        Mutex mutex;
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        C26181 c261812;
        ?? r02;
        Ref.ObjectRef objectRef4;
        Mutex mutex2;
        ?? r03;
        if (continuation instanceof C26181) {
            c26181 = (C26181) continuation;
            int i = c26181.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c26181.label = i - Integer.MIN_VALUE;
            } else {
                c26181 = new C26181(this, continuation);
            }
        }
        T t = (T) c26181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26181.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(t);
            if (!(Intrinsics.areEqual(this.downstreamFlow.getValue(), UnInitialized.INSTANCE) || (this.downstreamFlow.getValue() instanceof ReadException))) {
                throw new IllegalStateException("Check failed.");
            }
            mutexMutex$default = MutexKt.Mutex$default(false, 1, null);
            objectRef = new Ref.ObjectRef();
            c26181.L$0 = this;
            c26181.L$1 = mutexMutex$default;
            c26181.L$2 = objectRef;
            c26181.L$3 = objectRef;
            c26181.label = 1;
            t = (T) readDataOrHandleCorruption(c26181);
            if (t != coroutine_suspended) {
                r10 = this;
                objectRef2 = objectRef;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) c26181.L$3;
                booleanRef2 = (Ref.BooleanRef) c26181.L$2;
                objectRef4 = (Ref.ObjectRef) c26181.L$1;
                SingleProcessDataStore singleProcessDataStore = (SingleProcessDataStore) c26181.L$0;
                ResultKt.throwOnFailure(t);
                r03 = singleProcessDataStore;
                try {
                    booleanRef2.element = true;
                    Unit unit = Unit.INSTANCE;
                    mutex2.unlock(null);
                    MutableStateFlow<State<T>> mutableStateFlow = r03.downstreamFlow;
                    T t2 = objectRef4.element;
                    mutableStateFlow.setValue(new Data(t2, t2 != null ? t2.hashCode() : 0));
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    mutex2.unlock(null);
                    throw th;
                }
            }
            it = (Iterator) c26181.L$5;
            singleProcessDataStore$readAndInit$api$1 = (SingleProcessDataStore$readAndInit$api$1) c26181.L$4;
            booleanRef = (Ref.BooleanRef) c26181.L$3;
            objectRef3 = (Ref.ObjectRef) c26181.L$2;
            mutex = (Mutex) c26181.L$1;
            SingleProcessDataStore singleProcessDataStore2 = (SingleProcessDataStore) c26181.L$0;
            ResultKt.throwOnFailure(t);
            r12 = singleProcessDataStore2;
            while (it.hasNext()) {
                Function2 function2 = (Function2) it.next();
                c26181.L$0 = r12;
                c26181.L$1 = mutex;
                c26181.L$2 = objectRef3;
                c26181.L$3 = booleanRef;
                c26181.L$4 = singleProcessDataStore$readAndInit$api$1;
                c26181.L$5 = it;
                c26181.label = 2;
                if (function2.invoke(singleProcessDataStore$readAndInit$api$1, c26181) == coroutine_suspended) {
                    break;
                }
            }
            c261812 = c26181;
            booleanRef2 = booleanRef;
            objectRef2 = objectRef3;
            mutexMutex$default = mutex;
            r02 = r12;
            r02.initTasks = null;
            c261812.L$0 = r02;
            c261812.L$1 = objectRef2;
            c261812.L$2 = booleanRef2;
            c261812.L$3 = mutexMutex$default;
            c261812.L$4 = null;
            c261812.L$5 = null;
            c261812.label = 3;
            if (mutexMutex$default.lock(null, c261812) != coroutine_suspended) {
                objectRef4 = objectRef2;
                mutex2 = mutexMutex$default;
                r03 = r02;
                booleanRef2.element = true;
                Unit unit2 = Unit.INSTANCE;
                mutex2.unlock(null);
                MutableStateFlow<State<T>> mutableStateFlow2 = r03.downstreamFlow;
                T t22 = objectRef4.element;
                mutableStateFlow2.setValue(new Data(t22, t22 != null ? t22.hashCode() : 0));
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        objectRef = (Ref.ObjectRef) c26181.L$3;
        objectRef2 = (Ref.ObjectRef) c26181.L$2;
        mutexMutex$default = (Mutex) c26181.L$1;
        SingleProcessDataStore singleProcessDataStore3 = (SingleProcessDataStore) c26181.L$0;
        ResultKt.throwOnFailure(t);
        r10 = singleProcessDataStore3;
        objectRef.element = t;
        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
        SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$12 = new SingleProcessDataStore$readAndInit$api$1(mutexMutex$default, booleanRef3, objectRef2, r10);
        List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list = r10.initTasks;
        if (list == null) {
            booleanRef2 = booleanRef3;
            c261812 = c26181;
            r02 = r10;
            r02.initTasks = null;
            c261812.L$0 = r02;
            c261812.L$1 = objectRef2;
            c261812.L$2 = booleanRef2;
            c261812.L$3 = mutexMutex$default;
            c261812.L$4 = null;
            c261812.L$5 = null;
            c261812.label = 3;
            if (mutexMutex$default.lock(null, c261812) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        r12 = r10;
        objectRef3 = objectRef2;
        singleProcessDataStore$readAndInit$api$1 = singleProcessDataStore$readAndInit$api$12;
        it = list.iterator();
        mutex = mutexMutex$default;
        booleanRef = booleanRef3;
        while (it.hasNext()) {
        }
        c261812 = c26181;
        booleanRef2 = booleanRef;
        objectRef2 = objectRef3;
        mutexMutex$default = mutex;
        r02 = r12;
        r02.initTasks = null;
        c261812.L$0 = r02;
        c261812.L$1 = objectRef2;
        c261812.L$2 = booleanRef2;
        c261812.L$3 = mutexMutex$default;
        c261812.L$4 = null;
        c261812.L$5 = null;
        c261812.label = 3;
        if (mutexMutex$default.lock(null, c261812) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAndInitOrPropagateAndThrowFailure(Continuation<? super Unit> continuation) throws Throwable {
        C26191 c26191;
        SingleProcessDataStore singleProcessDataStore;
        if (continuation instanceof C26191) {
            c26191 = (C26191) continuation;
            int i = c26191.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c26191.label = i - Integer.MIN_VALUE;
            } else {
                c26191 = new C26191(this, continuation);
            }
        }
        Object obj = c26191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26191.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            singleProcessDataStore = (SingleProcessDataStore) c26191.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        try {
            c26191.L$0 = this;
            c26191.label = 1;
            if (readAndInit(c26191) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            singleProcessDataStore = this;
            singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readAndInitOrPropagateFailure(Continuation<? super Unit> continuation) {
        C26201 c26201;
        SingleProcessDataStore singleProcessDataStore;
        if (continuation instanceof C26201) {
            c26201 = (C26201) continuation;
            int i = c26201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c26201.label = i - Integer.MIN_VALUE;
            } else {
                c26201 = new C26201(this, continuation);
            }
        }
        Object obj = c26201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26201.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                c26201.L$0 = this;
                c26201.label = 1;
                if (readAndInit(c26201) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                th = th;
                singleProcessDataStore = this;
                singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            singleProcessDataStore = (SingleProcessDataStore) c26201.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                singleProcessDataStore.downstreamFlow.setValue(new ReadException(th));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.SingleProcessDataStore$readData$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.datastore.core.Serializer, androidx.datastore.core.Serializer<T>] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readData(Continuation<? super T> continuation) throws FileNotFoundException {
        ?? c26211;
        ?? fileInputStream;
        Throwable th;
        ?? r2;
        if (continuation instanceof C26211) {
            C26211 c262112 = (C26211) continuation;
            int i = c262112.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c262112.label = i - Integer.MIN_VALUE;
                c26211 = c262112;
            } else {
                c26211 = new C26211(this, continuation);
            }
        }
        Object from = c26211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26211.label;
        try {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) c26211.L$2;
                fileInputStream = (Closeable) c26211.L$1;
                c26211 = (SingleProcessDataStore) c26211.L$0;
                try {
                    ResultKt.throwOnFailure(from);
                    r2 = fileInputStream;
                    return from;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } finally {
                        CloseableKt.closeFinally(fileInputStream, th);
                    }
                }
            }
            ResultKt.throwOnFailure(from);
            try {
                fileInputStream = new FileInputStream(getFile());
                try {
                    Serializer<T> serializer = this.serializer;
                    c26211.L$0 = this;
                    c26211.L$1 = fileInputStream;
                    c26211.L$2 = null;
                    c26211.label = 1;
                    from = serializer.readFrom(fileInputStream, c26211);
                    if (from == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    th = null;
                    r2 = fileInputStream;
                    return from;
                } catch (Throwable th3) {
                    th = th3;
                    c26211 = this;
                    throw th;
                }
            } catch (FileNotFoundException e) {
                e = e;
                c26211 = this;
                if (c26211.getFile().exists()) {
                    throw e;
                }
                return c26211.serializer.getDefaultValue();
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.datastore.core.SingleProcessDataStore, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readDataOrHandleCorruption(Continuation<? super T> continuation) throws CorruptionException, FileNotFoundException {
        C26221 c26221;
        ?? r2;
        Object objHandleCorruption;
        CorruptionException corruptionException;
        ?? r4;
        CorruptionException corruptionException2;
        if (continuation instanceof C26221) {
            c26221 = (C26221) continuation;
            int i = c26221.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c26221.label = i - Integer.MIN_VALUE;
            } else {
                c26221 = new C26221(this, continuation);
            }
        }
        Object obj = c26221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26221.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                c26221.L$0 = this;
                c26221.label = 1;
                Object data = readData(c26221);
                if (data != coroutine_suspended) {
                    return data;
                }
            } catch (CorruptionException e) {
                e = e;
                r2 = this;
                CorruptionHandler<T> corruptionHandler = r2.corruptionHandler;
                c26221.L$0 = r2;
                c26221.L$1 = e;
                c26221.label = 2;
                objHandleCorruption = corruptionHandler.handleCorruption(e, c26221);
                if (objHandleCorruption != coroutine_suspended) {
                }
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Object obj2 = c26221.L$1;
                    corruptionException2 = (CorruptionException) c26221.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        return obj2;
                    } catch (IOException e2) {
                        e = e2;
                        ExceptionsKt.addSuppressed(corruptionException2, e);
                        throw corruptionException2;
                    }
                }
                corruptionException = (CorruptionException) c26221.L$1;
                SingleProcessDataStore singleProcessDataStore = (SingleProcessDataStore) c26221.L$0;
                ResultKt.throwOnFailure(obj);
                r4 = singleProcessDataStore;
                try {
                    c26221.L$0 = corruptionException;
                    c26221.L$1 = obj;
                    c26221.label = 3;
                    return r4.writeData$datastore_core(obj, c26221) != coroutine_suspended ? coroutine_suspended : obj;
                } catch (IOException e3) {
                    e = e3;
                    corruptionException2 = corruptionException;
                    ExceptionsKt.addSuppressed(corruptionException2, e);
                    throw corruptionException2;
                }
            }
            r2 = (SingleProcessDataStore) c26221.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (CorruptionException e5) {
                e = e5;
            }
        }
        CorruptionHandler<T> corruptionHandler2 = r2.corruptionHandler;
        c26221.L$0 = r2;
        c26221.L$1 = e;
        c26221.label = 2;
        objHandleCorruption = corruptionHandler2.handleCorruption(e, c26221);
        if (objHandleCorruption != coroutine_suspended) {
            ?? r6 = r2;
            corruptionException = e;
            obj = objHandleCorruption;
            r4 = r6;
            c26221.L$0 = corruptionException;
            c26221.L$1 = obj;
            c26221.label = 3;
            if (r4.writeData$datastore_core(obj, c26221) != coroutine_suspended) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object transformAndWrite(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        C26231 c26231;
        Data data;
        Object obj;
        SingleProcessDataStore singleProcessDataStore;
        Object obj2;
        SingleProcessDataStore singleProcessDataStore2;
        if (continuation instanceof C26231) {
            c26231 = (C26231) continuation;
            int i = c26231.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c26231.label = i - Integer.MIN_VALUE;
            } else {
                c26231 = new C26231(this, continuation);
            }
        }
        Object obj3 = c26231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c26231.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            Data data2 = (Data) this.downstreamFlow.getValue();
            data2.checkHashCode();
            Object value = data2.getValue();
            SingleProcessDataStore$transformAndWrite$newData$1 singleProcessDataStore$transformAndWrite$newData$1 = new SingleProcessDataStore$transformAndWrite$newData$1(function2, value, null);
            c26231.L$0 = this;
            c26231.L$1 = data2;
            c26231.L$2 = value;
            c26231.label = 1;
            Object objWithContext = BuildersKt.withContext(coroutineContext, singleProcessDataStore$transformAndWrite$newData$1, c26231);
            if (objWithContext != coroutine_suspended) {
                data = data2;
                obj3 = objWithContext;
                obj = value;
                singleProcessDataStore = this;
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = c26231.L$1;
            SingleProcessDataStore singleProcessDataStore3 = (SingleProcessDataStore) c26231.L$0;
            ResultKt.throwOnFailure(obj3);
            singleProcessDataStore2 = singleProcessDataStore3;
            singleProcessDataStore2.downstreamFlow.setValue(new Data(obj2, obj2 == null ? obj2.hashCode() : 0));
            return obj2;
        }
        obj = c26231.L$2;
        data = (Data) c26231.L$1;
        SingleProcessDataStore singleProcessDataStore4 = (SingleProcessDataStore) c26231.L$0;
        ResultKt.throwOnFailure(obj3);
        singleProcessDataStore = singleProcessDataStore4;
        data.checkHashCode();
        if (Intrinsics.areEqual(obj, obj3)) {
            return obj;
        }
        c26231.L$0 = singleProcessDataStore;
        c26231.L$1 = obj3;
        c26231.L$2 = null;
        c26231.label = 2;
        if (singleProcessDataStore.writeData$datastore_core(obj3, c26231) != coroutine_suspended) {
            obj2 = obj3;
            singleProcessDataStore2 = singleProcessDataStore;
            singleProcessDataStore2.downstreamFlow.setValue(new Data(obj2, obj2 == null ? obj2.hashCode() : 0));
            return obj2;
        }
        return coroutine_suspended;
    }

    @Override // androidx.datastore.core.DataStore
    @NotNull
    public Flow<T> getData() {
        return this.data;
    }

    @Override // androidx.datastore.core.DataStore
    @Nullable
    public Object updateData(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.actor.offer(new Message.Update(function2, completableDeferredCompletableDeferred$default, this.downstreamFlow.getValue(), continuation.getContext()));
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.FileOutputStream] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeData$datastore_core(T t, @NotNull Continuation<? super Unit> continuation) throws IOException {
        SingleProcessDataStore$writeData$1 singleProcessDataStore$writeData$1;
        ?? file;
        ?? fileOutputStream;
        SingleProcessDataStore<T> singleProcessDataStore;
        ?? r9;
        Throwable th;
        if (continuation instanceof SingleProcessDataStore$writeData$1) {
            singleProcessDataStore$writeData$1 = (SingleProcessDataStore$writeData$1) continuation;
            int i = singleProcessDataStore$writeData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                singleProcessDataStore$writeData$1.label = i - Integer.MIN_VALUE;
            } else {
                singleProcessDataStore$writeData$1 = new SingleProcessDataStore$writeData$1(this, continuation);
            }
        }
        Object obj = singleProcessDataStore$writeData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = singleProcessDataStore$writeData$1.label;
        ?? r4 = 1;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                createParentDirectories(getFile());
                file = new File(Intrinsics.stringPlus(getFile().getAbsolutePath(), this.SCRATCH_SUFFIX));
                try {
                    fileOutputStream = new FileOutputStream((File) file);
                    try {
                        Serializer<T> serializer = this.serializer;
                        UncloseableOutputStream uncloseableOutputStream = new UncloseableOutputStream(fileOutputStream);
                        singleProcessDataStore$writeData$1.L$0 = this;
                        singleProcessDataStore$writeData$1.L$1 = file;
                        singleProcessDataStore$writeData$1.L$2 = fileOutputStream;
                        singleProcessDataStore$writeData$1.L$3 = null;
                        singleProcessDataStore$writeData$1.L$4 = fileOutputStream;
                        singleProcessDataStore$writeData$1.label = 1;
                        if (serializer.writeTo(t, uncloseableOutputStream, singleProcessDataStore$writeData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        singleProcessDataStore = this;
                        r4 = file;
                        r9 = fileOutputStream;
                        th = null;
                        fileOutputStream = fileOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        r4 = file;
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FileOutputStream fileOutputStream2 = (FileOutputStream) singleProcessDataStore$writeData$1.L$4;
                th = (Throwable) singleProcessDataStore$writeData$1.L$3;
                fileOutputStream = (Closeable) singleProcessDataStore$writeData$1.L$2;
                r4 = (File) singleProcessDataStore$writeData$1.L$1;
                singleProcessDataStore = (SingleProcessDataStore) singleProcessDataStore$writeData$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    fileOutputStream = fileOutputStream;
                    r4 = r4;
                    r9 = fileOutputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th4;
                    }
                }
            }
            r9.getFD().sync();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, th);
            if (r4.renameTo(singleProcessDataStore.getFile())) {
                return Unit.INSTANCE;
            }
            throw new IOException("Unable to rename " + r4 + ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
        } catch (IOException e2) {
            e = e2;
            file = r4;
            if (file.exists()) {
            }
            throw e;
        }
    }

    public /* synthetic */ SingleProcessDataStore(Function0 function0, Serializer serializer, List list, CorruptionHandler corruptionHandler, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, serializer, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? new NoOpCorruptionHandler() : corruptionHandler, (i & 16) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))) : coroutineScope);
    }

    private static /* synthetic */ void getDownstreamFlow$annotations() {
    }
}
