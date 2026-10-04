package androidx.glance.appwidget;

import androidx.glance.GlanceModifier;
import androidx.glance.color.DayNightColorProvidersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, m13886d2 = {"background", "Landroidx/glance/GlanceModifier;", "day", "Landroidx/compose/ui/graphics/Color;", "night", "background-WkMS-hQ", "(Landroidx/glance/GlanceModifier;JJ)Landroidx/glance/GlanceModifier;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class BackgroundKt {
    @NotNull
    /* JADX INFO: renamed from: background-WkMS-hQ, reason: not valid java name */
    public static final GlanceModifier m21270backgroundWkMShQ(@NotNull GlanceModifier background, long j, long j2) {
        Intrinsics.checkNotNullParameter(background, "$this$background");
        return androidx.glance.BackgroundKt.background(background, DayNightColorProvidersKt.m21426ColorProviderOWjLjI(j, j2));
    }
}
