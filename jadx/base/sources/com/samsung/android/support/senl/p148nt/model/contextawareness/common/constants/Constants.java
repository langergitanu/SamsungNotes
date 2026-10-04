package com.samsung.android.support.senl.p148nt.model.contextawareness.common.constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Constants {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BroadcastAction {
        public static final String ACTION_DRAW_SUGGESTION = "com.samsung.android.app.notes.intent.action.DRAW_SUGGESTION";
        public static final String ACTION_EXECUTE_ACTION = "com.samsung.android.app.notes.intent.action.ATTACH_CONTENT";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DonateType {
        public static final String IMAGE_OBJECT = "ImageObject";
        public static final String MESSAGE = "Message";
        public static final String WEB_PAGE = "WebPage";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IntentExtraName {
        public static final String SOURCE = "source";
        public static final String SUBSCRIBE_ID = "subscribe.id";
        public static final String TYPE = "type";
        public static final String URL = "url";
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UserContextBasedContent {
        public static final String REQUEST_KNOWLEDGE = "{\n    \"@type\": \"http://schema.org/PropertyValue\",\n    \"http://schema.org/name\": \"type\",\n    \"http://schema.org/value\": [\"<http://schema.org/WebPage>\",\"<http://schema.org/ImageObject>\",\"<http://schema.org/Message>\"]\n}";
        public static final String RESPONSE_BUNDLE_EXTRA_SOURCES = "source";
        public static final String RESPONSE_BUNDLE_EXTRA_SUGGESTIONS = "suggestions";
    }
}
