package com.sun.imageio.plugins.jpeg;

import java.util.ListResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
abstract class JPEGMetadataFormatResources extends ListResourceBundle {
    static final Object[][] commonContents = {new Object[]{"dqt", "A Define Quantization Table(s) marker segment"}, new Object[]{"dqtable", "A single quantization table"}, new Object[]{"dht", "A Define Huffman Table(s) marker segment"}, new Object[]{"dhtable", "A single Huffman table"}, new Object[]{"dri", "A Define Restart Interval marker segment"}, new Object[]{"com", "A Comment marker segment.  The user object contains the actual bytes."}, new Object[]{"unknown", "An unrecognized marker segment.  The user object contains the data not including length."}, new Object[]{"dqtable/elementPrecision", "The number of bits in each table element (0 = 8, 1 = 16)"}, new Object[]{"dgtable/qtableId", "The table id"}, new Object[]{"dhtable/class", "Indicates whether this is a DC (0) or an AC (1) table"}, new Object[]{"dhtable/htableId", "The table id"}, new Object[]{"dri/interval", "The restart interval in MCUs"}, new Object[]{"com/comment", "The comment as a string (used only if user object is null)"}, new Object[]{"unknown/MarkerTag", "The tag identifying this marker segment"}};
}
