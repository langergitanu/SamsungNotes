package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CloneTransformer implements Transformer, Serializable {
    public static final Transformer INSTANCE = new CloneTransformer();
    static /* synthetic */ Class class$org$apache$commons$collections$functors$CloneTransformer = null;
    private static final long serialVersionUID = -8188742709499652567L;

    private CloneTransformer() {
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Transformer getInstance() {
        return INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$CloneTransformer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.CloneTransformer");
            class$org$apache$commons$collections$functors$CloneTransformer = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$CloneTransformer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.CloneTransformer");
            class$org$apache$commons$collections$functors$CloneTransformer = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        if (obj == null) {
            return null;
        }
        return PrototypeFactory.getInstance(obj).create();
    }
}
