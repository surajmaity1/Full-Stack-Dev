package com.surajmaity1.springbootrestapi.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;


@Controller
public class TestingServiceHeathStatusCheck implements HealthIndicator {

    @Autowired
    private Environment environment;

    @Override
    public Health health() {
        try {
            if (checkServiceStatus()) {
                return Health.up().withDetail("Testing Service", "UP & WORKING").build();
            }
            else {
                return Health.down().withDetail("Testing Service", "DOWN").build();
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    private static boolean checkAddressStatus(String address, int port, int timeout) throws IOException {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(address, port), timeout);
            return true;
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
            return false;
        }
        finally {
            socket.close();
        }
    }

    private boolean checkServiceStatus() throws IOException {
        String address = environment.getProperty("testingService.address");
        String port = environment.getProperty("testingService.port");

        return checkAddressStatus(
                address, Integer.parseInt(port), 4000
        );
    }
}
