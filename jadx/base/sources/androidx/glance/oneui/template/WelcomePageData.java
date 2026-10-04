package androidx.glance.oneui.template;

import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.layout.Alignment;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/oneui/template/WelcomePageData;", "", "icon", "Landroidx/glance/oneui/template/ImageWithBackgroundData;", "titleText", "Landroidx/glance/oneui/template/TextData;", ExternalDataConstants.Column.BODY_TEXT, "contentAlign", "Landroidx/glance/layout/Alignment$Horizontal;", "illustrationBg", "", "(Landroidx/glance/oneui/template/ImageWithBackgroundData;Landroidx/glance/oneui/template/TextData;Landroidx/glance/oneui/template/TextData;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBodyText", "()Landroidx/glance/oneui/template/TextData;", "getContentAlign-PGIyAqw$annotations", "()V", "getContentAlign-PGIyAqw", "()I", "I", "getIcon", "()Landroidx/glance/oneui/template/ImageWithBackgroundData;", "getIllustrationBg", "getTitleText", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class WelcomePageData {
    public static final int $stable = 8;

    @Nullable
    private final TextData bodyText;
    private final int contentAlign;

    @Nullable
    private final ImageWithBackgroundData icon;
    private final int illustrationBg;

    @NotNull
    private final TextData titleText;

    public /* synthetic */ WelcomePageData(ImageWithBackgroundData imageWithBackgroundData, TextData textData, TextData textData2, int i, @DrawableRes int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageWithBackgroundData, textData, textData2, i, i2);
    }

    @Nullable
    public final TextData getBodyText() {
        return this.bodyText;
    }

    /* JADX INFO: renamed from: getContentAlign-PGIyAqw, reason: not valid java name and from getter */
    public final int getContentAlign() {
        return this.contentAlign;
    }

    @Nullable
    public final ImageWithBackgroundData getIcon() {
        return this.icon;
    }

    public final int getIllustrationBg() {
        return this.illustrationBg;
    }

    @NotNull
    public final TextData getTitleText() {
        return this.titleText;
    }

    private WelcomePageData(ImageWithBackgroundData imageWithBackgroundData, TextData titleText, TextData textData, int i, int i2) {
        Intrinsics.checkNotNullParameter(titleText, "titleText");
        this.icon = imageWithBackgroundData;
        this.titleText = titleText;
        this.bodyText = textData;
        this.contentAlign = i;
        this.illustrationBg = i2;
    }

    public /* synthetic */ WelcomePageData(ImageWithBackgroundData imageWithBackgroundData, TextData textData, TextData textData2, int i, int i2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageWithBackgroundData, textData, (i4 & 4) != 0 ? null : textData2, (i4 & 8) != 0 ? Alignment.INSTANCE.m21433getStartPGIyAqw() : i, (i4 & 16) != 0 ? 0 : i2, null);
    }

    @Deprecated(message = "This contentAlign is deprecated since OneUI8.5. WelcomepageTemplate only supports Start alignment.")
    /* JADX INFO: renamed from: getContentAlign-PGIyAqw$annotations, reason: not valid java name */
    public static /* synthetic */ void m21698getContentAlignPGIyAqw$annotations() {
    }
}
