package barbatchov.openoffice.docconverter.controller.v1;

import barbatchov.openoffice.docconverter.config.ooffice.ExportTypes;
import barbatchov.openoffice.docconverter.service.JodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/jod")
@Api(value = "JodConverter", description = "Operações sobre arquivos", tags = "Converter")
public class JodConverterV1Controller {

    private final JodService jodService;

    @ApiOperation(value = "Download do arquivo no formato html", response = byte[].class)
    @PostMapping(value = "/to-html")
    public ResponseEntity<byte[]> convertHtml(final MultipartFile multipartFile) throws Throwable {
        return jodService.convert(multipartFile, ExportTypes.HTML);
    }

    @ApiOperation(value = "Download do arquivo no formato pdf", response = byte[].class)
    @PostMapping(value = "/to-pdf")
    public ResponseEntity<byte[]> convertPdf(final MultipartFile multipartFile) throws Throwable {
        return jodService.convert(multipartFile, ExportTypes.PDF);
    }
}
