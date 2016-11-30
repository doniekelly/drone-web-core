package io.magpi.api;

import io.magpi.api.handler.ElevationHandler;
import io.magpi.api.handler.GridHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import static io.vertx.core.http.HttpMethod.GET;

public class RestApi  {


    public static Router createRouter(Vertx vertx) {

        Router apiRouter=Router.router(vertx);

        /*
            Given lat , long
            and return elevation in meters

            method :GET
            params:
                    latitude ........ gps latitude

                    longitude ....... gps longitude


         */
        apiRouter.route(GET,"/elevation").handler(new ElevationHandler());

        /*
            Given lat , long and bearing calculate a grid
            and return grid as an array of gps coordinates and with elevations

            method :GET
            params:
                    latitude ........ gps latitude

                    longitude ....... gps longitude

                    bearing  ........ bearing in degrees ........ format float .....

                    gridOffset ...... meters between grid lines . format integer ...
                                        min 10 .. optional defaults to 50

                    gridDimensions .. size of grid .............. format AxB  ......
                                        max A * B =300 ..min A * B = 9 .. optional defailts to 17x17



         */
        apiRouter.route(GET,"/grid").handler(new GridHandler());



        return apiRouter;
    }
}