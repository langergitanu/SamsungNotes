package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InvokerTransformer implements Transformer, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$InvokerTransformer = null;
    private static final long serialVersionUID = -8653385846894047688L;
    private final Object[] iArgs;
    private final String iMethodName;
    private final Class[] iParamTypes;

    private InvokerTransformer(String str) {
        this.iMethodName = str;
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Transformer getInstance(String str) {
        if (str != null) {
            return new InvokerTransformer(str);
        }
        throw new IllegalArgumentException("The method to invoke must not be null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$InvokerTransformer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.InvokerTransformer");
            class$org$apache$commons$collections$functors$InvokerTransformer = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$InvokerTransformer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.InvokerTransformer");
            class$org$apache$commons$collections$functors$InvokerTransformer = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod(this.iMethodName, this.iParamTypes).invoke(obj, this.iArgs);
        } catch (IllegalAccessException unused) {
            StringBuffer stringBuffer = new StringBuffer("InvokerTransformer: The method '");
            stringBuffer.append(this.iMethodName);
            stringBuffer.append("' on '");
            stringBuffer.append(obj.getClass());
            stringBuffer.append("' cannot be accessed");
            throw new FunctorException(stringBuffer.toString());
        } catch (NoSuchMethodException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer("InvokerTransformer: The method '");
            stringBuffer2.append(this.iMethodName);
            stringBuffer2.append("' on '");
            stringBuffer2.append(obj.getClass());
            stringBuffer2.append("' does not exist");
            throw new FunctorException(stringBuffer2.toString());
        } catch (InvocationTargetException e) {
            StringBuffer stringBuffer3 = new StringBuffer("InvokerTransformer: The method '");
            stringBuffer3.append(this.iMethodName);
            stringBuffer3.append("' on '");
            stringBuffer3.append(obj.getClass());
            stringBuffer3.append("' threw an exception");
            throw new FunctorException(stringBuffer3.toString(), e);
        }
    }

    public static Transformer getInstance(String str, Class[] clsArr, Object[] objArr) {
        if (str != null) {
            if ((clsArr == null && objArr != null) || ((clsArr != null && objArr == null) || (clsArr != null && objArr != null && clsArr.length != objArr.length))) {
                throw new IllegalArgumentException("The parameter types must match the arguments");
            }
            if (clsArr != null && clsArr.length != 0) {
                return new InvokerTransformer(str, (Class[]) clsArr.clone(), (Object[]) objArr.clone());
            }
            return new InvokerTransformer(str);
        }
        throw new IllegalArgumentException("The method to invoke must not be null");
    }

    public InvokerTransformer(String str, Class[] clsArr, Object[] objArr) {
        this.iMethodName = str;
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
    }
}
