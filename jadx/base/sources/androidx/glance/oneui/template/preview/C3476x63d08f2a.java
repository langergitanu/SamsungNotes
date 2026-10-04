package androidx.glance.oneui.template.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewContentReceiverKt$runGlance$1$receiver$1$providePreviewContent$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewContentReceiverKt$runGlance$1$receiver$1", m14021f = "PreviewContentReceiver.kt", m14022i = {0}, m14023l = {50}, m14024m = "providePreviewContent", m14025n = {"content"}, m14026s = {"L$0"})
public final class C3476x63d08f2a extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewContentReceiverKt$runGlance$1$receiver$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3476x63d08f2a(PreviewContentReceiverKt$runGlance$1$receiver$1 previewContentReceiverKt$runGlance$1$receiver$1, Continuation<? super C3476x63d08f2a> continuation) {
        super(continuation);
        this.this$0 = previewContentReceiverKt$runGlance$1$receiver$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.providePreviewContent(null, this);
    }
}
