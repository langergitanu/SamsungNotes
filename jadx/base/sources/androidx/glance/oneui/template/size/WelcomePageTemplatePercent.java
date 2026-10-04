package androidx.glance.oneui.template.size;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.oneui.common.AppWidgetSize;
import androidx.glance.oneui.template.TextType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, m13886d2 = {"Landroidx/glance/oneui/template/size/WelcomePageTemplatePercent;", "", "()V", "ICON_SIZE_PERCENT", "Lkotlin/Pair;", "", "getICON_SIZE_PERCENT", "()Lkotlin/Pair;", "MEDIUM_BOTTOM_PADDING", "getMEDIUM_BOTTOM_PADDING", "()F", "MEDIUM_TOP_PADDING", "getMEDIUM_TOP_PADDING", "getButtonSize", "widgetSize", "Landroidx/glance/oneui/common/AppWidgetSize;", "getButtonSize-L2j3NV4", "(I)Lkotlin/Pair;", "getTextViewHeightPercent", "type", "Landroidx/glance/oneui/template/TextType;", "maxLines", "", "getTextViewHeightPercent-tZlUyYw", "(III)F", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class WelcomePageTemplatePercent {
    public static final int $stable = 0;

    @NotNull
    public static final WelcomePageTemplatePercent INSTANCE = new WelcomePageTemplatePercent();

    @NotNull
    private static final Pair<Float, Float> ICON_SIZE_PERCENT = new Pair<>(Float.valueOf(0.28f), Float.valueOf(0.245f));
    private static final float MEDIUM_TOP_PADDING = 0.1f;
    private static final float MEDIUM_BOTTOM_PADDING = 0.1f;

    private WelcomePageTemplatePercent() {
    }

    @NotNull
    /* JADX INFO: renamed from: getButtonSize-L2j3NV4, reason: not valid java name */
    public final Pair<Float, Float> m21954getButtonSizeL2j3NV4(int widgetSize) {
        Float fValueOf = Float.valueOf(0.75f);
        AppWidgetSize.Companion companion = AppWidgetSize.INSTANCE;
        return AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21571getTinyrx25Pp4()) ? TuplesKt.m13893to(fValueOf, fValueOf) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21570getSmallrx25Pp4()) ? TuplesKt.m13893to(Float.valueOf(0.385f), fValueOf) : AppWidgetSize.m21550equalsimpl0(widgetSize, companion.m21573getWideSmallrx25Pp4()) ? TuplesKt.m13893to(Float.valueOf(0.175f), fValueOf) : TuplesKt.m13893to(Float.valueOf(0.28f), Float.valueOf(0.245f));
    }

    @NotNull
    public final Pair<Float, Float> getICON_SIZE_PERCENT() {
        return ICON_SIZE_PERCENT;
    }

    public final float getMEDIUM_BOTTOM_PADDING() {
        return MEDIUM_BOTTOM_PADDING;
    }

    public final float getMEDIUM_TOP_PADDING() {
        return MEDIUM_TOP_PADDING;
    }

    /* JADX INFO: renamed from: getTextViewHeightPercent-tZlUyYw, reason: not valid java name */
    public final float m21955getTextViewHeightPercenttZlUyYw(int widgetSize, int type, int maxLines) {
        TextType.Companion companion = TextType.INSTANCE;
        if (TextType.m21684equalsimpl0(type, companion.m21694getTitlegxbDmow())) {
            AppWidgetSize.Companion companion2 = AppWidgetSize.INSTANCE;
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21571getTinyrx25Pp4())) {
                return 0.3f;
            }
            if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion2.m21573getWideSmallrx25Pp4())) {
                return maxLines == 1 ? 0.31f : 0.61f;
            }
            return 0.125f;
        }
        if (TextType.m21684equalsimpl0(type, companion.m21693getLabelgxbDmow())) {
            return 0.3f;
        }
        AppWidgetSize.Companion companion3 = AppWidgetSize.INSTANCE;
        if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21571getTinyrx25Pp4())) {
            return 0.3f;
        }
        if (AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21570getSmallrx25Pp4()) ? true : AppWidgetSize.m21550equalsimpl0(widgetSize, companion3.m21573getWideSmallrx25Pp4())) {
            return 0.26f;
        }
        if (maxLines != 1) {
            return maxLines != 2 ? 0.31f : 0.205f;
        }
        return 0.105f;
    }
}
