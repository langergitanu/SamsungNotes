package androidx.compose.p109ui.graphics.layer;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/SurfaceUtils;", "", "()V", "hasRetrievedMethod", "", "lockHardwareCanvasMethod", "Ljava/lang/reflect/Method;", "isLockHardwareCanvasAvailable", "lockCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "lockCanvasFallback", "resolveLockHardwareCanvasMethod", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SurfaceUtils {

    @NotNull
    public static final SurfaceUtils INSTANCE = new SurfaceUtils();
    private static boolean hasRetrievedMethod;

    @Nullable
    private static Method lockHardwareCanvasMethod;

    private SurfaceUtils() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private final Canvas lockCanvasFallback(Surface surface) throws IllegalAccessException, InvocationTargetException {
        Method methodResolveLockHardwareCanvasMethod = resolveLockHardwareCanvasMethod();
        if (methodResolveLockHardwareCanvasMethod == null) {
            return surface.lockCanvas(null);
        }
        Object objInvoke = methodResolveLockHardwareCanvasMethod.invoke(surface, null);
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.graphics.Canvas");
        return (Canvas) objInvoke;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private final Method resolveLockHardwareCanvasMethod() {
        Method method;
        synchronized (this) {
            method = null;
            try {
                Method method2 = lockHardwareCanvasMethod;
                if (hasRetrievedMethod) {
                    method = method2;
                } else {
                    hasRetrievedMethod = true;
                    Method declaredMethod = Surface.class.getDeclaredMethod("lockHardwareCanvas", null);
                    declaredMethod.setAccessible(true);
                    lockHardwareCanvasMethod = declaredMethod;
                    method = declaredMethod;
                }
            } catch (Throwable unused) {
                lockHardwareCanvasMethod = null;
            }
        }
        return method;
    }

    public final boolean isLockHardwareCanvasAvailable() {
        return true;
    }

    @RequiresApi(22)
    @NotNull
    public final Canvas lockCanvas(@NotNull Surface surface) {
        return SurfaceVerificationHelper.INSTANCE.lockHardwareCanvas(surface);
    }
}
