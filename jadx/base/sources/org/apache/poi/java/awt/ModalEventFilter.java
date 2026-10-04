package org.apache.poi.java.awt;

import org.apache.poi.java.awt.Dialog;
import org.apache.poi.java.awt.EventFilter;
import org.apache.poi.sun.awt.AppContext;
import org.apache.poi.sun.awt.ModalExclude;

/* JADX INFO: loaded from: classes10.dex */
abstract class ModalEventFilter implements EventFilter {
    protected boolean disabled = false;
    protected Dialog modalDialog;

    /* JADX INFO: renamed from: org.apache.poi.java.awt.ModalEventFilter$1 */
    public static /* synthetic */ class C140271 {
        static final /* synthetic */ int[] $SwitchMap$java$awt$Dialog$ModalityType;

        static {
            int[] iArr = new int[Dialog.ModalityType.values().length];
            $SwitchMap$java$awt$Dialog$ModalityType = iArr;
            try {
                iArr[Dialog.ModalityType.DOCUMENT_MODAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$awt$Dialog$ModalityType[Dialog.ModalityType.APPLICATION_MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$awt$Dialog$ModalityType[Dialog.ModalityType.TOOLKIT_MODAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class ApplicationModalEventFilter extends ModalEventFilter {
        private AppContext appContext;

        public ApplicationModalEventFilter(Dialog dialog) {
            super(dialog);
            this.appContext = dialog.appContext;
        }

        @Override // org.apache.poi.java.awt.ModalEventFilter
        public EventFilter.FilterAction acceptWindow(Window window) {
            if (window.isModalExcluded(Dialog.ModalExclusionType.APPLICATION_EXCLUDE)) {
                return EventFilter.FilterAction.ACCEPT;
            }
            if (window.appContext != this.appContext) {
                return EventFilter.FilterAction.ACCEPT;
            }
            while (window != null) {
                if (window == this.modalDialog) {
                    return EventFilter.FilterAction.ACCEPT_IMMEDIATELY;
                }
                window = window.getOwner();
            }
            return EventFilter.FilterAction.REJECT;
        }
    }

    public static class DocumentModalEventFilter extends ModalEventFilter {
        private Window documentRoot;

        public DocumentModalEventFilter(Dialog dialog) {
            super(dialog);
            this.documentRoot = dialog.getDocumentRoot();
        }

        @Override // org.apache.poi.java.awt.ModalEventFilter
        public EventFilter.FilterAction acceptWindow(Window window) {
            if (window.isModalExcluded(Dialog.ModalExclusionType.APPLICATION_EXCLUDE)) {
                Window owner = this.modalDialog;
                do {
                    owner = owner.getOwner();
                    if (owner == null) {
                        return EventFilter.FilterAction.ACCEPT;
                    }
                } while (owner != window);
                return EventFilter.FilterAction.REJECT;
            }
            while (window != null) {
                if (window == this.modalDialog) {
                    return EventFilter.FilterAction.ACCEPT_IMMEDIATELY;
                }
                if (window == this.documentRoot) {
                    return EventFilter.FilterAction.REJECT;
                }
                window = window.getOwner();
            }
            return EventFilter.FilterAction.ACCEPT;
        }
    }

    public static class ToolkitModalEventFilter extends ModalEventFilter {
        private AppContext appContext;

        public ToolkitModalEventFilter(Dialog dialog) {
            super(dialog);
            this.appContext = dialog.appContext;
        }

        @Override // org.apache.poi.java.awt.ModalEventFilter
        public EventFilter.FilterAction acceptWindow(Window window) {
            if (window.isModalExcluded(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE)) {
                return EventFilter.FilterAction.ACCEPT;
            }
            if (window.appContext != this.appContext) {
                return EventFilter.FilterAction.REJECT;
            }
            while (window != null) {
                if (window == this.modalDialog) {
                    return EventFilter.FilterAction.ACCEPT_IMMEDIATELY;
                }
                window = window.getOwner();
            }
            return EventFilter.FilterAction.REJECT;
        }
    }

    public ModalEventFilter(Dialog dialog) {
        this.modalDialog = dialog;
    }

    public static ModalEventFilter createFilterForDialog(Dialog dialog) {
        int i = C140271.$SwitchMap$java$awt$Dialog$ModalityType[dialog.getModalityType().ordinal()];
        if (i == 1) {
            return new DocumentModalEventFilter(dialog);
        }
        if (i == 2) {
            return new ApplicationModalEventFilter(dialog);
        }
        if (i != 3) {
            return null;
        }
        return new ToolkitModalEventFilter(dialog);
    }

    @Override // org.apache.poi.java.awt.EventFilter
    public EventFilter.FilterAction acceptEvent(AWTEvent aWTEvent) {
        if (this.disabled || !this.modalDialog.isVisible()) {
            return EventFilter.FilterAction.ACCEPT;
        }
        int id = aWTEvent.getID();
        if ((id >= 500 && id <= 507) || ((id >= 1001 && id <= 1001) || id == 201)) {
            Object source = aWTEvent.getSource();
            if (!(source instanceof ModalExclude) && (source instanceof Component)) {
                Component parent_NoClientCode = (Component) source;
                while (parent_NoClientCode != null && !(parent_NoClientCode instanceof Window)) {
                    parent_NoClientCode = parent_NoClientCode.getParent_NoClientCode();
                }
                if (parent_NoClientCode != null) {
                    return acceptWindow((Window) parent_NoClientCode);
                }
            }
        }
        return EventFilter.FilterAction.ACCEPT;
    }

    public abstract EventFilter.FilterAction acceptWindow(Window window);

    public int compareTo(ModalEventFilter modalEventFilter) {
        Dialog modalDialog = modalEventFilter.getModalDialog();
        for (Component parent_NoClientCode = this.modalDialog; parent_NoClientCode != null; parent_NoClientCode = parent_NoClientCode.getParent_NoClientCode()) {
            if (parent_NoClientCode == modalDialog) {
                return 1;
            }
        }
        for (Container parent_NoClientCode2 = modalDialog; parent_NoClientCode2 != null; parent_NoClientCode2 = parent_NoClientCode2.getParent_NoClientCode()) {
            if (parent_NoClientCode2 == this.modalDialog) {
                return -1;
            }
        }
        Dialog modalBlocker = this.modalDialog;
        do {
            modalBlocker = modalBlocker.getModalBlocker();
            if (modalBlocker == null) {
                for (Dialog modalBlocker2 = modalDialog.getModalBlocker(); modalBlocker2 != null; modalBlocker2 = modalBlocker2.getModalBlocker()) {
                    if (modalBlocker2 == this.modalDialog) {
                        return 1;
                    }
                }
                return this.modalDialog.getModalityType().compareTo(modalDialog.getModalityType());
            }
        } while (modalBlocker != modalDialog);
        return -1;
    }

    public void disable() {
        this.disabled = true;
    }

    public Dialog getModalDialog() {
        return this.modalDialog;
    }
}
