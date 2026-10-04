package com.samsung.android.support.senl.p148nt.composer.main.base.model.link;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DateFormats {
    static String DATE_FORMAT = "yyyy/MM/dd";
    static final String DATE_SEPERATOR = "(\\/|\\-|\\.)";
    static String DAY_FORMAT = "EEE";
    static final String ENGLISH_DATE_KEYWORD_FORMAT = "([tT](onight|oday|omorrow))";
    static final String ENGLISH_DAY_KEYWORD_FORMAT = "(([sS](unday|aterday))|([mM]onday)|([tT](uesday|hursday))|([wW]ednesday)|([fF]riday))";
    static final String ENGLISH_DAY_MONTH_FORMAT = "((0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|3(0(th)?|1(st)?)) ((J(anuary|uly)|Ma(rch|y)|August|(Octo|Decem)ber)|((J(an|ul)|Ma(r|y)|Aug|Oct|Dec)[\\.\\,]?))|(0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|30(th)?) ((April|June|(Sept|Nov)ember)|((Apr|Jun|Sep|Nov)[\\.\\,]?))|(0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|2([1](st)?|[2](nd)?|[3](rd)?|[4-80](th)?)) (February|Feb[\\.\\,]?)|29(th)? (February|Feb[\\.\\,]?) ((0[48]|[2468][048]|[13579][26])00|[0-9]{2}(0[48]|[2468][048]|[13579][26])))";
    static final String ENGLISH_MONTH_DAY_FORMAT = "(((J(anuary|uly)|Ma(rch|y)|August|(Octo|Decem)ber)|((J(an|ul)|Ma(r|y)|Aug|Oct|Dec)[\\.\\,]?)) (0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|3(0(th)?|1(st)?))|((April|June|(Sept|Nov)ember)|((Apr|Jun|Sep|Nov)[\\.\\,]?)) (0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|[2]([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|30(th)?)|(February|Feb[\\.\\,]?) (0[1-9]|([1](st)?|[2](nd)?|[3](rd)?|[4-90](th)?)|[1][0-9](th)?|2([1](st)?|[2](nd)?|[3](rd)?|[4-80](th)?))|(February|Feb[\\.\\,]?)29(th)? ((0[48]|[2468][048]|[13579][26])00|[0-9]{2}(0[48]|[2468][048]|[13579][26])))";
    static final String ENGLISH_TIME_KEYWORD_FORMAT = "((([mM]orning) ([0][6-9]|[1][0-1]|[6-9])(\\:)([0-5][0-9]|[1-9]))|(([aA]fternoon) ([0][1-5]|[1][2]|[1-5])(\\:)([0-5][0-9]|[1-9]))|(([eE]vening) ([0][6-9]|[1][0]|[6-9])(\\:)([0-5][0-9]|[1-9]))|(([nN]ight) ([0][8-9]|[1][0-2]|[8-9])(\\:)([0-5][0-9]|[1-9])))";
    static final String KOREAN_DATE_FORMAT = "(18|19|20|21)\\d{2}년 ([1][0-2]|[1-9]|[0][1-9])월 ([1-2][0-9]|[3][0-1]|[1-9]|[0][1-9])일";
    static String KOREAN_DATE_KEYWORD_FORMAT = null;
    static String KOREAN_DAY_KEYWORD_FORMAT = null;
    static final String KOREAN_TIME_FORMAT = "((([0-1][0-9]|[1-9]|([2][0-4]))시)[ ]?(([0-5][0-9]|[1-9])분)?)";
    static String KOREAN_TIME_KEYWORD_FORMAT = null;
    static final String SEPERATOR_FORMAT = "[ \\,][ ]?";
    static final String STANDARD_DAY_FORMAT = "([1-2][0-9]|[3][0-1]|[1-9]|[0][1-9])";
    static final String STANDARD_MONTH_FORMAT = "([1][0-2]|[1-9]|[0][1-9])";
    static final String STANDARD_TIME_FORMAT = "(((([1][3-9])|([2][0-4]))[\\:]([0-5][0-9]|[1-9]))|(([0-1][0-9]|[1-9])[ ]?[aApP][mM])|(([0-1][0-9]|[1-9])[\\:]([0-5][0-9]|[1-9])([ ]?[aApP][mM])?))";
    static final String STANDARD_YEAR_FORMAT = "(18|19|20|21)\\d{2}";
    static String WESTERN_DATE_KEYWORD_FORMAT;
    static String WESTERN_DAY_KEYWORD_FORMAT;
    static String WESTERN_DAY_MONTH_FORMAT;
    static String WESTERN_MONTH_DAY_FORMAT;
    static String WESTERN_TIME_KEYWORD_FORMAT;
}
