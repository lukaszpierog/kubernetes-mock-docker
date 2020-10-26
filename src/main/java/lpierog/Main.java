package lpierog;

import io.fabric8.kubernetes.client.*;
import io.fabric8.kubernetes.client.server.mock.*;
import io.fabric8.kubernetes.internal.*;
import org.slf4j.*;

import java.net.*;
import java.util.*;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static KubernetesServer server;

    public static void main(String... args) throws Exception {
        var port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "8088")
        );
        server = new KubernetesServer(
                false,
                true,
                InetAddress.getByName("0.0.0.0"),
                port,
                Collections.emptyList());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.after()));

        server.before();
        var resources = System.getenv("CUSTOM_RESOURCES");
        LOG.info("Resources " + resources);
        if (Objects.nonNull(resources)) {
            for (String res : resources.split(",")) {
                LOG.info("Registering custom kind {}", res);
                KubernetesDeserializer.registerCustomKind(res, CR.class);
            }
        }
    }

    public static class CR extends CustomResource {
        public Object spec;
    }
}