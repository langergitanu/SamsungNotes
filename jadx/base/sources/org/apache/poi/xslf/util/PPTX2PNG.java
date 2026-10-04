package org.apache.poi.xslf.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.RenderingHints;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.javax.imageio.ImageIO;
import org.apache.poi.p226sl.usermodel.Slide;
import org.apache.poi.p226sl.usermodel.SlideShow;
import org.apache.poi.p226sl.usermodel.SlideShowFactory;
import org.apache.poi.sl.draw.DrawFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PPTX2PNG {
    public static void main(String[] strArr) throws Throwable {
        SlideShow<?, ?> slideShow;
        List list;
        boolean z;
        String string;
        if (strArr.length == 0) {
            usage(null);
            return;
        }
        int i = 0;
        File file = null;
        File parentFile = null;
        String str = Constants.THUMBNAIL_PNG_EXTENSION;
        float f = 1.0f;
        String str2 = "-1";
        boolean z2 = false;
        while (i < strArr.length) {
            if (!strArr[i].startsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                file = new File(strArr[i]);
            } else if ("-scale".equals(strArr[i])) {
                i++;
                f = Float.parseFloat(strArr[i]);
            } else if ("-slide".equals(strArr[i])) {
                i++;
                str2 = strArr[i];
            } else if ("-format".equals(strArr[i])) {
                i++;
                str = strArr[i];
            } else if ("-outdir".equals(strArr[i])) {
                i++;
                parentFile = new File(strArr[i]);
            } else if ("-quiet".equals(strArr[i])) {
                z2 = true;
            }
            i++;
        }
        if (file == null || !file.exists()) {
            usage("File not specified or it doesn't exist");
            return;
        }
        if (str == null || !str.matches("^(png|gif|jpg|null)$")) {
            usage("Invalid format given");
            return;
        }
        if (parentFile == null) {
            parentFile = file.getParentFile();
        }
        if (!"null".equals(str) && (parentFile == null || !parentFile.exists() || !parentFile.isDirectory())) {
            usage("Output directory doesn't exist");
            return;
        }
        if (f < 0.0f) {
            usage("Invalid scale given");
            return;
        }
        if (!z2) {
            System.out.println("Processing " + file);
        }
        SlideShow<?, ?> slideShowCreate = SlideShowFactory.create(file, null, true);
        try {
            List slides = slideShowCreate.getSlides();
            Set<Integer> setSlideIndexes = slideIndexes(slides.size(), str2);
            if (setSlideIndexes.isEmpty()) {
                usage("slidenum must be either -1 (for all) or within range: [1.." + slides.size() + "] for " + file);
                slideShowCreate.close();
                return;
            }
            Dimension pageSize = slideShowCreate.getPageSize();
            int i2 = (int) (pageSize.width * f);
            int i4 = (int) (pageSize.height * f);
            Iterator<Integer> it = setSlideIndexes.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                Slide slide = (Slide) slides.get(next.intValue());
                String title = slide.getTitle();
                if (z2) {
                    slideShow = slideShowCreate;
                    list = slides;
                    z = z2;
                } else {
                    PrintStream printStream = System.out;
                    slideShow = slideShowCreate;
                    try {
                        StringBuilder sb = new StringBuilder();
                        list = slides;
                        sb.append("Rendering slide ");
                        sb.append(next);
                        if (title == null) {
                            z = z2;
                            string = "";
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            z = z2;
                            sb2.append(": ");
                            sb2.append(title);
                            string = sb2.toString();
                        }
                        sb.append(string);
                        printStream.println(sb.toString());
                    } catch (Throwable th) {
                        th = th;
                        slideShow.close();
                        throw th;
                    }
                }
                BufferedImage bufferedImage = new BufferedImage(i2, i4, 2);
                Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
                DrawFactory.getInstance(graphics2DCreateGraphics).fixFonts(graphics2DCreateGraphics);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                graphics2DCreateGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                Iterator<Integer> it2 = it;
                double d = f;
                graphics2DCreateGraphics.scale(d, d);
                slide.draw(graphics2DCreateGraphics);
                if (!"null".equals(str)) {
                    ImageIO.write(bufferedImage, str, new File(parentFile, String.format(Locale.ROOT, "%1$s-%2$04d.%3$s", file.getName().replaceFirst(".pptx?", ""), next, str)));
                }
                graphics2DCreateGraphics.dispose();
                bufferedImage.flush();
                slideShowCreate = slideShow;
                it = it2;
                slides = list;
                z2 = z;
            }
            boolean z3 = z2;
            slideShowCreate.close();
            if (z3) {
                return;
            }
            System.out.println("Done");
        } catch (Throwable th2) {
            th = th2;
            slideShow = slideShowCreate;
        }
    }

    private static Set<Integer> slideIndexes(int i, String str) {
        TreeSet treeSet = new TreeSet();
        if ("-1".equals(str)) {
            for (int i2 = 0; i2 < i; i2++) {
                treeSet.add(Integer.valueOf(i2));
            }
        } else {
            for (String str2 : str.split(",")) {
                String[] strArrSplit = str2.split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                int length = strArrSplit.length;
                if (length == 1) {
                    int i4 = Integer.parseInt(strArrSplit[0]);
                    if (str2.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                        int i5 = str2.startsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? 0 : i4;
                        int iMin = str2.endsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) ? i : Math.min(i4, i);
                        for (int iMax = Math.max(i5, 1); iMax < iMin; iMax++) {
                            treeSet.add(Integer.valueOf(iMax - 1));
                        }
                    } else {
                        treeSet.add(Integer.valueOf(Math.max(i4, 1) - 1));
                    }
                } else if (length == 2) {
                    int iMin2 = Math.min(Integer.parseInt(strArrSplit[0]), i);
                    int iMin3 = Math.min(Integer.parseInt(strArrSplit[1]), i);
                    for (int iMax2 = Math.max(iMin2, 1); iMax2 < iMin3; iMax2++) {
                        treeSet.add(Integer.valueOf(iMax2 - 1));
                    }
                }
            }
        }
        return treeSet;
    }

    public static void usage(String str) {
        System.out.println(AbstractC0622a.m1170p(str == null ? "" : AbstractC0541b.m773o("Error: ", str, "\n"), "Options:\n    -scale <float>   scale factor\n    -slide <integer> 1-based index of a slide to render\n    -format <type>   png,gif,jpg (,null for testing)    -outdir <dir>    output directory, defaults to origin of the ppt/pptx file    -quiet           do not write to console (for normal processing)", new StringBuilder("Usage: PPTX2PNG [options] <ppt or pptx file>\n")));
    }
}
