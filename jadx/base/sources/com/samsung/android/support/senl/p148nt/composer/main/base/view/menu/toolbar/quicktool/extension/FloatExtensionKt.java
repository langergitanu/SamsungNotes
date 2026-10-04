package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.extension;

import androidx.annotation.FloatRange;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0086\b\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\u001d\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0087\b\u001a\u001d\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0086\b¨\u0006\u000b"}, m13886d2 = {"sanitize", "", "degrees", "radians", "between", "", "start", "end", "normalize", "sweep", "denormalize", "ntComposer_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFloatExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n*L\n1#1,38:1\n10#1,2:39\n10#1,2:41\n*S KotlinDebug\n*F\n+ 1 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n*L\n32#1:39,2\n36#1:41,2\n*E\n"})
public final class FloatExtensionKt {
    public static final boolean between(float f, float f4, float f5) {
        return f4 > f5 ? f >= f4 || f <= f5 : f4 <= f && f <= f5;
    }

    public static final float degrees(float f) {
        return (float) (((double) (f * 180)) / 3.141592653589793d);
    }

    public static final float denormalize(float f, float f4, float f5) {
        float f6 = (f * f5) + f4;
        float f7 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f8 = f6 % f7;
        return f8 < 0.0f ? f8 + f7 : f8;
    }

    @FloatRange(from = 0.0d, m705to = 1.0d)
    public static final float normalize(float f, float f4, float f5) {
        float f6 = f - f4;
        float f7 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f8 = f6 % f7;
        if (f8 < 0.0f) {
            f8 += f7;
        }
        return f8 / f5;
    }

    public static final float radians(float f) {
        return (float) ((((double) f) * 3.141592653589793d) / ((double) 180));
    }

    @FloatRange(from = 0.0d, m705to = 360.0d, toInclusive = false)
    public static final float sanitize(float f) {
        float f4 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f5 = f % f4;
        return f5 < 0.0f ? f5 + f4 : f5;
    }
}
