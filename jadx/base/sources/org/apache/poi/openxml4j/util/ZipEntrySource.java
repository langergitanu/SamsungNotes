package org.apache.poi.openxml4j.util;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ZipEntrySource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    Enumeration<? extends ZipEntry> getEntries();

    InputStream getInputStream(ZipEntry zipEntry);

    boolean isClosed();
}
