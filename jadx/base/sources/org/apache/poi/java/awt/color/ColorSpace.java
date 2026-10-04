package org.apache.poi.java.awt.color;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.sec.android.diagmonagent.log.provider.utils.DiagMonUtil;
import java.io.Serializable;
import org.apache.poi.sun.java2d.cmm.CMSManager;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ColorSpace implements Serializable {
    public static final int CS_CIEXYZ = 1001;
    public static final int CS_GRAY = 1003;
    public static final int CS_LINEAR_RGB = 1004;
    public static final int CS_PYCC = 1002;
    public static final int CS_sRGB = 1000;
    private static ColorSpace GRAYspace = null;
    private static ColorSpace LINEAR_RGBspace = null;
    private static ColorSpace PYCCspace = null;
    public static final int TYPE_2CLR = 12;
    public static final int TYPE_3CLR = 13;
    public static final int TYPE_4CLR = 14;
    public static final int TYPE_5CLR = 15;
    public static final int TYPE_6CLR = 16;
    public static final int TYPE_7CLR = 17;
    public static final int TYPE_8CLR = 18;
    public static final int TYPE_9CLR = 19;
    public static final int TYPE_ACLR = 20;
    public static final int TYPE_BCLR = 21;
    public static final int TYPE_CCLR = 22;
    public static final int TYPE_CMY = 11;
    public static final int TYPE_CMYK = 9;
    public static final int TYPE_DCLR = 23;
    public static final int TYPE_ECLR = 24;
    public static final int TYPE_FCLR = 25;
    public static final int TYPE_GRAY = 6;
    public static final int TYPE_HLS = 8;
    public static final int TYPE_HSV = 7;
    public static final int TYPE_Lab = 1;
    public static final int TYPE_Luv = 2;
    public static final int TYPE_RGB = 5;
    public static final int TYPE_XYZ = 0;
    public static final int TYPE_YCbCr = 3;
    public static final int TYPE_Yxy = 4;
    private static ColorSpace XYZspace = null;
    private static ColorSpace sRGBspace = null;
    static final long serialVersionUID = -409452704308689724L;
    private transient String[] compName = null;
    private int numComponents;
    private int type;

    public ColorSpace(int i, int i2) {
        this.type = i;
        this.numComponents = i2;
    }

    public static ColorSpace getInstance(int i) {
        ColorSpace colorSpace;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        ColorSpace colorSpace5;
        switch (i) {
            case 1000:
                synchronized (ColorSpace.class) {
                    try {
                        if (sRGBspace == null) {
                            sRGBspace = new ICC_ColorSpace(ICC_Profile.getInstance(1000));
                        }
                        colorSpace = sRGBspace;
                    } finally {
                    }
                    break;
                }
                return colorSpace;
            case 1001:
                synchronized (ColorSpace.class) {
                    try {
                        if (XYZspace == null) {
                            XYZspace = new ICC_ColorSpace(ICC_Profile.getInstance(1001));
                        }
                        colorSpace2 = XYZspace;
                    } finally {
                    }
                    break;
                }
                return colorSpace2;
            case 1002:
                synchronized (ColorSpace.class) {
                    try {
                        if (PYCCspace == null) {
                            PYCCspace = new ICC_ColorSpace(ICC_Profile.getInstance(1002));
                        }
                        colorSpace3 = PYCCspace;
                    } finally {
                    }
                    break;
                }
                return colorSpace3;
            case 1003:
                synchronized (ColorSpace.class) {
                    try {
                        if (GRAYspace == null) {
                            ICC_ColorSpace iCC_ColorSpace = new ICC_ColorSpace(ICC_Profile.getInstance(1003));
                            GRAYspace = iCC_ColorSpace;
                            CMSManager.GRAYspace = iCC_ColorSpace;
                        }
                        colorSpace4 = GRAYspace;
                    } finally {
                    }
                    break;
                }
                return colorSpace4;
            case 1004:
                synchronized (ColorSpace.class) {
                    try {
                        if (LINEAR_RGBspace == null) {
                            ICC_ColorSpace iCC_ColorSpace2 = new ICC_ColorSpace(ICC_Profile.getInstance(1004));
                            LINEAR_RGBspace = iCC_ColorSpace2;
                            CMSManager.LINEAR_RGBspace = iCC_ColorSpace2;
                        }
                        colorSpace5 = LINEAR_RGBspace;
                    } finally {
                    }
                    break;
                }
                return colorSpace5;
            default:
                throw new IllegalArgumentException("Unknown color space");
        }
    }

    public static boolean isCS_CIEXYZ(ColorSpace colorSpace) {
        return colorSpace == XYZspace;
    }

    public abstract float[] fromCIEXYZ(float[] fArr);

    public abstract float[] fromRGB(float[] fArr);

    public float getMaxValue(int i) {
        if (i < 0 || i > this.numComponents - 1) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Component index out of range: "));
        }
        return 1.0f;
    }

    public float getMinValue(int i) {
        if (i < 0 || i > this.numComponents - 1) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Component index out of range: "));
        }
        return 0.0f;
    }

    public String getName(int i) {
        if (i >= 0) {
            int i2 = this.numComponents;
            if (i <= i2 - 1) {
                if (this.compName == null) {
                    switch (this.type) {
                        case 0:
                            this.compName = new String[]{"X", DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, "Z"};
                            break;
                        case 1:
                            this.compName = new String[]{"L", "a", "b"};
                            break;
                        case 2:
                            this.compName = new String[]{"L", CoeditServiceConstants.CacheFilePath.UPDATE_CACHE, VPathDataCmd.RCurveTo};
                            break;
                        case 3:
                            this.compName = new String[]{DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, "Cb", "Cr"};
                            break;
                        case 4:
                            this.compName = new String[]{DiagMonUtil.AGREE_TYPE_SERVICE_LEGACY, "x", "y"};
                            break;
                        case 5:
                            this.compName = new String[]{"Red", "Green", "Blue"};
                            break;
                        case 6:
                            this.compName = new String[]{"Gray"};
                            break;
                        case 7:
                            this.compName = new String[]{"Hue", ExifInterface.TAG_SATURATION, "Value"};
                            break;
                        case 8:
                            this.compName = new String[]{"Hue", "Lightness", ExifInterface.TAG_SATURATION};
                            break;
                        case 9:
                            this.compName = new String[]{"Cyan", "Magenta", "Yellow", "Black"};
                            break;
                        case 10:
                        default:
                            String[] strArr = new String[i2];
                            for (int i4 = 0; i4 < i2; i4++) {
                                strArr[i4] = AbstractC0541b.m767i(i4, "Unnamed color component(", ")");
                            }
                            this.compName = strArr;
                            break;
                        case 11:
                            this.compName = new String[]{"Cyan", "Magenta", "Yellow"};
                            break;
                    }
                }
                return this.compName[i];
            }
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Component index out of range: "));
    }

    public int getNumComponents() {
        return this.numComponents;
    }

    public int getType() {
        return this.type;
    }

    public boolean isCS_sRGB() {
        return this == sRGBspace;
    }

    public abstract float[] toCIEXYZ(float[] fArr);

    public abstract float[] toRGB(float[] fArr);
}
