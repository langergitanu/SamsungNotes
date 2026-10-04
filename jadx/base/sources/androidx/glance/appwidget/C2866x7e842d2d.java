package androidx.glance.appwidget;

import androidx.glance.appwidget.GlanceRemoteViewsService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory$startSessionIfNeededAndWaitUntilReady$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.GlanceRemoteViewsService$GlanceRemoteViewsFactory", m14021f = "GlanceRemoteViewsService.kt", m14022i = {0}, m14023l = {133, 143, 146}, m14024m = "startSessionIfNeededAndWaitUntilReady", m14025n = {"this"}, m14026s = {"L$0"})
public final class C2866x7e842d2d extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlanceRemoteViewsService.GlanceRemoteViewsFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2866x7e842d2d(GlanceRemoteViewsService.GlanceRemoteViewsFactory glanceRemoteViewsFactory, Continuation<? super C2866x7e842d2d> continuation) {
        super(continuation);
        this.this$0 = glanceRemoteViewsFactory;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startSessionIfNeededAndWaitUntilReady(null, this);
    }
}
