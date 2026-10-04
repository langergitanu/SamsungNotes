package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.ntnl.coedit.CoeditDeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.title.coedit.TitleCoeditMemberInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditMemberListPresenter {
    private static final String TAG = Logger.createTag("TitleCoeditMemberListPresenter");
    private final ComposerModel mComposerModel;
    private String mYouWord = "";
    private Map<String, TitleCoeditMemberInfo> mCoeditMemberInfoMap = new LinkedHashMap();

    public TitleCoeditMemberListPresenter(ComposerModel composerModel) {
        this.mComposerModel = composerModel;
        updateCoeditMemberList();
    }

    @NonNull
    private TitleCoeditMemberInfo getAddMemberInfo() {
        return new TitleCoeditMemberInfo(TitleCoeditMemberInfo.ADD_MEMBER, "", null);
    }

    private int getCoeditMemberCountOnDoing() {
        int i = 1;
        for (TitleCoeditMemberInfo titleCoeditMemberInfo : this.mCoeditMemberInfoMap.values()) {
            if (titleCoeditMemberInfo != null && titleCoeditMemberInfo.isWriter()) {
                i++;
            }
        }
        return i;
    }

    public int getCoeditMemberCount() {
        return this.mCoeditMemberInfoMap.containsKey(TitleCoeditMemberInfo.ADD_MEMBER) ? this.mCoeditMemberInfoMap.size() - 1 : this.mCoeditMemberInfoMap.size();
    }

    public List<TitleCoeditMemberInfo> getCoeditMemberList() {
        return new ArrayList(this.mCoeditMemberInfoMap.values());
    }

    public boolean hasWriterMember() {
        for (TitleCoeditMemberInfo titleCoeditMemberInfo : this.mCoeditMemberInfoMap.values()) {
            if (titleCoeditMemberInfo != null && titleCoeditMemberInfo.isWriter()) {
                return true;
            }
        }
        return false;
    }

    public void onAttachView(Activity activity) {
        this.mYouWord = activity.getResources().getString(C9086R.string.coedit_edit_you_or_me);
    }

    public void updateCoeditMemberList() {
        List<CoeditResolverContract.MemberInfo> coeditMemberList = this.mComposerModel.getMdeInfo().getCoeditMemberList();
        if (coeditMemberList == null || coeditMemberList.isEmpty()) {
            Logger.m11003i(TAG, "updateCoeditMemberList# coeditMemberList is empty");
            this.mCoeditMemberInfoMap.clear();
            return;
        }
        Collections.sort(coeditMemberList, new Comparator<CoeditResolverContract.MemberInfo>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.title.TitleCoeditMemberListPresenter.1
            @Override // java.util.Comparator
            public int compare(CoeditResolverContract.MemberInfo memberInfo, CoeditResolverContract.MemberInfo memberInfo2) {
                if (memberInfo.getMemberName() == null) {
                    return memberInfo2.getMemberName() == null ? 0 : 1;
                }
                if (memberInfo2.getMemberName() == null) {
                    return -1;
                }
                return memberInfo.getMemberName().compareTo(memberInfo2.getMemberName());
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String leaderId = this.mComposerModel.getMdeInfo().getLeaderId();
        String myId = this.mComposerModel.getMdeInfo().getMyId();
        linkedHashMap.put(leaderId, null);
        for (CoeditResolverContract.MemberInfo memberInfo : coeditMemberList) {
            String memberName = memberInfo.getMemberName();
            if (myId != null && myId.equals(memberInfo.getMemberId()) && !this.mYouWord.isEmpty()) {
                memberName = AbstractC0622a.m1170p(this.mYouWord, ")", AbstractC0541b.m781w(memberName, "("));
            }
            TitleCoeditMemberInfo titleCoeditMemberInfo = new TitleCoeditMemberInfo(memberInfo.getMemberId(), memberName, memberInfo.getUri());
            boolean z = false;
            titleCoeditMemberInfo.setLeader(leaderId != null && leaderId.equals(memberInfo.getMemberId()));
            if (this.mCoeditMemberInfoMap.containsKey(memberInfo.getMemberId())) {
                TitleCoeditMemberInfo titleCoeditMemberInfo2 = this.mCoeditMemberInfoMap.get(memberInfo.getMemberId());
                if (titleCoeditMemberInfo2 != null && titleCoeditMemberInfo2.isWriter()) {
                    z = true;
                }
                titleCoeditMemberInfo.setWriter(z);
            }
            linkedHashMap.put(memberInfo.getMemberId(), titleCoeditMemberInfo);
        }
        if (this.mComposerModel.getMdeInfo().isStandAlone()) {
            TitleCoeditMemberInfo addMemberInfo = getAddMemberInfo();
            linkedHashMap.put(addMemberInfo.getMemberId(), addMemberInfo);
        }
        this.mCoeditMemberInfoMap = linkedHashMap;
        this.mComposerModel.getMdeManager().setMaximumCountOnCoedit(getCoeditMemberCountOnDoing());
        Logger.m11003i(TAG, "updateCoeditMemberList#" + this.mCoeditMemberInfoMap.size());
    }

    public void updateCoeditWriterInfo(List<CoeditDeviceInfo> list) {
        Map<String, TitleCoeditMemberInfo> map = this.mCoeditMemberInfoMap;
        if (map == null || map.isEmpty()) {
            Logger.m11003i(TAG, "updateCoeditWriterInfo# mCoeditMemberInfoMap is empty");
            return;
        }
        if (list == null || list.isEmpty()) {
            Logger.m11003i(TAG, "updateCoeditWriterInfo# deviceList is empty");
            return;
        }
        Logger.m11003i(TAG, "updateCoeditWriterInfo#" + list.size());
        String myId = this.mComposerModel.getMdeInfo().getMyId();
        for (CoeditDeviceInfo coeditDeviceInfo : list) {
            TitleCoeditMemberInfo titleCoeditMemberInfo = this.mCoeditMemberInfoMap.get(coeditDeviceInfo.getUserId());
            if (titleCoeditMemberInfo != null) {
                if (coeditDeviceInfo.getUserId().equals(myId)) {
                    titleCoeditMemberInfo.setWriter(false);
                } else {
                    titleCoeditMemberInfo.setWriter(coeditDeviceInfo.isConnected());
                }
            }
        }
        this.mComposerModel.getMdeManager().setMaximumCountOnCoedit(getCoeditMemberCountOnDoing());
    }
}
