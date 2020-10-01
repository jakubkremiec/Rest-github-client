
package pl.kremiec.restgithubclient.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.springframework.stereotype.Service;

@Service
public class GithubSerializer {

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("html_url")
        @Expose
        private String html_url;

        @SerializedName("created_at")
        @Expose
        private String createdAt;

        @SerializedName("watchers")
        @Expose
        private Integer watchers;

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public String getHtmlUrl() {
                return html_url;
        }

        public String getCreatedAt() {
                return createdAt;
        }

        public Integer getWatchers() {
                return watchers;
        }
}
