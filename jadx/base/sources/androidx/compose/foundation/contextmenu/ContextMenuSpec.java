package androidx.compose.foundation.contextmenu;

import androidx.annotation.VisibleForTesting;
import androidx.compose.p109ui.Alignment;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.text.PlatformTextStyle;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.p109ui.text.font.FontFamily;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.intl.LocaleList;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.LineHeightStyle;
import androidx.compose.p109ui.text.style.TextAlign;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.text.style.TextIndent;
import androidx.compose.p109ui.text.style.TextMotion;
import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.p109ui.unit.TextUnitKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b#\u0010\u000fR\u0019\u0010$\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b%\u0010\u000fR\u0019\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, m13886d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuSpec;", "", "()V", "ContainerWidthMax", "Landroidx/compose/ui/unit/Dp;", "getContainerWidthMax-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "ContainerWidthMin", "getContainerWidthMin-D9Ej5fM", "CornerRadius", "getCornerRadius-D9Ej5fM", "FontSize", "Landroidx/compose/ui/unit/TextUnit;", "getFontSize-XSAIIZE", "()J", "J", "FontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "HorizontalPadding", "getHorizontalPadding-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "LabelHorizontalTextAlignment", "Landroidx/compose/ui/text/style/TextAlign;", "getLabelHorizontalTextAlignment-e0LSkKk", "()I", "I", "LabelVerticalTextAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getLabelVerticalTextAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "LetterSpacing", "getLetterSpacing-XSAIIZE", "LineHeight", "getLineHeight-XSAIIZE", "ListItemHeight", "getListItemHeight-D9Ej5fM", "MenuContainerElevation", "getMenuContainerElevation-D9Ej5fM", "VerticalPadding", "getVerticalPadding-D9Ej5fM", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "textStyle-8_81llA", "(J)Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@VisibleForTesting
@SourceDebugExtension({"SMAP\nContextMenuUi.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextMenuUi.android.kt\nandroidx/compose/foundation/contextmenu/ContextMenuSpec\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,415:1\n149#2:416\n149#2:417\n149#2:418\n149#2:419\n149#2:420\n149#2:421\n149#2:422\n149#2:423\n*S KotlinDebug\n*F\n+ 1 ContextMenuUi.android.kt\nandroidx/compose/foundation/contextmenu/ContextMenuSpec\n*L\n70#1:416\n71#1:417\n72#1:418\n73#1:419\n74#1:420\n77#1:421\n78#1:422\n79#1:423\n*E\n"})
public final class ContextMenuSpec {
    public static final int $stable = 0;

    @NotNull
    public static final ContextMenuSpec INSTANCE = new ContextMenuSpec();
    private static final float ContainerWidthMin = C2256Dp.m20968constructorimpl(112);
    private static final float ContainerWidthMax = C2256Dp.m20968constructorimpl(280);
    private static final float ListItemHeight = C2256Dp.m20968constructorimpl(48);
    private static final float MenuContainerElevation = C2256Dp.m20968constructorimpl(3);
    private static final float CornerRadius = C2256Dp.m20968constructorimpl(4);

    @NotNull
    private static final Alignment.Vertical LabelVerticalTextAlignment = Alignment.INSTANCE.getCenterVertically();
    private static final int LabelHorizontalTextAlignment = TextAlign.INSTANCE.m20862getStarte0LSkKk();
    private static final float HorizontalPadding = C2256Dp.m20968constructorimpl(12);
    private static final float VerticalPadding = C2256Dp.m20968constructorimpl(8);
    private static final float IconSize = C2256Dp.m20968constructorimpl(24);
    private static final long FontSize = TextUnitKt.getSp(14);

    @NotNull
    private static final FontWeight FontWeight = FontWeight.INSTANCE.getMedium();
    private static final long LineHeight = TextUnitKt.getSp(20);
    private static final long LetterSpacing = TextUnitKt.getSp(0.1f);

    private ContextMenuSpec() {
    }

    /* JADX INFO: renamed from: getContainerWidthMax-D9Ej5fM, reason: not valid java name */
    public final float m15519getContainerWidthMaxD9Ej5fM() {
        return ContainerWidthMax;
    }

    /* JADX INFO: renamed from: getContainerWidthMin-D9Ej5fM, reason: not valid java name */
    public final float m15520getContainerWidthMinD9Ej5fM() {
        return ContainerWidthMin;
    }

    /* JADX INFO: renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m15521getCornerRadiusD9Ej5fM() {
        return CornerRadius;
    }

    /* JADX INFO: renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m15522getFontSizeXSAIIZE() {
        return FontSize;
    }

    @NotNull
    public final FontWeight getFontWeight() {
        return FontWeight;
    }

    /* JADX INFO: renamed from: getHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m15523getHorizontalPaddingD9Ej5fM() {
        return HorizontalPadding;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m15524getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getLabelHorizontalTextAlignment-e0LSkKk, reason: not valid java name */
    public final int m15525getLabelHorizontalTextAlignmente0LSkKk() {
        return LabelHorizontalTextAlignment;
    }

    @NotNull
    public final Alignment.Vertical getLabelVerticalTextAlignment() {
        return LabelVerticalTextAlignment;
    }

    /* JADX INFO: renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m15526getLetterSpacingXSAIIZE() {
        return LetterSpacing;
    }

    /* JADX INFO: renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m15527getLineHeightXSAIIZE() {
        return LineHeight;
    }

    /* JADX INFO: renamed from: getListItemHeight-D9Ej5fM, reason: not valid java name */
    public final float m15528getListItemHeightD9Ej5fM() {
        return ListItemHeight;
    }

    /* JADX INFO: renamed from: getMenuContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m15529getMenuContainerElevationD9Ej5fM() {
        return MenuContainerElevation;
    }

    /* JADX INFO: renamed from: getVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m15530getVerticalPaddingD9Ej5fM() {
        return VerticalPadding;
    }

    @NotNull
    /* JADX INFO: renamed from: textStyle-8_81llA, reason: not valid java name */
    public final TextStyle m15531textStyle8_81llA(long color) {
        int i = LabelHorizontalTextAlignment;
        return new TextStyle(color, FontSize, FontWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, LetterSpacing, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, i, 0, LineHeight, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613240, (DefaultConstructorMarker) null);
    }
}
