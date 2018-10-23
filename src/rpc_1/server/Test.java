package rpc_1.server;

import rpc_1.server.service.SellHamServiceImpl;
import rpc_1.service.SellHamService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author Franco
 */
public class Test {

    private static Map<String, Object> registery = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        registery.put(SellHamService.class.getName(), new SellHamServiceImpl());
        Socket socket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        String methodName = in.readUTF();
        String className = in.readUTF();
        Class<?>[] paramTypes = (Class<?>[]) in.readObject();
        Object[] arguments = (Object[]) in.readObject();
        Object service = registery.get(className);
        Method method = service.getClass().getDeclaredMethod(methodName, paramTypes);
        Object result = method.invoke(service, arguments);
        out.writeObject(result);
    }
}
