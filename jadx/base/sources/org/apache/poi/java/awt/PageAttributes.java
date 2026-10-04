package org.apache.poi.java.awt;

import androidx.glance.AbstractC2821a;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public final class PageAttributes implements Cloneable {
    private ColorType color;
    private MediaType media;
    private OrientationRequestedType orientationRequested;
    private OriginType origin;
    private PrintQualityType printQuality;
    private int[] printerResolution;

    public static final class ColorType extends AttributeValue {
        private static final int I_COLOR = 0;
        private static final int I_MONOCHROME = 1;
        private static final String[] NAMES = {"color", "monochrome"};
        public static final ColorType COLOR = new ColorType(0);
        public static final ColorType MONOCHROME = new ColorType(1);

        private ColorType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class MediaType extends AttributeValue {

        /* JADX INFO: renamed from: A */
        public static final MediaType f10057A;

        /* JADX INFO: renamed from: A0 */
        public static final MediaType f10058A0;

        /* JADX INFO: renamed from: A1 */
        public static final MediaType f10059A1;
        public static final MediaType A10;

        /* JADX INFO: renamed from: A2 */
        public static final MediaType f10060A2;

        /* JADX INFO: renamed from: A3 */
        public static final MediaType f10061A3;

        /* JADX INFO: renamed from: A4 */
        public static final MediaType f10062A4;

        /* JADX INFO: renamed from: A5 */
        public static final MediaType f10063A5;

        /* JADX INFO: renamed from: A6 */
        public static final MediaType f10064A6;

        /* JADX INFO: renamed from: A7 */
        public static final MediaType f10065A7;

        /* JADX INFO: renamed from: A8 */
        public static final MediaType f10066A8;

        /* JADX INFO: renamed from: A9 */
        public static final MediaType f10067A9;

        /* JADX INFO: renamed from: B */
        public static final MediaType f10068B;

        /* JADX INFO: renamed from: B0 */
        public static final MediaType f10069B0;

        /* JADX INFO: renamed from: B1 */
        public static final MediaType f10070B1;
        public static final MediaType B10;

        /* JADX INFO: renamed from: B2 */
        public static final MediaType f10071B2;

        /* JADX INFO: renamed from: B3 */
        public static final MediaType f10072B3;

        /* JADX INFO: renamed from: B4 */
        public static final MediaType f10073B4;

        /* JADX INFO: renamed from: B5 */
        public static final MediaType f10074B5;

        /* JADX INFO: renamed from: B6 */
        public static final MediaType f10075B6;

        /* JADX INFO: renamed from: B7 */
        public static final MediaType f10076B7;

        /* JADX INFO: renamed from: B8 */
        public static final MediaType f10077B8;

        /* JADX INFO: renamed from: B9 */
        public static final MediaType f10078B9;

        /* JADX INFO: renamed from: C */
        public static final MediaType f10079C;

        /* JADX INFO: renamed from: C0 */
        public static final MediaType f10080C0;

        /* JADX INFO: renamed from: C1 */
        public static final MediaType f10081C1;
        public static final MediaType C10;

        /* JADX INFO: renamed from: C2 */
        public static final MediaType f10082C2;

        /* JADX INFO: renamed from: C3 */
        public static final MediaType f10083C3;

        /* JADX INFO: renamed from: C4 */
        public static final MediaType f10084C4;

        /* JADX INFO: renamed from: C5 */
        public static final MediaType f10085C5;

        /* JADX INFO: renamed from: C6 */
        public static final MediaType f10086C6;

        /* JADX INFO: renamed from: C7 */
        public static final MediaType f10087C7;

        /* JADX INFO: renamed from: C8 */
        public static final MediaType f10088C8;

        /* JADX INFO: renamed from: C9 */
        public static final MediaType f10089C9;

        /* JADX INFO: renamed from: D */
        public static final MediaType f10090D;

        /* JADX INFO: renamed from: E */
        public static final MediaType f10091E;
        public static final MediaType ENV_10;
        public static final MediaType ENV_10X13;
        public static final MediaType ENV_10X14;
        public static final MediaType ENV_10X15;
        public static final MediaType ENV_11;
        public static final MediaType ENV_12;
        public static final MediaType ENV_14;
        public static final MediaType ENV_6X9;
        public static final MediaType ENV_7X9;
        public static final MediaType ENV_9;
        public static final MediaType ENV_9X11;
        public static final MediaType ENV_9X12;
        public static final MediaType ENV_INVITE;
        public static final MediaType ENV_ITALY;
        public static final MediaType ENV_MONARCH;
        public static final MediaType ENV_PERSONAL;
        public static final MediaType EXECUTIVE;
        public static final MediaType FOLIO;
        public static final MediaType INVITE;
        public static final MediaType INVITE_ENVELOPE;
        public static final MediaType INVOICE;
        public static final MediaType ISO_A0;
        public static final MediaType ISO_A1;
        public static final MediaType ISO_A10;
        public static final MediaType ISO_A2;
        public static final MediaType ISO_A3;
        public static final MediaType ISO_A4;
        public static final MediaType ISO_A5;
        public static final MediaType ISO_A6;
        public static final MediaType ISO_A7;
        public static final MediaType ISO_A8;
        public static final MediaType ISO_A9;
        public static final MediaType ISO_B0;
        public static final MediaType ISO_B1;
        public static final MediaType ISO_B10;
        public static final MediaType ISO_B2;
        public static final MediaType ISO_B3;
        public static final MediaType ISO_B4;
        public static final MediaType ISO_B4_ENVELOPE;
        public static final MediaType ISO_B5;
        public static final MediaType ISO_B5_ENVELOPE;
        public static final MediaType ISO_B6;
        public static final MediaType ISO_B7;
        public static final MediaType ISO_B8;
        public static final MediaType ISO_B9;
        public static final MediaType ISO_C0;
        public static final MediaType ISO_C0_ENVELOPE;
        public static final MediaType ISO_C1;
        public static final MediaType ISO_C10;
        public static final MediaType ISO_C10_ENVELOPE;
        public static final MediaType ISO_C1_ENVELOPE;
        public static final MediaType ISO_C2;
        public static final MediaType ISO_C2_ENVELOPE;
        public static final MediaType ISO_C3;
        public static final MediaType ISO_C3_ENVELOPE;
        public static final MediaType ISO_C4;
        public static final MediaType ISO_C4_ENVELOPE;
        public static final MediaType ISO_C5;
        public static final MediaType ISO_C5_ENVELOPE;
        public static final MediaType ISO_C6;
        public static final MediaType ISO_C6_ENVELOPE;
        public static final MediaType ISO_C7;
        public static final MediaType ISO_C7_ENVELOPE;
        public static final MediaType ISO_C8;
        public static final MediaType ISO_C8_ENVELOPE;
        public static final MediaType ISO_C9;
        public static final MediaType ISO_C9_ENVELOPE;
        public static final MediaType ISO_DESIGNATED_LONG;
        public static final MediaType ISO_DESIGNATED_LONG_ENVELOPE;
        public static final MediaType ITALY;
        public static final MediaType ITALY_ENVELOPE;
        private static final int I_A = 54;
        private static final int I_B = 55;
        private static final int I_C = 56;
        private static final int I_D = 57;
        private static final int I_E = 58;
        private static final int I_EXECUTIVE = 47;
        private static final int I_FOLIO = 48;
        private static final int I_INVITE_ENVELOPE = 71;
        private static final int I_INVOICE = 49;
        private static final int I_ISO_2A0 = 1;
        private static final int I_ISO_4A0 = 0;
        private static final int I_ISO_A0 = 2;
        private static final int I_ISO_A1 = 3;
        private static final int I_ISO_A10 = 12;
        private static final int I_ISO_A2 = 4;
        private static final int I_ISO_A3 = 5;
        private static final int I_ISO_A4 = 6;
        private static final int I_ISO_A5 = 7;
        private static final int I_ISO_A6 = 8;
        private static final int I_ISO_A7 = 9;
        private static final int I_ISO_A8 = 10;
        private static final int I_ISO_A9 = 11;
        private static final int I_ISO_B0 = 13;
        private static final int I_ISO_B1 = 14;
        private static final int I_ISO_B10 = 23;
        private static final int I_ISO_B2 = 15;
        private static final int I_ISO_B3 = 16;
        private static final int I_ISO_B4 = 17;
        private static final int I_ISO_B5 = 18;
        private static final int I_ISO_B6 = 19;
        private static final int I_ISO_B7 = 20;
        private static final int I_ISO_B8 = 21;
        private static final int I_ISO_B9 = 22;
        private static final int I_ISO_C0 = 35;
        private static final int I_ISO_C1 = 36;
        private static final int I_ISO_C10 = 45;
        private static final int I_ISO_C2 = 37;
        private static final int I_ISO_C3 = 38;
        private static final int I_ISO_C4 = 39;
        private static final int I_ISO_C5 = 40;
        private static final int I_ISO_C6 = 41;
        private static final int I_ISO_C7 = 42;
        private static final int I_ISO_C8 = 43;
        private static final int I_ISO_C9 = 44;
        private static final int I_ISO_DESIGNATED_LONG = 46;
        private static final int I_ITALY_ENVELOPE = 72;
        private static final int I_JIS_B0 = 24;
        private static final int I_JIS_B1 = 25;
        private static final int I_JIS_B10 = 34;
        private static final int I_JIS_B2 = 26;
        private static final int I_JIS_B3 = 27;
        private static final int I_JIS_B4 = 28;
        private static final int I_JIS_B5 = 29;
        private static final int I_JIS_B6 = 30;
        private static final int I_JIS_B7 = 31;
        private static final int I_JIS_B8 = 32;
        private static final int I_JIS_B9 = 33;
        private static final int I_LEDGER = 50;
        private static final int I_MONARCH_ENVELOPE = 73;
        private static final int I_NA_10X13_ENVELOPE = 61;
        private static final int I_NA_10X14_ENVELOPE = 60;
        private static final int I_NA_10X15_ENVELOPE = 59;
        private static final int I_NA_6X9_ENVELOPE = 65;
        private static final int I_NA_7X9_ENVELOPE = 64;
        private static final int I_NA_9X11_ENVELOPE = 63;
        private static final int I_NA_9X12_ENVELOPE = 62;
        private static final int I_NA_LEGAL = 52;
        private static final int I_NA_LETTER = 51;
        private static final int I_NA_NUMBER_10_ENVELOPE = 67;
        private static final int I_NA_NUMBER_11_ENVELOPE = 68;
        private static final int I_NA_NUMBER_12_ENVELOPE = 69;
        private static final int I_NA_NUMBER_14_ENVELOPE = 70;
        private static final int I_NA_NUMBER_9_ENVELOPE = 66;
        private static final int I_PERSONAL_ENVELOPE = 74;
        private static final int I_QUARTO = 53;
        public static final MediaType JIS_B0;
        public static final MediaType JIS_B1;
        public static final MediaType JIS_B10;
        public static final MediaType JIS_B2;
        public static final MediaType JIS_B3;
        public static final MediaType JIS_B4;
        public static final MediaType JIS_B5;
        public static final MediaType JIS_B6;
        public static final MediaType JIS_B7;
        public static final MediaType JIS_B8;
        public static final MediaType JIS_B9;
        public static final MediaType LEDGER;
        public static final MediaType LEGAL;
        public static final MediaType LETTER;
        public static final MediaType MONARCH;
        public static final MediaType MONARCH_ENVELOPE;
        public static final MediaType NA_10X13_ENVELOPE;
        public static final MediaType NA_10X14_ENVELOPE;
        public static final MediaType NA_10X15_ENVELOPE;
        public static final MediaType NA_6X9_ENVELOPE;
        public static final MediaType NA_7X9_ENVELOPE;
        public static final MediaType NA_9X11_ENVELOPE;
        public static final MediaType NA_9X12_ENVELOPE;
        public static final MediaType NA_LEGAL;
        public static final MediaType NA_LETTER;
        public static final MediaType NA_NUMBER_10_ENVELOPE;
        public static final MediaType NA_NUMBER_11_ENVELOPE;
        public static final MediaType NA_NUMBER_12_ENVELOPE;
        public static final MediaType NA_NUMBER_14_ENVELOPE;
        public static final MediaType NA_NUMBER_9_ENVELOPE;
        public static final MediaType NOTE;
        public static final MediaType PERSONAL;
        public static final MediaType PERSONAL_ENVELOPE;
        public static final MediaType QUARTO;
        public static final MediaType STATEMENT;
        public static final MediaType TABLOID;
        private static final String[] NAMES = {"iso-4a0", "iso-2a0", "iso-a0", "iso-a1", "iso-a2", "iso-a3", "iso-a4", "iso-a5", "iso-a6", "iso-a7", "iso-a8", "iso-a9", "iso-a10", "iso-b0", "iso-b1", "iso-b2", "iso-b3", "iso-b4", "iso-b5", "iso-b6", "iso-b7", "iso-b8", "iso-b9", "iso-b10", "jis-b0", "jis-b1", "jis-b2", "jis-b3", "jis-b4", "jis-b5", "jis-b6", "jis-b7", "jis-b8", "jis-b9", "jis-b10", "iso-c0", "iso-c1", "iso-c2", "iso-c3", "iso-c4", "iso-c5", "iso-c6", "iso-c7", "iso-c8", "iso-c9", "iso-c10", "iso-designated-long", "executive", "folio", "invoice", "ledger", "na-letter", "na-legal", "quarto", "a", "b", "c", "d", "e", "na-10x15-envelope", "na-10x14-envelope", "na-10x13-envelope", "na-9x12-envelope", "na-9x11-envelope", "na-7x9-envelope", "na-6x9-envelope", "na-number-9-envelope", "na-number-10-envelope", "na-number-11-envelope", "na-number-12-envelope", "na-number-14-envelope", "invite-envelope", "italy-envelope", "monarch-envelope", "personal-envelope"};
        public static final MediaType ISO_4A0 = new MediaType(0);
        public static final MediaType ISO_2A0 = new MediaType(1);

        static {
            MediaType mediaType = new MediaType(2);
            ISO_A0 = mediaType;
            MediaType mediaType2 = new MediaType(3);
            ISO_A1 = mediaType2;
            MediaType mediaType3 = new MediaType(4);
            ISO_A2 = mediaType3;
            MediaType mediaType4 = new MediaType(5);
            ISO_A3 = mediaType4;
            MediaType mediaType5 = new MediaType(6);
            ISO_A4 = mediaType5;
            MediaType mediaType6 = new MediaType(7);
            ISO_A5 = mediaType6;
            MediaType mediaType7 = new MediaType(8);
            ISO_A6 = mediaType7;
            MediaType mediaType8 = new MediaType(9);
            ISO_A7 = mediaType8;
            MediaType mediaType9 = new MediaType(10);
            ISO_A8 = mediaType9;
            MediaType mediaType10 = new MediaType(11);
            ISO_A9 = mediaType10;
            MediaType mediaType11 = new MediaType(12);
            ISO_A10 = mediaType11;
            MediaType mediaType12 = new MediaType(13);
            ISO_B0 = mediaType12;
            MediaType mediaType13 = new MediaType(14);
            ISO_B1 = mediaType13;
            MediaType mediaType14 = new MediaType(15);
            ISO_B2 = mediaType14;
            MediaType mediaType15 = new MediaType(16);
            ISO_B3 = mediaType15;
            MediaType mediaType16 = new MediaType(17);
            ISO_B4 = mediaType16;
            MediaType mediaType17 = new MediaType(18);
            ISO_B5 = mediaType17;
            MediaType mediaType18 = new MediaType(19);
            ISO_B6 = mediaType18;
            MediaType mediaType19 = new MediaType(20);
            ISO_B7 = mediaType19;
            MediaType mediaType20 = new MediaType(21);
            ISO_B8 = mediaType20;
            MediaType mediaType21 = new MediaType(22);
            ISO_B9 = mediaType21;
            MediaType mediaType22 = new MediaType(23);
            ISO_B10 = mediaType22;
            JIS_B0 = new MediaType(24);
            JIS_B1 = new MediaType(25);
            JIS_B2 = new MediaType(26);
            JIS_B3 = new MediaType(27);
            JIS_B4 = new MediaType(28);
            JIS_B5 = new MediaType(29);
            JIS_B6 = new MediaType(30);
            JIS_B7 = new MediaType(31);
            JIS_B8 = new MediaType(32);
            JIS_B9 = new MediaType(33);
            JIS_B10 = new MediaType(34);
            MediaType mediaType23 = new MediaType(35);
            ISO_C0 = mediaType23;
            MediaType mediaType24 = new MediaType(36);
            ISO_C1 = mediaType24;
            MediaType mediaType25 = new MediaType(37);
            ISO_C2 = mediaType25;
            MediaType mediaType26 = new MediaType(38);
            ISO_C3 = mediaType26;
            MediaType mediaType27 = new MediaType(39);
            ISO_C4 = mediaType27;
            MediaType mediaType28 = new MediaType(40);
            ISO_C5 = mediaType28;
            MediaType mediaType29 = new MediaType(41);
            ISO_C6 = mediaType29;
            MediaType mediaType30 = new MediaType(42);
            ISO_C7 = mediaType30;
            MediaType mediaType31 = new MediaType(43);
            ISO_C8 = mediaType31;
            MediaType mediaType32 = new MediaType(44);
            ISO_C9 = mediaType32;
            MediaType mediaType33 = new MediaType(45);
            ISO_C10 = mediaType33;
            MediaType mediaType34 = new MediaType(46);
            ISO_DESIGNATED_LONG = mediaType34;
            EXECUTIVE = new MediaType(47);
            FOLIO = new MediaType(48);
            MediaType mediaType35 = new MediaType(49);
            INVOICE = mediaType35;
            MediaType mediaType36 = new MediaType(50);
            LEDGER = mediaType36;
            MediaType mediaType37 = new MediaType(51);
            NA_LETTER = mediaType37;
            MediaType mediaType38 = new MediaType(52);
            NA_LEGAL = mediaType38;
            QUARTO = new MediaType(53);
            f10057A = new MediaType(54);
            f10068B = new MediaType(55);
            f10079C = new MediaType(56);
            f10090D = new MediaType(57);
            f10091E = new MediaType(58);
            MediaType mediaType39 = new MediaType(59);
            NA_10X15_ENVELOPE = mediaType39;
            MediaType mediaType40 = new MediaType(60);
            NA_10X14_ENVELOPE = mediaType40;
            MediaType mediaType41 = new MediaType(61);
            NA_10X13_ENVELOPE = mediaType41;
            MediaType mediaType42 = new MediaType(62);
            NA_9X12_ENVELOPE = mediaType42;
            MediaType mediaType43 = new MediaType(63);
            NA_9X11_ENVELOPE = mediaType43;
            MediaType mediaType44 = new MediaType(64);
            NA_7X9_ENVELOPE = mediaType44;
            MediaType mediaType45 = new MediaType(65);
            NA_6X9_ENVELOPE = mediaType45;
            MediaType mediaType46 = new MediaType(66);
            NA_NUMBER_9_ENVELOPE = mediaType46;
            MediaType mediaType47 = new MediaType(67);
            NA_NUMBER_10_ENVELOPE = mediaType47;
            MediaType mediaType48 = new MediaType(68);
            NA_NUMBER_11_ENVELOPE = mediaType48;
            MediaType mediaType49 = new MediaType(69);
            NA_NUMBER_12_ENVELOPE = mediaType49;
            MediaType mediaType50 = new MediaType(70);
            NA_NUMBER_14_ENVELOPE = mediaType50;
            MediaType mediaType51 = new MediaType(71);
            INVITE_ENVELOPE = mediaType51;
            MediaType mediaType52 = new MediaType(72);
            ITALY_ENVELOPE = mediaType52;
            MediaType mediaType53 = new MediaType(73);
            MONARCH_ENVELOPE = mediaType53;
            MediaType mediaType54 = new MediaType(74);
            PERSONAL_ENVELOPE = mediaType54;
            f10058A0 = mediaType;
            f10059A1 = mediaType2;
            f10060A2 = mediaType3;
            f10061A3 = mediaType4;
            f10062A4 = mediaType5;
            f10063A5 = mediaType6;
            f10064A6 = mediaType7;
            f10065A7 = mediaType8;
            f10066A8 = mediaType9;
            f10067A9 = mediaType10;
            A10 = mediaType11;
            f10069B0 = mediaType12;
            f10070B1 = mediaType13;
            f10071B2 = mediaType14;
            f10072B3 = mediaType15;
            f10073B4 = mediaType16;
            ISO_B4_ENVELOPE = mediaType16;
            f10074B5 = mediaType17;
            ISO_B5_ENVELOPE = mediaType17;
            f10075B6 = mediaType18;
            f10076B7 = mediaType19;
            f10077B8 = mediaType20;
            f10078B9 = mediaType21;
            B10 = mediaType22;
            f10080C0 = mediaType23;
            ISO_C0_ENVELOPE = mediaType23;
            f10081C1 = mediaType24;
            ISO_C1_ENVELOPE = mediaType24;
            f10082C2 = mediaType25;
            ISO_C2_ENVELOPE = mediaType25;
            f10083C3 = mediaType26;
            ISO_C3_ENVELOPE = mediaType26;
            f10084C4 = mediaType27;
            ISO_C4_ENVELOPE = mediaType27;
            f10085C5 = mediaType28;
            ISO_C5_ENVELOPE = mediaType28;
            f10086C6 = mediaType29;
            ISO_C6_ENVELOPE = mediaType29;
            f10087C7 = mediaType30;
            ISO_C7_ENVELOPE = mediaType30;
            f10088C8 = mediaType31;
            ISO_C8_ENVELOPE = mediaType31;
            f10089C9 = mediaType32;
            ISO_C9_ENVELOPE = mediaType32;
            C10 = mediaType33;
            ISO_C10_ENVELOPE = mediaType33;
            ISO_DESIGNATED_LONG_ENVELOPE = mediaType34;
            STATEMENT = mediaType35;
            TABLOID = mediaType36;
            LETTER = mediaType37;
            NOTE = mediaType37;
            LEGAL = mediaType38;
            ENV_10X15 = mediaType39;
            ENV_10X14 = mediaType40;
            ENV_10X13 = mediaType41;
            ENV_9X12 = mediaType42;
            ENV_9X11 = mediaType43;
            ENV_7X9 = mediaType44;
            ENV_6X9 = mediaType45;
            ENV_9 = mediaType46;
            ENV_10 = mediaType47;
            ENV_11 = mediaType48;
            ENV_12 = mediaType49;
            ENV_14 = mediaType50;
            ENV_INVITE = mediaType51;
            ENV_ITALY = mediaType52;
            ENV_MONARCH = mediaType53;
            ENV_PERSONAL = mediaType54;
            INVITE = mediaType51;
            ITALY = mediaType52;
            MONARCH = mediaType53;
            PERSONAL = mediaType54;
        }

        private MediaType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class OrientationRequestedType extends AttributeValue {
        private static final int I_LANDSCAPE = 1;
        private static final int I_PORTRAIT = 0;
        private static final String[] NAMES = {"portrait", "landscape"};
        public static final OrientationRequestedType PORTRAIT = new OrientationRequestedType(0);
        public static final OrientationRequestedType LANDSCAPE = new OrientationRequestedType(1);

        private OrientationRequestedType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public static final class OriginType extends AttributeValue {
        private static final int I_PHYSICAL = 0;
        private static final int I_PRINTABLE = 1;
        private static final String[] NAMES = {"physical", "printable"};
        public static final OriginType PHYSICAL = new OriginType(0);
        public static final OriginType PRINTABLE = new OriginType(1);

        private OriginType(int i) {
            super(i, NAMES);
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // org.apache.poi.java.awt.AttributeValue
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }
    }

    public PageAttributes() {
        setColor(ColorType.MONOCHROME);
        setMediaToDefault();
        setOrientationRequestedToDefault();
        setOrigin(OriginType.PHYSICAL);
        setPrintQualityToDefault();
        setPrinterResolutionToDefault();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PageAttributes)) {
            return false;
        }
        PageAttributes pageAttributes = (PageAttributes) obj;
        if (this.color == pageAttributes.color && this.media == pageAttributes.media && this.orientationRequested == pageAttributes.orientationRequested && this.origin == pageAttributes.origin && this.printQuality == pageAttributes.printQuality) {
            int[] iArr = this.printerResolution;
            int i = iArr[0];
            int[] iArr2 = pageAttributes.printerResolution;
            if (i == iArr2[0] && iArr[1] == iArr2[1] && iArr[2] == iArr2[2]) {
                return true;
            }
        }
        return false;
    }

    public ColorType getColor() {
        return this.color;
    }

    public MediaType getMedia() {
        return this.media;
    }

    public OrientationRequestedType getOrientationRequested() {
        return this.orientationRequested;
    }

    public OriginType getOrigin() {
        return this.origin;
    }

    public PrintQualityType getPrintQuality() {
        return this.printQuality;
    }

    public int[] getPrinterResolution() {
        int[] iArr = this.printerResolution;
        return new int[]{iArr[0], iArr[1], iArr[2]};
    }

    public int hashCode() {
        int iHashCode = ((((this.color.hashCode() << 31) ^ (this.media.hashCode() << 24)) ^ (this.orientationRequested.hashCode() << 23)) ^ (this.origin.hashCode() << 22)) ^ (this.printQuality.hashCode() << 20);
        int[] iArr = this.printerResolution;
        return ((iHashCode ^ ((iArr[2] >> 2) << 19)) ^ (iArr[1] << 10)) ^ iArr[0];
    }

    public void set(PageAttributes pageAttributes) {
        this.color = pageAttributes.color;
        this.media = pageAttributes.media;
        this.orientationRequested = pageAttributes.orientationRequested;
        this.origin = pageAttributes.origin;
        this.printQuality = pageAttributes.printQuality;
        this.printerResolution = pageAttributes.printerResolution;
    }

    public void setColor(ColorType colorType) {
        if (colorType == null) {
            throw new IllegalArgumentException("Invalid value for attribute color");
        }
        this.color = colorType;
    }

    public void setMedia(MediaType mediaType) {
        if (mediaType == null) {
            throw new IllegalArgumentException("Invalid value for attribute media");
        }
        this.media = mediaType;
    }

    public void setMediaToDefault() {
        String country = Locale.getDefault().getCountry();
        setMedia((country == null || !(country.equals(Locale.US.getCountry()) || country.equals(Locale.CANADA.getCountry()))) ? MediaType.ISO_A4 : MediaType.NA_LETTER);
    }

    public void setOrientationRequested(int i) {
        setOrientationRequested(i != 3 ? i != 4 ? null : OrientationRequestedType.LANDSCAPE : OrientationRequestedType.PORTRAIT);
    }

    public void setOrientationRequestedToDefault() {
        setOrientationRequested(OrientationRequestedType.PORTRAIT);
    }

    public void setOrigin(OriginType originType) {
        if (originType == null) {
            throw new IllegalArgumentException("Invalid value for attribute origin");
        }
        this.origin = originType;
    }

    public void setPrintQuality(int i) {
        setPrintQuality(i != 3 ? i != 4 ? i != 5 ? null : PrintQualityType.HIGH : PrintQualityType.NORMAL : PrintQualityType.DRAFT);
    }

    public void setPrintQualityToDefault() {
        setPrintQuality(PrintQualityType.NORMAL);
    }

    public void setPrinterResolution(int i) {
        setPrinterResolution(new int[]{i, i, 3});
    }

    public void setPrinterResolutionToDefault() {
        setPrinterResolution(72);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("color=");
        sb.append(getColor());
        sb.append(",media=");
        sb.append(getMedia());
        sb.append(",orientation-requested=");
        sb.append(getOrientationRequested());
        sb.append(",origin=");
        sb.append(getOrigin());
        sb.append(",print-quality=");
        sb.append(getPrintQuality());
        sb.append(",printer-resolution=[");
        sb.append(this.printerResolution[0]);
        sb.append(",");
        sb.append(this.printerResolution[1]);
        sb.append(",");
        return AbstractC2821a.m2223n(sb, "]", this.printerResolution[2]);
    }

    public PageAttributes(ColorType colorType, MediaType mediaType, OrientationRequestedType orientationRequestedType, OriginType originType, PrintQualityType printQualityType, int[] iArr) {
        setColor(colorType);
        setMedia(mediaType);
        setOrientationRequested(orientationRequestedType);
        setOrigin(originType);
        setPrintQuality(printQualityType);
        setPrinterResolution(iArr);
    }

    public void setOrientationRequested(OrientationRequestedType orientationRequestedType) {
        if (orientationRequestedType == null) {
            throw new IllegalArgumentException("Invalid value for attribute orientationRequested");
        }
        this.orientationRequested = orientationRequestedType;
    }

    public void setPrintQuality(PrintQualityType printQualityType) {
        if (printQualityType == null) {
            throw new IllegalArgumentException("Invalid value for attribute printQuality");
        }
        this.printQuality = printQualityType;
    }

    public void setPrinterResolution(int[] iArr) {
        int i;
        int i2;
        int i4;
        if (iArr == null || iArr.length != 3 || (i = iArr[0]) <= 0 || (i2 = iArr[1]) <= 0 || !((i4 = iArr[2]) == 3 || i4 == 4)) {
            throw new IllegalArgumentException("Invalid value for attribute printerResolution");
        }
        this.printerResolution = new int[]{i, i2, i4};
    }

    public PageAttributes(PageAttributes pageAttributes) {
        set(pageAttributes);
    }
}
