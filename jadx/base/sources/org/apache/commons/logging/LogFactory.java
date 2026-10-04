package org.apache.commons.logging;

import androidx.appcompat.animation.C0422b;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.emoji2.text.flatbuffer.C2747a;
import com.samsung.android.vexfwk.sdk.bokeheffect.C11571a;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Properties;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.function.Supplier;
import org.apache.commons.lang3.SystemProperties;
import p001A.AbstractC0000a;
import p074R1.C0230b;
import p122b2.C4183f;
import p122b2.C4194q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LogFactory {
    public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
    private static final String DIAGNOSTICS_PREFIX;
    private static final PrintStream DIAGNOSTICS_STREAM;
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    private static final String FACTORY_LOG4J_API = "org.apache.commons.logging.impl.Log4jApiLogFactory";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    private static final String FACTORY_SLF4J = "org.apache.commons.logging.impl.Slf4jLogFactory";
    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
    private static final String LOG4J_TO_SLF4J_BRIDGE = "org.apache.logging.slf4j.SLF4JProvider";
    private static final int MAX_BROKEN_SERVICES = 3;
    public static final String PRIORITY_KEY = "priority";
    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    public static final String TCCL_KEY = "use_tccl";
    private static final String WEAK_HASHTABLE_CLASSNAME = "org.apache.commons.logging.impl.WeakHashtable";
    protected static Hashtable<ClassLoader, LogFactory> factories;

    @Deprecated
    protected static volatile LogFactory nullClassLoaderFactory;
    private static final WeakReference<ClassLoader> thisClassLoaderRef;

    static {
        String strObjectId;
        ClassLoader classLoader = getClassLoader(LogFactory.class);
        thisClassLoaderRef = new WeakReference<>(classLoader);
        if (classLoader != null) {
            try {
                strObjectId = objectId(classLoader);
            } catch (SecurityException unused) {
                strObjectId = "UNKNOWN";
            }
        } else {
            strObjectId = "BOOTLOADER";
        }
        DIAGNOSTICS_PREFIX = AbstractC0541b.m773o("[LogFactory from ", strObjectId, "] ");
        DIAGNOSTICS_STREAM = initDiagnostics();
        logClassLoaderEnvironment(LogFactory.class);
        factories = createFactoryStore();
        logDiagnostic("BOOTSTRAP COMPLETED");
    }

    private static void cacheFactory(ClassLoader classLoader, LogFactory logFactory) {
        if (logFactory != null) {
            if (classLoader == null) {
                nullClassLoaderFactory = logFactory;
            } else {
                factories.put(classLoader, logFactory);
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0044: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]) (LINE:69), block:B:11:0x0044 */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0147 A[Catch: Exception -> 0x0043, TryCatch #7 {Exception -> 0x0043, blocks: (B:5:0x0017, B:7:0x001d, B:9:0x0023, B:19:0x008c, B:16:0x004d, B:18:0x0053, B:34:0x00e5, B:36:0x00ed, B:38:0x00f3, B:39:0x0113, B:49:0x0141, B:51:0x0147, B:52:0x015f, B:42:0x0116, B:44:0x011e, B:46:0x0124, B:47:0x013f, B:24:0x009d, B:26:0x00a5, B:28:0x00c4, B:30:0x00cd, B:31:0x00e2, B:29:0x00c8), top: B:70:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object createFactory(String str, ClassLoader classLoader) {
        Class<?> cls;
        Class<?> clsLoadClass;
        Class<?> cls2;
        Class<?> cls3 = null;
        try {
            if (classLoader != null) {
                try {
                    clsLoadClass = classLoader.loadClass(str);
                    try {
                        if (LogFactory.class.isAssignableFrom(clsLoadClass)) {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic("Loaded class " + clsLoadClass.getName() + " from class loader " + objectId(classLoader));
                            }
                        } else if (isDiagnosticsEnabled()) {
                            logDiagnostic("Factory class " + clsLoadClass.getName() + " loaded from class loader " + objectId(clsLoadClass.getClassLoader()) + " does not extend '" + LogFactory.class.getName() + "' as loaded by this class loader.");
                            logHierarchy("[BAD CL TREE] ", classLoader);
                        }
                        return LogFactory.class.cast(clsLoadClass.getConstructor(null).newInstance(null));
                    } catch (ClassCastException unused) {
                        if (classLoader == thisClassLoaderRef.get()) {
                            boolean zImplementsLogFactory = implementsLogFactory(clsLoadClass);
                            StringBuilder sb = new StringBuilder("The application has specified that a custom LogFactory implementation should be used but Class '");
                            sb.append(str);
                            sb.append("' cannot be converted to '");
                            sb.append(LogFactory.class.getName());
                            sb.append("'. ");
                            if (zImplementsLogFactory) {
                                sb.append("The conflict is caused by the presence of multiple LogFactory classes in incompatible class loaders. Background can be found in https://commons.apache.org/logging/tech.html. If you have not explicitly specified a custom LogFactory then it is likely that the container has set one without your knowledge. In this case, consider using the commons-logging-adapters.jar file or specifying the standard LogFactory from the command line. ");
                            } else {
                                sb.append("Please check the custom implementation. ");
                            }
                            sb.append("Help can be found at https://commons.apache.org/logging/troubleshooting.html.");
                            logDiagnostic(sb.toString());
                            throw new ClassCastException(sb.toString());
                        }
                        if (isDiagnosticsEnabled()) {
                        }
                        cls2 = Class.forName(str);
                        return LogFactory.class.cast(cls2.getConstructor(null).newInstance(null));
                    } catch (ClassNotFoundException e) {
                        e = e;
                        if (classLoader == thisClassLoaderRef.get()) {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic("Unable to locate any class called '" + str + "' via class loader " + objectId(classLoader));
                            }
                            throw e;
                        }
                        if (isDiagnosticsEnabled()) {
                        }
                        cls2 = Class.forName(str);
                        return LogFactory.class.cast(cls2.getConstructor(null).newInstance(null));
                    } catch (NoClassDefFoundError e2) {
                        e = e2;
                        if (classLoader == thisClassLoaderRef.get()) {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic("Class '" + str + "' cannot be loaded via class loader " + objectId(classLoader) + " - it depends on some other class that cannot be found.");
                            }
                            throw e;
                        }
                        if (isDiagnosticsEnabled()) {
                        }
                        cls2 = Class.forName(str);
                        return LogFactory.class.cast(cls2.getConstructor(null).newInstance(null));
                    }
                } catch (ClassCastException unused2) {
                    clsLoadClass = null;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                } catch (Exception e5) {
                    e = e5;
                    if (isDiagnosticsEnabled()) {
                    }
                    if (cls3 != null) {
                    }
                } catch (NoClassDefFoundError e6) {
                    e = e6;
                }
            }
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Unable to load factory class via class loader " + objectId(classLoader) + " - trying the class loader associated with this LogFactory.");
            }
            cls2 = Class.forName(str);
            try {
                return LogFactory.class.cast(cls2.getConstructor(null).newInstance(null));
            } catch (Exception e7) {
                cls3 = cls2;
                e = e7;
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("Unable to create LogFactory instance.");
                }
                return (cls3 != null || LogFactory.class.isAssignableFrom(cls3)) ? new LogConfigurationException(e) : new LogConfigurationException("The chosen LogFactory implementation does not extend LogFactory. Please check your configuration.", e);
            }
        } catch (Exception e8) {
            e = e8;
            cls3 = cls;
        }
    }

    private static Hashtable<ClassLoader, LogFactory> createFactoryStore() {
        String systemProperty;
        Hashtable<ClassLoader, LogFactory> hashtable = null;
        try {
            systemProperty = getSystemProperty(HASHTABLE_IMPLEMENTATION_PROPERTY, null);
        } catch (SecurityException unused) {
            systemProperty = null;
        }
        if (systemProperty == null) {
            systemProperty = WEAK_HASHTABLE_CLASSNAME;
        }
        try {
            hashtable = (Hashtable) Class.forName(systemProperty).getConstructor(null).newInstance(null);
        } catch (Throwable th) {
            handleThrowable(th);
            if (!WEAK_HASHTABLE_CLASSNAME.equals(systemProperty)) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("[ERROR] LogFactory: Load of custom Hashtable failed");
                } else {
                    System.err.println("[ERROR] LogFactory: Load of custom Hashtable failed");
                }
            }
        }
        return hashtable == null ? new Hashtable<>() : hashtable;
    }

    public static ClassLoader directGetContextClassLoader() {
        try {
            return Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            return null;
        }
    }

    private static LogFactory getCachedFactory(ClassLoader classLoader) {
        return classLoader == null ? nullClassLoaderFactory : factories.get(classLoader);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        try {
            return cls.getClassLoader();
        } catch (SecurityException e) {
            logDiagnostic(new C4183f(cls, e, 13));
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Properties getConfigurationFile(ClassLoader classLoader, String str) {
        URL url;
        Enumeration<URL> resources;
        Properties properties = null;
        try {
            resources = getResources(classLoader, str);
        } catch (SecurityException unused) {
            url = null;
        }
        if (resources == null) {
            return null;
        }
        url = null;
        double d = 0.0d;
        while (resources.hasMoreElements()) {
            try {
                URL urlNextElement = resources.nextElement();
                Properties properties2 = getProperties(urlNextElement);
                if (properties2 != null) {
                    if (properties == null) {
                        try {
                            String property = properties2.getProperty("priority");
                            d = property != null ? Double.parseDouble(property) : 0.0d;
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic("[LOOKUP] Properties file found at '" + urlNextElement + "' with priority " + d);
                            }
                            url = urlNextElement;
                            properties = properties2;
                        } catch (SecurityException unused2) {
                            url = urlNextElement;
                            properties = properties2;
                            logDiagnostic("SecurityException thrown while trying to find/read config files.");
                            if (isDiagnosticsEnabled()) {
                            }
                            return properties;
                        }
                    } else {
                        String property2 = properties2.getProperty("priority");
                        double d2 = property2 != null ? Double.parseDouble(property2) : 0.0d;
                        if (d2 > d) {
                            if (isDiagnosticsEnabled()) {
                                logDiagnostic("[LOOKUP] Properties file at '" + urlNextElement + "' with priority " + d2 + " overrides file at '" + url + "' with priority " + d);
                            }
                            url = urlNextElement;
                            properties = properties2;
                            d = d2;
                        } else if (isDiagnosticsEnabled()) {
                            logDiagnostic("[LOOKUP] Properties file at '" + urlNextElement + "' with priority " + d2 + " does not override file at '" + url + "' with priority " + d);
                        }
                    }
                }
            } catch (SecurityException unused3) {
            }
        }
        if (isDiagnosticsEnabled()) {
            if (properties == null) {
                logDiagnostic(AbstractC0541b.m773o("[LOOKUP] No properties file of name '", str, "' found."));
            } else {
                logDiagnostic("[LOOKUP] Properties file of name '" + str + "' found at '" + url + '\"');
            }
        }
        return properties;
    }

    public static ClassLoader getContextClassLoader() {
        return directGetContextClassLoader();
    }

    private static ClassLoader getContextClassLoaderInternal() {
        return (ClassLoader) AccessController.doPrivileged(new C13936d(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static LogFactory getFactory() {
        ClassLoader contextClassLoaderInternal = getContextClassLoaderInternal();
        if (contextClassLoaderInternal == null) {
            logDiagnostic("Context class loader is null.");
        }
        LogFactory cachedFactory = getCachedFactory(contextClassLoaderInternal);
        if (cachedFactory != null) {
            return cachedFactory;
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[LOOKUP] LogFactory implementation requested for the first time for context class loader " + objectId(contextClassLoaderInternal));
            logHierarchy("[LOOKUP] ", contextClassLoaderInternal);
        }
        Properties configurationFile = getConfigurationFile(contextClassLoaderInternal, FACTORY_PROPERTIES);
        boolean z = true;
        boolean z2 = false;
        boolean z3 = contextClassLoaderInternal != null;
        if (configurationFile != null) {
            String property = configurationFile.getProperty(TCCL_KEY);
            if (property != null && !Boolean.parseBoolean(property)) {
                z = false;
            }
            z3 &= z;
        }
        if (z3) {
            try {
                if (LogFactory.class.equals(Class.forName(LogFactory.class.getName(), false, contextClassLoaderInternal))) {
                    z2 = z3;
                } else {
                    logDiagnostic(new C13934b(contextClassLoaderInternal, 0));
                    logHierarchy("[BAD CL TREE] ", contextClassLoaderInternal);
                }
            } catch (ClassNotFoundException unused) {
                logDiagnostic(new C13934b(contextClassLoaderInternal, 1));
                logHierarchy("[BAD CL TREE] ", contextClassLoaderInternal);
            }
        }
        ClassLoader classLoader = z2 ? contextClassLoaderInternal : thisClassLoaderRef.get();
        logDiagnostic(new C2747a(21));
        try {
            String systemProperty = getSystemProperty(FACTORY_PROPERTY, null);
            if (systemProperty != null) {
                logDiagnostic(new C4194q(systemProperty, 7));
                cachedFactory = newFactory(systemProperty, classLoader, contextClassLoaderInternal);
            } else {
                logDiagnostic(new C2747a(22));
            }
        } catch (SecurityException e) {
            logDiagnostic(new C13935c(e, 0));
        } catch (RuntimeException e2) {
            logDiagnostic(new C0230b(e2, 11));
            throw e2;
        }
        if (cachedFactory == null) {
            logDiagnostic("[LOOKUP] Using ServiceLoader  to define the LogFactory subclass to use...");
            try {
                Iterator it = ServiceLoader.load(LogFactory.class, classLoader).iterator();
                int i = 3;
                while (cachedFactory == null) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    try {
                        if (it.hasNext()) {
                            cachedFactory = (LogFactory) it.next();
                        }
                    } catch (LinkageError | ServiceConfigurationError e3) {
                        logDiagnostic(new C0230b(e3, 12));
                    }
                    i = i2;
                }
            } catch (Exception e5) {
                logDiagnostic(new C0230b(e5, 13));
            }
        }
        if (cachedFactory == null) {
            if (configurationFile != null) {
                logDiagnostic(new C2747a(23));
                String property2 = configurationFile.getProperty(FACTORY_PROPERTY);
                if (property2 != null) {
                    logDiagnostic(new C4194q(property2, 6));
                    cachedFactory = newFactory(property2, classLoader, contextClassLoaderInternal);
                } else {
                    logDiagnostic("[LOOKUP] Properties file has no entry specifying LogFactory subclass.");
                }
            } else {
                logDiagnostic("[LOOKUP] No properties file available to determine LogFactory subclass from..");
            }
        }
        if (cachedFactory == null) {
            cachedFactory = newStandardFactory(classLoader);
        }
        if (cachedFactory == null) {
            WeakReference<ClassLoader> weakReference = thisClassLoaderRef;
            if (classLoader != weakReference.get()) {
                cachedFactory = newStandardFactory(weakReference.get());
            }
        }
        if (cachedFactory == null) {
            logDiagnostic(new C2747a(20));
            cachedFactory = newFactory(FACTORY_DEFAULT, thisClassLoaderRef.get(), contextClassLoaderInternal);
        } else if (isDiagnosticsEnabled()) {
            logDiagnostic("Created object " + objectId(cachedFactory) + " to manage class loader " + objectId(contextClassLoaderInternal));
        }
        if (cachedFactory != null) {
            cacheFactory(contextClassLoaderInternal, cachedFactory);
            if (configurationFile != null) {
                Enumeration<?> enumerationPropertyNames = configurationFile.propertyNames();
                while (enumerationPropertyNames.hasMoreElements()) {
                    String string = Objects.toString(enumerationPropertyNames.nextElement(), null);
                    cachedFactory.setAttribute(string, configurationFile.getProperty(string));
                }
            }
        }
        return cachedFactory;
    }

    public static Log getLog(Class<?> cls) {
        return getFactory().getInstance(cls);
    }

    private static Properties getProperties(URL url) {
        return (Properties) AccessController.doPrivileged(new C13939g(url, 0));
    }

    private static Enumeration<URL> getResources(ClassLoader classLoader, String str) {
        return (Enumeration) AccessController.doPrivileged(new C13933a(classLoader, str));
    }

    private static String getSystemProperty(String str, String str2) {
        return (String) AccessController.doPrivileged(new C13938f(str, str2, 0));
    }

    public static void handleThrowable(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }

    private static boolean implementsLogFactory(Class<?> cls) {
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot class loader");
                    return false;
                }
                logHierarchy("[CUSTOM LOG FACTORY] ", classLoader);
                boolean zIsAssignableFrom = Class.forName(FACTORY_PROPERTY, false, classLoader).isAssignableFrom(cls);
                String name = cls.getName();
                if (zIsAssignableFrom) {
                    logDiagnostic(new C4194q(name, 8));
                    return zIsAssignableFrom;
                }
                logDiagnostic(new C4194q(name, 9));
                return zIsAssignableFrom;
            } catch (ClassNotFoundException unused) {
                logDiagnostic(new C2747a(24));
            } catch (LinkageError e) {
                logDiagnostic(new C0230b(e, 14));
            } catch (SecurityException e2) {
                logDiagnostic(new C13935c(e2, 1));
            }
        }
        return false;
    }

    private static PrintStream initDiagnostics() {
        try {
            String systemProperty = getSystemProperty(DIAGNOSTICS_DEST_PROPERTY, null);
            if (systemProperty == null) {
                return null;
            }
            return systemProperty.equals("STDOUT") ? System.out : systemProperty.equals("STDERR") ? System.err : new PrintStream((OutputStream) new FileOutputStream(systemProperty, true), false, StandardCharsets.UTF_8.name());
        } catch (IOException | SecurityException unused) {
            return null;
        }
    }

    private static boolean isClassAvailable(String str, ClassLoader classLoader) {
        logDiagnostic(new C4183f(str, classLoader, 11));
        try {
            Class.forName(str, true, classLoader);
            return true;
        } catch (ClassNotFoundException | LinkageError e) {
            logDiagnostic(new C11571a(str, 3, classLoader, e));
            return false;
        }
    }

    public static boolean isDiagnosticsEnabled() {
        return DIAGNOSTICS_STREAM != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getClassLoader$0(Class cls, SecurityException securityException) {
        return "Unable to get class loader for class '" + cls + "' due to security restrictions - " + securityException.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$1(ClassLoader classLoader) {
        return "The class " + LogFactory.class.getName() + " loaded by the context class loader " + objectId(classLoader) + " and this class differ. Disabling the usage of the context class loader.Background can be found in https://commons.apache.org/logging/tech.html. ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$10() {
        return "[LOOKUP] Looking in properties file for entry with key 'org.apache.commons.logging.LogFactory' to define the LogFactory subclass to use...";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$11(String str) {
        return AbstractC0541b.m773o("[LOOKUP] Properties file specifies LogFactory subclass '", str, "'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$12() {
        return "[LOOKUP] Loading the default LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl' via the same class loader that loaded this LogFactory class (ie not looking in the context class loader).";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$2(ClassLoader classLoader) {
        return "The class " + LogFactory.class.getName() + " is not present in the the context class loader " + objectId(classLoader) + ". Disabling the usage of the context class loader.Background can be found in https://commons.apache.org/logging/tech.html. ";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$3() {
        return "[LOOKUP] Looking for system property [org.apache.commons.logging.LogFactory] to define the LogFactory subclass to use...";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$4(String str) {
        return AbstractC0541b.m773o("[LOOKUP] Creating an instance of LogFactory class '", str, "' as specified by system property org.apache.commons.logging.LogFactory");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$5() {
        return "[LOOKUP] No system property [org.apache.commons.logging.LogFactory] defined.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$6(SecurityException securityException) {
        return AbstractC0622a.m1170p(trim(securityException.getMessage()), "]. Trying alternative implementations...", new StringBuilder("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: ["));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$7(RuntimeException runtimeException) {
        return AbstractC0622a.m1170p(trim(runtimeException.getMessage()), "] as specified by a system property.", new StringBuilder("[LOOKUP] An exception occurred while trying to create an instance of the custom factory class: ["));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$8(Error error) {
        return AbstractC0622a.m1170p(trim(error.getMessage()), "]. Trying alternative implementations...", new StringBuilder("[LOOKUP] An exception occurred while trying to find an instance of LogFactory: ["));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getFactory$9(Exception exc) {
        return AbstractC0622a.m1170p(trim(exc.getMessage()), "]. Trying alternative implementations...", new StringBuilder("[LOOKUP] A security exception occurred while trying to create an instance of the custom factory class: ["));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getProperties$13(URL url) {
        return "Unable to close stream for URL " + url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getProperties$14(URL url) {
        return "Unable to read URL " + url;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Properties lambda$getProperties$15(final URL url) {
        try {
            URLConnection uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.setUseCaches(false);
            try {
                InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                if (inputStream == null) {
                    if (inputStream == null) {
                        return null;
                    }
                    inputStream.close();
                    return null;
                }
                try {
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    inputStream.close();
                    return properties;
                } finally {
                }
            } catch (IOException unused) {
                final int i = 0;
                logDiagnostic((Supplier<String>) new Supplier() { // from class: org.apache.commons.logging.e
                    @Override // java.util.function.Supplier
                    public final Object get() {
                        switch (i) {
                            case 0:
                                return LogFactory.lambda$getProperties$13(url);
                            default:
                                return LogFactory.lambda$getProperties$14(url);
                        }
                    }
                });
                return null;
            }
        } catch (IOException unused2) {
            final int i2 = 1;
            logDiagnostic((Supplier<String>) new Supplier() { // from class: org.apache.commons.logging.e
                @Override // java.util.function.Supplier
                public final Object get() {
                    switch (i2) {
                        case 0:
                            return LogFactory.lambda$getProperties$13(url);
                        default:
                            return LogFactory.lambda$getProperties$14(url);
                    }
                }
            });
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getResources$16(String str, IOException iOException) {
        StringBuilder sbM15l = AbstractC0000a.m15l("Exception while trying to find configuration file ", str, ":");
        sbM15l.append(iOException.getMessage());
        return sbM15l.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Enumeration lambda$getResources$17(ClassLoader classLoader, String str) {
        try {
            return classLoader != null ? classLoader.getResources(str) : ClassLoader.getSystemResources(str);
        } catch (IOException e) {
            logDiagnostic(new C4183f(str, e, 10));
            return null;
        } catch (NoSuchMethodError unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$implementsLogFactory$19(String str) {
        return AbstractC0541b.m773o("[CUSTOM LOG FACTORY] ", str, " implements LogFactory but was loaded by an incompatible class loader.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$implementsLogFactory$20(String str) {
        return AbstractC0541b.m773o("[CUSTOM LOG FACTORY] ", str, " does not implement LogFactory.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$implementsLogFactory$21(SecurityException securityException) {
        return "[CUSTOM LOG FACTORY] SecurityException caught trying to determine whether the compatibility was caused by a class loader conflict: " + securityException.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$implementsLogFactory$22(LinkageError linkageError) {
        return "[CUSTOM LOG FACTORY] LinkageError caught trying to determine whether the compatibility was caused by a class loader conflict: " + linkageError.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$implementsLogFactory$23() {
        return "[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by the class loader which loaded the custom LogFactory implementation. Is the custom factory in the right class loader?";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isClassAvailable$24(String str, ClassLoader classLoader) {
        StringBuilder sbM15l = AbstractC0000a.m15l("Checking if class '", str, "' is available in class loader ");
        sbM15l.append(objectId(classLoader));
        return sbM15l.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$isClassAvailable$25(String str, ClassLoader classLoader, Throwable th) {
        StringBuilder sbM15l = AbstractC0000a.m15l("Failed to load class '", str, "' from class loader ");
        sbM15l.append(objectId(classLoader));
        sbM15l.append(": ");
        sbM15l.append(th.getMessage());
        return sbM15l.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$newFactory$27(LogConfigurationException logConfigurationException) {
        return "An error occurred while loading the factory class:" + logConfigurationException.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$newFactory$28(Object obj, ClassLoader classLoader) {
        return "Created object " + objectId(obj) + " to manage class loader " + objectId(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$newStandardFactory$29() {
        return "[LOOKUP] Log4j API to SLF4J redirection detected. Loading the SLF4J LogFactory implementation 'org.apache.commons.logging.impl.Slf4jLogFactory'.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$newStandardFactory$30() {
        return "[LOOKUP] Loading the Log4j API LogFactory implementation 'org.apache.commons.logging.impl.Log4jApiLogFactory'.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$newStandardFactory$31() {
        return "[LOOKUP] Loading the SLF4J LogFactory implementation 'org.apache.commons.logging.impl.Slf4jLogFactory'.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$newStandardFactory$32() {
        return "[LOOKUP] Loading the legacy LogFactory implementation 'org.apache.commons.logging.impl.LogFactoryImpl'.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$release$33(ClassLoader classLoader) {
        return "Releasing factory for class loader " + objectId(classLoader);
    }

    private static void logClassLoaderEnvironment(Class<?> cls) {
        if (isDiagnosticsEnabled()) {
            try {
                logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
                logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty(SystemProperties.JAVA_CLASS_PATH));
            } catch (SecurityException unused) {
                logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
            }
            String name = cls.getName();
            try {
                ClassLoader classLoader = getClassLoader(cls);
                StringBuilder sbM15l = AbstractC0000a.m15l("[ENV] Class ", name, " was loaded via class loader ");
                sbM15l.append(objectId(classLoader));
                logDiagnostic(sbM15l.toString());
                logHierarchy(AbstractC0541b.m773o("[ENV] Ancestry of class loader which loaded ", name, " is "), classLoader);
            } catch (SecurityException unused2) {
                logDiagnostic("[ENV] Security forbids determining the class loader for ".concat(name));
            }
        }
    }

    private static void logDiagnostic(String str) {
        if (DIAGNOSTICS_STREAM != null) {
            logDiagnosticDirect(str);
        }
    }

    private static void logDiagnosticDirect(String str) {
        PrintStream printStream = DIAGNOSTICS_STREAM;
        printStream.print(DIAGNOSTICS_PREFIX);
        printStream.println(str);
        printStream.flush();
    }

    private static void logHierarchy(String str, ClassLoader classLoader) {
        if (isDiagnosticsEnabled()) {
            if (classLoader != null) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                sbM1324q.append(objectId(classLoader));
                sbM1324q.append(" == '");
                sbM1324q.append(classLoader.toString());
                sbM1324q.append("'");
                logDiagnostic(sbM1324q.toString());
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (classLoader != null) {
                    StringBuilder sb = new StringBuilder(AbstractC0541b.m756B(str, "ClassLoader tree:"));
                    do {
                        sb.append(objectId(classLoader));
                        if (classLoader == systemClassLoader) {
                            sb.append(" (SYSTEM) ");
                        }
                        try {
                            classLoader = classLoader.getParent();
                            sb.append(" --> ");
                        } catch (SecurityException unused) {
                            sb.append(" --> SECRET");
                        }
                    } while (classLoader != null);
                    sb.append("BOOT");
                    logDiagnostic(sb.toString());
                }
            } catch (SecurityException unused2) {
                logDiagnostic(AbstractC0541b.m756B(str, "Security forbids determining the system class loader."));
            }
        }
    }

    public static final void logRawDiagnostic(String str) {
        PrintStream printStream = DIAGNOSTICS_STREAM;
        if (printStream != null) {
            printStream.println(str);
            printStream.flush();
        }
    }

    public static LogFactory newFactory(String str, ClassLoader classLoader) {
        return newFactory(str, classLoader, null);
    }

    private static LogFactory newStandardFactory(ClassLoader classLoader) {
        if (isClassAvailable(LOG4J_TO_SLF4J_BRIDGE, classLoader)) {
            int i = 25;
            try {
                return (LogFactory) Class.forName(FACTORY_SLF4J, true, classLoader).getConstructor(null).newInstance(null);
            } catch (LinkageError | ReflectiveOperationException unused) {
            } finally {
                logDiagnostic(new C2747a(i));
            }
        }
        int i2 = 18;
        try {
            LogFactory logFactory = (LogFactory) Class.forName(FACTORY_LOG4J_API, true, classLoader).getConstructor(null).newInstance(null);
            logDiagnostic(new C2747a(i2));
            return logFactory;
        } catch (LinkageError | ReflectiveOperationException unused2) {
            logDiagnostic(new C2747a(i2));
            int i4 = 19;
            try {
                LogFactory logFactory2 = (LogFactory) Class.forName(FACTORY_SLF4J, true, classLoader).getConstructor(null).newInstance(null);
                logDiagnostic(new C2747a(i4));
                return logFactory2;
            } catch (LinkageError | ReflectiveOperationException unused3) {
                logDiagnostic(new C2747a(i4));
                int i5 = 17;
                try {
                    return (LogFactory) Class.forName(FACTORY_DEFAULT, true, classLoader).getConstructor(null).newInstance(null);
                } catch (LinkageError | ReflectiveOperationException unused4) {
                    return null;
                } finally {
                    logDiagnostic(new C2747a(i5));
                }
            } catch (Throwable th) {
                logDiagnostic(new C2747a(i4));
                throw th;
            }
        } catch (Throwable th2) {
            logDiagnostic(new C2747a(i2));
            throw th2;
        }
    }

    public static String objectId(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getName() + com.samsung.android.sdk.scs.base.utils.Log.TAG_SEPARATOR + System.identityHashCode(obj);
    }

    public static void release(ClassLoader classLoader) {
        logDiagnostic(new C13934b(classLoader, 2));
        Hashtable<ClassLoader, LogFactory> hashtable = factories;
        synchronized (hashtable) {
            try {
                if (classLoader != null) {
                    LogFactory logFactory = hashtable.get(classLoader);
                    if (logFactory != null) {
                        logFactory.release();
                        hashtable.remove(classLoader);
                    }
                } else if (nullClassLoaderFactory != null) {
                    nullClassLoaderFactory.release();
                    nullClassLoaderFactory = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void releaseAll() {
        logDiagnostic("Releasing factory for all class loaders.");
        Hashtable<ClassLoader, LogFactory> hashtable = factories;
        synchronized (hashtable) {
            try {
                hashtable.values().forEach(new C0422b(6));
                hashtable.clear();
                if (nullClassLoaderFactory != null) {
                    nullClassLoaderFactory.release();
                    nullClassLoaderFactory = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String trim(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    public abstract Object getAttribute(String str);

    public abstract String[] getAttributeNames();

    public abstract Log getInstance(Class<?> cls);

    public abstract Log getInstance(String str);

    public abstract void release();

    public abstract void removeAttribute(String str);

    public abstract void setAttribute(String str, Object obj);

    public static Log getLog(String str) {
        return getFactory().getInstance(str);
    }

    public static LogFactory newFactory(String str, ClassLoader classLoader, ClassLoader classLoader2) {
        Object objDoPrivileged = AccessController.doPrivileged(new C13933a(str, classLoader));
        if (!(objDoPrivileged instanceof LogConfigurationException)) {
            logDiagnostic(new C4183f(objDoPrivileged, classLoader2, 12));
            return (LogFactory) objDoPrivileged;
        }
        LogConfigurationException logConfigurationException = (LogConfigurationException) objDoPrivileged;
        logDiagnostic(new C0230b(logConfigurationException, 10));
        throw logConfigurationException;
    }

    private static void logDiagnostic(Supplier<String> supplier) {
        if (DIAGNOSTICS_STREAM != null) {
            logDiagnosticDirect(supplier.get());
        }
    }
}
