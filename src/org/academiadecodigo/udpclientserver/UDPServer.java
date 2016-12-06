package org.academiadecodigo.udpclientserver;

import java.io.IOException;
import java.net.*;

/**
 * Created by codecadet on 07/11/16.
 */
public class UDPServer {

    public static void main(String[] args) {

        byte[] rcvBuffer = new byte[1024];
        byte[] sendBuffer;
        int portNumber = 5000;
        String hostName = "localhost";

        //Open Datagram socket
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(portNumber);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        //Create new datagram packet from socket
        DatagramPacket rcvPacket = new DatagramPacket(rcvBuffer, rcvBuffer.length);
        //Receive packet from socket
        try {
            System.out.println("Waiting for packet");
            socket.receive(rcvPacket); //blocking
        } catch (IOException e) {
            e.printStackTrace();
        }

        String message = new String(rcvBuffer, 0, rcvPacket.getLength());
        System.out.println(message);
        sendBuffer = message.toUpperCase().getBytes();


        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
                                             rcvPacket.getAddress(), rcvPacket.getPort());
        try {
            socket.send(sendPacket);
            System.out.println(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}