package com.adobe.internal.xmp.impl;

import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.XMPConst;
import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.options.PropertyOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class XMPNode implements Comparable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean alias;
    private List children;
    private boolean hasAliases;
    private boolean hasValueChild;
    private boolean implicit;
    private String name;
    private PropertyOptions options;
    private XMPNode parent;
    private List qualifier;
    private String value;

    public XMPNode(String str, String str2, PropertyOptions propertyOptions) {
        this.children = null;
        this.qualifier = null;
        this.name = str;
        this.value = str2;
        this.options = propertyOptions;
    }

    private void assertChildNotExisting(String str) throws XMPException {
        if (!XMPConst.ARRAY_ITEM_NAME.equals(str) && findChildByName(str) != null) {
            throw new XMPException(AbstractC0541b.m773o("Duplicate property or field node '", str, "'"), 203);
        }
    }

    private void assertQualifierNotExisting(String str) throws XMPException {
        if (!XMPConst.ARRAY_ITEM_NAME.equals(str) && findQualifierByName(str) != null) {
            throw new XMPException(AbstractC0541b.m773o("Duplicate '", str, "' qualifier"), 203);
        }
    }

    private XMPNode find(List list, String str) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            XMPNode xMPNode = (XMPNode) it.next();
            if (xMPNode.getName().equals(str)) {
                return xMPNode;
            }
        }
        return null;
    }

    private List getChildren() {
        if (this.children == null) {
            this.children = new ArrayList(0);
        }
        return this.children;
    }

    private boolean isLanguageNode() {
        return XMPConst.XML_LANG.equals(this.name);
    }

    private boolean isTypeNode() {
        return XMPConst.RDF_TYPE.equals(this.name);
    }

    public void addChild(XMPNode xMPNode) throws XMPException {
        assertChildNotExisting(xMPNode.getName());
        xMPNode.setParent(this);
        getChildren().add(xMPNode);
    }

    public void addQualifier(XMPNode xMPNode) throws XMPException {
        assertQualifierNotExisting(xMPNode.getName());
        xMPNode.setParent(this);
        xMPNode.getOptions().setQualifier(true);
        getOptions().setHasQualifiers(true);
        if (xMPNode.isLanguageNode()) {
            this.options.setHasLanguage(true);
            getQualifier().add(0, xMPNode);
        } else if (!xMPNode.isTypeNode()) {
            getQualifier().add(xMPNode);
        } else {
            this.options.setHasType(true);
            getQualifier().add(this.options.getHasLanguage() ? 1 : 0, xMPNode);
        }
    }

    public void cleanupChildren() {
        if (this.children.isEmpty()) {
            this.children = null;
        }
    }

    public void clear() {
        this.options = null;
        this.name = null;
        this.value = null;
        this.children = null;
        this.qualifier = null;
    }

    public Object clone() {
        return clone(false);
    }

    public void cloneSubtree(XMPNode xMPNode, boolean z) {
        try {
            Iterator itIterateChildren = iterateChildren();
            while (itIterateChildren.hasNext()) {
                XMPNode xMPNode2 = (XMPNode) itIterateChildren.next();
                if (!z || ((xMPNode2.getValue() != null && xMPNode2.getValue().length() != 0) || xMPNode2.hasChildren())) {
                    XMPNode xMPNode3 = (XMPNode) xMPNode2.clone(z);
                    if (xMPNode3 != null) {
                        xMPNode.addChild(xMPNode3);
                    }
                }
            }
            Iterator itIterateQualifier = iterateQualifier();
            while (itIterateQualifier.hasNext()) {
                XMPNode xMPNode4 = (XMPNode) itIterateQualifier.next();
                if (!z || ((xMPNode4.getValue() != null && xMPNode4.getValue().length() != 0) || xMPNode4.hasChildren())) {
                    XMPNode xMPNode5 = (XMPNode) xMPNode4.clone(z);
                    if (xMPNode5 != null) {
                        xMPNode.addQualifier(xMPNode5);
                    }
                }
            }
        } catch (XMPException unused) {
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return getOptions().isSchemaNode() ? this.value.compareTo(((XMPNode) obj).getValue()) : this.name.compareTo(((XMPNode) obj).getName());
    }

    public String dumpNode(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(512);
        dumpNode(stringBuffer, z, 0, 0);
        return stringBuffer.toString();
    }

    public XMPNode findChildByName(String str) {
        return find(getChildren(), str);
    }

    public XMPNode findQualifierByName(String str) {
        return find(this.qualifier, str);
    }

    public XMPNode getChild(int i) {
        return (XMPNode) getChildren().get(i - 1);
    }

    public int getChildrenLength() {
        List list = this.children;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean getHasAliases() {
        return this.hasAliases;
    }

    public boolean getHasValueChild() {
        return this.hasValueChild;
    }

    public String getName() {
        return this.name;
    }

    public PropertyOptions getOptions() {
        if (this.options == null) {
            this.options = new PropertyOptions();
        }
        return this.options;
    }

    public XMPNode getParent() {
        return this.parent;
    }

    public XMPNode getQualifier(int i) {
        return (XMPNode) getQualifier().get(i - 1);
    }

    public int getQualifierLength() {
        List list = this.qualifier;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List getUnmodifiableChildren() {
        return Collections.unmodifiableList(new ArrayList(getChildren()));
    }

    public String getValue() {
        return this.value;
    }

    public boolean hasChildren() {
        List list = this.children;
        return list != null && list.size() > 0;
    }

    public boolean hasQualifier() {
        List list = this.qualifier;
        return list != null && list.size() > 0;
    }

    public boolean isAlias() {
        return this.alias;
    }

    public boolean isImplicit() {
        return this.implicit;
    }

    public Iterator iterateChildren() {
        return this.children != null ? getChildren().iterator() : Collections.EMPTY_LIST.listIterator();
    }

    public Iterator iterateQualifier() {
        if (this.qualifier == null) {
            return Collections.EMPTY_LIST.iterator();
        }
        final Iterator it = getQualifier().iterator();
        return new Iterator() { // from class: com.adobe.internal.xmp.impl.XMPNode.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return it.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove() is not allowed due to the internal contraints");
            }
        };
    }

    public void removeChild(int i) {
        getChildren().remove(i - 1);
        cleanupChildren();
    }

    public void removeChildren() {
        this.children = null;
    }

    public void removeQualifier(XMPNode xMPNode) {
        PropertyOptions options = getOptions();
        if (xMPNode.isLanguageNode()) {
            options.setHasLanguage(false);
        } else if (xMPNode.isTypeNode()) {
            options.setHasType(false);
        }
        getQualifier().remove(xMPNode);
        if (this.qualifier.isEmpty()) {
            options.setHasQualifiers(false);
            this.qualifier = null;
        }
    }

    public void removeQualifiers() {
        PropertyOptions options = getOptions();
        options.setHasQualifiers(false);
        options.setHasLanguage(false);
        options.setHasType(false);
        this.qualifier = null;
    }

    public void replaceChild(int i, XMPNode xMPNode) {
        xMPNode.setParent(this);
        getChildren().set(i - 1, xMPNode);
    }

    public void setAlias(boolean z) {
        this.alias = z;
    }

    public void setHasAliases(boolean z) {
        this.hasAliases = z;
    }

    public void setHasValueChild(boolean z) {
        this.hasValueChild = z;
    }

    public void setImplicit(boolean z) {
        this.implicit = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOptions(PropertyOptions propertyOptions) {
        this.options = propertyOptions;
    }

    public void setParent(XMPNode xMPNode) {
        this.parent = xMPNode;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void sort() {
        if (hasQualifier()) {
            XMPNode[] xMPNodeArr = (XMPNode[]) getQualifier().toArray(new XMPNode[getQualifierLength()]);
            int i = 0;
            while (xMPNodeArr.length > i && (XMPConst.XML_LANG.equals(xMPNodeArr[i].getName()) || XMPConst.RDF_TYPE.equals(xMPNodeArr[i].getName()))) {
                xMPNodeArr[i].sort();
                i++;
            }
            Arrays.sort(xMPNodeArr, i, xMPNodeArr.length);
            ListIterator listIterator = this.qualifier.listIterator();
            for (int i2 = 0; i2 < xMPNodeArr.length; i2++) {
                listIterator.next();
                listIterator.set(xMPNodeArr[i2]);
                xMPNodeArr[i2].sort();
            }
        }
        if (hasChildren()) {
            if (!getOptions().isArray()) {
                Collections.sort(this.children);
            }
            Iterator itIterateChildren = iterateChildren();
            while (itIterateChildren.hasNext()) {
                ((XMPNode) itIterateChildren.next()).sort();
            }
        }
    }

    private List getQualifier() {
        if (this.qualifier == null) {
            this.qualifier = new ArrayList(0);
        }
        return this.qualifier;
    }

    public Object clone(boolean z) {
        PropertyOptions propertyOptions;
        try {
            propertyOptions = new PropertyOptions(getOptions().getOptions());
        } catch (XMPException unused) {
            propertyOptions = new PropertyOptions();
        }
        XMPNode xMPNode = new XMPNode(this.name, this.value, propertyOptions);
        cloneSubtree(xMPNode, z);
        if (!z) {
            return xMPNode;
        }
        if ((xMPNode.getValue() == null || xMPNode.getValue().length() == 0) && !xMPNode.hasChildren()) {
            return null;
        }
        return xMPNode;
    }

    public void removeChild(XMPNode xMPNode) {
        getChildren().remove(xMPNode);
        cleanupChildren();
    }

    private void dumpNode(StringBuffer stringBuffer, boolean z, int i, int i2) {
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            stringBuffer.append('\t');
        }
        if (this.parent != null) {
            if (getOptions().isQualifier()) {
                stringBuffer.append('?');
                stringBuffer.append(this.name);
            } else if (getParent().getOptions().isArray()) {
                stringBuffer.append(PropertyUtils.INDEXED_DELIM);
                stringBuffer.append(i2);
                stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
            } else {
                stringBuffer.append(this.name);
            }
        } else {
            stringBuffer.append("ROOT NODE");
            String str = this.name;
            if (str != null && str.length() > 0) {
                stringBuffer.append(" (");
                stringBuffer.append(this.name);
                stringBuffer.append(PropertyUtils.MAPPED_DELIM2);
            }
        }
        String str2 = this.value;
        if (str2 != null && str2.length() > 0) {
            stringBuffer.append(" = \"");
            stringBuffer.append(this.value);
            stringBuffer.append('\"');
        }
        if (getOptions().containsOneOf(-1)) {
            stringBuffer.append("\t(");
            stringBuffer.append(getOptions().toString());
            stringBuffer.append(" : ");
            stringBuffer.append(getOptions().getOptionsString());
            stringBuffer.append(PropertyUtils.MAPPED_DELIM2);
        }
        stringBuffer.append('\n');
        if (z && hasQualifier()) {
            XMPNode[] xMPNodeArr = (XMPNode[]) getQualifier().toArray(new XMPNode[getQualifierLength()]);
            int i6 = 0;
            while (xMPNodeArr.length > i6 && (XMPConst.XML_LANG.equals(xMPNodeArr[i6].getName()) || XMPConst.RDF_TYPE.equals(xMPNodeArr[i6].getName()))) {
                i6++;
            }
            Arrays.sort(xMPNodeArr, i6, xMPNodeArr.length);
            int i7 = 0;
            while (i7 < xMPNodeArr.length) {
                i7++;
                xMPNodeArr[i7].dumpNode(stringBuffer, z, i + 2, i7);
            }
        }
        if (z && hasChildren()) {
            XMPNode[] xMPNodeArr2 = (XMPNode[]) getChildren().toArray(new XMPNode[getChildrenLength()]);
            if (!getOptions().isArray()) {
                Arrays.sort(xMPNodeArr2);
            }
            while (i4 < xMPNodeArr2.length) {
                i4++;
                xMPNodeArr2[i4].dumpNode(stringBuffer, z, i + 1, i4);
            }
        }
    }

    public void addChild(int i, XMPNode xMPNode) throws XMPException {
        assertChildNotExisting(xMPNode.getName());
        xMPNode.setParent(this);
        getChildren().add(i - 1, xMPNode);
    }

    public XMPNode(String str, PropertyOptions propertyOptions) {
        this(str, null, propertyOptions);
    }
}
