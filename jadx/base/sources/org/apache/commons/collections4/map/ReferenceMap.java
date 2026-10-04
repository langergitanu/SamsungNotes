package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.collections4.map.AbstractReferenceMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReferenceMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
        super(AbstractReferenceMap.ReferenceStrength.HARD, AbstractReferenceMap.ReferenceStrength.SOFT, 16, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, boolean z) {
        super(referenceStrength, referenceStrength2, 16, 0.75f, z);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i, float f) {
        super(referenceStrength, referenceStrength2, i, f, false);
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength referenceStrength, AbstractReferenceMap.ReferenceStrength referenceStrength2, int i, float f, boolean z) {
        super(referenceStrength, referenceStrength2, i, f, z);
    }
}
