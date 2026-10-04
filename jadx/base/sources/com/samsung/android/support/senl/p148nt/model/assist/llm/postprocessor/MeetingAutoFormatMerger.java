package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.AbsMeetingFormatPostProcessor;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.meeting.MeetingList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MeetingAutoFormatMerger extends AbsMeetingFormatPostProcessor {
    private static final String TAG = "Ai$MeetingAutoFormatMerger";
    private String mAgendasKey;
    private String mContentsKey;
    private String mDateKey;
    private String mInputText;
    private String mParticipantsKey;
    private String mPlaceKey;
    private String mTimeKey;
    private String mTitleKey;
    private String QUOTES = "\\\"";
    private final AbsMeetingFormatPostProcessor.MeetingFormatResultForMerger mResult = new AbsMeetingFormatPostProcessor.MeetingFormatResultForMerger();
    private boolean mIsUpdated = false;

    private int parseAndMergeComponents(List<MeetingList> list, List<String> list2, String[] strArr, int i) {
        String str;
        int iIndexOf;
        ArrayList<MeetingList> arrayList = new ArrayList();
        list2.clear();
        if (!strArr[i].contains("null, ") && strArr[i].contains("[")) {
            if (strArr[i].indexOf(93) >= 0) {
                parseLineOfComponents(arrayList, strArr[i]);
            } else {
                while (true) {
                    i++;
                    if (i >= strArr.length || ((iIndexOf = (str = strArr[i]).indexOf(93)) > -1 && str.indexOf(34, iIndexOf) == -1)) {
                        break;
                    }
                    String strTrim = str.trim();
                    if (!strTrim.isEmpty()) {
                        parseLineOfComponents(arrayList, strTrim);
                    }
                }
            }
            for (MeetingList meetingList : arrayList) {
                Iterator<MeetingList> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        list.add(meetingList);
                        list2.add(meetingList.getText());
                        Logger.m8697d(TAG, "parseComponents : add component - " + meetingList.getLength());
                        break;
                    }
                    if (it.next().sameWith(meetingList.getText())) {
                        Logger.m8697d(TAG, "parseComponents : duplicated - " + meetingList.getLength());
                        break;
                    }
                }
            }
        }
        return i;
    }

    private String parseContents() {
        int iIndexOf = this.mInputText.indexOf(this.mContentsKey);
        int iLastIndexOf = this.mInputText.lastIndexOf("]");
        StringBuilder sb = new StringBuilder("{\n");
        if (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) {
            Logger.m8697d(TAG, "parseContents# can't find contents, add empty contents");
            sb.append("    ");
            sb.append(this.mContentsKey + " : []");
            sb.append("\n}");
        } else {
            String strSubstring = this.mInputText.substring(iIndexOf, iLastIndexOf + 1);
            sb.append("    ");
            sb.append(strSubstring);
            sb.append("\n}");
        }
        return sb.toString();
    }

    private void parseLineOfComponents(List<MeetingList> list, String str) {
        int iIndexOf = str.indexOf(this.QUOTES) + 1;
        int iIndexOf2 = str.indexOf(this.QUOTES, iIndexOf);
        while (iIndexOf > 0 && iIndexOf2 > -1 && iIndexOf < iIndexOf2) {
            String strTrim = str.substring(iIndexOf, iIndexOf2).trim();
            int iIndexOf3 = str.indexOf(this.QUOTES, iIndexOf2 + 1) + 1;
            int iIndexOf4 = str.indexOf(this.QUOTES, iIndexOf3);
            if (!strTrim.equals(ServerResultMeetingParser.PARTICIPANTS) && !strTrim.equals(ServerResultMeetingParser.AGENDAS) && strTrim.length() >= 1) {
                list.add(new MeetingList(-1, strTrim));
            }
            iIndexOf = iIndexOf3;
            iIndexOf2 = iIndexOf4;
        }
    }

    private void parseServerResult() {
        String[] strArrSplitLine = splitLine();
        initParameters();
        int andMergeComponents = 0;
        while (andMergeComponents < strArrSplitLine.length) {
            String str = strArrSplitLine[andMergeComponents];
            this.mIsUpdated = false;
            if (str.contains(this.mTitleKey) && !this.mResult.mTitle.exists()) {
                this.mResult.mTitle.setText(parseValueFromKeyValue(str));
            } else if (str.contains(this.mDateKey) && !this.mResult.mDate.exists()) {
                this.mResult.mDate.setText(parseValueFromKeyValue(str));
                this.mResult.mDate.setIsUpdated(this.mIsUpdated);
            } else if (str.contains(this.mTimeKey) && !this.mResult.mTime.exists()) {
                this.mResult.mTime.setText(parseValueFromKeyValue(str));
                this.mResult.mTime.setIsUpdated(this.mIsUpdated);
            } else if (str.contains(this.mPlaceKey) && !this.mResult.mPlace.exists()) {
                this.mResult.mPlace.setText(parseValueFromKeyValue(str));
                this.mResult.mPlace.setIsUpdated(this.mIsUpdated);
            } else if (str.contains(this.mParticipantsKey)) {
                AbsMeetingFormatPostProcessor.MeetingFormatResultForMerger meetingFormatResultForMerger = this.mResult;
                andMergeComponents = parseAndMergeComponents(meetingFormatResultForMerger.mParticipants, meetingFormatResultForMerger.mNewParticipants, strArrSplitLine, andMergeComponents);
            } else if (str.contains(this.mAgendasKey)) {
                AbsMeetingFormatPostProcessor.MeetingFormatResultForMerger meetingFormatResultForMerger2 = this.mResult;
                andMergeComponents = parseAndMergeComponents(meetingFormatResultForMerger2.mAgendas, meetingFormatResultForMerger2.mNewAgendas, strArrSplitLine, andMergeComponents);
            } else if (str.contains(this.mContentsKey)) {
                this.mResult.mContents = parseContents();
                return;
            }
            andMergeComponents++;
        }
    }

    private String parseValueFromKeyValue(String str) {
        int length = this.QUOTES.length() + str.indexOf(this.QUOTES, str.indexOf(58));
        int iIndexOf = str.indexOf(this.QUOTES, length);
        if (length >= iIndexOf || length == -1 || iIndexOf == -1) {
            return "";
        }
        String strTrim = str.substring(length, iIndexOf).trim();
        if (!strTrim.equals("")) {
            this.mIsUpdated = true;
        }
        return strTrim;
    }

    private String preProcess() {
        String str = this.mInputText;
        new StringBuilder(str.length());
        int i = 0;
        Integer numValueOf = null;
        for (int i2 = 1; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2 - 1);
            if (str.charAt(i2) == '\"') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i2);
                    str.substring(i, i2);
                } else if (cCharAt != '\\') {
                    StringUtils.convertUnexpectedChars(str.substring(numValueOf.intValue(), i2));
                    numValueOf = null;
                }
                i = i2;
            }
        }
        if (i != str.length() - 1) {
            StringUtils.convertUnexpectedChars(str.substring(i));
        }
        return str;
    }

    private String[] splitLine() {
        String[] strArrSplit = preProcess().replace("\\n", "\n").split("\n");
        this.QUOTES = "\\\"";
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = strArrSplit[i];
            int iIndexOf = str.indexOf(58);
            if (iIndexOf == -1) {
                i++;
            } else if (!str.substring(0, iIndexOf).contains(this.QUOTES)) {
                this.QUOTES = "\"";
                Logger.m8703w(TAG, "parse# quotes is changed");
                return strArrSplit;
            }
        }
        return strArrSplit;
    }

    public void addFormatToResult(String str) {
        this.mInputText = str;
        parseServerResult();
    }

    public String[] getAgendas() {
        return (String[]) this.mResult.mNewAgendas.toArray(new String[this.mResult.mNewAgendas.size()]);
    }

    public String getContents() {
        return this.mResult.mContents;
    }

    public String getDate() {
        return this.mResult.mDate.getText();
    }

    public String[] getParticipants() {
        return (String[]) this.mResult.mNewParticipants.toArray(new String[this.mResult.mNewParticipants.size()]);
    }

    public String getPlace() {
        return this.mResult.mPlace.getText();
    }

    public String getTime() {
        return this.mResult.mTime.getText();
    }

    public String getTitle() {
        return this.mResult.mTitle.getText();
    }

    public void initParameters() {
        this.mTitleKey = this.QUOTES + "title" + this.QUOTES;
        this.mDateKey = this.QUOTES + "date" + this.QUOTES;
        this.mTimeKey = this.QUOTES + "time" + this.QUOTES;
        this.mPlaceKey = this.QUOTES + ServerResultMeetingParser.PLACE + this.QUOTES;
        this.mParticipantsKey = this.QUOTES + ServerResultMeetingParser.PARTICIPANTS + this.QUOTES;
        this.mAgendasKey = this.QUOTES + ServerResultMeetingParser.AGENDAS + this.QUOTES;
        this.mContentsKey = this.QUOTES + "contents" + this.QUOTES;
        this.mResult.mDate.setIsUpdated(false);
        this.mResult.mTime.setIsUpdated(false);
        this.mResult.mPlace.setIsUpdated(false);
    }

    public boolean isAgendasUpdated() {
        Logger.m8697d(TAG, "isAgendasUpdated : " + this.mResult.mNewAgendas.size());
        return this.mResult.mNewAgendas.size() > 0;
    }

    public boolean isDateUpdated() {
        Logger.m8697d(TAG, "isDateUpdated : " + this.mResult.mDate.getLength());
        return this.mResult.mDate.getIsUpdated();
    }

    public boolean isParticipantsUpdated() {
        Logger.m8697d(TAG, "isParticipantsUpdated : " + this.mResult.mNewParticipants.size());
        return this.mResult.mNewParticipants.size() > 0;
    }

    public boolean isPlaceUpdated() {
        Logger.m8697d(TAG, "isPlaceUpdated : " + this.mResult.mPlace.getLength());
        return this.mResult.mPlace.getIsUpdated();
    }

    public boolean isTimeUpdated() {
        Logger.m8697d(TAG, "isTimeUpdated : " + this.mResult.mTime.getLength());
        return this.mResult.mTime.getIsUpdated();
    }
}
