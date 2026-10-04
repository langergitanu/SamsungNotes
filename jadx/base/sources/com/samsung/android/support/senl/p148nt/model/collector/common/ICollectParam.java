package com.samsung.android.support.senl.p148nt.model.collector.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface ICollectParam {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ActionType {
        NONE(-1),
        START(0),
        CANCEL(1),
        RESUME_NOTE(2),
        PAUSE_NOTE(3),
        RESUME_PDF(4),
        PAUSE_PDF(5),
        UPDATE_READY_STATE_NOTES(6),
        UPDATE_NOTE_DOC_OBJECT_RECOGNITION(7),
        UPDATE_SKIPPED_NOTES_OBJECT_RECOGNITION(8),
        FINISH(9);

        private final int value;

        ActionType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CancelType {
        SAVE(0),
        UPDATE(1),
        DELETE(2);

        private final int value;

        CancelType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DEFAULT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LinkWith {
        private static final /* synthetic */ LinkWith[] $VALUES;
        public static final LinkWith CODE_BLOCK;
        public static final LinkWith DEFAULT;
        public static final LinkWith LEGACY_NOTES;
        public static final LinkWith MEDIA;
        public static final LinkWith OBJECT_RECOGNITION;
        public static final LinkWith PDF_SEARCH;
        public static final LinkWith STICKY;
        public static final LinkWith TEMPLATE_SEARCH;
        public static final LinkWith TEXT_SEARCH;
        private final int value;

        private static /* synthetic */ LinkWith[] $values() {
            return new LinkWith[]{TEXT_SEARCH, TEMPLATE_SEARCH, OBJECT_RECOGNITION, MEDIA, STICKY, CODE_BLOCK, PDF_SEARCH, DEFAULT, LEGACY_NOTES};
        }

        static {
            LinkWith linkWith = new LinkWith("TEXT_SEARCH", 0, 1);
            TEXT_SEARCH = linkWith;
            LinkWith linkWith2 = new LinkWith("TEMPLATE_SEARCH", 1, 2);
            TEMPLATE_SEARCH = linkWith2;
            LinkWith linkWith3 = new LinkWith("OBJECT_RECOGNITION", 2, 4);
            OBJECT_RECOGNITION = linkWith3;
            LinkWith linkWith4 = new LinkWith("MEDIA", 3, 8);
            MEDIA = linkWith4;
            LinkWith linkWith5 = new LinkWith("STICKY", 4, 16);
            STICKY = linkWith5;
            LinkWith linkWith6 = new LinkWith("CODE_BLOCK", 5, 32);
            CODE_BLOCK = linkWith6;
            LinkWith linkWith7 = new LinkWith("PDF_SEARCH", 6, 64);
            PDF_SEARCH = linkWith7;
            DEFAULT = new LinkWith("DEFAULT", 7, linkWith7.getValue() + linkWith6.getValue() + linkWith5.getValue() + linkWith4.getValue() + linkWith3.getValue() + linkWith2.getValue() + linkWith.getValue());
            LEGACY_NOTES = new LinkWith("LEGACY_NOTES", 8, linkWith3.getValue() + linkWith.getValue());
            $VALUES = $values();
        }

        private LinkWith(String str, int i, int i2) {
            this.value = i2;
        }

        public static LinkWith valueOf(String str) {
            return (LinkWith) Enum.valueOf(LinkWith.class, str);
        }

        public static LinkWith[] values() {
            return (LinkWith[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Priority {
        BACKGROUND(0),
        FOREGROUND(1),
        IMMEDIATELY(2);

        private final int priority;

        Priority(int i) {
            this.priority = i;
        }

        public int getValue() {
            return this.priority;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SourceType {
        COMPOSER(0),
        IMPORT(1),
        SMART_SWITCH(3),
        SYNC(2),
        OTHERS(4);

        private final int value;

        SourceType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TriggerType {
        SAVE(0),
        UPDATE(1),
        AUTO_TITLE(2);

        private final int value;

        TriggerType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
