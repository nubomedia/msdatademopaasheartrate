/*
 * (C) Copyright 2015 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */

package fi.vtt.nubomedia.msdata;

import org.kurento.client.KurentoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Magic Mirror main class.
 *
 * @author Boni Garcia (bgarcia@gsyc.es)
 * @author David Fernandez (d.fernandezlop@gmail.com)
 * @since 6.1.1
 */
@SpringBootApplication
@EnableWebSocket
public class MsDataApp implements WebSocketConfigurer {

    //    static final String DEFAULT_APP_SERVER_URL = "https://localhost:8443";

    //final static String DEFAULT_KMS_WS_URI = "ws://localhost:8888/kurento";
    //final static String DEFAULT_APP_SERVER_URL = "http://localhost:8080";


  @Bean
  public MsDataHandler handler() {
    return new MsDataHandler();
  }

    /*
  @Bean
  public KurentoClient kurentoClient() {
      System.err.println("\nMSDATA APP kurentoClient 8080");
    return KurentoClient.create();
  }
    */
  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(handler(), "/metadata");
  }

  public static void main(String[] args) throws Exception {
    new SpringApplication(MsDataApp.class).run(args);
  }
}
