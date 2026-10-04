package org.apache.poi.javax.imageio.metadata;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IIOMetadata {
    protected IIOMetadataController controller;
    protected IIOMetadataController defaultController;
    protected String[] extraMetadataFormatClassNames;
    protected String[] extraMetadataFormatNames;
    protected String nativeMetadataFormatClassName;
    protected String nativeMetadataFormatName;
    protected boolean standardFormatSupported;

    public IIOMetadata() {
        this.nativeMetadataFormatName = null;
        this.nativeMetadataFormatClassName = null;
        this.extraMetadataFormatNames = null;
        this.extraMetadataFormatClassNames = null;
        this.defaultController = null;
        this.controller = null;
    }

    private void append(IIOMetadataNode iIOMetadataNode, IIOMetadataNode iIOMetadataNode2) {
        if (iIOMetadataNode2 != null) {
            iIOMetadataNode.appendChild(iIOMetadataNode2);
        }
    }

    public boolean activateController() {
        if (hasController()) {
            return getController().activate(this);
        }
        throw new IllegalStateException("hasController() == false!");
    }

    public abstract Node getAsTree(String str);

    public IIOMetadataController getController() {
        return this.controller;
    }

    public IIOMetadataController getDefaultController() {
        return this.defaultController;
    }

    public String[] getExtraMetadataFormatNames() {
        String[] strArr = this.extraMetadataFormatNames;
        if (strArr == null) {
            return null;
        }
        return (String[]) strArr.clone();
    }

    public IIOMetadataFormat getMetadataFormat(String str) {
        String str2;
        Class<?> cls;
        if (str == null) {
            throw new IllegalArgumentException("formatName == null!");
        }
        if (this.standardFormatSupported && str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            return IIOMetadataFormatImpl.getStandardFormatInstance();
        }
        if (str.equals(this.nativeMetadataFormatName)) {
            str2 = this.nativeMetadataFormatClassName;
        } else if (this.extraMetadataFormatNames != null) {
            int i = 0;
            while (true) {
                String[] strArr = this.extraMetadataFormatNames;
                if (i >= strArr.length) {
                    break;
                }
                if (str.equals(strArr[i])) {
                    str2 = this.extraMetadataFormatClassNames[i];
                    break;
                }
                i++;
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Unsupported format name");
        }
        try {
            try {
                cls = Class.forName(str2, true, (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.metadata.IIOMetadata.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        return this.getClass().getClassLoader();
                    }
                }));
            } catch (ClassNotFoundException unused) {
                try {
                    cls = Class.forName(str2, true, (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.poi.javax.imageio.metadata.IIOMetadata.2
                        @Override // java.security.PrivilegedAction
                        public Object run() {
                            return Thread.currentThread().getContextClassLoader();
                        }
                    }));
                } catch (ClassNotFoundException unused2) {
                    cls = Class.forName(str2, true, ClassLoader.getSystemClassLoader());
                }
            }
            return (IIOMetadataFormat) cls.getMethod("getInstance", null).invoke(null, null);
        } catch (Exception e) {
            IllegalStateException illegalStateException = new IllegalStateException("Can't obtain format");
            illegalStateException.initCause(e);
            throw illegalStateException;
        }
    }

    public String[] getMetadataFormatNames() {
        String nativeMetadataFormatName = getNativeMetadataFormatName();
        String str = isStandardMetadataFormatSupported() ? IIOMetadataFormatImpl.standardMetadataFormatName : null;
        String[] extraMetadataFormatNames = getExtraMetadataFormatNames();
        int i = 0;
        int i2 = 1;
        int length = nativeMetadataFormatName != null ? 1 : 0;
        if (str != null) {
            length++;
        }
        if (extraMetadataFormatNames != null) {
            length += extraMetadataFormatNames.length;
        }
        if (length == 0) {
            return null;
        }
        String[] strArr = new String[length];
        if (nativeMetadataFormatName != null) {
            strArr[0] = nativeMetadataFormatName;
        } else {
            i2 = 0;
        }
        if (str != null) {
            strArr[i2] = str;
            i2++;
        }
        if (extraMetadataFormatNames != null) {
            while (i < extraMetadataFormatNames.length) {
                strArr[i2] = extraMetadataFormatNames[i];
                i++;
                i2++;
            }
        }
        return strArr;
    }

    public String getNativeMetadataFormatName() {
        return this.nativeMetadataFormatName;
    }

    public IIOMetadataNode getStandardChromaNode() {
        return null;
    }

    public IIOMetadataNode getStandardCompressionNode() {
        return null;
    }

    public IIOMetadataNode getStandardDataNode() {
        return null;
    }

    public IIOMetadataNode getStandardDimensionNode() {
        return null;
    }

    public IIOMetadataNode getStandardDocumentNode() {
        return null;
    }

    public IIOMetadataNode getStandardTextNode() {
        return null;
    }

    public IIOMetadataNode getStandardTileNode() {
        return null;
    }

    public IIOMetadataNode getStandardTransparencyNode() {
        return null;
    }

    public final IIOMetadataNode getStandardTree() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(IIOMetadataFormatImpl.standardMetadataFormatName);
        append(iIOMetadataNode, getStandardChromaNode());
        append(iIOMetadataNode, getStandardCompressionNode());
        append(iIOMetadataNode, getStandardDataNode());
        append(iIOMetadataNode, getStandardDimensionNode());
        append(iIOMetadataNode, getStandardDocumentNode());
        append(iIOMetadataNode, getStandardTextNode());
        append(iIOMetadataNode, getStandardTileNode());
        append(iIOMetadataNode, getStandardTransparencyNode());
        return iIOMetadataNode;
    }

    public boolean hasController() {
        return getController() != null;
    }

    public abstract boolean isReadOnly();

    public boolean isStandardMetadataFormatSupported() {
        return this.standardFormatSupported;
    }

    public abstract void mergeTree(String str, Node node);

    public abstract void reset();

    public void setController(IIOMetadataController iIOMetadataController) {
        this.controller = iIOMetadataController;
    }

    public void setFromTree(String str, Node node) {
        reset();
        mergeTree(str, node);
    }

    public IIOMetadata(boolean z, String str, String str2, String[] strArr, String[] strArr2) {
        this.extraMetadataFormatNames = null;
        this.extraMetadataFormatClassNames = null;
        this.defaultController = null;
        this.controller = null;
        this.standardFormatSupported = z;
        this.nativeMetadataFormatName = str;
        this.nativeMetadataFormatClassName = str2;
        if (strArr == null) {
            if (strArr2 != null) {
                throw new IllegalArgumentException("extraMetadataFormatNames == null && extraMetadataFormatClassNames != null!");
            }
        } else {
            if (strArr.length == 0) {
                throw new IllegalArgumentException("extraMetadataFormatNames.length == 0!");
            }
            if (strArr2 != null) {
                if (strArr2.length == strArr.length) {
                    this.extraMetadataFormatNames = (String[]) strArr.clone();
                    this.extraMetadataFormatClassNames = (String[]) strArr2.clone();
                    return;
                }
                throw new IllegalArgumentException("extraMetadataFormatClassNames.length != extraMetadataFormatNames.length!");
            }
            throw new IllegalArgumentException("extraMetadataFormatNames != null && extraMetadataFormatClassNames == null!");
        }
    }
}
