package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.contacts.presetimage.PresetImageUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.title.coedit.TitleCoeditMemberInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditMemberListAdapter extends RecyclerView.Adapter<TitleCoeditMemberListHolder> {
    private static final String TAG = Logger.createTag("TitleCoeditMemberListAdapter");
    private int mBackgroundColor;
    private List<TitleCoeditMemberInfo> mMemberList;
    private final TitleCoeditMemberListAdapterContract mTitleCoeditMemberListAdapterContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TitleCoeditMemberListAdapterContract {
        boolean isBackgroundDarkTheme();

        boolean isEditMode();

        boolean isStandAlone();

        void showCoeditMemberManage();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class TitleCoeditMemberListHolder extends RecyclerView.ViewHolder {
        TextView mMemberInitial;
        ImageView mMemberLeader;
        TextView mMemberNameView;
        ImageView mMemberPhoto;
        ImageView mMemberWriter;

        public TitleCoeditMemberListHolder(@NonNull View view) {
            super(view);
            this.mMemberPhoto = (ImageView) view.findViewById(C9086R.id.comp_title_coedit_member_item_photo);
            this.mMemberInitial = (TextView) view.findViewById(C9086R.id.comp_title_coedit_member_item_initial);
            this.mMemberWriter = (ImageView) view.findViewById(C9086R.id.comp_title_coedit_member_item_writer);
            this.mMemberLeader = (ImageView) view.findViewById(C9086R.id.comp_title_coedit_member_item_leader);
            this.mMemberNameView = (TextView) view.findViewById(C9086R.id.comp_title_coedit_member_item_name);
            if (TitleCoeditMemberListAdapter.this.mTitleCoeditMemberListAdapterContract.isStandAlone()) {
                view.setClickable(true);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListAdapter.TitleCoeditMemberListHolder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        TitleCoeditMemberListAdapter.this.mTitleCoeditMemberListAdapterContract.showCoeditMemberManage();
                        ComposerSA.insertLog(TitleCoeditMemberListAdapter.this.mTitleCoeditMemberListAdapterContract.isEditMode() ? "683" : "682", ComposerSAConstants.EVENT_COEDIT_STANDALONE_NOTE_MEMBERS);
                    }
                });
            }
        }
    }

    public TitleCoeditMemberListAdapter(TitleCoeditMemberListAdapterContract titleCoeditMemberListAdapterContract) {
        this.mTitleCoeditMemberListAdapterContract = titleCoeditMemberListAdapterContract;
    }

    private void cleanThumbnailView(ImageView imageView, TextView textView) {
        textView.setVisibility(8);
        textView.setText("");
        imageView.setBackground(null);
        imageView.setImageBitmap(null);
    }

    private Bitmap getUserThumbnailBitmap(@NonNull Context context, String str) {
        AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor;
        Bitmap bitmapDecodeStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            assetFileDescriptorOpenTypedAssetFileDescriptor = context.getContentResolver().openTypedAssetFileDescriptor(Uri.parse(str), "image/jpeg", null, null);
            try {
            } catch (Throwable th) {
                try {
                    assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            Logger.m11000e(TAG, "getUserThumbnailBitmap# FileNotFoundException : " + e);
        } catch (IOException e2) {
            Logger.m11000e(TAG, "getUserThumbnailBitmap# IOException : " + e2);
        }
        if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
            if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
                return null;
            }
            assetFileDescriptorOpenTypedAssetFileDescriptor.close();
            return null;
        }
        try {
            FileInputStream fileInputStreamCreateInputStream = assetFileDescriptorOpenTypedAssetFileDescriptor.createInputStream();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamCreateInputStream);
                if (fileInputStreamCreateInputStream != null) {
                    fileInputStreamCreateInputStream.close();
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
        } catch (Exception e3) {
            Logger.m11000e(TAG, "getUserThumbnailBitmap# Exception : " + e3);
        }
        assetFileDescriptorOpenTypedAssetFileDescriptor.close();
        return bitmapDecodeStream;
    }

    private void loadThumbnailFromUri(ImageView imageView, TextView textView, TitleCoeditMemberInfo titleCoeditMemberInfo) {
        cleanThumbnailView(imageView, textView);
        if (TitleCoeditMemberInfo.ADD_MEMBER.equals(titleCoeditMemberInfo.getMemberId())) {
            setAddMemberImage(imageView);
            return;
        }
        Bitmap userThumbnailBitmap = getUserThumbnailBitmap(imageView.getContext(), titleCoeditMemberInfo.getUri());
        if (userThumbnailBitmap != null) {
            imageView.setImageBitmap(userThumbnailBitmap);
        } else {
            setDefaultImage(titleCoeditMemberInfo, imageView, textView);
        }
    }

    private void setAddMemberImage(ImageView imageView) {
        if (this.mTitleCoeditMemberListAdapterContract.isBackgroundDarkTheme()) {
            imageView.setImageResource(C9086R.drawable.comp_title_coedit_member_item_add_for_dark);
        } else {
            imageView.setImageResource(C9086R.drawable.comp_title_coedit_member_item_add);
        }
        imageView.setContentDescription(imageView.getResources().getString(C9086R.string.coedit_share_with_collaborators));
    }

    private static void setDefaultImage(TitleCoeditMemberInfo titleCoeditMemberInfo, ImageView imageView, TextView textView) {
        if (!TextUtils.isEmpty(titleCoeditMemberInfo.getMemberName())) {
            char cCharAt = titleCoeditMemberInfo.getMemberName().toUpperCase().charAt(0);
            if (Character.isAlphabetic(cCharAt)) {
                textView.setText(String.valueOf(cCharAt));
                textView.setVisibility(0);
            }
        }
        imageView.setBackground(imageView.getContext().getDrawable(PresetImageUtil.getCirclePresetImage(titleCoeditMemberInfo.getMemberId())));
    }

    private void updateWriterBackgroundColor(ImageView imageView) {
        GradientDrawable gradientDrawable = (GradientDrawable) imageView.getContext().getDrawable(C9086R.drawable.comp_title_coedit_writer);
        if (gradientDrawable == null) {
            return;
        }
        gradientDrawable.setStroke(imageView.getResources().getDimensionPixelSize(C9086R.dimen.comp_title_coedit_writer_stroke_size), this.mBackgroundColor);
        imageView.setImageDrawable(gradientDrawable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mMemberList.size();
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setCoeditMemberList(List<TitleCoeditMemberInfo> list) {
        this.mMemberList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull TitleCoeditMemberListHolder titleCoeditMemberListHolder, int i) {
        TitleCoeditMemberInfo titleCoeditMemberInfo = this.mMemberList.get(i);
        if (titleCoeditMemberInfo == null) {
            return;
        }
        titleCoeditMemberListHolder.mMemberNameView.setText(titleCoeditMemberInfo.getMemberName());
        loadThumbnailFromUri(titleCoeditMemberListHolder.mMemberPhoto, titleCoeditMemberListHolder.mMemberInitial, titleCoeditMemberInfo);
        titleCoeditMemberListHolder.mMemberLeader.setVisibility(titleCoeditMemberInfo.isLeader() ? 0 : 8);
        titleCoeditMemberListHolder.mMemberWriter.setVisibility(titleCoeditMemberInfo.isWriter() ? 0 : 8);
        updateWriterBackgroundColor(titleCoeditMemberListHolder.mMemberWriter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public TitleCoeditMemberListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TitleCoeditMemberListHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_title_coedit_member_item_layout, viewGroup, false));
    }
}
