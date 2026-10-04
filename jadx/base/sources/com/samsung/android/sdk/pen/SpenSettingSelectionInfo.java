package com.samsung.android.sdk.pen;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo;", "", "<init>", "()V", "type", "", "typeFilter", "includePartiallySelected", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingSelectionInfo {
    public static final int TYPE_CIRCLE = 2;
    public static final int TYPE_LASSO = 0;
    public static final int TYPE_MAGIC_WAND = 3;
    public static final int TYPE_OBJECT = 4;
    public static final int TYPE_RECT = 1;

    @JvmField
    public boolean includePartiallySelected;

    @JvmField
    public int type;

    @JvmField
    public int typeFilter = FIND_TYPE_ALL;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int FIND_TYPE_STROKE = 1;
    private static final int FIND_TYPE_TEXT_BOX = 2;
    private static final int FIND_TYPE_IMAGE = 4;
    private static final int FIND_TYPE_CONTAINER = 8;
    private static final int FIND_TYPE_STROKE_BOX = 16;
    private static final int FIND_TYPE_SHAPE_BASE = 32;
    private static final int FIND_TYPE_SHAPE = 64;
    private static final int FIND_TYPE_LINE = 128;
    private static final int FIND_TYPE_DUMMY_STROKE = 256;
    private static final int FIND_TYPE_VOICE = 512;
    private static final int FIND_TYPE_FORMULA = 1024;
    private static final int FIND_TYPE_TABLE = 2048;
    private static final int FIND_TYPE_WEB = 4096;
    private static final int FIND_TYPE_PAINTING = 8192;
    private static final int FIND_TYPE_STROKE_DEV_VERSION = 16384;
    private static final int FIND_TYPE_VIDEO = 32768;
    private static final int FIND_TYPE_LINK = 65536;
    private static final int FIND_TYPE_STROKE_BRUSH = 131072;
    private static final int FIND_TYPE_UNKNOWN = 262144;
    private static final int FIND_TYPE_PLOT = 524288;
    private static final int FIND_TYPE_MATH = 1048576;
    private static final int FIND_TYPE_ALL = 2097151;
    private static final int FIND_LAYER_BASE = 1;
    private static final int FIND_LAYER_TOP = 2;
    private static final int FIND_LAYER_ALL = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b8\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\fR\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\fR\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\fR\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\fR\u0011\u0010%\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\fR\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\fR\u0011\u0010)\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u0011\u0010+\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\fR\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\fR\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\fR\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\fR\u0011\u00103\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\fR\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\fR\u0011\u00107\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\fR\u0011\u00109\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\fR\u0011\u0010;\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\f¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingSelectionInfo$Companion;", "", "<init>", "()V", "TYPE_LASSO", "", "TYPE_RECT", "TYPE_CIRCLE", "TYPE_MAGIC_WAND", "TYPE_OBJECT", "FIND_TYPE_STROKE", "getFIND_TYPE_STROKE", "()I", "FIND_TYPE_TEXT_BOX", "getFIND_TYPE_TEXT_BOX", "FIND_TYPE_IMAGE", "getFIND_TYPE_IMAGE", "FIND_TYPE_CONTAINER", "getFIND_TYPE_CONTAINER", "FIND_TYPE_STROKE_BOX", "getFIND_TYPE_STROKE_BOX", "FIND_TYPE_SHAPE_BASE", "getFIND_TYPE_SHAPE_BASE", "FIND_TYPE_SHAPE", "getFIND_TYPE_SHAPE", "FIND_TYPE_LINE", "getFIND_TYPE_LINE", "FIND_TYPE_DUMMY_STROKE", "getFIND_TYPE_DUMMY_STROKE", "FIND_TYPE_VOICE", "getFIND_TYPE_VOICE", "FIND_TYPE_FORMULA", "getFIND_TYPE_FORMULA", "FIND_TYPE_TABLE", "getFIND_TYPE_TABLE", "FIND_TYPE_WEB", "getFIND_TYPE_WEB", "FIND_TYPE_PAINTING", "getFIND_TYPE_PAINTING", "FIND_TYPE_STROKE_DEV_VERSION", "getFIND_TYPE_STROKE_DEV_VERSION", "FIND_TYPE_VIDEO", "getFIND_TYPE_VIDEO", "FIND_TYPE_LINK", "getFIND_TYPE_LINK", "FIND_TYPE_STROKE_BRUSH", "getFIND_TYPE_STROKE_BRUSH", "FIND_TYPE_UNKNOWN", "getFIND_TYPE_UNKNOWN", "FIND_TYPE_PLOT", "getFIND_TYPE_PLOT", "FIND_TYPE_MATH", "getFIND_TYPE_MATH", "FIND_TYPE_ALL", "getFIND_TYPE_ALL", "FIND_LAYER_BASE", "getFIND_LAYER_BASE", "FIND_LAYER_TOP", "getFIND_LAYER_TOP", "FIND_LAYER_ALL", "getFIND_LAYER_ALL", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getFIND_LAYER_ALL() {
            return SpenSettingSelectionInfo.FIND_LAYER_ALL;
        }

        public final int getFIND_LAYER_BASE() {
            return SpenSettingSelectionInfo.FIND_LAYER_BASE;
        }

        public final int getFIND_LAYER_TOP() {
            return SpenSettingSelectionInfo.FIND_LAYER_TOP;
        }

        public final int getFIND_TYPE_ALL() {
            return SpenSettingSelectionInfo.FIND_TYPE_ALL;
        }

        public final int getFIND_TYPE_CONTAINER() {
            return SpenSettingSelectionInfo.FIND_TYPE_CONTAINER;
        }

        public final int getFIND_TYPE_DUMMY_STROKE() {
            return SpenSettingSelectionInfo.FIND_TYPE_DUMMY_STROKE;
        }

        public final int getFIND_TYPE_FORMULA() {
            return SpenSettingSelectionInfo.FIND_TYPE_FORMULA;
        }

        public final int getFIND_TYPE_IMAGE() {
            return SpenSettingSelectionInfo.FIND_TYPE_IMAGE;
        }

        public final int getFIND_TYPE_LINE() {
            return SpenSettingSelectionInfo.FIND_TYPE_LINE;
        }

        public final int getFIND_TYPE_LINK() {
            return SpenSettingSelectionInfo.FIND_TYPE_LINK;
        }

        public final int getFIND_TYPE_MATH() {
            return SpenSettingSelectionInfo.FIND_TYPE_MATH;
        }

        public final int getFIND_TYPE_PAINTING() {
            return SpenSettingSelectionInfo.FIND_TYPE_PAINTING;
        }

        public final int getFIND_TYPE_PLOT() {
            return SpenSettingSelectionInfo.FIND_TYPE_PLOT;
        }

        public final int getFIND_TYPE_SHAPE() {
            return SpenSettingSelectionInfo.FIND_TYPE_SHAPE;
        }

        public final int getFIND_TYPE_SHAPE_BASE() {
            return SpenSettingSelectionInfo.FIND_TYPE_SHAPE_BASE;
        }

        public final int getFIND_TYPE_STROKE() {
            return SpenSettingSelectionInfo.FIND_TYPE_STROKE;
        }

        public final int getFIND_TYPE_STROKE_BOX() {
            return SpenSettingSelectionInfo.FIND_TYPE_STROKE_BOX;
        }

        public final int getFIND_TYPE_STROKE_BRUSH() {
            return SpenSettingSelectionInfo.FIND_TYPE_STROKE_BRUSH;
        }

        public final int getFIND_TYPE_STROKE_DEV_VERSION() {
            return SpenSettingSelectionInfo.FIND_TYPE_STROKE_DEV_VERSION;
        }

        public final int getFIND_TYPE_TABLE() {
            return SpenSettingSelectionInfo.FIND_TYPE_TABLE;
        }

        public final int getFIND_TYPE_TEXT_BOX() {
            return SpenSettingSelectionInfo.FIND_TYPE_TEXT_BOX;
        }

        public final int getFIND_TYPE_UNKNOWN() {
            return SpenSettingSelectionInfo.FIND_TYPE_UNKNOWN;
        }

        public final int getFIND_TYPE_VIDEO() {
            return SpenSettingSelectionInfo.FIND_TYPE_VIDEO;
        }

        public final int getFIND_TYPE_VOICE() {
            return SpenSettingSelectionInfo.FIND_TYPE_VOICE;
        }

        public final int getFIND_TYPE_WEB() {
            return SpenSettingSelectionInfo.FIND_TYPE_WEB;
        }

        private Companion() {
        }
    }
}
