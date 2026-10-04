package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.Title;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.meeting.MeetingComponent;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.meeting.MeetingList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbsMeetingFormatPostProcessor {
    static final String AGENDAS = "agendas";
    static final String CONTENTS = "contents";
    static final String DATE = "date";
    static final String DETAILS = "details";
    static final String EMPTY = "";
    static final String PARTICIPANTS = "participants";
    static final String PLACE = "place";
    static final String SUBHEADING = "subheading";
    static final String TIME = "time";
    static final String TITLE = "title";
    static final int UNKNOWN_INDEX = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MeetingFormatResultForMerger {
        public Title mTitle = new Title();
        public MeetingComponent mDate = new MeetingComponent();
        public MeetingComponent mTime = new MeetingComponent();
        public MeetingComponent mPlace = new MeetingComponent();
        public List<MeetingList> mParticipants = new ArrayList();
        public List<String> mNewParticipants = new ArrayList();
        public List<MeetingList> mAgendas = new ArrayList();
        public List<String> mNewAgendas = new ArrayList();
        public String mContents = "";
    }
}
