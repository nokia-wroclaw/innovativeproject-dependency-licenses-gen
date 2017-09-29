package model.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties("")
public class ConfigProperties {
    private Server server;
    private Paths paths;
    @Data
    public static class Server {
        private int port;
    }
    @Data
    public static class Paths {
        private String targetDir;
        private String maven;
        private String sbt;
        private String gradle;
    }}
