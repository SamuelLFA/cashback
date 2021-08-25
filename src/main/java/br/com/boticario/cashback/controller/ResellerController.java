package br.com.boticario.cashback.controller;

import br.com.boticario.cashback.contant.Paths;
import br.com.boticario.cashback.controller.dto.ResellerDto;
import br.com.boticario.cashback.controller.form.NewResellerForm;
import br.com.boticario.cashback.model.Reseller;
import br.com.boticario.cashback.service.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = Paths.RESELLERS)
public class ResellerController {

    private final ResellerService resellerService;

    @Autowired
    public ResellerController(ResellerService resellerService) {
        this.resellerService = resellerService;
    }

    @PostMapping
    public ResponseEntity<ResellerDto> create(@Valid @RequestBody NewResellerForm form, UriComponentsBuilder uriBuilder) {
        Reseller model = form.toModel();
        resellerService.create(model);

        URI uri = uriBuilder.path("{path}/{id}").buildAndExpand(Paths.RESELLERS, model.getId()).toUri();
        ResellerDto dto = new ResellerDto(model);
        return ResponseEntity.created(uri).body(dto);
    }
}
