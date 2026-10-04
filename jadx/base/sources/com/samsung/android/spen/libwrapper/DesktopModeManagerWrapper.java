package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.DesktopModeManagerInterface;
import com.samsung.android.spen.libsdl.SdlDesktopModeManager;
import com.samsung.android.spen.libse.SeDesktopModeManager;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DesktopModeManagerWrapper {
    private DesktopModeManagerInterface instance;

    public DesktopModeManagerWrapper(DesktopModeManagerInterface desktopModeManagerInterface) throws PlatformException {
        try {
            this.instance = desktopModeManagerInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static DesktopModeManagerWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new DesktopModeManagerWrapper(new SeDesktopModeManager(context));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new DesktopModeManagerWrapper(new SdlDesktopModeManager(context));
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public boolean isDesktopMode() throws PlatformException {
        try {
            return this.instance.isDesktopMode();
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
