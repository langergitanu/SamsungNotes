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
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSession", m14021f = "PreviewSession.kt", m14022i = {0, 0, 0}, m14023l = {120}, m14024m = "getPreviewGlanceState$glance_oneui_template_release", m14025n = {"this", "context", "result$iv"}, m14026s = {"L$0", "L$1", "L$2"})
public final class PreviewSession$getPreviewGlanceState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewSession$getPreviewGlanceState$1(PreviewSession previewSession, Continuation<? super PreviewSession$getPreviewGlanceState$1> continuation) {
        super(continuation);
        this.this$0 = previewSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPreviewGlanceState$glance_oneui_template_release(null, this);
    }
}
