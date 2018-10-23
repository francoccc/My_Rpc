package rpc_1.client;


import rpc_1.bean.Hamburger;
import rpc_1.service.SellHamService;

/**
 *
 * @Author Franco
 */
public class Test {

    public static void main(String[] args) {
        ServiceHandler serviceHandler = new ServiceHandler();
        serviceHandler.connection("127.0.0.1", 8888);
        SellHamService sellHamService = serviceHandler.getService(SellHamService.class);
        Hamburger hamburger = sellHamService.prepareOneHam();
        System.out.println(hamburger);
    }
}
