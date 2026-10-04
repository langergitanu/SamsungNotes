package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/util/KeyboardUtils;", "", "<init>", "()V", "isExternalKeyboardConnected", "", "context", "Landroid/content/Context;", "isKeyboardDevice", "device", "Landroid/view/InputDevice;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class KeyboardUtils {

    @NotNull
    public static final KeyboardUtils INSTANCE = new KeyboardUtils();

    private KeyboardUtils() {
    }

    private final boolean isKeyboardDevice(InputDevice device) {
        return !device.isVirtual() && device.getKeyboardType() == 2 && (device.getSources() & 257) == 257;
    }

    public final boolean isExternalKeyboardConnected(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("input");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.input.InputManager");
        InputManager inputManager = (InputManager) systemService;
        for (int i : inputManager.getInputDeviceIds()) {
            InputDevice inputDevice = inputManager.getInputDevice(i);
            if (inputDevice != null && isKeyboardDevice(inputDevice)) {
                return true;
            }
        }
        return false;
    }
}
