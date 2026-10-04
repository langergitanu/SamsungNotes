package androidx.compose.material;

import androidx.compose.p109ui.unit.C2256Dp;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m13886d2 = {"Landroidx/compose/material/BottomSheetScaffoldDefaults;", "", "()V", "SheetElevation", "Landroidx/compose/ui/unit/Dp;", "getSheetElevation-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BottomSheetScaffoldDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final BottomSheetScaffoldDefaults INSTANCE = new BottomSheetScaffoldDefaults();
    private static final float SheetElevation = C2256Dp.m20968constructorimpl(8);
    private static final float SheetPeekHeight = C2256Dp.m20968constructorimpl(56);

    private BottomSheetScaffoldDefaults() {
    }

    /* JADX INFO: renamed from: getSheetElevation-D9Ej5fM, reason: not valid java name */
    public final float m16617getSheetElevationD9Ej5fM() {
        return SheetElevation;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m16618getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }
}
