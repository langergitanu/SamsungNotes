package androidx.compose.p109ui.graphics;

import android.graphics.Shader;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Immutable
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, m13886d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "()V", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "createShader", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBrush.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Brush.kt\nandroidx/compose/ui/graphics/ShaderBrush\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,670:1\n1#2:671\n*E\n"})
public abstract class ShaderBrush extends Brush {
    private long createdSize;

    @Nullable
    private Shader internalShader;

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.INSTANCE.m18361getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.p109ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo18472applyToPq9zytI(long size, @NotNull Paint p, float alpha) {
        Shader shaderMo18494createShaderuvyYCjk = this.internalShader;
        if (shaderMo18494createShaderuvyYCjk == null || !Size.m18349equalsimpl0(this.createdSize, size)) {
            if (Size.m18355isEmptyimpl(size)) {
                shaderMo18494createShaderuvyYCjk = null;
                this.internalShader = null;
                this.createdSize = Size.INSTANCE.m18361getUnspecifiedNHjbRc();
            } else {
                shaderMo18494createShaderuvyYCjk = mo18494createShaderuvyYCjk(size);
                this.internalShader = shaderMo18494createShaderuvyYCjk;
                this.createdSize = size;
            }
        }
        long jMo18398getColor0d7_KjU = p.mo18398getColor0d7_KjU();
        Color.Companion companion = Color.INSTANCE;
        if (!Color.m18526equalsimpl0(jMo18398getColor0d7_KjU, companion.m18551getBlack0d7_KjU())) {
            p.mo18404setColor8_81llA(companion.m18551getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual(p.getShader(), shaderMo18494createShaderuvyYCjk)) {
            p.setShader(shaderMo18494createShaderuvyYCjk);
        }
        if (p.getAlpha() == alpha) {
            return;
        }
        p.setAlpha(alpha);
    }

    @NotNull
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo18494createShaderuvyYCjk(long size);
}
