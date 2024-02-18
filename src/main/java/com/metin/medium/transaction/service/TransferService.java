package com.metin.medium.transaction.service;

import com.metin.medium.transaction.TransferRepository;
import com.metin.medium.transaction.dto.TransferInformation;
import com.metin.medium.transaction.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class TransferService {
    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(TransferInformation transferInformation) {
        if (Objects.isNull(transferInformation.getUsernameFrom()) || Objects.isNull(transferInformation.getAmount())) {
            throw new RuntimeException("Gönderici veya miktar bilgisi eksik...");
        }

        Optional<Customer> usernameFrom = transferRepository.findById(transferInformation.getUsernameFrom());
        if (usernameFrom.isPresent() && usernameFrom.get().getAmount().compareTo(transferInformation.getAmount()) > 0) {
            usernameFrom.get().setAmount(usernameFrom.get().getAmount().subtract(transferInformation.getAmount()));
            transferRepository.save(usernameFrom.get());
        }

        if (Objects.isNull(transferInformation.getUsernameTo())) {
            throw new RuntimeException("Alıcı bilgisi eksik...");
        }

        Optional<Customer> usernameTo = transferRepository.findById(transferInformation.getUsernameTo());
        if (usernameTo.isPresent()) {
            usernameTo.get().setAmount(usernameTo.get().getAmount().add(transferInformation.getAmount()));
            transferRepository.save(usernameTo.get());
        }
    }
}
