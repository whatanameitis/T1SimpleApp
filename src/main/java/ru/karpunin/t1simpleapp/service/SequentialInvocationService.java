package ru.karpunin.t1simpleapp.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.karpunin.t1simpleapp.dto.Candidate;
import ru.karpunin.t1simpleapp.dto.Status;
import ru.karpunin.t1simpleapp.integration.T1FeignClient;
import ru.karpunin.t1simpleapp.util.Base64Encoder;


@Service
@RequiredArgsConstructor
public class SequentialInvocationService {

    private final T1FeignClient client;

    Logger logger = LoggerFactory.getLogger(SequentialInvocationService.class);

    public void invoke(Candidate candidate) {

        logger.info("Roles are: " + client.getRoles().roles().toString());

        logger.info("Client sign up response is: " + client.signUp(candidate));

        String code = client.getCode(candidate.email()).replaceAll("\"", "");

        logger.info("Code is: " + code);

        String token = Base64Encoder.encodeBase64EmailAndCode(candidate.email(), code);

        logger.info("Token is: " + token);

        logger.info("Status is: " + client.setStatus(new Status(token, "increased")));

    }

}
