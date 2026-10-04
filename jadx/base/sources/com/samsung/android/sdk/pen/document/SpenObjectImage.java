package com.samsung.android.sdk.pen.document;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bB\u0018\u0000 \u0093\u00012\u00020\u0001:\u0002\u0093\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0014\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\u001a\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010I2\u0006\u0010O\u001a\u00020\u0005H\u0016J\u0010\u0010P\u001a\u00020M2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020MH\u0016J\u0010\u0010\u0012\u001a\u00020M2\b\u0010T\u001a\u0004\u0018\u00010\u0015J\u001a\u0010\u0012\u001a\u00020M2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0012\u001a\u00020M2\u0006\u0010T\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ(\u0010U\u001a\u00020M2\u0006\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u00020&H\u0007J\u0010\u0010Z\u001a\u00020M2\b\u0010[\u001a\u0004\u0018\u00010\u0015J\u001c\u0010\\\u001a\u00020M2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010]\u001a\u00020M2\u0006\u0010^\u001a\u00020\bH\u0002J\u0019\u0010_\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010a\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010b\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\bH\u0082 J%\u0010c\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\b\u0010d\u001a\u0004\u0018\u00010\u000f2\b\u0010e\u001a\u0004\u0018\u00010\u000bH\u0082 J\u0013\u0010f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0013\u0010g\u001a\u0004\u0018\u00010\u00152\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010h\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u001b\u0010i\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0082 J\u0011\u0010j\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0019\u0010k\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0082 J\u0011\u0010l\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0019\u0010m\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0082 J\u0011\u0010n\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J1\u0010o\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u00020&H\u0082 J\u0011\u0010p\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010q\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010r\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010s\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0019\u0010t\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u00104\u001a\u00020\bH\u0082 J\u0011\u0010u\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0019\u0010v\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u0015H\u0082 J\u0013\u0010x\u001a\u0004\u0018\u00010\u00152\u0006\u0010`\u001a\u00020\bH\u0082 J\u0019\u0010y\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010z\u001a\u00020\u0005H\u0082 J\u0011\u0010{\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010|\u001a\u00020M2\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010}\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\bH\u0082 J\u0011\u0010~\u001a\u00020I2\u0006\u0010`\u001a\u00020\bH\u0082 J\"\u0010\u007f\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010Q\u001a\u00020R2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0082 J\n\u0010\u0081\u0001\u001a\u00020MH\u0082 J&\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0082 J'\u0010\u0083\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0082 J\u0012\u0010\u0085\u0001\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u001a\u0010\u0086\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u00108\u001a\u00020\u0005H\u0082 J\u0012\u0010\u0087\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\bH\u0082 J\u001a\u0010\u0088\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0082 J\u0012\u0010\u0089\u0001\u001a\u00020\b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u001b\u0010\u008a\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0007\u0010\u008b\u0001\u001a\u00020&H\u0082 J\u0012\u0010\u008c\u0001\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J\u001a\u0010\u008d\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\u0006\u0010<\u001a\u00020&H\u0082 J\u0012\u0010\u008e\u0001\u001a\u00020&2\u0006\u0010`\u001a\u00020\bH\u0082 J\u001c\u0010\u008f\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010\u000bH\u0082 J\u0012\u0010\u0090\u0001\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\bH\u0082 J\u001c\u0010\u0091\u0001\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010\u0015H\u0082 J\u0012\u0010\u0092\u0001\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\bH\u0082 R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00158G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR(\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\tR$\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020&8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b-\u0010)R\u0011\u0010.\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b/\u0010)R\u0011\u00100\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b1\u0010)R\u0011\u00102\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b3\u0010)R$\u00105\u001a\u00020\b2\u0006\u00104\u001a\u00020\b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u0010#\"\u0004\b7\u0010\tR$\u00108\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010\u0006R$\u0010=\u001a\u00020&2\u0006\u0010<\u001a\u00020&8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+R(\u0010@\u001a\u0004\u0018\u00010\u000b2\b\u0010@\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u001fR\u0011\u0010C\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bD\u0010\u0017R\u0013\u0010E\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\bF\u0010\u0011R\u0014\u0010G\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010:R\u0014\u0010H\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006\u0094\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectImage;", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "objectType", "", "(I)V", "ninePatchRect", "Landroid/graphics/Rect;", "getNinePatchRect", "()Landroid/graphics/Rect;", "image", "Landroid/graphics/Bitmap;", "getImage", "()Landroid/graphics/Bitmap;", "setImage", "(Landroid/graphics/Bitmap;)V", DBSchema.DocumentThumbnail.IMAGE_PATH, "", "getImagePath", "()Ljava/lang/String;", "imageBorderPath", "getImageBorderPath", "imageBorderNinePatchRect", "getImageBorderNinePatchRect", "cropRect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "color", "lineBorderColor", "getLineBorderColor", "()I", "setLineBorderColor", "width", "", "lineBorderWidth", "getLineBorderWidth", "()F", "setLineBorderWidth", "(F)V", "imageBorderLeftWidth", "getImageBorderLeftWidth", "imageBorderTopWidth", "getImageBorderTopWidth", "imageBorderRightWidth", "getImageBorderRightWidth", "imageBorderBottomWidth", "getImageBorderBottomWidth", "type", "borderType", "getBorderType", "setBorderType", "transparency", "getTransparency", "()Z", "setTransparency", TypedValues.Cycle.S_WAVE_OFFSET, "hintTextVerticalOffset", "getHintTextVerticalOffset", "setHintTextVerticalOffset", "originalRect", "getOriginalRect", "setOriginalRect", "originalImagePath", "getOriginalImagePath", "imageBorder", "getImageBorder", "isChanged", "drawnRect", "Landroid/graphics/RectF;", "getDrawnRect", "()Landroid/graphics/RectF;", "setRect", "", "rect", "regionOnly", "copy", "source", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "clearChangedFlag", "filePath", "setImageBorderWidth", "left", "top", "right", "bottom", "setOriginalImage", "path", "setImageBorder", "throwUncheckedException", "errno", "ObjectImage_init", "handle", "ObjectImage_getImage", "ObjectImage_getImagePath", "ObjectImage_setImageBorder", "bitmap", "ninePatch", "ObjectImage_getImageBorder", "ObjectImage_getImageBorderPath", "ObjectImage_getImageBorderNinePatchRect", "ObjectImage_setCropRect", "ObjectImage_getCropRect", "ObjectImage_setLineBorderColor", "ObjectImage_getLineBorderColor", "ObjectImage_setLineBorderWidth", "ObjectImage_getLineBorderWidth", "ObjectImage_setImageBorderWidth", "ObjectImage_getImageBorderLeftWidth", "ObjectImage_getImageBorderTopWidth", "ObjectImage_getImageBorderRightWidth", "ObjectImage_getImageBorderBottomWidth", "ObjectImage_setBorderType", "ObjectImage_getBorderType", "ObjectImage_setHintText", "hintText", "ObjectImage_getHintText", "ObjectImage_setHintTextVisibility", "visible", "ObjectImage_isHintTextVisiable", "ObjectImage_clearChangedFlag", "ObjectImage_isChanged", "ObjectImage_getDrawnRect", "ObjectImage_copy", "sourceHandle", "Bitmap_saveImageTest", "ObjectImage_setImage", "ObjectImage_setImage2", "srcUri", "ObjectImage_getNinePatchRect", "ObjectImage_setTransparency", "ObjectImage_getTransparency", "ObjectImage_setHintTextColor", "ObjectImage_getHintTextColor", "ObjectImage_setHintTextFontSize", "size", "ObjectImage_getHintTextFontSize", "ObjectImage_setHintTextVerticalOffset", "ObjectImage_getHintTextVerticalOffset", "ObjectImage_setOriginalRect", "ObjectImage_getOriginalRect", "ObjectImage_setOriginalImage", "ObjectImage_getOriginalImagePath", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectImage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectImage.kt\ncom/samsung/android/sdk/pen/document/SpenObjectImage\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,738:1\n1#2:739\n*E\n"})
public final class SpenObjectImage extends SpenObjectShape {

    @JvmField
    public static final int BORDER_TYPE_NONE = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static final int BORDER_TYPE_SQUARE = 1;

    @JvmField
    public static final int BORDER_TYPE_SHADOW = 2;
    private static final int BORDER_TYPE_DOT = 3;
    private static final int BORDER_TYPE_IMAGE = 4;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectImage$Companion;", "", "<init>", "()V", "BORDER_TYPE_NONE", "", "getBORDER_TYPE_NONE$annotations", "BORDER_TYPE_SQUARE", "getBORDER_TYPE_SQUARE$annotations", "BORDER_TYPE_SHADOW", "getBORDER_TYPE_SHADOW$annotations", "BORDER_TYPE_DOT", "getBORDER_TYPE_DOT$annotations", "getBORDER_TYPE_DOT", "()I", "BORDER_TYPE_IMAGE", "getBORDER_TYPE_IMAGE$annotations", "getBORDER_TYPE_IMAGE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getBORDER_TYPE_DOT$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, do not support.")
        public static /* synthetic */ void getBORDER_TYPE_IMAGE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getBORDER_TYPE_NONE$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, do not support..")
        public static /* synthetic */ void getBORDER_TYPE_SHADOW$annotations() {
        }

        @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
        public static /* synthetic */ void getBORDER_TYPE_SQUARE$annotations() {
        }

        public final int getBORDER_TYPE_DOT() {
            return SpenObjectImage.BORDER_TYPE_DOT;
        }

        public final int getBORDER_TYPE_IMAGE() {
            return SpenObjectImage.BORDER_TYPE_IMAGE;
        }

        private Companion() {
        }
    }

    public SpenObjectImage() {
        super(3, 0);
    }

    private final native void Bitmap_saveImageTest();

    private final native void ObjectImage_clearChangedFlag(int handle);

    private final native boolean ObjectImage_copy(int handle, SpenObjectBase source, int sourceHandle);

    private final native int ObjectImage_getBorderType(int handle);

    private final native Rect ObjectImage_getCropRect(int handle);

    private final native RectF ObjectImage_getDrawnRect(int handle);

    private final native String ObjectImage_getHintText(int handle);

    private final native int ObjectImage_getHintTextColor(int handle);

    private final native float ObjectImage_getHintTextFontSize(int handle);

    private final native float ObjectImage_getHintTextVerticalOffset(int handle);

    private final native Bitmap ObjectImage_getImage(int handle);

    private final native Bitmap ObjectImage_getImageBorder(int handle);

    private final native float ObjectImage_getImageBorderBottomWidth(int handle);

    private final native float ObjectImage_getImageBorderLeftWidth(int handle);

    private final native Rect ObjectImage_getImageBorderNinePatchRect(int handle);

    private final native String ObjectImage_getImageBorderPath(int handle);

    private final native float ObjectImage_getImageBorderRightWidth(int handle);

    private final native float ObjectImage_getImageBorderTopWidth(int handle);

    private final native String ObjectImage_getImagePath(int handle);

    private final native int ObjectImage_getLineBorderColor(int handle);

    private final native float ObjectImage_getLineBorderWidth(int handle);

    private final native Rect ObjectImage_getNinePatchRect(int handle);

    private final native String ObjectImage_getOriginalImagePath(int handle);

    private final native Rect ObjectImage_getOriginalRect(int handle);

    private final native boolean ObjectImage_getTransparency(int handle);

    private final native boolean ObjectImage_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectImage_isChanged(int handle);

    private final native boolean ObjectImage_isHintTextVisiable(int handle);

    private final native boolean ObjectImage_setBorderType(int handle, int type);

    private final native boolean ObjectImage_setCropRect(int handle, Rect cropRect);

    private final native boolean ObjectImage_setHintText(int handle, String hintText);

    private final native boolean ObjectImage_setHintTextColor(int handle, int color);

    private final native boolean ObjectImage_setHintTextFontSize(int handle, float size);

    private final native boolean ObjectImage_setHintTextVerticalOffset(int handle, float offset);

    private final native boolean ObjectImage_setHintTextVisibility(int handle, boolean visible);

    private final native boolean ObjectImage_setImage(int handle, Bitmap image, Rect ninePatchRect);

    private final native boolean ObjectImage_setImage2(int handle, String srcUri, Rect ninePatchRect);

    private final native boolean ObjectImage_setImageBorder(int handle, Bitmap bitmap, Rect ninePatch);

    private final native boolean ObjectImage_setImageBorderWidth(int handle, float left, float top, float right, float bottom);

    private final native boolean ObjectImage_setLineBorderColor(int handle, int color);

    private final native boolean ObjectImage_setLineBorderWidth(int handle, float width);

    private final native boolean ObjectImage_setOriginalImage(int handle, String path);

    private final native boolean ObjectImage_setOriginalRect(int handle, Rect originalRect);

    private final native boolean ObjectImage_setTransparency(int handle, boolean transparency);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectImage(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void clearChangedFlag() {
        ObjectImage_clearChangedFlag(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectShapeBase, com.samsung.android.sdk.pen.document.SpenObjectBase
    public void copy(@NotNull SpenObjectBase source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (ObjectImage_copy(getMHandle(), source, source.getMHandle())) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect} without an image boarder.")
    public final int getBorderType() {
        return ObjectImage_getBorderType(getMHandle());
    }

    @Nullable
    public final Rect getCropRect() {
        return ObjectImage_getCropRect(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    @NotNull
    public RectF getDrawnRect() {
        return ObjectImage_getDrawnRect(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final float getHintTextVerticalOffset() {
        return ObjectImage_getHintTextVerticalOffset(getMHandle());
    }

    @Nullable
    public final Bitmap getImage() {
        return ObjectImage_getImage(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    @Nullable
    public final Bitmap getImageBorder() {
        String strObjectImage_getImageBorderPath = ObjectImage_getImageBorderPath(getMHandle());
        if (strObjectImage_getImageBorderPath == null) {
            return null;
        }
        return BitmapFactory.decodeFile(strObjectImage_getImageBorderPath);
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final float getImageBorderBottomWidth() {
        return ObjectImage_getImageBorderBottomWidth(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final float getImageBorderLeftWidth() {
        return ObjectImage_getImageBorderLeftWidth(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    @NotNull
    public final Rect getImageBorderNinePatchRect() {
        return ObjectImage_getImageBorderNinePatchRect(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    @Nullable
    public final String getImageBorderPath() {
        return ObjectImage_getImageBorderPath(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final float getImageBorderRightWidth() {
        return ObjectImage_getImageBorderRightWidth(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final float getImageBorderTopWidth() {
        return ObjectImage_getImageBorderTopWidth(getMHandle());
    }

    @NotNull
    public final String getImagePath() {
        return ObjectImage_getImagePath(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect SpenLineColorEffect}.")
    public final int getLineBorderColor() {
        return ObjectImage_getLineBorderColor(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
    public final float getLineBorderWidth() {
        return ObjectImage_getLineBorderWidth(getMHandle());
    }

    @NotNull
    public final Rect getNinePatchRect() {
        return ObjectImage_getNinePatchRect(getMHandle());
    }

    @NotNull
    public final String getOriginalImagePath() {
        return ObjectImage_getOriginalImagePath(getMHandle());
    }

    @Nullable
    public final Rect getOriginalRect() {
        return ObjectImage_getOriginalRect(getMHandle());
    }

    public final boolean getTransparency() {
        return ObjectImage_getTransparency(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public boolean isChanged() {
        return ObjectImage_isChanged(getMHandle());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect} without an image boarder.")
    public final void setBorderType(int i) {
        if (ObjectImage_setBorderType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setCropRect(@Nullable Rect rect) {
        if (ObjectImage_setCropRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final void setHintTextVerticalOffset(float f) {
        if (ObjectImage_setHintTextVerticalOffset(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImage(@Nullable Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectImage_setImage(getMHandle(), bitmap, null)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final void setImageBorder(@Nullable Bitmap image, @Nullable Rect ninePatchRect) {
        if (image != null && image.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectImage_setImageBorder(getMHandle(), image, ninePatchRect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, do not support.")
    public final void setImageBorderWidth(float left, float top, float right, float bottom) {
        if (ObjectImage_setImageBorderWidth(getMHandle(), left, top, right, bottom)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect SpenLineColorEffect}.")
    public final void setLineBorderColor(int i) {
        if (ObjectImage_setLineBorderColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Deprecated(message = "As of 4.0.0, replaced by {@link com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect SpenLineStyleEffect}.")
    public final void setLineBorderWidth(float f) {
        if (ObjectImage_setLineBorderWidth(getMHandle(), f)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setOriginalImage(@Nullable String path) {
        if (ObjectImage_setOriginalImage(getMHandle(), path)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setOriginalRect(@Nullable Rect rect) {
        if (ObjectImage_setOriginalRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.document.SpenObjectBase
    public void setRect(@Nullable RectF rect, boolean regionOnly) {
        super.setRect(rect, regionOnly);
    }

    public final void setTransparency(boolean z) {
        if (ObjectImage_setTransparency(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectImage(boolean z) {
        super(3, 0);
        if (ObjectImage_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImage(@Nullable String filePath) {
        if (ObjectImage_setImage2(getMHandle(), filePath, null)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public SpenObjectImage(int i) {
        super(i, 0);
    }

    public final void setImage(@Nullable Bitmap image, @Nullable Rect ninePatchRect) {
        if (image != null && image.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectImage_setImage(getMHandle(), image, ninePatchRect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImage(@NotNull String filePath, @Nullable Rect ninePatchRect) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (ObjectImage_setImage2(getMHandle(), filePath, ninePatchRect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
