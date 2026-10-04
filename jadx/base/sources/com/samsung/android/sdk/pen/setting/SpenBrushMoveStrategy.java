package com.samsung.android.sdk.pen.setting;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b`\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J \u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveStrategy;", "", "moveView", "", "guideView", "Landroid/view/View;", "target", "align", "direction", "getPenDegree", "", "orientation", "getSelectorDegree", "getColorFlip", "setRotateDegree", "", "degree", "getRotateDegree", "setColorInfo", "getColorFlipDir", "getColorFlipDegree", "getSelectorFlipDir", "getSelectorFlipDegree", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenBrushMoveStrategy {
    public static final int ALIGN_END = 1;
    public static final int ALIGN_START = 2;
    public static final int ALIGN_TOP = 3;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FLIP_DIR_LEFT_RIGHT = -1;
    public static final int FLIP_DIR_NONE = 0;
    public static final int FLIP_DIR_UP_DOWN = 1;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveStrategy$Companion;", "", "<init>", "()V", "ALIGN_TOP", "", "ALIGN_START", "ALIGN_END", "ORIENTATION_PORTRAIT", "ORIENTATION_LANDSCAPE", "FLIP_DIR_NONE", "FLIP_DIR_UP_DOWN", "FLIP_DIR_LEFT_RIGHT", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ALIGN_END = 1;
        public static final int ALIGN_START = 2;
        public static final int ALIGN_TOP = 3;
        public static final int FLIP_DIR_LEFT_RIGHT = -1;
        public static final int FLIP_DIR_NONE = 0;
        public static final int FLIP_DIR_UP_DOWN = 1;
        public static final int ORIENTATION_LANDSCAPE = 2;
        public static final int ORIENTATION_PORTRAIT = 1;

        private Companion() {
        }
    }

    int getColorFlip(int align, int direction);

    int getColorFlipDegree();

    int getColorFlipDir();

    float getPenDegree(int orientation, int align, int direction);

    int getRotateDegree();

    float getSelectorDegree(int orientation, int align, int direction);

    int getSelectorFlipDegree();

    int getSelectorFlipDir();

    int moveView(@NotNull View guideView, @NotNull View target, int align, int direction);

    void setColorInfo(int orientation, int align, int direction);

    void setRotateDegree(int degree);
}
