package com.samsung.android.support.senl.p148nt.app.main.invitation.adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.DrawableUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsInvitationHolder extends RecyclerView.ViewHolder {
    private final Context mContext;
    private final TextView mExpiredTime;
    private final TextView mNotebookTitle;
    private final TextView mRequestedTime;
    private final TextView mRequesterName;

    public GcsInvitationHolder(Context context, View view) {
        super(view);
        this.mContext = context;
        view.setBackground(DrawableUtils.setRippleSelected(context));
        this.mNotebookTitle = (TextView) view.findViewById(C8003R.id.invited_notebook_title);
        this.mRequesterName = (TextView) view.findViewById(C8003R.id.invited_requester_name);
        TextView textView = (TextView) view.findViewById(C8003R.id.invited_expired_time);
        this.mExpiredTime = textView;
        TextView textView2 = (TextView) view.findViewById(C8003R.id.invited_requested_time);
        this.mRequestedTime = textView2;
        CharUtils.applyTextSizeUntilMediumSize(context, textView, 13.0f);
        CharUtils.applyTextSizeUntilMediumSize(context, textView2, 13.0f);
    }

    private String makeExpiredTimeFormat(long j) {
        long jCurrentTimeMillis = (j * 1000) + System.currentTimeMillis();
        return new SimpleDateFormat(DateFormat.getBestDateTimePattern(Locale.getDefault(), "yy/MM/dd"), Locale.getDefault()).format(Long.valueOf(jCurrentTimeMillis)) + " \u200e" + ((SimpleDateFormat) DateFormat.getTimeFormat(this.mContext)).format(Long.valueOf(jCurrentTimeMillis));
    }

    private String makeRequestedTimeFormat(long j) {
        return ((SimpleDateFormat) DateFormat.getTimeFormat(this.mContext)).format(Long.valueOf(j));
    }

    public void decorate(GroupInvitationListResult.GroupInvitation groupInvitation) {
        this.mNotebookTitle.setText(groupInvitation.getGroupName());
        this.mRequesterName.setText(this.mContext.getString(C8003R.string.gcs_invitations_requester_name, groupInvitation.getRequesterName()));
        this.mExpiredTime.setText(this.mContext.getString(C8003R.string.gcs_invitations_expires_time, makeExpiredTimeFormat(groupInvitation.getExpiredTime())));
        this.mRequestedTime.setText(makeRequestedTimeFormat(groupInvitation.getRequestedTime()));
    }
}
