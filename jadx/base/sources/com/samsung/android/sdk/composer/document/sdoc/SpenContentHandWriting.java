package com.samsung.android.sdk.composer.document.sdoc;

import android.graphics.Rect;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.smartswitchfileshare.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b,\u0018\u0000 q2\u00020\u0001:\u0002pqB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010B\u001a\u0004\u0018\u00010>2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005J\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020F2\u0006\u0010H\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013J\u0012\u0010I\u001a\u00020F2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010J\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u0005H\u0002J\u0011\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010P\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082 J\u0011\u0010Q\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010R\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0082 J\u0011\u0010S\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u001b\u0010T\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0082 J\u0011\u0010U\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010V\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0005H\u0082 J\u0011\u0010X\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0082 J#\u0010Y\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u0082 J-\u0010[\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0082 J!\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010]\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0082 J\u0011\u0010^\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010_\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0082 J\u0011\u0010`\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0082 J#\u0010a\u001a\u0004\u0018\u00010>2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0005H\u0082 J\u0011\u0010b\u001a\u00020>2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0011\u0010c\u001a\u00020+2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010d\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082 J\u0011\u0010e\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0082 J-\u0010f\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u001a\u00101\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u00010\u0012j\n\u0012\u0004\u0012\u000202\u0018\u0001`\u0014H\u0082 J!\u0010g\u001a\u0012\u0012\u0004\u0012\u0002020\u0012j\b\u0012\u0004\u0012\u000202`\u00142\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0011\u0010h\u001a\u00020+2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010i\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0082 J\u0011\u0010j\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0082 J#\u0010k\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0082 J\u0011\u0010l\u001a\u00020+2\u0006\u0010O\u001a\u00020\u0005H\u0082 J\u0019\u0010m\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0082 J\u0019\u0010n\u001a\u00020+2\u0006\u0010O\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0082 J\u0011\u0010o\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0082 R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rRL\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00142\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010!R$\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010\u0006R$\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b*\u0010,R$\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010!\"\u0004\b0\u0010\u0006RL\u00103\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u00010\u0012j\n\u0012\u0004\u0012\u000202\u0018\u0001`\u00142\u001a\u00101\u001a\u0016\u0012\u0004\u0012\u000202\u0018\u00010\u0012j\n\u0012\u0004\u0012\u000202\u0018\u0001`\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R$\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010!\"\u0004\b9\u0010\u0006R$\u0010:\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010!\"\u0004\b<\u0010\u0006R\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0011\u0010A\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\bA\u0010,¨\u0006r"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentHandWriting;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentBase;", "<init>", "()V", "canvasType", "", "(I)V", "rect", "Landroid/graphics/RectF;", "objectRect", "getObjectRect", "()Landroid/graphics/RectF;", "setObjectRect", "(Landroid/graphics/RectF;)V", "thumbnailRect", "getThumbnailRect", "setThumbnailRect", "pathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "thumbnailPathList", "getThumbnailPathList", "()Ljava/util/ArrayList;", "setThumbnailPathList", "(Ljava/util/ArrayList;)V", "path", "attachedFile", "getAttachedFile", "()Ljava/lang/String;", "setAttachedFile", "(Ljava/lang/String;)V", "getCanvasType", "()I", "pattern", "backgroundPattern", "getBackgroundPattern", "setBackgroundPattern", "color", "backgroundPatternColor", "getBackgroundPatternColor", "setBackgroundPatternColor", "isImageIncluded", "", "()Z", "count", "thumbnailCount", "getThumbnailCount", "setThumbnailCount", Constants.JTAG_DATA_LIST, "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentHandWriting$ActionLinkData;", "actionLinkData", "getActionLinkData", "setActionLinkData", "state", "actionLinkDataState", "getActionLinkDataState", "setActionLinkDataState", "backgroundColor", "getBackgroundColor", "setBackgroundColor", "noteDoc", "Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "getNoteDoc", "()Lcom/samsung/android/sdk/pen/document/SpenNoteDoc;", "isEmptyNoteDoc", "createNoteDoc", "width", "height", "deleteNoteDoc", "", "removeThumbnailPath", "index", "attachFile", "copy", "source", "throwUncheckedException", "errno", "ContentHandWriting_init", "handle", "ContentHandWriting_setObjectRect", "ContentHandWriting_getObjectRect", "ContentHandWriting_setThumbnailRect", "ContentHandWriting_getThumbnailRect", "ContentHandWriting_attachFile", "ContentHandWriting_getAttachedFile", "ContentHandWriting_init2", "type", "ContentHandWriting_getCanvasType", "ContentHandWriting_copy", "sourceHandle", "ContentHandWriting_setThumbnailPathList", "ContentHandWriting_getThumbnailPathList", "ContentHandWriting_setBackgroundPattern", "ContentHandWriting_getBackgroundPattern", "ContentHandWriting_setBackgroundPatternColor", "ContentHandWriting_getBackgroundPatternColor", "ContentHandWriting_createNoteDoc", "ContentHandWriting_getNoteDoc", "ContentHandWriting_deleteNoteDoc", "ContentHandWriting_setThumbnailCount", "ContentHandWriting_getThumbnailCount", "ContentHandWriting_setActionLinkData", "ContentHandWriting_getActionLinkData", "ContentHandWriting_isImageIncluded", "ContentHandWriting_setActionLinkDataState", "ContentHandWriting_getActionLinkDataState", "ContentHandWriting_setThumbnailPath", "ContentHandWriting_isEmptyNoteDoc", "ContentHandWriting_removeThumbnailPath", "ContentHandWriting_setBackgroundColor", "ContentHandWriting_getBackgroundColor", "ActionLinkData", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenContentHandWriting extends SpenContentBase {
    public static final int BACKGROUND_PATTERN_CHECK_DENSITY_1 = 11;
    public static final int BACKGROUND_PATTERN_CHECK_DENSITY_2 = 12;
    public static final int BACKGROUND_PATTERN_CHECK_DENSITY_3 = 13;
    public static final int BACKGROUND_PATTERN_CHECK_DENSITY_4 = 14;
    public static final int BACKGROUND_PATTERN_LINE_SPACING_1 = 1;
    public static final int BACKGROUND_PATTERN_LINE_SPACING_2 = 2;
    public static final int BACKGROUND_PATTERN_LINE_SPACING_3 = 3;
    public static final int BACKGROUND_PATTERN_LINE_SPACING_4 = 4;
    public static final int BACKGROUND_PATTERN_NONE = 0;
    public static final int CANVAS_TYPE_FINITE = 1;
    public static final int CANVAS_TYPE_INFINITE = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentHandWriting$ActionLinkData;", "", "<init>", "()V", "linkType", "", "pageWidth", "linkStr", "", "strokeRect", "Landroid/graphics/Rect;", "firstCharRect", "lastCharRect", "handleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "customData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ActionLinkData {
        public static final int ACTIONLINK_TYPE_EMAIL = 2;
        public static final int ACTIONLINK_TYPE_FORMULA = 3;
        public static final int ACTIONLINK_TYPE_PHONE = 0;
        public static final int ACTIONLINK_TYPE_URL = 1;

        @JvmField
        @Nullable
        public HashMap<Integer, String> customData;

        @JvmField
        @Nullable
        public Rect firstCharRect;

        @JvmField
        @Nullable
        public ArrayList<Integer> handleList;

        @JvmField
        @Nullable
        public Rect lastCharRect;

        @JvmField
        @Nullable
        public String linkStr;

        @JvmField
        public int linkType;

        @JvmField
        public int pageWidth;

        @JvmField
        @Nullable
        public Rect strokeRect;
    }

    public SpenContentHandWriting() {
        super(3);
    }

    private final native boolean ContentHandWriting_attachFile(int handle, String path);

    private final native boolean ContentHandWriting_copy(int handle, int sourceHandle, SpenContentBase source);

    private final native SpenNoteDoc ContentHandWriting_createNoteDoc(int handle, int width, int height);

    private final native boolean ContentHandWriting_deleteNoteDoc(int handle);

    private final native ArrayList<ActionLinkData> ContentHandWriting_getActionLinkData(int handle);

    private final native int ContentHandWriting_getActionLinkDataState(int handle);

    private final native String ContentHandWriting_getAttachedFile(int handle);

    private final native int ContentHandWriting_getBackgroundColor(int handle);

    private final native int ContentHandWriting_getBackgroundPattern(int handle);

    private final native int ContentHandWriting_getBackgroundPatternColor(int handle);

    private final native int ContentHandWriting_getCanvasType(int handle);

    private final native SpenNoteDoc ContentHandWriting_getNoteDoc(int handle);

    private final native RectF ContentHandWriting_getObjectRect(int handle);

    private final native int ContentHandWriting_getThumbnailCount(int handle);

    private final native ArrayList<String> ContentHandWriting_getThumbnailPathList(int handle);

    private final native RectF ContentHandWriting_getThumbnailRect(int handle);

    private final native boolean ContentHandWriting_init(int handle);

    private final native boolean ContentHandWriting_init2(int handle, int type);

    private final native boolean ContentHandWriting_isEmptyNoteDoc(int handle);

    private final native boolean ContentHandWriting_isImageIncluded(int handle);

    private final native boolean ContentHandWriting_removeThumbnailPath(int handle, int index);

    private final native boolean ContentHandWriting_setActionLinkData(int handle, ArrayList<ActionLinkData> dataList);

    private final native boolean ContentHandWriting_setActionLinkDataState(int handle, int state);

    private final native boolean ContentHandWriting_setBackgroundColor(int handle, int count);

    private final native boolean ContentHandWriting_setBackgroundPattern(int handle, int pattern);

    private final native boolean ContentHandWriting_setBackgroundPatternColor(int handle, int color);

    private final native boolean ContentHandWriting_setObjectRect(int handle, RectF rect);

    private final native boolean ContentHandWriting_setThumbnailCount(int handle, int count);

    private final native boolean ContentHandWriting_setThumbnailPath(int handle, int index, String path);

    private final native boolean ContentHandWriting_setThumbnailPathList(int handle, ArrayList<String> pathList);

    private final native boolean ContentHandWriting_setThumbnailRect(int handle, RectF rect);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenContentHandWriting(" + this + ") is already closed");
    }

    @Deprecated(message = "Please use [.attachedFile] instead.")
    public final void attachFile(@Nullable String path) {
        if (ContentHandWriting_attachFile(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.composer.document.sdoc.SpenContentBase
    public void copy(@Nullable SpenContentBase source) {
        if (source == null || source.getType() != 3) {
            SpenError.ThrowUncheckedException(7);
        }
        int mHandle = getMHandle();
        Intrinsics.checkNotNull(source);
        if (ContentHandWriting_copy(mHandle, source.getMHandle(), source)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SpenNoteDoc createNoteDoc(int width, int height) throws IOException {
        SpenNoteDoc spenNoteDocContentHandWriting_createNoteDoc = ContentHandWriting_createNoteDoc(getMHandle(), width, height);
        if (spenNoteDocContentHandWriting_createNoteDoc == null) {
            int error = SpenError.getError();
            if (error == 5) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            } else {
                if (error == 11) {
                    throw new IOException();
                }
                if (error == 19) {
                    throw new SpenAlreadyClosedException("SpenNoteDoc(" + this + ") is already closed.");
                }
                if (error == 7 || error == 8) {
                }
            }
        }
        return spenNoteDocContentHandWriting_createNoteDoc;
    }

    public final void deleteNoteDoc() {
        if (ContentHandWriting_deleteNoteDoc(getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Nullable
    public final ArrayList<ActionLinkData> getActionLinkData() {
        return ContentHandWriting_getActionLinkData(getMHandle());
    }

    public final int getActionLinkDataState() {
        return ContentHandWriting_getActionLinkDataState(getMHandle());
    }

    @Nullable
    public final String getAttachedFile() {
        return ContentHandWriting_getAttachedFile(getMHandle());
    }

    public final int getBackgroundColor() {
        return ContentHandWriting_getBackgroundColor(getMHandle());
    }

    public final int getBackgroundPattern() {
        return ContentHandWriting_getBackgroundPattern(getMHandle());
    }

    public final int getBackgroundPatternColor() {
        return ContentHandWriting_getBackgroundPatternColor(getMHandle());
    }

    public final int getCanvasType() {
        return ContentHandWriting_getCanvasType(getMHandle());
    }

    @NotNull
    public final SpenNoteDoc getNoteDoc() {
        return ContentHandWriting_getNoteDoc(getMHandle());
    }

    @NotNull
    public final RectF getObjectRect() {
        return ContentHandWriting_getObjectRect(getMHandle());
    }

    public final int getThumbnailCount() {
        return ContentHandWriting_getThumbnailCount(getMHandle());
    }

    @Nullable
    public final ArrayList<String> getThumbnailPathList() {
        return ContentHandWriting_getThumbnailPathList(getMHandle());
    }

    @NotNull
    public final RectF getThumbnailRect() {
        return ContentHandWriting_getThumbnailRect(getMHandle());
    }

    public final boolean isEmptyNoteDoc() {
        return ContentHandWriting_isEmptyNoteDoc(getMHandle());
    }

    public final boolean isImageIncluded() {
        return ContentHandWriting_isImageIncluded(getMHandle());
    }

    public final void removeThumbnailPath(int index) {
        if (ContentHandWriting_removeThumbnailPath(getMHandle(), index)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setActionLinkData(@Nullable ArrayList<ActionLinkData> arrayList) {
        if (ContentHandWriting_setActionLinkData(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setActionLinkDataState(int i) {
        if (ContentHandWriting_setActionLinkDataState(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAttachedFile(@Nullable String str) {
        if (ContentHandWriting_attachFile(getMHandle(), str)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundColor(int i) {
        if (ContentHandWriting_setBackgroundColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundPattern(int i) {
        if (ContentHandWriting_setBackgroundPattern(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setBackgroundPatternColor(int i) {
        if (ContentHandWriting_setBackgroundPatternColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setObjectRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ContentHandWriting_setObjectRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailCount(int i) {
        if (ContentHandWriting_setThumbnailCount(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPathList(@Nullable ArrayList<String> arrayList) {
        if (ContentHandWriting_setThumbnailPathList(getMHandle(), arrayList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ContentHandWriting_setThumbnailRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenContentHandWriting(int i) {
        super(3);
        if (ContentHandWriting_init2(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setThumbnailPathList(int index, @Nullable String path) {
        if (ContentHandWriting_setThumbnailPath(getMHandle(), index, path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
