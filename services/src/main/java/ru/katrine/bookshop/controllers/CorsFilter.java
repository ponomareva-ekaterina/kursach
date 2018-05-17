package ru.katrine.bookshop.controllers;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * Фильтр для разрешения Cross-Origin Requests Sharing.
 */
@Provider
public class CorsFilter implements ContainerResponseFilter {
    /**
     * настройка параметров фильтрации.
     * @param requestContext
     * @param responseContext
     * @throws IOException
     */
    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add(
                "Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().add(
                "Access-Control-Allow-Headers",
                "Origin, Content-type, Accept, Authorization,"
                        + " Access-Control-Allow-Origin, Access-Control-Allow-Credentials,"
                        + " Access-Control-Allow-Headers, Access-Control-Allow-Methods");
        responseContext.getHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH");
        responseContext.getHeaders().add(
                "enctype",
                "application/x-www-form-urlencoded, multipart/form-data, text-plain");
    }
}