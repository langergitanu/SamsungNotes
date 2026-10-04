package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WhileClosure implements Closure, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$WhileClosure = null;
    private static final long serialVersionUID = -3110538116913760108L;
    private final Closure iClosure;
    private final boolean iDoLoop;
    private final Predicate iPredicate;

    public WhileClosure(Predicate predicate, Closure closure, boolean z) {
        this.iPredicate = predicate;
        this.iClosure = closure;
        this.iDoLoop = z;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Closure getInstance(Predicate predicate, Closure closure, boolean z) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        if (closure != null) {
            return new WhileClosure(predicate, closure, z);
        }
        throw new IllegalArgumentException("Closure must not be null");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$WhileClosure;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.WhileClosure");
            class$org$apache$commons$collections$functors$WhileClosure = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$WhileClosure;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.WhileClosure");
            class$org$apache$commons$collections$functors$WhileClosure = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.commons.collections.Closure
    public void execute(Object obj) {
        if (this.iDoLoop) {
            this.iClosure.execute(obj);
        }
        while (this.iPredicate.evaluate(obj)) {
            this.iClosure.execute(obj);
        }
    }

    public Closure getClosure() {
        return this.iClosure;
    }

    public Predicate getPredicate() {
        return this.iPredicate;
    }

    public boolean isDoLoop() {
        return this.iDoLoop;
    }
}
