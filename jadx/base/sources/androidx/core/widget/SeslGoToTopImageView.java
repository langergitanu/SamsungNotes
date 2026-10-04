package androidx.core.widget;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslGoToTopImageView extends ImageView {
    private WindowLocationProvider mWindowLocationProvider;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface WindowLocationProvider {
        void provideWindowOffset(int[] iArr);
    }

    public SeslGoToTopImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void getLocationInWindow(int[] iArr) {
        super.getLocationInWindow(iArr);
        WindowLocationProvider windowLocationProvider = this.mWindowLocationProvider;
        if (windowLocationProvider != null) {
            windowLocationProvider.provideWindowOffset(iArr);
        }
    }

    public WindowLocationProvider getWindowLocationProvider() {
        return this.mWindowLocationProvider;
    }

    public void setWindowLocationProvider(@Nullable WindowLocationProvider windowLocationProvider) {
        if (this.mWindowLocationProvider != windowLocationProvider) {
            this.mWindowLocationProvider = windowLocationProvider;
        }
    }
}
