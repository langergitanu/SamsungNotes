package org.apache.poi.java.awt;

/* JADX INFO: loaded from: classes10.dex */
public class HeadlessException extends UnsupportedOperationException {
    private static final long serialVersionUID = 167183644944358563L;

    public HeadlessException() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String headlessMessage = GraphicsEnvironment.getHeadlessMessage();
        return message == null ? headlessMessage : headlessMessage == null ? message : message.concat(headlessMessage);
    }

    public HeadlessException(String str) {
        super(str);
    }
}
