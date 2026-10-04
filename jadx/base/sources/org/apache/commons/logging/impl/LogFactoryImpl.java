package org.apache.commons.logging.impl;

import androidx.compose.runtime.AbstractC1974b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.util.Hashtable;
import org.apache.commons.logging.C13936d;
import org.apache.commons.logging.C13938f;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import p001A.AbstractC0000a;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LogFactoryImpl extends LogFactory {
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
    private static final String LOGGING_IMPL_LUMBERJACK_LOGGER = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    private static final String PKG_IMPL = "org.apache.commons.logging.impl.";
    private static final int PKG_LEN = 32;
    private boolean allowFlawedContext;
    private boolean allowFlawedDiscovery;
    private boolean allowFlawedHierarchy;
    private String diagnosticPrefix;
    private String logClassName;
    protected Constructor<?> logConstructor;
    protected Method logMethod;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String LOGGING_IMPL_JDK14_LOGGER = "org.apache.commons.logging.impl.Jdk14Logger";
    private static final String LOGGING_IMPL_SIMPLE_LOGGER = "org.apache.commons.logging.impl.SimpleLog";
    private static final String[] classesToDiscover = {LOGGING_IMPL_JDK14_LOGGER, LOGGING_IMPL_SIMPLE_LOGGER};
    private boolean useTCCL = true;
    protected Hashtable<String, Object> attributes = new Hashtable<>();
    protected Hashtable<String, Log> instances = new Hashtable<>();
    protected Class<?>[] logConstructorSignature = {String.class};
    protected Class<?>[] logMethodSignature = {LogFactory.class};

    public LogFactoryImpl() {
        initDiagnostics();
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Instance created.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0151 A[LOOP:0: B:6:0x002e->B:49:0x0151, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0146 A[EDGE_INSN: B:74:0x0146->B:45:0x0146 BREAK  A[LOOP:0: B:6:0x002e->B:49:0x0151], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Log createLogFromClass(String str, String str2, boolean z) {
        Log log;
        Class<?> cls;
        Class<?> cls2;
        Object objNewInstance;
        URL systemResource;
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Attempting to instantiate '" + str + "'");
        }
        Object[] objArr = {str2};
        ClassLoader baseClassLoader = getBaseClassLoader();
        Constructor<?> constructor = null;
        Class<?> cls3 = null;
        while (true) {
            StringBuilder sbM15l = AbstractC0000a.m15l("Trying to load '", str, "' from class loader ");
            sbM15l.append(LogFactory.objectId(baseClassLoader));
            logDiagnostic(sbM15l.toString());
            try {
                try {
                    if (isDiagnosticsEnabled()) {
                        String str3 = str.replace('.', '/') + ".class";
                        if (baseClassLoader != null) {
                            systemResource = baseClassLoader.getResource(str3);
                        } else {
                            systemResource = ClassLoader.getSystemResource(str3 + ".class");
                        }
                        if (systemResource == null) {
                            logDiagnostic("Class '" + str + "' [" + str3 + "] cannot be found.");
                        } else {
                            logDiagnostic("Class '" + str + "' was found at '" + systemResource + "'");
                        }
                    }
                    try {
                        cls = Class.forName(str, true, baseClassLoader);
                    } catch (ClassNotFoundException e) {
                        logDiagnostic("The log adapter '" + str + "' is not available via class loader " + LogFactory.objectId(baseClassLoader) + ": " + trim(e.getMessage()));
                        try {
                            cls = Class.forName(str);
                        } catch (ClassNotFoundException e2) {
                            logDiagnostic("The log adapter '" + str + "' is not available via the LogFactoryImpl class class loader: " + trim(e2.getMessage()));
                            break;
                        }
                    }
                    cls2 = cls;
                    constructor = cls2.getConstructor(this.logConstructorSignature);
                    objNewInstance = constructor.newInstance(objArr);
                } catch (LogConfigurationException e3) {
                    throw e3;
                }
            } catch (ExceptionInInitializerError e5) {
                e = e5;
            } catch (NoClassDefFoundError e6) {
                e = e6;
            } catch (Throwable th) {
                th = th;
            }
            if (objNewInstance instanceof Log) {
                try {
                    log = (Log) objNewInstance;
                    cls3 = cls2;
                    break;
                } catch (ExceptionInInitializerError e7) {
                    e = e7;
                    cls3 = cls2;
                    String message = e.getMessage();
                    StringBuilder sbM15l2 = AbstractC0000a.m15l("The log adapter '", str, "' is unable to initialize itself when loaded via class loader ");
                    sbM15l2.append(LogFactory.objectId(baseClassLoader));
                    sbM15l2.append(": ");
                    sbM15l2.append(trim(message));
                    logDiagnostic(sbM15l2.toString());
                    log = null;
                } catch (NoClassDefFoundError e8) {
                    e = e8;
                    cls3 = cls2;
                    String message2 = e.getMessage();
                    StringBuilder sbM15l3 = AbstractC0000a.m15l("The log adapter '", str, "' is missing dependencies when loaded via class loader ");
                    sbM15l3.append(LogFactory.objectId(baseClassLoader));
                    sbM15l3.append(": ");
                    sbM15l3.append(trim(message2));
                    logDiagnostic(sbM15l3.toString());
                    log = null;
                } catch (Throwable th2) {
                    th = th2;
                    cls3 = cls2;
                    LogFactory.handleThrowable(th);
                    handleFlawedDiscovery(str, th);
                    if (baseClassLoader != null) {
                    }
                }
            } else {
                handleFlawedHierarchy(baseClassLoader, cls2);
                if (baseClassLoader != null) {
                    break;
                }
                baseClassLoader = getParentClassLoader(baseClassLoader);
            }
        }
        log = null;
        if (cls3 != null && z) {
            this.logClassName = str;
            this.logConstructor = constructor;
            try {
                this.logMethod = cls3.getMethod("setLogFactory", this.logMethodSignature);
                logDiagnostic("Found method setLogFactory(LogFactory) in '" + str + "'");
            } catch (Throwable th3) {
                LogFactory.handleThrowable(th3);
                this.logMethod = null;
                StringBuilder sbM15l4 = AbstractC0000a.m15l("[INFO] '", str, "' from class loader ");
                sbM15l4.append(LogFactory.objectId(baseClassLoader));
                sbM15l4.append(" does not declare optional method setLogFactory(LogFactory)");
                logDiagnostic(sbM15l4.toString());
            }
            StringBuilder sbM15l5 = AbstractC0000a.m15l("Log adapter '", str, "' from class loader ");
            sbM15l5.append(LogFactory.objectId(cls3.getClassLoader()));
            sbM15l5.append(" has been selected for use.");
            logDiagnostic(sbM15l5.toString());
        }
        return log;
    }

    private Log discoverLogImplementation(String str) {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Discovering a Log implementation...");
        }
        initConfiguration();
        String strFindUserSpecifiedLogClassName = findUserSpecifiedLogClassName();
        if (strFindUserSpecifiedLogClassName == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("No user-specified Log implementation; performing discovery using the standard supported logging implementations...");
            }
            Log logCreateLogFromClass = null;
            int i = 0;
            while (true) {
                String[] strArr = classesToDiscover;
                if (i >= strArr.length || logCreateLogFromClass != null) {
                    break;
                }
                logCreateLogFromClass = createLogFromClass(strArr[i], str, true);
                i++;
            }
            if (logCreateLogFromClass != null) {
                return logCreateLogFromClass;
            }
            throw new LogConfigurationException("No suitable Log implementation");
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Attempting to load user-specified log class '" + strFindUserSpecifiedLogClassName + "'...");
        }
        Log logCreateLogFromClass2 = createLogFromClass(strFindUserSpecifiedLogClassName, str, true);
        if (logCreateLogFromClass2 != null) {
            return logCreateLogFromClass2;
        }
        StringBuilder sbM15l = AbstractC0000a.m15l("User-specified log class '", strFindUserSpecifiedLogClassName, "' cannot be found or is not useable.");
        informUponSimilarName(sbM15l, strFindUserSpecifiedLogClassName, LOGGING_IMPL_LOG4J_LOGGER);
        informUponSimilarName(sbM15l, strFindUserSpecifiedLogClassName, LOGGING_IMPL_JDK14_LOGGER);
        informUponSimilarName(sbM15l, strFindUserSpecifiedLogClassName, LOGGING_IMPL_LUMBERJACK_LOGGER);
        informUponSimilarName(sbM15l, strFindUserSpecifiedLogClassName, LOGGING_IMPL_SIMPLE_LOGGER);
        throw new LogConfigurationException(sbM15l.toString());
    }

    private String findUserSpecifiedLogClassName() {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.Log'");
        }
        String systemProperty = (String) getAttribute(LOG_PROPERTY);
        if (systemProperty == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.log'");
            }
            systemProperty = (String) getAttribute(LOG_PROPERTY_OLD);
        }
        if (systemProperty == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.Log'");
            }
            try {
                systemProperty = getSystemProperty(LOG_PROPERTY, null);
            } catch (SecurityException e) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("No access allowed to system property 'org.apache.commons.logging.Log' - " + e.getMessage());
                }
            }
        }
        if (systemProperty == null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.log'");
            }
            try {
                systemProperty = getSystemProperty(LOG_PROPERTY_OLD, null);
            } catch (SecurityException e2) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("No access allowed to system property 'org.apache.commons.logging.log' - " + e2.getMessage());
                }
            }
        }
        return systemProperty != null ? systemProperty.trim() : systemProperty;
    }

    private ClassLoader getBaseClassLoader() {
        ClassLoader classLoader = getClassLoader(LogFactoryImpl.class);
        if (!this.useTCCL) {
            return classLoader;
        }
        ClassLoader contextClassLoaderInternal = getContextClassLoaderInternal();
        ClassLoader lowestClassLoader = getLowestClassLoader(contextClassLoaderInternal, classLoader);
        if (lowestClassLoader == null) {
            if (!this.allowFlawedContext) {
                throw new LogConfigurationException("Bad class loader hierarchy; LogFactoryImpl was loaded via a class loader that is not related to the current context class loader.");
            }
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[WARNING] the context class loader is not part of a parent-child relationship with the class loader that loaded LogFactoryImpl.");
            }
            return contextClassLoaderInternal;
        }
        if (lowestClassLoader != contextClassLoaderInternal) {
            if (!this.allowFlawedContext) {
                throw new LogConfigurationException("Bad class loader hierarchy; LogFactoryImpl was loaded via a class loader that is not related to the current context class loader.");
            }
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Warning: the context class loader is an ancestor of the class loader that loaded LogFactoryImpl; it should be the same or a descendant. The application using commons-logging should ensure the context class loader is used correctly.");
                return lowestClassLoader;
            }
        }
        return lowestClassLoader;
    }

    private boolean getBooleanConfiguration(String str, boolean z) {
        String configurationValue = getConfigurationValue(str);
        return configurationValue == null ? z : Boolean.parseBoolean(configurationValue);
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return LogFactory.getClassLoader(cls);
    }

    private String getConfigurationValue(String str) {
        String systemProperty;
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] Trying to get configuration for item " + str);
        }
        Object attribute = getAttribute(str);
        if (attribute != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[ENV] Found LogFactory attribute [" + attribute + "] for " + str);
            }
            return attribute.toString();
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] No LogFactory attribute found for " + str);
        }
        try {
            systemProperty = getSystemProperty(str, null);
        } catch (SecurityException unused) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[ENV] Security prevented reading system property " + str);
            }
        }
        if (systemProperty != null) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("[ENV] Found system property [" + systemProperty + "] for " + str);
            }
            return systemProperty;
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] No system property found for property " + str);
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[ENV] No configuration defined for item " + str);
        }
        return null;
    }

    public static ClassLoader getContextClassLoader() {
        return LogFactory.getContextClassLoader();
    }

    private static ClassLoader getContextClassLoaderInternal() {
        return (ClassLoader) AccessController.doPrivileged(new C13936d(1));
    }

    private ClassLoader getLowestClassLoader(ClassLoader classLoader, ClassLoader classLoader2) {
        if (classLoader == null) {
            return classLoader2;
        }
        if (classLoader2 != null) {
            ClassLoader parentClassLoader = classLoader;
            while (parentClassLoader != null) {
                if (parentClassLoader != classLoader2) {
                    parentClassLoader = getParentClassLoader(parentClassLoader);
                }
            }
            ClassLoader parentClassLoader2 = classLoader2;
            while (parentClassLoader2 != null) {
                if (parentClassLoader2 == classLoader) {
                    return classLoader2;
                }
                parentClassLoader2 = getParentClassLoader(parentClassLoader2);
            }
            return null;
        }
        return classLoader;
    }

    private ClassLoader getParentClassLoader(ClassLoader classLoader) {
        try {
            return (ClassLoader) AccessController.doPrivileged(new C13942a(classLoader, 0));
        } catch (SecurityException unused) {
            logDiagnostic("[SECURITY] Unable to obtain parent class loader");
            return null;
        }
    }

    private static String getSystemProperty(String str, String str2) {
        return (String) AccessController.doPrivileged(new C13938f(str, str2, 1));
    }

    private void handleFlawedDiscovery(String str, Throwable th) {
        Throwable targetException;
        Throwable cause;
        if (isDiagnosticsEnabled()) {
            StringBuilder sbM15l = AbstractC0000a.m15l("Could not instantiate Log '", str, "' -- ");
            sbM15l.append(th.getClass().getName());
            sbM15l.append(": ");
            sbM15l.append(th.getLocalizedMessage());
            logDiagnostic(sbM15l.toString());
            if ((th instanceof InvocationTargetException) && (targetException = ((InvocationTargetException) th).getTargetException()) != null) {
                logDiagnostic("... InvocationTargetException: " + targetException.getClass().getName() + ": " + targetException.getLocalizedMessage());
                if ((targetException instanceof ExceptionInInitializerError) && (cause = ((ExceptionInInitializerError) targetException).getCause()) != null) {
                    StringWriter stringWriter = new StringWriter();
                    cause.printStackTrace(new PrintWriter((Writer) stringWriter, true));
                    logDiagnostic("... ExceptionInInitializerError: " + stringWriter.toString());
                }
            }
        }
        if (!this.allowFlawedDiscovery) {
            throw new LogConfigurationException(th);
        }
    }

    private void handleFlawedHierarchy(ClassLoader classLoader, Class<?> cls) {
        String name = Log.class.getName();
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (name.equals(cls2.getName())) {
                if (isDiagnosticsEnabled()) {
                    try {
                        logDiagnostic("Class '" + cls.getName() + "' was found in class loader " + LogFactory.objectId(classLoader) + ". It is bound to a Log interface which is not the one loaded from class loader " + LogFactory.objectId(getClassLoader(Log.class)));
                    } catch (Throwable th) {
                        LogFactory.handleThrowable(th);
                        logDiagnostic("Error while trying to output diagnostics about bad class '" + cls + "'");
                    }
                }
                if (!this.allowFlawedHierarchy) {
                    StringBuilder sb = new StringBuilder("Terminating logging for this context due to bad log hierarchy. You have more than one version of '");
                    sb.append(Log.class.getName());
                    sb.append("' visible.");
                    if (isDiagnosticsEnabled()) {
                        logDiagnostic(sb.toString());
                    }
                    throw new LogConfigurationException(sb.toString());
                }
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("Warning: bad log hierarchy. You have more than one version of '" + Log.class.getName() + "' visible.");
                    return;
                }
                return;
            }
        }
        if (!this.allowFlawedDiscovery) {
            StringBuilder sb2 = new StringBuilder("Terminating logging for this context. Log class '");
            sb2.append(cls.getName());
            sb2.append("' does not implement the Log interface.");
            if (isDiagnosticsEnabled()) {
                logDiagnostic(sb2.toString());
            }
            throw new LogConfigurationException(sb2.toString());
        }
        if (isDiagnosticsEnabled()) {
            logDiagnostic("[WARNING] Log class '" + cls.getName() + "' does not implement the Log interface.");
        }
    }

    private void informUponSimilarName(StringBuilder sb, String str, String str2) {
        if (!str.equals(str2) && str.regionMatches(true, 0, str2, 0, PKG_LEN + 5)) {
            AbstractC1974b.m1332y(sb, " Did you mean '", str2, "'?");
        }
    }

    private void initConfiguration() {
        this.allowFlawedContext = getBooleanConfiguration(ALLOW_FLAWED_CONTEXT_PROPERTY, true);
        this.allowFlawedDiscovery = getBooleanConfiguration(ALLOW_FLAWED_DISCOVERY_PROPERTY, true);
        this.allowFlawedHierarchy = getBooleanConfiguration(ALLOW_FLAWED_HIERARCHY_PROPERTY, true);
    }

    private void initDiagnostics() {
        String strObjectId;
        ClassLoader classLoader = getClassLoader(getClass());
        if (classLoader == null) {
            strObjectId = "BOOTLOADER";
        } else {
            try {
                strObjectId = LogFactory.objectId(classLoader);
            } catch (SecurityException unused) {
                strObjectId = "UNKNOWN";
            }
        }
        this.diagnosticPrefix = "[LogFactoryImpl@" + System.identityHashCode(this) + " from " + strObjectId + "] ";
    }

    public static boolean isDiagnosticsEnabled() {
        return LogFactory.isDiagnosticsEnabled();
    }

    private boolean isLogLibraryAvailable(String str, String str2) {
        if (isDiagnosticsEnabled()) {
            logDiagnostic("Checking for '" + str + "'.");
        }
        try {
            if (createLogFromClass(str2, getClass().getName(), false) == null) {
                if (isDiagnosticsEnabled()) {
                    logDiagnostic("Did not find '" + str + "'.");
                }
                return false;
            }
            if (!isDiagnosticsEnabled()) {
                return true;
            }
            logDiagnostic("Found '" + str + "'.");
            return true;
        } catch (LogConfigurationException unused) {
            if (isDiagnosticsEnabled()) {
                logDiagnostic("Logging system '" + str + "' is available but not useable.");
            }
            return false;
        }
    }

    private static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        return (String[]) this.attributes.keySet().toArray(EMPTY_STRING_ARRAY);
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    @Deprecated
    public String getLogClassName() {
        if (this.logClassName == null) {
            discoverLogImplementation(getClass().getName());
        }
        return this.logClassName;
    }

    @Deprecated
    public Constructor<?> getLogConstructor() {
        if (this.logConstructor == null) {
            discoverLogImplementation(getClass().getName());
        }
        return this.logConstructor;
    }

    @Deprecated
    public boolean isJdk13LumberjackAvailable() {
        return isLogLibraryAvailable("Jdk13Lumberjack", LOGGING_IMPL_LUMBERJACK_LOGGER);
    }

    @Deprecated
    public boolean isJdk14Available() {
        return isLogLibraryAvailable("Jdk14", LOGGING_IMPL_JDK14_LOGGER);
    }

    @Deprecated
    public boolean isLog4JAvailable() {
        return isLogLibraryAvailable("Log4J", LOGGING_IMPL_LOG4J_LOGGER);
    }

    public void logDiagnostic(String str) {
        if (isDiagnosticsEnabled()) {
            LogFactory.logRawDiagnostic(this.diagnosticPrefix + str);
        }
    }

    public Log newInstance(String str) {
        try {
            Constructor<?> constructor = this.logConstructor;
            Log logDiscoverLogImplementation = constructor == null ? discoverLogImplementation(str) : (Log) constructor.newInstance(str);
            Method method = this.logMethod;
            if (method != null) {
                method.invoke(logDiscoverLogImplementation, this);
            }
            return logDiscoverLogImplementation;
        } catch (InvocationTargetException e) {
            e = e;
            Throwable targetException = e.getTargetException();
            if (targetException != null) {
                e = targetException;
            }
            throw new LogConfigurationException(e);
        } catch (LogConfigurationException e2) {
            throw e2;
        } catch (Throwable th) {
            LogFactory.handleThrowable(th);
            throw new LogConfigurationException(th);
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        logDiagnostic("Releasing all known loggers");
        this.instances.clear();
    }

    @Override // org.apache.commons.logging.LogFactory
    public void removeAttribute(String str) {
        this.attributes.remove(str);
    }

    @Override // org.apache.commons.logging.LogFactory
    public void setAttribute(String str, Object obj) {
        if (this.logConstructor != null) {
            logDiagnostic("setAttribute: call too late; configuration already performed.");
        }
        if (obj == null) {
            this.attributes.remove(str);
        } else {
            this.attributes.put(str, obj);
        }
        if (str.equals(LogFactory.TCCL_KEY)) {
            this.useTCCL = obj != null && Boolean.parseBoolean(obj.toString());
        }
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String str) {
        return this.instances.computeIfAbsent(str, new C0332a(this, 22));
    }
}
