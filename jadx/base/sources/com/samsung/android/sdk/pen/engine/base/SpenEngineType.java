package com.samsung.android.sdk.pen.engine.base;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/base/SpenEngineType;", "", "<init>", "()V", "TOOL_UNKNOWN", "", "TOOL_FINGER", "TOOL_SPEN", "TOOL_MOUSE", "TOOL_ERASER", "TOOL_MULTI_TOUCH", "TOOL_PEN_BUTTON", "ACTION_NONE", "ACTION_GESTURE", "ACTION_STROKE", "ACTION_HIGHLIGHTER", "ACTION_STRAIGHT_HIGHLIGHTER", "ACTION_MOSAIC_PEN", "ACTION_DIM_STROKE", "ACTION_ERASER", "ACTION_STROKE_REMOVER", "ACTION_COLOR_PICKER", "ACTION_SELECTION", "ACTION_TEXT", "ACTION_RECOGNITION", "ACTION_CHANGESTYLE", "ACTION_RECGONITION_PREVIEW", "ACTION_MATH", "ACTION_SPEN_TO_TEXT", "ACTION_FILL_COLOR", "ACTION_LASER_PEN", "ACTION_AUTO_CLEAN_UP", "ACTION_DOODLE_PEN", "PREDICTION_TYPE_NONE", "PREDICTION_TYPE_16", "PREDICTION_TYPE_20", "PREDICTION_TYPE_22", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenEngineType {
    public static final int ACTION_AUTO_CLEAN_UP = 19;
    public static final int ACTION_CHANGESTYLE = 13;
    public static final int ACTION_COLOR_PICKER = 9;
    public static final int ACTION_DIM_STROKE = 6;
    public static final int ACTION_DOODLE_PEN = 20;
    public static final int ACTION_ERASER = 7;
    public static final int ACTION_FILL_COLOR = 17;
    public static final int ACTION_GESTURE = 1;
    public static final int ACTION_HIGHLIGHTER = 3;
    public static final int ACTION_LASER_PEN = 18;
    public static final int ACTION_MATH = 15;
    public static final int ACTION_MOSAIC_PEN = 5;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_RECGONITION_PREVIEW = 14;
    public static final int ACTION_RECOGNITION = 12;
    public static final int ACTION_SELECTION = 10;
    public static final int ACTION_SPEN_TO_TEXT = 16;
    public static final int ACTION_STRAIGHT_HIGHLIGHTER = 4;
    public static final int ACTION_STROKE = 2;
    public static final int ACTION_STROKE_REMOVER = 8;
    public static final int ACTION_TEXT = 11;

    @NotNull
    public static final SpenEngineType INSTANCE = new SpenEngineType();
    public static final int PREDICTION_TYPE_16 = 1;
    public static final int PREDICTION_TYPE_20 = 2;
    public static final int PREDICTION_TYPE_22 = 3;
    public static final int PREDICTION_TYPE_NONE = 0;
    public static final int TOOL_ERASER = 4;
    public static final int TOOL_FINGER = 1;
    public static final int TOOL_MOUSE = 3;
    public static final int TOOL_MULTI_TOUCH = 5;
    public static final int TOOL_PEN_BUTTON = 6;
    public static final int TOOL_SPEN = 2;
    public static final int TOOL_UNKNOWN = 0;

    private SpenEngineType() {
    }
}
