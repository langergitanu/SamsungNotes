package com.vladsch.flexmark.util.misc;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.view.MotionEventCompat;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageObserver;
import java.awt.image.RGBImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImageUtils {
    public static Color TRANSPARENT = new Color(0, 0, 0, 0);
    private static final Pattern BASE64_ENCODING_PATTERN = Pattern.compile("^data:image/[a-z0-9_-]+;base64,", 2);

    public static BufferedImage addBorder(BufferedImage bufferedImage, Color color, int i, int i2) {
        int i4 = i * 2;
        int width = bufferedImage.getWidth() + i4;
        int height = bufferedImage.getHeight() + i4;
        BufferedImage bufferedImage2 = new BufferedImage(width, height, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        graphics2DCreateGraphics.setColor(color);
        graphics2DCreateGraphics.drawImage(bufferedImage, i, i, bufferedImage.getWidth(), bufferedImage.getHeight(), (ImageObserver) null);
        float f = i;
        graphics2DCreateGraphics.setStroke(new BasicStroke(f, 2, 0, f));
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int i5 = (width - i) - 1;
        int i6 = (height - i) - 1;
        int i7 = i / 2;
        if (i2 > 0) {
            int i8 = i2 + i;
            graphics2DCreateGraphics.drawRoundRect(i7, i7, i5, i6, i8, i8);
        } else {
            graphics2DCreateGraphics.drawRect(i7, i7, i5, i6);
        }
        graphics2DCreateGraphics.dispose();
        return bufferedImage2;
    }

    public static BufferedImage base64Decode(File file) {
        String str;
        int iIndexOf;
        if (file != null && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[(int) file.length()];
                if (fileInputStream.read(bArr) != -1 && (iIndexOf = (str = new String(bArr, StandardCharsets.UTF_8)).indexOf(44)) >= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(str.substring(iIndexOf + 1)));
                    BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
                    byteArrayInputStream.close();
                    return bufferedImage;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String base64Encode(BufferedImage bufferedImage) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String strReplace = null;
        try {
            ImageIO.write(bufferedImage, "PNG", byteArrayOutputStream);
            strReplace = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()).replace(StringUtils.f9761CR, "").replace("\n", "");
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AbstractC0541b.m772n("data:image/png;base64,", strReplace);
    }

    public static BufferedImage cropImage(BufferedImage bufferedImage, int i, int i2, int i4, int i5) {
        return bufferedImage.getSubimage(i, i4, (bufferedImage.getWidth() - i) - i2, (bufferedImage.getHeight() - i4) - i5);
    }

    public static BufferedImage drawHighlightOval(BufferedImage bufferedImage, int i, int i2, int i4, int i5, Color color, int i6, Color color2) {
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        boolean z = color2.getAlpha() != 0;
        graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        if (z) {
            graphics2DCreateGraphics.setColor(color2);
            graphics2DCreateGraphics.fillOval(i, i2, i4, i5);
        }
        if (i6 > 0) {
            graphics2DCreateGraphics.setColor(color);
            float f = i6;
            graphics2DCreateGraphics.setStroke(new BasicStroke(f, 2, 0, f));
            graphics2DCreateGraphics.drawOval(i, i2, i4, i5);
        }
        graphics2DCreateGraphics.dispose();
        return bufferedImage2;
    }

    public static BufferedImage drawHighlightRectangle(BufferedImage bufferedImage, int i, int i2, int i4, int i5, Color color, int i6, int i7, Color color2) {
        Graphics2D graphics2D;
        Graphics2D graphics2D2;
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        boolean z = color2.getAlpha() != 0;
        graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        if (i7 > 0) {
            if (z) {
                graphics2DCreateGraphics.setColor(color2);
                graphics2D2 = graphics2DCreateGraphics;
                graphics2D2.fillRoundRect(i, i2, i4, i5, i7, i7);
            } else {
                graphics2D2 = graphics2DCreateGraphics;
            }
            if (i6 > 0) {
                graphics2D2.setColor(color);
                float f = i6;
                graphics2D2.setStroke(new BasicStroke(f, 2, 0, f));
                graphics2D2.drawRoundRect(i, i2, i4, i5, i7, i7);
            }
            graphics2D = graphics2D2;
        } else {
            graphics2D = graphics2DCreateGraphics;
            if (z) {
                graphics2D.setColor(color2);
                graphics2D.fillRect(i, i2, i4, i5);
            }
            if (i6 > 0) {
                graphics2D.setColor(color);
                float f4 = i6;
                graphics2D.setStroke(new BasicStroke(f4, 2, 0, f4));
                graphics2D.drawRect(i, i2, i4, i5);
            }
        }
        graphics2D.dispose();
        return bufferedImage2;
    }

    public static BufferedImage drawOval(BufferedImage bufferedImage, int i, int i2, int i4, int i5, Color color, int i6, float[] fArr, float f) {
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        Color color2 = color == null ? Color.getColor("", ~(bufferedImage.getRGB((i4 / 2) + i, (i5 / 2) + i2) & 16777215)) : color;
        graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        if (fArr != null) {
            float f4 = i6;
            graphics2DCreateGraphics.setStroke(new BasicStroke(f4, 2, 0, f4, fArr, f));
        } else {
            float f5 = i6;
            graphics2DCreateGraphics.setStroke(new BasicStroke(f5, 2, 0, f5));
        }
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreateGraphics.setColor(color2);
        graphics2DCreateGraphics.drawOval(i, i2, i4, i5);
        graphics2DCreateGraphics.dispose();
        return bufferedImage2;
    }

    public static BufferedImage drawRectangle(BufferedImage bufferedImage, int i, int i2, int i4, int i5, Color color, int i6, int i7) {
        return drawRectangle(bufferedImage, i, i2, i4, i5, color, i6, i7, null, 0.0f);
    }

    public static byte[] getImageBytes(BufferedImage bufferedImage) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "PNG", byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Image getImageFromClipboard() {
        return getImageFromTransferable(Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object) null));
    }

    public static Image getImageFromTransferable(Transferable transferable) {
        if (transferable != null) {
            try {
                if (transferable.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    return (Image) transferable.getTransferData(DataFlavor.imageFlavor);
                }
            } catch (IOException unused) {
                throw new RuntimeException();
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isEncodedImage(String str) {
        return str != null && str.startsWith("data:image/") && BASE64_ENCODING_PATTERN.matcher(str).find();
    }

    public static boolean isPossiblyEncodedImage(String str) {
        return str != null && str.startsWith("data:image/");
    }

    public static BufferedImage loadImageFromContent(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
                try {
                    return bufferedImage;
                } catch (IOException e) {
                    return bufferedImage;
                }
            } finally {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException | IndexOutOfBoundsException unused) {
            System.err.print("*");
            System.err.println("could not read from image bytes for " + str);
            try {
                byteArrayInputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public static BufferedImage loadImageFromFile(File file) {
        if (file != null && file.isFile()) {
            for (int i = 0; i < 3; i++) {
                try {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(file);
                        if (i > 0) {
                            System.err.println();
                        }
                        return bufferedImage;
                    } catch (IndexOutOfBoundsException unused) {
                        System.err.print("*");
                        System.err.println("could not read" + file);
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return null;
    }

    public static BufferedImage loadImageFromURL(String str) {
        return loadImageFromURL(str, false);
    }

    public static BufferedImage makeRoundedCorner(BufferedImage bufferedImage, int i, int i2) {
        float f = i;
        if (f == 0.0f) {
            return bufferedImage;
        }
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage bufferedImage2 = new BufferedImage(width, height, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        graphics2DCreateGraphics.setComposite(AlphaComposite.Src);
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreateGraphics.setColor(Color.WHITE);
        graphics2DCreateGraphics.fill(new RoundRectangle2D.Float(0.0f, 0.0f, width, height, f, f));
        graphics2DCreateGraphics.setComposite(AlphaComposite.SrcAtop);
        graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        graphics2DCreateGraphics.dispose();
        return bufferedImage2;
    }

    public static BufferedImage punchOuterHighlightOval(BufferedImage bufferedImage, BufferedImage bufferedImage2, int i, int i2, int i4, int i5, int i6, Color color, int i7, int i8, boolean z) {
        if (color.getAlpha() == 0) {
            return bufferedImage2;
        }
        BufferedImage bufferedImage3 = bufferedImage2 != null ? bufferedImage2 : new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Graphics2D graphics2DCreateGraphics = bufferedImage3.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (bufferedImage2 == null) {
            graphics2DCreateGraphics.setColor(color);
            if (i8 > 0) {
                int i9 = i7 * 2;
                graphics2DCreateGraphics.fillRoundRect(i7, i7, width - i9, height - i9, i8, i8);
            } else {
                int i10 = i7 * 2;
                graphics2DCreateGraphics.fillRect(i7, i7, width - i10, height - i10);
            }
        }
        graphics2DCreateGraphics.setColor(TRANSPARENT);
        graphics2DCreateGraphics.setComposite(AlphaComposite.Src);
        int i11 = i6 / 2;
        graphics2DCreateGraphics.fillOval(Utils.minLimit(0, i - i11), Utils.minLimit(0, i2 - i11), i4 + i6, i5 + i6);
        if (z) {
            graphics2DCreateGraphics.setComposite(AlphaComposite.DstOver);
            graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        }
        graphics2DCreateGraphics.dispose();
        return bufferedImage3;
    }

    public static BufferedImage punchOuterHighlightRectangle(BufferedImage bufferedImage, BufferedImage bufferedImage2, int i, int i2, int i4, int i5, int i6, int i7, Color color, int i8, int i9, boolean z) {
        Graphics2D graphics2D;
        if (color.getAlpha() == 0) {
            return bufferedImage2;
        }
        BufferedImage bufferedImage3 = bufferedImage2 != null ? bufferedImage2 : new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        Graphics2D graphics2DCreateGraphics = bufferedImage3.createGraphics();
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (bufferedImage2 == null) {
            graphics2DCreateGraphics.setColor(color);
            if (i9 > 0) {
                int i10 = i8 * 2;
                graphics2DCreateGraphics.fillRoundRect(i8, i8, width - i10, height - i10, i9, i9);
                graphics2D = graphics2DCreateGraphics;
            } else {
                graphics2D = graphics2DCreateGraphics;
                int i11 = i8 * 2;
                graphics2D.fillRect(i8, i8, width - i11, height - i11);
            }
        } else {
            graphics2D = graphics2DCreateGraphics;
        }
        if (i7 > 0) {
            graphics2D.setColor(TRANSPARENT);
            graphics2D.setComposite(AlphaComposite.Src);
            int i12 = i6 / 2;
            int i13 = i4 + i6;
            int i14 = i5 + i6;
            int i15 = i6 + i7;
            graphics2D.fillRoundRect(Utils.minLimit(0, i - i12), Utils.minLimit(0, i2 - i12), i13, i14, i15, i15);
        } else {
            graphics2D.setColor(TRANSPARENT);
            graphics2D.setComposite(AlphaComposite.Src);
            int i16 = i6 / 2;
            graphics2D.fillRect(Utils.minLimit(0, i - i16), Utils.minLimit(0, i2 - i16), i4 + i6, i5 + i6);
        }
        if (z) {
            graphics2D.setComposite(AlphaComposite.DstOver);
            graphics2D.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        }
        graphics2D.dispose();
        return bufferedImage3;
    }

    public static BufferedImage removeAlpha(BufferedImage bufferedImage) {
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth((ImageObserver) null), bufferedImage.getHeight((ImageObserver) null), 1);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, bufferedImage2.getWidth(), bufferedImage2.getHeight(), Color.WHITE, (ImageObserver) null);
        graphics2DCreateGraphics.dispose();
        return bufferedImage2;
    }

    public static void save(BufferedImage bufferedImage, File file, String str) {
        try {
            ImageIO.write(bufferedImage, str, file);
        } catch (Throwable th) {
            System.out.println("Write error for " + file.getPath() + ": " + th.getMessage());
        }
    }

    public static BufferedImage scaleImage(BufferedImage bufferedImage, int i, int i2, int i4) {
        if (bufferedImage == null || i == 0 || i2 == 0) {
            return null;
        }
        AffineTransform scaleInstance = AffineTransform.getScaleInstance(((double) i) / ((double) bufferedImage.getWidth((ImageObserver) null)), ((double) i2) / ((double) bufferedImage.getHeight((ImageObserver) null)));
        if (i4 == 0) {
            i4 = 2;
        }
        return new AffineTransformOp(scaleInstance, i4).filter(bufferedImage, (BufferedImage) null);
    }

    public static BufferedImage toBufferedImage(Image image) {
        if (image == null) {
            return null;
        }
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        int width = image.getWidth((ImageObserver) null);
        int height = image.getHeight((ImageObserver) null);
        if (width < 0 || height < 0) {
            return null;
        }
        BufferedImage bufferedImage = new BufferedImage(width, height, 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.drawImage(image, 0, 0, (ImageObserver) null);
        graphics2DCreateGraphics.dispose();
        return bufferedImage;
    }

    public static Image toTransparent(BufferedImage bufferedImage, Color color, int i) {
        return Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(bufferedImage.getSource(), new RGBImageFilter(color, i) { // from class: com.vladsch.flexmark.util.misc.ImageUtils.1
            public final int markerRGB;
            final int radius;
            final /* synthetic */ Color val$color;
            final /* synthetic */ int val$tolerance;

            {
                this.val$color = color;
                this.val$tolerance = i;
                this.markerRGB = color.getRGB() | (-16777216);
                this.radius = i * i * 3;
            }

            public final int filterRGB(int i2, int i4, int i5) {
                if (this.val$tolerance == 0 && (i5 | (-16777216)) == this.markerRGB) {
                    return i5 & 16777215;
                }
                if ((i5 & (-16777216)) == -16777216) {
                    int i6 = this.markerRGB;
                    int i7 = ((i5 & 16711680) >> 16) - ((16711680 & i6) >> 16);
                    int i8 = ((i5 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) - ((65280 & i6) >> 8);
                    int i9 = (i5 & 255) - (i6 & 255);
                    if ((i9 * i9) + (i8 * i8) + (i7 * i7) <= this.radius) {
                        return i5 & 16777215;
                    }
                }
                return i5;
            }
        }));
    }

    public static BufferedImage drawRectangle(BufferedImage bufferedImage, int i, int i2, int i4, int i5, Color color, int i6, int i7, float[] fArr, float f) {
        Graphics2D graphics2D;
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 2);
        Graphics2D graphics2DCreateGraphics = bufferedImage2.createGraphics();
        Color color2 = color == null ? Color.getColor("", ~(bufferedImage.getRGB((i4 / 2) + i, (i5 / 2) + i2) & 16777215)) : color;
        graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
        if (fArr != null) {
            float f4 = i6;
            graphics2DCreateGraphics.setStroke(new BasicStroke(f4, 2, 0, f4, fArr, f));
        } else {
            float f5 = i6;
            graphics2DCreateGraphics.setStroke(new BasicStroke(f5, 2, 0, f5));
        }
        graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2DCreateGraphics.setColor(color2);
        if (i7 > 0) {
            graphics2D = graphics2DCreateGraphics;
            graphics2D.drawRoundRect(i, i2, i4, i5, i7, i7);
        } else {
            graphics2D = graphics2DCreateGraphics;
            graphics2D.drawRect(i, i2, i4, i5);
        }
        graphics2D.dispose();
        return bufferedImage2;
    }

    public static BufferedImage loadImageFromURL(String str, boolean z) {
        if (str == null) {
            return null;
        }
        try {
            return toBufferedImage(ImageIO.read(new URL(str)));
        } catch (IOException e) {
            if (!z) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage base64Decode(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                int iIndexOf = str.indexOf(44);
                if (iIndexOf >= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.getDecoder().decode(str.substring(iIndexOf + 1)));
                    BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
                    byteArrayInputStream.close();
                    return bufferedImage;
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String base64Encode(File file) {
        if (file != null && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[(int) file.length()];
                if (fileInputStream.read(bArr) != -1) {
                    return "data:image/png;base64," + Base64.getEncoder().encodeToString(bArr).replace(StringUtils.f9761CR, "").replace("\n", "");
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
