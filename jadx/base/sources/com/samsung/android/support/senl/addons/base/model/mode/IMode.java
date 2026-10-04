package com.samsung.android.support.senl.addons.base.model.mode;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/mode/IMode;", "Lcom/samsung/android/support/senl/addons/base/model/mode/ISpenOnlyMode;", "getPrevMode", "", "getCurrentMode", "setMode", "", "mode", "isMode", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IMode extends ISpenOnlyMode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MODE_CHANGESTYLE = 9;
    public static final int MODE_COLOR_PICKER = 5;
    public static final int MODE_ERASER = 4;
    public static final int MODE_NONE = 0;
    public static final int MODE_PEN = 2;
    public static final int MODE_RECOGNITION = 8;
    public static final int MODE_RECOGNITION_PREVIEW = 10;
    public static final int MODE_SELECTION = 6;
    public static final int MODE_TEXT = 11;
    public static final int OBSV_PROPERTY_MODE_CHANGED = 402;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/mode/IMode$Companion;", "", "<init>", "()V", "OBSV_PROPERTY_MODE_CHANGED", "", "MODE_NONE", "MODE_PEN", "MODE_ERASER", "MODE_SELECTION", "MODE_RECOGNITION", "MODE_CHANGESTYLE", "MODE_COLOR_PICKER", "MODE_RECOGNITION_PREVIEW", "MODE_TEXT", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MODE_CHANGESTYLE = 9;
        public static final int MODE_COLOR_PICKER = 5;
        public static final int MODE_ERASER = 4;
        public static final int MODE_NONE = 0;
        public static final int MODE_PEN = 2;
        public static final int MODE_RECOGNITION = 8;
        public static final int MODE_RECOGNITION_PREVIEW = 10;
        public static final int MODE_SELECTION = 6;
        public static final int MODE_TEXT = 11;
        public static final int OBSV_PROPERTY_MODE_CHANGED = 402;

        private Companion() {
        }
    }

    int getCurrentMode();

    int getPrevMode();

    boolean isMode(int mode);

    void setMode(int mode);
}
