package pl.kremiec.restgithubclient;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.kremiec.restgithubclient.service.RestService;


@SpringBootTest
public class RestServiceTest {

    @Autowired
    RestService restService;

    @Test
    public void checkForNulls(){

        Assertions.assertNotNull(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation"));
        Assertions.assertNotNull(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation"));
    }

    @Test
    public void checkForDefinedInput(){

        Assertions.assertEquals(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation").getFullName(), "Registration-with-email-confirmation");
        Assertions.assertEquals(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation").getDescription(), "Application where you can create new account, later you need to confirm your account with email link.");
        Assertions.assertEquals(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation").getCloneUrl(), "https://github.com/jakubkremiec/Registration-with-email-confirmation");
        Assertions.assertEquals(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation").getStars(), 1);
        Assertions.assertEquals(restService.getGithubObject("jakubkremiec", "Registration-with-email-confirmation").getCreatedAt().toString(), "2020-06-06T20:26:09");
    }

    @Test
    public void checkForIncorrectInput(){

        Assertions.assertEquals(restService.getGithubObject("IncorrectNickname", "IncorrectRepo").getFullName(), "repository or user not found");
        Assertions.assertEquals(restService.getGithubObject("IncorrectNickname", "IncorrectRepo").getDescription(), "repository or user not found");
        Assertions.assertEquals(restService.getGithubObject("IncorrectNickname", "IncorrectRepo").getCloneUrl(), "repository or user not found");
        Assertions.assertEquals(restService.getGithubObject("IncorrectNickname", "IncorrectRepo").getStars(), 0);
    }

}
