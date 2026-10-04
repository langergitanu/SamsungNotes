package com.samsung.android.sdk.pen.document;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b1\u0018\u0000 ~2\u00020\u0001:\u0001~B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u001a\u0010\u001f\u001a\u00020N2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010(J\u0018\u0010\u001f\u001a\u00020N2\u0006\u0010O\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u000207J\u000e\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u000207J\u001e\u0010P\u001a\u00020\u00052\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u0002070\bj\b\u0012\u0004\u0012\u000207`\nJ\u001e\u0010R\u001a\u00020\u00052\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u0002070\bj\b\u0012\u0004\u0012\u000207`\nJ\u0010\u0010T\u001a\u0004\u0018\u0001072\u0006\u0010U\u001a\u000200J&\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00002\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u0002070\bj\b\u0012\u0004\u0012\u000207`\nJ\u0010\u0010X\u001a\u00020N2\u0006\u0010Y\u001a\u000200H\u0002J\u0019\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J)\u0010\\\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0082 J!\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010[\u001a\u000200H\u0082 J!\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010[\u001a\u000200H\u0082 J)\u0010_\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0082 J\u0019\u0010`\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\u0014H\u0082 J\u0011\u0010a\u001a\u00020\u00142\u0006\u0010[\u001a\u000200H\u0082 J%\u0010b\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0082 J#\u0010c\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010O\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0082 J\u0011\u0010d\u001a\u00020\u001b2\u0006\u0010[\u001a\u000200H\u0082 J\u0011\u0010e\u001a\u00020\t2\u0006\u0010[\u001a\u000200H\u0082 J\u0011\u0010f\u001a\u00020(2\u0006\u0010[\u001a\u000200H\u0082 J)\u0010g\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0082 J!\u0010h\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010[\u001a\u000200H\u0082 J\u0019\u0010i\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010/\u001a\u000200H\u0082 J\u0011\u0010j\u001a\u0002002\u0006\u0010[\u001a\u000200H\u0082 J-\u0010k\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\nH\u0082 J%\u0010l\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\n2\u0006\u0010[\u001a\u000200H\u0082 J-\u0010m\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\nH\u0082 J%\u0010n\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\n2\u0006\u0010[\u001a\u000200H\u0082 J\u0019\u0010o\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010Q\u001a\u000207H\u0082 J\u0019\u0010p\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010Q\u001a\u000207H\u0082 J)\u0010q\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u0002070\bj\b\u0012\u0004\u0012\u000207`\nH\u0082 J)\u0010r\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u0002070\bj\b\u0012\u0004\u0012\u000207`\nH\u0082 J\u001b\u0010s\u001a\u0004\u0018\u0001072\u0006\u0010[\u001a\u0002002\u0006\u0010U\u001a\u000200H\u0082 J\u0011\u0010t\u001a\u0002002\u0006\u0010[\u001a\u000200H\u0082 J\u0019\u0010u\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010D\u001a\u000200H\u0082 J\u0011\u0010v\u001a\u0002002\u0006\u0010[\u001a\u000200H\u0082 J\u0019\u0010w\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010@\u001a\u00020\tH\u0082 J\u0011\u0010x\u001a\u00020\t2\u0006\u0010[\u001a\u000200H\u0082 J\u0019\u0010y\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010H\u001a\u00020\u0005H\u0082 J\u0011\u0010z\u001a\u00020\u00052\u0006\u0010[\u001a\u000200H\u0082 J1\u0010{\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010W\u001a\u00020\u00002\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u0002070\bj\b\u0012\u0004\u0012\u000207`\nH\u0082 J\u0019\u0010|\u001a\u00020\u00052\u0006\u0010[\u001a\u0002002\u0006\u0010K\u001a\u00020\u0005H\u0082 J\u0011\u0010}\u001a\u00020\u00052\u0006\u0010[\u001a\u000200H\u0082 RD\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRD\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*RD\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR$\u00101\u001a\u0002002\u0006\u0010/\u001a\u0002008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105RL\u00108\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\n2\u001a\u00106\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fRL\u0010;\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\n2\u001a\u00106\u001a\u0016\u0012\u0004\u0012\u000207\u0018\u00010\bj\n\u0012\u0004\u0012\u000207\u0018\u0001`\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\u0011\u0010>\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b?\u00103R$\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R$\u0010E\u001a\u0002002\u0006\u0010D\u001a\u0002008G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bF\u00103\"\u0004\bG\u00105R$\u0010H\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010\u0006R$\u0010K\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010I\"\u0004\bM\u0010\u0006¨\u0006\u007f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/document/SpenObjectFormula;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "isTemplateObject", "", "(Z)V", "latexList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", HtmlConstants.LATEX, "getLatex", "()Ljava/util/ArrayList;", "setLatex", "(Ljava/util/ArrayList;)V", "substitutionLatex", "getSubstitutionLatex", "setSubstitutionLatex", "rect", "Landroid/graphics/RectF;", "latexResultRect", "getLatexResultRect", "()Landroid/graphics/RectF;", "setLatexResultRect", "(Landroid/graphics/RectF;)V", "bitmap", "Landroid/graphics/Bitmap;", "image", "getImage", "()Landroid/graphics/Bitmap;", "setImage", "(Landroid/graphics/Bitmap;)V", "path", DBSchema.DocumentThumbnail.IMAGE_PATH, "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "ninePatchRect", "Landroid/graphics/Rect;", "getNinePatchRect", "()Landroid/graphics/Rect;", "latexResultList", "latexResult", "getLatexResult", "setLatexResult", "type", "", "angleType", "getAngleType", "()I", "setAngleType", "(I)V", XmlErrorCodes.LIST, "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "strokeList", "getStrokeList", "setStrokeList", "answerStrokeList", "getAnswerStrokeList", "setAnswerStrokeList", "strokeCount", "getStrokeCount", "answer", "answerString", "getAnswerString", "setAnswerString", "color", "answerStrokeColor", "getAnswerStrokeColor", "setAnswerStrokeColor", "isPlottable", "()Z", "setPlottable", "hasTrigonometryCalculation", "getHasTrigonometryCalculation", "setHasTrigonometryCalculation", "", "filePath", "appendStroke", "stroke", "removeStroke", "objectList", "getStroke", "index", "transferObjects", "srcFormula", "throwUncheckedException", "errno", "ObjectFormula_init", "handle", "ObjectFormula_setLatex", "ObjectFormula_getLatex", "ObjectFormula_getSubstitutionLatex", "ObjectFormula_setSubstitutionLatex", "ObjectFormula_setLatexResultRect", "ObjectFormula_getLatexResultRect", "ObjectFormula_setImageBitmap", "ObjectFormula_setImagePath", "ObjectFormula_getImageBitmap", "ObjectFormula_getImagePath", "ObjectFormula_getNinePatchRect", "ObjectFormula_setLatexResult", "ObjectFormula_getLatexResult", "ObjectFormula_setAngleType", "ObjectFormula_getAngleType", "ObjectFormula_setStrokeList", "ObjectFormula_getStrokeList", "ObjectFormula_setAnswerStrokeList", "ObjectFormula_getAnswerStrokeList", "ObjectFormula_appendStroke", "ObjectFormula_removeStroke", "ObjectFormula_appendObjectList", "ObjectFormula_removeObjectList", "ObjectFormula_getStroke", "ObjectFormula_getStrokeCount", "ObjectFormula_setAnswerStrokeColor", "ObjectFormula_getAnswerStrokeColor", "ObjectFormula_setAnswerString", "ObjectFormula_getAnswerString", "ObjectFormula_setPlottable", "ObjectFormula_isPlottable", "ObjectFormula_transferObjects", "ObjectFormula_setHasTrigonometryCalculation", "ObjectFormula_hasTrigonometryCalculation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenObjectFormula.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenObjectFormula.kt\ncom/samsung/android/sdk/pen/document/SpenObjectFormula\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,625:1\n1#2:626\n*E\n"})
public final class SpenObjectFormula extends SpenObjectBase {
    public static final int TYPE_DEGREE = 0;
    public static final int TYPE_RADIAN = 1;

    public SpenObjectFormula() {
        super(11);
    }

    private final native boolean ObjectFormula_appendObjectList(int handle, ArrayList<SpenObjectStroke> objectList);

    private final native boolean ObjectFormula_appendStroke(int handle, SpenObjectStroke stroke);

    private final native int ObjectFormula_getAngleType(int handle);

    private final native String ObjectFormula_getAnswerString(int handle);

    private final native int ObjectFormula_getAnswerStrokeColor(int handle);

    private final native ArrayList<SpenObjectStroke> ObjectFormula_getAnswerStrokeList(int handle);

    private final native Bitmap ObjectFormula_getImageBitmap(int handle);

    private final native String ObjectFormula_getImagePath(int handle);

    private final native ArrayList<String> ObjectFormula_getLatex(int handle);

    private final native ArrayList<String> ObjectFormula_getLatexResult(int handle);

    private final native RectF ObjectFormula_getLatexResultRect(int handle);

    private final native Rect ObjectFormula_getNinePatchRect(int handle);

    private final native SpenObjectStroke ObjectFormula_getStroke(int handle, int index);

    private final native int ObjectFormula_getStrokeCount(int handle);

    private final native ArrayList<SpenObjectStroke> ObjectFormula_getStrokeList(int handle);

    private final native ArrayList<String> ObjectFormula_getSubstitutionLatex(int handle);

    private final native boolean ObjectFormula_hasTrigonometryCalculation(int handle);

    private final native boolean ObjectFormula_init(int handle, boolean isTemplateObject);

    private final native boolean ObjectFormula_isPlottable(int handle);

    private final native boolean ObjectFormula_removeObjectList(int handle, ArrayList<SpenObjectStroke> objectList);

    private final native boolean ObjectFormula_removeStroke(int handle, SpenObjectStroke stroke);

    private final native boolean ObjectFormula_setAngleType(int handle, int type);

    private final native boolean ObjectFormula_setAnswerString(int handle, String answer);

    private final native boolean ObjectFormula_setAnswerStrokeColor(int handle, int color);

    private final native boolean ObjectFormula_setAnswerStrokeList(int handle, ArrayList<SpenObjectStroke> answerStrokeList);

    private final native boolean ObjectFormula_setHasTrigonometryCalculation(int handle, boolean hasTrigonometryCalculation);

    private final native boolean ObjectFormula_setImageBitmap(int handle, Bitmap bitmap, Rect ninePatchRect);

    private final native boolean ObjectFormula_setImagePath(int handle, String filePath, Rect ninePatchRect);

    private final native boolean ObjectFormula_setLatex(int handle, ArrayList<String> latexList);

    private final native boolean ObjectFormula_setLatexResult(int handle, ArrayList<String> latexList);

    private final native boolean ObjectFormula_setLatexResultRect(int handle, RectF rect);

    private final native boolean ObjectFormula_setPlottable(int handle, boolean isPlottable);

    private final native boolean ObjectFormula_setStrokeList(int handle, ArrayList<SpenObjectStroke> strokeList);

    private final native boolean ObjectFormula_setSubstitutionLatex(int handle, ArrayList<String> latexList);

    private final native boolean ObjectFormula_transferObjects(int handle, SpenObjectFormula srcFormula, ArrayList<SpenObjectStroke> objectList);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenObjectFormula(" + this + ") is already closed");
    }

    public final boolean appendStroke(@NotNull SpenObjectStroke stroke) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        boolean zObjectFormula_appendStroke = ObjectFormula_appendStroke(getMHandle(), stroke);
        if (!zObjectFormula_appendStroke) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectFormula_appendStroke;
    }

    public final int getAngleType() {
        return ObjectFormula_getAngleType(getMHandle());
    }

    @NotNull
    public final String getAnswerString() {
        return ObjectFormula_getAnswerString(getMHandle());
    }

    @ColorInt
    public final int getAnswerStrokeColor() {
        return ObjectFormula_getAnswerStrokeColor(getMHandle());
    }

    @Nullable
    public final ArrayList<SpenObjectStroke> getAnswerStrokeList() {
        ArrayList<SpenObjectStroke> arrayListObjectFormula_getAnswerStrokeList = ObjectFormula_getAnswerStrokeList(getMHandle());
        if (arrayListObjectFormula_getAnswerStrokeList == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListObjectFormula_getAnswerStrokeList;
    }

    public final boolean getHasTrigonometryCalculation() {
        return ObjectFormula_hasTrigonometryCalculation(getMHandle());
    }

    @Nullable
    public final Bitmap getImage() {
        return ObjectFormula_getImageBitmap(getMHandle());
    }

    @NotNull
    public final String getImagePath() {
        return ObjectFormula_getImagePath(getMHandle());
    }

    @NotNull
    public final ArrayList<String> getLatex() {
        return ObjectFormula_getLatex(getMHandle());
    }

    @NotNull
    public final ArrayList<String> getLatexResult() {
        return ObjectFormula_getLatexResult(getMHandle());
    }

    @NotNull
    public final RectF getLatexResultRect() {
        return ObjectFormula_getLatexResultRect(getMHandle());
    }

    @NotNull
    public final Rect getNinePatchRect() {
        return ObjectFormula_getNinePatchRect(getMHandle());
    }

    @Nullable
    public final SpenObjectStroke getStroke(int index) {
        SpenObjectStroke spenObjectStrokeObjectFormula_getStroke = ObjectFormula_getStroke(getMHandle(), index);
        if (spenObjectStrokeObjectFormula_getStroke == null) {
            throwUncheckedException(SpenError.getError());
        }
        return spenObjectStrokeObjectFormula_getStroke;
    }

    public final int getStrokeCount() {
        return ObjectFormula_getStrokeCount(getMHandle());
    }

    @Nullable
    public final ArrayList<SpenObjectStroke> getStrokeList() {
        ArrayList<SpenObjectStroke> arrayListObjectFormula_getStrokeList = ObjectFormula_getStrokeList(getMHandle());
        if (arrayListObjectFormula_getStrokeList == null) {
            throwUncheckedException(SpenError.getError());
        }
        return arrayListObjectFormula_getStrokeList;
    }

    @NotNull
    public final ArrayList<String> getSubstitutionLatex() {
        return ObjectFormula_getSubstitutionLatex(getMHandle());
    }

    public final boolean isPlottable() {
        return ObjectFormula_isPlottable(getMHandle());
    }

    public final boolean removeStroke(@NotNull SpenObjectStroke stroke) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        boolean zObjectFormula_removeStroke = ObjectFormula_removeStroke(getMHandle(), stroke);
        if (!zObjectFormula_removeStroke) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectFormula_removeStroke;
    }

    public final void setAngleType(int i) {
        if (ObjectFormula_setAngleType(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAnswerString(@NotNull String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (ObjectFormula_setAnswerString(getMHandle(), answer)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @ColorInt
    @SuppressLint({"SupportAnnotationUsage"})
    public final void setAnswerStrokeColor(int i) {
        if (ObjectFormula_setAnswerStrokeColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setAnswerStrokeList(@Nullable ArrayList<SpenObjectStroke> arrayList) {
        ObjectFormula_setAnswerStrokeList(getMHandle(), arrayList);
    }

    public final void setHasTrigonometryCalculation(boolean z) {
        if (ObjectFormula_setHasTrigonometryCalculation(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImage(@Nullable Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectFormula_setImageBitmap(getMHandle(), bitmap, null)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImagePath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (ObjectFormula_setImagePath(getMHandle(), path, null)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLatex(@NotNull ArrayList<String> latexList) {
        Intrinsics.checkNotNullParameter(latexList, "latexList");
        if (ObjectFormula_setLatex(getMHandle(), latexList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLatexResult(@NotNull ArrayList<String> latexResultList) {
        Intrinsics.checkNotNullParameter(latexResultList, "latexResultList");
        if (ObjectFormula_setLatexResult(getMHandle(), latexResultList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setLatexResultRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (ObjectFormula_setLatexResultRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setPlottable(boolean z) {
        if (ObjectFormula_setPlottable(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setStrokeList(@Nullable ArrayList<SpenObjectStroke> arrayList) {
        ObjectFormula_setStrokeList(getMHandle(), arrayList);
    }

    public final void setSubstitutionLatex(@NotNull ArrayList<String> latexList) {
        Intrinsics.checkNotNullParameter(latexList, "latexList");
        if (ObjectFormula_setSubstitutionLatex(getMHandle(), latexList)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean transferObjects(@NotNull SpenObjectFormula srcFormula, @NotNull ArrayList<SpenObjectStroke> objectList) {
        Intrinsics.checkNotNullParameter(srcFormula, "srcFormula");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        boolean zObjectFormula_transferObjects = ObjectFormula_transferObjects(getMHandle(), srcFormula, objectList);
        if (!zObjectFormula_transferObjects) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectFormula_transferObjects;
    }

    public SpenObjectFormula(boolean z) {
        super(11);
        if (ObjectFormula_init(getMHandle(), z)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final boolean appendStroke(@NotNull ArrayList<SpenObjectStroke> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        boolean zObjectFormula_appendObjectList = ObjectFormula_appendObjectList(getMHandle(), objectList);
        if (!zObjectFormula_appendObjectList) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectFormula_appendObjectList;
    }

    public final boolean removeStroke(@NotNull ArrayList<SpenObjectStroke> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        boolean zObjectFormula_removeObjectList = ObjectFormula_removeObjectList(getMHandle(), objectList);
        if (!zObjectFormula_removeObjectList) {
            throwUncheckedException(SpenError.getError());
        }
        return zObjectFormula_removeObjectList;
    }

    public final void setImage(@Nullable Bitmap bitmap, @Nullable Rect ninePatchRect) {
        if (bitmap != null && bitmap.isRecycled()) {
            throw new IllegalArgumentException("image is recyled.");
        }
        if (ObjectFormula_setImageBitmap(getMHandle(), bitmap, ninePatchRect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    public final void setImage(@NotNull String filePath, @Nullable Rect ninePatchRect) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (ObjectFormula_setImagePath(getMHandle(), filePath, ninePatchRect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
