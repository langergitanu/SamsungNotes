package com.samsung.android.sdk.pen.plugin.interfaces;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\bf\u0018\u0000 A2\u00020\u0001:\u0001AJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH&JC\u00104\u001a\u00020\u00072\f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020/H&¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u001cH&R\u001a\u0010\t\u001a\u0004\u0018\u00010\nX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u00020\u0012X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0012\u0010\u0019\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u001b\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u0018\u0010$\u001a\u00020%X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010&\"\u0004\b'\u0010(R\u0018\u0010)\u001a\u00020%X¦\u000e¢\u0006\f\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u0018\u0010.\u001a\u00020/X¦\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenPenInterface;", "", "draw", "", "event", "Landroid/view/MotionEvent;", "rect", "Landroid/graphics/RectF;", "redrawPen", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "setReferenceBitmap", "setDepthMapBitmap", "size", "", "getSize", "()F", "setSize", "(F)V", "minSettingValue", "getMinSettingValue", "maxSettingValue", "getMaxSettingValue", "color", "", "getColor", "()I", "setColor", "(I)V", "particleDensity", "getParticleDensity", "setParticleDensity", "isCurveEnabled", "", "()Z", "setCurveEnabled", "(Z)V", "isEraserEnabled", "setEraserEnabled", "setScreenResolution", "width", "height", "advancedSetting", "", "getAdvancedSetting", "()Ljava/lang/String;", "setAdvancedSetting", "(Ljava/lang/String;)V", "getStrokeRect", "points", "", "Landroid/graphics/PointF;", "pressures", "", "timestamps", "", "isCurvable", "advanced", "([Landroid/graphics/PointF;[F[IFZLjava/lang/String;)Landroid/graphics/RectF;", "getPenAttribute", "attribute", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenPenInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PEN_ATTRIBUTE_ADVANCED_SETTING = 4;
    public static final int PEN_ATTRIBUTE_ALPHA = 1;
    public static final int PEN_ATTRIBUTE_COLOR = 2;
    public static final int PEN_ATTRIBUTE_CURVE = 3;
    public static final int PEN_ATTRIBUTE_FIXED_ALPHA = 9;
    public static final int PEN_ATTRIBUTE_FIXED_WIDTH = 8;
    public static final int PEN_ATTRIBUTE_PARTICLE_DENSITY = 5;
    public static final int PEN_ATTRIBUTE_PARTICLE_SIZE = 6;
    public static final int PEN_ATTRIBUTE_SECONDARY_COLOR = 7;
    public static final int PEN_ATTRIBUTE_SIZE = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenPenInterface$Companion;", "", "<init>", "()V", "PEN_ATTRIBUTE_SIZE", "", "PEN_ATTRIBUTE_ALPHA", "PEN_ATTRIBUTE_COLOR", "PEN_ATTRIBUTE_CURVE", "PEN_ATTRIBUTE_ADVANCED_SETTING", "PEN_ATTRIBUTE_PARTICLE_DENSITY", "PEN_ATTRIBUTE_PARTICLE_SIZE", "PEN_ATTRIBUTE_SECONDARY_COLOR", "PEN_ATTRIBUTE_FIXED_WIDTH", "PEN_ATTRIBUTE_FIXED_ALPHA", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PEN_ATTRIBUTE_ADVANCED_SETTING = 4;
        public static final int PEN_ATTRIBUTE_ALPHA = 1;
        public static final int PEN_ATTRIBUTE_COLOR = 2;
        public static final int PEN_ATTRIBUTE_CURVE = 3;
        public static final int PEN_ATTRIBUTE_FIXED_ALPHA = 9;
        public static final int PEN_ATTRIBUTE_FIXED_WIDTH = 8;
        public static final int PEN_ATTRIBUTE_PARTICLE_DENSITY = 5;
        public static final int PEN_ATTRIBUTE_PARTICLE_SIZE = 6;
        public static final int PEN_ATTRIBUTE_SECONDARY_COLOR = 7;
        public static final int PEN_ATTRIBUTE_SIZE = 0;

        private Companion() {
        }
    }

    void draw(@NotNull MotionEvent event, @NotNull RectF rect);

    @NotNull
    String getAdvancedSetting();

    @Nullable
    Bitmap getBitmap();

    int getColor();

    float getMaxSettingValue();

    float getMinSettingValue();

    int getParticleDensity();

    boolean getPenAttribute(int attribute);

    float getSize();

    @NotNull
    RectF getStrokeRect(@NotNull PointF[] points, @NotNull float[] pressures, @NotNull int[] timestamps, float size, boolean isCurvable, @NotNull String advanced);

    boolean isCurveEnabled();

    boolean isEraserEnabled();

    void redrawPen(@NotNull MotionEvent event, @NotNull RectF rect);

    void setAdvancedSetting(@NotNull String str);

    void setBitmap(@Nullable Bitmap bitmap);

    void setColor(int i);

    void setCurveEnabled(boolean z);

    void setDepthMapBitmap(@NotNull Bitmap bitmap);

    void setEraserEnabled(boolean z);

    void setParticleDensity(int i);

    void setReferenceBitmap(@NotNull Bitmap bitmap);

    void setScreenResolution(int width, int height);

    void setSize(float f);
}
