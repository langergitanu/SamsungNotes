package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Offset;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", LangPackConfigConstants.LANGUAGE_CODE_IT, "Landroidx/compose/ui/geometry/Offset;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.gestures.Draggable2DKt$NoOpOnDragStarted$1", m14021f = "Draggable2D.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class Draggable2DKt$NoOpOnDragStarted$1 extends SuspendLambda implements Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> {
    int label;

    public Draggable2DKt$NoOpOnDragStarted$1(Continuation<? super Draggable2DKt$NoOpOnDragStarted$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Offset offset, Continuation<? super Unit> continuation) {
        return m15608invoked4ec7I(coroutineScope, offset.getPackedValue(), continuation);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
    public final Object m15608invoked4ec7I(@NotNull CoroutineScope coroutineScope, long j, @Nullable Continuation<? super Unit> continuation) {
        return new Draggable2DKt$NoOpOnDragStarted$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }
}
