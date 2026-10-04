package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format;

import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.MeetingAutoFormatMerger;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MeetingFormatNoteMerger {
    private static final String TAG = Logger.createTag("MeetingFormatNoteMerger", AiConstants.PREFIX_TAG);
    List<Integer> mInfoEndIndexList;
    MeetingAutoFormatMerger mMeetingAutoFormatMerger = new MeetingAutoFormatMerger();
    Map<String, ServerResultMeetingParser.MeetingFormat> mMeetingFormatMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        List<SpenWNote> getNoteList();

        SpenObjectTextBox makeNewTextBox();
    }

    private void mergeInfo() {
        if (this.mMeetingAutoFormatMerger.isDateUpdated()) {
            ServerResultMeetingParser.DateFormat dateFormat = (ServerResultMeetingParser.DateFormat) this.mMeetingFormatMap.get("date");
            if (dateFormat != null) {
                dateFormat.mText = this.mMeetingAutoFormatMerger.getDate();
            }
            Logger.m10999d(TAG, "mergeInfo# date");
        }
        if (this.mMeetingAutoFormatMerger.isTimeUpdated()) {
            ServerResultMeetingParser.TimeFormat timeFormat = (ServerResultMeetingParser.TimeFormat) this.mMeetingFormatMap.get("time");
            if (timeFormat != null) {
                timeFormat.mText = this.mMeetingAutoFormatMerger.getTime();
            }
            Logger.m10999d(TAG, "mergeInfo# time");
        }
        if (this.mMeetingAutoFormatMerger.isPlaceUpdated()) {
            ServerResultMeetingParser.PlaceFormat placeFormat = (ServerResultMeetingParser.PlaceFormat) this.mMeetingFormatMap.get(ServerResultMeetingParser.PLACE);
            if (placeFormat != null) {
                placeFormat.mText = this.mMeetingAutoFormatMerger.getDate();
            }
            Logger.m10999d(TAG, "mergeInfo# place");
        }
        if (this.mMeetingAutoFormatMerger.isParticipantsUpdated()) {
            ServerResultMeetingParser.ParticipantsFormat participantsFormat = (ServerResultMeetingParser.ParticipantsFormat) this.mMeetingFormatMap.get(ServerResultMeetingParser.PARTICIPANTS);
            if (participantsFormat != null) {
                for (int i = 0; i < this.mMeetingAutoFormatMerger.getParticipants().length; i++) {
                    participantsFormat.mItemList.add(new ServerResultMeetingParser.ParticipantFormat(this.mMeetingAutoFormatMerger.getParticipants()[i]));
                }
            }
            Logger.m10999d(TAG, "mergeInfo# participants");
        }
        if (this.mMeetingAutoFormatMerger.isAgendasUpdated()) {
            ServerResultMeetingParser.AgendasFormat agendasFormat = (ServerResultMeetingParser.AgendasFormat) this.mMeetingFormatMap.get(ServerResultMeetingParser.AGENDAS);
            if (agendasFormat != null) {
                for (int i2 = 0; i2 < this.mMeetingAutoFormatMerger.getAgendas().length; i2++) {
                    agendasFormat.mItemList.add(new ServerResultMeetingParser.AgendaFormat(this.mMeetingAutoFormatMerger.getAgendas()[i2]));
                }
            }
            Logger.m10999d(TAG, "mergeInfo# agendas");
        }
    }

    public MeetingAutoFormatMerger getMeetingAutoFormatMerger() {
        return this.mMeetingAutoFormatMerger;
    }

    public void initialize(ServerResultMeetingParser serverResultMeetingParser, String str) {
        this.mInfoEndIndexList = serverResultMeetingParser.getInfoEndIndexList();
        this.mMeetingAutoFormatMerger.addFormatToResult(str);
        this.mMeetingFormatMap = serverResultMeetingParser.makeInfoFormatMap(this.mMeetingAutoFormatMerger.getTitle(), this.mMeetingAutoFormatMerger.getDate(), this.mMeetingAutoFormatMerger.getTime(), this.mMeetingAutoFormatMerger.getPlace(), this.mMeetingAutoFormatMerger.getParticipants(), this.mMeetingAutoFormatMerger.getAgendas());
    }

    public void mergeNote(ServerResultMeetingParser serverResultMeetingParser, int i, Contract contract) {
        mergeInfo();
        ServerResultMeetingParser.FormatStructure formatStructureMakeInfoFormatStructure = serverResultMeetingParser.makeInfoFormatStructure(this.mMeetingFormatMap);
        List<SpenWNote> noteList = contract.getNoteList();
        for (int i2 = 0; i2 < noteList.size(); i2++) {
            Logger.m10999d(TAG, "mergeNote# " + i2);
            SpenWNote spenWNote = noteList.get(i2);
            SpenObjectTextBox spenObjectTextBoxMakeNewTextBox = contract.makeNewTextBox();
            serverResultMeetingParser.applyFormatReplaceInfoText(formatStructureMakeInfoFormatStructure, i2, spenObjectTextBoxMakeNewTextBox, i);
            if (spenObjectTextBoxMakeNewTextBox.getText().length() > 0 && this.mInfoEndIndexList.get(i2).intValue() > 0) {
                spenWNote.getBodyText().replaceText(spenObjectTextBoxMakeNewTextBox, 0, this.mInfoEndIndexList.get(i2).intValue());
                this.mInfoEndIndexList.set(i2, Integer.valueOf(spenObjectTextBoxMakeNewTextBox.getText().length()));
            }
        }
    }
}
