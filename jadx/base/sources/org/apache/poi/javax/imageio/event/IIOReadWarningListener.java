package org.apache.poi.javax.imageio.event;

import java.util.EventListener;
import org.apache.poi.javax.imageio.ImageReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IIOReadWarningListener extends EventListener {
    void warningOccurred(ImageReader imageReader, String str);
}
