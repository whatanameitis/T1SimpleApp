package ru.karpunin.t1simpleapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.karpunin.t1simpleapp.dto.Candidate;
import ru.karpunin.t1simpleapp.service.SequentialInvocationService;

@RestController
@RequiredArgsConstructor
public class SequentialInvocationController {

    private final SequentialInvocationService sequentialInvocationService;

    @PostMapping("/invoke")
    public void invokeMethods(@RequestBody Candidate candidate) {
        sequentialInvocationService.invoke(candidate);
    }
}
