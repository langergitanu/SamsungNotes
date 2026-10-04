package androidx.glance;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u000e\b\u0001\u0010\u0003\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"<anonymous>", "T", "", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/Applier;", "invoke", "()Ljava/lang/Object;", "androidx/compose/runtime/ComposablesKt$ComposeNode$1"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 176)
@SourceDebugExtension({"SMAP\nComposables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composables.kt\nandroidx/compose/runtime/ComposablesKt$ComposeNode$1\n*L\n1#1,484:1\n*E\n"})
public final class GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1<T> extends Lambda implements Function0<T> {
    final /* synthetic */ Function0 $factory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(Function0 function0) {
        super(0);
        this.$factory = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        return (T) this.$factory.invoke();
    }
}
