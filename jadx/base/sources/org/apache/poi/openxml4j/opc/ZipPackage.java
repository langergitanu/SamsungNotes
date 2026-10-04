package org.apache.poi.openxml4j.opc;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.poi.UnsupportedFileFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.ODFNotOfficeXmlFileException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.internal.ContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.apache.poi.openxml4j.opc.internal.MemoryPackagePart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipContentTypeManager;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.opc.internal.marshallers.ZipPartMarshaller;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.openxml4j.util.ZipFileZipEntrySource;
import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ZipPackage extends OPCPackage {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) ZipPackage.class);
    private static final String MIMETYPE = "mimetype";
    private static final String SETTINGS_XML = "settings.xml";
    private final ZipEntrySource zipArchive;

    public ZipPackage() {
        super(OPCPackage.defaultPackageAccess);
        this.zipArchive = null;
        try {
            this.contentTypeManager = new ZipContentTypeManager(null, this);
        } catch (InvalidFormatException e) {
            LOG.log(5, "Could not parse ZipPackage", e);
        }
    }

    private PackagePartName buildPartName(ZipEntry zipEntry) {
        try {
            if (zipEntry.getName().equalsIgnoreCase(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                return null;
            }
            return PackagingURIHelper.createPartName(ZipHelper.getOPCNameFromZipItemName(zipEntry.getName()));
        } catch (Exception e) {
            LOG.log(5, "Entry " + zipEntry.getName() + " is not valid, so this part won't be add to the package.", e);
            return null;
        }
    }

    private synchronized String generateTempFileName(File file) {
        File file2;
        do {
            file2 = new File(file.getAbsoluteFile() + File.separator + "OpenXML4J" + System.nanoTime());
        } while (file2.exists());
        return FileHelper.getFilename(file2.getAbsoluteFile());
    }

    private static ZipEntrySource openZipEntrySourceStream(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                return openZipEntrySourceStream(fileInputStream);
            } catch (Exception e) {
                IOUtils.closeQuietly(fileInputStream);
                if (e instanceof InvalidOperationException) {
                    throw ((InvalidOperationException) e);
                }
                throw new InvalidOperationException("Failed to read the file input stream from file: '" + file + "'", e);
            }
        } catch (FileNotFoundException e2) {
            throw new InvalidOperationException("Can't open the specified file input stream from file: '" + file + "'", e2);
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void closeImpl() {
        flush();
        String str = this.originalPackagePath;
        if (str == null || "".equals(str)) {
            return;
        }
        File file = new File(this.originalPackagePath);
        if (!file.exists()) {
            throw new InvalidOperationException("Can't close a package not previously open with the open() method !");
        }
        File fileCreateTempFile = TempFile.createTempFile(generateTempFileName(FileHelper.getDirectory(file)), DiskFileUpload.postfix);
        try {
            save(fileCreateTempFile);
            IOUtils.closeQuietly(this.zipArchive);
            try {
                FileHelper.copyFile(fileCreateTempFile, file);
            } finally {
                if (!fileCreateTempFile.delete()) {
                    LOG.log(5, "The temporary file: '" + file.getAbsolutePath() + "' cannot be deleted ! Make sure that no other application use it.");
                }
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(this.zipArchive);
            try {
                FileHelper.copyFile(fileCreateTempFile, file);
                if (!fileCreateTempFile.delete()) {
                    LOG.log(5, "The temporary file: '" + file.getAbsolutePath() + "' cannot be deleted ! Make sure that no other application use it.");
                }
                throw th;
            } finally {
                if (!fileCreateTempFile.delete()) {
                    LOG.log(5, "The temporary file: '" + file.getAbsolutePath() + "' cannot be deleted ! Make sure that no other application use it.");
                }
            }
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePart createPartImpl(PackagePartName packagePartName, String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("contentType");
        }
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        try {
            return new MemoryPackagePart(this, packagePartName, str, z);
        } catch (InvalidFormatException e) {
            LOG.log(5, e);
            return null;
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePart getPartImpl(PackagePartName packagePartName) {
        if (this.partList.containsKey(packagePartName)) {
            return this.partList.get(packagePartName);
        }
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.UnsupportedFileFormatException */
    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public PackagePart[] getPartsImpl() throws UnsupportedFileFormatException, InvalidFormatException {
        String contentType;
        String contentType2;
        if (this.partList == null) {
            this.partList = new PackagePartCollection();
        }
        ZipEntrySource zipEntrySource = this.zipArchive;
        if (zipEntrySource == null) {
            return (PackagePart[]) this.partList.sortedValues().toArray(new PackagePart[this.partList.size()]);
        }
        Enumeration<? extends ZipEntry> entries = zipEntrySource.getEntries();
        while (true) {
            if (!entries.hasMoreElements()) {
                break;
            }
            ZipEntry zipEntryNextElement = entries.nextElement();
            if (zipEntryNextElement.getName().equalsIgnoreCase(ContentTypeManager.CONTENT_TYPES_PART_NAME)) {
                try {
                    this.contentTypeManager = new ZipContentTypeManager(getZipArchive().getInputStream(zipEntryNextElement), this);
                    break;
                } catch (IOException e) {
                    throw new InvalidFormatException(e.getMessage(), e);
                }
            }
        }
        if (this.contentTypeManager == null) {
            Enumeration<? extends ZipEntry> entries2 = this.zipArchive.getEntries();
            boolean z = false;
            boolean z2 = false;
            int i = 0;
            while (entries2.hasMoreElements()) {
                String name = entries2.nextElement().getName();
                if ("mimetype".equals(name)) {
                    z = true;
                }
                if (SETTINGS_XML.equals(name)) {
                    z2 = true;
                }
                i++;
            }
            if (z && z2) {
                throw new ODFNotOfficeXmlFileException("The supplied data appears to be in ODF (Open Document) Format. Formats like these (eg ODS, ODP) are not supported, try Apache ODFToolkit");
            }
            if (i == 0) {
                throw new NotOfficeXmlFileException("No valid entries or contents found, this is not a valid OOXML (Office Open XML) file");
            }
            throw new InvalidFormatException("Package should contain a content type part [M1.13]");
        }
        Enumeration<? extends ZipEntry> entries3 = this.zipArchive.getEntries();
        while (entries3.hasMoreElements()) {
            ZipEntry zipEntryNextElement2 = entries3.nextElement();
            PackagePartName packagePartNameBuildPartName = buildPartName(zipEntryNextElement2);
            if (packagePartNameBuildPartName != null && (contentType2 = this.contentTypeManager.getContentType(packagePartNameBuildPartName)) != null && contentType2.equals("application/vnd.openxmlformats-package.relationships+xml")) {
                try {
                    this.partList.put(packagePartNameBuildPartName, new ZipPackagePart(this, zipEntryNextElement2, packagePartNameBuildPartName, contentType2));
                } catch (InvalidOperationException e2) {
                    throw new InvalidFormatException(e2.getMessage(), e2);
                }
            }
        }
        Enumeration<? extends ZipEntry> entries4 = this.zipArchive.getEntries();
        while (entries4.hasMoreElements()) {
            ZipEntry zipEntryNextElement3 = entries4.nextElement();
            PackagePartName packagePartNameBuildPartName2 = buildPartName(zipEntryNextElement3);
            if (packagePartNameBuildPartName2 != null && ((contentType = this.contentTypeManager.getContentType(packagePartNameBuildPartName2)) == null || !contentType.equals("application/vnd.openxmlformats-package.relationships+xml"))) {
                if (contentType == null) {
                    throw new InvalidFormatException("The part " + packagePartNameBuildPartName2.getURI().getPath() + " does not have any content type ! Rule: Package require content types when retrieving a part from a package. [M.1.14]");
                }
                try {
                    this.partList.put(packagePartNameBuildPartName2, new ZipPackagePart(this, zipEntryNextElement3, packagePartNameBuildPartName2, contentType));
                } catch (InvalidOperationException e3) {
                    throw new InvalidFormatException(e3.getMessage(), e3);
                }
            }
        }
        return (PackagePart[]) this.partList.sortedValues().toArray(new PackagePart[this.partList.size()]);
    }

    public ZipEntrySource getZipArchive() {
        return this.zipArchive;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void removePartImpl(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partUri");
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void revertImpl() {
        try {
            ZipEntrySource zipEntrySource = this.zipArchive;
            if (zipEntrySource != null) {
                zipEntrySource.close();
            }
        } catch (IOException unused) {
        }
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void saveImpl(OutputStream outputStream) {
        throwExceptionIfReadOnly();
        try {
            ZipOutputStream zipOutputStream = !(outputStream instanceof ZipOutputStream) ? new ZipOutputStream(outputStream) : (ZipOutputStream) outputStream;
            if (getPartsByRelationshipType("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties").size() == 0 && getPartsByRelationshipType("http://schemas.openxmlformats.org/officedocument/2006/relationships/metadata/core-properties").size() == 0) {
                LOG.log(1, "Save core properties part");
                getPackageProperties();
                addPackagePart(this.packageProperties);
                this.relationships.addRelationship(this.packageProperties.getPartName().getURI(), TargetMode.INTERNAL, "http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties", null);
                if (!this.contentTypeManager.isContentTypeRegister("application/vnd.openxmlformats-package.core-properties+xml")) {
                    this.contentTypeManager.addContentType(this.packageProperties.getPartName(), "application/vnd.openxmlformats-package.core-properties+xml");
                }
            }
            POILogger pOILogger = LOG;
            pOILogger.log(1, "Save package relationships");
            ZipPartMarshaller.marshallRelationshipPart(getRelationships(), PackagingURIHelper.PACKAGE_RELATIONSHIPS_ROOT_PART_NAME, zipOutputStream);
            pOILogger.log(1, "Save content types part");
            this.contentTypeManager.save(zipOutputStream);
            for (PackagePart packagePart : getParts()) {
                if (!packagePart.isRelationshipPart()) {
                    PackagePartName partName = packagePart.getPartName();
                    LOG.log(1, "Save part '" + ZipHelper.getZipItemNameFromOPCName(partName.getName()) + "'");
                    PartMarshaller partMarshaller = this.partMarshallers.get(packagePart._contentType);
                    String str = "The part " + partName.getURI() + " failed to be saved in the stream with marshaller ";
                    if (partMarshaller != null) {
                        if (!partMarshaller.marshall(packagePart, zipOutputStream)) {
                            throw new OpenXML4JException(str + partMarshaller);
                        }
                    } else if (!this.defaultPartMarshaller.marshall(packagePart, zipOutputStream)) {
                        throw new OpenXML4JException(str + this.defaultPartMarshaller);
                    }
                }
            }
            zipOutputStream.close();
        } catch (OpenXML4JRuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new OpenXML4JRuntimeException(AbstractC2322a.m1619i(e2, new StringBuilder("Fail to save: an error occurs while saving the package : ")), e2);
        }
    }

    public ZipPackage(InputStream inputStream, PackageAccess packageAccess) throws IOException {
        super(packageAccess);
        ZipSecureFile.ThresholdInputStream thresholdInputStreamOpenZipStream = ZipHelper.openZipStream(inputStream);
        try {
            this.zipArchive = new ZipInputStreamZipEntrySource(thresholdInputStreamOpenZipStream);
        } catch (IOException e) {
            IOUtils.closeQuietly(thresholdInputStreamOpenZipStream);
            throw new IOException("Failed to read zip entry source", e);
        }
    }

    private static ZipEntrySource openZipEntrySourceStream(FileInputStream fileInputStream) {
        try {
            ZipSecureFile.ThresholdInputStream thresholdInputStreamOpenZipStream = ZipHelper.openZipStream(fileInputStream);
            try {
                return openZipEntrySourceStream(thresholdInputStreamOpenZipStream);
            } catch (Exception e) {
                IOUtils.closeQuietly(thresholdInputStreamOpenZipStream);
                if (e instanceof InvalidOperationException) {
                    throw ((InvalidOperationException) e);
                }
                throw new InvalidOperationException("Failed to read the zip entry source stream", e);
            }
        } catch (IOException e2) {
            throw new InvalidOperationException("Could not open the file input stream", e2);
        }
    }

    public ZipPackage(String str, PackageAccess packageAccess) {
        this(new File(str), packageAccess);
    }

    public ZipPackage(File file, PackageAccess packageAccess) {
        ZipFileZipEntrySource zipFileZipEntrySourceOpenZipEntrySourceStream;
        super(packageAccess);
        try {
            zipFileZipEntrySourceOpenZipEntrySourceStream = new ZipFileZipEntrySource(ZipHelper.openZipFile(file));
        } catch (IOException e) {
            if (packageAccess != PackageAccess.WRITE) {
                LOG.log(7, "Error in zip file " + file + " - falling back to stream processing (i.e. ignoring zip central directory)");
                zipFileZipEntrySourceOpenZipEntrySourceStream = openZipEntrySourceStream(file);
            } else {
                throw new InvalidOperationException("Can't open the specified file: '" + file + "'", e);
            }
        }
        this.zipArchive = zipFileZipEntrySourceOpenZipEntrySourceStream;
    }

    private static ZipEntrySource openZipEntrySourceStream(ZipSecureFile.ThresholdInputStream thresholdInputStream) {
        try {
            return new ZipInputStreamZipEntrySource(thresholdInputStream);
        } catch (IOException e) {
            throw new InvalidOperationException("Could not open the specified zip entry source stream", e);
        }
    }

    public ZipPackage(ZipEntrySource zipEntrySource, PackageAccess packageAccess) {
        super(packageAccess);
        this.zipArchive = zipEntrySource;
    }

    @Override // org.apache.poi.openxml4j.opc.OPCPackage
    public void flushImpl() {
    }
}
