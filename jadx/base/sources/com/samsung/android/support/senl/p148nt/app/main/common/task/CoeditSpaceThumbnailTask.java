package com.samsung.android.support.senl.p148nt.app.main.common.task;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.core.content.res.ResourcesCompat;
import com.samsung.android.contacts.presetimage.PresetImageUtil;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.CoeditUserThumbnailUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceThumbnailTask extends AsyncTask<Void, Void, View> {
    private static final int MAX_MEMBER = 4;
    private String[] mMemberInitial;
    private final List<CoeditResolverContract.MemberInfo> mMembers;
    private final WeakReference<ViewGroup> mThumbnailContainer;

    @IdRes
    private final int[] profileIds = {C8003R.id.first_profile, C8003R.id.second_profile, C8003R.id.third_profile, C8003R.id.forth_profile};

    @IdRes
    private final int[] initialIds = {C8003R.id.first_initial, C8003R.id.second_initial, C8003R.id.third_initial, C8003R.id.forth_initial};

    public CoeditSpaceThumbnailTask(ViewGroup viewGroup, List<CoeditResolverContract.MemberInfo> list) {
        this.mThumbnailContainer = new WeakReference<>(viewGroup);
        this.mMembers = list;
    }

    @LayoutRes
    private int getThumbnailLayoutResId(int i) {
        return i == 4 ? C8003R.layout.notes_coedit_thumbnail_four_profile : i == 3 ? C8003R.layout.notes_coedit_thumbnail_three_profile : i == 2 ? C8003R.layout.notes_coedit_thumbnail_two_profile : C8003R.layout.notes_coedit_thumbnail_one_profile;
    }

    private void initMemberInitials(View view) {
        String[] strArr = this.mMemberInitial;
        int length = strArr == null ? 0 : strArr.length;
        for (int i = 0; i < length; i++) {
            if (!TextUtils.isEmpty(this.mMemberInitial[i])) {
                TextView textView = (TextView) view.findViewById(this.initialIds[i]);
                textView.setText(this.mMemberInitial[i].toUpperCase());
                textView.setVisibility(0);
            }
        }
    }

    private void loadThumbnailFromUri(ImageView imageView, CoeditResolverContract.MemberInfo memberInfo, int i) {
        if (CoeditUserThumbnailUtils.loadThumbnailFromUri(imageView, memberInfo.getUri())) {
            return;
        }
        setDefaultThumbnail(imageView, memberInfo, i);
    }

    private void setDefaultThumbnail(ImageView imageView, CoeditResolverContract.MemberInfo memberInfo, int i) {
        imageView.setBackground(ResourcesCompat.getDrawable(imageView.getResources(), PresetImageUtil.getPresetImage(memberInfo.getMemberId()), null));
        String memberName = memberInfo.getMemberName();
        this.mMemberInitial[i] = TextUtils.isEmpty(memberName) ? null : memberName.substring(0, 1);
    }

    @Override // android.os.AsyncTask
    public View doInBackground(Void... voidArr) {
        int size;
        if (this.mThumbnailContainer.get() == null || (size = this.mMembers.size()) == 0) {
            return null;
        }
        if (size > 4) {
            size = 4;
        }
        this.mMemberInitial = new String[size];
        View viewInflate = LayoutInflater.from(this.mThumbnailContainer.get().getContext()).inflate(getThumbnailLayoutResId(size), (ViewGroup) null, false);
        for (int i = 0; i < size; i++) {
            loadThumbnailFromUri((ImageView) viewInflate.findViewById(this.profileIds[i]), this.mMembers.get(i), i);
        }
        return viewInflate;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(View view) {
        super.onPostExecute(view);
        if (this.mThumbnailContainer.get() == null) {
            return;
        }
        this.mThumbnailContainer.get().removeAllViews();
        if (view != null) {
            initMemberInitials(view);
            this.mThumbnailContainer.get().addView(view);
        }
        this.mThumbnailContainer.get().setBackground(ResourcesCompat.getDrawable(this.mThumbnailContainer.get().getResources(), C8003R.drawable.gcs_group_list_item_user_thumbnail_bg, null));
        this.mThumbnailContainer.get().setClipToOutline(true);
    }
}
