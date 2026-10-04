package androidx.core.widget;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.SeslGoToTopController;
import androidx.core.widget.SeslNestedGoToTopController;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslGoToTopControllerFactory {

    /* JADX INFO: renamed from: androidx.core.widget.SeslGoToTopControllerFactory$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C24941 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$core$widget$SeslGoToTopControllerFactory$ControllerType */
        static final /* synthetic */ int[] f1361xb7599abd;

        static {
            int[] iArr = new int[ControllerType.values().length];
            f1361xb7599abd = iArr;
            try {
                iArr[ControllerType.RECYCLERVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1361xb7599abd[ControllerType.NESTEDSCROLLVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ControllerType {
        RECYCLERVIEW,
        NESTEDSCROLLVIEW
    }

    @Nullable
    public static SeslGoToTopController createController(@NonNull ControllerType controllerType, @NonNull SeslGoToTopConfig seslGoToTopConfig, @NonNull SeslGoToTopController.Host host, @NonNull String str) {
        try {
            int i = C24941.f1361xb7599abd[controllerType.ordinal()];
            if (i == 1) {
                return new SeslGoToTopController.Builder().setHost(host).setConfig(seslGoToTopConfig).build();
            }
            if (i == 2) {
                return new SeslNestedGoToTopController.Builder().setHost(host).setConfig(seslGoToTopConfig).build();
            }
            Log.e(str, "Unknown controller type: " + controllerType);
            return null;
        } catch (Throwable th) {
            Log.e(str, "Failed to initialize GoToTopController", th);
            return null;
        }
    }
}
