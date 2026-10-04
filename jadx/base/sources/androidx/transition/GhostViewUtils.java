package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    @Nullable
    public static GhostView addGhost(@NonNull View view, @NonNull ViewGroup viewGroup, @Nullable Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? GhostViewPlatform.addGhost(view, viewGroup, matrix) : GhostViewPort.addGhost(view, viewGroup, matrix);
    }

    public static void removeGhost(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.removeGhost(view);
        } else {
            GhostViewPort.removeGhost(view);
        }
    }
}
