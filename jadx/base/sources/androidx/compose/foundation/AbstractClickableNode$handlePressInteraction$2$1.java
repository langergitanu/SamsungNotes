package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.compose.foundation.AbstractClickableNode$handlePressInteraction$2$1", m14021f = "Clickable.kt", m14022i = {0, 1, 2}, m14023l = {1139, 1141, 1148, 1149, 1158}, m14024m = "invokeSuspend", m14025n = {"delayJob", "success", "release"}, m14026s = {"L$0", "Z$0", "L$0"})
public final class AbstractClickableNode$handlePressInteraction$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    final /* synthetic */ PressGestureScope $this_handlePressInteraction;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ AbstractClickableNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClickableNode$handlePressInteraction$2$1(PressGestureScope pressGestureScope, long j, MutableInteractionSource mutableInteractionSource, AbstractClickableNode abstractClickableNode, Continuation<? super AbstractClickableNode$handlePressInteraction$2$1> continuation) {
        super(2, continuation);
        this.$this_handlePressInteraction = pressGestureScope;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
        this.this$0 = abstractClickableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AbstractClickableNode$handlePressInteraction$2$1 abstractClickableNode$handlePressInteraction$2$1 = new AbstractClickableNode$handlePressInteraction$2$1(this.$this_handlePressInteraction, this.$offset, this.$interactionSource, this.this$0, continuation);
        abstractClickableNode$handlePressInteraction$2$1.L$0 = obj;
        return abstractClickableNode$handlePressInteraction$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        if (r3.emit(r2, r16) != r1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if (r4.emit(r5, r16) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Job jobLaunch$default;
        Object objTryAwaitRelease;
        boolean z;
        PressInteraction.Release release;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new AbstractClickableNode$handlePressInteraction$2$1$delayJob$1(this.this$0, this.$offset, this.$interactionSource, null), 3, null);
            PressGestureScope pressGestureScope = this.$this_handlePressInteraction;
            this.L$0 = jobLaunch$default;
            this.label = 1;
            objTryAwaitRelease = pressGestureScope.tryAwaitRelease(this);
            if (objTryAwaitRelease != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            jobLaunch$default = (Job) this.L$0;
            ResultKt.throwOnFailure(obj);
            objTryAwaitRelease = obj;
        } else {
            if (i == 2) {
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
                if (z) {
                    PressInteraction.Press press = new PressInteraction.Press(this.$offset, null);
                    PressInteraction.Release release2 = new PressInteraction.Release(press);
                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                    this.L$0 = release2;
                    this.label = 3;
                    if (mutableInteractionSource.emit(press, this) != coroutine_suspended) {
                        release = release2;
                        MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
                        this.L$0 = null;
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                this.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            }
            if (i != 3) {
                if (i != 4 && i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            }
            release = (PressInteraction.Release) this.L$0;
            ResultKt.throwOnFailure(obj);
            MutableInteractionSource mutableInteractionSource22 = this.$interactionSource;
            this.L$0 = null;
            this.label = 4;
        }
        boolean zBooleanValue = ((Boolean) objTryAwaitRelease).booleanValue();
        if (!jobLaunch$default.isActive()) {
            PressInteraction.Press press2 = this.this$0.pressInteraction;
            if (press2 != null) {
                MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
                Interaction release3 = zBooleanValue ? new PressInteraction.Release(press2) : new PressInteraction.Cancel(press2);
                this.L$0 = null;
                this.label = 5;
            }
            this.this$0.pressInteraction = null;
            return Unit.INSTANCE;
        }
        this.L$0 = null;
        this.Z$0 = zBooleanValue;
        this.label = 2;
        if (JobKt.cancelAndJoin(jobLaunch$default, this) != coroutine_suspended) {
            z = zBooleanValue;
            if (z) {
            }
            this.this$0.pressInteraction = null;
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AbstractClickableNode$handlePressInteraction$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
