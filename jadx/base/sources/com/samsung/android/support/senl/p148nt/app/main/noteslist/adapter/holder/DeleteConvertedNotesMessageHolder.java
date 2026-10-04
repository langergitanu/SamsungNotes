package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class DeleteConvertedNotesMessageHolder extends CommonHolder {
    private static final String TAG = "DeleteConvertedNotesMessageHolder";

    public DeleteConvertedNotesMessageHolder(@NotNull View view, int i) {
        super(view, i);
        setHolderType(33554432);
        View viewFindViewById = view.findViewById(C8003R.id.delete_converted_notes_message);
        ((Button) viewFindViewById.findViewById(C8003R.id.delete_converted_notes_button)).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.DeleteConvertedNotesMessageHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_OLDNOTE_SELECT, NotesSAConstants.EVENT_OLDNOTES_DELETE_ALL);
                DeleteConvertedNotesMessageHolder.this.getMAdapterContract().requestAllDeleteConvertedNotes();
            }
        });
        TextView textView = (TextView) viewFindViewById.findViewById(C8003R.id.delete_converted_notes_description);
        textView.setText(textView.getResources().getString(C8003R.string.converted_note_description_automatically_convert) + " " + textView.getResources().getString(C8003R.string.converted_note_description_avoid_duplicates));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(@Nullable Common common, @Nullable StateInfo stateInfo) {
    }
}
