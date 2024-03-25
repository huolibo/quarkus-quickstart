package com.taosdata.filter;

import io.vertx.core.http.HttpServerRequest;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MyFilter implements ContainerRequestFilter, ContainerResponseFilter {

  @Context
  UriInfo info;

  @Context
  HttpServerRequest request;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    final String method = requestContext.getMethod();
    final String path = info.getPath();
    final String address = request.remoteAddress().toString();

    System.out.println(String.format("Request %s %s from IP %s", method, path, address));
  }

  @Override
  public void filter(ContainerRequestContext requestContext,
      ContainerResponseContext responseContext) throws IOException {
    System.out.println("Response: " + responseContext.getStatus());
  }
}