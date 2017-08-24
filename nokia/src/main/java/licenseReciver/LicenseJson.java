package licenseReciver;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.apache.commons.lang.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"path",
"sha",
"size",
"url",
"html_url",
"git_url",
"download_url",
"type",
"content",
"encoding"
})
public class LicenseJson {

@JsonProperty("name")
private String name;
@JsonProperty("path")
private String path;
@JsonProperty("sha")
private String sha;
@JsonProperty("size")
private Integer size;
@JsonProperty("url")
private String url;
@JsonProperty("html_url")
private String htmlUrl;
@JsonProperty("git_url")
private String gitUrl;
@JsonProperty("download_url")
private String downloadUrl;
@JsonProperty("type")
private String type;
@JsonProperty("content")
private String content;
@JsonProperty("encoding")
private String encoding;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("path")
public String getPath() {
return path;
}

@JsonProperty("path")
public void setPath(String path) {
this.path = path;
}

@JsonProperty("sha")
public String getSha() {
return sha;
}

@JsonProperty("sha")
public void setSha(String sha) {
this.sha = sha;
}

@JsonProperty("size")
public Integer getSize() {
return size;
}

@JsonProperty("size")
public void setSize(Integer size) {
this.size = size;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonProperty("html_url")
public String getHtmlUrl() {
return htmlUrl;
}

@JsonProperty("html_url")
public void setHtmlUrl(String htmlUrl) {
this.htmlUrl = htmlUrl;
}

@JsonProperty("git_url")
public String getGitUrl() {
return gitUrl;
}

@JsonProperty("git_url")
public void setGitUrl(String gitUrl) {
this.gitUrl = gitUrl;
}

@JsonProperty("download_url")
public String getDownloadUrl() {
return downloadUrl;
}

@JsonProperty("download_url")
public void setDownloadUrl(String downloadUrl) {
this.downloadUrl = downloadUrl;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("content")
public String getContent() {
return content;
}

@JsonProperty("content")
public void setContent(String content) {
this.content = content;
}

@JsonProperty("encoding")
public String getEncoding() {
return encoding;
}

@JsonProperty("encoding")
public void setEncoding(String encoding) {
this.encoding = encoding;
}

//@Override
//public String toString() {
//return ToStringBuilder.reflectionToString(this);
//}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}