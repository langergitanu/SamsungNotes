package kotlin.p196io.path;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002JB\u0010\u0017\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 \u0012\u0004\u0012\u00020\u00180\u001fH\u0082H¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, m13886d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "[Lkotlin/io/path/PathWalkOption;", "followLinks", "", "getFollowLinks", "()Z", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "includeDirectories", "getIncludeDirectories", "isBFS", "iterator", "", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dfsIterator", "bfsIterator", "kotlin-stdlib-jdk7"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PathTreeWalk implements Sequence<Path> {

    @NotNull
    private final PathWalkOption[] options;

    @NotNull
    private final Path start;

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", m14021f = "PathTreeWalk.kt", m14022i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, m14023l = {STBorder.INT_ZIG_ZAG_STITCH, JPEG.SOF5}, m14024m = "invokeSuspend", m14025n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n101#1:181,19\n*E\n"})
    public static final class C130231 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public C130231(Continuation<? super C130231> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C130231 c130231 = PathTreeWalk.this.new C130231(continuation);
            c130231.L$0 = obj;
            return c130231;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f6 -> B:11:0x007d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f8 -> B:11:0x007d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IllegalFileNameException, FileSystemLoopException {
            ArrayDeque arrayDeque;
            DirectoryEntriesReader directoryEntriesReader;
            SequenceScope sequenceScope;
            PathNode pathNode;
            Path path;
            PathTreeWalk pathTreeWalk;
            LinkOption[] linkOptionArr;
            SequenceScope sequenceScope2;
            ArrayDeque arrayDeque2;
            DirectoryEntriesReader directoryEntriesReader2;
            PathNode pathNode2;
            PathTreeWalk pathTreeWalk2;
            Path path2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
                ArrayDeque arrayDeque3 = new ArrayDeque();
                DirectoryEntriesReader directoryEntriesReader3 = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                arrayDeque3.addLast(new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null));
                arrayDeque = arrayDeque3;
                directoryEntriesReader = directoryEntriesReader3;
                sequenceScope = sequenceScope3;
            } else if (i == 1) {
                path2 = (Path) this.L$5;
                pathTreeWalk2 = (PathTreeWalk) this.L$4;
                pathNode2 = (PathNode) this.L$3;
                directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
                arrayDeque2 = (ArrayDeque) this.L$1;
                sequenceScope2 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ArrayDeque arrayDeque4 = arrayDeque2;
                path = path2;
                directoryEntriesReader = directoryEntriesReader2;
                pathTreeWalk = pathTreeWalk2;
                arrayDeque = arrayDeque4;
                pathNode = pathNode2;
                sequenceScope = sequenceScope2;
                LinkOption[] linkOptions = pathTreeWalk.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    arrayDeque.addAll(directoryEntriesReader.readEntries(pathNode));
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                directoryEntriesReader = (DirectoryEntriesReader) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                sequenceScope = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (!arrayDeque.isEmpty()) {
                pathNode = (PathNode) arrayDeque.removeFirst();
                pathTreeWalk = PathTreeWalk.this;
                path = pathNode.getPath();
                if (pathNode.getParent() != null) {
                    PathsKt__PathRecursiveFunctionsKt.checkFileName(path);
                }
                LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    if (PathTreeWalkKt.createsCycle(pathNode)) {
                        throw new FileSystemLoopException(path.toString());
                    }
                    if (pathTreeWalk.getIncludeDirectories()) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.L$3 = pathNode;
                        this.L$4 = pathTreeWalk;
                        this.L$5 = path;
                        this.label = 1;
                        if (sequenceScope.yield(path, this) != coroutine_suspended) {
                            directoryEntriesReader2 = directoryEntriesReader;
                            path2 = path;
                            arrayDeque2 = arrayDeque;
                            pathTreeWalk2 = pathTreeWalk;
                            sequenceScope2 = sequenceScope;
                            pathNode2 = pathNode;
                            ArrayDeque arrayDeque42 = arrayDeque2;
                            path = path2;
                            directoryEntriesReader = directoryEntriesReader2;
                            pathTreeWalk = pathTreeWalk2;
                            arrayDeque = arrayDeque42;
                            pathNode = pathNode2;
                            sequenceScope = sequenceScope2;
                        }
                    }
                    LinkOption[] linkOptions3 = pathTreeWalk.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                    if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    }
                    while (!arrayDeque.isEmpty()) {
                    }
                } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                    this.L$0 = sequenceScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = directoryEntriesReader;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 2;
                    if (sequenceScope.yield(path, this) == coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C130231) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", m14021f = "PathTreeWalk.kt", m14022i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, m14023l = {STBorder.INT_ZIG_ZAG_STITCH, JPEG.SOF5, 210, JPEG.SOI}, m14024m = "invokeSuspend", m14025n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    @SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,180:1\n44#2,19:181\n44#2,19:200\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n70#1:181,19\n81#1:200,19\n*E\n"})
    public static final class C130241 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public C130241(Continuation<? super C130241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C130241 c130241 = PathTreeWalk.this.new C130241(continuation);
            c130241.L$0 = obj;
            return c130241;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0143, code lost:
        
            if (r7.yield(r10, r13) == r0) goto L66;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x01d5  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01d3 -> B:39:0x0147). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01d5 -> B:39:0x0147). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws IllegalFileNameException, FileSystemLoopException {
            SequenceScope sequenceScope;
            ArrayDeque arrayDeque;
            DirectoryEntriesReader directoryEntriesReader;
            PathNode pathNode;
            PathTreeWalk pathTreeWalk;
            Path path;
            DirectoryEntriesReader directoryEntriesReader2;
            Path path2;
            SequenceScope sequenceScope2;
            PathNode pathNode2;
            PathTreeWalk pathTreeWalk2;
            ArrayDeque arrayDeque2;
            ArrayDeque arrayDeque3;
            LinkOption[] linkOptionArr;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sequenceScope = (SequenceScope) this.L$0;
                arrayDeque = new ArrayDeque();
                directoryEntriesReader = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                pathNode = new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null);
                pathTreeWalk = PathTreeWalk.this;
                path = pathNode.getPath();
                if (pathNode.getParent() != null) {
                    PathsKt__PathRecursiveFunctionsKt.checkFileName(path);
                }
                LinkOption[] linkOptions = pathTreeWalk.getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                        this.L$0 = sequenceScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = directoryEntriesReader;
                        this.label = 2;
                    }
                    arrayDeque3 = arrayDeque;
                    while (!arrayDeque3.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                }
                if (PathTreeWalkKt.createsCycle(pathNode)) {
                    throw new FileSystemLoopException(path.toString());
                }
                if (pathTreeWalk.getIncludeDirectories()) {
                    this.L$0 = sequenceScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = directoryEntriesReader;
                    this.L$3 = pathNode;
                    this.L$4 = pathTreeWalk;
                    this.L$5 = path;
                    this.label = 1;
                    if (sequenceScope.yield(path, this) != coroutine_suspended) {
                        directoryEntriesReader2 = directoryEntriesReader;
                        path2 = path;
                        sequenceScope2 = sequenceScope;
                        pathNode2 = pathNode;
                        pathTreeWalk2 = pathTreeWalk;
                        arrayDeque2 = arrayDeque;
                    }
                }
                LinkOption[] linkOptions2 = pathTreeWalk.getLinkOptions();
                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    pathNode.setContentIterator(directoryEntriesReader.readEntries(pathNode).iterator());
                    arrayDeque.addLast(pathNode);
                }
                arrayDeque3 = arrayDeque;
                while (!arrayDeque3.isEmpty()) {
                }
                return Unit.INSTANCE;
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        Path path3 = (Path) this.L$5;
                        PathTreeWalk pathTreeWalk3 = (PathTreeWalk) this.L$4;
                        PathNode pathNode3 = (PathNode) this.L$3;
                        DirectoryEntriesReader directoryEntriesReader3 = (DirectoryEntriesReader) this.L$2;
                        ArrayDeque arrayDeque4 = (ArrayDeque) this.L$1;
                        SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        ArrayDeque arrayDeque5 = arrayDeque4;
                        Path path4 = path3;
                        directoryEntriesReader = directoryEntriesReader3;
                        PathTreeWalk pathTreeWalk4 = pathTreeWalk3;
                        arrayDeque3 = arrayDeque5;
                        PathNode next = pathNode3;
                        sequenceScope = sequenceScope3;
                        LinkOption[] linkOptions3 = pathTreeWalk4.getLinkOptions();
                        LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                        if (Files.isDirectory(path4, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                            next.setContentIterator(directoryEntriesReader.readEntries(next).iterator());
                            arrayDeque3.addLast(next);
                        }
                        while (!arrayDeque3.isEmpty()) {
                            Iterator<PathNode> contentIterator = ((PathNode) arrayDeque3.last()).getContentIterator();
                            Intrinsics.checkNotNull(contentIterator);
                            if (contentIterator.hasNext()) {
                                next = contentIterator.next();
                                pathTreeWalk4 = PathTreeWalk.this;
                                path4 = next.getPath();
                                if (next.getParent() != null) {
                                    PathsKt__PathRecursiveFunctionsKt.checkFileName(path4);
                                }
                                LinkOption[] linkOptions4 = pathTreeWalk4.getLinkOptions();
                                LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
                                if (Files.isDirectory(path4, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                                    if (PathTreeWalkKt.createsCycle(next)) {
                                        throw new FileSystemLoopException(path4.toString());
                                    }
                                    if (pathTreeWalk4.getIncludeDirectories()) {
                                        this.L$0 = sequenceScope;
                                        this.L$1 = arrayDeque3;
                                        this.L$2 = directoryEntriesReader;
                                        this.L$3 = next;
                                        this.L$4 = pathTreeWalk4;
                                        this.L$5 = path4;
                                        this.label = 3;
                                        if (sequenceScope.yield(path4, this) != coroutine_suspended) {
                                            directoryEntriesReader3 = directoryEntriesReader;
                                            path3 = path4;
                                            arrayDeque4 = arrayDeque3;
                                            pathTreeWalk3 = pathTreeWalk4;
                                            sequenceScope3 = sequenceScope;
                                            pathNode3 = next;
                                            ArrayDeque arrayDeque52 = arrayDeque4;
                                            Path path42 = path3;
                                            directoryEntriesReader = directoryEntriesReader3;
                                            PathTreeWalk pathTreeWalk42 = pathTreeWalk3;
                                            arrayDeque3 = arrayDeque52;
                                            PathNode next2 = pathNode3;
                                            sequenceScope = sequenceScope3;
                                        }
                                    }
                                    LinkOption[] linkOptions32 = pathTreeWalk42.getLinkOptions();
                                    LinkOption[] linkOptionArr32 = (LinkOption[]) Arrays.copyOf(linkOptions32, linkOptions32.length);
                                    if (Files.isDirectory(path42, (LinkOption[]) Arrays.copyOf(linkOptionArr32, linkOptionArr32.length))) {
                                    }
                                    while (!arrayDeque3.isEmpty()) {
                                    }
                                } else if (Files.exists(path42, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                                    this.L$0 = sequenceScope;
                                    this.L$1 = arrayDeque3;
                                    this.L$2 = directoryEntriesReader;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.label = 4;
                                    if (sequenceScope.yield(path42, this) == coroutine_suspended) {
                                    }
                                } else {
                                    continue;
                                }
                                return coroutine_suspended;
                            }
                            arrayDeque3.removeLast();
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                directoryEntriesReader = (DirectoryEntriesReader) this.L$2;
                arrayDeque3 = (ArrayDeque) this.L$1;
                sequenceScope = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                while (!arrayDeque3.isEmpty()) {
                }
                return Unit.INSTANCE;
            }
            path2 = (Path) this.L$5;
            pathTreeWalk2 = (PathTreeWalk) this.L$4;
            pathNode2 = (PathNode) this.L$3;
            directoryEntriesReader2 = (DirectoryEntriesReader) this.L$2;
            arrayDeque2 = (ArrayDeque) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope4 = sequenceScope2;
            path = path2;
            directoryEntriesReader = directoryEntriesReader2;
            pathNode = pathNode2;
            sequenceScope = sequenceScope4;
            arrayDeque = arrayDeque2;
            pathTreeWalk = pathTreeWalk2;
            LinkOption[] linkOptions22 = pathTreeWalk.getLinkOptions();
            linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            }
            arrayDeque3 = arrayDeque;
            while (!arrayDeque3.isEmpty()) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C130241) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public PathTreeWalk(@NotNull Path start, @NotNull PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new C130231(null));
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C130241(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> sequenceScope, PathNode pathNode, DirectoryEntriesReader directoryEntriesReader, Function1<? super List<PathNode>, Unit> function1, Continuation<? super Unit> continuation) throws IllegalFileNameException, FileSystemLoopException {
        Path path = pathNode.getPath();
        if (pathNode.getParent() != null) {
            PathsKt__PathRecursiveFunctionsKt.checkFileName(path);
        }
        LinkOption[] linkOptions = getLinkOptions();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (PathTreeWalkKt.createsCycle(pathNode)) {
                throw new FileSystemLoopException(path.toString());
            }
            if (getIncludeDirectories()) {
                InlineMarker.mark(0);
                sequenceScope.yield(path, continuation);
                InlineMarker.mark(1);
            }
            LinkOption[] linkOptions2 = getLinkOptions();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                function1.invoke(directoryEntriesReader.readEntries(pathNode));
            }
        } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            InlineMarker.mark(0);
            sequenceScope.yield(path, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<Path> iterator() {
        return isBFS() ? bfsIterator() : dfsIterator();
    }
}
