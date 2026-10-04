package opennlp.tools.stemmer.snowball;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class greekStemmer extends AbstractSnowballStemmer {
    private boolean B_test1;
    private static final Among[] a_0 = {new Among("", -1, 25), new Among("Ά", 0, 1), new Among("Έ", 0, 5), new Among("Ή", 0, 7), new Among("Ί", 0, 9), new Among("Ό", 0, 15), new Among("Ύ", 0, 20), new Among("Ώ", 0, 24), new Among("ΐ", 0, 7), new Among("Α", 0, 1), new Among("Β", 0, 2), new Among("Γ", 0, 3), new Among("Δ", 0, 4), new Among("Ε", 0, 5), new Among("Ζ", 0, 6), new Among("Η", 0, 7), new Among("Θ", 0, 8), new Among("Ι", 0, 9), new Among("Κ", 0, 10), new Among("Λ", 0, 11), new Among("Μ", 0, 12), new Among("Ν", 0, 13), new Among("Ξ", 0, 14), new Among("Ο", 0, 15), new Among("Π", 0, 16), new Among("Ρ", 0, 17), new Among("Σ", 0, 18), new Among("Τ", 0, 19), new Among("Υ", 0, 20), new Among("Φ", 0, 21), new Among("Χ", 0, 22), new Among("Ψ", 0, 23), new Among("Ω", 0, 24), new Among("Ϊ", 0, 9), new Among("Ϋ", 0, 20), new Among("ά", 0, 1), new Among("έ", 0, 5), new Among("ή", 0, 7), new Among("ί", 0, 9), new Among("ΰ", 0, 20), new Among("ς", 0, 18), new Among("ϊ", 0, 7), new Among("ϋ", 0, 20), new Among("ό", 0, 15), new Among("ύ", 0, 20), new Among("ώ", 0, 24)};
    private static final Among[] a_1 = {new Among("σκαγια", -1, 2), new Among("φαγια", -1, 1), new Among("ολογια", -1, 3), new Among("σογια", -1, 4), new Among("τατογια", -1, 5), new Among("κρεατα", -1, 6), new Among("περατα", -1, 7), new Among("τερατα", -1, 8), new Among("γεγονοτα", -1, 11), new Among("καθεστωτα", -1, 10), new Among("φωτα", -1, 9), new Among("περατη", -1, 7), new Among("σκαγιων", -1, 2), new Among("φαγιων", -1, 1), new Among("ολογιων", -1, 3), new Among("σογιων", -1, 4), new Among("τατογιων", -1, 5), new Among("κρεατων", -1, 6), new Among("περατων", -1, 7), new Among("τερατων", -1, 8), new Among("γεγονοτων", -1, 11), new Among("καθεστωτων", -1, 10), new Among("φωτων", -1, 9), new Among("κρεασ", -1, 6), new Among("περασ", -1, 7), new Among("τερασ", -1, 8), new Among("γεγονοσ", -1, 11), new Among("κρεατοσ", -1, 6), new Among("περατοσ", -1, 7), new Among("τερατοσ", -1, 8), new Among("γεγονοτοσ", -1, 11), new Among("καθεστωτοσ", -1, 10), new Among("φωτοσ", -1, 9), new Among("καθεστωσ", -1, 10), new Among("φωσ", -1, 9), new Among("σκαγιου", -1, 2), new Among("φαγιου", -1, 1), new Among("ολογιου", -1, 3), new Among("σογιου", -1, 4), new Among("τατογιου", -1, 5)};
    private static final Among[] a_2 = {new Among("πα", -1, 1), new Among("ξαναπα", 0, 1), new Among("επα", 0, 1), new Among("περιπα", 0, 1), new Among("αναμπα", 0, 1), new Among("εμπα", 0, 1), new Among("β", -1, 2), new Among("δανε", -1, 1), new Among("βαθυρι", -1, 2), new Among("βαρκ", -1, 2), new Among("μαρκ", -1, 2), new Among("λ", -1, 2), new Among("μ", -1, 2), new Among("κορν", -1, 2), new Among("αθρο", -1, 1), new Among("συναθρο", 14, 1), new Among("π", -1, 2), new Among("ιμπ", 16, 2), new Among("ρ", -1, 2), new Among("μαρ", 18, 2), new Among("αμπαρ", 18, 2), new Among("γκρ", 18, 2), new Among("βολβορ", 18, 2), new Among("γλυκορ", 18, 2), new Among("πιπερορ", 18, 2), new Among("πρ", 18, 2), new Among("μπρ", 25, 2), new Among("αρρ", 18, 2), new Among("γλυκυρ", 18, 2), new Among("πολυρ", 18, 2), new Among("λου", -1, 2)};
    private static final Among[] a_3 = {new Among("ιζα", -1, 1), new Among("ιζε", -1, 1), new Among("ιζαμε", -1, 1), new Among("ιζουμε", -1, 1), new Among("ιζανε", -1, 1), new Among("ιζουνε", -1, 1), new Among("ιζατε", -1, 1), new Among("ιζετε", -1, 1), new Among("ιζει", -1, 1), new Among("ιζαν", -1, 1), new Among("ιζουν", -1, 1), new Among("ιζεσ", -1, 1), new Among("ιζεισ", -1, 1), new Among("ιζω", -1, 1)};
    private static final Among[] a_4 = {new Among("βι", -1, 1), new Among("λι", -1, 1), new Among("αλ", -1, 1), new Among("εν", -1, 1), new Among("σ", -1, 1), new Among("χ", -1, 1), new Among("υψ", -1, 1), new Among("ζω", -1, 1)};
    private static final Among[] a_5 = {new Among("ωθηκα", -1, 1), new Among("ωθηκε", -1, 1), new Among("ωθηκαμε", -1, 1), new Among("ωθηκανε", -1, 1), new Among("ωθηκατε", -1, 1), new Among("ωθηκαν", -1, 1), new Among("ωθηκεσ", -1, 1)};
    private static final Among[] a_6 = {new Among("ξαναπα", -1, 1), new Among("επα", -1, 1), new Among("περιπα", -1, 1), new Among("αναμπα", -1, 1), new Among("εμπα", -1, 1), new Among("χαρτοπα", -1, 1), new Among("εξαρχα", -1, 1), new Among("γε", -1, 2), new Among("γκε", -1, 2), new Among("κλε", -1, 1), new Among("εκλε", 9, 1), new Among("απεκλε", 10, 1), new Among("αποκλε", 9, 1), new Among("εσωκλε", 9, 1), new Among("δανε", -1, 1), new Among("πε", -1, 1), new Among("επε", 15, 1), new Among("μετεπε", 16, 1), new Among("εσε", -1, 1), new Among("γκ", -1, 2), new Among("μ", -1, 2), new Among("πουκαμ", 20, 2), new Among("κομ", 20, 2), new Among("αν", -1, 2), new Among("ολο", -1, 2), new Among("αθρο", -1, 1), new Among("συναθρο", 25, 1), new Among("π", -1, 2), new Among("λαρ", -1, 2), new Among("δημοκρατ", -1, 2), new Among("αφ", -1, 2), new Among("γιγαντοαφ", 30, 2)};
    private static final Among[] a_7 = {new Among("ισα", -1, 1), new Among("ισαμε", -1, 1), new Among("ισανε", -1, 1), new Among("ισε", -1, 1), new Among("ισατε", -1, 1), new Among("ισαν", -1, 1), new Among("ισεσ", -1, 1)};
    private static final Among[] a_8 = {new Among("ξαναπα", -1, 1), new Among("επα", -1, 1), new Among("περιπα", -1, 1), new Among("αναμπα", -1, 1), new Among("εμπα", -1, 1), new Among("χαρτοπα", -1, 1), new Among("εξαρχα", -1, 1), new Among("κλε", -1, 1), new Among("εκλε", 7, 1), new Among("απεκλε", 8, 1), new Among("αποκλε", 7, 1), new Among("εσωκλε", 7, 1), new Among("δανε", -1, 1), new Among("πε", -1, 1), new Among("επε", 13, 1), new Among("μετεπε", 14, 1), new Among("εσε", -1, 1), new Among("αθρο", -1, 1), new Among("συναθρο", 17, 1)};
    private static final Among[] a_9 = {new Among("ισουμε", -1, 1), new Among("ισουνε", -1, 1), new Among("ισετε", -1, 1), new Among("ισει", -1, 1), new Among("ισουν", -1, 1), new Among("ισεισ", -1, 1), new Among("ισω", -1, 1)};
    private static final Among[] a_10 = {new Among("ατα", -1, 2), new Among("φα", -1, 2), new Among("ηφα", 1, 2), new Among("μεγ", -1, 2), new Among("λυγ", -1, 2), new Among("ηδ", -1, 2), new Among("κλε", -1, 1), new Among("εσωκλε", 6, 1), new Among("πλε", -1, 1), new Among("δανε", -1, 1), new Among("σε", -1, 1), new Among("ασε", 10, 1), new Among("καθ", -1, 2), new Among("εχθ", -1, 2), new Among("κακ", -1, 2), new Among("μακ", -1, 2), new Among("σκ", -1, 2), new Among("φιλ", -1, 2), new Among("κυλ", -1, 2), new Among("μ", -1, 2), new Among("γεμ", 19, 2), new Among("αχν", -1, 2), new Among("συναθρο", -1, 1), new Among("π", -1, 2), new Among("απ", 23, 2), new Among("εμπ", 23, 2), new Among("ευπ", 23, 2), new Among("αρ", -1, 2), new Among("αορ", -1, 2), new Among("γυρ", -1, 2), new Among("χρ", -1, 2), new Among("χωρ", -1, 2), new Among("κτ", -1, 2), new Among("ακτ", 32, 2), new Among("χτ", -1, 2), new Among("αχτ", 34, 2), new Among("ταχ", -1, 2), new Among("σχ", -1, 2), new Among("ασχ", 37, 2), new Among("υψ", -1, 2)};
    private static final Among[] a_11 = {new Among("ιστα", -1, 1), new Among("ιστε", -1, 1), new Among("ιστη", -1, 1), new Among("ιστοι", -1, 1), new Among("ιστων", -1, 1), new Among("ιστο", -1, 1), new Among("ιστεσ", -1, 1), new Among("ιστησ", -1, 1), new Among("ιστοσ", -1, 1), new Among("ιστουσ", -1, 1), new Among("ιστου", -1, 1)};
    private static final Among[] a_12 = {new Among("εγκλε", -1, 1), new Among("αποκλε", -1, 1), new Among("δανε", -1, 2), new Among("αντιδανε", 2, 2), new Among("σε", -1, 1), new Among("μετασε", 4, 1), new Among("μικροσε", 4, 1)};
    private static final Among[] a_13 = {new Among("ατομικ", -1, 2), new Among("εθνικ", -1, 4), new Among("τοπικ", -1, 7), new Among("εκλεκτικ", -1, 5), new Among("σκεπτικ", -1, 6), new Among("γνωστικ", -1, 3), new Among("αγνωστικ", 5, 1), new Among("αλεξανδριν", -1, 8), new Among("θεατριν", -1, 10), new Among("βυζαντιν", -1, 9)};
    private static final Among[] a_14 = {new Among("ισμοι", -1, 1), new Among("ισμων", -1, 1), new Among("ισμο", -1, 1), new Among("ισμοσ", -1, 1), new Among("ισμουσ", -1, 1), new Among("ισμου", -1, 1)};
    private static final Among[] a_15 = {new Among("σ", -1, 1), new Among("χ", -1, 1)};
    private static final Among[] a_16 = {new Among("ουδακια", -1, 1), new Among("αρακια", -1, 1), new Among("ουδακι", -1, 1), new Among("αρακι", -1, 1)};
    private static final Among[] a_17 = {new Among("β", -1, 2), new Among("βαμβ", 0, 1), new Among("σλοβ", 0, 1), new Among("τσεχοσλοβ", 2, 1), new Among("καρδ", -1, 2), new Among("ζ", -1, 2), new Among("τζ", 5, 1), new Among("κ", -1, 1), new Among("καπακ", 7, 1), new Among("σοκ", 7, 1), new Among("σκ", 7, 1), new Among("βαλ", -1, 2), new Among("μαλ", -1, 1), new Among("γλ", -1, 2), new Among("τριπολ", -1, 2), new Among("πλ", -1, 1), new Among("λουλ", -1, 1), new Among("φυλ", -1, 1), new Among("καιμ", -1, 1), new Among("κλιμ", -1, 1), new Among("φαρμ", -1, 1), new Among("γιαν", -1, 2), new Among("σπαν", -1, 1), new Among("ηγουμεν", -1, 2), new Among("κον", -1, 1), new Among("μακρυν", -1, 2), new Among("π", -1, 2), new Among("κατραπ", 26, 1), new Among("ρ", -1, 1), new Among("βρ", 28, 1), new Among("λαβρ", 29, 1), new Among("αμβρ", 29, 1), new Among("μερ", 28, 1), new Among("πατερ", 28, 2), new Among("ανθρ", 28, 1), new Among("κορ", 28, 1), new Among("σ", -1, 1), new Among("ναγκασ", 36, 1), new Among("τοσ", 36, 2), new Among("μουστ", -1, 1), new Among("ρυ", -1, 1), new Among("φ", -1, 1), new Among("σφ", 41, 1), new Among("αλισφ", 42, 1), new Among("νυφ", 41, 2), new Among("χ", -1, 1)};
    private static final Among[] a_18 = {new Among("ακια", -1, 1), new Among("αρακια", 0, 1), new Among("ιτσα", -1, 1), new Among("ακι", -1, 1), new Among("αρακι", 3, 1), new Among("ιτσων", -1, 1), new Among("ιτσασ", -1, 1), new Among("ιτσεσ", -1, 1)};
    private static final Among[] a_19 = {new Among("ψαλ", -1, 1), new Among("αιφν", -1, 1), new Among("ολο", -1, 1), new Among("ιρ", -1, 1)};
    private static final Among[] a_20 = {new Among("ε", -1, 1), new Among("παιχν", -1, 1)};
    private static final Among[] a_21 = {new Among("ιδια", -1, 1), new Among("ιδιων", -1, 1), new Among("ιδιο", -1, 1)};
    private static final Among[] a_22 = {new Among("ιβ", -1, 1), new Among("δ", -1, 1), new Among("φραγκ", -1, 1), new Among("λυκ", -1, 1), new Among("οβελ", -1, 1), new Among("μην", -1, 1), new Among("ρ", -1, 1)};
    private static final Among[] a_23 = {new Among("ισκε", -1, 1), new Among("ισκο", -1, 1), new Among("ισκοσ", -1, 1), new Among("ισκου", -1, 1)};
    private static final Among[] a_24 = {new Among("αδων", -1, 1), new Among("αδεσ", -1, 1)};
    private static final Among[] a_25 = {new Among("γιαγι", -1, -1), new Among("θει", -1, -1), new Among("οκ", -1, -1), new Among("μαμ", -1, -1), new Among("μαν", -1, -1), new Among("μπαμπ", -1, -1), new Among("πεθερ", -1, -1), new Among("πατερ", -1, -1), new Among("κυρ", -1, -1), new Among("νταντ", -1, -1)};
    private static final Among[] a_26 = {new Among("εδων", -1, 1), new Among("εδεσ", -1, 1)};
    private static final Among[] a_27 = {new Among("μιλ", -1, 1), new Among("δαπ", -1, 1), new Among("γηπ", -1, 1), new Among("ιπ", -1, 1), new Among("εμπ", -1, 1), new Among("οπ", -1, 1), new Among("κρασπ", -1, 1), new Among("υπ", -1, 1)};
    private static final Among[] a_28 = {new Among("ουδων", -1, 1), new Among("ουδεσ", -1, 1)};
    private static final Among[] a_29 = {new Among("τραγ", -1, 1), new Among("φε", -1, 1), new Among("καλιακ", -1, 1), new Among("αρκ", -1, 1), new Among("σκ", -1, 1), new Among("πεταλ", -1, 1), new Among("βελ", -1, 1), new Among("λουλ", -1, 1), new Among("φλ", -1, 1), new Among("χν", -1, 1), new Among("πλεξ", -1, 1), new Among("σπ", -1, 1), new Among("φρ", -1, 1), new Among("σ", -1, 1), new Among("λιχ", -1, 1)};
    private static final Among[] a_30 = {new Among("εων", -1, 1), new Among("εωσ", -1, 1)};
    private static final Among[] a_31 = {new Among("δ", -1, 1), new Among("ιδ", 0, 1), new Among("θ", -1, 1), new Among("γαλ", -1, 1), new Among("ελ", -1, 1), new Among("ν", -1, 1), new Among("π", -1, 1), new Among("παρ", -1, 1)};
    private static final Among[] a_32 = {new Among("ια", -1, 1), new Among("ιων", -1, 1), new Among("ιου", -1, 1)};
    private static final Among[] a_33 = {new Among("ικα", -1, 1), new Among("ικων", -1, 1), new Among("ικο", -1, 1), new Among("ικου", -1, 1)};
    private static final Among[] a_34 = {new Among("αδ", -1, 1), new Among("συναδ", 0, 1), new Among("καταδ", 0, 1), new Among("αντιδ", -1, 1), new Among("ενδ", -1, 1), new Among("φυλοδ", -1, 1), new Among("υποδ", -1, 1), new Among("πρωτοδ", -1, 1), new Among("εξωδ", -1, 1), new Among("ηθ", -1, 1), new Among("ανηθ", 9, 1), new Among("ξικ", -1, 1), new Among("αλ", -1, 1), new Among("αμμοχαλ", 12, 1), new Among("συνομηλ", -1, 1), new Among("μπολ", -1, 1), new Among("μουλ", -1, 1), new Among("τσαμ", -1, 1), new Among("βρωμ", -1, 1), new Among("αμαν", -1, 1), new Among("μπαν", -1, 1), new Among("καλλιν", -1, 1), new Among("ποστελν", -1, 1), new Among("φιλον", -1, 1), new Among("καλπ", -1, 1), new Among("γερ", -1, 1), new Among("χασ", -1, 1), new Among("μποσ", -1, 1), new Among("πλιατσ", -1, 1), new Among("πετσ", -1, 1), new Among("πιτσ", -1, 1), new Among("φυσ", -1, 1), new Among("μπαγιατ", -1, 1), new Among("νιτ", -1, 1), new Among("πικαντ", -1, 1), new Among("σερτ", -1, 1)};
    private static final Among[] a_35 = {new Among("αγαμε", -1, 1), new Among("ηκαμε", -1, 1), new Among("ηθηκαμε", 1, 1), new Among("ησαμε", -1, 1), new Among("ουσαμε", -1, 1)};
    private static final Among[] a_36 = {new Among("βουβ", -1, 1), new Among("ξεθ", -1, 1), new Among("πεθ", -1, 1), new Among("αποθ", -1, 1), new Among("αποκ", -1, 1), new Among("ουλ", -1, 1), new Among("αναπ", -1, 1), new Among("πικρ", -1, 1), new Among("ποτ", -1, 1), new Among("αποστ", -1, 1), new Among("χ", -1, 1), new Among("σιχ", 10, 1)};
    private static final Among[] a_37 = {new Among("τρ", -1, 1), new Among("τσ", -1, 1)};
    private static final Among[] a_38 = {new Among("αγανε", -1, 1), new Among("ηκανε", -1, 1), new Among("ηθηκανε", 1, 1), new Among("ησανε", -1, 1), new Among("ουσανε", -1, 1), new Among("οντανε", -1, 1), new Among("ιοντανε", 5, 1), new Among("ουντανε", -1, 1), new Among("ιουντανε", 7, 1), new Among("οτανε", -1, 1), new Among("ιοτανε", 9, 1)};
    private static final Among[] a_39 = {new Among("ταβ", -1, 1), new Among("νταβ", 0, 1), new Among("ψηλοταβ", 0, 1), new Among("λιβ", -1, 1), new Among("κλιβ", 3, 1), new Among("ξηροκλιβ", 4, 1), new Among("γ", -1, 1), new Among("αγ", 6, 1), new Among("τραγ", 7, 1), new Among("τσαγ", 7, 1), new Among("αθιγγ", 6, 1), new Among("τσιγγ", 6, 1), new Among("ατσιγγ", 11, 1), new Among("στεγ", 6, 1), new Among("απηγ", 6, 1), new Among("σιγ", 6, 1), new Among("ανοργ", 6, 1), new Among("ενοργ", 6, 1), new Among("καλπουζ", -1, 1), new Among("θ", -1, 1), new Among("μωαμεθ", 19, 1), new Among("πιθ", 19, 1), new Among("απιθ", 21, 1), new Among("δεκ", -1, 1), new Among("πελεκ", -1, 1), new Among("ικ", -1, 1), new Among("ανικ", 25, 1), new Among("βουλκ", -1, 1), new Among("βασκ", -1, 1), new Among("βραχυκ", -1, 1), new Among("γαλ", -1, 1), new Among("καταγαλ", 30, 1), new Among("ολογαλ", 30, 1), new Among("βαθυγαλ", 30, 1), new Among("μελ", -1, 1), new Among("καστελ", -1, 1), new Among("πορτολ", -1, 1), new Among("πλ", -1, 1), new Among("διπλ", 37, 1), new Among("λαοπλ", 37, 1), new Among("ψυχοπλ", 37, 1), new Among("ουλ", -1, 1), new Among("μ", -1, 1), new Among("ολιγοδαμ", 42, 1), new Among("μουσουλμ", 42, 1), new Among("δραδουμ", 42, 1), new Among("βραχμ", 42, 1), new Among("ν", -1, 1), new Among("αμερικαν", 47, 1), new Among("π", -1, 1), new Among("αδαπ", 49, 1), new Among("χαμηλοδαπ", 49, 1), new Among("πολυδαπ", 49, 1), new Among("κοπ", 49, 1), new Among("υποκοπ", 53, 1), new Among("τσοπ", 49, 1), new Among("σπ", 49, 1), new Among("ερ", -1, 1), new Among("γερ", 57, 1), new Among("βετερ", 57, 1), new Among("λουθηρ", -1, 1), new Among("κορμορ", -1, 1), new Among("περιτρ", -1, 1), new Among("ουρ", -1, 1), new Among("σ", -1, 1), new Among("βασ", 64, 1), new Among("πολισ", 64, 1), new Among("σαρακατσ", 64, 1), new Among("θυσ", 64, 1), new Among("διατ", -1, 1), new Among("πλατ", -1, 1), new Among("τσαρλατ", -1, 1), new Among("τετ", -1, 1), new Among("πουριτ", -1, 1), new Among("σουλτ", -1, 1), new Among("μαιντ", -1, 1), new Among("ζωντ", -1, 1), new Among("καστ", -1, 1), new Among("φ", -1, 1), new Among("διαφ", 78, 1), new Among("στεφ", 78, 1), new Among("φωτοστεφ", 80, 1), new Among("περηφ", 78, 1), new Among("υπερηφ", 82, 1), new Among("κοιλαρφ", 78, 1), new Among("πενταρφ", 78, 1), new Among("ορφ", 78, 1), new Among("χ", -1, 1), new Among("αμηχ", 87, 1), new Among("βιομηχ", 87, 1), new Among("μεγλοβιομηχ", 89, 1), new Among("καπνοβιομηχ", 89, 1), new Among("μικροβιομηχ", 89, 1), new Among("πολυμηχ", 87, 1), new Among("λιχ", 87, 1)};
    private static final Among[] a_40 = {new Among("ησετε", -1, 1)};
    private static final Among[] a_41 = {new Among("ενδ", -1, 1), new Among("συνδ", -1, 1), new Among("οδ", -1, 1), new Among("διαθ", -1, 1), new Among("καθ", -1, 1), new Among("ραθ", -1, 1), new Among("ταθ", -1, 1), new Among("τιθ", -1, 1), new Among("εκθ", -1, 1), new Among("ενθ", -1, 1), new Among("συνθ", -1, 1), new Among("ροθ", -1, 1), new Among("υπερθ", -1, 1), new Among("σθ", -1, 1), new Among("ευθ", -1, 1), new Among("αρκ", -1, 1), new Among("ωφελ", -1, 1), new Among("βολ", -1, 1), new Among("αιν", -1, 1), new Among("πον", -1, 1), new Among("ρον", -1, 1), new Among("συν", -1, 1), new Among("βαρ", -1, 1), new Among("βρ", -1, 1), new Among("αιρ", -1, 1), new Among("φορ", -1, 1), new Among("ευρ", -1, 1), new Among("πυρ", -1, 1), new Among("χωρ", -1, 1), new Among("νετ", -1, 1), new Among("σχ", -1, 1)};
    private static final Among[] a_42 = {new Among("παγ", -1, 1), new Among("δ", -1, 1), new Among("αδ", 1, 1), new Among("θ", -1, 1), new Among("αθ", 3, 1), new Among("τοκ", -1, 1), new Among("σκ", -1, 1), new Among("παρακαλ", -1, 1), new Among("σκελ", -1, 1), new Among("απλ", -1, 1), new Among("εμ", -1, 1), new Among("αν", -1, 1), new Among("βεν", -1, 1), new Among("βαρον", -1, 1), new Among("κοπ", -1, 1), new Among("σερπ", -1, 1), new Among("αβαρ", -1, 1), new Among("εναρ", -1, 1), new Among("αβρ", -1, 1), new Among("μπορ", -1, 1), new Among("θαρρ", -1, 1), new Among("ντρ", -1, 1), new Among("υ", -1, 1), new Among("νιφ", -1, 1), new Among("συρφ", -1, 1)};
    private static final Among[] a_43 = {new Among("οντασ", -1, 1), new Among("ωντασ", -1, 1)};
    private static final Among[] a_44 = {new Among("ομαστε", -1, 1), new Among("ιομαστε", 0, 1)};
    private static final Among[] a_45 = {new Among("π", -1, 1), new Among("απ", 0, 1), new Among("ακαταπ", 1, 1), new Among("συμπ", 0, 1), new Among("ασυμπ", 3, 1), new Among("αμεταμφ", -1, 1)};
    private static final Among[] a_46 = {new Among("ζ", -1, 1), new Among("αλ", -1, 1), new Among("παρακαλ", 1, 1), new Among("εκτελ", -1, 1), new Among("μ", -1, 1), new Among("ξ", -1, 1), new Among("προ", -1, 1), new Among("αρ", -1, 1), new Among("νισ", -1, 1)};
    private static final Among[] a_47 = {new Among("ηθηκα", -1, 1), new Among("ηθηκε", -1, 1), new Among("ηθηκεσ", -1, 1)};
    private static final Among[] a_48 = {new Among("πιθ", -1, 1), new Among("οθ", -1, 1), new Among("ναρθ", -1, 1), new Among("σκουλ", -1, 1), new Among("σκωλ", -1, 1), new Among("σφ", -1, 1)};
    private static final Among[] a_49 = {new Among("θ", -1, 1), new Among("διαθ", 0, 1), new Among("παρακαταθ", 0, 1), new Among("συνθ", 0, 1), new Among("προσθ", 0, 1)};
    private static final Among[] a_50 = {new Among("ηκα", -1, 1), new Among("ηκε", -1, 1), new Among("ηκεσ", -1, 1)};
    private static final Among[] a_51 = {new Among("φαγ", -1, 1), new Among("ληγ", -1, 1), new Among("φρυδ", -1, 1), new Among("μαντιλ", -1, 1), new Among("μαλλ", -1, 1), new Among("ομ", -1, 1), new Among("βλεπ", -1, 1), new Among("ποδαρ", -1, 1), new Among("κυματ", -1, 1), new Among("πρωτ", -1, 1), new Among("λαχ", -1, 1), new Among("πανταχ", -1, 1)};
    private static final Among[] a_52 = {new Among("τσα", -1, 1), new Among("χαδ", -1, 1), new Among("μεδ", -1, 1), new Among("λαμπιδ", -1, 1), new Among("δε", -1, 1), new Among("πλε", -1, 1), new Among("μεσαζ", -1, 1), new Among("δεσποζ", -1, 1), new Among("αιθ", -1, 1), new Among("φαρμακ", -1, 1), new Among("αγκ", -1, 1), new Among("ανηκ", -1, 1), new Among("λ", -1, 1), new Among("μ", -1, 1), new Among("αμ", 13, 1), new Among("βρομ", 13, 1), new Among("υποτειν", -1, 1), new Among("εκλιπ", -1, 1), new Among("ρ", -1, 1), new Among("ενδιαφερ", 18, 1), new Among("αναρρ", 18, 1), new Among("πατ", -1, 1), new Among("καθαρευ", -1, 1), new Among("δευτερευ", -1, 1), new Among("λεχ", -1, 1)};
    private static final Among[] a_53 = {new Among("ουσα", -1, 1), new Among("ουσε", -1, 1), new Among("ουσεσ", -1, 1)};
    private static final Among[] a_54 = {new Among("πελ", -1, 1), new Among("λλ", -1, 1), new Among("σμην", -1, 1), new Among("ρπ", -1, 1), new Among("πρ", -1, 1), new Among("φρ", -1, 1), new Among("χορτ", -1, 1), new Among("οφ", -1, 1), new Among("ψοφ", 7, -1), new Among("σφ", -1, 1), new Among("λοχ", -1, 1), new Among("ναυλοχ", 10, -1)};
    private static final Among[] a_55 = {new Among("αμαλλι", -1, 1), new Among("λ", -1, 1), new Among("αμαλ", 1, 1), new Among("μ", -1, 1), new Among("ουλαμ", 3, 1), new Among("εν", -1, 1), new Among("δερβεν", 5, 1), new Among("π", -1, 1), new Among("αειπ", 7, 1), new Among("αρτιπ", 7, 1), new Among("συμπ", 7, 1), new Among("νεοπ", 7, 1), new Among("κροκαλοπ", 7, 1), new Among("ολοπ", 7, 1), new Among("προσωποπ", 7, 1), new Among("σιδηροπ", 7, 1), new Among("δροσοπ", 7, 1), new Among("ασπ", 7, 1), new Among("ανυπ", 7, 1), new Among("ρ", -1, 1), new Among("ασπαρ", 19, 1), new Among("χαρ", 19, 1), new Among("αχαρ", 21, 1), new Among("απερ", 19, 1), new Among("τρ", 19, 1), new Among("ουρ", 19, 1), new Among("τ", -1, 1), new Among("διατ", 26, 1), new Among("επιτ", 26, 1), new Among("συντ", 26, 1), new Among("ομοτ", 26, 1), new Among("νομοτ", 30, 1), new Among("αποτ", 26, 1), new Among("υποτ", 26, 1), new Among("αβαστ", 26, 1), new Among("αιμοστ", 26, 1), new Among("προστ", 26, 1), new Among("ανυστ", 26, 1), new Among("ναυ", -1, 1), new Among("αφ", -1, 1), new Among("ξεφ", -1, 1), new Among("αδηφ", -1, 1), new Among("παμφ", -1, 1), new Among("πολυφ", -1, 1)};
    private static final Among[] a_56 = {new Among("αγα", -1, 1), new Among("αγε", -1, 1), new Among("αγεσ", -1, 1)};
    private static final Among[] a_57 = {new Among("ησα", -1, 1), new Among("ησε", -1, 1), new Among("ησου", -1, 1)};
    private static final Among[] a_58 = {new Among("ν", -1, 1), new Among("δωδεκαν", 0, 1), new Among("επταν", 0, 1), new Among("μεγαλον", 0, 1), new Among("ερημον", 0, 1), new Among("χερσον", 0, 1)};
    private static final Among[] a_59 = {new Among("ηστε", -1, 1)};
    private static final Among[] a_60 = {new Among("σβ", -1, 1), new Among("ασβ", 0, 1), new Among("απλ", -1, 1), new Among("αειμν", -1, 1), new Among("χρ", -1, 1), new Among("αχρ", 4, 1), new Among("κοινοχρ", 4, 1), new Among("δυσχρ", 4, 1), new Among("ευχρ", 4, 1), new Among("παλιμψ", -1, 1)};
    private static final Among[] a_61 = {new Among("ουνε", -1, 1), new Among("ηθουνε", 0, 1), new Among("ησουνε", 0, 1)};
    private static final Among[] a_62 = {new Among("σπι", -1, 1), new Among("ν", -1, 1), new Among("εξων", 1, 1), new Among("ρ", -1, 1), new Among("στραβομουτσ", -1, 1), new Among("κακομουτσ", -1, 1)};
    private static final Among[] a_63 = {new Among("ουμε", -1, 1), new Among("ηθουμε", 0, 1), new Among("ησουμε", 0, 1)};
    private static final Among[] a_64 = {new Among("αζ", -1, 1), new Among("ωριοπλ", -1, 1), new Among("ασουσ", -1, 1), new Among("παρασουσ", 2, 1), new Among("αλλοσουσ", -1, 1), new Among("φ", -1, 1), new Among("χ", -1, 1)};
    private static final Among[] a_65 = {new Among("ματα", -1, 1), new Among("ματων", -1, 1), new Among("ματοσ", -1, 1)};
    private static final Among[] a_66 = {new Among("α", -1, 1), new Among("ιουμα", 0, 1), new Among("ομουνα", 0, 1), new Among("ιομουνα", 2, 1), new Among("οσουνα", 0, 1), new Among("ιοσουνα", 4, 1), new Among("ε", -1, 1), new Among("αγατε", 6, 1), new Among("ηκατε", 6, 1), new Among("ηθηκατε", 8, 1), new Among("ησατε", 6, 1), new Among("ουσατε", 6, 1), new Among("ειτε", 6, 1), new Among("ηθειτε", 12, 1), new Among("ιεμαστε", 6, 1), new Among("ουμαστε", 6, 1), new Among("ιουμαστε", 15, 1), new Among("ιεσαστε", 6, 1), new Among("οσαστε", 6, 1), new Among("ιοσαστε", 18, 1), new Among("η", -1, 1), new Among("ι", -1, 1), new Among("αμαι", 21, 1), new Among("ιεμαι", 21, 1), new Among("ομαι", 21, 1), new Among("ουμαι", 21, 1), new Among("ασαι", 21, 1), new Among("εσαι", 21, 1), new Among("ιεσαι", 27, 1), new Among("αται", 21, 1), new Among("εται", 21, 1), new Among("ιεται", 30, 1), new Among("ονται", 21, 1), new Among("ουνται", 21, 1), new Among("ιουνται", 33, 1), new Among("ει", 21, 1), new Among("αει", 35, 1), new Among("ηθει", 35, 1), new Among("ησει", 35, 1), new Among("οι", 21, 1), new Among("αν", -1, 1), new Among("αγαν", 40, 1), new Among("ηκαν", 40, 1), new Among("ηθηκαν", 42, 1), new Among("ησαν", 40, 1), new Among("ουσαν", 40, 1), new Among("οντουσαν", 45, 1), new Among("ιοντουσαν", 46, 1), new Among("ονταν", 40, 1), new Among("ιονταν", 48, 1), new Among("ουνταν", 40, 1), new Among("ιουνταν", 50, 1), new Among("οταν", 40, 1), new Among("ιοταν", 52, 1), new Among("ομασταν", 40, 1), new Among("ιομασταν", 54, 1), new Among("οσασταν", 40, 1), new Among("ιοσασταν", 56, 1), new Among("ουν", -1, 1), new Among("ηθουν", 58, 1), new Among("ομουν", 58, 1), new Among("ιομουν", 60, 1), new Among("ησουν", 58, 1), new Among("οσουν", 58, 1), new Among("ιοσουν", 63, 1), new Among("ων", -1, 1), new Among("ηδων", 65, 1), new Among("ο", -1, 1), new Among("ασ", -1, 1), new Among("εσ", -1, 1), new Among("ηδεσ", 69, 1), new Among("ησεσ", 69, 1), new Among("ησ", -1, 1), new Among("εισ", -1, 1), new Among("ηθεισ", 73, 1), new Among("οσ", -1, 1), new Among("υσ", -1, 1), new Among("ουσ", 76, 1), new Among("υ", -1, 1), new Among("ου", 78, 1), new Among("ω", -1, 1), new Among("αω", 80, 1), new Among("ηθω", 80, 1), new Among("ησω", 80, 1)};
    private static final Among[] a_67 = {new Among("οτερ", -1, 1), new Among("εστερ", -1, 1), new Among("υτερ", -1, 1), new Among("ωτερ", -1, 1), new Among("οτατ", -1, 1), new Among("εστατ", -1, 1), new Among("υτατ", -1, 1), new Among("ωτατ", -1, 1)};
    private static final char[] g_v = {'Q', 'A', 16, 1};
    private static final char[] g_v2 = {'Q', 'A', 0, 1};

    private boolean r_has_min_length() {
        return this.current.length() >= 3;
    }

    private boolean r_step1() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_1);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        switch (iFind_among_b) {
            case 1:
                slice_from("φα");
                break;
            case 2:
                slice_from("σκα");
                break;
            case 3:
                slice_from("ολο");
                break;
            case 4:
                slice_from("σο");
                break;
            case 5:
                slice_from("τατο");
                break;
            case 6:
                slice_from("κρε");
                break;
            case 7:
                slice_from("περ");
                break;
            case 8:
                slice_from("τερ");
                break;
            case 9:
                slice_from("φω");
                break;
            case 10:
                slice_from("καθεστ");
                break;
            case 11:
                slice_from("γεγον");
                break;
        }
        this.B_test1 = false;
        return true;
    }

    private boolean r_step2a() {
        this.ket = this.cursor;
        if (find_among_b(a_24) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        int i = this.limit - this.cursor;
        if (find_among_b(a_25) != 0) {
            return false;
        }
        int i2 = this.limit - i;
        this.cursor = i2;
        insert(i2, i2, "αδ");
        this.cursor = i2;
        return true;
    }

    private boolean r_step2b() {
        this.ket = this.cursor;
        if (find_among_b(a_26) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_27) == 0) {
            return false;
        }
        slice_from("εδ");
        return true;
    }

    private boolean r_step2c() {
        this.ket = this.cursor;
        if (find_among_b(a_28) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_29) == 0) {
            return false;
        }
        slice_from("ουδ");
        return true;
    }

    private boolean r_step2d() {
        this.ket = this.cursor;
        if (find_among_b(a_30) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_31) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ε");
        return true;
    }

    private boolean r_step3() {
        this.ket = this.cursor;
        if (find_among_b(a_32) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (!in_grouping_b(g_v, 945, 969)) {
            return false;
        }
        slice_from("ι");
        return true;
    }

    private boolean r_step4() {
        this.ket = this.cursor;
        if (find_among_b(a_33) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        if (in_grouping_b(g_v, 945, 969)) {
            slice_from("ικ");
        } else {
            int i5 = this.limit - i4;
            this.cursor = i5;
            this.ket = i5;
        }
        this.bra = this.cursor;
        if (find_among_b(a_34) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ικ");
        return true;
    }

    private boolean r_step5a() {
        int i = this.limit - this.cursor;
        if (eq_s_b("αγαμε") && this.cursor <= this.limit_backward) {
            slice_from("αγαμ");
        }
        int i2 = this.limit;
        int i4 = i2 - i;
        this.cursor = i4;
        int i5 = i2 - i4;
        this.ket = i4;
        if (find_among_b(a_35) != 0) {
            this.bra = this.cursor;
            slice_del();
            this.B_test1 = false;
        }
        int i6 = this.limit - i5;
        this.cursor = i6;
        this.ket = i6;
        if (!eq_s_b("αμε")) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i7 = this.cursor;
        this.ket = i7;
        this.bra = i7;
        if (find_among_b(a_36) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("αμ");
        return true;
    }

    private boolean r_step5b() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (find_among_b(a_38) != 0) {
            this.bra = this.cursor;
            slice_del();
            this.B_test1 = false;
            int i5 = this.cursor;
            this.ket = i5;
            this.bra = i5;
            if (find_among_b(a_37) != 0 && this.cursor <= this.limit_backward) {
                slice_from("αγαν");
            }
        }
        int i6 = this.limit - i4;
        this.cursor = i6;
        this.ket = i6;
        if (!eq_s_b("ανε")) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i7 = this.limit;
        int i8 = this.cursor;
        int i9 = i7 - i8;
        this.ket = i8;
        this.bra = i8;
        if (in_grouping_b(g_v2, 945, 969)) {
            slice_from("αν");
        } else {
            int i10 = this.limit - i9;
            this.cursor = i10;
            this.ket = i10;
        }
        this.bra = this.cursor;
        if (find_among_b(a_39) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("αν");
        return true;
    }

    private boolean r_step5c() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (find_among_b(a_40) != 0) {
            this.bra = this.cursor;
            slice_del();
            this.B_test1 = false;
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        this.ket = i5;
        if (!eq_s_b("ετε")) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i6 = this.limit;
        int i7 = this.cursor;
        int i8 = i6 - i7;
        this.ket = i7;
        this.bra = i7;
        if (in_grouping_b(g_v2, 945, 969)) {
            slice_from("ετ");
        } else {
            int i9 = this.limit - i8;
            this.cursor = i9;
            this.ket = i9;
            this.bra = i9;
            if (find_among_b(a_41) == 0) {
                int i10 = this.limit - i8;
                this.cursor = i10;
                this.ket = i10;
            } else {
                slice_from("ετ");
            }
        }
        this.bra = this.cursor;
        if (find_among_b(a_42) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ετ");
        return true;
    }

    private boolean r_step5d() {
        this.ket = this.cursor;
        if (find_among_b(a_43) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        if (eq_s_b("αρχ") && this.cursor <= this.limit_backward) {
            slice_from("οντ");
            return true;
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        this.ket = i5;
        this.bra = i5;
        if (!eq_s_b("κρε")) {
            return false;
        }
        slice_from("ωντ");
        return true;
    }

    private boolean r_step5e() {
        this.ket = this.cursor;
        if (find_among_b(a_44) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (!eq_s_b("ον") || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ομαστ");
        return true;
    }

    private boolean r_step5f() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (eq_s_b("ιεστε")) {
            this.bra = this.cursor;
            slice_del();
            this.B_test1 = false;
            int i5 = this.cursor;
            this.ket = i5;
            this.bra = i5;
            if (find_among_b(a_45) != 0 && this.cursor <= this.limit_backward) {
                slice_from("ιεστ");
            }
        }
        int i6 = this.limit - i4;
        this.cursor = i6;
        this.ket = i6;
        if (!eq_s_b("εστε")) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i7 = this.cursor;
        this.ket = i7;
        this.bra = i7;
        if (find_among_b(a_46) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ιεστ");
        return true;
    }

    private boolean r_step5g() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (find_among_b(a_47) != 0) {
            this.bra = this.cursor;
            slice_del();
            this.B_test1 = false;
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        this.ket = i5;
        if (find_among_b(a_50) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i6 = this.limit;
        int i7 = this.cursor;
        int i8 = i6 - i7;
        this.ket = i7;
        this.bra = i7;
        if (find_among_b(a_48) != 0) {
            slice_from("ηκ");
            return true;
        }
        int i9 = this.limit - i8;
        this.cursor = i9;
        this.ket = i9;
        this.bra = i9;
        if (find_among_b(a_49) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ηκ");
        return true;
    }

    private boolean r_step5h() {
        this.ket = this.cursor;
        if (find_among_b(a_53) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        if (find_among_b(a_51) != 0) {
            slice_from("ουσ");
            return true;
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        this.ket = i5;
        this.bra = i5;
        if (find_among_b(a_52) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ουσ");
        return true;
    }

    private boolean r_step5i() {
        this.ket = this.cursor;
        if (find_among_b(a_56) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        if (eq_s_b("κολλ")) {
            slice_from("αγ");
        } else {
            int i5 = this.limit;
            int i6 = i5 - i4;
            this.cursor = i6;
            int i7 = i5 - i6;
            this.ket = i6;
            this.bra = i6;
            int iFind_among_b = find_among_b(a_54);
            if (iFind_among_b == 0) {
                int i8 = this.limit - i7;
                this.cursor = i8;
                this.ket = i8;
                this.bra = i8;
                if (find_among_b(a_55) == 0 || this.cursor > this.limit_backward) {
                    return false;
                }
                slice_from("αγ");
            } else if (iFind_among_b == 1) {
                slice_from("αγ");
            }
        }
        return true;
    }

    private boolean r_step5j() {
        this.ket = this.cursor;
        if (find_among_b(a_57) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_58) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ησ");
        return true;
    }

    private boolean r_step5k() {
        this.ket = this.cursor;
        if (find_among_b(a_59) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_60) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ηστ");
        return true;
    }

    private boolean r_step5l() {
        this.ket = this.cursor;
        if (find_among_b(a_61) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_62) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ουν");
        return true;
    }

    private boolean r_step5m() {
        this.ket = this.cursor;
        if (find_among_b(a_63) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_64) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ουμ");
        return true;
    }

    private boolean r_step6() {
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        if (find_among_b(a_65) != 0) {
            this.bra = this.cursor;
            slice_from("μα");
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        if (!this.B_test1) {
            return false;
        }
        this.ket = i5;
        if (find_among_b(a_66) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        return true;
    }

    private boolean r_step7() {
        this.ket = this.cursor;
        if (find_among_b(a_67) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        return true;
    }

    private boolean r_steps1() {
        this.ket = this.cursor;
        if (find_among_b(a_3) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        int iFind_among_b = find_among_b(a_2);
        if (iFind_among_b == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_from("ι");
        } else if (iFind_among_b == 2) {
            slice_from("ιζ");
        }
        return true;
    }

    private boolean r_steps10() {
        this.ket = this.cursor;
        if (find_among_b(a_23) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_22) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ισκ");
        return true;
    }

    private boolean r_steps2() {
        this.ket = this.cursor;
        if (find_among_b(a_5) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_4) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ων");
        return true;
    }

    private boolean r_steps3() {
        this.ket = this.cursor;
        if (find_among_b(a_7) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit - this.cursor;
        if (eq_s_b("ισα") && this.cursor <= this.limit_backward) {
            slice_from("ισ");
        } else {
            int i2 = this.limit - i;
            this.cursor = i2;
            this.ket = i2;
            this.bra = i2;
            int iFind_among_b = find_among_b(a_6);
            if (iFind_among_b == 0 || this.cursor > this.limit_backward) {
                return false;
            }
            if (iFind_among_b == 1) {
                slice_from("ι");
            } else if (iFind_among_b == 2) {
                slice_from("ισ");
            }
        }
        return true;
    }

    private boolean r_steps4() {
        this.ket = this.cursor;
        if (find_among_b(a_9) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_8) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("ι");
        return true;
    }

    private boolean r_steps5() {
        this.ket = this.cursor;
        if (find_among_b(a_11) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        int iFind_among_b = find_among_b(a_10);
        if (iFind_among_b == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        if (iFind_among_b == 1) {
            slice_from("ι");
        } else if (iFind_among_b == 2) {
            slice_from("ιστ");
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean r_steps6() {
        this.ket = this.cursor;
        if (find_among_b(a_14) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        int iFind_among_b = find_among_b(a_12);
        if (iFind_among_b == 0 || this.cursor > this.limit_backward) {
            int i5 = this.limit - i4;
            this.cursor = i5;
            this.ket = i5;
            int iFind_among_b2 = find_among_b(a_13);
            if (iFind_among_b2 != 0) {
                this.bra = this.cursor;
                switch (iFind_among_b2) {
                    case 1:
                        slice_from("αγνωστ");
                        break;
                    case 2:
                        slice_from("ατομ");
                        break;
                    case 3:
                        slice_from("γνωστ");
                        break;
                    case 4:
                        slice_from("εθν");
                        break;
                    case 5:
                        slice_from("εκλεκτ");
                        break;
                    case 6:
                        slice_from("σκεπτ");
                        break;
                    case 7:
                        slice_from("τοπ");
                        break;
                    case 8:
                        slice_from("αλεξανδρ");
                        break;
                    case 9:
                        slice_from("βυζαντ");
                        break;
                    case 10:
                        slice_from("θεατρ");
                        break;
                }
            } else {
                return false;
            }
        } else if (iFind_among_b == 1) {
            slice_from("ισμ");
        } else if (iFind_among_b == 2) {
            slice_from("ι");
        }
        return true;
    }

    private boolean r_steps7() {
        this.ket = this.cursor;
        if (find_among_b(a_16) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.cursor;
        this.ket = i;
        this.bra = i;
        if (find_among_b(a_15) == 0 || this.cursor > this.limit_backward) {
            return false;
        }
        slice_from("αρακ");
        return true;
    }

    private boolean r_steps8() {
        this.ket = this.cursor;
        if (find_among_b(a_18) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        int iFind_among_b = find_among_b(a_17);
        if (iFind_among_b == 0 || this.cursor > this.limit_backward) {
            int i5 = this.limit - i4;
            this.cursor = i5;
            this.ket = i5;
            this.bra = i5;
            if (!eq_s_b("κορ")) {
                return false;
            }
            slice_from("ιτσ");
        } else if (iFind_among_b == 1) {
            slice_from("ακ");
        } else if (iFind_among_b == 2) {
            slice_from("ιτσ");
        }
        return true;
    }

    private boolean r_steps9() {
        this.ket = this.cursor;
        if (find_among_b(a_21) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_del();
        this.B_test1 = false;
        int i = this.limit;
        int i2 = this.cursor;
        int i4 = i - i2;
        this.ket = i2;
        this.bra = i2;
        if (find_among_b(a_19) != 0 && this.cursor <= this.limit_backward) {
            slice_from("ιδ");
            return true;
        }
        int i5 = this.limit - i4;
        this.cursor = i5;
        this.ket = i5;
        this.bra = i5;
        if (find_among_b(a_20) == 0) {
            return false;
        }
        slice_from("ιδ");
        return true;
    }

    private boolean r_tolower() {
        while (true) {
            int i = this.limit;
            int i2 = this.cursor;
            int i4 = i - i2;
            this.ket = i2;
            int iFind_among_b = find_among_b(a_0);
            int i5 = this.cursor;
            this.bra = i5;
            switch (iFind_among_b) {
                case 1:
                    slice_from("α");
                    break;
                case 2:
                    slice_from("β");
                    break;
                case 3:
                    slice_from("γ");
                    break;
                case 4:
                    slice_from("δ");
                    break;
                case 5:
                    slice_from("ε");
                    break;
                case 6:
                    slice_from("ζ");
                    break;
                case 7:
                    slice_from("η");
                    break;
                case 8:
                    slice_from("θ");
                    break;
                case 9:
                    slice_from("ι");
                    break;
                case 10:
                    slice_from("κ");
                    break;
                case 11:
                    slice_from("λ");
                    break;
                case 12:
                    slice_from("μ");
                    break;
                case 13:
                    slice_from("ν");
                    break;
                case 14:
                    slice_from("ξ");
                    break;
                case 15:
                    slice_from("ο");
                    break;
                case 16:
                    slice_from("π");
                    break;
                case 17:
                    slice_from("ρ");
                    break;
                case 18:
                    slice_from("σ");
                    break;
                case 19:
                    slice_from("τ");
                    break;
                case 20:
                    slice_from("υ");
                    break;
                case 21:
                    slice_from("φ");
                    break;
                case 22:
                    slice_from("χ");
                    break;
                case 23:
                    slice_from("ψ");
                    break;
                case 24:
                    slice_from("ω");
                    break;
                case 25:
                    if (i5 <= this.limit_backward) {
                        this.cursor = this.limit - i4;
                        return true;
                    }
                    this.cursor = i5 - 1;
                    break;
            }
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof greekStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return -497813465;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    public boolean stem() {
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        r_tolower();
        this.cursor = this.limit;
        if (!r_has_min_length()) {
            return false;
        }
        this.B_test1 = true;
        int i = this.limit - this.cursor;
        r_step1();
        int i2 = this.limit;
        int i4 = i2 - i;
        this.cursor = i4;
        int i5 = i2 - i4;
        r_steps1();
        int i6 = this.limit;
        int i7 = i6 - i5;
        this.cursor = i7;
        int i8 = i6 - i7;
        r_steps2();
        int i9 = this.limit;
        int i10 = i9 - i8;
        this.cursor = i10;
        int i11 = i9 - i10;
        r_steps3();
        int i12 = this.limit;
        int i13 = i12 - i11;
        this.cursor = i13;
        int i14 = i12 - i13;
        r_steps4();
        int i15 = this.limit;
        int i16 = i15 - i14;
        this.cursor = i16;
        int i17 = i15 - i16;
        r_steps5();
        int i18 = this.limit;
        int i19 = i18 - i17;
        this.cursor = i19;
        int i20 = i18 - i19;
        r_steps6();
        int i21 = this.limit;
        int i22 = i21 - i20;
        this.cursor = i22;
        int i23 = i21 - i22;
        r_steps7();
        int i24 = this.limit;
        int i25 = i24 - i23;
        this.cursor = i25;
        int i26 = i24 - i25;
        r_steps8();
        int i27 = this.limit;
        int i28 = i27 - i26;
        this.cursor = i28;
        int i29 = i27 - i28;
        r_steps9();
        int i30 = this.limit;
        int i31 = i30 - i29;
        this.cursor = i31;
        int i32 = i30 - i31;
        r_steps10();
        int i33 = this.limit;
        int i34 = i33 - i32;
        this.cursor = i34;
        int i35 = i33 - i34;
        r_step2a();
        int i36 = this.limit;
        int i37 = i36 - i35;
        this.cursor = i37;
        int i38 = i36 - i37;
        r_step2b();
        int i39 = this.limit;
        int i40 = i39 - i38;
        this.cursor = i40;
        int i41 = i39 - i40;
        r_step2c();
        int i42 = this.limit;
        int i43 = i42 - i41;
        this.cursor = i43;
        int i44 = i42 - i43;
        r_step2d();
        int i45 = this.limit;
        int i46 = i45 - i44;
        this.cursor = i46;
        int i47 = i45 - i46;
        r_step3();
        int i48 = this.limit;
        int i49 = i48 - i47;
        this.cursor = i49;
        int i50 = i48 - i49;
        r_step4();
        int i51 = this.limit;
        int i52 = i51 - i50;
        this.cursor = i52;
        int i53 = i51 - i52;
        r_step5a();
        int i54 = this.limit;
        int i55 = i54 - i53;
        this.cursor = i55;
        int i56 = i54 - i55;
        r_step5b();
        int i57 = this.limit;
        int i58 = i57 - i56;
        this.cursor = i58;
        int i59 = i57 - i58;
        r_step5c();
        int i60 = this.limit;
        int i61 = i60 - i59;
        this.cursor = i61;
        int i62 = i60 - i61;
        r_step5d();
        int i63 = this.limit;
        int i64 = i63 - i62;
        this.cursor = i64;
        int i65 = i63 - i64;
        r_step5e();
        int i66 = this.limit;
        int i67 = i66 - i65;
        this.cursor = i67;
        int i68 = i66 - i67;
        r_step5f();
        int i69 = this.limit;
        int i70 = i69 - i68;
        this.cursor = i70;
        int i71 = i69 - i70;
        r_step5g();
        int i72 = this.limit;
        int i73 = i72 - i71;
        this.cursor = i73;
        int i74 = i72 - i73;
        r_step5h();
        int i75 = this.limit;
        int i76 = i75 - i74;
        this.cursor = i76;
        int i77 = i75 - i76;
        r_step5j();
        int i78 = this.limit;
        int i79 = i78 - i77;
        this.cursor = i79;
        int i80 = i78 - i79;
        r_step5i();
        int i81 = this.limit;
        int i82 = i81 - i80;
        this.cursor = i82;
        int i83 = i81 - i82;
        r_step5k();
        int i84 = this.limit;
        int i85 = i84 - i83;
        this.cursor = i85;
        int i86 = i84 - i85;
        r_step5l();
        int i87 = this.limit;
        int i88 = i87 - i86;
        this.cursor = i88;
        int i89 = i87 - i88;
        r_step5m();
        int i90 = this.limit;
        int i91 = i90 - i89;
        this.cursor = i91;
        r_step6();
        this.cursor = this.limit - (i90 - i91);
        r_step7();
        this.cursor = this.limit_backward;
        return true;
    }
}
