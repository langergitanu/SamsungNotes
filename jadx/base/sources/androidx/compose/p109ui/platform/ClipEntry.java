package androidx.compose.p109ui.platform;

import android.content.ClipData;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/compose/ui/platform/ClipEntry;", "", "clipData", "Landroid/content/ClipData;", "(Landroid/content/ClipData;)V", "getClipData", "()Landroid/content/ClipData;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ClipEntry {
    public static final int $stable = 8;

    @NotNull
    private final ClipData clipData;

    public ClipEntry(@NotNull ClipData clipData) {
        this.clipData = clipData;
    }

    @NotNull
    public final ClipData getClipData() {
        return this.clipData;
    }

    @NotNull
    public final ClipMetadata getClipMetadata() {
        return AndroidClipboardManager_androidKt.toClipMetadata(this.clipData.getDescription());
    }
}
