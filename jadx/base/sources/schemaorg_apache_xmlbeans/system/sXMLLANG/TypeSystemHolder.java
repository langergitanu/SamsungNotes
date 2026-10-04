package schemaorg_apache_xmlbeans.system.sXMLLANG;

import java.lang.reflect.Constructor;
import kotlin.collections.AbstractC12991c;
import org.apache.xmlbeans.SchemaTypeSystem;

/* JADX INFO: loaded from: classes11.dex */
public class TypeSystemHolder {
    static /* synthetic */ Class class$java$lang$Class;
    static /* synthetic */ Class class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder;
    public static final SchemaTypeSystem typeSystem = loadTypeSystem();

    private TypeSystemHolder() {
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private static final SchemaTypeSystem loadTypeSystem() throws Throwable {
        try {
            Class clsClass$ = class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder;
            if (clsClass$ == null) {
                clsClass$ = class$("schemaorg_apache_xmlbeans.system.sXMLLANG.TypeSystemHolder");
                class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder = clsClass$;
            }
            Class<?> cls = Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, clsClass$.getClassLoader());
            Class clsClass$2 = class$java$lang$Class;
            if (clsClass$2 == null) {
                clsClass$2 = class$("java.lang.Class");
                class$java$lang$Class = clsClass$2;
            }
            Constructor<?> constructor = cls.getConstructor(clsClass$2);
            Class clsClass$3 = class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder;
            if (clsClass$3 == null) {
                clsClass$3 = class$("schemaorg_apache_xmlbeans.system.sXMLLANG.TypeSystemHolder");
                class$schemaorg_apache_xmlbeans$system$sXMLLANG$TypeSystemHolder = clsClass$3;
            }
            return (SchemaTypeSystem) constructor.newInstance(clsClass$3);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", e);
        } catch (Exception e2) {
            StringBuffer stringBuffer = new StringBuffer("Could not instantiate SchemaTypeSystemImpl (");
            stringBuffer.append(e2.toString());
            stringBuffer.append("): is the version of xbean.jar correct?");
            throw new RuntimeException(stringBuffer.toString(), e2);
        }
    }
}
