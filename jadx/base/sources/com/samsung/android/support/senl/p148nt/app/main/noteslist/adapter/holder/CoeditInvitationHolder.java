package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.CoeditUserThumbnailUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
import p079T.AbstractC0291i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditInvitationHolder extends CommonHolder {
    public CoeditInvitationHolder(@NonNull View view, int i) {
        super(view, i);
        setHolderType(131072);
    }

    private String getStandaloneNoteName(String str) {
        String[] strArrSplit = str.split(" ", 2);
        return strArrSplit.length < 2 ? str : strArrSplit[1];
    }

    private void initButtons(final GroupInvitationListResult.GroupInvitation groupInvitation) {
        View viewFindViewById = this.itemView.findViewById(C8003R.id.coedit_invitation_decline);
        ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById.findViewById(C8003R.id.coedit_invitation_decline_text));
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.CoeditInvitationHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_INVITE_DECLINE);
                CoeditInvitationHolder.this.getMAdapterContract().onCoeditInvitationSelected(groupInvitation.getGroupId(), groupInvitation.getGroupName(), false);
            }
        });
        View viewFindViewById2 = this.itemView.findViewById(C8003R.id.coedit_invitation_join);
        ButtonShapeUtil.setButtonShapeEnabled(viewFindViewById2.findViewById(C8003R.id.coedit_invitation_join_text));
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.holder.CoeditInvitationHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, NotesSAConstants.EVENT_COEDIT_INVITE_JOIN);
                CoeditInvitationHolder.this.getMAdapterContract().onCoeditInvitationSelected(groupInvitation.getGroupId(), groupInvitation.getGroupName(), true);
            }
        });
    }

    private void initTexts(GroupInvitationListResult.GroupInvitation groupInvitation) {
        Resources resources = this.itemView.getContext().getResources();
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.coedit_invitation_title);
        String requesterName = groupInvitation.getRequesterName();
        if (requesterName == null || requesterName.isEmpty()) {
            requesterName = resources.getString(C8003R.string.co_edit_invitation_default_name);
        }
        TextView textView2 = (TextView) this.itemView.findViewById(C8003R.id.coedit_invitation_space_name);
        TextView textView3 = (TextView) this.itemView.findViewById(C8003R.id.coedit_invitation_message);
        if (groupInvitation.getGroupName() == null || !AbstractC0291i.m570g(groupInvitation.getGroupName())) {
            textView.setText(resources.getString(C8003R.string.co_edit_notification_shared_notebook_invitation));
            textView3.setText(resources.getString(C8003R.string.co_edit_notification_shared_notebook_invitation_message, requesterName));
            textView2.setText(groupInvitation.getGroupName());
        } else {
            textView.setText(resources.getString(C8003R.string.co_edit_notification_shared_note_invitation));
            textView3.setText(resources.getString(C8003R.string.co_edit_notification_shared_note_invitation_message, requesterName));
            textView2.setText(getStandaloneNoteName(groupInvitation.getGroupName()));
        }
        ((TextView) this.itemView.findViewById(C8003R.id.coedit_invitation_expired_time)).setText(resources.getString(C8003R.string.gcs_invitations_expires_time, makeExpiredTimeFormat(groupInvitation.getExpiredTime())));
    }

    private void initThumbnail(GroupInvitationListResult.GroupInvitation groupInvitation) {
        ImageView imageView = (ImageView) this.itemView.findViewById(C8003R.id.coedit_invitation_thumbnail);
        Context context = this.itemView.getContext();
        Resources resources = this.itemView.getResources();
        if (!CoeditUserThumbnailUtils.loadThumbnailFromUri(imageView, groupInvitation.getRequesterImageContentUri())) {
            imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, ContextUtils.isNightMode(context) ? C8003R.drawable.ic_invitation_no_image_dark : C8003R.drawable.ic_invitation_no_image, null));
        } else {
            imageView.setBackground(ResourcesCompat.getDrawable(resources, C8003R.drawable.gcs_group_list_item_user_thumbnail_bg, null));
            imageView.setClipToOutline(true);
        }
    }

    private String makeExpiredTimeFormat(long j) {
        long jCurrentTimeMillis = (j * 1000) + System.currentTimeMillis();
        return new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "yy/MM/dd"), Locale.getDefault()).format(Long.valueOf(jCurrentTimeMillis)) + " \u200e" + ((SimpleDateFormat) DateFormat.getTimeFormat(this.itemView.getContext())).format(Long.valueOf(jCurrentTimeMillis));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolder
    public void decorate(Common common, StateInfo stateInfo) {
        GroupInvitationListResult.GroupInvitation groupInvitation = common.invitation;
        if (groupInvitation == null) {
            return;
        }
        initThumbnail(groupInvitation);
        initTexts(groupInvitation);
        initButtons(groupInvitation);
    }
}
