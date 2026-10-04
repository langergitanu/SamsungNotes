package com.samsung.android.sdk.pen.hwuicompat.util;

import android.graphics.Canvas;
import android.os.Build;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\n\u0010\r¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHwuiHandler;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "create", "Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHwuiHandler$SPenHwuiHandlerInterface;", "nativeDrawGLFunctor", "", "isHWUISupported", "", "isHWUISupported$annotations", "()Z", "SPenHwuiHandlerInterface", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwuiHandler {

    @NotNull
    public static final SpenHwuiHandler INSTANCE = new SpenHwuiHandler();

    @NotNull
    private static final String TAG = "SpenHwuiHandler";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/hwuicompat/util/SpenHwuiHandler$SPenHwuiHandlerInterface;", "", "setGLDrawCallback", "", "canvas", "Landroid/graphics/Canvas;", "invoke", "waitForCompleting", "close", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SPenHwuiHandlerInterface {
        void close();

        boolean invoke(boolean waitForCompleting);

        boolean setGLDrawCallback(@Nullable Canvas canvas);
    }

    private SpenHwuiHandler() {
    }

    @JvmStatic
    @NotNull
    public static final SPenHwuiHandlerInterface create(long nativeDrawGLFunctor) {
        int i = Build.VERSION.SDK_INT;
        AbstractC2322a.m1631u(i, "current Android SDK version: ", TAG);
        return i <= 28 ? new HwuiHandlerCompatApi21_28(nativeDrawGLFunctor) : new HwuiHandlerImpl(nativeDrawGLFunctor);
    }

    public static final boolean isHWUISupported() {
        return Build.VERSION.SDK_INT <= 28 ? HwuiHandlerCompatApi21_28.INSTANCE.isHWUISupported() : HwuiHandlerImpl.INSTANCE.isHWUISupported();
    }

    @JvmStatic
    public static /* synthetic */ void isHWUISupported$annotations() {
    }
}
