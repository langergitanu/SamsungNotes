package com.samsung.android.spen.libwrapper;

import android.content.ContentResolver;
import android.content.Context;
import com.samsung.android.spen.libinterface.SettingsSystemInterface;
import com.samsung.android.spen.libsdl.SdlSettingsSystem;
import com.samsung.android.spen.libse.SeSettingsSystem;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SettingsSystemWrapper {
    public static final String PEN_HOVERING;
    public static final String PEN_HOVERING_INFORMATION_PREVIEW;
    public static final String PEN_HOVERING_LINK_PREVIEW = "pen_hovering_link_preview";
    public static final int USER_CURRENT_OR_SELF = -3;
    public static final int USER_OWNER;
    private SettingsSystemInterface instance;

    static {
        if (PlatformUtils.isSemDevice()) {
            PEN_HOVERING_INFORMATION_PREVIEW = "pen_hovering_information_preview";
            PEN_HOVERING = "pen_hovering";
            USER_OWNER = 0;
        } else {
            PEN_HOVERING_INFORMATION_PREVIEW = "pen_hovering_information_preview";
            PEN_HOVERING = "pen_hovering";
            USER_OWNER = 0;
        }
    }

    private SettingsSystemWrapper(SettingsSystemInterface settingsSystemInterface) throws PlatformException {
        try {
            this.instance = settingsSystemInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static SettingsSystemWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new SettingsSystemWrapper(new SeSettingsSystem());
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new SettingsSystemWrapper(new SdlSettingsSystem());
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public int getIntForUser(ContentResolver contentResolver, String str, int i, int i2) throws PlatformException {
        try {
            return this.instance.getIntForUser(contentResolver, str, i, i2);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
