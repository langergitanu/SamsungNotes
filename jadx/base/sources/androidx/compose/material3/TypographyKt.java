package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.p109ui.layout.LayoutKt;
import androidx.compose.p109ui.text.TextStyle;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, m13886d2 = {"LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Typography;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "fromToken", "Landroidx/compose/ui/text/TextStyle;", "value", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "material3_release"}, m13887k = 2, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class TypographyKt {

    @NotNull
    private static final ProvidableCompositionLocal<Typography> LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0<Typography>() { // from class: androidx.compose.material3.TypographyKt$LocalTypography$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Typography invoke() {
            return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LayoutKt.LargeDimension, null);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 7, 1}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypographyKeyTokens.values().length];
            iArr[TypographyKeyTokens.DisplayLarge.ordinal()] = 1;
            iArr[TypographyKeyTokens.DisplayMedium.ordinal()] = 2;
            iArr[TypographyKeyTokens.DisplaySmall.ordinal()] = 3;
            iArr[TypographyKeyTokens.HeadlineLarge.ordinal()] = 4;
            iArr[TypographyKeyTokens.HeadlineMedium.ordinal()] = 5;
            iArr[TypographyKeyTokens.HeadlineSmall.ordinal()] = 6;
            iArr[TypographyKeyTokens.TitleLarge.ordinal()] = 7;
            iArr[TypographyKeyTokens.TitleMedium.ordinal()] = 8;
            iArr[TypographyKeyTokens.TitleSmall.ordinal()] = 9;
            iArr[TypographyKeyTokens.BodyLarge.ordinal()] = 10;
            iArr[TypographyKeyTokens.BodyMedium.ordinal()] = 11;
            iArr[TypographyKeyTokens.BodySmall.ordinal()] = 12;
            iArr[TypographyKeyTokens.LabelLarge.ordinal()] = 13;
            iArr[TypographyKeyTokens.LabelMedium.ordinal()] = 14;
            iArr[TypographyKeyTokens.LabelSmall.ordinal()] = 15;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final TextStyle fromToken(@NotNull Typography typography, @NotNull TypographyKeyTokens value) {
        Intrinsics.checkNotNullParameter(typography, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return typography.getDisplayLarge();
            case 2:
                return typography.getDisplayMedium();
            case 3:
                return typography.getDisplaySmall();
            case 4:
                return typography.getHeadlineLarge();
            case 5:
                return typography.getHeadlineMedium();
            case 6:
                return typography.getHeadlineSmall();
            case 7:
                return typography.getTitleLarge();
            case 8:
                return typography.getTitleMedium();
            case 9:
                return typography.getTitleSmall();
            case 10:
                return typography.getBodyLarge();
            case 11:
                return typography.getBodyMedium();
            case 12:
                return typography.getBodySmall();
            case 13:
                return typography.getLabelLarge();
            case 14:
                return typography.getLabelMedium();
            case 15:
                return typography.getLabelSmall();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }
}
