package barbatchov.openoffice.docconverter.config.ooffice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;

public class ExportTypes {

    public static final MediaMap HTML = new MediaMap("html", MediaType.TEXT_HTML_VALUE);
    public static final MediaMap PDF = new MediaMap("pdf", MediaType.APPLICATION_PDF_VALUE);

    @Getter
    @RequiredArgsConstructor
    public static class MediaMap {
        private final String extension;
        private final String mediaType;
    }
}
