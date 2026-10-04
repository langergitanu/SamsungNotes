package androidx.compose.p109ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.compose.p109ui.graphics.TileMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, m13886d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class AndroidTileMode_androidKt {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            try {
                iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: isSupported-0vamqd0, reason: not valid java name */
    public static final boolean m18429isSupported0vamqd0(int i) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.m18894equalsimpl0(i, TileMode.INSTANCE.m18899getDecal3opZhB0());
    }

    @NotNull
    /* JADX INFO: renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m18430toAndroidTileMode0vamqd0(int i) {
        TileMode.Companion companion = TileMode.INSTANCE;
        return TileMode.m18894equalsimpl0(i, companion.m18898getClamp3opZhB0()) ? Shader.TileMode.CLAMP : TileMode.m18894equalsimpl0(i, companion.m18901getRepeated3opZhB0()) ? Shader.TileMode.REPEAT : TileMode.m18894equalsimpl0(i, companion.m18900getMirror3opZhB0()) ? Shader.TileMode.MIRROR : TileMode.m18894equalsimpl0(i, companion.m18899getDecal3opZhB0()) ? Build.VERSION.SDK_INT >= 31 ? TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal() : Shader.TileMode.CLAMP : Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(@NotNull Shader.TileMode tileMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? (Build.VERSION.SDK_INT < 31 || tileMode != Shader.TileMode.DECAL) ? TileMode.INSTANCE.m18898getClamp3opZhB0() : TileModeVerificationHelper.INSTANCE.m18902getComposeTileModeDecal3opZhB0() : TileMode.INSTANCE.m18901getRepeated3opZhB0() : TileMode.INSTANCE.m18900getMirror3opZhB0() : TileMode.INSTANCE.m18898getClamp3opZhB0();
    }
}
