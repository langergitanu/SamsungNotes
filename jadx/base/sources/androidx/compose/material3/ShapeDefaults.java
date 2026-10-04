package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.tokens.ShapeTokens;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/material3/ShapeDefaults;", "", "()V", "ExtraLarge", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getExtraLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "ExtraSmall", "getExtraSmall", "Large", "getLarge", "Medium", "getMedium", "Small", "getSmall", "material3_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ShapeDefaults {
    public static final int $stable = 0;

    @NotNull
    private static final CornerBasedShape ExtraLarge;

    @NotNull
    private static final CornerBasedShape ExtraSmall;

    @NotNull
    public static final ShapeDefaults INSTANCE = new ShapeDefaults();

    @NotNull
    private static final CornerBasedShape Large;

    @NotNull
    private static final CornerBasedShape Medium;

    @NotNull
    private static final CornerBasedShape Small;

    static {
        ShapeTokens shapeTokens = ShapeTokens.INSTANCE;
        ExtraSmall = shapeTokens.getCornerExtraSmall();
        Small = shapeTokens.getCornerSmall();
        Medium = shapeTokens.getCornerMedium();
        Large = shapeTokens.getCornerLarge();
        ExtraLarge = shapeTokens.getCornerExtraLarge();
    }

    private ShapeDefaults() {
    }

    @NotNull
    public final CornerBasedShape getExtraLarge() {
        return ExtraLarge;
    }

    @NotNull
    public final CornerBasedShape getExtraSmall() {
        return ExtraSmall;
    }

    @NotNull
    public final CornerBasedShape getLarge() {
        return Large;
    }

    @NotNull
    public final CornerBasedShape getMedium() {
        return Medium;
    }

    @NotNull
    public final CornerBasedShape getSmall() {
        return Small;
    }
}
