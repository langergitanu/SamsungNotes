package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m13886d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterImpl;", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "()V", "modifiers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "getModifiers", "()Landroidx/compose/runtime/collection/MutableVector;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBringIntoViewRequester.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BringIntoViewRequester.kt\nandroidx/compose/foundation/relocation/BringIntoViewRequesterImpl\n+ 2 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVectorKt\n+ 3 MutableVector.kt\nandroidx/compose/runtime/collection/MutableVector\n*L\n1#1,181:1\n1208#2:182\n1187#2,2:183\n460#3,11:185\n*S KotlinDebug\n*F\n+ 1 BringIntoViewRequester.kt\nandroidx/compose/foundation/relocation/BringIntoViewRequesterImpl\n*L\n112#1:182\n112#1:183,2\n115#1:185,11\n*E\n"})
final class BringIntoViewRequesterImpl implements BringIntoViewRequester {

    @NotNull
    private final MutableVector<BringIntoViewRequesterNode> modifiers = new MutableVector<>(new BringIntoViewRequesterNode[16], 0);

    /* JADX INFO: renamed from: androidx.compose.foundation.relocation.BringIntoViewRequesterImpl$bringIntoView$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.compose.foundation.relocation.BringIntoViewRequesterImpl", m14021f = "BringIntoViewRequester.kt", m14022i = {0, 0, 0, 0}, m14023l = {116}, m14024m = "bringIntoView", m14025n = {"rect", "content$iv", "size$iv", "i$iv"}, m14026s = {"L$0", "L$1", "I$0", "I$1"})
    public static final class C11871 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11871(Continuation<? super C11871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BringIntoViewRequesterImpl.this.bringIntoView(null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        if (r8 < r2) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0064 -> B:20:0x0067). Please report as a decompilation issue!!! */
    @Override // androidx.compose.foundation.relocation.BringIntoViewRequester
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object bringIntoView(@Nullable Rect rect, @NotNull Continuation<? super Unit> continuation) {
        C11871 c11871;
        int size;
        Rect rect2;
        int i;
        Object[] objArr;
        if (continuation instanceof C11871) {
            c11871 = (C11871) continuation;
            int i2 = c11871.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c11871.label = i2 - Integer.MIN_VALUE;
            } else {
                c11871 = new C11871(continuation);
            }
        }
        Object obj = c11871.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c11871.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableVector<BringIntoViewRequesterNode> mutableVector = this.modifiers;
            size = mutableVector.getSize();
            if (size > 0) {
                BringIntoViewRequesterNode[] content = mutableVector.getContent();
                rect2 = rect;
                i = 0;
                objArr = content;
                BringIntoViewRequesterNode bringIntoViewRequesterNode = (BringIntoViewRequesterNode) objArr[i];
                c11871.L$0 = rect2;
                c11871.L$1 = objArr;
                c11871.I$0 = size;
                c11871.I$1 = i;
                c11871.label = 1;
                if (ScrollIntoView.scrollIntoView(bringIntoViewRequesterNode, rect2, c11871) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
            }
            return Unit.INSTANCE;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = c11871.I$1;
        size = c11871.I$0;
        objArr = (Object[]) c11871.L$1;
        Rect rect3 = (Rect) c11871.L$0;
        ResultKt.throwOnFailure(obj);
        rect2 = rect3;
        i++;
    }

    @NotNull
    public final MutableVector<BringIntoViewRequesterNode> getModifiers() {
        return this.modifiers;
    }
}
