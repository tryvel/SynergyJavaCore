package topic11.task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class ProxyCheckerRunnable {
    public static void main(String[] args) {
        try {
            new FileOutputStream("good_ip.txt").close();            // delete the contents of a file
            FileInputStream fis = new FileInputStream("ip.txt");
            int i;
            StringBuffer socket = new StringBuffer();
            while ((i = fis.read()) != -1) {
                if (i == 13);
                else if (i == 10) {
                    String ip = socket.toString().split(":")[0];
                    int port = Integer.parseInt(socket.toString().split(":")[1]);
                    System.out.println("Проверка: " + ip + ":" + port);

                    Thread thread = new Thread(new CheckProxyRunnable(ip, port));
                    thread.start();

                    socket = new StringBuffer();
                } else {
                    socket.append((char) i);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class CheckProxyRunnable implements Runnable {
    String ip;
    int port;

    public CheckProxyRunnable(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
            InputStream is = connection.getInputStream();
            StringBuffer detectedIP = new StringBuffer();
            int i;
            while ((i = is.read()) != -1) {
                detectedIP.append((char) i);
            }
            System.out.println(detectedIP + ":" + port + " Работает!");
            FileOutputStream fos = new FileOutputStream("good_ip.txt", true);
            fos.write((ip + ":" + port + "\n").getBytes());
        } catch (IOException e) {
            System.out.println(ip + ":" + port + " не работает");
        }
    }
}