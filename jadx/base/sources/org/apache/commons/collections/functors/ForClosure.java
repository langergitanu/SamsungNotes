package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Closure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ForClosure implements Closure, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$ForClosure = null;
    private static final long serialVersionUID = -1190120533393621674L;
    private final Closure iClosure;
    private final int iCount;

    public ForClosure(int i, Closure closure) {
        this.iCount = i;
        this.iClosure = closure;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Closure getInstance(int i, Closure closure) {
        return (i <= 0 || closure == null) ? NOPClosure.INSTANCE : i == 1 ? closure : new ForClosure(i, closure);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$ForClosure;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.ForClosure");
            class$org$apache$commons$collections$functors$ForClosure = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$ForClosure;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.ForClosure");
            class$org$apache$commons$collections$functors$ForClosure = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        for (int i = 0; i < this.iCount; i++) {
            this.iClosure.execute(obj);
        }
    }

    public Closure getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
