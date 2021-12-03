package com.sf.mass.svc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OtherServiceCaller {
    Logger logger = LogManager.getLogger(OtherServiceCaller.class);

    private String sfDemoServiceURI = "http://sf-demo.info:31111/rest/docker/hello";

    //sfDemoServiceURI = "http://sf-demo.info:31111/rest/docker/hello";
    private WebClient webClient;

    public OtherServiceCaller() {
        //sfDemoServiceURI = "http://localhost:8085/rest/docker/hello";
        webClient = WebClient.create(sfDemoServiceURI);
    }

    /**public void callOther(){

        WebClient.RequestHeadersUriSpec<?> requestHeadersUriSpec = webClient.get();
        //requestHeadersUriSpec.
        Mono<ResponseEntity<Void>> responseEntityMono = requestHeadersUriSpec.retrieve().toBodilessEntity();
        HttpStatus statusCode = responseEntityMono.block().getStatusCode();
        logger.info("status Code = " + statusCode);
    }*/

    public String callSfDemo(String noProcessHeaderValue){
        String stringMono = webClient.get().uri(uriBuilder -> uriBuilder.build())
                .accept(MediaType.APPLICATION_JSON)
                .header("no-process", noProcessHeaderValue)
                .retrieve()
                /**.onStatus(HttpStatus::is4xxClientError, response -> {
                    return Mono.error();
                })*/
                .bodyToMono(String.class)
                .block();
        System.out.println(stringMono + " , OtherServiceCaller hash = " + System.identityHashCode(this));
        return stringMono;
    }
}
