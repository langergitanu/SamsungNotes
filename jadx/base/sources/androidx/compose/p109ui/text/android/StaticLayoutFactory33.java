package androidx.compose.p109ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.appsearch.platformstorage.converter.AbstractC0564a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory33;", "", "()V", "isFallbackLineSpacingEnabled", "", DBSchema.DocumentThumbnail.LAYOUT, "Landroid/text/StaticLayout;", "setLineBreakConfig", "", "builder", "Landroid/text/StaticLayout$Builder;", "lineBreakStyle", "", "lineBreakWordStyle", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class StaticLayoutFactory33 {

    @NotNull
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    @JvmStatic
    @DoNotInline
    public static final boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout layout) {
        return layout.isFallbackLineSpacingEnabled();
    }

    @JvmStatic
    @DoNotInline
    public static final void setLineBreakConfig(@NotNull StaticLayout.Builder builder, int lineBreakStyle, int lineBreakWordStyle) {
        builder.setLineBreakConfig(AbstractC0564a.m899c().setLineBreakStyle(lineBreakStyle).setLineBreakWordStyle(lineBreakWordStyle).build());
    }
}
