package rpc_1.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ServiceHandler implements InvocationHandler {

    private Socket socket;
    private Class<?> clazz;

    public void connection(String address, int port) {
        try {
            this.socket = new Socket(address, port);
        }catch(Exception e) {
            e.getStackTrace();
        }
    }

    public <T> T getService(Class<T> clazz) {
        this.clazz = clazz;
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeUTF(method.getName());
        out.writeUTF(clazz.getName());
        out.writeObject(method.getParameterTypes());
        out.writeObject(args);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Object result = in.readObject();
        if(result instanceof Throwable) {
            throw (Throwable) result;
        }
        out.close();
        in.close();
        return result;
    }
}
