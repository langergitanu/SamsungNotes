package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.HapticFeedbackConstants;
import com.google.android.material.carousel.RunnableC4617a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/VibrationHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "vibrationEffect", "Landroid/os/VibrationEffect;", "vibrator", "Landroid/os/Vibrator;", "vibratorHandler", "Landroid/os/Handler;", "doVibrate", "", "hitFromLongClick", "", "isVibrationOff", "vibratorInit", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class VibrationHelper {

    @NotNull
    private final Context context;

    @Nullable
    private VibrationEffect vibrationEffect;

    @Nullable
    private Vibrator vibrator;

    @Nullable
    private Handler vibratorHandler;

    public VibrationHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doVibrate$lambda$0(VibrationHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Vibrator vibrator = this$0.vibrator;
        if (vibrator != null) {
            vibrator.vibrate(this$0.vibrationEffect);
        }
    }

    private final void vibratorInit() {
        if (this.vibrator == null) {
            HandlerThread handlerThread = new HandlerThread("Vibration thread", -19);
            handlerThread.start();
            this.vibratorHandler = new Handler(handlerThread.getLooper());
            Object systemService = this.context.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            this.vibrator = (Vibrator) systemService;
        }
    }

    public final void doVibrate(boolean hitFromLongClick) {
        vibratorInit();
        this.vibrationEffect = VibrationEffect.semCreateWaveform(HapticFeedbackConstants.semGetVibrationIndex(hitFromLongClick ? 1 : 41), -1, VibrationEffect.SemMagnitudeType.TYPE_TOUCH);
        Handler handler = this.vibratorHandler;
        if (handler != null) {
            handler.post(new RunnableC4617a(this, 10));
        }
    }

    public final boolean isVibrationOff() {
        return Settings.System.getInt(this.context.getContentResolver(), "haptic_feedback_enabled", 1) == 0;
    }
}
