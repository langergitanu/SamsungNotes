package androidx.glance.oneui.template.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewSessionManager$scope$1$startCoroutineSession$isStateChangedSinceLastCall$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSessionManager$scope$1", m14021f = "PreviewSessionManager.kt", m14022i = {0}, m14023l = {34}, m14024m = "startCoroutineSession$isStateChangedSinceLastCall", m14025n = {"cachedState"}, m14026s = {"L$0"})
public final class C3483xee026ca2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public C3483xee026ca2(Continuation<? super C3483xee026ca2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return PreviewSessionManager$scope$1.startCoroutineSession$isStateChangedSinceLastCall(null, null, this);
    }
}
