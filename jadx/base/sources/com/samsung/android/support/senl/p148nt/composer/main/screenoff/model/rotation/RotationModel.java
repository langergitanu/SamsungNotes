package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation;

import android.view.View;
import android.view.WindowInsets;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowInsetsCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p059N3.ViewOnApplyWindowInsetsListenerC0186a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/rotation/RotationModel;", "", "<init>", "()V", "mOrientationListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/rotation/IRotationModel;", "mDecorView", "Landroid/view/View;", "mRotation", "", "init", "", "orientationListener", "decorView", Key.ROTATION, "getRotation", "()I", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RotationModel {
    private static final int ROTATION_UNDEFINED = -1;

    @Nullable
    private View mDecorView;

    @Nullable
    private IRotationModel mOrientationListener;
    private int mRotation = -1;

    @NotNull
    private static final String TAG = SOLogger.createTag("RotationModel");

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets init$lambda$0(RotationModel rotationModel, View view, WindowInsets insets) {
        WindowInsets windowInsetsOnApplyWindowInsets;
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int iFindRotationByWindowInsets = WindowInsetsCompat.INSTANCE.getInstance().findRotationByWindowInsets(insets, ConfigurationModel.INSTANCE.hasGestureNavigation(), -1);
        if (iFindRotationByWindowInsets != -1) {
            int i = rotationModel.mRotation;
            rotationModel.mRotation = iFindRotationByWindowInsets;
            SOLogger sOLogger = SOLogger.INSTANCE;
            String str = TAG;
            sOLogger.SOLoggerD(str, AbstractC1038a.m1214o(i, iFindRotationByWindowInsets, "onApplyWindowInsets# before/after rotation ", "/"));
            if (Math.abs(i - rotationModel.mRotation) == 2) {
                sOLogger.SOLoggerD(str, "onApplyWindowInsets# onHalfWheelRotationChanged by detecting 180 degree rotation");
                IRotationModel iRotationModel = rotationModel.mOrientationListener;
                if (iRotationModel != null) {
                    iRotationModel.onHalfWheelRotationChanged();
                }
            }
        }
        View view2 = rotationModel.mDecorView;
        return (view2 == null || (windowInsetsOnApplyWindowInsets = view2.onApplyWindowInsets(insets)) == null) ? insets : windowInsetsOnApplyWindowInsets;
    }

    public final int getRotation() {
        AbstractC8014b.m7206h("getRotation# ", this.mRotation, SOLogger.INSTANCE, TAG);
        return this.mRotation;
    }

    public final void init(@Nullable IRotationModel orientationListener, @Nullable View decorView) {
        View view;
        SOLogger.INSTANCE.SOLoggerD(TAG, "init");
        this.mOrientationListener = orientationListener;
        this.mDecorView = decorView;
        if (ConfigurationModel.hasSWNavigation()) {
            ConfigurationModel configurationModel = ConfigurationModel.INSTANCE;
            if (!configurationModel.isSupportRotation() || configurationModel.isSupportNavigationRotation() || (view = this.mDecorView) == null) {
                return;
            }
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0186a(this, 0));
        }
    }
}
