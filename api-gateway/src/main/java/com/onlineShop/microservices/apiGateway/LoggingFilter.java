package com.onlineShop.microservices.apiGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String traceId = "12345678";
        logger.info("Path of the request is {}",exchange.getRequest().getPath());

        exchange.getResponse().getHeaders().add("Trace-id", traceId);
        logger.info("trace-id {} ",exchange.getRequest().getPath());

        return chain.filter(exchange);
    }
}

//    @Autowired
//    Tracer tracer;
//
//    @Autowired
//    CurrentTraceContext currentTraceContext;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        Span span = tracer.currentSpan();
//        if (span != null) {
//            String traceId = span.context().traceId();
//            exchange.getResponse().getHeaders().add("Trace-Id", traceId);
//        }
//
//        return chain.filter(exchange);
//    };
}