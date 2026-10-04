package com.samsung.android.support.senl.addons.base.model.screen.rotation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationInfo;", "", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IRotationInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PIVOT_TYPE_BOTTOM = 2;
    public static final int PIVOT_TYPE_CENTER = 0;
    public static final int PIVOT_TYPE_LEFT = 4;
    public static final int PIVOT_TYPE_RIGHT = 8;
    public static final int PIVOT_TYPE_TOP = 1;
    public static final int ROTATE_ANIMATION_TYPE_SET_POSITION = 1;
    public static final int ROTATE_ANIMATION_TYPE_TRANSLATION = 0;
    public static final int ROTATION_DEGREE_0 = 0;
    public static final int ROTATION_DEGREE_180 = 180;
    public static final int ROTATION_DEGREE_270 = 270;
    public static final int ROTATION_DEGREE_90 = 90;
    public static final int ROTATION_DEGREE_UNDEFINED = -1;
    public static final int ROTATION_MARGIN_DEGREE = 40;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationInfo$Companion;", "", "<init>", "()V", "ROTATION_MARGIN_DEGREE", "", "PIVOT_TYPE_CENTER", "PIVOT_TYPE_TOP", "PIVOT_TYPE_BOTTOM", "PIVOT_TYPE_LEFT", "PIVOT_TYPE_RIGHT", "ROTATION_DEGREE_UNDEFINED", "ROTATION_DEGREE_0", "ROTATION_DEGREE_90", "ROTATION_DEGREE_180", "ROTATION_DEGREE_270", "ROTATE_ANIMATION_TYPE_TRANSLATION", "ROTATE_ANIMATION_TYPE_SET_POSITION", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PIVOT_TYPE_BOTTOM = 2;
        public static final int PIVOT_TYPE_CENTER = 0;
        public static final int PIVOT_TYPE_LEFT = 4;
        public static final int PIVOT_TYPE_RIGHT = 8;
        public static final int PIVOT_TYPE_TOP = 1;
        public static final int ROTATE_ANIMATION_TYPE_SET_POSITION = 1;
        public static final int ROTATE_ANIMATION_TYPE_TRANSLATION = 0;
        public static final int ROTATION_DEGREE_0 = 0;
        public static final int ROTATION_DEGREE_180 = 180;
        public static final int ROTATION_DEGREE_270 = 270;
        public static final int ROTATION_DEGREE_90 = 90;
        public static final int ROTATION_DEGREE_UNDEFINED = -1;
        public static final int ROTATION_MARGIN_DEGREE = 40;

        private Companion() {
        }
    }
}
