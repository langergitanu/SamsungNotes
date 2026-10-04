package androidx.glance.oneui.template.preview;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, m13886d2 = {"LocalPreviewUpdateState", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PreviewSessionKt {

    @NotNull
    private static final ProvidableCompositionLocal<Integer> LocalPreviewUpdateState = CompositionLocalKt.staticCompositionLocalOf(new Function0<Integer>() { // from class: androidx.glance.oneui.template.preview.PreviewSessionKt$LocalPreviewUpdateState$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return 0;
        }
    });
}
