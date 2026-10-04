package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.res.ResourcesCompat;
import androidx.credentials.provider.C2558c;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.app.sdk.deepsky.textextraction.C7039R;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J/\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001c¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u0004J\u001e\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020'2\u0006\u0010$\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0004J\u0019\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/util/DrawUtil;", "", "()V", "HANDLE_SHADOW_DRAWABLE_DX", "", "HANDLE_SHADOW_DRAWABLE_DY", "HANDLE_SHADOW_DRAWABLE_RADIUS", "PIVOT_LEFT_END", "PIVOT_RIGHT_END", "PIVOT_TOP_END", SearchConstants.TargetContents.TAG, "", "convertDpToPx", "", "context", "Landroid/content/Context;", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "(Landroid/content/Context;Ljava/lang/Float;)I", "createLeftHandleDrawable", "Landroid/graphics/drawable/RotateDrawable;", "color", "createLeftHandleShadowDrawable", "createRightHandleDrawable", "createRightHandleShadowDrawable", "createShadowDrawable", "Landroid/graphics/drawable/Drawable;", "fixDimensions", "", "Landroid/graphics/Point;", "points", "", "ratio", TypedValues.Cycle.S_WAVE_OFFSET, "([Landroid/graphics/Point;FLandroid/graphics/Point;)Ljava/util/List;", "interpolateInt", "start", "end", "fraction", "interpolateRect", "Landroid/graphics/Rect;", "isLeftToRightText", "", "poly", "([Landroid/graphics/Point;)Z", "logOcrResult", "", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "languageTags", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DrawUtil {
    private static final float HANDLE_SHADOW_DRAWABLE_DX = 0.0f;
    private static final float HANDLE_SHADOW_DRAWABLE_DY = 5.0f;
    private static final float HANDLE_SHADOW_DRAWABLE_RADIUS = 10.0f;

    @NotNull
    public static final DrawUtil INSTANCE = new DrawUtil();
    private static final float PIVOT_LEFT_END = 0.0f;
    private static final float PIVOT_RIGHT_END = 1.0f;
    private static final float PIVOT_TOP_END = 0.0f;

    @NotNull
    private static final String TAG = "DrawUtil";

    private DrawUtil() {
    }

    private final Drawable createShadowDrawable(Context context) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setFlags(1);
        shapeDrawable.getPaint().setColor(0);
        shapeDrawable.getPaint().setShadowLayer(10.0f, 0.0f, HANDLE_SHADOW_DRAWABLE_DY, context.getColor(C7039R.color.textextraction_handle_shadow_color));
        return shapeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Point fixDimensions$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Point) tmp0.invoke(obj);
    }

    public final int convertDpToPx(@NotNull Context context, @Nullable Float dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNull(dp);
        return (int) (TypedValue.applyDimension(1, dp.floatValue(), context.getResources().getDisplayMetrics()) + 0.5f);
    }

    @NotNull
    public final RotateDrawable createLeftHandleDrawable(@NotNull Context context, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(ResourcesCompat.getDrawable(context.getResources(), C7039R.drawable.copypaste_text_select_handle_mtrl_01, null));
        rotateDrawable.setPivotX(1.0f);
        rotateDrawable.setPivotY(0.0f);
        rotateDrawable.setTint(color);
        return rotateDrawable;
    }

    @NotNull
    public final RotateDrawable createLeftHandleShadowDrawable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(INSTANCE.createShadowDrawable(context));
        rotateDrawable.setPivotX(1.0f);
        rotateDrawable.setPivotY(0.0f);
        return rotateDrawable;
    }

    @NotNull
    public final RotateDrawable createRightHandleDrawable(@NotNull Context context, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(ResourcesCompat.getDrawable(context.getResources(), C7039R.drawable.copypaste_text_select_handle_mtrl_02, null));
        rotateDrawable.setPivotX(0.0f);
        rotateDrawable.setPivotY(0.0f);
        rotateDrawable.setTint(color);
        return rotateDrawable;
    }

    @NotNull
    public final RotateDrawable createRightHandleShadowDrawable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(INSTANCE.createShadowDrawable(context));
        rotateDrawable.setPivotX(0.0f);
        rotateDrawable.setPivotY(0.0f);
        return rotateDrawable;
    }

    @NotNull
    public final List<Point> fixDimensions(@NotNull Point[] points, final float ratio, @NotNull final Point offset) {
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(offset, "offset");
        Object objCollect = Stream.of(Arrays.copyOf(points, points.length)).map(new C2558c(new Function1<Point, Point>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil.fixDimensions.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Point invoke(@NotNull Point point) {
                Intrinsics.checkNotNullParameter(point, "point");
                float f = point.x;
                float f4 = ratio;
                Point point2 = offset;
                return new Point((int) ((f * f4) + point2.x + 0.5f), (int) ((point.y * f4) + point2.y + 0.5f));
            }
        }, 12)).collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(objCollect, "ratio: Float, offset: Po…lect(Collectors.toList())");
        return (List) objCollect;
    }

    public final int interpolateInt(int start, int end, float fraction) {
        return (int) (((end - start) * fraction) + start);
    }

    @NotNull
    public final Rect interpolateRect(@NotNull Rect start, @NotNull Rect end, float fraction) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new Rect((int) (((end.left - r1) * fraction) + start.left), (int) (((end.top - r2) * fraction) + start.top), (int) (((end.right - r3) * fraction) + start.right), (int) (((end.bottom - r7) * fraction) + start.bottom));
    }

    public final boolean isLeftToRightText(@NotNull Point[] poly) {
        Intrinsics.checkNotNullParameter(poly, "poly");
        List listSlice = ArraysKt.slice((Object[]) poly, new IntRange(0, 2));
        Point point = (Point) listSlice.get(0);
        Point point2 = (Point) listSlice.get(1);
        Point point3 = (Point) listSlice.get(2);
        int i = point2.y;
        int i2 = i - point.y;
        int i4 = point3.x;
        int i5 = point2.x;
        return ((i4 - i5) * i2) - ((point3.y - i) * (i5 - point.x)) < 0;
    }

    public final void logOcrResult(@NotNull OcrResult ocrResult, @NotNull String languageTags) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(languageTags, "languageTags");
        StringBuilder sb = new StringBuilder();
        sb.append("setOcrResult " + ocrResult + ", LanguageTags : " + languageTags);
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        char c = '\n';
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        int i = 0;
        for (OcrResult.BlockInfo blockInfo : ocrResult.getBlockInfoList()) {
            int i2 = i + 1;
            String strPolyToString = PointUtil.INSTANCE.polyToString(blockInfo.getPoly());
            Rect rect = blockInfo.getRect();
            String string = blockInfo.getString();
            StringBuilder sbM1629s = AbstractC2322a.m1629s("blockInfo", i, " ", strPolyToString, " ");
            sbM1629s.append(rect);
            sbM1629s.append(" ");
            sbM1629s.append(string);
            sb.append(sbM1629s.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
            sb.append(c);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            int i4 = 0;
            for (OcrResult.LineInfo lineInfo : blockInfo.getLineInfo()) {
                int i5 = i4 + 1;
                String strPolyToString2 = PointUtil.INSTANCE.polyToString(lineInfo.getPoly());
                Rect rect2 = lineInfo.getRect();
                String string2 = lineInfo.getString();
                StringBuilder sbM1629s2 = AbstractC2322a.m1629s("    lineInfo", i4, " ", strPolyToString2, " ");
                sbM1629s2.append(rect2);
                sbM1629s2.append(" ");
                sbM1629s2.append(string2);
                sb.append(sbM1629s2.toString());
                Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                int i6 = 0;
                for (OcrResult.WordInfo wordInfo : lineInfo.getWordInfo()) {
                    String strPolyToString3 = PointUtil.INSTANCE.polyToString(wordInfo.getPoly());
                    Rect rect3 = wordInfo.getRect();
                    String string3 = wordInfo.getString();
                    StringBuilder sbM1629s3 = AbstractC2322a.m1629s("        wordInfo", i6, SQLKeyword.COMMA, strPolyToString3, " ");
                    sbM1629s3.append(rect3);
                    sbM1629s3.append(" ");
                    sbM1629s3.append(string3);
                    sb.append(sbM1629s3.toString());
                    Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                    sb.append('\n');
                    Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                    i6++;
                }
                i4 = i5;
                c = '\n';
            }
            i = i2;
        }
        for (OcrResult.EntityInfo entityInfo : ocrResult.getEntityInfoList()) {
            String strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(entityInfo.getPolys(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Point[], CharSequence>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil$logOcrResult$polyString$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Point[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return PointUtil.INSTANCE.polyToString(it);
                }
            }, 31, (Object) null);
            String strJoinToString$default2 = ArraysKt___ArraysKt.joinToString$default(entityInfo.getRects(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Rect, CharSequence>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil$logOcrResult$rectString$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Rect it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String string4 = it.toString();
                    Intrinsics.checkNotNullExpressionValue(string4, "it.toString()");
                    return string4;
                }
            }, 31, (Object) null);
            String text = entityInfo.getText();
            String type = entityInfo.getType();
            StringBuilder sbM16m = AbstractC0000a.m16m("entityInfo ", strJoinToString$default, " ", strJoinToString$default2, " ");
            sbM16m.append(text);
            sbM16m.append(" ");
            sbM16m.append(type);
            sb.append(sbM16m.toString());
            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            for (OcrResult.UnderlineInfo underlineInfo : entityInfo.getUnderlines()) {
                PointF start = underlineInfo.getStart();
                PointF stop = underlineInfo.getStop();
                Intrinsics.checkNotNull(start);
                float f = start.x;
                float f4 = start.y;
                Intrinsics.checkNotNull(stop);
                float f5 = stop.x;
                float f6 = stop.y;
                StringBuilder sbM1176v = AbstractC0622a.m1176v("    underline start : ", f, SQLKeyword.COMMA, f4, ", stop : ");
                sbM1176v.append(f5);
                sbM1176v.append(SQLKeyword.COMMA);
                sbM1176v.append(f6);
                sb.append(sbM1176v.toString());
                Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
        String string4 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string4, "ocrLog.toString()");
        LibLogger.m5432i(TAG, string4);
    }
}
