package org.academiadecodigo.udpclientserver;

import java.io.IOException;
import java.net.*;

/**
 * Created by codecadet on 07/11/16.
 */

public class UDPClient {

    public static void main(String[] args) {


        String message = "knock knock";
        byte[] clientSendBuffer = message.getBytes();
        byte[] clientReceiveBuffer = new byte[1024];
        int portNumber = 5000;
        String hostName = "localhost";

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();




                System.out.println("About to send");
                DatagramPacket sendPacket = new DatagramPacket(clientSendBuffer, clientSendBuffer.length,
                        InetAddress.getByName(hostName), portNumber);

                socket.send(sendPacket);

                System.out.println("Sent");

                DatagramPacket receivePacket = new DatagramPacket(clientReceiveBuffer, clientReceiveBuffer.length);

                System.out.println("Receiving");
                socket.receive(receivePacket);

                System.out.println("Received");


                String messageReceived = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println(messageReceived);

            }catch(SocketException e){
            e.printStackTrace();
            }catch(UnknownHostException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
