package org.apache.commons.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GrowthList extends AbstractSerializableListDecorator {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public static List decorate(List list) {
        return new GrowthList(list);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public void add(int i, Object obj) {
        int size = getList().size();
        if (i > size) {
            getList().addAll(Collections.nCopies(i - size, null));
        }
        getList().add(i, obj);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection collection) {
        boolean z;
        int size = getList().size();
        if (i > size) {
            getList().addAll(Collections.nCopies(i - size, null));
            z = true;
        } else {
            z = false;
        }
        return getList().addAll(i, collection) | z;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object set(int i, Object obj) {
        int size = getList().size();
        if (i >= size) {
            getList().addAll(Collections.nCopies((i - size) + 1, null));
        }
        return getList().set(i, obj);
    }

    public GrowthList(int i) {
        super(new ArrayList(i));
    }

    public GrowthList(List list) {
        super(list);
    }
}
