package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.apache.poi.java.awt.peer.FileDialogPeer;
import org.apache.poi.sun.awt.AWTAccessor;

/* JADX INFO: loaded from: classes10.dex */
public class FileDialog extends Dialog {
    public static final int LOAD = 0;
    public static final int SAVE = 1;
    private static final String base = "filedlg";
    private static int nameCounter = 0;
    private static final long serialVersionUID = 5035145889651310422L;
    String dir;
    String file;
    private File[] files;
    FilenameFilter filter;
    int mode;
    private boolean multipleMode;

    static {
        Toolkit.loadLibraries();
        if (!GraphicsEnvironment.isHeadless()) {
            initIDs();
        }
        AWTAccessor.setFileDialogAccessor(new AWTAccessor.FileDialogAccessor() { // from class: org.apache.poi.java.awt.FileDialog.1
            @Override // org.apache.poi.sun.awt.AWTAccessor.FileDialogAccessor
            public boolean isMultipleMode(FileDialog fileDialog) {
                boolean z;
                synchronized (fileDialog.getObjectLock()) {
                    z = fileDialog.multipleMode;
                }
                return z;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.FileDialogAccessor
            public void setDirectory(FileDialog fileDialog, String str) {
                if ("".equals(str)) {
                    str = null;
                }
                fileDialog.dir = str;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.FileDialogAccessor
            public void setFile(FileDialog fileDialog, String str) {
                if ("".equals(str)) {
                    str = null;
                }
                fileDialog.file = str;
            }

            @Override // org.apache.poi.sun.awt.AWTAccessor.FileDialogAccessor
            public void setFiles(FileDialog fileDialog, File[] fileArr) {
                fileDialog.setFiles(fileArr);
            }
        });
    }

    public FileDialog(Dialog dialog) {
        this(dialog, "", 0);
    }

    private static native void initIDs();

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        String str = this.dir;
        if (str != null && str.equals("")) {
            this.dir = null;
        }
        String str2 = this.file;
        if (str2 == null || !str2.equals("")) {
            return;
        }
        this.file = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFiles(File[] fileArr) {
        synchronized (getObjectLock()) {
            this.files = fileArr;
        }
    }

    @Override // org.apache.poi.java.awt.Dialog, org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public void addNotify() {
        synchronized (getTreeLock()) {
            try {
                Container container = this.parent;
                if (container != null && container.getPeer() == null) {
                    this.parent.addNotify();
                }
                if (this.peer == null) {
                    this.peer = getToolkit().createFileDialog(this);
                }
                super.addNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.poi.java.awt.Dialog, org.apache.poi.java.awt.Window, org.apache.poi.java.awt.Component
    public String constructComponentName() {
        String string;
        synchronized (FileDialog.class) {
            StringBuilder sb = new StringBuilder(base);
            int i = nameCounter;
            nameCounter = i + 1;
            sb.append(i);
            string = sb.toString();
        }
        return string;
    }

    public String getDirectory() {
        return this.dir;
    }

    public String getFile() {
        return this.file;
    }

    public FilenameFilter getFilenameFilter() {
        return this.filter;
    }

    public File[] getFiles() {
        File[] fileArr;
        synchronized (getObjectLock()) {
            try {
                File[] fileArr2 = this.files;
                fileArr = fileArr2 != null ? (File[]) fileArr2.clone() : new File[0];
            } catch (Throwable th) {
                throw th;
            }
        }
        return fileArr;
    }

    public int getMode() {
        return this.mode;
    }

    public boolean isMultipleMode() {
        boolean z;
        synchronized (getObjectLock()) {
            z = this.multipleMode;
        }
        return z;
    }

    @Override // org.apache.poi.java.awt.Dialog, org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public String paramString() {
        StringBuilder sbM781w = AbstractC0541b.m781w(super.paramString(), ",dir= ");
        sbM781w.append(this.dir);
        StringBuilder sbM781w2 = AbstractC0541b.m781w(sbM781w.toString(), ",file= ");
        sbM781w2.append(this.file);
        StringBuilder sbM1324q = AbstractC1974b.m1324q(sbM781w2.toString());
        sbM1324q.append(this.mode == 0 ? ",load" : ",save");
        return sbM1324q.toString();
    }

    @Override // org.apache.poi.java.awt.Container, org.apache.poi.java.awt.Component
    public boolean postsOldMouseEvents() {
        return false;
    }

    public void setDirectory(String str) {
        if (str != null && str.equals("")) {
            str = null;
        }
        this.dir = str;
        FileDialogPeer fileDialogPeer = this.peer;
        if (fileDialogPeer != null) {
            fileDialogPeer.setDirectory(str);
        }
    }

    public void setFile(String str) {
        if (str != null && str.equals("")) {
            str = null;
        }
        this.file = str;
        FileDialogPeer fileDialogPeer = this.peer;
        if (fileDialogPeer != null) {
            fileDialogPeer.setFile(str);
        }
    }

    public synchronized void setFilenameFilter(FilenameFilter filenameFilter) {
        this.filter = filenameFilter;
        FileDialogPeer fileDialogPeer = this.peer;
        if (fileDialogPeer != null) {
            fileDialogPeer.setFilenameFilter(filenameFilter);
        }
    }

    public void setMode(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("illegal file dialog mode");
        }
        this.mode = i;
    }

    public void setMultipleMode(boolean z) {
        synchronized (getObjectLock()) {
            this.multipleMode = z;
        }
    }

    public FileDialog(Dialog dialog, String str) {
        this(dialog, str, 0);
    }

    public FileDialog(Dialog dialog, String str, int i) {
        super(dialog, str, true);
        this.multipleMode = false;
        setMode(i);
        setLayout(null);
    }

    public FileDialog(Frame frame) {
        this(frame, "", 0);
    }

    public FileDialog(Frame frame, String str) {
        this(frame, str, 0);
    }

    public FileDialog(Frame frame, String str, int i) {
        super(frame, str, true);
        this.multipleMode = false;
        setMode(i);
        setLayout(null);
    }
}
