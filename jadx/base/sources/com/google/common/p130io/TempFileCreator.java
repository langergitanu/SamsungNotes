package com.google.common.p130io;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.p130io.TempFileCreator;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
abstract class TempFileCreator {
    static final TempFileCreator INSTANCE = pickSecureCreator();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class JavaIoCreator extends TempFileCreator {
        private static final int TEMP_DIR_ATTEMPTS = 10000;

        private JavaIoCreator() {
            super();
        }

        @Override // com.google.common.p130io.TempFileCreator
        public File createTempDir() {
            File file = new File(StandardSystemProperty.JAVA_IO_TMPDIR.value());
            String str = System.currentTimeMillis() + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR;
            for (int i = 0; i < 10000; i++) {
                File file2 = new File(file, str + i);
                if (file2.mkdir()) {
                    return file2;
                }
            }
            throw new IllegalStateException(AbstractC0541b.m775q("Failed to create directory within 10000 attempts (tried ", str, "0 to ", str, "9999)"));
        }

        @Override // com.google.common.p130io.TempFileCreator
        public File createTempFile(String str) {
            return File.createTempFile(str, null, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ThrowingCreator extends TempFileCreator {
        private static final String MESSAGE = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

        private ThrowingCreator() {
            super();
        }

        @Override // com.google.common.p130io.TempFileCreator
        public File createTempDir() {
            throw new IllegalStateException(MESSAGE);
        }

        @Override // com.google.common.p130io.TempFileCreator
        public File createTempFile(String str) throws IOException {
            throw new IOException(MESSAGE);
        }
    }

    private static TempFileCreator pickSecureCreator() {
        try {
            try {
                return new JavaNioCreator();
            } catch (ClassNotFoundException unused) {
                return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get(null)).intValue() ? new ThrowingCreator() : new JavaIoCreator();
            }
        } catch (ClassNotFoundException unused2) {
            return new ThrowingCreator();
        } catch (IllegalAccessException unused3) {
            return new ThrowingCreator();
        } catch (NoSuchFieldException unused4) {
            return new ThrowingCreator();
        }
    }

    public abstract File createTempDir();

    public abstract File createTempFile(String str);

    private TempFileCreator() {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @IgnoreJRERequirement
    public static final class JavaNioCreator extends TempFileCreator {
        private static final PermissionSupplier directoryPermissions;
        private static final PermissionSupplier filePermissions;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @IgnoreJRERequirement
        public interface PermissionSupplier {
            FileAttribute<?> get();
        }

        static {
            Set<String> setSupportedFileAttributeViews = FileSystems.getDefault().supportedFileAttributeViews();
            if (setSupportedFileAttributeViews.contains("posix")) {
                final int i = 0;
                filePermissions = new PermissionSupplier() { // from class: com.google.common.io.a
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        switch (i) {
                            case 0:
                                return TempFileCreator.JavaNioCreator.lambda$static$0();
                            case 1:
                                return TempFileCreator.JavaNioCreator.lambda$static$1();
                            default:
                                return TempFileCreator.JavaNioCreator.lambda$static$2();
                        }
                    }
                };
                final int i2 = 1;
                directoryPermissions = new PermissionSupplier() { // from class: com.google.common.io.a
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        switch (i2) {
                            case 0:
                                return TempFileCreator.JavaNioCreator.lambda$static$0();
                            case 1:
                                return TempFileCreator.JavaNioCreator.lambda$static$1();
                            default:
                                return TempFileCreator.JavaNioCreator.lambda$static$2();
                        }
                    }
                };
                return;
            }
            if (setSupportedFileAttributeViews.contains("acl")) {
                PermissionSupplier permissionSupplierUserPermissions = userPermissions();
                directoryPermissions = permissionSupplierUserPermissions;
                filePermissions = permissionSupplierUserPermissions;
            } else {
                final int i4 = 2;
                PermissionSupplier permissionSupplier = new PermissionSupplier() { // from class: com.google.common.io.a
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        switch (i4) {
                            case 0:
                                return TempFileCreator.JavaNioCreator.lambda$static$0();
                            case 1:
                                return TempFileCreator.JavaNioCreator.lambda$static$1();
                            default:
                                return TempFileCreator.JavaNioCreator.lambda$static$2();
                        }
                    }
                };
                directoryPermissions = permissionSupplier;
                filePermissions = permissionSupplier;
            }
        }

        private JavaNioCreator() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$static$0() {
            return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$static$1() {
            return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$static$2() throws IOException {
            throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$userPermissions$4(IOException iOException) throws IOException {
            throw new IOException("Could not find user", iOException);
        }

        private static PermissionSupplier userPermissions() {
            try {
                final ImmutableList immutableListM4303of = ImmutableList.m4303of(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(StandardSystemProperty.USER_NAME.value())).setPermissions(EnumSet.allOf(AclEntryPermission.class)).setFlags(AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT).build());
                final FileAttribute<ImmutableList<AclEntry>> fileAttribute = new FileAttribute<ImmutableList<AclEntry>>() { // from class: com.google.common.io.TempFileCreator.JavaNioCreator.1
                    @Override // java.nio.file.attribute.FileAttribute
                    public String name() {
                        return "acl:acl";
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.nio.file.attribute.FileAttribute
                    public ImmutableList<AclEntry> value() {
                        return immutableListM4303of;
                    }
                };
                final int i = 0;
                return new PermissionSupplier() { // from class: com.google.common.io.b
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        switch (i) {
                            case 0:
                                return TempFileCreator.JavaNioCreator.lambda$userPermissions$3((FileAttribute) fileAttribute);
                            default:
                                return TempFileCreator.JavaNioCreator.lambda$userPermissions$4((IOException) fileAttribute);
                        }
                    }
                };
            } catch (IOException e) {
                final int i2 = 1;
                return new PermissionSupplier() { // from class: com.google.common.io.b
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        switch (i2) {
                            case 0:
                                return TempFileCreator.JavaNioCreator.lambda$userPermissions$3((FileAttribute) e);
                            default:
                                return TempFileCreator.JavaNioCreator.lambda$userPermissions$4((IOException) e);
                        }
                    }
                };
            }
        }

        @Override // com.google.common.p130io.TempFileCreator
        public File createTempDir() {
            try {
                return Files.createTempDirectory(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), null, directoryPermissions.get()).toFile();
            } catch (IOException e) {
                throw new IllegalStateException("Failed to create directory", e);
            }
        }

        @Override // com.google.common.p130io.TempFileCreator
        public File createTempFile(String str) {
            return Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), str, null, filePermissions.get()).toFile();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$userPermissions$3(FileAttribute fileAttribute) {
            return fileAttribute;
        }
    }
}
