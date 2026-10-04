package androidx.compose.p109ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.text.SpanStyle;
import androidx.compose.p109ui.text.font.FontStyle;
import androidx.compose.p109ui.text.font.FontSynthesis;
import androidx.compose.p109ui.text.font.FontWeight;
import androidx.compose.p109ui.text.style.BaselineShift;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextGeometricTransform;
import androidx.compose.p109ui.unit.TextUnit;
import androidx.compose.p109ui.unit.TextUnitType;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, m13886d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", VElementKey.SHADOW, "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", XmlErrorCodes.INT, "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class EncodeHelper {
    public static final int $stable = 8;

    @NotNull
    private Parcel parcel = Parcel.obtain();

    public final void encode(@NotNull SpanStyle spanStyle) {
        long jM20406getColor0d7_KjU = spanStyle.m20406getColor0d7_KjU();
        Color.Companion companion = Color.INSTANCE;
        if (!Color.m18526equalsimpl0(jM20406getColor0d7_KjU, companion.m18561getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m20209encode8_81llA(spanStyle.m20406getColor0d7_KjU());
        }
        long fontSize = spanStyle.getFontSize();
        TextUnit.Companion companion2 = TextUnit.INSTANCE;
        if (!TextUnit.m21158equalsimpl0(fontSize, companion2.m21172getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m20206encodeR2X_6o(spanStyle.getFontSize());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        if (fontStyle != null) {
            int iM20568unboximpl = fontStyle.m20568unboximpl();
            encode((byte) 4);
            m20211encodenzbMABs(iM20568unboximpl);
        }
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        if (fontSynthesis != null) {
            int value = fontSynthesis.getValue();
            encode((byte) 5);
            m20208encode6p3vJLY(value);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m21158equalsimpl0(spanStyle.getLetterSpacing(), companion2.m21172getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m20206encodeR2X_6o(spanStyle.getLetterSpacing());
        }
        BaselineShift baselineShift = spanStyle.getBaselineShift();
        if (baselineShift != null) {
            float fM20747unboximpl = baselineShift.m20747unboximpl();
            encode((byte) 8);
            m20207encode4Dl_Bck(fM20747unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m18526equalsimpl0(spanStyle.getBackground(), companion.m18561getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m20209encode8_81llA(spanStyle.getBackground());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m20206encodeR2X_6o(long textUnit) {
        long jM21160getTypeUIouoOA = TextUnit.m21160getTypeUIouoOA(textUnit);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        byte b = 0;
        if (!TextUnitType.m21189equalsimpl0(jM21160getTypeUIouoOA, companion.m21195getUnspecifiedUIouoOA())) {
            if (TextUnitType.m21189equalsimpl0(jM21160getTypeUIouoOA, companion.m21194getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m21189equalsimpl0(jM21160getTypeUIouoOA, companion.m21193getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m21189equalsimpl0(TextUnit.m21160getTypeUIouoOA(textUnit), companion.m21195getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m21161getValueimpl(textUnit));
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m20207encode4Dl_Bck(float baselineShift) {
        encode(baselineShift);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m20208encode6p3vJLY(int fontSynthesis) {
        FontSynthesis.Companion companion = FontSynthesis.INSTANCE;
        byte b = 0;
        if (!FontSynthesis.m20576equalsimpl0(fontSynthesis, companion.m20583getNoneGVVA2EU())) {
            if (FontSynthesis.m20576equalsimpl0(fontSynthesis, companion.m20582getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m20576equalsimpl0(fontSynthesis, companion.m20585getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m20576equalsimpl0(fontSynthesis, companion.m20584getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m20209encode8_81llA(long color) {
        m20210encodeVKZWuLQ(color);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m20210encodeVKZWuLQ(long uLong) {
        this.parcel.writeLong(uLong);
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m20211encodenzbMABs(int fontStyle) {
        FontStyle.Companion companion = FontStyle.INSTANCE;
        byte b = 0;
        if (!FontStyle.m20565equalsimpl0(fontStyle, companion.m20572getNormal_LCdwA()) && FontStyle.m20565equalsimpl0(fontStyle, companion.m20571getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    @NotNull
    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final void encode(@NotNull FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    public final void encode(@NotNull TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(@NotNull TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(@NotNull Shadow shadow) {
        m20209encode8_81llA(shadow.getColor());
        encode(Offset.m18284getXimpl(shadow.getOffset()));
        encode(Offset.m18285getYimpl(shadow.getOffset()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    public final void encode(@NotNull String string) {
        this.parcel.writeString(string);
    }
}
