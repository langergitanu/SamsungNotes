package org.apache.poi.java.awt;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EventListener;
import java.util.Locale;
import java.util.Vector;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleSelection;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.event.ActionEvent;
import org.apache.poi.java.awt.event.ActionListener;
import org.apache.poi.java.awt.event.FocusListener;
import org.apache.poi.java.awt.event.ItemEvent;
import org.apache.poi.java.awt.event.ItemListener;
import org.apache.poi.java.awt.peer.ComponentPeer;
import org.apache.poi.java.awt.peer.ListPeer;

/* JADX INFO: loaded from: classes10.dex */
public class List extends Component implements ItemSelectable, Accessible {
    static final int DEFAULT_VISIBLE_ROWS = 4;
    private static final String base = "list";
    private static int nameCounter = 0;
    private static final long serialVersionUID = -3304312411574666869L;
    transient ActionListener actionListener;
    transient ItemListener itemListener;
    Vector items;
    private int listSerializedDataVersion;
    boolean multipleMode;
    int rows;
    int[] selected;
    int visibleIndex;

    public class AccessibleAWTList extends Component.AccessibleAWTComponent implements AccessibleSelection, ItemListener, ActionListener {
        private static final long serialVersionUID = 7924617370136012829L;

        public AccessibleAWTList() {
            super();
            List.this.addActionListener(this);
            List.this.addItemListener(this);
        }

        public void addAccessibleSelection(int i) {
            List.this.select(i);
        }

        public void clearAccessibleSelection() {
            synchronized (List.this) {
                try {
                    int[] selectedIndexes = List.this.getSelectedIndexes();
                    if (selectedIndexes != null) {
                        for (int length = selectedIndexes.length - 1; length >= 0; length--) {
                            List.this.deselect(selectedIndexes[length]);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public Accessible getAccessibleAt(Point point) {
            return null;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public Accessible getAccessibleChild(int i) {
            synchronized (List.this) {
                try {
                    if (i >= List.this.getItemCount()) {
                        return null;
                    }
                    return new AccessibleAWTListChild(List.this, i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public int getAccessibleChildrenCount() {
            return List.this.getItemCount();
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.LIST;
        }

        public Accessible getAccessibleSelection(int i) {
            synchronized (List.this) {
                try {
                    int accessibleSelectionCount = getAccessibleSelectionCount();
                    if (i >= 0 && i < accessibleSelectionCount) {
                        return getAccessibleChild(List.this.getSelectedIndexes()[i]);
                    }
                    return null;
                } finally {
                }
            }
        }

        public int getAccessibleSelectionCount() {
            return List.this.getSelectedIndexes().length;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (List.this.isMultipleMode()) {
                accessibleStateSet.add(AccessibleState.MULTISELECTABLE);
            }
            return accessibleStateSet;
        }

        public boolean isAccessibleChildSelected(int i) {
            return List.this.isIndexSelected(i);
        }

        public void removeAccessibleSelection(int i) {
            List.this.deselect(i);
        }

        public void selectAllAccessibleSelection() {
            synchronized (List.this) {
                try {
                    for (int itemCount = List.this.getItemCount() - 1; itemCount >= 0; itemCount--) {
                        List.this.select(itemCount);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public AccessibleSelection getAccessibleSelection() {
            return this;
        }

        public class AccessibleAWTListChild extends Component.AccessibleAWTComponent implements Accessible {
            private static final long serialVersionUID = 4412022926028300317L;
            private int indexInParent;
            private List parent;

            public AccessibleAWTListChild(List list, int i) {
                super();
                this.parent = list;
                setAccessibleParent(list);
                this.indexInParent = i;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public boolean contains(Point point) {
                return false;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Accessible getAccessibleAt(Point point) {
                return null;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Accessible getAccessibleChild(int i) {
                return null;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public int getAccessibleChildrenCount() {
                return 0;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public int getAccessibleIndexInParent() {
                return this.indexInParent;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public AccessibleRole getAccessibleRole() {
                return AccessibleRole.LIST_ITEM;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public AccessibleStateSet getAccessibleStateSet() {
                AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
                if (this.parent.isIndexSelected(this.indexInParent)) {
                    accessibleStateSet.add(AccessibleState.SELECTED);
                }
                return accessibleStateSet;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Color getBackground() {
                return this.parent.getBackground();
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Rectangle getBounds() {
                return null;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Cursor getCursor() {
                return this.parent.getCursor();
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Font getFont() {
                return this.parent.getFont();
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public FontMetrics getFontMetrics(Font font) {
                return this.parent.getFontMetrics(font);
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Color getForeground() {
                return this.parent.getForeground();
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Locale getLocale() {
                return this.parent.getLocale();
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Point getLocation() {
                return null;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Point getLocationOnScreen() {
                return null;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public Dimension getSize() {
                return null;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public boolean isEnabled() {
                return this.parent.isEnabled();
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public boolean isFocusTraversable() {
                return false;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public boolean isShowing() {
                return false;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public boolean isVisible() {
                return false;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setBackground(Color color) {
                this.parent.setBackground(color);
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setCursor(Cursor cursor) {
                this.parent.setCursor(cursor);
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setEnabled(boolean z) {
                this.parent.setEnabled(z);
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setFont(Font font) {
                this.parent.setFont(font);
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setForeground(Color color) {
                this.parent.setForeground(color);
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setVisible(boolean z) throws Throwable {
                this.parent.setVisible(z);
            }

            public AccessibleContext getAccessibleContext() {
                return this;
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void requestFocus() {
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void addFocusListener(FocusListener focusListener) {
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void removeFocusListener(FocusListener focusListener) {
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setBounds(Rectangle rectangle) {
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setLocation(Point point) {
            }

            @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
            public void setSize(Dimension dimension) {
            }
        }

        public void actionPerformed(ActionEvent actionEvent) {
        }

        public void itemStateChanged(ItemEvent itemEvent) {
        }
    }

    public List() {
        this(0, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        objectInputStream.defaultReadObject();
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            }
            String strIntern = ((String) object).intern();
            if ("itemL" == strIntern) {
                addItemListener((ItemListener) objectInputStream.readObject());
            } else if ("actionL" == strIntern) {
                addActionListener((ActionListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        synchronized (this) {
            try {
                ListPeer listPeer = this.peer;
                if (listPeer != null) {
                    this.selected = listPeer.getSelectedIndexes();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, "itemL", this.itemListener);
        AWTEventMulticaster.save(objectOutputStream, "actionL", this.actionListener);
        objectOutputStream.writeObject(null);
    }

    public void add(String str) {
        addItem(str);
    }

    public synchronized void addActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.add(this.actionListener, actionListener);
        this.newEventsOnly = true;
    }

    @Deprecated
    public void addItem(String str) {
        addItem(str, -1);
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void addItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.add(this.itemListener, itemListener);
        this.newEventsOnly = true;
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                if (this.peer == null) {
                    this.peer = getToolkit().createList(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public boolean allowsMultipleSelections() {
        return this.multipleMode;
    }

    @Deprecated
    public synchronized void clear() {
        try {
            ListPeer listPeer = this.peer;
            if (listPeer != null) {
                listPeer.removeAll();
            }
            this.items = new Vector();
            this.selected = new int[0];
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (List.class) {
            StringBuilder sb = new StringBuilder("list");
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    @Deprecated
    public int countItems() {
        return this.items.size();
    }

    @Deprecated
    public void delItem(int i) {
        delItems(i, i);
    }

    @Deprecated
    public synchronized void delItems(int i, int i2) {
        for (int i4 = i2; i4 >= i; i4--) {
            try {
                this.items.removeElementAt(i4);
            } catch (Throwable th) {
                throw th;
            }
        }
        ListPeer listPeer = this.peer;
        if (listPeer != null) {
            listPeer.delItems(i, i2);
        }
    }

    public synchronized void deselect(int i) {
        try {
            ListPeer listPeer = this.peer;
            if (listPeer != null && (isMultipleMode() || getSelectedIndex() == i)) {
                listPeer.deselect(i);
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.selected;
                if (i2 >= iArr.length) {
                    return;
                }
                if (iArr[i2] == i) {
                    int[] iArr2 = new int[iArr.length - 1];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    int[] iArr3 = this.selected;
                    int i4 = i2 + 1;
                    System.arraycopy(iArr3, i4, iArr2, i2, iArr3.length - i4);
                    this.selected = iArr2;
                    return;
                }
                i2++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        int i = aWTEvent.f10031id;
        return i != 701 ? i != 1001 ? super.eventEnabled(aWTEvent) : ((this.eventMask & 128) == 0 && this.actionListener == null) ? false : true : ((this.eventMask & 512) == 0 && this.itemListener == null) ? false : true;
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTList();
        }
        return this.accessibleContext;
    }

    public synchronized ActionListener[] getActionListeners() {
        return getListeners(ActionListener.class);
    }

    public String getItem(int i) {
        return getItemImpl(i);
    }

    public int getItemCount() {
        return countItems();
    }

    public final String getItemImpl(int i) {
        return (String) this.items.elementAt(i);
    }

    public synchronized ItemListener[] getItemListeners() {
        return getListeners(ItemListener.class);
    }

    public synchronized String[] getItems() {
        String[] strArr;
        strArr = new String[this.items.size()];
        this.items.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        ActionListener actionListener;
        if (cls == ActionListener.class) {
            actionListener = this.actionListener;
        } else {
            if (cls != ItemListener.class) {
                return (T[]) super.getListeners(cls);
            }
            actionListener = this.itemListener;
        }
        return (T[]) AWTEventMulticaster.getListeners(actionListener, cls);
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getMinimumSize() {
        return minimumSize();
    }

    @Override // org.apache.poi.java.awt.Component
    public Dimension getPreferredSize() {
        return preferredSize();
    }

    public int getRows() {
        return this.rows;
    }

    public synchronized int getSelectedIndex() {
        int[] selectedIndexes;
        selectedIndexes = getSelectedIndexes();
        return selectedIndexes.length == 1 ? selectedIndexes[0] : -1;
    }

    public synchronized int[] getSelectedIndexes() {
        try {
            ListPeer listPeer = this.peer;
            if (listPeer != null) {
                this.selected = listPeer.getSelectedIndexes();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (int[]) this.selected.clone();
    }

    public synchronized String getSelectedItem() {
        int selectedIndex;
        selectedIndex = getSelectedIndex();
        return selectedIndex < 0 ? null : getItem(selectedIndex);
    }

    public synchronized String[] getSelectedItems() {
        String[] strArr;
        int[] selectedIndexes = getSelectedIndexes();
        strArr = new String[selectedIndexes.length];
        for (int i = 0; i < selectedIndexes.length; i++) {
            strArr[i] = getItem(selectedIndexes[i]);
        }
        return strArr;
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public Object[] getSelectedObjects() {
        return getSelectedItems();
    }

    public int getVisibleIndex() {
        return this.visibleIndex;
    }

    public boolean isIndexSelected(int i) {
        return isSelected(i);
    }

    public boolean isMultipleMode() {
        return allowsMultipleSelections();
    }

    @Deprecated
    public boolean isSelected(int i) {
        for (int i2 : getSelectedIndexes()) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public synchronized void makeVisible(int i) {
        this.visibleIndex = i;
        ListPeer listPeer = this.peer;
        if (listPeer != null) {
            listPeer.makeVisible(i);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension minimumSize() {
        Dimension dimensionMinimumSize;
        synchronized (getTreeLock()) {
            try {
                int i = this.rows;
                dimensionMinimumSize = i > 0 ? minimumSize(i) : super.minimumSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimensionMinimumSize;
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        return super.paramString() + ",selected=" + getSelectedItem();
    }

    @Override // org.apache.poi.java.awt.Component
    @Deprecated
    public Dimension preferredSize() {
        Dimension dimensionPreferredSize;
        synchronized (getTreeLock()) {
            try {
                int i = this.rows;
                dimensionPreferredSize = i > 0 ? preferredSize(i) : super.preferredSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return dimensionPreferredSize;
    }

    public void processActionEvent(ActionEvent actionEvent) {
        ActionListener actionListener = this.actionListener;
        if (actionListener != null) {
            actionListener.actionPerformed(actionEvent);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public void processItemEvent(ItemEvent itemEvent) {
        ItemListener itemListener = this.itemListener;
        if (itemListener != null) {
            itemListener.itemStateChanged(itemEvent);
        }
    }

    public void remove(int i) {
        delItem(i);
    }

    public synchronized void removeActionListener(ActionListener actionListener) {
        if (actionListener == null) {
            return;
        }
        this.actionListener = AWTEventMulticaster.remove(this.actionListener, actionListener);
    }

    public void removeAll() {
        clear();
    }

    @Override // org.apache.poi.java.awt.ItemSelectable
    public synchronized void removeItemListener(ItemListener itemListener) {
        if (itemListener == null) {
            return;
        }
        this.itemListener = AWTEventMulticaster.remove(this.itemListener, itemListener);
    }

    @Override // org.apache.poi.java.awt.Component
    public void removeNotify() {
        synchronized (getTreeLock()) {
            try {
                ListPeer listPeer = this.peer;
                if (listPeer != null) {
                    this.selected = listPeer.getSelectedIndexes();
                }
                super.removeNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void replaceItem(String str, int i) {
        remove(i);
        add(str, i);
    }

    public void select(int i) {
        ComponentPeer componentPeer;
        do {
            componentPeer = (ListPeer) this.peer;
            if (componentPeer != null) {
                componentPeer.select(i);
                return;
            }
            synchronized (this) {
                int i2 = 0;
                while (true) {
                    try {
                        int[] iArr = this.selected;
                        if (i2 < iArr.length) {
                            if (iArr[i2] == i) {
                                break;
                            } else {
                                i2++;
                            }
                        } else if (this.multipleMode) {
                            int[] iArr2 = new int[iArr.length + 1];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[this.selected.length] = i;
                            this.selected = iArr2;
                        } else {
                            this.selected = new int[]{i};
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } while (componentPeer != this.peer);
    }

    public void setMultipleMode(boolean z) {
        setMultipleSelections(z);
    }

    @Deprecated
    public synchronized void setMultipleSelections(boolean z) {
        if (z != this.multipleMode) {
            this.multipleMode = z;
            ListPeer listPeer = this.peer;
            if (listPeer != null) {
                listPeer.setMultipleMode(z);
            }
        }
    }

    public List(int i) {
        this(i, false);
    }

    public void add(String str, int i) {
        addItem(str, i);
    }

    @Deprecated
    public synchronized void addItem(String str, int i) {
        if (i >= -1) {
            try {
                if (i >= this.items.size()) {
                    i = -1;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            i = -1;
        }
        if (str == null) {
            str = "";
        }
        if (i == -1) {
            this.items.addElement(str);
        } else {
            this.items.insertElementAt(str, i);
        }
        ListPeer listPeer = this.peer;
        if (listPeer != null) {
            listPeer.add(str, i);
        }
    }

    public Dimension getMinimumSize(int i) {
        return minimumSize(i);
    }

    public Dimension getPreferredSize(int i) {
        return preferredSize(i);
    }

    @Deprecated
    public Dimension minimumSize(int i) {
        Dimension minimumSize;
        synchronized (getTreeLock()) {
            try {
                ListPeer listPeer = this.peer;
                minimumSize = listPeer != null ? listPeer.getMinimumSize(i) : super.minimumSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return minimumSize;
    }

    @Deprecated
    public Dimension preferredSize(int i) {
        Dimension preferredSize;
        synchronized (getTreeLock()) {
            try {
                ListPeer listPeer = this.peer;
                preferredSize = listPeer != null ? listPeer.getPreferredSize(i) : super.preferredSize();
            } catch (Throwable th) {
                throw th;
            }
        }
        return preferredSize;
    }

    public synchronized void remove(String str) {
        int iIndexOf = this.items.indexOf(str);
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("item " + str + " not found in list");
        }
        remove(iIndexOf);
    }

    public List(int i, boolean z) {
        this.items = new Vector();
        this.rows = 0;
        this.multipleMode = false;
        this.selected = new int[0];
        this.visibleIndex = -1;
        this.listSerializedDataVersion = 1;
        GraphicsEnvironment.checkHeadless();
        this.rows = i == 0 ? 4 : i;
        this.multipleMode = z;
    }
}
