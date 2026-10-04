package androidx.glance.oneui.template.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSessionManager$scope$1", m14021f = "PreviewSessionManager.kt", m14022i = {0, 0, 1}, m14023l = {42, 50}, m14024m = "startCoroutineSession", m14025n = {"context", "session", "session"}, m14026s = {"L$0", "L$1", "L$0"})
public final class PreviewSessionManager$scope$1$startCoroutineSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewSessionManager$scope$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewSessionManager$scope$1$startCoroutineSession$1(PreviewSessionManager$scope$1 previewSessionManager$scope$1, Continuation<? super PreviewSessionManager$scope$1$startCoroutineSession$1> continuation) {
        super(continuation);
        this.this$0 = previewSessionManager$scope$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startCoroutineSession(null, null, this);
    }
}
