package androidx.glance.oneui.template;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.GlanceTemplateAppWidget", m14021f = "GlanceTemplateAppWidget.kt", m14022i = {}, m14023l = {163}, m14024m = "providePreview$glance_oneui_template_release", m14025n = {}, m14026s = {})
public final class GlanceTemplateAppWidget$providePreview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlanceTemplateAppWidget this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceTemplateAppWidget$providePreview$1(GlanceTemplateAppWidget glanceTemplateAppWidget, Continuation<? super GlanceTemplateAppWidget$providePreview$1> continuation) {
        super(continuation);
        this.this$0 = glanceTemplateAppWidget;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.providePreview$glance_oneui_template_release(null, this);
    }
}
