package com.samsung.android.support.senl.addons.base.model.color;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/color/IBaseColorModel;", "", "setColor", "", "color", "", "getColor", "getPosition", "setPosition", "position", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IBaseColorModel {
    public static final int COLOR_PICKER_MODE = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MODE_MASK = -1048576;
    public static final int MODE_SHIFT = 20;
    public static final int OBSV_BASECOLOR_MODEL_COLOR_CHANGED = 201;
    public static final int OBSV_BASECOLOR_MODEL_SELECTION_CHANGED = 202;
    public static final int OBSV_VM_COLOR_PICKER_COLOR_CHANGED = 203;
    public static final int PAGE_SHIFT = 8;
    public static final int PALETTE_INDEX_MASK = 255;
    public static final int PALETTE_MODE = 2;
    public static final int PALETTE_PAGE_MASK = 1048320;
    public static final int RECENT_COLOR_FROM_NOT_PALETTE = 2097151;
    public static final int RECENT_MODE = 1;
    public static final int UNKNOWN_MODE = -1048576;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/color/IBaseColorModel$Companion;", "", "<init>", "()V", "OBSV_BASECOLOR_MODEL_COLOR_CHANGED", "", "OBSV_BASECOLOR_MODEL_SELECTION_CHANGED", "OBSV_VM_COLOR_PICKER_COLOR_CHANGED", "MODE_SHIFT", "MODE_MASK", "UNKNOWN_MODE", "RECENT_COLOR_FROM_NOT_PALETTE", "RECENT_MODE", "PALETTE_MODE", "COLOR_PICKER_MODE", "PAGE_SHIFT", "PALETTE_PAGE_MASK", "PALETTE_INDEX_MASK", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int COLOR_PICKER_MODE = 4;
        public static final int MODE_MASK = -1048576;
        public static final int MODE_SHIFT = 20;
        public static final int OBSV_BASECOLOR_MODEL_COLOR_CHANGED = 201;
        public static final int OBSV_BASECOLOR_MODEL_SELECTION_CHANGED = 202;
        public static final int OBSV_VM_COLOR_PICKER_COLOR_CHANGED = 203;
        public static final int PAGE_SHIFT = 8;
        public static final int PALETTE_INDEX_MASK = 255;
        public static final int PALETTE_MODE = 2;
        public static final int PALETTE_PAGE_MASK = 1048320;
        public static final int RECENT_COLOR_FROM_NOT_PALETTE = 2097151;
        public static final int RECENT_MODE = 1;
        public static final int UNKNOWN_MODE = -1048576;

        private Companion() {
        }
    }

    int getColor();

    int getPosition();

    void setColor(int color);

    void setPosition(int position);
}
