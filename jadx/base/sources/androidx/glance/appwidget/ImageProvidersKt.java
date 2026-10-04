package androidx.glance.appwidget;

import android.net.Uri;
import androidx.glance.ImageProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m13886d2 = {"ImageProvider", "Landroidx/glance/ImageProvider;", "uri", "Landroid/net/Uri;", "glance-appwidget_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ImageProvidersKt {
    @NotNull
    public static final ImageProvider ImageProvider(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new UriImageProvider(uri);
    }
}
