package com.aarestu;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {

        //TODO : ubah proxy/host
        String proxyhost = "182.239.127.134";
        int proxyport = 80;

        Socket socket = null;
        PrintWriter writer = null;
        BufferedReader reader = null;

        try {
            socket = new Socket(proxyhost, proxyport);
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // TODO : Manipulasi request disini

            //example normal request *ketawa jahat*
            String hostname = "telkomsel.com";
            writer.println("GET http://" + hostname + "/ HTTP/1.1");
            writer.println("Host: " + hostname);
            writer.println("Accept: */*");
            writer.println("User-Agent: Mozilla/5.0 (Windows NT6.1; rv:14.0) Gecko/20100101 Firefox/14.0");
            writer.println("\r\n\r\n");
            writer.flush();

            // TODO : Kirim hasil ke client

            // print hasil request di console (hapus aja kalo ga digunain)
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }

        } finally {
            if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
            if (writer != null) { writer.close(); }
            if (socket != null) try { socket.close(); } catch (IOException logOrIgnore) {}
        }
    }
}
