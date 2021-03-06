package org.newtutorials.elasticsearch.client;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeValidationException;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Created by dani on 5/7/2017.
 */
public class ElasticSearchClientBuilder {

    public static TransportClient createElasticSearchClient(String host,int port, String clusterName) throws UnknownHostException

    {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", true)
                .put("client.transport.ping_timeout", 20, TimeUnit.SECONDS)
                .build();
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(Inet4Address.getByName(host), port));
    }
}
