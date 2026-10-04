package androidx.compose.material;

import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/material/SnackbarData;", "", "actionLabel", "", "getActionLabel", "()Ljava/lang/String;", XmlErrorCodes.DURATION, "Landroidx/compose/material/SnackbarDuration;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "message", "getMessage", "dismiss", "", "performAction", "material_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public interface SnackbarData {
    void dismiss();

    @Nullable
    String getActionLabel();

    @NotNull
    SnackbarDuration getDuration();

    @NotNull
    String getMessage();

    void performAction();
}
