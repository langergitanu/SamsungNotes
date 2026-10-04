package androidx.glance.appwidget.util;

import androidx.glance.appwidget.util.OneTimeUpdateKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2", m14021f = "OneTimeUpdate.kt", m14022i = {0, 0}, m14023l = {44}, m14024m = "invokeSuspend$clearResource", m14025n = {"$this$coroutineScope", "$glanceId"}, m14026s = {"L$0", "L$1"})
public final class OneTimeUpdateKt$updateForOneTime$2$clearResource$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public OneTimeUpdateKt$updateForOneTime$2$clearResource$1(Continuation<? super OneTimeUpdateKt$updateForOneTime$2$clearResource$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OneTimeUpdateKt.C30742.invokeSuspend$clearResource(null, null, null, null, null, null, this);
    }
}
