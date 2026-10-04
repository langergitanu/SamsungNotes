package com.samsung.android.sdk.scs.p142ai.language;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum SuggestionCategory {
    NOW_BRIEF_WEATHER("NOW_BRIEF_WEATHER"),
    NOW_BRIEF_INSIGHT("NOW_BRIEF_INSIGHT"),
    CLIP_QNA("CLIP_QNA"),
    TOUCH_TO_SEARCH_ENTITY_SUGGESTION("TOUCH_TO_SEARCH_ENTITY_SUGGESTION"),
    FILE_RENAME("FILE_RENAME"),
    TITLE_GENERATION("TITLE_GENERATION"),
    NOTE_TRAVEL_TIP("NOTE_TRAVEL_TIP"),
    AI_SELECT_AUTO_FILL("AI_SELECT_AUTO_FILL"),
    IMAGE_TRANSLATION_STRATEGY("IMAGE_TRANSLATION_STRATEGY"),
    FINDER_SEARCH_ANSWER_SYNTHESIS("FINDER_SEARCH_ANSWER_SYNTHESIS"),
    VOICE_RECORDER_FILENAME_AND_TAGS("VOICE_RECORDER_FILENAME_AND_TAGS"),
    CALL_DECLINE_MESSAGE("CALL_DECLINE_MESSAGE"),
    OTHERS("OTHERS");

    private final String name;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MultiModal {
        MYFILES_FILE_RENAME("MYFILES_FILE_RENAME");

        private final String name;

        MultiModal(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }

    SuggestionCategory(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
