package org.apache.poi.javax.imageio.spi;

import com.sun.imageio.plugins.png.PNGImageReaderSpi;
import com.sun.imageio.plugins.png.PNGImageWriterSpi;
import com.sun.imageio.spi.FileImageInputStreamSpi;
import com.sun.imageio.spi.FileImageOutputStreamSpi;
import com.sun.imageio.spi.InputStreamImageInputStreamSpi;
import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;
import com.sun.imageio.spi.RAFImageInputStreamSpi;
import com.sun.imageio.spi.RAFImageOutputStreamSpi;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Vector;
import org.apache.poi.sun.awt.AppContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class IIORegistry extends ServiceRegistry {
    private static final Vector initialCategories;

    static {
        Vector vector = new Vector(5);
        initialCategories = vector;
        vector.add(ImageReaderSpi.class);
        vector.add(ImageWriterSpi.class);
        vector.add(ImageTranscoderSpi.class);
        vector.add(ImageInputStreamSpi.class);
        vector.add(ImageOutputStreamSpi.class);
    }

    private IIORegistry() {
        super(initialCategories.iterator());
        registerStandardSpis();
        registerApplicationClasspathSpis();
    }

    public static IIORegistry getDefaultInstance() {
        AppContext appContext = AppContext.getAppContext();
        IIORegistry iIORegistry = (IIORegistry) appContext.get(IIORegistry.class);
        if (iIORegistry != null) {
            return iIORegistry;
        }
        IIORegistry iIORegistry2 = new IIORegistry();
        appContext.put(IIORegistry.class, iIORegistry2);
        return iIORegistry2;
    }

    private void registerInstalledProviders() {
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.spi.IIORegistry.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                Iterator<Class<?>> categories = IIORegistry.this.getCategories();
                while (categories.hasNext()) {
                    Iterator it = ServiceLoader.loadInstalled(categories.next()).iterator();
                    while (it.hasNext()) {
                        IIORegistry.this.registerServiceProvider((IIOServiceProvider) it.next());
                    }
                }
                return this;
            }
        });
    }

    private void registerStandardSpis() {
        registerServiceProvider(new PNGImageReaderSpi());
        registerServiceProvider(new PNGImageWriterSpi());
        registerServiceProvider(new FileImageInputStreamSpi());
        registerServiceProvider(new FileImageOutputStreamSpi());
        registerServiceProvider(new InputStreamImageInputStreamSpi());
        registerServiceProvider(new OutputStreamImageOutputStreamSpi());
        registerServiceProvider(new RAFImageInputStreamSpi());
        registerServiceProvider(new RAFImageOutputStreamSpi());
        registerInstalledProviders();
    }

    public void registerApplicationClasspathSpis() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Iterator<Class<?>> categories = getCategories();
        while (categories.hasNext()) {
            Iterator it = ServiceLoader.load(categories.next(), contextClassLoader).iterator();
            while (it.hasNext()) {
                try {
                    registerServiceProvider((IIOServiceProvider) it.next());
                } catch (ServiceConfigurationError e) {
                    if (System.getSecurityManager() == null) {
                        throw e;
                    }
                    e.printStackTrace();
                }
            }
        }
    }
}
