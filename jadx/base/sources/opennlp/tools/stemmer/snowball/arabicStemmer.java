package opennlp.tools.stemmer.snowball;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class arabicStemmer extends AbstractSnowballStemmer {
    private boolean B_is_defined;
    private boolean B_is_noun;
    private boolean B_is_verb;
    private static final Among[] a_0 = {new Among("ـ", -1, 1), new Among("ً", -1, 1), new Among("ٌ", -1, 1), new Among("ٍ", -1, 1), new Among("َ", -1, 1), new Among("ُ", -1, 1), new Among("ِ", -1, 1), new Among("ّ", -1, 1), new Among("ْ", -1, 1), new Among("٠", -1, 2), new Among("١", -1, 3), new Among("٢", -1, 4), new Among("٣", -1, 5), new Among("٤", -1, 6), new Among("٥", -1, 7), new Among("٦", -1, 8), new Among("٧", -1, 9), new Among("٨", -1, 10), new Among("٩", -1, 11), new Among("ﺀ", -1, 12), new Among("ﺁ", -1, 16), new Among("ﺂ", -1, 16), new Among("ﺃ", -1, 13), new Among("ﺄ", -1, 13), new Among("ﺅ", -1, 17), new Among("ﺆ", -1, 17), new Among("ﺇ", -1, 14), new Among("ﺈ", -1, 14), new Among("ﺉ", -1, 15), new Among("ﺊ", -1, 15), new Among("ﺋ", -1, 15), new Among("ﺌ", -1, 15), new Among("ﺍ", -1, 18), new Among("ﺎ", -1, 18), new Among("ﺏ", -1, 19), new Among("ﺐ", -1, 19), new Among("ﺑ", -1, 19), new Among("ﺒ", -1, 19), new Among("ﺓ", -1, 20), new Among("ﺔ", -1, 20), new Among("ﺕ", -1, 21), new Among("ﺖ", -1, 21), new Among("ﺗ", -1, 21), new Among("ﺘ", -1, 21), new Among("ﺙ", -1, 22), new Among("ﺚ", -1, 22), new Among("ﺛ", -1, 22), new Among("ﺜ", -1, 22), new Among("ﺝ", -1, 23), new Among("ﺞ", -1, 23), new Among("ﺟ", -1, 23), new Among("ﺠ", -1, 23), new Among("ﺡ", -1, 24), new Among("ﺢ", -1, 24), new Among("ﺣ", -1, 24), new Among("ﺤ", -1, 24), new Among("ﺥ", -1, 25), new Among("ﺦ", -1, 25), new Among("ﺧ", -1, 25), new Among("ﺨ", -1, 25), new Among("ﺩ", -1, 26), new Among("ﺪ", -1, 26), new Among("ﺫ", -1, 27), new Among("ﺬ", -1, 27), new Among("ﺭ", -1, 28), new Among("ﺮ", -1, 28), new Among("ﺯ", -1, 29), new Among("ﺰ", -1, 29), new Among("ﺱ", -1, 30), new Among("ﺲ", -1, 30), new Among("ﺳ", -1, 30), new Among("ﺴ", -1, 30), new Among("ﺵ", -1, 31), new Among("ﺶ", -1, 31), new Among("ﺷ", -1, 31), new Among("ﺸ", -1, 31), new Among("ﺹ", -1, 32), new Among("ﺺ", -1, 32), new Among("ﺻ", -1, 32), new Among("ﺼ", -1, 32), new Among("ﺽ", -1, 33), new Among("ﺾ", -1, 33), new Among("ﺿ", -1, 33), new Among("ﻀ", -1, 33), new Among("ﻁ", -1, 34), new Among("ﻂ", -1, 34), new Among("ﻃ", -1, 34), new Among("ﻄ", -1, 34), new Among("ﻅ", -1, 35), new Among("ﻆ", -1, 35), new Among("ﻇ", -1, 35), new Among("ﻈ", -1, 35), new Among("ﻉ", -1, 36), new Among("ﻊ", -1, 36), new Among("ﻋ", -1, 36), new Among("ﻌ", -1, 36), new Among("ﻍ", -1, 37), new Among("ﻎ", -1, 37), new Among("ﻏ", -1, 37), new Among("ﻐ", -1, 37), new Among("ﻑ", -1, 38), new Among("ﻒ", -1, 38), new Among("ﻓ", -1, 38), new Among("ﻔ", -1, 38), new Among("ﻕ", -1, 39), new Among("ﻖ", -1, 39), new Among("ﻗ", -1, 39), new Among("ﻘ", -1, 39), new Among("ﻙ", -1, 40), new Among("ﻚ", -1, 40), new Among("ﻛ", -1, 40), new Among("ﻜ", -1, 40), new Among("ﻝ", -1, 41), new Among("ﻞ", -1, 41), new Among("ﻟ", -1, 41), new Among("ﻠ", -1, 41), new Among("ﻡ", -1, 42), new Among("ﻢ", -1, 42), new Among("ﻣ", -1, 42), new Among("ﻤ", -1, 42), new Among("ﻥ", -1, 43), new Among("ﻦ", -1, 43), new Among("ﻧ", -1, 43), new Among("ﻨ", -1, 43), new Among("ﻩ", -1, 44), new Among("ﻪ", -1, 44), new Among("ﻫ", -1, 44), new Among("ﻬ", -1, 44), new Among("ﻭ", -1, 45), new Among("ﻮ", -1, 45), new Among("ﻯ", -1, 46), new Among("ﻰ", -1, 46), new Among("ﻱ", -1, 47), new Among("ﻲ", -1, 47), new Among("ﻳ", -1, 47), new Among("ﻴ", -1, 47), new Among("ﻵ", -1, 51), new Among("ﻶ", -1, 51), new Among("ﻷ", -1, 49), new Among("ﻸ", -1, 49), new Among("ﻹ", -1, 50), new Among("ﻺ", -1, 50), new Among("ﻻ", -1, 48), new Among("ﻼ", -1, 48)};
    private static final Among[] a_1 = {new Among("آ", -1, 1), new Among("أ", -1, 1), new Among("ؤ", -1, 1), new Among("إ", -1, 1), new Among("ئ", -1, 1)};
    private static final Among[] a_2 = {new Among("آ", -1, 1), new Among("أ", -1, 1), new Among("ؤ", -1, 2), new Among("إ", -1, 1), new Among("ئ", -1, 3)};
    private static final Among[] a_3 = {new Among("ال", -1, 2), new Among("بال", -1, 1), new Among("كال", -1, 1), new Among("لل", -1, 2)};
    private static final Among[] a_4 = {new Among("أآ", -1, 2), new Among("أأ", -1, 1), new Among("أؤ", -1, 1), new Among("أإ", -1, 4), new Among("أا", -1, 3)};
    private static final Among[] a_5 = {new Among("ف", -1, 1), new Among("و", -1, 1)};
    private static final Among[] a_6 = {new Among("ال", -1, 2), new Among("بال", -1, 1), new Among("كال", -1, 1), new Among("لل", -1, 2)};
    private static final Among[] a_7 = {new Among("ب", -1, 1), new Among("با", 0, -1), new Among("بب", 0, 2), new Among("كك", -1, 3)};
    private static final Among[] a_8 = {new Among("سأ", -1, 4), new Among("ست", -1, 2), new Among("سن", -1, 3), new Among("سي", -1, 1)};
    private static final Among[] a_9 = {new Among("تست", -1, 1), new Among("نست", -1, 1), new Among("يست", -1, 1)};
    private static final Among[] a_10 = {new Among("كما", -1, 3), new Among("هما", -1, 3), new Among("نا", -1, 2), new Among("ها", -1, 2), new Among("ك", -1, 1), new Among("كم", -1, 2), new Among("هم", -1, 2), new Among("هن", -1, 2), new Among("ه", -1, 1), new Among("ي", -1, 1)};
    private static final Among[] a_11 = {new Among("ن", -1, 1)};
    private static final Among[] a_12 = {new Among("ا", -1, 1), new Among("و", -1, 1), new Among("ي", -1, 1)};
    private static final Among[] a_13 = {new Among("ات", -1, 1)};
    private static final Among[] a_14 = {new Among("ت", -1, 1)};
    private static final Among[] a_15 = {new Among("ة", -1, 1)};
    private static final Among[] a_16 = {new Among("ي", -1, 1)};
    private static final Among[] a_17 = {new Among("كما", -1, 3), new Among("هما", -1, 3), new Among("نا", -1, 2), new Among("ها", -1, 2), new Among("ك", -1, 1), new Among("كم", -1, 2), new Among("هم", -1, 2), new Among("كن", -1, 2), new Among("هن", -1, 2), new Among("ه", -1, 1), new Among("كمو", -1, 3), new Among("ني", -1, 2)};
    private static final Among[] a_18 = {new Among("ا", -1, 1), new Among("تا", 0, 2), new Among("تما", 0, 4), new Among("نا", 0, 2), new Among("ت", -1, 1), new Among("ن", -1, 1), new Among("ان", 5, 3), new Among("تن", 5, 2), new Among("ون", 5, 3), new Among("ين", 5, 3), new Among("ي", -1, 1)};
    private static final Among[] a_19 = {new Among("وا", -1, 1), new Among("تم", -1, 1)};
    private static final Among[] a_20 = {new Among("و", -1, 1), new Among("تمو", 0, 2)};
    private static final Among[] a_21 = {new Among("ى", -1, 1)};

    private boolean r_Checks1() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_3);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (iFind_among != 1) {
            if (iFind_among == 2) {
                if (this.current.length() <= 3) {
                    return false;
                }
                this.B_is_noun = true;
                this.B_is_verb = false;
                this.B_is_defined = true;
            }
        } else {
            if (this.current.length() <= 4) {
                return false;
            }
            this.B_is_noun = true;
            this.B_is_verb = false;
            this.B_is_defined = true;
        }
        return true;
    }

    private boolean r_Normalize_post() {
        int i = this.cursor;
        this.limit_backward = i;
        int i2 = this.limit;
        this.cursor = i2;
        this.ket = i2;
        if (find_among_b(a_1) != 0) {
            this.bra = this.cursor;
            slice_from("ء");
            this.cursor = this.limit_backward;
        }
        this.cursor = i;
        while (true) {
            int i4 = this.cursor;
            this.bra = i4;
            int iFind_among = find_among(a_2);
            if (iFind_among == 0) {
                this.cursor = i4;
                if (i4 >= this.limit) {
                    this.cursor = i;
                    return true;
                }
                this.cursor = i4 + 1;
            } else {
                this.ket = this.cursor;
                if (iFind_among == 1) {
                    slice_from("ا");
                } else if (iFind_among == 2) {
                    slice_from("و");
                } else if (iFind_among == 3) {
                    slice_from("ي");
                }
            }
        }
    }

    private boolean r_Normalize_pre() {
        int i = this.cursor;
        while (true) {
            int i2 = this.cursor;
            this.bra = i2;
            int iFind_among = find_among(a_0);
            if (iFind_among != 0) {
                this.ket = this.cursor;
                switch (iFind_among) {
                    case 1:
                        slice_del();
                        break;
                    case 2:
                        slice_from("0");
                        break;
                    case 3:
                        slice_from("1");
                        break;
                    case 4:
                        slice_from("2");
                        break;
                    case 5:
                        slice_from("3");
                        break;
                    case 6:
                        slice_from("4");
                        break;
                    case 7:
                        slice_from("5");
                        break;
                    case 8:
                        slice_from("6");
                        break;
                    case 9:
                        slice_from("7");
                        break;
                    case 10:
                        slice_from("8");
                        break;
                    case 11:
                        slice_from("9");
                        break;
                    case 12:
                        slice_from("ء");
                        break;
                    case 13:
                        slice_from("أ");
                        break;
                    case 14:
                        slice_from("إ");
                        break;
                    case 15:
                        slice_from("ئ");
                        break;
                    case 16:
                        slice_from("آ");
                        break;
                    case 17:
                        slice_from("ؤ");
                        break;
                    case 18:
                        slice_from("ا");
                        break;
                    case 19:
                        slice_from("ب");
                        break;
                    case 20:
                        slice_from("ة");
                        break;
                    case 21:
                        slice_from("ت");
                        break;
                    case 22:
                        slice_from("ث");
                        break;
                    case 23:
                        slice_from("ج");
                        break;
                    case 24:
                        slice_from("ح");
                        break;
                    case 25:
                        slice_from("خ");
                        break;
                    case 26:
                        slice_from("د");
                        break;
                    case 27:
                        slice_from("ذ");
                        break;
                    case 28:
                        slice_from("ر");
                        break;
                    case 29:
                        slice_from("ز");
                        break;
                    case 30:
                        slice_from("س");
                        break;
                    case 31:
                        slice_from("ش");
                        break;
                    case 32:
                        slice_from("ص");
                        break;
                    case 33:
                        slice_from("ض");
                        break;
                    case 34:
                        slice_from("ط");
                        break;
                    case 35:
                        slice_from("ظ");
                        break;
                    case 36:
                        slice_from("ع");
                        break;
                    case 37:
                        slice_from("غ");
                        break;
                    case 38:
                        slice_from("ف");
                        break;
                    case 39:
                        slice_from("ق");
                        break;
                    case 40:
                        slice_from("ك");
                        break;
                    case 41:
                        slice_from("ل");
                        break;
                    case 42:
                        slice_from("م");
                        break;
                    case 43:
                        slice_from("ن");
                        break;
                    case 44:
                        slice_from("ه");
                        break;
                    case 45:
                        slice_from("و");
                        break;
                    case 46:
                        slice_from("ى");
                        break;
                    case 47:
                        slice_from("ي");
                        break;
                    case 48:
                        slice_from("لا");
                        break;
                    case 49:
                        slice_from("لأ");
                        break;
                    case 50:
                        slice_from("لإ");
                        break;
                    case 51:
                        slice_from("لآ");
                        break;
                }
            } else {
                this.cursor = i2;
                if (i2 >= this.limit) {
                    this.cursor = i;
                    return true;
                }
                this.cursor = i2 + 1;
            }
        }
    }

    private boolean r_Prefix_Step1() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_4);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (iFind_among != 1) {
            if (iFind_among != 2) {
                if (iFind_among != 3) {
                    if (iFind_among == 4) {
                        if (this.current.length() <= 3) {
                            return false;
                        }
                        slice_from("إ");
                    }
                } else {
                    if (this.current.length() <= 3) {
                        return false;
                    }
                    slice_from("ا");
                }
            } else {
                if (this.current.length() <= 3) {
                    return false;
                }
                slice_from("آ");
            }
        } else {
            if (this.current.length() <= 3) {
                return false;
            }
            slice_from("أ");
        }
        return true;
    }

    private boolean r_Prefix_Step2() {
        this.bra = this.cursor;
        if (find_among(a_5) == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (this.current.length() <= 3) {
            return false;
        }
        int i = this.cursor;
        if (eq_s("ا")) {
            return false;
        }
        this.cursor = i;
        slice_del();
        return true;
    }

    private boolean r_Prefix_Step3_Verb() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_8);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (iFind_among != 1) {
            if (iFind_among != 2) {
                if (iFind_among != 3) {
                    if (iFind_among == 4) {
                        if (this.current.length() <= 4) {
                            return false;
                        }
                        slice_from("أ");
                    }
                } else {
                    if (this.current.length() <= 4) {
                        return false;
                    }
                    slice_from("ن");
                }
            } else {
                if (this.current.length() <= 4) {
                    return false;
                }
                slice_from("ت");
            }
        } else {
            if (this.current.length() <= 4) {
                return false;
            }
            slice_from("ي");
        }
        return true;
    }

    private boolean r_Prefix_Step3a_Noun() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_6);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (iFind_among != 1) {
            if (iFind_among == 2) {
                if (this.current.length() <= 4) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (this.current.length() <= 5) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Prefix_Step3b_Noun() {
        this.bra = this.cursor;
        int iFind_among = find_among(a_7);
        if (iFind_among == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (iFind_among != 1) {
            if (iFind_among != 2) {
                if (iFind_among == 3) {
                    if (this.current.length() <= 3) {
                        return false;
                    }
                    slice_from("ك");
                }
            } else {
                if (this.current.length() <= 3) {
                    return false;
                }
                slice_from("ب");
            }
        } else {
            if (this.current.length() <= 3) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Prefix_Step4_Verb() {
        this.bra = this.cursor;
        if (find_among(a_9) == 0) {
            return false;
        }
        this.ket = this.cursor;
        if (this.current.length() <= 4) {
            return false;
        }
        this.B_is_verb = true;
        this.B_is_noun = false;
        slice_from("است");
        return true;
    }

    private boolean r_Suffix_All_alef_maqsura() {
        this.ket = this.cursor;
        if (find_among_b(a_21) == 0) {
            return false;
        }
        this.bra = this.cursor;
        slice_from("ي");
        return true;
    }

    private boolean r_Suffix_Noun_Step1a() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_10);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b != 2) {
                if (iFind_among_b == 3) {
                    if (this.current.length() < 6) {
                        return false;
                    }
                    slice_del();
                }
            } else {
                if (this.current.length() < 5) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (this.current.length() < 4) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Suffix_Noun_Step1b() {
        this.ket = this.cursor;
        if (find_among_b(a_11) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() <= 5) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Noun_Step2a() {
        this.ket = this.cursor;
        if (find_among_b(a_12) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() <= 4) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Noun_Step2b() {
        this.ket = this.cursor;
        if (find_among_b(a_13) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() < 5) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Noun_Step2c1() {
        this.ket = this.cursor;
        if (find_among_b(a_14) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() < 4) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Noun_Step2c2() {
        this.ket = this.cursor;
        if (find_among_b(a_15) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() < 4) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Noun_Step3() {
        this.ket = this.cursor;
        if (find_among_b(a_16) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() < 3) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Verb_Step1() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_17);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b != 2) {
                if (iFind_among_b == 3) {
                    if (this.current.length() < 6) {
                        return false;
                    }
                    slice_del();
                }
            } else {
                if (this.current.length() < 5) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (this.current.length() < 4) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Suffix_Verb_Step2a() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_18);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b != 2) {
                if (iFind_among_b != 3) {
                    if (iFind_among_b == 4) {
                        if (this.current.length() < 6) {
                            return false;
                        }
                        slice_del();
                    }
                } else {
                    if (this.current.length() <= 5) {
                        return false;
                    }
                    slice_del();
                }
            } else {
                if (this.current.length() < 5) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (this.current.length() < 4) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    private boolean r_Suffix_Verb_Step2b() {
        this.ket = this.cursor;
        if (find_among_b(a_19) == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (this.current.length() < 5) {
            return false;
        }
        slice_del();
        return true;
    }

    private boolean r_Suffix_Verb_Step2c() {
        this.ket = this.cursor;
        int iFind_among_b = find_among_b(a_20);
        if (iFind_among_b == 0) {
            return false;
        }
        this.bra = this.cursor;
        if (iFind_among_b != 1) {
            if (iFind_among_b == 2) {
                if (this.current.length() < 6) {
                    return false;
                }
                slice_del();
            }
        } else {
            if (this.current.length() < 4) {
                return false;
            }
            slice_del();
        }
        return true;
    }

    public boolean equals(Object obj) {
        return obj instanceof arabicStemmer;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ String getCurrent() {
        return super.getCurrent();
    }

    public int hashCode() {
        return 1034823183;
    }

    @Override // opennlp.tools.stemmer.snowball.SnowballProgram
    public /* bridge */ /* synthetic */ void setCurrent(String str) {
        super.setCurrent(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ff  */
    @Override // opennlp.tools.stemmer.snowball.AbstractSnowballStemmer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean stem() {
        int i;
        this.B_is_noun = true;
        this.B_is_verb = true;
        this.B_is_defined = false;
        int i2 = this.cursor;
        r_Checks1();
        this.cursor = i2;
        r_Normalize_pre();
        this.limit_backward = this.cursor;
        this.cursor = this.limit;
        if (this.B_is_verb) {
            int i4 = 1;
            while (true) {
                i = this.limit - this.cursor;
                if (!r_Suffix_Verb_Step1()) {
                    break;
                }
                i4--;
            }
            int i5 = this.limit;
            int i6 = i5 - i;
            this.cursor = i6;
            if (i4 > 0) {
                this.cursor = this.limit;
                if (!r_Suffix_Verb_Step2b()) {
                    this.cursor = this.limit;
                    if (!r_Suffix_Verb_Step2a()) {
                    }
                }
            } else {
                int i7 = i5 - i6;
                if (!r_Suffix_Verb_Step2a()) {
                    this.cursor = this.limit - i7;
                    if (!r_Suffix_Verb_Step2c()) {
                        int i8 = this.limit - i7;
                        this.cursor = i8;
                        if (i8 > this.limit_backward) {
                            this.cursor = i8 - 1;
                        }
                    }
                }
            }
        } else {
            this.cursor = this.limit;
            if (this.B_is_noun) {
                if (!r_Suffix_Noun_Step2c2()) {
                    this.cursor = this.limit;
                    if (this.B_is_defined || !r_Suffix_Noun_Step1a()) {
                        this.cursor = this.limit;
                        if (r_Suffix_Noun_Step1b()) {
                            int i9 = this.limit - this.cursor;
                            if (!r_Suffix_Noun_Step2a()) {
                                this.cursor = this.limit - i9;
                                if (!r_Suffix_Noun_Step2b()) {
                                    this.cursor = this.limit - i9;
                                    if (!r_Suffix_Noun_Step2c1()) {
                                    }
                                }
                            }
                        } else {
                            this.cursor = this.limit;
                            if (this.B_is_defined || !r_Suffix_Noun_Step2a()) {
                                this.cursor = this.limit;
                                if (!r_Suffix_Noun_Step2b()) {
                                    this.cursor = this.limit;
                                }
                            }
                        }
                    } else {
                        int i10 = this.limit - this.cursor;
                        if (!r_Suffix_Noun_Step2a()) {
                            this.cursor = this.limit - i10;
                            if (!r_Suffix_Noun_Step2b()) {
                                this.cursor = this.limit - i10;
                                if (!r_Suffix_Noun_Step2c1()) {
                                    int i11 = this.limit - i10;
                                    this.cursor = i11;
                                    if (i11 > this.limit_backward) {
                                        this.cursor = i11 - 1;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!r_Suffix_Noun_Step3()) {
                    this.cursor = this.limit;
                    r_Suffix_All_alef_maqsura();
                }
            }
        }
        int i12 = this.limit_backward;
        this.cursor = i12;
        if (!r_Prefix_Step1()) {
            this.cursor = i12;
        }
        int i13 = this.cursor;
        if (!r_Prefix_Step2()) {
            this.cursor = i13;
        }
        int i14 = this.cursor;
        if (!r_Prefix_Step3a_Noun()) {
            this.cursor = i14;
            if (!this.B_is_noun || !r_Prefix_Step3b_Noun()) {
                this.cursor = i14;
                if (this.B_is_verb) {
                    if (!r_Prefix_Step3_Verb()) {
                        this.cursor = i14;
                    }
                    r_Prefix_Step4_Verb();
                }
            }
        }
        this.cursor = i12;
        r_Normalize_post();
        return true;
    }
}
