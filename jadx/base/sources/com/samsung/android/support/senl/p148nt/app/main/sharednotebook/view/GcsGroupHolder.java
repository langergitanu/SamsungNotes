package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupReadResolver;
import com.samsung.android.contacts.presetimage.PresetImageUtil;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.data.RepositoryManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.ResourcesUtils;
import com.samsung.android.support.senl.p148nt.app.common.widget.HoverPopupTextView;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Marker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
    private static final int GROUP_MEMBER_THUMB_MAX_COUNT = 7;
    private static final String TAG = "GcsGroupHolder";
    private final GcsGroupHolderContract mContract;
    private String mGroupId;
    private boolean mIsLongClickPressed;
    private int mIsOwner;
    private String mSpaceId;
    private TextView mTitleView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface GcsGroupHolderContract {
        boolean onItemLongPressed(GcsGroupHolder gcsGroupHolder);

        void onItemSelected(GcsGroupHolder gcsGroupHolder);

        void setNoNoteInVisible(boolean z);
    }

    public GcsGroupHolder(View view, GcsGroupHolderContract gcsGroupHolderContract) {
        super(view);
        this.mIsLongClickPressed = false;
        this.mContract = gcsGroupHolderContract;
        View viewFindViewById = view.findViewById(C8003R.id.gcs_group_list_item_layout);
        viewFindViewById.setOnLongClickListener(this);
        viewFindViewById.setOnClickListener(this);
    }

    private void decorateCreator(String str) {
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.gcs_group_created_by);
        String userName = SesGroupReadResolver.getInstance().getUserName(this.mGroupId, str);
        String string = userName == null ? this.itemView.getContext().getString(C8003R.string.gcs_group_list_item_created_by_ps, "Unknown") : this.itemView.getContext().getString(C8003R.string.gcs_group_list_item_created_by_ps, userName);
        if (this.mIsOwner > 0) {
            string = this.itemView.getContext().getString(C8003R.string.gcs_group_list_item_created_by_me);
        }
        textView.setText(string);
    }

    private void decorateNewBadge() {
        this.itemView.findViewById(C8003R.id.new_badge).setVisibility(RepositoryManager.getInstance().getSyncNoteDataRepository().getUnreadMdeNoteCount(this.mSpaceId) > 0 ? 0 : 8);
    }

    private void decorateThumbnail(String str) throws Throwable {
        int groupCount = SesGroupReadResolver.getInstance().getGroupCount(this.mGroupId);
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(C8003R.id.gcs_group_user_thumb_layout);
        if (!SesGroupReadResolver.getInstance().isLocalGroupType(this.mGroupId)) {
            View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(C8003R.layout.gcs_group_user_thumbnail_item, (ViewGroup) linearLayout, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(C8003R.id.group_user_thumbnail);
            imageView.setBackground(ResourcesCompat.getDrawable(viewInflate.getResources(), C8003R.drawable.ic_gcs_group_thumbnail_default_bg, null));
            setUserThumbnailBitmap(imageView, SesGroupReadResolver.getInstance().getGroupCoverImageUri(this.mGroupId));
            linearLayout.addView(viewInflate);
            setGroupName(groupCount);
            return;
        }
        for (int i = 0; i < Math.min(groupCount, 7); i++) {
            View viewInflate2 = LayoutInflater.from(this.itemView.getContext()).inflate(C8003R.layout.gcs_group_user_thumbnail_item, (ViewGroup) linearLayout, false);
            if (i == 6 && groupCount > 7) {
                loadLocalGroupThumbnailMax(viewInflate2, groupCount);
            } else if (i == 0) {
                loadLocalGroupThumbnailFromUri(viewInflate2, str);
                ImageView imageView2 = (ImageView) viewInflate2.findViewById(C8003R.id.shared_notebook_group_owner_icon);
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            } else {
                ArrayList<String> gCSGroupMemberIDsExcludeOwner = SesGroupReadResolver.getInstance().getGCSGroupMemberIDsExcludeOwner(this.mGroupId, str);
                if (gCSGroupMemberIDsExcludeOwner.size() >= i) {
                    loadLocalGroupThumbnailFromUri(viewInflate2, gCSGroupMemberIDsExcludeOwner.get(i - 1));
                }
            }
            linearLayout.addView(viewInflate2);
        }
    }

    private void decorateTitle(String str) {
        HoverPopupTextView hoverPopupTextView = (HoverPopupTextView) this.itemView.findViewById(C8003R.id.title);
        hoverPopupTextView.setTitleOriginalTitle(str, ResourcesUtils.getDefaultBackgroundColor(this.itemView.getResources()), false, true);
        this.mTitleView = hoverPopupTextView;
    }

    private void init() {
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.gcs_global_group_name);
        if (textView != null) {
            textView.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(C8003R.id.gcs_group_user_thumb_layout);
        if (linearLayout == null || linearLayout.getChildCount() <= 0) {
            return;
        }
        linearLayout.removeViews(0, linearLayout.getChildCount());
    }

    private void loadLocalGroupThumbnailFromUri(View view, String str) throws Throwable {
        String userName;
        String memberThumbnailImageUri = SesGroupReadResolver.getInstance().getMemberThumbnailImageUri(this.mGroupId, str);
        ImageView imageView = (ImageView) view.findViewById(C8003R.id.group_user_thumbnail);
        if (memberThumbnailImageUri == null) {
            userName = SesGroupReadResolver.getInstance().getUserName(this.mGroupId, str);
            imageView.setBackground(ResourcesCompat.getDrawable(view.getResources(), PresetImageUtil.getCirclePresetImage(str), null));
            if (TextUtils.isEmpty(userName)) {
                StringBuilder sb = new StringBuilder("loadLocalGroupThumbnailFromUri# Can't get user name : ");
                sb.append(MainLogger.getEncode(this.mGroupId + " " + str));
                MainLogger.m7254d(TAG, sb.toString());
            }
        } else {
            setUserThumbnailBitmap(imageView, memberThumbnailImageUri);
            userName = " ";
        }
        ((TextView) view.findViewById(C8003R.id.group_user_name)).setText(TextUtils.isEmpty(userName) ? " " : userName.substring(0, 1));
    }

    private void loadLocalGroupThumbnailMax(View view, int i) {
        String str = Marker.ANY_NON_NULL_MARKER + ContentUtils.convertToArabicNumber(i - 7);
        ImageView imageView = (ImageView) view.findViewById(C8003R.id.group_user_thumbnail);
        TextView textView = (TextView) view.findViewById(C8003R.id.group_user_name);
        textView.setText(str);
        textView.setTextSize(12.0f);
        textView.setTextColor(view.getResources().getColor(C8003R.color.gcs_group_list_item_user_thumbnail_count_text_color, null));
        imageView.setBackground(ResourcesCompat.getDrawable(view.getResources(), C8003R.drawable.gcs_group_list_item_user_thumbnail_bg, null));
    }

    private void setGroupName(int i) {
        String groupName = SesGroupReadResolver.getInstance().getGroupName(this.mGroupId);
        StringBuilder sb = new StringBuilder();
        if (groupName == null) {
            groupName = "Group";
        }
        sb.append(groupName);
        sb.append(" (");
        sb.append(i);
        sb.append(")");
        String string = sb.toString();
        TextView textView = (TextView) this.itemView.findViewById(C8003R.id.gcs_global_group_name);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(string);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View, android.widget.ImageView] */
    private void setUserThumbnailBitmap(ImageView imageView, String str) throws Throwable {
        ?? r4;
        String str2;
        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor;
        Bitmap bitmapDecodeStream;
        if (str == null) {
            return;
        }
        try {
            str2 = "image/jpeg";
            assetFileDescriptorOpenTypedAssetFileDescriptor = this.itemView.getContext().getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "image/jpeg", null, null);
        } catch (FileNotFoundException e) {
            e = e;
            r4 = 0;
        } catch (IOException e2) {
            e = e2;
            r4 = 0;
        }
        try {
            if (assetFileDescriptorOpenTypedAssetFileDescriptor != null) {
                try {
                    FileInputStream fileInputStreamCreateInputStream = assetFileDescriptorOpenTypedAssetFileDescriptor.createInputStream();
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamCreateInputStream);
                        r4 = bitmapDecodeStream;
                        if (fileInputStreamCreateInputStream != null) {
                            try {
                                try {
                                    fileInputStreamCreateInputStream.close();
                                    r4 = bitmapDecodeStream;
                                } catch (Exception e3) {
                                    e = e3;
                                    MainLogger.m7255e(TAG, "getImageBitmapFromUri# Can't create image file : " + e.toString());
                                    r4 = bitmapDecodeStream;
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        if (fileInputStreamCreateInputStream != null) {
                            try {
                                fileInputStreamCreateInputStream.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bitmapDecodeStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                    throw th;
                }
            } else {
                r4 = 0;
            }
            if (assetFileDescriptorOpenTypedAssetFileDescriptor != null) {
                assetFileDescriptorOpenTypedAssetFileDescriptor.close();
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            r4 = str2;
            MainLogger.m7255e(TAG, "getImageBitmapFromUri# Can't find image file : " + e.toString());
        } catch (IOException e7) {
            e = e7;
            r4 = str2;
            MainLogger.m7255e(TAG, "getImageBitmapFromUri# IOException occured : " + e.toString());
        }
        if (r4 != 0) {
            imageView.setBackground(ResourcesCompat.getDrawable(this.itemView.getResources(), C8003R.drawable.gcs_group_list_item_user_thumbnail_bg, null));
            imageView.setImageBitmap(r4);
            imageView.setClipToOutline(true);
        }
    }

    public void decorate(Cursor cursor) throws Throwable {
        init();
        String string = cursor.getString(cursor.getColumnIndex("owner"));
        this.mGroupId = cursor.getString(cursor.getColumnIndex("groupId"));
        this.mSpaceId = cursor.getString(cursor.getColumnIndex("spaceId"));
        this.mIsOwner = cursor.getInt(cursor.getColumnIndex("is_owned_by_me"));
        decorateTitle(cursor.getString(cursor.getColumnIndex("title")));
        decorateCreator(string);
        decorateThumbnail(string);
        decorateNewBadge();
    }

    public String getGroupID() {
        return this.mGroupId;
    }

    public String getSpaceId() {
        return this.mSpaceId;
    }

    public String getTitle() {
        return this.mTitleView.getText().toString();
    }

    public void initLongClick() {
        this.mIsLongClickPressed = false;
    }

    public boolean isOwnedByMe() {
        return this.mIsOwner > 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mIsLongClickPressed) {
            this.mIsLongClickPressed = false;
        }
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SharedNoteBooks;
        if (UserInputSkipper.isValidSingleActionEvent(false, tag) && UserInputSkipper.isValidEvent(UserInputSkipper.Tag.MemoList)) {
            UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_VIEW_SHARED_NOTEBOOKS);
            this.mContract.onItemSelected(this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.mIsLongClickPressed = true;
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_SELECTION_MODE);
        if (this.mContract.onItemLongPressed(this)) {
            view.performHapticFeedback(0);
        }
        return false;
    }
}
