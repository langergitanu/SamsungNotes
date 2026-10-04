package androidx.glance.appwidget.util;

import androidx.glance.appwidget.util.OneTimeUpdateKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2$1", m14021f = "OneTimeUpdate.kt", m14022i = {0, 1}, m14023l = {60, 69}, m14024m = "emit", m14025n = {"this", "this"}, m14026s = {"L$0", "L$0"})
public final class OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OneTimeUpdateKt.C30742.AnonymousClass1.AnonymousClass2.C145651<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1(OneTimeUpdateKt.C30742.AnonymousClass1.AnonymousClass2.C145651<? super T> c145651, Continuation<? super OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c145651;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1 for r1v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r2) {
        /*
            r1 = this;
            r1.result = r2
            int r2 = r1.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 | r0
            r1.label = r2
            androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2$1<T> r2 = r1.this$0
            r0 = 0
            java.lang.Object r2 = r2.emit(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.util.OneTimeUpdateKt$updateForOneTime$2$1$2$1$emit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
