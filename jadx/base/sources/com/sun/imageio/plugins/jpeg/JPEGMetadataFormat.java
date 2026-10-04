package com.sun.imageio.plugins.jpeg;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import com.vladsch.flexmark.util.html.Attribute;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGQTable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class JPEGMetadataFormat extends IIOMetadataFormatImpl {
    private static final int MAX_JPEG_DATA_SIZE = 65533;
    String resourceBaseName;

    public JPEGMetadataFormat(String str, int i) {
        super(str, i);
        String strConcat = getClass().getName().concat("Resources");
        this.resourceBaseName = strConcat;
        setResourceBaseName(strConcat);
    }

    public void addStreamElements(String str) {
        addElement("dqt", str, 1, 4);
        addElement("dqtable", "dqt", 0);
        addAttribute("dqtable", "elementPrecision", 2, false, "0");
        ArrayList arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        addAttribute("dqtable", "qtableId", 2, true, (String) null, (List<String>) arrayList);
        addObjectValue("dqtable", (Class<Object>) JPEGQTable.class, true, (Object) null);
        addElement("dht", str, 1, 4);
        addElement("dhtable", "dht", 0);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("0");
        arrayList2.add("1");
        addAttribute("dhtable", Attribute.CLASS_ATTR, 2, true, (String) null, (List<String>) arrayList2);
        addAttribute("dhtable", "htableId", 2, true, (String) null, (List<String>) arrayList);
        addObjectValue("dhtable", (Class<Object>) JPEGHuffmanTable.class, true, (Object) null);
        addElement("dri", str, 0);
        addAttribute("dri", MicrosoftAuthorizationResponse.INTERVAL, 2, true, null, "0", "65535", true, true);
        addElement("com", str, 0);
        addAttribute("com", ClientCookie.COMMENT_ATTR, 0, false, null);
        addObjectValue("com", byte[].class, 1, 65533);
        addElement("unknown", str, 0);
        addAttribute("unknown", "MarkerTag", 2, true, null, "0", "255", true, true);
        addObjectValue("unknown", byte[].class, 1, 65533);
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl, org.apache.poi.javax.imageio.metadata.IIOMetadataFormat
    public boolean canNodeAppear(String str, ImageTypeSpecifier imageTypeSpecifier) {
        return isInSubtree(str, getRootName());
    }

    public boolean isInSubtree(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        for (String str3 : getChildNames(str)) {
            if (isInSubtree(str, str3)) {
                return true;
            }
        }
        return false;
    }
}
