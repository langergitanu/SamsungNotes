package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.BreakIterator;
import java.util.EventListener;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.accessibility.AccessibleText;
import javax.swing.text.AttributeSet;
import org.apache.poi.java.awt.Component;
import org.apache.poi.java.awt.event.TextEvent;
import org.apache.poi.java.awt.event.TextListener;
import org.apache.poi.java.awt.im.InputMethodRequests;
import org.apache.poi.java.awt.peer.TextComponentPeer;
import org.apache.poi.sun.awt.InputMethodSupport;

/* JADX INFO: loaded from: classes10.dex */
public class TextComponent extends Component implements Accessible {
    private static final long serialVersionUID = -2214773872412987419L;
    int selectionEnd;
    int selectionStart;
    String text;
    protected transient TextListener textListener;
    boolean editable = true;
    boolean backgroundSetByClientCode = false;
    private int textComponentSerializedDataVersion = 1;
    private boolean checkForEnableIM = true;

    public TextComponent(String str) {
        GraphicsEnvironment.checkHeadless();
        this.text = str == null ? "" : str;
        setCursor(Cursor.getPredefinedCursor(2));
    }

    private boolean canAccessClipboard() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null) {
            return true;
        }
        try {
            securityManager.checkSystemClipboardAccess();
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    private void enableInputMethodsIfNecessary() {
        if (this.checkForEnableIM) {
            this.checkForEnableIM = false;
            try {
                Object defaultToolkit = Toolkit.getDefaultToolkit();
                enableInputMethods(defaultToolkit instanceof InputMethodSupport ? ((InputMethodSupport) defaultToolkit).enableInputMethodsForTextComponent() : false);
            } catch (Exception unused) {
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        GraphicsEnvironment.checkHeadless();
        objectInputStream.defaultReadObject();
        String str = this.text;
        if (str == null) {
            str = "";
        }
        this.text = str;
        select(this.selectionStart, this.selectionEnd);
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                enableInputMethodsIfNecessary();
                return;
            } else if ("textL" == ((String) object).intern()) {
                addTextListener((TextListener) objectInputStream.readObject());
            } else {
                objectInputStream.readObject();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        TextComponentPeer textComponentPeer = this.peer;
        if (textComponentPeer != null) {
            this.text = textComponentPeer.getText();
            this.selectionStart = textComponentPeer.getSelectionStart();
            this.selectionEnd = textComponentPeer.getSelectionEnd();
        }
        objectOutputStream.defaultWriteObject();
        AWTEventMulticaster.save(objectOutputStream, "textL", this.textListener);
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.poi.java.awt.Component
    public void addNotify() throws Throwable {
        super.addNotify();
        enableInputMethodsIfNecessary();
    }

    public synchronized void addTextListener(TextListener textListener) {
        if (textListener == null) {
            return;
        }
        this.textListener = AWTEventMulticaster.add(this.textListener, textListener);
        this.newEventsOnly = true;
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean areInputMethodsEnabled() {
        if (this.checkForEnableIM) {
            enableInputMethodsIfNecessary();
        }
        return (this.eventMask & 4096) != 0;
    }

    @Override // org.apache.poi.java.awt.Component
    public void enableInputMethods(boolean z) {
        this.checkForEnableIM = false;
        super.enableInputMethods(z);
    }

    @Override // org.apache.poi.java.awt.Component
    public boolean eventEnabled(AWTEvent aWTEvent) {
        return aWTEvent.f10031id == 900 ? ((this.eventMask & 1024) == 0 && this.textListener == null) ? false : true : super.eventEnabled(aWTEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleAWTTextComponent();
        }
        return this.accessibleContext;
    }

    @Override // org.apache.poi.java.awt.Component
    public Color getBackground() {
        return (this.editable || this.backgroundSetByClientCode) ? super.getBackground() : SystemColor.control;
    }

    public synchronized int getCaretPosition() {
        int caretPosition;
        try {
            TextComponentPeer textComponentPeer = this.peer;
            caretPosition = textComponentPeer != null ? textComponentPeer.getCaretPosition() : this.selectionStart;
            int length = getText().length();
            if (caretPosition > length) {
                caretPosition = length;
            }
        } catch (Throwable th) {
            throw th;
        }
        return caretPosition;
    }

    public Rectangle getCharacterBounds(int i) {
        return null;
    }

    public int getIndexAtPoint(Point point) {
        return -1;
    }

    @Override // org.apache.poi.java.awt.Component
    public InputMethodRequests getInputMethodRequests() {
        TextComponentPeer textComponentPeer = this.peer;
        if (textComponentPeer != null) {
            return textComponentPeer.getInputMethodRequests();
        }
        return null;
    }

    @Override // org.apache.poi.java.awt.Component
    public <T extends EventListener> T[] getListeners(Class<T> cls) {
        return cls == TextListener.class ? (T[]) AWTEventMulticaster.getListeners(this.textListener, cls) : (T[]) super.getListeners(cls);
    }

    public synchronized String getSelectedText() {
        return getText().substring(getSelectionStart(), getSelectionEnd());
    }

    public synchronized int getSelectionEnd() {
        try {
            TextComponentPeer textComponentPeer = this.peer;
            if (textComponentPeer != null) {
                this.selectionEnd = textComponentPeer.getSelectionEnd();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.selectionEnd;
    }

    public synchronized int getSelectionStart() {
        try {
            TextComponentPeer textComponentPeer = this.peer;
            if (textComponentPeer != null) {
                this.selectionStart = textComponentPeer.getSelectionStart();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.selectionStart;
    }

    public synchronized String getText() {
        try {
            TextComponentPeer textComponentPeer = this.peer;
            if (textComponentPeer != null) {
                this.text = textComponentPeer.getText();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.text;
    }

    public synchronized TextListener[] getTextListeners() {
        return getListeners(TextListener.class);
    }

    public boolean isEditable() {
        return this.editable;
    }

    @Override // org.apache.poi.java.awt.Component
    public String paramString() {
        String strM756B = super.paramString() + ",text=" + getText();
        if (this.editable) {
            strM756B = AbstractC0541b.m756B(strM756B, ",editable");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(strM756B, ",selection=");
        sbM781w.append(getSelectionStart());
        sbM781w.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        sbM781w.append(getSelectionEnd());
        return sbM781w.toString();
    }

    @Override // org.apache.poi.java.awt.Component
    public void processEvent(AWTEvent aWTEvent) {
        super.processEvent(aWTEvent);
    }

    public void processTextEvent(TextEvent textEvent) {
        TextListener textListener = this.textListener;
        if (textListener == null || textEvent.getID() != 900) {
            return;
        }
        textListener.textValueChanged(textEvent);
    }

    @Override // org.apache.poi.java.awt.Component
    public void removeNotify() {
        synchronized (getTreeLock()) {
            try {
                TextComponentPeer textComponentPeer = this.peer;
                if (textComponentPeer != null) {
                    this.text = textComponentPeer.getText();
                    this.selectionStart = textComponentPeer.getSelectionStart();
                    this.selectionEnd = textComponentPeer.getSelectionEnd();
                }
                super.removeNotify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void removeTextListener(TextListener textListener) {
        if (textListener == null) {
            return;
        }
        this.textListener = AWTEventMulticaster.remove(this.textListener, textListener);
    }

    public synchronized void select(int i, int i2) {
        try {
            String text = getText();
            if (i < 0) {
                i = 0;
            }
            if (i > text.length()) {
                i = text.length();
            }
            if (i2 > text.length()) {
                i2 = text.length();
            }
            if (i2 < i) {
                i2 = i;
            }
            this.selectionStart = i;
            this.selectionEnd = i2;
            TextComponentPeer textComponentPeer = this.peer;
            if (textComponentPeer != null) {
                textComponentPeer.select(i, i2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void selectAll() {
        this.selectionStart = 0;
        int length = getText().length();
        this.selectionEnd = length;
        TextComponentPeer textComponentPeer = this.peer;
        if (textComponentPeer != null) {
            textComponentPeer.select(this.selectionStart, length);
        }
    }

    @Override // org.apache.poi.java.awt.Component
    public void setBackground(Color color) {
        this.backgroundSetByClientCode = true;
        super.setBackground(color);
    }

    public synchronized void setCaretPosition(int i) {
        try {
            if (i < 0) {
                throw new IllegalArgumentException("position less than zero.");
            }
            int length = getText().length();
            if (i > length) {
                i = length;
            }
            TextComponentPeer textComponentPeer = this.peer;
            if (textComponentPeer != null) {
                textComponentPeer.setCaretPosition(i);
            } else {
                select(i, i);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setEditable(boolean z) {
        if (this.editable == z) {
            return;
        }
        this.editable = z;
        TextComponentPeer textComponentPeer = this.peer;
        if (textComponentPeer != null) {
            textComponentPeer.setEditable(z);
        }
    }

    public synchronized void setSelectionEnd(int i) {
        select(getSelectionStart(), i);
    }

    public synchronized void setSelectionStart(int i) {
        select(i, getSelectionEnd());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void setText(String str) {
        boolean z;
        try {
            String str2 = this.text;
            if (str2 == null || str2.isEmpty()) {
                z = str == null || str.isEmpty();
            }
            if (str == null) {
                str = "";
            }
            this.text = str;
            TextComponentPeer textComponentPeer = this.peer;
            if (textComponentPeer != null && !z) {
                textComponentPeer.setText(str);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public class AccessibleAWTTextComponent extends Component.AccessibleAWTComponent implements AccessibleText, TextListener {
        private static final boolean NEXT = true;
        private static final boolean PREVIOUS = false;
        private static final long serialVersionUID = 3631432373506317811L;

        public AccessibleAWTTextComponent() {
            super();
            TextComponent.this.addTextListener(this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        
            if (r6 == (-1)) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        
            r2 = java.lang.Math.min(r1, r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        
            if (r2 >= java.lang.Math.max(r1, r6)) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        
            if (java.lang.Character.isLetter(r9.charAt(r2)) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        
            r2 = r2 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        
            if (r8 != true) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0017, code lost:
        
            r1 = r7.previous();
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        
            if (r8 == true) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        
            r1 = r7.next();
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        
            r1 = r7.previous();
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
        
            r4 = r1;
            r1 = r6;
            r6 = r4;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:7:0x000e). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int findWordLimit(int i, BreakIterator breakIterator, boolean z, String str) {
            int iFollowing = z ? breakIterator.following(i) : breakIterator.preceding(i);
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.TEXT;
        }

        @Override // org.apache.poi.java.awt.Component.AccessibleAWTComponent
        public AccessibleStateSet getAccessibleStateSet() {
            AccessibleStateSet accessibleStateSet = super.getAccessibleStateSet();
            if (TextComponent.this.isEditable()) {
                accessibleStateSet.add(AccessibleState.EDITABLE);
            }
            return accessibleStateSet;
        }

        public String getAfterIndex(int i, int i2) {
            int iFollowing;
            int iFollowing2;
            if (i2 < 0 || i2 >= TextComponent.this.getText().length()) {
                return null;
            }
            if (i == 1) {
                int i4 = i2 + 1;
                if (i4 >= TextComponent.this.getText().length()) {
                    return null;
                }
                return TextComponent.this.getText().substring(i4, i2 + 2);
            }
            if (i == 2) {
                String text = TextComponent.this.getText();
                BreakIterator wordInstance = BreakIterator.getWordInstance();
                wordInstance.setText(text);
                int iFindWordLimit = findWordLimit(i2, wordInstance, true, text);
                if (iFindWordLimit == -1 || iFindWordLimit >= text.length() || (iFollowing = wordInstance.following(iFindWordLimit)) == -1 || iFollowing >= text.length()) {
                    return null;
                }
                return text.substring(iFindWordLimit, iFollowing);
            }
            if (i != 3) {
                return null;
            }
            String text2 = TextComponent.this.getText();
            BreakIterator sentenceInstance = BreakIterator.getSentenceInstance();
            sentenceInstance.setText(text2);
            int iFollowing3 = sentenceInstance.following(i2);
            if (iFollowing3 == -1 || iFollowing3 >= text2.length() || (iFollowing2 = sentenceInstance.following(iFollowing3)) == -1 || iFollowing2 >= text2.length()) {
                return null;
            }
            return text2.substring(iFollowing3, iFollowing2);
        }

        public String getAtIndex(int i, int i2) {
            if (i2 < 0 || i2 >= TextComponent.this.getText().length()) {
                return null;
            }
            if (i == 1) {
                return TextComponent.this.getText().substring(i2, i2 + 1);
            }
            if (i == 2) {
                String text = TextComponent.this.getText();
                BreakIterator wordInstance = BreakIterator.getWordInstance();
                wordInstance.setText(text);
                return text.substring(wordInstance.previous(), wordInstance.following(i2));
            }
            if (i != 3) {
                return null;
            }
            String text2 = TextComponent.this.getText();
            BreakIterator sentenceInstance = BreakIterator.getSentenceInstance();
            sentenceInstance.setText(text2);
            return text2.substring(sentenceInstance.previous(), sentenceInstance.following(i2));
        }

        public String getBeforeIndex(int i, int i2) {
            int iPreceding;
            if (i2 < 0 || i2 > TextComponent.this.getText().length() - 1) {
                return null;
            }
            if (i == 1) {
                if (i2 == 0) {
                    return null;
                }
                return TextComponent.this.getText().substring(i2 - 1, i2);
            }
            if (i == 2) {
                String text = TextComponent.this.getText();
                BreakIterator wordInstance = BreakIterator.getWordInstance();
                wordInstance.setText(text);
                int iFindWordLimit = findWordLimit(i2, wordInstance, false, text);
                if (iFindWordLimit == -1 || (iPreceding = wordInstance.preceding(iFindWordLimit)) == -1) {
                    return null;
                }
                return text.substring(iPreceding, iFindWordLimit);
            }
            if (i != 3) {
                return null;
            }
            String text2 = TextComponent.this.getText();
            BreakIterator sentenceInstance = BreakIterator.getSentenceInstance();
            sentenceInstance.setText(text2);
            sentenceInstance.following(i2);
            int iPrevious = sentenceInstance.previous();
            int iPrevious2 = sentenceInstance.previous();
            if (iPrevious2 == -1) {
                return null;
            }
            return text2.substring(iPrevious2, iPrevious);
        }

        public int getCaretPosition() {
            return TextComponent.this.getCaretPosition();
        }

        public int getCharCount() {
            return TextComponent.this.getText().length();
        }

        public AttributeSet getCharacterAttribute(int i) {
            return null;
        }

        public Rectangle getCharacterBounds(int i) {
            return TextComponent.this.getCharacterBounds(i);
        }

        public int getIndexAtPoint(Point point) {
            return TextComponent.this.getIndexAtPoint(point);
        }

        public String getSelectedText() {
            String selectedText = TextComponent.this.getSelectedText();
            if (selectedText == null || selectedText.equals("")) {
                return null;
            }
            return selectedText;
        }

        public int getSelectionEnd() {
            return TextComponent.this.getSelectionEnd();
        }

        public int getSelectionStart() {
            return TextComponent.this.getSelectionStart();
        }

        public void textValueChanged(TextEvent textEvent) {
            firePropertyChange("AccessibleText", null, Integer.valueOf(TextComponent.this.getCaretPosition()));
        }

        public AccessibleText getAccessibleText() {
            return this;
        }
    }
}
