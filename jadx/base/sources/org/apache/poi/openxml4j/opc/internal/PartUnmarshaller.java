package org.apache.poi.openxml4j.opc.internal;

import java.io.InputStream;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface PartUnmarshaller {
    PackagePart unmarshall(UnmarshallContext unmarshallContext, InputStream inputStream);
}
