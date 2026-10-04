package com.samsung.android.support.senl.p148nt.composer.main.cover.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.cover.SuggestedCoverRepository;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import com.samsung.android.support.senl.p148nt.model.domain.cover.UpdateDocumentCoverUseCase;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverEditorPresenter {
    private static final String TAG = Logger.createCoverTag("CoverEditorPresenter");
    private static final String TEMPLATE = "template";
    private final CoverData mCoverData;
    private String[] mTemplateUuids;
    private View[] mTemplateViews;

    public CoverEditorPresenter(Activity activity, View view, String str) {
        this.mCoverData = new CoverData(str);
        initData(activity);
        init(view);
    }

    private void initData(Context context) {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(context);
        NotesDocumentCoverRepository notesDocumentCoverRepositoryCreateDocumentCoverRepository = notesDataRepositoryFactoryNewInstance.createDocumentCoverRepository();
        SuggestedCoverRepository suggestedCoverRepositoryCreateSuggestedCoverRepository = notesDataRepositoryFactoryNewInstance.createSuggestedCoverRepository();
        NotesDocumentCoverEntity entity = notesDocumentCoverRepositoryCreateDocumentCoverRepository.getEntity(this.mCoverData.getNoteUuid());
        if (entity == null) {
            entity = new NotesDocumentCoverEntity();
            entity.setDocUuid(this.mCoverData.getNoteUuid());
        }
        SuggestedCoverEntity entity2 = suggestedCoverRepositoryCreateSuggestedCoverRepository.getEntity(this.mCoverData.getNoteUuid());
        if (entity2 == null) {
            entity2 = new SuggestedCoverEntity();
            entity2.setDocUuid(this.mCoverData.getNoteUuid());
        }
        this.mCoverData.setState(entity2.getState());
        this.mCoverData.setEnabled(entity.isEnabled());
        this.mCoverData.setCategoryUuid(entity.getCategoryUuid());
        this.mCoverData.setTemplateUuid(entity.getTemplateUuid());
        this.mCoverData.setTitle(entity.getTitle());
        this.mCoverData.setSummary(entity.getSummary());
        this.mCoverData.setColorId(entity.getBackgroundColor());
        this.mCoverData.setCreatedAt(entity.getCreatedAt());
        this.mCoverData.setLastModifiedAt(entity.getLastModifiedAt());
    }

    public CoverData getCoverData() {
        return this.mCoverData;
    }

    public String getSelectedTemplateUuid() {
        int i = 0;
        while (true) {
            View[] viewArr = this.mTemplateViews;
            if (i >= viewArr.length) {
                return this.mTemplateUuids[0];
            }
            if ("template".equals(viewArr[i].getTag())) {
                return this.mTemplateUuids[i];
            }
            i++;
        }
    }

    public int getState() {
        int i = this.mCoverData.isAiGeneratedCover() ? 4 : 2;
        AbstractC0000a.m3D(i, "getState# ", TAG);
        return i;
    }

    public int getTemplateIdx(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.mTemplateUuids;
            if (i >= strArr.length) {
                return 0;
            }
            if (strArr[i].equals(str)) {
                return i;
            }
            i++;
        }
    }

    public void init(View view) {
        Logger.m10999d(TAG, "init");
        this.mTemplateViews = new View[]{view.findViewById(C9086R.id.cover_template_type1), view.findViewById(C9086R.id.cover_template_type2), view.findViewById(C9086R.id.cover_template_type3), view.findViewById(C9086R.id.cover_template_type4), view.findViewById(C9086R.id.cover_template_type5)};
        this.mTemplateUuids = new String[]{"BASIC_STYLE_1:///", "BASIC_STYLE_2:///", "BASIC_STYLE_3:///", "BASIC_STYLE_4:///", "BASIC_STYLE_5:///"};
    }

    public void onClickTemplate(Activity activity, View view, int i, String str) {
        setTemplateUuid(this.mTemplateUuids[i]);
        setBackgroundTemplate(activity, view, this.mTemplateUuids[i], str);
        setSelectedTemplate(i);
    }

    public void saveCoverData(String str, String str2, String str3) {
        AbstractC8014b.m7196B("saveCoverData# log : ", str3, TAG);
        this.mCoverData.setTitle(str);
        this.mCoverData.setSummary(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mCoverData.getCreatedAt() == 0) {
            this.mCoverData.setCreatedAt(jCurrentTimeMillis);
        }
        this.mCoverData.setLastModifiedAt(jCurrentTimeMillis);
        setState(getState());
    }

    public void setAvailableAutoCover(boolean z) {
        this.mCoverData.setAvailableAutoCover(z);
    }

    public void setBackgroundTemplate(Context context, View view, String str, String str2) {
        CoverEditorUtils.setBackgroundTemplate(context, view, str, str2);
    }

    public void setCategoryUuid(String str) {
        this.mCoverData.setCategoryUuid(str);
    }

    public void setColorId(String str) {
        this.mCoverData.setColorId(str);
    }

    public void setEnabled(boolean z) {
        this.mCoverData.setEnabled(z);
    }

    public void setExtractStr(String str) {
        this.mCoverData.setExtractStr(str);
    }

    public void setGenerateState(int i) {
        this.mCoverData.setGenerateState(i);
    }

    public void setSelectedTemplate(int i) {
        int i2 = 0;
        while (true) {
            View[] viewArr = this.mTemplateViews;
            if (i2 >= viewArr.length) {
                return;
            }
            if (i2 == i) {
                viewArr[i2].setSelected(true);
                this.mTemplateViews[i2].setTag("template");
            } else {
                viewArr[i2].setSelected(false);
                this.mTemplateViews[i2].setTag("");
            }
            i2++;
        }
    }

    public void setSelectedTemplateList(ArrayList<String> arrayList) {
        this.mCoverData.setSelectedTemplateList(arrayList);
    }

    public void setSelectedTemplateUuid(int i, String str) {
        this.mCoverData.setSelectedTemplateUuid(i, str);
    }

    public void setState(int i) {
        this.mCoverData.setState(i);
    }

    public void setSummary(String str) {
        this.mCoverData.setSummary(str);
    }

    public void setTemplateColor(Context context, String str) {
        int backgroundColor = CoverEditorUtils.getBackgroundColor(context, str);
        for (View view : this.mTemplateViews) {
            LayerDrawable layerDrawable = (LayerDrawable) view.findViewById(C9086R.id.cover_template_type_container).getBackground();
            layerDrawable.mutate();
            layerDrawable.findDrawableByLayerId(C9086R.id.cover_thumbnail_bg_layer).setTint(backgroundColor);
        }
    }

    public void setTemplateEnable(boolean z) {
        for (View view : this.mTemplateViews) {
            view.setImportantForAccessibility(z ? 1 : 4);
            view.setFocusable(z);
        }
    }

    public void setTemplateUuid(String str) {
        this.mCoverData.setTemplateUuid(str);
    }

    public void setTemplateViewListener(View.OnClickListener onClickListener) {
        for (View view : this.mTemplateViews) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setTemplateViewToolTip(Context context) {
        int i = 0;
        while (true) {
            View[] viewArr = this.mTemplateViews;
            if (i >= viewArr.length) {
                return;
            }
            View view = viewArr[i];
            StringBuilder sb = new StringBuilder();
            sb.append(context.getString(C9086R.string.ai_cover_style));
            sb.append(" ");
            int i2 = i + 1;
            sb.append(i2);
            view.setContentDescription(sb.toString());
            ViewCompat.getInstance().setTooltipText(this.mTemplateViews[i]);
            i = i2;
        }
    }

    public void setTitle(String str) {
        this.mCoverData.setTitle(str);
    }

    public void updateCoverEntity(Context context) {
        Logger.m10999d(TAG, "updateCoverEntity#");
        NotesDocumentCoverEntity notesDocumentCoverEntity = new NotesDocumentCoverEntity();
        notesDocumentCoverEntity.setDocUuid(this.mCoverData.getNoteUuid());
        notesDocumentCoverEntity.setCategoryUuid(this.mCoverData.getCategoryUuid());
        notesDocumentCoverEntity.setTemplateUuid(this.mCoverData.getTemplateUuid());
        notesDocumentCoverEntity.setBackgroundColor(this.mCoverData.getColorId());
        notesDocumentCoverEntity.setSummary(this.mCoverData.getSummary());
        notesDocumentCoverEntity.setCreatedAt(this.mCoverData.getCreatedAt());
        notesDocumentCoverEntity.setLastModifiedAt(this.mCoverData.getLastModifiedAt());
        notesDocumentCoverEntity.setEnabled(this.mCoverData.isEnabled());
        new UpdateDocumentCoverUseCase(NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository()).invoke(notesDocumentCoverEntity, getState(), "CoverEditorPresenter - updateCoverEntity");
        if (notesDocumentCoverEntity.isEnabled()) {
            CoverThumbnailCreator.convertCoverPath(context, this.mCoverData.getNoteUuid());
        } else {
            CoverThumbnailCreator.deleteCoverFileByUuid(context, this.mCoverData.getNoteUuid());
        }
    }

    public CoverEditorPresenter(View view, CoverData coverData) {
        this.mCoverData = coverData;
    }
}
