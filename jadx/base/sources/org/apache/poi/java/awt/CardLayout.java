package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes10.dex */
public class CardLayout implements LayoutManager2, Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = -4328196481005934313L;
    int currentCard;
    int hgap;
    Vector vector;
    int vgap;

    public class Card implements Serializable {
        static final long serialVersionUID = 6640330810709497518L;
        public Component comp;
        public String name;

        public Card(String str, Component component) {
            this.name = str;
            this.comp = component;
        }
    }

    static {
        ObjectStreamField objectStreamField = new ObjectStreamField("tab", Hashtable.class);
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{objectStreamField, new ObjectStreamField("hgap", cls), new ObjectStreamField("vgap", cls), new ObjectStreamField("vector", Vector.class), new ObjectStreamField("currentCard", cls)};
    }

    public CardLayout() {
        this(0, 0);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = objectInputStream.readFields();
        this.hgap = fields.get("hgap", 0);
        this.vgap = fields.get("vgap", 0);
        if (!fields.defaulted("vector")) {
            this.vector = (Vector) fields.get("vector", (Object) null);
            this.currentCard = fields.get("currentCard", 0);
            return;
        }
        Hashtable hashtable = (Hashtable) fields.get("tab", (Object) null);
        this.vector = new Vector();
        if (hashtable == null || hashtable.isEmpty()) {
            return;
        }
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            Component component = (Component) hashtable.get(str);
            this.vector.add(new Card(str, component));
            if (component.isVisible()) {
                this.currentCard = this.vector.size() - 1;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Hashtable hashtable = new Hashtable();
        int size = this.vector.size();
        for (int i = 0; i < size; i++) {
            Card card = (Card) this.vector.get(i);
            hashtable.put(card.name, card.comp);
        }
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("hgap", this.hgap);
        putFieldPutFields.put("vgap", this.vgap);
        putFieldPutFields.put("vector", this.vector);
        putFieldPutFields.put("currentCard", this.currentCard);
        putFieldPutFields.put("tab", hashtable);
        objectOutputStream.writeFields();
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    @Deprecated
    public void addLayoutComponent(String str, Component component) {
        synchronized (component.getTreeLock()) {
            try {
                int i = 0;
                if (!this.vector.isEmpty()) {
                    component.setVisible(false);
                }
                while (true) {
                    if (i >= this.vector.size()) {
                        this.vector.add(new Card(str, component));
                        break;
                    } else {
                        if (((Card) this.vector.get(i)).name.equals(str)) {
                            ((Card) this.vector.get(i)).comp = component;
                            break;
                        }
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void checkLayout(Container container) {
        if (container.getLayout() != this) {
            throw new IllegalArgumentException("wrong parent for CardLayout");
        }
    }

    public void first(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                checkLayout(container);
                int componentCount = container.getComponentCount();
                int i = 0;
                while (true) {
                    if (i >= componentCount) {
                        break;
                    }
                    Component component = container.getComponent(i);
                    if (component.isVisible()) {
                        component.setVisible(false);
                        break;
                    }
                    i++;
                }
                if (componentCount > 0) {
                    this.currentCard = 0;
                    container.getComponent(0).setVisible(true);
                    container.validate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getHgap() {
        return this.hgap;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public float getLayoutAlignmentX(Container container) {
        return 0.5f;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public float getLayoutAlignmentY(Container container) {
        return 0.5f;
    }

    public int getVgap() {
        return this.vgap;
    }

    public void last(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                checkLayout(container);
                int componentCount = container.getComponentCount();
                int i = 0;
                while (true) {
                    if (i >= componentCount) {
                        break;
                    }
                    Component component = container.getComponent(i);
                    if (component.isVisible()) {
                        component.setVisible(false);
                        break;
                    }
                    i++;
                }
                if (componentCount > 0) {
                    int i2 = componentCount - 1;
                    this.currentCard = i2;
                    container.getComponent(i2).setVisible(true);
                    container.validate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void layoutContainer(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int componentCount = container.getComponentCount();
                boolean z = false;
                for (int i = 0; i < componentCount; i++) {
                    Component component = container.getComponent(i);
                    int i2 = this.hgap;
                    int i4 = insets.left;
                    int i5 = this.vgap;
                    int i6 = insets.top;
                    component.setBounds(i2 + i4, i5 + i6, container.width - (((i2 * 2) + i4) + insets.right), container.height - (((i5 * 2) + i6) + insets.bottom));
                    if (component.isVisible()) {
                        z = true;
                    }
                }
                if (!z && componentCount > 0) {
                    container.getComponent(0).setVisible(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public Dimension maximumLayoutSize(Container container) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension minimumLayoutSize(Container container) {
        Dimension dimension;
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int componentCount = container.getComponentCount();
                int i = 0;
                int i2 = 0;
                for (int i4 = 0; i4 < componentCount; i4++) {
                    Dimension minimumSize = container.getComponent(i4).getMinimumSize();
                    int i5 = minimumSize.width;
                    if (i5 > i) {
                        i = i5;
                    }
                    int i6 = minimumSize.height;
                    if (i6 > i2) {
                        i2 = i6;
                    }
                }
                dimension = new Dimension((this.hgap * 2) + insets.left + insets.right + i, (this.vgap * 2) + insets.top + insets.bottom + i2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    public void next(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                checkLayout(container);
                int componentCount = container.getComponentCount();
                int i = 0;
                while (true) {
                    if (i >= componentCount) {
                        showDefaultComponent(container);
                        break;
                    }
                    Component component = container.getComponent(i);
                    if (component.isVisible()) {
                        component.setVisible(false);
                        int i2 = (i + 1) % componentCount;
                        this.currentCard = i2;
                        container.getComponent(i2).setVisible(true);
                        container.validate();
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public Dimension preferredLayoutSize(Container container) {
        Dimension dimension;
        synchronized (container.getTreeLock()) {
            try {
                Insets insets = container.getInsets();
                int componentCount = container.getComponentCount();
                int i = 0;
                int i2 = 0;
                for (int i4 = 0; i4 < componentCount; i4++) {
                    Dimension preferredSize = container.getComponent(i4).getPreferredSize();
                    int i5 = preferredSize.width;
                    if (i5 > i) {
                        i = i5;
                    }
                    int i6 = preferredSize.height;
                    if (i6 > i2) {
                        i2 = i6;
                    }
                }
                dimension = new Dimension((this.hgap * 2) + insets.left + insets.right + i, (this.vgap * 2) + insets.top + insets.bottom + i2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimension;
    }

    public void previous(Container container) {
        synchronized (container.getTreeLock()) {
            try {
                checkLayout(container);
                int componentCount = container.getComponentCount();
                int i = 0;
                while (true) {
                    if (i >= componentCount) {
                        showDefaultComponent(container);
                        break;
                    }
                    Component component = container.getComponent(i);
                    if (component.isVisible()) {
                        component.setVisible(false);
                        int i2 = i > 0 ? i - 1 : componentCount - 1;
                        this.currentCard = i2;
                        container.getComponent(i2).setVisible(true);
                        container.validate();
                    } else {
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager
    public void removeLayoutComponent(Component component) {
        synchronized (component.getTreeLock()) {
            int i = 0;
            while (true) {
                try {
                    if (i >= this.vector.size()) {
                        break;
                    }
                    if (((Card) this.vector.get(i)).comp == component) {
                        if (component.isVisible() && component.getParent() != null) {
                            next(component.getParent());
                        }
                        this.vector.remove(i);
                        int i2 = this.currentCard;
                        if (i2 > i) {
                            this.currentCard = i2 - 1;
                        }
                    } else {
                        i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void setHgap(int i) {
        this.hgap = i;
    }

    public void setVgap(int i) {
        this.vgap = i;
    }

    public void show(Container container, String str) {
        Component component;
        synchronized (container.getTreeLock()) {
            try {
                checkLayout(container);
                int size = this.vector.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        component = null;
                        break;
                    }
                    Card card = (Card) this.vector.get(i);
                    if (card.name.equals(str)) {
                        component = card.comp;
                        this.currentCard = i;
                        break;
                    }
                    i++;
                }
                if (component != null && !component.isVisible()) {
                    int componentCount = container.getComponentCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= componentCount) {
                            break;
                        }
                        Component component2 = container.getComponent(i2);
                        if (component2.isVisible()) {
                            component2.setVisible(false);
                            break;
                        }
                        i2++;
                    }
                    component.setVisible(true);
                    container.validate();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void showDefaultComponent(Container container) throws Throwable {
        if (container.getComponentCount() > 0) {
            this.currentCard = 0;
            container.getComponent(0).setVisible(true);
            container.validate();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[hgap=");
        sb.append(this.hgap);
        sb.append(",vgap=");
        return AbstractC2821a.m2223n(sb, "]", this.vgap);
    }

    public CardLayout(int i, int i2) {
        this.vector = new Vector();
        this.currentCard = 0;
        this.hgap = i;
        this.vgap = i2;
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public void addLayoutComponent(Component component, Object obj) {
        synchronized (component.getTreeLock()) {
            if (obj == null) {
                obj = "";
            }
            try {
                if (!(obj instanceof String)) {
                    throw new IllegalArgumentException("cannot add to layout: constraint must be a string");
                }
                addLayoutComponent((String) obj, component);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.LayoutManager2
    public void invalidateLayout(Container container) {
    }
}
