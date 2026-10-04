package org.apache.poi.java.awt;

import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.text.AttributedCharacterIterator;
import java.text.CharacterIterator;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.java.awt.font.FontRenderContext;
import org.apache.poi.java.awt.font.GlyphVector;
import org.apache.poi.java.awt.font.LineMetrics;
import org.apache.poi.java.awt.font.TextAttribute;
import org.apache.poi.java.awt.font.TextLayout;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.peer.FontPeer;
import p001A.AbstractC0000a;
import sun.font.AttributeMap;
import sun.font.AttributeValues;
import sun.font.CompositeFont;
import sun.font.CoreMetrics;
import sun.font.CreatedFontTracker;
import sun.font.EAttribute;
import sun.font.Font2D;
import sun.font.Font2DHandle;
import sun.font.FontAccess;
import sun.font.FontLineMetrics;
import sun.font.FontManager;
import sun.font.FontManagerFactory;
import sun.font.FontUtilities;
import sun.font.GlyphLayout;
import sun.font.StandardGlyphVector;

/* JADX INFO: loaded from: classes10.dex */
public class Font implements Serializable {
    public static final int BOLD = 1;
    public static final int CENTER_BASELINE = 1;
    public static final String DIALOG = "Dialog";
    public static final String DIALOG_INPUT = "DialogInput";
    private static final int EXTRA_MASK;
    public static final int HANGING_BASELINE = 2;
    public static final int ITALIC = 2;
    public static final int LAYOUT_LEFT_TO_RIGHT = 0;
    private static final int LAYOUT_MASK;
    public static final int LAYOUT_NO_LIMIT_CONTEXT = 4;
    public static final int LAYOUT_NO_START_CONTEXT = 2;
    public static final int LAYOUT_RIGHT_TO_LEFT = 1;
    public static final String MONOSPACED = "Monospaced";
    public static final int PLAIN = 0;
    private static final int PRIMARY_MASK;
    private static final int RECOGNIZED_MASK;
    public static final int ROMAN_BASELINE = 0;
    public static final String SANS_SERIF = "SansSerif";
    private static final int SECONDARY_MASK;
    public static final String SERIF = "Serif";
    public static final int TRUETYPE_FONT = 0;
    public static final int TYPE1_FONT = 1;
    private static final AffineTransform identityTx;
    private static final long serialVersionUID = -4206021311591459213L;
    private static final float[] ssinfo;
    private transient boolean createdFont;
    private Hashtable fRequestedAttributes;
    private transient SoftReference flmref;
    private transient Font2DHandle font2DHandle;
    private int fontSerializedDataVersion;
    private transient boolean hasLayoutAttributes;
    transient int hash;
    protected String name;
    private transient boolean nonIdentityTx;
    private transient long pData;
    private transient FontPeer peer;
    protected float pointSize;
    protected int size;
    protected int style;
    private transient AttributeValues values;

    public static class FontAccessImpl extends FontAccess {
        private FontAccessImpl() {
        }

        public Font2D getFont2D(Font font) {
            return font.getFont2D();
        }

        public boolean isCreatedFont(Font font) {
            return font.createdFont;
        }

        public void setCreatedFont(Font font) {
            font.createdFont = true;
        }

        public void setFont2D(Font font, Font2DHandle font2DHandle) {
            font.font2DHandle = font2DHandle;
        }
    }

    static {
        Toolkit.loadLibraries();
        initIDs();
        FontAccess.setFontAccess(new FontAccessImpl());
        identityTx = new AffineTransform();
        int i = AttributeValues.MASK_ALL & (~AttributeValues.getMask(EAttribute.EFONT));
        RECOGNIZED_MASK = i;
        int mask = AttributeValues.getMask(new EAttribute[]{EAttribute.EFAMILY, EAttribute.EWEIGHT, EAttribute.EWIDTH, EAttribute.EPOSTURE, EAttribute.ESIZE, EAttribute.ETRANSFORM, EAttribute.ESUPERSCRIPT, EAttribute.ETRACKING});
        PRIMARY_MASK = mask;
        SECONDARY_MASK = i & (~mask);
        LAYOUT_MASK = AttributeValues.getMask(new EAttribute[]{EAttribute.ECHAR_REPLACEMENT, EAttribute.EFOREGROUND, EAttribute.EBACKGROUND, EAttribute.EUNDERLINE, EAttribute.ESTRIKETHROUGH, EAttribute.ERUN_DIRECTION, EAttribute.EBIDI_EMBEDDING, EAttribute.EJUSTIFICATION, EAttribute.EINPUT_METHOD_HIGHLIGHT, EAttribute.EINPUT_METHOD_UNDERLINE, EAttribute.ESWAP_COLORS, EAttribute.ENUMERIC_SHAPING, EAttribute.EKERNING, EAttribute.ELIGATURES, EAttribute.ETRACKING, EAttribute.ESUPERSCRIPT});
        EXTRA_MASK = AttributeValues.getMask(new EAttribute[]{EAttribute.ETRANSFORM, EAttribute.ESUPERSCRIPT, EAttribute.EWIDTH});
        ssinfo = new float[]{0.0f, 0.375f, 0.625f, 0.7916667f, 0.9027778f, 0.9768519f, 1.0262346f, 1.0591564f};
    }

    private Font(File file, int i, boolean z, CreatedFontTracker createdFontTracker) {
        this.fontSerializedDataVersion = 1;
        this.createdFont = true;
        Font2DHandle font2DHandle = FontManagerFactory.getInstance().createFont2D(file, i, z, createdFontTracker).handle;
        this.font2DHandle = font2DHandle;
        this.name = font2DHandle.font2D.getFontName(Locale.getDefault());
        this.style = 0;
        this.size = 1;
        this.pointSize = 1.0f;
    }

    private static void applyStyle(int i, AttributeValues attributeValues) {
        attributeValues.setWeight((i & 1) != 0 ? 2.0f : 1.0f);
        attributeValues.setPosture((i & 2) != 0 ? 0.2f : 0.0f);
    }

    private static void applyTransform(AffineTransform affineTransform, AttributeValues attributeValues) {
        if (affineTransform == null) {
            throw new IllegalArgumentException("transform must not be null");
        }
        attributeValues.setTransform(affineTransform);
    }

    public static Font createFont(int i, File file) throws IOException {
        File file2 = new File(file.getPath());
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("font format not recognized");
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission(file2.getPath(), "read"));
        }
        if (file2.canRead()) {
            return new Font(file2, i, false, null);
        }
        throw new IOException(AbstractC2322a.m1617g(file2, "Can't read "));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        r11 = new org.apache.poi.java.awt.Font(r1, r10, true, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        if (r12 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        r12.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0087, code lost:
    
        if (r12 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0089, code lost:
    
        r12.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008c, code lost:
    
        if (r0 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008e, code lost:
    
        if (r12 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0090, code lost:
    
        r12.subBytes(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0093, code lost:
    
        java.security.AccessController.doPrivileged(new org.apache.poi.java.awt.Font.C140113());
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009b, code lost:
    
        throw r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Font createFont0(int i, InputStream inputStream, CreatedFontTracker createdFontTracker) throws FontFormatException, IOException {
        boolean z = true;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("font format not recognized");
        }
        try {
            final File file = (File) AccessController.doPrivileged(new PrivilegedExceptionAction<File>() { // from class: org.apache.poi.java.awt.Font.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public File run() {
                    return Files.createTempFile("+~JF", DiskFileUpload.postfix, new FileAttribute[0]).toFile();
                }
            });
            if (createdFontTracker != null) {
                createdFontTracker.add(file);
            }
            int i2 = 0;
            try {
                OutputStream outputStream = (OutputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<OutputStream>() { // from class: org.apache.poi.java.awt.Font.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.security.PrivilegedExceptionAction
                    public OutputStream run() {
                        return new FileOutputStream(file);
                    }
                });
                if (createdFontTracker != null) {
                    createdFontTracker.set(file, outputStream);
                }
                try {
                    try {
                        byte[] bArr = new byte[8192];
                        int i4 = 0;
                        while (true) {
                            try {
                                int i5 = inputStream.read(bArr);
                                if (i5 < 0) {
                                    break;
                                }
                                if (createdFontTracker != null) {
                                    int i6 = i4 + i5;
                                    if (i6 > 33554432) {
                                        throw new IOException("File too big.");
                                    }
                                    if (createdFontTracker.getNumBytes() + i4 > 335544320) {
                                        throw new IOException("Total files too big.");
                                    }
                                    try {
                                        createdFontTracker.addBytes(i5);
                                        i4 = i6;
                                    } catch (Throwable th) {
                                        th = th;
                                        outputStream.close();
                                        throw th;
                                    }
                                }
                                outputStream.write(bArr, 0, i5);
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
        } catch (Throwable th6) {
            if (th6 instanceof FontFormatException) {
                throw ((FontFormatException) th6);
            }
            if (th6 instanceof IOException) {
                throw ((IOException) th6);
            }
            Throwable cause = th6.getCause();
            if (cause instanceof FontFormatException) {
                throw ((FontFormatException) cause);
            }
            throw new IOException("Problem reading font data.");
        }
    }

    public static Font decode(String str) {
        int i;
        String strSubstring;
        int i2;
        int i4;
        int i5;
        int i6 = 12;
        int i7 = 0;
        if (str == null) {
            return new Font(DIALOG, 0, 12);
        }
        char c = str.lastIndexOf(45) <= str.lastIndexOf(32) ? ' ' : '-';
        int iLastIndexOf = str.lastIndexOf(c);
        int iLastIndexOf2 = str.lastIndexOf(c, iLastIndexOf - 1);
        int length = str.length();
        if (iLastIndexOf <= 0 || (i5 = iLastIndexOf + 1) >= length) {
            i = iLastIndexOf;
            iLastIndexOf = iLastIndexOf2;
        } else {
            try {
                int iIntValue = Integer.valueOf(str.substring(i5)).intValue();
                if (iIntValue > 0) {
                    i6 = iIntValue;
                }
                i = iLastIndexOf;
                iLastIndexOf = iLastIndexOf2;
            } catch (NumberFormatException unused) {
                i = str.charAt(length + (-1)) == c ? length - 1 : length;
            }
        }
        if (iLastIndexOf < 0 || (i2 = iLastIndexOf + 1) >= length) {
            if (iLastIndexOf > 0) {
                length = iLastIndexOf;
            } else if (i > 0) {
                length = i;
            }
            if (length > 0 && str.charAt(length - 1) == c) {
                length--;
            }
            strSubstring = str.substring(0, length);
        } else {
            String lowerCase = str.substring(i2, i).toLowerCase(Locale.ENGLISH);
            if (lowerCase.equals("bolditalic")) {
                i4 = 3;
            } else if (lowerCase.equals("italic")) {
                i4 = 2;
            } else if (lowerCase.equals("bold")) {
                i4 = 1;
            } else if (lowerCase.equals("plain")) {
                i4 = 0;
            } else if (str.charAt(i - 1) == c) {
                iLastIndexOf = i - 1;
                i4 = 0;
            } else {
                i4 = 0;
                iLastIndexOf = i;
            }
            strSubstring = str.substring(0, iLastIndexOf);
            i7 = i4;
        }
        return new Font(strSubstring, i7, i6);
    }

    private FontLineMetrics defaultLineMetrics(FontRenderContext fontRenderContext) {
        float f;
        FontLineMetrics fontLineMetrics;
        AffineTransform charTransform;
        SoftReference softReference = this.flmref;
        if (softReference == null || (fontLineMetrics = (FontLineMetrics) softReference.get()) == null || !fontLineMetrics.frc.equals(fontRenderContext)) {
            float[] fArr = new float[8];
            getFont2D().getFontMetrics(this, identityTx, fontRenderContext.getAntiAliasingHint(), fontRenderContext.getFractionalMetricsHint(), fArr);
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            AttributeValues attributeValues = this.values;
            if (attributeValues == null || attributeValues.getSuperscript() == 0) {
                f = 0.0f;
            } else {
                float translateY = (float) getTransform().getTranslateY();
                f4 -= translateY;
                f5 += translateY;
                f = translateY;
            }
            float f7 = f5;
            float f8 = f4 + f7 + f6;
            float[] fArr2 = {0.0f, ((f7 / 2.0f) - f4) / 2.0f, -f4};
            float f9 = fArr[4];
            float f10 = fArr[5];
            float f11 = fArr[6];
            float f12 = fArr[7];
            float italicAngle = getItalicAngle(fontRenderContext);
            if (isTransformed() && (charTransform = this.values.getCharTransform()) != null) {
                Point2D.Float r13 = new Point2D.Float();
                r13.setLocation(0.0f, f9);
                charTransform.deltaTransform(r13, r13);
                f9 = r13.f10133y;
                r13.setLocation(0.0f, f10);
                charTransform.deltaTransform(r13, r13);
                f10 = r13.f10133y;
                r13.setLocation(0.0f, f11);
                charTransform.deltaTransform(r13, r13);
                f11 = r13.f10133y;
                r13.setLocation(0.0f, f12);
                charTransform.deltaTransform(r13, r13);
                f12 = r13.f10133y;
            }
            FontLineMetrics fontLineMetrics2 = new FontLineMetrics(0, new CoreMetrics(f4, f7, f6, f8, 0, fArr2, f9 + f, f10, f11 + f, f12, f, italicAngle), fontRenderContext);
            this.flmref = new SoftReference(fontLineMetrics2);
            fontLineMetrics = fontLineMetrics2;
        }
        return (FontLineMetrics) fontLineMetrics.clone();
    }

    private AttributeValues getAttributeValues() {
        if (this.values == null) {
            AttributeValues attributeValues = new AttributeValues();
            attributeValues.setFamily(this.name);
            attributeValues.setSize(this.pointSize);
            if ((this.style & 1) != 0) {
                attributeValues.setWeight(2.0f);
            }
            if ((this.style & 2) != 0) {
                attributeValues.setPosture(0.2f);
            }
            attributeValues.defineAll(PRIMARY_MASK);
            this.values = attributeValues;
        }
        return this.values;
    }

    public static Font getFont(String str) {
        return getFont(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Font2D getFont2D() {
        Font2DHandle font2DHandle;
        FontManager fontManagerFactory = FontManagerFactory.getInstance();
        if (fontManagerFactory.usingPerAppContextComposites() && (font2DHandle = this.font2DHandle) != null && (font2DHandle.font2D instanceof CompositeFont) && this.font2DHandle.font2D.isStdComposite()) {
            return fontManagerFactory.findFont2D(this.name, this.style, 2);
        }
        if (this.font2DHandle == null) {
            this.font2DHandle = fontManagerFactory.findFont2D(this.name, this.style, 2).handle;
        }
        return this.font2DHandle.font2D;
    }

    private static boolean hasTempPermission() {
        if (System.getSecurityManager() == null) {
            return true;
        }
        try {
            Files.createTempFile("+~JT", DiskFileUpload.postfix, new FileAttribute[0]).toFile().delete();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void initFromValues(AttributeValues attributeValues) {
        this.values = attributeValues;
        attributeValues.defineAll(PRIMARY_MASK);
        this.name = attributeValues.getFamily();
        this.pointSize = attributeValues.getSize();
        this.size = (int) (((double) attributeValues.getSize()) + 0.5d);
        if (attributeValues.getWeight() >= 2.0f) {
            this.style |= 1;
        }
        if (attributeValues.getPosture() >= 0.2f) {
            this.style |= 2;
        }
        this.nonIdentityTx = attributeValues.anyNonDefault(EXTRA_MASK);
        this.hasLayoutAttributes = attributeValues.anyNonDefault(LAYOUT_MASK);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.pointSize == 0.0f) {
            this.pointSize = this.size;
        }
        if (this.fRequestedAttributes != null) {
            this.values = getAttributeValues();
            AttributeValues attributeValuesFromSerializableHashtable = AttributeValues.fromSerializableHashtable(this.fRequestedAttributes);
            if (!AttributeValues.is16Hashtable(this.fRequestedAttributes)) {
                attributeValuesFromSerializableHashtable.unsetDefault();
            }
            AttributeValues attributeValuesMerge = getAttributeValues().merge(attributeValuesFromSerializableHashtable);
            this.values = attributeValuesMerge;
            this.nonIdentityTx = attributeValuesMerge.anyNonDefault(EXTRA_MASK);
            this.hasLayoutAttributes = this.values.anyNonDefault(LAYOUT_MASK);
            this.fRequestedAttributes = null;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        AttributeValues attributeValues = this.values;
        if (attributeValues == null) {
            objectOutputStream.defaultWriteObject();
            return;
        }
        synchronized (attributeValues) {
            this.fRequestedAttributes = this.values.toSerializableHashtable();
            objectOutputStream.defaultWriteObject();
            this.fRequestedAttributes = null;
        }
    }

    public boolean canDisplay(char c) {
        return getFont2D().canDisplay(c);
    }

    public int canDisplayUpTo(String str) {
        Font2D font2D = getFont2D();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (!font2D.canDisplay(cCharAt)) {
                if (!Character.isHighSurrogate(cCharAt) || !font2D.canDisplay(str.codePointAt(i))) {
                    return i;
                }
                i++;
            }
            i++;
        }
        return -1;
    }

    public GlyphVector createGlyphVector(FontRenderContext fontRenderContext, String str) {
        return new StandardGlyphVector(this, str, fontRenderContext);
    }

    public Font deriveFont(float f) {
        if (this.values == null) {
            return new Font(this.name, this.style, f, this.createdFont, this.font2DHandle);
        }
        AttributeValues attributeValuesClone = getAttributeValues().clone();
        attributeValuesClone.setSize(f);
        return new Font(attributeValuesClone, (String) null, -1, this.createdFont, this.font2DHandle);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            Font font = (Font) obj;
            if (this.size != font.size || this.style != font.style || this.nonIdentityTx != font.nonIdentityTx || this.hasLayoutAttributes != font.hasLayoutAttributes || this.pointSize != font.pointSize || !this.name.equals(font.name)) {
                return false;
            }
            AttributeValues attributeValues = this.values;
            if (attributeValues != null) {
                return attributeValues.equals(font.getAttributeValues());
            }
            if (font.values == null) {
                return true;
            }
            return getAttributeValues().equals(font.values);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public Map<TextAttribute, ?> getAttributes() {
        return new AttributeMap(getAttributeValues());
    }

    public AttributedCharacterIterator.Attribute[] getAvailableAttributes() {
        return new AttributedCharacterIterator.Attribute[]{TextAttribute.FAMILY, TextAttribute.WEIGHT, TextAttribute.WIDTH, TextAttribute.POSTURE, TextAttribute.SIZE, TextAttribute.TRANSFORM, TextAttribute.SUPERSCRIPT, TextAttribute.CHAR_REPLACEMENT, TextAttribute.FOREGROUND, TextAttribute.BACKGROUND, TextAttribute.UNDERLINE, TextAttribute.STRIKETHROUGH, TextAttribute.RUN_DIRECTION, TextAttribute.BIDI_EMBEDDING, TextAttribute.JUSTIFICATION, TextAttribute.INPUT_METHOD_HIGHLIGHT, TextAttribute.INPUT_METHOD_UNDERLINE, TextAttribute.SWAP_COLORS, TextAttribute.NUMERIC_SHAPING, TextAttribute.KERNING, TextAttribute.LIGATURES, TextAttribute.TRACKING};
    }

    public byte getBaselineFor(char c) {
        return getFont2D().getBaselineFor(c);
    }

    public String getFamily() {
        return getFamily_NoClientCode();
    }

    public final String getFamily_NoClientCode() {
        return getFamily(Locale.getDefault());
    }

    public String getFontName() {
        return getFontName(Locale.getDefault());
    }

    public float getItalicAngle() {
        return getItalicAngle(null);
    }

    public LineMetrics getLineMetrics(String str, int i, int i2, FontRenderContext fontRenderContext) {
        FontLineMetrics fontLineMetricsDefaultLineMetrics = defaultLineMetrics(fontRenderContext);
        int i4 = i2 - i;
        if (i4 < 0) {
            i4 = 0;
        }
        fontLineMetricsDefaultLineMetrics.numchars = i4;
        return fontLineMetricsDefaultLineMetrics;
    }

    public Rectangle2D getMaxCharBounds(FontRenderContext fontRenderContext) {
        float[] fArr = new float[4];
        getFont2D().getFontMetrics(this, fontRenderContext, fArr);
        float f = fArr[0];
        return new Rectangle2D.Float(0.0f, -f, fArr[3], f + fArr[1] + fArr[2]);
    }

    public int getMissingGlyphCode() {
        return getFont2D().getMissingGlyphCode();
    }

    public String getName() {
        return this.name;
    }

    public int getNumGlyphs() {
        return getFont2D().getNumGlyphs();
    }

    public String getPSName() {
        return getFont2D().getPostscriptName();
    }

    @Deprecated
    public FontPeer getPeer() {
        return getPeer_NoClientCode();
    }

    public final FontPeer getPeer_NoClientCode() {
        if (this.peer == null) {
            this.peer = Toolkit.getDefaultToolkit().getFontPeer(this.name, this.style);
        }
        return this.peer;
    }

    public int getSize() {
        return this.size;
    }

    public float getSize2D() {
        return this.pointSize;
    }

    public Rectangle2D getStringBounds(String str, int i, int i2, FontRenderContext fontRenderContext) {
        return getStringBounds(str.substring(i, i2), fontRenderContext);
    }

    public int getStyle() {
        return this.style;
    }

    public AffineTransform getTransform() {
        if (!this.nonIdentityTx) {
            return new AffineTransform();
        }
        AttributeValues attributeValues = getAttributeValues();
        AffineTransform affineTransform = attributeValues.isNonDefault(EAttribute.ETRANSFORM) ? new AffineTransform(attributeValues.getTransform()) : new AffineTransform();
        if (attributeValues.getSuperscript() != 0) {
            int superscript = attributeValues.getSuperscript();
            int i = 0;
            boolean z = superscript > 0;
            int i2 = z ? -1 : 1;
            if (!z) {
                superscript = -superscript;
            }
            double d = 0.0d;
            while (true) {
                int i4 = superscript & 7;
                if (i4 <= i) {
                    break;
                }
                float[] fArr = ssinfo;
                d += (double) ((fArr[i4] - fArr[i]) * i2);
                superscript >>= 3;
                i2 = -i2;
                i = i4;
            }
            double d2 = d * ((double) this.pointSize);
            double dPow = Math.pow(0.6666666666666666d, i);
            affineTransform.preConcatenate(AffineTransform.getTranslateInstance(0.0d, d2));
            affineTransform.scale(dPow, dPow);
        }
        if (attributeValues.isNonDefault(EAttribute.EWIDTH)) {
            affineTransform.scale(attributeValues.getWidth(), 1.0d);
        }
        return affineTransform;
    }

    public boolean hasLayoutAttributes() {
        return this.hasLayoutAttributes;
    }

    public boolean hasUniformLineMetrics() {
        return false;
    }

    public int hashCode() {
        AttributeValues attributeValues;
        if (this.hash == 0) {
            this.hash = (this.name.hashCode() ^ this.style) ^ this.size;
            if (this.nonIdentityTx && (attributeValues = this.values) != null && attributeValues.getTransform() != null) {
                this.hash ^= this.values.getTransform().hashCode();
            }
        }
        return this.hash;
    }

    public boolean isBold() {
        return (this.style & 1) != 0;
    }

    public boolean isItalic() {
        return (this.style & 2) != 0;
    }

    public boolean isPlain() {
        return this.style == 0;
    }

    public boolean isTransformed() {
        return this.nonIdentityTx;
    }

    public GlyphVector layoutGlyphVector(FontRenderContext fontRenderContext, char[] cArr, int i, int i2, int i4) {
        GlyphLayout glyphLayout = GlyphLayout.get((GlyphLayout.LayoutEngineFactory) null);
        StandardGlyphVector standardGlyphVectorLayout = glyphLayout.layout(this, fontRenderContext, cArr, i, i2 - i, i4, (StandardGlyphVector) null);
        GlyphLayout.done(glyphLayout);
        return standardGlyphVectorLayout;
    }

    public String toString() {
        String str = isBold() ? isItalic() ? "bolditalic" : "bold" : isItalic() ? "italic" : "plain";
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[family=");
        sb.append(getFamily());
        sb.append(",name=");
        AbstractC2821a.m2207B(sb, this.name, ",style=", str, ",size=");
        return AbstractC2821a.m2223n(sb, "]", this.size);
    }

    private Font(String str, int i, float f) {
        this.createdFont = false;
        this.fontSerializedDataVersion = 1;
        this.name = str == null ? AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME : str;
        this.style = (i & (-4)) != 0 ? 0 : i;
        this.size = (int) (((double) f) + 0.5d);
        this.pointSize = f;
    }

    public static Font getFont(String str, Font font) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? font : decode(property);
    }

    private float getItalicAngle(FontRenderContext fontRenderContext) {
        Object fractionalMetricsHint;
        Object obj;
        if (fontRenderContext == null) {
            obj = RenderingHints.VALUE_TEXT_ANTIALIAS_OFF;
            fractionalMetricsHint = RenderingHints.VALUE_FRACTIONALMETRICS_OFF;
        } else {
            Object antiAliasingHint = fontRenderContext.getAntiAliasingHint();
            fractionalMetricsHint = fontRenderContext.getFractionalMetricsHint();
            obj = antiAliasingHint;
        }
        return getFont2D().getItalicAngle(this, identityTx, obj, fractionalMetricsHint);
    }

    public boolean canDisplay(int i) {
        if (Character.isValidCodePoint(i)) {
            return getFont2D().canDisplay(i);
        }
        throw new IllegalArgumentException(AbstractC1974b.m1316i(i, new StringBuilder("invalid code point: ")));
    }

    public int canDisplayUpTo(CharacterIterator characterIterator, int i, int i2) {
        Font2D font2D = getFont2D();
        char index = characterIterator.setIndex(i);
        while (i < i2) {
            if (!font2D.canDisplay(index)) {
                if (Character.isHighSurrogate(index)) {
                    char next = characterIterator.next();
                    if (Character.isLowSurrogate(next) && font2D.canDisplay(Character.toCodePoint(index, next))) {
                        i++;
                    }
                }
                return i;
            }
            i++;
            index = characterIterator.next();
        }
        return -1;
    }

    public GlyphVector createGlyphVector(FontRenderContext fontRenderContext, CharacterIterator characterIterator) {
        return new StandardGlyphVector(this, characterIterator, fontRenderContext);
    }

    public Font deriveFont(int i) {
        if (this.values == null) {
            return new Font(this.name, i, this.size, this.createdFont, this.font2DHandle);
        }
        AttributeValues attributeValuesClone = getAttributeValues().clone();
        int i2 = this.style;
        if (i2 == i) {
            i2 = -1;
        }
        applyStyle(i, attributeValuesClone);
        return new Font(attributeValuesClone, (String) null, i2, this.createdFont, this.font2DHandle);
    }

    public String getFamily(Locale locale) {
        if (locale != null) {
            return getFont2D().getFamilyName(locale);
        }
        throw new NullPointerException("null locale doesn't mean default");
    }

    public String getFontName(Locale locale) {
        if (locale != null) {
            return getFont2D().getFontName(locale);
        }
        throw new NullPointerException("null locale doesn't mean default");
    }

    public LineMetrics getLineMetrics(String str, FontRenderContext fontRenderContext) {
        FontLineMetrics fontLineMetricsDefaultLineMetrics = defaultLineMetrics(fontRenderContext);
        fontLineMetricsDefaultLineMetrics.numchars = str.length();
        return fontLineMetricsDefaultLineMetrics;
    }

    public Rectangle2D getStringBounds(String str, FontRenderContext fontRenderContext) {
        char[] charArray = str.toCharArray();
        return getStringBounds(charArray, 0, charArray.length, fontRenderContext);
    }

    private Font(String str, int i, float f, boolean z, Font2DHandle font2DHandle) {
        this(str, i, f);
        this.createdFont = z;
        if (z) {
            if (!(font2DHandle.font2D instanceof CompositeFont) || font2DHandle.font2D.getStyle() == i) {
                this.font2DHandle = font2DHandle;
            } else {
                this.font2DHandle = FontManagerFactory.getInstance().getNewComposite((String) null, i, font2DHandle);
            }
        }
    }

    public static Font getFont(Map<? extends AttributedCharacterIterator.Attribute, ?> map) {
        if (map instanceof AttributeMap) {
            AttributeMap attributeMap = (AttributeMap) map;
            if (attributeMap.getValues() != null) {
                AttributeValues values = attributeMap.getValues();
                if (!values.isNonDefault(EAttribute.EFONT)) {
                    return new Font(map);
                }
                Font font = values.getFont();
                int i = SECONDARY_MASK;
                if (!values.anyDefined(i)) {
                    return font;
                }
                AttributeValues attributeValuesClone = font.getAttributeValues().clone();
                attributeValuesClone.merge(map, i);
                return new Font(attributeValuesClone, font.name, font.style, font.createdFont, font.font2DHandle);
            }
        }
        Font font2 = (Font) map.get(TextAttribute.FONT);
        if (font2 == null) {
            return new Font(map);
        }
        if (map.size() <= 1) {
            return font2;
        }
        AttributeValues attributeValuesClone2 = font2.getAttributeValues().clone();
        attributeValuesClone2.merge(map, SECONDARY_MASK);
        return new Font(attributeValuesClone2, font2.name, font2.style, font2.createdFont, font2.font2DHandle);
    }

    public int canDisplayUpTo(char[] cArr, int i, int i2) {
        Font2D font2D = getFont2D();
        while (i < i2) {
            char c = cArr[i];
            if (!font2D.canDisplay(c)) {
                if (!Character.isHighSurrogate(c) || !font2D.canDisplay(Character.codePointAt(cArr, i, i2))) {
                    return i;
                }
                i++;
            }
            i++;
        }
        return -1;
    }

    public GlyphVector createGlyphVector(FontRenderContext fontRenderContext, char[] cArr) {
        return new StandardGlyphVector(this, cArr, fontRenderContext);
    }

    public Font deriveFont(int i, float f) {
        if (this.values == null) {
            return new Font(this.name, i, f, this.createdFont, this.font2DHandle);
        }
        AttributeValues attributeValuesClone = getAttributeValues().clone();
        int i2 = this.style;
        if (i2 == i) {
            i2 = -1;
        }
        applyStyle(i, attributeValuesClone);
        attributeValuesClone.setSize(f);
        return new Font(attributeValuesClone, (String) null, i2, this.createdFont, this.font2DHandle);
    }

    public LineMetrics getLineMetrics(CharacterIterator characterIterator, int i, int i2, FontRenderContext fontRenderContext) {
        FontLineMetrics fontLineMetricsDefaultLineMetrics = defaultLineMetrics(fontRenderContext);
        int i4 = i2 - i;
        if (i4 < 0) {
            i4 = 0;
        }
        fontLineMetricsDefaultLineMetrics.numchars = i4;
        return fontLineMetricsDefaultLineMetrics;
    }

    public Rectangle2D getStringBounds(CharacterIterator characterIterator, int i, int i2, FontRenderContext fontRenderContext) {
        int beginIndex = characterIterator.getBeginIndex();
        int endIndex = characterIterator.getEndIndex();
        if (i < beginIndex) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "beginIndex: "));
        }
        if (i2 > endIndex) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i2, "limit: "));
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException("range length: " + (i2 - i));
        }
        int i4 = i2 - i;
        char[] cArr = new char[i4];
        characterIterator.setIndex(i);
        for (int i5 = 0; i5 < i4; i5++) {
            cArr[i5] = characterIterator.current();
            characterIterator.next();
        }
        return getStringBounds(cArr, 0, i4, fontRenderContext);
    }

    public Font(String str, int i, int i2) {
        this.createdFont = false;
        this.fontSerializedDataVersion = 1;
        this.name = str == null ? AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME : str;
        this.style = (i & (-4)) != 0 ? 0 : i;
        this.size = i2;
        this.pointSize = i2;
    }

    public GlyphVector createGlyphVector(FontRenderContext fontRenderContext, int[] iArr) {
        return new StandardGlyphVector(this, iArr, fontRenderContext);
    }

    public Font deriveFont(int i, AffineTransform affineTransform) {
        AttributeValues attributeValuesClone = getAttributeValues().clone();
        int i2 = this.style;
        if (i2 == i) {
            i2 = -1;
        }
        int i4 = i2;
        applyStyle(i, attributeValuesClone);
        applyTransform(affineTransform, attributeValuesClone);
        return new Font(attributeValuesClone, (String) null, i4, this.createdFont, this.font2DHandle);
    }

    public LineMetrics getLineMetrics(char[] cArr, int i, int i2, FontRenderContext fontRenderContext) {
        FontLineMetrics fontLineMetricsDefaultLineMetrics = defaultLineMetrics(fontRenderContext);
        int i4 = i2 - i;
        if (i4 < 0) {
            i4 = 0;
        }
        fontLineMetricsDefaultLineMetrics.numchars = i4;
        return fontLineMetricsDefaultLineMetrics;
    }

    public Font(Map<? extends AttributedCharacterIterator.Attribute, ?> map) {
        this.createdFont = false;
        this.fontSerializedDataVersion = 1;
        initFromValues(AttributeValues.fromMap(map, RECOGNIZED_MASK));
    }

    public Font deriveFont(Map<? extends AttributedCharacterIterator.Attribute, ?> map) {
        if (map == null) {
            return this;
        }
        AttributeValues attributeValuesClone = getAttributeValues().clone();
        attributeValuesClone.merge(map, RECOGNIZED_MASK);
        return new Font(attributeValuesClone, this.name, this.style, this.createdFont, this.font2DHandle);
    }

    public Font(Font font) {
        this.createdFont = false;
        this.fontSerializedDataVersion = 1;
        if (font.values != null) {
            initFromValues(font.getAttributeValues().clone());
        } else {
            this.name = font.name;
            this.style = font.style;
            this.size = font.size;
            this.pointSize = font.pointSize;
        }
        this.font2DHandle = font.font2DHandle;
        this.createdFont = font.createdFont;
    }

    public Font deriveFont(AffineTransform affineTransform) {
        AttributeValues attributeValuesClone = getAttributeValues().clone();
        applyTransform(affineTransform, attributeValuesClone);
        return new Font(attributeValuesClone, (String) null, -1, this.createdFont, this.font2DHandle);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Font(AttributeValues attributeValues, String str, int i, boolean z, Font2DHandle font2DHandle) {
        this.fontSerializedDataVersion = 1;
        this.createdFont = z;
        if (z) {
            this.font2DHandle = font2DHandle;
            if (str != null) {
                String family = attributeValues.getFamily();
                family = str.equals(family) ? null : family;
                if (i != -1) {
                    int i2 = attributeValues.getWeight() < 2.0f ? 0 : 1;
                    i2 = attributeValues.getPosture() >= 0.2f ? i2 | 2 : i2;
                    i2 = i == i2 ? -1 : i2;
                    if (font2DHandle.font2D instanceof CompositeFont) {
                        if (i2 != -1 || family != null) {
                            this.font2DHandle = FontManagerFactory.getInstance().getNewComposite(family, i2, font2DHandle);
                        }
                    } else if (family != null) {
                        this.createdFont = false;
                        this.font2DHandle = null;
                    }
                }
            }
        }
        initFromValues(attributeValues);
    }

    public static Font createFont(int i, InputStream inputStream) {
        if (hasTempPermission()) {
            return createFont0(i, inputStream, null);
        }
        CreatedFontTracker tracker = CreatedFontTracker.getTracker();
        try {
            try {
                boolean zAcquirePermit = tracker.acquirePermit();
                if (!zAcquirePermit) {
                    throw new IOException("Timed out waiting for resources.");
                }
                Font fontCreateFont0 = createFont0(i, inputStream, tracker);
                if (zAcquirePermit) {
                    tracker.releasePermit();
                }
                return fontCreateFont0;
            } catch (InterruptedException unused) {
                throw new IOException("Problem reading font data.");
            }
        } catch (Throwable th) {
            if (0 != 0) {
                tracker.releasePermit();
            }
            throw th;
        }
    }

    public Rectangle2D getStringBounds(char[] cArr, int i, int i2, FontRenderContext fontRenderContext) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "beginIndex: "));
        }
        if (i2 > cArr.length) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i2, "limit: "));
        }
        if (i > i2) {
            throw new IndexOutOfBoundsException("range length: " + (i2 - i));
        }
        AttributeValues attributeValues = this.values;
        boolean z = attributeValues == null || (attributeValues.getKerning() == 0 && this.values.getLigatures() == 0 && this.values.getBaselineTransform() == null);
        if (z) {
            z = !FontUtilities.isComplexText(cArr, i, i2);
        }
        if (z) {
            return new StandardGlyphVector(this, cArr, i, i2 - i, fontRenderContext).getLogicalBounds();
        }
        TextLayout textLayout = new TextLayout(new String(cArr, i, i2 - i), this, fontRenderContext);
        return new Rectangle2D.Float(0.0f, -textLayout.getAscent(), textLayout.getAdvance(), textLayout.getAscent() + textLayout.getDescent() + textLayout.getLeading());
    }
}
