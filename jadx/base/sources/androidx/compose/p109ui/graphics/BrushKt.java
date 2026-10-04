package androidx.compose.p109ui.graphics;

import android.graphics.Shader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, m13886d2 = {"ShaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "shader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class BrushKt {
    @NotNull
    public static final ShaderBrush ShaderBrush(@NotNull final Shader shader) {
        return new ShaderBrush() { // from class: androidx.compose.ui.graphics.BrushKt.ShaderBrush.1
            @Override // androidx.compose.p109ui.graphics.ShaderBrush
            @NotNull
            /* JADX INFO: renamed from: createShader-uvyYCjk, reason: not valid java name */
            public Shader mo18494createShaderuvyYCjk(long size) {
                return shader;
            }
        };
    }
}
