package ru.karpunin.t1simpleapp.integration;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.karpunin.t1simpleapp.dto.Candidate;
import ru.karpunin.t1simpleapp.dto.Roles;
import ru.karpunin.t1simpleapp.dto.Status;

@FeignClient(name = "T1-client", url = "http://193.19.100.32:7000/api")
public interface T1FeignClient {

    @GetMapping("/get-roles/")
    Roles getRoles();

    @PostMapping("/sign-up/")
    String signUp(@RequestBody Candidate candidate);

    @GetMapping("/get-code/")
    String getCode(@RequestParam String email);

    @PostMapping("/set-status/")
    String setStatus(@RequestBody Status status);
}
