package androidx.glance.appwidget;

import androidx.glance.appwidget.UnmanagedSessionReceiver;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.UnmanagedSessionReceiver$Companion", m14021f = "UnmanagedSessionReceiver.kt", m14022i = {0, 0}, m14023l = {139}, m14024m = "registerSession", m14025n = {"session", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID}, m14026s = {"L$0", "I$0"})
public final class UnmanagedSessionReceiver$Companion$registerSession$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnmanagedSessionReceiver.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnmanagedSessionReceiver$Companion$registerSession$1(UnmanagedSessionReceiver.Companion companion, Continuation<? super UnmanagedSessionReceiver$Companion$registerSession$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerSession(0, null, this);
    }
}
