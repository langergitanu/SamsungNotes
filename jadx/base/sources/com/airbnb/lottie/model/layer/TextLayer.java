package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTextRangeSelector;
import com.airbnb.lottie.model.animatable.AnimatableTextStyle;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.content.TextRangeUnits;
import com.airbnb.lottie.utils.DropShadow;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class TextLayer extends BaseLayer {
    private final StringBuilder charStringBuilder;
    private final List<String> charStrings;
    private final LongSparseArray<String> codePointCache;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final RectF rectF;
    private final StringBuilder reorderingStringBuilder;
    private final StringBuilder reversingStringBuilder;
    private final StringBuilder stringBuilder;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    private final Paint strokePaint;

    @Nullable
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;

    @Nullable
    private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> textRangeEndAnimation;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> textRangeOffsetAnimation;

    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> textRangeStartAnimation;
    private TextRangeUnits textRangeUnits;

    @Nullable
    private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    private final List<TextSubLine> textSubLines;

    @Nullable
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;

    @Nullable
    private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;

    @Nullable
    private BaseKeyframeAnimation<Typeface, Typeface> typefaceCallbackAnimation;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.TextLayer$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C43393 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextSubLine {
        private String text;
        private float width;

        private TextSubLine() {
            this.text = "";
            this.width = 0.0f;
        }

        public void set(String str, float f) {
            this.text = str;
            this.width = f;
        }
    }

    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        AnimatableTextRangeSelector animatableTextRangeSelector;
        AnimatableTextRangeSelector animatableTextRangeSelector2;
        AnimatableIntegerValue animatableIntegerValue;
        AnimatableTextRangeSelector animatableTextRangeSelector3;
        AnimatableIntegerValue animatableIntegerValue2;
        AnimatableTextRangeSelector animatableTextRangeSelector4;
        AnimatableIntegerValue animatableIntegerValue3;
        AnimatableTextStyle animatableTextStyle;
        AnimatableIntegerValue animatableIntegerValue4;
        AnimatableTextStyle animatableTextStyle2;
        AnimatableFloatValue animatableFloatValue;
        AnimatableTextStyle animatableTextStyle3;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableTextStyle animatableTextStyle4;
        AnimatableColorValue animatableColorValue;
        AnimatableTextStyle animatableTextStyle5;
        AnimatableColorValue animatableColorValue2;
        super(lottieDrawable, layer);
        this.stringBuilder = new StringBuilder(2);
        this.charStringBuilder = new StringBuilder(0);
        this.reorderingStringBuilder = new StringBuilder(0);
        this.reversingStringBuilder = new StringBuilder(0);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        int i = 1;
        this.fillPaint = new Paint(i) { // from class: com.airbnb.lottie.model.layer.TextLayer.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(i) { // from class: com.airbnb.lottie.model.layer.TextLayer.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray<>();
        this.charStrings = new ArrayList();
        this.textSubLines = new ArrayList();
        this.textRangeUnits = TextRangeUnits.INDEX;
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        TextKeyframeAnimation textKeyframeAnimationCreateAnimation = layer.getText().createAnimation();
        this.textAnimation = textKeyframeAnimationCreateAnimation;
        textKeyframeAnimationCreateAnimation.addUpdateListener(this);
        addAnimation(textKeyframeAnimationCreateAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (textProperties != null && (animatableTextStyle5 = textProperties.textStyle) != null && (animatableColorValue2 = animatableTextStyle5.color) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation = animatableColorValue2.createAnimation();
            this.colorAnimation = baseKeyframeAnimationCreateAnimation;
            baseKeyframeAnimationCreateAnimation.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (textProperties != null && (animatableTextStyle4 = textProperties.textStyle) != null && (animatableColorValue = animatableTextStyle4.stroke) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation2 = animatableColorValue.createAnimation();
            this.strokeColorAnimation = baseKeyframeAnimationCreateAnimation2;
            baseKeyframeAnimationCreateAnimation2.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (textProperties != null && (animatableTextStyle3 = textProperties.textStyle) != null && (animatableFloatValue2 = animatableTextStyle3.strokeWidth) != null) {
            FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation = animatableFloatValue2.createAnimation();
            this.strokeWidthAnimation = floatKeyframeAnimationCreateAnimation;
            floatKeyframeAnimationCreateAnimation.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties != null && (animatableTextStyle2 = textProperties.textStyle) != null && (animatableFloatValue = animatableTextStyle2.tracking) != null) {
            FloatKeyframeAnimation floatKeyframeAnimationCreateAnimation2 = animatableFloatValue.createAnimation();
            this.trackingAnimation = floatKeyframeAnimationCreateAnimation2;
            floatKeyframeAnimationCreateAnimation2.addUpdateListener(this);
            addAnimation(this.trackingAnimation);
        }
        if (textProperties != null && (animatableTextStyle = textProperties.textStyle) != null && (animatableIntegerValue4 = animatableTextStyle.opacity) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation3 = animatableIntegerValue4.createAnimation();
            this.opacityAnimation = baseKeyframeAnimationCreateAnimation3;
            baseKeyframeAnimationCreateAnimation3.addUpdateListener(this);
            addAnimation(this.opacityAnimation);
        }
        if (textProperties != null && (animatableTextRangeSelector4 = textProperties.rangeSelector) != null && (animatableIntegerValue3 = animatableTextRangeSelector4.start) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation4 = animatableIntegerValue3.createAnimation();
            this.textRangeStartAnimation = baseKeyframeAnimationCreateAnimation4;
            baseKeyframeAnimationCreateAnimation4.addUpdateListener(this);
            addAnimation(this.textRangeStartAnimation);
        }
        if (textProperties != null && (animatableTextRangeSelector3 = textProperties.rangeSelector) != null && (animatableIntegerValue2 = animatableTextRangeSelector3.end) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation5 = animatableIntegerValue2.createAnimation();
            this.textRangeEndAnimation = baseKeyframeAnimationCreateAnimation5;
            baseKeyframeAnimationCreateAnimation5.addUpdateListener(this);
            addAnimation(this.textRangeEndAnimation);
        }
        if (textProperties != null && (animatableTextRangeSelector2 = textProperties.rangeSelector) != null && (animatableIntegerValue = animatableTextRangeSelector2.offset) != null) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationCreateAnimation6 = animatableIntegerValue.createAnimation();
            this.textRangeOffsetAnimation = baseKeyframeAnimationCreateAnimation6;
            baseKeyframeAnimationCreateAnimation6.addUpdateListener(this);
            addAnimation(this.textRangeOffsetAnimation);
        }
        if (textProperties == null || (animatableTextRangeSelector = textProperties.rangeSelector) == null) {
            return;
        }
        this.textRangeUnits = animatableTextRangeSelector.units;
    }

    private String codePointToString(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!isModifier(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.codePointCache.containsKey(j)) {
            return this.codePointCache.get(j);
        }
        this.stringBuilder.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.stringBuilder.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.stringBuilder.toString();
        this.codePointCache.put(j, string);
        return string;
    }

    private void configurePaint(DocumentData documentData, int i, int i2) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
        } else if (this.colorAnimation == null || !isIndexInRangeSelection(i2)) {
            this.fillPaint.setColor(documentData.color);
        } else {
            this.fillPaint.setColor(this.colorAnimation.getValue().intValue());
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorCallbackAnimation;
        if (baseKeyframeAnimation2 != null) {
            this.strokePaint.setColor(baseKeyframeAnimation2.getValue().intValue());
        } else if (this.strokeColorAnimation == null || !isIndexInRangeSelection(i2)) {
            this.strokePaint.setColor(documentData.strokeColor);
        } else {
            this.strokePaint.setColor(this.strokeColorAnimation.getValue().intValue());
        }
        int iIntValue = 100;
        int iIntValue2 = this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue();
        if (this.opacityAnimation != null && isIndexInRangeSelection(i2)) {
            iIntValue = this.opacityAnimation.getValue().intValue();
        }
        int iRound = Math.round((((iIntValue / 100.0f) * ((iIntValue2 * 255.0f) / 100.0f)) * i) / 255.0f);
        this.fillPaint.setAlpha(iRound);
        this.strokePaint.setAlpha(iRound);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthCallbackAnimation;
        if (baseKeyframeAnimation3 != null) {
            this.strokePaint.setStrokeWidth(baseKeyframeAnimation3.getValue().floatValue());
        } else if (this.strokeWidthAnimation == null || !isIndexInRangeSelection(i2)) {
            this.strokePaint.setStrokeWidth(Utils.dpScale() * documentData.strokeWidth);
        } else {
            this.strokePaint.setStrokeWidth(this.strokeWidthAnimation.getValue().floatValue());
        }
    }

    private void drawCharacter(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, float f, DocumentData documentData, Canvas canvas, int i, int i2) {
        configurePaint(documentData, i2, i);
        List<ContentGroup> contentsForCharacter = getContentsForCharacter(fontCharacter);
        for (int i4 = 0; i4 < contentsForCharacter.size(); i4++) {
            Path path = contentsForCharacter.get(i4).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.reset();
            this.matrix.preTranslate(0.0f, Utils.dpScale() * (-documentData.baselineShift));
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                drawGlyph(path, this.strokePaint, canvas);
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                drawGlyph(path, this.fillPaint, canvas);
            }
        }
    }

    private void drawCharacterFromFont(String str, DocumentData documentData, Canvas canvas, int i, int i2) {
        configurePaint(documentData, i2, i);
        if (documentData.strokeOverFill) {
            drawCharacter(str, this.fillPaint, canvas);
            drawCharacter(str, this.strokePaint, canvas);
        } else {
            drawCharacter(str, this.strokePaint, canvas);
            drawCharacter(str, this.fillPaint, canvas);
        }
    }

    private void drawFontTextLine(String str, DocumentData documentData, Canvas canvas, float f, int i, int i2) {
        this.charStrings.clear();
        int length = 0;
        while (length < str.length()) {
            String strCodePointToString = codePointToString(str, length);
            this.charStrings.add(strCodePointToString);
            length += strCodePointToString.length();
        }
        int i4 = 0;
        while (i4 < this.charStrings.size()) {
            this.charStringBuilder.setLength(0);
            this.charStringBuilder.append(this.charStrings.get(i4));
            int i5 = i4 + 1;
            while (i5 < this.charStrings.size()) {
                String str2 = this.charStrings.get(i5);
                if (isJoiningRightToLeft(str2)) {
                    this.charStringBuilder.insert(0, str2);
                    i5++;
                }
            }
            String string = this.charStringBuilder.toString();
            DocumentData documentData2 = documentData;
            drawCharacterFromFont(string, documentData2, canvas, i + i4, i2);
            canvas.translate(this.fillPaint.measureText(string) + f, 0.0f);
            i4 = i5;
            documentData = documentData2;
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void drawGlyphTextLine(String str, DocumentData documentData, Font font, Canvas canvas, float f, float f4, float f5, int i) {
        DocumentData documentData2;
        Canvas canvas2;
        float f6;
        int i2;
        int i4 = 0;
        while (i4 < str.length()) {
            FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(str.charAt(i4), font.getFamily(), font.getStyle()));
            if (fontCharacter == null) {
                documentData2 = documentData;
                canvas2 = canvas;
                f6 = f4;
                i2 = i;
            } else {
                documentData2 = documentData;
                canvas2 = canvas;
                f6 = f4;
                i2 = i;
                drawCharacterAsGlyph(fontCharacter, f6, documentData2, canvas2, i4, i2);
                canvas2.translate((Utils.dpScale() * ((float) fontCharacter.getWidth()) * f6) + f5, 0.0f);
            }
            i4++;
            f4 = f6;
            documentData = documentData2;
            canvas = canvas2;
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawTextWithFont(DocumentData documentData, Font font, Canvas canvas, int i) {
        float fFloatValue;
        int size;
        int i2;
        float f;
        int i4;
        TextLayer textLayer = this;
        DocumentData documentData2 = documentData;
        Font font2 = font;
        Typeface typeface = textLayer.getTypeface(font2);
        if (typeface == null) {
            return;
        }
        String textInternal = documentData2.text;
        TextDelegate textDelegate = textLayer.lottieDrawable.getTextDelegate();
        if (textDelegate != null) {
            textInternal = textDelegate.getTextInternal(textLayer.getName(), textInternal);
        }
        textLayer.fillPaint.setTypeface(typeface);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = textLayer.textSizeCallbackAnimation;
        float fFloatValue2 = baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() : documentData2.size;
        textLayer.fillPaint.setTextSize(Utils.dpScale() * fFloatValue2);
        textLayer.strokePaint.setTypeface(textLayer.fillPaint.getTypeface());
        textLayer.strokePaint.setTextSize(textLayer.fillPaint.getTextSize());
        float f4 = documentData2.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = textLayer.trackingCallbackAnimation;
        if (baseKeyframeAnimation2 == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = textLayer.trackingAnimation;
            if (baseKeyframeAnimation3 != null) {
                fFloatValue = baseKeyframeAnimation3.getValue().floatValue();
            }
            float fDpScale = ((Utils.dpScale() * f4) * fFloatValue2) / 100.0f;
            List<String> textLines = textLayer.getTextLines(textInternal);
            size = textLines.size();
            int i5 = -1;
            i2 = 0;
            int length = 0;
            while (i2 < size) {
                String str = textLines.get(i2);
                PointF pointF = documentData2.boxSize;
                float f5 = fDpScale;
                List<TextSubLine> listSplitGlyphTextIntoLines = textLayer.splitGlyphTextIntoLines(str, pointF == null ? 0.0f : pointF.x, font2, 0.0f, f5, false);
                int i6 = 0;
                while (i6 < listSplitGlyphTextIntoLines.size()) {
                    TextSubLine textSubLine = listSplitGlyphTextIntoLines.get(i6);
                    i5++;
                    canvas.save();
                    if (textLayer.offsetCanvas(canvas, documentData2, i5, (textLayer.textAnimation == null && textLayer.textSizeCallbackAnimation == null && textLayer.trackingCallbackAnimation == null) ? textSubLine.width : textLayer.fillPaint.measureText(textSubLine.text))) {
                        String strReorderLineVisually = textSubLine.text;
                        if (Bidi.requiresBidi(strReorderLineVisually.toCharArray(), 0, strReorderLineVisually.length())) {
                            strReorderLineVisually = textLayer.reorderLineVisually(strReorderLineVisually);
                        }
                        f = f5;
                        i4 = length;
                        textLayer.drawFontTextLine(strReorderLineVisually, documentData2, canvas, f, i4, i);
                    } else {
                        f = f5;
                        i4 = length;
                    }
                    length = textSubLine.text.length() + i4;
                    canvas.restore();
                    i6++;
                    textLayer = this;
                    documentData2 = documentData;
                    f5 = f;
                }
                fDpScale = f5;
                i2++;
                textLayer = this;
                documentData2 = documentData;
                font2 = font;
            }
        }
        fFloatValue = baseKeyframeAnimation2.getValue().floatValue();
        f4 += fFloatValue;
        float fDpScale2 = ((Utils.dpScale() * f4) * fFloatValue2) / 100.0f;
        List<String> textLines2 = textLayer.getTextLines(textInternal);
        size = textLines2.size();
        int i52 = -1;
        i2 = 0;
        int length2 = 0;
        while (i2 < size) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawTextWithGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas, int i) {
        float fFloatValue;
        int i2;
        float f;
        float f4;
        TextLayer textLayer = this;
        DocumentData documentData2 = documentData;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = textLayer.textSizeCallbackAnimation;
        float fFloatValue2 = (baseKeyframeAnimation != null ? baseKeyframeAnimation.getValue().floatValue() : documentData2.size) / 100.0f;
        float scale = Utils.getScale(matrix);
        List<String> textLines = textLayer.getTextLines(documentData2.text);
        int size = textLines.size();
        float f5 = documentData2.tracking / 10.0f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = textLayer.trackingCallbackAnimation;
        if (baseKeyframeAnimation2 == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = textLayer.trackingAnimation;
            if (baseKeyframeAnimation3 != null) {
                fFloatValue = baseKeyframeAnimation3.getValue().floatValue();
            }
            float f6 = f5;
            int i4 = -1;
            i2 = 0;
            while (i2 < size) {
                String str = textLines.get(i2);
                PointF pointF = documentData2.boxSize;
                List<TextSubLine> listSplitGlyphTextIntoLines = textLayer.splitGlyphTextIntoLines(str, pointF == null ? 0.0f : pointF.x, font, fFloatValue2, f6, true);
                int i5 = 0;
                while (i5 < listSplitGlyphTextIntoLines.size()) {
                    TextSubLine textSubLine = listSplitGlyphTextIntoLines.get(i5);
                    i4++;
                    canvas.save();
                    if (textLayer.offsetCanvas(canvas, documentData2, i4, textSubLine.width)) {
                        float f7 = fFloatValue2;
                        DocumentData documentData3 = documentData2;
                        f = f6;
                        f4 = scale;
                        textLayer.drawGlyphTextLine(textSubLine.text, documentData3, font, canvas, f4, f7, f, i);
                        fFloatValue2 = f7;
                    } else {
                        f = f6;
                        f4 = scale;
                    }
                    canvas.restore();
                    i5++;
                    textLayer = this;
                    scale = f4;
                    f6 = f;
                    documentData2 = documentData;
                }
                i2++;
                textLayer = this;
                f6 = f6;
                documentData2 = documentData;
            }
        }
        fFloatValue = baseKeyframeAnimation2.getValue().floatValue();
        f5 += fFloatValue;
        float f62 = f5;
        int i42 = -1;
        i2 = 0;
        while (i2 < size) {
        }
    }

    private TextSubLine ensureEnoughSubLines(int i) {
        for (int size = this.textSubLines.size(); size < i; size++) {
            this.textSubLines.add(new TextSubLine());
        }
        return this.textSubLines.get(i - 1);
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i), this.composition));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    private List<String> getTextLines(String str) {
        return Arrays.asList(str.replaceAll("\r\n", StringUtils.f9761CR).replaceAll("\u0003", StringUtils.f9761CR).replaceAll("\n", StringUtils.f9761CR).split(StringUtils.f9761CR));
    }

    @Nullable
    private Typeface getTypeface(Font font) {
        Typeface value;
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation = this.typefaceCallbackAnimation;
        if (baseKeyframeAnimation != null && (value = baseKeyframeAnimation.getValue()) != null) {
            return value;
        }
        Typeface typeface = this.lottieDrawable.getTypeface(font);
        return typeface != null ? typeface : font.getTypeface();
    }

    private boolean isIndexInRangeSelection(int i) {
        int length = this.textAnimation.getValue().text.length();
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.textRangeStartAnimation;
        if (baseKeyframeAnimation == null || this.textRangeEndAnimation == null) {
            return true;
        }
        int iMin = Math.min(baseKeyframeAnimation.getValue().intValue(), this.textRangeEndAnimation.getValue().intValue());
        int iMax = Math.max(this.textRangeStartAnimation.getValue().intValue(), this.textRangeEndAnimation.getValue().intValue());
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.textRangeOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            int iIntValue = baseKeyframeAnimation2.getValue().intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.textRangeUnits == TextRangeUnits.INDEX) {
            return i >= iMin && i < iMax;
        }
        float f = (i / length) * 100.0f;
        return f >= ((float) iMin) && f < ((float) iMax);
    }

    private boolean isJoiningRightToLeft(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.getDirectionality(str.codePointAt(i)) == 2) {
                return true;
            }
        }
        return false;
    }

    private boolean isModifier(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    private boolean offsetCanvas(Canvas canvas, DocumentData documentData, int i, float f) {
        PointF pointF = documentData.boxPosition;
        PointF pointF2 = documentData.boxSize;
        float fDpScale = Utils.dpScale();
        float fM1154D = AbstractC0622a.m1154D(i, documentData.lineHeight, fDpScale, pointF == null ? 0.0f : (documentData.lineHeight * fDpScale) + pointF.y);
        if (this.lottieDrawable.getClipTextToBoundingBox() && pointF2 != null && pointF != null && fM1154D >= pointF.y + pointF2.y + documentData.size) {
            return false;
        }
        float f4 = pointF == null ? 0.0f : pointF.x;
        float f5 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = C43393.$SwitchMap$com$airbnb$lottie$model$DocumentData$Justification[documentData.justification.ordinal()];
        if (i2 == 1) {
            canvas.translate(f4, fM1154D);
        } else if (i2 == 2) {
            canvas.translate((f4 + f5) - f, fM1154D);
        } else if (i2 == 3) {
            canvas.translate(((f5 / 2.0f) + f4) - (f / 2.0f), fM1154D);
        }
        return true;
    }

    private String reorderLineVisually(String str) {
        Bidi bidi = new Bidi(str, -2);
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i = 0; i < runCount; i++) {
            bArr[i] = (byte) bidi.getRunLevel(i);
            numArr[i] = Integer.valueOf(i);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        this.reorderingStringBuilder.setLength(0);
        for (int i2 = 0; i2 < runCount; i2++) {
            int iIntValue = numArr[i2].intValue();
            int runStart = bidi.getRunStart(iIntValue);
            int runLimit = bidi.getRunLimit(iIntValue);
            int runLevel = bidi.getRunLevel(iIntValue);
            String strSubstring = str.substring(runStart, runLimit);
            if ((runLevel & 1) == 0) {
                this.reorderingStringBuilder.append(strSubstring);
            } else {
                this.reversingStringBuilder.setLength(0);
                int length = 0;
                while (length < strSubstring.length()) {
                    String strCodePointToString = codePointToString(strSubstring, length);
                    this.reversingStringBuilder.insert(0, strCodePointToString);
                    length += strCodePointToString.length();
                }
                this.reorderingStringBuilder.append((CharSequence) this.reversingStringBuilder);
            }
        }
        return this.reorderingStringBuilder.toString();
    }

    private List<TextSubLine> splitGlyphTextIntoLines(String str, float f, Font font, float f4, float f5, boolean z) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i4 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (z) {
                FontCharacter fontCharacter = this.composition.getCharacters().get(FontCharacter.hashFor(cCharAt, font.getFamily(), font.getStyle()));
                if (fontCharacter != null) {
                    fMeasureText = (Utils.dpScale() * ((float) fontCharacter.getWidth()) * f4) + f5;
                }
            } else {
                fMeasureText = this.fillPaint.measureText(str.substring(i5, i5 + 1)) + f5;
            }
            if (cCharAt == ' ') {
                z2 = true;
                f8 = fMeasureText;
            } else if (z2) {
                z2 = false;
                i4 = i5;
                f7 = fMeasureText;
            } else {
                f7 += fMeasureText;
            }
            f6 += fMeasureText;
            if (f > 0.0f && f6 >= f && cCharAt != ' ') {
                i++;
                TextSubLine textSubLineEnsureEnoughSubLines = ensureEnoughSubLines(i);
                if (i4 == i2) {
                    textSubLineEnsureEnoughSubLines.set(str.substring(i2, i5).trim(), (f6 - fMeasureText) - ((r9.length() - r7.length()) * f8));
                    i2 = i5;
                    i4 = i2;
                    f6 = fMeasureText;
                    f7 = f6;
                } else {
                    textSubLineEnsureEnoughSubLines.set(str.substring(i2, i4 - 1).trim(), ((f6 - f7) - ((r7.length() - r13.length()) * f8)) - f8);
                    f6 = f7;
                    i2 = i4;
                }
            }
        }
        if (f6 > 0.0f) {
            i++;
            ensureEnoughSubLines(i).set(str.substring(i2), f6);
        }
        return this.textSubLines.subList(0, i);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.colorCallbackAnimation);
            return;
        }
        if (t == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorCallbackAnimation;
            if (baseKeyframeAnimation2 != null) {
                removeAnimation(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.strokeColorCallbackAnimation);
            return;
        }
        if (t == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthCallbackAnimation;
            if (baseKeyframeAnimation3 != null) {
                removeAnimation(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            addAnimation(this.strokeWidthCallbackAnimation);
            return;
        }
        if (t == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.trackingCallbackAnimation;
            if (baseKeyframeAnimation4 != null) {
                removeAnimation(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.trackingCallbackAnimation);
            return;
        }
        if (t == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation5 != null) {
                removeAnimation(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            addAnimation(this.textSizeCallbackAnimation);
            return;
        }
        if (t != LottieProperty.TYPEFACE) {
            if (t == LottieProperty.TEXT) {
                this.textAnimation.setStringValueCallback(lottieValueCallback);
                return;
            }
            return;
        }
        BaseKeyframeAnimation<Typeface, Typeface> baseKeyframeAnimation6 = this.typefaceCallbackAnimation;
        if (baseKeyframeAnimation6 != null) {
            removeAnimation(baseKeyframeAnimation6);
        }
        if (lottieValueCallback == null) {
            this.typefaceCallbackAnimation = null;
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation6 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.typefaceCallbackAnimation = valueCallbackKeyframeAnimation6;
        valueCallbackKeyframeAnimation6.addUpdateListener(this);
        addAnimation(this.typefaceCallbackAnimation);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i, @Nullable DropShadow dropShadow) {
        Canvas canvas2;
        DocumentData value = this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(value.fontName);
        if (font == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        configurePaint(value, i, 0);
        if (this.lottieDrawable.useTextGlyphs()) {
            canvas2 = canvas;
            drawTextWithGlyphs(value, matrix, font, canvas2, i);
        } else {
            canvas2 = canvas;
            drawTextWithFont(value, font, canvas2, i);
        }
        canvas2.restore();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.composition.getBounds().width(), this.composition.getBounds().height());
    }
}
