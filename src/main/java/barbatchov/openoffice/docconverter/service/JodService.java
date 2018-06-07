package barbatchov.openoffice.docconverter.service;

import barbatchov.openoffice.docconverter.config.ooffice.ExportTypes.MediaMap;
import lombok.RequiredArgsConstructor;
import org.jodconverter.OfficeDocumentConverter;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JodService {

    private final OfficeManager officeManager;

    public ResponseEntity<byte[]> convert(final MultipartFile multipartFile, MediaMap mediaMap) throws IOException, OfficeException {
        final String filePath = "/tmp/"
            .concat(UUID.randomUUID().toString())
            .concat("." + mediaMap.getExtension());
        final File sourceFile = new File("/tmp/" + multipartFile.getOriginalFilename());
        final File targetFile = new File(filePath);

        multipartFile.transferTo(sourceFile);

        new OfficeDocumentConverter(officeManager).convert(sourceFile, targetFile);

        return ResponseEntity
            .status(HttpStatus.OK)
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + targetFile.getName())
            .header(HttpHeaders.CONTENT_TYPE, mediaMap.getMediaType())
            .body(Files.readAllBytes(targetFile.toPath()));
    }

}
