package org.apache.poi.p226sl.image;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.javax.imageio.ImageIO;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.Units;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ImageHeaderBitmap {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ImageHeaderBitmap.class);
    private final Dimension size;

    public ImageHeaderBitmap(byte[] bArr, int i) {
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new ByteArrayInputStream(bArr, i, bArr.length - i));
        } catch (IOException e) {
            LOG.log(5, "Can't determine image dimensions", e);
            bufferedImage = null;
        }
        this.size = bufferedImage == null ? new Dimension(200, 200) : new Dimension((int) Units.pixelToPoints(bufferedImage.getWidth()), (int) Units.pixelToPoints(bufferedImage.getHeight()));
    }

    public Dimension getSize() {
        return this.size;
    }
}
