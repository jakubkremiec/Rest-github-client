package pl.kremiec.restgithubclient.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pl.kremiec.restgithubclient.model.RestObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class RestService {

    public RestObject getGithubObject(String username, String repositoryName){

        try {
            for (GithubSerializer counter : getSerializedArray(username)) {
                if (counter.getName().equals(repositoryName)) {
                    return new RestObject.Builder()
                            .fullName(counter.getName())
                            .description(counter.getDescription())
                            .cloneUrl(counter.getHtmlUrl())
                            .stars(counter.getWatchers())
                            .createdAt(counter.getCreatedAt())
                            .build();
                }
            }
        }catch (Exception e){
        }
        return new RestObject();
    }

    private GithubSerializer[] getSerializedArray(String username) throws IOException {

        URL url = new URL("https://api.github.com/users/" + username + "/repos");
        GithubSerializer[] githubSerializerArray = new Gson().fromJson(new InputStreamReader(url.openStream()), GithubSerializer[].class);

        return githubSerializerArray;
    }


}
