package com.microsoft.azure.kusto.data;

import org.apache.http.client.utils.URIBuilder;

import java.net.URISyntaxException;

public class UriUtils {
    private UriUtils() {
        // Providing hidden constructor to hide default public constructor in utils class
    }

    public static String setPathForUri(String uri, String path, boolean ensureTrailingSlash) throws URISyntaxException {
        if (ensureTrailingSlash) {
            ensureTrailingSlash(path);
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        return new URIBuilder(uri).setPath(path).build().toString();
    }

    public static String setPathForUri(String uri, String path) throws URISyntaxException {
        return setPathForUri(uri, path, false);
    }

    public static String ensureTrailingSlash(String uri) {
        if (uri != null && !uri.isEmpty() && !uri.endsWith("/")) {
            return uri + "/";
        }
        return uri;
    }

}
