package topic10.task01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class ProxyChecker {
    public static void main(String[] args) {
        try {
            new FileOutputStream("good_ip.txt").close();            // delete the contents of a file
            FileInputStream fis = new FileInputStream("ip.txt");
            int i;
            StringBuilder socket = new StringBuilder();
            while ((i = fis.read()) != -1) {
                if (i == 13) {
                    continue;
                } else if (i == 10) {
                    String ip = socket.toString().split(":")[0];
                    int port = Integer.parseInt(socket.toString().split(":")[1]);
                    System.out.println("Проверка: " + ip + ":" + port);
                    checkProxy(ip, port);
                    socket = new StringBuilder();
                } else {
                    socket.append((char) i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void checkProxy (String ip, int port) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
            InputStream is = connection.getInputStream();
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println(" работает");
            FileOutputStream fos = new FileOutputStream("good_ip.txt", true);
            fos.write((ip + ":" + port + "\n").getBytes());
        } catch (IOException e) {
            System.out.println(ip + ":" + port + " не работает");
        }
    }
}
