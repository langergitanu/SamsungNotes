package com.google.api.client.util.store;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Throwables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class FileDataStoreFactory extends AbstractDataStoreFactory {
    private static final Logger LOGGER = Logger.getLogger(FileDataStoreFactory.class.getName());
    private final File dataDirectory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FileDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {
        private final File dataFile;

        public FileDataStore(FileDataStoreFactory fileDataStoreFactory, File file, String str) throws IOException {
            super(fileDataStoreFactory, str);
            File file2 = new File(file, str);
            this.dataFile = file2;
            if (IOUtils.isSymbolicLink(file2)) {
                throw new IOException(AbstractC2322a.m1617g(file2, "unable to use a symbolic link: "));
            }
            if (!file2.createNewFile()) {
                this.keyValueMap = (HashMap) IOUtils.deserialize(new FileInputStream(file2));
            } else {
                this.keyValueMap = Maps.newHashMap();
                save();
            }
        }

        @Override // com.google.api.client.util.store.AbstractMemoryDataStore
        public void save() throws IOException {
            IOUtils.serialize(this.keyValueMap, new FileOutputStream(this.dataFile));
        }

        @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
        public FileDataStoreFactory getDataStoreFactory() {
            return (FileDataStoreFactory) super.getDataStoreFactory();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public FileDataStoreFactory(File file) throws X, IOException {
        File canonicalFile = file.getCanonicalFile();
        this.dataDirectory = canonicalFile;
        if (IOUtils.isSymbolicLink(canonicalFile)) {
            throw new IOException(AbstractC2322a.m1617g(canonicalFile, "unable to use a symbolic link: "));
        }
        if (!canonicalFile.exists() && !canonicalFile.mkdirs()) {
            throw new IOException(AbstractC2322a.m1617g(canonicalFile, "unable to create directory: "));
        }
        setPermissionsToOwnerOnly(canonicalFile);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X */
    public static void setPermissionsToOwnerOnly(File file) throws X {
        try {
            Class cls = Boolean.TYPE;
            Method method = File.class.getMethod("setReadable", cls, cls);
            Method method2 = File.class.getMethod("setWritable", cls, cls);
            Method method3 = File.class.getMethod("setExecutable", cls, cls);
            Boolean bool = Boolean.FALSE;
            if (!((Boolean) method.invoke(file, bool, bool)).booleanValue() || !((Boolean) method2.invoke(file, bool, bool)).booleanValue() || !((Boolean) method3.invoke(file, bool, bool)).booleanValue()) {
                LOGGER.warning("unable to change permissions for everybody: " + file);
            }
            Boolean bool2 = Boolean.TRUE;
            if (((Boolean) method.invoke(file, bool2, bool2)).booleanValue() && ((Boolean) method2.invoke(file, bool2, bool2)).booleanValue() && ((Boolean) method3.invoke(file, bool2, bool2)).booleanValue()) {
                return;
            }
            LOGGER.warning("unable to change permissions for owner: " + file);
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException unused) {
        } catch (NoSuchMethodException unused2) {
            LOGGER.warning("Unable to set permissions for " + file + ", likely because you are running a version of Java prior to 1.6");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            Throwables.propagateIfPossible(cause, IOException.class);
            throw new RuntimeException(cause);
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    public <V extends Serializable> DataStore<V> createDataStore(String str) {
        return new FileDataStore(this, this.dataDirectory, str);
    }

    public final File getDataDirectory() {
        return this.dataDirectory;
    }
}
