package androidx.compose.p109ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.text.font.FontVariation;
import androidx.compose.runtime.Stable;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\b\u0010\u0015\u001a\u00020\u0016H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, m13886d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", BundleContract.FILE_DESCRIPTOR, "Landroid/os/ParcelFileDescriptor;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-Ej4NQ78", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "path", "", "assetManager", "Landroid/content/res/AssetManager;", "Font-MuC2MFs", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "generateAndroidFontKtForApiCompatibility", "", "ui-text_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmName(name = "AndroidFontKt")
public final class AndroidFontKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m20514FontEj4NQ78(@NotNull File file, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings) {
        return new AndroidFileFont(file, fontWeight, i, settings, null);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m20516FontEj4NQ78$default(File file, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.INSTANCE.m20572getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = FontVariation.INSTANCE.m20587Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m20514FontEj4NQ78(file, fontWeight, i, settings);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: Font-MuC2MFs, reason: not valid java name */
    public static final Font m20517FontMuC2MFs(@NotNull String str, @NotNull AssetManager assetManager, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings) {
        return new AndroidAssetFont(assetManager, str, fontWeight, i, settings, null);
    }

    /* JADX INFO: renamed from: Font-MuC2MFs$default, reason: not valid java name */
    public static /* synthetic */ Font m20518FontMuC2MFs$default(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.INSTANCE.m20572getNormal_LCdwA();
        }
        if ((i2 & 16) != 0) {
            settings = FontVariation.INSTANCE.m20587Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m20517FontMuC2MFs(str, assetManager, fontWeight, i, settings);
    }

    @Stable
    @RequiresApi(26)
    @NotNull
    /* JADX INFO: renamed from: Font-Ej4NQ78, reason: not valid java name */
    public static final Font m20513FontEj4NQ78(@NotNull ParcelFileDescriptor parcelFileDescriptor, @NotNull FontWeight fontWeight, int i, @NotNull FontVariation.Settings settings) {
        return new AndroidFileDescriptorFont(parcelFileDescriptor, fontWeight, i, settings, null);
    }

    /* JADX INFO: renamed from: Font-Ej4NQ78$default, reason: not valid java name */
    public static /* synthetic */ Font m20515FontEj4NQ78$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.INSTANCE.m20572getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = FontVariation.INSTANCE.m20587Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m20513FontEj4NQ78(parcelFileDescriptor, fontWeight, i, settings);
    }

    private static final void generateAndroidFontKtForApiCompatibility() {
    }
}
