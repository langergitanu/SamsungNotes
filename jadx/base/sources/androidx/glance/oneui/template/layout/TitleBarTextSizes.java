package androidx.glance.oneui.template.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.text.ComplexUnit;
import androidx.glance.text.FontWeight;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/template/layout/TitleBarTextSizes;", "", "()V", ExternalDataConstants.Column.BODY_TEXT, "Landroidx/glance/oneui/template/layout/TextSize;", "getBodyText", "()Landroidx/glance/oneui/template/layout/TextSize;", "titleText", "getTitleText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TitleBarTextSizes {
    public static final int $stable = 0;

    @NotNull
    public static final TitleBarTextSizes INSTANCE = new TitleBarTextSizes();

    private TitleBarTextSizes() {
    }

    @NotNull
    public final TextSize getBodyText() {
        return new TextSize(12.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21998getNormalWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TextSize getTitleText() {
        return new TextSize(16.0f, ComplexUnit.f1613DP, FontWeight.INSTANCE.m21999getSemiBoldWjrlUT0(), 0.0f, 8, (DefaultConstructorMarker) null);
    }
}
