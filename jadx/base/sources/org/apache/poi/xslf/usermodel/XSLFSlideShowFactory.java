package org.apache.poi.xslf.usermodel;

import java.io.File;
import java.io.InputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.p226sl.usermodel.SlideShow;
import org.apache.poi.p226sl.usermodel.SlideShowFactory;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class XSLFSlideShowFactory extends SlideShowFactory {
    public static SlideShow<?, ?> createSlideShow(OPCPackage oPCPackage) {
        try {
            return new XMLSlideShow(oPCPackage);
        } catch (IllegalArgumentException e) {
            oPCPackage.revert();
            throw e;
        }
    }

    public static SlideShow<?, ?> createSlideShow(File file, boolean z) {
        return createSlideShow(OPCPackage.open(file, z ? PackageAccess.READ : PackageAccess.READ_WRITE));
    }

    public static SlideShow<?, ?> createSlideShow(InputStream inputStream) {
        return createSlideShow(OPCPackage.open(inputStream));
    }
}
