package com.metin.medium.transaction.rest;

import com.metin.medium.transaction.dto.TransferInformation;
import com.metin.medium.transaction.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferInformation transferInformation) {
        transferService.transfer(transferInformation);
    }
}
