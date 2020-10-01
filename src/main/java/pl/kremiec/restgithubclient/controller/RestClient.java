package pl.kremiec.restgithubclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kremiec.restgithubclient.model.RestObject;
import pl.kremiec.restgithubclient.service.RestService;

@RestController
public class RestClient {

    private RestService restService;

    public RestClient(RestService restService) {
        this.restService = restService;
    }

    @GetMapping("repositories/{user}/{repositoryName}")
    private RestObject githubObject(@PathVariable("user") String username, @PathVariable("repositoryName") String repositoryName){
        return restService.getGithubObject(username, repositoryName);
    }

}
