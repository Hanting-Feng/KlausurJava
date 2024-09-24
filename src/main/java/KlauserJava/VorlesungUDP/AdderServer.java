package KlauserJava.VorlesungUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AdderServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(13)) {

            while (true) {
                var requestBuffer = ByteBuffer.allocate(1024);
                requestBuffer.order(ByteOrder.BIG_ENDIAN);


                var requestPackage = new DatagramPacket(
                        requestBuffer.array(),
                        requestBuffer.array().length);
                socket.receive(requestPackage);
                System.out.println("Package received.");


                var action = DatagramActions.values()[requestBuffer.getInt()];
                if (action == DatagramActions.SUM_REQUEST) {
                    var a = requestBuffer.getDouble();
                    var b = requestBuffer.getDouble();

                    var responseBuffer = ByteBuffer.allocate(1024);
                    responseBuffer.putInt(DatagramActions.SUM_RESPONSE.ordinal());
                    responseBuffer.putDouble(a + b);

                    var responsePackage = new DatagramPacket(
                            responseBuffer.array(),
                            responseBuffer.array().length,
                            requestPackage.getAddress(),
                            requestPackage.getPort());
                    socket.send(responsePackage);
                } else {
                    System.out.println("Protocol Error");
                    System.exit(-1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
