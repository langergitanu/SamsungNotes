package com.samsung.android.support.senl.addons.base.model.setting;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/ISPenOnlyModeHandler;", "", "isSPenSupport", "", "isSPenOnlyMode", "setSPenOnlyMode", "", "enable", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISPenOnlyModeHandler {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String SETTINGS_PREFS_NAME = "Settings";

    @NotNull
    public static final String SETTINGS_SPEN_ONLY_MODE = "settings_spen_only_mode";

    @NotNull
    public static final String SETTINGS_SPEN_SUPPORTED = "settings_spen_supported";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/ISPenOnlyModeHandler$Companion;", "", "<init>", "()V", "SETTINGS_PREFS_NAME", "", "SETTINGS_SPEN_ONLY_MODE", "SETTINGS_SPEN_SUPPORTED", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String SETTINGS_PREFS_NAME = "Settings";

        @NotNull
        public static final String SETTINGS_SPEN_ONLY_MODE = "settings_spen_only_mode";

        @NotNull
        public static final String SETTINGS_SPEN_SUPPORTED = "settings_spen_supported";

        private Companion() {
        }
    }

    boolean isSPenOnlyMode();

    boolean isSPenSupport();

    void setSPenOnlyMode(boolean enable);
}
