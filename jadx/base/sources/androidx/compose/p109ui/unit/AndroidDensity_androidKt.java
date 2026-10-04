package androidx.compose.p109ui.unit;

import android.content.Context;
import androidx.compose.p109ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.p109ui.unit.fontscaling.FontScaleConverterFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m13886d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "context", "Landroid/content/Context;", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidDensity_androidKt {
    @NotNull
    public static final Density Density(@NotNull Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        float f4 = context.getResources().getDisplayMetrics().density;
        FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.INSTANCE.forScale(f);
        if (fontScaleConverterForScale == null) {
            fontScaleConverterForScale = new LinearFontScaleConverter(f);
        }
        return new DensityWithConverter(f4, f, fontScaleConverterForScale);
    }
}
