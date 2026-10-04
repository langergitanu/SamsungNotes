package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReferenceMap extends AbstractReferenceMap implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
        super(0, 1, 16, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public ReferenceMap(int i, int i2) {
        super(i, i2, 16, 0.75f, false);
    }

    public ReferenceMap(int i, int i2, boolean z) {
        super(i, i2, 16, 0.75f, z);
    }

    public ReferenceMap(int i, int i2, int i4, float f) {
        super(i, i2, i4, f, false);
    }

    public ReferenceMap(int i, int i2, int i4, float f, boolean z) {
        super(i, i2, i4, f, z);
    }
}
