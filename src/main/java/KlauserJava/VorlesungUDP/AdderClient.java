package KlauserJava.VorlesungUDP;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

public class AdderClient {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(14)) {

            for(int i = 0; i < 10; i++) {
                var a = new Random().nextDouble();
                var b = new Random().nextDouble();

                var requestBuffer = ByteBuffer.allocate(1024);

                requestBuffer.order(ByteOrder.BIG_ENDIAN);
                requestBuffer.putInt(DatagramActions.SUM_REQUEST.ordinal());
                requestBuffer.putDouble(a);
                requestBuffer.putDouble(b);

                var requestPackage = new DatagramPacket(
                        requestBuffer.array(),
                        requestBuffer.array().length,
                        InetAddress.getLocalHost(),
                        13
                );
                socket.send(requestPackage);
                System.out.println("Package sent");


                var responseBuffer = ByteBuffer.allocate(1024);
                responseBuffer.order(ByteOrder.BIG_ENDIAN);
                var responsePackage = new DatagramPacket(
                        responseBuffer.array(),
                        responseBuffer.array().length
                );
                socket.receive(responsePackage);

                var action = DatagramActions.values()[responseBuffer.getInt()];
                if (action == DatagramActions.SUM_RESPONSE) {
                    var sum = responseBuffer.getDouble();
                    System.out.println(String.format("Sum of %.2f and %.2f is: %.2f ", a, b, sum));
                }
                else {
                    System.out.println("Protocol Error");
                    System.exit(-1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
