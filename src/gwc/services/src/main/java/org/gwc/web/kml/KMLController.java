/*
 * (c) 2022 Open Source Geospatial Foundation - all rights reserved This code is licensed under the
 * GPL 2.0 license, available at the root application directory.
 */
package org.gwc.web.kml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.geoserver.ows.Dispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(
        path = {"/gwc/service/kml", "/{virtualservice}/gwc/service/kml", "/{virtualservice}/{layer}/gwc/service/kml"})
@RequiredArgsConstructor
public class KMLController {

    private final @NonNull Dispatcher geoserverDispatcher;

    @GetMapping(path = "/**")
    public void serviceRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        geoserverDispatcher.handleRequest(request, response);
    }
}
